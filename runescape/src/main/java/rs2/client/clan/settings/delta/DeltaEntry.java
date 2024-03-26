package rs2.client.clan.settings.delta;

import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!ga")
public abstract class DeltaEntry extends Node {

    @OriginalMember(owner = "client!ga", name = "a", descriptor = "(ILclient!ge;)V")
    public abstract void decode(@OriginalArg(1) Packet packet);

    @OriginalMember(owner = "client!ga", name = "a", descriptor = "(Lclient!hi;I)V")
    public abstract void applyTo(@OriginalArg(0) ClanSettings settings);
}
