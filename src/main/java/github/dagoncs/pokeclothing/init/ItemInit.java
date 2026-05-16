package github.dagoncs.pokeclothing.init;

import github.dagoncs.pokeclothing.PokeClothing;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ItemInit {

    public static final Map<String, Item> CLOTHS = new LinkedHashMap<>();

    static {
        String[] colors = {
                "white", "light_gray", "gray", "black", "brown", "red", "orange",
                "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple",
                "magenta", "pink"
        };
        for (String color : colors) {
            CLOTHS.put(color, registerBase(color + "_cloth"));
        }
    }

    public static final Item ASH_CAP_ICON = registerBase("ash_cap_icon");
    public static final ArmorPieces KANTO_ASH = registerSet("kanto_ash", ArmorMaterialInit.KANTO_ASH, true, true, true, true);
    public static final ArmorPieces MISTY = registerSet("misty", ArmorMaterialInit.MISTY, false, true, true, true);
    public static final ArmorPieces BROCK = registerSet("brock", ArmorMaterialInit.BROCK, false, true, true, true);
    public static final ArmorPieces PROFESSOR_OAK = registerSet("professor_oak", ArmorMaterialInit.PROFESSOR_OAK, false, true, true, true);
    public static final ArmorPieces JESSIE = registerSet("jessie", ArmorMaterialInit.JESSIE, false, true, true, true);
    public static final ArmorPieces JAMES = registerSet("james", ArmorMaterialInit.JAMES, false, true, true, true);
    public static final ArmorPieces TEAM_ROCKET_GRUNT = registerSet("team_rocket_grunt", ArmorMaterialInit.TEAM_ROCKET_GRUNT, true, true, true, true);
    public static final ArmorPieces HOENN_ASH = registerSet("hoenn_ash", ArmorMaterialInit.HOENN_ASH, true, true, true, true);
    public static final ArmorPieces MAY = registerSet("may", ArmorMaterialInit.MAY, true, true, true, true);
    public static final ArmorPieces EMERALD_MAY = registerSet("emerald_may", ArmorMaterialInit.EMERALD_MAY, true, true, true, true);
    public static final ArmorPieces TEAM_MAGMA_GRUNT = registerSet("team_magma_grunt", ArmorMaterialInit.TEAM_MAGMA_GRUNT, true, true, true, true);
    public static final ArmorPieces TEAM_AQUA_GRUNT = registerSet("team_aqua_grunt", ArmorMaterialInit.TEAM_AQUA_GRUNT, true, true, true, true);
    public static final ArmorPieces SINNOH_ASH = registerSet("sinnoh_ash", ArmorMaterialInit.SINNOH_ASH, true, true, true, true);
    public static final ArmorPieces DAWN = registerSet("dawn", ArmorMaterialInit.DAWN, true, true, true, true);
    public static final ArmorPieces PLATINUM_DAWN = registerSet("platinum_dawn", ArmorMaterialInit.PLATINUM_DAWN, false, true, true, true);
    public static final ArmorPieces BRENDAN = registerSet("brendan", ArmorMaterialInit.BRENDAN, true, true, true, true);
    public static final ArmorPieces EMERALD_BRENDAN = registerSet("emerald_brendan", ArmorMaterialInit.EMERALD_BRENDAN, true, true, true, true);
    public static final ArmorPieces CYRUS = registerSet("cyrus", ArmorMaterialInit.CYRUS, false, true, true, true);
    public static final ArmorPieces TEAM_GALACTIC_GRUNT = registerSet("team_galactic_grunt", ArmorMaterialInit.TEAM_GALACTIC_GRUNT, false, true, true, true);
    public static final ArmorPieces UNOVA_ASH = registerSet("unova_ash", ArmorMaterialInit.UNOVA_ASH, true, true, true, true);
    public static final ArmorPieces KALOS_ASH = registerSet("kalos_ash", ArmorMaterialInit.KALOS_ASH, true, true, true, true);
    public static final ArmorPieces SERENA = registerSet("serena", ArmorMaterialInit.SERENA, true, true, true, true);
    public static final ArmorPieces ALOLA_ASH = registerSet("alola_ash", ArmorMaterialInit.ALOLA_ASH, true, true, true, true);
    public static final ArmorPieces GALAR_ASH = registerSet("galar_ash", ArmorMaterialInit.GALAR_ASH, true, true, true, true);
    public static final ArmorPieces RED = registerSet("red", ArmorMaterialInit.RED, true, true, true, true);


    /** A clean container to hold a full or partial set of armor */
    public record ArmorPieces(Item helmet, Item chestplate, Item leggings, Item boots) {}

    /**
     * Registers an entire armor set in one line.
     * Pass 'false' if the character doesn't have a specific piece.
     */
    private static ArmorPieces registerSet(String baseName, RegistryEntry<ArmorMaterial> material,
                                           boolean hasHelmet, boolean hasChest, boolean hasLegs, boolean hasBoots) {
        Item helmet = hasHelmet ? registerArmor(baseName + "_helmet", material, ArmorItem.Type.HELMET) : null;
        Item chest = hasChest ? registerArmor(baseName + "_chestplate", material, ArmorItem.Type.CHESTPLATE) : null;
        Item legs = hasLegs ? registerArmor(baseName + "_leggings", material, ArmorItem.Type.LEGGINGS) : null;
        Item boots = hasBoots ? registerArmor(baseName + "_boots", material, ArmorItem.Type.BOOTS) : null;

        return new ArmorPieces(helmet, chest, legs, boots);
    }

    private static Item registerArmor(String name, RegistryEntry<ArmorMaterial> material, ArmorItem.Type type) {
        return register(name, new ArmorItem(material, type, new Item.Settings().maxDamage(type.getMaxDamage(50))));
    }

    private static Item registerBase(String name) {
        return register(name, new Item(new Item.Settings()));
    }

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, PokeClothing.id(name), item);
    }

    public static void load() {
        PokeClothing.LOGGER.info("Registering ItemInit");
    }
}