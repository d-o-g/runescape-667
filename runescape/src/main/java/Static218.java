import com.jagex.SignedResource;
import com.jagex.SignedResourceStatus;
import com.jagex.core.io.FileOnDisk;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static218 {

    @OriginalMember(owner = "client!go", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;B)V")
    public static void method3188(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
        if (arg1.length() > 320 || !LoginManager.isAtLoginScreen()) {
            return;
        }
        ServerConnection.LOBBY.close();
        LoginManager.resetSocialNetwork();
        LoginManager.password = arg0;
        LoginManager.username = arg1;
        MainLogicManager.setStep(5);
    }

    @OriginalMember(owner = "client!go", name = "b", descriptor = "(I)V")
    public static void method3189() {
        @Pc(7) FileOnDisk local7 = null;
        try {
            @Pc(13) SignedResource resource = GameShell.signLink.openPrefs("2", true);
            while (resource.status == SignedResourceStatus.IDLE) {
                TimeUtils.sleep(1L);
            }

            if (resource.status == SignedResourceStatus.SUCCESS) {
                local7 = (FileOnDisk) resource.result;
                @Pc(41) byte[] data = new byte[(int) local7.length()];
                @Pc(57) int local57;
                for (@Pc(43) int local43 = 0; local43 < data.length; local43 += local57) {
                    local57 = local7.read(data.length - local43, data, local43);
                    if (local57 == -1) {
                        throw new IOException("EOF");
                    }
                }
                Static618.method8317(new Packet(data));
            }
        } catch (@Pc(88) Exception local88) {
        }
        try {
            if (local7 != null) {
                local7.close();
            }
        } catch (@Pc(100) Exception local100) {
        }
    }
}
