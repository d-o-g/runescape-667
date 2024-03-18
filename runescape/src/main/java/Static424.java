import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static424 {

    @OriginalMember(owner = "client!nga", name = "d", descriptor = "I")
    public static int anInt6459 = 0;

    @OriginalMember(owner = "client!nga", name = "b", descriptor = "Lclient!ss;")
    public static final Class345 aClass345_79 = new Class345(14, 3);

    @OriginalMember(owner = "client!nga", name = "a", descriptor = "(I)V")
    public static void method5779() {
        @Pc(1) WeightedCache local1 = PlayerModel.BIG_CACHE;
        synchronized (PlayerModel.BIG_CACHE) {
            PlayerModel.BIG_CACHE.method2151();
        }
        local1 = PlayerModel.SMALL_CACHE;
        synchronized (PlayerModel.SMALL_CACHE) {
            PlayerModel.SMALL_CACHE.method2151();
        }
    }
}
