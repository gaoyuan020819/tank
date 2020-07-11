package com.gaoyuan.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {

    public static BufferedImage rotateImage(final BufferedImage target, final int degree) {

        int w = target.getWidth();
        int h = target.getHeight();
        int type = target.getColorModel().getTransparency();

        BufferedImage bufferedImage;
        Graphics2D graphics2D;

        bufferedImage = new BufferedImage(w, h, type);
        graphics2D = bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2D.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2D.drawImage(target, 0, 0, null);
        graphics2D.dispose();

        return bufferedImage;

    }
}
