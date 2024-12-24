package com.csl.cpuifabric.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawContext;

public class ColorPickerUtilClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            System.out.println("HudRenderCallback triggered!");
            System.out.println("HudRenderCallback triggered!");
            System.out.println("HudRenderCallback triggered!");
            System.out.println("HudRenderCallback triggered!");
            System.out.println("HudRenderCallback triggered!");
            drawLargeBlueRectangle(drawContext);
        });
    }

    private void drawLargeBlueRectangle(DrawContext drawContext) {
        RenderSystem.enableBlend(); // Enable blending for transparency
        RenderSystem.defaultBlendFunc(); // Set the default blending function

        // Get the screen width and height from DrawContext
        int screenWidth = drawContext.getScaledWindowWidth();
        int screenHeight = drawContext.getScaledWindowHeight();

        // Define the rectangle dimensions (a very large rectangle)
        int rectangleWidth = 300;  // Width of 300 pixels
        int rectangleHeight = 150; // Height of 150 pixels

        // Position it in the top-right corner
        int x1 = screenWidth - rectangleWidth - 10; // 10 pixels from the right edge
        int y1 = 10;                                // 10 pixels from the top edge
        int x2 = x1 + rectangleWidth;
        int y2 = y1 + rectangleHeight;

        // Use the drawContext instance to draw the rectangle
        drawContext.fill(x1, y1, x2, y2, 0xFF0000FF); // ARGB format: Blue color

        RenderSystem.disableBlend(); // Disable blending after drawing
    }
}
