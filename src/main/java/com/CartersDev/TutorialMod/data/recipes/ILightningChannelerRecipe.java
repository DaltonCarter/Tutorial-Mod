package com.CartersDev.TutorialMod.data.recipes;


import com.CartersDev.TutorialMod.TutorialMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface ILightningChannelerRecipe extends IRecipe<IInventory> {
    ResourceLocation TYPE_ID = new ResourceLocation(TutorialMod.MOD_ID, "lightning");

    @Override
    default IRecipeType<?> getType() {
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canFit(int width, int height) {
        return true;
    }

    @Override
    default boolean isDynamic() {
        return true;
    }
}
