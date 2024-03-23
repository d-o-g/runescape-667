package com.jagex.game.runetek6.config.flotype;

import com.jagex.core.io.Packet;
import com.jagex.math.ColourUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!re")
public final class FloorOverlayType {

    @OriginalMember(owner = "client!se", name = "a", descriptor = "(II)I")
    private static int colour(@OriginalArg(0) int colour) {
        return colour == 0xFF00FF ? 0xFFFFFFFF : ColourUtils.rgbToHsl(colour);
    }

    @OriginalMember(owner = "client!re", name = "e", descriptor = "Lclient!ef;")
    public FloorOverlayTypeList myList;

    @OriginalMember(owner = "client!re", name = "h", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!re", name = "s", descriptor = "I")
    public int colour = 0;

    @OriginalMember(owner = "client!re", name = "j", descriptor = "I")
    public int size = 512;

    @OriginalMember(owner = "client!re", name = "b", descriptor = "Z")
    public boolean occludes = true;

    @OriginalMember(owner = "client!re", name = "c", descriptor = "I")
    public int blendColour = -1;

    @OriginalMember(owner = "client!re", name = "i", descriptor = "I")
    public int waterDepth = 64;

    @OriginalMember(owner = "client!re", name = "f", descriptor = "Z")
    public boolean blockShadow = true;

    @OriginalMember(owner = "client!re", name = "p", descriptor = "I")
    public int blendPriority = 8;

    @OriginalMember(owner = "client!re", name = "m", descriptor = "I")
    public int waterBias = 127;

    @OriginalMember(owner = "client!re", name = "g", descriptor = "I")
    public int texture = -1;

    @OriginalMember(owner = "client!re", name = "a", descriptor = "Z")
    public boolean blendable = false;

    @OriginalMember(owner = "client!re", name = "q", descriptor = "I")
    public int waterColour = 1190717;

    @OriginalMember(owner = "client!re", name = "a", descriptor = "(I)V")
    public void postDecode() {
        this.blendPriority = (this.blendPriority << 8) | this.id;
    }

    @OriginalMember(owner = "client!re", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(7) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(packet, code);
        }
    }

    @OriginalMember(owner = "client!re", name = "a", descriptor = "(BLclient!ge;I)V")
    public void decode(@OriginalArg(1) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.colour = colour(packet.g3());
        } else if (code == 2) {
            this.texture = packet.g1();
        } else if (code == 3) {
            this.texture = packet.g2();
            if (this.texture == 65535) {
                this.texture = -1;
            }
        } else if (code == 5) {
            this.occludes = false;
        } else if (code == 7) {
            this.blendColour = colour(packet.g3());
        } else if (code == 8) {
            this.myList.dflt = this.id;
        } else if (code == 9) {
            this.size = packet.g2() << 2;
        } else if (code == 10) {
            this.blockShadow = false;
        } else if (code == 11) {
            this.blendPriority = packet.g1();
        } else if (code == 12) {
            this.blendable = true;
        } else if (code == 13) {
            this.waterColour = packet.g3();
        } else if (code == 14) {
            this.waterDepth = packet.g1() << 2;
        } else if (code == 16) {
            this.waterBias = packet.g1();
        }
    }
}
