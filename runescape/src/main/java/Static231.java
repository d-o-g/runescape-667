import com.jagex.core.stringtools.general.NameTools;
import com.jagex.game.LocalisedText;
import com.jagex.graphics.Toolkit;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static231 {

    @OriginalMember(owner = "client!hd", name = "t", descriptor = "I")
    public static int anInt3734;

    @OriginalMember(owner = "client!hd", name = "u", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_1 = new Class157(0, 3, Static702.aClass397_20);

    @OriginalMember(owner = "client!hd", name = "f", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_2 = new Class157(1, 3, Static702.aClass397_20);

    @OriginalMember(owner = "client!hd", name = "b", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_3 = new Class157(2, 4, Static702.aClass397_16);

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_4 = new Class157(3, 1, Static702.aClass397_20);

    @OriginalMember(owner = "client!hd", name = "v", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_5 = new Class157(4, 2, Static702.aClass397_20);

    @OriginalMember(owner = "client!hd", name = "d", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_6 = new Class157(5, 3, Static702.aClass397_20);

    @OriginalMember(owner = "client!hd", name = "l", descriptor = "Lclient!hd;")
    public static final Class157 aClass157_7 = new Class157(6, 4, Static702.aClass397_20);

    @OriginalMember(owner = "client!hd", name = "c", descriptor = "I")
    public static final int anInt3733 = IntMath.countBits(16);

    @OriginalMember(owner = "client!hd", name = "e", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___41 = new ClientProt(34, 4);

    @OriginalMember(owner = "client!hd", name = "m", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___102 = new ServerProt(34, 6);

    @OriginalMember(owner = "client!hd", name = "b", descriptor = "(I)V")
    public static void method3375() {
        if (Toolkit.active == null) {
            return;
        }
        if (InterfaceManager.aBoolean210) {
            Static164.method2606();
        }
        Static514.aClass213_2.method5010();
        Static563.method7461();
        Minimap.reset();
        Static329.method1649();
        Static638.method8393();
        Static65.method1472();
        Static81.method1589();
        Static352.cacheReset();
        Static203.resetStaticSprites();
        Static143.method3572();
        Static668.method8700(false);
        for (@Pc(34) int local34 = 0; local34 < 2048; local34++) {
            @Pc(39) PlayerEntity local39 = PlayerList.highResolutionPlayers[local34];
            if (local39 != null) {
                for (@Pc(43) int local43 = 0; local43 < local39.aModelArray3.length; local43++) {
                    local39.aModelArray3[local43] = null;
                }
            }
        }
        for (@Pc(65) int local65 = 0; local65 < NPCList.newNpcCount; local65++) {
            @Pc(71) NPCEntity local71 = NPCList.localNpcs[local65].npc;
            if (local71 != null) {
                for (@Pc(75) int local75 = 0; local75 < local71.aModelArray3.length; local75++) {
                    local71.aModelArray3[local75] = null;
                }
            }
        }
        Static59.aMatrix_5 = null;
        Static460.aMatrix_10 = null;
        Toolkit.active.free();
        Toolkit.active = null;
    }

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "(II)Lclient!hd;")
    public static Class157 method3377(@OriginalArg(0) int arg0) {
        if (arg0 == 0) {
            return aClass157_1;
        } else if (arg0 == 1) {
            return aClass157_2;
        } else if (arg0 == 2) {
            return aClass157_3;
        } else if (arg0 == 3) {
            return aClass157_4;
        } else if (arg0 == 4) {
            return aClass157_5;
        } else if (arg0 == 5) {
            return aClass157_6;
        } else if (arg0 == 6) {
            return aClass157_7;
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "(ILjava/lang/String;)I")
    public static int method3379(@OriginalArg(1) String arg0) {
        return arg0.length() + 1;
    }

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "(ZLjava/lang/String;B)V")
    public static void method3382(@OriginalArg(0) boolean arg0, @OriginalArg(1) String arg1) {
        if (arg1 == null) {
            return;
        }
        if (Static436.anInt3849 >= 100) {
            ChatHistory.addPrivateError(LocalisedText.IGNORELISTFULL.localise(client.language));
            return;
        }
        @Pc(27) String local27 = NameTools.format(arg1);
        if (local27 == null) {
            return;
        }

        @Pc(76) String local76;
        for (@Pc(33) int local33 = 0; local33 < Static436.anInt3849; local33++) {
            @Pc(40) String local40 = NameTools.format(Static632.aStringArray44[local33]);
            if (local40 != null && local40.equals(local27)) {
                ChatHistory.addPrivateError(arg1 + LocalisedText.IGNORELISTDUPE.localise(client.language));
                return;
            }
            if (Static10.aStringArray1[local33] != null) {
                local76 = NameTools.format(Static10.aStringArray1[local33]);
                if (local76 != null && local76.equals(local27)) {
                    ChatHistory.addPrivateError(arg1 + LocalisedText.IGNORELISTDUPE.localise(client.language));
                    return;
                }
            }
        }
        for (@Pc(106) int local106 = 0; local106 < Static327.anInt5392; local106++) {
            local76 = NameTools.format(Static330.aStringArray25[local106]);
            if (local76 != null && local76.equals(local27)) {
                ChatHistory.addPrivateError(LocalisedText.REMOVEFRIEND1.localise(client.language) + arg1 + LocalisedText.REMOVEFRIEND2.localise(client.language));
                return;
            }
            if (Static572.aStringArray42[local106] != null) {
                @Pc(154) String local154 = NameTools.format(Static572.aStringArray42[local106]);
                if (local154 != null && local154.equals(local27)) {
                    ChatHistory.addPrivateError(LocalisedText.REMOVEFRIEND1.localise(client.language) + arg1 + LocalisedText.REMOVEFRIEND2.localise(client.language));
                    return;
                }
            }
        }
        if (NameTools.format(PlayerEntity.self.accountName).equals(local27)) {
            ChatHistory.addPrivateError(LocalisedText.IGNORECANTADDSELF.localise(client.language));
            return;
        }
        @Pc(216) ServerConnection local216 = ConnectionManager.active();
        @Pc(222) ClientMessage local222 = ClientMessage.create(Static113.A_CLIENT_PROT___22, local216.cipher);
        local222.bitPacket.p1(method3379(arg1) + 1);
        local222.bitPacket.pjstr(arg1);
        local222.bitPacket.p1(arg0 ? 1 : 0);
        local216.send(local222);
    }
}
