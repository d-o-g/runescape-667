package rs2.client.event.keyboard;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!wka")
public interface KeyLog {

    public static final int TYPE_UNFOCUSED = -1;
    public static final int TYPE_RELEASED = 1;
    public static final int TYPE_KEY_TYPED = 3;

    @OriginalMember(owner = "client!wka", name = "a", descriptor = "(I)I")
    int getKeyCode();

    @OriginalMember(owner = "client!wka", name = "d", descriptor = "(I)J")
    long getTime();

    @OriginalMember(owner = "client!wka", name = "b", descriptor = "(I)C")
    char getKeyChar();

    @OriginalMember(owner = "client!wka", name = "c", descriptor = "(I)I")
    int getModifierFlags();

    @OriginalMember(owner = "client!wka", name = "a", descriptor = "(Z)I")
    int getType();
}
