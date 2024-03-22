import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ef")
public final class FloorOverlayTypeList {

    @OriginalMember(owner = "client!ef", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_55 = new ReferenceCache(64);

    @OriginalMember(owner = "client!ef", name = "i", descriptor = "I")
    public int anInt2509 = 0;

    @OriginalMember(owner = "client!ef", name = "j", descriptor = "Lclient!sb;")
    public final js5 aJs5_23;

    @OriginalMember(owner = "client!ef", name = "q", descriptor = "I")
    public final int num;

    @OriginalMember(owner = "client!ef", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public FloorOverlayTypeList(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_23 = arg2;
        this.num = this.aJs5_23.fileLimit(4);
    }

    @OriginalMember(owner = "client!ef", name = "a", descriptor = "(B)V")
    public void method2349() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_55;
        synchronized (this.aReferenceCache_55) {
            this.aReferenceCache_55.reset();
        }
    }

    @OriginalMember(owner = "client!ef", name = "b", descriptor = "(I)V")
    public void method2351() {
        @Pc(9) ReferenceCache local9 = this.aReferenceCache_55;
        synchronized (this.aReferenceCache_55) {
            this.aReferenceCache_55.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ef", name = "a", descriptor = "(IB)Lclient!re;")
    public FloorOverlayType list(@OriginalArg(0) int arg0) {
        @Pc(15) ReferenceCache local15 = this.aReferenceCache_55;
        @Pc(25) FloorOverlayType local25;
        synchronized (this.aReferenceCache_55) {
            local25 = (FloorOverlayType) this.aReferenceCache_55.get((long) arg0);
        }
        if (local25 != null) {
            return local25;
        }
        @Pc(39) js5 local39 = this.aJs5_23;
        @Pc(48) byte[] local48;
        synchronized (this.aJs5_23) {
            local48 = this.aJs5_23.getfile(arg0, 4);
        }
        local25 = new FloorOverlayType();
        local25.aFloorOverlayTypeList_5 = this;
        local25.anInt8253 = arg0;
        if (local48 != null) {
            local25.method7256(new Packet(local48));
        }
        local25.method7254();
        @Pc(81) ReferenceCache local81 = this.aReferenceCache_55;
        synchronized (this.aReferenceCache_55) {
            this.aReferenceCache_55.put(local25, (long) arg0);
            return local25;
        }
    }

    @OriginalMember(owner = "client!ef", name = "a", descriptor = "(II)V")
    public void method2355() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_55;
        synchronized (this.aReferenceCache_55) {
            this.aReferenceCache_55.clean(5);
        }
    }
}
