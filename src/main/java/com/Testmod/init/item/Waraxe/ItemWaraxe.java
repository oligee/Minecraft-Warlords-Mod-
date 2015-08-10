package com.Testmod.init.item.Waraxe;

import com.Testmod.Testmod;
import com.Testmod.init.blocks.TestBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemWaraxe extends ItemSword{
private float normalWeponDamage; 
private float attackDamage;
	public ItemWaraxe(ToolMaterial material) {
		super(material);
		this.attackDamage = material.getDamageVsEntity();
		this.normalWeponDamage = attackDamage;
		
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		//checks if player has wepon equiped , if so buffs the player with strength
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		{
			
			 EntityPlayer player = (EntityPlayer) entityIn;
			 ItemStack equipped = player.getCurrentEquippedItem();
			 if (equipped == stack){
				 player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(),0,0));
			 }
		}
	}
	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
    {	
		//Sets up the breaking of shields
        if (block == TestBlocks.wooden_warshield_block ||block == TestBlocks.stone_warshield_block ||block == TestBlocks.iron_warshield_block ||block == TestBlocks.diamond_warshield_block )
        {
            return 15.0F;
        }
        else
        {
            Material material = block.getMaterial();
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : 1.5F;
        }
    }
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {	

	// hitting entity
		stack.damageItem(1, attacker);
		target.attackEntityFrom(DamageSource.generic,(float) attackDamage );
		System.out.println(attackDamage);
		return true;
     
    }
	


}
