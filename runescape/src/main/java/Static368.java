import com.jagex.core.datastruct.key.Deque;
import com.jagex.graphics.Toolkit;
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

    @OriginalMember(owner = "client!lka", name = "a", descriptor = "(ILclient!sia;ILclient!ha;I)V")
    public static void method5272(@OriginalArg(1) Deque arg0, @OriginalArg(3) Toolkit arg1) {
        WorldMap.aDeque_54.clear();
        if (Static178.aBoolean251) {
            return;
        }
        for (@Pc(27) MapElementListEntry local27 = (MapElementListEntry) arg0.first(); local27 != null; local27 = (MapElementListEntry) arg0.next()) {
            @Pc(35) MapElementType local35 = WorldMap.mapElementTypeList.list(local27.id);
            if (Static408.method5634(local35)) {
                @Pc(47) boolean local47 = Static351.method5138(arg1, local35, local27);
                if (local47) {
                    Static603.method7902(local27, arg1, local35);
                }
            }
        }
    }

    @OriginalMember(owner = "client!lka", name = "b", descriptor = "(B)V")
    public static void method5273() {
        Static33.anInt779 = 0;
        Static409.aClass104Array1 = new Class104[50];
    }
}
