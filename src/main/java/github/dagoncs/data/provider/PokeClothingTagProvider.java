package github.dagoncs.data.provider;

import github.dagoncs.PokeClothing;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class PokeClothingTagProvider extends FabricTagProvider.ItemTagProvider {
    public PokeClothingTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> CLOTH = TagKey.of(RegistryKeys.ITEM, PokeClothing.id("cloth"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        for (Item item : Registries.ITEM) {
            Identifier id = Registries.ITEM.getId(item);

            if (id.getNamespace().equals(PokeClothing.id("dummy").getNamespace())) {

                if (item instanceof ArmorItem armorItem) {
                    switch (armorItem.getType()) {
                        case HELMET -> getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(item);
                        case CHESTPLATE -> getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(item);
                        case LEGGINGS -> getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(item);
                        case BOOTS -> getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(item);
                    }
                }
                else if (id.getPath().endsWith("_cloth")) {
                    getOrCreateTagBuilder(CLOTH).add(item);
                }
            }
        }
    }
}