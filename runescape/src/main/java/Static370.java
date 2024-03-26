import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static370 {

    @OriginalMember(owner = "client!lm", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___152 = new ServerProt(4, 0);

    @OriginalMember(owner = "client!lm", name = "j", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___11 = new ZoneProt(9, -1);

    @OriginalMember(owner = "client!lm", name = "d", descriptor = "(I)V")
    public static void method5280() {
        @Pc(12) int local12;
        if (Static384.aLocOccluderArray2 != null) {
            for (local12 = 0; local12 < Static317.anInt5046; local12++) {
                Static384.aLocOccluderArray2[local12] = null;
            }
            Static384.aLocOccluderArray2 = null;
        }
        if (Static607.aLocOccluderArray4 != null) {
            for (local12 = 0; local12 < Static444.anInt6751; local12++) {
                Static607.aLocOccluderArray4[local12] = null;
            }
            Static607.aLocOccluderArray4 = null;
        }
        if (Static285.aLocOccluderArray1 != null) {
            for (local12 = 0; local12 < Static150.anInt2634; local12++) {
                Static285.aLocOccluderArray1[local12] = null;
            }
            Static285.aLocOccluderArray1 = null;
        }
        Static560.aLocOccluderArray3 = null;
        Static446.anIntArrayArrayArray9 = null;
        Static485.anIntArray886 = null;
        Static624.anInt9461 = -1;
        Static228.anInt3709 = -1;
    }

}
