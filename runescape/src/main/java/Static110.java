import com.jagex.core.util.TimeUtils;
import com.jagex.graphics.Font;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static110 {

    @OriginalMember(owner = "client!dha", name = "s", descriptor = "I")
    public static int fullscreenHeight;

    @OriginalMember(owner = "client!dha", name = "v", descriptor = "Ljava/lang/String;")
    public static String aString19 = "";

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(IZ)V")
    public static void method2079(@OriginalArg(0) int arg0) {
        @Pc(7) int local7 = TimeUtils.clock - Static212.anInt3468;
        if (local7 >= 100) {
            Static693.anInt10383 = -1;
            Static692.anInt10376 = -1;
            Camera.mode = 1;
            return;
        }
        @Pc(28) int local28 = (int) Static479.aFloat123;
        if (Static188.anInt3103 >> 8 > local28) {
            local28 = Static188.anInt3103 >> 8;
        }
        if (Static572.aBooleanArray29[4] && local28 < Static140.anIntArray222[4] + 128) {
            local28 = Static140.anIntArray222[4] + 128;
        }
        @Pc(63) int local63 = (int) Camera.playerCameraYaw + Static288.anInt4621 & 0x3FFF;
        Static292.method4606(local28, (local28 >> 3) * 3 + 600 << 2, arg0, Static494.anInt7409, local63, Static38.anInt920, Static102.averageHeight(Camera.renderingLevel, -29754, PlayerEntity.self.z, PlayerEntity.self.x) - 200);
        @Pc(107) float local107 = 1.0F - (float) ((100 - local7) * (-local7 + 100) * (100 - local7)) / 1000000.0F;
        Camera.positionX = (int) ((float) Static70.anInt1569 + (float) (Camera.positionX - Static70.anInt1569) * local107);
        Camera.positionY = (int) ((float) (Camera.positionY - Static302.anInt4854) * local107 + (float) Static302.anInt4854);
        Camera.positionZ = (int) (local107 * (float) (Camera.positionZ - Static411.anInt6329) + (float) Static411.anInt6329);
        Camera.pitch = (int) ((float) (Camera.pitch - Static340.anInt5584) * local107 + (float) Static340.anInt5584);
        @Pc(160) int local160 = Camera.yaw - Static225.anInt3641;
        if (local160 > 8192) {
            local160 -= 16384;
        } else if (local160 < -8192) {
            local160 += 16384;
        }
        Camera.yaw = (int) ((float) Static225.anInt3641 + (float) local160 * local107);
        Camera.yaw &= 0x3FFF;
    }

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(Lclient!sb;I)V")
    public static void setBillboardJs5(@OriginalArg(0) js5 arg0) {
        Static331.aJs5_65 = arg0;
    }

    @OriginalMember(owner = "client!dha", name = "a", descriptor = "(Lclient!da;)V")
    public static void method2082(@OriginalArg(0) Font arg0) {
        Static242.aFont_7 = arg0;
    }
}
