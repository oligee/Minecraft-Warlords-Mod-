package com.Testmod.Entitys;

import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.Testmod.Testmod;
import com.Testmod.ThrownEntitys.EntityThrowDiamondSpear;
import com.Testmod.ThrownEntitys.EntityThrowIronSpear;
import com.Testmod.ThrownEntitys.EntityThrowStoneSpear;
import com.Testmod.ThrownEntitys.EntityThrowWoodenSpear;

public class Entitys {
	public static void register(Testmod testmod){
		//spears 
		//testing colours too 
		int redColor = (255 << 16);
		int orangeColor = (255 << 16)+ (200 << 8);
		EntityRegistry.registerGlobalEntityID(EntityThrowWoodenSpear.class,"woodenSpear",160, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowWoodenSpear.class, "woodenSpear",160,testmod,128, 1, true);
	    EntityRegistry.registerGlobalEntityID(EntityThrowStoneSpear.class,"stoneSpear",161, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowStoneSpear.class, "stoneSpear",161,testmod,128, 1, true);
	    EntityRegistry.registerGlobalEntityID(EntityThrowIronSpear.class,"ironSpear",162, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowIronSpear.class, "ironSpear",162,testmod,128, 1, true);
	    EntityRegistry.registerGlobalEntityID(EntityThrowDiamondSpear.class,"diamondSpear",163, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowDiamondSpear.class, "diamondSpear",163,testmod,128, 1, true);
	    // mobs 
	    //fallen hero
	    EntityRegistry.registerGlobalEntityID(FallenHeroEntity.class, "Fallen Hero", 164, redColor,orangeColor);
	    EntityRegistry.registerModEntity(FallenHeroEntity.class, "Fallen Hero", 164,testmod,128, 1, true);
	    EntityRegistry.addSpawn(FallenHeroEntity.class, 1, 1, 1,EnumCreatureType.MONSTER);
	    // maggot
	    EntityRegistry.registerGlobalEntityID(MaggotEntity.class, "Maggot", 165, redColor,orangeColor);
	    EntityRegistry.registerModEntity(MaggotEntity.class, "Maggot", 165,testmod,128, 1, true);
	    EntityRegistry.addSpawn(MaggotEntity.class, 1, 1, 1,EnumCreatureType.MONSTER);
	    //cacoon
	    EntityRegistry.registerGlobalEntityID(CacoonEntity.class, "Cacoon", 166, redColor,orangeColor);
	    EntityRegistry.registerModEntity(CacoonEntity.class, "Cacoon", 166,testmod,128, 1, true);
	    EntityRegistry.addSpawn(CacoonEntity.class, 1, 1, 1,EnumCreatureType.MONSTER);
	}



}
