package rs2.client.clan.channel.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.channel.ClanChannel;

@OriginalClass("client!lc")
public final class UpdateBaseSettings extends DeltaEntry {

    @OriginalMember(owner = "client!lc", name = "y", descriptor = "B")
    public byte talkRank;

    @OriginalMember(owner = "client!lc", name = "D", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!lc", name = "F", descriptor = "B")
    public byte kickRank;

    @OriginalMember(owner = "client!lc", name = "a", descriptor = "(Lclient!rfa;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanChannel channel) {
        if (this.name != null) {
            channel.kickRank = this.kickRank;
            channel.talkRank = this.talkRank;
        }

        channel.clanName = this.name;
    }

    @OriginalMember(owner = "client!lc", name = "a", descriptor = "(Lclient!ge;I)V")
    @Override
    public void decode(@OriginalArg(0) Packet packet) {
        this.name = packet.fastgstr();

        if (this.name != null) {
            packet.g1();
            this.talkRank = packet.g1b();
            this.kickRank = packet.g1b();
        }
    }
}
