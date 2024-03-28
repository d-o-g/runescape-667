import com.jagex.core.io.Packet;
import com.jagex.game.camera.Shake;
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

    @OriginalMember(owner = "client!qja", name = "e", descriptor = "[[[B")
    public byte[][][] aByteArrayArrayArray12;

    @OriginalMember(owner = "client!qja", name = "j", descriptor = "[I")
    public final int[] anIntArray706 = new int[]{0, 0, 0, 256, 512, 512, 512, 256, 256, 384, 128, 128, 256};

    @OriginalMember(owner = "client!qja", name = "h", descriptor = "[I")
    public final int[] anIntArray707 = new int[]{0, 256, 512, 512, 512, 256, 0, 0, 128, 256, 128, 384, 256};

    @OriginalMember(owner = "client!qja", name = "k", descriptor = "Lclient!dh;")
    public final FloorUnderlayTypeList aFloorUnderlayTypeList_8;

    @OriginalMember(owner = "client!qja", name = "q", descriptor = "I")
    protected final int length;

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "I")
    public final int levels;

    @OriginalMember(owner = "client!qja", name = "m", descriptor = "Z")
    public final boolean underwater;

    @OriginalMember(owner = "client!qja", name = "n", descriptor = "I")
    protected final int width;

    @OriginalMember(owner = "client!qja", name = "l", descriptor = "Lclient!ef;")
    public final FloorOverlayTypeList aFloorOverlayTypeList_6;

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
        this.aFloorUnderlayTypeList_8 = arg5;
        this.length = length;
        this.levels = levels;
        this.underwater = underwater;
        this.width = width;
        this.aFloorOverlayTypeList_6 = arg4;
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
    public void method7882(@OriginalArg(0) int arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) int[][] arg2, @OriginalArg(4) Ground arg3, @OriginalArg(5) Ground arg4, @OriginalArg(6) Ground arg5) {
        for (@Pc(1) int local1 = 0; local1 < this.width; local1++) {
            for (@Pc(4) int local4 = 0; local4 < this.length; local4++) {
                if (Static478.anInt7198 == -1 || Static696.isTileVisibleFrom(local4, Static478.anInt7198, local1, arg0)) {
                    @Pc(28) byte local28 = this.tileShapes[arg0][local1][local4];
                    @Pc(37) byte local37 = this.tileDirections[arg0][local1][local4];
                    @Pc(48) int local48 = this.overlay[arg0][local1][local4] & 0xFF;
                    @Pc(59) int local59 = this.underlay[arg0][local1][local4] & 0xFF;
                    @Pc(72) FloorOverlayType local72 = local48 == 0 ? null : this.aFloorOverlayTypeList_6.list(local48 - 1);
                    if (local28 == 0 && local72 == null) {
                        local28 = 12;
                    }
                    @Pc(93) FloorUnderlayType local93 = local59 == 0 ? null : this.aFloorUnderlayTypeList_8.list(local59 - 1);
                    @Pc(95) FloorOverlayType local95 = local72;
                    if (local72 != null && local72.colour == -1 && local72.blendColour == -1) {
                        local95 = local72;
                        local72 = null;
                    }
                    if (local72 != null || local93 != null) {
                        @Pc(125) int local125 = Static102.anIntArray183[local28];
                        @Pc(129) int local129 = Static298.anIntArray366[local28];
                        @Pc(143) int local143 = (local93 == null ? 0 : local125) + (local72 == null ? 0 : local129);
                        @Pc(145) int local145 = 0;
                        @Pc(147) int local147 = 0;
                        @Pc(155) int local155 = local72 == null ? -1 : local72.texture;
                        @Pc(163) int local163 = local93 == null ? -1 : local93.texture;
                        @Pc(166) int[] local166 = new int[local143];
                        @Pc(169) int[] local169 = new int[local143];
                        @Pc(172) int[] local172 = new int[local143];
                        @Pc(175) int[] local175 = new int[local143];
                        @Pc(178) int[] local178 = new int[local143];
                        @Pc(181) int[] local181 = new int[local143];
                        @Pc(195) int[] local195 = local72 == null || local72.blendColour == -1 ? null : new int[local143];
                        @Pc(199) int local199;
                        if (local72 == null) {
                            local147 = local129;
                        } else {
                            for (local199 = 0; local199 < local129; local199++) {
                                local166[local145] = Static260.anIntArrayArray96[local28][local147];
                                local169[local145] = Static586.anIntArrayArray220[local28][local147];
                                local172[local145] = Static551.anIntArrayArray204[local28][local147];
                                local178[local145] = local155;
                                local181[local145] = local72.size;
                                local175[local145] = local72.colour;
                                if (local195 != null) {
                                    local195[local145] = local72.blendColour;
                                }
                                local145++;
                                local147++;
                            }
                            if (!this.underwater && arg0 == 0) {
                                Static295.method4354(local1, local4, local72.waterColour, local72.waterDepth * 8, local72.waterBias);
                            }
                        }
                        if (local93 != null) {
                            for (local199 = 0; local199 < local125; local199++) {
                                local166[local145] = Static260.anIntArrayArray96[local28][local147];
                                local169[local145] = Static586.anIntArrayArray220[local28][local147];
                                local172[local145] = Static551.anIntArrayArray204[local28][local147];
                                local178[local145] = local163;
                                local181[local145] = local93.size;
                                local175[local145] = arg2[local1][local4];
                                if (local195 != null) {
                                    local195[local145] = local175[local145];
                                }
                                local147++;
                                local145++;
                            }
                        }
                        local199 = this.anIntArray707.length;
                        @Pc(352) int[] local352 = new int[local199];
                        @Pc(355) int[] local355 = new int[local199];
                        @Pc(363) int[] local363 = arg3 == null ? null : new int[local199];
                        @Pc(375) int[] local375 = arg3 == null && arg5 == null ? null : new int[local199];
                        @Pc(383) int local383;
                        @Pc(388) int local388;
                        @Pc(477) int local477;
                        @Pc(485) int local485;
                        for (@Pc(377) int local377 = 0; local377 < local199; local377++) {
                            local383 = this.anIntArray707[local377];
                            local388 = this.anIntArray706[local377];
                            if (local37 == 0) {
                                local352[local377] = local383;
                                local355[local377] = local388;
                            } else if (local37 == 1) {
                                local352[local377] = local388;
                                local355[local377] = 512 - local383;
                            } else if (local37 == 2) {
                                local352[local377] = 512 - local383;
                                local355[local377] = 512 - local388;
                            } else if (local37 == 3) {
                                local352[local377] = 512 - local388;
                                local355[local377] = local383;
                            }
                            if (local363 != null && Static499.aBooleanArrayArray7[local28][local377]) {
                                local477 = local352[local377] + (local1 << 9);
                                local485 = (local4 << 9) + local355[local377];
                                local363[local377] = arg3.averageHeight(local477, local485) - arg4.averageHeight(local477, local485);
                            }
                            if (local375 != null) {
                                if (arg3 != null && !Static499.aBooleanArrayArray7[local28][local377]) {
                                    local477 = local352[local377] + (local1 << 9);
                                    local485 = (local4 << 9) + local355[local377];
                                    local375[local377] = arg4.averageHeight(local477, local485) - arg3.averageHeight(local477, local485);
                                } else if (arg5 != null && !Static355.aBooleanArrayArray4[local28][local377]) {
                                    local477 = (local1 << 9) + local352[local377];
                                    local485 = local355[local377] + (local4 << 9);
                                    local375[local377] = arg5.averageHeight(local477, local485) - arg4.averageHeight(local477, local485);
                                }
                            }
                        }
                        local383 = arg4.getHeight(local1, local4);
                        local388 = arg4.getHeight(local1 + 1, local4);
                        local477 = arg4.getHeight(local1 - -1, local4 + 1);
                        local485 = arg4.getHeight(local1, local4 + 1);
                        @Pc(633) boolean local633 = Static441.isBridgeAt(local4, local1);
                        if (local633 && arg0 > 1 || !local633 && arg0 > 0) {
                            @Pc(652) boolean local652 = true;
                            if (local93 != null && !local93.occludes) {
                                local652 = false;
                            } else if (local59 == 0 && local28 != 0) {
                                local652 = false;
                            } else if (local48 > 0 && local95 != null && !local95.occludes) {
                                local652 = false;
                            }
                            if (local652 && local388 == local383 && local477 == local383 && local383 == local485) {
                                this.occluderFlags[arg0][local1][local4] = (byte) (this.occluderFlags[arg0][local1][local4] | 0x4);
                            }
                        }
                        @Pc(740) int local740 = 0;
                        @Pc(742) int local742 = 0;
                        @Pc(744) int local744 = 0;
                        if (this.underwater) {
                            local740 = Static100.method1987(local1, local4);
                            local742 = Static350.method5124(local1, local4);
                            local744 = Static339.method5005(local1, local4);
                        }
                        arg4.method7871(local1, local4, local352, local363, local355, local375, local166, local169, local172, local175, local195, local178, local181, local740, local742, local744);
                        Static527.method7084(arg0, local1, local4);
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(ILclient!re;[[BIIIIILclient!ha;I[ZLclient!nq;[[B[[B)V")
    public void method7883(@OriginalArg(0) int arg0, @OriginalArg(1) FloorOverlayType arg1, @OriginalArg(2) byte[][] arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) Toolkit arg7, @OriginalArg(9) int arg8, @OriginalArg(10) boolean[] arg9, @OriginalArg(11) FloorUnderlayType arg10, @OriginalArg(12) byte[][] arg11, @OriginalArg(13) byte[][] arg12) {
        @Pc(19) boolean[] local19 = arg1 != null && arg1.blendable ? Static463.aBooleanArrayArray6[arg0] : Static435.aBooleanArrayArray5[arg0];
        @Pc(37) int local37;
        @Pc(50) FloorOverlayType local50;
        @Pc(70) byte local70;
        @Pc(86) int local86;
        @Pc(91) int local91;
        if (arg8 > 0) {
            if (arg4 > 0) {
                local37 = arg12[arg4 - 1][arg8 - 1] & 0xFF;
                if (local37 > 0) {
                    local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                    if (local50.colour != -1 && local50.blendable) {
                        local70 = arg11[arg4 - 1][arg8 - 1];
                        local86 = arg2[arg4 - 1][arg8 - 1] * 2 + 4 & 0x7;
                        local91 = Static718.method9367(local50, arg7);
                        if (Static499.aBooleanArrayArray7[local70][local86]) {
                            Static319.anIntArray385[0] = local50.colour;
                            Static262.anIntArray326[0] = local91;
                            Static153.anIntArray234[0] = local50.texture;
                            Static725.anIntArray890[0] = local50.size;
                            Static615.anIntArray719[0] = local50.blendPriority;
                            Static248.anIntArray313[0] = 256;
                        }
                    }
                }
            }
            if (arg3 - 1 > arg4) {
                local37 = arg12[arg4 + 1][arg8 - 1] & 0xFF;
                if (local37 > 0) {
                    local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                    if (local50.colour != -1 && local50.blendable) {
                        local70 = arg11[arg4 + 1][arg8 - 1];
                        local86 = arg2[arg4 + 1][arg8 - 1] * 2 + 6 & 0x7;
                        local91 = Static718.method9367(local50, arg7);
                        if (Static499.aBooleanArrayArray7[local70][local86]) {
                            Static319.anIntArray385[2] = local50.colour;
                            Static262.anIntArray326[2] = local91;
                            Static153.anIntArray234[2] = local50.texture;
                            Static725.anIntArray890[2] = local50.size;
                            Static615.anIntArray719[2] = local50.blendPriority;
                            Static248.anIntArray313[2] = 512;
                        }
                    }
                }
            }
        }
        if (arg6 - 1 > arg8) {
            if (arg4 > 0) {
                local37 = arg12[arg4 - 1][arg8 + 1] & 0xFF;
                if (local37 > 0) {
                    local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                    if (local50.colour != -1 && local50.blendable) {
                        local70 = arg11[arg4 - 1][arg8 + 1];
                        local86 = arg2[arg4 - 1][arg8 + 1] * 2 + 2 & 0x7;
                        local91 = Static718.method9367(local50, arg7);
                        if (Static499.aBooleanArrayArray7[local70][local86]) {
                            Static319.anIntArray385[6] = local50.colour;
                            Static262.anIntArray326[6] = local91;
                            Static153.anIntArray234[6] = local50.texture;
                            Static725.anIntArray890[6] = local50.size;
                            Static615.anIntArray719[6] = local50.blendPriority;
                            Static248.anIntArray313[6] = 64;
                        }
                    }
                }
            }
            if (arg3 - 1 > arg4) {
                local37 = arg12[arg4 + 1][arg8 + 1] & 0xFF;
                if (local37 > 0) {
                    local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                    if (local50.colour != -1 && local50.blendable) {
                        local70 = arg11[arg4 + 1][arg8 + 1];
                        local86 = (arg2[arg4 + 1][arg8 + 1] * 2) & 0x7;
                        local91 = Static718.method9367(local50, arg7);
                        if (Static499.aBooleanArrayArray7[local70][local86]) {
                            Static319.anIntArray385[4] = local50.colour;
                            Static262.anIntArray326[4] = local91;
                            Static153.anIntArray234[4] = local50.texture;
                            Static725.anIntArray890[4] = local50.size;
                            Static615.anIntArray719[4] = local50.blendPriority;
                            Static248.anIntArray313[4] = 128;
                        }
                    }
                }
            }
        }
        @Pc(509) int local509;
        @Pc(514) int local514;
        @Pc(516) int local516;
        @Pc(498) byte local498;
        if (arg8 > 0) {
            local37 = arg12[arg4][arg8 - 1] & 0xFF;
            if (local37 > 0) {
                local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                if (local50.colour != -1) {
                    local70 = arg11[arg4][arg8 - 1];
                    local498 = arg2[arg4][arg8 - 1];
                    if (local50.blendable) {
                        local91 = 2;
                        local509 = local498 * 2 + 4;
                        local514 = Static718.method9367(local50, arg7);
                        for (local516 = 0; local516 < 3; local516++) {
                            local91 &= 0x7;
                            local509 &= 0x7;
                            if (Static499.aBooleanArrayArray7[local70][local509] && local50.blendPriority >= Static615.anIntArray719[local91]) {
                                Static319.anIntArray385[local91] = local50.colour;
                                Static262.anIntArray326[local91] = local514;
                                Static153.anIntArray234[local91] = local50.texture;
                                Static725.anIntArray890[local91] = local50.size;
                                if (Static615.anIntArray719[local91] == local50.blendPriority) {
                                    Static248.anIntArray313[local91] |= 0x20;
                                } else {
                                    Static248.anIntArray313[local91] = 32;
                                }
                                Static615.anIntArray719[local91] = local50.blendPriority;
                            }
                            local91--;
                            local509++;
                        }
                        if (!local19[arg5 & 0x3]) {
                            arg9[0] = Static463.aBooleanArrayArray6[local70][local498 + 2 & 0x3];
                        }
                    } else if (!local19[arg5 & 0x3]) {
                        arg9[0] = Static435.aBooleanArrayArray5[local70][local498 + 2 & 0x3];
                    }
                }
            }
        }
        if (arg6 - 1 > arg8) {
            local37 = arg12[arg4][arg8 + 1] & 0xFF;
            if (local37 > 0) {
                local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                if (local50.colour != -1) {
                    local70 = arg11[arg4][arg8 + 1];
                    local498 = arg2[arg4][arg8 + 1];
                    if (local50.blendable) {
                        local91 = 4;
                        local509 = local498 * 2 + 2;
                        local514 = Static718.method9367(local50, arg7);
                        for (local516 = 0; local516 < 3; local516++) {
                            local91 &= 0x7;
                            local509 &= 0x7;
                            if (Static499.aBooleanArrayArray7[local70][local509] && Static615.anIntArray719[local91] <= local50.blendPriority) {
                                Static319.anIntArray385[local91] = local50.colour;
                                Static262.anIntArray326[local91] = local514;
                                Static153.anIntArray234[local91] = local50.texture;
                                Static725.anIntArray890[local91] = local50.size;
                                if (Static615.anIntArray719[local91] == local50.blendPriority) {
                                    Static248.anIntArray313[local91] |= 0x10;
                                } else {
                                    Static248.anIntArray313[local91] = 16;
                                }
                                Static615.anIntArray719[local91] = local50.blendPriority;
                            }
                            local91++;
                            local509--;
                        }
                        if (!local19[arg5 + 2 & 0x3]) {
                            arg9[2] = Static463.aBooleanArrayArray6[local70][--local498 & 0x3];
                        }
                    } else if (!local19[arg5 + 2 & 0x3]) {
                        arg9[2] = Static435.aBooleanArrayArray5[local70][local498 & 0x3];
                    }
                }
            }
        }
        if (arg4 > 0) {
            local37 = arg12[arg4 - 1][arg8] & 0xFF;
            if (local37 > 0) {
                local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                if (local50.colour != -1) {
                    local70 = arg11[arg4 - 1][arg8];
                    local498 = arg2[arg4 - 1][arg8];
                    if (local50.blendable) {
                        local91 = 6;
                        local509 = local498 * 2 + 4;
                        local514 = Static718.method9367(local50, arg7);
                        for (local516 = 0; local516 < 3; local516++) {
                            local91 &= 0x7;
                            local509 &= 0x7;
                            if (Static499.aBooleanArrayArray7[local70][local509] && Static615.anIntArray719[local91] <= local50.blendPriority) {
                                Static319.anIntArray385[local91] = local50.colour;
                                Static262.anIntArray326[local91] = local514;
                                Static153.anIntArray234[local91] = local50.texture;
                                Static725.anIntArray890[local91] = local50.size;
                                if (local50.blendPriority == Static615.anIntArray719[local91]) {
                                    Static248.anIntArray313[local91] |= 0x8;
                                } else {
                                    Static248.anIntArray313[local91] = 8;
                                }
                                Static615.anIntArray719[local91] = local50.blendPriority;
                            }
                            local91++;
                            local509--;
                        }
                        if (!local19[arg5 + 3 & 0x3]) {
                            arg9[3] = Static463.aBooleanArrayArray6[local70][local498 + 1 & 0x3];
                        }
                    } else if (!local19[arg5 + 3 & 0x3]) {
                        arg9[3] = Static435.aBooleanArrayArray5[local70][local498 + 1 & 0x3];
                    }
                }
            }
        }
        if (arg4 < arg3 - 1) {
            local37 = arg12[arg4 + 1][arg8] & 0xFF;
            if (local37 > 0) {
                local50 = this.aFloorOverlayTypeList_6.list(local37 - 1);
                if (local50.colour != -1) {
                    local70 = arg11[arg4 + 1][arg8];
                    local498 = arg2[arg4 + 1][arg8];
                    if (local50.blendable) {
                        local91 = 4;
                        local509 = local498 * 2 + 6;
                        local514 = Static718.method9367(local50, arg7);
                        for (local516 = 0; local516 < 3; local516++) {
                            local509 &= 0x7;
                            local91 &= 0x7;
                            if (Static499.aBooleanArrayArray7[local70][local509] && local50.blendPriority >= Static615.anIntArray719[local91]) {
                                Static319.anIntArray385[local91] = local50.colour;
                                Static262.anIntArray326[local91] = local514;
                                Static153.anIntArray234[local91] = local50.texture;
                                Static725.anIntArray890[local91] = local50.size;
                                if (Static615.anIntArray719[local91] == local50.blendPriority) {
                                    Static248.anIntArray313[local91] |= 0x4;
                                } else {
                                    Static248.anIntArray313[local91] = 4;
                                }
                                Static615.anIntArray719[local91] = local50.blendPriority;
                            }
                            local91--;
                            local509++;
                        }
                        if (!local19[arg5 + 1 & 0x3]) {
                            arg9[1] = Static463.aBooleanArrayArray6[local70][local498 + 3 & 0x3];
                        }
                    } else if (!local19[arg5 + 1 & 0x3]) {
                        arg9[1] = Static435.aBooleanArrayArray5[local70][local498 + 3 & 0x3];
                    }
                }
            }
        }
        if (arg1 == null) {
            return;
        }
        local37 = Static718.method9367(arg1, arg7);
        if (!arg1.blendable) {
            return;
        }
        for (@Pc(1245) int local1245 = 0; local1245 < 8; local1245++) {
            @Pc(1255) int local1255 = local1245 - arg5 * 2 & 0x7;
            if (Static499.aBooleanArrayArray7[arg0][local1245] && arg1.blendPriority >= Static615.anIntArray719[local1255]) {
                Static319.anIntArray385[local1255] = arg1.colour;
                Static262.anIntArray326[local1255] = local37;
                Static153.anIntArray234[local1255] = arg1.texture;
                Static725.anIntArray890[local1255] = arg1.size;
                if (arg1.blendPriority == Static615.anIntArray719[local1255]) {
                    Static248.anIntArray313[local1255] |= 0x2;
                } else {
                    Static248.anIntArray313[local1255] = 2;
                }
                Static615.anIntArray719[local1255] = arg1.blendPriority;
            }
        }
        return;
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
    public final void method7888(@OriginalArg(1) Toolkit arg0, @OriginalArg(2) Ground arg1, @OriginalArg(3) Ground arg2) {
        if (Static397.anIntArray482 == null || this.length != Static397.anIntArray482.length) {
            Static501.anIntArray606 = new int[this.length];
            Static418.anIntArray704 = new int[this.length];
            Static397.anIntArray482 = new int[this.length];
            Static359.anIntArray449 = new int[this.length];
            Static467.anIntArray568 = new int[this.length];
        }
        @Pc(45) int[][] local45 = new int[this.width][this.length];
        @Pc(50) int local50;
        for (@Pc(47) int local47 = 0; local47 < this.levels; local47++) {
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
                        local101 = this.underlay[local47][local86][local81] & 0xFF;
                        if (local101 > 0) {
                            @Pc(114) FloorUnderlayType local114 = this.aFloorUnderlayTypeList_8.list(local101 - 1);
                            Static397.anIntArray482[local81] += local114.anInt6630;
                            Static467.anIntArray568[local81] += local114.anInt6637;
                            Static501.anIntArray606[local81] += local114.anInt6639;
                            Static359.anIntArray449[local81] += local114.anInt6632;
                            local150 = Static418.anIntArray704[local81]++;
                        }
                    }
                    local101 = local78 - 5;
                    if (local101 >= 0) {
                        local170 = this.underlay[local47][local101][local81] & 0xFF;
                        if (local170 > 0) {
                            @Pc(180) FloorUnderlayType local180 = this.aFloorUnderlayTypeList_8.list(local170 - 1);
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
                            local45[local78][local244] = Static318.method8555(local170 / local242, local101 / local242, local86 * 256 / local240);
                        }
                    }
                }
            }
            if (Static718.aBoolean822) {
                this.method7890(local47 == 0 ? arg2 : null, local45, local47 == 0 ? arg1 : null, Static246.ground[local47], arg0, local47);
            } else {
                this.method7882(local47, arg0, local45, local47 == 0 ? arg2 : null, Static246.ground[local47], local47 == 0 ? arg1 : null);
            }
            this.underlay[local47] = null;
            this.overlay[local47] = null;
            this.tileShapes[local47] = null;
            this.tileDirections[local47] = null;
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
    public void method7890(@OriginalArg(0) Ground arg0, @OriginalArg(2) int[][] arg1, @OriginalArg(3) Ground arg2, @OriginalArg(4) Ground arg3, @OriginalArg(5) Toolkit arg4, @OriginalArg(6) int arg5) {
        @Pc(8) byte[][] local8 = this.tileShapes[arg5];
        @Pc(13) byte[][] local13 = this.tileDirections[arg5];
        @Pc(26) byte[][] local26 = this.underlay[arg5];
        @Pc(31) byte[][] local31 = this.overlay[arg5];
        for (@Pc(33) int local33 = 0; local33 < this.width; local33++) {
            @Pc(47) int local47 = this.width - 1 > local33 ? local33 + 1 : local33;
            for (@Pc(49) int local49 = 0; local49 < this.length; local49++) {
                @Pc(67) int local67 = local49 < this.length - 1 ? local49 + 1 : local49;
                if (Static478.anInt7198 == -1 || Static696.isTileVisibleFrom(local49, Static478.anInt7198, local33, arg5)) {
                    @Pc(83) boolean local83 = false;
                    @Pc(85) boolean local85 = false;
                    @Pc(88) boolean[] local88 = new boolean[4];
                    @Pc(94) int local94 = local8[local33][local49];
                    @Pc(100) int local100 = local13[local33][local49];
                    @Pc(108) int local108 = local31[local33][local49] & 0xFF;
                    @Pc(116) int local116 = local26[local33][local49] & 0xFF;
                    @Pc(124) int local124 = local26[local33][local67] & 0xFF;
                    @Pc(132) int local132 = local26[local47][local67] & 0xFF;
                    @Pc(140) int local140 = local26[local47][local49] & 0xFF;
                    if (local108 != 0 || local116 != 0) {
                        @Pc(164) FloorOverlayType local164 = local108 == 0 ? null : this.aFloorOverlayTypeList_6.list(local108 - 1);
                        @Pc(177) FloorUnderlayType local177 = local116 == 0 ? null : this.aFloorUnderlayTypeList_8.list(local116 - 1);
                        if (local94 == 0 && local164 == null) {
                            local94 = 12;
                        }
                        @Pc(187) FloorOverlayType local187 = local164;
                        if (local164 != null) {
                            if (local164.colour == -1 && local164.blendColour == -1) {
                                local187 = local164;
                                local164 = null;
                            } else if (local177 != null && local94 != 0) {
                                local85 = local164.blendable;
                            }
                        }
                        @Pc(294) int local294;
                        @Pc(345) int local345;
                        @Pc(391) int local391;
                        @Pc(403) int local403;
                        if ((local94 == 0 || local94 == 12) && local33 > 0 && local49 > 0 && local33 < this.width && this.length > local49) {
                            @Pc(276) int local276 = local116 == local26[local47][local49 - 1] ? 1 : -1;
                            local294 = local26[local33 - 1][local49 - 1] == local116 ? 1 : -1;
                            @Pc(308) int local308 = local116 == local26[local47][local67] ? 1 : -1;
                            if (local26[local33][local49 - 1] == local116) {
                                local276++;
                                local294++;
                            } else {
                                local276--;
                                local294--;
                            }
                            local345 = local26[local33 - 1][local67] == local116 ? 1 : -1;
                            if (local116 == local26[local47][local49]) {
                                local308++;
                                local276++;
                            } else {
                                local276--;
                                local308--;
                            }
                            if (local116 == local26[local33][local67]) {
                                local308++;
                                local345++;
                            } else {
                                local308--;
                                local345--;
                            }
                            if (local116 == local26[local33 - 1][local49]) {
                                local294++;
                                local345++;
                            } else {
                                local294--;
                                local345--;
                            }
                            local391 = local294 - local308;
                            if (local391 < 0) {
                                local391 = -local391;
                            }
                            local403 = local276 - local345;
                            if (local403 < 0) {
                                local403 = -local403;
                            }
                            if (local391 == local403) {
                                local391 = arg3.getHeight(local33, local49) - arg3.getHeight(local47, local67);
                                if (local391 < 0) {
                                    local391 = -local391;
                                }
                                local403 = arg3.getHeight(local47, local49) - arg3.getHeight(local33, local67);
                                if (local403 < 0) {
                                    local403 = -local403;
                                }
                            }
                            local100 = local403 > local391 ? 1 : 0;
                        }
                        for (local294 = 0; local294 < 13; local294++) {
                            Static615.anIntArray719[local294] = -1;
                            Static248.anIntArray313[local294] = 1;
                        }
                        @Pc(496) boolean[] local496 = local164 != null && local164.blendable ? Static463.aBooleanArrayArray6[local94] : Static435.aBooleanArrayArray5[local94];
                        this.method7883(local94, local164, local13, this.width, local33, local100, this.length, arg4, local49, local88, local177, local8, local31);
                        @Pc(532) boolean local532 = local164 != null && local164.colour != local164.blendColour;
                        if (!local532) {
                            for (local345 = 0; local345 < 8; local345++) {
                                if (Static615.anIntArray719[local345] >= 0 && Static262.anIntArray326[local345] != Static319.anIntArray385[local345]) {
                                    local532 = true;
                                    break;
                                }
                            }
                        }
                        if (!local496[local100 + 1 & 0x3]) {
                            local88[1] = Static588.method7712(local88[1], (Static248.anIntArray313[2] & Static248.anIntArray313[4]) == 0);
                        }
                        if (!local496[local100 + 3 & 0x3]) {
                            local88[3] = Static588.method7712(local88[3], (Static248.anIntArray313[6] & Static248.anIntArray313[0]) == 0);
                        }
                        if (!local496[local100 & 0x3]) {
                            local88[0] = Static588.method7712(local88[0], (Static248.anIntArray313[0] & Static248.anIntArray313[2]) == 0);
                        }
                        if (!local496[local100 + 2 & 0x3]) {
                            local88[2] = Static588.method7712(local88[2], (Static248.anIntArray313[6] & Static248.anIntArray313[4]) == 0);
                        }
                        if (!local85 && (local94 == 0 || local94 == 12)) {
                            if (local88[0] && !local88[1] && !local88[2] && local88[3]) {
                                local88[0] = local88[3] = false;
                                local94 = local94 == 0 ? 13 : 14;
                                local100 = 0;
                            } else if (local88[0] && local88[1] && !local88[2] && !local88[3]) {
                                local94 = local94 == 0 ? 13 : 14;
                                local100 = 3;
                                local88[0] = local88[1] = false;
                            } else if (!local88[0] && local88[1] && local88[2] && !local88[3]) {
                                local94 = local94 == 0 ? 13 : 14;
                                local88[1] = local88[2] = false;
                                local100 = 2;
                            } else if (!local88[0] && !local88[1] && local88[2] && local88[3]) {
                                local94 = local94 == 0 ? 13 : 14;
                                local100 = 1;
                                local88[2] = local88[3] = false;
                            }
                        }
                        @Pc(909) boolean local909 = !local85 && !local88[0] && !local88[2] && !local88[1] && !local88[3];
                        @Pc(911) int[] local911 = null;
                        @Pc(917) int[] local917;
                        @Pc(934) int[] local934;
                        @Pc(930) int[] local930;
                        if (local909) {
                            local917 = Static260.anIntArrayArray96[local94];
                            local403 = local164 == null ? 0 : Static298.anIntArray366[local94];
                            local930 = Static551.anIntArrayArray204[local94];
                            local934 = Static586.anIntArrayArray220[local94];
                            local391 = local177 == null ? 0 : Static102.anIntArray183[local94];
                        } else if (local85) {
                            local930 = Shake.anIntArrayArray86[local94];
                            local403 = local164 == null ? 0 : Static348.anIntArray424[local94];
                            local917 = Static233.anIntArrayArray90[local94];
                            local911 = Static553.anIntArrayArray206[local94];
                            local934 = Static511.anIntArrayArray193[local94];
                            local391 = local177 == null ? 0 : Static661.anIntArray468[local94];
                        } else {
                            local391 = local177 == null ? 0 : Static381.anIntArray464[local94];
                            local930 = Static491.anIntArrayArray257[local94];
                            local403 = local164 == null ? 0 : Static496.anIntArray601[local94];
                            local917 = Static115.anIntArrayArray56[local94];
                            local911 = Static264.anIntArrayArray267[local94];
                            local934 = Static206.anIntArrayArray84[local94];
                        }
                        @Pc(1021) int local1021 = local403 + local391;
                        if (local1021 <= 0) {
                            Static527.method7084(arg5, local33, local49);
                        } else {
                            if (local88[0]) {
                                local1021++;
                            }
                            if (local88[2]) {
                                local1021++;
                            }
                            if (local88[1]) {
                                local1021++;
                            }
                            if (local88[3]) {
                                local1021++;
                            }
                            @Pc(1062) int local1062 = 0;
                            @Pc(1064) int local1064 = 0;
                            @Pc(1068) int local1068 = local1021 * 3;
                            @Pc(1076) int[] local1076 = local532 ? new int[local1068] : null;
                            @Pc(1079) int[] local1079 = new int[local1068];
                            @Pc(1082) int[] local1082 = new int[local1068];
                            @Pc(1085) int[] local1085 = new int[local1068];
                            @Pc(1088) int[] local1088 = new int[local1068];
                            @Pc(1091) int[] local1091 = new int[local1068];
                            @Pc(1099) int[] local1099 = arg0 == null ? null : new int[local1068];
                            @Pc(1111) int[] local1111 = arg0 == null && arg2 == null ? null : new int[local1068];
                            @Pc(1113) int local1113 = -1;
                            @Pc(1115) int local1115 = -1;
                            @Pc(1117) int local1117 = 256;
                            @Pc(1277) byte local1277;
                            @Pc(1162) int local1162;
                            @Pc(1164) int local1164;
                            @Pc(1411) int local1411;
                            @Pc(1416) int local1416;
                            @Pc(1425) int local1425;
                            @Pc(1430) int local1430;
                            @Pc(1452) int local1452;
                            @Pc(1435) int local1435;
                            @Pc(1448) int local1448;
                            @Pc(1501) int local1501;
                            @Pc(1508) int local1508;
                            if (local164 != null) {
                                local1117 = local164.size;
                                local1113 = local164.colour;
                                local1115 = local164.texture;
                                local1162 = Static718.method9367(local164, arg4);
                                for (local1164 = 0; local1164 < local403; local1164++) {
                                    if (local88[-local100 & 0x3] && local911[0] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 1;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 1;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        Static590.anIntArray695[5] = local930[local1062];
                                        local1277 = 6;
                                    } else if (local88[2 - local100 & 0x3] && local911[2] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 5;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 5;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        Static590.anIntArray695[5] = local930[local1062];
                                        local1277 = 6;
                                    } else if (local88[1 - local100 & 0x3] && local911[1] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 3;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 3;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        local1277 = 6;
                                        Static590.anIntArray695[5] = local930[local1062];
                                    } else if (local88[3 - local100 & 0x3] && local911[3] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 7;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 7;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        local1277 = 6;
                                        Static590.anIntArray695[5] = local930[local1062];
                                    } else {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = local934[local1062];
                                        Static590.anIntArray695[2] = local930[local1062];
                                        local1277 = 3;
                                    }
                                    for (local1411 = 0; local1411 < local1277; local1411++) {
                                        local1416 = Static590.anIntArray695[local1411];
                                        local1425 = local1416 - local100 * 2 & 0x7;
                                        local1430 = this.anIntArray707[local1416];
                                        local1435 = this.anIntArray706[local1416];
                                        if (local100 == 1) {
                                            local1448 = 512 - local1430;
                                            local1452 = local1435;
                                        } else if (local100 == 2) {
                                            local1448 = 512 - local1435;
                                            local1452 = 512 - local1430;
                                        } else if (local100 == 3) {
                                            local1452 = 512 - local1435;
                                            local1448 = local1430;
                                        } else {
                                            local1452 = local1430;
                                            local1448 = local1435;
                                        }
                                        local1079[local1064] = local1452;
                                        local1082[local1064] = local1448;
                                        if (local1099 != null && Static499.aBooleanArrayArray7[local94][local1416]) {
                                            local1501 = local1452 + (local33 << 9);
                                            local1508 = (local49 << 9) + local1448;
                                            local1099[local1064] = arg0.averageHeight(local1501, local1508) - arg3.averageHeight(local1501, local1508);
                                        }
                                        if (local1111 != null) {
                                            if (arg0 != null && !Static499.aBooleanArrayArray7[local94][local1416]) {
                                                local1501 = local1452 + (local33 << 9);
                                                local1508 = (local49 << 9) + local1448;
                                                local1111[local1064] = arg3.averageHeight(local1501, local1508) - arg0.averageHeight(local1501, local1508);
                                            } else if (arg2 != null && !Static355.aBooleanArrayArray4[local94][local1416]) {
                                                local1501 = local1452 + (local33 << 9);
                                                local1508 = local1448 + (local49 << 9);
                                                local1111[local1064] = arg2.averageHeight(local1501, local1508) - arg3.averageHeight(local1501, local1508);
                                            }
                                        }
                                        if (local1416 < 8 && Static615.anIntArray719[local1425] > local164.blendPriority) {
                                            if (local1076 != null) {
                                                local1076[local1064] = Static262.anIntArray326[local1425];
                                            }
                                            local1091[local1064] = Static725.anIntArray890[local1425];
                                            local1088[local1064] = Static153.anIntArray234[local1425];
                                            local1085[local1064] = Static319.anIntArray385[local1425];
                                        } else {
                                            if (local1076 != null) {
                                                local1076[local1064] = local1162;
                                            }
                                            local1088[local1064] = local164.texture;
                                            local1091[local1064] = local164.size;
                                            local1085[local1064] = local1113;
                                        }
                                        local1064++;
                                    }
                                    local1062++;
                                }
                                if (!this.underwater && arg5 == 0) {
                                    Static295.method4354(local33, local49, local164.waterColour, local164.waterDepth * 8, local164.waterBias);
                                }
                                if (local94 != 12 && local164.colour != -1 && local164.blockShadow) {
                                    local83 = true;
                                }
                            } else if (local909) {
                                local1062 = Static298.anIntArray366[local94];
                            } else if (local85) {
                                local1062 = Static348.anIntArray424[local94];
                            } else {
                                local1062 = Static496.anIntArray601[local94];
                            }
                            if (local177 != null) {
                                if (local140 == 0) {
                                    local140 = local116;
                                }
                                if (local132 == 0) {
                                    local132 = local116;
                                }
                                if (local124 == 0) {
                                    local124 = local116;
                                }
                                @Pc(1750) FloorUnderlayType local1750 = this.aFloorUnderlayTypeList_8.list(local116 - 1);
                                @Pc(1758) FloorUnderlayType local1758 = this.aFloorUnderlayTypeList_8.list(local124 - 1);
                                @Pc(1766) FloorUnderlayType local1766 = this.aFloorUnderlayTypeList_8.list(local132 - 1);
                                @Pc(1774) FloorUnderlayType local1774 = this.aFloorUnderlayTypeList_8.list(local140 - 1);
                                for (local1425 = 0; local1425 < local391; local1425++) {
                                    if (local88[-local100 & 0x3] && local911[0] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 1;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 1;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        local1277 = 6;
                                        Static590.anIntArray695[5] = local930[local1062];
                                    } else if (local88[2 - local100 & 0x3] && local911[2] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 5;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 5;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        local1277 = 6;
                                        Static590.anIntArray695[5] = local930[local1062];
                                    } else if (local88[1 - local100 & 0x3] && local911[1] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 3;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 3;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        local1277 = 6;
                                        Static590.anIntArray695[5] = local930[local1062];
                                    } else if (local88[3 - local100 & 0x3] && local911[3] == local1062) {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = 7;
                                        Static590.anIntArray695[2] = local930[local1062];
                                        Static590.anIntArray695[3] = 7;
                                        Static590.anIntArray695[4] = local934[local1062];
                                        Static590.anIntArray695[5] = local930[local1062];
                                        local1277 = 6;
                                    } else {
                                        Static590.anIntArray695[0] = local917[local1062];
                                        Static590.anIntArray695[1] = local934[local1062];
                                        local1277 = 3;
                                        Static590.anIntArray695[2] = local930[local1062];
                                    }
                                    local1062++;
                                    for (local1430 = 0; local1430 < local1277; local1430++) {
                                        local1452 = Static590.anIntArray695[local1430];
                                        local1435 = local1452 - local100 * 2 & 0x7;
                                        local1448 = this.anIntArray707[local1452];
                                        local1508 = this.anIntArray706[local1452];
                                        @Pc(2056) int local2056;
                                        if (local100 == 1) {
                                            local1501 = local1508;
                                            local2056 = 512 - local1448;
                                        } else if (local100 == 2) {
                                            local1501 = 512 - local1448;
                                            local2056 = 512 - local1508;
                                        } else if (local100 == 3) {
                                            local2056 = local1448;
                                            local1501 = 512 - local1508;
                                        } else {
                                            local1501 = local1448;
                                            local2056 = local1508;
                                        }
                                        local1079[local1064] = local1501;
                                        local1082[local1064] = local2056;
                                        @Pc(2106) int local2106;
                                        @Pc(2112) int local2112;
                                        if (local1099 != null && Static499.aBooleanArrayArray7[local94][local1452]) {
                                            local2106 = local1501 + (local33 << 9);
                                            local2112 = local2056 + (local49 << 9);
                                            local1099[local1064] = arg0.averageHeight(local2106, local2112) - arg3.averageHeight(local2106, local2112);
                                        }
                                        if (local1111 != null) {
                                            if (arg0 != null && !Static499.aBooleanArrayArray7[local94][local1452]) {
                                                local2106 = (local33 << 9) + local1501;
                                                local2112 = local2056 + (local49 << 9);
                                                local1111[local1064] = arg3.averageHeight(local2106, local2112) - arg0.averageHeight(local2106, local2112);
                                            } else if (arg2 != null && !Static355.aBooleanArrayArray4[local94][local1452]) {
                                                local2106 = local1501 + (local33 << 9);
                                                local2112 = (local49 << 9) + local2056;
                                                local1111[local1064] = arg2.averageHeight(local2106, local2112) - arg3.averageHeight(local2106, local2112);
                                            }
                                        }
                                        if (local1452 < 8 && Static615.anIntArray719[local1435] >= 0) {
                                            if (local1076 != null) {
                                                local1076[local1064] = Static262.anIntArray326[local1435];
                                            }
                                            local1091[local1064] = Static725.anIntArray890[local1435];
                                            local1088[local1064] = Static153.anIntArray234[local1435];
                                            local1085[local1064] = Static319.anIntArray385[local1435];
                                        } else {
                                            if (local85 && Static499.aBooleanArrayArray7[local94][local1452]) {
                                                local1088[local1064] = local1115;
                                                local1091[local1064] = local1117;
                                                local1085[local1064] = local1113;
                                            } else if (local1501 == 0 && local2056 == 0) {
                                                local1085[local1064] = arg1[local33][local49];
                                                local1088[local1064] = local1750.texture;
                                                local1091[local1064] = local1750.size;
                                            } else if (local1501 == 0 && local2056 == 512) {
                                                local1085[local1064] = arg1[local33][local67];
                                                local1088[local1064] = local1758.texture;
                                                local1091[local1064] = local1758.size;
                                            } else if (local1501 == 512 && local2056 == 512) {
                                                local1085[local1064] = arg1[local47][local67];
                                                local1088[local1064] = local1766.texture;
                                                local1091[local1064] = local1766.size;
                                            } else if (local1501 == 512 && local2056 == 0) {
                                                local1085[local1064] = arg1[local47][local49];
                                                local1088[local1064] = local1774.texture;
                                                local1091[local1064] = local1774.size;
                                            } else {
                                                if (local1501 >= 256) {
                                                    if (local2056 < 256) {
                                                        local1088[local1064] = local1774.texture;
                                                        local1091[local1064] = local1774.size;
                                                    } else {
                                                        local1088[local1064] = local1766.texture;
                                                        local1091[local1064] = local1766.size;
                                                    }
                                                } else if (local2056 < 256) {
                                                    local1088[local1064] = local1750.texture;
                                                    local1091[local1064] = local1750.size;
                                                } else {
                                                    local1088[local1064] = local1758.texture;
                                                    local1091[local1064] = local1758.size;
                                                }
                                                local2106 = Static273.method3966(arg1[local47][local49], local1501 << 7 >> 9, arg1[local33][local49]);
                                                local2112 = Static273.method3966(arg1[local47][local67], local1501 << 7 >> 9, arg1[local33][local67]);
                                                local1085[local1064] = Static273.method3966(local2112, local2056 << 7 >> 9, local2106);
                                            }
                                            if (local1076 != null) {
                                                local1076[local1064] = local1085[local1064];
                                            }
                                        }
                                        local1064++;
                                    }
                                }
                                if (local94 != 0 && local177.allowShadow) {
                                    local83 = true;
                                }
                            }
                            local1162 = arg3.getHeight(local33, local49);
                            local1164 = arg3.getHeight(local47, local49);
                            local1411 = arg3.getHeight(local47, local67);
                            local1416 = arg3.getHeight(local33, local67);
                            @Pc(2560) boolean local2560 = Static441.isBridgeAt(local49, local33);
                            if (local2560 && arg5 > 1 || !local2560 && arg5 > 0) {
                                @Pc(2579) boolean local2579 = true;
                                if (local177 != null && !local177.occludes) {
                                    local2579 = false;
                                } else if (local116 == 0 && local94 != 0) {
                                    local2579 = false;
                                } else if (local108 > 0 && local187 != null && !local187.occludes) {
                                    local2579 = false;
                                }
                                if (local2579 && local1164 == local1162 && local1411 == local1162 && local1162 == local1416) {
                                    this.occluderFlags[arg5][local33][local49] = (byte) (this.occluderFlags[arg5][local33][local49] | 0x4);
                                }
                            }
                            local1430 = 0;
                            local1452 = 0;
                            local1435 = 0;
                            if (this.underwater) {
                                local1430 = Static100.method1987(local33, local49);
                                local1452 = Static350.method5124(local33, local49);
                                local1435 = Static339.method5005(local33, local49);
                            }
                            arg3.U(local33, local49, local1079, local1099, local1082, local1111, local1085, local1076, local1088, local1091, local1430, local1452, local1435, local83);
                            Static527.method7084(arg5, local33, local49);
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
