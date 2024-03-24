package rs2.client.event.keyboard;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ff")
public final class SimpleKeyLog extends Node implements KeyLog {

    @OriginalMember(owner = "client!ff", name = "q", descriptor = "I")
    public int keyCode;

    @OriginalMember(owner = "client!ff", name = "w", descriptor = "C")
    public char keyChar;

    @OriginalMember(owner = "client!ff", name = "l", descriptor = "J")
    public long time;

    @OriginalMember(owner = "client!ff", name = "A", descriptor = "I")
    public int modifierFlags;

    @OriginalMember(owner = "client!ff", name = "n", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!ff", name = "a", descriptor = "(Z)I")
    @Override
    public int getType() {
        return this.type;
    }

    @OriginalMember(owner = "client!ff", name = "d", descriptor = "(I)J")
    @Override
    public long getTime() {
        return this.time;
    }

    @OriginalMember(owner = "client!ff", name = "b", descriptor = "(I)C")
    @Override
    public char getKeyChar() {
        return this.keyChar;
    }

    @OriginalMember(owner = "client!ff", name = "c", descriptor = "(I)I")
    @Override
    public int getModifierFlags() {
        return this.modifierFlags;
    }

    @OriginalMember(owner = "client!ff", name = "a", descriptor = "(I)I")
    @Override
    public int getKeyCode() {
        return this.keyCode;
    }
}
