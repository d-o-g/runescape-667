package com.jagex;

import com.jagex.collect.Deque;
import com.jagex.collect.DoublyLinkedNode;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rw")
public final class AnimFrameset extends DoublyLinkedNode {

    @OriginalMember(owner = "client!rw", name = "t", descriptor = "[Lclient!nb;")
    public AnimFrame[] frames;

    @OriginalMember(owner = "client!rw", name = "E", descriptor = "[[B")
    public byte[][] aByteArrayArray32;

    @OriginalMember(owner = "client!rw", name = "x", descriptor = "I")
    public final int anInt8535;

    @OriginalMember(owner = "client!rw", name = "<init>", descriptor = "(I)V")
    public AnimFrameset(@OriginalArg(0) int arg0) {
        this.anInt8535 = arg0;
    }

    @OriginalMember(owner = "client!rw", name = "a", descriptor = "(I)Z")
    public boolean method7565() {
        if (this.frames != null) {
            return true;
        }
        @Pc(36) int[] local36;
        @Pc(43) int local43;
        if (this.aByteArrayArray32 == null) {
            @Pc(14) js5 local14 = js5.aJs5_96;
            synchronized (js5.aJs5_96) {
                if (!js5.aJs5_96.method7607(this.anInt8535)) {
                    return false;
                }
                local36 = js5.aJs5_96.method7603(this.anInt8535);
                this.aByteArrayArray32 = new byte[local36.length][];
                for (local43 = 0; local43 < local36.length; local43++) {
                    this.aByteArrayArray32[local43] = js5.aJs5_96.getfile(local36[local43], this.anInt8535);
                }
            }
        }
        @Pc(69) boolean local69 = true;
        for (@Pc(71) int local71 = 0; local71 < this.aByteArrayArray32.length; local71++) {
            @Pc(77) byte[] local77 = this.aByteArrayArray32[local71];
            @Pc(82) Packet local82 = new Packet(local77);
            local82.pos = 1;
            local43 = local82.g2();
            @Pc(91) js5 local91 = js5.aJs5_58;
            synchronized (js5.aJs5_58) {
                local69 &= js5.aJs5_58.method7581(local43);
            }
        }
        if (!local69) {
            return false;
        }
        @Pc(123) Deque local123 = new Deque();
        @Pc(125) js5 local125 = js5.aJs5_96;
        synchronized (js5.aJs5_96) {
            @Pc(133) int local133 = js5.aJs5_96.fileLimit(this.anInt8535);
            this.frames = new AnimFrame[local133];
            local36 = js5.aJs5_96.method7603(this.anInt8535);
        }
        for (local43 = 0; local43 < local36.length; local43++) {
            @Pc(167) byte[] local167 = this.aByteArrayArray32[local43];
            @Pc(172) Packet local172 = new Packet(local167);
            local172.pos = 1;
            @Pc(179) int local179 = local172.g2();
            @Pc(181) AnimBase local181 = null;
            for (@Pc(188) AnimBase local188 = (AnimBase) local123.first(); local188 != null; local188 = (AnimBase) local123.next()) {
                if (local188.anInt7692 == local179) {
                    local181 = local188;
                    break;
                }
            }
            if (local181 == null) {
                @Pc(209) js5 local209 = js5.aJs5_58;
                synchronized (js5.aJs5_58) {
                    local181 = new AnimBase(local179, js5.aJs5_58.getfile(local179));
                }
                local123.addLast(local181);
            }
            this.frames[local36[local43]] = new AnimFrame(local167, local181);
        }
        this.aByteArrayArray32 = null;
        return true;
    }

    @OriginalMember(owner = "client!rw", name = "a", descriptor = "(BI)Z")
    public boolean method7568(@OriginalArg(1) int arg0) {
        return this.frames[arg0].aBoolean470;
    }

    @OriginalMember(owner = "client!rw", name = "c", descriptor = "(II)Z")
    public boolean method7569(@OriginalArg(1) int arg0) {
        return this.frames[arg0].aBoolean471;
    }

    @OriginalMember(owner = "client!rw", name = "b", descriptor = "(II)Z")
    public boolean method7570(@OriginalArg(0) int arg0) {
        return this.frames[arg0].aBoolean469;
    }
}
