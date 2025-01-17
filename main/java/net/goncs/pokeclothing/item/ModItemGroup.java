package net.goncs.pokeclothing.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup POKE_CLOTHING = new ItemGroup("pokeClothingTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.KANTO_ASH_HELMET.get());
        }
    };
}
