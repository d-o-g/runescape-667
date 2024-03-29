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
    public ProceduralLoadingScreen(@OriginalArg(0) LoadingScreenType screen, @OriginalArg(1) LoadingScreenOpFactory factory) {
        this.screen = screen;
        this.ops = new LoadingScreenOp[this.screen.ops.length];

        for (@Pc(15) int i = 0; i < this.ops.length; i++) {
            this.ops[i] = factory.create(this.screen.ops[i]);
        }
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(ZJ)Z")
    @Override
    public boolean method8463(@OriginalArg(1) long time) {
        return SystemTimer.safetime() >= (long) this.screen.start + time;
    }

    @OriginalMember(owner = "client!tha", name = "c", descriptor = "(I)I")
    @Override
    public int getFadeDuration() {
        return this.screen.fadeDuration;
    }

    @OriginalMember(owner = "client!tha", name = "b", descriptor = "(I)V")
    @Override
    public void init() {
        if (this.toolkit != Toolkit.active) {
            this.toolkit = Toolkit.active;
            this.newToolkit = true;
        }

        this.toolkit.GA(0x000000);

        @Pc(29) LoadingScreenOp[] ops = this.ops;
        for (@Pc(31) int i = 0; i < ops.length; i++) {
            @Pc(37) LoadingScreenOp op = ops[i];

            if (op != null) {
                op.init();
            }
        }
    }

    @OriginalMember(owner = "client!tha", name = "d", descriptor = "(I)I")
    @Override
    public int percentage() {
        @Pc(7) int count = 0;
        @Pc(10) LoadingScreenOp[] ops = this.ops;

        for (@Pc(20) int i = 0; i < ops.length; i++) {
            @Pc(26) LoadingScreenOp op = ops[i];

            if (op == null || op.ready()) {
                count++;
            }
        }

        return (count * 100) / this.ops.length;
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(ZB)V")
    @Override
    public void render(@OriginalArg(0) boolean arg0) {
        @Pc(10) LoadingScreenOp[] ops = this.ops;

        for (@Pc(12) int i = 0; i < ops.length; i++) {
            @Pc(18) LoadingScreenOp op = ops[i];

            if (op != null) {
                op.execute();
            }
        }

        this.newToolkit = false;
    }

    @OriginalMember(owner = "client!tha", name = "a", descriptor = "(I)V")
    @Override
    public void cleanup() {
    }
}
