package com.jagex.game;

import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.DoublyLinkedNode;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!aj")
public final class DelayedStateChange extends DoublyLinkedNode {

    public static final int TYPE_SETVARC = 1;

    public static final int TYPE_SETVARCSTR = 2;

    public static final int TYPE_IF_SETTEXT = 3;

    public static final int TYPE_IF_SETMODEL = 4;

    public static final int TYPE_IF_SETMODELANIM = 5;

    public static final int TYPE_IF_SETCOLOUR = 6;

    public static final int TYPE_IF_SETHIDE = 7;

    public static final int TYPE_IF_SETMODELANGLE = 8;

    public static final int TYPE_IF_SETOBJECT = 9;

    public static final int TYPE_IF_SETMODELOFFSET = 10;

    public static final int TYPE_IF_SETPOSITION = 11;

    public static final int TYPE_IF_SETSCROLLPOS = 12;

    public static final int TYPE_IF_SETGRAPHIC = 14;

    public static final int TYPE_SETMAPFLAG = 15;

    public static final int TYPE_IF_SETTEXTFONT = 16;

    public static final int TYPE_IF_SETVIDEO = 17;

    public static final int TYPE_IF_SETRECOL = 18;

    public static final int TYPE_IF_SETRETEX = 19;

    public static final int TYPE_IF_SETFONTMONO = 20;

    public static final int TYPE_IF_SETCLICKMASK = 21;

    @OriginalMember(owner = "client!us", name = "k", descriptor = "Lclient!av;")
    private static final IterableHashTable<DelayedStateChange> changes = new IterableHashTable<DelayedStateChange>(16);

    @OriginalMember(owner = "client!bv", name = "k", descriptor = "Lclient!jga;")
    private static final Queue<DelayedStateChange> delayed = new Queue<>();

    @OriginalMember(owner = "client!efa", name = "e", descriptor = "Lclient!jga;")
    private static final Queue<DelayedStateChange> immediate = new Queue<>();

    @OriginalMember(owner = "client!cka", name = "a", descriptor = "(I)Lclient!aj;")
    public static DelayedStateChange removeFirst() {
        @Pc(17) DelayedStateChange change = immediate.first();
        if (change != null) {
            change.unlink();
            change.unlink2();
            return change;
        }

        do {
            change = delayed.first();
            if (change == null) {
                return null;
            }
            if (change.getTime() > SystemTimer.safetime()) {
                return null;
            }
            change.unlink();
            change.unlink2();
        } while ((change.key2 & Long.MIN_VALUE) == 0L);

        return change;
    }

    @OriginalMember(owner = "client!nt", name = "a", descriptor = "(IIJ)Lclient!aj;")
    private static DelayedStateChange getOrAdd(@OriginalArg(1) int type, @OriginalArg(2) long value) {
        @Pc(21) DelayedStateChange change = changes.get(((long) type << 56) | value);

        if (change == null) {
            change = new DelayedStateChange(type, value);
            changes.put(change.key, change);
        }

        return change;
    }

    @OriginalMember(owner = "client!ee", name = "a", descriptor = "(ZI)V")
    public static void resetVarc(@OriginalArg(1) int id) {
        @Pc(14) DelayedStateChange change = getOrAdd(TYPE_SETVARC, id);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!r", name = "a", descriptor = "(IBI)V")
    public static void setVarc(@OriginalArg(2) int id, @OriginalArg(0) int value) {
        @Pc(16) DelayedStateChange change = getOrAdd(TYPE_SETVARC, id);
        change.setClientServerUpdate();
        change.primaryData = value;
    }

    @OriginalMember(owner = "client!cm", name = "a", descriptor = "(II)V")
    public static void resetVarcstr(@OriginalArg(1) int id) {
        @Pc(11) DelayedStateChange change = getOrAdd(TYPE_SETVARCSTR, id);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!mh", name = "a", descriptor = "(ZILjava/lang/String;)V")
    public static void setVarcstr(@OriginalArg(1) int id, @OriginalArg(2) String string) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_SETVARCSTR, id);
        change.setClientServerUpdate();
        change.stringData = string;
    }

    @OriginalMember(owner = "client!tfa", name = "a", descriptor = "(II)V")
    public static void interfaceResetText(@OriginalArg(1) int idAndSlot) {
        @Pc(23) DelayedStateChange change = getOrAdd(TYPE_IF_SETTEXT, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!gj", name = "a", descriptor = "(IILjava/lang/String;)V")
    public static void interfaceSetText(@OriginalArg(0) int idAndSlot, @OriginalArg(2) String text) {
        @Pc(16) DelayedStateChange change = getOrAdd(TYPE_IF_SETTEXT, idAndSlot);
        change.setClientServerUpdate();
        change.stringData = text;
    }

    @OriginalMember(owner = "client!da", name = "b", descriptor = "(II)V")
    public static void interfaceResetModel(@OriginalArg(1) int idAndSlot) {
        @Pc(18) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODEL, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!pc", name = "a", descriptor = "(IIIII)V")
    public static void interfaceSetModel(@OriginalArg(3) int idAndSlot, @OriginalArg(1) int objType, @OriginalArg(0) int obj, @OriginalArg(2) int objData) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODEL, idAndSlot);
        change.setClientServerUpdate();
        change.tertiaryData = objData;
        change.primaryData = objType;
        change.secondaryData = obj;
    }

    @OriginalMember(owner = "client!ca", name = "b", descriptor = "(II)V")
    public static void interfaceResetModelAnim(@OriginalArg(0) int idAndSlot) {
        @Pc(17) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODELANIM, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(IIB)V")
    public static void interfaceSetModelAnim(@OriginalArg(0) int idAndSlot, @OriginalArg(1) int anim) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODELANIM, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = anim;
    }

    @OriginalMember(owner = "client!ua", name = "a", descriptor = "(ZI)V")
    public static void interfaceResetColour(@OriginalArg(1) int idAndSlot) {
        @Pc(16) DelayedStateChange change = getOrAdd(TYPE_IF_SETCOLOUR, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!aaa", name = "d", descriptor = "(III)V")
    public static void interfaceSetColour(@OriginalArg(2) int idAndSlot, @OriginalArg(1) int colour) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETCOLOUR, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = colour;
    }

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(II)V")
    public static void interfaceResetHide(@OriginalArg(1) int idAndSlot) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETHIDE, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!oda", name = "a", descriptor = "(BII)V")
    public static void interfaceSetHide(@OriginalArg(2) int idAndSlot, @OriginalArg(1) int visible) {
        @Pc(16) DelayedStateChange change = getOrAdd(TYPE_IF_SETHIDE, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = visible;
    }

    @OriginalMember(owner = "client!ci", name = "b", descriptor = "(IZ)V")
    public static void interfaceResetModelAngle(@OriginalArg(0) int idAndSlot) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODELANGLE, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "(IIIII)V")
    public static void interfaceSetModelAngle(@OriginalArg(3) int idAndSlot, @OriginalArg(0) int xan2d, @OriginalArg(4) int yan2d, @OriginalArg(1) int zoom2d) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODELANGLE, idAndSlot);
        change.setClientServerUpdate();
        change.secondaryData = yan2d;
        change.tertiaryData = zoom2d;
        change.primaryData = xan2d;
    }

    @OriginalMember(owner = "client!kh", name = "a", descriptor = "(BI)V")
    public static void interfaceResetObject(@OriginalArg(1) int idAndSlot) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETOBJECT, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!jja", name = "a", descriptor = "(IIII)V")
    public static void interfaceSetObject(@OriginalArg(0) int idAndSlot, @OriginalArg(1) int count, @OriginalArg(2) int objId) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETOBJECT, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = objId;
        change.secondaryData = count;
    }

    @OriginalMember(owner = "client!sea", name = "a", descriptor = "(II)V")
    public static void interfaceResetModelOffset(@OriginalArg(0) int idAndSlot) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODELOFFSET, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!ql", name = "a", descriptor = "(BIIII)V")
    public static void interfaceSetModelOffset(@OriginalArg(2) int idAndSlot, @OriginalArg(4) int xof2d, @OriginalArg(3) int yof2d, @OriginalArg(1) int zan2d) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETMODELOFFSET, idAndSlot);
        change.setClientServerUpdate();
        change.secondaryData = yof2d;
        change.primaryData = xof2d;
        change.tertiaryData = zan2d;
    }

    @OriginalMember(owner = "client!nc", name = "a", descriptor = "(II)V")
    public static void interfaceResetPosition(@OriginalArg(0) int idAndSlot) {
        @Pc(16) DelayedStateChange change = getOrAdd(TYPE_IF_SETPOSITION, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!ria", name = "a", descriptor = "(IIII)V")
    public static void interfaceSetPosition(@OriginalArg(3) int idAndSlot, @OriginalArg(0) int x, @OriginalArg(2) int y) {
        @Pc(14) DelayedStateChange change = getOrAdd(TYPE_IF_SETPOSITION, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = x;
        change.secondaryData = y;
    }

    @OriginalMember(owner = "client!nm", name = "b", descriptor = "(II)V")
    public static void interfaceResetScrollPosition(@OriginalArg(1) int idAndSlot) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETSCROLLPOS, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!m", name = "a", descriptor = "(BII)V")
    public static void interfaceSetScrollPosition(@OriginalArg(2) int idAndSlot, @OriginalArg(1) int position) {
        @Pc(14) DelayedStateChange change = getOrAdd(TYPE_IF_SETSCROLLPOS, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = position;
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(III)V")
    public static void method4347(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        @Pc(14) DelayedStateChange change = getOrAdd(13, arg0);
        change.setClientServerUpdate();
        change.primaryData = arg1;
    }

    @OriginalMember(owner = "client!hfa", name = "a", descriptor = "(IZ)V")
    public static void interfaceResetGraphic(@OriginalArg(0) int idAndSlot) {
        @Pc(16) DelayedStateChange change = getOrAdd(TYPE_IF_SETGRAPHIC, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!uh", name = "a", descriptor = "(III)V")
    public static void interfaceSetGraphic(@OriginalArg(0) int idAndSlot, @OriginalArg(1) int graphic) {
        @Pc(20) DelayedStateChange change = getOrAdd(TYPE_IF_SETGRAPHIC, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = graphic;
    }

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(B)V")
    public static void resetMapFlag() {
        @Pc(13) DelayedStateChange change = getOrAdd(TYPE_SETMAPFLAG, 0L);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!bm", name = "a", descriptor = "(IIB)V")
    public static void setMapFlag(@OriginalArg(1) int x, @OriginalArg(0) int y) {
        @Pc(8) DelayedStateChange change = getOrAdd(TYPE_SETMAPFLAG, 0L);
        change.setClientServerUpdate();
        change.primaryData = x;
        change.secondaryData = y;
    }

    @OriginalMember(owner = "client!ik", name = "a", descriptor = "(II)V")
    public static void interfaceResetTextFont(@OriginalArg(0) int idAndSlot) {
        @Pc(17) DelayedStateChange change = getOrAdd(TYPE_IF_SETTEXTFONT, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!vk", name = "a", descriptor = "(III)V")
    public static void interfaceSetTextFont(@OriginalArg(1) int idAndSlot, @OriginalArg(2) int font) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETTEXTFONT, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = font;
    }

    @OriginalMember(owner = "client!ck", name = "a", descriptor = "(II)V")
    public static void interfaceResetVideo(@OriginalArg(1) int idAndSlot) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETVIDEO, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(III)V")
    public static void interfaceSetVideo(@OriginalArg(2) int idAndSlot, @OriginalArg(1) int video) {
        @Pc(9) DelayedStateChange change = getOrAdd(TYPE_IF_SETVIDEO, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = video;
    }

    @OriginalMember(owner = "client!kca", name = "a", descriptor = "(IIZ)V")
    public static void interfaceResetRecol(@OriginalArg(0) int idAndSlot, @OriginalArg(1) int index) {
        @Pc(23) DelayedStateChange change = getOrAdd(TYPE_IF_SETRECOL, ((long) index << 32) | (long) idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!gu", name = "a", descriptor = "(IIIII)V")
    public static void interfaceSetRecol(@OriginalArg(3) int idAndSlot, @OriginalArg(0) int index, @OriginalArg(4) int source, @OriginalArg(1) int destination) {
        @Pc(22) DelayedStateChange change = getOrAdd(TYPE_IF_SETRECOL, ((long) index << 32) | (long) idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = source;
        change.secondaryData = destination;
    }

    @OriginalMember(owner = "client!vu", name = "a", descriptor = "(III)V")
    public static void interfaceResetRetex(@OriginalArg(0) int idAndSlot, @OriginalArg(1) int index) {
        @Pc(21) DelayedStateChange change = getOrAdd(TYPE_IF_SETRETEX, ((long) index << 32) | (long) idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!fd", name = "a", descriptor = "(IIIII)V")
    public static void interfaceSetRetex(@OriginalArg(3) int idAndSlot, @OriginalArg(2) int index, @OriginalArg(1) int source, @OriginalArg(4) int destination) {
        @Pc(14) DelayedStateChange change = getOrAdd(TYPE_IF_SETRETEX, ((long) index << 32) | (long) idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = source;
        change.secondaryData = destination;
    }

    @OriginalMember(owner = "client!vka", name = "b", descriptor = "(II)V")
    public static void interfaceResetFontMono(@OriginalArg(1) int idAndSlot) {
        @Pc(17) DelayedStateChange change = getOrAdd(TYPE_IF_SETFONTMONO, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!cea", name = "a", descriptor = "(IB)V")
    public static void interfaceResetClickmask(@OriginalArg(0) int idAndSlot) {
        @Pc(18) DelayedStateChange change = getOrAdd(TYPE_IF_SETCLICKMASK, idAndSlot);
        change.prepareDelayed();
    }

    @OriginalMember(owner = "client!pg", name = "a", descriptor = "(IIZ)V")
    public static void interfaceSetClickMask(@OriginalArg(0) int idAndSlot, @OriginalArg(2) boolean clickMask) {
        @Pc(21) DelayedStateChange change = getOrAdd(TYPE_IF_SETCLICKMASK, idAndSlot);
        change.setClientServerUpdate();
        change.primaryData = clickMask ? 1 : 0;
    }

    @OriginalMember(owner = "client!oha", name = "a", descriptor = "(B)V")
    public static void clear() {
        changes.clear();
        delayed.clear();
        immediate.clear();
    }

    @OriginalMember(owner = "client!aj", name = "x", descriptor = "Ljava/lang/String;")
    public String stringData;

    @OriginalMember(owner = "client!aj", name = "A", descriptor = "I")
    public int tertiaryData;

    @OriginalMember(owner = "client!aj", name = "w", descriptor = "I")
    public int secondaryData;

    @OriginalMember(owner = "client!aj", name = "t", descriptor = "I")
    public int primaryData;

    @OriginalMember(owner = "client!aj", name = "<init>", descriptor = "(IJ)V")
    public DelayedStateChange(@OriginalArg(0) int type, @OriginalArg(1) long value) {
        super.key = ((long) type << 56) | value;
    }

    @OriginalMember(owner = "client!aj", name = "g", descriptor = "(I)J")
    public long getTime() {
        return super.key2 & Long.MAX_VALUE;
    }

    @OriginalMember(owner = "client!aj", name = "i", descriptor = "(I)V")
    public void setClientServerUpdate() {
        super.key2 |= Long.MIN_VALUE;

        if (this.getTime() == (long) 0) {
            immediate.add(this);
        }
    }

    @OriginalMember(owner = "client!aj", name = "a", descriptor = "(I)I")
    public int getType() {
        return (int) (super.key >>> 56 & 0xFFL);
    }

    @OriginalMember(owner = "client!aj", name = "h", descriptor = "(I)J")
    public long getValue() {
        return super.key & 0xFFFFFFFFFFFFFFL;
    }

    @OriginalMember(owner = "client!aj", name = "c", descriptor = "(B)V")
    public void prepareDelayed() {
        super.key2 = (SystemTimer.safetime() + 500L) | (super.key2 & Long.MIN_VALUE);
        delayed.add(this);
    }
}
