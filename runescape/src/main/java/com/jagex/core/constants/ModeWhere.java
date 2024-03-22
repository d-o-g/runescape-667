package com.jagex.core.constants;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tka")
public final class ModeWhere {

    @OriginalMember(owner = "client!oaa", name = "c", descriptor = "Lclient!tka;")
    public static final ModeWhere LIVE = new ModeWhere("LIVE", "", "", 0);

    @OriginalMember(owner = "client!wea", name = "R", descriptor = "Lclient!tka;")
    public static final ModeWhere WTRC = new ModeWhere("WTRC", "office", "_rc", 1);

    @OriginalMember(owner = "client!wk", name = "g", descriptor = "Lclient!tka;")
    public static final ModeWhere WTQA = new ModeWhere("WTQA", "office", "_qa", 2);

    @OriginalMember(owner = "client!nh", name = "k", descriptor = "Lclient!tka;")
    public static final ModeWhere WIP = new ModeWhere("WTWIP", "office", "_wip", 3);

    @OriginalMember(owner = "client!aj", name = "D", descriptor = "Lclient!tka;")
    public static final ModeWhere LOCAL = new ModeWhere("LOCAL", "", "local", 4);

    @OriginalMember(owner = "client!ip", name = "z", descriptor = "Lclient!tka;")
    public static final ModeWhere WTI = new ModeWhere("WTI", "office", "_wti", 5);

    @OriginalMember(owner = "client!vka", name = "b", descriptor = "Lclient!tka;")
    public static final ModeWhere INTBETA = new ModeWhere("INTBETA", "office", "_intbeta", 6);

    @OriginalMember(owner = "client!jaa", name = "a", descriptor = "(I)[Lclient!tka;")
    public static ModeWhere[] values() {
        return new ModeWhere[]{
            LIVE,
            WTRC,
            WTQA,
            WIP,
            LOCAL,
            WTI,
            INTBETA
        };
    }

    @OriginalMember(owner = "client!oka", name = "a", descriptor = "(II)Lclient!tka;")
    public static ModeWhere fromId(@OriginalArg(0) int id) {
        @Pc(8) ModeWhere[] values = values();

        for (@Pc(10) int i = 0; i < values.length; i++) {
            @Pc(16) ModeWhere value = values[i];

            if (value.id == id) {
                return value;
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!fk", name = "a", descriptor = "(ZLclient!tka;)Z")
    public static boolean isPrivate(@OriginalArg(1) ModeWhere modeWhere) {
        return modeWhere == WTRC
            || modeWhere == WTQA
            || modeWhere == WIP
            || modeWhere == WTI
            || modeWhere == INTBETA;
    }

    @OriginalMember(owner = "client!tka", name = "f", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!tka", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V")
    public ModeWhere(@OriginalArg(0) String name, @OriginalArg(1) String arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int id) {
        this.id = id;
    }

    @OriginalMember(owner = "client!tka", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
