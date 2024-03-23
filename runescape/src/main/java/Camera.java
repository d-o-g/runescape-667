import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Camera {
    @OriginalMember(owner = "client!taa", name = "H", descriptor = "[[[I")
    public static final int[][][] spline = new int[2][][];

    @OriginalMember(owner = "client!mh", name = "B", descriptor = "I")
    public static int renderingLevel;

    @OriginalMember(owner = "client!dha", name = "y", descriptor = "I")
    public static int positionZ;

    @OriginalMember(owner = "client!fea", name = "h", descriptor = "I")
    public static int positionX;

    @OriginalMember(owner = "client!qb", name = "j", descriptor = "I")
    public static int anInt7645;

    @OriginalMember(owner = "client!wh", name = "N", descriptor = "I")
    public static int anInt10667;

    @OriginalMember(owner = "client!dp", name = "f", descriptor = "I")
    public static int anInt2333;

    @OriginalMember(owner = "client!cea", name = "A", descriptor = "I")
    public static int splineStart = 0;

    @OriginalMember(owner = "client!mu", name = "a", descriptor = "I")
    public static int splineEnd = 0;

    @OriginalMember(owner = "client!iba", name = "h", descriptor = "I")
    public static int splineRate = 0;

    @OriginalMember(owner = "client!ija", name = "d", descriptor = "Z")
    public static boolean finished = false;

    @OriginalMember(owner = "client!nha", name = "c", descriptor = "Z")
    public static boolean aBoolean73 = false;

    @OriginalMember(owner = "client!lfa", name = "g", descriptor = "I")
    public static int positionY;

    @OriginalMember(owner = "client!sl", name = "A", descriptor = "I")
    public static int splineLookOffset = 0;

    @OriginalMember(owner = "client!lp", name = "a", descriptor = "I")
    public static int lookSpline = -1;

    @OriginalMember(owner = "client!ss", name = "f", descriptor = "I")
    public static int pitch;

    @OriginalMember(owner = "client!kda", name = "d", descriptor = "I")
    public static int yaw;

    @OriginalMember(owner = "client!cka", name = "q", descriptor = "I")
    public static int roll;

    @OriginalMember(owner = "client!sg", name = "a", descriptor = "(I)V")
    public static void splineTick() {
        if (Static197.anInt3260 == -1 || lookSpline == -1) {
            return;
        }

        @Pc(24) int rate = splineStart + ((splineEnd - splineStart) * splineRate >> 16);
        splineRate += rate;

        if (splineRate < 65535) {
            aBoolean73 = false;
            finished = false;
        } else {
            splineRate = 65535;
            if (aBoolean73) {
                finished = false;
            } else {
                finished = true;
            }
            aBoolean73 = true;
        }

        @Pc(54) float local54 = (float) splineRate / 65535.0F;
        @Pc(57) float[] local57 = new float[3];
        @Pc(61) int local61 = Static303.anInt4868 * 2;
        @Pc(94) int local94;
        @Pc(127) int local127;
        @Pc(135) int local135;
        @Pc(140) int local140;
        @Pc(149) int local149;
        @Pc(165) int local165;
        for (@Pc(63) int local63 = 0; local63 < 3; local63++) {
            @Pc(82) int local82 = spline[Static197.anInt3260][local61][local63] * 3;
            local94 = spline[Static197.anInt3260][local61 + 1][local63] * 3;
            local127 = (spline[Static197.anInt3260][local61 + 2][local63] + spline[Static197.anInt3260][local61 + 2][local63] - spline[Static197.anInt3260][local61 + 3][local63]) * 3;
            local135 = spline[Static197.anInt3260][local61][local63];
            local140 = local94 - local82;
            local149 = local127 + local82 - local94 * 2;
            local165 = spline[Static197.anInt3260][local61 + 2][local63] + local94 - local135 - local127;
            local57[local63] = (float) local135 + ((float) local140 + (local54 * (float) local165 + (float) local149) * local54) * local54;
        }

        positionZ = (int) local57[2] - WorldMap.areaBaseZ * 512;
        positionY = (int) local57[1] * -1;
        positionX = (int) local57[0] - WorldMap.areaBaseX * 512;

        @Pc(220) float[] local220 = new float[3];
        local94 = splineLookOffset * 2;
        for (local127 = 0; local127 < 3; local127++) {
            local135 = spline[lookSpline][local94][local127] * 3;
            local140 = spline[lookSpline][local94 + 1][local127] * 3;
            local149 = (spline[lookSpline][local94 + 2][local127] + spline[lookSpline][local94 + 2][local127] - spline[lookSpline][local94 + 3][local127]) * 3;
            local165 = spline[lookSpline][local94][local127];
            @Pc(294) int local294 = local140 - local135;
            @Pc(304) int local304 = local135 + local149 - local140 * 2;
            @Pc(321) int local321 = spline[lookSpline][local94 + 2][local127] + local140 - local165 - local149;
            local220[local127] = (float) local165 + ((float) local294 + ((float) local304 + (float) local321 * local54) * local54) * local54;
        }
        @Pc(353) float local353 = local220[0] - local57[0];
        @Pc(363) float local363 = -1.0F * (local220[1] - local57[1]);
        @Pc(372) float local372 = local220[2] - local57[2];
        @Pc(382) double local382 = Math.sqrt(local353 * local353 + local372 * local372);
        pitch = (int) (Math.atan2(local363, local382) * 2607.5945876176133D) & 0x3FFF;
        yaw = (int) (-Math.atan2(local353, local372) * 2607.5945876176133D) & 0x3FFF;
        roll = ((spline[Static197.anInt3260][local61 + 2][3] - spline[Static197.anInt3260][local61][3]) * splineRate >> 16) + spline[Static197.anInt3260][local61][3];
    }

    private Camera() {
        /* empty */
    }
}
