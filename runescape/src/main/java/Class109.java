import com.jagex.Client;
import com.jagex.graphics.Sprite;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!en")
public final class Class109 implements LoadingScreenOp {

    @OriginalMember(owner = "client!en", name = "b", descriptor = "Lclient!st;")
    public Sprite aSprite_9;

    @OriginalMember(owner = "client!en", name = "a", descriptor = "Lclient!sb;")
    public final js5 aJs5_27;

    @OriginalMember(owner = "client!en", name = "g", descriptor = "Lclient!jt;")
    public final Class200 aClass200_1;

    @OriginalMember(owner = "client!en", name = "<init>", descriptor = "(Lclient!sb;Lclient!jt;)V")
    public Class109(@OriginalArg(0) js5 arg0, @OriginalArg(1) Class200 arg1) {
        this.aJs5_27 = arg0;
        this.aClass200_1 = arg1;
    }

    @OriginalMember(owner = "client!en", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(11) int local11 = Client.loadingScreenWidth >= GameShell.canvasWid ? Client.loadingScreenWidth : GameShell.canvasWid;
        @Pc(19) int local19 = GameShell.canvasHei <= Client.loadingScreenHeight ? Client.loadingScreenHeight : GameShell.canvasHei;
        @Pc(23) int local23 = this.aSprite_9.scaleWidth();
        @Pc(27) int local27 = this.aSprite_9.scaleHeight();
        @Pc(29) int local29 = 0;
        @Pc(31) int local31 = local11;
        @Pc(37) int local37 = local11 * local27 / local23;
        @Pc(44) int local44 = (local19 - local37) / 2;
        if (local19 < local37) {
            local31 = local23 * local19 / local27;
            local37 = local19;
            local44 = 0;
            local29 = (local11 - local31) / 2;
        }
        this.aSprite_9.render(local29, local44, local31, local37);
    }

    @OriginalMember(owner = "client!en", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
        this.aSprite_9 = Static652.method8533(this.aClass200_1.anInt4996, this.aJs5_27);
    }

    @OriginalMember(owner = "client!en", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        return this.aJs5_27.fileready(this.aClass200_1.anInt4996);
    }
}
