import com.jagex.core.constants.ComponentClientCode;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static507 {

    @OriginalMember(owner = "client!pw", name = "C", descriptor = "[Lclient!w;")
    public static Class394[] aClass394Array1;

    @OriginalMember(owner = "client!pw", name = "l", descriptor = "Lclient!ss;")
    public static final Class345 aClass345_95 = new Class345(44, -1);

    @OriginalMember(owner = "client!pw", name = "t", descriptor = "Lclient!it;")
    public static final Class184 aClass184_14 = new Class184(10, 2, 2, 0);

    @OriginalMember(owner = "client!pw", name = "q", descriptor = "[I")
    public static final int[] anIntArray610 = new int[4096];

    @OriginalMember(owner = "client!pw", name = "a", descriptor = "(ZIIILclient!hda;)V")
    public static void method6743(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Component arg3) {
        @Pc(6) int local6 = arg3.width;
        @Pc(16) int local16 = arg3.height;
        if (arg3.sizeTypeHorizontal == 0) {
            arg3.width = arg3.baseWidth;
        } else if (arg3.sizeTypeHorizontal == 1) {
            arg3.width = arg2 - arg3.baseWidth;
        } else if (arg3.sizeTypeHorizontal == 2) {
            arg3.width = arg3.baseWidth * arg2 >> 14;
        }
        if (arg3.sizeTypeVertical == 0) {
            arg3.height = arg3.baseHeight;
        } else if (arg3.sizeTypeVertical == 1) {
            arg3.height = arg1 - arg3.baseHeight;
        } else if (arg3.sizeTypeVertical == 2) {
            arg3.height = arg1 * arg3.baseHeight >> 14;
        }
        if (arg3.sizeTypeHorizontal == 4) {
            arg3.width = arg3.anInt3795 * arg3.height / arg3.anInt3750;
        }
        if (arg3.sizeTypeVertical == 4) {
            arg3.height = arg3.width * arg3.anInt3750 / arg3.anInt3795;
        }
        if (InterfaceManager.testOpacity && (InterfaceManager.serverActiveProperties(arg3).events != 0 || arg3.type == 0)) {
            if (arg3.height < 5 && arg3.width < 5) {
                arg3.height = 5;
                arg3.width = 5;
            } else {
                if (arg3.width <= 0) {
                    arg3.width = 5;
                }
                if (arg3.height <= 0) {
                    arg3.height = 5;
                }
            }
        }
        if (ComponentClientCode.SCENE == arg3.clientcode) {
            InterfaceManager.viewport = arg3;
        }
        if (arg0 && arg3.anObjectArray19 != null && (local6 != arg3.width || local16 != arg3.height)) {
            @Pc(225) HookRequest local225 = new HookRequest();
            local225.arguments = arg3.anObjectArray19;
            local225.source = arg3;
            Static521.A_DEQUE___44.addLast(local225);
        }
    }

}
