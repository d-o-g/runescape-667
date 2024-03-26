import com.jagex.core.util.JavaScript;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Login {

    @OriginalMember(owner = "client!qka", name = "f", descriptor = "Lclient!lja;")
    public static ConnectionInfo worldInfo;

    @OriginalMember(owner = "client!uu", name = "o", descriptor = "Lclient!lja;")
    public static ConnectionInfo lobbyInfo;

    @OriginalMember(owner = "client!he", name = "a", descriptor = "(IZ)V")
    public static void logout(@OriginalArg(1) boolean arg0) {
        @Pc(12) ServerConnection[] local12 = ConnectionManager.VALUES;
        for (@Pc(14) int local14 = 0; local14 < local12.length; local14++) {
            @Pc(19) ServerConnection local19 = local12[local14];
            local19.close();
        }
        Static707.method9227();
        Static352.cacheReset();
        Static563.method7461();
        for (@Pc(36) int local36 = 0; local36 < 4; local36++) {
            Static577.collisionMaps[local36].reset();
        }
        Static668.method8700(false);
        System.gc();
        Static312.method4541();
        Static588.anInt8692 = -1;
        Static501.aBoolean575 = false;
        Static550.method7266();
        SoundManager.removeActiveStreams(true);
        Static300.method4393();
        Static723.method9450();
        Static187.method2842();
        if (arg0) {
            MainLogicManager.setStep(13);
            return;
        }
        MainLogicManager.setStep(3);
        try {
            JavaScript.call("loggedout", GameShell.loaderApplet);
        } catch (@Pc(86) Throwable local86) {
        }
    }

    private Login() {
        /* empty */
    }

    @OriginalMember(owner = "client!eo", name = "a", descriptor = "(III)V")
    public static void requestLoginFromSocialNetwork(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (!Static470.method6387()) {
            return;
        }
        Static470.anInt7113 = arg1;
        if (Static129.anInt2409 != arg0) {
            Static319.aString51 = "";
        }
        Static129.anInt2409 = arg0;
        MainLogicManager.setStep(6);
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(ILjava/lang/String;Ljava/lang/String;I)V")
    public static void requestLoginWithUsername(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1, @OriginalArg(2) String arg2) {
        if (arg2.length() > 320 || !Static470.method6387()) {
            return;
        }
        Static367.method5268();
        Static470.anInt7113 = arg0;
        Static59.aString63 = arg1;
        Static449.aString75 = arg2;
        MainLogicManager.setStep(6);
    }
}
