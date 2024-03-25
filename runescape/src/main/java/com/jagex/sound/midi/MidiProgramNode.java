package com.jagex.sound.midi;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vd")
public final class MidiProgramNode extends Node {

    @OriginalMember(owner = "client!vd", name = "l", descriptor = "[B")
    public final byte[] notes;

    @OriginalMember(owner = "client!vd", name = "<init>", descriptor = "([B)V")
    public MidiProgramNode(@OriginalArg(0) byte[] notes) {
        this.notes = notes;
    }
}
