package github.dagoncs.pokeclothing.screen.custom;

import github.dagoncs.pokeclothing.provider.PokeClothingTagProvider; // <--- ADD THIS IMPORT
import github.dagoncs.pokeclothing.block.BlockInit;
import github.dagoncs.pokeclothing.recipe.ModRecipes;
import github.dagoncs.pokeclothing.recipe.TailoringRecipe;
import github.dagoncs.pokeclothing.screen.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class TailoringStationScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;
    private final World world;

    private final Property selectedRecipe = Property.create();
    private List<RecipeEntry<TailoringRecipe>> availableRecipes = new ArrayList<>();
    private Runnable contentsChangedListener = () -> {};
    long lastTakeTime;

    public final Inventory input;

    public TailoringStationScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, new SimpleInventory(17), ScreenHandlerContext.create(inventory.player.getWorld(), pos));
    }

    public TailoringStationScreenHandler(int syncId, PlayerInventory playerInventory, Inventory input, ScreenHandlerContext context) {
        super(ModScreenHandlers.TAILORING_STATION_SCREEN_HANDLER, syncId);
        checkSize(input, 17);
        this.input = input;
        this.context = context;
        this.world = playerInventory.player.getWorld();
        this.addProperty(this.selectedRecipe);

        // Input slots
        int startX = 19;
        int startY = 72;

        for (int row = 0; row < 2; ++row) {
            for (int col = 0; col < 8; ++col) {
                this.addSlot(new Slot(this.input, col + row * 8, startX + col * 18, startY + row * 18) {

                    @Override
                    public boolean canInsert(ItemStack stack) {
                        // Only allow items that are in the CLOTH tag
                        return stack.isIn(PokeClothingTagProvider.CLOTH);
                    }

                    @Override
                    public void markDirty() {
                        super.markDirty();
                        TailoringStationScreenHandler.this.onContentChanged(this.inventory);
                    }
                });
            }
        }

        // Output slot
        this.addSlot(new Slot(this.input, 16, 143, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraftByPlayer(player.getWorld(), player, stack.getCount());
                onCraftingSuccess(player);

                player.getWorld().playSound(null, player.getBlockPos(),
                        SoundEvents.UI_LOOM_TAKE_RESULT,
                        SoundCategory.BLOCKS, 1.0F, 1.0F);

                context.run((world, pos) -> {
                    long l = world.getTime();
                    if (TailoringStationScreenHandler.this.lastTakeTime != l) {
                        TailoringStationScreenHandler.this.lastTakeTime = l;
                    }
                });

                super.onTakeItem(player, stack);
            }
        });

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        this.updateAvailableRecipes(input);
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        if (inventory == this.input) {
            this.updateAvailableRecipes(inventory);
        }
    }

    private void updateAvailableRecipes(Inventory inventory) {
        this.availableRecipes.clear();
        this.selectedRecipe.set(-1);
        this.input.setStack(16, ItemStack.EMPTY);

        if (!inventory.isEmpty()) {
            RecipeInput inventoryWrapper = new RecipeInput() {
                @Override
                public ItemStack getStackInSlot(int slot) { return inventory.getStack(slot); }
                @Override
                public int getSize() { return 16; }
                @Override
                public boolean isEmpty() {
                    for (int i = 0; i < 16; i++) {
                        if (!inventory.getStack(i).isEmpty()) return false;
                    }
                    return true;
                }
            };

            List<RecipeEntry<TailoringRecipe>> list = this.world.getRecipeManager()
                    .getAllMatches(ModRecipes.TAILORING_TYPE, inventoryWrapper, this.world);

            this.availableRecipes = list;
        }
        this.contentsChangedListener.run();
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult();
        }
        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    private void populateResult() {
        if (!this.availableRecipes.isEmpty() && this.isInBounds(this.selectedRecipe.get())) {
            RecipeEntry<TailoringRecipe> entry = this.availableRecipes.get(this.selectedRecipe.get());
            this.input.setStack(16, entry.value().getResult(this.world.getRegistryManager()).copy());
        } else {
            this.input.setStack(16, ItemStack.EMPTY);
        }
    }

    private void onCraftingSuccess(PlayerEntity player) {
        if (this.isInBounds(this.selectedRecipe.get())) {
            RecipeEntry<TailoringRecipe> entry = this.availableRecipes.get(this.selectedRecipe.get());
            TailoringRecipe recipe = entry.value();

            for (net.minecraft.recipe.Ingredient ingredient : recipe.getIngredients()) {
                for (int i = 0; i < 16; i++) {
                    ItemStack slotStack = this.input.getStack(i);
                    if (!slotStack.isEmpty() && ingredient.test(slotStack)) {
                        this.input.removeStack(i, 1);
                        break;
                    }
                }
            }
        }
        this.updateAvailableRecipes(this.input);
    }

    public int getSelectedRecipe() { return this.selectedRecipe.get(); }
    public List<RecipeEntry<TailoringRecipe>> getAvailableRecipes() { return this.availableRecipes; }
    public int getAvailableRecipeCount() { return this.availableRecipes.size(); }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        int startY = 122;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, startY + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        int startY = 180;
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, startY));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, BlockInit.TAILORING_STATION);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot == 16) {
                slot.onQuickTransfer(originalStack, newStack);
                if (!this.insertItem(originalStack, 17, 53, true)) return ItemStack.EMPTY;
                slot.onTakeItem(player, originalStack);
            }
            else if (invSlot >= 17) {
                if (!this.insertItem(originalStack, 0, 16, false)) return ItemStack.EMPTY;
            }
            else if (!this.insertItem(originalStack, 17, 53, false)) {
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }
        return newStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.input.onClose(player);
    }
}