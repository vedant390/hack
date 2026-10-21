package com.example.cheatmenu.gui;

import com.example.cheatmenu.CheatMenuClient;
import com.example.cheatmenu.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.List;

public class ClickGuiScreen extends Screen {
    private static final int PANEL_WIDTH = 110;
    private static final int ROW_HEIGHT = 14;
    private static final int GAP = 10;

    public ClickGuiScreen() {
        super(Text.literal("Cheat Menu"));
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    private int panelX(int index) {
        int total = Module.Category.values().length * (PANEL_WIDTH + GAP) - GAP;
        return (width - total) / 2 + index * (PANEL_WIDTH + GAP);
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        super.render(ctx, mouseX, mouseY, delta);

        Module.Category[] categories = Module.Category.values();
        for (int i = 0; i < categories.length; i++) {
            int x = panelX(i);
            int y = 30;
            List<Module> mods = CheatMenuClient.modules.getByCategory(categories[i]);

            // Header
            ctx.fill(x, y, x + PANEL_WIDTH, y + ROW_HEIGHT, 0xFF1E1E2E);
            ctx.drawTextWithShadow(textRenderer, categories[i].name(), x + 4, y + 3, 0xFF55FFFF);
            y += ROW_HEIGHT;

            for (Module m : mods) {
                boolean hover = mouseX >= x && mouseX < x + PANEL_WIDTH && mouseY >= y && mouseY < y + ROW_HEIGHT;
                int bg = m.isEnabled() ? (hover ? 0xFF2E7D32 : 0xFF388E3C) : (hover ? 0xFF3A3A4A : 0xFF2A2A3A);
                ctx.fill(x, y, x + PANEL_WIDTH, y + ROW_HEIGHT, bg);
                ctx.drawTextWithShadow(textRenderer, m.getName(), x + 4, y + 3, 0xFFFFFFFF);
                y += ROW_HEIGHT;
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Module.Category[] categories = Module.Category.values();
        for (int i = 0; i < categories.length; i++) {
            int x = panelX(i);
            int y = 30 + ROW_HEIGHT;
            for (Module m : CheatMenuClient.modules.getByCategory(categories[i])) {
                if (mouseX >= x && mouseX < x + PANEL_WIDTH && mouseY >= y && mouseY < y + ROW_HEIGHT) {
                    if (button == 0) m.toggle();
                    return true;
                }
                y += ROW_HEIGHT;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
