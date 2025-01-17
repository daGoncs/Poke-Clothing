package github.dagoncs.init;

import github.dagoncs.PokeClothing;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ItemGroupInit {
    private static final Text CREATIVE_TAB = Text.translatable("itemGroup." + PokeClothing.MOD_ID + ".poke_clothing_group");
    public static final ItemGroup POKE_CLOTHING_GROUP = register("poke_clothing_group", FabricItemGroup.builder()
            .displayName(CREATIVE_TAB)
            .icon(ItemInit.KANTO_ASH_HELMET::getDefaultStack)
            .entries((displayContext, entries) -> {
                entries.add(ItemInit.WHITE_CLOTH);
                entries.add(ItemInit.LIGHT_GRAY_CLOTH);
                entries.add(ItemInit.GRAY_CLOTH);
                entries.add(ItemInit.BLACK_CLOTH);
                entries.add(ItemInit.BROWN_CLOTH);
                entries.add(ItemInit.RED_CLOTH);
                entries.add(ItemInit.ORANGE_CLOTH);
                entries.add(ItemInit.YELLOW_CLOTH);
                entries.add(ItemInit.LIME_CLOTH);
                entries.add(ItemInit.GREEN_CLOTH);
                entries.add(ItemInit.CYAN_CLOTH);
                entries.add(ItemInit.LIGHT_BLUE_CLOTH);
                entries.add(ItemInit.BLUE_CLOTH);
                entries.add(ItemInit.PURPLE_CLOTH);
                entries.add(ItemInit.MAGENTA_CLOTH);
                entries.add(ItemInit.PINK_CLOTH);
                entries.add(ItemInit.KANTO_ASH_HELMET);
                entries.add(ItemInit.KANTO_ASH_CHESTPLATE);
                entries.add(ItemInit.KANTO_ASH_LEGGINGS);
                entries.add(ItemInit.KANTO_ASH_BOOTS);
                entries.add(ItemInit.MISTY_CHESTPLATE);
                entries.add(ItemInit.MISTY_LEGGINGS);
                entries.add(ItemInit.MISTY_BOOTS);
                entries.add(ItemInit.BROCK_CHESTPLATE);
                entries.add(ItemInit.BROCK_LEGGINGS);
                entries.add(ItemInit.BROCK_BOOTS);
                entries.add(ItemInit.TEAM_ROCKET_GRUNT_HELMET);
                entries.add(ItemInit.TEAM_ROCKET_GRUNT_CHESTPLATE);
                entries.add(ItemInit.TEAM_ROCKET_GRUNT_LEGGINGS);
                entries.add(ItemInit.TEAM_ROCKET_GRUNT_BOOTS);
            })
            .build());

    public static <T extends ItemGroup> T register(String id, T itemGroup) {
        return Registry.register(Registries.ITEM_GROUP, PokeClothing.id(id), itemGroup);
    }
    public static void load() {}
}
