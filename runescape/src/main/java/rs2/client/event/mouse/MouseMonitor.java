package rs2.client.event.mouse;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Component;
import java.lang.reflect.Constructor;

@OriginalClass("client!fb")
public abstract class MouseMonitor {

    public static final int CLICK_TYPE_NONE = 0x0;
    public static final int CLICK_TYPE_LEFT = 0x1;
    public static final int CLICK_TYPE_MIDDLE = 0x2;
    public static final int CLICK_TYPE_RIGHT = 0x4;

    @OriginalMember(owner = "client!fr", name = "h", descriptor = "Lclient!fb;")
    public static MouseMonitor instance;

    // $FF: synthetic field
    @OriginalMember(owner = "client!ce", name = "k", descriptor = "Ljava/lang/Class;")
    public static Class completeClass;

    @OriginalMember(owner = "client!ce", name = "a", descriptor = "(Ljava/awt/Component;IZ)Lclient!fb;")
    public static MouseMonitor create(@OriginalArg(0) Component component) {
        try {
            @Pc(34) Constructor ctor = Class.forName("rs2.client.event.mouse.CompleteMouseMonitor").getDeclaredConstructor(completeClass == null ? (completeClass = Class.forName("java.awt.Component")) : completeClass, Boolean.TYPE);
            return (MouseMonitor) ctor.newInstance(component, Boolean.valueOf(true));
        } catch (@Pc(52) Throwable ignored) {
            return new SimpleMouseMonitor(component, true);
        }
    }

    @OriginalMember(owner = "client!fb", name = "<init>", descriptor = "()V")
    protected MouseMonitor() {
    }

    @OriginalMember(owner = "client!fb", name = "e", descriptor = "(B)V")
    public abstract void record();

    @OriginalMember(owner = "client!fb", name = "c", descriptor = "(I)Z")
    public abstract boolean isLeftDown();

    @OriginalMember(owner = "client!fb", name = "b", descriptor = "(I)Z")
    public abstract boolean isRightDown();

    @OriginalMember(owner = "client!fb", name = "b", descriptor = "(B)Z")
    public final boolean isDown() {
        return this.isLeftDown() || this.isMiddleDown() || this.isRightDown();
    }

    @OriginalMember(owner = "client!fb", name = "d", descriptor = "(I)Z")
    public abstract boolean isMiddleDown();

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(I)V")
    public abstract void remove();

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(B)Lclient!bv;")
    public abstract MouseLog removeFirstLog();

    @OriginalMember(owner = "client!fb", name = "d", descriptor = "(B)I")
    public abstract int getRecordedX();

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(Z)I")
    public abstract int getRecordedY();
}
