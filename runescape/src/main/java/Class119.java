import com.jagex.game.runetek6.client.GameShell;
import com.jagex.sign.SignLink;
import com.jagex.core.util.JagException;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!faa")
public final class Class119 implements Runnable {

    @OriginalMember(owner = "client!faa", name = "g", descriptor = "Lclient!vq;")
    public SignLink aSignLink_2;

    @OriginalMember(owner = "client!faa", name = "f", descriptor = "[Lclient!cd;")
    public final PcmPlayer[] aPcmPlayerArray1 = new PcmPlayer[2];

    @OriginalMember(owner = "client!faa", name = "h", descriptor = "Z")
    public volatile boolean aBoolean241 = false;

    @OriginalMember(owner = "client!faa", name = "e", descriptor = "Z")
    public volatile boolean aBoolean242 = false;

    @OriginalMember(owner = "client!faa", name = "run", descriptor = "()V")
    @Override
    public void run() {
        this.aBoolean242 = true;
        try {
            while (!this.aBoolean241) {
                for (@Pc(12) int local12 = 0; local12 < 2; local12++) {
                    @Pc(21) PcmPlayer local21 = this.aPcmPlayerArray1[local12];
                    if (local21 != null) {
                        local21.method3594();
                    }
                }
                TimeUtils.sleep(10L);
                GameShell.waitForEvents(this.aSignLink_2, null);
            }
        } catch (@Pc(49) Exception local49) {
            JagException.sendTrace(local49, null);
        } finally {
            @Pc(59) Object local59 = null;
            this.aBoolean242 = false;
        }
    }
}
