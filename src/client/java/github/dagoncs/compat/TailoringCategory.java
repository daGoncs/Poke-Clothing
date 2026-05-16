package github.dagoncs.compat;

import github.dagoncs.pokeclothing.PokeClothing;
import github.dagoncs.pokeclothing.block.BlockInit;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class TailoringCategory implements DisplayCategory<TailoringDisplay> {

    public static final CategoryIdentifier<TailoringDisplay> TAILORING = CategoryIdentifier.of(PokeClothing.MOD_ID, "tailoring");

    @Override
    public CategoryIdentifier<? extends TailoringDisplay> getCategoryIdentifier() {
        return TAILORING;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.poke-clothing.tailoring_station");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(BlockInit.TAILORING_STATION);
    }

    @Override
    public List<Widget> setupDisplay(TailoringDisplay display, Rectangle bounds) {
        // 'bounds' is the box REI gives us to draw in.
        // We define a start point slightly up and left of center to fit everything.
        Point startPoint = new Point(bounds.getCenterX() - 85, bounds.getCenterY() - 25);
        List<Widget> widgets = new ArrayList<>();

        // Draw the Background (The gray panel)
        widgets.add(Widgets.createRecipeBase(bounds));

        // Draw the Input Slots (2 Rows of 8)
        List<EntryIngredient> inputEntries = display.getInputEntries();

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 8; col++) {
                int index = col + (row * 8);

                // Calculate X and Y for this specific slot (18 pixels per slot)
                int x = startPoint.x + (col * 18);
                int y = startPoint.y + (row * 18);

                // Add the slot widget
                widgets.add(Widgets.createSlot(new Point(x, y))
                        .markInput() // Tells REI "Hovering this highlights ingredients"
                        .entries(index < inputEntries.size() ? inputEntries.get(index) : EntryIngredient.empty()));
            }
        }

        widgets.add(Widgets.createArrow(new Point(startPoint.x + 148, startPoint.y + 9)));

        // Draw the Output Slot
        int outputX = startPoint.x + 180;
        int outputY = startPoint.y + 9;

        widgets.add(Widgets.createResultSlotBackground(new Point(outputX, outputY)));
        widgets.add(Widgets.createSlot(new Point(outputX, outputY))
                .markOutput() // Tells REI "Hovering this highlights the result"
                .entries(display.getOutputEntries().get(0))
                .disableBackground()); // Background already added above

        return widgets;
    }

    // These determine how big the gray window is in REI
    @Override
    public int getDisplayHeight() {
        return 70;
    }

    @Override
    public int getDisplayWidth(TailoringDisplay display) {
        return 240; // Needs to be wide to fit 8 slots + arrow + output
    }
}