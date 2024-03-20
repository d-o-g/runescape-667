import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static533 {

    @OriginalMember(owner = "client!qp", name = "d", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_196 = new Class225(114, 4);

    @OriginalMember(owner = "client!qp", name = "f", descriptor = "[I")
    public static final int[] anIntArray628 = new int[1000];

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(B)V")
    public static void method7119() {
        for (@Pc(8) DoublyLinkedNode_Sub2_Sub4 local8 = (DoublyLinkedNode_Sub2_Sub4) Static350.A_QUEUE___8.first(); local8 != null; local8 = (DoublyLinkedNode_Sub2_Sub4) Static350.A_QUEUE___8.next()) {
            if (local8.anInt1534 > 1) {
                local8.anInt1534 = 0;
                Static717.A_WEIGHTED_CACHE___232.put(local8, ((DoublyLinkedNode_Sub2_Sub16) local8.aQueue_3.sentinel.next2).aLong234);
                local8.aQueue_3.clear();
            }
        }
        Static31.anInt767 = 0;
        Static594.anInt8777 = 0;
        Static693.A_DEQUE___79.clear();
        Static490.A_HASH_TABLE___34.clear();
        Static350.A_QUEUE___8.clear();
        Static400.aBoolean622 = false;
    }
}
