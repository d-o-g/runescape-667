import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static210 {

    @OriginalMember(owner = "client!gia", name = "t", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___9 = new ZoneProt(7, 2);

    @OriginalMember(owner = "client!gia", name = "q", descriptor = "Ljava/lang/Object;")
    public static volatile Object anObject8 = null;

    @OriginalMember(owner = "client!gia", name = "a", descriptor = "(BZIIZ)V")
    public static void quicksortWorldList(@OriginalArg(1) boolean primaryDescending, @OriginalArg(2) int secondaryComparison, @OriginalArg(3) int primaryComparison, @OriginalArg(4) boolean secondaryDescending) {
        WorldList.quicksort(WorldList.activeWorlds.length - 1, 0, primaryDescending, primaryComparison, secondaryDescending, secondaryComparison);
        Static419.anInt6434 = 0;
        Static522.aClass2_Sub12_4 = null;
    }
}
