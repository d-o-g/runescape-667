package com.jagex;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!om")
public final class PrivateChatMode {

    @OriginalMember(owner = "client!wn", name = "l", descriptor = "Lclient!om;")
    public static final PrivateChatMode ON = new PrivateChatMode(0);

    @OriginalMember(owner = "client!ef", name = "f", descriptor = "Lclient!om;")
    public static final PrivateChatMode FRIENDS = new PrivateChatMode(1);

    @OriginalMember(owner = "client!jh", name = "e", descriptor = "Lclient!om;")
    public static final PrivateChatMode OFF = new PrivateChatMode(2);

    @OriginalMember(owner = "client!fr", name = "a", descriptor = "(IB)Lclient!om;")
    public static PrivateChatMode fromId(@OriginalArg(0) int id) {
        @Pc(6) PrivateChatMode[] values = values();
        for (@Pc(8) int i = 0; i < values.length; i++) {
            @Pc(19) PrivateChatMode value = values[i];
            if (id == value.id) {
                return value;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!mk", name = "a", descriptor = "(Z)[Lclient!om;")
    public static PrivateChatMode[] values() {
        return new PrivateChatMode[]{
            ON,
            FRIENDS,
            OFF,
        };
    }

    @OriginalMember(owner = "client!om", name = "g", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!om", name = "<init>", descriptor = "(I)V")
    public PrivateChatMode(@OriginalArg(0) int id) {
        this.id = id;
    }

    @OriginalMember(owner = "client!om", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
