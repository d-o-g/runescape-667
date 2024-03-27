import com.jagex.game.runetek6.client.GameShell;
import com.jagex.game.runetek6.sound.Audio;
import com.jagex.sound.SampleRateConverter;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.channel.ClanChannel;

public final class Static674 {

    @OriginalMember(owner = "client!vfa", name = "Gb", descriptor = "Lclient!rfa;")
    public static ClanChannel aClass2_Sub47_3;

    @OriginalMember(owner = "client!vfa", name = "b", descriptor = "(B)V")
    public static void method8806() {
        Static517.method6822(ClientOptions.instance.stereoSound.getValue() == 1);
        Static719.aClass56_5 = Static638.method8394(GameShell.signLink, 0, 22050, GameShell.canvas);
        Static697.method9120(Static48.method1100(null));
        Static559.aClass56_3 = Static638.method8394(GameShell.signLink, 1, 2048, GameShell.canvas);
        SoundManager.activeStreams = new Node_Sub6_Sub3();
        Static559.aClass56_3.method3582(SoundManager.activeStreams);
        Static681.aSampleRateConverter_2 = new SampleRateConverter(22050, Audio.sampleRate);
        SoundManager.mixBussReset();
    }
}
