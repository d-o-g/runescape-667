import com.jagex.core.util.TimeUtils;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.camera.Shake;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Camera {

    @OriginalMember(owner = "client!taa", name = "H", descriptor = "[[[I")
    public static final int[][][] spline = new int[2][][];

    @OriginalMember(owner = "client!mh", name = "B", descriptor = "I")
    public static int renderingLevel;

    @OriginalMember(owner = "client!dha", name = "y", descriptor = "I")
    public static int z;

    @OriginalMember(owner = "client!fea", name = "h", descriptor = "I")
    public static int x;

    @OriginalMember(owner = "client!qb", name = "j", descriptor = "I")
    public static int mode;

    @OriginalMember(owner = "client!wh", name = "N", descriptor = "I")
    public static int moveToZ;

    @OriginalMember(owner = "client!dp", name = "f", descriptor = "I")
    public static int moveToX;

    @OriginalMember(owner = "client!cea", name = "A", descriptor = "I")
    public static int splineStart = 0;

    @OriginalMember(owner = "client!mu", name = "a", descriptor = "I")
    public static int splineEnd = 0;

    @OriginalMember(owner = "client!iba", name = "h", descriptor = "I")
    public static int splineRate = 0;

    @OriginalMember(owner = "client!ija", name = "d", descriptor = "Z")
    public static boolean splineFinished = false;

    @OriginalMember(owner = "client!nha", name = "c", descriptor = "Z")
    public static boolean splineAtEnd = false;

    @OriginalMember(owner = "client!lfa", name = "g", descriptor = "I")
    public static int y;

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

    @OriginalMember(owner = "client!ff", name = "s", descriptor = "F")
    public static float playerCameraYaw = 0.0F;

    @OriginalMember(owner = "client!b", name = "jb", descriptor = "I")
    public static int yawOffset = 0;

    @OriginalMember(owner = "client!uu", name = "n", descriptor = "I")
    public static int scaleOffset = 0;

    @OriginalMember(owner = "client!nu", name = "b", descriptor = "I")
    public static int lookX;

    @OriginalMember(owner = "client!ah", name = "a", descriptor = "I")
    public static int lookZ;

    @OriginalMember(owner = "client!br", name = "B", descriptor = "I")
    public static int lookY;

    @OriginalMember(owner = "client!hma", name = "k", descriptor = "I")
    public static int anInt4018 = 0;

    @OriginalMember(owner = "client!nl", name = "c", descriptor = "I")
    public static int anInt6262 = 0;

    @OriginalMember(owner = "client!gba", name = "c", descriptor = "I")
    public static int posSpline = -1;

    @OriginalMember(owner = "client!jka", name = "r", descriptor = "I")
    public static int splinePosOffset = 0;

    @OriginalMember(owner = "client!ch", name = "m", descriptor = "[Lclient!tn;")
    public static ScriptedCameraPath[] cutsceneSplines;

    @OriginalMember(owner = "client!gka", name = "p", descriptor = "I")
    public static int lastSmoothReset = 0;

    @OriginalMember(owner = "client!ce", name = "g", descriptor = "I")
    public static int lastX;

    @OriginalMember(owner = "client!mv", name = "d", descriptor = "I")
    public static int lastZ;

    @OriginalMember(owner = "client!gw", name = "p", descriptor = "I")
    public static int lastYaw;

    @OriginalMember(owner = "client!kn", name = "j", descriptor = "I")
    public static int lastPitch;

    @OriginalMember(owner = "client!jk", name = "L", descriptor = "I")
    public static int lastY;

    @OriginalMember(owner = "client!li", name = "e", descriptor = "I")
    public static int moveToY;

    @OriginalMember(owner = "client!vv", name = "w", descriptor = "I")
    public static int moveToStep;

    @OriginalMember(owner = "client!vfa", name = "o", descriptor = "I")
    public static int moveToRate;

    @OriginalMember(owner = "client!vu", name = "b", descriptor = "I")
    public static int anInt10383;

    @OriginalMember(owner = "client!vt", name = "h", descriptor = "I")
    public static int anInt10376;

    @OriginalMember(owner = "client!fk", name = "o", descriptor = "I")
    public static int lookSpeed;

    @OriginalMember(owner = "client!jw", name = "v", descriptor = "I")
    public static int lookStep;

    @OriginalMember(owner = "client!sg", name = "a", descriptor = "(I)V")
    public static void splineTick() {
        if (posSpline == -1 || lookSpline == -1) {
            return;
        }

        @Pc(24) int rate = splineStart + ((splineEnd - splineStart) * splineRate >> 16);
        splineRate += rate;

        if (splineRate < 65535) {
            splineAtEnd = false;
            splineFinished = false;
        } else {
            splineRate = 65535;
            splineFinished = !splineAtEnd;
            splineAtEnd = true;
        }

        @Pc(54) float t = (float) splineRate / 65535.0F;
        @Pc(57) float[] pos = new float[3];
        @Pc(61) int posIdx = splinePosOffset * 2;
        for (@Pc(63) int i = 0; i < 3; i++) {
            @Pc(82) int tp0 = spline[posSpline][posIdx][i] * 3;
            @Pc(94) int tp1 = spline[posSpline][posIdx + 1][i] * 3;
            @Pc(127) int tp2 = (spline[posSpline][posIdx + 2][i] + spline[posSpline][posIdx + 2][i] - spline[posSpline][posIdx + 3][i]) * 3;
            @Pc(135) int d = spline[posSpline][posIdx][i];
            @Pc(140) int c = tp1 - tp0;
            @Pc(149) int b = tp2 + tp0 - tp1 * 2;
            @Pc(165) int a = spline[posSpline][posIdx + 2][i] + tp1 - d - tp2;
            pos[i] = (((float) a * t + (float) b) * t + (float) c) * t + (float) d;
        }

        z = (int) pos[2] - (WorldMap.areaBaseZ * 512);
        y = (int) pos[1] * -1;
        x = (int) pos[0] - (WorldMap.areaBaseX * 512);

        @Pc(220) float[] look = new float[3];
        @Pc(94) int lookIdx = splineLookOffset * 2;
        for (@Pc(127) int i = 0; i < 3; i++) {
            @Pc(135) int tp0 = spline[lookSpline][lookIdx][i] * 3;
            @Pc(140) int tp1 = spline[lookSpline][lookIdx + 1][i] * 3;
            @Pc(149) int tp2 = (spline[lookSpline][lookIdx + 2][i] + spline[lookSpline][lookIdx + 2][i] - spline[lookSpline][lookIdx + 3][i]) * 3;
            @Pc(165) int d = spline[lookSpline][lookIdx][i];
            @Pc(294) int c = tp1 - tp0;
            @Pc(304) int b = tp0 + tp2 - tp1 * 2;
            @Pc(321) int a = spline[lookSpline][lookIdx + 2][i] + tp1 - d - tp2;
            look[i] = (((float) a * t + (float) b) * t + (float) c) * t + (float) d;
        }

        @Pc(353) float deltaX = look[0] - pos[0];
        @Pc(363) float deltaY = -1.0F * (look[1] - pos[1]);
        @Pc(372) float deltaZ = look[2] - pos[2];
        @Pc(382) double delta = Math.sqrt((deltaX * deltaX) + (deltaZ * deltaZ));
        pitch = (int) (Math.atan2(deltaY, delta) * 2607.5945876176133D) & 0x3FFF;
        yaw = (int) (-Math.atan2(deltaX, deltaZ) * 2607.5945876176133D) & 0x3FFF;
        roll = ((spline[posSpline][posIdx + 2][3] - spline[posSpline][posIdx][3]) * splineRate >> 16) + spline[posSpline][posIdx][3];
    }

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(IZ)V")
    public static void update(@OriginalArg(0) int arg0) {
        @Pc(7) int deltaTime = TimeUtils.clock - lastSmoothReset;
        if (deltaTime >= 100) {
            anInt10383 = -1;
            anInt10376 = -1;
            mode = CameraMode.MODE_RESET;
            return;
        }

        @Pc(28) int local28 = (int) Static479.aFloat123;
        if (Static188.anInt3103 >> 8 > local28) {
            local28 = Static188.anInt3103 >> 8;
        }
        if (Shake.enabled[4] && local28 < Shake.amplitude[4] + 128) {
            local28 = Shake.amplitude[4] + 128;
        }

        @Pc(63) int local63 = (int) playerCameraYaw + Static288.anInt4621 & 0x3FFF;
        method4606(local28, (local28 >> 3) * 3 + 600 << 2, arg0, Static494.anInt7409, local63, Static38.anInt920, Static102.averageHeight(renderingLevel, PlayerEntity.self.z, PlayerEntity.self.x) - 200);

        @Pc(107) float local107 = 1.0F - (float) ((100 - deltaTime) * (-deltaTime + 100) * (100 - deltaTime)) / 1000000.0F;
        x = (int) ((float) (x - lastX) * local107 + (float) lastX);
        y = (int) ((float) (y - lastY) * local107 + (float) lastY);
        z = (int) (local107 * (float) (z - lastZ) + (float) lastZ);
        pitch = (int) ((float) (pitch - lastPitch) * local107 + (float) lastPitch);

        @Pc(160) int local160 = yaw - lastYaw;
        if (local160 > 8192) {
            local160 -= 16384;
        } else if (local160 < -8192) {
            local160 += 16384;
        }

        yaw = (int) ((float) lastYaw + (float) local160 * local107);
        yaw &= 0x3FFF;
    }

    @OriginalMember(owner = "client!jea", name = "b", descriptor = "(IIIIIIII)V")
    public static void method4606(@OriginalArg(0) int pitch, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int x, @OriginalArg(5) int yaw, @OriginalArg(6) int z, @OriginalArg(7) int y) {
        @Pc(7) int local7 = arg2 - 334;
        if (local7 < 0) {
            local7 = 0;
        } else if (local7 > 100) {
            local7 = 100;
        }
        @Pc(33) int local33 = local7 * (Static502.aShort97 - Static228.aShort45) / 100 + Static228.aShort45;
        Static582.orthoAngle = Static582.orthoZoom * local33 >> 8;

        @Pc(45) int local45 = local33 * arg1 >> 8;
        @Pc(52) int local52 = 16384 - pitch & 0x3FFF;
        @Pc(65) int local65 = 16384 - yaw & 0x3FFF;
        @Pc(67) int local67 = 0;
        @Pc(69) int local69 = 0;
        @Pc(71) int local71 = local45;
        if (local52 != 0) {
            local69 = Trig1.SIN[local52] * -local45 >> 14;
            local71 = local45 * Trig1.COS[local52] >> 14;
        }
        if (local65 != 0) {
            local67 = local71 * Trig1.SIN[local65] >> 14;
            local71 = Trig1.COS[local65] * local71 >> 14;
        }

        Camera.pitch = pitch;
        Camera.z = z - local71;
        Camera.x = x - local67;
        Camera.y = y - local69;
        Camera.roll = 0;
        Camera.yaw = yaw;
    }

    @OriginalMember(owner = "client!kba", name = "a", descriptor = "(IZIBIII)V")
    public static void moveTo(@OriginalArg(0) int x, @OriginalArg(1) boolean snap, @OriginalArg(2) int step, @OriginalArg(4) int y, @OriginalArg(5) int z, @OriginalArg(6) int rate) {
        moveToY = y;
        moveToStep = step;
        moveToRate = rate;
        moveToZ = z;
        moveToX = x;
        if (snap && moveToRate >= 100) {
            Camera.x = (moveToX * 512) + 256;
            Camera.z = (moveToZ * 512) + 256;
            Camera.y = Static102.averageHeight(renderingLevel, Camera.z, Camera.x) - moveToY;
        }
        mode = CameraMode.MODE_MOVE_TO;
        anInt10383 = -1;
        anInt10376 = -1;
    }

    @OriginalMember(owner = "client!vu", name = "a", descriptor = "(B)V")
    public static void reset() {
        for (@Pc(1) int i = 0; i < Shake.DIRECTIONS; i++) {
            Shake.enabled[i] = false;
        }
        lookSpeed = 0;
        lookSpline = -1;
        lookStep = 0;
        posSpline = -1;
        mode = CameraMode.MODE_RESET;
        anInt10383 = -1;
        anInt10376 = -1;
    }

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(I)V")
    public static void smoothReset() {
        for (@Pc(10) int i = 0; i < Shake.DIRECTIONS; i++) {
            Shake.enabled[i] = false;
        }
        lastX = x;
        lastZ = z;
        lastYaw = yaw;
        posSpline = -1;
        lastPitch = pitch;
        anInt10383 = -1;
        anInt10376 = -1;
        lookSpline = -1;
        lastSmoothReset = TimeUtils.clock;
        lookSpeed = 0;
        lookStep = 0;
        mode = CameraMode.MODE_SMOOTH_RESET;
        lastY = y;
    }

    @OriginalMember(owner = "client!sla", name = "a", descriptor = "(I)V")
    public static void moveToTick() {
        @Pc(9) int local9 = (moveToX * 512) + 256;
        @Pc(15) int local15 = (moveToZ * 512) + 256;
        @Pc(24) int local24 = Static102.averageHeight(renderingLevel, local15, local9) - moveToY;

        if (moveToRate >= 100) {
            x = moveToX * 512 + 256;
            z = moveToZ * 512 + 256;
            y = Static102.averageHeight(renderingLevel, z, x) - moveToY;
        } else {
            if (x < local9) {
                x += moveToStep + (local9 - x) * moveToRate / 1000;
                if (local9 < x) {
                    x = local9;
                }
            }
            if (local24 > y) {
                y += moveToStep + moveToRate * (local24 - y) / 1000;
                if (local24 < y) {
                    y = local24;
                }
            }
            if (local9 < x) {
                x -= moveToStep + (x - local9) * moveToRate / 1000;
                if (local9 > x) {
                    x = local9;
                }
            }
            if (y > local24) {
                y -= moveToStep + (y - local24) * moveToRate / 1000;
                if (local24 > y) {
                    y = local24;
                }
            }
            if (z < local15) {
                z += moveToStep + (local15 - z) * moveToRate / 1000;
                if (local15 < z) {
                    z = local15;
                }
            }
            if (z > local15) {
                z -= moveToRate * (z - local15) / 1000 + moveToStep;
                if (local15 > z) {
                    z = local15;
                }
            }
        }

        local15 = lookZ * 512 + 256;
        local9 = lookX * 512 + 256;
        local24 = Static102.averageHeight(renderingLevel, local15, local9) - lookY;

        @Pc(259) int local259 = local9 - x;
        @Pc(264) int local264 = local24 - y;
        @Pc(269) int local269 = local15 - z;
        @Pc(280) int local280 = (int) Math.sqrt(local269 * local269 + local259 * local259);
        @Pc(291) int local291 = (int) (Math.atan2(local264, local280) * 2607.5945876176133D) & 0x3FFF;
        @Pc(302) int local302 = (int) (Math.atan2(local259, local269) * -2607.5945876176133D) & 0x3FFF;

        if (local291 < 1024) {
            local291 = 1024;
        }
        if (local291 > 3072) {
            local291 = 3072;
        }

        if (pitch < local291) {
            pitch += (local291 - pitch >> 3) * lookSpeed / 1000 + lookStep << 3;
            if (local291 < pitch) {
                pitch = local291;
            }
        }
        if (pitch > local291) {
            pitch -= lookStep + lookSpeed * (pitch - local291 >> 3) / 1000 << 3;
            if (pitch < local291) {
                pitch = local291;
            }
        }

        @Pc(388) int local388 = local302 - yaw;
        if (local388 > 8192) {
            local388 -= 16384;
        }
        if (local388 < -8192) {
            local388 += 16384;
        }

        local388 >>= 0x3;

        if (local388 > 0) {
            yaw += lookStep + lookSpeed * local388 / 1000 << 3;
            yaw &= 0x3FFF;
        }
        if (local388 < 0) {
            yaw -= lookSpeed * -local388 / 1000 + lookStep << 3;
            yaw &= 0x3FFF;
        }

        @Pc(456) int local456 = local302 - yaw;
        if (local456 > 8192) {
            local456 -= 16384;
        }
        if (local456 < -8192) {
            local456 += 16384;
        }

        roll = 0;

        if (local456 < 0 && local388 > 0 || local456 > 0 && local388 < 0) {
            yaw = local302;
        }
    }

    private Camera() {
        /* empty */
    }
}
