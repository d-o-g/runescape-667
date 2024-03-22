import com.jagex.SignLink;
import com.jagex.game.runetek6.sound.Audio;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static674 {

    @OriginalMember(owner = "client!vfa", name = "o", descriptor = "I")
    public static int anInt10088;

    @OriginalMember(owner = "client!vfa", name = "Gb", descriptor = "Lclient!rfa;")
    public static Node_Sub47 aClass2_Sub47_3;

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(II)V")
    public static void method8789(@OriginalArg(0) int arg0) {
        if (MainLogicManager.step == 7 && (Static135.anInt8223 == 0 && Static6.anInt95 == 0)) {
            Static470.anInt7113 = arg0;
            MainLogicManager.setStep(9);
        }
    }

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "(B)V")
    public static void method8806() {
        Static517.method6822(Static400.instance.aClass57_Sub17_1.method5667() == 1);
        Static719.aClass56_5 = Static638.method8394(SignLink.instance, 0, 22050, Static434.aCanvas7);
        Static697.method9120(Static48.method1100((Node_Sub6_Sub1) null));
        Static559.aClass56_3 = Static638.method8394(SignLink.instance, 1, 2048, Static434.aCanvas7);
        Static336.aClass2_Sub6_Sub3_1 = new Node_Sub6_Sub3();
        Static559.aClass56_3.method3582(Static336.aClass2_Sub6_Sub3_1);
        Static681.aClass224_2 = new Class224(22050, Audio.sampleRate);
        Static550.method7266();
    }
}
