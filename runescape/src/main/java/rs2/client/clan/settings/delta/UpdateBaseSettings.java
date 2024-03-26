package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

import java.util.BitSet;

@OriginalClass("client!ku")
public final class UpdateBaseSettings extends DeltaEntry {

    @OriginalMember(owner = "client!ku", name = "o", descriptor = "B")
    public byte rankKick;

    @OriginalMember(owner = "client!ku", name = "m", descriptor = "B")
    public byte coinshare;

    @OriginalMember(owner = "client!ku", name = "r", descriptor = "Z")
    public boolean allowNonMembers;

    @OriginalMember(owner = "client!ku", name = "p", descriptor = "B")
    public byte rankTalk;

    @OriginalMember(owner = "client!ku", name = "s", descriptor = "B")
    public byte rankLootShare;

    static {
        new BitSet(65536);
    }

    @OriginalMember(owner = "client!ku", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.allowNonMembers = this.allowNonMembers;
        settings.rankKick = this.rankKick;
        settings.rankLootShare = this.rankLootShare;
        settings.coinshare = this.coinshare;
        settings.rankTalk = this.rankTalk;
    }

    @OriginalMember(owner = "client!ku", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.allowNonMembers = packet.g1() == 1;
        this.rankTalk = packet.g1b();
        this.rankKick = packet.g1b();
        this.rankLootShare = packet.g1b();
        this.coinshare = packet.g1b();
    }
}
