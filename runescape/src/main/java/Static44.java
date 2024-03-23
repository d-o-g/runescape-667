import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static44 {

    @OriginalMember(owner = "client!bia", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;I)V")
    public static void method1072(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(3) int arg2, @OriginalArg(4) String arg3, @OriginalArg(5) String arg4, @OriginalArg(6) int arg5) {
        Static662.method8625(arg4, arg1, -1, arg0, null, arg2, arg3, arg5);
    }

    @OriginalMember(owner = "client!bia", name = "a", descriptor = "(ILclient!hda;)V")
    public static void method1073(@OriginalArg(1) Component arg0) {
        @Pc(7) Component local7 = Static556.method7299(arg0);
        @Pc(24) int local24;
        @Pc(27) int local27;
        if (local7 == null) {
            local27 = GameShell.canvasHei;
            local24 = GameShell.canvasWid;
        } else {
            local24 = local7.width;
            local27 = local7.height;
        }
        InterfaceManager.resize(false, local27, local24, arg0);
        InterfaceManager.calculateDimensions(arg0, local24, local27, -8525);
    }

}
