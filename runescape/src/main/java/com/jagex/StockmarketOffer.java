package com.jagex;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ho")
public final class StockmarketOffer {

    public static final int TYPE_BUY = 0;

    public static final int TYPE_SELL = 1;

    @OriginalMember(owner = "client!ho", name = "h", descriptor = "I")
    public int completedGold;

    @OriginalMember(owner = "client!ho", name = "j", descriptor = "I")
    public int objId;

    @OriginalMember(owner = "client!ho", name = "d", descriptor = "I")
    public int count;

    @OriginalMember(owner = "client!ho", name = "f", descriptor = "I")
    public int completedCount;

    @OriginalMember(owner = "client!ho", name = "a", descriptor = "B")
    public byte status;

    @OriginalMember(owner = "client!ho", name = "i", descriptor = "I")
    public int price;

    @OriginalMember(owner = "client!ho", name = "<init>", descriptor = "()V")
    public StockmarketOffer() {
    }

    @OriginalMember(owner = "client!ho", name = "<init>", descriptor = "(Lclient!ge;)V")
    public StockmarketOffer(@OriginalArg(0) Packet packet) {
        this.status = packet.g1b();
        this.objId = packet.g2();
        this.price = packet.g4();
        this.count = packet.g4();
        this.completedCount = packet.g4();
        this.completedGold = packet.g4();
    }

    @OriginalMember(owner = "client!ho", name = "a", descriptor = "(Z)I")
    public int getOfferType() {
        return (this.status & 0x8) == 8 ? TYPE_SELL : TYPE_BUY;
    }

    @OriginalMember(owner = "client!ho", name = "a", descriptor = "(I)I")
    public int getStatus() {
        return this.status & 0x7;
    }
}
