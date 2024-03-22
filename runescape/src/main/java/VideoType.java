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
    public boolean paused;

    @OriginalMember(owner = "client!aia", name = "v", descriptor = "Z")
    public final boolean transmitOnEnd;

    @OriginalMember(owner = "client!aia", name = "l", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!aia", name = "o", descriptor = "Lclient!wea;")
    public final Js5Video js5;

    @OriginalMember(owner = "client!aia", name = "t", descriptor = "I")
    public final int anInt180;

    @OriginalMember(owner = "client!aia", name = "<init>", descriptor = "(ILclient!wea;IZ)V")
    public VideoType(@OriginalArg(0) int id, @OriginalArg(1) Js5Video js5, @OriginalArg(2) int arg2, @OriginalArg(3) boolean transmitOnEnd) {
        this.transmitOnEnd = transmitOnEnd;
        this.id = id;
        this.js5 = js5;
        this.anInt180 = arg2;
    }
}
