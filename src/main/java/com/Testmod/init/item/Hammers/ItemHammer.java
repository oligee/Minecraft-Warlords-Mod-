package com.Testmod.init.item.Hammers;

import java.util.List;



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

public class ItemHammer extends ItemBow{
private float normalWeponDamage; 
private float attackDamage;
	public ItemHammer(ToolMaterial material) {
		super();
		this.attackDamage =  material.getDamageVsEntity();

		
	}
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		//nbt tags test
	      if (itemStack.getTagCompound() == null)
	        {
	    	  itemStack.setTagCompound(new NBTTagCompound());
	    	  itemStack.getTagCompound().setString("owner", player.getName());
	    	  itemStack.getTagCompound().setInteger("code", 3);
	    	  itemStack.getTagCompound().setString("charge", "1" );
	        }
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		//sets up swing attack
		 playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		
	    return itemStackIn;
	}

	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		{
			//makes attacking slower if held 
			 EntityPlayer player = (EntityPlayer) entityIn;
			 if(entityIn instanceof EntityPlayer) {
			
				 EntityPlayer playerIn = (EntityPlayer) entityIn;
				 ItemStack equipped = player.getCurrentEquippedItem();
				 
				 	if(equipped == stack) {
            	
				 		if(player.isSwingInProgress) {
				 			playerIn.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1, 3));
				 		}
				 	}
			 }
		}	
	}
	public void addInformation(ItemStack itemStack, EntityPlayer player,List list, boolean par4) {
    if (itemStack.getTagCompound() != null) {
            String owner = itemStack.getTagCompound().getString("owner");
            int code = itemStack.getTagCompound().getInteger("code");
            String charge = itemStack.getTagCompound().getString("charge");
            list.add("owner: " + owner);
            list.add("Charge: " + charge);
            if (owner.equals(player.getName())) {
                    list.add(EnumChatFormatting.GREEN + "code: " + code);
            } else {
                    list.add(EnumChatFormatting.RED + "code: "
                                    + EnumChatFormatting.OBFUSCATED + code);
            }
    	}

	}   
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
	{	
		//spawns a entity if right click is held long enough 
		//entity cuases explotion , thats is used in the event hooks
		if(timeLeft<=71977){
			playerIn.isSwingInProgress = true;
				if(playerIn.isSwingInProgress) {
					playerIn.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 1, 3));
				}
				worldIn.spawnEntityInWorld(new EntityBlasterBolt(worldIn, playerIn));
		}
		System.out.println(timeLeft);
		
	}
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {	
		//causes confusion on hit 
		target.addPotionEffect(new PotionEffect(Potion.confusion.id, 50, 6));
		stack.damageItem(1, attacker);
		target.attackEntityFrom(DamageSource.generic,(float) attackDamage );
		return true;
     
    }

}
