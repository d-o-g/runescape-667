import com.jagex.core.io.Packet;
import com.jagex.game.collision.CollisionMap;
import com.jagex.game.runetek6.config.flotype.FloorOverlayType;
import com.jagex.game.runetek6.config.flotype.FloorOverlayTypeList;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayType;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayTypeList;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qja")
public class Class306 {

    @OriginalMember(owner = "client!ji", name = "I", descriptor = "[I")
    public static final int[] OVERLAY_FACE_COUNT = {2, 1, 1, 1, 2, 2, 2, 1, 3, 3, 3, 2, 0, 4, 0};

    @OriginalMember(owner = "client!iba", name = "i", descriptor = "[[I")
    public static final int[][] TILE_FACE_A = {{0, 2}, {0, 2}, {0, 0, 2}, {2, 0, 0}, {0, 2, 0}, {0, 0, 2}, {0, 5, 1, 4}, {0, 4, 4, 4}, {4, 4, 4, 0}, {6, 6, 6, 2, 2, 2}, {2, 2, 2, 6, 6, 6}, {0, 11, 6, 6, 6, 4}, {0, 2}, {0, 4, 4, 4}, {0, 4, 4, 4}};

    @OriginalMember(owner = "client!rfa", name = "w", descriptor = "[[I")
    public static final int[][] TILE_FACE_C = {{6, 6}, {6, 6}, {6, 5, 5}, {5, 6, 5}, {5, 5, 6}, {6, 5, 5}, {5, 0, 4, 1}, {7, 7, 1, 2}, {7, 1, 2, 7}, {8, 9, 4, 0, 8, 9}, {0, 8, 9, 8, 9, 4}, {11, 0, 10, 11, 4, 2}, {6, 6}, {7, 7, 1, 2}, {7, 7, 1, 2}};

    @OriginalMember(owner = "client!qb", name = "o", descriptor = "[[I")
    public static final int[][] anIntArrayArray193 = {{2, 4, 6, 0}, {0, 2, 3, 5, 6, 4}, {0, 1, 4, 5}, {4, 6, 0, 2}, {2, 4, 0}, {0, 2, 4}, {6, 0, 1, 2, 4, 5}, {0, 1, 2, 4, 6, 7}, {4, 7, 6, 0}, {0, 8, 6, 1, 9, 2, 9, 4}, {2, 9, 4, 0, 8, 6}, {2, 11, 3, 7, 10, 10, 6, 6}, {2, 4, 6, 0}};

    @OriginalMember(owner = "client!he", name = "f", descriptor = "[[I")
    public static final int[][] anIntArrayArray90 = {{0, 2, 4, 6}, {6, 0, 2, 3, 5, 3}, {6, 0, 2, 4}, {2, 5, 6, 1}, {0, 2, 6}, {6, 0, 2}, {5, 6, 0, 1, 2, 4}, {7, 7, 1, 2, 4, 6}, {2, 4, 4, 7}, {6, 6, 4, 0, 1, 1, 3, 3}, {0, 2, 2, 6, 6, 4}, {0, 2, 2, 3, 7, 0, 4, 3}, {0, 2, 4, 6}};

    @OriginalMember(owner = "client!gka", name = "q", descriptor = "[[I")
    public static final int[][] anIntArrayArray86 = {{12, 12, 12, 12}, {12, 12, 12, 12, 12, 5}, {5, 5, 1, 1}, {5, 1, 1, 5}, {5, 5, 5}, {5, 5, 5}, {12, 12, 12, 12, 12, 12}, {1, 12, 12, 12, 12, 12}, {1, 1, 7, 1}, {8, 9, 9, 8, 8, 3, 1, 9}, {8, 8, 9, 8, 9, 9}, {10, 10, 11, 11, 11, 7, 3, 7}, {12, 12, 12, 12}};

    @OriginalMember(owner = "client!kv", name = "C", descriptor = "[I")
    public static final int[] anIntArray424 = {4, 2, 1, 1, 2, 2, 3, 1, 3, 3, 3, 2, 0};

    @OriginalMember(owner = "client!dd", name = "F", descriptor = "[I")
    public static final int[] UNDERLAY_FACE_COUNT = {0, 1, 2, 2, 1, 1, 2, 3, 1, 3, 3, 4, 2, 0, 4};

    @OriginalMember(owner = "client!uw", name = "y", descriptor = "[I")
    public static final int[] anIntArray468 = {0, 4, 3, 3, 1, 1, 3, 5, 1, 5, 3, 6, 4};

    @OriginalMember(owner = "client!rga", name = "j", descriptor = "[[I")
    public static final int[][] anIntArrayArray206 = {{0, 1, 2, 3}, {1, -1, -1, 0}, {-1, 2, -1, 0}, {-1, 0, -1, 2}, {0, 1, -1, 2}, {1, 2, -1, 0}, {-1, 4, -1, 1}, {-1, 3, 4, -1}, {-1, 0, 2, -1}, {-1, -1, 2, 0}, {0, 2, 5, 3}, {0, -1, 6, -1}, {0, 1, 2, 3}};

    @OriginalMember(owner = "client!lw", name = "j", descriptor = "[I")
    public static final int[] anIntArray464 = {0, 2, 2, 2, 1, 1, 3, 3, 1, 3, 3, 4, 4};

    @OriginalMember(owner = "client!sha", name = "k", descriptor = "[[I")
    public static final int[][] TILE_FACE_B = new int[][]{{2, 4}, {2, 4}, {5, 2, 4}, {4, 5, 2}, {2, 4, 5}, {5, 2, 4}, {1, 6, 2, 5}, {1, 6, 7, 1}, {6, 7, 1, 1}, {0, 8, 9, 8, 9, 4}, {8, 9, 4, 0, 8, 9}, {2, 10, 0, 10, 11, 11}, {2, 4}, {1, 6, 7, 1}, {1, 6, 7, 1}};

    @OriginalMember(owner = "client!tha", name = "f", descriptor = "[I")
    public static final int[] OVERLAY_BLEND_PRIORITIES = new int[13];

    @OriginalMember(owner = "client!oka", name = "c", descriptor = "[[Z")
    public static final boolean[][] aBooleanArrayArray6 = new boolean[][]{new boolean[4], {false, true, true, false}, {true, false, true, false}, {true, false, true, false}, {false, false, true, false}, {false, false, true, false}, {true, false, true, false}, {true, false, false, true}, {true, false, false, true}, {true, true, false, false}, new boolean[4], {false, true, false, true}, new boolean[4]};

    @OriginalMember(owner = "client!nm", name = "B", descriptor = "[[Z")
    public static final boolean[][] aBooleanArrayArray5 = new boolean[][]{new boolean[4], new boolean[4], {false, false, true, false}, {false, false, true, false}, {false, false, true, false}, {false, false, true, false}, {true, false, true, false}, {true, false, false, true}, {true, false, false, true}, new boolean[4], new boolean[4], new boolean[4], new boolean[4]};

    @OriginalMember(owner = "client!kba", name = "H", descriptor = "[I")
    public static final int[] OVERLAY_COLOURS = new int[13];

    @OriginalMember(owner = "client!ica", name = "n", descriptor = "[I")
    public static final int[] OVERLAY_BLEND_COLOURS = new int[13];

    @OriginalMember(owner = "client!eq", name = "m", descriptor = "[I")
    public static final int[] OVERLAY_TEXTURES = new int[13];

    @OriginalMember(owner = "client!pn", name = "db", descriptor = "[[Z")
    public static final boolean[][] aBooleanArrayArray7 = new boolean[][]{{true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, false, false, false, true, true, false, false, false, false, true}, {true, false, false, false, false, true, true, true, false, false, false, false, false}, {false, false, true, true, true, true, false, false, false, false, false, false, false}, {true, true, true, true, true, true, false, false, false, false, false, false, false}, {true, true, true, false, false, true, true, true, false, false, false, false, false}, {true, true, false, false, false, true, true, true, false, false, false, false, true}, {true, true, false, false, false, false, false, true, false, false, false, false, false}, {false, true, true, true, true, true, true, true, false, false, false, false, false}, {true, false, false, false, true, true, true, true, true, true, false, false, false}, {true, true, true, true, true, false, false, false, true, true, false, false, false}, {true, true, true, false, false, false, false, false, false, false, true, true, false}, new boolean[13], {true, true, true, true, true, true, true, true, true, true, true, true, true}, new boolean[13]};

    @OriginalMember(owner = "client!hm", name = "b", descriptor = "[I")
    public static final int[] anIntArray313 = new int[13];

    @OriginalMember(owner = "client!pka", name = "d", descriptor = "[I")
    public static final int[] anIntArray601 = new int[]{4, 2, 1, 1, 2, 2, 3, 1, 3, 3, 3, 2, 0};

    @OriginalMember(owner = "client!pi", name = "c", descriptor = "[[I")
    public static final int[][] anIntArrayArray257 = new int[][]{{12, 12, 12, 12}, {12, 12, 12, 12}, {5, 5, 5}, {5, 5, 5}, {5, 5, 5}, {5, 5, 5}, {12, 12, 12, 12, 12, 12}, {1, 1, 1, 7}, {1, 1, 7, 1}, {8, 9, 9, 8, 8, 9}, {8, 8, 9, 8, 9, 9}, {10, 10, 11, 11, 11, 10}, {12, 12, 12, 12}};

    @OriginalMember(owner = "client!ww", name = "c", descriptor = "[I")
    public static int[] OVERLAY_SIZES = new int[13];

    @OriginalMember(owner = "client!ska", name = "H", descriptor = "[I")
    public static int[] anIntArray695 = new int[6];

    @OriginalMember(owner = "client!qja", name = "e", descriptor = "[[[B")
    public byte[][][] aByteArrayArrayArray12;

    @OriginalMember(owner = "client!qja", name = "j", descriptor = "[I")
    public final int[] tileOffsetY = {0, 0, 0, 256, 512, 512, 512, 256, 256, 384, 128, 128, 256};

    @OriginalMember(owner = "client!qja", name = "h", descriptor = "[I")
    public final int[] tileOffsetX = {0, 256, 512, 512, 512, 256, 0, 0, 128, 256, 128, 384, 256};

    @OriginalMember(owner = "client!qja", name = "k", descriptor = "Lclient!dh;")
    public final FloorUnderlayTypeList underlayTypeList;

    @OriginalMember(owner = "client!qja", name = "q", descriptor = "I")
    protected final int length;

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "I")
    public final int levels;

    @OriginalMember(owner = "client!qja", name = "m", descriptor = "Z")
    public final boolean underwater;

    @OriginalMember(owner = "client!qja", name = "n", descriptor = "I")
    protected final int width;

    @OriginalMember(owner = "client!qja", name = "l", descriptor = "Lclient!ef;")
    public final FloorOverlayTypeList floorOverlayTypeList;

    @OriginalMember(owner = "client!qja", name = "x", descriptor = "[[[B")
    public final byte[][][] tileDirections;

    @OriginalMember(owner = "client!qja", name = "g", descriptor = "[[[B")
    public final byte[][][] underlay;

    @OriginalMember(owner = "client!qja", name = "u", descriptor = "[[[B")
    protected byte[][][] occluderFlags;

    @OriginalMember(owner = "client!qja", name = "s", descriptor = "[[[B")
    public final byte[][][] overlay;

    @OriginalMember(owner = "client!qja", name = "C", descriptor = "[[[B")
    public final byte[][][] tileShapes;

    @OriginalMember(owner = "client!qja", name = "A", descriptor = "[[[I")
    public final int[][][] tileHeights;

    @OriginalMember(owner = "client!qja", name = "<init>", descriptor = "(IIIZLclient!ef;Lclient!dh;)V")
    protected Class306(@OriginalArg(0) int levels, @OriginalArg(1) int width, @OriginalArg(2) int length, @OriginalArg(3) boolean underwater, @OriginalArg(4) FloorOverlayTypeList arg4, @OriginalArg(5) FloorUnderlayTypeList arg5) {
        this.underlayTypeList = arg5;
        this.length = length;
        this.levels = levels;
        this.underwater = underwater;
        this.width = width;
        this.floorOverlayTypeList = arg4;
        this.tileDirections = new byte[this.levels][this.width][this.length];
        this.underlay = new byte[this.levels][this.width][this.length];
        this.occluderFlags = new byte[this.levels][this.width + 1][this.length + 1];
        this.overlay = new byte[this.levels][this.width][this.length];
        this.tileShapes = new byte[this.levels][this.width][this.length];
        this.tileHeights = new int[this.levels][this.width + 1][this.length + 1];
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(Lclient!ge;I[Lclient!eq;IBII)V")
    public final void decodeMapSquare(@OriginalArg(0) Packet packet, @OriginalArg(2) CollisionMap[] collisionMaps, @OriginalArg(6) int absX, @OriginalArg(1) int absZ, @OriginalArg(5) int areaBaseX, @OriginalArg(3) int areaBaseZ) {
        if (!this.underwater) {
            for (@Pc(4) int level = 0; level < 4; level++) {
                @Pc(9) CollisionMap collisionMap = collisionMaps[level];

                for (@Pc(11) int localX = 0; localX < 64; localX++) {
                    for (@Pc(14) int localZ = 0; localZ < 64; localZ++) {
                        @Pc(19) int x = localX + absX;
                        @Pc(23) int z = localZ + absZ;

                        if (x >= 0 && this.width > x && z >= 0 && z < this.length) {
                            collisionMap.unflagBlocked(x, z);
                        }
                    }
                }
            }
        }

        @Pc(4) int x = absX + areaBaseX;
        @Pc(84) int z = absZ + areaBaseZ;
        for (@Pc(11) int level = 0; level < this.levels; level++) {
            for (@Pc(14) int localX = 0; localX < 64; localX++) {
                for (@Pc(19) int localZ = 0; localZ < 64; localZ++) {
                    this.decodeTile(packet, localX + absX, absZ + localZ, x + localX, z + localZ, 0, 0, level, 0, false);
                }
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(IIIII)V")
    public final void method7880(@OriginalArg(2) int x, @OriginalArg(4) int z) {
        for (@Pc(1) int level = 0; level < this.levels; level++) {
            this.setTileHeights(x, z, level, 64, 64);
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(I[[[ILclient!ha;[Lclient!eq;)V")
    public final void method7881(@OriginalArg(1) int[][][] arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) CollisionMap[] arg2) {
        @Pc(4) int local4;
        @Pc(7) int local7;
        @Pc(10) int local10;
        if (!this.underwater) {
            for (local4 = 0; local4 < 4; local4++) {
                for (local7 = 0; local7 < this.width; local7++) {
                    for (local10 = 0; local10 < this.length; local10++) {
                        if ((Static280.tileFlags[local4][local7][local10] & 0x1) != 0) {
                            @Pc(26) int local26 = local4;
                            if ((Static280.tileFlags[1][local7][local10] & 0x2) != 0) {
                                local26 = local4 - 1;
                            }
                            if (local26 >= 0) {
                                arg2[local26].flagBlocked(local10, local7);
                            }
                        }
                    }
                }
            }
        }
        for (local4 = 0; local4 < this.levels; local4++) {
            local7 = 0;
            local10 = 0;
            if (!this.underwater) {
                if (Static50.aBoolean566) {
                    local10 = 8;
                }
                if (Static305.aBoolean371) {
                    local7 = 2;
                }
                if (Static439.anInt6674 != 0) {
                    local7 |= 0x1;
                    if (local4 == 0 | Static428.aBoolean487) {
                        local10 |= 0x10;
                    }
                }
            }
            if (Static305.aBoolean371) {
                local10 |= 0x7;
            }
            if (!Static196.aBoolean262) {
                local10 |= 0x20;
            }
            @Pc(165) int[][] local165 = arg0 == null || local4 >= arg0.length ? this.tileHeights[local4] : arg0[local4];
            Static429.method5805(local4, arg1.createGround(this.width, this.length, this.tileHeights[local4], local165, local7, local10));
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(IBLclient!ha;[[ILclient!s;Lclient!s;Lclient!s;)V")
    public void loadUnblended(@OriginalArg(0) int level, @OriginalArg(2) Toolkit toolkit, @OriginalArg(3) int[][] colour, @OriginalArg(4) Ground surfaceGround, @OriginalArg(5) Ground ground, @OriginalArg(6) Ground underwaterGround) {
        for (@Pc(1) int x = 0; x < this.width; x++) {
            for (@Pc(4) int z = 0; z < this.length; z++) {

                if (AnimatedBackground.level == -1 || Static696.isTileVisibleFrom(z, AnimatedBackground.level, x, level)) {
                    @Pc(28) byte shape = this.tileShapes[level][x][z];
                    @Pc(37) byte direction = this.tileDirections[level][x][z];
                    @Pc(48) int overlay = this.overlay[level][x][z] & 0xFF;
                    @Pc(59) int underlay = this.underlay[level][x][z] & 0xFF;

                    @Pc(72) FloorOverlayType overlayType = overlay == 0 ? null : this.floorOverlayTypeList.list(overlay - 1);
                    if (shape == 0 && overlayType == null) {
                        shape = 12;
                    }

                    @Pc(93) FloorUnderlayType underlayType = underlay == 0 ? null : this.underlayTypeList.list(underlay - 1);
                    @Pc(95) FloorOverlayType local95 = overlayType;
                    if (overlayType != null && overlayType.colour == -1 && overlayType.blendColour == -1) {
                        local95 = overlayType;
                        overlayType = null;
                    }

                    if (overlayType != null || underlayType != null) {
                        @Pc(125) int underlayFaces = UNDERLAY_FACE_COUNT[shape];
                        @Pc(129) int overlayFaces = OVERLAY_FACE_COUNT[shape];
                        @Pc(143) int faces = (underlayType == null ? 0 : underlayFaces) + (overlayType == null ? 0 : overlayFaces);
                        @Pc(145) int faceIndex = 0;
                        @Pc(147) int vertexIndex = 0;
                        @Pc(155) int overlayTexture = overlayType == null ? -1 : overlayType.texture;
                        @Pc(163) int underlayTexture = underlayType == null ? -1 : underlayType.texture;
                        @Pc(166) int[] faceA = new int[faces];
                        @Pc(169) int[] faceB = new int[faces];
                        @Pc(172) int[] faceC = new int[faces];
                        @Pc(175) int[] colours = new int[faces];
                        @Pc(178) int[] textures = new int[faces];
                        @Pc(181) int[] sizes = new int[faces];
                        @Pc(195) int[] blendedColours = overlayType == null || overlayType.blendColour == -1 ? null : new int[faces];

                        if (overlayType == null) {
                            vertexIndex = overlayFaces;
                        } else {
                            for (@Pc(199) int i = 0; i < overlayFaces; i++) {
                                faceA[faceIndex] = TILE_FACE_A[shape][vertexIndex];
                                faceB[faceIndex] = TILE_FACE_B[shape][vertexIndex];
                                faceC[faceIndex] = TILE_FACE_C[shape][vertexIndex];
                                textures[faceIndex] = overlayTexture;
                                sizes[faceIndex] = overlayType.size;
                                colours[faceIndex] = overlayType.colour;
                                if (blendedColours != null) {
                                    blendedColours[faceIndex] = overlayType.blendColour;
                                }
                                faceIndex++;
                                vertexIndex++;
                            }

                            if (!this.underwater && level == 0) {
                                Static295.setWaterParams(x, z, overlayType.waterColour, overlayType.waterDepth * 8, overlayType.waterBias);
                            }
                        }

                        if (underlayType != null) {
                            for (@Pc(199) int i = 0; i < underlayFaces; i++) {
                                faceA[faceIndex] = TILE_FACE_A[shape][vertexIndex];
                                faceB[faceIndex] = TILE_FACE_B[shape][vertexIndex];
                                faceC[faceIndex] = TILE_FACE_C[shape][vertexIndex];
                                textures[faceIndex] = underlayTexture;
                                sizes[faceIndex] = underlayType.size;
                                colours[faceIndex] = colour[x][z];

                                if (blendedColours != null) {
                                    blendedColours[faceIndex] = colours[faceIndex];
                                }

                                vertexIndex++;
                                faceIndex++;
                            }
                        }

                        @Pc(199) int vertices = this.tileOffsetX.length;
                        @Pc(352) int[] offsetX = new int[vertices];
                        @Pc(355) int[] offsetY = new int[vertices];
                        @Pc(363) int[] offsetLevel = surfaceGround == null ? null : new int[vertices];
                        @Pc(375) int[] depths = surfaceGround == null && underwaterGround == null ? null : new int[vertices];

                        for (@Pc(377) int i = 0; i < vertices; i++) {
                            @Pc(383) int deltaX = this.tileOffsetX[i];
                            @Pc(388) int deltaY = this.tileOffsetY[i];

                            if (direction == 0) {
                                offsetX[i] = deltaX;
                                offsetY[i] = deltaY;
                            } else if (direction == 1) {
                                offsetX[i] = deltaY;
                                offsetY[i] = 512 - deltaX;
                            } else if (direction == 2) {
                                offsetX[i] = 512 - deltaX;
                                offsetY[i] = 512 - deltaY;
                            } else if (direction == 3) {
                                offsetX[i] = 512 - deltaY;
                                offsetY[i] = deltaX;
                            }

                            if (offsetLevel != null && aBooleanArrayArray7[shape][i]) {
                                @Pc(477) int waterX = offsetX[i] + (x << 9);
                                @Pc(485) int waterY = (z << 9) + offsetY[i];
                                offsetLevel[i] = surfaceGround.averageHeight(waterX, waterY) - ground.averageHeight(waterX, waterY);
                            }

                            if (depths != null) {
                                if (surfaceGround != null && !aBooleanArrayArray7[shape][i]) {
                                    @Pc(477) int waterX = offsetX[i] + (x << 9);
                                    @Pc(485) int waterY = (z << 9) + offsetY[i];
                                    depths[i] = ground.averageHeight(waterX, waterY) - surfaceGround.averageHeight(waterX, waterY);
                                } else if (underwaterGround != null && !Static355.aBooleanArrayArray4[shape][i]) {
                                    @Pc(477) int waterX = (x << 9) + offsetX[i];
                                    @Pc(485) int waterY = offsetY[i] + (z << 9);
                                    depths[i] = underwaterGround.averageHeight(waterX, waterY) - ground.averageHeight(waterX, waterY);
                                }
                            }
                        }

                        @Pc(383) int heightSW = ground.getHeight(x, z);
                        @Pc(388) int heightSE = ground.getHeight(x + 1, z);
                        @Pc(477) int heightNE = ground.getHeight(x - -1, z + 1);
                        @Pc(485) int heightNW = ground.getHeight(x, z + 1);

                        @Pc(633) boolean bridge = Static441.isBridgeAt(z, x);
                        if (bridge && level > 1 || !bridge && level > 0) {
                            @Pc(652) boolean occlused = true;
                            if (underlayType != null && !underlayType.occludes) {
                                occlused = false;
                            } else if (underlay == 0 && shape != 0) {
                                occlused = false;
                            } else if (overlay > 0 && local95 != null && !local95.occludes) {
                                occlused = false;
                            }

                            if (occlused && heightSE == heightSW && heightNE == heightSW && heightSW == heightNW) {
                                this.occluderFlags[level][x][z] = (byte) (this.occluderFlags[level][x][z] | 0x4);
                            }
                        }

                        @Pc(740) int waterColour = 0;
                        @Pc(742) int waterDepth = 0;
                        @Pc(744) int waterBias = 0;

                        if (this.underwater) {
                            waterColour = Static100.getWaterColour(x, z);
                            waterDepth = Static350.getWaterDepth(x, z);
                            waterBias = Static339.getWaterBias(x, z);
                        }

                        ground.addTile(x, z, offsetX, offsetLevel, offsetY, depths, faceA, faceB, faceC, colours, blendedColours, textures, sizes, waterColour, waterDepth, waterBias);
                        Static527.method7084(level, x, z);
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(ILclient!re;[[BIIIIILclient!ha;I[ZLclient!nq;[[B[[B)V")
    public void blendOverlay(@OriginalArg(0) int shape, @OriginalArg(1) FloorOverlayType overlayType, @OriginalArg(2) byte[][] directions, @OriginalArg(3) int width, @OriginalArg(5) int x, @OriginalArg(6) int direction, @OriginalArg(7) int length, @OriginalArg(8) Toolkit toolkit, @OriginalArg(9) int z, @OriginalArg(10) boolean[] arg9, @OriginalArg(11) FloorUnderlayType underlayType, @OriginalArg(12) byte[][] shapes, @OriginalArg(13) byte[][] overlays) {
        @Pc(19) boolean[] local19 = overlayType != null && overlayType.blendable ? aBooleanArrayArray6[shape] : aBooleanArrayArray5[shape];

        if (z > 0) {
            if (x > 0) {
                @Pc(37) int overlaySW = overlays[x - 1][z - 1] & 0xFF;

                if (overlaySW > 0) {
                    @Pc(50) FloorOverlayType overlayTypeSW = this.floorOverlayTypeList.list(overlaySW - 1);
                    if (overlayTypeSW.colour != -1 && overlayTypeSW.blendable) {
                        @Pc(70) byte shapeSW = shapes[x - 1][z - 1];
                        @Pc(86) int directionSW = ((directions[x - 1][z - 1] * 2) + 4) & 0x7;
                        @Pc(91) int colourSW = Static718.blendColour(overlayTypeSW, toolkit);

                        if (aBooleanArrayArray7[shapeSW][directionSW]) {
                            OVERLAY_COLOURS[0] = overlayTypeSW.colour;
                            OVERLAY_BLEND_COLOURS[0] = colourSW;
                            OVERLAY_TEXTURES[0] = overlayTypeSW.texture;
                            OVERLAY_SIZES[0] = overlayTypeSW.size;
                            OVERLAY_BLEND_PRIORITIES[0] = overlayTypeSW.blendPriority;
                            anIntArray313[0] = 256;
                        }
                    }
                }
            }

            if (x < width - 1) {
                @Pc(37) int overlaySE = overlays[x + 1][z - 1] & 0xFF;

                if (overlaySE > 0) {
                    @Pc(50) FloorOverlayType overlayTypeSE = this.floorOverlayTypeList.list(overlaySE - 1);

                    if (overlayTypeSE.colour != -1 && overlayTypeSE.blendable) {
                        @Pc(70) byte shapeSE = shapes[x + 1][z - 1];
                        @Pc(86) int directionSE = ((directions[x + 1][z - 1] * 2) + 6) & 0x7;
                        @Pc(91) int colourSE = Static718.blendColour(overlayTypeSE, toolkit);
                        if (aBooleanArrayArray7[shapeSE][directionSE]) {
                            OVERLAY_COLOURS[2] = overlayTypeSE.colour;
                            OVERLAY_BLEND_COLOURS[2] = colourSE;
                            OVERLAY_TEXTURES[2] = overlayTypeSE.texture;
                            OVERLAY_SIZES[2] = overlayTypeSE.size;
                            OVERLAY_BLEND_PRIORITIES[2] = overlayTypeSE.blendPriority;
                            anIntArray313[2] = 512;
                        }
                    }
                }
            }
        }

        if (z < length - 1) {
            if (x > 0) {
                @Pc(37) int overlayNW = overlays[x - 1][z + 1] & 0xFF;

                if (overlayNW > 0) {
                    @Pc(50) FloorOverlayType overlayTypeNW = this.floorOverlayTypeList.list(overlayNW - 1);

                    if (overlayTypeNW.colour != -1 && overlayTypeNW.blendable) {
                        @Pc(70) byte shapeNW = shapes[x - 1][z + 1];
                        @Pc(86) int directionNW = directions[x - 1][z + 1] * 2 + 2 & 0x7;
                        @Pc(91) int colourNW = Static718.blendColour(overlayTypeNW, toolkit);

                        if (aBooleanArrayArray7[shapeNW][directionNW]) {
                            OVERLAY_COLOURS[6] = overlayTypeNW.colour;
                            OVERLAY_BLEND_COLOURS[6] = colourNW;
                            OVERLAY_TEXTURES[6] = overlayTypeNW.texture;
                            OVERLAY_SIZES[6] = overlayTypeNW.size;
                            OVERLAY_BLEND_PRIORITIES[6] = overlayTypeNW.blendPriority;
                            anIntArray313[6] = 64;
                        }
                    }
                }
            }

            if (width - 1 > x) {
                @Pc(37) int overlayNE = overlays[x + 1][z + 1] & 0xFF;

                if (overlayNE > 0) {
                    @Pc(50) FloorOverlayType overlayTypeNE = this.floorOverlayTypeList.list(overlayNE - 1);

                    if (overlayTypeNE.colour != -1 && overlayTypeNE.blendable) {
                        @Pc(70) byte shapeNE = shapes[x + 1][z + 1];
                        @Pc(86) int directionNE = (directions[x + 1][z + 1] * 2) & 0x7;
                        @Pc(91) int colourNE = Static718.blendColour(overlayTypeNE, toolkit);

                        if (aBooleanArrayArray7[shapeNE][directionNE]) {
                            OVERLAY_COLOURS[4] = overlayTypeNE.colour;
                            OVERLAY_BLEND_COLOURS[4] = colourNE;
                            OVERLAY_TEXTURES[4] = overlayTypeNE.texture;
                            OVERLAY_SIZES[4] = overlayTypeNE.size;
                            OVERLAY_BLEND_PRIORITIES[4] = overlayTypeNE.blendPriority;
                            anIntArray313[4] = 128;
                        }
                    }
                }
            }
        }

        if (z > 0) {
            @Pc(37) int overlaySouth = overlays[x][z - 1] & 0xFF;

            if (overlaySouth > 0) {
                @Pc(50) FloorOverlayType overlayTypeSouth = this.floorOverlayTypeList.list(overlaySouth - 1);

                if (overlayTypeSouth.colour != -1) {
                    @Pc(70) byte shapeSouth = shapes[x][z - 1];
                    @Pc(498) byte directionSouth = directions[x][z - 1];

                    if (overlayTypeSouth.blendable) {
                        @Pc(91) int colour = 2;
                        @Pc(509) int local509 = (directionSouth * 2) + 4;
                        @Pc(514) int local514 = Static718.blendColour(overlayTypeSouth, toolkit);

                        for (@Pc(516) int i = 0; i < 3; i++) {
                            colour &= 0x7;
                            local509 &= 0x7;

                            if (aBooleanArrayArray7[shapeSouth][local509] && overlayTypeSouth.blendPriority >= OVERLAY_BLEND_PRIORITIES[colour]) {
                                OVERLAY_COLOURS[colour] = overlayTypeSouth.colour;
                                OVERLAY_BLEND_COLOURS[colour] = local514;
                                OVERLAY_TEXTURES[colour] = overlayTypeSouth.texture;
                                OVERLAY_SIZES[colour] = overlayTypeSouth.size;

                                if (OVERLAY_BLEND_PRIORITIES[colour] == overlayTypeSouth.blendPriority) {
                                    anIntArray313[colour] |= 0x20;
                                } else {
                                    anIntArray313[colour] = 0x20;
                                }

                                OVERLAY_BLEND_PRIORITIES[colour] = overlayTypeSouth.blendPriority;
                            }

                            colour--;
                            local509++;
                        }

                        if (!local19[direction & 0x3]) {
                            arg9[0] = aBooleanArrayArray6[shapeSouth][(directionSouth + 2) & 0x3];
                        }
                    } else if (!local19[direction & 0x3]) {
                        arg9[0] = aBooleanArrayArray5[shapeSouth][(directionSouth + 2) & 0x3];
                    }
                }
            }
        }

        if (z < length - 1) {
            @Pc(37) int overlayNorth = overlays[x][z + 1] & 0xFF;

            if (overlayNorth > 0) {
                @Pc(50) FloorOverlayType overlayTypeNorth = this.floorOverlayTypeList.list(overlayNorth - 1);

                if (overlayTypeNorth.colour != -1) {
                    @Pc(70) byte shapeNorth = shapes[x][z + 1];
                    @Pc(498) byte directionNorth = directions[x][z + 1];

                    if (overlayTypeNorth.blendable) {
                        @Pc(91) int colour = 4;
                        @Pc(509) int local509 = directionNorth * 2 + 2;
                        @Pc(514) int local514 = Static718.blendColour(overlayTypeNorth, toolkit);

                        for (@Pc(516) int i = 0; i < 3; i++) {
                            colour &= 0x7;
                            local509 &= 0x7;

                            if (aBooleanArrayArray7[shapeNorth][local509] && OVERLAY_BLEND_PRIORITIES[colour] <= overlayTypeNorth.blendPriority) {
                                OVERLAY_COLOURS[colour] = overlayTypeNorth.colour;
                                OVERLAY_BLEND_COLOURS[colour] = local514;
                                OVERLAY_TEXTURES[colour] = overlayTypeNorth.texture;
                                OVERLAY_SIZES[colour] = overlayTypeNorth.size;

                                if (OVERLAY_BLEND_PRIORITIES[colour] == overlayTypeNorth.blendPriority) {
                                    anIntArray313[colour] |= 0x10;
                                } else {
                                    anIntArray313[colour] = 0x10;
                                }

                                OVERLAY_BLEND_PRIORITIES[colour] = overlayTypeNorth.blendPriority;
                            }

                            colour++;
                            local509--;
                        }

                        if (!local19[(direction + 2) & 0x3]) {
                            arg9[2] = aBooleanArrayArray6[shapeNorth][--directionNorth & 0x3];
                        }
                    } else if (!local19[(direction + 2) & 0x3]) {
                        arg9[2] = aBooleanArrayArray5[shapeNorth][directionNorth & 0x3];
                    }
                }
            }
        }

        if (x > 0) {
            @Pc(37) int overlayWest = overlays[x - 1][z] & 0xFF;

            if (overlayWest > 0) {
                @Pc(50) FloorOverlayType overlayTypeWest = this.floorOverlayTypeList.list(overlayWest - 1);

                if (overlayTypeWest.colour != -1) {
                    @Pc(70) byte shapeWest = shapes[x - 1][z];
                    @Pc(498) byte directionWest = directions[x - 1][z];

                    if (overlayTypeWest.blendable) {
                        @Pc(91) int colour = 6;
                        @Pc(509) int local509 = directionWest * 2 + 4;
                        @Pc(514) int local514 = Static718.blendColour(overlayTypeWest, toolkit);

                        for (@Pc(516) int i = 0; i < 3; i++) {
                            colour &= 0x7;
                            local509 &= 0x7;

                            if (aBooleanArrayArray7[shapeWest][local509] && OVERLAY_BLEND_PRIORITIES[colour] <= overlayTypeWest.blendPriority) {
                                OVERLAY_COLOURS[colour] = overlayTypeWest.colour;
                                OVERLAY_BLEND_COLOURS[colour] = local514;
                                OVERLAY_TEXTURES[colour] = overlayTypeWest.texture;
                                OVERLAY_SIZES[colour] = overlayTypeWest.size;

                                if (overlayTypeWest.blendPriority == OVERLAY_BLEND_PRIORITIES[colour]) {
                                    anIntArray313[colour] |= 0x8;
                                } else {
                                    anIntArray313[colour] = 0x8;
                                }

                                OVERLAY_BLEND_PRIORITIES[colour] = overlayTypeWest.blendPriority;
                            }

                            colour++;
                            local509--;
                        }

                        if (!local19[(direction + 3) & 0x3]) {
                            arg9[3] = aBooleanArrayArray6[shapeWest][(directionWest + 1) & 0x3];
                        }
                    } else if (!local19[(direction + 3) & 0x3]) {
                        arg9[3] = aBooleanArrayArray5[shapeWest][(directionWest + 1) & 0x3];
                    }
                }
            }
        }

        if (x < width - 1) {
            @Pc(37) int overlayEast = overlays[x + 1][z] & 0xFF;

            if (overlayEast > 0) {
                @Pc(50) FloorOverlayType overlayTypeEast = this.floorOverlayTypeList.list(overlayEast - 1);

                if (overlayTypeEast.colour != -1) {
                    @Pc(70) byte local70 = shapes[x + 1][z];
                    @Pc(498) byte local498 = directions[x + 1][z];

                    if (overlayTypeEast.blendable) {
                        @Pc(91) int colour = 4;
                        @Pc(509) int local509 = local498 * 2 + 6;
                        @Pc(514) int local514 = Static718.blendColour(overlayTypeEast, toolkit);

                        for (@Pc(516) int local516 = 0; local516 < 3; local516++) {
                            local509 &= 0x7;
                            colour &= 0x7;

                            if (aBooleanArrayArray7[local70][local509] && overlayTypeEast.blendPriority >= OVERLAY_BLEND_PRIORITIES[colour]) {
                                OVERLAY_COLOURS[colour] = overlayTypeEast.colour;
                                OVERLAY_BLEND_COLOURS[colour] = local514;
                                OVERLAY_TEXTURES[colour] = overlayTypeEast.texture;
                                OVERLAY_SIZES[colour] = overlayTypeEast.size;

                                if (OVERLAY_BLEND_PRIORITIES[colour] == overlayTypeEast.blendPriority) {
                                    anIntArray313[colour] |= 0x4;
                                } else {
                                    anIntArray313[colour] = 0x4;
                                }

                                OVERLAY_BLEND_PRIORITIES[colour] = overlayTypeEast.blendPriority;
                            }

                            colour--;
                            local509++;
                        }

                        if (!local19[(direction + 1) & 0x3]) {
                            arg9[1] = aBooleanArrayArray6[local70][(local498 + 3) & 0x3];
                        }

                    } else if (!local19[(direction + 1) & 0x3]) {
                        arg9[1] = aBooleanArrayArray5[local70][(local498 + 3) & 0x3];
                    }
                }
            }
        }

        if (overlayType == null) {
            return;
        }

        @Pc(37) int local37 = Static718.blendColour(overlayType, toolkit);
        if (!overlayType.blendable) {
            return;
        }

        for (@Pc(1245) int i = 0; i < 8; i++) {
            @Pc(1255) int local1255 = (i - (direction * 2)) & 0x7;

            if (aBooleanArrayArray7[shape][i] && overlayType.blendPriority >= OVERLAY_BLEND_PRIORITIES[local1255]) {
                OVERLAY_COLOURS[local1255] = overlayType.colour;
                OVERLAY_BLEND_COLOURS[local1255] = local37;
                OVERLAY_TEXTURES[local1255] = overlayType.texture;
                OVERLAY_SIZES[local1255] = overlayType.size;

                if (overlayType.blendPriority == OVERLAY_BLEND_PRIORITIES[local1255]) {
                    anIntArray313[local1255] |= 0x2;
                } else {
                    anIntArray313[local1255] = 2;
                }

                OVERLAY_BLEND_PRIORITIES[local1255] = overlayType.blendPriority;
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "([[IBI)V")
    public final void method7885(@OriginalArg(0) int[][] arg0) {
        @Pc(16) int[][] local16 = this.tileHeights[0];
        for (@Pc(18) int local18 = 0; local18 < this.width + 1; local18++) {
            for (@Pc(21) int local21 = 0; local21 < this.length + 1; local21++) {
                local16[local18][local21] += arg0[local18][local21];
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(IIIIILclient!ge;IIIIZ)V")
    public void decodeTile(@OriginalArg(5) Packet packet, @OriginalArg(3) int x, @OriginalArg(1) int z, @OriginalArg(4) int localX, @OriginalArg(7) int localZ, @OriginalArg(6) int offsetX, @OriginalArg(2) int offsetZ, @OriginalArg(8) int level, @OriginalArg(0) int rotation, @OriginalArg(10) boolean arg9) {
        if (rotation == 1) {
            offsetZ = 1;
        } else if (rotation == 2) {
            offsetX = 1;
            offsetZ = 1;
        } else if (rotation == 3) {
            offsetX = 1;
        }

        if (x < 0 || x >= this.width || z < 0 || z >= this.length) {
            while (true) {
                @Pc(50) int code = packet.g1();
                if (code == 0) {
                    break;
                }

                if (code == 1) {
                    packet.g1();
                    break;
                }
                if (code <= 49) {
                    packet.g1();
                }
            }
            return;
        }

        if (!this.underwater && !arg9) {
            Static280.tileFlags[level][x][z] = 0;
        }

        while (true) {
            @Pc(50) int code = packet.g1();
            if (code == 0) {
                if (this.underwater) {
                    this.tileHeights[0][x + offsetX][z + offsetZ] = 0;
                } else if (level == 0) {
                    this.tileHeights[0][x + offsetX][z + offsetZ] = -Static144.method2406(localX + 932731, localZ + 556238) * 8 << 2;
                } else {
                    this.tileHeights[level][x + offsetX][z + offsetZ] = this.tileHeights[level - 1][x + offsetX][z + offsetZ] - 960;
                }
                break;
            }

            if (code == 1) {
                @Pc(194) int local194 = packet.g1();
                if (this.underwater) {
                    this.tileHeights[0][offsetX + x][offsetZ + z] = local194 * 8 << 2;
                } else {
                    if (local194 == 1) {
                        local194 = 0;
                    }
                    if (level == 0) {
                        this.tileHeights[0][offsetX + x][offsetZ + z] = -local194 * 8 << 2;
                    } else {
                        this.tileHeights[level][offsetX + x][z + offsetZ] = this.tileHeights[level - 1][x + offsetX][offsetZ + z] - (local194 * 8 << 2);
                    }
                }
                break;
            }

            if (code <= 49) {
                if (arg9) {
                    packet.g1();
                } else {
                    this.overlay[level][x][z] = packet.g1b();
                    this.tileShapes[level][x][z] = (byte) ((code - 2) / 4);
                    this.tileDirections[level][x][z] = (byte) (code + rotation - 2 & 0x3);
                }
            } else if (code <= 81) {
                if (!this.underwater && !arg9) {
                    Static280.tileFlags[level][x][z] = (byte) (code - 49);
                }
            } else if (!arg9) {
                this.underlay[level][x][z] = (byte) (code - 81);
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(BLclient!ha;Lclient!s;Lclient!s;)V")
    public final void method7888(@OriginalArg(1) Toolkit toolkit, @OriginalArg(2) Ground underwaterGround, @OriginalArg(3) Ground surfaceGround) {
        if (Static397.anIntArray482 == null || this.length != Static397.anIntArray482.length) {
            Static501.anIntArray606 = new int[this.length];
            Static418.anIntArray704 = new int[this.length];
            Static397.anIntArray482 = new int[this.length];
            Static359.anIntArray449 = new int[this.length];
            Static467.anIntArray568 = new int[this.length];
        }
        @Pc(45) int[][] colour = new int[this.width][this.length];
        @Pc(50) int local50;
        for (@Pc(47) int level = 0; level < this.levels; level++) {
            for (local50 = 0; local50 < this.length; local50++) {
                Static397.anIntArray482[local50] = 0;
                Static467.anIntArray568[local50] = 0;
                Static501.anIntArray606[local50] = 0;
                Static359.anIntArray449[local50] = 0;
                Static418.anIntArray704[local50] = 0;
            }
            for (@Pc(78) int local78 = -5; local78 < this.width; local78++) {
                @Pc(86) int local86;
                @Pc(101) int local101;
                @Pc(170) int local170;
                for (@Pc(81) int local81 = 0; local81 < this.length; local81++) {
                    local86 = local78 + 5;
                    @Pc(150) int local150;
                    if (local86 < this.width) {
                        local101 = this.underlay[level][local86][local81] & 0xFF;
                        if (local101 > 0) {
                            @Pc(114) FloorUnderlayType local114 = this.underlayTypeList.list(local101 - 1);
                            Static397.anIntArray482[local81] += local114.anInt6630;
                            Static467.anIntArray568[local81] += local114.anInt6637;
                            Static501.anIntArray606[local81] += local114.anInt6639;
                            Static359.anIntArray449[local81] += local114.anInt6632;
                            local150 = Static418.anIntArray704[local81]++;
                        }
                    }
                    local101 = local78 - 5;
                    if (local101 >= 0) {
                        local170 = this.underlay[level][local101][local81] & 0xFF;
                        if (local170 > 0) {
                            @Pc(180) FloorUnderlayType local180 = this.underlayTypeList.list(local170 - 1);
                            Static397.anIntArray482[local81] -= local180.anInt6630;
                            Static467.anIntArray568[local81] -= local180.anInt6637;
                            Static501.anIntArray606[local81] -= local180.anInt6639;
                            Static359.anIntArray449[local81] -= local180.anInt6632;
                            local150 = Static418.anIntArray704[local81]--;
                        }
                    }
                }
                if (local78 >= 0) {
                    local86 = 0;
                    local101 = 0;
                    local170 = 0;
                    @Pc(240) int local240 = 0;
                    @Pc(242) int local242 = 0;
                    for (@Pc(244) int local244 = -5; local244 < this.length; local244++) {
                        @Pc(249) int local249 = local244 + 5;
                        if (this.length > local249) {
                            local101 += Static467.anIntArray568[local249];
                            local86 += Static397.anIntArray482[local249];
                            local240 += Static359.anIntArray449[local249];
                            local170 += Static501.anIntArray606[local249];
                            local242 += Static418.anIntArray704[local249];
                        }
                        @Pc(291) int local291 = local244 - 5;
                        if (local291 >= 0) {
                            local170 -= Static501.anIntArray606[local291];
                            local240 -= Static359.anIntArray449[local291];
                            local86 -= Static397.anIntArray482[local291];
                            local242 -= Static418.anIntArray704[local291];
                            local101 -= Static467.anIntArray568[local291];
                        }
                        if (local244 >= 0 && local240 > 0 && local242 > 0) {
                            colour[local78][local244] = Static318.method8555(local170 / local242, local101 / local242, local86 * 256 / local240);
                        }
                    }
                }
            }
            if (Static718.groundBlending) {
                this.loadBlended(level == 0 ? surfaceGround : null, colour, level == 0 ? underwaterGround : null, Static246.ground[level], toolkit, level);
            } else {
                this.loadUnblended(level, toolkit, colour, level == 0 ? surfaceGround : null, Static246.ground[level], level == 0 ? underwaterGround : null);
            }
            this.underlay[level] = null;
            this.overlay[level] = null;
            this.tileShapes[level] = null;
            this.tileDirections[level] = null;
        }
        if (!this.underwater) {
            if (Static439.anInt6674 != 0) {
                Static176.method6688();
            }
            if (Static305.aBoolean371) {
                Static358.method9182();
            }
        }
        for (local50 = 0; local50 < this.levels; local50++) {
            Static246.ground[local50].YA();
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(IIIIII)V")
    public final void setTileHeights(@OriginalArg(3) int x, @OriginalArg(2) int z, @OriginalArg(4) int level, @OriginalArg(5) int width, @OriginalArg(1) int length) {
        for (@Pc(5) int tileZ = z; tileZ < length + z; tileZ++) {
            for (@Pc(8) int tileX = x; tileX < x + width; tileX++) {
                if (tileX >= 0 && this.width > tileX && tileZ >= 0 && tileZ < this.length) {
                    this.tileHeights[level][tileX][tileZ] = level <= 0 ? 0 : this.tileHeights[level - 1][tileX][tileZ] - 960;
                }
            }
        }

        if (x > 0 && x < this.width) {
            for (@Pc(8) int localZ = z + 1; localZ < z + length; localZ++) {
                if (localZ >= 0 && localZ < this.length) {
                    this.tileHeights[level][x][localZ] = this.tileHeights[level][x - 1][localZ];
                }
            }
        }

        if (z > 0 && z < this.length) {
            for (@Pc(8) int localX = x + 1; localX < x + width; localX++) {
                if (localX >= 0 && localX < this.width) {
                    this.tileHeights[level][localX][z] = this.tileHeights[level][localX][z - 1];
                }
            }
        }

        if (x < 0 || z < 0 || this.width <= x || this.length <= z) {
            return;
        }

        if (level == 0) {
            if (x > 0 && this.tileHeights[level][x - 1][z] != 0) {
                this.tileHeights[level][x][z] = this.tileHeights[level][x - 1][z];
                return;
            }
            if (z > 0 && this.tileHeights[level][x][z - 1] != 0) {
                this.tileHeights[level][x][z] = this.tileHeights[level][x][z - 1];
                return;
            }
            if (x > 0 && z > 0 && this.tileHeights[level][x - 1][z - 1] != 0) {
                this.tileHeights[level][x][z] = this.tileHeights[level][x - 1][z - 1];
                return;
            }
            return;
        }

        if (x > 0 && this.tileHeights[level][x - 1][z] != this.tileHeights[level - 1][x - 1][z]) {
            this.tileHeights[level][x][z] = this.tileHeights[level][x - 1][z];
            return;
        }

        if (z > 0 && this.tileHeights[level][x][z - 1] != this.tileHeights[level - 1][x][z - 1]) {
            this.tileHeights[level][x][z] = this.tileHeights[level][x][z - 1];
            return;
        }

        if (x > 0 && z > 0 && this.tileHeights[level - 1][x - 1][z - 1] != this.tileHeights[level][x - 1][z - 1]) {
            this.tileHeights[level][x][z] = this.tileHeights[level][x - 1][z - 1];
            return;
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(Lclient!s;Z[[ILclient!s;Lclient!s;Lclient!ha;I)V")
    public void loadBlended(@OriginalArg(0) Ground surfaceGround, @OriginalArg(2) int[][] colours, @OriginalArg(3) Ground underwaterGround, @OriginalArg(4) Ground ground, @OriginalArg(5) Toolkit toolkit, @OriginalArg(6) int level) {
        @Pc(8) byte[][] shapes = this.tileShapes[level];
        @Pc(13) byte[][] directions = this.tileDirections[level];
        @Pc(26) byte[][] underlay = this.underlay[level];
        @Pc(31) byte[][] overlay = this.overlay[level];

        for (@Pc(33) int x = 0; x < this.width; x++) {
            @Pc(47) int nextX = this.width - 1 > x ? x + 1 : x;

            for (@Pc(49) int z = 0; z < this.length; z++) {
                @Pc(67) int nextZ = z < this.length - 1 ? z + 1 : z;

                if (AnimatedBackground.level == -1 || Static696.isTileVisibleFrom(z, AnimatedBackground.level, x, level)) {
                    @Pc(83) boolean allowShadow = false;
                    @Pc(85) boolean blendable = false;
                    @Pc(88) boolean[] local88 = new boolean[4];

                    @Pc(94) int shape = shapes[x][z];
                    @Pc(100) int direction = directions[x][z];
                    @Pc(108) int overlaySW = overlay[x][z] & 0xFF;

                    @Pc(116) int underlaySW = underlay[x][z] & 0xFF;
                    @Pc(124) int underlayNW = underlay[x][nextZ] & 0xFF;
                    @Pc(132) int underlayNE = underlay[nextX][nextZ] & 0xFF;
                    @Pc(140) int underlaySE = underlay[nextX][z] & 0xFF;

                    if (overlaySW != 0 || underlaySW != 0) {
                        @Pc(164) FloorOverlayType overlayType = overlaySW == 0 ? null : this.floorOverlayTypeList.list(overlaySW - 1);
                        @Pc(177) FloorUnderlayType underlayType = underlaySW == 0 ? null : this.underlayTypeList.list(underlaySW - 1);
                        if (shape == 0 && overlayType == null) {
                            shape = 12;
                        }

                        @Pc(187) FloorOverlayType local187 = overlayType;
                        if (overlayType != null) {
                            if (overlayType.colour != -1 || overlayType.blendColour != -1) {
                                if (underlayType != null && shape != 0) {
                                    blendable = overlayType.blendable;
                                }
                            } else {
                                local187 = overlayType;
                                overlayType = null;
                            }
                        }

                        if ((shape == 0 || shape == 12) && x > 0 && z > 0 && x < this.width && this.length > z) {
                            @Pc(276) int local276 = underlaySW == underlay[nextX][z - 1] ? 1 : -1;
                            @Pc(294) int local294 = underlay[x - 1][z - 1] == underlaySW ? 1 : -1;
                            @Pc(308) int local308 = underlaySW == underlay[nextX][nextZ] ? 1 : -1;

                            if (underlay[x][z - 1] == underlaySW) {
                                local276++;
                                local294++;
                            } else {
                                local276--;
                                local294--;
                            }

                            @Pc(345) int local345 = underlay[x - 1][nextZ] == underlaySW ? 1 : -1;

                            if (underlaySW == underlay[nextX][z]) {
                                local308++;
                                local276++;
                            } else {
                                local276--;
                                local308--;
                            }

                            if (underlaySW == underlay[x][nextZ]) {
                                local308++;
                                local345++;
                            } else {
                                local308--;
                                local345--;
                            }

                            if (underlaySW == underlay[x - 1][z]) {
                                local294++;
                                local345++;
                            } else {
                                local294--;
                                local345--;
                            }

                            @Pc(391) int local391 = local294 - local308;
                            if (local391 < 0) {
                                local391 = -local391;
                            }

                            @Pc(403) int local403 = local276 - local345;
                            if (local403 < 0) {
                                local403 = -local403;
                            }

                            if (local391 == local403) {
                                local391 = ground.getHeight(x, z) - ground.getHeight(nextX, nextZ);
                                if (local391 < 0) {
                                    local391 = -local391;
                                }

                                local403 = ground.getHeight(nextX, z) - ground.getHeight(x, nextZ);
                                if (local403 < 0) {
                                    local403 = -local403;
                                }
                            }

                            direction = local403 > local391 ? 1 : 0;
                        }

                        for (@Pc(294) int i = 0; i < 13; i++) {
                            OVERLAY_BLEND_PRIORITIES[i] = -1;
                            anIntArray313[i] = 1;
                        }

                        @Pc(496) boolean[] local496 = overlayType != null && overlayType.blendable ? aBooleanArrayArray6[shape] : aBooleanArrayArray5[shape];
                        this.blendOverlay(shape, overlayType, directions, this.width, x, direction, this.length, toolkit, z, local88, underlayType, shapes, overlay);

                        @Pc(532) boolean blendOverlay = overlayType != null && overlayType.colour != overlayType.blendColour;
                        if (!blendOverlay) {
                            for (@Pc(345) int local345 = 0; local345 < 8; local345++) {
                                if (OVERLAY_BLEND_PRIORITIES[local345] >= 0 && OVERLAY_BLEND_COLOURS[local345] != OVERLAY_COLOURS[local345]) {
                                    blendOverlay = true;
                                    break;
                                }
                            }
                        }

                        if (!local496[(direction + 1) & 0x3]) {
                            local88[1] = Static588.method7712(local88[1], (anIntArray313[2] & anIntArray313[4]) == 0);
                        }
                        if (!local496[(direction + 3) & 0x3]) {
                            local88[3] = Static588.method7712(local88[3], (anIntArray313[6] & anIntArray313[0]) == 0);
                        }
                        if (!local496[direction & 0x3]) {
                            local88[0] = Static588.method7712(local88[0], (anIntArray313[0] & anIntArray313[2]) == 0);
                        }
                        if (!local496[(direction + 2) & 0x3]) {
                            local88[2] = Static588.method7712(local88[2], (anIntArray313[6] & anIntArray313[4]) == 0);
                        }

                        if (!blendable && (shape == 0 || shape == 12)) {
                            if (local88[0] && !local88[1] && !local88[2] && local88[3]) {
                                local88[0] = local88[3] = false;
                                shape = shape == 0 ? 13 : 14;
                                direction = 0;
                            } else if (local88[0] && local88[1] && !local88[2] && !local88[3]) {
                                shape = shape == 0 ? 13 : 14;
                                direction = 3;
                                local88[0] = local88[1] = false;
                            } else if (!local88[0] && local88[1] && local88[2] && !local88[3]) {
                                shape = shape == 0 ? 13 : 14;
                                local88[1] = local88[2] = false;
                                direction = 2;
                            } else if (!local88[0] && !local88[1] && local88[2] && local88[3]) {
                                shape = shape == 0 ? 13 : 14;
                                direction = 1;
                                local88[2] = local88[3] = false;
                            }
                        }

                        @Pc(909) boolean local909 = !blendable && !local88[0] && !local88[2] && !local88[1] && !local88[3];
                        @Pc(911) int[] local911 = null;
                        @Pc(917) int[] faceA;
                        @Pc(934) int[] faceB;
                        @Pc(930) int[] faceC;
                        @Pc(391) int faceUnderlay;
                        @Pc(403) int faceOverlay;
                        if (local909) {
                            faceA = TILE_FACE_A[shape];
                            faceOverlay = overlayType == null ? 0 : OVERLAY_FACE_COUNT[shape];
                            faceC = TILE_FACE_C[shape];
                            faceB = TILE_FACE_B[shape];
                            faceUnderlay = underlayType == null ? 0 : UNDERLAY_FACE_COUNT[shape];
                        } else if (blendable) {
                            faceC = anIntArrayArray86[shape];
                            faceOverlay = overlayType == null ? 0 : anIntArray424[shape];
                            faceA = anIntArrayArray90[shape];
                            local911 = anIntArrayArray206[shape];
                            faceB = anIntArrayArray193[shape];
                            faceUnderlay = underlayType == null ? 0 : anIntArray468[shape];
                        } else {
                            faceUnderlay = underlayType == null ? 0 : anIntArray464[shape];
                            faceC = anIntArrayArray257[shape];
                            faceOverlay = overlayType == null ? 0 : anIntArray601[shape];
                            faceA = Static115.anIntArrayArray56[shape];
                            local911 = Static264.anIntArrayArray267[shape];
                            faceB = Static206.anIntArrayArray84[shape];
                        }

                        @Pc(1021) int faceCount = faceOverlay + faceUnderlay;
                        if (faceCount <= 0) {
                            Static527.method7084(level, x, z);
                        } else {
                            if (local88[0]) {
                                faceCount++;
                            }
                            if (local88[2]) {
                                faceCount++;
                            }
                            if (local88[1]) {
                                faceCount++;
                            }
                            if (local88[3]) {
                                faceCount++;
                            }

                            @Pc(1062) int local1062 = 0;
                            @Pc(1064) int local1064 = 0;
                            @Pc(1068) int vertexCount = faceCount * 3;
                            @Pc(1076) int[] overlayBlendColours = blendOverlay ? new int[vertexCount] : null;
                            @Pc(1079) int[] local1079 = new int[vertexCount];
                            @Pc(1082) int[] local1082 = new int[vertexCount];
                            @Pc(1085) int[] blendedColours = new int[vertexCount];
                            @Pc(1088) int[] blendedTextures = new int[vertexCount];
                            @Pc(1091) int[] blendedSizes = new int[vertexCount];
                            @Pc(1099) int[] local1099 = surfaceGround == null ? null : new int[vertexCount];
                            @Pc(1111) int[] waterDepths = surfaceGround == null && underwaterGround == null ? null : new int[vertexCount];

                            @Pc(1113) int colour = -1;
                            @Pc(1115) int texture = -1;
                            @Pc(1117) int size = 256;

                            if (overlayType == null) {
                                if (local909) {
                                    local1062 = OVERLAY_FACE_COUNT[shape];
                                } else if (blendable) {
                                    local1062 = anIntArray424[shape];
                                } else {
                                    local1062 = anIntArray601[shape];
                                }
                            } else {
                                size = overlayType.size;
                                colour = overlayType.colour;
                                texture = overlayType.texture;

                                @Pc(1162) int local1162 = Static718.blendColour(overlayType, toolkit);
                                @Pc(1277) byte local1277;

                                for (@Pc(1164) int local1164 = 0; local1164 < faceOverlay; local1164++) {
                                    if (local88[-direction & 0x3] && local911[0] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 1;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 1;
                                        anIntArray695[4] = faceB[local1062];
                                        anIntArray695[5] = faceC[local1062];
                                        local1277 = 6;
                                    } else if (local88[(2 - direction) & 0x3] && local911[2] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 5;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 5;
                                        anIntArray695[4] = faceB[local1062];
                                        anIntArray695[5] = faceC[local1062];
                                        local1277 = 6;
                                    } else if (local88[(1 - direction) & 0x3] && local911[1] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 3;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 3;
                                        anIntArray695[4] = faceB[local1062];
                                        local1277 = 6;
                                        anIntArray695[5] = faceC[local1062];
                                    } else if (local88[(3 - direction) & 0x3] && local911[3] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 7;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 7;
                                        anIntArray695[4] = faceB[local1062];
                                        local1277 = 6;
                                        anIntArray695[5] = faceC[local1062];
                                    } else {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = faceB[local1062];
                                        anIntArray695[2] = faceC[local1062];
                                        local1277 = 3;
                                    }

                                    for (@Pc(1411) int local1411 = 0; local1411 < local1277; local1411++) {
                                        @Pc(1416) int local1416 = anIntArray695[local1411];
                                        @Pc(1425) int local1425 = (local1416 - (direction * 2)) & 0x7;
                                        @Pc(1430) int local1430 = this.tileOffsetX[local1416];
                                        @Pc(1435) int local1435 = this.tileOffsetY[local1416];

                                        @Pc(1452) int local1452;
                                        @Pc(1448) int local1448;
                                        if (direction == 1) {
                                            local1448 = 512 - local1430;
                                            local1452 = local1435;
                                        } else if (direction == 2) {
                                            local1448 = 512 - local1435;
                                            local1452 = 512 - local1430;
                                        } else if (direction == 3) {
                                            local1452 = 512 - local1435;
                                            local1448 = local1430;
                                        } else {
                                            local1452 = local1430;
                                            local1448 = local1435;
                                        }

                                        local1079[local1064] = local1452;
                                        local1082[local1064] = local1448;
                                        if (local1099 != null && aBooleanArrayArray7[shape][local1416]) {
                                            @Pc(1501) int local1501 = local1452 + (x << 9);
                                            @Pc(1508) int local1508 = (z << 9) + local1448;
                                            local1099[local1064] = surfaceGround.averageHeight(local1501, local1508) - ground.averageHeight(local1501, local1508);
                                        }

                                        if (waterDepths != null) {
                                            if (surfaceGround != null && !aBooleanArrayArray7[shape][local1416]) {
                                                @Pc(1501) int local1501 = local1452 + (x << 9);
                                                @Pc(1508) int local1508 = (z << 9) + local1448;
                                                waterDepths[local1064] = ground.averageHeight(local1501, local1508) - surfaceGround.averageHeight(local1501, local1508);
                                            } else if (underwaterGround != null && !Static355.aBooleanArrayArray4[shape][local1416]) {
                                                @Pc(1501) int local1501 = local1452 + (x << 9);
                                                @Pc(1508) int local1508 = local1448 + (z << 9);
                                                waterDepths[local1064] = underwaterGround.averageHeight(local1501, local1508) - ground.averageHeight(local1501, local1508);
                                            }
                                        }

                                        if (local1416 < 8 && OVERLAY_BLEND_PRIORITIES[local1425] > overlayType.blendPriority) {
                                            if (overlayBlendColours != null) {
                                                overlayBlendColours[local1064] = OVERLAY_BLEND_COLOURS[local1425];
                                            }

                                            blendedSizes[local1064] = OVERLAY_SIZES[local1425];
                                            blendedTextures[local1064] = OVERLAY_TEXTURES[local1425];
                                            blendedColours[local1064] = OVERLAY_COLOURS[local1425];
                                        } else {
                                            if (overlayBlendColours != null) {
                                                overlayBlendColours[local1064] = local1162;
                                            }

                                            blendedTextures[local1064] = overlayType.texture;
                                            blendedSizes[local1064] = overlayType.size;
                                            blendedColours[local1064] = colour;
                                        }

                                        local1064++;
                                    }

                                    local1062++;
                                }

                                if (!this.underwater && level == 0) {
                                    Static295.setWaterParams(x, z, overlayType.waterColour, overlayType.waterDepth * 8, overlayType.waterBias);
                                }

                                if (shape != 12 && overlayType.colour != -1 && overlayType.blockShadow) {
                                    allowShadow = true;
                                }
                            }

                            if (underlayType != null) {
                                if (underlaySE == 0) {
                                    underlaySE = underlaySW;
                                }

                                if (underlayNE == 0) {
                                    underlayNE = underlaySW;
                                }

                                if (underlayNW == 0) {
                                    underlayNW = underlaySW;
                                }

                                @Pc(1750) FloorUnderlayType underlayTypeSW = this.underlayTypeList.list(underlaySW - 1);
                                @Pc(1758) FloorUnderlayType underlayTypeNW = this.underlayTypeList.list(underlayNW - 1);
                                @Pc(1766) FloorUnderlayType underlayTypeNE = this.underlayTypeList.list(underlayNE - 1);
                                @Pc(1774) FloorUnderlayType underlayTypeSE = this.underlayTypeList.list(underlaySE - 1);

                                @Pc(1277) byte local1277;
                                for (@Pc(1425) int local1425 = 0; local1425 < faceUnderlay; local1425++) {
                                    if (local88[-direction & 0x3] && local911[0] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 1;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 1;
                                        anIntArray695[4] = faceB[local1062];
                                        local1277 = 6;
                                        anIntArray695[5] = faceC[local1062];
                                    } else if (local88[2 - direction & 0x3] && local911[2] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 5;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 5;
                                        anIntArray695[4] = faceB[local1062];
                                        local1277 = 6;
                                        anIntArray695[5] = faceC[local1062];
                                    } else if (local88[1 - direction & 0x3] && local911[1] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 3;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 3;
                                        anIntArray695[4] = faceB[local1062];
                                        local1277 = 6;
                                        anIntArray695[5] = faceC[local1062];
                                    } else if (local88[3 - direction & 0x3] && local911[3] == local1062) {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = 7;
                                        anIntArray695[2] = faceC[local1062];
                                        anIntArray695[3] = 7;
                                        anIntArray695[4] = faceB[local1062];
                                        anIntArray695[5] = faceC[local1062];
                                        local1277 = 6;
                                    } else {
                                        anIntArray695[0] = faceA[local1062];
                                        anIntArray695[1] = faceB[local1062];
                                        local1277 = 3;
                                        anIntArray695[2] = faceC[local1062];
                                    }

                                    local1062++;

                                    for (@Pc(1430) int local1430 = 0; local1430 < local1277; local1430++) {
                                        @Pc(1452) int local1452 = anIntArray695[local1430];
                                        @Pc(1435) int local1435 = (local1452 - (direction * 2)) & 0x7;
                                        @Pc(1448) int offsetX = this.tileOffsetX[local1452];
                                        @Pc(1508) int offsetY = this.tileOffsetY[local1452];

                                        @Pc(2056) int local2056;
                                        @Pc(1501) int local1501;
                                        if (direction == 1) {
                                            local1501 = offsetY;
                                            local2056 = 512 - offsetX;
                                        } else if (direction == 2) {
                                            local1501 = 512 - offsetX;
                                            local2056 = 512 - offsetY;
                                        } else if (direction == 3) {
                                            local2056 = offsetX;
                                            local1501 = 512 - offsetY;
                                        } else {
                                            local1501 = offsetX;
                                            local2056 = offsetY;
                                        }

                                        local1079[local1064] = local1501;
                                        local1082[local1064] = local2056;

                                        @Pc(2106) int local2106;
                                        @Pc(2112) int local2112;
                                        if (local1099 != null && aBooleanArrayArray7[shape][local1452]) {
                                            local2106 = local1501 + (x << 9);
                                            local2112 = local2056 + (z << 9);
                                            local1099[local1064] = surfaceGround.averageHeight(local2106, local2112) - ground.averageHeight(local2106, local2112);
                                        }

                                        if (waterDepths != null) {
                                            if (surfaceGround != null && !aBooleanArrayArray7[shape][local1452]) {
                                                local2106 = (x << 9) + local1501;
                                                local2112 = local2056 + (z << 9);
                                                waterDepths[local1064] = ground.averageHeight(local2106, local2112) - surfaceGround.averageHeight(local2106, local2112);
                                            } else if (underwaterGround != null && !Static355.aBooleanArrayArray4[shape][local1452]) {
                                                local2106 = local1501 + (x << 9);
                                                local2112 = (z << 9) + local2056;
                                                waterDepths[local1064] = underwaterGround.averageHeight(local2106, local2112) - ground.averageHeight(local2106, local2112);
                                            }
                                        }

                                        if (local1452 < 8 && OVERLAY_BLEND_PRIORITIES[local1435] >= 0) {
                                            if (overlayBlendColours != null) {
                                                overlayBlendColours[local1064] = OVERLAY_BLEND_COLOURS[local1435];
                                            }
                                            blendedSizes[local1064] = OVERLAY_SIZES[local1435];
                                            blendedTextures[local1064] = OVERLAY_TEXTURES[local1435];
                                            blendedColours[local1064] = OVERLAY_COLOURS[local1435];
                                        } else {
                                            if (blendable && aBooleanArrayArray7[shape][local1452]) {
                                                blendedTextures[local1064] = texture;
                                                blendedSizes[local1064] = size;
                                                blendedColours[local1064] = colour;
                                            } else if (local1501 == 0 && local2056 == 0) {
                                                blendedColours[local1064] = colours[x][z];
                                                blendedTextures[local1064] = underlayTypeSW.texture;
                                                blendedSizes[local1064] = underlayTypeSW.size;
                                            } else if (local1501 == 0 && local2056 == 512) {
                                                blendedColours[local1064] = colours[x][nextZ];
                                                blendedTextures[local1064] = underlayTypeNW.texture;
                                                blendedSizes[local1064] = underlayTypeNW.size;
                                            } else if (local1501 == 512 && local2056 == 512) {
                                                blendedColours[local1064] = colours[nextX][nextZ];
                                                blendedTextures[local1064] = underlayTypeNE.texture;
                                                blendedSizes[local1064] = underlayTypeNE.size;
                                            } else if (local1501 == 512 && local2056 == 0) {
                                                blendedColours[local1064] = colours[nextX][z];
                                                blendedTextures[local1064] = underlayTypeSE.texture;
                                                blendedSizes[local1064] = underlayTypeSE.size;
                                            } else {
                                                if (local1501 >= 256) {
                                                    if (local2056 < 256) {
                                                        blendedTextures[local1064] = underlayTypeSE.texture;
                                                        blendedSizes[local1064] = underlayTypeSE.size;
                                                    } else {
                                                        blendedTextures[local1064] = underlayTypeNE.texture;
                                                        blendedSizes[local1064] = underlayTypeNE.size;
                                                    }
                                                } else if (local2056 < 256) {
                                                    blendedTextures[local1064] = underlayTypeSW.texture;
                                                    blendedSizes[local1064] = underlayTypeSW.size;
                                                } else {
                                                    blendedTextures[local1064] = underlayTypeNW.texture;
                                                    blendedSizes[local1064] = underlayTypeNW.size;
                                                }
                                                local2106 = Static273.method3966(colours[nextX][z], local1501 << 7 >> 9, colours[x][z]);
                                                local2112 = Static273.method3966(colours[nextX][nextZ], local1501 << 7 >> 9, colours[x][nextZ]);
                                                blendedColours[local1064] = Static273.method3966(local2112, local2056 << 7 >> 9, local2106);
                                            }

                                            if (overlayBlendColours != null) {
                                                overlayBlendColours[local1064] = blendedColours[local1064];
                                            }
                                        }

                                        local1064++;
                                    }
                                }

                                if (shape != 0 && underlayType.allowShadow) {
                                    allowShadow = true;
                                }
                            }

                            @Pc(1162) int heightSW = ground.getHeight(x, z);
                            @Pc(1164) int heightSE = ground.getHeight(nextX, z);
                            @Pc(1411) int heightNE = ground.getHeight(nextX, nextZ);
                            @Pc(1416) int heightNW = ground.getHeight(x, nextZ);

                            @Pc(2560) boolean bridge = Static441.isBridgeAt(z, x);
                            if (bridge && level > 1 || !bridge && level > 0) {
                                @Pc(2579) boolean occludes = true;

                                if (underlayType != null && !underlayType.occludes) {
                                    occludes = false;
                                } else if (underlaySW == 0 && shape != 0) {
                                    occludes = false;
                                } else if (overlaySW > 0 && local187 != null && !local187.occludes) {
                                    occludes = false;
                                }

                                if (occludes && heightSE == heightSW && heightNE == heightSW && heightSW == heightNW) {
                                    this.occluderFlags[level][x][z] = (byte) (this.occluderFlags[level][x][z] | 0x4);
                                }
                            }

                            @Pc(1430) int waterColour = 0;
                            @Pc(1452) int waterDepth = 0;
                            @Pc(1435) int waterBias = 0;
                            if (this.underwater) {
                                waterColour = Static100.getWaterColour(x, z);
                                waterDepth = Static350.getWaterDepth(x, z);
                                waterBias = Static339.getWaterBias(x, z);
                            }

                            ground.U(x, z, local1079, local1099, local1082, waterDepths, blendedColours, overlayBlendColours, blendedTextures, blendedSizes, waterColour, waterDepth, waterBias, allowShadow);
                            Static527.method7084(level, x, z);
                        }
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(IIIIILclient!ge;II[Lclient!eq;B)V")
    public final void decodeZone(@OriginalArg(2) int x, @OriginalArg(4) int z, @OriginalArg(0) int level, @OriginalArg(7) int pointerX, @OriginalArg(3) int pointerZ, @OriginalArg(1) int pointerLevel, @OriginalArg(6) int pointerRotation, @OriginalArg(5) Packet packet, @OriginalArg(8) CollisionMap[] collisionMaps) {
        @Pc(17) int pointerSquareX = (pointerX & 0x7) * 8;
        @Pc(23) int pointerSquareZ = (pointerZ & 0x7) * 8;

        if (!this.underwater) {
            @Pc(30) CollisionMap collisionMap = collisionMaps[level];
            for (@Pc(32) int zoneX = 0; zoneX < 8; zoneX++) {
                for (@Pc(35) int zoneZ = 0; zoneZ < 8; zoneZ++) {
                    @Pc(49) int tileX = x + MapRegion.rotateZoneX(zoneX & 0x7, zoneZ & 0x7, pointerRotation);
                    @Pc(61) int tileZ = z + MapRegion.rotateZoneY(zoneX & 0x7, zoneZ & 0x7, pointerRotation);

                    if (tileX > 0 && this.width - 1 > tileX && tileZ > 0 && tileZ < this.length - 1) {
                        collisionMap.unflagBlocked(tileX, tileZ);
                    }
                }
            }
        }

        @Pc(117) int local117 = (pointerX & ~0x7) << 3;
        @Pc(32) int local32 = (pointerZ & ~0x7) << 3;
        @Pc(125) byte offsetX = 0;
        @Pc(127) byte offsetZ = 0;
        if (pointerRotation == 1) {
            offsetZ = 1;
        } else if (pointerRotation == 2) {
            offsetZ = 1;
            offsetX = 1;
        } else if (pointerRotation == 3) {
            offsetX = 1;
        }

        for (@Pc(61) int squareLevel = 0; squareLevel < this.levels; squareLevel++) {
            for (@Pc(153) int squareX = 0; squareX < 64; squareX++) {
                for (@Pc(156) int squareZ = 0; squareZ < 64; squareZ++) {
                    if (pointerLevel == squareLevel && squareX >= pointerSquareX && squareX <= pointerSquareX + 8 && pointerSquareZ <= squareZ && squareZ <= pointerSquareZ + 8) {
                        @Pc(243) int zoneX;
                        @Pc(252) int zoneZ;

                        if (pointerSquareX + 8 == squareX || squareZ == pointerSquareZ + 8) {
                            if (pointerRotation == 0) {
                                zoneX = x + squareX - pointerSquareX;
                                zoneZ = z + squareZ - pointerSquareZ;
                            } else if (pointerRotation == 1) {
                                zoneX = x + squareZ - pointerSquareZ;
                                zoneZ = pointerSquareX + z + 8 - squareX;
                            } else if (pointerRotation == 2) {
                                zoneX = x + pointerSquareX + 8 - squareX;
                                zoneZ = pointerSquareZ + z + 8 - squareZ;
                            } else {
                                zoneZ = squareX + z - pointerSquareX;
                                zoneX = x + pointerSquareZ + 8 - squareZ;
                            }

                            this.decodeTile(packet, zoneX, zoneZ, squareX + local117, squareZ + local32, 0, 0, level, 0, true);
                        } else {
                            zoneX = x + MapRegion.rotateZoneX(squareX & 0x7, squareZ & 0x7, pointerRotation);
                            zoneZ = MapRegion.rotateZoneY(squareX & 0x7, squareZ & 0x7, pointerRotation) + z;
                            this.decodeTile(packet, zoneX, zoneZ, squareX + local117, squareZ + local32, offsetX, offsetZ, level, pointerRotation, false);
                        }

                        if (squareX == 63 || squareZ == 63) {
                            @Pc(376) byte rotations = 1;
                            if (squareX == 63 && squareZ == 63) {
                                rotations = 3;
                            }

                            for (@Pc(390) int rotation = 0; rotation < rotations; rotation++) {
                                @Pc(393) int x2 = squareX;
                                @Pc(395) int z2 = squareZ;
                                if (rotation == 0) {
                                    z2 = squareZ == 63 ? 64 : squareZ;
                                    x2 = squareX == 63 ? 64 : squareX;
                                } else if (rotation == 1) {
                                    x2 = 64;
                                } else if (rotation == 2) {
                                    z2 = 64;
                                }

                                @Pc(450) int x1;
                                @Pc(442) int z1;
                                if (pointerRotation == 0) {
                                    z1 = z + z2 - pointerSquareZ;
                                    x1 = x2 + x - pointerSquareX;
                                } else if (pointerRotation == 1) {
                                    x1 = z2 + x - pointerSquareZ;
                                    z1 = z + pointerSquareX + 8 - x2;
                                } else if (pointerRotation == 2) {
                                    z1 = pointerSquareZ + z + 8 - z2;
                                    x1 = pointerSquareX + x + 8 - x2;
                                } else {
                                    z1 = z + x2 - pointerSquareX;
                                    x1 = x + pointerSquareZ + 8 - z2;
                                }

                                if (x1 >= 0 && x1 < this.width && z1 >= 0 && z1 < this.length) {
                                    this.tileHeights[level][x1][z1] = this.tileHeights[level][offsetX + zoneX][zoneZ + offsetZ];
                                }
                            }
                        }
                    } else {
                        this.decodeTile(packet, -1, -1, 0, 0, 0, 0, 0, 0, false);
                    }
                }
            }
        }
    }
}
