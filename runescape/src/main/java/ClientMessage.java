import com.jagex.core.crypto.Isaac;
import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fk")
public final class ClientMessage extends Node {

    @OriginalMember(owner = "client!fk", name = "m", descriptor = "Lclient!ss;")
    public ClientProt aClientProt_32;

    @OriginalMember(owner = "client!fk", name = "q", descriptor = "I")
    public int anInt2986;

    @OriginalMember(owner = "client!fk", name = "s", descriptor = "Lclient!rka;")
    public BitPacket bitPacket;

    @OriginalMember(owner = "client!fk", name = "r", descriptor = "I")
    public int totalSize;

    @OriginalMember(owner = "client!jfa", name = "a", descriptor = "(ILclient!ss;Lclient!iv;)Lclient!fk;")
    public static ClientMessage create(@OriginalArg(1) ClientProt arg0, @OriginalArg(2) Isaac arg1) {
        @Pc(6) ClientMessage local6 = Static119.method2174();
        local6.anInt2986 = arg0.length;
        local6.aClientProt_32 = arg0;
        if (local6.anInt2986 == -1) {
            local6.bitPacket = new BitPacket(260);
        } else if (local6.anInt2986 == -2) {
            local6.bitPacket = new BitPacket(10000);
        } else if (local6.anInt2986 <= 18) {
            local6.bitPacket = new BitPacket(20);
        } else if (local6.anInt2986 <= 98) {
            local6.bitPacket = new BitPacket(100);
        } else {
            local6.bitPacket = new BitPacket(260);
        }
        local6.bitPacket.setIsaac(arg1);
        local6.bitPacket.startPacket(local6.aClientProt_32.getOpcode());
        local6.totalSize = 0;
        return local6;
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IIILclient!fk;I)V")
    public static void addComponentData(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) ClientMessage arg2, @OriginalArg(4) int arg3) {
        arg2.bitPacket.p4_alt3(arg0);
        arg2.bitPacket.p2_alt3(arg1);
        arg2.bitPacket.p2(arg3);
    }

    @OriginalMember(owner = "client!fk", name = "a", descriptor = "(Z)V")
    public void method2768() {
        if (Static76.anInt1604 < Static372.aClass2_Sub19Array1.length) {
            Static372.aClass2_Sub19Array1[Static76.anInt1604++] = this;
        }
    }
}
