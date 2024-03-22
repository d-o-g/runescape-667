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
        Static352.method5180();
        Static563.method7461();
        for (@Pc(36) int local36 = 0; local36 < 4; local36++) {
            Static577.A_COLLISION_MAP_ARRAY_1[local36].method2467();
        }
        Static668.method8700(false);
        System.gc();
        Static312.method4541();
        Static588.anInt8692 = -1;
        Static501.aBoolean575 = false;
        Static550.method7266();
        Static609.method8213(true);
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
}
