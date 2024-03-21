import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!aia")
public final class VideoType extends Node {

    @OriginalMember(owner = "client!aia", name = "s", descriptor = "Z")
    public boolean aBoolean14;

    @OriginalMember(owner = "client!aia", name = "m", descriptor = "Z")
    public boolean aBoolean16;

    @OriginalMember(owner = "client!aia", name = "r", descriptor = "Z")
    public boolean aBoolean18;

    @OriginalMember(owner = "client!aia", name = "v", descriptor = "Z")
    public final boolean aBoolean15;

    @OriginalMember(owner = "client!aia", name = "l", descriptor = "I")
    public final int anInt182;

    @OriginalMember(owner = "client!aia", name = "o", descriptor = "Lclient!wea;")
    public final Video_Sub1 js5;

    @OriginalMember(owner = "client!aia", name = "t", descriptor = "I")
    public final int anInt180;

    @OriginalMember(owner = "client!aia", name = "<init>", descriptor = "(ILclient!wea;IZ)V")
    public VideoType(@OriginalArg(0) int arg0, @OriginalArg(1) Video_Sub1 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
        this.aBoolean15 = arg3;
        this.anInt182 = arg0;
        this.js5 = arg1;
        this.anInt180 = arg2;
    }
}
