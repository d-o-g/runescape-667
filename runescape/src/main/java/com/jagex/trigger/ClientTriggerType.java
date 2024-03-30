package com.jagex.trigger;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mia")
public final class ClientTriggerType implements TriggerType {

    @OriginalMember(owner = "client!oi", name = "r", descriptor = "Lclient!mia;")
    public static final ClientTriggerType VIDEO_END = new ClientTriggerType("", 18);

    @OriginalMember(owner = "client!ji", name = "x", descriptor = "Lclient!mia;")
    public static final ClientTriggerType OP_MAPELEMENT1 = new ClientTriggerType("", 10);

    @OriginalMember(owner = "client!bf", name = "p", descriptor = "Lclient!mia;")
    public static final ClientTriggerType OP_MAPELEMENT2 = new ClientTriggerType("", 11);

    @OriginalMember(owner = "client!kla", name = "Xb", descriptor = "Lclient!mia;")
    public static final ClientTriggerType OP_MAPELEMENT3 = new ClientTriggerType("", 12);

    @OriginalMember(owner = "client!qda", name = "x", descriptor = "Lclient!mia;")
    public static final ClientTriggerType OP_MAPELEMENT4 = new ClientTriggerType("", 13);

    @OriginalMember(owner = "client!bb", name = "b", descriptor = "Lclient!mia;")
    public static final ClientTriggerType OP_MAPELEMENT5 = new ClientTriggerType("", 14);

    @OriginalMember(owner = "client!aca", name = "e", descriptor = "Lclient!mia;")
    public static final ClientTriggerType MAP_ELEMENT_MOUSEOVER = new ClientTriggerType("", 15);

    @OriginalMember(owner = "client!ip", name = "v", descriptor = "Lclient!mia;")
    public static final ClientTriggerType MAP_ELEMENT_MOUSELEAVE = new ClientTriggerType("", 16);

    @OriginalMember(owner = "client!ud", name = "K", descriptor = "Lclient!mia;")
    public static final ClientTriggerType MAP_ELEMENT_MOUSEREPEAT = new ClientTriggerType("", 17);

    @OriginalMember(owner = "client!lha", name = "f", descriptor = "Lclient!mia;")
    public static final ClientTriggerType JCOINS_UPDATE = new ClientTriggerType("", 19);

    @OriginalMember(owner = "client!bh", name = "w", descriptor = "Lclient!mia;")
    public static final ClientTriggerType CUTSCENE_SUBTITLE = new ClientTriggerType("", 20);

    @OriginalMember(owner = "client!hda", name = "u", descriptor = "Lclient!mia;")
    public static final ClientTriggerType LOYALTY_UPDATED = new ClientTriggerType("", 21);

    public static ClientTriggerType PROC = new ClientTriggerType("", 73);

    public static ClientTriggerType CLIENTSCRIPT = new ClientTriggerType("", 76);

    @OriginalMember(owner = "client!mia", name = "a", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!mia", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public ClientTriggerType(@OriginalArg(0) String name, @OriginalArg(1) int id) {
        this.id = id;
    }

    @OriginalMember(owner = "client!mia", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
