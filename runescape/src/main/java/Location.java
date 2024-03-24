import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!uv")
public interface Location {

    @OriginalMember(owner = "client!uv", name = "c", descriptor = "(I)I")
    int getRotation();

    @OriginalMember(owner = "client!uv", name = "d", descriptor = "(I)V")
    void method6856();

    @OriginalMember(owner = "client!uv", name = "a", descriptor = "(Lclient!ha;I)V")
    void removeShadow(@OriginalArg(0) Toolkit toolkit);

    @OriginalMember(owner = "client!uv", name = "b", descriptor = "(I)I")
    int getShape();

    @OriginalMember(owner = "client!uv", name = "a", descriptor = "(I)I")
    int getId();

    @OriginalMember(owner = "client!uv", name = "e", descriptor = "(I)Z")
    boolean hardShadow();

    @OriginalMember(owner = "client!uv", name = "b", descriptor = "(Lclient!ha;I)V")
    void addShadow(@OriginalArg(0) Toolkit toolkit);
}
