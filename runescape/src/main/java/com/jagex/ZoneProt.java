package com.jagex;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pc")
public final class ZoneProt {

    @OriginalMember(owner = "client!oda", name = "v", descriptor = "Lclient!pc;")
    public static final ZoneProt LOC_ADD_CHANGE = new ZoneProt(0, 4);

    @OriginalMember(owner = "client!pd", name = "p", descriptor = "Lclient!pc;")
    public static final ZoneProt SOUND_AREA = new ZoneProt(1, 8);

    @OriginalMember(owner = "client!lu", name = "I", descriptor = "Lclient!pc;")
    public static final ZoneProt LOC_CUSTOMISE = new ZoneProt(2, -1);

    @OriginalMember(owner = "client!nea", name = "c", descriptor = "Lclient!pc;")
    public static final ZoneProt LOC_ANIM = new ZoneProt(3, 4);

    @OriginalMember(owner = "client!kga", name = "G", descriptor = "Lclient!pc;")
    public static final ZoneProt LOC_PREFETCH = new ZoneProt(4, 3);

    @OriginalMember(owner = "client!rq", name = "H", descriptor = "Lclient!pc;")
    public static final ZoneProt OBJ_DEL = new ZoneProt(5, 3);

    @OriginalMember(owner = "client!cg", name = "W", descriptor = "Lclient!pc;")
    public static final ZoneProt MAP_PROJANIM = new ZoneProt(6, 16);

    @OriginalMember(owner = "client!gia", name = "t", descriptor = "Lclient!pc;")
    public static final ZoneProt LOC_DEL = new ZoneProt(7, 2);

    @OriginalMember(owner = "client!wea", name = "P", descriptor = "Lclient!pc;")
    public static final ZoneProt OBJ_COUNT = new ZoneProt(8, 7);

    @OriginalMember(owner = "client!lm", name = "j", descriptor = "Lclient!pc;")
    public static final ZoneProt TEXT_COORD = new ZoneProt(9, -1);

    @OriginalMember(owner = "client!ab", name = "u", descriptor = "Lclient!pc;")
    public static final ZoneProt MAP_PROJANIM_HALFSQ = new ZoneProt(10, 19);

    @OriginalMember(owner = "client!client", name = "vb", descriptor = "Lclient!pc;")
    public static final ZoneProt SOUND_VORBIS_AREA = new ZoneProt(11, 8);

    @OriginalMember(owner = "client!vca", name = "i", descriptor = "Lclient!pc;")
    public static final ZoneProt MAP_ANIM = new ZoneProt(12, 7);

    @OriginalMember(owner = "client!ci", name = "g", descriptor = "Lclient!pc;")
    public static final ZoneProt OBJ_REVEAL = new ZoneProt(13, 7);

    @OriginalMember(owner = "client!aka", name = "j", descriptor = "Lclient!pc;")
    public static final ZoneProt OBJ_ADD = new ZoneProt(14, 5);

    @OriginalMember(owner = "client!rka", name = "z", descriptor = "(I)[Lclient!pc;")
    public static ZoneProt[] values() {
        return new ZoneProt[]{
            LOC_ADD_CHANGE,
            SOUND_AREA,
            LOC_CUSTOMISE,
            LOC_ANIM,
            LOC_PREFETCH,
            OBJ_DEL,
            MAP_PROJANIM,
            LOC_DEL,
            OBJ_COUNT,
            TEXT_COORD,
            MAP_PROJANIM_HALFSQ,
            SOUND_VORBIS_AREA,
            MAP_ANIM,
            OBJ_REVEAL,
            OBJ_ADD,
        };
    }

    @OriginalMember(owner = "client!pc", name = "<init>", descriptor = "(II)V")
    public ZoneProt(@OriginalArg(0) int opcode, @OriginalArg(1) int length) {
    }

    @OriginalMember(owner = "client!pc", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
