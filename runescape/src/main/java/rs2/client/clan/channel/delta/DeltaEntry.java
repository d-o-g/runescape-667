package rs2.client.clan.channel.delta;

import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.channel.ClanChannel;

@OriginalClass("client!op")
public abstract class DeltaEntry extends Node {

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(Lclient!rfa;I)V")
    public abstract void applyTo(@OriginalArg(0) ClanChannel channel);

    @OriginalMember(owner = "client!op", name = "a", descriptor = "(Lclient!ge;I)V")
    public abstract void decode(@OriginalArg(0) Packet packet);
}
