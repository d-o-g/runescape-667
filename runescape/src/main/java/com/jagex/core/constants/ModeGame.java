package com.jagex.core.constants;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ul")
public final class ModeGame {

    @OriginalMember(owner = "client!vf", name = "J", descriptor = "Lclient!ul;")
    public static final ModeGame RUNESCAPE = new ModeGame("runescape", "RuneScape", 0);

    @OriginalMember(owner = "client!wu", name = "E", descriptor = "Lclient!ul;")
    public static final ModeGame STELLAR_DAWN = new ModeGame("stellardawn", "Stellar Dawn", 1);

    @OriginalMember(owner = "client!ola", name = "H", descriptor = "Lclient!ul;")
    public static final ModeGame GAME3 = new ModeGame("game3", "Game 3", 2);

    @OriginalMember(owner = "client!un", name = "u", descriptor = "Lclient!ul;")
    public static final ModeGame GAME4 = new ModeGame("game4", "Game 4", 3);

    public static final ModeGame GAME5 = new ModeGame("game5", "Game 5", 4);

    @OriginalMember(owner = "client!ul", name = "d", descriptor = "Ljava/lang/String;")
    public final String domainName;

    @OriginalMember(owner = "client!ul", name = "a", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!ul", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;I)V")
    public ModeGame(@OriginalArg(0) String domainName, @OriginalArg(1) String title, @OriginalArg(2) int id) {
        this.domainName = domainName;
        this.id = id;
    }

    @OriginalMember(owner = "client!ul", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
