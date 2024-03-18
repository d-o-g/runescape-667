import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sia")
public final class Class339 {

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "Lclient!ie;")
    public Node aNode_272;

    @OriginalMember(owner = "client!sia", name = "x", descriptor = "Lclient!ie;")
    public final Node aNode_271 = new Node();

    @OriginalMember(owner = "client!sia", name = "<init>", descriptor = "()V")
    public Class339() {
        this.aNode_271.aNode_346 = this.aNode_271;
        this.aNode_271.aNode_345 = this.aNode_271;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;I)V")
    public void method7697(@OriginalArg(0) Node arg0) {
        if (arg0.aNode_345 != null) {
            arg0.method9457();
        }
        arg0.aNode_346 = this.aNode_271.aNode_346;
        arg0.aNode_345 = this.aNode_271;
        arg0.aNode_345.aNode_346 = arg0;
        arg0.aNode_346.aNode_345 = arg0;
    }

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "(I)Lclient!ie;")
    public Node method7699(@OriginalArg(0) int arg0) {
        @Pc(7) Node local7 = this.aNode_271.aNode_346;
        if (arg0 != 65280) {
            this.aNode_272 = null;
        }
        if (local7 == this.aNode_271) {
            this.aNode_272 = null;
            return null;
        } else {
            this.aNode_272 = local7.aNode_346;
            return local7;
        }
    }

    @OriginalMember(owner = "client!sia", name = "f", descriptor = "(I)V")
    public void method7700() {
        while (true) {
            @Pc(7) Node local7 = this.aNode_271.aNode_346;
            if (this.aNode_271 == local7) {
                this.aNode_272 = null;
                return;
            }
            local7.method9457();
        }
    }

    @OriginalMember(owner = "client!sia", name = "c", descriptor = "(I)I")
    public int method7701() {
        @Pc(13) int local13 = 0;
        @Pc(17) Node local17 = this.aNode_271.aNode_346;
        while (local17 != this.aNode_271) {
            local17 = local17.aNode_346;
            local13++;
        }
        return local13;
    }

    @OriginalMember(owner = "client!sia", name = "d", descriptor = "(I)Z")
    public boolean method7702() {
        return this.aNode_271 == this.aNode_271.aNode_346;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;Lclient!sia;B)V")
    public void method7703(@OriginalArg(0) Node arg0, @OriginalArg(1) Class339 arg1) {
        @Pc(7) Node local7 = this.aNode_271.aNode_345;
        this.aNode_271.aNode_345 = arg0.aNode_345;
        arg0.aNode_345.aNode_346 = this.aNode_271;
        if (arg0 != this.aNode_271) {
            arg0.aNode_345 = arg1.aNode_271.aNode_345;
            arg0.aNode_345.aNode_346 = arg0;
            local7.aNode_346 = arg1.aNode_271;
            arg1.aNode_271.aNode_345 = local7;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(I)Lclient!ie;")
    public Node method7705() {
        @Pc(7) Node local7 = this.aNode_271.aNode_346;
        if (local7 == this.aNode_271) {
            return null;
        } else {
            local7.method9457();
            return local7;
        }
    }

    @OriginalMember(owner = "client!sia", name = "h", descriptor = "(I)Lclient!ie;")
    public Node method7706() {
        @Pc(13) Node local13 = this.aNode_272;
        if (local13 == this.aNode_271) {
            this.aNode_272 = null;
            return null;
        } else {
            this.aNode_272 = local13.aNode_346;
            return local13;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(ILclient!sia;)V")
    public void method7707(@OriginalArg(1) Class339 arg0) {
        this.method7703(this.aNode_271.aNode_346, arg0);
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(B)Lclient!ie;")
    public Node method7708() {
        @Pc(14) Node local14 = this.aNode_271.aNode_345;
        if (local14 == this.aNode_271) {
            this.aNode_272 = null;
            return null;
        } else {
            this.aNode_272 = local14.aNode_345;
            return local14;
        }
    }

    @OriginalMember(owner = "client!sia", name = "b", descriptor = "(B)Lclient!ie;")
    public Node method7709() {
        @Pc(6) Node local6 = this.aNode_272;
        if (local6 == this.aNode_271) {
            this.aNode_272 = null;
            return null;
        } else {
            this.aNode_272 = local6.aNode_345;
            return local6;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(BLclient!ie;)V")
    public void method7711(@OriginalArg(1) Node arg0) {
        if (arg0.aNode_345 != null) {
            arg0.method9457();
        }
        arg0.aNode_346 = this.aNode_271;
        arg0.aNode_345 = this.aNode_271.aNode_345;
        arg0.aNode_345.aNode_346 = arg0;
        arg0.aNode_346.aNode_345 = arg0;
    }
}
