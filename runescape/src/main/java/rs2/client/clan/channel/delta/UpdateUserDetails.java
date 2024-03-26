package rs2.client.clan.channel.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.channel.ClanChannelUser;
import rs2.client.clan.channel.delta.DeltaEntry;

@OriginalClass("client!sea")
public final class UpdateUserDetails extends DeltaEntry {

    @OriginalMember(owner = "client!sea", name = "t", descriptor = "I")
    public int world;

    @OriginalMember(owner = "client!sea", name = "w", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!sea", name = "s", descriptor = "B")
    public byte rank;

    @OriginalMember(owner = "client!sea", name = "v", descriptor = "I")
    public int pos = -1;

    @OriginalMember(owner = "client!sea", name = "a", descriptor = "(Lclient!ge;I)V")
    @Override
    public void decode(@OriginalArg(0) Packet packet) {
        this.pos = packet.g2();
        this.rank = packet.g1b();
        this.world = packet.g2();
        packet.g8();
        this.name = packet.gjstr();
    }

    @OriginalMember(owner = "client!sea", name = "a", descriptor = "(Lclient!rfa;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanChannel channel) {
        @Pc(9) ClanChannelUser user = channel.users[this.pos];
        user.world = this.world;
        user.rank = this.rank;
        user.displayName = this.name;
    }
}
