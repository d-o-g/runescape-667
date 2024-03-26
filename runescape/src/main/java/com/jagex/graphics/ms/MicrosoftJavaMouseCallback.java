package com.jagex.graphics.ms;

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

    /**
     * @see <a href="https://learn.microsoft.com/en-us/windows/win32/menurc/about-cursors">About Cursors</a>
     */
    private static final int CURSOR_NORMAL_SELECT = 32512;

    /**
     * @see <a href="https://learn.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-getwindowlonga">GetWindowLongA function</a>
     */
    public static final int GWL_WNDPROC = -4;

    @OriginalMember(owner = "client!ow", name = "e", descriptor = "I")
    public volatile int nIndex;

    @OriginalMember(owner = "client!ow", name = "d", descriptor = "I")
    public volatile int windowHandle;

    @OriginalMember(owner = "client!ow", name = "a", descriptor = "I")
    public int windowLong;

    @OriginalMember(owner = "client!ow", name = "b", descriptor = "Z")
    public boolean loaded;

    @OriginalMember(owner = "client!ow", name = "c", descriptor = "Z")
    public volatile boolean delete = true;

    @OriginalMember(owner = "client!ow", name = "callback", descriptor = "(IIII)I")
    public synchronized int callback(@OriginalArg(0) int windowHandle, @OriginalArg(1) int message, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        if (this.windowHandle != windowHandle) {
            @Pc(7) int local7 = User32.GetWindowLong(windowHandle, GWL_WNDPROC);
            return User32.CallWindowProc(local7, windowHandle, message, arg2, arg3);
        }

        if (message == 32) {
            @Pc(7) int local7 = arg3 & 0xFFFF;
            if (local7 == 1) {
                User32.SetCursor(this.delete ? this.windowLong : 0);
                return 0;
            }
        }
        if (message == 101024) {
            User32.SetCursor(this.delete ? this.windowLong : 0);
            return 0;
        }
        if (message == 1) {
            this.windowHandle = 0;
            this.delete = true;
        }
        return User32.CallWindowProc(this.nIndex, windowHandle, message, arg2, arg3);
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
            @Pc(6) int windowHandle = peer.getTopHwnd();

            if (windowHandle == this.windowHandle && delete == this.delete) {
                return;
            }

            if (!this.loaded) {
                this.windowLong = User32.LoadCursor(0, CURSOR_NORMAL_SELECT);
                Root.alloc(this);
                this.loaded = true;
            }

            if (this.windowHandle != windowHandle) {
                if (this.windowHandle != 0) {
                    this.delete = true;
                    User32.SendMessage(windowHandle, 101024, 0, 0);

                    synchronized (this) {
                        User32.SetWindowLong(this.windowHandle, GWL_WNDPROC, this.nIndex);
                    }
                }

                synchronized (this) {
                    this.windowHandle = windowHandle;
                    this.nIndex = User32.SetWindowLong(this.windowHandle, GWL_WNDPROC, this);
                }
            }

            this.delete = delete;
            User32.SendMessage(windowHandle, 101024, 0, 0);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }
}
