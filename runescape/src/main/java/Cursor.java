import org.openrs2.deob.annotation.OriginalMember;

public final class Cursor {

    @OriginalMember(owner = "client!im", name = "lb", descriptor = "I")
    public static int dflt = -1;

    @OriginalMember(owner = "client!bf", name = "u", descriptor = "I")
    public static int interaction = -1;

    private Cursor() {
        /* empty */
    }
}
