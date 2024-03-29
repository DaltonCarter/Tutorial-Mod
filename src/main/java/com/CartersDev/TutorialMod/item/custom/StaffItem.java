package com.CartersDev.TutorialMod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class StaffItem extends Item {
    public StaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        attacker.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 60));
        target.addPotionEffect(new EffectInstance(Effects.LEVITATION, 200, 2));
        return super.hitEntity(stack, target, attacker);
    }
}
