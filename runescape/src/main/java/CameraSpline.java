import com.jagex.core.io.Packet;
import com.jagex.game.camera.CameraMode;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ra")
public final class CameraSpline extends CutsceneAction {

    @OriginalMember(owner = "client!ra", name = "i", descriptor = "I")
    public final int posSpline;

    @OriginalMember(owner = "client!ra", name = "l", descriptor = "I")
    public final int lookSpline;

    @OriginalMember(owner = "client!ra", name = "n", descriptor = "I")
    public final int posOffset;

    @OriginalMember(owner = "client!ra", name = "j", descriptor = "I")
    public final int lookOffset;

    @OriginalMember(owner = "client!ra", name = "m", descriptor = "I")
    public final int start;

    @OriginalMember(owner = "client!ra", name = "o", descriptor = "I")
    public final int end;

    @OriginalMember(owner = "client!ra", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CameraSpline(@OriginalArg(0) Packet packet) {
        super(packet);
        this.posSpline = packet.g2();
        this.lookSpline = packet.g2();
        this.posOffset = packet.g2();
        this.lookOffset = packet.g2();
        this.start = packet.g2();
        this.end = packet.g2();
    }

    @OriginalMember(owner = "client!ra", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        Camera.cutsceneSplines[this.posSpline].useSpline(0);
        Camera.cutsceneSplines[this.lookSpline].useSpline(1);
        Camera.splineStart = this.start;
        Camera.posSpline = 0;
        Camera.lookSpline = 1;
        Camera.mode = CameraMode.MODE_SPLINE;
        Camera.splineRate = 0;
        Camera.splineLookOffset = this.lookOffset;
        Camera.splinePosOffset = this.posOffset;
        Camera.splineEnd = this.end;
        Camera.splineTick();
        CutsceneManager.aBoolean480 = true;
    }
}
