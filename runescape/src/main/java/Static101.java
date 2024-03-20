import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static101 {

    @OriginalMember(owner = "client!dca", name = "w", descriptor = "I")
    public static int anInt2097;

    @OriginalMember(owner = "client!dca", name = "v", descriptor = "I")
    public static int anInt2098;

    @OriginalMember(owner = "client!dca", name = "a", descriptor = "(I)V")
    public static void method2000() {
        for (@Pc(8) Node_Sub51 local8 = (Node_Sub51) Static460.A_DEQUE___40.first(); local8 != null; local8 = (Node_Sub51) Static460.A_DEQUE___40.next()) {
            if (local8.aBoolean713) {
                local8.method8236();
            }
        }
        for (@Pc(31) Node_Sub51 local31 = (Node_Sub51) Static717.A_DEQUE___81.first(); local31 != null; local31 = (Node_Sub51) Static717.A_DEQUE___81.next()) {
            if (local31.aBoolean713) {
                local31.method8236();
            }
        }
    }

    @OriginalMember(owner = "client!dca", name = "a", descriptor = "([[BBLclient!taa;)V")
    public static void method2001(@OriginalArg(0) byte[][] arg0, @OriginalArg(2) MapRegion region) {
        for (@Pc(1) int level = 0; level < region.levels; level++) {
            Static557.method7331();
            for (@Pc(6) int chunkX = 0; chunkX < Static720.mapWidth >> 3; chunkX++) {
                for (@Pc(9) int chunkY = 0; chunkY < Static501.mapHeight >> 3; chunkY++) {
                    @Pc(18) int chunkData = Static623.anIntArrayArrayArray19[level][chunkX][chunkY];
                    if (chunkData != -1) {
                        @Pc(27) int chunkLevel = (chunkData >> 24) & 0x3;
                        if (!region.underwater || chunkLevel == 0) {
                            @Pc(43) int regionDirection = (chunkData >> 1) & 0x3;
                            @Pc(49) int regionX = (chunkData >> 14) & 0x3FF;
                            @Pc(55) int regionZ = (chunkData >> 3) & 0x7FF;
                            @Pc(65) int regionId = (regionZ / 8) + ((regionX / 8) << 8);
                            for (@Pc(67) int local67 = 0; local67 < Static89.anIntArray169.length; local67++) {
                                if (Static89.anIntArray169[local67] == regionId && arg0[local67] != null) {
                                    region.loadChunkLocations((regionX & 0x7) * 8, Static577.A_COLLISION_MAP_ARRAY_1, level, Static163.activeToolkit, chunkX * 8, chunkY * 8, arg0[local67], regionDirection, chunkLevel, (regionZ & 0x7) * 8);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
