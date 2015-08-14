package com.Testmod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCacoon extends ModelBase {
    public  ModelRenderer bottomp5;
    public  ModelRenderer bottomp4;
    public  ModelRenderer bottomp3;
    public  ModelRenderer bottomp2;
    public  ModelRenderer bottomp1;
    public  ModelRenderer middle;
    public  ModelRenderer topp3;
    public  ModelRenderer topp2;
    public  ModelRenderer topp1;
    public ModelCacoon()
    {
      textureWidth = 80;
      textureHeight = 80;
      
      
      
      bottomp5 = new ModelRenderer(this, 0, 0);
      bottomp5.addBox(0F, 0F, 0F, 5, 1, 5);
      bottomp5.setRotationPoint(-2F, 23F, -3F);
      bottomp5.setTextureSize(80, 80);


      bottomp4 = new ModelRenderer(this, 0, 0);
      bottomp4.addBox(0F, 0F, 0F, 9, 1, 9);
      bottomp4.setRotationPoint(-4F, 22F, -5F);
      bottomp4.setTextureSize(80, 80);

      bottomp3 = new ModelRenderer(this, 0, 0);
      bottomp3.addBox(0F, 0F, 0F, 11, 1, 11);
      bottomp3.setRotationPoint(-5F, 21F, -6F);
      bottomp3.setTextureSize(80, 80);

      

      bottomp2 = new ModelRenderer(this, 0, 0);
      bottomp2.addBox(0F, 0F, 0F, 13, 2, 13);
      bottomp2.setRotationPoint(-6F, 19F, -7F);
      bottomp2.setTextureSize(80, 80);

      

      

      bottomp1 = new ModelRenderer(this, 0, 0);
      bottomp1.addBox(0F, 0F, 0F, 15, 3, 15);
      bottomp1.setRotationPoint(-7F, 16F, -8F);
      bottomp1.setTextureSize(80, 80);

      

      
      middle = new ModelRenderer(this, 0, 0);
      middle.addBox(0F, 0F, 0F, 17, 16, 17);
      middle.setRotationPoint(-8F, 0F, -9F);
      middle.setTextureSize(80, 80);

      

      topp3 = new ModelRenderer(this, 0, 0);
      topp3.addBox(0F, 0F, 0F, 15, 3, 15);
      topp3.setRotationPoint(-7F, -3F, -8F);
      topp3.setTextureSize(80, 80);

      

      topp2 = new ModelRenderer(this, 0, 0);
      topp2.addBox(0F, 0F, 0F, 13, 2, 13);
      topp2.setRotationPoint(-6F, -5.2F, -7F);
      topp2.setTextureSize(80, 80);

      
 
      topp1 = new ModelRenderer(this, 0, 0);
      topp1.addBox(-5F, 1F, -6F, 11, 1, 11);
      topp1.setRotationPoint(0F, -7F, 0F);
      topp1.setTextureSize(80, 80);


    }
    public void render(Entity entity, float time, float limbSwingDistance, float f2, float headYrotation, float headXrotation, float Ytrans)
    {
    //  super.render(entity, f, f1, f2, f3, f4, f5);
      this.setRotationAngles( time,  limbSwingDistance,  f2,  headYrotation, headXrotation,  Ytrans,entity);
      bottomp5.render(Ytrans);
      bottomp4.render(Ytrans);
      bottomp3.render(Ytrans);
      bottomp2.render(Ytrans);
      bottomp1.render(Ytrans);
      middle.render(Ytrans);
      topp3.render(Ytrans);
      topp2.render(Ytrans);
      topp1.render(Ytrans);
    }
    public void setRotationAngles(float time, float limbSwingDistance, float f2, float headYrotation, float headXrotation, float Ytrans,Entity entity)
    {
      super.setRotationAngles(time,  limbSwingDistance,  f2,  headYrotation, headXrotation,  Ytrans,entity);
    }
}
