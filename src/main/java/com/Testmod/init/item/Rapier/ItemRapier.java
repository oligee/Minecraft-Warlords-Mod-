package com.Testmod.init.item.Rapier;

import com.Testmod.Testmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemRapier extends ItemSword{
private float normalWeponDamage; 
private float attackDamage;
	public ItemRapier(ToolMaterial material) {
		super(material);
		this.attackDamage = material.getDamageVsEntity();
		
		
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		{
			//speeds up attacking if held 
			 EntityPlayer player = (EntityPlayer) entityIn;
			 ItemStack equipped = player.getCurrentEquippedItem();
			 if (equipped == stack){
				 player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(),2,1));
			 }
		}
	}
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {	
		//applys bleed when hitting player
		target.addPotionEffect(new PotionEffect(Testmod.customPotion.id, 50, 1));
		stack.damageItem(1, attacker);
		target.attackEntityFrom(DamageSource.generic,(float) attackDamage );
		System.out.println(attackDamage);
		return true;
     
    }


}
