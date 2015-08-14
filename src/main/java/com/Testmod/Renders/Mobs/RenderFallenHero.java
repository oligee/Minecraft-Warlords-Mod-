package com.Testmod.Renders.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFallenHero extends RenderZombie {
	private static final ResourceLocation heroTexture = new ResourceLocation("textures/entity/FallenHero.png");
	public RenderFallenHero(RenderManager renderManager) {
		super(renderManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		System.out.println("ping");
		return heroTexture;
	}

}
