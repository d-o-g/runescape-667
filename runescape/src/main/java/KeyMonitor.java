import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!rg")
public abstract class KeyMonitor {

    @OriginalMember(owner = "client!kja", name = "b", descriptor = "Lclient!rg;")
    public static KeyMonitor instance;

    @OriginalMember(owner = "client!rg", name = "<init>", descriptor = "()V")
    protected KeyMonitor() {
    }

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "(I)Lclient!wka;")
    public abstract Interface27 method8478();

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "(II)Z")
    public abstract boolean isPressed(@OriginalArg(1) int arg0);

    @OriginalMember(owner = "client!rg", name = "a", descriptor = "(B)V")
    public abstract void method8481();

    @OriginalMember(owner = "client!rg", name = "b", descriptor = "(B)V")
    public abstract void method8482();
}
