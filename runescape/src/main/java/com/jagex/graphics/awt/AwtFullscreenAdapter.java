package com.jagex.graphics.awt;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;

@OriginalClass("client!cia")
public final class AwtFullscreenAdapter {

    @OriginalMember(owner = "client!cia", name = "b", descriptor = "Ljava/awt/DisplayMode;")
    public DisplayMode previousDisplayMode;

    @OriginalMember(owner = "client!cia", name = "a", descriptor = "Ljava/awt/GraphicsDevice;")
    public GraphicsDevice fullscreenDevice;

    @OriginalMember(owner = "client!cia", name = "<init>", descriptor = "()V")
    public AwtFullscreenAdapter() throws Exception {
        @Pc(3) GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.fullscreenDevice = env.getDefaultScreenDevice();

        if (!this.fullscreenDevice.isFullScreenSupported()) {
            @Pc(14) GraphicsDevice[] screenDevices = env.getScreenDevices();
            for (@Pc(18) int i = 0; i < screenDevices.length; i++) {
                @Pc(30) GraphicsDevice screenDevice = screenDevices[i];

                if (screenDevice != null && screenDevice.isFullScreenSupported()) {
                    this.fullscreenDevice = screenDevice;
                    return;
                }
            }

            throw new Exception();
        }
    }

    @OriginalMember(owner = "client!cia", name = "a", descriptor = "(Ljava/awt/Frame;I)V")
    private void method1562(@OriginalArg(0) Frame frame) {
        @Pc(1) boolean wasValid = false;

        try {
            @Pc(10) Field validField = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
            validField.setAccessible(true);
            @Pc(20) boolean valid = (Boolean) validField.get(this.fullscreenDevice);

            if (valid) {
                wasValid = true;
                validField.set(this.fullscreenDevice, Boolean.FALSE);
            }
        } catch (@Pc(33) Throwable ignored) {
            /* empty */
        }

        try {
            this.fullscreenDevice.setFullScreenWindow(frame);
        } finally {
            if (wasValid) {
                try {
                    @Pc(77) Field validField = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
                    validField.set(this.fullscreenDevice, Boolean.TRUE);
                } catch (@Pc(84) Throwable ignored) {
                    /* empty */
                }
            }
        }
    }

    @OriginalMember(owner = "client!cia", name = "enter", descriptor = "(Ljava/awt/Frame;IIII)V")
    public void enter(@OriginalArg(0) Frame frame, @OriginalArg(1) int width, @OriginalArg(2) int height, @OriginalArg(3) int bits, @OriginalArg(4) int refreshrate) {
        System.out.println("fullscreen.fsimp14: w=" + width + " h=" + height + " bits=" + bits + " refreshrate=" + refreshrate);

        this.previousDisplayMode = this.fullscreenDevice.getDisplayMode();
        if (this.previousDisplayMode == null) {
            throw new NullPointerException();
        }

        frame.setUndecorated(true);
        frame.enableInputMethods(false);
        this.method1562(frame);

        if (refreshrate == 0) {
            @Pc(31) int currentrate = this.previousDisplayMode.getRefreshRate();
            @Pc(35) DisplayMode[] mode = this.fullscreenDevice.getDisplayModes();
            @Pc(37) boolean foundBetter = false;

            for (@Pc(39) int i = 0; i < mode.length; i++) {
                if (width == mode[i].getWidth() && mode[i].getHeight() == height && mode[i].getBitDepth() == bits) {
                    @Pc(76) int potentialRefreshRate = mode[i].getRefreshRate();

                    if (!foundBetter || Math.abs(potentialRefreshRate - currentrate) < Math.abs(refreshrate - currentrate)) {
                        refreshrate = potentialRefreshRate;
                        foundBetter = true;
                    }
                }
            }

            if (foundBetter) {
                System.out.println("fullscreen.fsimp14: using refreshrate=" + refreshrate + " - closest found to currentrate=" + currentrate);
            } else {
                refreshrate = currentrate;
                System.out.println("fullscreen.fsimp14: no refreshrate found, falling back to current refreshrate=" + currentrate);
            }
        }

        this.fullscreenDevice.setDisplayMode(new DisplayMode(width, height, bits, refreshrate));
        System.out.println("fullscreen.fsimp14: mode set successfully");
    }

    @OriginalMember(owner = "client!cia", name = "listmodes", descriptor = "()[I")
    public int[] listmodes() {
        @Pc(3) DisplayMode[] modes = this.fullscreenDevice.getDisplayModes();
        @Pc(9) int[] packedModes = new int[modes.length << 2];
        for (@Pc(11) int i = 0; i < modes.length; i++) {
            packedModes[i << 2] = modes[i].getWidth();
            packedModes[(i << 2) + 1] = modes[i].getHeight();
            packedModes[(i << 2) + 2] = modes[i].getBitDepth();
            packedModes[(i << 2) + 3] = modes[i].getRefreshRate();
        }
        return packedModes;
    }

    @OriginalMember(owner = "client!cia", name = "exit", descriptor = "()V")
    public void exit() {
        System.out.println("fullscreen.fsimp14: exiting");

        if (this.previousDisplayMode != null) {
            this.fullscreenDevice.setDisplayMode(this.previousDisplayMode);

            if (!this.fullscreenDevice.getDisplayMode().equals(this.previousDisplayMode)) {
                throw new RuntimeException("Did not return to correct resolution!");
            }

            this.previousDisplayMode = null;
        }

        this.method1562(null);
        System.out.println("fullscreen.fsimp14: exited");
    }
}
