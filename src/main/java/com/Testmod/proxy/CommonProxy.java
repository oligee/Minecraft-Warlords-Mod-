package com.Testmod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy {
	public void registerRenders(){
		
	}
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) 
	    {
	        return ctx.getServerHandler().playerEntity;
	    }

}
