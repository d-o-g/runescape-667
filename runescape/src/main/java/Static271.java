import com.jagex.ChangeLocationRequest;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static271 {

    @OriginalMember(owner = "client!ij", name = "l", descriptor = "Lclient!sb;")
    public static js5 aJs5_59;

    @OriginalMember(owner = "client!ij", name = "n", descriptor = "I")
    public static int anInt4363;

    @OriginalMember(owner = "client!ij", name = "a", descriptor = "(I)J")
    public static long method3929() {
        return Static600.aClass27_1.method5602();
    }

    @OriginalMember(owner = "client!ij", name = "c", descriptor = "(B)V")
    public static void method3930() {
        @Pc(10) ChangeLocationRequest local10;
        for (local10 = (ChangeLocationRequest) Static159.aDeque_15.first(); local10 != null; local10 = (ChangeLocationRequest) Static159.aDeque_15.next()) {
            Static544.method7214(local10, false);
        }
        for (local10 = (ChangeLocationRequest) Static227.aDeque_18.first(); local10 != null; local10 = (ChangeLocationRequest) Static227.aDeque_18.next()) {
            Static544.method7214(local10, true);
        }
    }
}
