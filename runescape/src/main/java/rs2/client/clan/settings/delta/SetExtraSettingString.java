package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!se")
public final class SetExtraSettingString extends DeltaEntry {

    @OriginalMember(owner = "client!se", name = "r", descriptor = "Ljava/lang/String;")
    public String value;

    @OriginalMember(owner = "client!se", name = "m", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!se", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doSetExtraSettingString(this.value, this.id);
    }

    @OriginalMember(owner = "client!se", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        this.id = packet.g4();
        this.value = packet.gjstr();
    }
}
