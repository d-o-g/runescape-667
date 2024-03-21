import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static372 {

    @OriginalMember(owner = "client!ln", name = "m", descriptor = "Lclient!ss;")
    public static final Class345 aClass345_69 = new Class345(20, 8);

    @OriginalMember(owner = "client!ln", name = "l", descriptor = "[Lclient!fk;")
    public static final ClientMessage[] aClass2_Sub19Array1 = new ClientMessage[300];

    @OriginalMember(owner = "client!ln", name = "a", descriptor = "(III)I")
    public static int method5290(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return arg1 == 1 || arg1 == 3 ? Static60.anIntArray111[arg0 & 0x3] : Static353.anIntArray748[arg0 & 0x3];
    }

    @OriginalMember(owner = "client!ln", name = "a", descriptor = "(ILclient!hda;I)I")
    public static int method5292(@OriginalArg(0) int arg0, @OriginalArg(1) Component arg1) {
        if (!Static84.method1661(arg1).isOpEnabled(arg0) && arg1.onOp == null) {
            return -1;
        } else if (arg1.opCursors == null || arg0 >= arg1.opCursors.length) {
            return -1;
        } else {
            return arg1.opCursors[arg0];
        }
    }
}
