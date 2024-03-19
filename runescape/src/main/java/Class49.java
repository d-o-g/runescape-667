import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bo")
public final class Class49 {

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_21 = new ReferenceCache(64);

    @OriginalMember(owner = "client!bo", name = "d", descriptor = "Lclient!sb;")
    public final js5 aJs5_10;

    @OriginalMember(owner = "client!bo", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class49(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_10 = arg2;
        if (this.aJs5_10 != null) {
            this.aJs5_10.fileLimit(11);
        }
    }

    @OriginalMember(owner = "client!bo", name = "c", descriptor = "(I)V")
    public void method1156() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_21;
        synchronized (this.aReferenceCache_21) {
            this.aReferenceCache_21.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!bo", name = "b", descriptor = "(II)V")
    public void method1158() {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_21;
        synchronized (this.aReferenceCache_21) {
            this.aReferenceCache_21.clean(5);
        }
    }

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "(I)V")
    public void method1160() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_21;
        synchronized (this.aReferenceCache_21) {
            this.aReferenceCache_21.reset();
        }
    }

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "(II)Lclient!po;")
    public ParamType list(@OriginalArg(0) int arg0) {
        @Pc(13) ReferenceCache local13 = this.aReferenceCache_21;
        @Pc(23) ParamType local23;
        synchronized (this.aReferenceCache_21) {
            local23 = (ParamType) this.aReferenceCache_21.get((long) arg0);
        }
        if (local23 != null) {
            return local23;
        }
        @Pc(37) js5 local37 = this.aJs5_10;
        @Pc(46) byte[] local46;
        synchronized (this.aJs5_10) {
            local46 = this.aJs5_10.getfile(arg0, 11);
        }
        local23 = new ParamType();
        if (local46 != null) {
            local23.method6673(new Packet(local46));
        }
        @Pc(70) ReferenceCache local70 = this.aReferenceCache_21;
        synchronized (this.aReferenceCache_21) {
            this.aReferenceCache_21.put(local23, (long) arg0);
            return local23;
        }
    }
}
