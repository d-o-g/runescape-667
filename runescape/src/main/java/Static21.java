import com.jagex.Client;
import com.jagex.Entity;
import com.jagex.core.util.JavaScript;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.graphics.EnvironmentLight;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.File;
import java.lang.reflect.Method;

public final class Static21 {

    // $FF: synthetic field
    @OriginalMember(owner = "client!am", name = "Xb", descriptor = "Ljava/lang/Class;")
    public static Class aClass23;

    @OriginalMember(owner = "client!am", name = "a", descriptor = "(Lclient!ha;IIIIIIZZ)V")
    public static void method8043(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int arg1, @OriginalArg(4) int arg2, @OriginalArg(5) int arg3, @OriginalArg(6) int arg4, @OriginalArg(7) boolean arg5, @OriginalArg(8) boolean arg6) {
        Static665.aToolkit_15 = toolkit;
        Static32.anInt772 = arg1;
        Static661.aBoolean457 = Static32.anInt772 > 1 && Static665.aToolkit_15.method7979();
        EnvironmentLight.anInt1066 = 9;
        Static340.anInt5586 = 0x1 << EnvironmentLight.anInt1066;
        EnvironmentLight.anInt3993 = Static340.anInt5586 >> 1;
        Math.sqrt(EnvironmentLight.anInt3993 * EnvironmentLight.anInt3993 + EnvironmentLight.anInt3993 * EnvironmentLight.anInt3993);
        Static299.tileMaxLevel = 4;
        Static619.tileMaxX = arg2;
        Static662.tileMaxZ = arg3;
        Static35.anInt813 = arg4;
        Static272.aClass13_1 = Static167.method2632();
        Static276.method3986();
        Static478.aTileArrayArrayArray3 = new Tile[4][Static619.tileMaxX][Static662.tileMaxZ];
        Static706.floor = new Ground[4];
        if (arg5) {
            Static62.waterColour = new int[Static619.tileMaxX][Static662.tileMaxZ];
            Static421.waterBias = new byte[Static619.tileMaxX][Static662.tileMaxZ];
            Static272.waterDepth = new short[Static619.tileMaxX][Static662.tileMaxZ];
            Static420.aTileArrayArrayArray2 = new Tile[1][Static619.tileMaxX][Static662.tileMaxZ];
            Static693.underwaterGround = new Ground[1];
        } else {
            Static62.waterColour = null;
            Static421.waterBias = null;
            Static272.waterDepth = null;
            Static420.aTileArrayArrayArray2 = null;
            Static693.underwaterGround = null;
        }
        if (arg6) {
            Client.tileLightFlags = new long[4][arg2][arg3];
            EnvironmentLight.aEnvironmentLightArray1 = new EnvironmentLight[65535];
            Static279.aBooleanArray11 = new boolean[65535];
            Static319.anInt5080 = 0;
        } else {
            Client.tileLightFlags = null;
            EnvironmentLight.aEnvironmentLightArray1 = null;
            Static279.aBooleanArray11 = null;
            Static319.anInt5080 = 0;
        }
        Static379.method5355(false);
        Static576.opaqueStationaryEntities = new Entity[2];
        Static398.transparentStationaryEntities = new Entity[2];
        Static468.dynamicEntities = new Entity[2];
        Static48.aEntityArray3 = new Entity[10000];
        Static546.onscreenOpaqueEntityCount = 0;
        Static395.aEntityArray11 = new Entity[5000];
        Static645.onscreenTransparentEntityCount = 0;
        Static679.aPositionEntity = new PositionEntity[5000];
        Static125.dynamicEntityCount = 0;
        Static258.aBooleanArrayArray3 = new boolean[Static35.anInt813 + Static35.anInt813 + 1][Static35.anInt813 + Static35.anInt813 + 1];
        Static142.aBooleanArrayArray1 = new boolean[Static35.anInt813 + Static35.anInt813 + 2][Static35.anInt813 + Static35.anInt813 + 2];
        Static102.anIntArray184 = new int[Static35.anInt813 + Static35.anInt813 + 2];
        Static514.aClass213_2 = Static514.aClass213_3;
        if (Static661.aBoolean457) {
            Static433.aBooleanArrayArrayArray5 = new boolean[4][Static35.anInt813 + Static35.anInt813 + 1][Static35.anInt813 + Static35.anInt813 + 1];
            Static275.aBooleanArrayArrayArray4 = new boolean[4][][];
            if (Static226.aClass46Array7 != null) {
                Static227.method3354();
            }
            Static226.aClass46Array7 = new Class46[Static32.anInt772];
            Static665.aToolkit_15.allocateThreads(Static226.aClass46Array7.length + 1);
            Static665.aToolkit_15.linkThreads(0);
            for (@Pc(214) int local214 = 0; local214 < Static226.aClass46Array7.length; local214++) {
                Static226.aClass46Array7[local214] = new Class46(local214 + 1, Static665.aToolkit_15);
                (new Thread(Static226.aClass46Array7[local214], "wr" + local214)).start();
            }
            @Pc(253) byte local253;
            if (Static32.anInt772 == 2) {
                local253 = 4;
                Static549.anInt9424 = 2;
            } else if (Static32.anInt772 == 3) {
                local253 = 6;
                Static549.anInt9424 = 3;
            } else {
                local253 = 8;
                Static549.anInt9424 = 4;
            }
            Static684.aClass302Array1 = new Class302[local253];
            for (@Pc(273) int local273 = 0; local273 < local253; local273++) {
                Static684.aClass302Array1[local273] = new Class302(Static515.renderingTaskNames[Static32.anInt772 - 2][local273]);
            }
        } else {
            Static549.anInt9424 = 1;
        }
        Static537.anIntArray633 = new int[Static549.anInt9424 - 1];
        Static621.anIntArray766 = new int[Static549.anInt9424 - 1];
    }

    @OriginalMember(owner = "client!am", name = "a", descriptor = "(ILjava/io/File;Z)V")
    public static void method8048(@OriginalArg(1) File arg0) {
        if (Static210.anObject8 == null) {
            Static716.method9349();
        }
        try {
            @Pc(28) Class local28 = Class.forName("com.sun.management.HotSpotDiagnosticMXBean");
            @Pc(54) Method local54 = local28.getDeclaredMethod("dumpHeap", aClass23 == null ? (aClass23 = Class.forName("java.lang.String")) : aClass23, Boolean.TYPE);
            local54.invoke(Static210.anObject8, arg0.getAbsolutePath(), Boolean.valueOf(false));
        } catch (@Pc(74) Exception local74) {
            System.out.println("HeapDump error:");
            local74.printStackTrace();
        }
    }

    @OriginalMember(owner = "client!am", name = "f", descriptor = "(B)Z")
    public static boolean showVideoAd() {
        if (Client.js) {
            try {
                JavaScript.call("showVideoAd", GameShell.loaderApplet);
                return true;
            } catch (@Pc(15) Throwable local15) {
            }
        }
        return false;
    }
}
