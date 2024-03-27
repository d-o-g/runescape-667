import com.jagex.ClientProt;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannelUser;

public final class Static180 {

    @OriginalMember(owner = "client!fka", name = "o", descriptor = "Lclient!wk;")
    public static HorizontalAlignment aHorizontalAlignment_3;

    @OriginalMember(owner = "client!fka", name = "q", descriptor = "I")
    public static int anInt2995 = 0;

    @OriginalMember(owner = "client!fka", name = "n", descriptor = "J")
    public static long aLong108 = -1L;

    @OriginalMember(owner = "client!fka", name = "g", descriptor = "I")
    public static int anInt3001 = -1;

    @OriginalMember(owner = "client!fka", name = "a", descriptor = "(II)V")
    public static void method2775(@OriginalArg(1) int arg0) {
        if (Static45.aClass2_Sub47_1 == null || (arg0 < 0 || arg0 >= Static45.aClass2_Sub47_1.userCount)) {
            return;
        }
        @Pc(29) ClanChannelUser local29 = Static45.aClass2_Sub47_1.users[arg0];
        if (local29.rank != -1) {
            return;
        }
        @Pc(45) ServerConnection local45 = ConnectionManager.active();
        @Pc(53) ClientMessage local53 = ClientMessage.create(ClientProt.AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL, local45.cipher);
        local53.bitPacket.p1(Static231.method3379(local29.displayName) + 2);
        local53.bitPacket.p2(arg0);
        local53.bitPacket.pjstr(local29.displayName);
        local45.send(local53);
    }

    @OriginalMember(owner = "client!fka", name = "a", descriptor = "(IIBIII)V")
    public static void method2776(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        if (arg0 == arg3) {
            Static142.method2379(arg2, arg1, arg4, arg3);
        } else if (arg4 - arg3 >= anInt2995 && arg3 + arg4 <= Static111.anInt2219 && Static724.anInt10930 <= arg2 - arg0 && Static273.anInt4395 >= arg2 + arg0) {
            Static211.method5000(arg2, arg0, arg3, arg1, arg4);
        } else {
            Static619.method1508(arg2, arg3, arg0, arg4, arg1);
        }
    }
}
