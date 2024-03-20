import com.jagex.Entity;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fla")
public final class Class130 {

    @OriginalMember(owner = "client!fla", name = "f", descriptor = "Lclient!ep;")
    public Entity aEntity_28;

    @OriginalMember(owner = "client!fla", name = "j", descriptor = "Lclient!ep;")
    public final Entity aEntity_27 = new Entity();

    @OriginalMember(owner = "client!fla", name = "<init>", descriptor = "()V")
    public Class130() {
        this.aEntity_27.aEntity_67 = this.aEntity_27;
        this.aEntity_27.aEntity_68 = this.aEntity_27;
    }

    @OriginalMember(owner = "client!fla", name = "d", descriptor = "(I)Z")
    public boolean method2782() {
        return this.aEntity_27 == this.aEntity_27.aEntity_68;
    }

    @OriginalMember(owner = "client!fla", name = "e", descriptor = "(I)Lclient!ep;")
    public Entity method2783() {
        @Pc(15) Entity local15 = this.aEntity_27.aEntity_68;
        if (local15 == this.aEntity_27) {
            return null;
        } else {
            local15.method9274();
            return local15;
        }
    }

    @OriginalMember(owner = "client!fla", name = "c", descriptor = "(I)I")
    public int method2784() {
        @Pc(7) int local7 = 0;
        for (@Pc(11) Entity local11 = this.aEntity_27.aEntity_68; local11 != this.aEntity_27; local11 = local11.aEntity_68) {
            local7++;
        }
        return local7;
    }

    @OriginalMember(owner = "client!fla", name = "a", descriptor = "(I)Lclient!ep;")
    public Entity method2785() {
        @Pc(6) Entity local6 = this.aEntity_28;
        if (this.aEntity_27 == local6) {
            this.aEntity_28 = null;
            return null;
        } else {
            this.aEntity_28 = local6.aEntity_68;
            return local6;
        }
    }

    @OriginalMember(owner = "client!fla", name = "a", descriptor = "(ZLclient!ep;)V")
    public void method2787(@OriginalArg(1) Entity arg0) {
        if (arg0.aEntity_67 != null) {
            arg0.method9274();
        }
        arg0.aEntity_67 = this.aEntity_27.aEntity_67;
        arg0.aEntity_68 = this.aEntity_27;
        arg0.aEntity_67.aEntity_68 = arg0;
        arg0.aEntity_68.aEntity_67 = arg0;
    }

    @OriginalMember(owner = "client!fla", name = "b", descriptor = "(I)Lclient!ep;")
    public Entity method2788() {
        @Pc(15) Entity local15 = this.aEntity_27.aEntity_67;
        if (local15 == this.aEntity_27) {
            this.aEntity_28 = null;
            return null;
        } else {
            this.aEntity_28 = local15.aEntity_67;
            return local15;
        }
    }

    @OriginalMember(owner = "client!fla", name = "b", descriptor = "(B)V")
    public void method2789() {
        while (true) {
            @Pc(11) Entity local11 = this.aEntity_27.aEntity_68;
            if (local11 == this.aEntity_27) {
                this.aEntity_28 = null;
                return;
            }
            local11.method9274();
        }
    }

    @OriginalMember(owner = "client!fla", name = "a", descriptor = "(B)Lclient!ep;")
    public Entity method2790() {
        @Pc(15) Entity local15 = this.aEntity_27.aEntity_68;
        if (local15 == this.aEntity_27) {
            this.aEntity_28 = null;
            return null;
        } else {
            this.aEntity_28 = local15.aEntity_68;
            return local15;
        }
    }
}
