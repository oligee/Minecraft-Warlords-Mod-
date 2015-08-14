package com.Testmod.Renders.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderEndermite;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMaggot extends RenderEndermite {
	private static final ResourceLocation maggotTexture = new ResourceLocation("textures/entity/maggot.png");
	public RenderMaggot(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return maggotTexture;
	}

}
