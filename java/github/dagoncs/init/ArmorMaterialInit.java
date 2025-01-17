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
    public static final RegistryEntry<ArmorMaterial> KANTO_ASH = register("kanto_ash", Map.of(
            ArmorItem.Type.HELMET, 1,
            ArmorItem.Type.CHESTPLATE, 3,
            ArmorItem.Type.LEGGINGS, 2,
            ArmorItem.Type.BOOTS, 1
    ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.fromTag(PokeClothingTagProvider.CLOTH),0.0f,0.0f,false);

    public static final RegistryEntry<ArmorMaterial> MISTY = register("misty", Map.of(
                    ArmorItem.Type.HELMET, 1,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 1
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.fromTag(PokeClothingTagProvider.CLOTH),0.0f,0.0f,false);

    public static final RegistryEntry<ArmorMaterial> BROCK = register("brock", Map.of(
                    ArmorItem.Type.HELMET, 1,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 1
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.fromTag(PokeClothingTagProvider.CLOTH),0.0f,0.0f,false);

    public static final RegistryEntry<ArmorMaterial> TEAM_ROCKET_GRUNT = register("team_rocket_grunt", Map.of(
                    ArmorItem.Type.HELMET, 1,
                    ArmorItem.Type.CHESTPLATE, 3,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 1
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.fromTag(PokeClothingTagProvider.CLOTH),0.0f,0.0f,false);


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
