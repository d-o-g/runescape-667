package com.jagex.game;

import com.jagex.game.QuickChatDynamicCommand;
import com.jagex.game.QuickChatFillerDecoder;
import com.jagex.game.runetek6.config.enumtype.EnumType;
import com.jagex.game.runetek6.config.enumtype.EnumTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ms")
public final class SimpleFillerDecoder implements QuickChatFillerDecoder {

    @OriginalMember(owner = "client!ms", name = "a", descriptor = "(IJLclient!it;[I)Ljava/lang/String;")
    @Override
    public String decode(@OriginalArg(1) long value, @OriginalArg(2) QuickChatDynamicCommand command, @OriginalArg(3) int[] vars) {
        if (command == QuickChatDynamicCommand.LISTDIALOG) {
            @Pc(13) EnumType type = EnumTypeList.instance.list(vars[0]);
            return type.getString((int) value);
        } else if (command == QuickChatDynamicCommand.OBJDIALOG || command == QuickChatDynamicCommand.OBJTRADEDIALOG) {
            @Pc(41) ObjType objType = ObjTypeList.instance.list((int) value);
            return objType.name;
        } else if (QuickChatDynamicCommand.ENUM_STRING == command || command == QuickChatDynamicCommand.ENUM_STRING_CLAN || command == QuickChatDynamicCommand.ENUM_STRING_STATBASE) {
            return EnumTypeList.instance.list(vars[0]).getString((int) value);
        } else {
            return null;
        }
    }
}
