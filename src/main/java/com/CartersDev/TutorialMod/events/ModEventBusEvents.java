package com.CartersDev.TutorialMod.events;


import com.CartersDev.TutorialMod.TutorialMod;
import com.CartersDev.TutorialMod.entity.ModEntityTypes;
import com.CartersDev.TutorialMod.entity.custom.BuffZombieEntity;
import com.CartersDev.TutorialMod.entity.custom.PigeonEntity;
import com.CartersDev.TutorialMod.events.loot.FirestoneAdditionModifier;
import com.CartersDev.TutorialMod.events.loot.FirestoneStructureAdditionModifier;
import com.CartersDev.TutorialMod.item.custom.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().create());
        event.put(ModEntityTypes.PIGEON.get(), PigeonEntity.setCustomAttributes().create());
    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new FirestoneAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(TutorialMod.MOD_ID,"firestone_from_magma")),
                new FirestoneStructureAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(TutorialMod.MOD_ID,"firestone_in_igloo"))
        );
    }

}
