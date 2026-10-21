package com.example.cheatmenu.modules;

import com.example.cheatmenu.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module {
    private static final double MULTIPLIER = 1.4;
    private static final double MAX_HORIZONTAL = 0.6;

    public Speed() {
        super("Speed", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        ClientPlayerEntity p = mc.player;
        if (!p.isOnGround() || p.isTouchingWater() || p.isInLava()) return;
        if (p.input.movementForward == 0 && p.input.movementSideways == 0) return;

        Vec3d v = p.getVelocity();
        double hx = v.x * MULTIPLIER;
        double hz = v.z * MULTIPLIER;
        double len = Math.sqrt(hx * hx + hz * hz);
        if (len > MAX_HORIZONTAL) {
            hx = hx / len * MAX_HORIZONTAL;
            hz = hz / len * MAX_HORIZONTAL;
        }
        p.setVelocity(hx, v.y, hz);
    }
}
