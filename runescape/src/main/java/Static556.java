import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static556 {

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "Lclient!uc;")
    public static Environment aEnvironment_2;

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IB)V")
    public static void method7300(@OriginalArg(0) int arg0) {
        Static682.anIntArray817 = new int[arg0];
        Static153.anIntArray235 = new int[arg0];
        Static9.anIntArray18 = new int[arg0];
        Static482.anIntArray588 = new int[arg0];
        Static457.anIntArray552 = new int[arg0];
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IBZ)Lclient!gfa;")
    public static ClientInventory method7303(@OriginalArg(0) int arg0, @OriginalArg(2) boolean arg1) {
        @Pc(19) long local19 = arg0 | (arg1 ? Integer.MIN_VALUE : 0);
        return (ClientInventory) ClientInventory.recentUse.get(local19);
    }
}
