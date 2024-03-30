import com.jagex.core.constants.ModeGame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!sga")
public final class IdleAnimationsOption extends Option {

    @OriginalMember(owner = "client!sga", name = "<init>", descriptor = "(ILclient!kv;)V")
    public IdleAnimationsOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!sga", name = "<init>", descriptor = "(Lclient!kv;)V")
    public IdleAnimationsOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!sga", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!sga", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!sga", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.getModeGame() == ModeGame.STELLAR_DAWN) {
            super.value = 2;
        }
        if (super.value < 0 || super.value > 2) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!sga", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!sga", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }
}
