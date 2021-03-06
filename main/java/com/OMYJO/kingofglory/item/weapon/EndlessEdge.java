package com.OMYJO.kingofglory.item.weapon;

import com.OMYJO.kingofglory.other.Helper;
import com.OMYJO.kingofglory.other.KingOfItemTier;
import com.OMYJO.kingofglory.other.SharedKingAttributes;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EndlessEdge extends KingOfWeapon
{
	private float attackDamage = Helper.attackDamage(130);
	private float criticalChance = 0.2F;
	private float criticalDamage = 0.4F;
	private final HashMap<EquipmentSlotType, UUID> attackDamageModifierMap = new HashMap<>();
	private final HashMap<EquipmentSlotType, UUID> criticalChanceModifierMap = new HashMap<>();
	public static final UUID ENDLESS_EDGE_MODIFIER = UUID.randomUUID();

	public EndlessEdge()
	{
		super(new KingOfItemTier(), Rarity.RARE);
		attackDamageModifierMap.put(EquipmentSlotType.MAINHAND,UUID.randomUUID());
		attackDamageModifierMap.put(EquipmentSlotType.OFFHAND,UUID.randomUUID());
		criticalChanceModifierMap.put(EquipmentSlotType.MAINHAND,UUID.randomUUID());
		criticalChanceModifierMap.put(EquipmentSlotType.OFFHAND,UUID.randomUUID());
		setRegistryName("endless_edge");
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 *
	 * @param stack
	 * @param worldIn
	 * @param tooltip
	 * @param flagIn
	 */
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("item_effect"+"."+getRegistryName().getNamespace() + "." + getRegistryName().getPath() +".0"));
	}

	@Override
	public float getAttackDamage()
	{
		return attackDamage;
	}

	@Override
	public float getCriticalChance()
	{
		return criticalChance;
	}

	@Override
	public float getCriticalDamage()
	{
		return criticalDamage;
	}


	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	 *
	 * @param equipmentSlot
	 */
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot)
	{
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if(equipmentSlot == EquipmentSlotType.MAINHAND || equipmentSlot == EquipmentSlotType.OFFHAND)
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(attackDamageModifierMap.get(equipmentSlot), "Weapon modifier", getAttackDamage(), AttributeModifier.Operation.ADDITION));
			multimap.put(SharedKingAttributes.CRITICAL_CHANCE.getName(), new AttributeModifier(criticalChanceModifierMap.get(equipmentSlot), "Weapon modifier", getCriticalChance(), AttributeModifier.Operation.ADDITION));
			multimap.put(SharedKingAttributes.CRITICAL_DAMAGE.getName(), new AttributeModifier(ENDLESS_EDGE_MODIFIER, "Weapon modifier", this.getCriticalDamage(), AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
}
