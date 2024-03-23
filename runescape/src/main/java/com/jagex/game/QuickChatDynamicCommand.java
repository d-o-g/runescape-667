package com.jagex.game;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!it")
public final class QuickChatDynamicCommand {

    @OriginalMember(owner = "client!mla", name = "d", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand LISTDIALOG = new QuickChatDynamicCommand(0, 2, 2, 1);

    @OriginalMember(owner = "client!rl", name = "m", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand OBJDIALOG = new QuickChatDynamicCommand(1, 2, 2, 0);

    @OriginalMember(owner = "client!vea", name = "I", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand COUNTDIALOG = new QuickChatDynamicCommand(2, 4, 4, 0);

    @OriginalMember(owner = "client!hi", name = "A", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand STAT_BASE = new QuickChatDynamicCommand(4, 1, 1, 1);

    @OriginalMember(owner = "client!bma", name = "a", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand ENUM_STRING = new QuickChatDynamicCommand(6, 0, 4, 2);

    @OriginalMember(owner = "client!uea", name = "b", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand ENUM_STRING_CLAN = new QuickChatDynamicCommand(7, 0, 1, 1);

    @OriginalMember(owner = "client!cv", name = "n", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand TOSTRING_VARP = new QuickChatDynamicCommand(8, 0, 4, 1);

    @OriginalMember(owner = "client!li", name = "a", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand TOSTRING_VARBIT = new QuickChatDynamicCommand(9, 0, 4, 1);

    @OriginalMember(owner = "client!pw", name = "t", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand OBJTRADEDIALOG = new QuickChatDynamicCommand(10, 2, 2, 0);

    @OriginalMember(owner = "client!gha", name = "u", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand ENUM_STRING_STATBASE = new QuickChatDynamicCommand(11, 0, 1, 2);

    @OriginalMember(owner = "client!tea", name = "i", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand ACC_GETCOUNT_WORLD = new QuickChatDynamicCommand(12, 0, 1, 0);

    @OriginalMember(owner = "client!cn", name = "k", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand ACC_GETMEANCOMBATLEVEL = new QuickChatDynamicCommand(13, 0, 1, 0);

    @OriginalMember(owner = "client!hu", name = "o", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand TOSTRING_SHARED = new QuickChatDynamicCommand(14, 0, 4, 1);

    @OriginalMember(owner = "client!wf", name = "q", descriptor = "Lclient!it;")
    public static final QuickChatDynamicCommand ACTIVECOMBATLEVEL = new QuickChatDynamicCommand(15, 0, 1, 0);

    @OriginalMember(owner = "client!it", name = "b", descriptor = "I")
    public final int anInt4573;

    @OriginalMember(owner = "client!it", name = "f", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!it", name = "c", descriptor = "I")
    public final int anInt4577;

    @OriginalMember(owner = "client!it", name = "a", descriptor = "I")
    public final int anInt4576;

    @OriginalMember(owner = "client!it", name = "<init>", descriptor = "(IIII)V")
    public QuickChatDynamicCommand(@OriginalArg(0) int id, @OriginalArg(1) int writeSize, @OriginalArg(2) int readSize, @OriginalArg(3) int varCount) {
        this.anInt4573 = varCount;
        this.id = id;
        this.anInt4577 = readSize;
        this.anInt4576 = writeSize;
    }

    @OriginalMember(owner = "client!rd", name = "a", descriptor = "(I)[Lclient!it;")
    public static QuickChatDynamicCommand[] values() {
        return new QuickChatDynamicCommand[]{
            LISTDIALOG,
            OBJDIALOG,
            COUNTDIALOG,
            STAT_BASE,
            ENUM_STRING,
            ENUM_STRING_CLAN,
            TOSTRING_VARP,
            TOSTRING_VARBIT,
            OBJTRADEDIALOG,
            ENUM_STRING_STATBASE,
            ACC_GETCOUNT_WORLD,
            ACC_GETMEANCOMBATLEVEL,
            TOSTRING_SHARED,
            ACTIVECOMBATLEVEL
        };
    }

    @OriginalMember(owner = "client!oaa", name = "a", descriptor = "(BI)Lclient!it;")
    public static QuickChatDynamicCommand fromId(@OriginalArg(1) int id) {
        @Pc(6) QuickChatDynamicCommand[] values = values();

        for (@Pc(8) int i = 0; i < values.length; i++) {
            if (values[i].id == id) {
                return values[i];
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!it", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
