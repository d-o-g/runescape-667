import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sfa")
public final class Class335 {

    @OriginalMember(owner = "client!sfa", name = "c", descriptor = "Lclient!dla;")
    public final ReferenceCache aReferenceCache_188 = new ReferenceCache(64);

    @OriginalMember(owner = "client!sfa", name = "b", descriptor = "Lclient!sb;")
    public final js5 aJs5_107;

    @OriginalMember(owner = "client!sfa", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public Class335(@OriginalArg(0) ModeGame arg0, @OriginalArg(1) int arg1, @OriginalArg(2) js5 arg2) {
        this.aJs5_107 = arg2;
        this.aJs5_107.fileLimit(5);
    }

    @OriginalMember(owner = "client!sfa", name = "a", descriptor = "(II)Lclient!dba;")
    public DoublyLinkedNode_Sub2_Sub6 method7657(@OriginalArg(0) int arg0) {
        @Pc(6) ReferenceCache local6 = this.aReferenceCache_188;
        @Pc(16) DoublyLinkedNode_Sub2_Sub6 local16;
        synchronized (this.aReferenceCache_188) {
            local16 = (DoublyLinkedNode_Sub2_Sub6) this.aReferenceCache_188.get((long) arg0);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.aJs5_107;
        @Pc(39) byte[] local39;
        synchronized (this.aJs5_107) {
            local39 = this.aJs5_107.getfile(arg0, 5);
        }
        local16 = new DoublyLinkedNode_Sub2_Sub6();
        if (local39 != null) {
            local16.method1979(new Packet(local39));
        }
        @Pc(63) ReferenceCache local63 = this.aReferenceCache_188;
        synchronized (this.aReferenceCache_188) {
            this.aReferenceCache_188.put(local16, (long) arg0);
            return local16;
        }
    }
}
