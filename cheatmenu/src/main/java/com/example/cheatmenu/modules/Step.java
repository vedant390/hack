package com.example.cheatmenu.modules;

import com.example.cheatmenu.Module;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;

public class Step extends Module {
    private static final double STEP_HEIGHT = 1.0;
    private static final double DEFAULT_STEP_HEIGHT = 0.6;

    public Step() {
        super("Step", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        EntityAttributeInstance attr = mc.player.getAttributeInstance(EntityAttributes.STEP_HEIGHT);
        if (attr != null) attr.setBaseValue(STEP_HEIGHT);
    }

    @Override
    protected void onDisable() {
        if (mc.player == null) return;
        EntityAttributeInstance attr = mc.player.getAttributeInstance(EntityAttributes.STEP_HEIGHT);
        if (attr != null) attr.setBaseValue(DEFAULT_STEP_HEIGHT);
    }
}
