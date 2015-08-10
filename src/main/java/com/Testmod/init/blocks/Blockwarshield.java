package com.Testmod.init.blocks;

import java.util.Random;

import com.Testmod.init.item.TestItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class Blockwarshield extends BlockDoor {

	public Blockwarshield(Material materialIn) {
		super(materialIn);
		setStepSound(Block.soundTypeAnvil);
		setHardness(5.0F);
		setHarvestLevel("axe",3);
		//sets up block , should there be perks for stanidn behind it ?
	}
	@Override
	 public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ){
		return enableStats;
		
	}


}
