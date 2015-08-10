package com.Testmod.init.item.Hammers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlasterBolt extends EntityThrowable
{
	private EntityLivingBase igonedunit;
    public EntityBlasterBolt(World par1World)
    {
        super(par1World);
    }
    public EntityBlasterBolt(World par1World, EntityLivingBase igonedunit)
    {
        super(par1World, igonedunit);
        this.igonedunit = igonedunit;
    }
    public EntityBlasterBolt(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		//this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) 2, false);
	}
	@Override
	public void onUpdate(){
		this.worldObj.createExplosion(igonedunit, this.posX, this.posY, this.posZ, (float) 2, true);
		 this.setDead();
	}

}