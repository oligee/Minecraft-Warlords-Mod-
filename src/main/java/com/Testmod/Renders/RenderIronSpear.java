package com.Testmod.Renders;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.Testmod.ThrownEntitys.EntityThrowSpear;

@SideOnly(Side.CLIENT)
public class RenderIronSpear extends RenderSpear{
private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/ironSpear.png");
private static final String __OBFID = "CL_00000978";

	public RenderIronSpear(RenderManager p_i46193_1_){
		
		super(p_i46193_1_);
		
	}
    @Override
    protected ResourceLocation getEntityTexture(EntityThrowSpear p_180550_1_)
    {
    return arrowTextures;
    }

}