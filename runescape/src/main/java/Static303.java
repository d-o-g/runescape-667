import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.ImageProgressBarInstance;
import rs2.client.loading.screen.op.instance.ProgressBarInstance;

public final class Static303 {

    @OriginalMember(owner = "client!jka", name = "a", descriptor = "(IB)V")
    public static void method4428(@OriginalArg(0) int arg0) {
        if (!LoginManager.isAtLoginScreen()) {
            return;
        }
        if (LoginManager.socialNetworkId != arg0) {
            LoginManager.previousUsername = "";
        }
        LoginManager.socialNetworkId = arg0;
        ServerConnection.LOBBY.close();
        MainLogicManager.setStep(5);
    }

    @OriginalMember(owner = "client!jka", name = "a", descriptor = "(Lclient!ge;B)Lclient!gha;")
    public static ImageProgressBarInstance method4430(@OriginalArg(0) Packet arg0) {
        @Pc(15) ProgressBarInstance local15 = ProgressBarInstance.decode(arg0);
        @Pc(19) int local19 = arg0.g4();
        @Pc(23) int local23 = arg0.g4();
        @Pc(27) int local27 = arg0.g2();
        return new ImageProgressBarInstance(local15.horizontalAlignment, local15.verticalAlignment, local15.x, local15.y, local15.width, local15.height, local15.textOffsetX, local15.font, local15.textColour, local19, local23, local27);
    }
}
