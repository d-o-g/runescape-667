import com.jagex.core.datastruct.LinkedList;
import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public final class Static168 {

    @OriginalMember(owner = "client!fda", name = "f", descriptor = "I")
    public static int anInt2842;

    @OriginalMember(owner = "client!fda", name = "c", descriptor = "Lclient!fla;")
    public static final LinkedList A_ENTITY_LIST___5 = new LinkedList();

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(Lclient!rka;I)V")
    public static void method2633(@OriginalArg(0) PacketBuffer arg0) {
        arg0.enterBitMode();
        @Pc(10) int local10 = PlayerList.activePlayerSlot;
        @Pc(20) PlayerEntity local20 = PlayerEntity.self = PlayerList.highResolutionPlayers[local10] = new PlayerEntity();
        local20.id = local10;
        @Pc(28) int local28 = arg0.readBits(30);
        @Pc(33) byte local33 = (byte) (local28 >> 28);
        @Pc(39) int local39 = local28 >> 14 & 0x3FFF;
        local20.pathX[0] = local39 - WorldMap.areaBaseX;
        @Pc(51) int local51 = local28 & 0x3FFF;
        local20.x = (local20.pathX[0] << 9) + (local20.getSize() << 8);
        local20.pathZ[0] = local51 - WorldMap.areaBaseZ;
        local20.z = (local20.pathZ[0] << 9) + (local20.getSize() << 8);
        Camera.renderingLevel = local20.level = local20.virtualLevel = local33;
        if (Static441.isBridgeAt(local20.pathZ[0], local20.pathX[0])) {
            local20.virtualLevel++;
        }
        if (PlayerList.appearances[local10] != null) {
            local20.decodeAppearance(PlayerList.appearances[local10]);
        }
        PlayerList.highResolutionPlayerCount = 0;
        PlayerList.highResolutionPlayerIndices[PlayerList.highResolutionPlayerCount++] = local10;
        PlayerList.updateHistory[local10] = 0;
        PlayerList.lowResolutionPlayerCount = 0;
        for (@Pc(151) int local151 = 1; local151 < 2048; local151++) {
            if (local10 != local151) {
                @Pc(163) int local163 = arg0.readBits(18);
                @Pc(167) int local167 = local163 >> 16;
                @Pc(173) int local173 = local163 >> 8 & 0xFF;
                @Pc(177) int local177 = local163 & 0xFF;
                @Pc(185) LowResPlayer local185 = PlayerList.lowResolutionPlayers[local151] = new LowResPlayer();
                local185.aBoolean711 = false;
                local185.target = -1;
                local185.coord = local177 + (local173 << 14) + (local167 << 28);
                local185.direcion = 0;
                local185.clanmate = false;
                PlayerList.lowResolutionPlayerIndices[PlayerList.lowResolutionPlayerCount++] = local151;
                PlayerList.updateHistory[local151] = 0;
            }
        }
        arg0.exitBitMode();
    }

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(I[B)Lclient!st;")
    public static Sprite method2634(@OriginalArg(1) byte[] data) {
        if (data == null) {
            throw new RuntimeException("");
        }

        while (true) {
            try {
                @Pc(22) Image image = Toolkit.getDefaultToolkit().createImage(data);
                @Pc(27) MediaTracker tracker = new MediaTracker(client.aClient1);
                tracker.addImage(image, 0);
                tracker.waitForAll();
                @Pc(37) int width = image.getWidth(client.aClient1);
                @Pc(41) int height = image.getHeight(client.aClient1);
                if (!tracker.isErrorAny() && width >= 0 && height >= 0) {
                    @Pc(66) int[] pixels = new int[height * width];
                    @Pc(78) PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
                    grabber.grabPixels();
                    return com.jagex.graphics.Toolkit.active.createSprite(width, width, height, pixels);
                }
                throw new RuntimeException("");
            } catch (@Pc(91) InterruptedException local91) {
            }
        }
    }

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(IBIIIII)V")
    public static void method2637(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        if (Static180.anInt2995 <= arg5 && Static111.anInt2219 >= arg3 && Static724.anInt10930 <= arg4 && Static273.anInt4395 >= arg0) {
            if (arg2 == 1) {
                Static175.method2701(arg0, arg4, arg1, arg3, arg5);
            } else {
                Static548.method7253(arg1, arg5, arg3, arg0, arg2, arg4);
            }
        } else if (arg2 == 1) {
            Static385.method5420(arg0, arg5, arg1, arg3, arg4);
        } else {
            Static249.method3535(arg2, arg4, arg3, arg0, arg5, arg1);
        }
    }
}
