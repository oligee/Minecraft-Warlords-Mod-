package com.Testmod.World;

import java.util.Random;

import com.Testmod.init.blocks.TestBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class worldGenTestBlock implements IWorldGenerator {
	//this gens the block in the world i think
	static int defaultChunkSize = 16;
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()){
		
			case -1:generateNether(random,chunkX*defaultChunkSize,chunkZ*defaultChunkSize,world);
					break;
			case 0: generateSurface(random,chunkX*defaultChunkSize,chunkZ*defaultChunkSize,world);
					break;
			case 1: generateEnd(random,chunkX*defaultChunkSize,chunkZ*defaultChunkSize,world);
					break;
			default:
		}
		
	}
	private void addBlock(IBlockState block,Random random,World world,int posX,int posZ,int minY,int maxY,int spawnChance,int minVeinSize,int maxVeinSize){
		for(int i= 0;i<spawnChance;i++){
			
			int xPos = posX + random.nextInt(defaultChunkSize);
			int yPos = minY + random.nextInt(maxY-minY);
			int zPos = posZ + random.nextInt(defaultChunkSize);
			BlockPos blockpos = new BlockPos(xPos,yPos,zPos);
			new WorldGenMinable(block,(minVeinSize + random.nextInt(maxVeinSize-minVeinSize))).generate(world,random,blockpos);	
		}

	}
	private void generateEnd(Random random, int chunkX, int chunkY, World world) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(Random random,int chunkX, int chunkY, World world) {
		// TODO Auto-generated method stub
		addBlock(TestBlocks.test_block.getDefaultState(),random,world,chunkX,chunkY,20,60,10,10,20);

		int chance = random.nextInt(300);
		if(chance == 2){
			HouseGen.generateBuilding(this,world, random,chunkX,chunkY);
		}
		chance = random.nextInt(600);
		if(chance == 2){
			test3 test = new test3();
			test.generateBuilding(this,world, random,chunkX,chunkY);
		}
	}

	private void generateNether(Random random, int i, int j, World world) {
		// TODO Auto-generated method stub
		
	}
	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{	
		
		Block b1 = world.getBlockState(new BlockPos(x, y, z)).getBlock();

		if(b1.isAir(world,(new BlockPos(x, y, z))) || b1.isLeaves(world,(new BlockPos(x, y, z))))
		{
			//world.setBlock(new BlockPos(x, y, z), block, metadata, 2);
			world.setBlockState(new BlockPos(x, y, z),block.getDefaultState());
		}
	}

}
