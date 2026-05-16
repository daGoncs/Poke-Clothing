package github.dagoncs.pokeclothing.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import github.dagoncs.pokeclothing.PokeClothing;
import github.dagoncs.pokeclothing.recipe.TailoringRecipe;
import github.dagoncs.pokeclothing.screen.custom.TailoringStationScreenHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class TailoringStationScreen extends HandledScreen<TailoringStationScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(PokeClothing.MOD_ID, "textures/gui/container/tailoring_station.png");

    // SCROLLING VARIABLES
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public TailoringStationScreen(TailoringStationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 204;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    @Override
    protected void init() {
        super.init();
        this.scrollAmount = 0.0F;
        this.scrollOffset = 0;

        // THIS IS THE CRITICAL MISSING LINK
        // It tells the screen: "When the handler finds a recipe, run 'onInventoryChange'!"
        ((TailoringStationScreenHandler)this.handler).setContentsChangedListener(this::onInventoryChange);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;

        // 1. Draw Main Background
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);

        // 2. Draw Scrollbar (Optional, assumes you have a scrollbar sprite at 176,0)
        int k = (int)(41.0F * this.scrollAmount);
        context.drawTexture(TEXTURE, x + 119, y + 15 + k, 176 + (this.shouldScroll() ? 0 : 12), 0, 12, 15);

        // 3. Draw Recipe Buttons
        int recipeListX = x + 52;
        int recipeListY = y + 14;
        int visibleIndex = this.scrollOffset + 12; // Show 12 buttons at a time (4 rows of 3)

        this.renderRecipeBackground(context, mouseX, mouseY, recipeListX, recipeListY, visibleIndex);
        this.renderRecipeIcons(context, recipeListX, recipeListY, visibleIndex);
    }

    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int x, int y, int scrollOffset) {
        // Iterate through all available recipes
        for(int i = this.scrollOffset; i < scrollOffset && i < this.handler.getAvailableRecipeCount(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 4 * 16; // Column position
            int l = j / 4;
            int m = y + l * 18 + 2; // Row position
            int n = 0; // Texture Y-offset for button sprites

            // Check if this specific recipe is currently selected
            if (i == this.handler.getSelectedRecipe()) {
                n += 18; // Shift to "Selected" sprite
            } else if (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18) {
                n += 36; // Shift to "Hovered" sprite
            }

            // Draw the button
            // NOTE: This assumes your button sprites are at u=0, v=204 (after the main GUI)
            context.drawTexture(TEXTURE, k, m - 1, 200, n, 16, 18);
        }
    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        List<RecipeEntry<TailoringRecipe>> list = this.handler.getAvailableRecipes();

        for(int i = this.scrollOffset; i < scrollOffset && i < this.handler.getAvailableRecipeCount(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;

            // Render the Result Item of the recipe on top of the button
            context.drawItem(list.get(i).value().getResult(this.client.world.getRegistryManager()), k, m);
        }
    }

    // --- INTERACTION LOGIC ---

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;

            for(int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = mouseX - (double)(i + m % 4 * 16);
                double e = mouseY - (double)(j + m / 4 * 18);

                // If clicked on a button
                if (d >= 0.0 && e >= 0.0 && d < 16.0 && e < 18.0 && this.handler.onButtonClick(this.client.player, l)) {
                    MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.client.interactionManager.clickButton(this.handler.syncId, l);
                    return true;
                }
            }

            // Scrollbar logic
            i = this.x + 119;
            j = this.y + 9;
            if (mouseX >= (double)i && mouseX < (double)(i + 12) && mouseY >= (double)j && mouseY < (double)(j + 54)) {
                this.mouseClicked = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.y + 14;
            int j = i + 54;
            this.scrollAmount = ((float)mouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0F, 1.0F);
            this.scrollOffset = (int)((double)(this.scrollAmount * (float)this.getMaxScroll()) + 0.5) * 4;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.shouldScroll()) {
            int i = this.getMaxScroll();
            float f = (float)verticalAmount / (float)i;
            this.scrollAmount = MathHelper.clamp(this.scrollAmount - f, 0.0F, 1.0F);
            this.scrollOffset = (int)((double)(this.scrollAmount * (float)i) + 0.5) * 4;
        }
        return true;
    }

    private boolean shouldScroll() {
        return this.canCraft && this.handler.getAvailableRecipeCount() > 12;
    }

    protected int getMaxScroll() {
        return (this.handler.getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    // Called by the Handler when recipes change
    private void onInventoryChange() {
        this.canCraft = this.handler.getAvailableRecipeCount() > 0;
        if (!this.canCraft) {
            this.scrollAmount = 0.0F;
            this.scrollOffset = 0;
        }
    }
}