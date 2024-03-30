import com.jagex.Client;
import com.jagex.sign.SignedResource;
import com.jagex.sign.SignedResourceStatus;
import com.jagex.core.io.FileOnDisk;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.game.runetek6.config.meltype.MapElementType;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.IOException;

public final class Static720 {

    @OriginalMember(owner = "client!wr", name = "n", descriptor = "I")
    public static int mapWidth = 104;

    @OriginalMember(owner = "client!wr", name = "a", descriptor = "(ILclient!fu;ILclient!el;Lclient!rt;IBLclient!ha;I)V")
    public static void method9396(@OriginalArg(0) int arg0, @OriginalArg(1) MapElementListEntry arg1, @OriginalArg(2) int arg2, @OriginalArg(3) MapElementType arg3, @OriginalArg(4) Class327 arg4, @OriginalArg(5) int arg5, @OriginalArg(7) Toolkit arg6, @OriginalArg(8) int arg7) {
        @Pc(14) int local14 = arg2 - arg5 / 2 - 5;
        @Pc(18) int local18 = arg7 + 2;
        if (arg3.fillColour != 0) {
            arg6.fillRect(local14, local18, arg5 + 10, arg0 * arg4.method7536() + 1 + arg7 + -local18, arg3.fillColour);
        }
        if (arg3.outlineColour != 0) {
            arg6.outlineRect(local14, local18, arg5 + 10, arg4.method7536() * arg0 + 1 + arg7 + -local18, arg3.outlineColour);
        }
        @Pc(73) int local73 = arg3.textColour;
        if (arg1.aBoolean256 && arg3.hoverTextColour != -1) {
            local73 = arg3.hoverTextColour;
        }
        for (@Pc(87) int local87 = 0; local87 < arg0; local87++) {
            @Pc(93) String local93 = Static37.aStringArray5[local87];
            if (local87 < arg0 - 1) {
                local93 = local93.substring(0, local93.length() - 4);
            }
            arg4.method7540(arg6, local93, arg2, arg7, local73);
            arg7 += arg4.method7536();
        }
    }

    @OriginalMember(owner = "client!wr", name = "a", descriptor = "(ILjava/awt/Canvas;)V")
    public static void method9397(@OriginalArg(1) Canvas arg0) {
        @Pc(14) Dimension local14 = arg0.getSize();
        OrthoMode.method5454(local14.height, local14.width);
        if (OrthoMode.anInt6796 == 1) {
            OrthoMode.toolkit.addCanvas(arg0, OrthoMode.anInt8534, OrthoMode.anInt8585);
        } else {
            OrthoMode.toolkit.addCanvas(arg0, OrthoMode.orthoWidth, OrthoMode.orthoHeight);
        }
    }

    @OriginalMember(owner = "client!wr", name = "a", descriptor = "(I)Lclient!kv;")
    public static ClientOptions method9398() {
        @Pc(13) FileOnDisk local13 = null;
        @Pc(19) ClientOptions local19 = new ClientOptions(Client.modeGame, 0);
        try {
            @Pc(25) SignedResource resource = GameShell.signLink.openPrefs("", true);
            while (resource.status == SignedResourceStatus.IDLE) {
                TimeUtils.sleep(1L);
            }

            if (resource.status == SignedResourceStatus.SUCCESS) {
                local13 = (FileOnDisk) resource.result;
                @Pc(51) byte[] local51 = new byte[(int) local13.length()];
                @Pc(66) int local66;
                for (@Pc(53) int local53 = 0; local53 < local51.length; local53 += local66) {
                    local66 = local13.read(local51.length - local53, local51, local53);
                    if (local66 == -1) {
                        throw new IOException("EOF");
                    }
                }
                local19 = new ClientOptions(new Packet(local51), Client.modeGame, 0);
            }
        } catch (@Pc(97) Exception local97) {
        }
        try {
            if (local13 != null) {
                local13.close();
            }
        } catch (@Pc(104) Exception local104) {
        }
        return local19;
    }
}
