import com.jagex.sound.SampleRateConverter;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.event.keyboard.KeyboardMonitor;
import rs2.client.event.keyboard.SimpleKeyboardMonitor;

import java.awt.Component;

public final class Static681 {

    @OriginalMember(owner = "client!vk", name = "a", descriptor = "Lclient!lg;")
    public static SampleRateConverter aSampleRateConverter_2;

    @OriginalMember(owner = "client!vk", name = "a", descriptor = "(ILjava/awt/Component;)Lclient!rg;")
    public static KeyboardMonitor method8921(@OriginalArg(1) Component arg0) {
        return new SimpleKeyboardMonitor(arg0);
    }
}
