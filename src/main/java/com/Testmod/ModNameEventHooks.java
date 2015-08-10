package com.Testmod;


import java.util.ArrayList;
import java.util.List;

import com.Testmod.init.item.TestItems;
import com.Testmod.DamageSourceArmorBreak;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.ExplosionEvent.Detonate;
import net.minecraftforge.event.world.ExplosionEvent.Start;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModNameEventHooks {



@SubscribeEvent
public void onEntityUpdate(LivingUpdateEvent event) 
{
     //entityLiving in fact refers to EntityLivingBase so to understand everything about this part go to EntityLivingBase instead
     if (event.entityLiving.isPotionActive(Testmod.customPotion)) 
     {
         if (event.entityLiving.worldObj.rand.nextInt(20) == 0) 
         {
        	
        	 event.entityLiving.attackEntityFrom(DamageSource.generic, 2);
        	

         }
     }
}

@SubscribeEvent
public void Event(LivingAttackEvent event) {
	float damageTaken;
	DamageSource source;

	if (event.entity instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.entity;
		 ItemStack equipped = player.getCurrentEquippedItem();
		 if(equipped != null){
			 damageTaken = event.ammount;
			 source = event.source;
			 if(source.getEntity() instanceof EntityMob ||source.getEntity() instanceof EntityPlayer ){
				 if (equipped.getItem()==TestItems.wooden_warshield){
					
					
					 		event.setCanceled(true);
					 		player.attackEntityFrom(DamageSource.magic,damageTaken/4);
					
					 	
				 }
				 if (equipped.getItem()==TestItems.wooden_waraxe){
					 	
					 		System.out.println("fuck");
					 		event.setCanceled(true);
					 		player.attackEntityFrom(DamageSource.starve,(float) (damageTaken*1.5));
					
				}
				 
			 }
		 }
	}
	
}
	




@SubscribeEvent
public void onWorldExplosion( Start event){
	List<Entity> entityList = new ArrayList<Entity>();

	World world = event.world;
	Explosion explosion = event.explosion;
	Entity who =  explosion.getExplosivePlacedBy();
	
	if (who instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) who;
		 ItemStack equipped = player.getCurrentEquippedItem();
		 if(equipped != null){
				 if (equipped.getItem()==TestItems.wooden_hammer||equipped.getItem()==TestItems.stone_hammer||equipped.getItem()==TestItems.iron_hammer||equipped.getItem()==TestItems.diamond_hammer){
					 
						AxisAlignedBB radius = new AxisAlignedBB( player.posX-10,player.posY-10,player.posZ-10,player.posX+10,player.posY+10,player.posZ+10);
						entityList = world.getEntitiesWithinAABBExcludingEntity(player,radius);
						for(Entity entity:entityList){
							System.out.println(entity);
							entity.attackEntityFrom(DamageSource.setExplosionSource(explosion),4);
						}
						event.setCanceled(true);
						explosion.doExplosionB(true);					
					 	
				 }

				 
		}
	}
	
	
}
@SideOnly(Side.CLIENT)
@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
public void onEvent(MouseEvent event)
{ 
    if (event.button == 0 && event.buttonstate)
    {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer thePlayer = mc.thePlayer;
        if (thePlayer != null)
        {
            ItemStack itemstack = thePlayer.getCurrentEquippedItem();
            IExtendedReach ieri;
            if (itemstack != null)
            {
                if (itemstack.getItem() instanceof IExtendedReach)
                {
                    ieri = (IExtendedReach) itemstack.getItem();
                } else
                {
                    ieri = null;
                }
   
                if (ieri != null)
                {
                    float reach = ieri.getReach();
                    MovingObjectPosition mov = getMouseOverExtended(reach); 
                      
                    if (mov != null)
                    {
                        if (mov.entityHit != null && mov.entityHit.hurtResistantTime == 0)
                        {
                            if (mov.entityHit != thePlayer )
                            {
                                Testmod.network.sendToServer(new MessageExtendedReachAttack(mov.entityHit.getEntityId()));
                            }
                        }
                    }
                }
            }
        }
    }
}
        
// This is mostly copied from the EntityRenderer#getMouseOver() method
public static MovingObjectPosition getMouseOverExtended(float dist)
{
    Minecraft mc = FMLClientHandler.instance().getClient();
    Entity theRenderViewEntity = mc.getRenderViewEntity();
    AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
            theRenderViewEntity.posX-0.5D,
            theRenderViewEntity.posY-0.0D,
            theRenderViewEntity.posZ-0.5D,
            theRenderViewEntity.posX+0.5D,
            theRenderViewEntity.posY+1.5D,
            theRenderViewEntity.posZ+0.5D
            );
    MovingObjectPosition returnMOP = null;
    if (mc.theWorld != null)
    {
        double var2 = dist;
        returnMOP = theRenderViewEntity.rayTrace(var2, 0);
        double calcdist = var2;
        Vec3 pos = theRenderViewEntity.getPositionEyes(0);
        var2 = calcdist;
        if (returnMOP != null)
        {
            calcdist = returnMOP.hitVec.distanceTo(pos);
        }
         
        Vec3 lookvec = theRenderViewEntity.getLook(0);
        Vec3 var8 = pos.addVector(lookvec.xCoord * var2, 
              lookvec.yCoord * var2, 
              lookvec.zCoord * var2);
        Entity pointedEntity = null;
        float var9 = 1.0F;
        @SuppressWarnings("unchecked")
        List<Entity> list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(
              theRenderViewEntity, 
              theViewBoundingBox.addCoord(
                    lookvec.xCoord * var2, 
                    lookvec.yCoord * var2, 
                    lookvec.zCoord * var2).expand(var9, var9, var9));
        double d = calcdist;
            
        for (Entity entity : list)
        {
            if (entity.canBeCollidedWith())
            {
                float bordersize = entity.getCollisionBorderSize();
                AxisAlignedBB aabb = new AxisAlignedBB(
                      entity.posX-entity.width/2, 
                      entity.posY, 
                      entity.posZ-entity.width/2, 
                      entity.posX+entity.width/2, 
                      entity.posY+entity.height, 
                      entity.posZ+entity.width/2);
                aabb.expand(bordersize, bordersize, bordersize);
                MovingObjectPosition mop0 = aabb.calculateIntercept(pos, var8);
                    
                if (aabb.isVecInside(pos))
                {
                    if (0.0D < d || d == 0.0D)
                    {
                        pointedEntity = entity;
                        d = 0.0D;
                    }
                } else if (mop0 != null)
                {
                    double d1 = pos.distanceTo(mop0.hitVec);
                        
                    if (d1 < d || d == 0.0D)
                    {
                        pointedEntity = entity;
                        d = d1;
                    }
                }
            }
        }
           
        if (pointedEntity != null && (d < calcdist || returnMOP == null))
        {
             returnMOP = new MovingObjectPosition(pointedEntity);
        }
    }
    return returnMOP;
}
}



