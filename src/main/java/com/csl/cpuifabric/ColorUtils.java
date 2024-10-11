package com.csl.cpuifabric;

public class ColorUtils {

    // Convert RGB to HEX
    public static String rgbToHex(int r, int g, int b) {
        return String.format("#%02x%02x%02x", r, g, b);
    }

    // Convert RGB to CMYK
    public static float[] rgbToCmyk(int r, int g, int b) {
        float rPrime = r / 255.0f;
        float gPrime = g / 255.0f;
        float bPrime = b / 255.0f;

        float k = 1 - Math.max(rPrime, Math.max(gPrime, bPrime));
        float c = (1 - rPrime - k) / (1 - k);
        float m = (1 - gPrime - k) / (1 - k);
        float y = (1 - bPrime - k) / (1 - k);

        return new float[] {c, m, y, k};
    }

    // Convert RGB to HSV
    public static float[] rgbToHsv(int r, int g, int b) {
        float rPrime = r / 255.0f;
        float gPrime = g / 255.0f;
        float bPrime = b / 255.0f;

        float cMax = Math.max(rPrime, Math.max(gPrime, bPrime));
        float cMin = Math.min(rPrime, Math.min(gPrime, bPrime));
        float delta = cMax - cMin;

        float h = 0, s = 0, v = cMax;

        if (delta != 0) {
            if (cMax == rPrime) {
                h = ((gPrime - bPrime) / delta) % 6;
            } else if (cMax == gPrime) {
                h = ((bPrime - rPrime) / delta) + 2;
            } else if (cMax == bPrime) {
                h = ((rPrime - gPrime) / delta) + 4;
            }

            s = delta / cMax;
        }

        return new float[] {h * 60, s * 100, v * 100};
    }

    // Convert RGB to HSL
    public static float[] rgbToHsl(int r, int g, int b) {
        float rPrime = r / 255.0f;
        float gPrime = g / 255.0f;
        float bPrime = b / 255.0f;

        float cMax = Math.max(rPrime, Math.max(gPrime, bPrime));
        float cMin = Math.min(rPrime, Math.min(gPrime, bPrime));
        float delta = cMax - cMin;

        float h = 0, s = 0, l = (cMax + cMin) / 2;

        if (delta != 0) {
            if (cMax == rPrime) {
                h = ((gPrime - bPrime) / delta) % 6;
            } else if (cMax == gPrime) {
                h = ((bPrime - rPrime) / delta) + 2;
            } else if (cMax == bPrime) {
                h = ((rPrime - gPrime) / delta) + 4;
            }

            s = delta / (1 - Math.abs(2 * l - 1));
        }

        return new float[] {h * 60, s * 100, l * 100};
    }
}
