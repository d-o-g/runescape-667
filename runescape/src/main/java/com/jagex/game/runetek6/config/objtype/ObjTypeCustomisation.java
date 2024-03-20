package com.jagex.game.runetek6.config.objtype;

import com.jagex.core.io.Packet;
import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bs")
public final class ObjTypeCustomisation {

    @OriginalMember(owner = "client!so", name = "a", descriptor = "(Lclient!ge;Lclient!vfa;I)Lclient!bs;")
    public static ObjTypeCustomisation decode(@OriginalArg(0) Packet packet, @OriginalArg(1) ObjType obj) {
        @Pc(10) ObjTypeCustomisation customisation = new ObjTypeCustomisation(obj);

        @Pc(14) int flags = packet.g1();
        @Pc(23) boolean wear = (flags & 0x1) != 0;
        @Pc(35) boolean head = (flags & 0x2) != 0;
        @Pc(47) boolean recol = (flags & 0x4) != 0;
        @Pc(57) boolean retex = (flags & 0x8) != 0;

        if (wear) {
            customisation.manwear[0] = packet.gSmart2or4null();
            customisation.womanwear[0] = packet.gSmart2or4null();

            if (obj.manwear2 != -1 || obj.womanwear2 != -1) {
                customisation.manwear[1] = packet.gSmart2or4null();
                customisation.womanwear[1] = packet.gSmart2or4null();
            }

            if (obj.manwear3 != -1 || obj.womanwear3 != -1) {
                customisation.manwear[2] = packet.gSmart2or4null();
                customisation.womanwear[2] = packet.gSmart2or4null();
            }
        }

        if (head) {
            customisation.manhead[0] = packet.gSmart2or4null();
            customisation.womanhead[0] = packet.gSmart2or4null();

            if (obj.manhead2 != -1 || obj.womanhead2 != -1) {
                customisation.manhead[1] = packet.gSmart2or4null();
                customisation.womanhead[1] = packet.gSmart2or4null();
            }
        }

        if (recol) {
            @Pc(178) int packed = packet.g2();

            @Pc(181) int[] unpacked = {
                (packed & 0xF),
                (packed >> 4) & 0xF,
                (packed >> 8) & 0xF,
                (packed >> 12) & 0xF
            };

            for (@Pc(213) int i = 0; i < unpacked.length; i++) {
                if (unpacked[i] != 15) {
                    customisation.recol_d[unpacked[i]] = (short) packet.g2();
                }
            }
        }

        if (retex) {
            @Pc(178) int packed = packet.g1();

            @Pc(181) int[] unpacked = {
                (packed & 0xF),
                (packed >> 4) & 0xF
            };

            for (@Pc(213) int i = 0; i < unpacked.length; i++) {
                if (unpacked[i] != 15) {
                    customisation.retex_d[unpacked[i]] = (short) packet.g2();
                }
            }
        }

        return customisation;
    }

    @OriginalMember(owner = "client!bs", name = "h", descriptor = "[I")
    public final int[] womanhead = new int[2];

    @OriginalMember(owner = "client!bs", name = "b", descriptor = "[I")
    public final int[] manhead = new int[2];

    @OriginalMember(owner = "client!bs", name = "c", descriptor = "[I")
    public final int[] manwear = new int[3];

    @OriginalMember(owner = "client!bs", name = "f", descriptor = "[I")
    public final int[] womanwear = new int[3];

    @OriginalMember(owner = "client!bs", name = "d", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!bs", name = "g", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!bs", name = "<init>", descriptor = "(Lclient!vfa;)V")
    public ObjTypeCustomisation(@OriginalArg(0) ObjType type) {
        this.manwear[0] = type.manwear;
        this.manwear[1] = type.manwear2;
        this.manwear[2] = type.manwear3;
        this.womanwear[0] = type.womanwear;
        this.womanwear[1] = type.womanwear2;
        this.womanwear[2] = type.womanwear3;
        this.manhead[0] = type.manhead;
        this.manhead[1] = type.manhead2;
        this.womanhead[0] = type.womanhead;
        this.womanhead[1] = type.womanhead2;
        if (type.recol_d != null) {
            this.recol_d = new short[type.recol_d.length];
            Arrays.copy(type.recol_d, 0, this.recol_d, 0, this.recol_d.length);
        }
        if (type.retex_d != null) {
            this.retex_d = new short[type.retex_d.length];
            Arrays.copy(type.retex_d, 0, this.retex_d, 0, this.retex_d.length);
        }
    }
}
