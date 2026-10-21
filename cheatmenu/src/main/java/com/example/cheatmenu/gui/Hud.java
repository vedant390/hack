package com.example.cheatmenu.gui;

import com.example.cheatmenu.CheatMenuClient;
import com.example.cheatmenu.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

import java.util.Comparator;
import java.util.List;

public class Hud {
    public static void render(DrawContext ctx, RenderTickCounter tickCounter) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options.hudHidden || mc.getDebugHud().shouldShowDebugHud()) return;

        ctx.drawTextWithShadow(mc.textRenderer, "Cheat Menu", 4, 4, 0xFF55FFFF);

        List<Module> active = CheatMenuClient.modules.getModules().stream()
                .filter(Module::isEnabled)
                .sorted(Comparator.comparingInt((Module m) -> mc.textRenderer.getWidth(m.getName())).reversed())
                .toList();

        int screenWidth = ctx.getScaledWindowWidth();
        int y = 4;
        for (Module m : active) {
            int w = mc.textRenderer.getWidth(m.getName());
            ctx.drawTextWithShadow(mc.textRenderer, m.getName(), screenWidth - w - 4, y, 0xFF55FF55);
            y += 10;
        }
    }
}
