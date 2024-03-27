import com.jagex.core.util.JagException;
import com.jagex.game.camera.CameraMode;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static276 {

    @OriginalMember(owner = "client!ila", name = "a", descriptor = "(I)V")
    public static void method3986() {
        Static317.anInt5046 = 0;
        Static442.aBoolean499 = false;
        Static384.aLocOccluderArray2 = new LocOccluder[500];
        Static150.anInt2634 = 0;
        Static446.anIntArrayArrayArray9 = new int[Static299.tileMaxLevel][Static619.tileMaxX + 1][Static662.tileMaxZ + 1];
        Static663.anInt9874 = Static340.anInt5586;
        Static86.anInt1803 = Static340.anInt5586;
        Static444.anInt6751 = 0;
        Static607.aLocOccluderArray4 = new LocOccluder[2000];
        Static285.aLocOccluderArray1 = new LocOccluder[1000];
        Static469.anInt7072 = 0;
        Static560.aLocOccluderArray3 = new LocOccluder[500];
        if (Static665.aToolkit_15 instanceof oa) {
            Static18.occlude = false;
        } else {
            Static18.occlude = true;
        }
    }

    @OriginalMember(owner = "client!ila", name = "b", descriptor = "(I)V")
    public static void method3988() {
        if (ClientOptions.instance.removeRoofsOverride.getValue() != 2) {
            return;
        }
        @Pc(21) byte local21 = (byte) (Static198.anInt3276 - 4 & 0xFF);
        @Pc(25) int local25 = Static198.anInt3276 % Static720.mapWidth;
        @Pc(30) int local30;
        for (@Pc(27) int local27 = 0; local27 < 4; local27++) {
            for (local30 = 0; local30 < Static501.mapLength; local30++) {
                Static328.aByteArrayArrayArray4[local27][local25][local30] = local21;
            }
        }
        if (Camera.renderingLevel == 3) {
            return;
        }
        for (local30 = 0; local30 < 2; local30++) {
            Static482.anIntArray588[local30] = -1000000;
            Static9.anIntArray18[local30] = 1000000;
            Static457.anIntArray552[local30] = 0;
            Static682.anIntArray817[local30] = 1000000;
            Static153.anIntArray235[local30] = 0;
        }
        @Pc(92) int local92 = PlayerEntity.self.x;
        @Pc(95) int local95 = PlayerEntity.self.z;
        @Pc(149) int local149;
        if (Camera.mode != CameraMode.MODE_DEFAULT && Camera.anInt10376 == -1) {
            local149 = Static102.averageHeight(Camera.renderingLevel, Camera.z, Camera.x);
            if (local149 - Camera.y < 3200 && (Static280.tileFlags[Camera.renderingLevel][Camera.x >> 9][Camera.z >> 9] & 0x4) != 0) {
                Static409.method5656(Camera.z >> 9, Static334.activeTiles, 1, Camera.x >> 9, false);
                return;
            }
            return;
        }
        if (Camera.mode != CameraMode.MODE_DEFAULT) {
            local92 = Camera.anInt10376;
            local95 = Camera.anInt10383;
        }
        if ((Static280.tileFlags[Camera.renderingLevel][local92 >> 9][local95 >> 9] & 0x4) != 0) {
            Static409.method5656(local95 >> 9, Static334.activeTiles, 0, local92 >> 9, false);
        }
        if (Camera.pitch >= 2560) {
            return;
        }
        local149 = Camera.x >> 9;
        @Pc(153) int local153 = Camera.z >> 9;
        @Pc(157) int local157 = local92 >> 9;
        @Pc(161) int local161 = local95 >> 9;
        @Pc(169) int local169;
        if (local157 > local149) {
            local169 = local157 - local149;
        } else {
            local169 = local149 - local157;
        }
        @Pc(186) int local186;
        if (local153 < local161) {
            local186 = local161 - local153;
        } else {
            local186 = local153 - local161;
        }
        if ((local169 != 0 || local186 != 0) && local169 > (-Static720.mapWidth) && local169 < Static720.mapWidth && -Static501.mapLength < local186 && Static501.mapLength > local186) {
            @Pc(278) int local278;
            @Pc(280) int local280;
            if (local169 <= local186) {
                local278 = local169 * 65536 / local186;
                local280 = 32768;
                while (local161 != local153) {
                    if (local161 > local153) {
                        local153++;
                    } else if (local161 < local153) {
                        local153--;
                    }
                    if ((Static280.tileFlags[Camera.renderingLevel][local149][local153] & 0x4) != 0) {
                        Static409.method5656(local153, Static334.activeTiles, 1, local149, false);
                        return;
                    }
                    local280 += local278;
                    if (local280 >= 65536) {
                        local280 -= 65536;
                        if (local149 < local157) {
                            local149++;
                        } else if (local149 > local157) {
                            local149--;
                        }
                        if ((Static280.tileFlags[Camera.renderingLevel][local149][local153] & 0x4) != 0) {
                            Static409.method5656(local153, Static334.activeTiles, 1, local149, false);
                            return;
                        }
                    }
                }
                return;
            }
            local278 = local186 * 65536 / local169;
            local280 = 32768;
            while (local157 != local149) {
                if (local149 < local157) {
                    local149++;
                } else if (local157 < local149) {
                    local149--;
                }
                if ((Static280.tileFlags[Camera.renderingLevel][local149][local153] & 0x4) != 0) {
                    Static409.method5656(local153, Static334.activeTiles, 1, local149, false);
                    return;
                }
                local280 += local278;
                if (local280 >= 65536) {
                    if (local161 > local153) {
                        local153++;
                    } else if (local161 < local153) {
                        local153--;
                    }
                    local280 -= 65536;
                    if ((Static280.tileFlags[Camera.renderingLevel][local149][local153] & 0x4) != 0) {
                        Static409.method5656(local153, Static334.activeTiles, 1, local149, false);
                        return;
                    }
                }
            }
            return;
        }
        JagException.sendTrace(null, "RC: " + local149 + "," + local153 + " " + local157 + "," + local161 + " " + WorldMap.areaBaseX + "," + WorldMap.areaBaseZ);
        return;
    }
}
