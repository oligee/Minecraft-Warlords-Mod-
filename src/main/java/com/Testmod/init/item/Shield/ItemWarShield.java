package com.Testmod.init.item.Shield;

import com.Testmod.Testmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWarShield extends ItemDoor{
	private Block block;
	private static final String __OBFID = "CL_00000020";
	private float normalWeponDamage; 
	private float attackDamage;

	//blocking is handled in a event hook

	public ItemWarShield(Block block) {
		super(block);
		// TODO Auto-generated constructor stub
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