import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static46 {

    @OriginalMember(owner = "client!bja", name = "a", descriptor = "I")
    public static int anInt1001;

    @OriginalMember(owner = "client!bja", name = "a", descriptor = "(BZI)I")
    public static int method1082(@OriginalArg(2) int arg0) {
        @Pc(13) ClientInventory local13 = Static556.method7303(arg0, false);
        if (local13 == null) {
            return Static503.aClass335_1.method7657(arg0).anInt2072;
        }
        @Pc(24) int local24 = 0;
        for (@Pc(33) int local33 = 0; local33 < local13.anIntArray278.length; local33++) {
            if (local13.anIntArray278[local33] == -1) {
                local24++;
            }
        }
        return local24 + Static503.aClass335_1.method7657(arg0).anInt2072 - local13.anIntArray278.length;
    }

}
