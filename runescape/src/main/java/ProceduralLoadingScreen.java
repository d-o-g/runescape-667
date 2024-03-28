import com.jagex.core.util.SystemTimer;
import rs2.client.loading.screen.LoadingScreen;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!tha")
public final class ProceduralLoadingScreen implements LoadingScreen {

    @OriginalMember(owner = "client!tha", name = "j", descriptor = "Lclient!ha;")
    public Toolkit toolkit;

    @OriginalMember(owner = "client!tha", name = "d", descriptor = "Z")
    public boolean newToolkit;

    @OriginalMember(owner = "client!tha", name = "b", descriptor = "Lclient!de;")
    public final LoadingScreenType screen;

    @OriginalMember(owner = "client!tha", name = "k", descriptor = "[Lclient!jd;")
    public final LoadingScreenOp[] ops;

    @OriginalMember(owner = "client!tha", name = "<init>", descriptor = "(Lclient!de;Lclient!we;)V")
    public ProceduralLoadingScreen(@OriginalArg(0) LoadingScreenType screen, @OriginalArg(1) LoadingScreenOpFactory arg1) {
        this.screen = screen;
        this.ops = new LoadingScreenOp[this.screen.ops.length];

        for (@Pc(15) int i = 0; i < this.ops.length; i++) {
            this.ops[i] = arg1.method9168(this.screen.ops[i]);
        }
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(ZJ)Z")
    @Override
    public boolean method8463(@OriginalArg(1) long arg0) {
        return SystemTimer.safetime() >= (long) this.screen.start + arg0;
    }

    @OriginalMember(owner = "client!tha", name = "c", descriptor = "(I)I")
    @Override
    public int getFadeDuration() {
        return this.screen.fadeDuration;
    }

    @OriginalMember(owner = "client!tha", name = "b", descriptor = "(I)V")
    @Override
    public void method8464() {
        if (this.toolkit != Toolkit.active) {
            this.toolkit = Toolkit.active;
            this.newToolkit = true;
        }
        this.toolkit.GA(0);
        @Pc(29) LoadingScreenOp[] local29 = this.ops;
        for (@Pc(31) int local31 = 0; local31 < local29.length; local31++) {
            @Pc(37) LoadingScreenOp local37 = local29[local31];
            if (local37 != null) {
                local37.init();
            }
        }
    }

    @OriginalMember(owner = "client!tha", name = "d", descriptor = "(I)I")
    @Override
    public int percentage() {
        @Pc(7) int local7 = 0;
        @Pc(10) LoadingScreenOp[] op = this.ops;
        for (@Pc(20) int local20 = 0; local20 < op.length; local20++) {
            @Pc(26) LoadingScreenOp local26 = op[local20];
            if (local26 == null || local26.ready()) {
                local7++;
            }
        }
        return local7 * 100 / this.ops.length;
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(ZB)V")
    @Override
    public void render(@OriginalArg(0) boolean arg0) {
        @Pc(10) LoadingScreenOp[] local10 = this.ops;
        for (@Pc(12) int local12 = 0; local12 < local10.length; local12++) {
            @Pc(18) LoadingScreenOp local18 = local10[local12];
            if (local18 != null) {
                local18.execute();
            }
        }
        this.newToolkit = false;
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(I)V")
    @Override
    public void method8461() {
    }
}
