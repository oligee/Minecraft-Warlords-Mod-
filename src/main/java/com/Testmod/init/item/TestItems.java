package com.Testmod.init.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.Testmod.Reference;
import com.Testmod.Testmod;
import com.Testmod.init.blocks.Blockwarshield;
import com.Testmod.init.blocks.TestBlocks;
//import com.Testmod.init.item.ItemDiamondSpear;
//import com.Testmod.init.item.ItemIronSpear;
//import com.Testmod.init.item.ItemStoneSpear;
import com.Testmod.init.item.Crossbow.ItemCrossbow;
import com.Testmod.init.item.Dagger.ItemDiamondDagger;
import com.Testmod.init.item.Dagger.ItemIronDagger;
import com.Testmod.init.item.Dagger.ItemStoneDagger;
import com.Testmod.init.item.Dagger.ItemWoodenDagger;
import com.Testmod.init.item.Greatsword.ItemDiamondGreatsword;
import com.Testmod.init.item.Greatsword.ItemIronGreatsword;
import com.Testmod.init.item.Greatsword.ItemStoneGreatsword;
import com.Testmod.init.item.Greatsword.ItemWoodenGreatsword;
import com.Testmod.init.item.Hammers.ItemDiamondHammer;
import com.Testmod.init.item.Hammers.ItemIronHammer;
import com.Testmod.init.item.Hammers.ItemStoneHammer;
import com.Testmod.init.item.Hammers.ItemWoodenHammer;
import com.Testmod.init.item.Rapier.ItemDiamondRapier;
import com.Testmod.init.item.Rapier.ItemIronRapier;
import com.Testmod.init.item.Rapier.ItemStoneRapier;
import com.Testmod.init.item.Rapier.ItemWoodenRapier;
import com.Testmod.init.item.Shield.ItemDiamondWarShield;
import com.Testmod.init.item.Shield.ItemIronWarShield;
import com.Testmod.init.item.Shield.ItemStoneWarShield;
import com.Testmod.init.item.Shield.ItemWoodenWarShield;
import com.Testmod.init.item.Spear.ItemDiamondSpear;
import com.Testmod.init.item.Spear.ItemIronSpear;
import com.Testmod.init.item.Spear.ItemStoneSpear;
import com.Testmod.init.item.Spear.ItemWoodenSpear;
import com.Testmod.init.item.Waraxe.ItemDiamondWaraxe;
import com.Testmod.init.item.Waraxe.ItemIronWaraxe;
import com.Testmod.init.item.Waraxe.ItemStoneWaraxe;
import com.Testmod.init.item.Waraxe.ItemWoodenWaraxe;
public class TestItems {
	//Weapon item set up
	public static Item wooden_dagger;
	public static Item iron_dagger;
	public static Item stone_dagger;
	public static Item diamond_dagger;
	public static Item wooden_rapier;
	public static Item stone_rapier;
	public static Item iron_rapier;
	public static Item diamond_rapier;
	public static Item wooden_hammer;
	public static Item stone_hammer;
	public static Item iron_hammer;
	public static Item diamond_hammer;
	public static Item wooden_waraxe;
	public static Item stone_waraxe;
	public static Item iron_waraxe;
	public static Item diamond_waraxe;
	public static Item wooden_greatsword;
	public static Item stone_greatsword;
	public static Item iron_greatsword;
	public static Item diamond_greatsword;
	public static Item cross_bow;
	public static Item wooden_spear;
	public static Item stone_spear;
	public static Item iron_spear;
	public static Item diamond_spear;
	public static Item wooden_warshield;
	public static Item stone_warshield;
	public static Item iron_warshield;
	public static Item diamond_warshield;
	//Setting weapons tools up e.g their stats 
	public static final Item.ToolMaterial woodenDagger  = EnumHelper.addToolMaterial("woodenDagger",1,200,2.0F,3.0F,30);
	public static final Item.ToolMaterial stoneDagger   = EnumHelper.addToolMaterial("stoneDagger",1,200,2.0F,4.0F,30);
	public static final Item.ToolMaterial ironDagger    = EnumHelper.addToolMaterial("ironDagger",1,200,2.0F,5.0F,30);
	public static final Item.ToolMaterial diamondDagger = EnumHelper.addToolMaterial("diamondDagger",1,200,2.0F,6F,30);
	
	public static final Item.ToolMaterial woodenRapier  = EnumHelper.addToolMaterial("woodenRapier",1,500,2.0F,2.0F,30);
	public static final Item.ToolMaterial stoneRapier   = EnumHelper.addToolMaterial("stoneRapier",1,500,2.0F,3.0F,30);
	public static final Item.ToolMaterial ironRapier    = EnumHelper.addToolMaterial("ironRapier",1,500,2.0F,4.0F,30);
	public static final Item.ToolMaterial diamondRapier = EnumHelper.addToolMaterial("diamondRapier",1,500,2.0F,5.0F,30);
	
	public static final Item.ToolMaterial woodenHammer  = EnumHelper.addToolMaterial("woodenHammer",1,500,2.0F,3.0F,30);
	public static final Item.ToolMaterial stoneHammer   = EnumHelper.addToolMaterial("stoneHammer",1,500,2.0F,4.0F,30);
	public static final Item.ToolMaterial ironHammer    = EnumHelper.addToolMaterial("ironHammer",1,500,2.0F,5.0F,30);
	public static final Item.ToolMaterial diamondHammer = EnumHelper.addToolMaterial("diamondHammer",1,500,2.0F,6.0F,30);
	
	public static final Item.ToolMaterial woodenWaraxe  = EnumHelper.addToolMaterial("woodenWaraxe",1,500,2.0F,4.0F,30);
	public static final Item.ToolMaterial stoneWaraxe   = EnumHelper.addToolMaterial("stoneWaraxe",1,500,2.0F,5.0F,30);
	public static final Item.ToolMaterial ironWaraxe    = EnumHelper.addToolMaterial("ironWaraxe",1,500,2.0F,6F,30);
	public static final Item.ToolMaterial diamondWaraxe = EnumHelper.addToolMaterial("diamondWaraxe",1,500,2.0F,7.0F,30);
	
	public static final Item.ToolMaterial woodenGreatsword  = EnumHelper.addToolMaterial("woodenGreatsword",1,500,2.0F,6.0F,30);
	public static final Item.ToolMaterial stoneGreatsword   = EnumHelper.addToolMaterial("stoneGreatsword",1,500,2.0F,8.0F,30);
	public static final Item.ToolMaterial ironGreatsword    = EnumHelper.addToolMaterial("ironGreatsword",1,500,2.0F,10.0F,30);
	public static final Item.ToolMaterial diamondGreatsword = EnumHelper.addToolMaterial("diamondGreatsword",1,500,2.0F,12.0F,30);
	
	public static final Item.ToolMaterial crossBow = EnumHelper.addToolMaterial("crossBow",1,500,2.0F,0.0F,30);
	
	public static final Item.ToolMaterial woodenSpear  = EnumHelper.addToolMaterial("woodenSpear",1,500,2.0F,2.0F,30);
	public static final Item.ToolMaterial stoneSpear   = EnumHelper.addToolMaterial("stoneSpear",1,500,2.0F,3.0F,30);
	public static final Item.ToolMaterial ironSpear    = EnumHelper.addToolMaterial("ironSpear",1,500,2.0F,4.0F,30);
	public static final Item.ToolMaterial diamondSpear = EnumHelper.addToolMaterial("diamondSpear",1,500,2.0F,5.0F,30);
	
	public static final Item.ToolMaterial woodenWarShield = EnumHelper.addToolMaterial("woodenWarShield",1,500,2.0F,0.0F,30);
	public static final Item.ToolMaterial stoneWarShield = EnumHelper.addToolMaterial("stoneWarShield",1,500,2.0F,0.0F,30);
	public static final Item.ToolMaterial ironWarShield = EnumHelper.addToolMaterial("ironWarShield",1,500,2.0F,0.0F,30);
	public static final Item.ToolMaterial diamondWarShield = EnumHelper.addToolMaterial("diamondWarShield",1,500,2.0F,0.0F,30);
	
	public static void init() {
		//Creating Weapons
       wooden_dagger = new ItemWoodenDagger(woodenDagger).setUnlocalizedName("wooden_dagger").setCreativeTab(Testmod.tabTest);
       iron_dagger = new ItemStoneDagger(ironDagger).setUnlocalizedName("iron_dagger").setCreativeTab(Testmod.tabTest);
       stone_dagger = new ItemIronDagger(stoneDagger).setUnlocalizedName("stone_dagger").setCreativeTab(Testmod.tabTest);
       diamond_dagger = new ItemDiamondDagger(diamondDagger).setUnlocalizedName("diamond_dagger").setCreativeTab(Testmod.tabTest);
       wooden_rapier = new ItemWoodenRapier(woodenRapier).setUnlocalizedName("wooden_rapier").setCreativeTab(Testmod.tabTest);
       stone_rapier = new ItemStoneRapier(stoneRapier).setUnlocalizedName("stone_rapier").setCreativeTab(Testmod.tabTest);
       iron_rapier = new ItemIronRapier(ironRapier).setUnlocalizedName("iron_rapier").setCreativeTab(Testmod.tabTest);
       diamond_rapier = new ItemDiamondRapier(diamondRapier).setUnlocalizedName("diamond_rapier").setCreativeTab(Testmod.tabTest);
       wooden_hammer = new ItemWoodenHammer(woodenHammer).setUnlocalizedName("wooden_hammer").setCreativeTab(Testmod.tabTest);
       stone_hammer = new ItemStoneHammer(stoneHammer).setUnlocalizedName("stone_hammer").setCreativeTab(Testmod.tabTest);
       iron_hammer = new ItemIronHammer(ironHammer).setUnlocalizedName("iron_hammer").setCreativeTab(Testmod.tabTest);
       diamond_hammer = new ItemDiamondHammer(diamondHammer).setUnlocalizedName("diamond_hammer").setCreativeTab(Testmod.tabTest);
       wooden_waraxe = new ItemWoodenWaraxe(woodenWaraxe).setUnlocalizedName("wooden_waraxe").setCreativeTab(Testmod.tabTest);
       stone_waraxe = new ItemStoneWaraxe(stoneWaraxe).setUnlocalizedName("stone_waraxe").setCreativeTab(Testmod.tabTest);
       iron_waraxe = new ItemIronWaraxe(ironWaraxe).setUnlocalizedName("iron_waraxe").setCreativeTab(Testmod.tabTest);
       diamond_waraxe = new ItemDiamondWaraxe(diamondWaraxe).setUnlocalizedName("diamond_waraxe").setCreativeTab(Testmod.tabTest);
       wooden_greatsword = new ItemWoodenGreatsword(woodenGreatsword).setUnlocalizedName("wooden_greatsword").setCreativeTab(Testmod.tabTest);
       stone_greatsword = new ItemStoneGreatsword(stoneGreatsword).setUnlocalizedName("stone_greatsword").setCreativeTab(Testmod.tabTest);
       iron_greatsword = new ItemIronGreatsword(ironGreatsword).setUnlocalizedName("iron_greatsword").setCreativeTab(Testmod.tabTest);
       diamond_greatsword = new ItemDiamondGreatsword(diamondGreatsword).setUnlocalizedName("diamond_greatsword").setCreativeTab(Testmod.tabTest);
       cross_bow = new ItemCrossbow(crossBow).setUnlocalizedName("cross_bow").setCreativeTab(Testmod.tabTest);
       wooden_spear = new ItemWoodenSpear(woodenSpear).setUnlocalizedName("wooden_spear").setCreativeTab(Testmod.tabTest);
       stone_spear = new ItemStoneSpear(stoneSpear).setUnlocalizedName("stone_spear").setCreativeTab(Testmod.tabTest);
       iron_spear = new ItemIronSpear(ironSpear).setUnlocalizedName("iron_spear").setCreativeTab(Testmod.tabTest);
       diamond_spear = new ItemDiamondSpear(diamondSpear).setUnlocalizedName("diamond_spear").setCreativeTab(Testmod.tabTest);
       wooden_warshield = new ItemWoodenWarShield(TestBlocks.wooden_warshield_block).setUnlocalizedName("wooden_warshield").setCreativeTab(Testmod.tabTest);
       stone_warshield = new ItemStoneWarShield(TestBlocks.stone_warshield_block).setUnlocalizedName("stone_warshield").setCreativeTab(Testmod.tabTest);
       iron_warshield = new ItemIronWarShield(TestBlocks.iron_warshield_block).setUnlocalizedName("iron_warshield").setCreativeTab(Testmod.tabTest);
       diamond_warshield = new ItemDiamondWarShield(TestBlocks.diamond_warshield_block).setUnlocalizedName("diamond_warshield").setCreativeTab(Testmod.tabTest);
       //Adding recipes 
       GameRegistry.addRecipe(new ItemStack(wooden_dagger),new Object[]{"B","S",'S',Items.stick,'B',Blocks.planks});
       GameRegistry.addRecipe(new ItemStack(stone_dagger),new Object[]{"R","S",'S',Items.stick,'R',Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_dagger),new Object[]{"I","S",'S',Items.stick,'I',Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_dagger),new Object[]{"D","S",'S',Items.stick,'D',Items.diamond});
       GameRegistry.addRecipe(new ItemStack(wooden_rapier),new Object[]{"B","B","S",'S',Items.stick,'B',Blocks.planks});
       GameRegistry.addRecipe(new ItemStack(stone_rapier),new Object[]{"R","R","S",'S',Items.stick,'R',Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_rapier),new Object[]{"I","I","S",'S',Items.stick,'I',Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_rapier),new Object[]{"D","D","S",'S',Items.stick,'D',Items.diamond});
       GameRegistry.addRecipe(new ItemStack(wooden_hammer),new Object[]{"BBB", " S ",'S',Items.stick, 'B', Blocks.planks});
       GameRegistry.addRecipe(new ItemStack(stone_hammer),new Object[]{"RRR", " S ",'S',Items.stick, 'R', Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_hammer),new Object[]{"III", " S ",'S',Items.stick, 'I', Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_hammer),new Object[]{"DDD", " S ",'S',Items.stick, 'D', Items.diamond});
       GameRegistry.addRecipe(new ItemStack(wooden_waraxe),new Object[]{"BBB", "DSD"," S ",'S',Items.stick, 'B', Blocks.planks});
       GameRegistry.addRecipe(new ItemStack(stone_waraxe),new Object[]{"RRR", "DSD"," S ",'S',Items.stick, 'R', Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_waraxe),new Object[]{"III", "DSD"," S ",'S',Items.stick, 'I', Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_waraxe),new Object[]{"DDD", "DSD"," S ",'S',Items.stick, 'D', Items.diamond});
       GameRegistry.addRecipe(new ItemStack(wooden_greatsword),new Object[]{"BBB","DSD",'S',Items.wooden_sword, 'B', Blocks.planks});
       GameRegistry.addRecipe(new ItemStack(stone_greatsword),new Object[]{"RRR","DSD",'S',Items.stone_sword, 'R', Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_greatsword),new Object[]{"III","DSD",'S',Items.iron_sword, 'I', Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_greatsword),new Object[]{"DDD","DSD",'S',Items.diamond_sword, 'D', Items.diamond});
       GameRegistry.addRecipe(new ItemStack(cross_bow),new Object[]{"WSS","WWS","WSS",'W',Items.string, 'D', Items.stick});
       GameRegistry.addRecipe(new ItemStack(wooden_spear),new Object[]{"S  "," S ","  S",'S',Items.stick,});
       GameRegistry.addRecipe(new ItemStack(stone_spear),new Object[]{"R  "," S ","  S",'S',Items.stick,'R',Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_spear),new Object[]{"I  "," S ","  S",'S',Items.stick,'I',Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_spear),new Object[]{"D  "," S ","  S",'S',Items.stick,'D',Items.diamond});
       GameRegistry.addRecipe(new ItemStack(wooden_warshield),new Object[]{" S ","SSS"," S ",'S',Items.stick,});
       GameRegistry.addRecipe(new ItemStack(stone_warshield),new Object[]{" S ","RRR"," S ",'S',Items.stick,'R',Blocks.cobblestone});
       GameRegistry.addRecipe(new ItemStack(iron_warshield),new Object[]{" S ","III"," S ",'S',Items.stick,'I',Items.iron_ingot});
       GameRegistry.addRecipe(new ItemStack(diamond_warshield),new Object[]{" S ","DDD"," S ",'S',Items.stick,'D',Items.diamond});
    }
	
	
	
	public static void register(){
	//tile name 
		//Setting up renders , using the json and png files
		GameRegistry.registerItem(wooden_dagger,wooden_dagger.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(stone_dagger,stone_dagger.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(iron_dagger,iron_dagger.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(diamond_dagger,diamond_dagger.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(wooden_rapier,wooden_rapier.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(stone_rapier,stone_rapier.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(iron_rapier,iron_rapier.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamond_rapier,diamond_rapier.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wooden_hammer,wooden_hammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(stone_hammer,stone_hammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(iron_hammer,iron_hammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamond_hammer,diamond_hammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wooden_waraxe,wooden_waraxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(stone_waraxe,stone_waraxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(iron_waraxe,iron_waraxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamond_waraxe,diamond_waraxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wooden_greatsword,wooden_greatsword.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(stone_greatsword,stone_greatsword.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(iron_greatsword,iron_greatsword.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(diamond_greatsword,diamond_greatsword.getUnlocalizedName().substring(5)); 
		GameRegistry.registerItem(cross_bow,cross_bow.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wooden_spear,wooden_spear.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(stone_spear,stone_spear.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(iron_spear,iron_spear.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamond_spear,diamond_spear.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(wooden_warshield,wooden_warshield.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(stone_warshield,stone_warshield.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(iron_warshield,iron_warshield.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamond_warshield,diamond_warshield.getUnlocalizedName().substring(5));
	}
	
	
	public static void registerRenders(){
		registerRender(wooden_dagger);
		registerRender(stone_dagger);
		registerRender(iron_dagger);
		registerRender(diamond_dagger);
		registerRender(wooden_rapier);
		registerRender(stone_rapier);
		registerRender(iron_rapier);
		registerRender(diamond_rapier);
		registerRender(wooden_hammer);
		registerRender(stone_hammer);
		registerRender(iron_hammer);
		registerRender(diamond_hammer);
		registerRender(wooden_waraxe);
		registerRender(stone_waraxe);
		registerRender(iron_waraxe);
		registerRender(diamond_waraxe);
		registerRender(wooden_greatsword);
		registerRender(stone_greatsword);
		registerRender(iron_greatsword);
		registerRender(diamond_greatsword);
		registerRender(wooden_spear);
		registerRender(stone_spear);
		registerRender(iron_spear);
		registerRender(diamond_spear);
		registerRender(wooden_warshield);
		registerRender(stone_warshield);
		registerRender(iron_warshield);
		registerRender(diamond_warshield);
		ModelBakery.addVariantName(cross_bow, new String[] {Reference.MOD_ID + ":cross_bow", Reference.MOD_ID + ":cross_bow_pulling_0"});
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(cross_bow,0,new ModelResourceLocation(Reference.MOD_ID + ":" + "cross_bow","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(cross_bow,1,new ModelResourceLocation(Reference.MOD_ID + ":" + "cross_bow_pulling_0","inventory"));
    }
    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
        
    
    }
}
