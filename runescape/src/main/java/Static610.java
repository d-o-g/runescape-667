import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static610 {

    @OriginalMember(owner = "client!tf", name = "a", descriptor = "(ILclient!rka;I)V")
    public static void method8217(@OriginalArg(0) int arg0, @OriginalArg(1) PacketBuffer arg1) {
        @Pc(16) boolean local16 = arg1.readBits(1) == 1;
        if (local16) {
            Static321.anIntArray388[Static652.anInt9713++] = arg0;
        }
        @Pc(33) int local33 = arg1.readBits(2);
        @Pc(37) PlayerEntity local37 = PlayerList.highResolutionPlayers[arg0];
        if (local33 != 0) {
            @Pc(165) int local165;
            @Pc(170) int local170;
            @Pc(175) int local175;
            if (local33 == 1) {
                local165 = arg1.readBits(3);
                local170 = local37.pathX[0];
                local175 = local37.pathZ[0];
                if (local165 == 0) {
                    local175--;
                    local170--;
                } else if (local165 == 1) {
                    local175--;
                } else if (local165 == 2) {
                    local175--;
                    local170++;
                } else if (local165 == 3) {
                    local170--;
                } else if (local165 == 4) {
                    local170++;
                } else if (local165 == 5) {
                    local175++;
                    local170--;
                } else if (local165 == 6) {
                    local175++;
                } else if (local165 == 7) {
                    local170++;
                    local175++;
                }
                if (local16) {
                    local37.anInt1448 = local175;
                    local37.anInt1441 = local170;
                    local37.aBoolean127 = true;
                } else {
                    local37.method1425(local175, local170, Static139.aByteArray30[arg0]);
                }
            } else if (local33 == 2) {
                local165 = arg1.readBits(4);
                local170 = local37.pathX[0];
                local175 = local37.pathZ[0];
                if (local165 == 0) {
                    local170 -= 2;
                    local175 -= 2;
                } else if (local165 == 1) {
                    local170--;
                    local175 -= 2;
                } else if (local165 == 2) {
                    local175 -= 2;
                } else if (local165 == 3) {
                    local170++;
                    local175 -= 2;
                } else if (local165 == 4) {
                    local175 -= 2;
                    local170 += 2;
                } else if (local165 == 5) {
                    local175--;
                    local170 -= 2;
                } else if (local165 == 6) {
                    local170 += 2;
                    local175--;
                } else if (local165 == 7) {
                    local170 -= 2;
                } else if (local165 == 8) {
                    local170 += 2;
                } else if (local165 == 9) {
                    local170 -= 2;
                    local175++;
                } else if (local165 == 10) {
                    local170 += 2;
                    local175++;
                } else if (local165 == 11) {
                    local175 += 2;
                    local170 -= 2;
                } else if (local165 == 12) {
                    local175 += 2;
                    local170--;
                } else if (local165 == 13) {
                    local175 += 2;
                } else if (local165 == 14) {
                    local175 += 2;
                    local170++;
                } else if (local165 == 15) {
                    local170 += 2;
                    local175 += 2;
                }
                if (local16) {
                    local37.anInt1441 = local170;
                    local37.anInt1448 = local175;
                    local37.aBoolean127 = true;
                } else {
                    local37.method1425(local175, local170, Static139.aByteArray30[arg0]);
                }
            } else {
                local165 = arg1.readBits(1);
                @Pc(539) int local539;
                @Pc(551) int local551;
                @Pc(566) int local566;
                @Pc(573) int local573;
                if (local165 == 0) {
                    local170 = arg1.readBits(12);
                    local175 = local170 >> 10;
                    local539 = local170 >> 5 & 0x1F;
                    if (local539 > 15) {
                        local539 -= 32;
                    }
                    local551 = local170 & 0x1F;
                    if (local551 > 15) {
                        local551 -= 32;
                    }
                    local566 = local37.pathX[0] + local539;
                    local573 = local551 + local37.pathZ[0];
                    if (local16) {
                        local37.anInt1441 = local566;
                        local37.aBoolean127 = true;
                        local37.anInt1448 = local573;
                    } else {
                        local37.method1425(local573, local566, Static139.aByteArray30[arg0]);
                    }
                    local37.level = local37.virtualLevel = (byte) (local37.level + local175 & 0x3);
                    if (Static441.isBridgeAt(local573, local566)) {
                        local37.virtualLevel++;
                    }
                    if (PlayerList.activePlayerSlot == arg0) {
                        if (local37.level != Camera.renderingLevel) {
                            Static75.aBoolean521 = true;
                        }
                        Camera.renderingLevel = local37.level;
                    }
                } else {
                    local170 = arg1.readBits(30);
                    local175 = local170 >> 28;
                    local539 = local170 >> 14 & 0x3FFF;
                    local551 = local170 & 0x3FFF;
                    local566 = (local37.pathX[0] + WorldMap.areaBaseX + local539 & 0x3FFF) - WorldMap.areaBaseX;
                    local573 = (local551 + local37.pathZ[0] + WorldMap.areaBaseZ & 0x3FFF) - WorldMap.areaBaseZ;
                    if (local16) {
                        local37.aBoolean127 = true;
                        local37.anInt1448 = local573;
                        local37.anInt1441 = local566;
                    } else {
                        local37.method1425(local573, local566, Static139.aByteArray30[arg0]);
                    }
                    local37.level = local37.virtualLevel = (byte) (local175 + local37.level & 0x3);
                    if (Static441.isBridgeAt(local573, local566)) {
                        local37.virtualLevel++;
                    }
                    if (PlayerList.activePlayerSlot == arg0) {
                        Camera.renderingLevel = local37.level;
                    }
                }
            }
        } else if (local16) {
            local37.aBoolean127 = false;
        } else if (PlayerList.activePlayerSlot == arg0) {
            throw new RuntimeException("s:lr");
        } else {
            @Pc(70) Class350 local70 = Static246.aClass350Array1[arg0] = new Class350();
            local70.anInt9324 = (local37.level << 28) + ((WorldMap.areaBaseX + local37.pathX[0] >> 6 << 14) + (WorldMap.areaBaseZ + local37.pathZ[0] >> 6));
            if (local37.anInt1467 == -1) {
                local70.anInt9326 = local37.yaw.getValue(16383);
            } else {
                local70.anInt9326 = local37.anInt1467;
            }
            local70.anInt9322 = local37.target;
            local70.aBoolean711 = local37.aBoolean128;
            local70.aBoolean712 = local37.clanmate;
            if (local37.anInt1452 > 0) {
                Static76.method1552(local37);
            }
            PlayerList.highResolutionPlayers[arg0] = null;
            if (arg1.readBits(1) != 0) {
                Static383.method5379(arg0, arg1);
            }
        }
    }
}
