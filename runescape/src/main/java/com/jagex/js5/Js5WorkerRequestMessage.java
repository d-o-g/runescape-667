package com.jagex.js5;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!rja")
public final class Js5WorkerRequestMessage extends ResourceRequest {

    @OriginalMember(owner = "client!rja", name = "H", descriptor = "B")
    public byte padding;

    @OriginalMember(owner = "client!rja", name = "z", descriptor = "I")
    public int blockPos;

    @OriginalMember(owner = "client!rja", name = "A", descriptor = "Lclient!ge;")
    public Packet packet;

    @OriginalMember(owner = "client!rja", name = "a", descriptor = "(I)[B")
    @Override
    public byte[] getData() {
        if (super.incomplete || this.packet.data.length - this.padding > this.packet.pos) {
            throw new RuntimeException();
        } else {
            return this.packet.data;
        }
    }

    @OriginalMember(owner = "client!rja", name = "c", descriptor = "(B)I")
    @Override
    public int completePercentage() {
        if (this.packet == null){
            return 0;
        } else {
            return (this.packet.pos * 100) / (this.packet.data.length - this.padding);
        }
    }
}
