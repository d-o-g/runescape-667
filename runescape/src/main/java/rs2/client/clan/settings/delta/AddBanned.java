package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!gka")
public final class AddBanned extends DeltaEntry {

    @OriginalMember(owner = "client!gka", name = "l", descriptor = "Ljava/lang/String;")
    public String name = null;

    @OriginalMember(owner = "client!gka", name = "s", descriptor = "J")
    public long hash = -1L;

    @OriginalMember(owner = "client!gka", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doAddBanned(this.name, this.hash);
    }

    @OriginalMember(owner = "client!gka", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        if (packet.g1() != 255) {
            packet.pos--;
            this.hash = packet.g8();
        }

        this.name = packet.fastgstr();
    }
}
