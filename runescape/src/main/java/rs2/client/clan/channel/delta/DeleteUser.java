package rs2.client.clan.channel.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.channel.delta.DeltaEntry;

@OriginalClass("client!qca")
public final class DeleteUser extends DeltaEntry {

    @OriginalMember(owner = "client!qca", name = "t", descriptor = "I")
    public int pos = -1;

    @OriginalMember(owner = "client!qca", name = "a", descriptor = "(Lclient!ge;I)V")
    @Override
    public void decode(@OriginalArg(0) Packet packet) {
        this.pos = packet.g2();
        packet.g1();

        if (packet.g1() != 255) {
            packet.pos--;
            packet.g8();
        }
    }

    @OriginalMember(owner = "client!qca", name = "a", descriptor = "(Lclient!rfa;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanChannel channel) {
        channel.deleteUser(this.pos);
    }
}
