package github.dagoncs.init;

import github.dagoncs.PokeClothing;
import github.dagoncs.data.provider.PokeClothingTagProvider;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ArmorMaterialInit {

    // Default values
    private static final int BASE_ENCHANTABILITY = 15;
    private static final RegistryEntry<SoundEvent> BASE_SOUND = SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    private static final Supplier<Ingredient> BASE_REPAIR_ITEM = () -> Ingredient.fromTag(PokeClothingTagProvider.CLOTH);
    private static final float BASE_TOUGHNESS = 0.0f;
    private static final float BASE_KNOCKBACK = 0.0f;

    private static final Map<ArmorItem.Type, Integer> BASE_DEFENSE = Map.of(
            ArmorItem.Type.HELMET, 1,
            ArmorItem.Type.CHESTPLATE, 3,
            ArmorItem.Type.LEGGINGS, 2,
            ArmorItem.Type.BOOTS, 1
    );

    public static final RegistryEntry<ArmorMaterial> KANTO_ASH = register("kanto_ash");
    public static final RegistryEntry<ArmorMaterial> MISTY = register("misty");
    public static final RegistryEntry<ArmorMaterial> BROCK = register("brock");
    public static final RegistryEntry<ArmorMaterial> JESSIE = register("jessie");
    public static final RegistryEntry<ArmorMaterial> JAMES = register("james");
    public static final RegistryEntry<ArmorMaterial> DAWN = register("dawn");
    public static final RegistryEntry<ArmorMaterial> PLATINUM_DAWN = register("platinum_dawn");
    public static final RegistryEntry<ArmorMaterial> BRENDAN = register("brendan");
    public static final RegistryEntry<ArmorMaterial> EMERALD_BRENDAN = register("emerald_brendan");
    public static final RegistryEntry<ArmorMaterial> RED = register("red");
    public static final RegistryEntry<ArmorMaterial> TEAM_ROCKET_GRUNT = register("team_rocket_grunt");


    public static RegistryEntry<ArmorMaterial> register(String id) {
        return register(id, BASE_DEFENSE, BASE_ENCHANTABILITY, BASE_SOUND, BASE_REPAIR_ITEM, BASE_TOUGHNESS, BASE_KNOCKBACK, false);
    }

    public static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defensePoints,
                                                        int enchantability, RegistryEntry<SoundEvent> equipSound,
                                                        Supplier<Ingredient> repairIngredient, float toughness,
                                                        float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(PokeClothing.id(id), "", dyeable)
        );
        var material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredient, layers,
                toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, PokeClothing.id(id), material);
        return RegistryEntry.of(material);
    }

    public static void load() {}
}