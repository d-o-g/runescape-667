import com.jagex.game.runetek6.client.GameShell;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.instance.ClearScreenInstance;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!aca")
public final class ClearScreen implements LoadingScreenOp {

    @OriginalMember(owner = "client!aca", name = "a", descriptor = "Lclient!gi;")
    public final ClearScreenInstance instance;

    @OriginalMember(owner = "client!aca", name = "<init>", descriptor = "(Lclient!gi;)V")
    public ClearScreen(@OriginalArg(0) ClearScreenInstance instance) {
        this.instance = instance;
    }

    @OriginalMember(owner = "client!aca", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
    }

    @OriginalMember(owner = "client!aca", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        return true;
    }

    @OriginalMember(owner = "client!aca", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        Toolkit.active.aa(0, 0, GameShell.canvasWid, GameShell.canvasHei, this.instance.colour, 0);
    }
}
