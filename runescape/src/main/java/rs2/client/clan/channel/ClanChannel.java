package rs2.client.clan.channel;

import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import com.jagex.core.util.Arrays;
import com.jagex.core.util.Quicksort;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rfa")
public final class ClanChannel extends Node {

    @OriginalMember(owner = "client!oia", name = "t", descriptor = "Z")
    public static final boolean debug = false;

    @OriginalMember(owner = "client!bj", name = "u", descriptor = "Lclient!rfa;")
    public static ClanChannel affined;

    @OriginalMember(owner = "client!vfa", name = "Gb", descriptor = "Lclient!rfa;")
    public static ClanChannel listened;

    @OriginalMember(owner = "client!rfa", name = "x", descriptor = "B")
    public byte kickRank;

    @OriginalMember(owner = "client!rfa", name = "k", descriptor = "[Lclient!bca;")
    public ClanChannelUser[] users;

    @OriginalMember(owner = "client!rfa", name = "p", descriptor = "[I")
    public int[] sortedUserSlots;

    @OriginalMember(owner = "client!rfa", name = "D", descriptor = "J")
    public long updateNum;

    @OriginalMember(owner = "client!rfa", name = "C", descriptor = "B")
    public byte talkRank;

    @OriginalMember(owner = "client!rfa", name = "m", descriptor = "Z")
    public boolean useUserHashes;

    @OriginalMember(owner = "client!rfa", name = "A", descriptor = "Z")
    public boolean useDisplayNames = true;

    @OriginalMember(owner = "client!rfa", name = "t", descriptor = "I")
    public int userCount = 0;

    @OriginalMember(owner = "client!rfa", name = "s", descriptor = "Ljava/lang/String;")
    public String channelName = null;

    @OriginalMember(owner = "client!rfa", name = "<init>", descriptor = "(Lclient!ge;)V")
    public ClanChannel(@OriginalArg(0) Packet packet) {
        this.decode(packet);
    }

    @OriginalMember(owner = "client!rfa", name = "b", descriptor = "(I)[I")
    public int[] sortedUserSlots() {
        if (this.sortedUserSlots == null) {
            this.sortedUserSlots = new int[this.userCount];
            @Pc(17) String[] userDisplayNames = new String[this.userCount];

            @Pc(19) int i = 0;
            while (this.userCount > i) {
                userDisplayNames[i] = this.users[i].displayName;
                this.sortedUserSlots[i] = i++;
            }

            Quicksort.sort(userDisplayNames, this.sortedUserSlots);
        }

        return this.sortedUserSlots;
    }

    @OriginalMember(owner = "client!rfa", name = "a", descriptor = "(BLclient!bca;)V")
    public void addUser(@OriginalArg(1) ClanChannelUser user) {
        if (this.users == null || this.users.length <= this.userCount) {
            this.expand(this.userCount + 5);
        }

        this.users[this.userCount++] = user;
        this.sortedUserSlots = null;
    }

    @OriginalMember(owner = "client!rfa", name = "a", descriptor = "(ILclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        @Pc(9) int flags = packet.g1();
        if ((flags & 0x2) != 0) {
            this.useDisplayNames = true;
        }
        if ((flags & 0x1) != 0) {
            this.useUserHashes = true;
        }

        super.key = packet.g8();
        this.updateNum = packet.g8();
        this.channelName = packet.gjstr();
        packet.g1();
        this.kickRank = packet.g1b();
        this.talkRank = packet.g1b();
        this.userCount = packet.g2();

        if (this.userCount > 0) {
            this.users = new ClanChannelUser[this.userCount];

            for (@Pc(82) int i = 0; i < this.userCount; i++) {
                @Pc(88) ClanChannelUser user = new ClanChannelUser();
                if (this.useUserHashes) {
                    packet.g8();
                }
                if (this.useDisplayNames) {
                    user.displayName = packet.gjstr();
                }

                user.rank = packet.g1b();
                user.world = packet.g2();
                this.users[i] = user;
            }
        }
    }

    @OriginalMember(owner = "client!rfa", name = "a", descriptor = "(BI)V")
    public void expand(@OriginalArg(1) int count) {
        if (this.users == null) {
            this.users = new ClanChannelUser[count];
        } else {
            Arrays.copy(this.users, 0, this.users = new ClanChannelUser[count], 0, this.userCount);
        }
    }

    @OriginalMember(owner = "client!rfa", name = "a", descriptor = "(II)V")
    public void deleteUser(@OriginalArg(0) int pos) {
        this.userCount--;
        if (this.userCount == 0) {
            this.users = null;
        } else {
            Arrays.copy(this.users, pos + 1, this.users, pos, this.userCount - pos);
        }
        this.sortedUserSlots = null;
    }

    @OriginalMember(owner = "client!rfa", name = "a", descriptor = "(Ljava/lang/String;B)I")
    public int userSlot(@OriginalArg(0) String displayName) {
        for (@Pc(13) int i = 0; i < this.userCount; i++) {
            if (this.users[i].displayName.equalsIgnoreCase(displayName)) {
                return i;
            }
        }
        return -1;
    }
}
