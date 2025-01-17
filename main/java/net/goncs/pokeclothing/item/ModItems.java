package net.goncs.pokeclothing.item;

import net.goncs.pokeclothing.PokeClothing;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PokeClothing.MOD_ID);

    public static final RegistryObject<Item> KANTO_ASH_HELMET = ITEMS.register("kanto_ash_helmet",
            () -> new ArmorItem(ModArmorMaterial.KANTO_ASH, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> KANTO_ASH_CHESTPLATE = ITEMS.register("kanto_ash_chestplate",
            () -> new ArmorItem(ModArmorMaterial.KANTO_ASH, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> KANTO_ASH_LEGGINGS = ITEMS.register("kanto_ash_leggings",
            () -> new ArmorItem(ModArmorMaterial.KANTO_ASH, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> KANTO_ASH_BOOTS = ITEMS.register("kanto_ash_boots",
            () -> new ArmorItem(ModArmorMaterial.KANTO_ASH, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> MISTY_CHESTPLATE = ITEMS.register("misty_chestplate",
            () -> new ArmorItem(ModArmorMaterial.MISTY, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> MISTY_LEGGINGS = ITEMS.register("misty_leggings",
            () -> new ArmorItem(ModArmorMaterial.MISTY, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> MISTY_BOOTS = ITEMS.register("misty_boots",
            () -> new ArmorItem(ModArmorMaterial.MISTY, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> BROCK_CHESTPLATE = ITEMS.register("brock_chestplate",
            () -> new ArmorItem(ModArmorMaterial.BROCK, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> BROCK_LEGGINGS = ITEMS.register("brock_leggings",
            () -> new ArmorItem(ModArmorMaterial.BROCK, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> BROCK_BOOTS = ITEMS.register("brock_boots",
            () -> new ArmorItem(ModArmorMaterial.BROCK, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> TEAM_ROCKET_GRUNT_HELMET = ITEMS.register("team_rocket_grunt_helmet",
            () -> new ArmorItem(ModArmorMaterial.TEAM_ROCKET_GRUNT, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> TEAM_ROCKET_GRUNT_CHESTPLATE = ITEMS.register("team_rocket_grunt_chestplate",
            () -> new ArmorItem(ModArmorMaterial.TEAM_ROCKET_GRUNT, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> TEAM_ROCKET_GRUNT_LEGGINGS = ITEMS.register("team_rocket_grunt_leggings",
            () -> new ArmorItem(ModArmorMaterial.TEAM_ROCKET_GRUNT, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));

    public static final RegistryObject<Item> TEAM_ROCKET_GRUNT_BOOTS = ITEMS.register("team_rocket_grunt_boots",
            () -> new ArmorItem(ModArmorMaterial.TEAM_ROCKET_GRUNT, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.POKE_CLOTHING)));


    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
}
}