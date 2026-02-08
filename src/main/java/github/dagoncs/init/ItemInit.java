package github.dagoncs.init;

import github.dagoncs.PokeClothing;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ItemInit {
public static final Item WHITE_CLOTH = register("white_cloth", new Item(new Item.Settings()));
public static final Item LIGHT_GRAY_CLOTH = register("light_gray_cloth", new Item(new Item.Settings()));
public static final Item GRAY_CLOTH = register("gray_cloth", new Item(new Item.Settings()));
public static final Item BLACK_CLOTH = register("black_cloth", new Item(new Item.Settings()));
public static final Item BROWN_CLOTH = register("brown_cloth", new Item(new Item.Settings()));
public static final Item RED_CLOTH = register("red_cloth", new Item(new Item.Settings()));
public static final Item ORANGE_CLOTH = register("orange_cloth", new Item(new Item.Settings()));
public static final Item YELLOW_CLOTH = register("yellow_cloth", new Item(new Item.Settings()));
public static final Item LIME_CLOTH = register("lime_cloth", new Item(new Item.Settings()));
public static final Item GREEN_CLOTH = register("green_cloth", new Item(new Item.Settings()));
public static final Item CYAN_CLOTH = register("cyan_cloth", new Item(new Item.Settings()));
public static final Item LIGHT_BLUE_CLOTH = register("light_blue_cloth", new Item(new Item.Settings()));
public static final Item BLUE_CLOTH = register("blue_cloth", new Item(new Item.Settings()));
public static final Item PURPLE_CLOTH = register("purple_cloth", new Item(new Item.Settings()));
public static final Item MAGENTA_CLOTH = register("magenta_cloth", new Item(new Item.Settings()));
public static final Item PINK_CLOTH = register("pink_cloth", new Item(new Item.Settings()));
public static final Item KANTO_ASH_HELMET = register("kanto_ash_helmet", new ArmorItem(ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item KANTO_ASH_CHESTPLATE = register("kanto_ash_chestplate", new ArmorItem(ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item KANTO_ASH_LEGGINGS = register("kanto_ash_leggings", new ArmorItem(ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item KANTO_ASH_BOOTS = register("kanto_ash_boots", new ArmorItem(ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item MISTY_CHESTPLATE = register("misty_chestplate", new ArmorItem(ArmorMaterialInit.MISTY, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item MISTY_LEGGINGS = register("misty_leggings", new ArmorItem(ArmorMaterialInit.MISTY, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item MISTY_BOOTS = register("misty_boots", new ArmorItem(ArmorMaterialInit.MISTY, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item BROCK_CHESTPLATE = register("brock_chestplate", new ArmorItem(ArmorMaterialInit.BROCK, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item BROCK_LEGGINGS = register("brock_leggings", new ArmorItem(ArmorMaterialInit.BROCK, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item BROCK_BOOTS = register("brock_boots", new ArmorItem(ArmorMaterialInit.BROCK, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item TEAM_ROCKET_GRUNT_HELMET = register("team_rocket_grunt_helmet", new ArmorItem(ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item TEAM_ROCKET_GRUNT_CHESTPLATE = register("team_rocket_grunt_chestplate", new ArmorItem(ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item TEAM_ROCKET_GRUNT_LEGGINGS = register("team_rocket_grunt_leggings", new ArmorItem(ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
public static final Item TEAM_ROCKET_GRUNT_BOOTS = register("team_rocket_grunt_boots", new ArmorItem(ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, PokeClothing.id(name), item);
    }

    public static void load() {
        PokeClothing.LOGGER.info("Registering ItemInit");
    }
}
