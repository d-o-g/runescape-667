import com.jagex.core.constants.ModeGame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nt")
public final class AnimateBackgroundOption extends Option {

    @OriginalMember(owner = "client!nt", name = "<init>", descriptor = "(ILclient!kv;)V")
    public AnimateBackgroundOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!nt", name = "<init>", descriptor = "(Lclient!kv;)V")
    public AnimateBackgroundOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!nt", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return super.options.getModeGame() == ModeGame.RUNESCAPE && super.options.isLowDetail() ? 0 : 1;
    }

    @OriginalMember(owner = "client!nt", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        super.value = this.getDefaultValue();
    }

    @OriginalMember(owner = "client!nt", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!nt", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return 3;
    }

    @OriginalMember(owner = "client!nt", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }
}
