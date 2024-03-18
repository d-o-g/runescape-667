import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kq")
public final class Class214 {

    @OriginalMember(owner = "client!kq", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_114 = new ReferenceCache(256);

    @OriginalMember(owner = "client!kq", name = "j", descriptor = "Lclient!sb;")
    public final js5 aJs5_70;

    @OriginalMember(owner = "client!kq", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class214(@OriginalArg(0) Class377 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_70 = arg2;
        this.aJs5_70.method7608(26);
    }

    @OriginalMember(owner = "client!kq", name = "b", descriptor = "(Z)V")
    public void method5035() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_114;
        synchronized (this.aReferenceCache_114) {
            this.aReferenceCache_114.reset();
        }
    }

    @OriginalMember(owner = "client!kq", name = "b", descriptor = "(II)V")
    public void method5037() {
        @Pc(10) ReferenceCache local10 = this.aReferenceCache_114;
        synchronized (this.aReferenceCache_114) {
            this.aReferenceCache_114.clean(5);
        }
    }

    @OriginalMember(owner = "client!kq", name = "a", descriptor = "(II)Lclient!ab;")
    public DoublyLinkedNode_Sub2_Sub1 method5038(@OriginalArg(1) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_114;
        @Pc(16) DoublyLinkedNode_Sub2_Sub1 local16;
        synchronized (this.aReferenceCache_114) {
            local16 = (DoublyLinkedNode_Sub2_Sub1) this.aReferenceCache_114.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_70;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_70) {
            local39 = this.aJs5_70.method7595(arg0, 26);
        }
        local16 = new DoublyLinkedNode_Sub2_Sub1();
        if (local39 != null) {
            local16.method90(new Packet(local39));
        }
        @Pc(71) ReferenceCache local71 = this.aReferenceCache_114;
        synchronized (this.aReferenceCache_114) {
            this.aReferenceCache_114.put(local16, (long) arg0);
            return local16;
        }
    }

    @OriginalMember(owner = "client!kq", name = "a", descriptor = "(Z)V")
    public void method5040() {
        @Pc(2) ReferenceCache local2 = this.aReferenceCache_114;
        synchronized (this.aReferenceCache_114) {
            this.aReferenceCache_114.removeSoftReferences();
        }
    }
}
