package com.OMYJO.kingofglory.item.armor;

import com.OMYJO.kingofglory.item.KingOfItem;
import com.OMYJO.kingofglory.other.SharedKingAttributes;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.World;

public abstract class KingOfArmor extends ArmorItem implements KingOfItem
{
	public KingOfArmor(IArmorMaterial materialIn, EquipmentSlotType slot,  Rarity rarity)
	{
		super(materialIn, slot, (new Item.Properties()).group(ItemGroup.COMBAT).rarity(rarity));
	}

	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	 */
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot)
	{
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		return multimap;
	}

	/**
	 * Checks whether an item can be enchanted with a certain enchantment. This
	 * applies specifically to enchanting an item in the enchanting table and is
	 * called when retrieving the list of possible enchantments for an item.
	 * Enchantments may additionally (or exclusively) be doing their own checks in
	 * {@link net.minecraft.enchantment.Enchantment#canApplyAtEnchantingTable(ItemStack)};
	 * check the individual implementation for reference. By default this will check
	 * if the enchantment type is valid for this item type.
	 *
	 * @param stack       the item stack to be enchanted
	 * @param enchantment the enchantment to be applied
	 * @return true if the enchantment can be applied to this item
	 */
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.enchantment.Enchantment enchantment)
	{
		if(enchantment == Enchantments.AQUA_AFFINITY)//水下速掘
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.BLAST_PROTECTION)//爆炸保护
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.DEPTH_STRIDER)//深海
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.FEATHER_FALLING)//摔落
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.FIRE_PROTECTION)//火焰保护
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.FROST_WALKER)//冰霜
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.MENDING)//经验
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.PROJECTILE_PROTECTION)//弹射物
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.PROTECTION)//保护
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.RESPIRATION)//水下
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		else if(enchantment == Enchantments.THORNS)//荆棘
		{
			return enchantment.type.canEnchantItem(stack.getItem());
		}
		return false;
	}

	/**
	 * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
	 * update it's contents.
	 *
	 * @param stack
	 * @param worldIn
	 * @param entityIn
	 * @param itemSlot
	 * @param isSelected
	 */
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		long time = worldIn.getGameTime();
		if(time % 1000 == 0)
		{
			stack.setDamage(stack.getDamage() - (int)(((PlayerEntity)entityIn).getAttributes().getAttributeInstance(SharedKingAttributes.MANA_PER_5_SECONDS).getValue()));
		}
	}
}
