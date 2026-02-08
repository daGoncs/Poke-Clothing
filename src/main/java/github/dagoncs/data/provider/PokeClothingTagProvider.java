package github.dagoncs.data.provider;

import github.dagoncs.PokeClothing;
import github.dagoncs.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class PokeClothingTagProvider extends FabricTagProvider.ItemTagProvider {
    public PokeClothingTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> CLOTH = TagKey.of(RegistryKeys.ITEM, PokeClothing.id("cloth"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CLOTH).add(ItemInit.WHITE_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.LIGHT_GRAY_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.GRAY_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.BLACK_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.BROWN_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.RED_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.ORANGE_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.YELLOW_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.LIME_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.GREEN_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.CYAN_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.LIGHT_BLUE_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.BLUE_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.PURPLE_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.MAGENTA_CLOTH);
        getOrCreateTagBuilder(CLOTH).add(ItemInit.PINK_CLOTH);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ItemInit.KANTO_ASH_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ItemInit.KANTO_ASH_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ItemInit.KANTO_ASH_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ItemInit.KANTO_ASH_BOOTS);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ItemInit.MISTY_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ItemInit.MISTY_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ItemInit.MISTY_BOOTS);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ItemInit.BROCK_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ItemInit.BROCK_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ItemInit.BROCK_BOOTS);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ItemInit.TEAM_ROCKET_GRUNT_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ItemInit.TEAM_ROCKET_GRUNT_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ItemInit.TEAM_ROCKET_GRUNT_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ItemInit.TEAM_ROCKET_GRUNT_BOOTS);
    }
}
