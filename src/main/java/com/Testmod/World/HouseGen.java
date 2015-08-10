/*
*** MADE BY MRPONYCAPTAIN'S .SCHEMATIC TO .JAVA CONVERTING TOOL v2.0 ***
*/

package com.Testmod.World;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class HouseGen
{
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {
			Blocks.grass,Blocks.air,Blocks.stone,Blocks.water
		};
	}

	public boolean locationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block check = world.getBlockState(new BlockPos(i,j,k)).getBlock();
		
		while (check != Blocks.air){
			if (distanceToAir > 0){
				return false;
			}

			distanceToAir++;
			check = world.getBlockState(new BlockPos(i, j + distanceToAir, k)).getBlock();
		}

		j += distanceToAir - 1;

		Block block = world.getBlockState(new BlockPos(i, j, k)).getBlock();
		Block blockAbove = world.getBlockState(new BlockPos(i, j+1, k)).getBlock();
		Block blockBelow = world.getBlockState(new BlockPos(i, j-1, k)).getBlock();
		
		for (Block x : getValidSpawnBlocks()){
			if (blockAbove != Blocks.air){
				return false;
			}
			if (block == x){
				return true;
			}else if (block == Blocks.snow && blockBelow == x){
				return true;
			}
		}
		
		return false;
	}

	public static boolean generateBuilding(worldGenTestBlock WorldGen, World world, Random rand, int x, int z) {
		//check that each corner is one of the valid spawn blocks

		//if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 14, j, k) || !locationIsValidSpawn(world, i + 14, j, z + 11) || !locationIsValidSpawn(world, i, j, z + 11))
		//{
		//	return false;
		//}
		int y = 0;
		y = findY(x,z, world);
		if(y!=0){
			System.out.println(x+" "+y+" "+ z);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 0, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 1, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 2, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 8, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 9, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 10, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 1, y+ 0, z + 11, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 2, y+ 0, z + 2, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 2, y+ 0, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 0, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 0, z + 8, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, x + 2, y+ 1, z + 2, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 2, y+ 1, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 1, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 1, z + 8, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 2, y+ 2, z + 3, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 2, y+ 2, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 2, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 2, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 2, y+ 2, z + 7, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 2, y+ 3, z + 4, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 2, y+ 3, z + 5, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 2, y+ 3, z + 6, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 3, y+ 0, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 0, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 0, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 0, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 1, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 1, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 1, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 1, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 2, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 2, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 3, y+ 3, z + 8, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 4, y+ 0, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 0, z + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 4, y+ 0, z + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 4, y+ 0, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 0, z + 10, Blocks.air, 2);
			WorldGen.setBlock(world, x + 4, y+ 1, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 1, z + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 4, y+ 1, z + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 4, y+ 1, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 1, z + 10, Blocks.air, 8);
			WorldGen.setBlock(world, x + 4, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 2, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 2, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 2, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 2, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 2, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 1, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 5, Blocks.glowstone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 3, z + 9, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 4, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 4, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 4, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 4, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 4, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 0, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 0, z + 1, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 5, y+ 0, z + 9, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 5, y+ 0, z + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 1, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 1, z + 1, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 5, y+ 1, z + 9, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 5, y+ 1, z + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 2, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 2, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 2, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 3, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 3, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 3, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 3, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 4, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 4, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 4, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 4, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 5, z + 3, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 5, y+ 5, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 5, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 5, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 5, y+ 5, z + 7, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 6, y+ 0, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 0, z + 10, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 6, y+ 0, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 6, y+ 1, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 1, z + 11, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 6, y+ 2, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 3, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 3, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 4, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 4, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 5, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 5, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 5, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 5, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 6, y+ 5, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 0, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 0, z + 10, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 7, y+ 0, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 7, y+ 1, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 1, z + 11, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 7, y+ 2, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 3, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 3, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 4, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 4, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 5, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 5, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 5, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 5, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 7, y+ 5, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 0, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 0, z + 10, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 8, y+ 0, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 8, y+ 1, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 1, z + 11, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 8, y+ 2, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 3, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 3, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 4, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 4, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 5, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 5, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 5, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 5, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 8, y+ 5, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 0, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 0, z + 1, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 9, y+ 0, z + 9, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 9, y+ 0, z + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 0, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 9, y+ 1, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 1, z + 1, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 9, y+ 1, z + 9, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 9, y+ 1, z + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 2, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 2, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 2, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 3, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 3, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 3, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 4, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 4, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 4, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 4, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 5, z + 3, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 9, y+ 5, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 5, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 5, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 9, y+ 5, z + 7, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 10, y+ 0, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 0, z + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 10, y+ 0, z + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 10, y+ 0, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 0, z + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 10, y+ 0, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 10, y+ 1, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 1, z + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 10, y+ 1, z + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, x + 10, y+ 1, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 1, z + 11, Blocks.air, 2);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 2, z + 11, Blocks.air, 8);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 1, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 5, Blocks.glowstone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 3, z + 9, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 10, y+ 4, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 4, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 4, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 4, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 10, y+ 4, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 1, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 4, Blocks.iron_bars, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 5, Blocks.iron_bars, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 6, Blocks.iron_bars, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 11, y+ 0, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 11, y+ 1, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 1, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 1, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 1, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 2, z + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 2, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 11, y+ 3, z + 8, Blocks.planks, 2);
			WorldGen.setBlock(world, x + 11, y+ 4, z + 3, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 11, y+ 4, z + 4, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 11, y+ 4, z + 5, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 11, y+ 4, z + 6, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 11, y+ 4, z + 7, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 1, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 8, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 12, y+ 0, z + 11, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 12, y+ 1, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 1, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 1, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 12, y+ 2, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 2, z + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 12, y+ 2, z + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 12, y+ 2, z + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 12, y+ 2, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 3, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 3, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 3, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 3, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 3, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 4, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 4, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 4, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 4, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 4, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 5, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 5, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 5, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 6, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 6, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 6, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 7, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 7, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 7, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 12, y+ 8, z + 4, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 12, y+ 8, z + 5, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 12, y+ 8, z + 6, Blocks.brick_stairs, 3);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 0, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 1, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 2, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 4, Blocks.netherrack, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 5, Blocks.netherrack, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 6, Blocks.netherrack, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 8, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 10, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 13, y+ 0, z + 11, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 0, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 4, Blocks.fire, 15);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 5, Blocks.fire, 15);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 6, Blocks.fire, 15);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 1, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 2, z + 0, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 13, y+ 2, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 2, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 3, z + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 13, y+ 3, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 3, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 4, z + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 4, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 4, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 4, z + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 5, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 5, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 6, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 6, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 7, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 7, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 13, y+ 8, z + 4, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 13, y+ 8, z + 6, Blocks.brick_stairs, 3);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 3, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 4, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 7, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 8, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 9, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 10, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 14, y+ 0, z + 11, Blocks.dirt, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 3, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 7, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 8, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 1, z + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 2, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 2, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 2, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 2, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 2, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 3, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 3, z + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 3, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 3, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 3, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 4, z + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, x + 14, y+ 4, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 4, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 4, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 5, z + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, x + 14, y+ 5, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 5, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 5, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 6, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 6, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 6, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 7, z + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 7, z + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 7, z + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, x + 14, y+ 8, z + 4, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, x + 14, y+ 8, z + 5, Blocks.brick_stairs, 1);
			WorldGen.setBlock(world, x + 14, y+ 8, z + 6, Blocks.brick_stairs, 1);
		//	world.setBlockAndMetadataWithNotify(i + 11, y+ 1, z + 9, 1, 2);
		//	world.setBlockAndMetadataWithNotify(i + 11, y+ 1, z + 11, 1, 2);
		//	world.setBlockAndMetadataWithNotify(i + 13, y+ 4, z + 0, 1, 2);
		}
		return true;
	}

	private static int findY(int x, int z,World world) {
		for(int y = 60;y<100;y++){
			BlockPos pos = new BlockPos(x, y, z);
			Block block = world.getBlockState(pos).getBlock();
			if(block.isAir(world, pos)){
				return y;
			}
			 
		}
		return 0;
	}

}