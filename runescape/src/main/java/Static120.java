import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Calendar;

public final class Static120 {

    @OriginalMember(owner = "client!dn", name = "a", descriptor = "(IIILjava/lang/String;I)V")
    public static void method2193(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) String arg2, @OriginalArg(4) int arg3) {
        @Pc(8) Component local8 = Static15.method186(arg1, arg0);
        if (local8 == null) {
            return;
        }
        if (local8.onOp != null) {
            @Pc(19) Node_Sub42 local19 = new Node_Sub42();
            local19.anObjectArray36 = local8.onOp;
            local19.anInt7219 = arg3;
            local19.aString84 = arg2;
            local19.aComponent_14 = local8;
            Static472.method6420(local19);
        }
        if (MainLogicManager.step != 11 || !InterfaceManager.serverActiveProperties(local8).isOpEnabled(arg3 - 1)) {
            return;
        }
        @Pc(64) ClientMessage local64;
        if (arg3 == 1) {
            local64 = Static293.method4335(Static546.aClass345_98, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local64, arg1);
            ConnectionManager.GAME.send(local64);
        }
        if (arg3 == 2) {
            local64 = Static293.method4335(Static323.aClass345_65, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local64, arg1);
            ConnectionManager.GAME.send(local64);
        }
        if (arg3 == 3) {
            local64 = Static293.method4335(Static255.aClass345_54, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local64, arg1);
            ConnectionManager.GAME.send(local64);
        }
        @Pc(148) ClientMessage local148;
        if (arg3 == 4) {
            local148 = Static293.method4335(Static710.aClass345_93, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
        if (arg3 == 5) {
            local148 = Static293.method4335(Static693.aClass345_121, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
        if (arg3 == 6) {
            local148 = Static293.method4335(Static126.aClass345_23, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
        if (arg3 == 7) {
            local148 = Static293.method4335(Static358.aClass345_124, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
        if (arg3 == 8) {
            local148 = Static293.method4335(Static700.aClass345_123, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
        if (arg3 == 9) {
            local148 = Static293.method4335(Static372.aClass345_69, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
        if (arg3 == 10) {
            local148 = Static293.method4335(Static713.aClass345_125, ConnectionManager.GAME.cipher);
            Static277.method4040(arg0, local8.invObject, local148, arg1);
            ConnectionManager.GAME.send(local148);
        }
    }

    @OriginalMember(owner = "client!dn", name = "a", descriptor = "(ZIJI)Ljava/lang/String;")
    public static String method2198(@OriginalArg(2) long arg0, @OriginalArg(3) int arg1) {
        Static356.method5196(arg0);
        @Pc(10) Calendar local10 = Static260.aCalendar1;
        @Pc(20) int local20 = local10.get(5);
        @Pc(26) int local26 = local10.get(2) + 1;
        @Pc(38) int local38 = local10.get(1);
        @Pc(42) int local42 = local10.get(11);
        @Pc(46) int local46 = local10.get(12);
        return Integer.toString(local20 / 10) + local20 % 10 + "/" + local26 / 10 + local26 % 10 + "/" + local38 % 100 / 10 + local38 % 10 + " " + local42 / 10 + local42 % 10 + ":" + local46 / 10 + local46 % 10;
    }
}
