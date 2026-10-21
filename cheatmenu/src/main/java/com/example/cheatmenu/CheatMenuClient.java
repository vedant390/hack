package com.example.cheatmenu;

import com.example.cheatmenu.gui.ClickGuiScreen;
import com.example.cheatmenu.gui.Hud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class CheatMenuClient implements ClientModInitializer {
    public static ModuleManager modules;
    private static KeyBinding openGui;

    @Override
    public void onInitializeClient() {
        modules = new ModuleManager();

        openGui = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.cheatmenu.open_gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "key.categories.misc"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGui.wasPressed()) {
                client.setScreen(new ClickGuiScreen());
            }
            if (client.player != null && client.world != null) {
                modules.tick();
            }
        });

        HudRenderCallback.EVENT.register(Hud::render);
    }
}
