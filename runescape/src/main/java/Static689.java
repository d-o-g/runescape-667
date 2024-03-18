import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.File;

public final class Static689 {

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "s", descriptor = "Ljava/lang/Class;")
    public static Class aClass24;

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "p", descriptor = "Ljava/lang/Class;")
    public static Class aClass25;

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "g", descriptor = "Ljava/lang/Class;")
    public static Class aClass26;

    // $FF: synthetic field
    @OriginalMember(owner = "client!vq", name = "d", descriptor = "Ljava/lang/Class;")
    public static Class aClass27;

    @OriginalMember(owner = "client!vq", name = "t", descriptor = "J")
    public static volatile long aLong317 = 0L;

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;I)Lclient!dm;")
    public static FileOnDisk method8980(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2) {
        @Pc(29) String local29;
        if (arg1 == 33) {
            local29 = "jagex_" + arg0 + "_preferences" + arg2 + "_rc.dat";
        } else if (arg1 == 34) {
            local29 = "jagex_" + arg0 + "_preferences" + arg2 + "_wip.dat";
        } else {
            local29 = "jagex_" + arg0 + "_preferences" + arg2 + ".dat";
        }
        @Pc(121) String[] local121 = new String[]{"c:/rscache/", "/rscache/", SignLink.homeDir, "c:/windows/", "c:/winnt/", "c:/", "/tmp/", ""};
        for (@Pc(123) int local123 = 0; local123 < local121.length; local123++) {
            @Pc(128) String local128 = local121[local123];
            if (local128.length() <= 0 || (new File(local128)).exists()) {
                try {
                    return new FileOnDisk(new File(local128, local29), "rw", 10000L);
                } catch (@Pc(158) Exception local158) {
                }
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!vq", name = "a", descriptor = "(ILjava/lang/String;)Lclient!dm;")
    public static FileOnDisk method8983(@OriginalArg(1) String arg0) {
        return method8980(SignLink.game, SignLink.storeId, arg0);
    }
}
