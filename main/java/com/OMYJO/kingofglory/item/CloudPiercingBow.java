package com.OMYJO.kingofglory.item;

import com.OMYJO.kingofglory.other.Convertor;
import com.OMYJO.kingofglory.other.KingOfMaterial;
import com.OMYJO.kingofglory.other.SharedKingAttributes;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Rarity;

import java.util.HashMap;
import java.util.UUID;

public class CloudPiercingBow extends KingOfBow
{
	private float attackDamage = Convertor.attackDamage(40);
	private float attackSpeed = 0.1F;
	private final HashMap<EquipmentSlotType, UUID> attackDamageModifierMap = new HashMap<>();
	private final HashMap<EquipmentSlotType, UUID> attackSpeedModifierMap = new HashMap<>();
	public static final UUID ARMOR_BREAKING = UUID.randomUUID();

	public CloudPiercingBow()
	{
		super(new KingOfMaterial(),Rarity.UNCOMMON);
		attackDamageModifierMap.put(EquipmentSlotType.MAINHAND,UUID.randomUUID());
		attackDamageModifierMap.put(EquipmentSlotType.OFFHAND,UUID.randomUUID());
		attackSpeedModifierMap.put(EquipmentSlotType.MAINHAND,UUID.randomUUID());
		attackSpeedModifierMap.put(EquipmentSlotType.OFFHAND,UUID.randomUUID());
		setRegistryName("cloud_piercing_bow");
	}

	@Override
	public float getAttackDamage()
	{
		return attackDamage;
	}

	@Override
	public float getAttackSpeed()
	{
		return attackSpeed;
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
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(attackDamageModifierMap.get(equipmentSlot), "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(attackSpeedModifierMap.get(equipmentSlot), "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.MULTIPLY_BASE));
		}
		if(equipmentSlot == EquipmentSlotType.MAINHAND)
		{
			multimap.put(SharedKingAttributes.ARMOR_PIERCE.getName(), new AttributeModifier(ARMOR_BREAKING, "Weapon modifier", 0.2D, AttributeModifier.Operation.ADDITION));
		}
		else if(equipmentSlot == EquipmentSlotType.OFFHAND)
		{
			multimap.put(SharedKingAttributes.ARMOR_PIERCE.getName(), new AttributeModifier(ARMOR_BREAKING, "Weapon modifier", 0.1D, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
}
