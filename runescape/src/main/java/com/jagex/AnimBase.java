package com.jagex;

import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qda")
public final class AnimBase extends Node {

    @OriginalMember(owner = "client!qda", name = "w", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!qda", name = "r", descriptor = "I")
    public final int anInt7690;

    @OriginalMember(owner = "client!qda", name = "k", descriptor = "[I")
    public final int[] anIntArray618;

    @OriginalMember(owner = "client!qda", name = "y", descriptor = "[Z")
    public final boolean[] aBooleanArray25;

    @OriginalMember(owner = "client!qda", name = "u", descriptor = "[[I")
    public final int[][] anIntArrayArray196;

    @OriginalMember(owner = "client!qda", name = "v", descriptor = "[I")
    public final int[] anIntArray619;

    @OriginalMember(owner = "client!qda", name = "<init>", descriptor = "(I[B)V")
    public AnimBase(@OriginalArg(0) int arg0, @OriginalArg(1) byte[] arg1) {
        this.id = arg0;
        @Pc(9) Packet local9 = new Packet(arg1);
        this.anInt7690 = local9.g1();
        this.anIntArray618 = new int[this.anInt7690];
        this.aBooleanArray25 = new boolean[this.anInt7690];
        this.anIntArrayArray196 = new int[this.anInt7690][];
        this.anIntArray619 = new int[this.anInt7690];
        for (@Pc(36) int local36 = 0; local36 < this.anInt7690; local36++) {
            this.anIntArray619[local36] = local9.g1();
            if (this.anIntArray619[local36] == 6) {
                this.anIntArray619[local36] = 2;
            }
        }
        for (@Pc(68) int local68 = 0; local68 < this.anInt7690; local68++) {
            this.aBooleanArray25[local68] = local9.g1() == 1;
        }
        for (@Pc(89) int local89 = 0; local89 < this.anInt7690; local89++) {
            this.anIntArray618[local89] = local9.g2();
        }
        for (@Pc(108) int local108 = 0; local108 < this.anInt7690; local108++) {
            this.anIntArrayArray196[local108] = new int[local9.g1()];
        }
        for (@Pc(128) int local128 = 0; local128 < this.anInt7690; local128++) {
            for (@Pc(131) int local131 = 0; local131 < this.anIntArrayArray196[local128].length; local131++) {
                this.anIntArrayArray196[local128][local131] = local9.g1();
            }
        }
    }
}
