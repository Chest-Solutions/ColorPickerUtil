package com.csl.cpuifabric;

import net.fabricmc.api.ClientModInitializer;

public class CpuifabricMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Register custom keybind for opening the color picker
        ModKeyBindings.registerKeybinds();
    }
}
