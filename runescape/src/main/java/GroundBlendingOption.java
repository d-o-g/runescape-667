import com.jagex.core.constants.ModeGame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qia")
public final class GroundBlendingOption extends Option {

    @OriginalMember(owner = "client!qia", name = "<init>", descriptor = "(ILclient!kv;)V")
    public GroundBlendingOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!qia", name = "<init>", descriptor = "(Lclient!kv;)V")
    public GroundBlendingOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!qia", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        if (super.options.isLowDetail()) {
            return 3;
        } else if (super.options.getModeGame() == ModeGame.RUNESCAPE) {
            if (value == 0) {
                if (super.options.fog.getValue() == 1) {
                    return 2;
                }
                if (super.options.textures.getvalue() == 1) {
                    return 2;
                }
                if (super.options.waterDetail.getValue() > 0) {
                    return 2;
                }
            }
            return 1;
        } else {
            return 3;
        }
    }

    @OriginalMember(owner = "client!qia", name = "a", descriptor = "(B)V")
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

    @OriginalMember(owner = "client!qia", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!qia", name = "c", descriptor = "(B)Z")
    public boolean isCompatible() {
        if (super.options.isLowDetail()) {
            return false;
        } else {
            return super.options.getModeGame() == ModeGame.RUNESCAPE;
        }
    }

    @OriginalMember(owner = "client!qia", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!qia", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }
}
