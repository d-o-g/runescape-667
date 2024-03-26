import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tn")
public final class ScriptedCameraPath {

    @OriginalMember(owner = "client!tn", name = "a", descriptor = "[I")
    public final int[] startY;

    @OriginalMember(owner = "client!tn", name = "m", descriptor = "[I")
    public final int[] endZ;

    @OriginalMember(owner = "client!tn", name = "n", descriptor = "[I")
    public final int[] endX;

    @OriginalMember(owner = "client!tn", name = "j", descriptor = "[I")
    public final int[] startX;

    @OriginalMember(owner = "client!tn", name = "l", descriptor = "[I")
    public final int[] endY;

    @OriginalMember(owner = "client!tn", name = "h", descriptor = "[I")
    public final int[] startZ;

    @OriginalMember(owner = "client!tn", name = "b", descriptor = "[I")
    public final int[] roll;

    @OriginalMember(owner = "client!tn", name = "<init>", descriptor = "(Lclient!ge;)V")
    public ScriptedCameraPath(@OriginalArg(0) Packet packet) {
        @Pc(7) int count = packet.gsmart();
        this.startY = new int[count];
        this.endZ = new int[count];
        this.endX = new int[count];
        this.startX = new int[count];
        this.endY = new int[count];
        this.startZ = new int[count];
        this.roll = new int[count];

        for (@Pc(37) int i = 0; i < count; i++) {
            this.startX[i] = packet.g2() - 5120;
            this.startZ[i] = packet.g2() - 5120;
            this.startY[i] = packet.g2s();
            this.endX[i] = packet.g2() - 5120;
            this.endZ[i] = packet.g2() - 5120;
            this.endY[i] = packet.g2s();
            this.roll[i] = packet.g2s();
        }
    }

    @OriginalMember(owner = "client!tn", name = "b", descriptor = "(II)V")
    public void useSpline(@OriginalArg(0) int index) {
        @Pc(13) int[][] spline = new int[this.startX.length << 1][4];
        for (@Pc(15) int i = 0; i < this.startX.length; i++) {
            spline[i * 2][0] = this.startX[i];
            spline[i * 2][1] = this.startY[i];
            spline[i * 2][2] = this.startZ[i];
            spline[i * 2][3] = this.roll[i];

            spline[i * 2 + 1][0] = this.endX[i];
            spline[i * 2 + 1][1] = this.endY[i];
            spline[i * 2 + 1][2] = this.endZ[i];
            spline[i * 2 + 1][3] = this.roll[i];
        }

        Camera.spline[index] = spline;
    }
}
