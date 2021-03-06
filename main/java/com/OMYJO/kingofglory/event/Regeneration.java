package com.OMYJO.kingofglory.event;

import com.OMYJO.kingofglory.item.armor.EyeOfThePhoenix;
import com.OMYJO.kingofglory.other.SharedKingAttributes;
import com.OMYJO.kingofglory.potion.Effects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Regeneration
{
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		PlayerEntity playerEntity = event.player;
		long time = playerEntity.getEntityWorld().getGameTime();
		if (time % 100 == 0)
		{
			playerEntity.heal((float) playerEntity.getAttributes().getAttributeInstance(SharedKingAttributes.HP_PER_5_SECONDS).getValue());
		}
	}

	@SubscribeEvent
	public static void onLivingHeal(LivingHealEvent event)
	{
		//制裁
		if (event.getEntityLiving().isPotionActive(Effects.SEVERE_WOUND))
		{
			event.setAmount(event.getAmount() / 2);
		}
		//不死鸟
		if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof EyeOfThePhoenix)
		{
			float amplifier = 0.06F * (int) ((event.getEntityLiving().getMaxHealth() - event.getEntityLiving().getMaxHealth()) * 10 / event.getEntityLiving().getMaxHealth());
			event.setAmount(event.getAmount() * (1 + amplifier));
		}
	}
}
