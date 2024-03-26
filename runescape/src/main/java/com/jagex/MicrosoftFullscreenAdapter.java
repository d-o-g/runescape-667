package com.jagex;

import com.ms.awt.WComponentPeer;
import com.ms.com.IUnknown;
import com.ms.directX.DDSurfaceDesc;
import com.ms.directX.DirectDraw;
import com.ms.directX.IEnumModesCallback;
import com.ms.win32.User32;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@OriginalClass("client!ak")
public final class MicrosoftFullscreenAdapter implements IEnumModesCallback {

    @OriginalMember(owner = "client!ak", name = "b", descriptor = "[I")
    public static int[] anIntArray28;

    @OriginalMember(owner = "client!ak", name = "a", descriptor = "I")
    public static int anInt240;

    @OriginalMember(owner = "client!ak", name = "c", descriptor = "Lcom/ms/directX/DirectDraw;")
    public final DirectDraw draw = new DirectDraw();

    @OriginalMember(owner = "client!ak", name = "<init>", descriptor = "()V")
    public MicrosoftFullscreenAdapter() {
        this.draw.initialize(null);
    }

    @OriginalMember(owner = "client!ak", name = "a", descriptor = "(Ljava/awt/Frame;IIIII)V")
    public void enter(@OriginalArg(0) Frame frame, @OriginalArg(1) int bits, @OriginalArg(2) int refreshRate, @OriginalArg(3) int height, @OriginalArg(5) int width) {
        try {
            frame.setVisible(true);
            Method getPeer = Frame.class.getDeclaredMethod("getPeer");
            getPeer.setAccessible(true);
            @Pc(6) WComponentPeer local6 = (WComponentPeer) getPeer.invoke(frame);

            @Pc(9) int windowHandle = local6.getHwnd();
            User32.SetWindowLong(windowHandle, -16, Integer.MIN_VALUE);
            User32.SetWindowLong(windowHandle, -20, 8);

            this.draw.setCooperativeLevel(frame, 17);
            this.draw.setDisplayMode(width, height, bits, refreshRate, 0);

            frame.setBounds(0, 0, width, height);
            frame.toFront();
            frame.requestFocus();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    @OriginalMember(owner = "client!ak", name = "a", descriptor = "(Ljava/awt/Frame;I)V")
    public void exit(@OriginalArg(0) Frame frame) {
        this.draw.restoreDisplayMode();
        this.draw.setCooperativeLevel(frame, 8);
    }

    @OriginalMember(owner = "client!ak", name = "a", descriptor = "(I)[I")
    public int[] listmodes() {
        this.draw.enumDisplayModes(0, null, null, this);
        anIntArray28 = new int[anInt240];
        anInt240 = 0;
        this.draw.enumDisplayModes(0, null, null, this);
        @Pc(20) int[] local20 = anIntArray28;
        anIntArray28 = null;
        anInt240 = 0;
        return local20;
    }

    @OriginalMember(owner = "client!ak", name = "callbackEnumModes", descriptor = "(Lcom/ms/directX/DDSurfaceDesc;Lcom/ms/com/IUnknown;)V")
    public void callbackEnumModes(@OriginalArg(0) DDSurfaceDesc arg0, @OriginalArg(1) IUnknown arg1) {
        if (anIntArray28 == null) {
            anInt240 += 4;
        } else {
            anIntArray28[anInt240++] = arg0.width;
            anIntArray28[anInt240++] = arg0.height;
            anIntArray28[anInt240++] = arg0.rgbBitCount;
            anIntArray28[anInt240++] = arg0.refreshRate;
        }
    }
}
