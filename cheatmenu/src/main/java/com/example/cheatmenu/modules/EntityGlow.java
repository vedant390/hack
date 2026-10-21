package com.example.cheatmenu.modules;

import com.example.cheatmenu.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class EntityGlow extends Module {
    public EntityGlow() {
        super("EntityGlow", Category.VISUALS);
    }

    @Override
    public void onTick() {
        for (Entity e : mc.world.getEntities()) {
            if (e instanceof LivingEntity && e != mc.player) {
                e.setGlowing(true);
            }
        }
    }

    @Override
    protected void onDisable() {
        if (mc.world == null) return;
        for (Entity e : mc.world.getEntities()) {
            if (e instanceof LivingEntity && e != mc.player) {
                e.setGlowing(false);
            }
        }
    }
}
