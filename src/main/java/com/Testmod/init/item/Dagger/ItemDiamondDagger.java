package com.Testmod.init.item.Dagger;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDiamondDagger extends ItemDagger{
private float normalWeponDamage; 
private float attackDamage;
	public ItemDiamondDagger(ToolMaterial material) {
		super(material);
		this.attackDamage = 4.0F + material.getDamageVsEntity();
		this.normalWeponDamage = attackDamage;
		
	}
		

}
