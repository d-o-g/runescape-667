import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static25 {

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
            if (InterfaceManager.topLevelInterface != -1) {
                InterfaceManager.closeInterface(InterfaceManager.topLevelInterface);
            }
            for (@Pc(16) SubInterface local16 = (SubInterface) InterfaceManager.subInterfaces.first(); local16 != null; local16 = (SubInterface) InterfaceManager.subInterfaces.next()) {
                if (!local16.isLinked()) {
                    local16 = (SubInterface) InterfaceManager.subInterfaces.first();
                    if (local16 == null) {
                        break;
                    }
                }
                InterfaceManager.closeSubInterface(false, true, local16);
            }
            InterfaceManager.topLevelInterface = -1;
            InterfaceManager.subInterfaces = new IterableHashTable(8);
            InterfaceList.reset();
            InterfaceManager.topLevelInterface = Static523.graphicsDefaults.lobby_interface;
            InterfaceManager.refreshTopLevelInterface(false);
            InterfaceManager.redrawAll();
            ScriptRunner.executeOnLoad(InterfaceManager.topLevelInterface);
        }
        Static461.aBoolean529 = true;
    }
}
