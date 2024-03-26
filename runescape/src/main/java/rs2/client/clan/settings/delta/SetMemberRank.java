package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!ij")
public final class SetMemberRank extends DeltaEntry {

    @OriginalMember(owner = "client!ij", name = "m", descriptor = "B")
    public byte rank;

    @OriginalMember(owner = "client!ij", name = "p", descriptor = "I")
    public int member = -1;

    @OriginalMember(owner = "client!ij", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doSetMemberRank(this.rank, this.member);
    }

    @OriginalMember(owner = "client!ij", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.member = packet.g2();
        this.rank = packet.g1b();
    }
}
