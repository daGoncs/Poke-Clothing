package github.dagoncs.pokeclothing.block.entity.custom;

import github.dagoncs.pokeclothing.block.entity.ImplementedInventory;
import github.dagoncs.pokeclothing.block.entity.ModBlockEntities;
import github.dagoncs.pokeclothing.provider.PokeClothingTagProvider; // <--- ADD IMPORT
import github.dagoncs.pokeclothing.screen.custom.TailoringStationScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction; // <--- ADD IMPORT
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream; // <--- ADD IMPORT

public class TailoringStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(17, ItemStack.EMPTY);

    public TailoringStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TAILORING_STATION_BE, pos, state);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Tailoring Station");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TailoringStationScreenHandler(syncId, playerInventory, this, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    public void tick(World world, BlockPos pos, BlockState state) {
    }

    private void craftItem(ItemStack result, DefaultedList<Ingredient> ingredients) {
    }

    //Inventory writing/reading
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.inventory, registryLookup);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory, registryLookup);
    }

    /**
     * Determines which slots are accessible from which side.
     * Bottom = Output Slot (16)
     * Other Sides = Input Slots (0-15)
     */
    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return new int[]{16}; // Output slot only
        }
        // Returns an array [0, 1, 2, ... 15] for inputs
        return IntStream.range(0, 16).toArray();
    }

    /**
     * Checks if an item can be inserted (Hoppers/Pipes).
     * 1. Output slot (16) -> REJECT
     * 2. Input slots (0-15) -> ONLY ACCEPT IF HAS CLOTH TAG
     */
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if (slot == 16) return false;

        // Only allow inserting if the item is in your "Cloth" tag
        return stack.isIn(PokeClothingTagProvider.CLOTH);
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return false;
    }
}