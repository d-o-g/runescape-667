import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static94 {

    @OriginalMember(owner = "client!cv", name = "m", descriptor = "J")
    public static long aLong70;

    @OriginalMember(owner = "client!cv", name = "k", descriptor = "I")
    public static int anInt1961;

    @OriginalMember(owner = "client!cv", name = "b", descriptor = "(I)V")
    public static void method1841() {
        Static524.aServerConnection_3.clear();
        Static524.aServerConnection_3.currentProt = null;
        Static524.aServerConnection_3.buffer.pos = 0;
        Static524.aServerConnection_3.anInt3646 = 0;
        Static524.aServerConnection_3.antepenultimateProt = null;
        Static524.aServerConnection_3.penultimateProt = null;
        Static524.aServerConnection_3.currentPacketSize = 0;
        Static249.anInt4008 = 0;
        Static524.aServerConnection_3.aServerProt_92 = null;
        Static533.method7119();
        Static605.method7914();
        for (@Pc(36) int local36 = 0; local36 < 2048; local36++) {
            PlayerList.highResolutionPlayers[local36] = null;
        }
        PlayerEntity.self = null;
        for (@Pc(49) int local49 = 0; local49 < NPCList.newNpcCount; local49++) {
            @Pc(55) NPCEntity local55 = NPCList.localNpcs[local49].npc;
            if (local55 != null) {
                local55.target = -1;
            }
        }
        Static576.method7614();
        Camera.mode = 1;
        Static693.anInt10383 = -1;
        Static692.anInt10376 = -1;
        MainLogicManager.setStep(11);
        for (@Pc(79) int local79 = 0; local79 < 100; local79++) {
            InterfaceManager.dirtyRectangles[local79] = true;
        }
        Protocol.sendWindowStatus();
        Static675.aLong307 = 0L;
        Static211.aClass2_Sub12_3 = null;
    }
}
