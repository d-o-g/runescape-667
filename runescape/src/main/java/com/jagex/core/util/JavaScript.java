package com.jagex.core.util;

import netscape.javascript.JSObject;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

import java.applet.Applet;

public final class JavaScript {

    @OriginalMember(owner = "client!ac", name = "a", descriptor = "(BLjava/applet/Applet;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;")
    public static Object call(@OriginalArg(1) Applet applet, @OriginalArg(2) String arg1, @OriginalArg(3) Object[] arg2) throws Throwable {
        return JSObject.getWindow(applet).call(arg1, arg2);
    }

    @OriginalMember(owner = "client!ac", name = "a", descriptor = "(Ljava/lang/String;Ljava/applet/Applet;B)Ljava/lang/Object;")
    public static Object call(@OriginalArg(0) String arg0, @OriginalArg(1) Applet applet) throws Throwable {
        return JSObject.getWindow(applet).call(arg0, (Object[]) null);
    }

    @OriginalMember(owner = "client!ac", name = "a", descriptor = "(Ljava/lang/String;Ljava/applet/Applet;I)V")
    public static void eval(@OriginalArg(0) String string, @OriginalArg(1) Applet applet) throws Throwable {
        JSObject.getWindow(applet).eval(string);
    }

    private JavaScript() {
        /* empty */
    }
}
