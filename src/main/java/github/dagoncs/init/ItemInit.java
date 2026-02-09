package github.dagoncs.init;

import github.dagoncs.PokeClothing;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class ItemInit {
    public static final Item WHITE_CLOTH = registerBase("white_cloth");
    public static final Item LIGHT_GRAY_CLOTH = registerBase("light_gray_cloth");
    public static final Item GRAY_CLOTH = registerBase("gray_cloth");
    public static final Item BLACK_CLOTH = registerBase("black_cloth");
    public static final Item BROWN_CLOTH = registerBase("brown_cloth");
    public static final Item RED_CLOTH = registerBase("red_cloth");
    public static final Item ORANGE_CLOTH = registerBase("orange_cloth");
    public static final Item YELLOW_CLOTH = registerBase("yellow_cloth");
    public static final Item LIME_CLOTH = registerBase("lime_cloth");
    public static final Item GREEN_CLOTH = registerBase("green_cloth");
    public static final Item CYAN_CLOTH = registerBase("cyan_cloth");
    public static final Item LIGHT_BLUE_CLOTH = registerBase("light_blue_cloth");
    public static final Item BLUE_CLOTH = registerBase("blue_cloth");
    public static final Item PURPLE_CLOTH = registerBase("purple_cloth");
    public static final Item MAGENTA_CLOTH = registerBase("magenta_cloth");
    public static final Item PINK_CLOTH = registerBase("pink_cloth");
    // Kanto Ash
    public static final Item KANTO_ASH_HELMET = registerArmor("kanto_ash_helmet", ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.HELMET);
    public static final Item KANTO_ASH_CHESTPLATE = registerArmor("kanto_ash_chestplate", ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.CHESTPLATE);
    public static final Item KANTO_ASH_LEGGINGS = registerArmor("kanto_ash_leggings", ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.LEGGINGS);
    public static final Item KANTO_ASH_BOOTS = registerArmor("kanto_ash_boots", ArmorMaterialInit.KANTO_ASH, ArmorItem.Type.BOOTS);
    // Misty
    public static final Item MISTY_CHESTPLATE = registerArmor("misty_chestplate", ArmorMaterialInit.MISTY, ArmorItem.Type.CHESTPLATE);
    public static final Item MISTY_LEGGINGS = registerArmor("misty_leggings", ArmorMaterialInit.MISTY, ArmorItem.Type.LEGGINGS);
    public static final Item MISTY_BOOTS = registerArmor("misty_boots", ArmorMaterialInit.MISTY, ArmorItem.Type.BOOTS);
    // Brock
    public static final Item BROCK_CHESTPLATE = registerArmor("brock_chestplate", ArmorMaterialInit.BROCK, ArmorItem.Type.CHESTPLATE);
    public static final Item BROCK_LEGGINGS = registerArmor("brock_leggings", ArmorMaterialInit.BROCK, ArmorItem.Type.LEGGINGS);
    public static final Item BROCK_BOOTS = registerArmor("brock_boots", ArmorMaterialInit.BROCK, ArmorItem.Type.BOOTS);
    //Jessie
    public static final Item JESSIE_CHESTPLATE = registerArmor("jessie_chestplate", ArmorMaterialInit.JESSIE, ArmorItem.Type.CHESTPLATE);
    public static final Item JESSIE_LEGGINGS = registerArmor("jessie_leggings", ArmorMaterialInit.JESSIE, ArmorItem.Type.LEGGINGS);
    public static final Item JESSIE_BOOTS = registerArmor("jessie_boots", ArmorMaterialInit.JESSIE, ArmorItem.Type.BOOTS);
    // James
    public static final Item JAMES_CHESTPLATE = registerArmor("james_chestplate", ArmorMaterialInit.JAMES, ArmorItem.Type.CHESTPLATE);
    public static final Item JAMES_LEGGINGS = registerArmor("james_leggings", ArmorMaterialInit.JAMES, ArmorItem.Type.LEGGINGS);
    public static final Item JAMES_BOOTS = registerArmor("james_boots", ArmorMaterialInit.JAMES, ArmorItem.Type.BOOTS);
    // Dawn
    public static final Item DAWN_HELMET = registerArmor("dawn_helmet", ArmorMaterialInit.DAWN, ArmorItem.Type.HELMET);
    public static final Item DAWN_CHESTPLATE = registerArmor("dawn_chestplate", ArmorMaterialInit.DAWN, ArmorItem.Type.CHESTPLATE);
    public static final Item DAWN_LEGGINGS = registerArmor("dawn_leggings", ArmorMaterialInit.DAWN, ArmorItem.Type.LEGGINGS);
    public static final Item DAWN_BOOTS = registerArmor("dawn_boots", ArmorMaterialInit.DAWN, ArmorItem.Type.BOOTS);
    // Platinum Dawn
    public static final Item PLATINUM_DAWN_CHESTPLATE = registerArmor("platinum_dawn_chestplate", ArmorMaterialInit.PLATINUM_DAWN, ArmorItem.Type.CHESTPLATE);
    public static final Item PLATINUM_DAWN_LEGGINGS = registerArmor("platinum_dawn_leggings", ArmorMaterialInit.PLATINUM_DAWN, ArmorItem.Type.LEGGINGS);
    public static final Item PLATINUM_DAWN_BOOTS = registerArmor("platinum_dawn_boots", ArmorMaterialInit.PLATINUM_DAWN, ArmorItem.Type.BOOTS);
    // Brendan
    public static final Item BRENDAN_HELMET = registerArmor("brendan_helmet", ArmorMaterialInit.BRENDAN, ArmorItem.Type.HELMET);
    public static final Item BRENDAN_CHESTPLATE = registerArmor("brendan_chestplate", ArmorMaterialInit.BRENDAN, ArmorItem.Type.CHESTPLATE);
    public static final Item BRENDAN_LEGGINGS = registerArmor("brendan_leggings", ArmorMaterialInit.BRENDAN, ArmorItem.Type.LEGGINGS);
    public static final Item BRENDAN_BOOTS = registerArmor("brendan_boots", ArmorMaterialInit.BRENDAN, ArmorItem.Type.BOOTS);
    // Emerald Brendan
    public static final Item EMERALD_BRENDAN_HELMET = registerArmor("emerald_brendan_helmet", ArmorMaterialInit.EMERALD_BRENDAN, ArmorItem.Type.HELMET);
    public static final Item EMERALD_BRENDAN_CHESTPLATE = registerArmor("emerald_brendan_chestplate", ArmorMaterialInit.EMERALD_BRENDAN, ArmorItem.Type.CHESTPLATE);
    public static final Item EMERALD_BRENDAN_LEGGINGS = registerArmor("emerald_brendan_leggings", ArmorMaterialInit.EMERALD_BRENDAN, ArmorItem.Type.LEGGINGS);
    public static final Item EMERALD_BRENDAN_BOOTS = registerArmor("emerald_brendan_boots", ArmorMaterialInit.EMERALD_BRENDAN, ArmorItem.Type.BOOTS);
    // Red
    public static final Item RED_HELMET = registerArmor("red_helmet", ArmorMaterialInit.RED, ArmorItem.Type.HELMET);
    public static final Item RED_CHESTPLATE = registerArmor("red_chestplate", ArmorMaterialInit.RED, ArmorItem.Type.CHESTPLATE);
    public static final Item RED_LEGGINGS = registerArmor("red_leggings", ArmorMaterialInit.RED, ArmorItem.Type.LEGGINGS);
    public static final Item RED_BOOTS = registerArmor("red_boots", ArmorMaterialInit.RED, ArmorItem.Type.BOOTS);
    // Team Rocket Grunt
    public static final Item TEAM_ROCKET_GRUNT_HELMET = registerArmor("team_rocket_grunt_helmet", ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.HELMET);
    public static final Item TEAM_ROCKET_GRUNT_CHESTPLATE = registerArmor("team_rocket_grunt_chestplate", ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.CHESTPLATE);
    public static final Item TEAM_ROCKET_GRUNT_LEGGINGS = registerArmor("team_rocket_grunt_leggings", ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.LEGGINGS);
    public static final Item TEAM_ROCKET_GRUNT_BOOTS = registerArmor("team_rocket_grunt_boots", ArmorMaterialInit.TEAM_ROCKET_GRUNT, ArmorItem.Type.BOOTS);

    /**
     * Quickly registers a standard Armor Item.
     * Automatically calculates durability based on the slot (Type).
     */
    private static Item registerArmor(String name, RegistryEntry<ArmorMaterial> material, ArmorItem.Type type) {
        return register(name, new ArmorItem(material, type, new Item.Settings().maxDamage(type.getMaxDamage(50))));
    }

    /**
     * Quickly registers a basic generic Item (like cloth).
     */
    private static Item registerBase(String name) {
        return register(name, new Item(new Item.Settings()));
    }

    /**
     * The core register method.
     */
    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, PokeClothing.id(name), item);
    }

    public static void load() {
        PokeClothing.LOGGER.info("Registering ItemInit");
    }
}