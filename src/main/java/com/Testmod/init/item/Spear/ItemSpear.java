package com.Testmod.init.item.Spear;

import com.Testmod.IExtendedReach;
import com.Testmod.Testmod;
import com.Testmod.ThrownEntitys.EntityThrowDiamondSpear;
import com.Testmod.ThrownEntitys.EntityThrowIronSpear;
import com.Testmod.ThrownEntitys.EntityThrowSpear;
import com.Testmod.ThrownEntitys.EntityThrowStoneSpear;
import com.Testmod.ThrownEntitys.EntityThrowWoodenSpear;
import com.Testmod.init.item.TestItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSpear extends ItemBow implements IExtendedReach{
private float normalWeponDamage; 
private float attackDamage;
private int spearType;
	public ItemSpear(ToolMaterial material,int spearType) {
		super();
		this.spearType = spearType;
		this.attackDamage = material.getDamageVsEntity();
		
		
   	}
	@Override
	public float getReach() {
		//reach of weapon
		return 3.0F;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		//plays throwing animation 
		 playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
		
	    return itemStackIn;
	}
	@Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
    {	
		// handles the stopping right click use e.i throwing the spear
		if(timeLeft<=71977){
			//time needed to hold wepon before it is thrown
	        int j = this.getMaxItemUseDuration(stack) - timeLeft;
	        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, j);
	        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
	        j = event.charge;
	
	        boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
	
	        if (flag || playerIn.inventory.hasItem(TestItems.wooden_spear)||playerIn.inventory.hasItem(TestItems.stone_spear)||playerIn.inventory.hasItem(TestItems.iron_spear)||playerIn.inventory.hasItem(TestItems.diamond_spear))
	        {
	            float f = (float)j / 20.0F;
	            f = (f * f + f * 2.0F) / 3.0F;
	
	            if ((double)f < 0.1D)
	            {
	                return;
	            }
	
	            if (f > 1.0F)
	            {
	                f = 1.0F;
	            }
	            
	           //spawns custom spear
	            //then  handles the different types in helper function
	            EntityThrowSpear entityarrow = new EntityThrowSpear(worldIn, playerIn, f * 2.0F,this);
	            switch ( spearType ) {
	            case 0: 	
	            	EntityThrowWoodenSpear 	entityWoodenSpear= new EntityThrowWoodenSpear(worldIn, playerIn, f * 2.0F,this);
	            	spawnWoodenSpear(stack, worldIn, playerIn, f, entityWoodenSpear,flag);
	            	System.out.println(0);
	            break;
	            case 1: 
	            	EntityThrowStoneSpear	 entityStoneSpear = new EntityThrowStoneSpear(worldIn, playerIn, f * 2.0F,this);
	            	spawnWoodenSpear(stack, worldIn, playerIn, f, entityStoneSpear,flag);
	            break;
	            case 2: 
	            	EntityThrowIronSpear 	entityIronSpear = new EntityThrowIronSpear(worldIn, playerIn, f * 2.0F,this);
	            	spawnWoodenSpear(stack, worldIn, playerIn, f, entityIronSpear,flag);
	            break;
	            case 3:
	            	EntityThrowDiamondSpear entityDiamondSpear= new EntityThrowDiamondSpear(worldIn, playerIn, f * 2.0F,this);
	            	spawnWoodenSpear(stack, worldIn, playerIn, f, entityDiamondSpear,flag);
	            
	            }
	          
	        }
		}
    }
	public void spawnWoodenSpear(ItemStack stack, World worldIn, EntityPlayer playerIn, float f,EntityThrowSpear entityWoodenSpear,boolean flag){
		//helper function 
		  if (f == 1.0F)
          {
              entityWoodenSpear.setIsCritical(true);
          }

          int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

          if (k > 0)
          {
              entityWoodenSpear.setDamage(entityWoodenSpear.getDamage() + (double)k * 0.5D + 0.5D);
          }

          int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

          if (l > 0)
          {
              entityWoodenSpear.setKnockbackStrength(l);
          }

          if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
          {
              entityWoodenSpear.setFire(100);
          }

          stack.damageItem(1, playerIn);
          worldIn.playSoundAtEntity(playerIn, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

          if (flag)
          {
              entityWoodenSpear.canBePickedUp = 2;
          }
          else
          {
              playerIn.inventory.consumeInventoryItem(this);
          }

          playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

          if (!worldIn.isRemote)
          {		
        	  //spawns the spear in the world
              worldIn.spawnEntityInWorld(entityWoodenSpear);
          }
	 }
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{	
		//hitting a entity
		stack.damageItem(1, attacker);
		target.attackEntityFrom(DamageSource.generic,(float) attackDamage );
		System.out.println(attackDamage);
		return true;
	     
	}
	
}

