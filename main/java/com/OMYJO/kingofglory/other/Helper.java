package com.OMYJO.kingofglory.other;

import net.minecraft.entity.player.PlayerEntity;
import sun.nio.cs.ext.MacHebrew;

public class Helper
{
	public static float attackDamage(float attackDamage)
	{
		return attackDamage/20;
	}
	public static float maxHealth(float maxHealth) { return maxHealth/250; }
	public static int maxMana(int maxMana) { return maxMana/5; }
	public static float movementSpeed(float movementSpeed){return movementSpeed/720; }
	public static double distance(float d){return movementSpeed(d)*20*Math.sqrt(Math.PI)/2;}
	public static int getEscapeTime(PlayerEntity playerEntity)
	{
		if(playerEntity.getRevengeTarget() == null)
		{
			if(playerEntity.ticksExisted - playerEntity.getLastAttackedEntityTime() >140)
			{
				return playerEntity.ticksExisted - Math.max(playerEntity.getRevengeTimer(),playerEntity.getLastAttackedEntityTime()+140);
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
}
