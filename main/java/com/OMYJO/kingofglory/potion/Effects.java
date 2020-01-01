package com.OMYJO.kingofglory.potion;

import com.OMYJO.kingofglory.potion.ChasingSun;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@net.minecraftforge.registries.ObjectHolder("kingofglory")
public class Effects
{
	@ObjectHolder("cripple")
	public static Cripple CRIPPLE;
	@ObjectHolder("chasing_sun")
	public static ChasingSun CHASING_SUN;
	@ObjectHolder("severe_wound")
	public static SevereWound SEVERE_WOUND;
	@ObjectHolder("dark_curtain")
	public static DarkCurtain DARK_CURTAIN;
	@ObjectHolder("crushing_ice")
	public static CrushingIce CRUSHING_ICE;
	@ObjectHolder("storm")
	public static Storm STORM;
	@ObjectHolder("assaulting")
	public static Assaulting ASSAULTING;
	@ObjectHolder("dispelling")
	public static Dispelling DISPELLING;

	@SubscribeEvent
	public static void onEffectsRegistry(final RegistryEvent.Register<Effect> event)
	{
		event.getRegistry().register(new Cripple());
		event.getRegistry().register(new SevereWound());
		event.getRegistry().register(new ChasingSun());
		event.getRegistry().register(new DarkCurtain());
		event.getRegistry().register(new CrushingIce());
		event.getRegistry().register(new Storm());
		event.getRegistry().register(new Assaulting());
		event.getRegistry().register(new Dispelling());
	}
}
