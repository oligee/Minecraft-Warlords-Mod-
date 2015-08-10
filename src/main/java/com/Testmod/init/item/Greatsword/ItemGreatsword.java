package com.Testmod.init.item.Greatsword;

import java.util.List;


import com.Testmod.Testmod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemGreatsword extends ItemBow{
private float normalWeponDamage; 
private float attackDamage;
public static final int COOLDOWN = 60;
private boolean canHit = true;
	public ItemGreatsword(ToolMaterial material) {
		super();
		this.attackDamage = material.getDamageVsEntity();
	}

	@Override
	  public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
		//sets up swing to ensure it cannot be interupted
		if(entityLiving.isSwingInProgress){
			return true;
		}else{
			canHit = true;
			return false;
		}
    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{	
		//prevents blocking
	    return itemStackIn;
	}
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){	
		//only hits the player if there is not an attack on going 
		if(canHit){
			canHit = false;
			return false;
		}else{
			
			return true;
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		//entityIn.addPotionEffect(new PotionEffect(Potion.invisibility.getId(),50,1));
		//makes swing speed slow when held
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		{

			 EntityPlayer player = (EntityPlayer) entityIn;
			 if(entityIn instanceof EntityPlayer) {
			
				 EntityPlayer playerIn = (EntityPlayer) entityIn;
				 ItemStack equipped = player.getCurrentEquippedItem();
				 
				 	if(equipped == stack) {
            	
				 		if(player.isSwingInProgress) {
				 			playerIn.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1, 15));
				 		}
				 	}
			 }
		}	
	}
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {	
		//causes cripple on hit
		
		target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,  50, 5));
		stack.damageItem(1, attacker);
		target.attackEntityFrom(DamageSource.generic,(float) attackDamage );
		return true;
     
    }

}
