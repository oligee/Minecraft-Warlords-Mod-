package com.Testmod.init.blocks;

import com.Testmod.Reference;
import com.Testmod.Testmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestBlocks {
	
	public static Block test_block;
	public static Block wooden_warshield_block;
	public static Block stone_warshield_block;
	public static Block iron_warshield_block;
	public static Block diamond_warshield_block;
	
	//rendering blocks like in items class
	public static void init(){
		test_block = new blockTest(Material.sponge).setUnlocalizedName("test_block").setCreativeTab(Testmod.tabTest);
		wooden_warshield_block = new BlockWoodenWarshield(Material.sponge).setUnlocalizedName("wooden_warshield_block").setCreativeTab(Testmod.tabTest);
		stone_warshield_block = new BlockStoneWarshield(Material.sponge).setUnlocalizedName("stone_warshield_block").setCreativeTab(Testmod.tabTest);
		iron_warshield_block = new BlockIronWarshield(Material.sponge).setUnlocalizedName("iron_warshield_block").setCreativeTab(Testmod.tabTest);
		diamond_warshield_block = new BlockDiamondWarshield(Material.sponge).setUnlocalizedName("diamond_warshield_block").setCreativeTab(Testmod.tabTest);	
	}
	public static void register(){
		GameRegistry.registerBlock(test_block,test_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(wooden_warshield_block,wooden_warshield_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(iron_warshield_block,iron_warshield_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_warshield_block,stone_warshield_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(diamond_warshield_block,diamond_warshield_block.getUnlocalizedName().substring(5));
	}
	public static void registerRenders(){
		registerRender(test_block);
		registerRender(wooden_warshield_block);
		registerRender(stone_warshield_block);
		registerRender(iron_warshield_block);
		registerRender(diamond_warshield_block);
	}
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	}
}
