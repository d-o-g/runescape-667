import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static592 {

    @OriginalMember(owner = "client!sla", name = "a", descriptor = "(I)V")
    public static void method7761() {
        @Pc(9) int local9 = Camera.anInt2333 * 512 + 256;
        @Pc(15) int local15 = Camera.anInt10667 * 512 + 256;
        @Pc(24) int local24 = Static102.averageHeight(Camera.renderingLevel, -29754, local15, local9) - Static363.anInt6934;
        if (Static674.anInt10088 >= 100) {
            Camera.x = Camera.anInt2333 * 512 + 256;
            Camera.z = Camera.anInt10667 * 512 + 256;
            Camera.y = Static102.averageHeight(Camera.renderingLevel, -29754, Camera.z, Camera.x) - Static363.anInt6934;
        } else {
            if (Camera.x < local9) {
                Camera.x += Static694.anInt10411 + (local9 - Camera.x) * Static674.anInt10088 / 1000;
                if (local9 < Camera.x) {
                    Camera.x = local9;
                }
            }
            if (local24 > Camera.y) {
                Camera.y += Static694.anInt10411 + Static674.anInt10088 * (local24 - Camera.y) / 1000;
                if (local24 < Camera.y) {
                    Camera.y = local24;
                }
            }
            if (local9 < Camera.x) {
                Camera.x -= Static694.anInt10411 + (Camera.x - local9) * Static674.anInt10088 / 1000;
                if (local9 > Camera.x) {
                    Camera.x = local9;
                }
            }
            if (Camera.y > local24) {
                Camera.y -= Static694.anInt10411 + (Camera.y - local24) * Static674.anInt10088 / 1000;
                if (local24 > Camera.y) {
                    Camera.y = local24;
                }
            }
            if (Camera.z < local15) {
                Camera.z += Static694.anInt10411 + (local15 - Camera.z) * Static674.anInt10088 / 1000;
                if (local15 < Camera.z) {
                    Camera.z = local15;
                }
            }
            if (Camera.z > local15) {
                Camera.z -= Static674.anInt10088 * (Camera.z - local15) / 1000 + Static694.anInt10411;
                if (local15 > Camera.z) {
                    Camera.z = local15;
                }
            }
        }
        local15 = Camera.lookZ * 512 + 256;
        local9 = Camera.lookX * 512 + 256;
        local24 = Static102.averageHeight(Camera.renderingLevel, -29754, local15, local9) - Camera.lookY;
        @Pc(259) int local259 = local9 - Camera.x;
        @Pc(264) int local264 = local24 - Camera.y;
        @Pc(269) int local269 = local15 - Camera.z;
        @Pc(280) int local280 = (int) Math.sqrt(local269 * local269 + local259 * local259);
        @Pc(291) int local291 = (int) (Math.atan2(local264, local280) * 2607.5945876176133D) & 0x3FFF;
        @Pc(302) int local302 = (int) (-2607.5945876176133D * Math.atan2(local259, local269)) & 0x3FFF;
        if (local291 < 1024) {
            local291 = 1024;
        }
        if (local291 > 3072) {
            local291 = 3072;
        }
        if (Camera.pitch < local291) {
            Camera.pitch += (local291 - Camera.pitch >> 3) * Static179.anInt2991 / 1000 + Static314.anInt5035 << 3;
            if (local291 < Camera.pitch) {
                Camera.pitch = local291;
            }
        }
        if (Camera.pitch > local291) {
            Camera.pitch -= Static314.anInt5035 + Static179.anInt2991 * (Camera.pitch - local291 >> 3) / 1000 << 3;
            if (Camera.pitch < local291) {
                Camera.pitch = local291;
            }
        }
        @Pc(388) int local388 = local302 - Camera.yaw;
        if (local388 > 8192) {
            local388 -= 16384;
        }
        if (local388 < -8192) {
            local388 += 16384;
        }
        local388 >>= 0x3;
        if (local388 > 0) {
            Camera.yaw += Static314.anInt5035 + Static179.anInt2991 * local388 / 1000 << 3;
            Camera.yaw &= 0x3FFF;
        }
        if (local388 < 0) {
            Camera.yaw -= Static179.anInt2991 * -local388 / 1000 + Static314.anInt5035 << 3;
            Camera.yaw &= 0x3FFF;
        }
        @Pc(456) int local456 = local302 - Camera.yaw;
        if (local456 > 8192) {
            local456 -= 16384;
        }
        if (local456 < -8192) {
            local456 += 16384;
        }
        Camera.roll = 0;
        if (local456 < 0 && local388 > 0 || local456 > 0 && local388 < 0) {
            Camera.yaw = local302;
        }
    }
}
