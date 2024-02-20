package com.CartersDev.TutorialMod.integration.jei;


import com.CartersDev.TutorialMod.TutorialMod;
import com.CartersDev.TutorialMod.data.recipes.LightningChannelerRecipe;
import com.CartersDev.TutorialMod.data.recipes.ModRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class TutorialJei implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TutorialMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new LightningChannelerRecipieCatagory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().world).getRecipeManager();
        registration.addRecipes((rm.getRecipesForType(ModRecipeTypes.LIGHTNING_RECIPE).stream()
                .filter(r -> r instanceof LightningChannelerRecipe).collect(Collectors.toList())),
                LightningChannelerRecipieCatagory.UID);
    }
}
