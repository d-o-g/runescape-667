import com.jagex.Class67;
import com.jagex.IndexedImage;
import com.jagex.DepthBuffer;
import com.jagex.ParticleList;
import com.jagex.core.datastruct.Node2;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.util.Arrays;
import com.jagex.core.util.SystemTimer;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.FlipException;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.MemoryPool;
import com.jagex.graphics.OffscreenSurface;
import com.jagex.graphics.PointLight;
import com.jagex.graphics.Renderer;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Surface;
import com.jagex.graphics.TextureMetrics;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.math.ColourUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

@OriginalClass("client!iaa")
public final class JavaToolkit extends Toolkit {

    @OriginalMember(owner = "client!ed", name = "g", descriptor = "Lclient!sia;")
    public static final Deque objSprites = new Deque();

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(IILclient!d;ILjava/awt/Canvas;)Lclient!ha;")
    public static Toolkit create(@OriginalArg(4) Canvas canvas, @OriginalArg(2) TextureSource textureSource, @OriginalArg(0) int width, @OriginalArg(3) int height) {
        return new JavaToolkit(canvas, textureSource, width, height);
    }

    @OriginalMember(owner = "client!iaa", name = "pb", descriptor = "I")
    public int canvasWidth;

    @OriginalMember(owner = "client!iaa", name = "mb", descriptor = "Ljava/awt/Canvas;")
    public Canvas canvas;

    @OriginalMember(owner = "client!iaa", name = "Q", descriptor = "Lclient!cda;")
    public JavaSurface surface;

    @OriginalMember(owner = "client!iaa", name = "gb", descriptor = "I")
    public int canvasHeight;

    @OriginalMember(owner = "client!iaa", name = "A", descriptor = "I")
    public int sunX;

    @OriginalMember(owner = "client!iaa", name = "hb", descriptor = "I")
    public int depthWidth;

    @OriginalMember(owner = "client!iaa", name = "x", descriptor = "I")
    public int viewX2;

    @OriginalMember(owner = "client!iaa", name = "I", descriptor = "I")
    public int projectionCenterY;

    @OriginalMember(owner = "client!iaa", name = "K", descriptor = "I")
    public int mainSurfaceHeight;

    @OriginalMember(owner = "client!iaa", name = "kb", descriptor = "Lclient!du;")
    public JavaOffscreenSurface offscreenSurface;

    @OriginalMember(owner = "client!iaa", name = "nb", descriptor = "I")
    public int mainSurfaceWidth;

    @OriginalMember(owner = "client!iaa", name = "z", descriptor = "I")
    public int sunZ;

    @OriginalMember(owner = "client!iaa", name = "cb", descriptor = "[Lclient!wf;")
    public JavaThreadResource[] resources;

    @OriginalMember(owner = "client!iaa", name = "ib", descriptor = "I")
    public int vewY2;

    @OriginalMember(owner = "client!iaa", name = "O", descriptor = "[F")
    public float[] depthBuffer;

    @OriginalMember(owner = "client!iaa", name = "R", descriptor = "I")
    public int depthHeight;

    @OriginalMember(owner = "client!iaa", name = "S", descriptor = "I")
    public int sunY;

    @OriginalMember(owner = "client!iaa", name = "w", descriptor = "I")
    public int projectionCenterX;

    @OriginalMember(owner = "client!iaa", name = "P", descriptor = "[I")
    public int[] surfaceRaster;

    @OriginalMember(owner = "client!iaa", name = "jb", descriptor = "I")
    public int surfaceWidth;

    @OriginalMember(owner = "client!iaa", name = "Y", descriptor = "I")
    public int viewY1;

    @OriginalMember(owner = "client!iaa", name = "v", descriptor = "I")
    public int surfaceHeight;

    @OriginalMember(owner = "client!iaa", name = "M", descriptor = "[F")
    public float[] mainDepthBuffer;

    @OriginalMember(owner = "client!iaa", name = "E", descriptor = "I")
    public int viewX1;

    @OriginalMember(owner = "client!iaa", name = "qb", descriptor = "I")
    public int threadCount;

    @OriginalMember(owner = "client!iaa", name = "H", descriptor = "Lclient!st;")
    public Sprite sprite;

    @OriginalMember(owner = "client!iaa", name = "F", descriptor = "Z")
    public boolean stopped;

    @OriginalMember(owner = "client!iaa", name = "u", descriptor = "Z")
    public boolean colourTables;

    @OriginalMember(owner = "client!iaa", name = "N", descriptor = "Lclient!av;")
    public IterableHashTable<JavaSurface> surfaces;

    @OriginalMember(owner = "client!iaa", name = "L", descriptor = "I")
    public int clipY1;

    @OriginalMember(owner = "client!iaa", name = "C", descriptor = "I")
    public int projectionScaleY;

    @OriginalMember(owner = "client!iaa", name = "ab", descriptor = "I")
    public int ambient;

    @OriginalMember(owner = "client!iaa", name = "Z", descriptor = "I")
    public int clipX2;

    @OriginalMember(owner = "client!iaa", name = "B", descriptor = "I")
    public int zFar;

    @OriginalMember(owner = "client!iaa", name = "lb", descriptor = "I")
    public int textureSize;

    @OriginalMember(owner = "client!iaa", name = "y", descriptor = "I")
    public int clipY2;

    @OriginalMember(owner = "client!iaa", name = "D", descriptor = "I")
    public int sunIntensity;

    @OriginalMember(owner = "client!iaa", name = "V", descriptor = "I")
    public int clipX1;

    @OriginalMember(owner = "client!iaa", name = "bb", descriptor = "I")
    public int reverseSunIntensity;

    @OriginalMember(owner = "client!iaa", name = "U", descriptor = "Z")
    public boolean shrinkTextures;

    @OriginalMember(owner = "client!iaa", name = "fb", descriptor = "I")
    public int count;

    @OriginalMember(owner = "client!iaa", name = "T", descriptor = "I")
    public int modelCount;

    @OriginalMember(owner = "client!iaa", name = "X", descriptor = "I")
    public int zNear;

    @OriginalMember(owner = "client!iaa", name = "ob", descriptor = "I")
    public int projectionScaleX;

    @OriginalMember(owner = "client!iaa", name = "J", descriptor = "Lclient!dla;")
    public final ReferenceCache spriteCache;

    @OriginalMember(owner = "client!iaa", name = "G", descriptor = "I")
    public int textureId;

    @OriginalMember(owner = "client!iaa", name = "W", descriptor = "Lclient!dla;")
    public final ReferenceCache textureCache;

    @OriginalMember(owner = "client!iaa", name = "db", descriptor = "Lclient!eaa;")
    public JavaMatrix camera;

    @OriginalMember(owner = "client!iaa", name = "eb", descriptor = "I")
    public int lastTickTime;

    @OriginalMember(owner = "client!iaa", name = "<init>", descriptor = "(Lclient!d;)V")
    public JavaToolkit(@OriginalArg(0) TextureSource textureSource) {
        super(textureSource);
        this.stopped = false;
        this.colourTables = false;
        this.surfaces = new IterableHashTable<>(4);
        this.clipY1 = 0;
        this.projectionScaleY = 512;
        this.ambient = 75518;
        this.clipX2 = 0;
        this.zFar = 3500;
        this.textureSize = 128;
        this.clipY2 = 0;
        this.sunIntensity = 45823;
        this.clipX1 = 0;
        this.reverseSunIntensity = 78642;
        this.shrinkTextures = false;
        this.count = 0;
        this.modelCount = 0;
        this.zNear = 50;
        this.projectionScaleX = 512;
        this.spriteCache = new ReferenceCache(16);
        this.textureId = -1;

        try {
            this.textureCache = new ReferenceCache(256);
            this.camera = new JavaMatrix();
            this.allocateThreads(1);
            this.linkThreads(0);
            ColourUtils.init(true, true);
            this.colourTables = true;
            this.lastTickTime = (int) SystemTimer.safetime();
        } catch (@Pc(99) Throwable local99) {
            local99.printStackTrace();
            this.free();
            throw new RuntimeException("");
        }
    }

    @OriginalMember(owner = "client!iaa", name = "<init>", descriptor = "(Ljava/awt/Canvas;Lclient!d;II)V")
    public JavaToolkit(@OriginalArg(0) Canvas canvas, @OriginalArg(1) TextureSource textureSource, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        this(textureSource);

        try {
            this.addCanvas(canvas, width, height);
            this.setCanvas(canvas);
        } catch (@Pc(12) Throwable local12) {
            local12.printStackTrace();
            this.free();
            throw new RuntimeException("");
        }
    }

    @OriginalMember(owner = "client!iaa", name = "u", descriptor = "()V")
    @Override
    protected void stop() {
        if (this.colourTables) {
            ColourUtils.destroy(true, false);
            this.colourTables = false;
        }
        this.surface = null;
        this.canvas = null;
        this.canvasWidth = 0;
        this.canvasHeight = 0;
        this.surfaces = null;
        this.stopped = true;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIILclient!aa;II)V")
    @Override
    public void line(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2, @OriginalArg(4) int colour, @OriginalArg(5) int mode, @OriginalArg(6) ClippingMask mask, @OriginalArg(7) int maskX, @OriginalArg(8) int maskY) {
        @Pc(2) JavaClippingMask javaMask = (JavaClippingMask) mask;
        @Pc(5) int[] lineOffsets = javaMask.lineOffsets;
        @Pc(8) int[] lineWidths = javaMask.lineWidths;
        @Pc(18) int maxY = this.clipY1 > maskY ? this.clipY1 : maskY;
        @Pc(34) int minY = this.clipY2 < maskY + lineOffsets.length ? this.clipY2 : maskY + lineOffsets.length;
        x2 -= x1;
        y2 -= y1;
        if (x2 + y2 < 0) {
            x1 += x2;
            x2 = -x2;
            y1 += y2;
            y2 = -y2;
        }

        if (x2 > y2) {
            y1 <<= 0x10;
            y1 += 32768;

            @Pc(75) int shiftedY2 = y2 << 16;
            @Pc(85) int deltaY = (int) Math.floor((double) shiftedY2 / (double) x2 + 0.5D);

            x2 += x1;

            if (x1 < this.clipX1) {
                y1 += deltaY * (this.clipX1 - x1);
                x1 = this.clipX1;
            }
            if (x2 >= this.clipX2) {
                x2 = this.clipX2 - 1;
            }

            @Pc(118) int alpha = colour >>> 24;
            if (alpha == 255 && (mode == 0 || mode == 1)) {
                while (x1 <= x2) {
                    @Pc(136) int local136 = y1 >> 16;
                    @Pc(140) int local140 = local136 - maskY;
                    if (local136 >= maxY && local136 < minY) {
                        @Pc(154) int local154 = maskX + lineOffsets[local140];
                        if (x1 >= local154 && x1 < local154 + lineWidths[local140]) {
                            this.surfaceRaster[x1 + local136 * this.surfaceWidth] = colour;
                        }
                    }
                    y1 += deltaY;
                    x1++;
                }
                return;
            }
            if (mode == 1) {
                @Pc(215) int local215 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
                @Pc(136) int opacity = 256 - alpha;
                while (x1 <= x2) {
                    @Pc(140) int local140 = y1 >> 16;
                    @Pc(154) int local154 = local140 - maskY;
                    if (local140 >= maxY && local140 < minY) {
                        @Pc(242) int local242 = maskX + lineOffsets[local154];
                        if (x1 >= local242 && x1 < local242 + lineWidths[local154]) {
                            @Pc(261) int local261 = x1 + local140 * this.surfaceWidth;
                            @Pc(266) int local266 = this.surfaceRaster[local261];
                            local266 = ((local266 & 0xFF00FF) * opacity >> 8 & 0xFF00FF) + ((local266 & 0xFF00) * opacity >> 8 & 0xFF00);
                            this.surfaceRaster[local261] = local215 + local266;
                        }
                    }
                    y1 += deltaY;
                    x1++;
                }
                return;
            }
            if (mode == 2) {
                while (x1 <= x2) {
                    @Pc(140) int local140 = y1 >> 16;
                    @Pc(154) int local154 = local140 - maskY;
                    if (local140 >= maxY && local140 < minY) {
                        @Pc(242) int local242 = maskX + lineOffsets[local154];
                        if (x1 >= local242 && x1 < local242 + lineWidths[local154]) {
                            @Pc(261) int local261 = x1 + local140 * this.surfaceWidth;
                            @Pc(266) int local266 = this.surfaceRaster[local261];
                            @Pc(629) int local629 = colour + local266;
                            int i_27_ = (colour & 0xff00ff) + (local266 & 0xff00ff);
                            local266 = (i_27_ & 0x1000100) + (local629 - i_27_ & 0x10000);
                            this.surfaceRaster[local261] = local629 - local266 | local266 - (local266 >>> 8);
                        }
                    }
                    y1 += deltaY;
                    x1++;
                }
                return;
            }
            throw new IllegalArgumentException();
        } else {
            x1 <<= 0x10;
            x1 += 32768;
            @Pc(415) int local415 = x2 << 16;
            @Pc(85) int local85 = (int) Math.floor((double) local415 / (double) y2 + 0.5D);
            y2 += y1;
            if (y1 < maxY) {
                x1 += local85 * (maxY - y1);
                y1 = maxY;
            }
            if (y2 >= minY) {
                y2 = minY - 1;
            }
            @Pc(118) int local118 = colour >>> 24;
            if (local118 == 255 && (mode == 0 || mode == 1)) {
                while (y1 <= y2) {
                    @Pc(136) int local136 = x1 >> 16;
                    @Pc(140) int local140 = y1 - maskY;
                    @Pc(154) int local154 = maskX + lineOffsets[local140];
                    if (local136 >= this.clipX1 && local136 < this.clipX2 && local136 >= local154 && local136 < local154 + lineWidths[local140]) {
                        this.surfaceRaster[local136 + y1 * this.surfaceWidth] = colour;
                    }
                    x1 += local85;
                    y1++;
                }
            } else if (mode == 1) {
                @Pc(215) int local215 = ((colour & 0xFF00FF) * local118 >> 8 & 0xFF00FF) + ((colour & 0xFF00) * local118 >> 8 & 0xFF00) + (local118 << 24);
                @Pc(136) int local136 = 256 - local118;
                while (y1 <= y2) {
                    @Pc(140) int local140 = x1 >> 16;
                    @Pc(154) int local154 = y1 - maskY;
                    @Pc(242) int local242 = maskX + lineOffsets[local154];
                    if (local140 >= this.clipX1 && local140 < this.clipX2 && local140 >= local242 && local140 < local242 + lineWidths[local154]) {
                        @Pc(261) int local261 = local140 + y1 * this.surfaceWidth;
                        @Pc(266) int local266 = this.surfaceRaster[local261];
                        @Pc(629) int local629 = ((local266 & 0xFF00FF) * local136 >> 8 & 0xFF00FF) + ((local266 & 0xFF00) * local136 >> 8 & 0xFF00);
                        this.surfaceRaster[local140 + y1 * this.surfaceWidth] = local215 + local629;
                    }
                    x1 += local85;
                    y1++;
                }
            } else if (mode == 2) {
                while (y1 <= y2) {
                    @Pc(140) int local140 = x1 >> 16;
                    @Pc(154) int local154 = y1 - maskY;
                    @Pc(242) int local242 = maskX + lineOffsets[local154];
                    if (local140 >= this.clipX1 && local140 < this.clipX2 && local140 >= local242 && local140 < local242 + lineWidths[local154]) {
                        @Pc(261) int local261 = local140 + y1 * this.surfaceWidth;
                        @Pc(266) int local266 = this.surfaceRaster[local261];
                        @Pc(629) int local629 = colour + local266;
                        int i_45_ = (colour & 0xff00ff) + (local266 & 0xff00ff);
                        local266 = (i_45_ & 0x1000100) + (local629 - i_45_ & 0x10000);
                        this.surfaceRaster[local261] = local629 - local266 | local266 - (local266 >>> 8);
                    }
                    x1 += local85;
                    y1++;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "xa", descriptor = "(F)V")
    @Override
    public void xa(@OriginalArg(0) float globalAmbient) {
        this.ambient = (int) (globalAmbient * 65535.0F);
    }

    @OriginalMember(owner = "client!iaa", name = "M", descriptor = "()I")
    @Override
    public int M() {
        @Pc(2) int count = this.modelCount;
        this.modelCount = 0;
        return count;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIII)V")
    @Override
    public void strongLine(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2, @OriginalArg(4) int colour, @OriginalArg(5) int strength, @OriginalArg(6) int mode) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        @Pc(6) Rasterizer rasterizer = resource.rasterizer;
        @Pc(10) int width = x2 - x1;
        @Pc(14) int height = y2 - y1;
        @Pc(22) int absWidth = width >= 0 ? width : -width;
        @Pc(30) int absHeight = height >= 0 ? height : -height;
        @Pc(32) int minDimension = absWidth;
        if (absWidth < absHeight) {
            minDimension = absHeight;
        }
        if (minDimension == 0) {
            return;
        }
        @Pc(47) int deltaX = (width << 16) / minDimension;
        @Pc(53) int deltaY = (height << 16) / minDimension;
        width += deltaX >> 16;
        height += deltaY >> 16;
        if (deltaY <= deltaX) {
            deltaX = -deltaX;
        } else {
            deltaY = -deltaY;
        }
        @Pc(81) int strongX1 = strength * deltaY >> 17;
        @Pc(89) int strongX2 = strength * deltaY + 1 >> 17;
        @Pc(95) int strongY1 = strength * deltaX >> 17;
        @Pc(103) int strongY2 = strength * deltaX + 1 >> 17;
        @Pc(108) int centerX = x1 - rasterizer.offsetX();
        @Pc(113) int centerY = y1 - rasterizer.offsetY();
        @Pc(117) int lineX1 = centerX + strongX1;
        @Pc(121) int lineX2 = centerX - strongX2;
        @Pc(127) int lineX3 = centerX + width - strongX2;
        @Pc(133) int lineX4 = centerX + width + strongX1;
        @Pc(137) int lineY1 = centerY + strongY1;
        @Pc(141) int lineY2 = centerY - strongY2;
        @Pc(147) int lineY3 = centerY + height - strongY2;
        @Pc(153) int lineY4 = centerY + height + strongY1;
        if (mode == 0) {
            rasterizer.alpha = 0;
        } else if (mode == 1) {
            rasterizer.alpha = 255 - (colour >>> 24);
        } else {
            throw new IllegalArgumentException();
        }
        this.C(false);
        rasterizer.clamp = lineX1 < 0 || lineX1 > rasterizer.width || lineX2 < 0 || lineX2 > rasterizer.width || lineX3 < 0 || lineX3 > rasterizer.width;
        rasterizer.renderFlatTriangleRgb((float) lineY1, (float) lineY2, (float) lineY3, (float) lineX1, (float) lineX2, (float) lineX3, 100.0F, 100.0F, 100.0F, colour);
        rasterizer.clamp = lineX1 < 0 || lineX1 > rasterizer.width || lineX3 < 0 || lineX3 > rasterizer.width || lineX4 < 0 || lineX4 > rasterizer.width;
        rasterizer.renderFlatTriangleRgb((float) lineY1, (float) lineY3, (float) lineY4, (float) lineX1, (float) lineX3, (float) lineX4, 100.0F, 100.0F, 100.0F, colour);
        this.C(true);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Ljava/awt/Canvas;)V")
    @Override
    public void setCanvas(@OriginalArg(0) Canvas canvas) {
        if (canvas != null) {
            @Pc(10) JavaSurface surface = this.surfaces.get(canvas.hashCode());
            if (surface == null) {
                return;
            }

            this.canvas = canvas;

            @Pc(18) Dimension dimension = canvas.getSize();
            this.canvasWidth = dimension.width;
            this.canvasHeight = dimension.height;
            this.surface = surface;

            if (this.offscreenSurface == null) {
                this.surfaceRaster = surface.raster;
                this.surfaceWidth = surface.width;
                this.surfaceHeight = surface.height;

                if (this.surfaceWidth != this.depthWidth || this.surfaceHeight != this.depthHeight) {
                    this.mainSurfaceWidth = this.depthWidth = this.surfaceWidth;
                    this.mainSurfaceHeight = this.depthHeight = this.surfaceHeight;
                    this.mainDepthBuffer = this.depthBuffer = new float[this.depthWidth * this.depthHeight];
                }

                this.reset();
            }
        } else {
            this.canvas = null;
            this.surface = null;

            if (this.offscreenSurface == null) {
                this.surfaceRaster = null;
                this.surfaceWidth = this.surfaceHeight = 1;
                this.depthWidth = this.depthHeight = 1;
                this.reset();
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIIII)V")
    public void method3783(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
        if (arg0 < this.clipX1 || arg0 >= this.clipX2) {
            return;
        }
        @Pc(18) int local18 = arg0 + arg1 * this.surfaceWidth;
        @Pc(22) int local22 = arg3 >>> 24;
        @Pc(26) int local26 = arg4 + arg5;
        @Pc(30) int local30 = arg6 % local26;
        @Pc(44) int local44;
        if (local22 == 255 && true) {
            local44 = 0;
            while (local44 < arg2) {
                if (arg1 + local44 >= this.clipY1 && arg1 + local44 < this.clipY2 && local30 < arg4) {
                    this.surfaceRaster[local18 + local44 * this.surfaceWidth] = arg3;
                }
                local44++;
                local30++;
                local30 %= local26;
            }
            return;
        }
        @Pc(114) int local114 = ((arg3 & 0xFF00FF) * local22 >> 8 & 0xFF00FF) + ((arg3 & 0xFF00) * local22 >> 8 & 0xFF00) + (local22 << 24);
        local44 = 256 - local22;
        @Pc(120) int local120 = 0;
        while (local120 < arg2) {
            if (arg1 + local120 >= this.clipY1 && arg1 + local120 < this.clipY2 && local30 < arg4) {
                @Pc(147) int local147 = local18 + local120 * this.surfaceWidth;
                @Pc(152) int local152 = this.surfaceRaster[local147];
                @Pc(172) int local172 = ((local152 & 0xFF00FF) * local44 >> 8 & 0xFF00FF) + ((local152 & 0xFF00) * local44 >> 8 & 0xFF00);
                this.surfaceRaster[local147] = local114 + local172;
            }
            local120++;
            local30++;
            local30 %= local26;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "ya", descriptor = "()V")
    @Override
    public void ya() {
        if (this.clipX1 == 0 && this.clipX2 == this.surfaceWidth && this.clipY1 == 0 && this.clipY2 == this.surfaceHeight) {
            @Pc(25) int length = this.depthBuffer.length;
            @Pc(31) int iter = length - (length & 0x7);
            @Pc(33) int pointer = 0;

            while (pointer < iter) {
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
                this.depthBuffer[pointer++] = 2.14748365E9F;
            }

            while (pointer < length) {
                this.depthBuffer[pointer++] = 2.14748365E9F;
            }
        } else {
            @Pc(25) int deltaX = this.clipX2 - this.clipX1;
            @Pc(31) int deltaY = this.clipY2 - this.clipY1;
            @Pc(33) int width = this.surfaceWidth - deltaX;
            @Pc(124) int start = this.clipX1 + this.clipY1 * this.surfaceWidth;
            @Pc(128) int main = deltaX >> 3;
            @Pc(132) int extra = deltaX & 0x7;

            deltaX = start - 1;

            for (@Pc(139) int i = -deltaY; i < 0; i++) {
                if (main > 0) {
                    @Pc(144) int iter = main;

                    do {
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        iter--;
                    } while (iter > 0);
                }

                if (extra > 0) {
                    @Pc(144) int iter = extra;

                    do {
                        deltaX++;
                        this.depthBuffer[deltaX] = 2.14748365E9F;
                        iter--;
                    } while (iter > 0);
                }

                deltaX += width;
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!gaa;)V")
    @Override
    public void swapSurface(@OriginalArg(0) OffscreenSurface surface) {
        @Pc(2) JavaOffscreenSurface javaSurface = (JavaOffscreenSurface) surface;
        this.surfaceWidth = javaSurface.width;
        this.surfaceHeight = javaSurface.height;
        this.surfaceRaster = javaSurface.raster;
        this.offscreenSurface = javaSurface;
        this.depthWidth = javaSurface.width;
        this.depthHeight = javaSurface.height;
        this.depthBuffer = javaSurface.depthBuffer;
        this.reset();
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "()Z")
    @Override
    public boolean method7983() {
        return true;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!lk;I)V")
    @Override
    public void renderOrtho(@OriginalArg(0) ParticleList particleList, @OriginalArg(1) int zoom) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        @Pc(7) Node2 sentinel = particleList.particles.sentinel;

        for (@Pc(10) Node2 node = sentinel.next2; node != sentinel; node = node.next2) {
            @Pc(14) Particle particle = (Particle) node;
            @Pc(19) int x = particle.x >> 12;
            @Pc(24) int y = particle.y >> 12;
            @Pc(29) int z = particle.z >> 12;
            @Pc(54) float depth = this.camera.tz + (this.camera.e3_1 * (float) x) + (this.camera.e3_2 * (float) y) + (this.camera.e3_3 * (float) z);
            if (depth < (float) this.zNear || depth > (float) resource.fogPlane) {
                continue;
            }

            @Pc(106) int px = this.projectionCenterX + (int) (((float) this.projectionScaleX * (this.camera.tx + (this.camera.e1_1 * (float) x) + (this.camera.e1_2 * (float) y) + (this.camera.e1_3 * (float) z))) / (float) zoom);
            @Pc(142) int py = this.projectionCenterY + (int) (((float) this.projectionScaleY * (this.camera.ty + (this.camera.e2_1 * (float) x) + (this.camera.e2_2 * (float) y) + (this.camera.e2_3 * (float) z))) / (float) zoom);
            if (px >= this.clipX1 && px <= this.clipX2 && py >= this.clipY1 && py <= this.clipY2) {
                if (depth == 0.0F) {
                    depth = 1.0F;
                }
                this.render(particle, px, py, (int) depth, ((particle.size * this.projectionScaleX) >> 12) / zoom);
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!up;IIII)V")
    public void render(@OriginalArg(0) Particle particle, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int z, @OriginalArg(4) int size) {
        @Pc(2) int texture = particle.texture;
        @Pc(8) int doubleSize = size << 1;
        if (texture == -1) {
            this.method3790(x, y, z, size, particle.colour, 1);
            return;
        }

        if (this.textureId != texture) {
            @Pc(34) Sprite sprite = (Sprite) this.spriteCache.get(texture);
            if (sprite == null) {
                @Pc(40) int[] data = this.getArgbTexture(texture);
                if (data == null) {
                    return;
                }

                @Pc(54) int textureSize = this.smallTexture(texture) ? 64 : this.textureSize;
                sprite = this.createSprite(textureSize, textureSize, textureSize, data);
                this.spriteCache.put(sprite, texture);
            }

            this.textureId = texture;
            this.sprite = sprite;
        }

        doubleSize++;
        ((JavaSprite) this.sprite).method8208(x - size, y - size, z, doubleSize, doubleSize, 0, particle.colour, 1);
    }

    @OriginalMember(owner = "client!iaa", name = "F", descriptor = "(II)V")
    @Override
    public void F(@OriginalArg(0) int x, @OriginalArg(1) int y) {
        @Pc(6) int surfaceOffset = (y * this.surfaceWidth) + x;
        @Pc(13) int depthOffset = (y * this.depthWidth) + x;
        if (surfaceOffset == 0 && depthOffset == 0) {
            return;
        }

        @Pc(24) int[] raster = this.surfaceRaster;
        @Pc(27) float[] depths = this.depthBuffer;

        if (surfaceOffset < 0) {
            @Pc(34) int length = raster.length + surfaceOffset;
            Arrays.copy(raster, -surfaceOffset, raster, 0, length);
        } else if (surfaceOffset > 0) {
            @Pc(34) int length = raster.length - surfaceOffset;
            Arrays.copy(raster, 0, raster, surfaceOffset, length);
        }

        if (depthOffset < 0) {
            @Pc(34) int length = depths.length + depthOffset;
            Arrays.copy(depths, -depthOffset, depths, 0, length);
        } else if (depthOffset > 0) {
            @Pc(34) int length = depths.length - depthOffset;
            Arrays.copy(depths, 0, depths, depthOffset, length);
        }
    }

    @OriginalMember(owner = "client!iaa", name = "g", descriptor = "()Z")
    public boolean stopped() {
        return this.stopped;
    }

    @OriginalMember(owner = "client!iaa", name = "za", descriptor = "(IIIII)V")
    @Override
    protected void za(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int radius, @OriginalArg(3) int colour, @OriginalArg(4) int mode) {
        if (radius < 0) {
            radius = -radius;
        }

        @Pc(8) int y1 = y - radius;
        if (y1 < this.clipY1) {
            y1 = this.clipY1;
        }

        @Pc(21) int y2 = y + radius + 1;
        if (y2 > this.clipY2) {
            y2 = this.clipY2;
        }

        @Pc(30) int currY = y1;
        @Pc(34) int squareRadius = radius * radius;
        @Pc(36) int width = 0;
        @Pc(40) int local40 = y - y1;
        @Pc(44) int local44 = local40 * local40;
        @Pc(48) int local48 = local44 - local40;
        if (y > y2) {
            y = y2;
        }
        @Pc(57) int alpha = colour >>> 24;

        if (mode == 0 || (mode == 1 && alpha == 255)) {
            while (currY < y) {
                while (local48 <= squareRadius || local44 <= squareRadius) {
                    local44 += width + width;
                    local48 += width++ + width;
                }

                @Pc(98) int x1 = x + 1 - width;
                if (x1 < this.clipX1) {
                    x1 = this.clipX1;
                }

                @Pc(109) int x2 = x + width;
                if (x2 > this.clipX2) {
                    x2 = this.clipX2;
                }

                @Pc(123) int pixel = x1 + (currY * this.surfaceWidth);
                for (@Pc(125) int currX = x1; currX < x2; currX++) {
                    this.surfaceRaster[pixel++] = colour;
                }

                currY++;
                local44 -= local40-- + local40;
                local48 -= local40 + local40;
            }

            width = radius;
            local40 = currY - y;
            local48 = local40 * local40 + squareRadius;
            local44 = local48 - radius;
            local48 -= local40;

            while (currY < y2) {
                while (local48 > squareRadius && local44 > squareRadius) {
                    local48 -= width-- + width;
                    local44 -= width + width;
                }

                @Pc(98) int x1 = x - width;
                if (x1 < this.clipX1) {
                    x1 = this.clipX1;
                }

                @Pc(109) int x2 = x + width;
                if (x2 > this.clipX2 - 1) {
                    x2 = this.clipX2 - 1;
                }

                @Pc(123) int pixel = x1 + (currY * this.surfaceWidth);
                for (@Pc(125) int currX = x1; currX <= x2; currX++) {
                    this.surfaceRaster[pixel++] = colour;
                }

                currY++;
                local48 += local40 + local40;
                local44 += local40++ + local40;
            }
        } else {
            @Pc(287) int local287 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
            @Pc(98) int opacity = 256 - alpha;

            while (currY < y) {
                while (local48 <= squareRadius || local44 <= squareRadius) {
                    local44 += width + width;
                    local48 += width++ + width;
                }

                @Pc(109) int x1 = x + 1 - width;
                if (x1 < this.clipX1) {
                    x1 = this.clipX1;
                }

                @Pc(123) int x2 = x + width;
                if (x2 > this.clipX2) {
                    x2 = this.clipX2;
                }

                @Pc(125) int pixel = x1 + currY * this.surfaceWidth;
                for (@Pc(346) int currX = x1; currX < x2; currX++) {
                    @Pc(352) int local352 = this.surfaceRaster[pixel];
                    @Pc(372) int local372 = ((local352 & 0xFF00FF) * opacity >> 8 & 0xFF00FF) + ((local352 & 0xFF00) * opacity >> 8 & 0xFF00);
                    this.surfaceRaster[pixel++] = local287 + local372;
                }

                currY++;
                local44 -= local40-- + local40;
                local48 -= local40 + local40;
            }

            width = radius;
            local40 = -local40;
            local48 = local40 * local40 + squareRadius;
            local44 = local48 - radius;
            local48 -= local40;

            while (currY < y2) {
                while (local48 > squareRadius && local44 > squareRadius) {
                    local48 -= width-- + width;
                    local44 -= width + width;
                }

                @Pc(109) int x1 = x - width;
                if (x1 < this.clipX1) {
                    x1 = this.clipX1;
                }

                @Pc(123) int x2 = x + width;
                if (x2 > this.clipX2 - 1) {
                    x2 = this.clipX2 - 1;
                }

                @Pc(125) int pixel = x1 + currY * this.surfaceWidth;
                for (@Pc(346) int currX = x1; currX <= x2; currX++) {
                    @Pc(352) int local352 = this.surfaceRaster[pixel];
                    local352 = ((local352 & 0xFF00FF) * opacity >> 8 & 0xFF00FF) + ((local352 & 0xFF00) * opacity >> 8 & 0xFF00);
                    this.surfaceRaster[pixel++] = local287 + local352;
                }

                currY++;
                local48 += local40 + local40;
                local44 += local40++ + local40;
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "o", descriptor = "()Z")
    @Override
    public boolean supportsBloom() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "l", descriptor = "()Z")
    @Override
    public boolean method7978() {
        return true;
    }

    @OriginalMember(owner = "client!iaa", name = "DA", descriptor = "(IIII)V")
    @Override
    public void DA(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        this.projectionCenterX = x;
        this.projectionCenterY = y;
        this.projectionScaleX = width;
        this.projectionScaleY = height;
        this.updateViewport();
    }

    @OriginalMember(owner = "client!iaa", name = "aa", descriptor = "(IIIIII)V")
    @Override
    public void aa(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int colour, @OriginalArg(5) int mode) {
        if (x < this.clipX1) {
            width -= this.clipX1 - x;
            x = this.clipX1;
        }
        if (y < this.clipY1) {
            height -= this.clipY1 - y;
            y = this.clipY1;
        }

        if (x + width > this.clipX2) {
            width = this.clipX2 - x;
        }
        if (y + height > this.clipY2) {
            height = this.clipY2 - y;
        }

        if (width <= 0 || height <= 0 || x > this.clipX2 || y > this.clipY2) {
            return;
        }

        @Pc(74) int step = this.surfaceWidth - width;
        @Pc(81) int pixel = x + (y * this.surfaceWidth);
        @Pc(85) int alpha = colour >>> 24;

        if (mode == 0 || (mode == 1 && alpha == 255)) {
            @Pc(101) int local101 = width >> 3;
            @Pc(105) int local105 = width & 0x7;

            width = pixel - 1;

            for (@Pc(112) int i = -height; i < 0; i++) {
                if (local101 > 0) {
                    x = local101;

                    do {
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        width++;
                        this.surfaceRaster[width] = colour;
                        x--;
                    } while (x > 0);
                }

                if (local105 > 0) {
                    x = local105;

                    do {
                        width++;
                        this.surfaceRaster[width] = colour;
                        x--;
                    } while (x > 0);
                }

                width += step;
            }
        } else if (mode == 1) {
            @Pc(215) int local215 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + (((colour & 0xFF00FF00) >>> 8) * alpha & 0xFF00FF00);
            @Pc(101) int opacity = 256 - alpha;
            for (@Pc(105) int local105 = 0; local105 < height; local105++) {
                for (@Pc(112) int local112 = -width; local112 < 0; local112++) {
                    @Pc(231) int local231 = this.surfaceRaster[pixel];
                    local231 = ((local231 & 0xFF00FF) * opacity >> 8 & 0xFF00FF) + (((local231 & 0xFF00FF00) >>> 8) * opacity & 0xFF00FF00);
                    this.surfaceRaster[pixel++] = local215 + local231;
                }
                pixel += step;
            }
        } else if (mode == 2) {
            for (@Pc(101) int local101 = 0; local101 < height; local101++) {
                for (@Pc(105) int local105 = -width; local105 < 0; local105++) {
                    @Pc(112) int local112 = this.surfaceRaster[pixel];
                    @Pc(231) int local231 = colour + local112;
                    @Pc(299) int local299 = (colour & 0xFF00FF) + (local112 & 0xFF00FF);
                    @Pc(309) int local309 = (local299 & 0x1000100) + (local231 - local299 & 0x10000);
                    this.surfaceRaster[pixel++] = local231 - local309 | local309 - (local309 >>> 8);
                }
                pixel += step;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "GA", descriptor = "(I)V")
    @Override
    public void GA(@OriginalArg(0) int colour) {
        this.aa(0, 0, this.surfaceWidth, this.surfaceHeight, colour, 0);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Ljava/awt/Canvas;II)V")
    @Override
    public void resizeCanvas(@OriginalArg(0) Canvas canvas, @OriginalArg(1) int width, @OriginalArg(2) int height) {
        @Pc(8) JavaSurface surface = this.surfaces.get(canvas.hashCode());
        if (surface == null) {
            return;
        }

        surface.unlink();
        surface = JavaSurface.create(canvas, width, height);
        this.surfaces.put(canvas.hashCode(), surface);

        if (this.canvas == canvas && this.offscreenSurface == null) {
            @Pc(39) Dimension dimension = canvas.getSize();
            this.canvasWidth = dimension.width;
            this.canvasHeight = dimension.height;
            this.surface = surface;
            this.surfaceRaster = surface.raster;
            this.surfaceWidth = surface.width;
            this.surfaceHeight = surface.height;

            if (this.surfaceWidth != this.depthWidth || this.surfaceHeight != this.depthHeight) {
                this.mainSurfaceWidth = this.depthWidth = this.surfaceWidth;
                this.mainSurfaceHeight = this.depthHeight = this.surfaceHeight;
                this.mainDepthBuffer = this.depthBuffer = new float[this.depthWidth * this.depthHeight];
            }

            this.reset();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "d", descriptor = "(II)Lclient!wja;")
    @Override
    public DepthBuffer method7986(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return new Class165(arg0, arg1);
    }

    @OriginalMember(owner = "client!iaa", name = "n", descriptor = "()Lclient!tt;")
    @Override
    public Matrix camera() {
        return this.camera;
    }

    @OriginalMember(owner = "client!iaa", name = "h", descriptor = "()V")
    @Override
    public void method7969() {
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIIIIIIIII)V")
    @Override
    public void drawTriangle(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int z1, @OriginalArg(3) int x2, @OriginalArg(4) int y2, @OriginalArg(5) int z2, @OriginalArg(6) int x3, @OriginalArg(7) int y3, @OriginalArg(8) int z3, @OriginalArg(9) int c1, @OriginalArg(10) int c2, @OriginalArg(11) int c3, @OriginalArg(12) int mode) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        @Pc(6) Rasterizer rasterizer = resource.rasterizer;
        rasterizer.fastScanline = false;

        @Pc(14) int newX1 = x1 - this.viewX1;
        @Pc(19) int newX2 = x2 - this.viewX1;
        @Pc(24) int newX3 = x3 - this.viewX1;
        @Pc(29) int newY1 = y1 - this.viewY1;
        @Pc(34) int newY2 = y2 - this.viewY1;
        @Pc(39) int newY3 = y3 - this.viewY1;

        rasterizer.clamp = newX1 < 0 || newX1 > rasterizer.width || newX2 < 0 || newX2 > rasterizer.width || newX3 < 0 || newX3 > rasterizer.width;

        int alpha = c1 >>> 24;
        if (mode == 0 || (mode == 1 && alpha == 255)) {
            rasterizer.alpha = 0;
            rasterizer.halfBlend = false;
            rasterizer.renderTriangleRgb((float) newY1, (float) newY2, (float) newY3, (float) newX1, (float) newX2, (float) newX3, (float) z1, (float) z2, (float) z3, c1, c2, c3);
        } else if (mode == 1) {
            rasterizer.alpha = 255 - alpha;
            rasterizer.halfBlend = false;
            rasterizer.renderTriangleRgb((float) newY1, (float) newY2, (float) newY3, (float) newX1, (float) newX2, (float) newX3, (float) z1, (float) z2, (float) z3, c1, c2, c3);
        } else if (mode == 2) {
            rasterizer.alpha = 128;
            rasterizer.halfBlend = false;
            rasterizer.renderTriangleRgb((float) newY1, (float) newY2, (float) newY3, (float) newX1, (float) newX2, (float) newX3, (float) z1, (float) z2, (float) z3, c1, c2, c3);
        } else {
            throw new IllegalArgumentException();
        }

        rasterizer.fastScanline = true;
    }

    @OriginalMember(owner = "client!iaa", name = "XA", descriptor = "()I")
    @Override
    public int XA() {
        return this.zFar;
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(II)I")
    @Override
    public int compareFunctionMasks(@OriginalArg(0) int maskA, @OriginalArg(1) int maskB) {
        @Pc(3) int local3 = maskA | 0x20800;
        return local3 & maskB ^ maskB;
    }

    @OriginalMember(owner = "client!iaa", name = "Y", descriptor = "()[I")
    @Override
    public int[] Y() {
        return new int[]{
            this.projectionCenterX,
            this.projectionCenterY,
            this.projectionScaleX,
            this.projectionScaleY,
        };
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!dv;IIII)Lclient!ka;")
    @Override
    public Model createModel(@OriginalArg(0) Mesh mesh, @OriginalArg(1) int functionMask, @OriginalArg(2) int featureMask, @OriginalArg(3) int ambient, @OriginalArg(4) int contrast) {
        return new JavaModel(this, mesh, functionMask, ambient, contrast, featureMask);
    }

    @OriginalMember(owner = "client!iaa", name = "B", descriptor = "()Z")
    @Override
    public boolean method8001() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "n", descriptor = "(I)Z")
    public boolean textureAvailable(@OriginalArg(0) int arg0) {
        return super.textureSource.textureAvailable(arg0);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Ljava/lang/Runnable;)Lclient!wf;")
    public JavaThreadResource threadResource(@OriginalArg(0) Runnable arg0) {
        for (@Pc(1) int i = 0; i < this.threadCount; i++) {
            if (this.resources[i].thread == arg0) {
                return this.resources[i];
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!iaa", name = "f", descriptor = "(II)V")
    @Override
    public void f(@OriginalArg(0) int near, @OriginalArg(1) int far) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        this.zNear = near;
        this.zFar = far;
        resource.fogPlane = this.zFar - 255;
    }

    @OriginalMember(owner = "client!iaa", name = "P", descriptor = "(IIIII)V")
    @Override
    public void P(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int strength, @OriginalArg(3) int colour, @OriginalArg(4) int mode) {
        if (x < this.clipX1 || x >= this.clipX2) {
            return;
        }

        if (y < this.clipY1) {
            strength -= this.clipY1 - y;
            y = this.clipY1;
        }
        if (y + strength > this.clipY2) {
            strength = this.clipY2 - y;
        }

        @Pc(43) int pixel = x + (y * this.surfaceWidth);
        @Pc(47) int alpha = colour >>> 24;
        if (mode == 0 || mode == 1 && alpha == 255) {
            for (@Pc(61) int local61 = 0; local61 < strength; local61++) {
                this.surfaceRaster[pixel + local61 * this.surfaceWidth] = colour;
            }
        } else if (mode == 1) {
            @Pc(105) int local105 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
            @Pc(61) int local61 = 256 - alpha;
            for (@Pc(111) int local111 = 0; local111 < strength; local111++) {
                @Pc(119) int local119 = pixel + local111 * this.surfaceWidth;
                @Pc(124) int local124 = this.surfaceRaster[local119];
                local124 = ((local124 & 0xFF00FF) * local61 >> 8 & 0xFF00FF) + ((local124 & 0xFF00) * local61 >> 8 & 0xFF00);
                this.surfaceRaster[local119] = local105 + local124;
            }
        } else if (mode == 2) {
            for (@Pc(61) int local61 = 0; local61 < strength; local61++) {
                @Pc(111) int local111 = pixel + local61 * this.surfaceWidth;
                @Pc(119) int local119 = this.surfaceRaster[local111];
                @Pc(124) int local124 = colour + local119;
                @Pc(187) int local187 = (colour & 0xFF00FF) + (local119 & 0xFF00FF);
                @Pc(197) int local197 = (local187 & 0x1000100) + (local124 - local187 & 0x10000);
                this.surfaceRaster[local111] = local124 - local197 | local197 - (local197 >>> 8);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Z)V")
    @Override
    public void setShrinkTextures(@OriginalArg(0) boolean shrinkTextures) {
        this.shrinkTextures = shrinkTextures;
        this.textureCache.reset();
    }

    @OriginalMember(owner = "client!iaa", name = "A", descriptor = "()Lclient!tt;")
    @Override
    public Matrix scratchMatrix() {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        return resource.scratchMatrix;
    }

    @OriginalMember(owner = "client!iaa", name = "d", descriptor = "()V")
    @Override
    public void method7974() {
    }

    @OriginalMember(owner = "client!iaa", name = "d", descriptor = "(IIIIII)V")
    @Override
    public void outlineRect(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int colour, @OriginalArg(5) int mode) {
        this.U(x, y, width, colour, mode);
        this.U(x, y + height - 1, width, colour, mode);
        this.P(x, y + 1, height - 2, colour, mode);
        this.P(x + width - 1, y + 1, height - 2, colour, mode);
    }

    @OriginalMember(owner = "client!iaa", name = "U", descriptor = "(IIIII)V")
    @Override
    public void U(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int strength, @OriginalArg(3) int colour, @OriginalArg(4) int mode) {
        if (y < this.clipY1 || y >= this.clipY2) {
            return;
        }
        if (x < this.clipX1) {
            strength -= this.clipX1 - x;
            x = this.clipX1;
        }
        if (x + strength > this.clipX2) {
            strength = this.clipX2 - x;
        }

        @Pc(43) int pixel = x + y * this.surfaceWidth;
        @Pc(47) int alpha = colour >>> 24;

        if (mode == 0 || (mode == 1 && alpha == 255)) {
            for (@Pc(61) int local61 = 0; local61 < strength; local61++) {
                this.surfaceRaster[pixel + local61] = colour;
            }
        } else if (mode == 1) {
            @Pc(102) int local102 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
            @Pc(61) int local61 = 256 - alpha;
            for (@Pc(108) int local108 = 0; local108 < strength; local108++) {
                @Pc(116) int local116 = this.surfaceRaster[pixel + local108];
                local116 = ((local116 & 0xFF00FF) * local61 >> 8 & 0xFF00FF) + ((local116 & 0xFF00) * local61 >> 8 & 0xFF00);
                this.surfaceRaster[pixel + local108] = local102 + local116;
            }
        } else if (mode == 2) {
            for (@Pc(61) int local61 = 0; local61 < strength; local61++) {
                @Pc(108) int local108 = this.surfaceRaster[pixel + local61];
                @Pc(116) int local116 = colour + local108;
                @Pc(176) int local176 = (colour & 0xFF00FF) + (local108 & 0xFF00FF);
                @Pc(186) int local186 = (local176 & 0x1000100) + (local116 - local176 & 0x10000);
                this.surfaceRaster[pixel + local61] = local116 - local186 | local186 - (local186 >>> 8);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "ZA", descriptor = "(IFFFFF)V")
    @Override
    public void ZA(@OriginalArg(0) int colour, @OriginalArg(1) float intensity, @OriginalArg(2) float reverseIntensity, @OriginalArg(3) float x, @OriginalArg(4) float y, @OriginalArg(5) float z) {
        this.sunIntensity = (int) (intensity * 65535.0F);
        this.reverseSunIntensity = (int) (reverseIntensity * 65535.0F);
        @Pc(26) float lnorm = (float) Math.sqrt((x * x) + (y * y) + (z * z));
        this.sunX = (int) (x * 65535.0F / lnorm);
        this.sunY = (int) (y * 65535.0F / lnorm);
        this.sunZ = (int) (z * 65535.0F / lnorm);
    }

    @OriginalMember(owner = "client!iaa", name = "C", descriptor = "(Z)V")
    @Override
    public void C(@OriginalArg(0) boolean zWrite) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        resource.zWrite = zWrite;
    }

    @OriginalMember(owner = "client!iaa", name = "q", descriptor = "()V")
    @Override
    public void cacheReset() {
        this.textureCache.reset();
        this.spriteCache.reset();
    }

    @OriginalMember(owner = "client!iaa", name = "o", descriptor = "(I)[I")
    public int[] getArgbTexture(@OriginalArg(0) int id) {
        @Pc(2) ReferenceCache local2 = this.textureCache;
        @Pc(14) JavaAnimatedTexture texture;
        synchronized (this.textureCache) {
            texture = (JavaAnimatedTexture) this.textureCache.get((long) id | Long.MIN_VALUE);
            if (texture == null) {
                if (!super.textureSource.textureAvailable(id)) {
                    return null;
                }

                @Pc(36) TextureMetrics metrics = super.textureSource.getMetrics(id);
                @Pc(50) int size = (metrics.small || this.shrinkTextures) ? 64 : this.textureSize;
                texture = new JavaAnimatedTexture(id, size, super.textureSource.argbOutput(0.7F, id, size, size), metrics.alphaBlendMode != 1);
                this.textureCache.put(texture, (long) id | Long.MIN_VALUE);
            }
        }

        texture.awaitingTick = true;
        return texture.method3972();
    }

    @OriginalMember(owner = "client!iaa", name = "f", descriptor = "()V")
    @Override
    public void stopBloom() {
    }

    @OriginalMember(owner = "client!iaa", name = "A", descriptor = "(ILclient!aa;II)V")
    @Override
    public void A(@OriginalArg(0) int colour, @OriginalArg(1) ClippingMask clippingMask, @OriginalArg(2) int x, @OriginalArg(3) int y) {
        @Pc(2) JavaClippingMask mask = (JavaClippingMask) clippingMask;
        @Pc(5) int[] lineOffsets = mask.lineOffsets;
        @Pc(8) int[] lineWidths = mask.lineWidths;

        @Pc(20) int y2;
        if (this.clipY2 < y + lineOffsets.length) {
            y2 = this.clipY2 - y;
        } else {
            y2 = lineOffsets.length;
        }

        @Pc(33) int y1;
        if (this.clipY1 > y) {
            y1 = this.clipY1 - y;
            y = this.clipY1;
        } else {
            y1 = 0;
        }

        if (y2 - y1 <= 0) {
            return;
        }

        @Pc(50) int off = y * this.surfaceWidth;
        for (@Pc(52) int i = y1; i < y2; i++) {
            @Pc(59) int start = x + lineOffsets[i];
            @Pc(63) int width = lineWidths[i];

            if (this.clipX1 > start) {
                width -= this.clipX1 - start;
                start = this.clipX1;
            }
            if (this.clipX2 < start + width) {
                width = this.clipX2 - start;
            }

            start += off;

            for (@Pc(95) int j = -width; j < 0; j++) {
                this.surfaceRaster[start++] = colour;
            }

            off += this.surfaceWidth;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIIIII)V")
    @Override
    public void method7995(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7) {
        arg2 -= arg0;
        arg3 -= arg1;
        @Pc(31) int local31;
        @Pc(35) int local35;
        if (arg3 == 0) {
            if (arg2 >= 0) {
                this.method3794(arg0, arg1, arg2 + 1, arg4, arg5, arg6, arg7);
            } else {
                local31 = arg5 + arg6;
                local35 = arg7 % local31;
                local35 = local31 + arg5 - local35 - (-arg2 + 1) % local31;
                arg7 = local35 % local31;
                if (arg7 < 0) {
                    arg7 += local31;
                }
                this.method3794(arg0 + arg2, arg1, 1 - arg2, arg4, arg5, arg6, arg7);
            }
        } else if (arg2 != 0) {
            local35 = arg7 << 8;
            @Pc(149) int local149 = arg5 << 8;
            @Pc(153) int local153 = arg6 << 8;
            local31 = local149 + local153;
            arg7 = local35 % local31;
            @Pc(178) int local178;
            @Pc(182) int local182;
            if (arg2 + arg3 < 0) {
                local178 = (int) (Math.sqrt(arg2 * arg2 + arg3 * arg3) * 256.0D);
                local182 = local178 % local31;
                local35 = local31 + local149 - arg7 - local182;
                arg7 = local35 % local31;
                if (arg7 < 0) {
                    arg7 += local31;
                }
                arg0 += arg2;
                arg2 = -arg2;
                arg1 += arg3;
                arg3 = -arg3;
            }
            @Pc(260) int local260;
            @Pc(278) int local278;
            @Pc(371) int local371;
            @Pc(405) int local405;
            @Pc(410) int local410;
            @Pc(243) int local243;
            @Pc(229) int local229;
            @Pc(362) int local362;
            if (arg2 > arg3) {
                arg1 <<= 0x10;
                arg1 += 32768;
                local229 = arg3 << 16;
                local178 = (int) Math.floor((double) local229 / (double) arg2 + 0.5D);
                local243 = arg2 + arg0;
                local182 = arg4 >>> 24;
                local260 = (int) Math.sqrt((local178 >> 8) * (local178 >> 8) + 65536);
                if (local182 == 255 && true) {
                    while (arg0 <= local243) {
                        local278 = arg1 >> 16;
                        if (arg0 >= this.clipX1 && arg0 < this.clipX2 && local278 >= this.clipY1 && local278 < this.clipY2 && arg7 < local149) {
                            this.surfaceRaster[arg0 + local278 * this.surfaceWidth] = arg4;
                        }
                        arg1 += local178;
                        arg0++;
                        local35 = arg7 + local260;
                        arg7 = local35 % local31;
                    }
                } else {
                    local362 = ((arg4 & 0xFF00FF) * local182 >> 8 & 0xFF00FF) + ((arg4 & 0xFF00) * local182 >> 8 & 0xFF00) + (local182 << 24);
                    local278 = 256 - local182;
                    while (arg0 <= local243) {
                        local371 = arg1 >> 16;
                        if (arg0 >= this.clipX1 && arg0 < this.clipX2 && local371 >= this.clipY1 && local371 < this.clipY2 && arg7 < local149) {
                            local405 = arg0 + local371 * this.surfaceWidth;
                            local410 = this.surfaceRaster[local405];
                            local410 = ((local410 & 0xFF00FF) * local278 >> 8 & 0xFF00FF) + ((local410 & 0xFF00) * local278 >> 8 & 0xFF00);
                            this.surfaceRaster[local405] = local362 + local410;
                        }
                        arg1 += local178;
                        arg0++;
                        local35 = arg7 + local260;
                        arg7 = local35 % local31;
                    }
                }
            } else {
                arg0 <<= 0x10;
                arg0 += 32768;
                local243 = arg2 << 16;
                local178 = (int) Math.floor((double) local243 / (double) arg3 + 0.5D);
                local229 = arg3 + arg1;
                local182 = arg4 >>> 24;
                local260 = (int) Math.sqrt((local178 >> 8) * (local178 >> 8) + 65536);
                if (local182 == 255 && true) {
                    while (arg1 <= local229) {
                        local278 = arg0 >> 16;
                        if (arg1 >= this.clipY1 && arg1 < this.clipY2 && local278 >= this.clipX1 && local278 < this.clipX2 && arg7 < local149) {
                            this.surfaceRaster[local278 + arg1 * this.surfaceWidth] = arg4;
                        }
                        arg0 += local178;
                        arg1++;
                        local35 = arg7 + local260;
                        arg7 = local35 % local31;
                    }
                } else {
                    local362 = ((arg4 & 0xFF00FF) * local182 >> 8 & 0xFF00FF) + ((arg4 & 0xFF00) * local182 >> 8 & 0xFF00) + (local182 << 24);
                    local278 = 256 - local182;
                    while (arg1 <= local229) {
                        local371 = arg0 >> 16;
                        if (arg1 >= this.clipY1 && arg1 < this.clipY2 && local371 >= this.clipX1 && local371 < this.clipX2 && arg7 < local149) {
                            local405 = local371 + arg1 * this.surfaceWidth;
                            local410 = this.surfaceRaster[local405];
                            @Pc(773) int local773 = ((local410 & 0xFF00FF) * local278 >> 8 & 0xFF00FF) + ((local410 & 0xFF00) * local278 >> 8 & 0xFF00);
                            this.surfaceRaster[local371 + arg1 * this.surfaceWidth] = local362 + local773;
                        }
                        arg0 += local178;
                        arg1++;
                        local35 = arg7 + local260;
                        arg7 = local35 % local31;
                    }
                }
            }
        } else if (arg3 >= 0) {
            this.method3783(arg0, arg1, arg3 + 1, arg4, arg5, arg6, arg7);
        } else {
            local31 = arg5 + arg6;
            local35 = arg7 % local31;
            local35 = local31 + arg5 - local35 - (-arg3 + 1) % local31;
            arg7 = local35 % local31;
            if (arg7 < 0) {
                arg7 += local31;
            }
            this.method3783(arg0, arg1 + arg3, -arg3 + 1, arg4, arg5, arg6, arg7);
        }
    }

    @OriginalMember(owner = "client!iaa", name = "K", descriptor = "([I)V")
    @Override
    public void K(@OriginalArg(0) int[] destination) {
        destination[0] = this.clipX1;
        destination[1] = this.clipY1;
        destination[2] = this.clipX2;
        destination[3] = this.clipY2;
    }

    @OriginalMember(owner = "client!iaa", name = "i", descriptor = "()I")
    @Override
    public int i() {
        return this.zNear;
    }

    @OriginalMember(owner = "client!iaa", name = "c", descriptor = "()Lclient!dp;")
    @Override
    public Renderer renderer() {
        return new Renderer(0, "Pure Java", 1, "CPU", 0L);
    }

    @OriginalMember(owner = "client!iaa", name = "f", descriptor = "(I)V")
    @Override
    public void setTextureSize(@OriginalArg(0) int size) {
        this.textureSize = size;
        this.textureCache.reset();
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "([Ljava/awt/Rectangle;III)V")
    @Override
    public void flipDirtyRect(@OriginalArg(0) Rectangle[] rectangles, @OriginalArg(1) int count, @OriginalArg(2) int x, @OriginalArg(3) int y) throws FlipException {
        if (this.canvas == null || this.surface == null) {
            throw new IllegalStateException("off");
        }

        try {
            @Pc(19) Graphics local19 = this.canvas.getGraphics();
            for (@Pc(21) int local21 = 0; local21 < count; local21++) {
                @Pc(26) Rectangle local26 = rectangles[local21];
                if (local26.x + x <= this.surfaceWidth && local26.y + y <= this.surfaceHeight && local26.x + x + local26.width > 0 && local26.y + y + local26.height > 0) {
                    this.surface.clip(local26.x, local26.y, local26.x + x, local26.y + y, local26.width, local26.height, local19);
                }
            }
        } catch (@Pc(91) Exception local91) {
            this.canvas.repaint();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "D", descriptor = "()V")
    public void reset() {
        for (@Pc(1) int local1 = 0; local1 < this.threadCount; local1++) {
            this.resources[local1].method9194();
        }
        this.la();
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!za;)V")
    @Override
    public void method7938(@OriginalArg(0) MemoryPool arg0) {
    }

    @OriginalMember(owner = "client!iaa", name = "k", descriptor = "(I)V")
    @Override
    public void linkThreads(@OriginalArg(0) int arg0) {
        this.resources[arg0].method9196(Thread.currentThread());
    }

    @OriginalMember(owner = "client!iaa", name = "p", descriptor = "()Z")
    @Override
    public boolean increaseRenderDistance() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "([I)V")
    @Override
    public void method7944(@OriginalArg(0) int[] arg0) {
        arg0[0] = this.surfaceWidth;
        arg0[1] = this.surfaceHeight;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIII)V")
    @Override
    public void method7959(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
    }

    @OriginalMember(owner = "client!iaa", name = "c", descriptor = "(II)I")
    @Override
    public int combineFunctionMasks(@OriginalArg(0) int maskA, @OriginalArg(1) int maskB) {
        return maskA | maskB;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(II)Lclient!eca;")
    @Override
    public Surface method7962(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return this.createSprite(arg0, arg1, false);
    }

    @OriginalMember(owner = "client!iaa", name = "H", descriptor = "(III[I)V")
    @Override
    public void H(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3) {
        @Pc(24) float local24 = this.camera.tz + this.camera.e3_1 * (float) arg0 + this.camera.e3_2 * (float) arg1 + this.camera.e3_3 * (float) arg2;
        if (local24 == 0.0F) {
            arg3[0] = arg3[1] = arg3[2] = -1;
            return;
        }
        @Pc(74) int local74 = (int) ((float) this.projectionScaleX * (this.camera.tx + this.camera.e1_1 * (float) arg0 + this.camera.e1_2 * (float) arg1 + this.camera.e1_3 * (float) arg2) / local24);
        @Pc(106) int local106 = (int) ((float) this.projectionScaleY * (this.camera.ty + this.camera.e2_1 * (float) arg0 + this.camera.e2_2 * (float) arg1 + this.camera.e2_3 * (float) arg2) / local24);
        arg3[0] = local74 - this.viewX1;
        arg3[1] = local106 - this.viewY1;
        arg3[2] = (int) local24;
    }

    @OriginalMember(owner = "client!iaa", name = "x", descriptor = "()Z")
    @Override
    public boolean method7937() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "ra", descriptor = "(IIII)V")
    @Override
    public void ra(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        for (@Pc(1) int local1 = 0; local1 < this.resources.length; local1++) {
            this.resources[local1].anInt10600 = this.resources[local1].fogColour;
            this.resources[local1].waterHeight = arg0;
            this.resources[local1].fogColour = arg1;
            this.resources[local1].waterDepth = arg2;
            this.resources[local1].aBoolean805 = true;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "e", descriptor = "(IIIIII)V")
    public void method3790(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int size, @OriginalArg(4) int colour, @OriginalArg(5) int mode) {
        if (size < 0) {
            size = -size;
        }
        @Pc(8) int local8 = y - size;
        if (local8 < this.clipY1) {
            local8 = this.clipY1;
        }
        @Pc(21) int local21 = y + size + 1;
        if (local21 > this.clipY2) {
            local21 = this.clipY2;
        }
        @Pc(30) int local30 = local8;
        @Pc(34) int local34 = size * size;
        @Pc(36) int local36 = 0;
        @Pc(40) int local40 = y - local8;
        @Pc(44) int local44 = local40 * local40;
        @Pc(48) int local48 = local44 - local40;
        if (y > local21) {
            y = local21;
        }
        @Pc(57) int local57 = colour >>> 24;
        @Pc(98) int local98;
        @Pc(109) int local109;
        @Pc(123) int local123;
        @Pc(125) int local125;
        if (mode == 0 || mode == 1 && local57 == 255) {
            while (local30 < y) {
                while (local48 <= local34 || local44 <= local34) {
                    local44 += local36 + local36;
                    local48 += local36++ + local36;
                }
                local98 = x + 1 - local36;
                if (local98 < this.clipX1) {
                    local98 = this.clipX1;
                }
                local109 = x + local36;
                if (local109 > this.clipX2) {
                    local109 = this.clipX2;
                }
                local123 = local98 + local30 * this.surfaceWidth;
                for (local125 = local98; local125 < local109; local125++) {
                    if ((float) z < this.depthBuffer[local123]) {
                        this.surfaceRaster[local123] = colour;
                    }
                    local123++;
                }
                local30++;
                local44 -= local40-- + local40;
                local48 -= local40 + local40;
            }
            local36 = size;
            local40 = local30 - y;
            local48 = local40 * local40 + local34;
            local44 = local48 - size;
            local48 -= local40;
            while (local30 < local21) {
                while (local48 > local34 && local44 > local34) {
                    local48 -= local36-- + local36;
                    local44 -= local36 + local36;
                }
                local98 = x - local36;
                if (local98 < this.clipX1) {
                    local98 = this.clipX1;
                }
                local109 = x + local36;
                if (local109 > this.clipX2 - 1) {
                    local109 = this.clipX2 - 1;
                }
                local123 = local98 + local30 * this.surfaceWidth;
                for (local125 = local98; local125 <= local109; local125++) {
                    if ((float) z < this.depthBuffer[local123]) {
                        this.surfaceRaster[local123] = colour;
                    }
                    local123++;
                }
                local30++;
                local48 += local40 + local40;
                local44 += local40++ + local40;
            }
            return;
        }
        @Pc(366) int local366;
        @Pc(380) int local380;
        if (mode == 1) {
            @Pc(307) int local307 = ((colour & 0xFF00FF) * local57 >> 8 & 0xFF00FF) + ((colour & 0xFF00) * local57 >> 8 & 0xFF00) + (local57 << 24);
            local98 = 256 - local57;
            while (local30 < y) {
                while (local48 <= local34 || local44 <= local34) {
                    local44 += local36 + local36;
                    local48 += local36++ + local36;
                }
                local109 = x + 1 - local36;
                if (local109 < this.clipX1) {
                    local109 = this.clipX1;
                }
                local123 = x + local36;
                if (local123 > this.clipX2) {
                    local123 = this.clipX2;
                }
                local125 = local109 + local30 * this.surfaceWidth;
                for (local366 = local109; local366 < local123; local366++) {
                    if ((float) z < this.depthBuffer[local125]) {
                        local380 = this.surfaceRaster[local125];
                        local380 = ((local380 & 0xFF00FF) * local98 >> 8 & 0xFF00FF) + ((local380 & 0xFF00) * local98 >> 8 & 0xFF00);
                        this.surfaceRaster[local125] = local307 + local380;
                    }
                    local125++;
                }
                local30++;
                local44 -= local40-- + local40;
                local48 -= local40 + local40;
            }
            local36 = size;
            local40 = -local40;
            local48 = local40 * local40 + local34;
            local44 = local48 - size;
            local48 -= local40;
            while (local30 < local21) {
                while (local48 > local34 && local44 > local34) {
                    local48 -= local36-- + local36;
                    local44 -= local36 + local36;
                }
                local109 = x - local36;
                if (local109 < this.clipX1) {
                    local109 = this.clipX1;
                }
                local123 = x + local36;
                if (local123 > this.clipX2 - 1) {
                    local123 = this.clipX2 - 1;
                }
                local125 = local109 + local30 * this.surfaceWidth;
                for (local366 = local109; local366 <= local123; local366++) {
                    if ((float) z < this.depthBuffer[local125]) {
                        local380 = this.surfaceRaster[local125];
                        local380 = ((local380 & 0xFF00FF) * local98 >> 8 & 0xFF00FF) + ((local380 & 0xFF00) * local98 >> 8 & 0xFF00);
                        this.surfaceRaster[local125] = local307 + local380;
                    }
                    local125++;
                }
                local30++;
                local48 += local40 + local40;
                local44 += local40++ + local40;
            }
        } else if (mode == 2) {
            @Pc(655) int local655;
            while (local30 < y) {
                while (local48 <= local34 || local44 <= local34) {
                    local44 += local36 + local36;
                    local48 += local36++ + local36;
                }
                local98 = x + 1 - local36;
                if (local98 < this.clipX1) {
                    local98 = this.clipX1;
                }
                local109 = x + local36;
                if (local109 > this.clipX2) {
                    local109 = this.clipX2;
                }
                local123 = local98 + local30 * this.surfaceWidth;
                for (local125 = local98; local125 < local109; local125++) {
                    if ((float) z < this.depthBuffer[local123]) {
                        local366 = this.surfaceRaster[local123];
                        local380 = colour + local366;
                        local655 = (colour & 0xFF00FF) + (local366 & 0xFF00FF);
                        @Pc(665) int local665 = (local655 & 0x1000100) + (local380 - local655 & 0x10000);
                        this.surfaceRaster[local123] = local380 - local665 | local665 - (local665 >>> 8);
                    }
                    local123++;
                }
                local30++;
                local44 -= local40-- + local40;
                local48 -= local40 + local40;
            }
            local36 = size;
            local40 = -local40;
            local48 = local40 * local40 + local34;
            local44 = local48 - size;
            local48 -= local40;
            while (local30 < local21) {
                while (local48 > local34 && local44 > local34) {
                    local48 -= local36-- + local36;
                    local44 -= local36 + local36;
                }
                local98 = x - local36;
                if (local98 < this.clipX1) {
                    local98 = this.clipX1;
                }
                local109 = x + local36;
                if (local109 > this.clipX2 - 1) {
                    local109 = this.clipX2 - 1;
                }
                local123 = local98 + local30 * this.surfaceWidth;
                for (local125 = local98; local125 <= local109; local125++) {
                    if ((float) z < this.depthBuffer[local123]) {
                        local366 = this.surfaceRaster[local123];
                        local380 = colour + local366;
                        local655 = (colour & 0xFF00FF) + (local366 & 0xFF00FF);
                        local366 = (local655 & 0x1000100) + (local380 - local655 & 0x10000);
                        this.surfaceRaster[local123] = local380 - local366 | local366 - (local366 >>> 8);
                    }
                    local123++;
                }
                local30++;
                local48 += local40 + local40;
                local44 += local40++ + local40;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "KA", descriptor = "(IIII)V")
    @Override
    public void KA(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2) {
        if (x1 < 0) {
            x1 = 0;
        }
        if (y1 < 0) {
            y1 = 0;
        }
        if (x2 > this.surfaceWidth) {
            x2 = this.surfaceWidth;
        }
        if (y2 > this.surfaceHeight) {
            y2 = this.surfaceHeight;
        }
        this.clipX1 = x1;
        this.clipX2 = x2;
        this.clipY1 = y1;
        this.clipY2 = y2;
        this.updateViewport();
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(II[I[I)Lclient!aa;")
    @Override
    public ClippingMask createMask(@OriginalArg(0) int width, @OriginalArg(1) int height, @OriginalArg(2) int[] offsets, @OriginalArg(3) int[] widths) {
        return new JavaClippingMask(width, height, offsets, widths);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!pu;Lclient!pu;FLclient!pu;)Lclient!pu;")
    @Override
    public Class67 method8007(@OriginalArg(0) Class67 arg0, @OriginalArg(1) Class67 arg1, @OriginalArg(2) float arg2, @OriginalArg(3) Class67 arg3) {
        return null;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIF)Lclient!lca;")
    @Override
    public PointLight method7941(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) float arg5) {
        return null;
    }

    @OriginalMember(owner = "client!iaa", name = "da", descriptor = "(III[I)V")
    @Override
    public void da(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3) {
        @Pc(24) float local24 = this.camera.tz + this.camera.e3_1 * (float) arg0 + this.camera.e3_2 * (float) arg1 + this.camera.e3_3 * (float) arg2;
        if (local24 < (float) this.zNear || local24 > (float) this.zFar) {
            arg3[0] = arg3[1] = arg3[2] = -1;
            return;
        }
        @Pc(84) int local84 = (int) ((float) this.projectionScaleX * (this.camera.tx + this.camera.e1_1 * (float) arg0 + this.camera.e1_2 * (float) arg1 + this.camera.e1_3 * (float) arg2) / local24);
        @Pc(116) int local116 = (int) ((float) this.projectionScaleY * (this.camera.ty + this.camera.e2_1 * (float) arg0 + this.camera.e2_2 * (float) arg1 + this.camera.e2_3 * (float) arg2) / local24);
        if (local84 >= this.viewX1 && local84 <= this.viewX2 && local116 >= this.viewY1 && local116 <= this.vewY2) {
            arg3[0] = local84 - this.viewX1;
            arg3[1] = local116 - this.viewY1;
            arg3[2] = (int) local24;
        } else {
            arg3[0] = arg3[1] = arg3[2] = -1;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "HA", descriptor = "(IIII[I)V")
    @Override
    public void HA(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int[] arg4) {
        @Pc(24) float local24 = this.camera.tz + this.camera.e3_1 * (float) arg0 + this.camera.e3_2 * (float) arg1 + this.camera.e3_3 * (float) arg2;
        if (local24 < (float) this.zNear || local24 > (float) this.zFar) {
            arg4[0] = arg4[1] = arg4[2] = -1;
            return;
        }
        @Pc(85) int local85 = (int) ((float) this.projectionScaleX * (this.camera.tx + this.camera.e1_1 * (float) arg0 + this.camera.e1_2 * (float) arg1 + this.camera.e1_3 * (float) arg2) / (float) arg3);
        @Pc(118) int local118 = (int) ((float) this.projectionScaleY * (this.camera.ty + this.camera.e2_1 * (float) arg0 + this.camera.e2_2 * (float) arg1 + this.camera.e2_3 * (float) arg2) / (float) arg3);
        if (local85 >= this.viewX1 && local85 <= this.viewX2 && local118 >= this.viewY1 && local118 <= this.vewY2) {
            arg4[0] = local85 - this.viewX1;
            arg4[1] = local118 - this.viewY1;
            arg4[2] = (int) local24;
        } else {
            arg4[0] = arg4[1] = arg4[2] = -1;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "k", descriptor = "()Z")
    @Override
    public boolean method7949() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "c", descriptor = "(I)V")
    @Override
    public void method8016(@OriginalArg(0) int arg0) {
        this.resources[arg0].method9196(null);
    }

    @OriginalMember(owner = "client!iaa", name = "j", descriptor = "(I)V")
    @Override
    public void allocateThreads(@OriginalArg(0) int arg0) {
        this.threadCount = arg0;
        this.resources = new JavaThreadResource[this.threadCount];
        for (@Pc(9) int local9 = 0; local9 < this.threadCount; local9++) {
            this.resources[local9] = new JavaThreadResource(this);
        }
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(I)V")
    @Override
    public void method8003() {
        Static567.anInt8484 = 10000;
        Static567.anInt8486 = 10000;
        if (this.threadCount > 1) {
            throw new IllegalStateException("No MT");
        }
        this.allocateThreads(this.threadCount);
        this.linkThreads(0);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "([IIIIIZ)Lclient!st;")
    @Override
    public Sprite method7958(@OriginalArg(0) int[] arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) boolean arg4) {
        @Pc(1) boolean local1 = false;
        @Pc(3) int local3 = 0;
        for (@Pc(5) int local5 = 0; local5 < arg3; local5++) {
            for (@Pc(8) int local8 = 0; local8 < arg2; local8++) {
                @Pc(16) int local16 = arg0[local3++] >>> 24;
                if (local16 != 0 && local16 != 255) {
                    local1 = true;
                    return local1 ? new JavaArgbSprite(this, arg0, 0, arg1, arg2, arg3, arg4) : new JavaRgbSprite(this, arg0, 0, arg1, arg2, arg3, arg4);
                }
            }
        }
        return local1 ? new JavaArgbSprite(this, arg0, 0, arg1, arg2, arg3, arg4) : new JavaRgbSprite(this, arg0, 0, arg1, arg2, arg3, arg4);
    }

    @OriginalMember(owner = "client!iaa", name = "E", descriptor = "()I")
    @Override
    public int E() {
        return 0;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!pu;)V")
    @Override
    public void method7973(@OriginalArg(0) Class67 arg0) {
    }

    @OriginalMember(owner = "client!iaa", name = "s", descriptor = "()Z")
    @Override
    public boolean method7979() {
        return true;
    }

    @OriginalMember(owner = "client!iaa", name = "e", descriptor = "(I)V")
    @Override
    public void tick(@OriginalArg(0) int time) {
        @Pc(4) int elapsed = time - this.lastTickTime;

        for (@Pc(9) Object object = this.textureCache.first(); object != null; object = this.textureCache.next()) {
            @Pc(13) JavaAnimatedTexture texture = (JavaAnimatedTexture) object;

            if (texture.awaitingTick) {
                texture.runningTime += elapsed;

                @Pc(27) int frames = texture.runningTime / 20;
                if (frames > 0) {
                    @Pc(36) TextureMetrics metrics = super.textureSource.getMetrics(texture.anInt4408);
                    texture.translate((metrics.speedU * elapsed * 50) / 1000, (metrics.speedV * elapsed * 50) / 1000);
                    texture.runningTime -= frames * 20;
                }

                texture.awaitingTick = false;
            }
        }

        this.lastTickTime = time;
        this.spriteCache.clean(5);
        this.textureCache.clean(5);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(FFF)V")
    @Override
    public void method7993(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2) {
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(IIIIIIIIII)V")
    public void method3791(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9) {
        if (arg3 == 0 || arg4 == 0) {
            return;
        }
        if (arg6 == 65535 || super.textureSource.getMetrics(arg6).disableable) {
            this.method3790(arg0, arg1, arg2, arg3, arg7, arg9);
            return;
        }
        if (this.textureId != arg6) {
            @Pc(33) Sprite local33 = (Sprite) this.spriteCache.get(arg6);
            if (local33 == null) {
                @Pc(39) int[] local39 = this.getArgbTexture(arg6);
                if (local39 == null) {
                    return;
                }
                @Pc(53) int local53 = this.smallTexture(arg6) ? 64 : this.textureSize;
                local33 = this.createSprite(local53, local53, local53, local39);
                this.spriteCache.put(local33, arg6);
            }
            this.textureId = arg6;
            this.sprite = local33;
        }
        ((JavaSprite) this.sprite).method8208(arg0 - arg3, arg1 - arg4, arg2, arg3 << 1, arg4 << 1, arg8, arg7, arg9);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIZ)Lclient!st;")
    @Override
    public Sprite createSprite(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4) {
        @Pc(4) int[] local4 = new int[arg2 * arg3];
        @Pc(11) int local11 = arg1 * this.surfaceWidth + arg0;
        @Pc(16) int local16 = this.surfaceWidth - arg2;
        for (@Pc(18) int local18 = 0; local18 < arg3; local18++) {
            @Pc(23) int local23 = local18 * arg2;
            for (@Pc(25) int local25 = 0; local25 < arg2; local25++) {
                local4[local23 + local25] = this.surfaceRaster[local11++];
            }
            local11 += local16;
        }
        if (arg4) {
            return new JavaArgbSprite(this, local4, arg2, arg3);
        } else {
            return new JavaRgbSprite(this, local4, arg2, arg3);
        }
    }

    @OriginalMember(owner = "client!iaa", name = "T", descriptor = "(IIII)V")
    @Override
    public void T(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        if (this.clipX1 < arg0) {
            this.clipX1 = arg0;
        }
        if (this.clipY1 < arg1) {
            this.clipY1 = arg1;
        }
        if (this.clipX2 > arg2) {
            this.clipX2 = arg2;
        }
        if (this.clipY2 > arg3) {
            this.clipY2 = arg3;
        }
        this.updateViewport();
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!wp;Z)Lclient!st;")
    @Override
    public Sprite createSprite(@OriginalArg(0) IndexedImage arg0, @OriginalArg(1) boolean arg1) {
        @Pc(2) int[] local2 = arg0.palette;
        @Pc(5) byte[] local5 = arg0.raster;
        @Pc(8) int local8 = arg0.width;
        @Pc(11) int local11 = arg0.height;
        @Pc(80) JavaSprite local80;
        @Pc(22) int[] local22;
        @Pc(27) byte[] local27;
        @Pc(29) int local29;
        @Pc(34) int local34;
        @Pc(36) int local36;
        if (arg1 && arg0.alpha == null) {
            local22 = new int[local2.length];
            local27 = new byte[local8 * local11];
            for (local29 = 0; local29 < local11; local29++) {
                local34 = local29 * local8;
                for (local36 = 0; local36 < local8; local36++) {
                    local27[local34 + local36] = local5[local34 + local36];
                }
            }
            for (local34 = 0; local34 < local2.length; local34++) {
                local22[local34] = local2[local34];
            }
            local80 = new JavaIndexedSprite(this, local27, local22, local8, local11);
        } else {
            local22 = new int[local8 * local11];
            local27 = arg0.alpha;
            if (local27 == null) {
                for (local29 = 0; local29 < local11; local29++) {
                    local34 = local29 * local8;
                    for (local36 = 0; local36 < local8; local36++) {
                        @Pc(162) int local162 = local2[local5[local34 + local36] & 0xFF];
                        local22[local34 + local36] = local162 == 0 ? 0 : local162 | 0xFF000000;
                    }
                }
                local80 = new JavaRgbSprite(this, local22, local8, local11);
            } else {
                for (local29 = 0; local29 < local11; local29++) {
                    local34 = local29 * local8;
                    for (local36 = 0; local36 < local8; local36++) {
                        local22[local34 + local36] = local2[local5[local34 + local36] & 0xFF] | local27[local34 + local36] << 24;
                    }
                }
                local80 = new JavaArgbSprite(this, local22, local8, local11);
            }
        }
        local80.setOffsets(arg0.offX1, arg0.offY1, arg0.offX2, arg0.offY2);
        return local80;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(II[[I[[IIII)Lclient!s;")
    @Override
    public Ground createGround(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[][] arg2, @OriginalArg(3) int[][] arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        return new Ground_Sub3(this, arg4, arg5, arg0, arg1, arg2, arg3, 512);
    }

    @OriginalMember(owner = "client!iaa", name = "JA", descriptor = "(IIIIII)I")
    @Override
    public int JA(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
        @Pc(1) int local1 = 0;
        @Pc(26) float local26 = this.camera.e3_1 * (float) arg0 + this.camera.e3_2 * (float) arg1 + this.camera.e3_3 * (float) arg2 + this.camera.tz;
        if (local26 < 1.0F) {
            local26 = 1.0F;
        }
        @Pc(57) float local57 = this.camera.e3_1 * (float) arg3 + this.camera.e3_2 * (float) arg4 + this.camera.e3_3 * (float) arg5 + this.camera.tz;
        if (local57 < 1.0F) {
            local57 = 1.0F;
        }
        if (local26 < (float) this.zNear && local57 < (float) this.zNear) {
            local1 |= 0x10;
        } else if (local26 > (float) this.zFar && local57 > (float) this.zFar) {
            local1 |= 0x20;
        }
        @Pc(132) int local132 = (int) ((float) this.projectionScaleX * (this.camera.e1_1 * (float) arg0 + this.camera.e1_2 * (float) arg1 + this.camera.e1_3 * (float) arg2 + this.camera.tx) / local26);
        @Pc(164) int local164 = (int) ((float) this.projectionScaleX * (this.camera.e1_1 * (float) arg3 + this.camera.e1_2 * (float) arg4 + this.camera.e1_3 * (float) arg5 + this.camera.tx) / local57);
        if (local132 < this.viewX1 && local164 < this.viewX1) {
            local1 |= 0x1;
        } else if (local132 > this.viewX2 && local164 > this.viewX2) {
            local1 |= 0x2;
        }
        @Pc(225) int local225 = (int) ((float) this.projectionScaleY * (this.camera.e2_1 * (float) arg0 + this.camera.e2_2 * (float) arg1 + this.camera.e2_3 * (float) arg2 + this.camera.ty) / local26);
        @Pc(257) int local257 = (int) ((float) this.projectionScaleY * (this.camera.e2_1 * (float) arg3 + this.camera.e2_2 * (float) arg4 + this.camera.e2_3 * (float) arg5 + this.camera.ty) / local57);
        if (local225 < this.viewY1 && local257 < this.viewY1) {
            local1 |= 0x4;
        } else if (local225 > this.vewY2 && local257 > this.vewY2) {
            local1 |= 0x8;
        }
        return local1;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIII)V")
    @Override
    public void line(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2, @OriginalArg(4) int colour, @OriginalArg(5) int mode) {
        x2 -= x1;
        y2 -= y1;
        if (y2 == 0) {
            if (x2 >= 0) {
                this.U(x1, y1, x2 + 1, colour, mode);
            } else {
                this.U(x1 + x2, y1, 1 - x2, colour, mode);
            }
        } else if (x2 == 0) {
            if (y2 >= 0) {
                this.P(x1, y1, y2 + 1, colour, mode);
            } else {
                this.P(x1, y1 + y2, -y2 + 1, colour, mode);
            }
        } else {
            if (x2 + y2 < 0) {
                x1 += x2;
                x2 = -x2;
                y1 += y2;
                y2 = -y2;
            }

            if (x2 > y2) {
                y1 <<= 0x10;
                y1 += 32768;
                @Pc(100) int local100 = y2 << 16;
                @Pc(110) int local110 = (int) Math.floor((double) local100 / (double) x2 + 0.5D);
                x2 += x1;
                if (x1 < this.clipX1) {
                    y1 += local110 * (this.clipX1 - x1);
                    x1 = this.clipX1;
                }
                if (x2 >= this.clipX2) {
                    x2 = this.clipX2 - 1;
                }
                @Pc(143) int alpha = colour >>> 24;
                if (mode == 0 || (mode == 1 && alpha == 255)) {
                    while (x1 <= x2) {
                        @Pc(161) int local161 = y1 >> 16;
                        if (local161 >= this.clipY1 && local161 < this.clipY2) {
                            this.surfaceRaster[x1 + local161 * this.surfaceWidth] = colour;
                        }
                        y1 += local110;
                        x1++;
                    }
                } else if (mode == 1) {
                    @Pc(220) int local220 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
                    @Pc(161) int local161 = 256 - alpha;
                    while (x1 <= x2) {
                        @Pc(229) int local229 = y1 >> 16;
                        if (local229 >= this.clipY1 && local229 < this.clipY2) {
                            @Pc(246) int local246 = x1 + local229 * this.surfaceWidth;
                            @Pc(251) int local251 = this.surfaceRaster[local246];
                            local251 = ((local251 & 0xFF00FF) * local161 >> 8 & 0xFF00FF) + ((local251 & 0xFF00) * local161 >> 8 & 0xFF00);
                            this.surfaceRaster[local246] = local220 + local251;
                        }
                        y1 += local110;
                        x1++;
                    }
                } else if (mode == 2) {
                    while (x1 <= x2) {
                        @Pc(161) int local161 = y1 >> 16;
                        if (local161 >= this.clipY1 && local161 < this.clipY2) {
                            @Pc(229) int local229 = x1 + local161 * this.surfaceWidth;
                            @Pc(246) int local246 = this.surfaceRaster[local229];
                            @Pc(251) int local251 = colour + local246;
                            @Pc(331) int local331 = (colour & 0xFF00FF) + (local246 & 0xFF00FF);
                            local246 = (local331 & 0x1000100) + (local251 - local331 & 0x10000);
                            this.surfaceRaster[local229] = local251 - local246 | local246 - (local246 >>> 8);
                        }
                        y1 += local110;
                        x1++;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                x1 <<= 0x10;
                x1 += 32768;
                @Pc(380) int local380 = x2 << 16;
                @Pc(110) int local110 = (int) Math.floor((double) local380 / (double) y2 + 0.5D);
                y2 += y1;
                if (y1 < this.clipY1) {
                    x1 += local110 * (this.clipY1 - y1);
                    y1 = this.clipY1;
                }
                if (y2 >= this.clipY2) {
                    y2 = this.clipY2 - 1;
                }
                @Pc(143) int alpha = colour >>> 24;
                if (mode == 0 || (mode == 1 && alpha == 255)) {
                    while (y1 <= y2) {
                        @Pc(161) int local161 = x1 >> 16;
                        if (local161 >= this.clipX1 && local161 < this.clipX2) {
                            this.surfaceRaster[local161 + y1 * this.surfaceWidth] = colour;
                        }
                        x1 += local110;
                        y1++;
                    }
                } else if (mode == 1) {
                    @Pc(220) int local220 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
                    @Pc(161) int local161 = 256 - alpha;
                    while (y1 <= y2) {
                        @Pc(229) int local229 = x1 >> 16;
                        if (local229 >= this.clipX1 && local229 < this.clipX2) {
                            @Pc(246) int local246 = local229 + y1 * this.surfaceWidth;
                            @Pc(251) int local251 = this.surfaceRaster[local246];
                            local251 = ((local251 & 0xFF00FF) * local161 >> 8 & 0xFF00FF) + ((local251 & 0xFF00) * local161 >> 8 & 0xFF00);
                            this.surfaceRaster[local229 + y1 * this.surfaceWidth] = local220 + local251;
                        }
                        x1 += local110;
                        y1++;
                    }
                } else if (mode == 2) {
                    while (y1 <= y2) {
                        @Pc(161) int local161 = x1 >> 16;
                        if (local161 >= this.clipX1 && local161 < this.clipX2) {
                            @Pc(229) int local229 = local161 + y1 * this.surfaceWidth;
                            @Pc(246) int local246 = this.surfaceRaster[local229];
                            @Pc(251) int local251 = colour + local246;
                            @Pc(331) int local331 = (colour & 0xFF00FF) + (local246 & 0xFF00FF);
                            @Pc(626) int local626 = (local331 & 0x1000100) + (local251 - local331 & 0x10000);
                            this.surfaceRaster[local229] = local251 - local626 | local626 - (local626 >>> 8);
                        }
                        x1 += local110;
                        y1++;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(Z)V")
    @Override
    public void method8018(@OriginalArg(0) boolean arg0) {
    }

    @OriginalMember(owner = "client!iaa", name = "l", descriptor = "(I)[I")
    public int[] method3792(@OriginalArg(0) int arg0) {
        @Pc(2) ReferenceCache local2 = this.textureCache;
        @Pc(12) JavaAnimatedTexture local12;
        synchronized (this.textureCache) {
            local12 = (JavaAnimatedTexture) this.textureCache.get(arg0);
            if (local12 == null) {
                if (!super.textureSource.textureAvailable(arg0)) {
                    return null;
                }
                @Pc(34) TextureMetrics local34 = super.textureSource.getMetrics(arg0);
                @Pc(48) int local48 = local34.small || this.shrinkTextures ? 64 : this.textureSize;
                local12 = new JavaAnimatedTexture(arg0, local48, super.textureSource.rgbOutput(local48, true, local48, arg0, 0.7F), local34.alphaBlendMode != 1);
                this.textureCache.put(local12, arg0);
            }
        }
        local12.awaitingTick = true;
        return local12.method3972();
    }

    @OriginalMember(owner = "client!iaa", name = "r", descriptor = "()Z")
    @Override
    public boolean hardShadow() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "r", descriptor = "(IIIIIII)I")
    @Override
    public int r(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
        @Pc(24) float local24 = this.camera.e3_1 * (float) arg0 + this.camera.e3_2 * (float) arg1 + this.camera.e3_3 * (float) arg2 + this.camera.tz;
        @Pc(49) float local49 = this.camera.e3_1 * (float) arg3 + this.camera.e3_2 * (float) arg4 + this.camera.e3_3 * (float) arg5 + this.camera.tz;
        @Pc(51) int local51 = 0;
        if (local24 < (float) this.zNear && local49 < (float) this.zNear) {
            local51 |= 0x10;
        } else if (local24 > (float) this.zFar && local49 > (float) this.zFar) {
            local51 |= 0x20;
        }
        @Pc(121) int local121 = (int) ((float) this.projectionScaleX * (this.camera.e1_1 * (float) arg0 + this.camera.e1_2 * (float) arg1 + this.camera.e1_3 * (float) arg2 + this.camera.tx) / (float) arg6);
        @Pc(154) int local154 = (int) ((float) this.projectionScaleX * (this.camera.e1_1 * (float) arg3 + this.camera.e1_2 * (float) arg4 + this.camera.e1_3 * (float) arg5 + this.camera.tx) / (float) arg6);
        if (local121 < this.viewX1 && local154 < this.viewX1) {
            local51 |= 0x1;
        } else if (local121 > this.viewX2 && local154 > this.viewX2) {
            local51 |= 0x2;
        }
        @Pc(216) int local216 = (int) ((float) this.projectionScaleY * (this.camera.e2_1 * (float) arg0 + this.camera.e2_2 * (float) arg1 + this.camera.e2_3 * (float) arg2 + this.camera.ty) / (float) arg6);
        @Pc(249) int local249 = (int) ((float) this.projectionScaleY * (this.camera.e2_1 * (float) arg3 + this.camera.e2_2 * (float) arg4 + this.camera.e2_3 * (float) arg5 + this.camera.ty) / (float) arg6);
        if (local216 < this.viewY1 && local249 < this.viewY1) {
            local51 |= 0x4;
        } else if (local216 > this.vewY2 && local249 > this.vewY2) {
            local51 |= 0x8;
        }
        return local51;
    }

    @OriginalMember(owner = "client!iaa", name = "pa", descriptor = "()V")
    @Override
    public void pa() {
        for (@Pc(1) int local1 = 0; local1 < this.resources.length; local1++) {
            this.resources[local1].fogColour = this.resources[local1].anInt10600;
            this.resources[local1].aBoolean805 = false;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "m", descriptor = "(I)I")
    public int method3793(@OriginalArg(0) int arg0) {
        return super.textureSource.getMetrics(arg0).aShort37 & 0xFFFF;
    }

    @OriginalMember(owner = "client!iaa", name = "X", descriptor = "(I)V")
    @Override
    public void X(@OriginalArg(0) int arg0) {
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(IIIIIIII)V")
    public void method3794(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
        if (arg1 < this.clipY1 || arg1 >= this.clipY2) {
            return;
        }
        @Pc(18) int local18 = arg0 + arg1 * this.surfaceWidth;
        @Pc(22) int local22 = arg3 >>> 24;
        @Pc(26) int local26 = arg4 + arg5;
        @Pc(30) int local30 = arg6 % local26;
        @Pc(44) int local44;
        if (local22 == 255 && true) {
            local44 = 0;
            while (local44 < arg2) {
                if (arg0 + local44 >= this.clipX1 && arg0 + local44 < this.clipX2 && local30 < arg4) {
                    this.surfaceRaster[local18 + local44] = arg3;
                }
                local44++;
                local30++;
                local30 %= local26;
            }
            return;
        }
        @Pc(111) int local111 = ((arg3 & 0xFF00FF) * local22 >> 8 & 0xFF00FF) + ((arg3 & 0xFF00) * local22 >> 8 & 0xFF00) + (local22 << 24);
        local44 = 256 - local22;
        @Pc(117) int local117 = 0;
        while (local117 < arg2) {
            if (arg0 + local117 >= this.clipX1 && arg0 + local117 < this.clipX2 && local30 < arg4) {
                @Pc(144) int local144 = this.surfaceRaster[local18 + local117];
                @Pc(164) int local164 = ((local144 & 0xFF00FF) * local44 >> 8 & 0xFF00FF) + ((local144 & 0xFF00) * local44 >> 8 & 0xFF00);
                this.surfaceRaster[local18 + local117] = local111 + local164;
            }
            local117++;
            local30++;
            local30 %= local26;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "e", descriptor = "(II)V")
    @Override
    public void flip(@OriginalArg(0) int x, @OriginalArg(1) int y) throws FlipException {
        if (this.canvas == null || this.surface == null) {
            throw new IllegalStateException("off");
        }

        try {
            @Pc(19) Graphics graphics = this.canvas.getGraphics();
            this.surface.clip(0, 0, x, y, this.canvasWidth, this.canvasHeight, graphics);
        } catch (@Pc(34) Exception local34) {
            this.canvas.repaint();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(IIIID)V")
    @Override
    public void b(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) double zDepth) {
        @Pc(4) int step = this.depthWidth - width;
        @Pc(11) int offset = y * this.depthWidth + x;
        @Pc(14) float[] depths = this.depthBuffer;
        @Pc(16) int row = 0;

        while (row < height) {
            @Pc(19) int col = 0;

            while (col < width) {
                @Pc(24) float z = depths[offset];

                if (z != 2.14748365E9F) {
                    depths[offset] = (float) ((double) z + zDepth);
                }

                col++;
                offset++;
            }

            row++;
            offset += step;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!ve;[Lclient!wp;Z)Lclient!da;")
    @Override
    public Font createFont(@OriginalArg(0) FontMetrics metrics, @OriginalArg(1) IndexedImage[] images, @OriginalArg(2) boolean monospaced) {
        @Pc(3) int[] widths = new int[images.length];
        @Pc(7) int[] heights = new int[images.length];
        @Pc(9) boolean alpha = false;

        for (@Pc(11) int i = 0; i < images.length; i++) {
            widths[i] = images[i].width;
            heights[i] = images[i].height;

            if (images[i].alpha != null) {
                alpha = true;
            }
        }

        if (monospaced) {
            if (alpha) {
                return new JavaMonoAlphaFont(this, metrics, images, widths, heights);
            } else {
                return new JavaMonoFont(this, metrics, images, widths, heights);
            }
        } else if (alpha) {
            throw new IllegalArgumentException("");
        } else {
            return new JavaFont(this, metrics, images, widths, heights);
        }
    }

    @OriginalMember(owner = "client!iaa", name = "Q", descriptor = "(IIIIII[BII)V")
    @Override
    public void Q(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int overlayColour, @OriginalArg(5) int underlayColour, @OriginalArg(6) byte[] shape, @OriginalArg(7) int size, @OriginalArg(8) int mode) {
        if (width <= 0 || height <= 0) {
            return;
        }

        @Pc(9) int shapePointer = 0;
        @Pc(11) int shapeOffset = 0;
        @Pc(17) int shapeHorizontalStep = (size << 16) / width;
        @Pc(26) int shapeVerticalStep = (shape.length / size << 16) / height;
        @Pc(33) int surfacePointer = x + y * this.surfaceWidth;
        @Pc(38) int surfaceStep = this.surfaceWidth - width;

        if (y + height > this.clipY2) {
            height -= y + height - this.clipY2;
        }
        if (y < this.clipY1) {
            @Pc(62) int deltaY = this.clipY1 - y;
            height -= deltaY;
            surfacePointer += deltaY * this.surfaceWidth;
            shapeOffset += shapeVerticalStep * deltaY;
        }
        if (x + width > this.clipX2) {
            @Pc(62) int deltaX = x + width - this.clipX2;
            width -= deltaX;
            surfaceStep += deltaX;
        }
        if (x < this.clipX1) {
            @Pc(62) int deltaX = this.clipX1 - x;
            width -= deltaX;
            surfacePointer += deltaX;
            shapePointer += shapeHorizontalStep * deltaX;
            surfaceStep += deltaX;
        }

        @Pc(62) int overlayAlpha = overlayColour >>> 24;
        @Pc(135) int underlayAlpha = underlayColour >>> 24;

        if (mode == 0 || (mode == 1 && overlayAlpha == 255 && underlayAlpha == 255)) {
            @Pc(154) int shapeStart = shapePointer;

            for (@Pc(157) int i = -height; i < 0; i++) {
                @Pc(164) int offset = (shapeOffset >> 16) * size;

                for (@Pc(167) int j = -width; j < 0; j++) {
                    if (shape[(shapePointer >> 16) + offset] == 0) {
                        this.surfaceRaster[surfacePointer++] = overlayColour;
                    } else {
                        this.surfaceRaster[surfacePointer++] = underlayColour;
                    }

                    shapePointer += shapeHorizontalStep;
                }

                shapeOffset += shapeVerticalStep;
                shapePointer = shapeStart;
                surfacePointer += surfaceStep;
            }
        } else if (mode == 1) {
            @Pc(154) int shapeStart = shapePointer;

            for (@Pc(157) int i = -height; i < 0; i++) {
                @Pc(164) int offset = (shapeOffset >> 16) * size;

                for (@Pc(167) int j = -width; j < 0; j++) {
                    @Pc(233) int newColour = overlayColour;
                    if (shape[(shapePointer >> 16) + offset] != 0) {
                        newColour = underlayColour;
                    }

                    @Pc(247) int alpha = newColour >>> 24;
                    @Pc(251) int opacity = 255 - alpha;
                    @Pc(256) int colour = this.surfaceRaster[surfacePointer];
                    this.surfaceRaster[surfacePointer++] = ((newColour & 0xFF00FF) * alpha + (colour & 0xFF00FF) * opacity & 0xFF00FF00) + ((newColour & 0xFF00) * alpha + (colour & 0xFF00) * opacity & 0xFF0000) >> 8;
                    shapePointer += shapeHorizontalStep;
                }

                shapeOffset += shapeVerticalStep;
                shapePointer = shapeStart;
                surfacePointer += surfaceStep;
            }
        } else if (mode == 2) {
            @Pc(154) int local154 = shapePointer;

            for (@Pc(157) int i = -height; i < 0; i++) {
                @Pc(164) int offset = (shapeOffset >> 16) * size;

                for (@Pc(167) int j = -width; j < 0; j++) {
                    @Pc(233) int newColour = overlayColour;
                    if (shape[(shapePointer >> 16) + offset] != 0) {
                        newColour = underlayColour;
                    }

                    if (newColour == 0) {
                        surfacePointer++;
                    } else {
                        @Pc(247) int colour = this.surfaceRaster[surfacePointer];
                        @Pc(251) int combinedColour = newColour + colour;
                        @Pc(256) int combinedRb = (newColour & 0xFF00FF) + (colour & 0xFF00FF);
                        @Pc(372) int destColour = (combinedRb & 0x1000100) + (combinedColour - combinedRb & 0x10000);
                        this.surfaceRaster[surfacePointer++] = combinedColour - destColour | destColour - (destColour >>> 8);
                    }

                    shapePointer += shapeHorizontalStep;
                }

                shapeOffset += shapeVerticalStep;
                shapePointer = local154;
                surfacePointer += surfaceStep;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "j", descriptor = "()V")
    @Override
    public void method7950() {
    }

    @OriginalMember(owner = "client!iaa", name = "m", descriptor = "()Z")
    @Override
    public boolean hasBloom() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIILclient!aa;IIIII)V")
    @Override
    public void method7942(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2, @OriginalArg(4) int colour, @OriginalArg(5) int mode, @OriginalArg(6) ClippingMask mask, @OriginalArg(7) int maskX, @OriginalArg(8) int maskY, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) int arg10) {
        @Pc(2) JavaClippingMask local2 = (JavaClippingMask) mask;
        @Pc(5) int[] local5 = local2.lineOffsets;
        @Pc(8) int[] local8 = local2.lineWidths;
        @Pc(18) int local18 = this.clipY1 > maskY ? this.clipY1 : maskY;
        @Pc(34) int local34 = this.clipY2 < maskY + local5.length ? this.clipY2 : maskY + local5.length;
        @Pc(38) int local38 = arg10 << 8;
        @Pc(42) int local42 = arg8 << 8;
        @Pc(46) int local46 = arg9 << 8;
        @Pc(50) int local50 = local42 + local46;
        arg10 = local38 % local50;
        x2 -= x1;
        y2 -= y1;

        if (x2 + y2 < 0) {
            @Pc(79) int local79 = (int) (Math.sqrt(x2 * x2 + y2 * y2) * 256.0D);
            @Pc(83) int local83 = local79 % local50;
            local38 = local50 + local42 - arg10 - local83;
            arg10 = local38 % local50;
            if (arg10 < 0) {
                arg10 += local50;
            }
            x1 += x2;
            x2 = -x2;
            y1 += y2;
            y2 = -y2;
        }

        if (x2 > y2) {
            y1 <<= 0x10;
            y1 += 32768;
            @Pc(130) int local130 = y2 << 16;
            @Pc(79) int local79 = (int) Math.floor((double) local130 / (double) x2 + 0.5D);
            @Pc(144) int local144 = x2 + x1;
            @Pc(83) int alpha = colour >>> 24;
            @Pc(161) int local161 = (int) Math.sqrt((local79 >> 8) * (local79 >> 8) + 65536);
            if (mode == 0 || (mode == 1 && alpha == 255)) {
                while (x1 <= local144) {
                    @Pc(179) int local179 = y1 >> 16;
                    @Pc(183) int local183 = local179 - maskY;
                    if (x1 >= this.clipX1 && x1 < this.clipX2 && local179 >= local18 && local179 < local34 && arg10 < local42) {
                        @Pc(214) int local214 = maskX + local5[local183];
                        if (x1 >= local214 && x1 < local214 + local8[local183]) {
                            this.surfaceRaster[x1 + local179 * this.surfaceWidth] = colour;
                        }
                    }
                    y1 += local79;
                    x1++;
                    local38 = arg10 + local161;
                    arg10 = local38 % local50;
                }
            } else if (mode == 1) {
                @Pc(283) int local283 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
                @Pc(179) int local179 = 256 - alpha;
                while (x1 <= local144) {
                    @Pc(183) int local183 = y1 >> 16;
                    @Pc(214) int local214 = local183 - maskY;
                    if (x1 >= this.clipX1 && x1 < this.clipX2 && local183 >= local18 && local183 < local34 && arg10 < local42) {
                        @Pc(327) int local327 = maskX + local5[local214];
                        if (x1 >= local327 && x1 < local327 + local8[local214]) {
                            @Pc(346) int local346 = x1 + local183 * this.surfaceWidth;
                            @Pc(351) int local351 = this.surfaceRaster[local346];
                            @Pc(371) int local371 = ((local351 & 0xFF00FF) * local179 >> 8 & 0xFF00FF) + ((local351 & 0xFF00) * local179 >> 8 & 0xFF00);
                            this.surfaceRaster[local346] = local283 + local371;
                        }
                    }
                    y1 += local79;
                    x1++;
                    local38 = arg10 + local161;
                    arg10 = local38 % local50;
                }
            } else if (mode == 2) {
                while (x1 <= local144) {
                    @Pc(183) int local183 = y1 >> 16;
                    @Pc(214) int local214 = local183 - maskY;
                    if (x1 >= this.clipX1 && x1 < this.clipX2 && local183 >= local18 && local183 < local34 && arg10 < local42) {
                        @Pc(327) int local327 = maskX + local5[local214];
                        if (x1 >= local327 && x1 < local327 + local8[local214]) {
                            @Pc(346) int local346 = x1 + local183 * this.surfaceWidth;
                            @Pc(351) int local351 = this.surfaceRaster[local346];
                            @Pc(371) int local371 = colour + local351;
                            int i_592_ = (colour & 0xff00ff) + (local351 & 0xff00ff);
                            local351 = (i_592_ & 0x1000100) + (local371 - i_592_ & 0x10000);
                            this.surfaceRaster[local346] = local371 - local351 | local351 - (local351 >>> 8);
                        }
                    }
                    y1 += local79;
                    x1++;
                    local38 = arg10 + local161;
                    arg10 = local38 % local50;
                }
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            x1 <<= 0x10;
            x1 += 32768;
            @Pc(144) int local144 = x2 << 16;
            @Pc(79) int local79 = (int) Math.floor((double) local144 / (double) y2 + 0.5D);
            @Pc(83) int local83 = (int) Math.sqrt((local79 >> 8) * (local79 >> 8) + 65536);
            @Pc(130) int local130 = y2 + y1;
            @Pc(161) int alpha = colour >>> 24;
            if (mode == 0 || (mode == 1 && alpha == 255)) {
                while (y1 <= local130) {
                    @Pc(179) int local179 = x1 >> 16;
                    @Pc(183) int local183 = y1 - maskY;
                    if (y1 >= local18 && y1 < local34 && local179 >= this.clipX1 && local179 < this.clipX2 && arg10 < local42 && local179 >= maskX + local5[local183] && local179 < maskX + local5[local183] + local8[local183]) {
                        this.surfaceRaster[local179 + y1 * this.surfaceWidth] = colour;
                    }
                    x1 += local79;
                    y1++;
                    local38 = arg10 + local83;
                    arg10 = local38 % local50;
                }
            } else if (mode == 1) {
                @Pc(283) int local283 = ((colour & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((colour & 0xFF00) * alpha >> 8 & 0xFF00) + (alpha << 24);
                @Pc(179) int local179 = 256 - alpha;
                while (y1 <= local130) {
                    @Pc(183) int local183 = x1 >> 16;
                    @Pc(214) int local214 = y1 - maskY;
                    if (y1 >= local18 && y1 < local34 && local183 >= this.clipX1 && local183 < this.clipX2 && arg10 < local42 && local183 >= maskX + local5[local214] && local183 < maskX + local5[local214] + local8[local214]) {
                        @Pc(327) int local327 = local183 + y1 * this.surfaceWidth;
                        @Pc(346) int local346 = this.surfaceRaster[local327];
                        @Pc(782) int local782 = ((local346 & 0xFF00FF) * local179 >> 8 & 0xFF00FF) + ((local346 & 0xFF00) * local179 >> 8 & 0xFF00);
                        this.surfaceRaster[local183 + y1 * this.surfaceWidth] = local283 + local782;
                    }
                    x1 += local79;
                    y1++;
                    local38 = arg10 + local83;
                    arg10 = local38 % local50;
                }
            } else if (mode == 2) {
                while (y1 <= local130) {
                    @Pc(183) int local183 = x1 >> 16;
                    @Pc(214) int local214 = y1 - maskY;
                    if (y1 >= local18 && y1 < local34 && local183 >= this.clipX1 && local183 < this.clipX2 && arg10 < local42 && local183 >= maskX + local5[local214] && local183 < maskX + local5[local214] + local8[local214]) {
                        @Pc(327) int local327 = local183 + y1 * this.surfaceWidth;
                        @Pc(346) int local346 = this.surfaceRaster[local327];
                        @Pc(782) int local782 =colour + local346;
                        int i_608_ = (colour & 0xff00ff) + (local346 & 0xff00ff);
                        local346 = (i_608_ & 0x1000100) + (local782 - i_608_ & 0x10000);
                        this.surfaceRaster[local327] = local782 - local346 | local346 - (local346 >>> 8);
                    }
                    x1 += local79;
                    y1++;
                    local38 = arg10 + local83;
                    arg10 = local38 % local50;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "p", descriptor = "(I)I")
    public int textureAlphaBlendMode(@OriginalArg(0) int arg0) {
        return super.textureSource.getMetrics(arg0).alphaBlendMode;
    }

    @OriginalMember(owner = "client!iaa", name = "z", descriptor = "()Z")
    @Override
    public boolean method7990() {
        return true;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!eca;Lclient!wja;)Lclient!gaa;")
    @Override
    public OffscreenSurface createOffscreenSurface(@OriginalArg(0) Surface surface, @OriginalArg(1) DepthBuffer buffer) {
        return new JavaOffscreenSurface(this, (Sprite) surface, (Class165) buffer);
    }

    @OriginalMember(owner = "client!iaa", name = "e", descriptor = "()I")
    @Override
    public int getMaxLights() {
        return 0;
    }

    @OriginalMember(owner = "client!iaa", name = "t", descriptor = "()Z")
    @Override
    public boolean supportsAntiAliasing() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIZ)Lclient!st;")
    @Override
    public Sprite createSprite(@OriginalArg(0) int with, @OriginalArg(1) int height, @OriginalArg(2) boolean transparent) {
        return transparent ? new JavaArgbSprite(this, with, height) : new JavaRgbSprite(this, with, height);
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "()Z")
    @Override
    public boolean method7992() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "v", descriptor = "()V")
    @Override
    public void restoreSurface() {
        if (this.canvas == null) {
            this.surfaceWidth = 1;
            this.surfaceHeight = 1;
            this.surfaceRaster = null;
            this.depthWidth = 1;
            this.depthHeight = 1;
            this.depthBuffer = null;
        } else {
            this.surfaceRaster = this.surface.raster;
            this.surfaceWidth = this.surface.width;
            this.surfaceHeight = this.surface.height;
            this.depthBuffer = this.mainDepthBuffer;
            this.depthWidth = this.mainSurfaceWidth;
            this.depthHeight = this.mainSurfaceHeight;
        }
        this.offscreenSurface = null;
        this.reset();
    }

    @OriginalMember(owner = "client!iaa", name = "L", descriptor = "(III)V")
    @Override
    public void L(@OriginalArg(0) int colour, @OriginalArg(1) int range, @OriginalArg(2) int offset) {
        for (@Pc(1) int local1 = 0; local1 < this.resources.length; local1++) {
            @Pc(7) JavaThreadResource resource = this.resources[local1];
            resource.fogColour = colour & 0xFFFFFF;
            @Pc(19) int red = resource.fogColour >>> 16 & 0xFF;
            if (red < 2) {
                red = 2;
            }
            @Pc(31) int green = resource.fogColour >> 8 & 0xFF;
            if (green < 2) {
                green = 2;
            }
            @Pc(41) int blue = resource.fogColour & 0xFF;
            if (blue < 2) {
                blue = 2;
            }

            resource.fogColour = red << 16 | green << 8 | blue;

            if (range < 0) {
                resource.fogActive = false;
            } else {
                resource.fogActive = true;
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(I[Lclient!lca;)V")
    @Override
    public void method8009(@OriginalArg(0) int arg0, @OriginalArg(1) PointLight[] arg1) {
    }

    @OriginalMember(owner = "client!iaa", name = "d", descriptor = "(I)Z")
    public boolean textureRepeats(@OriginalArg(0) int id) {
        return super.textureSource.getMetrics(id).aBoolean236 || super.textureSource.getMetrics(id).aBoolean235;
    }

    @OriginalMember(owner = "client!iaa", name = "I", descriptor = "()I")
    @Override
    public int I() {
        @Pc(2) int local2 = this.count;
        this.count = 0;
        return local2;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(IIIIIIIIII)V")
    public void method3797(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int id, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9) {
        if (arg3 == 0 || arg4 == 0) {
            return;
        }
        if (id == 65535 || super.textureSource.getMetrics(id).disableable) {
            this.method3790(arg0, arg1, arg2, arg3, arg7, arg9);
            return;
        }
        if (this.textureId != id) {
            @Pc(33) Sprite sprite = (Sprite) this.spriteCache.get(id);
            if (sprite == null) {
                @Pc(39) int[] local39 = this.getArgbTexture(id);
                if (local39 == null) {
                    return;
                }
                @Pc(53) int size = this.smallTexture(id) ? 64 : this.textureSize;
                sprite = this.createSprite(size, size, size, local39);
                this.spriteCache.put(sprite, id);
            }
            this.textureId = id;
            this.sprite = sprite;
        }
        ((JavaSprite) this.sprite).method8207(arg0 - arg3, arg1 - arg4, arg2, arg3 << 1, arg4 << 1, arg8, arg7, arg9);
    }

    @OriginalMember(owner = "client!iaa", name = "la", descriptor = "()V")
    @Override
    public void la() {
        this.clipX1 = 0;
        this.clipY1 = 0;
        this.clipX2 = this.surfaceWidth;
        this.clipY2 = this.surfaceHeight;
        this.updateViewport();
    }

    @OriginalMember(owner = "client!iaa", name = "q", descriptor = "(I)Z")
    public boolean smallTexture(@OriginalArg(0) int arg0) {
        return this.shrinkTextures || super.textureSource.getMetrics(arg0).small;
    }

    @OriginalMember(owner = "client!iaa", name = "w", descriptor = "()Z")
    @Override
    public boolean bloom() {
        return false;
    }

    @OriginalMember(owner = "client!iaa", name = "C", descriptor = "()V")
    public void updateViewport() {
        this.viewX1 = this.clipX1 - this.projectionCenterX;
        this.viewX2 = this.clipX2 - this.projectionCenterX;
        this.viewY1 = this.clipY1 - this.projectionCenterY;
        this.vewY2 = this.clipY2 - this.projectionCenterY;

        for (@Pc(29) int i = 0; i < this.threadCount; i++) {
            @Pc(36) Rasterizer local36 = this.resources[i].rasterizer;
            local36.minX = this.projectionCenterX - this.clipX1;
            local36.minY = this.projectionCenterY - this.clipY1;
            local36.width = this.clipX2 - this.clipX1;
            local36.height = this.clipY2 - this.clipY1;
        }

        @Pc(78) int pixel = (this.clipY1 * this.surfaceWidth) + this.clipX1;
        for (@Pc(81) int y = this.clipY1; y < this.clipY2; y++) {
            for (@Pc(84) int i = 0; i < this.threadCount; i++) {
                this.resources[i].rasterizer.lineOffsets[y - this.clipY1] = pixel;
            }
            pixel += this.surfaceWidth;
        }
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(Ljava/awt/Canvas;II)V")
    @Override
    public void addCanvas(@OriginalArg(0) Canvas canvas, @OriginalArg(1) int width, @OriginalArg(2) int height) {
        @Pc(8) JavaSurface surface = this.surfaces.get(canvas.hashCode());

        if (surface == null) {
            surface = JavaSurface.create(canvas, width, height);
            this.surfaces.put(canvas.hashCode(), surface);
        } else if (surface.width != width || surface.height != height) {
            this.resizeCanvas(canvas, width, height);
        }
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!tt;)V")
    @Override
    public void setCamera(@OriginalArg(0) Matrix matrix) {
        this.camera = (JavaMatrix) matrix;
    }

    @OriginalMember(owner = "client!iaa", name = "na", descriptor = "(IIII)[I")
    @Override
    public int[] na(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        @Pc(4) int[] area = new int[width * height];
        @Pc(6) int destPixel = 0;
        for (@Pc(8) int currY = 0; currY < height; currY++) {
            @Pc(18) int sourcePixel = (y + currY) * this.surfaceWidth + x;
            for (@Pc(20) int currX = 0; currX < width; currX++) {
                area[destPixel++] = this.surfaceRaster[sourcePixel + currX];
            }
        }
        return area;
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(Lclient!lk;)V")
    @Override
    public void render(@OriginalArg(0) ParticleList particleList) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        @Pc(7) Node2 sentinel = particleList.particles.sentinel;

        for (@Pc(10) Node2 node = sentinel.next2; node != sentinel; node = node.next2) {
            @Pc(14) Particle particle = (Particle) node;
            @Pc(19) int x = particle.x >> 12;
            @Pc(24) int y = particle.y >> 12;
            @Pc(29) int z = particle.z >> 12;
            @Pc(54) float depth = this.camera.tz + this.camera.e3_1 * (float) x + this.camera.e3_2 * (float) y + this.camera.e3_3 * (float) z;

            if (!(depth < (float) this.zNear) && !(depth > (float) resource.fogPlane)) {
                @Pc(105) int px = this.projectionCenterX + (int) ((float) this.projectionScaleX * (this.camera.tx + this.camera.e1_1 * (float) x + this.camera.e1_2 * (float) y + this.camera.e1_3 * (float) z) / depth);
                @Pc(140) int pz = this.projectionCenterY + (int) ((float) this.projectionScaleY * (this.camera.ty + this.camera.e2_1 * (float) x + this.camera.e2_2 * (float) y + this.camera.e2_3 * (float) z) / depth);

                if (px >= this.clipX1 && px <= this.clipX2 && pz >= this.clipY1 && pz <= this.clipY2) {
                    if (depth == 0.0F) {
                        depth = 1.0F;
                    }

                    this.render(particle, px, pz, (int) depth, (int) ((float) (particle.size * this.projectionScaleX >> 12) / depth));
                }
            }
        }
    }

    @OriginalMember(owner = "client!iaa", name = "c", descriptor = "(IIIIII)Lclient!pu;")
    @Override
    public Class67 method8008(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
        return null;
    }

    @OriginalMember(owner = "client!iaa", name = "b", descriptor = "(Ljava/awt/Canvas;)V")
    @Override
    public void releaseSurface(@OriginalArg(0) Canvas canvas) {
        if (this.canvas == canvas) {
            this.setCanvas(null);
        }

        @Pc(17) JavaSurface surface = (JavaSurface) this.surfaces.get(canvas.hashCode());
        if (surface != null) {
            surface.unlink();
        }
    }

    @OriginalMember(owner = "client!iaa", name = "EA", descriptor = "(IIII)V")
    @Override
    public void EA(@OriginalArg(0) int height, @OriginalArg(1) int colour, @OriginalArg(2) int depth, @OriginalArg(3) int bias) {
        @Pc(3) JavaThreadResource resource = this.threadResource(Thread.currentThread());
        resource.waterHeight = height;
        resource.fogColour = colour;
        resource.waterDepth = depth;
    }

    @OriginalMember(owner = "client!iaa", name = "y", descriptor = "()Lclient!tt;")
    @Override
    public Matrix createMatrix() {
        return new JavaMatrix();
    }

    @OriginalMember(owner = "client!iaa", name = "a", descriptor = "(I)Lclient!za;")
    @Override
    public MemoryPool createHeap(@OriginalArg(0) int size) {
        return null;
    }
}
