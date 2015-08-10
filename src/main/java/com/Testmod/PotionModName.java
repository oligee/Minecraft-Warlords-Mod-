package com.Testmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.TextureManager;


public class PotionModName extends Potion {

  public PotionModName(int par1, boolean par2, int par3)	
  {		
	 
     super(par1, null, par2, par3);
     this.setIconIndex(4,0);
     
  }


	
  	@Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc) { 
    	ResourceLocation bleedicon = new ResourceLocation("textures/effects.BLEEDICON.png");
    	ResourceLocation r = new ResourceLocation("textures/gui/container/inventory.png");
    	//Minecraft.getMinecraft().renderEngine.bindTexture(bleedicon);
    	Minecraft.getMinecraft().renderEngine.bindTexture(r);
    	ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
    	int Width = sr.getScaledWidth();
    	int Height = sr.getScaledHeight();
   
    	//mc.getMinecraft().currentScreen.drawTexturedModalRect(0, 0, 16,16, Width, Height);
     }
}