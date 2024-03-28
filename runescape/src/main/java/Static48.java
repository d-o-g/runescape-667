import com.jagex.Entity;
import com.jagex.sound.MixBuss;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static48 {

    @OriginalMember(owner = "client!bka", name = "i", descriptor = "[Lclient!eo;")
    public static Entity[] aEntityArray3;

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "(Lclient!bd;I)Lclient!bd;")
    public static MixBuss method1100(@OriginalArg(0) MixBuss arg0) {
        @Pc(15) MixBuss local15 = arg0 == null ? new MixBuss() : new MixBuss(arg0);
        local15.method929();
        return local15;
    }
}
