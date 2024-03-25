import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.ClanSettings;

@OriginalClass("client!uu")
public final class Node_Sub14_Sub13 extends Node_Sub14 {

    @OriginalMember(owner = "client!uu", name = "r", descriptor = "I")
    public int anInt9838 = -1;

    @OriginalMember(owner = "client!uu", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void method8615(@OriginalArg(1) Packet arg0) {
        this.anInt9838 = arg0.g2();
    }

    @OriginalMember(owner = "client!uu", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void method8617(@OriginalArg(0) ClanSettings arg0) {
        arg0.doDeleteBanned(this.anInt9838);
    }
}
