import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static13 {

    @OriginalMember(owner = "client!aha", name = "l", descriptor = "I")
    public static int anInt148;

    @OriginalMember(owner = "client!aha", name = "p", descriptor = "I")
    public static int anInt150 = 0;

    @OriginalMember(owner = "client!aha", name = "b", descriptor = "(I)V")
    public static void method158() {
        for (@Pc(7) int local7 = 0; local7 < NPCList.size; local7++) {
            @Pc(13) int local13 = NPCList.slots[local7];
            @Pc(20) NPCEntityNode local20 = (NPCEntityNode) NPCList.local.get(local13);
            if (local20 != null) {
                @Pc(25) NPCEntity local25 = local20.npc;
                Static489.tick(false, local25);
            }
        }
    }
}
