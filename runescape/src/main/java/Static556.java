import com.jagex.core.datastruct.key.HashTableIterator;
import com.jagex.core.constants.ModeGame;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Font;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static556 {

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "Lclient!uc;")
    public static Environment aEnvironment_2;

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(BLclient!hda;)Lclient!hda;")
    public static Component method7299(@OriginalArg(1) Component arg0) {
        if (arg0.layer != -1) {
            return InterfaceList.list(arg0.layer);
        }
        @Pc(25) int local25 = arg0.slot >>> 16;
        @Pc(30) HashTableIterator local30 = new HashTableIterator(InterfaceManager.subInterfaces);
        for (@Pc(35) SubInterface local35 = (SubInterface) local30.first(); local35 != null; local35 = (SubInterface) local30.next()) {
            if (local35.id == local25) {
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
        if (MiniMenu.entryCount < 2 && !InterfaceManager.targeting || InterfaceManager.dragSource != null) {
            return;
        }
        @Pc(63) String local63;
        if (InterfaceManager.targeting && MiniMenu.entryCount < 2) {
            local63 = InterfaceManager.targetVerb + LocalisedText.MINISEPARATOR.localise(client.language) + InterfaceManager.targetedVerb + " ->";
        } else if (Static209.aBoolean269 && KeyMonitor.instance.isPressed(81) && MiniMenu.entryCount > 2) {
            local63 = Static518.method9293(Static470.aClass2_Sub2_Sub16_10);
        } else {
            @Pc(55) MiniMenuEntry local55 = Static470.aClass2_Sub2_Sub16_10;
            if (local55 == null) {
                return;
            }
            local63 = Static518.method9293(local55);
            @Pc(65) int[] local65 = null;
            if (Static245.method8635(local55.action)) {
                local65 = ObjTypeList.instance.list((int) local55.aLong233).quests;
            } else if (local55.anInt7317 != -1) {
                local65 = ObjTypeList.instance.list(local55.anInt7317).quests;
            } else if (Static598.method7825(local55.action)) {
                @Pc(93) Node_Sub45 local93 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((int) local55.aLong233);
                if (local93 != null) {
                    @Pc(98) NPCEntity local98 = local93.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                    @Pc(101) NPCType local101 = local98.type;
                    if (local101.multinpcs != null) {
                        local101 = local101.getMultiNPC(TimedVarDomain.instance);
                    }
                    if (local101 != null) {
                        local65 = local101.quests;
                    }
                }
            } else if (Static523.method3444(local55.action)) {
                @Pc(131) LocType local131 = LocTypeList.instance.list((int) (local55.aLong233 >>> 32 & 0x7FFFFFFFL));
                if (local131.multiLocs != null) {
                    local131 = local131.getMultiLoc(TimedVarDomain.instance);
                }
                if (local131 != null) {
                    local65 = local131.quests;
                }
            }
            if (local65 != null) {
                local63 = local63 + Static72.method1527(local65);
            }
        }
        if (MiniMenu.entryCount > 2) {
            local63 = local63 + "<col=ffffff> / " + (MiniMenu.entryCount - 2) + LocalisedText.MOREOPTIONS.localise(client.language);
        }
        if (WorldMap.optionsComponent != null) {
            @Pc(232) Font local232 = WorldMap.optionsComponent.font(arg0);
            if (local232 == null) {
                local232 = Fonts.b12;
            }
            local232.renderRandom(Static329.anIntArray163, WorldMap.optionsComponent.horizontalAlignment, WorldMap.optionsComponent.width, Static460.anIntArray554, WorldMap.optionsComponent.colour, WorldMap.optionsComponent.height, Static493.aRandom1, local63, WorldMap.optionsX, WorldMap.optionsComponent.shadow, Static186.aSpriteArray5, Static178.anInt2947, WorldMap.optionsY, WorldMap.optionsComponent.verticalAlignment);
            Static585.method7670(Static329.anIntArray163[2], Static329.anIntArray163[0], Static329.anIntArray163[3], Static329.anIntArray163[1]);
        } else if (InterfaceManager.optionsComponent != null && client.modeGame == ModeGame.RUNESCAPE) {
            @Pc(299) int local299 = Fonts.b12.renderRandom(Static186.aSpriteArray5, Static178.anInt2947, 0xFFFFFF, InterfaceManager.optionsY + 16, local63, Static460.anIntArray554, 0, Static493.aRandom1, InterfaceManager.optionsX + 4);
            Static585.method7670(local299 + Fonts.b12Metrics.stringWidth(local63), InterfaceManager.optionsX - -4, 16, InterfaceManager.optionsY);
        }
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(B)I")
    public static int method7302() {
        return Static449.aClass364_1.method8379();
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IBZ)Lclient!gfa;")
    public static ClientInventory method7303(@OriginalArg(0) int arg0, @OriginalArg(2) boolean arg1) {
        @Pc(19) long local19 = arg0 | (arg1 ? Integer.MIN_VALUE : 0);
        return (ClientInventory) Static286.A_HASH_TABLE___23.get(local19);
    }
}
