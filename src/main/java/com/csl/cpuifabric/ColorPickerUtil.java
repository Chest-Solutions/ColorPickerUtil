package com.csl.cpuifabric;

import com.csl.cpuifabric.RendererUI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;

public class ColorPickerUtil implements ClientModInitializer {

    private final RendererUI rendererUI = new RendererUI(); // Create an instance of RendererUI

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            renderHUD(drawContext);
        });
    }

    private void renderHUD(DrawContext drawContext) {
        int screenWidth = drawContext.getScaledWindowWidth();
        int screenHeight = drawContext.getScaledWindowHeight();

        // Define dimensions and position for the rectangle
        int width = 300;
        int height = 150;
        int x1 = screenWidth - width - 10; // Top-right corner
        int y1 = 10;

        // Call the RendererUI method to draw the rectangle
        rendererUI.drawRectangle(drawContext, x1, y1, width, height, 0xFF0000FF); // Blue color
    }
}
