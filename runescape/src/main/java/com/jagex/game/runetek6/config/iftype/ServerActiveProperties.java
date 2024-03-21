package com.jagex.game.runetek6.config.iftype;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ofa")
public final class ServerActiveProperties extends Node {

    @OriginalMember(owner = "client!cu", name = "T", descriptor = "Lclient!ofa;")
    public static final ServerActiveProperties DEFAULT = new ServerActiveProperties(0, -1);

    /**
     * 0x01 = TGT_OBJ
     * 0x02 = TGT_NPC
     * 0x04 = TGT_LOC
     * 0x08 = TGT_PLAYER
     * 0x10 = TGT_SELF
     * 0x20 = TGT_BUTTON
     * 0x40 = TGT_GROUND
     */
    @OriginalMember(owner = "client!tla", name = "a", descriptor = "(II)I")
    public static int targetMaskFrom(@OriginalArg(0) int events) {
        return (events >> 11) & 0x7F;
    }

    @OriginalMember(owner = "client!ofa", name = "r", descriptor = "I")
    public final int targetParam;

    @OriginalMember(owner = "client!ofa", name = "q", descriptor = "I")
    public final int events;

    @OriginalMember(owner = "client!ofa", name = "<init>", descriptor = "(II)V")
    public ServerActiveProperties(@OriginalArg(0) int events, @OriginalArg(1) int targetParam) {
        this.targetParam = targetParam;
        this.events = events;
    }

    @OriginalMember(owner = "client!ofa", name = "b", descriptor = "(I)I")
    public int getTargetMask() {
        return targetMaskFrom(this.events);
    }

    @OriginalMember(owner = "client!ofa", name = "b", descriptor = "(B)Z")
    public boolean isUseTarget() {
        return (this.events >> 22 & 0x1) != 0;
    }

    @OriginalMember(owner = "client!ofa", name = "g", descriptor = "(I)I")
    public int getDragDepth() {
        return this.events >> 18 & 0x7;
    }

    @OriginalMember(owner = "client!ofa", name = "d", descriptor = "(I)Z")
    public boolean isPauseButton() {
        return (this.events & 0x1) != 0;
    }

    @OriginalMember(owner = "client!ofa", name = "a", descriptor = "(I)Z")
    public boolean isDragTarget() {
        return (this.events >> 21 & 0x1) != 0;
    }

    @OriginalMember(owner = "client!ofa", name = "a", descriptor = "(BI)Z")
    public boolean isOpEnabled(@OriginalArg(1) int op) {
        return ((this.events >> (op + 1)) & 0x1) != 0;
    }
}
