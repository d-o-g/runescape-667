import com.jagex.collect.Deque;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static201 {

    @OriginalMember(owner = "client!ge", name = "Q", descriptor = "I")
    public static int anInt8407;

    @OriginalMember(owner = "client!ge", name = "Ab", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_206 = new Class225(136, 6);

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(ILclient!ie;Lclient!ie;)V")
    public static void addBefore(@OriginalArg(1) Deque.Node back, @OriginalArg(2) Deque.Node front) {
        if (front.prev != null) {
            front.unlink();
        }
        front.next = back;
        front.prev = back.prev;
        front.prev.next = front;
        front.next.prev = front;
    }
}
