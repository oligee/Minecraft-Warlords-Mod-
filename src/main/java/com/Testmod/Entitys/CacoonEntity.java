package com.Testmod.Entitys;

import java.util.ArrayList;
import java.util.List;

import com.Testmod.ThrownEntitys.EntityThrowWoodenSpear;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class CacoonEntity extends EntityCow
{
    
	int spawnTime= 0;
	int maxMaggotcount= 4;
	int currentMaggotCount=0;
	boolean playerNear = false;
    public CacoonEntity(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F, 1.3F);
        ((PathNavigateGround)this.getNavigator()).func_179690_a(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
        

    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.cow.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cow.hurt";
    }

    protected void playStepSound(BlockPos p_180429_1_, Block p_180429_2_)
    {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
        return Items.leather;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
        int k;

       
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() == Items.bucket && !player.capabilities.isCreativeMode)
        {
            if (itemstack.stackSize-- == 1)
            {
               
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket)))
            {
           
            }

            return true;
        }
        else
        {
            return super.interact(player);
        }
    }

    public CacoonEntity createChild(EntityAgeable ageable)
    {
        return new CacoonEntity(this.worldObj);
    }

    public float getEyeHeight()
    {
        return this.height;
    }
    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        List<Entity> entityList = new ArrayList<Entity>();
        AxisAlignedBB radius = new AxisAlignedBB( this.posX-10,this.posY-10,this.posZ-10,this.posX+10,this.posY+10,this.posZ+10);
		entityList = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,radius);
		for(Entity entity:entityList){
			if(entity instanceof EntityPlayer){
				playerNear = true;
			}
		}
		if(playerNear){
		System.out.println(spawnTime);
		if(spawnTime== 100){
			MaggotEntity maggot= new MaggotEntity(this.worldObj);
	        maggot.setPosition(this.posX,this.posY+2,this.posZ);
	        System.out.println(maggot.posX+" " + maggot.posY+" "+maggot.posZ);
	        if (!this.worldObj.isRemote){		
	        	  this.worldObj.spawnEntityInWorld(maggot);
	          	}

	        	spawnTime=0;
			}else{
				spawnTime++;
			}
			playerNear = false;
		}
}
    
}