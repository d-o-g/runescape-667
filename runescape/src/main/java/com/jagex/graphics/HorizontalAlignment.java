package com.jagex.graphics;

import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wk")
public final class HorizontalAlignment {

    @OriginalMember(owner = "client!ria", name = "e", descriptor = "Lclient!wk;")
    public static final HorizontalAlignment LEFT = new HorizontalAlignment();

    @OriginalMember(owner = "client!wha", name = "h", descriptor = "Lclient!wk;")
    public static final HorizontalAlignment CENTER = new HorizontalAlignment();

    @OriginalMember(owner = "client!fe", name = "f", descriptor = "Lclient!wk;")
    public static final HorizontalAlignment RIGHT = new HorizontalAlignment();

    @OriginalMember(owner = "client!bc", name = "a", descriptor = "(I)[Lclient!wk;")
    public static HorizontalAlignment[] values() {
        return new HorizontalAlignment[]{
            LEFT,
            CENTER,
            RIGHT,
        };
    }

    @OriginalMember(owner = "client!wk", name = "a", descriptor = "(III)I")
    public int align(@OriginalArg(1) int x, @OriginalArg(2) int width) {
        @Pc(15) int maxWidth = GameShell.canvasWid > x ? GameShell.canvasWid : x;
        if (LEFT == this) {
            return 0;
        } else if (RIGHT == this) {
            return maxWidth - width;
        } else if (CENTER == this) {
            return (maxWidth - width) / 2;
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!wk", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
