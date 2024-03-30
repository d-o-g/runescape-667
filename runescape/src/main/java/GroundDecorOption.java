import com.jagex.core.constants.ModeGame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fia")
public final class GroundDecorOption extends Option {

    @OriginalMember(owner = "client!fia", name = "<init>", descriptor = "(Lclient!kv;)V")
    public GroundDecorOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!fia", name = "<init>", descriptor = "(ILclient!kv;)V")
    public GroundDecorOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!fia", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!fia", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!fia", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        if (super.options.isLowDetail()) {
            return 3;
        } else if (super.options.getModeGame() == ModeGame.RUNESCAPE) {
            return 1;
        } else {
            return 3;
        }
    }

    @OriginalMember(owner = "client!fia", name = "b", descriptor = "(B)Z")
    public boolean canMod() {
        if (super.options.isLowDetail()) {
            return false;
        } else {
            return super.options.getModeGame() == ModeGame.RUNESCAPE;
        }
    }

    @OriginalMember(owner = "client!fia", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!fia", name = "a", descriptor = "(B)V")
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
}
