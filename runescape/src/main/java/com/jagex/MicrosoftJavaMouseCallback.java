package com.jagex;

import com.ms.awt.WComponentPeer;
import com.ms.dll.Callback;
import com.ms.dll.Root;
import com.ms.win32.User32;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@OriginalClass("client!ow")
public final class MicrosoftJavaMouseCallback extends Callback {

    @OriginalMember(owner = "client!ow", name = "e", descriptor = "I")
    public volatile int anInt7154;

    @OriginalMember(owner = "client!ow", name = "d", descriptor = "I")
    public volatile int anInt7155;

    @OriginalMember(owner = "client!ow", name = "a", descriptor = "I")
    public int anInt7156;

    @OriginalMember(owner = "client!ow", name = "b", descriptor = "Z")
    public boolean aBoolean541;

    @OriginalMember(owner = "client!ow", name = "c", descriptor = "Z")
    public volatile boolean aBoolean540 = true;

    @OriginalMember(owner = "client!ow", name = "callback", descriptor = "(IIII)I")
    public synchronized int callback(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        @Pc(7) int local7;
        if (this.anInt7155 != arg0) {
            local7 = User32.GetWindowLong(arg0, -4);
            return User32.CallWindowProc(local7, arg0, arg1, arg2, arg3);
        }
        if (arg1 == 32) {
            local7 = arg3 & 0xFFFF;
            if (local7 == 1) {
                User32.SetCursor(this.aBoolean540 ? this.anInt7156 : 0);
                return 0;
            }
        }
        if (arg1 == 101024) {
            User32.SetCursor(this.aBoolean540 ? this.anInt7156 : 0);
            return 0;
        }
        if (arg1 == 1) {
            this.anInt7155 = 0;
            this.aBoolean540 = true;
        }
        return User32.CallWindowProc(this.anInt7154, arg0, arg1, arg2, arg3);
    }

    @OriginalMember(owner = "client!ow", name = "a", descriptor = "(III)V")
    public void movemouse(@OriginalArg(0) int x, @OriginalArg(2) int y) {
        User32.SetCursorPos(x, y);
    }

    @OriginalMember(owner = "client!ow", name = "a", descriptor = "(ZLjava/awt/Component;B)V")
    public void showcursor(@OriginalArg(0) boolean delete, @OriginalArg(1) Component component) {
        try {
            Method getPeer = Component.class.getDeclaredMethod("getPeer");
            getPeer.setAccessible(true);
            @Pc(3) WComponentPeer peer = (WComponentPeer) getPeer.invoke(component);
            @Pc(6) int wnd = peer.getTopHwnd();

            if (wnd == this.anInt7155 && delete == this.aBoolean540) {
                return;
            }

            if (!this.aBoolean541) {
                this.anInt7156 = User32.LoadCursor(0, 32512);
                Root.alloc(this);
                this.aBoolean541 = true;
            }

            if (this.anInt7155 != wnd) {
                if (this.anInt7155 != 0) {
                    this.aBoolean540 = true;
                    User32.SendMessage(wnd, 101024, 0, 0);

                    synchronized (this) {
                        User32.SetWindowLong(this.anInt7155, -4, this.anInt7154);
                    }
                }

                synchronized (this) {
                    this.anInt7155 = wnd;
                    this.anInt7154 = User32.SetWindowLong(this.anInt7155, -4, this);
                }
            }

            this.aBoolean540 = delete;
            User32.SendMessage(wnd, 101024, 0, 0);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }
}
