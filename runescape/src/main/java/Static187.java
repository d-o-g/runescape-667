import com.jagex.core.constants.AreaMode;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.settings.ClanSettings;

public final class Static187 {

    @OriginalMember(owner = "client!fp", name = "R", descriptor = "I")
    public static int anInt3093 = 0;

    @OriginalMember(owner = "client!fp", name = "a", descriptor = "(Z)V")
    public static void method2842() {
        CutsceneManager.anIntArrayArray265 = null;
        CutsceneManager.id = -1;
        Static117.areaMode = AreaMode.STATIC_AREA;
        Static102.lastAreaMode = 0;
        CutsceneManager.state = 0;
        CutsceneManager.packet = null;
        Static298.method4385();
        Static525.areaCenterZ = 0;
        WorldMap.areaBaseX = 0;
        WorldMap.areaBaseZ = 0;
        Static62.areaCenterX = 0;
        for (@Pc(34) int local34 = 0; local34 < Static527.hintArrows.length; local34++) {
            Static527.hintArrows[local34] = null;
        }
        Static11.method146();
        for (@Pc(48) int local48 = 0; local48 < 2048; local48++) {
            PlayerList.highResolutionPlayers[local48] = null;
        }
        NPCList.size = 0;
        NPCList.local.clear();
        NPCList.newSize = 0;
        Static497.objStacks.clear();
        Camera.reset();
        VerifyId.reset();
        TimedVarDomain.instance.reset();
        ClanSettings.listened = null;
        ClanSettings.affined = null;
        Static211.pingRequest = null;
        ClanChannel.affined = null;
        ClanChannel.listened = null;
        Static675.nextPing = 0L;
    }

}
