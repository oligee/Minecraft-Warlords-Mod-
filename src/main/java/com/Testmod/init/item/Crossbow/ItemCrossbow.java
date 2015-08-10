package com.Testmod.init.item.Crossbow;


import javax.swing.Icon;

import com.Testmod.Reference;
import com.Testmod.ThrownEntitys.EntityThrowSpear;
import com.Testmod.init.item.TestItems;

import net.minecraft.client.resources.model.ModelResourceLocation;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrossbow extends ItemBow{
public boolean loaded = false;
private float normalWeponDamage; 
private float attackDamage;

	public ItemCrossbow(ToolMaterial material) {
		super();
		this.attackDamage = 4.0F + material.getDamageVsEntity();
		this.normalWeponDamage = attackDamage;
   	}
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	      if (itemStack.getTagCompound() == null)
	        {
	    	  setTags(itemStack,world,player);

	        }
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
    {	
		System.out.println(timeLeft);
		System.out.println(loaded);
		if(timeLeft<=71977){
			System.out.println("loaded");
			stack.getTagCompound().setBoolean("loaded",true);
		}else if(stack.getTagCompound().getBoolean("loaded")){
			
			System.out.println("pop");
			int j = this.getMaxItemUseDuration(stack) - 71977;
	        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, j);
	        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
	        j = event.charge;

	        boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

	        if (flag || playerIn.inventory.hasItem(Items.arrow))
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
	        
	            
	            EntityArrow entityarrow = new EntityArrow(worldIn, playerIn, f * 2.0F);
	           

	            if (f == 1.0F)
	            {
	                entityarrow.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

	            if (k > 0)
	            {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

	            if (l > 0)
	            {
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
	            {
	                entityarrow.setFire(100);
	            }

	            stack.damageItem(1, playerIn);
	            worldIn.playSoundAtEntity(playerIn, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            if (flag)
	            {
	                entityarrow.canBePickedUp = 2;
	            }
	            else
	            {
	                playerIn.inventory.consumeInventoryItem(Items.arrow);
	            }

	            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

	             if (!worldIn.isRemote)
	             {
	            	 loaded = false;
	            	 stack.getTagCompound().setBoolean("loaded",false);
	                 worldIn.spawnEntityInWorld(entityarrow);
	             }
	            
	        }
			
		}
    }
	@Override
	
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		
	    if (itemStackIn.getTagCompound() == null){
	    	 setTags(itemStackIn,worldIn,playerIn);
	       }
        if(itemStackIn.getTagCompound().getBoolean("loaded")){
        	System.out.println("fire!");
        	playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        	
        }else{
	        if (playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(Items.arrow))
	        {		
	            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
	        }
        }

        return itemStackIn;
    }

	public void arrowFire(ItemStack stack, World worldIn, EntityPlayer playerIn){
		System.out.println("pop");
		int j = this.getMaxItemUseDuration(stack) - 71977;
        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, j);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
        j = event.charge;

        boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

        if (flag || playerIn.inventory.hasItem(Items.arrow))
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
            System.out.println(f * 2.0F);
            
           EntityArrow entityarrow = new EntityArrow(worldIn, playerIn, f * 2.0F);
           

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0)
            {
                entityarrow.setFire(100);
            }

            stack.damageItem(1, playerIn);
            worldIn.playSoundAtEntity(playerIn, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                playerIn.inventory.consumeInventoryItem(Items.arrow);
            }

            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

             if (!worldIn.isRemote)
             {
                 worldIn.spawnEntityInWorld(entityarrow);
             }
            
        }
	}
	public void setTags(ItemStack itemStack, World world, EntityPlayer player){
  	  	itemStack.setTagCompound(new NBTTagCompound());
  	  	itemStack.getTagCompound().setBoolean("loaded", false);
	}
	@Override
    public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int useRemaining)
    {
		  if (stack.getTagCompound() == null){
		    	 setTags(stack,player.getEntityWorld(),player);
		      }
		 ModelResourceLocation modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":cross_bow", "inventory");

        if(stack.getItem() == this)
        {
            if(stack.getTagCompound().getBoolean("loaded"))
            {
                modelresourcelocation = new ModelResourceLocation(Reference.MOD_ID + ":cross_bow_pulling_0", "inventory");
            }
         
        }
        return modelresourcelocation;
    }
	
}

