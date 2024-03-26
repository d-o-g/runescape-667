import com.jagex.SignLink;
import com.jagex.game.runetek6.sound.Audio;
import com.jagex.sound.SampleRateConverter;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.channel.ClanChannel;

public final class Static674 {

    @OriginalMember(owner = "client!vfa", name = "Gb", descriptor = "Lclient!rfa;")
    public static ClanChannel aClass2_Sub47_3;

    @OriginalMember(owner = "client!vfa", name = "a", descriptor = "(II)V")
    public static void method8789(@OriginalArg(0) int arg0) {
        if (MainLogicManager.step == 7 && (Static135.anInt8223 == 0 && Static6.anInt95 == 0)) {
            Static470.anInt7113 = arg0;
            MainLogicManager.setStep(9);
        }
    }

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "(B)V")
    public static void method8806() {
        Static517.method6822(ClientOptions.instance.stereoSound.getValue() == 1);
        Static719.aClass56_5 = Static638.method8394(SignLink.instance, 0, 22050, GameShell.canvas);
        Static697.method9120(Static48.method1100(null));
        Static559.aClass56_3 = Static638.method8394(SignLink.instance, 1, 2048, GameShell.canvas);
        Static336.activeStreams = new Node_Sub6_Sub3();
        Static559.aClass56_3.method3582(Static336.activeStreams);
        Static681.aSampleRateConverter_2 = new SampleRateConverter(22050, Audio.sampleRate);
        Static550.method7266();
    }
}
