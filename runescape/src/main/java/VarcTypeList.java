import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kka")
public final class VarcTypeList {

    @OriginalMember(owner = "client!vs", name = "t", descriptor = "Lclient!kka;")
    public static VarcTypeList instance;

    @OriginalMember(owner = "client!kka", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_112 = new ReferenceCache(64);

    @OriginalMember(owner = "client!kka", name = "a", descriptor = "Lclient!sb;")
    public final js5 aJs5_67;

    @OriginalMember(owner = "client!kka", name = "f", descriptor = "I")
    public final int anInt5473;

    @OriginalMember(owner = "client!kka", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarcTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_67 = arg2;
        this.anInt5473 = this.aJs5_67.fileLimit(19);
    }

    @OriginalMember(owner = "client!kka", name = "a", descriptor = "(II)Lclient!paa;")
    public Class284 list(@OriginalArg(0) int id) {
        @Pc(12) ReferenceCache local12 = this.aReferenceCache_112;
        @Pc(22) Class284 local22;
        synchronized (this.aReferenceCache_112) {
            local22 = (Class284) this.aReferenceCache_112.get((long) id);
        }
        if (local22 != null) {
            return local22;
        }
        @Pc(36) js5 local36 = this.aJs5_67;
        @Pc(45) byte[] local45;
        synchronized (this.aJs5_67) {
            local45 = this.aJs5_67.getfile(id, 19);
        }
        local22 = new Class284();
        if (local45 != null) {
            local22.method6449(new Packet(local45));
        }
        @Pc(69) ReferenceCache local69 = this.aReferenceCache_112;
        synchronized (this.aReferenceCache_112) {
            this.aReferenceCache_112.put(local22, (long) id);
            return local22;
        }
    }
}
