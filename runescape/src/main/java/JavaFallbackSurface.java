import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;

@OriginalClass("client!ji")
public final class JavaFallbackSurface extends JavaSurface implements ImageProducer {

    @OriginalMember(owner = "client!ji", name = "B", descriptor = "Ljava/awt/Image;")
    public Image anImage2;

    @OriginalMember(owner = "client!ji", name = "J", descriptor = "Ljava/awt/Canvas;")
    public Canvas aCanvas4;

    @OriginalMember(owner = "client!ji", name = "D", descriptor = "Ljava/awt/image/ColorModel;")
    public ColorModel aColorModel1;

    @OriginalMember(owner = "client!ji", name = "F", descriptor = "Ljava/awt/image/ImageConsumer;")
    public ImageConsumer anImageConsumer1;

    @OriginalMember(owner = "client!ji", name = "removeConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
    @Override
    public synchronized void removeConsumer(@OriginalArg(0) ImageConsumer arg0) {
        if (arg0 == this.anImageConsumer1) {
            this.anImageConsumer1 = null;
        }
    }

    @OriginalMember(owner = "client!ji", name = "a", descriptor = "(IIIZLjava/awt/Graphics;III)V")
    @Override
    public void clip(@OriginalArg(2) int centerX, @OriginalArg(6) int centerY, @OriginalArg(1) int x, @OriginalArg(7) int y, @OriginalArg(0) int width, @OriginalArg(5) int height, @OriginalArg(4) Graphics graphics) {
        this.method4383(x, y, height, width);
        @Pc(18) Shape local18 = graphics.getClip();
        graphics.clipRect(centerX, centerY, width, height);
        graphics.drawImage(this.anImage2, centerX - x, -y + centerY, this.aCanvas4);
        graphics.setClip(local18);
    }

    @OriginalMember(owner = "client!ji", name = "addConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
    @Override
    public synchronized void addConsumer(@OriginalArg(0) ImageConsumer arg0) {
        this.anImageConsumer1 = arg0;
        arg0.setDimensions(super.width, super.height);
        arg0.setProperties(null);
        arg0.setColorModel(this.aColorModel1);
        arg0.setHints(14);
    }

    @OriginalMember(owner = "client!ji", name = "a", descriptor = "(ZIILjava/awt/Canvas;)V")
    @Override
    public void initialize(@OriginalArg(3) Canvas canvas, @OriginalArg(1) int width, @OriginalArg(2) int height) {
        super.height = height;
        this.aCanvas4 = canvas;
        super.width = width;
        super.raster = new int[super.width * super.height];
        this.aColorModel1 = new DirectColorModel(32, 16711680, 65280, 255);
        this.anImage2 = this.aCanvas4.createImage(this);
        this.method4384();
        this.aCanvas4.prepareImage(this.anImage2, this.aCanvas4);
        this.method4384();
        this.aCanvas4.prepareImage(this.anImage2, this.aCanvas4);
        this.method4384();
        this.aCanvas4.prepareImage(this.anImage2, this.aCanvas4);
    }

    @OriginalMember(owner = "client!ji", name = "a", descriptor = "(IIIZI)V")
    public synchronized void method4383(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
        if (this.anImageConsumer1 != null) {
            this.anImageConsumer1.setPixels(arg0, arg1, arg3, arg2, this.aColorModel1, super.raster, arg0 + arg1 * super.width, super.width);
            this.anImageConsumer1.imageComplete(2);
        }
    }

    @OriginalMember(owner = "client!ji", name = "startProduction", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
    @Override
    public void startProduction(@OriginalArg(0) ImageConsumer arg0) {
        this.addConsumer(arg0);
    }

    @OriginalMember(owner = "client!ji", name = "a", descriptor = "(I)V")
    public synchronized void method4384() {
        if (this.anImageConsumer1 != null) {
            this.anImageConsumer1.setPixels(0, 0, super.width, super.height, this.aColorModel1, super.raster, 0, super.width);
            this.anImageConsumer1.imageComplete(2);
        }
    }

    @OriginalMember(owner = "client!ji", name = "isConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)Z")
    @Override
    public synchronized boolean isConsumer(@OriginalArg(0) ImageConsumer arg0) {
        return arg0 == this.anImageConsumer1;
    }

    @OriginalMember(owner = "client!ji", name = "requestTopDownLeftRightResend", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
    @Override
    public void requestTopDownLeftRightResend(@OriginalArg(0) ImageConsumer arg0) {
    }
}
