import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static25 {

    @OriginalMember(owner = "client!as", name = "d", descriptor = "Lclient!bp;")
    public static SeqTypeList seqTypeList;

    @OriginalMember(owner = "client!as", name = "g", descriptor = "I")
    public static int anInt598;

    @OriginalMember(owner = "client!as", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___11 = new ServerProt(52, 6);

    @OriginalMember(owner = "client!as", name = "c", descriptor = "Lclient!av;")
    public static final IterableHashTable A_HASH_TABLE___4 = new IterableHashTable(32);

    @OriginalMember(owner = "client!as", name = "b", descriptor = "S")
    public static short aShort1 = 1;

    @OriginalMember(owner = "client!as", name = "a", descriptor = "(ZZ)V")
    public static void method688(@OriginalArg(0) boolean arg0) {
        if (arg0) {
            if (Static377.anInt5930 != -1) {
                Static347.method5094(Static377.anInt5930);
            }
            for (@Pc(16) SubInterface local16 = (SubInterface) InterfaceManager.subInterfaces.first(); local16 != null; local16 = (SubInterface) InterfaceManager.subInterfaces.next()) {
                if (!local16.isLinked()) {
                    local16 = (SubInterface) InterfaceManager.subInterfaces.first();
                    if (local16 == null) {
                        break;
                    }
                }
                Static449.method6115(false, true, local16);
            }
            Static377.anInt5930 = -1;
            InterfaceManager.subInterfaces = new IterableHashTable(8);
            Static656.method6692();
            Static377.anInt5930 = Static523.graphicsDefaults.lobby_interface;
            Static640.method8435(false);
            InterfaceManager.redrawAll();
            Static472.method6414(Static377.anInt5930);
        }
        Static461.aBoolean529 = true;
    }
}
