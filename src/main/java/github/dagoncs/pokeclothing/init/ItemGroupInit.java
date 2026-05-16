package github.dagoncs.pokeclothing.init;

import github.dagoncs.pokeclothing.PokeClothing;
import github.dagoncs.pokeclothing.block.BlockInit;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import org.jetbrains.annotations.UnknownNullability;

public class ItemGroupInit {
    private static final Text CREATIVE_TAB = Text.translatable("itemGroup." + PokeClothing.MOD_ID + ".poke_clothing_group");

    public static final ItemGroup POKE_CLOTHING_GROUP = register("poke_clothing_group", FabricItemGroup.builder()
            .displayName(CREATIVE_TAB)
            .icon(() -> new ItemStack(ItemInit.ASH_CAP_ICON))
            .entries((displayContext, entries) -> {
                entries.add(BlockInit.TAILORING_STATION);

                ItemInit.CLOTHS.values().forEach(entries::add);

                addArmorSet(entries, ItemInit.KANTO_ASH);
                addArmorSet(entries, ItemInit.MISTY);
                addArmorSet(entries, ItemInit.BROCK);
                addArmorSet(entries, ItemInit.PROFESSOR_OAK);
                addArmorSet(entries, ItemInit.JESSIE);
                addArmorSet(entries, ItemInit.JAMES);
                addArmorSet(entries, ItemInit.TEAM_ROCKET_GRUNT);
                addArmorSet(entries, ItemInit.HOENN_ASH);
                addArmorSet(entries, ItemInit.MAY);
                addArmorSet(entries, ItemInit.EMERALD_MAY);
                addArmorSet(entries, ItemInit.TEAM_MAGMA_GRUNT);
                addArmorSet(entries, ItemInit.TEAM_AQUA_GRUNT);
                addArmorSet(entries, ItemInit.SINNOH_ASH);
                addArmorSet(entries, ItemInit.DAWN);
                addArmorSet(entries, ItemInit.PLATINUM_DAWN);
                addArmorSet(entries, ItemInit.BRENDAN);
                addArmorSet(entries, ItemInit.EMERALD_BRENDAN);
                addArmorSet(entries, ItemInit.CYRUS);
                addArmorSet(entries, ItemInit.TEAM_GALACTIC_GRUNT);
                addArmorSet(entries, ItemInit.UNOVA_ASH);
                addArmorSet(entries, ItemInit.KALOS_ASH);
                addArmorSet(entries, ItemInit.SERENA);
                addArmorSet(entries, ItemInit.ALOLA_ASH);
                addArmorSet(entries, ItemInit.GALAR_ASH);
                addArmorSet(entries, ItemInit.RED);
            })
            .build());

    /**
     * Helper method to add an armor set to the creative tab safely.
     * It checks if a piece exists (isn't null) before adding it,
     * which handles characters like Misty who don't have helmets
     */
    private static void addArmorSet(ItemGroup.Entries entries, ItemInit.@UnknownNullability ArmorPieces set) {
        if (set.helmet() != null) entries.add(set.helmet());
        if (set.chestplate() != null) entries.add(set.chestplate());
        if (set.leggings() != null) entries.add(set.leggings());
        if (set.boots() != null) entries.add(set.boots());
    }

    public static <T extends ItemGroup> T register(String id, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, PokeClothing.id(id), itemGroup);
    }

    public static void load() {}
}