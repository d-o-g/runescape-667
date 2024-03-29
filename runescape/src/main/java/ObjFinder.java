import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ObjFinder {

    @OriginalMember(owner = "client!tc", name = "k", descriptor = "I")
    public static int resultCount;

    @OriginalMember(owner = "client!hu", name = "n", descriptor = "[S")
    public static short[] results;

    @OriginalMember(owner = "client!eia", name = "A", descriptor = "I")
    public static int pointer;

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "(ZLjava/lang/String;B)V")
    public static void find(@OriginalArg(0) boolean arg0, @OriginalArg(1) String arg1) {
        findIntParam(arg0, -1, -1, arg1);
    }

    @OriginalMember(owner = "client!ida", name = "a", descriptor = "(ZIIILjava/lang/String;)V")
    public static void findIntParam(@OriginalArg(0) boolean arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) String arg3) {
        method4538(false, arg0, arg1, arg2, arg3, null);
    }

    @OriginalMember(owner = "client!js", name = "a", descriptor = "(ZBZIILjava/lang/String;Ljava/lang/String;)V")
    public static void method4538(@OriginalArg(0) boolean arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) String arg4, @OriginalArg(6) String arg5) {
        js5.CONFIG_OBJ.discardunpacked = 1;
        @Pc(9) String local9 = arg4.toLowerCase();
        @Pc(12) short[] local12 = new short[16];
        @Pc(14) int local14 = -1;
        @Pc(16) String local16 = null;
        if (arg3 != -1) {
            @Pc(25) ParamType local25 = ParamTypeList.instance.list(arg3);
            if (local25 == null || local25.isString() != arg0) {
                return;
            }
            if (local25.isString()) {
                local16 = local25.defaultstr;
            } else {
                local14 = local25.defaultint;
            }
        }
        @Pc(54) int local54 = 0;
        for (@Pc(56) int local56 = 0; local56 < ObjTypeList.instance.num; local56++) {
            @Pc(62) ObjType local62 = ObjTypeList.instance.list(local56);
            if ((!arg1 || local62.stockmarket) && local62.certtemplate == -1 && local62.lenttemplate == -1 && local62.boughttemplate == -1 && local62.dummyitem == 0 && local62.name.toLowerCase().indexOf(local9) != -1) {
                if (arg3 != -1) {
                    if (arg0) {
                        if (!arg5.equals(local62.param(local16, arg3))) {
                            continue;
                        }
                    } else if (arg2 != local62.param(arg3, local14)) {
                        continue;
                    }
                }
                if (local54 >= 250) {
                    results = null;
                    resultCount = -1;
                    return;
                }
                if (local12.length <= local54) {
                    @Pc(164) short[] local164 = new short[local12.length * 2];
                    for (@Pc(166) int local166 = 0; local166 < local54; local166++) {
                        local164[local166] = local12[local166];
                    }
                    local12 = local164;
                }
                local12[local54++] = (short) local56;
            }
        }
        resultCount = local54;
        pointer = 0;
        results = local12;
        @Pc(203) String[] local203 = new String[resultCount];
        for (@Pc(205) int local205 = 0; local205 < resultCount; local205++) {
            local203[local205] = ObjTypeList.instance.list(local12[local205]).name;
        }
        quicksort(local203, results);
        js5.CONFIG_OBJ.discardUnpacked();
        js5.CONFIG_OBJ.discardunpacked = 2;
    }

    @OriginalMember(owner = "client!rha", name = "a", descriptor = "([Ljava/lang/String;[SI)V")
    public static void quicksort(@OriginalArg(0) String[] arg0, @OriginalArg(1) short[] arg1) {
        quicksort(arg0.length - 1, arg1, 0, arg0);
    }

    @OriginalMember(owner = "client!nea", name = "a", descriptor = "(I[SI[Ljava/lang/String;I)V")
    public static void quicksort(@OriginalArg(0) int arg0, @OriginalArg(1) short[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) String[] arg3) {
        if (arg2 >= arg0) {
            return;
        }
        @Pc(12) int local12 = (arg0 + arg2) / 2;
        @Pc(14) int local14 = arg2;
        @Pc(18) String local18 = arg3[local12];
        arg3[local12] = arg3[arg0];
        arg3[arg0] = local18;
        @Pc(32) short local32 = arg1[local12];
        arg1[local12] = arg1[arg0];
        arg1[arg0] = local32;
        for (@Pc(44) int local44 = arg2; local44 < arg0; local44++) {
            if (local18 == null || arg3[local44] != null && arg3[local44].compareTo(local18) < (local44 & 0x1)) {
                @Pc(68) String local68 = arg3[local44];
                arg3[local44] = arg3[local14];
                arg3[local14] = local68;
                @Pc(82) short local82 = arg1[local44];
                arg1[local44] = arg1[local14];
                arg1[local14++] = local82;
            }
        }
        arg3[arg0] = arg3[local14];
        arg3[local14] = local18;
        arg1[arg0] = arg1[local14];
        arg1[local14] = local32;
        quicksort(local14 - 1, arg1, arg2, arg3);
        quicksort(arg0, arg1, local14 + 1, arg3);
    }

    private ObjFinder() {
        /* empty */
    }

    @OriginalMember(owner = "client!wla", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;IZ)V")
    public static void findStringParam(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4) {
        method4538(true, arg4, -1, arg1, arg0, arg2);
        if (arg3 != 8) {
            findStringParam(null, 91, null, -101, true);
        }
    }
}
