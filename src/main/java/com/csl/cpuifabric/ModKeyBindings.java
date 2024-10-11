package com.csl.cpuifabric;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import com.csl.cpuifabric.ColorPickerScreen;

public class ModKeyBindings {
    public static KeyBinding colorPickerKey;

    public static void registerKeybinds() {
        // Initialize the keybinding for 'H'
        colorPickerKey = new KeyBinding(
                "key.cpuifabric.open",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.cpuifabric"
        );

        // Register the keybinding listener
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (colorPickerKey.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new ColorPickerScreen());
            }
        });
    }
}
