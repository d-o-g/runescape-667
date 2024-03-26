package com.jagex.game.news;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!rj")
public final class NewsItem {

    @OriginalMember(owner = "client!rj", name = "b", descriptor = "Ljava/lang/String;")
    public final String info;

    @OriginalMember(owner = "client!rj", name = "f", descriptor = "Ljava/lang/String;")
    public final String description;

    @OriginalMember(owner = "client!rj", name = "g", descriptor = "Ljava/lang/String;")
    public final String title;

    @OriginalMember(owner = "client!rj", name = "<init>", descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V")
    public NewsItem(@OriginalArg(0) String title, @OriginalArg(1) String info, @OriginalArg(2) String description) {
        this.info = info;
        this.description = description;
        this.title = title;
    }
}
