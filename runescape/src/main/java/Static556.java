import com.jagex.core.datastruct.key.Class331;
import com.jagex.core.constants.ModeGame;
import com.jagex.graphics.Font;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static556 {

    @OriginalMember(owner = "client!rj", name = "c", descriptor = "Lclient!ca;")
    public static Class8_Sub2_Sub1_Sub2_Sub1 aClass8_Sub2_Sub1_Sub2_Sub1_2;

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "Lclient!uc;")
    public static Environment aEnvironment_2;

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(BLclient!hda;)Lclient!hda;")
    public static Component method7299(@OriginalArg(1) Component arg0) {
        if (arg0.layer != -1) {
            return InterfaceList.list(arg0.layer);
        }
        @Pc(25) int local25 = arg0.slot >>> 16;
        @Pc(30) Class331 local30 = new Class331(Static548.aHashTable_40);
        for (@Pc(35) Node_Sub4 local35 = (Node_Sub4) local30.first(); local35 != null; local35 = (Node_Sub4) local30.next()) {
            if (local35.anInt147 == local25) {
                return InterfaceList.list((int) local35.key);
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IB)V")
    public static void method7300(@OriginalArg(0) int arg0) {
        Static682.anIntArray817 = new int[arg0];
        Static153.anIntArray235 = new int[arg0];
        Static9.anIntArray18 = new int[arg0];
        Static482.anIntArray588 = new int[arg0];
        Static457.anIntArray552 = new int[arg0];
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(Lclient!ha;I)V")
    public static void method7301(@OriginalArg(0) Toolkit arg0) {
        if (Static594.anInt8777 < 2 && !Static156.aBoolean223 || InterfaceManager.dragSource != null) {
            return;
        }
        @Pc(63) String local63;
        if (Static156.aBoolean223 && Static594.anInt8777 < 2) {
            local63 = Static153.aString27 + LocalisedText.MINISEPARATOR.localise(Static51.anInt1052) + Static128.aString108 + " ->";
        } else if (Static209.aBoolean269 && Static334.aClass319_1.method8479(81) && Static594.anInt8777 > 2) {
            local63 = Static518.method9293(Static470.aClass2_Sub2_Sub16_10);
        } else {
            @Pc(55) DoublyLinkedNode_Sub2_Sub16 local55 = Static470.aClass2_Sub2_Sub16_10;
            if (local55 == null) {
                return;
            }
            local63 = Static518.method9293(local55);
            @Pc(65) int[] local65 = null;
            if (Static245.method8635(local55.anInt7314)) {
                local65 = Static419.aObjTypeList_1.list((int) local55.aLong233).quests;
            } else if (local55.anInt7317 != -1) {
                local65 = Static419.aObjTypeList_1.list(local55.anInt7317).quests;
            } else if (Static598.method7825(local55.anInt7314)) {
                @Pc(93) Node_Sub45 local93 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) (int) local55.aLong233);
                if (local93 != null) {
                    @Pc(98) Class8_Sub2_Sub1_Sub2_Sub2 local98 = local93.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                    @Pc(101) NPCType local101 = local98.aNPCType_1;
                    if (local101.multinpcs != null) {
                        local101 = local101.getMultiNPC(65535, Static34.aClass304_1);
                    }
                    if (local101 != null) {
                        local65 = local101.quests;
                    }
                }
            } else if (Static523.method3444(local55.anInt7314)) {
                @Pc(131) LocType local131 = Static354.aLocTypeList_4.list((int) (local55.aLong233 >>> 32 & 0x7FFFFFFFL));
                if (local131.multiLocs != null) {
                    local131 = local131.getMultiLoc(Static34.aClass304_1);
                }
                if (local131 != null) {
                    local65 = local131.quests;
                }
            }
            if (local65 != null) {
                local63 = local63 + Static72.method1527(local65);
            }
        }
        if (Static594.anInt8777 > 2) {
            local63 = local63 + "<col=ffffff> / " + (Static594.anInt8777 - 2) + LocalisedText.MOREOPTIONS.localise(Static51.anInt1052);
        }
        if (Static605.aComponent_15 != null) {
            @Pc(232) Font local232 = Static605.aComponent_15.font(arg0);
            if (local232 == null) {
                local232 = Fonts.b12;
            }
            local232.renderRandom(Static329.anIntArray163, Static605.aComponent_15.horizontalAlignment, Static605.aComponent_15.width, Static460.anIntArray554, Static605.aComponent_15.colour, Static605.aComponent_15.height, Static493.aRandom1, local63, Static366.anInt5852, Static605.aComponent_15.shadow, Static186.aSpriteArray5, Static178.anInt2947, Static157.anInt2777, Static605.aComponent_15.verticalAlignment);
            Static585.method7670(Static329.anIntArray163[2], Static329.anIntArray163[0], Static329.anIntArray163[3], Static329.anIntArray163[1]);
        } else if (InterfaceManager.optionsComponent != null && Static392.aModeGame_4 == ModeGame.RUNESCAPE) {
            @Pc(299) int local299 = Fonts.b12.renderRandom(Static186.aSpriteArray5, Static178.anInt2947, 0xFFFFFF, InterfaceManager.anInt3123 + 16, local63, Static460.anIntArray554, 0, Static493.aRandom1, InterfaceManager.anInt10936 + 4);
            Static585.method7670(local299 + Fonts.b12Metrics.stringWidth(local63), InterfaceManager.anInt10936 - -4, 16, InterfaceManager.anInt3123);
        }
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(B)I")
    public static int method7302() {
        return Static449.aClass364_1.method8379();
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IBZ)Lclient!gfa;")
    public static Node_Sub22 method7303(@OriginalArg(0) int arg0, @OriginalArg(2) boolean arg1) {
        @Pc(19) long local19 = (long) (arg0 | (arg1 ? Integer.MIN_VALUE : 0));
        return (Node_Sub22) Static286.A_HASH_TABLE___23.get(local19);
    }
}
