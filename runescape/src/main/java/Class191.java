import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jg")
public final class Class191 {

    @OriginalMember(owner = "client!jg", name = "g", descriptor = "Lclient!sia;")
    public Class339 aClass339_27;

    @OriginalMember(owner = "client!jg", name = "j", descriptor = "Lclient!ie;")
    public Node aNode_149;

    @OriginalMember(owner = "client!jg", name = "<init>", descriptor = "()V")
    public Class191() {
    }

    @OriginalMember(owner = "client!jg", name = "<init>", descriptor = "(Lclient!sia;)V")
    public Class191(@OriginalArg(0) Class339 arg0) {
        this.aClass339_27 = arg0;
    }

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "(B)Lclient!ie;")
    public Node method4342() {
        @Pc(12) Node local12 = this.aNode_149;
        if (this.aClass339_27.aNode_271 == local12) {
            this.aNode_149 = null;
            return null;
        } else {
            this.aNode_149 = local12.next;
            return local12;
        }
    }

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "(I)Lclient!ie;")
    public Node method4343() {
        @Pc(8) Node local8 = this.aClass339_27.aNode_271.next;
        if (this.aClass339_27.aNode_271 == local8) {
            this.aNode_149 = null;
            return null;
        } else {
            this.aNode_149 = local8.next;
            return local8;
        }
    }

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "(Lclient!sia;I)V")
    public void method4344(@OriginalArg(0) Class339 arg0) {
        this.aClass339_27 = arg0;
    }
}
