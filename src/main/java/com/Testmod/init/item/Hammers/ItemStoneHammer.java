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

public class ItemStoneHammer extends ItemHammer{

	public ItemStoneHammer(ToolMaterial material) {
		super(material);

		
	}
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
	      if (itemStack.getTagCompound() == null)
	        {
	    	  itemStack.getTagCompound().setString("owner", player.getName());
	    	  itemStack.getTagCompound().setInteger("code", 3);
	    	  itemStack.getTagCompound().setString("charge", "1" );
	        }
	}
	
}
