import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!fo")
public final class Class133 implements LoadingScreenOp {

    @OriginalMember(owner = "client!fo", name = "g", descriptor = "Lclient!da;")
    public Font aFont_4;

    @OriginalMember(owner = "client!fo", name = "l", descriptor = "Lclient!fea;")
    public final Class125 aClass125_1;

    @OriginalMember(owner = "client!fo", name = "j", descriptor = "Lclient!sb;")
    public final js5 aJs5_36;

    @OriginalMember(owner = "client!fo", name = "n", descriptor = "Lclient!sb;")
    public final js5 aJs5_37;

    @OriginalMember(owner = "client!fo", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!fea;)V")
    public Class133(@OriginalArg(0) js5 arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) Class125 arg2) {
        this.aClass125_1 = arg2;
        this.aJs5_36 = arg1;
        this.aJs5_37 = arg0;
    }

    @OriginalMember(owner = "client!fo", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
        @Pc(24) FontMetrics local24 = FontMetrics.loadFile(this.aClass125_1.anInt2858, this.aJs5_36);
        this.aFont_4 = Toolkit.active.createFont(local24, IndexedImage.load(this.aJs5_37, this.aClass125_1.anInt2858), true);
    }

    @OriginalMember(owner = "client!fo", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(27) int local27 = this.aClass125_1.aHorizontalAlignment_2.align(Client.loadingScreenWidth, this.aClass125_1.anInt2865) + this.aClass125_1.anInt2868;
        @Pc(41) int local41 = this.aClass125_1.aVerticalAlignment_3.align(Client.loadingScreenHeight, this.aClass125_1.anInt2859) + this.aClass125_1.anInt2869;
        this.aFont_4.renderLines(0, null, this.aClass125_1.anInt2867, this.aClass125_1.aString30, null, null, local41, this.aClass125_1.anInt2862, 0, this.aClass125_1.anInt2860, local27, this.aClass125_1.anInt2870, this.aClass125_1.anInt2866, this.aClass125_1.anInt2865, this.aClass125_1.anInt2859);
    }

    @OriginalMember(owner = "client!fo", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        @Pc(11) boolean local11 = true;
        if (!this.aJs5_37.fileready(this.aClass125_1.anInt2858)) {
            local11 = false;
        }
        if (!this.aJs5_36.fileready(this.aClass125_1.anInt2858)) {
            local11 = false;
        }
        return local11;
    }
}
