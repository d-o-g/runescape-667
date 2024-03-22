import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static389 {

    @OriginalMember(owner = "client!md", name = "F", descriptor = "Lclient!lga;")
    public static ServerProt aServerProt_157 = new ServerProt(121, 6);

    @OriginalMember(owner = "client!md", name = "K", descriptor = "Z")
    public static boolean aBoolean459 = false;

    @OriginalMember(owner = "client!md", name = "G", descriptor = "Ljava/lang/String;")
    public static String aString64 = null;

    @OriginalMember(owner = "client!md", name = "a", descriptor = "(IBLclient!hda;I)V")
    public static void method5476(@OriginalArg(0) int arg0, @OriginalArg(2) Component arg1, @OriginalArg(3) int arg2) {
        if (arg1 == null) {
            return;
        }
        if (arg1.onTargetEnter != null) {
            @Pc(14) Node_Sub42 local14 = new Node_Sub42();
            local14.aComponent_14 = arg1;
            local14.anObjectArray36 = arg1.onTargetEnter;
            Static472.method6420(local14);
        }
        Static162.anInt2799 = arg1.invObject;
        Static450.anInt6819 = arg1.slot;
        Static156.aBoolean223 = true;
        Static610.anInt9329 = arg2;
        Static369.anInt4263 = arg1.targetEnterCursor;
        Static77.anInt1614 = arg1.id;
        Static442.anInt6699 = arg1.targetEndCursor;
        Static717.anInt10822 = arg0;
        InterfaceManager.redraw(arg1);
    }
}
