import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ida")
public final class Class176 {

    @OriginalMember(owner = "client!ida", name = "a", descriptor = "Lclient!sb;")
    public final js5 aJs5_57;

    @OriginalMember(owner = "client!ida", name = "d", descriptor = "I")
    public final int anInt4266;

    @OriginalMember(owner = "client!ida", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class176(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        new ReferenceCache(64);
        this.aJs5_57 = arg2;
        this.anInt4266 = this.aJs5_57.fileLimit(15);
    }
}
