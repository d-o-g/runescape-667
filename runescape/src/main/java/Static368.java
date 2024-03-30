import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static368 {

    @OriginalMember(owner = "client!lka", name = "a", descriptor = "(I[BIIIB)V")
    public static void method5270(@OriginalArg(0) int arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
        if (arg0 >= arg3) {
            return;
        }
        arg2 += arg0;
        @Pc(25) int local25 = arg3 - arg0 >> 2;
        while (true) {
            local25--;
            if (local25 < 0) {
                local25 = arg3 - arg0 & 0x3;
                while (true) {
                    local25--;
                    if (local25 < 0) {
                        return;
                    }
                    arg1[arg2++] = 1;
                }
            }
            @Pc(33) int local33 = arg2 + 1;
            arg1[arg2] = 1;
            @Pc(38) int local38 = local33 + 1;
            arg1[local33] = 1;
            @Pc(43) int local43 = local38 + 1;
            arg1[local38] = 1;
            arg2 = local43 + 1;
            arg1[local43] = 1;
        }
    }

}
