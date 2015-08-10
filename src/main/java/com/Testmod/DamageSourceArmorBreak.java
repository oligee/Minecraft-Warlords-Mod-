package com.Testmod;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

public class DamageSourceArmorBreak extends EntityDamageSource {
public DamageSourceArmorBreak(String name, Entity entity) {
super(name, entity);
setDamageBypassesArmor();
}
}