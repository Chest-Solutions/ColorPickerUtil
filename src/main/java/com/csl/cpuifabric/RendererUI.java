package com.csl.cpuifabric;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;

public class RendererUI {

    /**
     * Draws a blue rectangle on the screen.
     *
     * @param drawContext The DrawContext for rendering.
     * @param x1          The x-coordinate of the top-left corner.
     * @param y1          The y-coordinate of the top-left corner.
     * @param width       The width of the rectangle.
     * @param height      The height of the rectangle.
     * @param color       The ARGB color of the rectangle.
     */
    public void drawRectangle(DrawContext drawContext, int x1, int y1, int width, int height, int color) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        int x2 = x1 + width;
        int y2 = y1 + height;

        // Use DrawContext to fill the rectangle
        drawContext.fill(x1, y1, x2, y2, color);

        RenderSystem.disableBlend();
    }
}
