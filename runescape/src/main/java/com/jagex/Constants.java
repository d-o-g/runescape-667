package com.jagex;

import org.openrs2.deob.annotation.OriginalMember;

import java.applet.Applet;

public final class Constants {
    @OriginalMember(owner = "client!tw", name = "w", descriptor = "Ljava/applet/Applet;")
    public static Applet sourceApplet;
    @OriginalMember(owner = "client!lo", name = "e", descriptor = "I")
    public static int clientBuild;
    @OriginalMember(owner = "client!qda", name = "q", descriptor = "Ljava/lang/String;")
    public static String playerDisplayName;
    @OriginalMember(owner = "client!jea", name = "t", descriptor = "J")
    public static long playerDisplayNameEncoded;
}
