package com.jagex.game.runetek6.config.defaults;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MapDefaults {

    @OriginalMember(owner = "client!od", name = "c", descriptor = "[I")
    public static int[] skyboxes;

    @OriginalMember(owner = "client!mo", name = "c", descriptor = "[I")
    public static int[] maleTitleEnums;

    @OriginalMember(owner = "client!en", name = "d", descriptor = "[I")
    public static int[] femaleTitleEnums;

    @OriginalMember(owner = "client!pr", name = "a", descriptor = "(B[B)V")
    public static void decode(@OriginalArg(1) byte[] arg0) {
        @Pc(10) Packet packet = new Packet(arg0);

        while (true) {
            @Pc(14) int code = packet.g1();
            if (code == 0) {
                return;
            }

            if (code == 1) {
                @Pc(137) int[] textures = skyboxes = new int[6];
                textures[0] = packet.g2();
                textures[1] = packet.g2();
                textures[2] = packet.g2();
                textures[3] = packet.g2();
                textures[4] = packet.g2();
                textures[5] = packet.g2();
            } else if (code == 4) {
                @Pc(50) int count = packet.g1();
                maleTitleEnums = new int[count];

                for (@Pc(55) int local55 = 0; local55 < count; local55++) {
                    maleTitleEnums[local55] = packet.g2();
                    if (maleTitleEnums[local55] == 65535) {
                        maleTitleEnums[local55] = -1;
                    }
                }
            } else if (code == 5) {
                @Pc(50) int count = packet.g1();
                femaleTitleEnums = new int[count];

                for (@Pc(55) int local55 = 0; local55 < count; local55++) {
                    femaleTitleEnums[local55] = packet.g2();
                    if (femaleTitleEnums[local55] == 65535) {
                        femaleTitleEnums[local55] = -1;
                    }
                }
            }
        }
    }

    private MapDefaults() {
        /* empty */
    }
}
