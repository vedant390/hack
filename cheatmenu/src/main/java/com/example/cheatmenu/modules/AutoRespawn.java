package com.example.cheatmenu.modules;

import com.example.cheatmenu.Module;
import net.minecraft.client.gui.screen.DeathScreen;

public class AutoRespawn extends Module {
    public AutoRespawn() {
        super("AutoRespawn", Category.UTILITY);
    }

    @Override
    public void onTick() {
        if (mc.currentScreen instanceof DeathScreen && mc.player.isDead()) {
            mc.player.requestRespawn();
            mc.setScreen(null);
        }
    }
}
