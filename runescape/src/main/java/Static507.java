import com.jagex.core.constants.ClientComponent;
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
        @Pc(6) int local6 = arg3.anInt3802;
        @Pc(16) int local16 = arg3.anInt3746;
        if (arg3.sizeTypeHorizontal == 0) {
            arg3.anInt3802 = arg3.baseWidth;
        } else if (arg3.sizeTypeHorizontal == 1) {
            arg3.anInt3802 = arg2 - arg3.baseWidth;
        } else if (arg3.sizeTypeHorizontal == 2) {
            arg3.anInt3802 = arg3.baseWidth * arg2 >> 14;
        }
        if (arg3.sizeTypeVertical == 0) {
            arg3.anInt3746 = arg3.baseHeight;
        } else if (arg3.sizeTypeVertical == 1) {
            arg3.anInt3746 = arg1 - arg3.baseHeight;
        } else if (arg3.sizeTypeVertical == 2) {
            arg3.anInt3746 = arg1 * arg3.baseHeight >> 14;
        }
        if (arg3.sizeTypeHorizontal == 4) {
            arg3.anInt3802 = arg3.anInt3795 * arg3.anInt3746 / arg3.anInt3750;
        }
        if (arg3.sizeTypeVertical == 4) {
            arg3.anInt3746 = arg3.anInt3802 * arg3.anInt3750 / arg3.anInt3795;
        }
        if (Static103.aBoolean195 && (Static84.method1661(arg3).events != 0 || arg3.type == 0)) {
            if (arg3.anInt3746 < 5 && arg3.anInt3802 < 5) {
                arg3.anInt3746 = 5;
                arg3.anInt3802 = 5;
            } else {
                if (arg3.anInt3802 <= 0) {
                    arg3.anInt3802 = 5;
                }
                if (arg3.anInt3746 <= 0) {
                    arg3.anInt3746 = 5;
                }
            }
        }
        if (ClientComponent.SCENE == arg3.clientComponent) {
            Static610.aComponent_16 = arg3;
        }
        if (arg0 && arg3.anObjectArray19 != null && (local6 != arg3.anInt3802 || local16 != arg3.anInt3746)) {
            @Pc(225) Node_Sub42 local225 = new Node_Sub42();
            local225.anObjectArray36 = arg3.anObjectArray19;
            local225.aComponent_14 = arg3;
            Static521.A_DEQUE___44.addLast(local225);
        }
    }

    @OriginalMember(owner = "client!pw", name = "c", descriptor = "(Z)V")
    public static void method6744() {
        for (@Pc(15) Node_Sub5 local15 = (Node_Sub5) Static106.A_HASH_TABLE___11.first(); local15 != null; local15 = (Node_Sub5) Static106.A_HASH_TABLE___11.next()) {
            if (local15.aBoolean18) {
                local15.aBoolean18 = false;
            } else {
                Static121.method2199(local15.anInt182);
            }
        }
    }
}
