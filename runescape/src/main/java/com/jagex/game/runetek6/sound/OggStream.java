package com.jagex.game.runetek6.sound;

import com.jagex.core.datastruct.key.Node;
import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!kb")
public abstract class OggStream extends Node {

    @OriginalMember(owner = "client!kb", name = "m", descriptor = "I")
    public int packetNumber;

    @OriginalMember(owner = "client!kb", name = "o", descriptor = "Lclient!jagtheora/ogg/OggStreamState;")
    public final OggStreamState state;

    @OriginalMember(owner = "client!kb", name = "<init>", descriptor = "(Lclient!jagtheora/ogg/OggStreamState;)V")
    public OggStream(@OriginalArg(0) OggStreamState state) {
        this.state = state;
    }

    @OriginalMember(owner = "client!kb", name = "a", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    public final void handle(@OriginalArg(1) OggPacket packet) {
        this.decode(packet);
        this.packetNumber++;
    }

    @OriginalMember(owner = "client!kb", name = "b", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    protected abstract void decode(@OriginalArg(1) OggPacket packet);

    @OriginalMember(owner = "client!kb", name = "b", descriptor = "(I)V")
    public abstract void stop();
}
