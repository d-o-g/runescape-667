import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fb")
public abstract class MouseMonitor {

    public static final int CLICK_TYPE_UNKNOWN = 0x0;
    public static final int CLICK_TYPE_LEFT = 0x1;
    public static final int CLICK_TYPE_MIDDLE = 0x2;
    public static final int CLICK_TYPE_RIGHT = 0x4;

    @OriginalMember(owner = "client!fb", name = "<init>", descriptor = "()V")
    protected MouseMonitor() {
    }

    @OriginalMember(owner = "client!fb", name = "e", descriptor = "(B)V")
    public abstract void method8841();

    @OriginalMember(owner = "client!fb", name = "c", descriptor = "(I)Z")
    public abstract boolean isLeftDown();

    @OriginalMember(owner = "client!fb", name = "b", descriptor = "(I)Z")
    public abstract boolean isRightDown();

    @OriginalMember(owner = "client!fb", name = "b", descriptor = "(B)Z")
    public final boolean isDown() {
        return this.isLeftDown() || this.isMiddleDown() || this.isRightDown();
    }

    @OriginalMember(owner = "client!fb", name = "d", descriptor = "(I)Z")
    public abstract boolean isMiddleDown();

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(I)V")
    public abstract void remove();

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(B)Lclient!bv;")
    public abstract MouseLog removeFirstLog();

    @OriginalMember(owner = "client!fb", name = "d", descriptor = "(B)I")
    public abstract int getRecordedX();

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(Z)I")
    public abstract int getRecordedY();
}
