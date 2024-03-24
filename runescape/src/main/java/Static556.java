import com.jagex.core.datastruct.key.HashTableIterator;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static556 {

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "Lclient!uc;")
    public static Environment aEnvironment_2;

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(BLclient!hda;)Lclient!hda;")
    public static Component method7299(@OriginalArg(1) Component arg0) {
        if (arg0.layer != -1) {
            return InterfaceList.list(arg0.layer);
        }
        @Pc(25) int local25 = arg0.slot >>> 16;
        @Pc(30) HashTableIterator local30 = new HashTableIterator(InterfaceManager.subInterfaces);
        for (@Pc(35) SubInterface local35 = (SubInterface) local30.first(); local35 != null; local35 = (SubInterface) local30.next()) {
            if (local35.id == local25) {
                return InterfaceList.list((int) local35.key);
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IB)V")
    public static void method7300(@OriginalArg(0) int arg0) {
        Static682.anIntArray817 = new int[arg0];
        Static153.anIntArray235 = new int[arg0];
        Static9.anIntArray18 = new int[arg0];
        Static482.anIntArray588 = new int[arg0];
        Static457.anIntArray552 = new int[arg0];
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(B)I")
    public static int method7302() {
        return Static449.aClass364_1.method8379();
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IBZ)Lclient!gfa;")
    public static ClientInventory method7303(@OriginalArg(0) int arg0, @OriginalArg(2) boolean arg1) {
        @Pc(19) long local19 = arg0 | (arg1 ? Integer.MIN_VALUE : 0);
        return (ClientInventory) Static286.A_HASH_TABLE___23.get(local19);
    }
}
