import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static470 {

    @OriginalMember(owner = "client!or", name = "F", descriptor = "Lclient!pg;")
    public static DoublyLinkedNode_Sub2_Sub16 aClass2_Sub2_Sub16_10;

    @OriginalMember(owner = "client!or", name = "J", descriptor = "S")
    public static short aShort82;

    @OriginalMember(owner = "client!or", name = "H", descriptor = "Lclient!ss;")
    public static final Class345 aClass345_88 = new Class345(19, 3);

    @OriginalMember(owner = "client!or", name = "P", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_32 = new Class155(50);

    @OriginalMember(owner = "client!or", name = "Y", descriptor = "I")
    public static int anInt7112 = -1;

    @OriginalMember(owner = "client!or", name = "Z", descriptor = "I")
    public static int anInt7113 = -1;

    @OriginalMember(owner = "client!or", name = "a", descriptor = "(Lclient!hda;III)V")
    public static void method6383(@OriginalArg(0) Component arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        if (arg0.postTypeVertical == 0) {
            arg0.anInt3784 = arg0.basePosY;
        } else if (arg0.postTypeVertical == 1) {
            arg0.anInt3784 = arg0.basePosY + (arg2 - arg0.anInt3746) / 2;
        } else if (arg0.postTypeVertical == 2) {
            arg0.anInt3784 = arg2 - arg0.anInt3746 - arg0.basePosY;
        } else if (arg0.postTypeVertical == 3) {
            arg0.anInt3784 = arg0.basePosY * arg2 >> 14;
        } else if (arg0.postTypeVertical == 4) {
            arg0.anInt3784 = (arg2 - arg0.anInt3746) / 2 + (arg2 * arg0.basePosY >> 14);
        } else {
            arg0.anInt3784 = arg2 - (arg0.basePosY * arg2 >> 14) - arg0.anInt3746;
        }
        if (arg0.posTypeHorizontal == 0) {
            arg0.anInt3735 = arg0.basePosX;
        } else if (arg0.posTypeHorizontal == 1) {
            arg0.anInt3735 = arg0.basePosX + (arg1 - arg0.anInt3802) / 2;
        } else if (arg0.posTypeHorizontal == 2) {
            arg0.anInt3735 = arg1 - arg0.anInt3802 - arg0.basePosX;
        } else if (arg0.posTypeHorizontal == 3) {
            arg0.anInt3735 = arg0.basePosX * arg1 >> 14;
        } else if (arg0.posTypeHorizontal == 4) {
            arg0.anInt3735 = (arg1 - arg0.anInt3802) / 2 + (arg1 * arg0.basePosX >> 14);
        } else {
            arg0.anInt3735 = arg1 - (arg1 * arg0.basePosX >> 14) - arg0.anInt3802;
        }
        if (!Static103.aBoolean195) {
            return;
        }
        if (Static84.method1661(arg0).anInt6909 == 0 && arg0.type != 0) {
            return;
        }
        if (arg0.anInt3735 < 0) {
            arg0.anInt3735 = 0;
        } else if (arg1 < arg0.anInt3802 + arg0.anInt3735) {
            arg0.anInt3735 = arg1 - arg0.anInt3802;
        }
        if (arg0.anInt3784 < 0) {
            arg0.anInt3784 = 0;
            return;
        }
        if (arg0.anInt3784 + arg0.anInt3746 > arg2) {
            arg0.anInt3784 = arg2 - arg0.anInt3746;
            return;
        }
    }

    @OriginalMember(owner = "client!or", name = "h", descriptor = "(I)V")
    public static void method6384() {
        if (!Static156.aBoolean223) {
            return;
        }
        @Pc(14) Component local14 = Static15.method186(Static77.anInt1614, Static450.anInt6819);
        if (local14 != null && local14.onTargetLeave != null) {
            @Pc(25) Node_Sub42 local25 = new Node_Sub42();
            local25.anObjectArray36 = local14.onTargetLeave;
            local25.aComponent_14 = local14;
            Static472.method6420(local25);
        }
        Static442.anInt6699 = -1;
        Static156.aBoolean223 = false;
        Static162.anInt2799 = -1;
        if (local14 != null) {
            InterfaceManager.redraw(local14);
        }
    }

    @OriginalMember(owner = "client!or", name = "d", descriptor = "(B)V")
    public static void method6386() {
        if (!Static15.aBoolean17) {
            Static552.aFloat207 += (-Static552.aFloat207 - 24.0F) / 2.0F;
            Static15.aBoolean17 = true;
            Static273.aBoolean339 = true;
        }
    }

    @OriginalMember(owner = "client!or", name = "a", descriptor = "(Z)Z")
    public static boolean method6387() {
        if (Static283.step == 3) {
            return Static135.anInt8223 == 0 && Static6.anInt95 == 0;
        } else {
            return false;
        }
    }
}
