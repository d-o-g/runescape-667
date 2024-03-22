package com.jagex.core.constants;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hh")
public final class ModeWhat {

    @OriginalMember(owner = "client!qi", name = "l", descriptor = "Lclient!hh;")
    public static final ModeWhat LIVE = new ModeWhat("LIVE", 0);

    @OriginalMember(owner = "client!qfa", name = "m", descriptor = "Lclient!hh;")
    public static final ModeWhat RC = new ModeWhat("RC", 1);

    @OriginalMember(owner = "client!gw", name = "b", descriptor = "Lclient!hh;")
    public static final ModeWhat WIP = new ModeWhat("WIP", 2);

    @OriginalMember(owner = "client!hh", name = "d", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!uu", name = "a", descriptor = "(I)[Lclient!hh;")
    public static ModeWhat[] values() {
        return new ModeWhat[]{
            LIVE,
            RC,
            WIP
        };
    }

    @OriginalMember(owner = "client!tn", name = "a", descriptor = "(II)Lclient!hh;")
    public static ModeWhat fromId(@OriginalArg(1) int id) {
        @Pc(15) ModeWhat[] values = values();

        for (@Pc(17) int i = 0; i < values.length; i++) {
            @Pc(23) ModeWhat value = values[i];

            if (value.id == id) {
                return value;
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!hh", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public ModeWhat(@OriginalArg(0) String name, @OriginalArg(1) int id) {
        this.id = id;
    }

    @OriginalMember(owner = "client!hh", name = "a", descriptor = "(Z)I")
    public int getId() {
        return this.id;
    }

    @OriginalMember(owner = "client!hh", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
