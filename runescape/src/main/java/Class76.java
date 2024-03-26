import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.ClearScreenInstance;
import rs2.client.loading.screen.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!de")
public final class Class76 {

    @OriginalMember(owner = "client!de", name = "d", descriptor = "[Lclient!gja;")
    public LoadingScreenOpInstance[] anLoadingScreenOpInstanceArray1;

    @OriginalMember(owner = "client!de", name = "j", descriptor = "I")
    public int anInt2140;

    @OriginalMember(owner = "client!de", name = "i", descriptor = "I")
    public int anInt2141;

    @OriginalMember(owner = "client!de", name = "a", descriptor = "(ILclient!ge;Lclient!kda;)Lclient!gja;")
    public LoadingScreenOpInstance method2030(@OriginalArg(1) Packet arg0, @OriginalArg(2) LoadingScreenOpType arg1) {
        if (LoadingScreenOpType.CLEAR_SCREEN == arg1) {
            return ClearScreenInstance.decode(arg0);
        } else if (LoadingScreenOpType.SOLID_PROGRESS_BAR == arg1) {
            return Static502.method6720(arg0);
        } else if (arg1 == LoadingScreenOpType.NEWS) {
            return NewsInstance.decode(arg0);
        } else if (LoadingScreenOpType.ROTATING_IMAGE == arg1) {
            return Static464.method6301(arg0);
        } else if (LoadingScreenOpType.IMAGE == arg1) {
            return Class160.decode(arg0);
        } else if (arg1 == LoadingScreenOpType.IMAGE_PROGRESS_BAR) {
            return Static303.method4430(arg0);
        } else if (LoadingScreenOpType.FANCY_PROGRESS_BAR == arg1) {
            return Static715.method9346(arg0);
        } else if (arg1 == LoadingScreenOpType.TEXT) {
            return Class125.method6171(arg0);
        } else if (arg1 == LoadingScreenOpType.BACKGROUND_IMAGE) {
            return Static112.method2106(arg0);
        } else if (arg1 == LoadingScreenOpType.ANIMATED_PROGRESS_BAR) {
            return Static353.method8430(arg0);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!de", name = "a", descriptor = "(Lclient!ge;B)V")
    public void decode(@OriginalArg(0) Packet arg0) {
        this.anInt2140 = arg0.g3();
        this.anInt2141 = arg0.g2();
        this.anLoadingScreenOpInstanceArray1 = new LoadingScreenOpInstance[arg0.g1()];
        @Pc(31) LoadingScreenOpType[] local31 = LoadingScreenOpType.values();
        for (@Pc(33) int local33 = 0; local33 < this.anLoadingScreenOpInstanceArray1.length; local33++) {
            this.anLoadingScreenOpInstanceArray1[local33] = this.method2030(arg0, local31[arg0.g1()]);
        }
    }
}
