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

public class ItemDagger extends ItemSword{
private float normalWeponDamage; 
private float attackDamage;
	public ItemDagger(ToolMaterial material) {
		super(material);
		this.attackDamage = material.getDamageVsEntity();
		this.normalWeponDamage = attackDamage;
		
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		
		
	        playerIn.addPotionEffect(new PotionEffect(Potion.invisibility.getId(),50,1));
	    
		
	    return itemStackIn;
	}
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {	
		//checks direction on target being attacked , if the attack is from the behind do more damage
		int direction = MathHelper.floor_double((double) (attacker.rotationYaw * 4.0F / 360) + 0.50) & 3;
		int directionTwo = MathHelper.floor_double((double) (target.rotationYaw * 4.0F / 360) + 0.50) & 3;
		stack.damageItem(1, attacker);
		if(direction==directionTwo){
			if(attackDamage>normalWeponDamage){
				
			}else{
				attackDamage +=4;
			}
			target.attackEntityFrom(DamageSource.generic,(float) attackDamage );
		}else{
			
			attackDamage =normalWeponDamage;
		}

		System.out.println(attackDamage);
        return true;
    }
	


}
