import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static458 {

    @OriginalMember(owner = "client!oi", name = "o", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_31 = new Class155(20);

    @OriginalMember(owner = "client!oi", name = "a", descriptor = "(Z[[[Lclient!pha;)V")
    public static void method6243(@OriginalArg(1) Tile[][][] arg0) {
        for (@Pc(12) int local12 = 0; local12 < arg0.length; local12++) {
            @Pc(17) Tile[][] local17 = arg0[local12];
            for (@Pc(19) int local19 = 0; local19 < local17.length; local19++) {
                for (@Pc(22) int local22 = 0; local22 < local17[local19].length; local22++) {
                    @Pc(29) Tile local29 = local17[local19][local22];
                    if (local29 != null) {
                        if (local29.groundDecor instanceof Location) {
                            ((Location) local29.groundDecor).method6856();
                        }
                        if (local29.aWallDecor_1 instanceof Location) {
                            local29.aWallDecor_1.method6856();
                        }
                        if (local29.aClass8_Sub2_Sub4_2 instanceof Location) {
                            local29.aClass8_Sub2_Sub4_2.method6856();
                        }
                        if (local29.aClass8_Sub2_Sub3_2 instanceof Location) {
                            ((Location) local29.aClass8_Sub2_Sub3_2).method6856();
                        }
                        if (local29.aWall_1 instanceof Location) {
                            ((Location) local29.aWall_1).method6856();
                        }
                        for (@Pc(91) PositionEntityNode local91 = local29.head; local91 != null; local91 = local91.node) {
                            @Pc(95) PositionEntity local95 = local91.entity;
                            if (local95 instanceof Location) {
                                ((Location) local95).method6856();
                            }
                        }
                    }
                }
            }
        }
    }
}
