import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!uv")
public interface Location {

    @OriginalMember(owner = "client!uv", name = "c", descriptor = "(I)I")
    int method6855(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!uv", name = "d", descriptor = "(I)V")
    void method6856();

    @OriginalMember(owner = "client!uv", name = "a", descriptor = "(Lclient!ha;I)V")
    void method6857(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1);

    @OriginalMember(owner = "client!uv", name = "b", descriptor = "(I)I")
    int method6858();

    @OriginalMember(owner = "client!uv", name = "a", descriptor = "(I)I")
    int getId(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!uv", name = "e", descriptor = "(I)Z")
    boolean castsShadow(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!uv", name = "b", descriptor = "(Lclient!ha;I)V")
    void addShadow(@OriginalArg(0) Toolkit arg0);
}
