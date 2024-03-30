import com.jagex.core.constants.ModeGame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tv")
public final class TextureQuality extends Option {

    @OriginalMember(owner = "client!tv", name = "<init>", descriptor = "(Lclient!kv;)V")
    public TextureQuality(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!tv", name = "<init>", descriptor = "(ILclient!kv;)V")
    public TextureQuality(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!tv", name = "b", descriptor = "(B)Z")
    public boolean canMod() {
        if (super.options.getModeGame() == ModeGame.RUNESCAPE) {
            return !super.options.isLowDetail();
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!tv", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.getModeGame() != ModeGame.RUNESCAPE) {
            super.value = 1;
        } else if (super.options.isLowDetail()) {
            super.value = 0;
        }
        if (super.value != 0 && super.value != 1) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!tv", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!tv", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!tv", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        if (super.options.getModeGame() != ModeGame.RUNESCAPE) {
            return 3;
        } else if (super.options.isLowDetail()) {
            return 3;
        } else if (value == 0 || super.options.groundBlending.getValue() == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @OriginalMember(owner = "client!tv", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }
}
