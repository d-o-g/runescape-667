package com.jagex.game.runetek6.config.defaults;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class AudioDefaults {

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "I")
    public static int themeMusic = -1;

    @OriginalMember(owner = "client!af", name = "a", descriptor = "([BZ)V")
    public static void decode(@OriginalArg(0) byte[] data) {
        @Pc(15) Packet packet = new Packet(data);

        while (true) {
            @Pc(19) int code = packet.g1();
            if (code == 0) {
                return;
            }

            if (code == 1) {
                @Pc(34) int id = packet.g2();

                if (themeMusic == -1) {
                    themeMusic = id;
                }
            }
        }
    }

    private AudioDefaults() {
        /* empty */
    }
}
