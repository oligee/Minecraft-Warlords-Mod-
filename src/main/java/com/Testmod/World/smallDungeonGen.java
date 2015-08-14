/*
*** MADE BY MRPONYCAPTAIN'S .SCHEMATIC TO .JAVA CONVERTING TOOL v2.0 ***
*/

package com.Testmod.World;

import java.util.Random;

import com.Testmod.Dungeon.Parts.CornerPart;
import com.Testmod.Dungeon.Parts.DeadEndPart;
import com.Testmod.Dungeon.Parts.EntrancePart;
import com.Testmod.Dungeon.Parts.SplitPart;
import com.Testmod.Dungeon.Parts.StairsPart;
import com.Testmod.Dungeon.Parts.TunnelPart;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class smallDungeonGen
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
		EntrancePart entrance = new EntrancePart();
		StairsPart stairs = new StairsPart();
		CornerPart corner = new CornerPart();
		SplitPart split = new SplitPart();
		TunnelPart tunnel = new TunnelPart();
		DeadEndPart end = new DeadEndPart();
		j = findY(i,k, world) - 11;
		if (j!=0){
		System.out.println("here"+i+" " + " "+ j + " "+k);
		//i = x
		//k = z
		//i = y
		//clearing top easier to find that way
		for(int x=0;x<=11;x++){
			for(int y=1;y<=10;y++){
				for(int z=0;z<=11;z++){
					WorldGen.setBlock(world, i + x, j + y, k + z, Blocks.air, 0);
				}
			}
		}
		entrance.generateBuilding(WorldGen, world, rand, i, k, j, 1);
		j=j-11;
		stairs.generateBuilding(WorldGen, world, rand, i, k, j, 0);
		k=k-22;
		tunnel.generateBuilding(WorldGen, world, rand, i, k, j, 0);
		k=k-11;
		split.generateBuilding(WorldGen, world, rand, i, k, j, 0);
		//left coverd
		i=i-22;
		tunnel.generateBuilding(WorldGen, world, rand, i, k, j, 1);
		i=i-11;
		end.generateBuilding(WorldGen, world, rand, i, k, j, 1);
		i=i+44;
		//right side
		corner.generateBuilding(WorldGen, world, rand, i, k, j, 3);
		k=k-11;
		end.generateBuilding(WorldGen, world, rand, i, k, j, 0);
		//north
		k=k-11;
		i=i-11;
		tunnel.generateBuilding(WorldGen, world, rand, i, k, j, 0);
		k=k-11;
		end.generateBuilding(WorldGen, world, rand, i, k, j, 0);
		
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