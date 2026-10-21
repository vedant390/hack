package com.example.cheatmenu.modules;

import com.example.cheatmenu.Module;
import net.minecraft.client.network.ClientPlayerEntity;

public class Fly extends Module {
    public Fly() {
        super("Fly", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        ClientPlayerEntity p = mc.player;
        p.getAbilities().allowFlying = true;
        p.getAbilities().setFlySpeed(0.05f);
    }

    @Override
    protected void onDisable() {
        ClientPlayerEntity p = mc.player;
        if (p == null) return;
        if (!p.isCreative() && !p.isSpectator()) {
            p.getAbilities().allowFlying = false;
            p.getAbilities().flying = false;
        }
        p.getAbilities().setFlySpeed(0.05f);
    }
}
