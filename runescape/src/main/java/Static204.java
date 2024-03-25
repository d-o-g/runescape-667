import com.jagex.core.datastruct.key.Deque;
import com.jagex.game.collision.CollisionMap;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static204 {

    @OriginalMember(owner = "client!gfa", name = "l", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_14 = new Class155(22);

    @OriginalMember(owner = "client!gfa", name = "u", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___16 = new Deque();

    @OriginalMember(owner = "client!kb", name = "n", descriptor = "[B")
    public static final byte[] aByteArray103;

    static {
        @Pc(46) int local46 = 0;
        aByteArray103 = new byte[32896];
        for (@Pc(51) int local51 = 0; local51 < 256; local51++) {
            for (@Pc(54) int local54 = 0; local54 <= local51; local54++) {
                aByteArray103[local46++] = (byte) (int) (255.0D / Math.sqrt((float) (local51 * local51 + local54 * local54 + 65535) / 65535.0F));
            }
        }
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(IIIIIIIIZILclient!eq;)Z")
    public static boolean method3083(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(9) int arg8, @OriginalArg(10) CollisionMap arg9) {
        @Pc(5) int local5 = arg1;
        @Pc(7) int local7 = arg8;
        @Pc(16) int local16 = arg1 - 64;
        @Pc(21) int local21 = arg8 - 64;
        Static352.anIntArrayArray141[64][64] = 99;
        Static668.anIntArrayArray244[64][64] = 0;
        @Pc(35) byte local35 = 0;
        Static507.anIntArray610[0] = arg1;
        @Pc(41) int local41 = 0;
        @Pc(52) int local52 = local35 + 1;
        Static428.anIntArray517[0] = arg8;
        @Pc(57) int[][] local57 = arg9.flags;
        while (local52 != local41) {
            local7 = Static428.anIntArray517[local41];
            local5 = Static507.anIntArray610[local41];
            @Pc(70) int local70 = local7 - local21;
            @Pc(75) int local75 = local5 - local16;
            local41 = local41 + 1 & 0xFFF;
            @Pc(87) int local87 = local5 - arg9.x;
            @Pc(93) int local93 = local7 - arg9.z;
            if (arg5 == -4) {
                if (arg3 == local5 && local7 == arg7) {
                    Static594.anInt8775 = local5;
                    Static407.anInt6285 = local7;
                    return true;
                }
            } else if (arg5 == -3) {
                if (CollisionMap.isInsideRect(arg3, 2, local5, arg6, arg2, local7, arg7, 2)) {
                    Static407.anInt6285 = local7;
                    Static594.anInt8775 = local5;
                    return true;
                }
            } else if (arg5 == -2) {
                if (arg9.isOutsideRect(local5, local7, 2, 2, arg3, arg7, arg6, arg2, arg0)) {
                    Static407.anInt6285 = local7;
                    Static594.anInt8775 = local5;
                    return true;
                }
            } else if (arg5 == -1) {
                if (arg9.isInsideOrOutsideRect(local5, local7, 2, arg3, arg7, arg6, arg2, arg0)) {
                    Static407.anInt6285 = local7;
                    Static594.anInt8775 = local5;
                    return true;
                }
            } else if (arg5 == 0 || arg5 == 1 || arg5 == 2 || arg5 == 3 || arg5 == 9) {
                if (arg9.isAtWall(local5, arg7, 2, arg3, local7, arg5, arg4)) {
                    Static594.anInt8775 = local5;
                    Static407.anInt6285 = local7;
                    return true;
                }
            } else if (arg9.isAtDiagonalWallDecor(local5, arg5, arg3, arg7, arg4, local7, 2)) {
                Static407.anInt6285 = local7;
                Static594.anInt8775 = local5;
                return true;
            }
            @Pc(270) int local270 = Static668.anIntArrayArray244[local75][local70] + 1;
            if (local75 > 0 && Static352.anIntArrayArray141[local75 - 1][local70] == 0 && (local57[local87 - 1][local93] & 0x43A40000) == 0 && (local57[local87 - 1][local93 + 1] & 0x4E240000) == 0) {
                Static507.anIntArray610[local52] = local5 - 1;
                Static428.anIntArray517[local52] = local7;
                local52 = local52 + 1 & 0xFFF;
                Static352.anIntArrayArray141[local75 - 1][local70] = 2;
                Static668.anIntArrayArray244[local75 - 1][local70] = local270;
            }
            if (local75 < 126 && Static352.anIntArrayArray141[local75 + 1][local70] == 0 && (local57[local87 + 2][local93] & 0x60E40000) == 0 && (local57[local87 + 2][local93 + 1] & 0x78240000) == 0) {
                Static507.anIntArray610[local52] = local5 + 1;
                Static428.anIntArray517[local52] = local7;
                Static352.anIntArrayArray141[local75 + 1][local70] = 8;
                local52 = local52 + 1 & 0xFFF;
                Static668.anIntArrayArray244[local75 + 1][local70] = local270;
            }
            if (local70 > 0 && Static352.anIntArrayArray141[local75][local70 - 1] == 0 && (local57[local87][local93 - 1] & 0x43A40000) == 0 && (local57[local87 + 1][local93 - 1] & 0x60E40000) == 0) {
                Static507.anIntArray610[local52] = local5;
                Static428.anIntArray517[local52] = local7 - 1;
                Static352.anIntArrayArray141[local75][local70 - 1] = 1;
                local52 = local52 + 1 & 0xFFF;
                Static668.anIntArrayArray244[local75][local70 - 1] = local270;
            }
            if (local70 < 126 && Static352.anIntArrayArray141[local75][local70 + 1] == 0 && (local57[local87][local93 + 2] & 0x4E240000) == 0 && (local57[local87 + 1][local93 + 2] & 0x78240000) == 0) {
                Static507.anIntArray610[local52] = local5;
                Static428.anIntArray517[local52] = local7 + 1;
                local52 = local52 + 1 & 0xFFF;
                Static352.anIntArrayArray141[local75][local70 + 1] = 4;
                Static668.anIntArrayArray244[local75][local70 + 1] = local270;
            }
            if (local75 > 0 && local70 > 0 && Static352.anIntArrayArray141[local75 - 1][local70 - 1] == 0 && (local57[local87 - 1][local93] & 0x4FA40000) == 0 && (local57[local87 - 1][local93 - 1] & 0x43A40000) == 0 && (local57[local87][local93 - 1] & 0x63E40000) == 0) {
                Static507.anIntArray610[local52] = local5 - 1;
                Static428.anIntArray517[local52] = local7 - 1;
                local52 = local52 + 1 & 0xFFF;
                Static352.anIntArrayArray141[local75 - 1][local70 - 1] = 3;
                Static668.anIntArrayArray244[local75 - 1][local70 - 1] = local270;
            }
            if (local75 < 126 && local70 > 0 && Static352.anIntArrayArray141[local75 + 1][local70 - 1] == 0 && (local57[local87 + 1][local93 - 1] & 0x63E40000) == 0 && (local57[local87 + 2][local93 - 1] & 0x60E40000) == 0 && (local57[local87 + 2][local93] & 0x78E40000) == 0) {
                Static507.anIntArray610[local52] = local5 + 1;
                Static428.anIntArray517[local52] = local7 - 1;
                local52 = local52 + 1 & 0xFFF;
                Static352.anIntArrayArray141[local75 + 1][local70 - 1] = 9;
                Static668.anIntArrayArray244[local75 + 1][local70 - 1] = local270;
            }
            if (local75 > 0 && local70 < 126 && Static352.anIntArrayArray141[local75 - 1][local70 + 1] == 0 && (local57[local87 - 1][local93 + 1] & 0x4FA40000) == 0 && (local57[local87 - 1][local93 + 2] & 0x4E240000) == 0 && (local57[local87][local93 + 2] & 0x7E240000) == 0) {
                Static507.anIntArray610[local52] = local5 - 1;
                Static428.anIntArray517[local52] = local7 + 1;
                local52 = local52 + 1 & 0xFFF;
                Static352.anIntArrayArray141[local75 - 1][local70 + 1] = 6;
                Static668.anIntArrayArray244[local75 - 1][local70 + 1] = local270;
            }
            if (local75 < 126 && local70 < 126 && Static352.anIntArrayArray141[local75 + 1][local70 + 1] == 0 && (local57[local87 + 1][local93 + 2] & 0x7E240000) == 0 && (local57[local87 + 2][local93 + 2] & 0x78240000) == 0 && (local57[local87 + 2][local93 + 1] & 0x78E40000) == 0) {
                Static507.anIntArray610[local52] = local5 + 1;
                Static428.anIntArray517[local52] = local7 + 1;
                Static352.anIntArrayArray141[local75 + 1][local70 + 1] = 12;
                local52 = local52 + 1 & 0xFFF;
                Static668.anIntArrayArray244[local75 + 1][local70 + 1] = local270;
            }
        }
        Static407.anInt6285 = local7;
        Static594.anInt8775 = local5;
        return false;
    }

}
