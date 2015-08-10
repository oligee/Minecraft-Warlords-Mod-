package com.Testmod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.Testmod.Renders.RenderDiamondSpear;
import com.Testmod.Renders.RenderIronSpear;
import com.Testmod.Renders.RenderSpear;
import com.Testmod.Renders.RenderStoneSpear;
import com.Testmod.Renders.RenderWoodenSpear;
import com.Testmod.ThrownEntitys.EntityThrowDiamondSpear;
import com.Testmod.ThrownEntitys.EntityThrowIronSpear;
import com.Testmod.ThrownEntitys.EntityThrowSpear;
import com.Testmod.ThrownEntitys.EntityThrowStoneSpear;
import com.Testmod.ThrownEntitys.EntityThrowWoodenSpear;
import com.Testmod.init.blocks.TestBlocks;
import com.Testmod.init.item.TestItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders(){
		System.out.println("kapow");
		TestBlocks.registerRenders();
		TestItems.registerRenders();
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowStoneSpear.class, new RenderStoneSpear(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowIronSpear.class, new RenderIronSpear(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowDiamondSpear.class, new RenderDiamondSpear(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityThrowWoodenSpear.class, new RenderWoodenSpear(Minecraft.getMinecraft().getRenderManager()));
		
	}
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) {
		 
		return  (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntityFromContext(ctx));
	}
}