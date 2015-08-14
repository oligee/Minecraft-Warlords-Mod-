package com.Testmod.Entitys;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FallenHeroEntity extends EntityZombie{

	public FallenHeroEntity(World worldIn) {
		super(worldIn);
		// this.setCurrentItemOrArmor(4, new ItemStack(Items.leather_helmet));
		 this.setCurrentItemOrArmor(3, new ItemStack(Items.leather_chestplate));
		 this.setCurrentItemOrArmor(2, new ItemStack(Items.leather_leggings));
		 this.setCurrentItemOrArmor(1, new ItemStack(Items.leather_boots));
		 this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
		 
		// TODO Auto-generated constructor stub
	}

}
