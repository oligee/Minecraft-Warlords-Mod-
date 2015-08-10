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

public class BlockStoneWarshield extends Blockwarshield {

	public BlockStoneWarshield(Material materialIn) {
		super(materialIn);
	}
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null :  TestItems.stone_warshield;
    }
}