package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!uu")
public final class DeleteBanned extends DeltaEntry {

    @OriginalMember(owner = "client!uu", name = "r", descriptor = "I")
    public int pos = -1;

    @OriginalMember(owner = "client!uu", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.pos = packet.g2();
    }

    @OriginalMember(owner = "client!uu", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doDeleteBanned(this.pos);
    }
}
