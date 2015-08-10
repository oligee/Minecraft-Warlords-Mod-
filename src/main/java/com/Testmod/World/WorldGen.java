package com.Testmod.World;

import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGen {
	//setup
	public static void mainRegistry(){
		intialiseWorldGen();
	}
	//setting values
	public static void intialiseWorldGen(){
		registerWorldGen(new worldGenTestBlock(),1);
	}
	//registering the world .e.g like items in the item class
	public static void registerWorldGen(IWorldGenerator worldGenClass,int weightedProbability){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProbability);
		
	}	
}
