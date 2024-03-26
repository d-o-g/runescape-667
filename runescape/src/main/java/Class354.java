import com.jagex.core.util.SystemTimer;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!tha")
public final class Class354 implements LoadingScreen {

    @OriginalMember(owner = "client!tha", name = "j", descriptor = "Lclient!ha;")
    public Toolkit aToolkit_14;

    @OriginalMember(owner = "client!tha", name = "d", descriptor = "Z")
    public boolean aBoolean720;

    @OriginalMember(owner = "client!tha", name = "b", descriptor = "Lclient!de;")
    public final Class76 aClass76_1;

    @OriginalMember(owner = "client!tha", name = "k", descriptor = "[Lclient!jd;")
    public final LoadingScreenOp[] anLoadingScreenOpArray1;

    @OriginalMember(owner = "client!tha", name = "<init>", descriptor = "(Lclient!de;Lclient!we;)V")
    public Class354(@OriginalArg(0) Class76 arg0, @OriginalArg(1) LoadingScreenOpFactory arg1) {
        this.aClass76_1 = arg0;
        this.anLoadingScreenOpArray1 = new LoadingScreenOp[this.aClass76_1.anLoadingScreenOpInstanceArray1.length];
        for (@Pc(15) int local15 = 0; local15 < this.anLoadingScreenOpArray1.length; local15++) {
            this.anLoadingScreenOpArray1[local15] = arg1.method9168(this.aClass76_1.anLoadingScreenOpInstanceArray1[local15]);
        }
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(ZJ)Z")
    @Override
    public boolean method8463(@OriginalArg(1) long arg0) {
        return SystemTimer.safetime() >= (long) this.aClass76_1.anInt2140 + arg0;
    }

    @OriginalMember(owner = "client!tha", name = "c", descriptor = "(I)I")
    @Override
    public int method8462() {
        return this.aClass76_1.anInt2141;
    }

    @OriginalMember(owner = "client!tha", name = "b", descriptor = "(I)V")
    @Override
    public void method8464() {
        if (this.aToolkit_14 != Toolkit.active) {
            this.aToolkit_14 = Toolkit.active;
            this.aBoolean720 = true;
        }
        this.aToolkit_14.GA(0);
        @Pc(29) LoadingScreenOp[] local29 = this.anLoadingScreenOpArray1;
        for (@Pc(31) int local31 = 0; local31 < local29.length; local31++) {
            @Pc(37) LoadingScreenOp local37 = local29[local31];
            if (local37 != null) {
                local37.init();
            }
        }
    }

    @OriginalMember(owner = "client!tha", name = "d", descriptor = "(I)I")
    @Override
    public int method8460() {
        @Pc(7) int local7 = 0;
        @Pc(10) LoadingScreenOp[] local10 = this.anLoadingScreenOpArray1;
        for (@Pc(20) int local20 = 0; local20 < local10.length; local20++) {
            @Pc(26) LoadingScreenOp local26 = local10[local20];
            if (local26 == null || local26.ready()) {
                local7++;
            }
        }
        return local7 * 100 / this.anLoadingScreenOpArray1.length;
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(ZB)V")
    @Override
    public void render(@OriginalArg(0) boolean arg0) {
        @Pc(10) LoadingScreenOp[] local10 = this.anLoadingScreenOpArray1;
        for (@Pc(12) int local12 = 0; local12 < local10.length; local12++) {
            @Pc(18) LoadingScreenOp local18 = local10[local12];
            if (local18 != null) {
                local18.execute();
            }
        }
        this.aBoolean720 = false;
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(I)V")
    @Override
    public void method8461() {
    }
}
