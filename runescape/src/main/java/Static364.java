import com.jagex.game.runetek6.config.meltype.MapElementType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static364 {

    @OriginalMember(owner = "client!lia", name = "r", descriptor = "Lclient!rt;")
    public static Class327 aClass327_4;

    @OriginalMember(owner = "client!lia", name = "p", descriptor = "D")
    public static double aDouble17;

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(Z)Lclient!fu;")
    public static MapElementListEntry method5248() {
        if (WorldMap.elements == null || Static444.A_DEQUE_ITERATOR___1 == null) {
            return null;
        }
        for (@Pc(17) MapElementListEntry local17 = (MapElementListEntry) Static444.A_DEQUE_ITERATOR___1.next(); local17 != null; local17 = (MapElementListEntry) Static444.A_DEQUE_ITERATOR___1.next()) {
            @Pc(30) MapElementType local30 = WorldMap.mapElementTypeList.list(local17.id);
            if (local30 != null && local30.aBoolean217 && local30.variableTest(WorldMap.varDomain)) {
                return local17;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(IFFILclient!tk;[BFIBFIIIF)V")
    public static void method5251(@OriginalArg(1) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Class59 arg3, @OriginalArg(5) byte[] arg4, @OriginalArg(6) float arg5, @OriginalArg(9) float arg6, @OriginalArg(12) int arg7, @OriginalArg(13) float arg8) {
        @Pc(17) float[] local17 = new float[16384];
        @Pc(22) int local22;
        @Pc(48) int local48;
        for (@Pc(19) int local19 = 0; local19 < 8; local19++) {
            local22 = arg7;
            arg3.method1509(arg0 / (float) 128, arg8 * 127.0F, local17, 0, arg6 / (float) 16, arg2, arg1 / (float) 128);
            for (local48 = 0; local48 < 16384; local48++) {
                arg4[local22] = (byte) (int) ((float) arg4[local22] + local17[local48]);
                local22++;
            }
            arg1 *= 2.0F;
            arg0 *= 2.0F;
            arg6 *= 2.0F;
            arg8 *= arg5;
        }
        local22 = arg7;
        for (local48 = 0; local48 < 16384; local48++) {
            arg4[local22] = (byte) (arg4[local22] + 127);
            local22++;
        }
    }

}
