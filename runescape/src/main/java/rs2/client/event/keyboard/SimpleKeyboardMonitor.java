package rs2.client.event.keyboard;

import com.jagex.sign.SignLink;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.util.SystemTimer;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Method;

@OriginalClass("client!ui")
public final class SimpleKeyboardMonitor extends KeyboardMonitor implements KeyListener, FocusListener {

    public static final int KEY_CODE_SHIFT = 81;

    public static final int KEY_CODE_CONTROL = 82;

    public static final int KEY_CODE_ALT = 86;

    @OriginalMember(owner = "client!ot", name = "N", descriptor = "[I")
    public static final int[] KEY_MAP = {
        0, 0, 0, 0, 0, 0, 0, 0, 85, 80, 84, 0, 91, 0, 0, 0, 81, 82, 86,
        0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0, 83, 104, 105, 103, 102,
        96, 98, 97, 99, 0, 0, 0, 0, 0, 0, 0, 25, 16, 17, 18, 19, 20, 21,
        22, 23, 24, 0, 0, 0, 0, 0, 0, 0, 48, 68, 66, 50, 34, 51, 52, 53,
        39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65,
        37, 64, 0, 0, 0, 0, 0, 228, 231, 227, 233, 224, 219, 225, 230,
        226, 232, 89, 87, 0, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 0, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0
    };

    @OriginalMember(owner = "client!vaa", name = "b", descriptor = "(Z)V")
    public static void updateKeymap() {
        if (GameShell.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
            KEY_MAP[191] = 73;
            KEY_MAP[186] = 57;
            KEY_MAP[219] = 42;
            KEY_MAP[223] = 28;
            KEY_MAP[192] = 58;
            KEY_MAP[189] = 26;
            KEY_MAP[222] = 59;
            KEY_MAP[188] = 71;
            KEY_MAP[187] = 27;
            KEY_MAP[220] = 74;
            KEY_MAP[221] = 43;
            KEY_MAP[190] = 72;
        } else {
            KEY_MAP[92] = 74;
            KEY_MAP[47] = 73;
            KEY_MAP[46] = 72;
            KEY_MAP[44] = 71;
            KEY_MAP[45] = 26;
            if (SignLink.setFocusTraversalKeysEnabled == null) {
                KEY_MAP[192] = 58;
                KEY_MAP[222] = 59;
            } else {
                KEY_MAP[222] = 58;
                KEY_MAP[192] = 28;
                KEY_MAP[520] = 59;
            }
            KEY_MAP[93] = 43;
            KEY_MAP[91] = 42;
            KEY_MAP[59] = 57;
            KEY_MAP[61] = 27;
        }
    }

    @OriginalMember(owner = "client!ui", name = "n", descriptor = "Ljava/awt/Component;")
    public Component component;

    @OriginalMember(owner = "client!ui", name = "p", descriptor = "Lclient!sia;")
    public final Deque recorded = new Deque();

    @OriginalMember(owner = "client!ui", name = "q", descriptor = "Lclient!sia;")
    public final Deque logged = new Deque();

    @OriginalMember(owner = "client!ui", name = "i", descriptor = "[Z")
    public final boolean[] pressed = new boolean[112];

    @OriginalMember(owner = "client!ui", name = "<init>", descriptor = "(Ljava/awt/Component;)V")
    public SimpleKeyboardMonitor(@OriginalArg(0) Component component) {
        updateKeymap();
        this.listen(component);
    }

    @OriginalMember(owner = "client!ui", name = "d", descriptor = "(I)I")
    public int modifierFlags() {
        @Pc(5) int flags = 0;
        if (this.pressed[KEY_CODE_SHIFT]) {
            flags = 0x1;
        }
        if (this.pressed[KEY_CODE_CONTROL]) {
            flags |= 0x4;
        }
        if (this.pressed[KEY_CODE_ALT]) {
            flags |= 0x2;
        }
        return flags;
    }

    @OriginalMember(owner = "client!ui", name = "a", descriptor = "(CIII)V")
    public void log(@OriginalArg(0) char keyChar, @OriginalArg(2) int keyCode, @OriginalArg(3) int type) {
        @Pc(7) SimpleKeyLog log = new SimpleKeyLog();
        log.keyChar = keyChar;
        log.keyCode = keyCode;
        log.type = type;
        log.time = SystemTimer.safetime();
        this.logged.addLast(log);
    }

    @OriginalMember(owner = "client!ui", name = "focusGained", descriptor = "(Ljava/awt/event/FocusEvent;)V")
    @Override
    public void focusGained(@OriginalArg(0) FocusEvent event) {
        /* empty */
    }

    @OriginalMember(owner = "client!ui", name = "a", descriptor = "(I)Lclient!wka;")
    @Override
    public KeyLog removeFirstRecorded() {
        return (KeyLog) this.recorded.removeFirst();
    }

    @OriginalMember(owner = "client!ui", name = "keyReleased", descriptor = "(Ljava/awt/event/KeyEvent;)V")
    @Override
    public synchronized void keyReleased(@OriginalArg(0) KeyEvent event) {
        this.log(KeyLog.TYPE_RELEASED, event);
    }

    @OriginalMember(owner = "client!ui", name = "b", descriptor = "(B)V")
    @Override
    public void remove() {
        this.reset();
    }

    @OriginalMember(owner = "client!ui", name = "a", descriptor = "(B)V")
    @Override
    public synchronized void record() {
        this.recorded.clear();

        for (@Pc(22) SimpleKeyLog log = (SimpleKeyLog) this.logged.removeFirst(); log != null; log = (SimpleKeyLog) this.logged.removeFirst()) {
            log.modifierFlags = this.modifierFlags();

            if (log.type == 0) {
                if (!this.pressed[log.keyCode]) {
                    @Pc(152) SimpleKeyLog recordedLog = new SimpleKeyLog();
                    recordedLog.keyChar = '\u0000';
                    recordedLog.keyCode = log.keyCode;
                    recordedLog.type = 0;
                    recordedLog.modifierFlags = log.modifierFlags;
                    recordedLog.time = log.time;
                    this.recorded.addLast(recordedLog);
                    this.pressed[log.keyCode] = true;
                }

                log.type = 2;
                this.recorded.addLast(log);
            } else if (log.type == KeyLog.TYPE_RELEASED) {
                if (this.pressed[log.keyCode]) {
                    this.recorded.addLast(log);
                    this.pressed[log.keyCode] = false;
                }
            } else if (log.type == KeyLog.TYPE_UNFOCUSED) {
                for (@Pc(65) int keyCode = 0; keyCode < 112; keyCode++) {
                    if (this.pressed[keyCode]) {
                        @Pc(78) SimpleKeyLog recordedLog = new SimpleKeyLog();
                        recordedLog.keyCode = keyCode;
                        recordedLog.modifierFlags = log.modifierFlags;
                        recordedLog.keyChar = '\u0000';
                        recordedLog.type = 1;
                        recordedLog.time = log.time;
                        this.recorded.addLast(recordedLog);
                        this.pressed[keyCode] = false;
                    }
                }
            } else if (log.type == KeyLog.TYPE_KEY_TYPED) {
                this.recorded.addLast(log);
            }
        }
    }

    @OriginalMember(owner = "client!ui", name = "keyPressed", descriptor = "(Ljava/awt/event/KeyEvent;)V")
    @Override
    public synchronized void keyPressed(@OriginalArg(0) KeyEvent event) {
        this.log(0, event);
    }

    @OriginalMember(owner = "client!ui", name = "a", descriptor = "(BILjava/awt/event/KeyEvent;)V")
    public void log(@OriginalArg(1) int type, @OriginalArg(2) KeyEvent event) {
        @Pc(8) int keyCode = event.getKeyCode();

        if (keyCode == 0) {
            keyCode = 0;
        } else if (keyCode >= 0 && keyCode < KEY_MAP.length) {
            keyCode = KEY_MAP[keyCode];

            if (type == 0 && (keyCode & 0x80) != 0) {
                keyCode = 0;
            } else {
                keyCode &= 0xFFFFFF7F;
            }
        } else {
            keyCode = 0;
        }

        if (keyCode != 0) {
            this.log('\u0000', keyCode, type);
            event.consume();
        }
    }

    @OriginalMember(owner = "client!ui", name = "a", descriptor = "(ILjava/awt/Component;)V")
    public void listen(@OriginalArg(1) Component component) {
        this.reset();
        this.component = component;

        @Pc(11) Method setFocusTraversalKeysEnabled = SignLink.setFocusTraversalKeysEnabled;
        if (setFocusTraversalKeysEnabled != null) {
            try {
                setFocusTraversalKeysEnabled.invoke(this.component, Boolean.FALSE);
            } catch (@Pc(26) Throwable ignored) {
                /* empty */
            }
        }

        this.component.addKeyListener(this);
        this.component.addFocusListener(this);
    }

    @OriginalMember(owner = "client!ui", name = "c", descriptor = "(B)V")
    public void reset() {
        if (this.component == null) {
            return;
        }

        this.component.removeKeyListener(this);
        this.component.removeFocusListener(this);
        this.component = null;

        for (@Pc(26) int keyCode = 0; keyCode < 112; keyCode++) {
            this.pressed[keyCode] = false;
        }

        this.recorded.clear();
        this.logged.clear();
    }

    @OriginalMember(owner = "client!ui", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
    @Override
    public synchronized void focusLost(@OriginalArg(0) FocusEvent event) {
        this.log('\u0000', 0, KeyLog.TYPE_UNFOCUSED);
    }

    @OriginalMember(owner = "client!ui", name = "keyTyped", descriptor = "(Ljava/awt/event/KeyEvent;)V")
    @Override
    public synchronized void keyTyped(@OriginalArg(0) KeyEvent event) {
        @Pc(6) char keyChar = event.getKeyChar();

        if (keyChar != '\u0000' && Cp1252.contains(keyChar)) {
            this.log(keyChar, -1, KeyLog.TYPE_KEY_TYPED);
            event.consume();
        }
    }

    @OriginalMember(owner = "client!ui", name = "a", descriptor = "(II)Z")
    @Override
    public boolean isPressed(@OriginalArg(1) int keyCode) {
        return keyCode >= 0 && keyCode < 112 ? this.pressed[keyCode] : false;
    }
}
