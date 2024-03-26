package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!cq")
public final class SetExtraSettingLong extends DeltaEntry {

    @OriginalMember(owner = "client!cq", name = "m", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!cq", name = "o", descriptor = "J")
    public long value;

    @OriginalMember(owner = "client!cq", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doSetExtraSettingLong(this.id, this.value);
    }

    @OriginalMember(owner = "client!cq", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.id = packet.g4();
        this.value = packet.g8();
    }
}
