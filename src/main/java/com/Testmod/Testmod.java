package com.Testmod;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com.Testmod.ThrownEntitys.EntityThrowDiamondSpear;
import com.Testmod.ThrownEntitys.EntityThrowIronSpear;
import com.Testmod.ThrownEntitys.EntityThrowSpear;
import com.Testmod.ThrownEntitys.EntityThrowStoneSpear;
import com.Testmod.ThrownEntitys.EntityThrowWoodenSpear;
import com.Testmod.World.WorldGen;
import com.Testmod.init.blocks.TestBlocks;
import com.Testmod.init.item.TestItems;
import com.Testmod.proxy.CommonProxy;
//values
@Mod(modid = Reference.MOD_ID,name = Reference.MOD_Name,version = Reference.VERSION)

public class Testmod {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static Potion customPotion;
	public static SimpleNetworkWrapper network;
	//setting up the game
	//before loading
	public static final TestTab tabTest = new TestTab("tabtest");
	private static final String NETWORK_CHANNEL_NAME = "channel";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		
		TestBlocks.init();
		TestBlocks.register();
		TestItems.init();
		TestItems.register();
		WorldGen.mainRegistry();
		
		
		
	    int redColor = (255 << 16);
	    int orangeColor = (255 << 16)+ (200 << 8);

	    //Register mob
	    EntityRegistry.registerGlobalEntityID(EntityThrowWoodenSpear.class,"woodenSpear",160, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowWoodenSpear.class, "woodenSpear",160,this,128, 1, true);
	    EntityRegistry.registerGlobalEntityID(EntityThrowStoneSpear.class,"stoneSpear",161, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowStoneSpear.class, "stoneSpear",161,this,128, 1, true);
	    EntityRegistry.registerGlobalEntityID(EntityThrowIronSpear.class,"ironSpear",162, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowIronSpear.class, "ironSpear",162,this,128, 1, true);
	    EntityRegistry.registerGlobalEntityID(EntityThrowDiamondSpear.class,"diamondSpear",163, redColor,orangeColor);
	    EntityRegistry.registerModEntity(EntityThrowDiamondSpear.class, "diamondSpear",163,this,128, 1, true);
	  
	    
		   Potion[] potionTypes = null;

		    for (Field f : Potion.class.getDeclaredFields()) {
		        f.setAccessible(true);
		        try {
		            if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
		                Field modfield = Field.class.getDeclaredField("modifiers");
		                modfield.setAccessible(true);
		                modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

		                potionTypes = (Potion[])f.get(null);
		                final Potion[] newPotionTypes = new Potion[256];
		                System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
		                f.set(null, newPotionTypes);
		            }
		        } catch (Exception e) {
		            System.err.println("Severe error, please report this to the mod author:");
		            System.err.println(e);
		        }
		    }

		    MinecraftForge.EVENT_BUS.register(new ModNameEventHooks());
		}
		
	
	//while loading
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{	
		//Minecraft.getMinecraft().renderEngine.bindTexture(par1ResourceLocation)
		proxy.registerRenders();
		customPotion = (new PotionModName(40, false, 0)).setPotionName("Bleed");
		//customPotion = (new PotionModName(40, false, 0)).setPotionName("Bleed").setIconIndex(1, 0);
		Testmod.network = NetworkRegistry.INSTANCE.newSimpleChannel(Testmod.NETWORK_CHANNEL_NAME);

		int packetId = 0;
		// register messages from client to server
		Testmod.network.registerMessage(MessageExtendedReachAttack.Handler.class, 
		      MessageExtendedReachAttack.class, packetId++, Side.SERVER);
		
	}
	//after loading
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
