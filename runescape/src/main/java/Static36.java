import com.jagex.game.runetek6.client.GameShell;
import com.jagex.ServerProt;
import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.util.JavaScript;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.net.URL;

public final class Static36 {

    @OriginalMember(owner = "client!bda", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___15 = new ServerProt(70, -2);

    @OriginalMember(owner = "client!bda", name = "a", descriptor = "(BLclient!vq;Ljava/lang/String;Ljava/lang/String;I)Lclient!oba;")
    public static SignedResource method980(@OriginalArg(1) SignLink arg0, @OriginalArg(2) String arg1, @OriginalArg(3) String arg2, @OriginalArg(4) int arg3) {
        if (arg3 == 0) {
            return arg0.openPage(arg1);
        }
        @Pc(57) SignedResource local57;
        if (arg3 == 1) {
            try {
                @Pc(36) Object local36 = JavaScript.call(GameShell.loaderApplet, arg2, new Object[]{(new URL(GameShell.loaderApplet.getCodeBase(), arg1)).toString()});
                if (local36 == null) {
                    throw new RuntimeException();
                }
                @Pc(47) SignedResource local47 = new SignedResource();
                local47.status = 1;
                return local47;
            } catch (@Pc(53) Throwable local53) {
                local57 = new SignedResource();
                local57.status = 2;
                return local57;
            }
        } else if (arg3 == 2) {
            try {
                GameShell.loaderApplet.getAppletContext().showDocument(new URL(GameShell.loaderApplet.getCodeBase(), arg1), "_blank");
                local57 = new SignedResource();
                local57.status = 1;
                return local57;
            } catch (@Pc(94) Exception local94) {
                local57 = new SignedResource();
                local57.status = 2;
                return local57;
            }
        } else if (arg3 == 3) {
            try {
                JavaScript.call("loggedout", GameShell.loaderApplet);
            } catch (@Pc(115) Throwable local115) {
            }
            try {
                GameShell.loaderApplet.getAppletContext().showDocument(new URL(GameShell.loaderApplet.getCodeBase(), arg1), "_top");
                local57 = new SignedResource();
                local57.status = 1;
                return local57;
            } catch (@Pc(137) Exception local137) {
                local57 = new SignedResource();
                local57.status = 2;
                return local57;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
