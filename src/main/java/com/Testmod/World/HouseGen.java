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

	public static boolean generateBuilding(worldGenTestBlock WorldGen, World world, Random rand, int i, int k) {
		//check that each corner is one of the valid spawn blocks

		//if(!locationIsValidSpawn(world, i, j, k) || !locationIsValidSpawn(world, i + 14, j, k) || !locationIsValidSpawn(world, i + 14, j, z + 11) || !locationIsValidSpawn(world, i, j, z + 11))
		//{
		//	return false;
		//}
		int j = 0;
		j = findY(i,k, world);
		if(j!=0){
			System.out.println(i+" "+j+" "+ k);
			WorldGen.setBlock(world, i + 1, j + 0, k + 0, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 1, j + 0, k + 1, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 1, j + 0, k + 2, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 1, j + 0, k + 8, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 1, j + 0, k + 9, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 1, j + 0, k + 10, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 1, j + 0, k + 11, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 2, j + 0, k + 2, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 2, j + 0, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 0, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 0, k + 8, Blocks.oak_fence, 0);
			WorldGen.setBlock(world, i + 2, j + 1, k + 2, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 2, j + 1, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 1, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 1, k + 8, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 2, j + 2, k + 3, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 2, j + 2, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 2, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 2, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 2, j + 2, k + 7, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 2, j + 3, k + 4, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 2, j + 3, k + 5, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 2, j + 3, k + 6, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 3, j + 0, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 0, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 0, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 0, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 1, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 1, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 1, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 1, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 2, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 3, k + 2, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 3, j + 3, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 3, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 3, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 3, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 3, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 3, j + 3, k + 8, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 4, j + 0, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 0, k + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 4, j + 0, k + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 4, j + 0, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 1, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 1, k + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 4, j + 1, k + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 4, j + 1, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 2, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 2, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 2, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 2, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 2, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 1, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 4, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 5, Blocks.glowstone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 3, k + 9, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 4, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 4, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 4, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 4, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 4, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 0, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 0, k + 1, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 5, j + 0, k + 9, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 5, j + 0, k + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 1, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 1, k + 1, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 5, j + 1, k + 9, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 5, j + 1, k + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 2, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 2, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 2, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 3, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 3, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 3, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 3, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 4, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 4, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 4, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 4, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 5, k + 3, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 5, j + 5, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 5, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 5, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 5, j + 5, k + 7, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 6, j + 0, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 0, k + 10, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 6, j + 0, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 6, j + 1, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 1, k + 11, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 6, j + 2, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 3, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 3, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 4, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 4, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 5, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 5, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 5, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 5, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 6, j + 5, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 0, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 0, k + 10, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 7, j + 0, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 7, j + 1, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 1, k + 11, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 7, j + 2, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 3, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 3, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 4, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 4, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 5, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 5, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 5, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 5, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 7, j + 5, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 0, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 0, k + 10, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 8, j + 0, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 8, j + 1, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 1, k + 11, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 8, j + 2, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 3, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 3, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 4, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 4, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 5, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 5, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 5, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 5, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 8, j + 5, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 0, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 0, k + 1, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 9, j + 0, k + 9, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 9, j + 0, k + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 0, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 9, j + 1, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 1, k + 1, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 9, j + 1, k + 9, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 9, j + 1, k + 10, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 2, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 2, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 2, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 3, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 3, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 3, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 4, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 4, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 4, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 4, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 5, k + 3, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 9, j + 5, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 5, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 5, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 9, j + 5, k + 7, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 10, j + 0, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 0, k + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 10, j + 0, k + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 10, j + 0, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 0, k + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 10, j + 0, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 10, j + 1, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 1, k + 2, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 10, j + 1, k + 8, Blocks.stonebrick, 0);
			WorldGen.setBlock(world, i + 10, j + 1, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 1, k + 11, Blocks.air, 2);
			WorldGen.setBlock(world, i + 10, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 2, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 2, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 2, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 2, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 2, k + 9, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 2, k + 11, Blocks.air, 8);
			WorldGen.setBlock(world, i + 10, j + 3, k + 1, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 10, j + 3, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 5, Blocks.glowstone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 3, k + 9, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 10, j + 4, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 4, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 4, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 4, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 10, j + 4, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 1, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 4, Blocks.iron_bars, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 5, Blocks.iron_bars, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 6, Blocks.iron_bars, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 11, j + 0, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 11, j + 1, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 1, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 1, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 1, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 2, k + 8, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 3, k + 2, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 11, j + 3, k + 3, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 3, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 3, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 3, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 3, k + 7, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 11, j + 3, k + 8, Blocks.planks, 2);
			WorldGen.setBlock(world, i + 11, j + 4, k + 3, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, i + 11, j + 4, k + 4, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, i + 11, j + 4, k + 5, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, i + 11, j + 4, k + 6, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, i + 11, j + 4, k + 7, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 1, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 8, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 12, j + 0, k + 11, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 12, j + 1, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 1, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 1, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 12, j + 2, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 2, k + 4, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 12, j + 2, k + 5, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 12, j + 2, k + 6, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 12, j + 2, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 3, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 3, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 3, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 3, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 3, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 4, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 4, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 4, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 4, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 4, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 5, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 5, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 5, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 6, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 6, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 6, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 7, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 7, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 7, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 12, j + 8, k + 4, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 12, j + 8, k + 5, Blocks.brick_stairs, 0);
			WorldGen.setBlock(world, i + 12, j + 8, k + 6, Blocks.brick_stairs, 3);
			WorldGen.setBlock(world, i + 13, j + 0, k + 0, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 1, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 2, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 4, Blocks.netherrack, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 5, Blocks.netherrack, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 6, Blocks.netherrack, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 8, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 10, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 13, j + 0, k + 11, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 13, j + 1, k + 0, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 13, j + 1, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 1, k + 4, Blocks.fire, 15);
			WorldGen.setBlock(world, i + 13, j + 1, k + 5, Blocks.fire, 15);
			WorldGen.setBlock(world, i + 13, j + 1, k + 6, Blocks.fire, 15);
			WorldGen.setBlock(world, i + 13, j + 1, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 1, k + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 1, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 2, k + 0, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 13, j + 2, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 2, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 3, k + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 13, j + 3, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 3, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 4, k + 3, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 4, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 4, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 4, k + 7, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 5, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 5, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 6, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 6, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 7, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 7, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 13, j + 8, k + 4, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 13, j + 8, k + 6, Blocks.brick_stairs, 3);
			WorldGen.setBlock(world, i + 14, j + 0, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 3, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 7, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 8, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 9, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 10, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 14, j + 0, k + 11, Blocks.dirt, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 2, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 3, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 7, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 8, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 9, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 10, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 1, k + 11, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 2, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 2, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 2, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 2, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 2, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 3, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 3, k + 1, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 3, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 3, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 3, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 4, k + 0, Blocks.stone, 0);
			WorldGen.setBlock(world, i + 14, j + 4, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 4, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 4, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 5, k + 0, Blocks.grass, 0);
			WorldGen.setBlock(world, i + 14, j + 5, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 5, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 5, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 6, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 6, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 6, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 7, k + 4, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 7, k + 5, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 7, k + 6, Blocks.brick_block, 0);
			WorldGen.setBlock(world, i + 14, j + 8, k + 4, Blocks.brick_stairs, 2);
			WorldGen.setBlock(world, i + 14, j + 8, k + 5, Blocks.brick_stairs, 1);
			WorldGen.setBlock(world, i + 14, j + 8, k + 6, Blocks.brick_stairs, 1);
		}
		return true;
	}

	private static int findY(int x, int z,World world) {
		for(int y = 60;y<100;y++){
			BlockPos pos = new BlockPos(x, y, z);
			Block block = world.getBlockState(pos).getBlock();
			if(block.equals(Blocks.grass)){
				return y+1;
			}
			 
		}
		return 0;
	}

}