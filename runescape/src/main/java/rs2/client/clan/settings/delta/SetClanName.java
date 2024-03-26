package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!dga")
public final class SetClanName extends DeltaEntry {

    @OriginalMember(owner = "client!dga", name = "l", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!dga", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.name = this.name;
    }

    @OriginalMember(owner = "client!dga", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.name = packet.gjstr();
        packet.g4(); // last namechange timestamp
    }
}
