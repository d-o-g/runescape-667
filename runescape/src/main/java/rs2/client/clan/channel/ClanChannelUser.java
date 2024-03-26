package rs2.client.clan.channel;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bca")
public final class ClanChannelUser {

    @OriginalMember(owner = "client!bca", name = "d", descriptor = "Ljava/lang/String;")
    public String displayName;

    @OriginalMember(owner = "client!bca", name = "a", descriptor = "B")
    public byte rank;

    @OriginalMember(owner = "client!bca", name = "g", descriptor = "I")
    public int world;
}
