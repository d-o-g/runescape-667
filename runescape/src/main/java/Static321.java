import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static321 {

    @OriginalMember(owner = "client!kca", name = "V", descriptor = "I")
    public static int anInt5113;

    @OriginalMember(owner = "client!kca", name = "w", descriptor = "Lclient!ss;")
    public static final Class345 VIDEO_STOP = new Class345(58, 2);

    @OriginalMember(owner = "client!kca", name = "y", descriptor = "I")
    public static int anInt5111 = 0;

    @OriginalMember(owner = "client!kca", name = "O", descriptor = "[I")
    public static final int[] anIntArray388 = new int[2048];

    @OriginalMember(owner = "client!kca", name = "a", descriptor = "(IB)Lclient!wca;")
    public static Class396 method4620() {
        return new Class396(1, false);
    }

    @OriginalMember(owner = "client!kca", name = "a", descriptor = "(II)Z")
    public static boolean method4622(@OriginalArg(0) int arg0) {
        for (@Pc(8) DoublyLinkedNode_Sub2_Sub16 local8 = (DoublyLinkedNode_Sub2_Sub16) Static693.A_DEQUE___79.first(); local8 != null; local8 = (DoublyLinkedNode_Sub2_Sub16) Static693.A_DEQUE___79.next()) {
            if (Static598.method7825(local8.anInt7314) && local8.aLong233 == (long) arg0) {
                return true;
            }
        }
        return false;
    }
}
