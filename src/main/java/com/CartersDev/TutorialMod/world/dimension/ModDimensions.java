package com.CartersDev.TutorialMod.world.dimension;

import com.CartersDev.TutorialMod.TutorialMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static RegistryKey<World> KJDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(TutorialMod.MOD_ID, "kjdim"));
}
