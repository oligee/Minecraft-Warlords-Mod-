package com.Testmod.ThrownEntitys;

import java.util.List;

import com.Testmod.Testmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.Testmod.init.item.TestItems;
import com.Testmod.init.item.Spear.ItemSpear;
import com.Testmod.init.item.Spear.ItemWoodenSpear;
public class EntityThrowStoneSpear extends EntityThrowSpear   implements IProjectile
{

    public EntityThrowStoneSpear(World worldIn)
    {
        super(worldIn);

    }

    public EntityThrowStoneSpear(World worldIn, double x, double y, double z,ItemWoodenSpear spear)
    {	
    	
        super(worldIn,  x, y, z, spear);

    }

    public EntityThrowStoneSpear(World worldIn, EntityLivingBase shooter, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_,ItemWoodenSpear spear)
    {
        super( worldIn,  shooter,  p_i1755_3_,  p_i1755_4_,  p_i1755_5_, spear);

    }
    
    public EntityThrowStoneSpear(World worldIn, EntityLivingBase shooter, float p_i1756_3_,ItemSpear spear)
    {	
    	
        super(worldIn,shooter,p_i1756_3_, spear);
       

    }

  }