import com.jagex.DisplayProperties;
import com.jagex.SignLink;
import com.jagex.core.constants.MiniMenuAction;
import com.jagex.core.constants.ModeWhat;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.compression.huffman.WordPack;
import com.jagex.game.runetek6.config.enumtype.EnumMapping;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.enumtype.EnumStringMapping;
import com.jagex.game.runetek6.config.enumtype.EnumType;
import com.jagex.game.runetek6.config.enumtype.EnumTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementType;
import com.jagex.game.runetek6.config.meltype.MapElementTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.structtype.StructTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingType;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingTypeList;
import com.jagex.game.runetek6.config.vartype.clan.VarClanType;
import com.jagex.game.runetek6.config.vartype.clan.VarClanTypeList;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.math.ColourUtils;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.Arrays;
import com.jagex.core.util.JagException;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.iftype.DragRender;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.graphics.FontMetrics;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.settings.ClanSettings;
import rs2.client.event.keyboard.KeyboardMonitor;
import rs2.client.event.mouse.MouseMonitor;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

@OriginalClass("client!ou")
public final class ScriptRunner {

    @OriginalMember(owner = "client!ou", name = "y", descriptor = "[Ljava/lang/String;")
    public static String[] aStringArray36;

    @OriginalMember(owner = "client!ou", name = "v", descriptor = "[I")
    public static int[] anIntArray580;

    @OriginalMember(owner = "client!ou", name = "m", descriptor = "Lclient!hda;")
    public static Component aComponent_11;

    @OriginalMember(owner = "client!ou", name = "i", descriptor = "[J")
    public static long[] aLongArray15;

    @OriginalMember(owner = "client!ou", name = "H", descriptor = "Lclient!an;")
    public static Class21 aClass21_1;

    @OriginalMember(owner = "client!ou", name = "z", descriptor = "Lclient!rfa;")
    public static ClanChannel aClass2_Sub47_2;

    @OriginalMember(owner = "client!ou", name = "G", descriptor = "Lclient!hi;")
    public static ClanSettings aClanSettings_7;

    @OriginalMember(owner = "client!ou", name = "k", descriptor = "Lclient!hda;")
    public static Component aComponent_12;

    @OriginalMember(owner = "client!ou", name = "B", descriptor = "[J")
    public static final long[] aLongArray14 = new long[1000];

    @OriginalMember(owner = "client!ou", name = "e", descriptor = "[I")
    public static final int[] anIntArray578 = new int[1000];

    @OriginalMember(owner = "client!ou", name = "D", descriptor = "I")
    public static int anInt7139 = 0;

    @OriginalMember(owner = "client!ou", name = "t", descriptor = "[Lclient!gf;")
    public static final Class143[] aClass143Array1 = new Class143[50];

    @OriginalMember(owner = "client!ou", name = "r", descriptor = "I")
    public static int anInt7140 = 0;

    @OriginalMember(owner = "client!ou", name = "f", descriptor = "[I")
    public static final int[] areaCoords = new int[3];

    @OriginalMember(owner = "client!ou", name = "n", descriptor = "I")
    public static int anInt7142 = 0;

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "[Ljava/lang/String;")
    public static final String[] aStringArray37 = new String[1000];

    @OriginalMember(owner = "client!ou", name = "w", descriptor = "[[I")
    public static final int[][] anIntArrayArray177 = new int[5][5000];

    @OriginalMember(owner = "client!ou", name = "C", descriptor = "I")
    public static int anInt7152 = 0;

    @OriginalMember(owner = "client!ou", name = "g", descriptor = "[I")
    public static final int[] anIntArray581 = new int[5];

    @OriginalMember(owner = "client!ou", name = "E", descriptor = "Lclient!dla;")
    public static final ReferenceCache A_WEIGHTED_CACHE___156 = new ReferenceCache(4);

    @OriginalMember(owner = "client!ou", name = "q", descriptor = "Z")
    public static boolean aBoolean538 = false;

    @OriginalMember(owner = "client!ou", name = "o", descriptor = "I")
    public static int anInt7153 = 0;

    @OriginalMember(owner = "client!ou", name = "s", descriptor = "Ljava/lang/String;")
    public static String aString76 = null;

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "(I)I")
    public static int method6411(@OriginalArg(0) int arg0) {
        @Pc(4) VarClanType local4 = VarClanTypeList.instance.list(arg0);
        if (local4 == null) {
            throw new RuntimeException("sr-c113");
        }
        @Pc(29) Integer local29 = aClanSettings_7.getExtraSettingVarbit((client.modeGame.id << 16) | local4.baseVar, local4.endBit, local4.startBit);
        return local29 == null ? 0 : local29;
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(I)I")
    public static int method6412(@OriginalArg(0) int arg0) {
        @Pc(4) VarClanType local4 = VarClanTypeList.instance.list(arg0);
        if (local4 == null) {
            throw new RuntimeException("sr-c112");
        }
        @Pc(24) Integer local24 = aClanSettings_7.getExtraSettingInt(client.modeGame.id << 16 | arg0);
        if (local24 == null) {
            return local4.dataType == 'i' || local4.dataType == '1' ? 0 : -1;
        } else {
            return local24;
        }
    }

    @OriginalMember(owner = "client!ou", name = "c", descriptor = "(I)J")
    public static long method6413(@OriginalArg(0) int arg0) {
        @Pc(9) Long local9 = aClanSettings_7.getExtraSettingLong(client.modeGame.id << 16 | arg0);
        return local9 == null ? -1L : local9;
    }

    @OriginalMember(owner = "client!ou", name = "d", descriptor = "(I)V")
    public static void executeOnLoad(@OriginalArg(0) int arg0) {
        if (arg0 == -1 || !InterfaceList.load(arg0)) {
            return;
        }
        @Pc(14) Component[] local14 = InterfaceList.interfaces[arg0];
        for (@Pc(16) int local16 = 0; local16 < local14.length; local16++) {
            @Pc(21) Component local21 = local14[local16];
            if (local21.onLoad != null) {
                @Pc(28) HookRequest local28 = new HookRequest();
                local28.source = local21;
                local28.arguments = local21.onLoad;
                method6422(local28, 2000000);
            }
        }
    }

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "(Lclient!hda;)V")
    public static void method6415(@OriginalArg(0) Component arg0) {
        if (arg0 == null) {
            return;
        }
        @Pc(71) Component[] local71;
        if (arg0.id == -1) {
            @Pc(119) int local119 = arg0.slot >>> 16;
            @Pc(123) Component[] local123 = InterfaceList.cache[local119];
            if (local123 == null) {
                local71 = InterfaceList.interfaces[local119];
                @Pc(132) int local132 = local71.length;
                local123 = InterfaceList.cache[local119] = new Component[local132];
                Arrays.copy(local71, 0, local123, 0, local71.length);
            }
            @Pc(148) int local148;
            for (local148 = 0; local148 < local123.length && local123[local148] != arg0; local148++) {
            }
            if (local148 >= local123.length) {
                return;
            }
            Arrays.copy(local123, local148 + 1, local123, local148, local123.length - local148 - 1);
            local123[local123.length - 1] = arg0;
            return;
        }
        @Pc(12) Component local12 = InterfaceList.list(arg0.layer);
        if (local12 == null) {
            return;
        }
        if (local12.dynamicComponents == local12.staticComponents) {
            local12.dynamicComponents = new Component[local12.staticComponents.length];
            local12.dynamicComponents[local12.dynamicComponents.length - 1] = arg0;
            Arrays.copy(local12.staticComponents, 0, local12.dynamicComponents, 0, arg0.id);
            Arrays.copy(local12.staticComponents, arg0.id + 1, local12.dynamicComponents, arg0.id, local12.staticComponents.length - arg0.id - 1);
            return;
        }
        @Pc(68) int local68 = 0;
        local71 = local12.dynamicComponents;
        while (local68 < local71.length && local71[local68] != arg0) {
            local68++;
        }
        if (local68 >= local71.length) {
            return;
        }
        Arrays.copy(local71, local68 + 1, local71, local68, local71.length - local68 - 1);
        local71[local12.dynamicComponents.length - 1] = arg0;
        return;
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(IZ)V")
    public static void method6416(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        @Pc(220) Component component;
        @Pc(27) int local27;
        @Pc(21) int local21;
        @Pc(38) Component local38;
        @Pc(72) int local72;
        @Pc(303) Component local303;
        @Pc(15) int local15;
        @Pc(248) Component local248;
        if (arg0 < 300) {
            if (arg0 == 150) {
                anInt7142 -= 3;
                local15 = anIntArray578[anInt7142];
                local21 = anIntArray578[anInt7142 + 1];
                local27 = anIntArray578[anInt7142 + 2];
                if (local21 == 0) {
                    throw new RuntimeException();
                }
                local38 = InterfaceList.list(local15);
                if (local38.staticComponents == null) {
                    local38.staticComponents = new Component[local27 + 1];
                    local38.dynamicComponents = local38.staticComponents;
                }
                if (local38.staticComponents.length <= local27) {
                    @Pc(70) Component[] local70;
                    if (local38.staticComponents == local38.dynamicComponents) {
                        local70 = new Component[local27 + 1];
                        for (local72 = 0; local72 < local38.staticComponents.length; local72++) {
                            local70[local72] = local38.staticComponents[local72];
                        }
                        local38.staticComponents = local38.dynamicComponents = local70;
                    } else {
                        local70 = new Component[local27 + 1];
                        @Pc(104) Component[] local104 = new Component[local27 + 1];
                        for (@Pc(106) int local106 = 0; local106 < local38.staticComponents.length; local106++) {
                            local70[local106] = local38.staticComponents[local106];
                            local104[local106] = local38.dynamicComponents[local106];
                        }
                        local38.staticComponents = local70;
                        local38.dynamicComponents = local104;
                    }
                }
                if (local27 > 0 && local38.staticComponents[local27 - 1] == null) {
                    throw new RuntimeException("Gap at:" + (local27 - 1));
                }
                @Pc(166) Component local166 = new Component();
                local166.type = local21;
                local166.layer = local166.slot = local38.slot;
                local166.id = local27;
                local38.staticComponents[local27] = local166;
                if (local38.dynamicComponents != local38.staticComponents) {
                    local38.dynamicComponents[local27] = local166;
                }
                if (arg1) {
                    aComponent_12 = local166;
                } else {
                    aComponent_11 = local166;
                }
                InterfaceManager.redraw(local38);
                return;
            }
            if (arg0 == 151) {
                component = arg1 ? aComponent_12 : aComponent_11;
                if (component.id == -1) {
                    if (arg1) {
                        throw new RuntimeException("Tried to .cc_delete static .active-component!");
                    }
                    throw new RuntimeException("Tried to cc_delete static active-component!");
                }
                local248 = InterfaceList.list(component.slot);
                local248.staticComponents[component.id] = null;
                InterfaceManager.redraw(local248);
                return;
            }
            if (arg0 == 152) {
                component = InterfaceList.list(anIntArray578[--anInt7142]);
                component.staticComponents = null;
                component.dynamicComponents = null;
                InterfaceManager.redraw(component);
                return;
            }
            if (arg0 == 200) {
                anInt7142 -= 2;
                local15 = anIntArray578[anInt7142];
                local21 = anIntArray578[anInt7142 + 1];
                local303 = InterfaceList.getComponent(local21, local15);
                if (local303 != null && local21 != -1) {
                    anIntArray578[anInt7142++] = 1;
                    if (arg1) {
                        aComponent_12 = local303;
                        return;
                    }
                    aComponent_11 = local303;
                    return;
                }
                anIntArray578[anInt7142++] = 0;
                return;
            }
            if (arg0 == 201) {
                local15 = anIntArray578[--anInt7142];
                local248 = InterfaceList.list(local15);
                if (local248 != null) {
                    anIntArray578[anInt7142++] = 1;
                    if (arg1) {
                        aComponent_12 = local248;
                        return;
                    }
                    aComponent_11 = local248;
                    return;
                }
                anIntArray578[anInt7142++] = 0;
                return;
            }
            if (arg0 == 202 || arg0 == 204) {
                if (arg0 == 202) {
                    local21 = anIntArray578[--anInt7142];
                    component = InterfaceList.list(local21);
                } else {
                    component = arg1 ? aComponent_12 : aComponent_11;
                }
                method6415(component);
                return;
            }
            if (arg0 == 203 || arg0 == 205) {
                if (arg0 == 203) {
                    local21 = anIntArray578[--anInt7142];
                    component = InterfaceList.list(local21);
                } else {
                    component = arg1 ? aComponent_12 : aComponent_11;
                }
                method6417(component);
                return;
            }
        } else {
            @Pc(506) int local506;
            @Pc(575) boolean local575;
            if (arg0 < 500) {
                if (arg0 == 403) {
                    anInt7142 -= 2;
                    local15 = anIntArray578[anInt7142];
                    local21 = anIntArray578[anInt7142 + 1];
                    if (PlayerEntity.self.playerModel == null) {
                        return;
                    }
                    for (local27 = 0; local27 < Static698.anIntArray831.length; local27++) {
                        if (Static698.anIntArray831[local27] == local15) {
                            PlayerEntity.self.playerModel.setIDKPart(local21, IDKTypeList.instance, local27);
                            return;
                        }
                    }
                    for (local506 = 0; local506 < Static540.anIntArray594.length; local506++) {
                        if (Static540.anIntArray594[local506] == local15) {
                            PlayerEntity.self.playerModel.setIDKPart(local21, IDKTypeList.instance, local506);
                            return;
                        }
                    }
                    return;
                }
                if (arg0 == 404) {
                    anInt7142 -= 2;
                    local15 = anIntArray578[anInt7142];
                    local21 = anIntArray578[anInt7142 + 1];
                    if (PlayerEntity.self.playerModel == null) {
                        return;
                    }
                    PlayerEntity.self.playerModel.method4549(local15, local21);
                    return;
                }
                if (arg0 == 410) {
                    local575 = anIntArray578[--anInt7142] != 0;
                    if (PlayerEntity.self.playerModel == null) {
                        return;
                    }
                    PlayerEntity.self.playerModel.setGender(local575);
                    return;
                }
                if (arg0 == 411) {
                    anInt7142 -= 2;
                    local15 = anIntArray578[anInt7142];
                    local21 = anIntArray578[anInt7142 + 1];
                    if (PlayerEntity.self.playerModel == null) {
                        return;
                    }
                    PlayerEntity.self.playerModel.setObj(local21, local15, ObjTypeList.instance);
                    return;
                }
            } else if ((arg0 < 1000 || arg0 >= 1100) && (arg0 < 2000 || arg0 >= 2100)) {
                @Pc(1791) String local1791;
                @Pc(1394) String local1394;
                if (arg0 >= 1100 && arg0 < 1200 || !(arg0 < 2100 || arg0 >= 2200)) {
                    if (arg0 >= 2000) {
                        arg0 -= 1000;
                        component = InterfaceList.list(anIntArray578[--anInt7142]);
                    } else {
                        component = arg1 ? aComponent_12 : aComponent_11;
                    }
                    if (arg0 == 1100) {
                        anInt7142 -= 2;
                        component.scrollX = anIntArray578[anInt7142];
                        if (component.scrollX > component.scrollWidth - component.width) {
                            component.scrollX = component.scrollWidth - component.width;
                        }
                        if (component.scrollX < 0) {
                            component.scrollX = 0;
                        }
                        component.scrollY = anIntArray578[anInt7142 + 1];
                        if (component.scrollY > component.scrollHeight - component.height) {
                            component.scrollY = component.scrollHeight - component.height;
                        }
                        if (component.scrollY < 0) {
                            component.scrollY = 0;
                        }
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetScrollPosition(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1101) {
                        component.colour = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetColour(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1102) {
                        component.filled = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1103) {
                        component.transparency = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1104) {
                        component.lineWidth = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1105) {
                        local21 = anIntArray578[--anInt7142];
                        if (component.graphic != local21) {
                            component.graphic = local21;
                            InterfaceManager.redraw(component);
                        }
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetGraphic(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1106) {
                        component.angle2d = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1107) {
                        component.tiled = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1108) {
                        component.objType = 1;
                        component.obj = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1109) {
                        anInt7142 -= 6;
                        component.anInt3736 = anIntArray578[anInt7142];
                        component.anInt3804 = anIntArray578[anInt7142 + 1];
                        component.modelAngleX = anIntArray578[anInt7142 + 2];
                        component.modelAngleY = anIntArray578[anInt7142 + 3];
                        component.modelAngleZ = anIntArray578[anInt7142 + 4];
                        component.modelZoom = anIntArray578[anInt7142 + 5];
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModelAngle(component.slot);
                            DelayedStateChange.interfaceResetModelOffset(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1110) {
                        local21 = anIntArray578[--anInt7142];
                        if (local21 != component.modelAnimation) {
                            if (local21 == -1) {
                                component.animator = null;
                            } else {
                                if (component.animator == null) {
                                    component.animator = new ComponentAnimator();
                                }
                                component.animator.update(true, local21);
                            }
                            component.modelAnimation = local21;
                            InterfaceManager.redraw(component);
                        }
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModelAnim(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1111) {
                        component.modelOrtho = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1112) {
                        local1394 = aStringArray37[--anInt7139];
                        if (!local1394.equals(component.text)) {
                            component.text = local1394;
                            InterfaceManager.redraw(component);
                        }
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetText(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1113) {
                        component.fontGraphic = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetTextFont(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1114) {
                        anInt7142 -= 3;
                        component.horizontalAlignment = anIntArray578[anInt7142];
                        component.verticalAlignment = anIntArray578[anInt7142 + 1];
                        component.lineHeight = anIntArray578[anInt7142 + 2];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1115) {
                        component.textShadow = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1116) {
                        component.outline = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1117) {
                        component.shadow = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1118) {
                        component.flipHorizontal = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1119) {
                        component.flipVertical = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1120) {
                        anInt7142 -= 2;
                        component.scrollWidth = anIntArray578[anInt7142];
                        component.scrollHeight = anIntArray578[anInt7142 + 1];
                        InterfaceManager.redraw(component);
                        if (component.type == 0) {
                            InterfaceManager.calculateLayerDimensions(component, false);
                        }
                        return;
                    }
                    if (arg0 == 1122) {
                        component.transparent = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1123) {
                        component.modelZoom = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModelAngle(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1124) {
                        local21 = anIntArray578[--anInt7142];
                        component.lineDirection = local21 == 1;
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1125) {
                        anInt7142 -= 2;
                        component.modelOriginX = anIntArray578[anInt7142];
                        component.modelOriginY = anIntArray578[anInt7142 + 1];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1126) {
                        component.maxLines = anIntArray578[--anInt7142];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    @Pc(1756) ParamType local1756;
                    if (arg0 == 1127) {
                        anInt7142 -= 2;
                        local21 = anIntArray578[anInt7142];
                        local27 = anIntArray578[anInt7142 + 1];
                        local1756 = ParamTypeList.instance.list(local21);
                        if (local27 != local1756.defaultint) {
                            component.setParam(local21, local27);
                            return;
                        }
                        component.removeParam(local21);
                        return;
                    }
                    if (arg0 == 1128) {
                        local21 = anIntArray578[--anInt7142];
                        local1791 = aStringArray37[--anInt7139];
                        local1756 = ParamTypeList.instance.list(local21);
                        if (!local1756.defaultstr.equals(local1791)) {
                            component.setParam(local1791, local21);
                            return;
                        }
                        component.removeParam(local21);
                        return;
                    }
                    if (arg0 == 1129 || arg0 == 1130) {
                        local21 = anIntArray578[--anInt7142];
                        if ((component.type == 5 || arg0 != 1129) && (component.type == 4 || arg0 != 1130)) {
                            if (component.video != local21) {
                                component.video = local21;
                                InterfaceManager.redraw(component);
                            }
                            if (component.id == -1) {
                                DelayedStateChange.interfaceResetVideo(component.slot);
                            }
                            return;
                        }
                        return;
                    }
                    @Pc(1899) short local1899;
                    @Pc(1892) short local1892;
                    if (arg0 == 1131) {
                        anInt7142 -= 3;
                        local21 = anIntArray578[anInt7142];
                        local1892 = (short) anIntArray578[anInt7142 + 1];
                        local1899 = (short) anIntArray578[anInt7142 + 2];
                        if (local21 >= 0 && local21 < 5) {
                            component.setRecol(local1899, local21, local1892);
                            InterfaceManager.redraw(component);
                            if (component.id == -1) {
                                DelayedStateChange.interfaceResetRecol(component.slot, local21);
                            }
                            return;
                        }
                        return;
                    }
                    if (arg0 == 1132) {
                        anInt7142 -= 3;
                        local21 = anIntArray578[anInt7142];
                        local1892 = (short) anIntArray578[anInt7142 + 1];
                        local1899 = (short) anIntArray578[anInt7142 + 2];
                        if (local21 >= 0 && local21 < 5) {
                            component.setRetex(local1892, local21, local1899);
                            InterfaceManager.redraw(component);
                            if (component.id == -1) {
                                DelayedStateChange.interfaceResetRetex(component.slot, local21);
                            }
                            return;
                        }
                        return;
                    }
                    if (arg0 == 1133) {
                        component.fontMonospaced = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetFontMono(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1134) {
                        anInt7142 -= 2;
                        local21 = anIntArray578[anInt7142];
                        local27 = anIntArray578[anInt7142 + 1];
                        local1756 = ParamTypeList.instance.list(local21);
                        if (local27 != local1756.defaultint) {
                            component.setParam(local21, local27);
                            return;
                        }
                        component.removeParam(local21);
                        return;
                    }
                    if (arg0 == 1135) {
                        component.clickMask = anIntArray578[--anInt7142] == 1;
                        InterfaceManager.redraw(component);
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetClickmask(component.slot);
                        }
                        return;
                    }
                } else if (arg0 >= 1200 && arg0 < 1300 || arg0 >= 2200 && arg0 < 2300) {
                    if (arg0 >= 2000) {
                        arg0 -= 1000;
                        component = InterfaceList.list(anIntArray578[--anInt7142]);
                    } else {
                        component = arg1 ? aComponent_12 : aComponent_11;
                    }
                    InterfaceManager.redraw(component);
                    if (arg0 == 1200 || arg0 == 1205 || arg0 == 1208 || arg0 == 1209 || arg0 == 1212 || arg0 == 1213) {
                        anInt7142 -= 2;
                        local21 = anIntArray578[anInt7142];
                        local27 = anIntArray578[anInt7142 + 1];
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetObject(component.slot);
                            DelayedStateChange.interfaceResetModelAngle(component.slot);
                            DelayedStateChange.interfaceResetModelOffset(component.slot);
                        }
                        if (local21 == -1) {
                            component.objType = 1;
                            component.obj = -1;
                            component.invObject = -1;
                            return;
                        }
                        component.invObject = local21;
                        component.invCount = local27;
                        if (arg0 == 1208 || arg0 == 1209) {
                            component.objWearCol = true;
                        } else {
                            component.objWearCol = false;
                        }
                        @Pc(2236) ObjType local2236 = ObjTypeList.instance.list(local21);
                        component.modelAngleX = local2236.xan2d;
                        component.modelAngleY = local2236.yan2d;
                        component.modelAngleZ = local2236.zan2d;
                        component.anInt3736 = local2236.xof2d;
                        component.anInt3804 = local2236.yof2d;
                        component.modelZoom = local2236.zoom2d;
                        if (arg0 == 1205 || arg0 == 1209) {
                            component.objNumMode = 0;
                        } else if (arg0 == 1212 || arg0 == 1213) {
                            component.objNumMode = 1;
                        } else {
                            component.objNumMode = 2;
                        }
                        if (component.anInt3800 > 0) {
                            component.modelZoom = component.modelZoom * 32 / component.anInt3800;
                            return;
                        }
                        if (component.baseWidth > 0) {
                            component.modelZoom = component.modelZoom * 32 / component.baseWidth;
                        }
                        return;
                    }
                    if (arg0 == 1201) {
                        component.objType = 2;
                        component.obj = anIntArray578[--anInt7142];
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1202) {
                        component.objType = 3;
                        component.obj = -1;
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1203) {
                        component.objType = 6;
                        component.obj = anIntArray578[--anInt7142];
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1204) {
                        component.objType = 5;
                        component.obj = anIntArray578[--anInt7142];
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1206) {
                        anInt7142 -= 4;
                        component.skyBox = anIntArray578[anInt7142];
                        component.skyBoxSphereOffsetX = anIntArray578[anInt7142 + 1];
                        component.skyBoxSphereOffsetY = anIntArray578[anInt7142 + 2];
                        component.skyBoxSphereOffsetZ = anIntArray578[anInt7142 + 3];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1207) {
                        anInt7142 -= 2;
                        component.anInt3815 = anIntArray578[anInt7142];
                        component.anInt3786 = anIntArray578[anInt7142 + 1];
                        InterfaceManager.redraw(component);
                        return;
                    }
                    if (arg0 == 1210) {
                        anInt7142 -= 4;
                        component.obj = anIntArray578[anInt7142];
                        component.objData = anIntArray578[anInt7142 + 1];
                        if (anIntArray578[anInt7142 + 2] == 1) {
                            component.objType = 9;
                        } else {
                            component.objType = 8;
                        }
                        if (anIntArray578[anInt7142 + 3] == 1) {
                            component.objWearCol = true;
                        } else {
                            component.objWearCol = false;
                        }
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                    if (arg0 == 1211) {
                        component.objType = 5;
                        component.obj = PlayerList.activePlayerSlot;
                        component.objData = 0;
                        if (component.id == -1) {
                            DelayedStateChange.interfaceResetModel(component.slot);
                        }
                        return;
                    }
                } else {
                    @Pc(2978) int local2978;
                    if (arg0 >= 1300 && arg0 < 1400 || arg0 >= 2300 && arg0 < 2400) {
                        if (arg0 >= 2000) {
                            arg0 -= 1000;
                            component = InterfaceList.list(anIntArray578[--anInt7142]);
                        } else {
                            component = arg1 ? aComponent_12 : aComponent_11;
                        }
                        if (arg0 == 1300) {
                            local21 = anIntArray578[--anInt7142] - 1;
                            if (local21 >= 0 && local21 <= 9) {
                                component.setOpText(aStringArray37[--anInt7139], local21);
                                return;
                            }
                            anInt7139--;
                            return;
                        }
                        if (arg0 == 1301) {
                            anInt7142 -= 2;
                            local21 = anIntArray578[anInt7142];
                            local27 = anIntArray578[anInt7142 + 1];
                            if (local21 == -1 && local27 == -1) {
                                component.aComponent_6 = null;
                                return;
                            }
                            component.aComponent_6 = InterfaceList.getComponent(local27, local21);
                            return;
                        }
                        if (arg0 == 1302) {
                            local21 = anIntArray578[--anInt7142];
                            if (local21 != DragRender.OFFSET_TRANSPARENT && local21 != DragRender.FIXED && local21 != DragRender.OFFSET) {
                                return;
                            }
                            component.dragRenderBehaviour = local21;
                            return;
                        }
                        if (arg0 == 1303) {
                            component.dragDeadZone = anIntArray578[--anInt7142];
                            return;
                        }
                        if (arg0 == 1304) {
                            component.dragDeadTime = anIntArray578[--anInt7142];
                            return;
                        }
                        if (arg0 == 1305) {
                            component.opBase = aStringArray37[--anInt7139];
                            return;
                        }
                        if (arg0 == 1306) {
                            component.targetVerb = aStringArray37[--anInt7139];
                            return;
                        }
                        if (arg0 == 1307) {
                            component.ops = null;
                            return;
                        }
                        if (arg0 == 1308) {
                            component.targetEndCursor = anIntArray578[--anInt7142];
                            component.targetEnterCursor = anIntArray578[--anInt7142];
                            return;
                        }
                        if (arg0 == 1309) {
                            local21 = anIntArray578[--anInt7142];
                            local27 = anIntArray578[--anInt7142];
                            if (local27 >= 1 && local27 <= 10) {
                                component.setOpCursor(local27 - 1, local21);
                            }
                            return;
                        }
                        if (arg0 == 1310) {
                            component.pauseText = aStringArray37[--anInt7139];
                            return;
                        }
                        if (arg0 == 1311) {
                            component.targetOpCursor = anIntArray578[--anInt7142];
                            return;
                        }
                        if (arg0 == 1312 || arg0 == 1313) {
                            if (arg0 == 1312) {
                                anInt7142 -= 3;
                                local21 = anIntArray578[anInt7142] - 1;
                                local27 = anIntArray578[anInt7142 + 1];
                                local506 = anIntArray578[anInt7142 + 2];
                                if (local21 < 0 || local21 > 9) {
                                    throw new RuntimeException("IOR13121313");
                                }
                            } else {
                                anInt7142 -= 2;
                                local21 = 10;
                                local27 = anIntArray578[anInt7142];
                                local506 = anIntArray578[anInt7142 + 1];
                            }
                            if (component.opKeys == null) {
                                if (local27 == 0) {
                                    return;
                                }
                                component.opKeys = new byte[11];
                                component.opChars = new byte[11];
                                component.opKeyRates = new int[11];
                            }
                            component.opKeys[local21] = (byte) local27;
                            if (local27 == 0) {
                                component.hasOpKey = false;
                                for (local2978 = 0; local2978 < component.opKeys.length; local2978++) {
                                    if (component.opKeys[local2978] != 0) {
                                        component.hasOpKey = true;
                                        break;
                                    }
                                }
                            } else {
                                component.hasOpKey = true;
                            }
                            component.opChars[local21] = (byte) local506;
                            return;
                        }
                        if (arg0 == 1314) {
                            component.mouseOverCursor = anIntArray578[--anInt7142];
                            return;
                        }
                    } else if (arg0 >= 1400 && arg0 < 1500 || arg0 >= 2400 && arg0 < 2500) {
                        if (arg0 >= 2000) {
                            arg0 -= 1000;
                            component = InterfaceList.list(anIntArray578[--anInt7142]);
                        } else {
                            component = arg1 ? aComponent_12 : aComponent_11;
                        }
                        if (arg0 == 1499) {
                            component.clearScriptHooks();
                            return;
                        }
                        local1394 = aStringArray37[--anInt7139];
                        @Pc(3077) int[] local3077 = null;
                        if (local1394.length() > 0 && local1394.charAt(local1394.length() - 1) == 'Y') {
                            local506 = anIntArray578[--anInt7142];
                            if (local506 > 0) {
                                local3077 = new int[local506];
                                while (local506-- > 0) {
                                    local3077[local506] = anIntArray578[--anInt7142];
                                }
                            }
                            local1394 = local1394.substring(0, local1394.length() - 1);
                        }
                        @Pc(3131) Object[] local3131 = new Object[local1394.length() + 1];
                        for (local2978 = local3131.length - 1; local2978 >= 1; local2978--) {
                            if (local1394.charAt(local2978 - 1) == 's') {
                                local3131[local2978] = aStringArray37[--anInt7139];
                            } else if (local1394.charAt(local2978 - 1) == '§') {
                                local3131[local2978] = Long.valueOf(aLongArray14[--anInt7152]);
                            } else {
                                local3131[local2978] = Integer.valueOf(anIntArray578[--anInt7142]);
                            }
                        }
                        local72 = anIntArray578[--anInt7142];
                        if (local72 == -1) {
                            local3131 = null;
                        } else {
                            local3131[0] = Integer.valueOf(local72);
                        }
                        if (arg0 == 1400) {
                            component.onClick = local3131;
                        } else if (arg0 == 1401) {
                            component.onHold = local3131;
                        } else if (arg0 == 1402) {
                            component.onRelease = local3131;
                        } else if (arg0 == 1403) {
                            component.onMouseOver = local3131;
                        } else if (arg0 == 1404) {
                            component.onMouseLeave = local3131;
                        } else if (arg0 == 1405) {
                            component.onDrag = local3131;
                        } else if (arg0 == 1406) {
                            component.onTargetLeave = local3131;
                        } else if (arg0 == 1407) {
                            component.onVarTransmit = local3131;
                            component.varpTriggers = local3077;
                        } else if (arg0 == 1408) {
                            component.onTimer = local3131;
                        } else if (arg0 == 1409) {
                            component.onOp = local3131;
                        } else if (arg0 == 1410) {
                            component.onDragComplete = local3131;
                        } else if (arg0 == 1411) {
                            component.onClickRepeat = local3131;
                        } else if (arg0 == 1412) {
                            component.onMouseRepeat = local3131;
                        } else if (arg0 == 1414) {
                            component.onInvTransmit = local3131;
                            component.inventoryTriggers = local3077;
                        } else if (arg0 == 1415) {
                            component.onStatTransmit = local3131;
                            component.statTriggers = local3077;
                        } else if (arg0 == 1416) {
                            component.onTargetEnter = local3131;
                        } else if (arg0 == 1417) {
                            component.onScrollWheel = local3131;
                        } else if (arg0 == 1418) {
                            component.onChatTransmit = local3131;
                        } else if (arg0 == 1419) {
                            component.onKey = local3131;
                        } else if (arg0 == 1420) {
                            component.onFriendTransmit = local3131;
                        } else if (arg0 == 1421) {
                            component.onClanTransmit = local3131;
                        } else if (arg0 == 1422) {
                            component.onMiscTransmit = local3131;
                        } else if (arg0 == 1423) {
                            component.onDialogAbort = local3131;
                        } else if (arg0 == 1424) {
                            component.onSubChange = local3131;
                        } else if (arg0 == 1425) {
                            component.onStockTransmit = local3131;
                        } else if (arg0 == 1426) {
                            component.onCamFinished = local3131;
                        } else if (arg0 == 1427) {
                            component.onResize = local3131;
                        } else if (arg0 == 1428) {
                            component.onVarcTransmit = local3131;
                            component.varcTriggers = local3077;
                        } else if (arg0 == 1429) {
                            component.onVarcstrTransmit = local3131;
                            component.varcstrTriggers = local3077;
                        } else if (arg0 == 1430) {
                            component.onOpT = local3131;
                        } else if (arg0 == 1431) {
                            component.onClanSettingsTransmit = local3131;
                        } else if (arg0 == 1432) {
                            component.onClanChannelTransmit = local3131;
                        } else if (arg0 == 1433) {
                            component.onVarclanTransmit = local3131;
                        }
                        component.hasHook = true;
                        return;
                    } else if (arg0 < 1600) {
                        component = arg1 ? aComponent_12 : aComponent_11;
                        if (arg0 == 1500) {
                            anIntArray578[anInt7142++] = component.positionX;
                            return;
                        }
                        if (arg0 == 1501) {
                            anIntArray578[anInt7142++] = component.positionY;
                            return;
                        }
                        if (arg0 == 1502) {
                            anIntArray578[anInt7142++] = component.width;
                            return;
                        }
                        if (arg0 == 1503) {
                            anIntArray578[anInt7142++] = component.height;
                            return;
                        }
                        if (arg0 == 1504) {
                            anIntArray578[anInt7142++] = component.hidden ? 1 : 0;
                            return;
                        }
                        if (arg0 == 1505) {
                            anIntArray578[anInt7142++] = component.layer;
                            return;
                        }
                        if (arg0 == 1506) {
                            local248 = Static556.method7299(component);
                            anIntArray578[anInt7142++] = local248 == null ? -1 : local248.slot;
                            return;
                        }
                        if (arg0 == 1507) {
                            anIntArray578[anInt7142++] = component.colour;
                            return;
                        }
                    } else {
                        @Pc(3848) ParamType local3848;
                        if (arg0 < 1700) {
                            component = arg1 ? aComponent_12 : aComponent_11;
                            if (arg0 == 1600) {
                                anIntArray578[anInt7142++] = component.scrollX;
                                return;
                            }
                            if (arg0 == 1601) {
                                anIntArray578[anInt7142++] = component.scrollY;
                                return;
                            }
                            if (arg0 == 1602) {
                                aStringArray37[anInt7139++] = component.text;
                                return;
                            }
                            if (arg0 == 1603) {
                                anIntArray578[anInt7142++] = component.scrollWidth;
                                return;
                            }
                            if (arg0 == 1604) {
                                anIntArray578[anInt7142++] = component.scrollHeight;
                                return;
                            }
                            if (arg0 == 1605) {
                                anIntArray578[anInt7142++] = component.modelZoom;
                                return;
                            }
                            if (arg0 == 1606) {
                                anIntArray578[anInt7142++] = component.modelAngleX;
                                return;
                            }
                            if (arg0 == 1607) {
                                anIntArray578[anInt7142++] = component.modelAngleZ;
                                return;
                            }
                            if (arg0 == 1608) {
                                anIntArray578[anInt7142++] = component.modelAngleY;
                                return;
                            }
                            if (arg0 == 1609) {
                                anIntArray578[anInt7142++] = component.transparency;
                                return;
                            }
                            if (arg0 == 1610) {
                                anIntArray578[anInt7142++] = component.anInt3736;
                                return;
                            }
                            if (arg0 == 1611) {
                                anIntArray578[anInt7142++] = component.anInt3804;
                                return;
                            }
                            if (arg0 == 1612) {
                                anIntArray578[anInt7142++] = component.graphic;
                                return;
                            }
                            if (arg0 == 1613) {
                                local21 = anIntArray578[--anInt7142];
                                local3848 = ParamTypeList.instance.list(local21);
                                if (local3848.isString()) {
                                    aStringArray37[anInt7139++] = component.param(local3848.defaultstr, local21);
                                    return;
                                }
                                anIntArray578[anInt7142++] = component.param(local3848.defaultint, local21);
                                return;
                            }
                            if (arg0 == 1614) {
                                anIntArray578[anInt7142++] = component.angle2d;
                                return;
                            }
                            if (arg0 == 2614) {
                                anIntArray578[anInt7142++] = component.objType == 1 ? component.obj : -1;
                                return;
                            }
                            if (arg0 == 1618) {
                                anIntArray578[anInt7142++] = component.fontGraphic;
                                return;
                            }
                        } else if (arg0 < 1800) {
                            component = arg1 ? aComponent_12 : aComponent_11;
                            if (arg0 == 1700) {
                                anIntArray578[anInt7142++] = component.invObject;
                                return;
                            }
                            if (arg0 == 1701) {
                                if (component.invObject != -1) {
                                    anIntArray578[anInt7142++] = component.invCount;
                                    return;
                                }
                                anIntArray578[anInt7142++] = 0;
                                return;
                            }
                            if (arg0 == 1702) {
                                anIntArray578[anInt7142++] = component.id;
                                return;
                            }
                        } else if (arg0 < 1900) {
                            component = arg1 ? aComponent_12 : aComponent_11;
                            if (arg0 == 1800) {
                                anIntArray578[anInt7142++] = InterfaceManager.serverActiveProperties(component).getTargetMask();
                                return;
                            }
                            if (arg0 == 1801) {
                                local21 = anIntArray578[--anInt7142];
                                local21--;
                                if (component.ops != null && local21 < component.ops.length && component.ops[local21] != null) {
                                    aStringArray37[anInt7139++] = component.ops[local21];
                                    return;
                                }
                                aStringArray37[anInt7139++] = "";
                                return;
                            }
                            if (arg0 == 1802) {
                                if (component.opBase == null) {
                                    aStringArray37[anInt7139++] = "";
                                    return;
                                }
                                aStringArray37[anInt7139++] = component.opBase;
                                return;
                            }
                        } else if (arg0 < 2000 || arg0 >= 2900 && arg0 < 3000) {
                            if (arg0 >= 2000) {
                                component = InterfaceList.list(anIntArray578[--anInt7142]);
                                arg0 -= 1000;
                            } else {
                                component = arg1 ? aComponent_12 : aComponent_11;
                            }
                            if (anInt7153 >= 10) {
                                throw new RuntimeException("C29xx-1");
                            }
                            if (arg0 == 1927) {
                                if (component.onResize == null) {
                                    return;
                                }
                                @Pc(4169) HookRequest local4169 = new HookRequest();
                                local4169.source = component;
                                local4169.arguments = component.onResize;
                                local4169.anInt7220 = anInt7153 + 1;
                                Static521.A_DEQUE___44.addLast(local4169);
                                return;
                            }
                        } else if (arg0 < 2600) {
                            component = InterfaceList.list(anIntArray578[--anInt7142]);
                            if (arg0 == 2500) {
                                anIntArray578[anInt7142++] = component.positionX;
                                return;
                            }
                            if (arg0 == 2501) {
                                anIntArray578[anInt7142++] = component.positionY;
                                return;
                            }
                            if (arg0 == 2502) {
                                anIntArray578[anInt7142++] = component.width;
                                return;
                            }
                            if (arg0 == 2503) {
                                anIntArray578[anInt7142++] = component.height;
                                return;
                            }
                            if (arg0 == 2504) {
                                anIntArray578[anInt7142++] = component.hidden ? 1 : 0;
                                return;
                            }
                            if (arg0 == 2505) {
                                anIntArray578[anInt7142++] = component.layer;
                                return;
                            }
                            if (arg0 == 2506) {
                                local248 = Static556.method7299(component);
                                anIntArray578[anInt7142++] = local248 == null ? -1 : local248.slot;
                                return;
                            }
                            if (arg0 == 2507) {
                                anIntArray578[anInt7142++] = component.colour;
                                return;
                            }
                        } else if (arg0 < 2700) {
                            component = InterfaceList.list(anIntArray578[--anInt7142]);
                            if (arg0 == 2600) {
                                anIntArray578[anInt7142++] = component.scrollX;
                                return;
                            }
                            if (arg0 == 2601) {
                                anIntArray578[anInt7142++] = component.scrollY;
                                return;
                            }
                            if (arg0 == 2602) {
                                aStringArray37[anInt7139++] = component.text;
                                return;
                            }
                            if (arg0 == 2603) {
                                anIntArray578[anInt7142++] = component.scrollWidth;
                                return;
                            }
                            if (arg0 == 2604) {
                                anIntArray578[anInt7142++] = component.scrollHeight;
                                return;
                            }
                            if (arg0 == 2605) {
                                anIntArray578[anInt7142++] = component.modelZoom;
                                return;
                            }
                            if (arg0 == 2606) {
                                anIntArray578[anInt7142++] = component.modelAngleX;
                                return;
                            }
                            if (arg0 == 2607) {
                                anIntArray578[anInt7142++] = component.modelAngleZ;
                                return;
                            }
                            if (arg0 == 2608) {
                                anIntArray578[anInt7142++] = component.modelAngleY;
                                return;
                            }
                            if (arg0 == 2609) {
                                anIntArray578[anInt7142++] = component.transparency;
                                return;
                            }
                            if (arg0 == 2610) {
                                anIntArray578[anInt7142++] = component.anInt3736;
                                return;
                            }
                            if (arg0 == 2611) {
                                anIntArray578[anInt7142++] = component.anInt3804;
                                return;
                            }
                            if (arg0 == 2612) {
                                anIntArray578[anInt7142++] = component.graphic;
                                return;
                            }
                            if (arg0 == 2613) {
                                anIntArray578[anInt7142++] = component.angle2d;
                                return;
                            }
                            if (arg0 == 2614) {
                                anIntArray578[anInt7142++] = component.objType == 1 ? component.obj : -1;
                                return;
                            }
                            if (arg0 == 2617) {
                                anIntArray578[anInt7142++] = component.fontGraphic;
                                return;
                            }
                        } else {
                            @Pc(4760) SubInterface local4760;
                            @Pc(4653) SubInterface local4653;
                            if (arg0 < 2800) {
                                if (arg0 == 2700) {
                                    component = InterfaceList.list(anIntArray578[--anInt7142]);
                                    anIntArray578[anInt7142++] = component.invObject;
                                    return;
                                }
                                if (arg0 == 2701) {
                                    component = InterfaceList.list(anIntArray578[--anInt7142]);
                                    if (component.invObject != -1) {
                                        anIntArray578[anInt7142++] = component.invCount;
                                        return;
                                    }
                                    anIntArray578[anInt7142++] = 0;
                                    return;
                                }
                                if (arg0 == 2702) {
                                    local15 = anIntArray578[--anInt7142];
                                    local4653 = (SubInterface) InterfaceManager.subInterfaces.get(local15);
                                    if (local4653 != null) {
                                        anIntArray578[anInt7142++] = 1;
                                        return;
                                    }
                                    anIntArray578[anInt7142++] = 0;
                                    return;
                                }
                                if (arg0 == 2703) {
                                    component = InterfaceList.list(anIntArray578[--anInt7142]);
                                    if (component.staticComponents == null) {
                                        anIntArray578[anInt7142++] = 0;
                                        return;
                                    }
                                    local21 = component.staticComponents.length;
                                    for (local27 = 0; local27 < component.staticComponents.length; local27++) {
                                        if (component.staticComponents[local27] == null) {
                                            local21 = local27;
                                            break;
                                        }
                                    }
                                    anIntArray578[anInt7142++] = local21;
                                    return;
                                }
                                if (arg0 == 2704 || arg0 == 2705) {
                                    anInt7142 -= 2;
                                    local15 = anIntArray578[anInt7142];
                                    local21 = anIntArray578[anInt7142 + 1];
                                    local4760 = (SubInterface) InterfaceManager.subInterfaces.get(local15);
                                    if (local4760 != null && local4760.id == local21) {
                                        anIntArray578[anInt7142++] = 1;
                                        return;
                                    }
                                    anIntArray578[anInt7142++] = 0;
                                    return;
                                }
                            } else if (arg0 < 2900) {
                                component = InterfaceList.list(anIntArray578[--anInt7142]);
                                if (arg0 == 2800) {
                                    anIntArray578[anInt7142++] = InterfaceManager.serverActiveProperties(component).getTargetMask();
                                    return;
                                }
                                if (arg0 == 2801) {
                                    local21 = anIntArray578[--anInt7142];
                                    local21--;
                                    if (component.ops != null && local21 < component.ops.length && component.ops[local21] != null) {
                                        aStringArray37[anInt7139++] = component.ops[local21];
                                        return;
                                    }
                                    aStringArray37[anInt7139++] = "";
                                    return;
                                }
                                if (arg0 == 2802) {
                                    if (component.opBase == null) {
                                        aStringArray37[anInt7139++] = "";
                                        return;
                                    }
                                    aStringArray37[anInt7139++] = component.opBase;
                                    return;
                                }
                            } else {
                                @Pc(5005) ClientMessage local5005;
                                @Pc(4911) String local4911;
                                if (arg0 < 3200) {
                                    if (arg0 == 3100) {
                                        local4911 = aStringArray37[--anInt7139];
                                        ChatHistory.addScript(local4911);
                                        return;
                                    }
                                    if (arg0 == 3101) {
                                        anInt7142 -= 2;
                                        Static550.method7260(PlayerEntity.self, anIntArray578[anInt7142 + 1], anIntArray578[anInt7142]);
                                        return;
                                    }
                                    if (arg0 == 3103) {
                                        Static77.method1557();
                                        return;
                                    }
                                    if (arg0 == 3104) {
                                        local4911 = aStringArray37[--anInt7139];
                                        local21 = 0;
                                        if (StringTools.isDecimal(local4911)) {
                                            local21 = StringTools.parseDecimal(local4911);
                                        }
                                        @Pc(4974) ClientMessage local4974 = ClientMessage.create(Static330.A_CLIENT_PROT___66, ConnectionManager.GAME.cipher);
                                        local4974.bitPacket.p4(local21);
                                        ConnectionManager.GAME.send(local4974);
                                        return;
                                    }
                                    if (arg0 == 3105) {
                                        local4911 = aStringArray37[--anInt7139];
                                        local5005 = ClientMessage.create(Static276.A_CLIENT_PROT___56, ConnectionManager.GAME.cipher);
                                        local5005.bitPacket.p1(local4911.length() + 1);
                                        local5005.bitPacket.pjstr(local4911);
                                        ConnectionManager.GAME.send(local5005);
                                        return;
                                    }
                                    if (arg0 == 3106) {
                                        local4911 = aStringArray37[--anInt7139];
                                        local5005 = ClientMessage.create(Static137.A_CLIENT_PROT___28, ConnectionManager.GAME.cipher);
                                        local5005.bitPacket.p1(local4911.length() + 1);
                                        local5005.bitPacket.pjstr(local4911);
                                        ConnectionManager.GAME.send(local5005);
                                        return;
                                    }
                                    if (arg0 == 3107) {
                                        local15 = anIntArray578[--anInt7142];
                                        local1394 = aStringArray37[--anInt7139];
                                        Static242.method3504(local1394, local15);
                                        return;
                                    }
                                    if (arg0 == 3108) {
                                        anInt7142 -= 3;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        local27 = anIntArray578[anInt7142 + 2];
                                        local38 = InterfaceList.list(local27);
                                        InterfaceManager.dragTryPickup(local21, local38, local15);
                                        return;
                                    }
                                    if (arg0 == 3109) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        local303 = arg1 ? aComponent_12 : aComponent_11;
                                        InterfaceManager.dragTryPickup(local21, local303, local15);
                                        return;
                                    }
                                    if (arg0 == 3110) {
                                        local15 = anIntArray578[--anInt7142];
                                        local5005 = ClientMessage.create(Static209.A_CLIENT_PROT___37, ConnectionManager.GAME.cipher);
                                        local5005.bitPacket.p2(local15);
                                        ConnectionManager.GAME.send(local5005);
                                        return;
                                    }
                                    if (arg0 == 3111) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        local4760 = (SubInterface) InterfaceManager.subInterfaces.get(local15);
                                        if (local4760 != null) {
                                            InterfaceManager.closeSubInterface(true, local4760.id != local21, local4760);
                                        }
                                        InterfaceManager.openSubInterface(3, local21, local15, true);
                                        return;
                                    }
                                    if (arg0 == 3112) {
                                        anInt7142--;
                                        local15 = anIntArray578[anInt7142];
                                        local4653 = (SubInterface) InterfaceManager.subInterfaces.get(local15);
                                        if (local4653 != null && local4653.type == 3) {
                                            InterfaceManager.closeSubInterface(true, true, local4653);
                                        }
                                        return;
                                    }
                                    if (arg0 == 3113) {
                                        Static57.method1231(aStringArray37[--anInt7139]);
                                        return;
                                    }
                                    if (arg0 == 3114) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        local1791 = aStringArray37[--anInt7139];
                                        ChatHistory.add(local1791, "", local21, "", "", local15);
                                        return;
                                    }
                                    if (arg0 == 3115) {
                                        anInt7142 -= 11;
                                        @Pc(5320) HorizontalAlignment[] local5320 = HorizontalAlignment.values();
                                        @Pc(5323) VerticalAlignment[] local5323 = VerticalAlignment.values();
                                        Static124.method2216(anIntArray578[anInt7142 + 7], anIntArray578[anInt7142 + 2], anIntArray578[anInt7142 + 9], anIntArray578[anInt7142 + 4], local5323[anIntArray578[anInt7142 + 1]], anIntArray578[anInt7142 + 5], anIntArray578[anInt7142 + 8], anIntArray578[anInt7142 + 6], anIntArray578[anInt7142 + 3], local5320[anIntArray578[anInt7142]], anIntArray578[anInt7142 + 10]);
                                        return;
                                    }
                                    if (arg0 == 3116) {
                                        local15 = anIntArray578[--anInt7142];
                                        local5005 = ClientMessage.create(Static436.A_CLIENT_PROT___44, ConnectionManager.GAME.cipher);
                                        local5005.bitPacket.p2(local15);
                                        ConnectionManager.GAME.send(local5005);
                                        return;
                                    }
                                    if (arg0 == 3117) {
                                        local4911 = aStringArray37[--anInt7139];
                                        local5005 = ClientMessage.create(Static357.A_CLIENT_PROT___82, ConnectionManager.GAME.cipher);
                                        local5005.bitPacket.p1(local4911.length() + 1);
                                        local5005.bitPacket.pjstr(local4911);
                                        ConnectionManager.GAME.send(local5005);
                                        return;
                                    }
                                } else if (arg0 < 3300) {
                                    if (arg0 == 3200) {
                                        anInt7142 -= 3;
                                        Static161.method2586(256, anIntArray578[anInt7142 + 2], anIntArray578[anInt7142], anIntArray578[anInt7142 + 1], 255);
                                        return;
                                    }
                                    if (arg0 == 3201) {
                                        Static63.method1427(255, anIntArray578[--anInt7142], 50);
                                        return;
                                    }
                                    if (arg0 == 3202) {
                                        anInt7142 -= 2;
                                        Static482.method6481(255, anIntArray578[anInt7142], anIntArray578[anInt7142 + 1]);
                                        return;
                                    }
                                    if (arg0 == 3203) {
                                        anInt7142 -= 4;
                                        Static161.method2586(256, anIntArray578[anInt7142 + 2], anIntArray578[anInt7142], anIntArray578[anInt7142 + 1], anIntArray578[anInt7142 + 3]);
                                        return;
                                    }
                                    if (arg0 == 3204) {
                                        anInt7142 -= 3;
                                        Static63.method1427(anIntArray578[anInt7142 + 1], anIntArray578[anInt7142], anIntArray578[anInt7142 + 2]);
                                        return;
                                    }
                                    if (arg0 == 3205) {
                                        anInt7142 -= 3;
                                        Static482.method6481(anIntArray578[anInt7142 + 2], anIntArray578[anInt7142], anIntArray578[anInt7142 + 1]);
                                        return;
                                    }
                                    if (arg0 == 3206) {
                                        anInt7142 -= 4;
                                        Static186.method2818(anIntArray578[anInt7142], anIntArray578[anInt7142 + 1], 256, anIntArray578[anInt7142 + 2], anIntArray578[anInt7142 + 3], false);
                                        return;
                                    }
                                    if (arg0 == 3207) {
                                        anInt7142 -= 4;
                                        Static186.method2818(anIntArray578[anInt7142], anIntArray578[anInt7142 + 1], 256, anIntArray578[anInt7142 + 2], anIntArray578[anInt7142 + 3], true);
                                        return;
                                    }
                                    if (arg0 == 3208) {
                                        anInt7142 -= 5;
                                        Static161.method2586(anIntArray578[anInt7142 + 4], anIntArray578[anInt7142 + 2], anIntArray578[anInt7142], anIntArray578[anInt7142 + 1], anIntArray578[anInt7142 + 3]);
                                        return;
                                    }
                                    if (arg0 == 3209) {
                                        anInt7142 -= 5;
                                        Static186.method2818(anIntArray578[anInt7142], anIntArray578[anInt7142 + 1], anIntArray578[anInt7142 + 4], anIntArray578[anInt7142 + 2], anIntArray578[anInt7142 + 3], false);
                                        return;
                                    }
                                } else if (arg0 < 3400) {
                                    if (arg0 == 3300) {
                                        anIntArray578[anInt7142++] = TimeUtils.clock;
                                        return;
                                    }
                                    if (arg0 == 3301) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static597.method7822(local15, local21, false);
                                        return;
                                    }
                                    if (arg0 == 3302) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static536.method7169(local21, false, local15);
                                        return;
                                    }
                                    if (arg0 == 3303) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static67.method6099(local21, local15, false);
                                        return;
                                    }
                                    if (arg0 == 3304) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = InvTypeList.instance.list(local15).size;
                                        return;
                                    }
                                    if (arg0 == 3305) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = Static581.anIntArray688[local15];
                                        return;
                                    }
                                    if (arg0 == 3306) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = Static498.anIntArray604[local15];
                                        return;
                                    }
                                    if (arg0 == 3307) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = Static237.anIntArray518[local15];
                                        return;
                                    }
                                    if (arg0 == 3308) {
                                        @Pc(5929) byte local5929 = PlayerEntity.self.level;
                                        local21 = (PlayerEntity.self.x >> 9) + WorldMap.areaBaseX;
                                        local27 = (PlayerEntity.self.z >> 9) + WorldMap.areaBaseZ;
                                        anIntArray578[anInt7142++] = (local5929 << 28) + (local21 << 14) + local27;
                                        return;
                                    }
                                    if (arg0 == 3309) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = local15 >> 14 & 0x3FFF;
                                        return;
                                    }
                                    if (arg0 == 3310) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = local15 >> 28;
                                        return;
                                    }
                                    if (arg0 == 3311) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = local15 & 0x3FFF;
                                        return;
                                    }
                                    if (arg0 == 3312) {
                                        anIntArray578[anInt7142++] = Static174.mapMembers ? 1 : 0;
                                        return;
                                    }
                                    if (arg0 == 3313) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static597.method7822(local15, local21, true);
                                        return;
                                    }
                                    if (arg0 == 3314) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static536.method7169(local21, true, local15);
                                        return;
                                    }
                                    if (arg0 == 3315) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static67.method6099(local21, local15, true);
                                        return;
                                    }
                                    if (arg0 == 3316) {
                                        if (Static608.staffModLevel >= 2) {
                                            anIntArray578[anInt7142++] = Static608.staffModLevel;
                                            return;
                                        }
                                        anIntArray578[anInt7142++] = 0;
                                        return;
                                    }
                                    if (arg0 == 3317) {
                                        anIntArray578[anInt7142++] = Static249.anInt4008;
                                        return;
                                    }
                                    if (arg0 == 3318) {
                                        anIntArray578[anInt7142++] = client.gameConnection.id;
                                        return;
                                    }
                                    if (arg0 == 3321) {
                                        anIntArray578[anInt7142++] = Static703.anInt10571;
                                        return;
                                    }
                                    if (arg0 == 3322) {
                                        anIntArray578[anInt7142++] = Static494.anInt7404;
                                        return;
                                    }
                                    if (arg0 == 3323) {
                                        if (Static38.anInt928 >= 5 && Static38.anInt928 <= 9) {
                                            anIntArray578[anInt7142++] = 1;
                                            return;
                                        }
                                        anIntArray578[anInt7142++] = 0;
                                        return;
                                    }
                                    if (arg0 == 3324) {
                                        if (Static38.anInt928 >= 5 && Static38.anInt928 <= 9) {
                                            anIntArray578[anInt7142++] = Static38.anInt928;
                                            return;
                                        }
                                        anIntArray578[anInt7142++] = 0;
                                        return;
                                    }
                                    if (arg0 == 3325) {
                                        anIntArray578[anInt7142++] = Static126.aBoolean200 ? 1 : 0;
                                        return;
                                    }
                                    if (arg0 == 3326) {
                                        anIntArray578[anInt7142++] = PlayerEntity.self.combatLevel;
                                        return;
                                    }
                                    if (arg0 == 3327) {
                                        anIntArray578[anInt7142++] = PlayerEntity.self.playerModel != null && PlayerEntity.self.playerModel.female ? 1 : 0;
                                        return;
                                    }
                                    if (arg0 == 3329) {
                                        anIntArray578[anInt7142++] = Static617.aBoolean724 ? 1 : 0;
                                        return;
                                    }
                                    if (arg0 == 3330) {
                                        local15 = anIntArray578[--anInt7142];
                                        anIntArray578[anInt7142++] = Static46.method1082(local15);
                                        return;
                                    }
                                    if (arg0 == 3331) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static390.method5494(false, local21, local15);
                                        return;
                                    }
                                    if (arg0 == 3332) {
                                        anInt7142 -= 2;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        anIntArray578[anInt7142++] = Static390.method5494(true, local21, local15);
                                        return;
                                    }
                                    if (arg0 == 3333) {
                                        anIntArray578[anInt7142++] = Static696.method9034();
                                        return;
                                    }
                                    if (arg0 == 3335) {
                                        anIntArray578[anInt7142++] = client.language;
                                        return;
                                    }
                                    if (arg0 == 3336) {
                                        anInt7142 -= 4;
                                        local15 = anIntArray578[anInt7142];
                                        local21 = anIntArray578[anInt7142 + 1];
                                        local27 = anIntArray578[anInt7142 + 2];
                                        local506 = anIntArray578[anInt7142 + 3];
                                        local15 += local21 << 14;
                                        local15 += local27 << 28;
                                        local15 += local506;
                                        anIntArray578[anInt7142++] = local15;
                                        return;
                                    }
                                    if (arg0 == 3337) {
                                        anIntArray578[anInt7142++] = client.affid;
                                        return;
                                    }
                                    if (arg0 == 3338) {
                                        anIntArray578[anInt7142++] = Static65.profileCpu();
                                        return;
                                    }
                                    if (arg0 == 3339) {
                                        anIntArray578[anInt7142++] = 0;
                                        return;
                                    }
                                    if (arg0 == 3340) {
                                        anIntArray578[anInt7142++] = GameShell.focus ? 1 : 0;
                                        return;
                                    }
                                    if (arg0 == 3341) {
                                        anIntArray578[anInt7142++] = client.fromBilling ? 1 : 0;
                                        return;
                                    }
                                    if (arg0 == 3342) {
                                        anIntArray578[anInt7142++] = MouseMonitor.instance.getRecordedX();
                                        return;
                                    }
                                    if (arg0 == 3343) {
                                        anIntArray578[anInt7142++] = MouseMonitor.instance.getRecordedY();
                                        return;
                                    }
                                    if (arg0 == 3344) {
                                        aStringArray37[anInt7139++] = Static130.method2281();
                                        return;
                                    }
                                    if (arg0 == 3345) {
                                        aStringArray37[anInt7139++] = Static690.method8998();
                                        return;
                                    }
                                    if (arg0 == 3346) {
                                        anIntArray578[anInt7142++] = Static338.method4995();
                                        return;
                                    }
                                    if (arg0 == 3347) {
                                        anIntArray578[anInt7142++] = Static470.anInt7112;
                                        return;
                                    }
                                    if (arg0 == 3349) {
                                        anIntArray578[anInt7142++] = PlayerEntity.self.yaw.getValue(16383) >> 3;
                                        return;
                                    }
                                    if (arg0 == 3350) {
                                        local4911 = aStringArray37[--anInt7139];
                                        if (Static416.aString71 != null && Static416.aString71.equalsIgnoreCase(local4911)) {
                                            anIntArray578[anInt7142++] = 1;
                                            return;
                                        }
                                        anIntArray578[anInt7142++] = 0;
                                        return;
                                    }
                                    if (arg0 == 3351) {
                                        anIntArray578[anInt7142++] = MouseMonitor.instance.isLeftDown() ? 1 : 0;
                                        anIntArray578[anInt7142++] = MouseMonitor.instance.isMiddleDown() ? 1 : 0;
                                        anIntArray578[anInt7142++] = MouseMonitor.instance.isRightDown() ? 1 : 0;
                                        return;
                                    }
                                } else {
                                    @Pc(7345) String local7345;
                                    if (arg0 < 3500) {
                                        @Pc(6822) EnumType local6822;
                                        if (arg0 == 3400) {
                                            anInt7142 -= 2;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local6822 = EnumTypeList.instance.list(local15);
                                            aStringArray37[anInt7139++] = local6822.getString(local21);
                                            return;
                                        }
                                        @Pc(6868) EnumType local6868;
                                        if (arg0 == 3408) {
                                            anInt7142 -= 4;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local27 = anIntArray578[anInt7142 + 2];
                                            local506 = anIntArray578[anInt7142 + 3];
                                            local6868 = EnumTypeList.instance.list(local27);
                                            if (local6868.keyType == local15 && local6868.valType == local21) {
                                                if (local21 == 's') {
                                                    aStringArray37[anInt7139++] = local6868.getString(local506);
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = local6868.getInt(local506);
                                                return;
                                            }
                                            throw new RuntimeException("C3408-1 " + local27 + "-" + local506);
                                        }
                                        @Pc(6963) EnumType local6963;
                                        if (arg0 == 3409) {
                                            anInt7142 -= 3;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local27 = anIntArray578[anInt7142 + 2];
                                            if (local21 == -1) {
                                                throw new RuntimeException("C3409-2");
                                            }
                                            local6963 = EnumTypeList.instance.list(local21);
                                            if (local6963.valType != local15) {
                                                throw new RuntimeException("C3409-1");
                                            }
                                            anIntArray578[anInt7142++] = local6963.hasOutput(local27) ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3410) {
                                            local15 = anIntArray578[--anInt7142];
                                            local1394 = aStringArray37[--anInt7139];
                                            if (local15 == -1) {
                                                throw new RuntimeException("C3410-2");
                                            }
                                            local6822 = EnumTypeList.instance.list(local15);
                                            if (local6822.valType != 's') {
                                                throw new RuntimeException("C3410-1");
                                            }
                                            anIntArray578[anInt7142++] = local6822.hasOutputString(local1394) ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3411) {
                                            local15 = anIntArray578[--anInt7142];
                                            @Pc(7072) EnumType type = EnumTypeList.instance.list(local15);
                                            anIntArray578[anInt7142++] = type.getOutputCount();
                                            return;
                                        }
                                        if (arg0 == 3412) {
                                            anInt7142 -= 3;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local27 = anIntArray578[anInt7142 + 2];
                                            if (local21 == -1) {
                                                throw new RuntimeException();
                                            }
                                            local6963 = EnumTypeList.instance.list(local21);
                                            if (local6963.valType != local15) {
                                                throw new RuntimeException();
                                            }
                                            @Pc(7133) EnumMapping mapping = local6963.getReversed(local27);
                                            local72 = 0;
                                            if (mapping != null) {
                                                local72 = mapping.index.length;
                                            }
                                            anIntArray578[anInt7142++] = local72;
                                            return;
                                        }
                                        if (arg0 == 3413) {
                                            local15 = anIntArray578[--anInt7142];
                                            local1394 = aStringArray37[--anInt7139];
                                            if (local15 == -1) {
                                                throw new RuntimeException();
                                            }
                                            local6822 = EnumTypeList.instance.list(local15);
                                            if (local6822.valType != 's') {
                                                throw new RuntimeException();
                                            }
                                            @Pc(7196) EnumStringMapping mapping = local6822.getReversed(local1394);
                                            local2978 = 0;
                                            if (mapping != null) {
                                                local2978 = mapping.index.length;
                                            }
                                            anIntArray578[anInt7142++] = local2978;
                                            return;
                                        }
                                        if (arg0 == 3414) {
                                            anInt7142 -= 5;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local27 = anIntArray578[anInt7142 + 2];
                                            local506 = anIntArray578[anInt7142 + 3];
                                            local2978 = anIntArray578[anInt7142 + 4];
                                            if (local27 == -1) {
                                                throw new RuntimeException();
                                            }
                                            @Pc(7261) EnumType local7261 = EnumTypeList.instance.list(local27);
                                            if (local7261.keyType != local21) {
                                                throw new RuntimeException();
                                            }
                                            if (local7261.valType != local15) {
                                                throw new RuntimeException();
                                            }
                                            @Pc(7284) EnumMapping mapping = local7261.getReversed(local506);
                                            if (local2978 >= 0 && mapping != null && mapping.index.length > local2978) {
                                                anIntArray578[anInt7142++] = mapping.index[local2978];
                                                return;
                                            }
                                            throw new RuntimeException();
                                        }
                                        if (arg0 == 3415) {
                                            anInt7142 -= 3;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local27 = anIntArray578[anInt7142 + 2];
                                            local7345 = aStringArray37[--anInt7139];
                                            if (local21 == -1) {
                                                throw new RuntimeException();
                                            }
                                            local6868 = EnumTypeList.instance.list(local21);
                                            if (local6868.keyType != local15) {
                                                throw new RuntimeException();
                                            }
                                            if (local6868.valType != 's') {
                                                throw new RuntimeException();
                                            }
                                            @Pc(7381) EnumStringMapping local7381 = local6868.getReversed(local7345);
                                            if (local27 >= 0 && local7381 != null && local7381.index.length > local27) {
                                                anIntArray578[anInt7142++] = local7381.index[local27];
                                                return;
                                            }
                                            throw new RuntimeException();
                                        }
                                    } else if (arg0 < 3700) {
                                        if (arg0 == 3600) {
                                            if (Static251.anInt4036 == 0) {
                                                anIntArray578[anInt7142++] = -2;
                                                return;
                                            }
                                            if (Static251.anInt4036 == 1) {
                                                anIntArray578[anInt7142++] = -1;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = FriendsList.count;
                                            return;
                                        }
                                        if (arg0 == 3601) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 == 2 && local15 < FriendsList.count) {
                                                aStringArray37[anInt7139++] = FriendsList.names[local15];
                                                if (Static572.aStringArray42[local15] != null) {
                                                    aStringArray37[anInt7139++] = Static572.aStringArray42[local15];
                                                    return;
                                                }
                                                aStringArray37[anInt7139++] = "";
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3602) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 == 2 && local15 < FriendsList.count) {
                                                anIntArray578[anInt7142++] = FriendsList.worlds[local15];
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3603) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 == 2 && local15 < FriendsList.count) {
                                                anIntArray578[anInt7142++] = Static715.anIntArray881[local15];
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3604) {
                                            local4911 = aStringArray37[--anInt7139];
                                            local21 = anIntArray578[--anInt7142];
                                            Static430.method5819(local4911, local21);
                                            return;
                                        }
                                        if (arg0 == 3605) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static706.method9225(local4911);
                                            return;
                                        }
                                        if (arg0 == 3606) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static545.method7242(local4911);
                                            return;
                                        }
                                        if (arg0 == 3607) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static231.method3382(false, local4911);
                                            return;
                                        }
                                        if (arg0 == 3608) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static726.method9463(local4911);
                                            return;
                                        }
                                        if (arg0 == 3609) {
                                            local4911 = aStringArray37[--anInt7139];
                                            if (local4911.startsWith("<img=0>") || local4911.startsWith("<img=1>")) {
                                                local4911 = local4911.substring(7);
                                            }
                                            anIntArray578[anInt7142++] = Static362.method5241(0, local4911) ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3610) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 == 2 && local15 < FriendsList.count) {
                                                aStringArray37[anInt7139++] = Static419.aStringArray33[local15];
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3611) {
                                            if (Static723.aString129 != null) {
                                                aStringArray37[anInt7139++] = Static682.method8923(Static723.aString129);
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3612) {
                                            if (Static723.aString129 != null) {
                                                anIntArray578[anInt7142++] = FriendChat.count;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3613) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static723.aString129 != null && local15 < FriendChat.count) {
                                                aStringArray37[anInt7139++] = FriendChat.users[local15].aString67;
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3614) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static723.aString129 != null && local15 < FriendChat.count) {
                                                anIntArray578[anInt7142++] = FriendChat.users[local15].anInt6148;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3615) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static723.aString129 != null && local15 < FriendChat.count) {
                                                anIntArray578[anInt7142++] = FriendChat.users[local15].aByte99;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3616) {
                                            anIntArray578[anInt7142++] = Static673.aByte140;
                                            return;
                                        }
                                        if (arg0 == 3617) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static128.method7754(local4911);
                                            return;
                                        }
                                        if (arg0 == 3618) {
                                            anIntArray578[anInt7142++] = Static682.aByte142;
                                            return;
                                        }
                                        if (arg0 == 3619) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static698.method9124(local4911);
                                            return;
                                        }
                                        if (arg0 == 3620) {
                                            Static396.method5551();
                                            return;
                                        }
                                        if (arg0 == 3621) {
                                            if (Static251.anInt4036 == 0) {
                                                anIntArray578[anInt7142++] = -1;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = Static436.anInt3849;
                                            return;
                                        }
                                        if (arg0 == 3622) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 != 0 && local15 < Static436.anInt3849) {
                                                aStringArray37[anInt7139++] = Static632.aStringArray44[local15];
                                                if (Static10.aStringArray1[local15] != null) {
                                                    aStringArray37[anInt7139++] = Static10.aStringArray1[local15];
                                                    return;
                                                }
                                                aStringArray37[anInt7139++] = "";
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3623) {
                                            local4911 = aStringArray37[--anInt7139];
                                            if (local4911.startsWith("<img=0>") || local4911.startsWith("<img=1>")) {
                                                local4911 = local4911.substring(7);
                                            }
                                            anIntArray578[anInt7142++] = Static71.method1524(local4911) ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3624) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (FriendChat.users != null && local15 < FriendChat.count && FriendChat.users[local15].accountName.equalsIgnoreCase(PlayerEntity.self.accountName)) {
                                                anIntArray578[anInt7142++] = 1;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3625) {
                                            if (Static158.aString28 != null) {
                                                aStringArray37[anInt7139++] = Static158.aString28;
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3626) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static723.aString129 != null && local15 < FriendChat.count) {
                                                aStringArray37[anInt7139++] = FriendChat.users[local15].aString65;
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3627) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 == 2 && local15 >= 0 && local15 < FriendsList.count) {
                                                anIntArray578[anInt7142++] = Static623.aBooleanArray30[local15] ? 1 : 0;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3628) {
                                            local4911 = aStringArray37[--anInt7139];
                                            if (local4911.startsWith("<img=0>") || local4911.startsWith("<img=1>")) {
                                                local4911 = local4911.substring(7);
                                            }
                                            anIntArray578[anInt7142++] = Static664.method8658(local4911);
                                            return;
                                        }
                                        if (arg0 == 3629) {
                                            anIntArray578[anInt7142++] = client.country;
                                            return;
                                        }
                                        if (arg0 == 3630) {
                                            local4911 = aStringArray37[--anInt7139];
                                            Static231.method3382(true, local4911);
                                            return;
                                        }
                                        if (arg0 == 3631) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static65.aBooleanArray2[local15] ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3632) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static723.aString129 != null && local15 < FriendChat.count) {
                                                aStringArray37[anInt7139++] = FriendChat.users[local15].accountName;
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3633) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 != 0 && local15 < Static436.anInt3849) {
                                                aStringArray37[anInt7139++] = Static446.aStringArray35[local15];
                                                return;
                                            }
                                            aStringArray37[anInt7139++] = "";
                                            return;
                                        }
                                        if (arg0 == 3634) {
                                            local15 = anIntArray578[--anInt7142];
                                            if (Static251.anInt4036 == 2 && local15 < FriendsList.count) {
                                                anIntArray578[anInt7142++] = Static429.aBooleanArray21[local15] ? 1 : 0;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                    } else if (arg0 < 3800) {
                                        if (arg0 == 3700) {
                                            if (Static91.aClanSettings_9 != null) {
                                                anIntArray578[anInt7142++] = 1;
                                                aClanSettings_7 = Static91.aClanSettings_9;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3701) {
                                            if (Static128.aClanSettings_8 != null) {
                                                anIntArray578[anInt7142++] = 1;
                                                aClanSettings_7 = Static128.aClanSettings_8;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3702) {
                                            aStringArray37[anInt7139++] = aClanSettings_7.name;
                                            return;
                                        }
                                        if (arg0 == 3703) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.allowNonMembers ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3704) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.rankTalk;
                                            return;
                                        }
                                        if (arg0 == 3705) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.rankKick;
                                            return;
                                        }
                                        if (arg0 == 3706) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.rankLootShare;
                                            return;
                                        }
                                        if (arg0 == 3707) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.coinshare;
                                            return;
                                        }
                                        if (arg0 == 3709) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.affinedCount;
                                            return;
                                        }
                                        if (arg0 == 3710) {
                                            local15 = anIntArray578[--anInt7142];
                                            aStringArray37[anInt7139++] = aClanSettings_7.affinedDisplayNames[local15];
                                            return;
                                        }
                                        if (arg0 == 3711) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = aClanSettings_7.affinedRanks[local15];
                                            return;
                                        }
                                        if (arg0 == 3712) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.bannedCount;
                                            return;
                                        }
                                        if (arg0 == 3713) {
                                            local15 = anIntArray578[--anInt7142];
                                            aStringArray37[anInt7139++] = aClanSettings_7.bannedDisplayNames[local15];
                                            return;
                                        }
                                        if (arg0 == 3714) {
                                            anInt7142 -= 3;
                                            local15 = anIntArray578[anInt7142];
                                            local21 = anIntArray578[anInt7142 + 1];
                                            local27 = anIntArray578[anInt7142 + 2];
                                            anIntArray578[anInt7142++] = aClanSettings_7.getAffinedExtraInfo(local21, local27, local15);
                                            return;
                                        }
                                        if (arg0 == 3715) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.currentOwnerSlot;
                                            return;
                                        }
                                        if (arg0 == 3716) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.replacementOwnerSlot;
                                            return;
                                        }
                                        if (arg0 == 3717) {
                                            anIntArray578[anInt7142++] = aClanSettings_7.affinedSlot(aStringArray37[--anInt7139]);
                                            return;
                                        }
                                        if (arg0 == 3718) {
                                            anIntArray578[anInt7142 - 1] = aClanSettings_7.sortedAffinedSlots()[anIntArray578[anInt7142 - 1]];
                                            return;
                                        }
                                        if (arg0 == 3719) {
                                            Static180.method2775(anIntArray578[--anInt7142]);
                                            return;
                                        }
                                        if (arg0 == 3720) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = aClanSettings_7.affinedJoinRuneday[local15];
                                            return;
                                        }
                                        if (arg0 == 3750) {
                                            if (Static674.aClass2_Sub47_3 != null) {
                                                anIntArray578[anInt7142++] = 1;
                                                aClass2_Sub47_2 = Static674.aClass2_Sub47_3;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3751) {
                                            if (Static45.aClass2_Sub47_1 != null) {
                                                anIntArray578[anInt7142++] = 1;
                                                aClass2_Sub47_2 = Static45.aClass2_Sub47_1;
                                                return;
                                            }
                                            anIntArray578[anInt7142++] = 0;
                                            return;
                                        }
                                        if (arg0 == 3752) {
                                            aStringArray37[anInt7139++] = aClass2_Sub47_2.channelName;
                                            return;
                                        }
                                        if (arg0 == 3753) {
                                            anIntArray578[anInt7142++] = aClass2_Sub47_2.kickRank;
                                            return;
                                        }
                                        if (arg0 == 3754) {
                                            anIntArray578[anInt7142++] = aClass2_Sub47_2.talkRank;
                                            return;
                                        }
                                        if (arg0 == 3755) {
                                            anIntArray578[anInt7142++] = aClass2_Sub47_2.userCount;
                                            return;
                                        }
                                        if (arg0 == 3756) {
                                            local15 = anIntArray578[--anInt7142];
                                            aStringArray37[anInt7139++] = aClass2_Sub47_2.users[local15].displayName;
                                            return;
                                        }
                                        if (arg0 == 3757) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = aClass2_Sub47_2.users[local15].rank;
                                            return;
                                        }
                                        if (arg0 == 3758) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = aClass2_Sub47_2.users[local15].world;
                                            return;
                                        }
                                        if (arg0 == 3759) {
                                            local15 = anIntArray578[--anInt7142];
                                            Static525.method7886(aClass2_Sub47_2 == Static45.aClass2_Sub47_1, local15);
                                            return;
                                        }
                                        if (arg0 == 3760) {
                                            anIntArray578[anInt7142++] = aClass2_Sub47_2.userSlot(aStringArray37[--anInt7139]);
                                            return;
                                        }
                                        if (arg0 == 3761) {
                                            anIntArray578[anInt7142 - 1] = aClass2_Sub47_2.sortedUserSlots()[anIntArray578[anInt7142 - 1]];
                                            return;
                                        }
                                        if (arg0 == 3790) {
                                            anIntArray578[anInt7142++] = Static279.anObjectArray35 == null ? 0 : 1;
                                            return;
                                        }
                                    } else if (arg0 < 4000) {
                                        if (arg0 == 3903) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static105.aClass171Array1[local15].method3547();
                                            return;
                                        }
                                        if (arg0 == 3904) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static105.aClass171Array1[local15].anInt4033;
                                            return;
                                        }
                                        if (arg0 == 3905) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static105.aClass171Array1[local15].anInt4040;
                                            return;
                                        }
                                        if (arg0 == 3906) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static105.aClass171Array1[local15].anInt4034;
                                            return;
                                        }
                                        if (arg0 == 3907) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static105.aClass171Array1[local15].anInt4035;
                                            return;
                                        }
                                        if (arg0 == 3908) {
                                            local15 = anIntArray578[--anInt7142];
                                            anIntArray578[anInt7142++] = Static105.aClass171Array1[local15].anInt4032;
                                            return;
                                        }
                                        if (arg0 == 3910) {
                                            local15 = anIntArray578[--anInt7142];
                                            local21 = Static105.aClass171Array1[local15].method3548();
                                            anIntArray578[anInt7142++] = local21 == 0 ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3911) {
                                            local15 = anIntArray578[--anInt7142];
                                            local21 = Static105.aClass171Array1[local15].method3548();
                                            anIntArray578[anInt7142++] = local21 == 2 ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3912) {
                                            local15 = anIntArray578[--anInt7142];
                                            local21 = Static105.aClass171Array1[local15].method3548();
                                            anIntArray578[anInt7142++] = local21 == 5 ? 1 : 0;
                                            return;
                                        }
                                        if (arg0 == 3913) {
                                            local15 = anIntArray578[--anInt7142];
                                            local21 = Static105.aClass171Array1[local15].method3548();
                                            anIntArray578[anInt7142++] = local21 == 1 ? 1 : 0;
                                            return;
                                        }
                                    } else {
                                        @Pc(9705) long local9705;
                                        if (arg0 < 4100) {
                                            if (arg0 == 4000) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 + local21;
                                                return;
                                            }
                                            if (arg0 == 4001) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 - local21;
                                                return;
                                            }
                                            if (arg0 == 4002) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 * local21;
                                                return;
                                            }
                                            if (arg0 == 4003) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 / local21;
                                                return;
                                            }
                                            if (arg0 == 4004) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = (int) (Math.random() * (double) local15);
                                                return;
                                            }
                                            if (arg0 == 4005) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = (int) (Math.random() * (double) (local15 + 1));
                                                return;
                                            }
                                            if (arg0 == 4006) {
                                                anInt7142 -= 5;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local27 = anIntArray578[anInt7142 + 2];
                                                local506 = anIntArray578[anInt7142 + 3];
                                                local2978 = anIntArray578[anInt7142 + 4];
                                                anIntArray578[anInt7142++] = local15 + (local21 - local15) * (local2978 - local27) / (local506 - local27);
                                                return;
                                            }
                                            @Pc(9712) long local9712;
                                            if (arg0 == 4007) {
                                                anInt7142 -= 2;
                                                local9705 = anIntArray578[anInt7142];
                                                local9712 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = (int) (local9705 + local9705 * local9712 / 100L);
                                                return;
                                            }
                                            if (arg0 == 4008) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 | 0x1 << local21;
                                                return;
                                            }
                                            if (arg0 == 4009) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 & -(0x1 << local21) - 1;
                                                return;
                                            }
                                            if (arg0 == 4010) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = (local15 & 0x1 << local21) == 0 ? 0 : 1;
                                                return;
                                            }
                                            if (arg0 == 4011) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 % local21;
                                                return;
                                            }
                                            if (arg0 == 4012) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                if (local15 == 0) {
                                                    anIntArray578[anInt7142++] = 0;
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = (int) Math.pow(local15, local21);
                                                return;
                                            }
                                            if (arg0 == 4013) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                if (local15 == 0) {
                                                    anIntArray578[anInt7142++] = 0;
                                                    return;
                                                }
                                                if (local21 == 0) {
                                                    anIntArray578[anInt7142++] = Integer.MAX_VALUE;
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = (int) Math.pow(local15, 1.0D / (double) local21);
                                                return;
                                            }
                                            if (arg0 == 4014) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 & local21;
                                                return;
                                            }
                                            if (arg0 == 4015) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 | local21;
                                                return;
                                            }
                                            if (arg0 == 4016) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 < local21 ? local15 : local21;
                                                return;
                                            }
                                            if (arg0 == 4017) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local15 > local21 ? local15 : local21;
                                                return;
                                            }
                                            if (arg0 == 4018) {
                                                anInt7142 -= 3;
                                                local9705 = anIntArray578[anInt7142];
                                                local9712 = anIntArray578[anInt7142 + 1];
                                                @Pc(10099) long local10099 = anIntArray578[anInt7142 + 2];
                                                anIntArray578[anInt7142++] = (int) (local9705 * local10099 / local9712);
                                                return;
                                            }
                                            if (arg0 == 4019) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                if (local15 > 700 || local21 > 700) {
                                                    anIntArray578[anInt7142++] = 256;
                                                }
                                                @Pc(10162) double local10162 = (Math.random() * (double) (local21 + local15) + 800.0D - (double) local15) / 100.0D;
                                                anIntArray578[anInt7142++] = (int) (Math.pow(2.0D, local10162) + 0.5D);
                                                return;
                                            }
                                            if (arg0 == 4020) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = ColourUtils.HSV_TO_RGB[ColourUtils.hslToHsv(local15) & 0xFFFF];
                                                return;
                                            }
                                        } else if (arg0 < 4200) {
                                            if (arg0 == 4100) {
                                                local4911 = aStringArray37[--anInt7139];
                                                local21 = anIntArray578[--anInt7142];
                                                aStringArray37[anInt7139++] = local4911 + local21;
                                                return;
                                            }
                                            if (arg0 == 4101) {
                                                anInt7139 -= 2;
                                                local4911 = aStringArray37[anInt7139];
                                                local1394 = aStringArray37[anInt7139 + 1];
                                                aStringArray37[anInt7139++] = local4911 + local1394;
                                                return;
                                            }
                                            if (arg0 == 4102) {
                                                local4911 = aStringArray37[--anInt7139];
                                                local21 = anIntArray578[--anInt7142];
                                                aStringArray37[anInt7139++] = local4911 + StringTools.decimalWithSign(true, local21);
                                                return;
                                            }
                                            if (arg0 == 4103) {
                                                local4911 = aStringArray37[--anInt7139];
                                                aStringArray37[anInt7139++] = local4911.toLowerCase();
                                                return;
                                            }
                                            if (arg0 == 4104) {
                                                aStringArray37[anInt7139++] = Static522.method6994(client.language, Static38.method1003(anIntArray578[--anInt7142]));
                                                return;
                                            }
                                            if (arg0 == 4105) {
                                                anInt7139 -= 2;
                                                local4911 = aStringArray37[anInt7139];
                                                local1394 = aStringArray37[anInt7139 + 1];
                                                if (PlayerEntity.self.playerModel != null && PlayerEntity.self.playerModel.female) {
                                                    aStringArray37[anInt7139++] = local1394;
                                                    return;
                                                }
                                                aStringArray37[anInt7139++] = local4911;
                                                return;
                                            }
                                            if (arg0 == 4106) {
                                                local15 = anIntArray578[--anInt7142];
                                                aStringArray37[anInt7139++] = Integer.toString(local15);
                                                return;
                                            }
                                            if (arg0 == 4107) {
                                                anInt7139 -= 2;
                                                anIntArray578[anInt7142++] = Static540.compare(aStringArray37[anInt7139 + 1], client.language, aStringArray37[anInt7139]);
                                                return;
                                            }
                                            @Pc(10482) FontMetrics local10482;
                                            if (arg0 == 4108) {
                                                local4911 = aStringArray37[--anInt7139];
                                                anInt7142 -= 2;
                                                local21 = anIntArray578[anInt7142];
                                                local27 = anIntArray578[anInt7142 + 1];
                                                local10482 = FontMetrics.loadGroup(local27, js5.FONTMETRICS);
                                                anIntArray578[anInt7142++] = local10482.paraHeight(local4911, Sprites.nameIcons, local21);
                                                return;
                                            }
                                            if (arg0 == 4109) {
                                                local4911 = aStringArray37[--anInt7139];
                                                anInt7142 -= 2;
                                                local21 = anIntArray578[anInt7142];
                                                local27 = anIntArray578[anInt7142 + 1];
                                                local10482 = FontMetrics.loadGroup(local27, js5.FONTMETRICS);
                                                anIntArray578[anInt7142++] = local10482.paraWidth(Sprites.nameIcons, local4911, local21);
                                                return;
                                            }
                                            if (arg0 == 4110) {
                                                anInt7139 -= 2;
                                                local4911 = aStringArray37[anInt7139];
                                                local1394 = aStringArray37[anInt7139 + 1];
                                                if (anIntArray578[--anInt7142] == 1) {
                                                    aStringArray37[anInt7139++] = local4911;
                                                    return;
                                                }
                                                aStringArray37[anInt7139++] = local1394;
                                                return;
                                            }
                                            if (arg0 == 4111) {
                                                local4911 = aStringArray37[--anInt7139];
                                                aStringArray37[anInt7139++] = Static130.method2280(local4911);
                                                return;
                                            }
                                            if (arg0 == 4112) {
                                                local4911 = aStringArray37[--anInt7139];
                                                local21 = anIntArray578[--anInt7142];
                                                if (local21 == -1) {
                                                    throw new RuntimeException("null char");
                                                }
                                                aStringArray37[anInt7139++] = local4911 + (char) local21;
                                                return;
                                            }
                                            if (arg0 == 4113) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = charIsPrintable((char) local15);
                                                return;
                                            }
                                            if (arg0 == 4114) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = StringTools.isAlphanumeric((char) local15) ? 1 : 0;
                                                return;
                                            }
                                            if (arg0 == 4115) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = StringTools.isAlphabetical((char) local15) ? 1 : 0;
                                                return;
                                            }
                                            if (arg0 == 4116) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = StringTools.isNumeric((char) local15) ? 1 : 0;
                                                return;
                                            }
                                            if (arg0 == 4117) {
                                                local4911 = aStringArray37[--anInt7139];
                                                if (local4911 != null) {
                                                    anIntArray578[anInt7142++] = local4911.length();
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = 0;
                                                return;
                                            }
                                            if (arg0 == 4118) {
                                                local4911 = aStringArray37[--anInt7139];
                                                anInt7142 -= 2;
                                                local21 = anIntArray578[anInt7142];
                                                local27 = anIntArray578[anInt7142 + 1];
                                                aStringArray37[anInt7139++] = local4911.substring(local21, local27);
                                                return;
                                            }
                                            if (arg0 == 4119) {
                                                local4911 = aStringArray37[--anInt7139];
                                                @Pc(10848) StringBuffer local10848 = new StringBuffer(local4911.length());
                                                @Pc(10850) boolean local10850 = false;
                                                for (local506 = 0; local506 < local4911.length(); local506++) {
                                                    @Pc(10857) char local10857 = local4911.charAt(local506);
                                                    if (local10857 == '<') {
                                                        local10850 = true;
                                                    } else if (local10857 == '>') {
                                                        local10850 = false;
                                                    } else if (!local10850) {
                                                        local10848.append(local10857);
                                                    }
                                                }
                                                aStringArray37[anInt7139++] = local10848.toString();
                                                return;
                                            }
                                            if (arg0 == 4120) {
                                                local4911 = aStringArray37[--anInt7139];
                                                anInt7142 -= 2;
                                                local21 = anIntArray578[anInt7142];
                                                local27 = anIntArray578[anInt7142 + 1];
                                                anIntArray578[anInt7142++] = local4911.indexOf(local21, local27);
                                                return;
                                            }
                                            if (arg0 == 4121) {
                                                anInt7139 -= 2;
                                                local4911 = aStringArray37[anInt7139];
                                                local1394 = aStringArray37[anInt7139 + 1];
                                                local27 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = local4911.indexOf(local1394, local27);
                                                return;
                                            }
                                            if (arg0 == 4122) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = Character.toLowerCase((char) local15);
                                                return;
                                            }
                                            if (arg0 == 4123) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = Character.toUpperCase((char) local15);
                                                return;
                                            }
                                            if (arg0 == 4124) {
                                                local575 = anIntArray578[--anInt7142] != 0;
                                                local21 = anIntArray578[--anInt7142];
                                                aStringArray37[anInt7139++] = StringTools.formatNumber(client.language, local575, local21, 0);
                                                return;
                                            }
                                            if (arg0 == 4125) {
                                                local4911 = aStringArray37[--anInt7139];
                                                local21 = anIntArray578[--anInt7142];
                                                @Pc(11077) FontMetrics local11077 = FontMetrics.loadGroup(local21, js5.FONTMETRICS);
                                                anIntArray578[anInt7142++] = local11077.stringWidth(Sprites.nameIcons, local4911);
                                                return;
                                            }
                                            if (arg0 == 4126) {
                                                aStringArray37[anInt7139++] = Static647.method8474((long) anIntArray578[--anInt7142] * 60000L, client.language) + " UTC";
                                                return;
                                            }
                                            if (arg0 == 4127) {
                                                local9705 = aLongArray14[--anInt7152];
                                                aStringArray37[anInt7139++] = local9705 == -1L ? "" : Long.toString(local9705, 36).toUpperCase();
                                                return;
                                            }
                                        } else if (arg0 < 4300) {
                                            if (arg0 == 4200) {
                                                local15 = anIntArray578[--anInt7142];
                                                aStringArray37[anInt7139++] = ObjTypeList.instance.list(local15).name;
                                                return;
                                            }
                                            @Pc(11206) ObjType local11206;
                                            if (arg0 == 4201) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local11206 = ObjTypeList.instance.list(local15);
                                                if (local21 >= 1 && local21 <= 5 && local11206.op[local21 - 1] != null) {
                                                    aStringArray37[anInt7139++] = local11206.op[local21 - 1];
                                                    return;
                                                }
                                                aStringArray37[anInt7139++] = "";
                                                return;
                                            }
                                            if (arg0 == 4202) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local11206 = ObjTypeList.instance.list(local15);
                                                if (local21 >= 1 && local21 <= 5 && local11206.iop[local21 - 1] != null) {
                                                    aStringArray37[anInt7139++] = local11206.iop[local21 - 1];
                                                    return;
                                                }
                                                aStringArray37[anInt7139++] = "";
                                                return;
                                            }
                                            if (arg0 == 4203) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = ObjTypeList.instance.list(local15).cost;
                                                return;
                                            }
                                            if (arg0 == 4204) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = ObjTypeList.instance.list(local15).stackable == 1 ? 1 : 0;
                                                return;
                                            }
                                            @Pc(11380) ObjType local11380;
                                            if (arg0 == 4205) {
                                                local15 = anIntArray578[--anInt7142];
                                                local11380 = ObjTypeList.instance.list(local15);
                                                if (local11380.certtemplate == -1 && local11380.certlink >= 0) {
                                                    anIntArray578[anInt7142++] = local11380.certlink;
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = local15;
                                                return;
                                            }
                                            if (arg0 == 4206) {
                                                local15 = anIntArray578[--anInt7142];
                                                local11380 = ObjTypeList.instance.list(local15);
                                                if (local11380.certtemplate >= 0 && local11380.certlink >= 0) {
                                                    anIntArray578[anInt7142++] = local11380.certlink;
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = local15;
                                                return;
                                            }
                                            if (arg0 == 4207) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = ObjTypeList.instance.list(local15).members ? 1 : 0;
                                                return;
                                            }
                                            if (arg0 == 4208) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local3848 = ParamTypeList.instance.list(local21);
                                                if (local3848.isString()) {
                                                    aStringArray37[anInt7139++] = ObjTypeList.instance.list(local15).param(local3848.defaultstr, local21);
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = ObjTypeList.instance.list(local15).param(local21, local3848.defaultint);
                                                return;
                                            }
                                            if (arg0 == 4209) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1] - 1;
                                                local11206 = ObjTypeList.instance.list(local15);
                                                if (local11206.cursor1iop == local21) {
                                                    anIntArray578[anInt7142++] = local11206.icursor1;
                                                    return;
                                                }
                                                if (local11206.cursor2iop == local21) {
                                                    anIntArray578[anInt7142++] = local11206.icursor2;
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = -1;
                                                return;
                                            }
                                            if (arg0 == 4210) {
                                                local4911 = aStringArray37[--anInt7139];
                                                local21 = anIntArray578[--anInt7142];
                                                Static331.method4924(local21 == 1, local4911);
                                                anIntArray578[anInt7142++] = Static606.anInt8947;
                                                return;
                                            }
                                            if (arg0 == 4211) {
                                                if (Static256.aShortArray63 != null && Static143.anInt4054 < Static606.anInt8947) {
                                                    anIntArray578[anInt7142++] = Static256.aShortArray63[Static143.anInt4054++] & 0xFFFF;
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = -1;
                                                return;
                                            }
                                            if (arg0 == 4212) {
                                                Static143.anInt4054 = 0;
                                                return;
                                            }
                                            if (arg0 == 4213) {
                                                local15 = anIntArray578[--anInt7142];
                                                anIntArray578[anInt7142++] = ObjTypeList.instance.list(local15).multistacksize;
                                                return;
                                            }
                                            if (arg0 == 4214) {
                                                local4911 = aStringArray37[--anInt7139];
                                                anInt7142 -= 3;
                                                local21 = anIntArray578[anInt7142];
                                                local27 = anIntArray578[anInt7142 + 1];
                                                local506 = anIntArray578[anInt7142 + 2];
                                                Static263.method3855(local21 == 1, local506, local27, local4911);
                                                anIntArray578[anInt7142++] = Static606.anInt8947;
                                                return;
                                            }
                                            if (arg0 == 4215) {
                                                anInt7139 -= 2;
                                                anInt7142 -= 2;
                                                local4911 = aStringArray37[anInt7139];
                                                local21 = anIntArray578[anInt7142];
                                                local27 = anIntArray578[anInt7142 + 1];
                                                local7345 = aStringArray37[anInt7139 + 1];
                                                Static715.method9347(local4911, local27, local7345, 8, local21 == 1);
                                                anIntArray578[anInt7142++] = Static606.anInt8947;
                                                return;
                                            }
                                        } else if (arg0 < 4400) {
                                            if (arg0 == 4300) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local3848 = ParamTypeList.instance.list(local21);
                                                if (local3848.isString()) {
                                                    aStringArray37[anInt7139++] = NPCTypeList.instance.list(local15).param(local3848.defaultstr, local21);
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = NPCTypeList.instance.list(local15).param(local21, local3848.defaultint);
                                                return;
                                            }
                                        } else if (arg0 < 4500) {
                                            if (arg0 == 4400) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local3848 = ParamTypeList.instance.list(local21);
                                                if (local3848.isString()) {
                                                    aStringArray37[anInt7139++] = LocTypeList.instance.list(local15).param(local3848.defaultstr, local21);
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = LocTypeList.instance.list(local15).param(local3848.defaultint, local21);
                                                return;
                                            }
                                        } else if (arg0 < 4600) {
                                            if (arg0 == 4500) {
                                                anInt7142 -= 2;
                                                local15 = anIntArray578[anInt7142];
                                                local21 = anIntArray578[anInt7142 + 1];
                                                local3848 = ParamTypeList.instance.list(local21);
                                                if (local3848.isString()) {
                                                    aStringArray37[anInt7139++] = StructTypeList.instance.list(local15).param(local21, local3848.defaultstr);
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = StructTypeList.instance.list(local15).param(local3848.defaultint, local21);
                                                return;
                                            }
                                        } else if (arg0 < 4700) {
                                            if (arg0 == 4600) {
                                                local15 = anIntArray578[--anInt7142];
                                                @Pc(12037) BASType local12037 = BASTypeList.instance.list(local15);
                                                if (local12037.readyAnimations != null && local12037.readyAnimations.length > 0) {
                                                    local27 = 0;
                                                    local506 = local12037.readyAnimationWeights[0];
                                                    for (local2978 = 1; local2978 < local12037.readyAnimations.length; local2978++) {
                                                        if (local12037.readyAnimationWeights[local2978] > local506) {
                                                            local27 = local2978;
                                                            local506 = local12037.readyAnimationWeights[local2978];
                                                        }
                                                    }
                                                    anIntArray578[anInt7142++] = local12037.readyAnimations[local27];
                                                    return;
                                                }
                                                anIntArray578[anInt7142++] = local12037.ready;
                                                return;
                                            }
                                        } else if (arg0 < 4800) {
                                            if (arg0 == 4700) {
                                                anIntArray578[anInt7142++] = Static587.aBoolean663 ? 1 : 0;
                                                return;
                                            }
                                            if (arg0 == 4701) {
                                                local4911 = aStringArray37[--anInt7139];
                                                if (MainLogicManager.step == 7 && !Static242.method3500()) {
                                                    if (local4911.length() > 20) {
                                                        Static486.aByte115 = -4;
                                                        return;
                                                    }
                                                    Static486.aByte115 = -1;
                                                    local5005 = ClientMessage.create(Static429.A_CLIENT_PROT___81, ConnectionManager.LOBBY.cipher);
                                                    local5005.bitPacket.p1(0);
                                                    local27 = local5005.bitPacket.pos;
                                                    local5005.bitPacket.pjstr(local4911);
                                                    local5005.bitPacket.psize1(local5005.bitPacket.pos - local27);
                                                    ConnectionManager.LOBBY.send(local5005);
                                                    return;
                                                }
                                                Static486.aByte115 = -5;
                                                return;
                                            }
                                            if (arg0 == 4702) {
                                                anIntArray578[anInt7142++] = Static486.aByte115;
                                                if (Static486.aByte115 != -1) {
                                                    Static486.aByte115 = -6;
                                                }
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (arg0 >= 2000) {
                    arg0 -= 1000;
                    component = InterfaceList.list(anIntArray578[--anInt7142]);
                } else {
                    component = arg1 ? aComponent_12 : aComponent_11;
                }
                if (arg0 == 1000) {
                    anInt7142 -= 4;
                    component.basePosX = anIntArray578[anInt7142];
                    component.basePosY = anIntArray578[anInt7142 + 1];
                    local21 = anIntArray578[anInt7142 + 2];
                    if (local21 < 0) {
                        local21 = 0;
                    } else if (local21 > 5) {
                        local21 = 5;
                    }
                    local27 = anIntArray578[anInt7142 + 3];
                    if (local27 < 0) {
                        local27 = 0;
                    } else if (local27 > 5) {
                        local27 = 5;
                    }
                    component.posTypeHorizontal = (byte) local21;
                    component.postTypeVertical = (byte) local27;
                    InterfaceManager.redraw(component);
                    Static44.method1073(component);
                    if (component.id == -1) {
                        DelayedStateChange.interfaceResetPosition(component.slot);
                    }
                    return;
                }
                if (arg0 == 1001) {
                    anInt7142 -= 4;
                    component.baseWidth = anIntArray578[anInt7142];
                    component.baseHeight = anIntArray578[anInt7142 + 1];
                    component.anInt3800 = 0;
                    component.anInt3825 = 0;
                    local21 = anIntArray578[anInt7142 + 2];
                    if (local21 < 0) {
                        local21 = 0;
                    } else if (local21 > 4) {
                        local21 = 4;
                    }
                    local27 = anIntArray578[anInt7142 + 3];
                    if (local27 < 0) {
                        local27 = 0;
                    } else if (local27 > 4) {
                        local27 = 4;
                    }
                    component.sizeTypeHorizontal = (byte) local21;
                    component.sizeTypeVertical = (byte) local27;
                    InterfaceManager.redraw(component);
                    Static44.method1073(component);
                    if (component.type == 0) {
                        InterfaceManager.calculateLayerDimensions(component, false);
                    }
                    return;
                }
                if (arg0 == 1003) {
                    @Pc(834) boolean local834 = anIntArray578[--anInt7142] == 1;
                    if (component.hidden != local834) {
                        component.hidden = local834;
                        InterfaceManager.redraw(component);
                    }
                    if (component.id == -1) {
                        DelayedStateChange.interfaceResetHide(component.slot);
                    }
                    return;
                }
                if (arg0 == 1004) {
                    anInt7142 -= 2;
                    component.aspectRatioHeight = anIntArray578[anInt7142];
                    component.aspectRatioWidth = anIntArray578[anInt7142 + 1];
                    InterfaceManager.redraw(component);
                    Static44.method1073(component);
                    if (component.type == 0) {
                        InterfaceManager.calculateLayerDimensions(component, false);
                    }
                    return;
                }
                if (arg0 == 1005) {
                    component.noClickThrough = anIntArray578[--anInt7142] == 1;
                    return;
                }
            }
        }
        throw new IllegalStateException(String.valueOf(arg0));
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!hda;)V")
    public static void method6417(@OriginalArg(0) Component arg0) {
        if (arg0 == null) {
            return;
        }
        @Pc(69) Component[] local69;
        if (arg0.id == -1) {
            @Pc(106) int local106 = arg0.slot >>> 16;
            @Pc(110) Component[] local110 = InterfaceList.cache[local106];
            if (local110 == null) {
                local69 = InterfaceList.interfaces[local106];
                @Pc(119) int local119 = local69.length;
                local110 = InterfaceList.cache[local106] = new Component[local119];
                Arrays.copy(local69, 0, local110, 0, local69.length);
            }
            @Pc(135) int local135;
            for (local135 = 0; local135 < local110.length && local110[local135] != arg0; local135++) {
            }
            if (local135 >= local110.length) {
                return;
            }
            Arrays.copy(local110, 0, local110, 1, local135);
            local110[0] = arg0;
            return;
        }
        @Pc(12) Component local12 = InterfaceList.list(arg0.layer);
        if (local12 == null) {
            return;
        }
        if (local12.dynamicComponents == local12.staticComponents) {
            local12.dynamicComponents = new Component[local12.staticComponents.length];
            local12.dynamicComponents[0] = arg0;
            Arrays.copy(local12.staticComponents, 0, local12.dynamicComponents, 1, arg0.id);
            Arrays.copy(local12.staticComponents, arg0.id + 1, local12.dynamicComponents, arg0.id + 1, local12.staticComponents.length - arg0.id - 1);
            return;
        }
        @Pc(66) int local66 = 0;
        local69 = local12.dynamicComponents;
        while (local66 < local69.length && local69[local66] != arg0) {
            local66++;
        }
        if (local66 >= local69.length) {
            return;
        }
        Arrays.copy(local69, 0, local69, 1, local66);
        local69[0] = arg0;
        return;
    }

    @OriginalMember(owner = "client!ou", name = "b", descriptor = "(IZ)V")
    public static void profileOutput() {
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!fj;I)V")
    public static void method6419(@OriginalArg(0) ClientScript arg0, @OriginalArg(1) int arg1) {
        anInt7142 = 0;
        anInt7139 = 0;
        @Pc(5) int local5 = -1;
        @Pc(8) int[] local8 = arg0.anIntArray254;
        @Pc(11) int[] local11 = arg0.anIntArray255;
        @Pc(13) byte local13 = -1;
        anInt7140 = 0;
        @Pc(706) int local706;
        try {
            @Pc(17) int local17 = 0;
            label381:
            while (true) {
                local17++;
                if (local17 > arg1) {
                    throw new RuntimeException("slow");
                }
                local5++;
                @Pc(34) int local34 = local8[local5];
                if (aBoolean538 && (aString76 == null || arg0.aString31 != null && arg0.aString31.indexOf(aString76) != -1)) {
                    System.out.println(arg0.aString31 + ": " + local34);
                }
                if (local34 >= 150) {
                    @Pc(1436) boolean local1436;
                    if (local11[local5] == 1) {
                        local1436 = true;
                    } else {
                        local1436 = false;
                    }
                    if (local34 >= 150 && local34 < 5000) {
                        method6416(local34, local1436);
                    } else if (local34 >= 5000 && local34 < 10000) {
                        method6421(local34, local1436);
                    } else {
                        throw new IllegalStateException("Command: " + local34);
                    }
                } else if (local34 == 0) {
                    anIntArray578[anInt7142++] = local11[local5];
                } else {
                    @Pc(96) int local96;
                    if (local34 == 1) {
                        local96 = local11[local5];
                        anIntArray578[anInt7142++] = TimedVarDomain.instance.varValues[local96];
                    } else if (local34 == 2) {
                        local96 = local11[local5];
                        TimedVarDomain.instance.setVarValueInt(local96, anIntArray578[--anInt7142]);
                    } else if (local34 == 3) {
                        aStringArray37[anInt7139++] = arg0.aStringArray14[local5];
                    } else if (local34 == 6) {
                        local5 += local11[local5];
                    } else if (local34 == 7) {
                        anInt7142 -= 2;
                        if (anIntArray578[anInt7142] != anIntArray578[anInt7142 + 1]) {
                            local5 += local11[local5];
                        }
                    } else if (local34 == 8) {
                        anInt7142 -= 2;
                        if (anIntArray578[anInt7142] == anIntArray578[anInt7142 + 1]) {
                            local5 += local11[local5];
                        }
                    } else if (local34 == 9) {
                        anInt7142 -= 2;
                        if (anIntArray578[anInt7142] < anIntArray578[anInt7142 + 1]) {
                            local5 += local11[local5];
                        }
                    } else if (local34 == 10) {
                        anInt7142 -= 2;
                        if (anIntArray578[anInt7142] > anIntArray578[anInt7142 + 1]) {
                            local5 += local11[local5];
                        }
                    } else if (local34 == 21) {
                        if (anInt7140 == 0) {
                            return;
                        }
                        @Pc(270) Class143 local270 = aClass143Array1[--anInt7140];
                        arg0 = local270.aClass2_Sub2_Sub10_1;
                        local8 = arg0.anIntArray254;
                        local11 = arg0.anIntArray255;
                        local5 = local270.anInt3391;
                        anIntArray580 = local270.anIntArray276;
                        aStringArray36 = local270.aStringArray16;
                        aLongArray15 = local270.aLongArray5;
                    } else if (local34 == 25) {
                        local96 = local11[local5];
                        anIntArray578[anInt7142++] = TimedVarDomain.instance.getVarBitValue(local96);
                    } else if (local34 == 27) {
                        local96 = local11[local5];
                        TimedVarDomain.instance.setVarBitValue(anIntArray578[--anInt7142], local96);
                    } else if (local34 == 31) {
                        anInt7142 -= 2;
                        if (anIntArray578[anInt7142] <= anIntArray578[anInt7142 + 1]) {
                            local5 += local11[local5];
                        }
                    } else if (local34 == 32) {
                        anInt7142 -= 2;
                        if (anIntArray578[anInt7142] >= anIntArray578[anInt7142 + 1]) {
                            local5 += local11[local5];
                        }
                    } else if (local34 == 33) {
                        anIntArray578[anInt7142++] = anIntArray580[local11[local5]];
                    } else if (local34 == 34) {
                        anIntArray580[local11[local5]] = anIntArray578[--anInt7142];
                    } else if (local34 == 35) {
                        aStringArray37[anInt7139++] = aStringArray36[local11[local5]];
                    } else if (local34 == 36) {
                        aStringArray36[local11[local5]] = aStringArray37[--anInt7139];
                    } else {
                        @Pc(465) String local465;
                        if (local34 == 37) {
                            local96 = local11[local5];
                            anInt7139 -= local96;
                            local465 = Static142.method2381(local96, anInt7139, aStringArray37);
                            aStringArray37[anInt7139++] = local465;
                        } else if (local34 == 38) {
                            anInt7142--;
                        } else if (local34 == 39) {
                            anInt7139--;
                        } else if (local34 == 40) {
                            local96 = local11[local5];
                            @Pc(503) ClientScript local503 = ClientScriptList.list(local96);
                            if (local503 == null) {
                                throw new RuntimeException();
                            }
                            @Pc(514) int[] local514 = new int[local503.anInt2948];
                            @Pc(518) String[] local518 = new String[local503.anInt2950];
                            @Pc(522) long[] local522 = new long[local503.anInt2949];
                            for (@Pc(524) int local524 = 0; local524 < local503.anInt2951; local524++) {
                                local514[local524] = anIntArray578[anInt7142 + local524 - local503.anInt2951];
                            }
                            for (@Pc(543) int local543 = 0; local543 < local503.anInt2953; local543++) {
                                local518[local543] = aStringArray37[anInt7139 + local543 - local503.anInt2953];
                            }
                            for (@Pc(562) int local562 = 0; local562 < local503.anInt2954; local562++) {
                                local522[local562] = aLongArray14[anInt7152 + local562 - local503.anInt2954];
                            }
                            anInt7142 -= local503.anInt2951;
                            anInt7139 -= local503.anInt2953;
                            anInt7152 -= local503.anInt2954;
                            @Pc(598) Class143 local598 = new Class143();
                            local598.aClass2_Sub2_Sub10_1 = arg0;
                            local598.anInt3391 = local5;
                            local598.anIntArray276 = anIntArray580;
                            local598.aStringArray16 = aStringArray36;
                            local598.aLongArray5 = aLongArray15;
                            if (anInt7140 >= aClass143Array1.length) {
                                throw new RuntimeException();
                            }
                            aClass143Array1[anInt7140++] = local598;
                            arg0 = local503;
                            local8 = local503.anIntArray254;
                            local11 = local503.anIntArray255;
                            local5 = -1;
                            anIntArray580 = local514;
                            aStringArray36 = local518;
                            aLongArray15 = local522;
                        } else if (local34 == 42) {
                            anIntArray578[anInt7142++] = Static511.varcs[local11[local5]];
                        } else if (local34 == 43) {
                            local96 = local11[local5];
                            Static511.varcs[local96] = anIntArray578[--anInt7142];
                            DelayedStateChange.resetVarc(local96);
                            Static624.varcSaveRecommended |= Static118.permVarcs[local96];
                        } else if (local34 == 44) {
                            local96 = local11[local5] >> 16;
                            local706 = local11[local5] & 0xFFFF;
                            @Pc(714) int local714 = anIntArray578[--anInt7142];
                            if (local714 >= 0 && local714 <= 5000) {
                                anIntArray581[local96] = local714;
                                @Pc(732) byte local732 = -1;
                                if (local706 == 105) {
                                    local732 = 0;
                                }
                                @Pc(739) int local739 = 0;
                                while (true) {
                                    if (local739 >= local714) {
                                        continue label381;
                                    }
                                    anIntArrayArray177[local96][local739] = local732;
                                    local739++;
                                }
                            }
                            throw new RuntimeException();
                        } else if (local34 == 45) {
                            local96 = local11[local5];
                            local706 = anIntArray578[--anInt7142];
                            if (local706 < 0 || local706 >= anIntArray581[local96]) {
                                throw new RuntimeException();
                            }
                            anIntArray578[anInt7142++] = anIntArrayArray177[local96][local706];
                        } else if (local34 == 46) {
                            local96 = local11[local5];
                            anInt7142 -= 2;
                            local706 = anIntArray578[anInt7142];
                            if (local706 < 0 || local706 >= anIntArray581[local96]) {
                                throw new RuntimeException();
                            }
                            anIntArrayArray177[local96][local706] = anIntArray578[anInt7142 + 1];
                        } else if (local34 == 47) {
                            @Pc(843) String local843 = Static37.aStringArray4[local11[local5]];
                            if (local843 == null) {
                                local843 = "null";
                            }
                            aStringArray37[anInt7139++] = local843;
                        } else if (local34 == 48) {
                            local96 = local11[local5];
                            Static37.aStringArray4[local96] = aStringArray37[--anInt7139];
                            DelayedStateChange.resetVarcstr(local96);
                        } else if (local34 == 51) {
                            @Pc(889) IterableHashTable local889 = arg0.aIterableHashTableArray1[local11[local5]];
                            @Pc(902) IntNode local902 = (IntNode) local889.get(anIntArray578[--anInt7142]);
                            if (local902 != null) {
                                local5 += local902.value;
                            }
                        } else if (local34 == 54) {
                            aLongArray14[anInt7152++] = arg0.aLongArray4[local5];
                        } else if (local34 == 55) {
                            anInt7152--;
                        } else if (local34 == 66) {
                            aLongArray14[anInt7152++] = aLongArray15[local11[local5]];
                        } else if (local34 == 67) {
                            aLongArray15[local11[local5]] = aLongArray14[--anInt7152];
                        } else if (local34 == 68) {
                            anInt7152 -= 2;
                            if (aLongArray14[anInt7152] != aLongArray14[anInt7152 + 1]) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 69) {
                            anInt7152 -= 2;
                            if (aLongArray14[anInt7152] == aLongArray14[anInt7152 + 1]) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 70) {
                            anInt7152 -= 2;
                            if (aLongArray14[anInt7152] < aLongArray14[anInt7152 + 1]) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 71) {
                            anInt7152 -= 2;
                            if (aLongArray14[anInt7152] > aLongArray14[anInt7152 + 1]) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 72) {
                            anInt7152 -= 2;
                            if (aLongArray14[anInt7152] <= aLongArray14[anInt7152 + 1]) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 73) {
                            anInt7152 -= 2;
                            if (aLongArray14[anInt7152] >= aLongArray14[anInt7152 + 1]) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 86) {
                            if (anIntArray578[--anInt7142] == 1) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 87) {
                            if (anIntArray578[--anInt7142] == 0) {
                                local5 += local11[local5];
                            }
                        } else if (local34 == 106) {
                            local96 = local11[local5];
                            @Pc(1178) Integer local1178 = (Integer) Static279.anObjectArray35[local96];
                            if (local1178 == null) {
                                @Pc(1185) VarClanSettingType local1185 = VarClanSettingTypeList.instance.list(local96);
                                if (local1185.dataType == 'i' || local1185.dataType == '1') {
                                    anIntArray578[anInt7142++] = 0;
                                } else {
                                    anIntArray578[anInt7142++] = -1;
                                }
                            } else {
                                anIntArray578[anInt7142++] = local1178;
                            }
                        } else if (local34 == 107) {
                            local96 = local11[local5];
                            @Pc(1236) VarClanSettingType local1236 = VarClanSettingTypeList.instance.list(local96);
                            if (local1236.dataType != '\u0001') {
                                anIntArray578[anInt7142++] = 0;
                            }
                            @Pc(1256) Integer local1256 = (Integer) Static279.anObjectArray35[local1236.id];
                            if (local1256 == null) {
                                anIntArray578[anInt7142++] = 0;
                            } else {
                                @Pc(1284) int local1284 = local1236.end == 31 ? -1 : (0x1 << local1236.end + 1) - 1;
                                anIntArray578[anInt7142++] = (local1256 & local1284) >>> local1236.start;
                            }
                        } else if (local34 == 108) {
                            local96 = local11[local5];
                            @Pc(1311) Long local1311 = (Long) Static279.anObjectArray35[local96];
                            if (local1311 == null) {
                                aLongArray14[anInt7152++] = -1L;
                            } else {
                                aLongArray14[anInt7152++] = local1311;
                            }
                        } else if (local34 == 109) {
                            local96 = local11[local5];
                            local465 = (String) Static279.anObjectArray35[local96];
                            if (local465 == null) {
                                aStringArray37[anInt7139++] = "";
                            } else {
                                aStringArray37[anInt7139++] = local465;
                            }
                        } else if (local34 == 112) {
                            anIntArray578[anInt7142++] = method6412(local11[local5]);
                        } else if (local34 == 113) {
                            anIntArray578[anInt7142++] = method6411(local11[local5]);
                        } else if (local34 == 114) {
                            aLongArray14[anInt7152++] = method6413(local11[local5]);
                        } else if (local34 == 115) {
                            aStringArray37[anInt7139++] = method6425(local11[local5]);
                        }
                    }
                }
            }
        } catch (@Pc(1479) Exception local1479) {
            @Pc(1484) StringBuffer local1484 = new StringBuffer(30);
            local1484.append("CS2: ").append(arg0.key).append(" ");
            for (local706 = anInt7140 - 1; local706 >= 0; local706--) {
                local1484.append("v: ").append(aClass143Array1[local706].aClass2_Sub2_Sub10_1.key).append(" ");
            }
            local1484.append("op: ").append(local13);
            JagException.sendTrace(local1479, local1484.toString());
        }
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!pd;)V")
    public static void executeHookInner(@OriginalArg(0) HookRequest arg0) {
        method6422(arg0, 200000);
    }

    @OriginalMember(owner = "client!ou", name = "c", descriptor = "(IZ)V")
    public static void method6421(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        @Pc(109) int local109;
        @Pc(375) int local375;
        @Pc(95) String local95;
        @Pc(192) int local192;
        @Pc(1578) boolean local1578;
        @Pc(834) int local834;
        @Pc(115) int local115;
        @Pc(198) String local198;
        @Pc(101) String local101;
        if (arg0 < 5100) {
            if (arg0 == 5000) {
                anIntArray578[anInt7142++] = Static133.anInt2458;
                return;
            }
            @Pc(57) ServerConnection local57;
            @Pc(63) ClientMessage local63;
            if (arg0 == 5001) {
                anInt7142 -= 3;
                Static133.anInt2458 = anIntArray578[anInt7142];
                Static726.aClass280_7 = Static189.method2864(anIntArray578[anInt7142 + 1]);
                if (Static726.aClass280_7 == null) {
                    Static726.aClass280_7 = Static137.aClass280_4;
                }
                Static87.anInt1806 = anIntArray578[anInt7142 + 2];
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(Static98.A_CLIENT_PROT___20, local57.cipher);
                local63.bitPacket.p1(Static133.anInt2458);
                local63.bitPacket.p1(Static726.aClass280_7.anInt7039);
                local63.bitPacket.p1(Static87.anInt1806);
                local57.send(local63);
                return;
            }
            if (arg0 == 5002) {
                anInt7139 -= 2;
                local95 = aStringArray37[anInt7139];
                local101 = aStringArray37[anInt7139 + 1];
                anInt7142 -= 2;
                local109 = anIntArray578[anInt7142];
                local115 = anIntArray578[anInt7142 + 1];
                if (local101 == null) {
                    local101 = "";
                }
                if (local101.length() > 80) {
                    local101 = local101.substring(0, 80);
                }
                @Pc(135) ServerConnection local135 = ConnectionManager.active();
                @Pc(141) ClientMessage local141 = ClientMessage.create(Static245.A_CLIENT_PROT___114, local135.cipher);
                local141.bitPacket.p1(Static231.method3379(local95) + Static231.method3379(local101) + 2);
                local141.bitPacket.pjstr(local95);
                local141.bitPacket.p1(local109 - 1);
                local141.bitPacket.p1(local115);
                local141.bitPacket.pjstr(local101);
                local135.send(local141);
                return;
            }
            @Pc(196) ChatLine local196;
            if (arg0 == 5003) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.message != null) {
                    local198 = local196.message;
                }
                aStringArray37[anInt7139++] = local198;
                return;
            }
            if (arg0 == 5004) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.type;
                }
                anIntArray578[anInt7142++] = local109;
                return;
            }
            if (arg0 == 5005) {
                if (Static726.aClass280_7 == null) {
                    anIntArray578[anInt7142++] = -1;
                    return;
                }
                anIntArray578[anInt7142++] = Static726.aClass280_7.anInt7039;
                return;
            }
            @Pc(295) ClientMessage local295;
            @Pc(289) ServerConnection local289;
            if (arg0 == 5006) {
                local192 = anIntArray578[--anInt7142];
                local289 = ConnectionManager.active();
                local295 = ClientMessage.create(Static356.A_CLIENT_PROT___67, local289.cipher);
                local295.bitPacket.p1(local192);
                local289.send(local295);
                return;
            }
            if (arg0 == 5008) {
                local95 = aStringArray37[--anInt7139];
                method6426(local95, arg0);
                return;
            }
            if (arg0 == 5009) {
                anInt7139 -= 2;
                local95 = aStringArray37[anInt7139];
                local101 = aStringArray37[anInt7139 + 1];
                if (Static608.staffModLevel != 0 || (!Static389.aBoolean459 || Static34.aBoolean62) && !Static617.aBoolean724) {
                    @Pc(360) ServerConnection local360 = ConnectionManager.active();
                    @Pc(366) ClientMessage local366 = ClientMessage.create(ClientProt.MESSAGE_PRIVATE, local360.cipher);
                    local366.bitPacket.p2(0);
                    local375 = local366.bitPacket.pos;
                    local366.bitPacket.pjstr(local95);
                    WordPack.encode(local366.bitPacket, local101);
                    local366.bitPacket.psize2(local366.bitPacket.pos - local375);
                    local360.send(local366);
                    return;
                }
                return;
            }
            if (arg0 == 5010) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.name != null) {
                    local198 = local196.name;
                }
                aStringArray37[anInt7139++] = local198;
                return;
            }
            if (arg0 == 5011) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.channel != null) {
                    local198 = local196.channel;
                }
                aStringArray37[anInt7139++] = local198;
                return;
            }
            if (arg0 == 5012) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.quickchatId;
                }
                anIntArray578[anInt7142++] = local109;
                return;
            }
            if (arg0 == 5015) {
                if (PlayerEntity.self == null || PlayerEntity.self.displayName == null) {
                    local95 = "";
                } else {
                    local95 = PlayerEntity.self.getDisplayName(false, true);
                }
                aStringArray37[anInt7139++] = local95;
                return;
            }
            if (arg0 == 5016) {
                anIntArray578[anInt7142++] = Static87.anInt1806;
                return;
            }
            if (arg0 == 5017) {
                anIntArray578[anInt7142++] = Static402.method5578();
                return;
            }
            if (arg0 == 5018) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local109 = 0;
                if (local196 != null) {
                    local109 = local196.flags;
                }
                anIntArray578[anInt7142++] = local109;
                return;
            }
            if (arg0 == 5019) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.accountName != null) {
                    local198 = local196.accountName;
                }
                aStringArray37[anInt7139++] = local198;
                return;
            }
            if (arg0 == 5020) {
                if (PlayerEntity.self == null || PlayerEntity.self.displayName == null) {
                    local95 = "";
                } else {
                    local95 = PlayerEntity.self.getAccountName();
                }
                aStringArray37[anInt7139++] = local95;
                return;
            }
            if (arg0 == 5023) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.uid;
                }
                anIntArray578[anInt7142++] = local109;
                return;
            }
            if (arg0 == 5024) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local109 = -1;
                if (local196 != null) {
                    local109 = local196.clock;
                }
                anIntArray578[anInt7142++] = local109;
                return;
            }
            if (arg0 == 5025) {
                local192 = anIntArray578[--anInt7142];
                local196 = ChatHistory.get(local192);
                local198 = "";
                if (local196 != null && local196.displayName != null) {
                    local198 = local196.displayName;
                }
                aStringArray37[anInt7139++] = local198;
                return;
            }
            if (arg0 == 5050) {
                local192 = anIntArray578[--anInt7142];
                aStringArray37[anInt7139++] = QuickChatCatTypeList.instance.method3234(local192).aString4;
                return;
            }
            @Pc(793) DoublyLinkedNode_Sub2_Sub3 local793;
            if (arg0 == 5051) {
                local192 = anIntArray578[--anInt7142];
                local793 = QuickChatCatTypeList.instance.method3234(local192);
                if (local793.anIntArray93 == null) {
                    anIntArray578[anInt7142++] = 0;
                    return;
                }
                anIntArray578[anInt7142++] = local793.anIntArray93.length;
                return;
            }
            if (arg0 == 5052) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                @Pc(839) DoublyLinkedNode_Sub2_Sub3 local839 = QuickChatCatTypeList.instance.method3234(local192);
                local115 = local839.anIntArray93[local834];
                anIntArray578[anInt7142++] = local115;
                return;
            }
            if (arg0 == 5053) {
                local192 = anIntArray578[--anInt7142];
                local793 = QuickChatCatTypeList.instance.method3234(local192);
                if (local793.anIntArray94 == null) {
                    anIntArray578[anInt7142++] = 0;
                    return;
                }
                anIntArray578[anInt7142++] = local793.anIntArray94.length;
                return;
            }
            if (arg0 == 5054) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                anIntArray578[anInt7142++] = QuickChatCatTypeList.instance.method3234(local192).anIntArray94[local834];
                return;
            }
            if (arg0 == 5055) {
                local192 = anIntArray578[--anInt7142];
                aStringArray37[anInt7139++] = QuickChatPhraseTypeList.instance.get(local192).method3906();
                return;
            }
            if (arg0 == 5056) {
                local192 = anIntArray578[--anInt7142];
                @Pc(966) DoublyLinkedNode_Sub2_Sub12 local966 = QuickChatPhraseTypeList.instance.get(local192);
                if (local966.anIntArray333 == null) {
                    anIntArray578[anInt7142++] = 0;
                    return;
                }
                anIntArray578[anInt7142++] = local966.anIntArray333.length;
                return;
            }
            if (arg0 == 5057) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                anIntArray578[anInt7142++] = QuickChatPhraseTypeList.instance.get(local192).anIntArray333[local834];
                return;
            }
            if (arg0 == 5058) {
                aClass21_1 = new Class21();
                aClass21_1.anInt521 = anIntArray578[--anInt7142];
                aClass21_1.aClass2_Sub2_Sub12_1 = QuickChatPhraseTypeList.instance.get(aClass21_1.anInt521);
                aClass21_1.anIntArray29 = new int[aClass21_1.aClass2_Sub2_Sub12_1.method3901()];
                return;
            }
            if (arg0 == 5059) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(Static456.A_CLIENT_PROT___85, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(0);
                local63.bitPacket.p2(aClass21_1.anInt521);
                aClass21_1.aClass2_Sub2_Sub12_1.method3904(local63.bitPacket, aClass21_1.anIntArray29);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
            if (arg0 == 5060) {
                local95 = aStringArray37[--anInt7139];
                local289 = ConnectionManager.active();
                local295 = ClientMessage.create(Static234.A_CLIENT_PROT___46, local289.cipher);
                local295.bitPacket.p1(0);
                local115 = local295.bitPacket.pos;
                local295.bitPacket.pjstr(local95);
                local295.bitPacket.p2(aClass21_1.anInt521);
                aClass21_1.aClass2_Sub2_Sub12_1.method3904(local295.bitPacket, aClass21_1.anIntArray29);
                local295.bitPacket.psize1(local295.bitPacket.pos - local115);
                local289.send(local295);
                return;
            }
            if (arg0 == 5061) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(Static456.A_CLIENT_PROT___85, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(1);
                local63.bitPacket.p2(aClass21_1.anInt521);
                aClass21_1.aClass2_Sub2_Sub12_1.method3904(local63.bitPacket, aClass21_1.anIntArray29);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
            if (arg0 == 5062) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                anIntArray578[anInt7142++] = QuickChatCatTypeList.instance.method3234(local192).aCharArray2[local834];
                return;
            }
            if (arg0 == 5063) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                anIntArray578[anInt7142++] = QuickChatCatTypeList.instance.method3234(local192).aCharArray3[local834];
                return;
            }
            if (arg0 == 5064) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                if (local834 == -1) {
                    anIntArray578[anInt7142++] = -1;
                    return;
                }
                anIntArray578[anInt7142++] = QuickChatCatTypeList.instance.method3234(local192).method1185((char) local834);
                return;
            }
            if (arg0 == 5065) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                if (local834 == -1) {
                    anIntArray578[anInt7142++] = -1;
                    return;
                }
                anIntArray578[anInt7142++] = QuickChatCatTypeList.instance.method3234(local192).method1184((char) local834);
                return;
            }
            if (arg0 == 5066) {
                local192 = anIntArray578[--anInt7142];
                anIntArray578[anInt7142++] = QuickChatPhraseTypeList.instance.get(local192).method3901();
                return;
            }
            if (arg0 == 5067) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                local109 = QuickChatPhraseTypeList.instance.get(local192).method3898(local834).id;
                anIntArray578[anInt7142++] = local109;
                return;
            }
            if (arg0 == 5068) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                aClass21_1.anIntArray29[local192] = local834;
                return;
            }
            if (arg0 == 5069) {
                anInt7142 -= 2;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                aClass21_1.anIntArray29[local192] = local834;
                return;
            }
            if (arg0 == 5070) {
                anInt7142 -= 3;
                local192 = anIntArray578[anInt7142];
                local834 = anIntArray578[anInt7142 + 1];
                local109 = anIntArray578[anInt7142 + 2];
                @Pc(1526) DoublyLinkedNode_Sub2_Sub12 local1526 = QuickChatPhraseTypeList.instance.get(local192);
                if (local1526.method3898(local834).id != 0) {
                    throw new RuntimeException("bad command");
                }
                anIntArray578[anInt7142++] = local1526.method3900(local834, local109);
                return;
            }
            if (arg0 == 5071) {
                local95 = aStringArray37[--anInt7139];
                local1578 = anIntArray578[--anInt7142] == 1;
                Static494.method6599(local95, local1578);
                anIntArray578[anInt7142++] = Static606.anInt8947;
                return;
            }
            if (arg0 == 5072) {
                if (Static256.aShortArray63 != null && Static143.anInt4054 < Static606.anInt8947) {
                    anIntArray578[anInt7142++] = Static256.aShortArray63[Static143.anInt4054++] & 0xFFFF;
                    return;
                }
                anIntArray578[anInt7142++] = -1;
                return;
            }
            if (arg0 == 5073) {
                Static143.anInt4054 = 0;
                return;
            }
            if (arg0 == 5074) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(Static456.A_CLIENT_PROT___85, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(2);
                local63.bitPacket.p2(aClass21_1.anInt521);
                aClass21_1.aClass2_Sub2_Sub12_1.method3904(local63.bitPacket, aClass21_1.anIntArray29);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
            if (arg0 == 5075) {
                local57 = ConnectionManager.active();
                local63 = ClientMessage.create(Static456.A_CLIENT_PROT___85, local57.cipher);
                local63.bitPacket.p1(0);
                local109 = local63.bitPacket.pos;
                local63.bitPacket.p1(3);
                local63.bitPacket.p2(aClass21_1.anInt521);
                aClass21_1.aClass2_Sub2_Sub12_1.method3904(local63.bitPacket, aClass21_1.anIntArray29);
                local63.bitPacket.psize1(local63.bitPacket.pos - local109);
                local57.send(local63);
                return;
            }
        } else if (arg0 < 5200) {
            if (arg0 == 5100) {
                if (KeyboardMonitor.instance.isPressed(86)) {
                    anIntArray578[anInt7142++] = 1;
                    return;
                }
                anIntArray578[anInt7142++] = 0;
                return;
            }
            if (arg0 == 5101) {
                if (KeyboardMonitor.instance.isPressed(82)) {
                    anIntArray578[anInt7142++] = 1;
                    return;
                }
                anIntArray578[anInt7142++] = 0;
                return;
            }
            if (arg0 == 5102) {
                if (KeyboardMonitor.instance.isPressed(81)) {
                    anIntArray578[anInt7142++] = 1;
                    return;
                }
                anIntArray578[anInt7142++] = 0;
                return;
            }
        } else {
            @Pc(2331) boolean local2331;
            if (arg0 < 5300) {
                if (arg0 == 5200) {
                    WorldMap.setZoomPercentage(anIntArray578[--anInt7142]);
                    return;
                }
                if (arg0 == 5201) {
                    anIntArray578[anInt7142++] = WorldMap.getZoom();
                    return;
                }
                if (arg0 == 5205) {
                    WorldMap.method1293(anIntArray578[--anInt7142], false, -1, -1, -11493);
                    return;
                }
                @Pc(1908) WorldMapArea local1908;
                if (arg0 == 5206) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.method5078(local192 >> 14 & 0x3FFF, local192 & 0x3FFF);
                    if (local1908 == null) {
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = local1908.id;
                    return;
                }
                @Pc(1942) WorldMapArea local1942;
                if (arg0 == 5207) {
                    local1942 = WorldMap.getArea(anIntArray578[--anInt7142]);
                    if (local1942 != null && local1942.aString49 != null) {
                        aStringArray37[anInt7139++] = local1942.aString49;
                        return;
                    }
                    aStringArray37[anInt7139++] = "";
                    return;
                }
                if (arg0 == 5208) {
                    anIntArray578[anInt7142++] = WorldMap.width;
                    anIntArray578[anInt7142++] = WorldMap.height;
                    return;
                }
                if (arg0 == 5209) {
                    anIntArray578[anInt7142++] = WorldMap.anInt2809 + WorldMap.areaX;
                    anIntArray578[anInt7142++] = WorldMap.anInt9389 + WorldMap.areaY;
                    return;
                }
                if (arg0 == 5210) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.getArea(local192);
                    if (local1908 == null) {
                        anIntArray578[anInt7142++] = 0;
                        anIntArray578[anInt7142++] = 0;
                        return;
                    }
                    anIntArray578[anInt7142++] = local1908.origin >> 14 & 0x3FFF;
                    anIntArray578[anInt7142++] = local1908.origin & 0x3FFF;
                    return;
                }
                if (arg0 == 5211) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.getArea(local192);
                    if (local1908 == null) {
                        anIntArray578[anInt7142++] = 0;
                        anIntArray578[anInt7142++] = 0;
                        return;
                    }
                    anIntArray578[anInt7142++] = local1908.maxX - local1908.minX;
                    anIntArray578[anInt7142++] = local1908.maxY - local1908.minY;
                    return;
                }
                @Pc(2139) MapElementListEntry local2139;
                if (arg0 == 5212) {
                    local2139 = Static122.method2207();
                    if (local2139 == null) {
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = local2139.id;
                    local834 = local2139.level << 28 | local2139.x + WorldMap.areaX << 14 | local2139.y + WorldMap.areaY;
                    anIntArray578[anInt7142++] = local834;
                    return;
                }
                if (arg0 == 5213) {
                    local2139 = Static364.method5248();
                    if (local2139 == null) {
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = local2139.id;
                    local834 = local2139.level << 28 | local2139.x + WorldMap.areaX << 14 | local2139.y + WorldMap.areaY;
                    anIntArray578[anInt7142++] = local834;
                    return;
                }
                @Pc(2289) boolean local2289;
                if (arg0 == 5214) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.getArea();
                    if (local1908 != null) {
                        local2289 = local1908.method4088(areaCoords, local192 & 0x3FFF, local192 >> 28 & 0x3, local192 >> 14 & 0x3FFF);
                        if (local2289) {
                            Static106.method2048(areaCoords[1], areaCoords[2]);
                        }
                    }
                    return;
                }
                if (arg0 == 5215) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local834 = anIntArray578[anInt7142 + 1];
                    @Pc(2329) Queue local2329 = WorldMap.method5076(local192 >> 14 & 0x3FFF, local192 & 0x3FFF);
                    local2331 = false;
                    for (@Pc(2336) WorldMapArea local2336 = (WorldMapArea) local2329.first(); local2336 != null; local2336 = (WorldMapArea) local2329.next()) {
                        if (local2336.id == local834) {
                            local2331 = true;
                            break;
                        }
                    }
                    if (local2331) {
                        anIntArray578[anInt7142++] = 1;
                        return;
                    }
                    anIntArray578[anInt7142++] = 0;
                    return;
                }
                if (arg0 == 5218) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.getArea(local192);
                    if (local1908 == null) {
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = local1908.zoom;
                    return;
                }
                if (arg0 == 5220) {
                    anIntArray578[anInt7142++] = WorldMap.loadingPercent == 100 ? 1 : 0;
                    return;
                }
                if (arg0 == 5221) {
                    local192 = anIntArray578[--anInt7142];
                    Static106.method2048(local192 >> 14 & 0x3FFF, local192 & 0x3FFF);
                    return;
                }
                if (arg0 == 5222) {
                    local1942 = WorldMap.getArea();
                    if (local1942 != null) {
                        local1578 = local1942.method4091(WorldMap.anInt9389 + WorldMap.areaY, WorldMap.anInt2809 + WorldMap.areaX, areaCoords);
                        if (local1578) {
                            anIntArray578[anInt7142++] = areaCoords[1];
                            anIntArray578[anInt7142++] = areaCoords[2];
                            return;
                        }
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = -1;
                    anIntArray578[anInt7142++] = -1;
                    return;
                }
                if (arg0 == 5223) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local834 = anIntArray578[anInt7142 + 1];
                    WorldMap.method1293(local192, false, local834 & 0x3FFF, local834 >> 14 & 0x3FFF, -11493);
                    return;
                }
                if (arg0 == 5224) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.getArea();
                    if (local1908 != null) {
                        local2289 = local1908.method4088(areaCoords, local192 & 0x3FFF, local192 >> 28 & 0x3, local192 >> 14 & 0x3FFF);
                        if (local2289) {
                            anIntArray578[anInt7142++] = areaCoords[1];
                            anIntArray578[anInt7142++] = areaCoords[2];
                            return;
                        }
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = -1;
                    anIntArray578[anInt7142++] = -1;
                    return;
                }
                if (arg0 == 5225) {
                    local192 = anIntArray578[--anInt7142];
                    local1908 = WorldMap.getArea();
                    if (local1908 != null) {
                        local2289 = local1908.method4091(local192 & 0x3FFF, local192 >> 14 & 0x3FFF, areaCoords);
                        if (local2289) {
                            anIntArray578[anInt7142++] = areaCoords[1];
                            anIntArray578[anInt7142++] = areaCoords[2];
                            return;
                        }
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = -1;
                    anIntArray578[anInt7142++] = -1;
                    return;
                }
                if (arg0 == 5226) {
                    Static688.method8975(anIntArray578[--anInt7142]);
                    return;
                }
                if (arg0 == 5227) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local834 = anIntArray578[anInt7142 + 1];
                    WorldMap.method1293(local192, true, local834 & 0x3FFF, local834 >> 14 & 0x3FFF, -11493);
                    return;
                }
                if (arg0 == 5228) {
                    Static178.aBoolean251 = anIntArray578[--anInt7142] == 1;
                    return;
                }
                if (arg0 == 5229) {
                    anIntArray578[anInt7142++] = Static178.aBoolean251 ? 1 : 0;
                    return;
                }
                if (arg0 == 5230) {
                    local192 = anIntArray578[--anInt7142];
                    Static170.method2653(local192);
                    return;
                }
                @Pc(2867) Node local2867;
                if (arg0 == 5231) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local1578 = anIntArray578[anInt7142 + 1] == 1;
                    if (Static232.A_HASH_TABLE___18 != null) {
                        local2867 = Static232.A_HASH_TABLE___18.get(local192);
                        if (local2867 != null && !local1578) {
                            local2867.unlink();
                            return;
                        }
                        if (local2867 == null && local1578) {
                            local2867 = new Node();
                            Static232.A_HASH_TABLE___18.put(local192, local2867);
                        }
                    }
                    return;
                }
                @Pc(2914) Node local2914;
                if (arg0 == 5232) {
                    local192 = anIntArray578[--anInt7142];
                    if (Static232.A_HASH_TABLE___18 != null) {
                        local2914 = Static232.A_HASH_TABLE___18.get(local192);
                        anIntArray578[anInt7142++] = local2914 == null ? 0 : 1;
                        return;
                    }
                    anIntArray578[anInt7142++] = 0;
                    return;
                }
                if (arg0 == 5233) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local1578 = anIntArray578[anInt7142 + 1] == 1;
                    if (Static268.A_HASH_TABLE___22 != null) {
                        local2867 = Static268.A_HASH_TABLE___22.get(local192);
                        if (local2867 != null && !local1578) {
                            local2867.unlink();
                            return;
                        }
                        if (local2867 == null && local1578) {
                            local2867 = new Node();
                            Static268.A_HASH_TABLE___22.put(local192, local2867);
                        }
                    }
                    return;
                }
                if (arg0 == 5234) {
                    local192 = anIntArray578[--anInt7142];
                    if (Static268.A_HASH_TABLE___22 != null) {
                        local2914 = Static268.A_HASH_TABLE___22.get(local192);
                        anIntArray578[anInt7142++] = local2914 == null ? 0 : 1;
                        return;
                    }
                    anIntArray578[anInt7142++] = 0;
                    return;
                }
                if (arg0 == 5235) {
                    anIntArray578[anInt7142++] = WorldMap.area == null ? -1 : WorldMap.area.id;
                    return;
                }
                if (arg0 == 5236) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local834 = anIntArray578[anInt7142 + 1];
                    local109 = local834 >> 14 & 0x3FFF;
                    local115 = local834 & 0x3FFF;
                    local375 = Static687.method8957(local192, local115, local109);
                    if (local375 < 0) {
                        anIntArray578[anInt7142++] = -1;
                        return;
                    }
                    anIntArray578[anInt7142++] = local375;
                    return;
                }
                if (arg0 == 5237) {
                    Static322.method9441();
                    return;
                }
            } else if (arg0 < 5400) {
                if (arg0 == 5300) {
                    anInt7142 -= 2;
                    local192 = anIntArray578[anInt7142];
                    local834 = anIntArray578[anInt7142 + 1];
                    InterfaceManager.changeWindowMode(3, local192, false, local834);
                    anIntArray578[anInt7142++] = GameShell.fsframe == null ? 0 : 1;
                    return;
                }
                if (arg0 == 5301) {
                    if (GameShell.fsframe != null) {
                        InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                    }
                    return;
                }
                if (arg0 == 5302) {
                    @Pc(3186) DisplayProperties[] local3186 = Static587.method7710();
                    anIntArray578[anInt7142++] = local3186.length;
                    return;
                }
                if (arg0 == 5303) {
                    local192 = anIntArray578[--anInt7142];
                    @Pc(3210) DisplayProperties[] local3210 = Static587.method7710();
                    anIntArray578[anInt7142++] = local3210[local192].width;
                    anIntArray578[anInt7142++] = local3210[local192].height;
                    return;
                }
                if (arg0 == 5305) {
                    local192 = Static328.fullscreenWidth;
                    local834 = Static110.fullscreenHeight;
                    local109 = -1;
                    @Pc(3245) DisplayProperties[] local3245 = Static587.method7710();
                    for (local375 = 0; local375 < local3245.length; local375++) {
                        @Pc(3252) DisplayProperties local3252 = local3245[local375];
                        if (local3252.width == local192 && local3252.height == local834) {
                            local109 = local375;
                            break;
                        }
                    }
                    anIntArray578[anInt7142++] = local109;
                    return;
                }
                if (arg0 == 5306) {
                    anIntArray578[anInt7142++] = InterfaceManager.getWindowMode();
                    return;
                }
                if (arg0 == 5307) {
                    local192 = anIntArray578[--anInt7142];
                    if (local192 >= 1 && local192 <= 2) {
                        InterfaceManager.changeWindowMode(local192, -1, false, -1);
                        return;
                    }
                    return;
                }
                if (arg0 == 5308) {
                    anIntArray578[anInt7142++] = ClientOptions.instance.screenSizeDefault.getValue();
                    return;
                }
                if (arg0 == 5309) {
                    local192 = anIntArray578[--anInt7142];
                    if (local192 >= 1 && local192 <= 2) {
                        ClientOptions.instance.update(local192, ClientOptions.instance.screenSizeDefault);
                        ClientOptions.instance.update(local192, ClientOptions.instance.screenSize);
                        ClientOptions.save();
                        return;
                    }
                    return;
                }
            } else {
                @Pc(3561) int local3561;
                if (arg0 < 5500) {
                    if (arg0 == 5400) {
                        anInt7139 -= 2;
                        local95 = aStringArray37[anInt7139];
                        local101 = aStringArray37[anInt7139 + 1];
                        local109 = anIntArray578[--anInt7142];
                        @Pc(3411) ServerConnection local3411 = ConnectionManager.active();
                        @Pc(3417) ClientMessage local3417 = ClientMessage.create(Static563.A_CLIENT_PROT___102, local3411.cipher);
                        local3417.bitPacket.p1(Static231.method3379(local95) + Static231.method3379(local101) + 1);
                        local3417.bitPacket.pjstr(local95);
                        local3417.bitPacket.pjstr(local101);
                        local3417.bitPacket.p1(local109);
                        local3411.send(local3417);
                        return;
                    }
                    if (arg0 == 5401) {
                        anInt7142 -= 2;
                        client.clientpalette[anIntArray578[anInt7142]] = (short) ColourUtils.rgbToHsl(anIntArray578[anInt7142 + 1]);
                        ObjTypeList.instance.modelCacheReset();
                        ObjTypeList.instance.spriteCacheReset();
                        NPCTypeList.instance.modelCacheReset();
                        InterfaceManager.redrawAll();
                        return;
                    }
                    if (arg0 == 5405) {
                        anInt7142 -= 2;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1];
                        if (local192 >= 0 && local192 < 2) {
                            Camera.spline[local192] = new int[local834 << 1][4];
                        }
                        return;
                    }
                    if (arg0 == 5406) {
                        anInt7142 -= 7;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1] << 1;
                        local109 = anIntArray578[anInt7142 + 2];
                        local115 = anIntArray578[anInt7142 + 3];
                        local375 = anIntArray578[anInt7142 + 4];
                        local3561 = anIntArray578[anInt7142 + 5];
                        @Pc(3567) int local3567 = anIntArray578[anInt7142 + 6];
                        if (local192 >= 0 && local192 < 2 && Camera.spline[local192] != null && local834 >= 0 && local834 < Camera.spline[local192].length) {
                            Camera.spline[local192][local834] = new int[]{(local109 >> 14 & 0x3FFF) << 9, local115 << 2, (local109 & 0x3FFF) << 9, local3567};
                            Camera.spline[local192][local834 + 1] = new int[]{(local375 >> 14 & 0x3FFF) << 9, local3561 << 2, (local375 & 0x3FFF) << 9};
                        }
                        return;
                    }
                    if (arg0 == 5407) {
                        local192 = Camera.spline[anIntArray578[--anInt7142]].length >> 1;
                        anIntArray578[anInt7142++] = local192;
                        return;
                    }
                    if (arg0 == 5411) {
                        if (GameShell.fsframe != null) {
                            InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                        }
                        if (GameShell.frame != null) {
                            Static266.saveVarcs();
                            System.exit(0);
                            return;
                        }
                        local95 = client.quitUrl == null ? Static659.method8605() : client.quitUrl;
                        Static664.method8655(ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, local95, false, SignLink.instance);
                        return;
                    }
                    if (arg0 == 5419) {
                        local95 = "";
                        if (Static439.aSignedResource_4 != null) {
                            if (Static439.aSignedResource_4.result == null) {
                                local95 = Static419.method5756(Static439.aSignedResource_4.intData1);
                            } else {
                                local95 = (String) Static439.aSignedResource_4.result;
                            }
                        }
                        aStringArray37[anInt7139++] = local95;
                        return;
                    }
                    if (arg0 == 5420) {
                        anIntArray578[anInt7142++] = SignLink.instance.signed ? 0 : 1;
                        return;
                    }
                    if (arg0 == 5421) {
                        if (GameShell.fsframe != null) {
                            InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                        }
                        local95 = aStringArray37[--anInt7139];
                        local1578 = anIntArray578[--anInt7142] == 1;
                        local198 = Static659.method8605() + local95;
                        Static664.method8655(ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, local198, local1578, SignLink.instance);
                        return;
                    }
                    if (arg0 == 5422) {
                        anInt7139 -= 2;
                        local95 = aStringArray37[anInt7139];
                        local101 = aStringArray37[anInt7139 + 1];
                        local109 = anIntArray578[--anInt7142];
                        if (local95.length() > 0) {
                            if (Static685.prefixTitles == null) {
                                Static685.prefixTitles = new String[Static390.anIntArray476[client.modeGame.id]];
                            }
                            Static685.prefixTitles[local109] = local95;
                        }
                        if (local101.length() > 0) {
                            if (Static377.suffixTitles == null) {
                                Static377.suffixTitles = new String[Static390.anIntArray476[client.modeGame.id]];
                            }
                            Static377.suffixTitles[local109] = local101;
                        }
                        return;
                    }
                    if (arg0 == 5423) {
                        System.out.println(aStringArray37[--anInt7139]);
                        return;
                    }
                    if (arg0 == 5424) {
                        anInt7142 -= 11;
                        Static719.anInt10504 = anIntArray578[anInt7142];
                        Static514.anInt7677 = anIntArray578[anInt7142 + 1];
                        Static183.anInt3022 = anIntArray578[anInt7142 + 2];
                        Static405.anInt6255 = anIntArray578[anInt7142 + 3];
                        Static63.anInt1474 = anIntArray578[anInt7142 + 4];
                        Static282.anInt4417 = anIntArray578[anInt7142 + 5];
                        Static337.anInt5561 = anIntArray578[anInt7142 + 6];
                        Static176.anInt7532 = anIntArray578[anInt7142 + 7];
                        Static282.anInt4419 = anIntArray578[anInt7142 + 8];
                        Static563.anInt8455 = anIntArray578[anInt7142 + 9];
                        Static634.anInt9510 = anIntArray578[anInt7142 + 10];
                        js5.SPRITES.fileready(Static63.anInt1474);
                        js5.SPRITES.fileready(Static282.anInt4417);
                        js5.SPRITES.fileready(Static337.anInt5561);
                        js5.SPRITES.fileready(Static176.anInt7532);
                        js5.SPRITES.fileready(Static282.anInt4419);
                        Static26.aSprite_5 = null;
                        Static561.aSprite_34 = null;
                        Static261.aSprite_18 = null;
                        Static608.aSprite_41 = null;
                        Static1.aSprite_42 = null;
                        Static459.aSprite_31 = null;
                        Static542.aSprite_33 = null;
                        Static63.aSprite_8 = null;
                        Static60.aBoolean87 = true;
                        return;
                    }
                    if (arg0 == 5425) {
                        Static329.method1649();
                        Static60.aBoolean87 = false;
                        return;
                    }
                    if (arg0 == 5426) {
                        anInt7142 -= 2;
                        Cursor.dflt = anIntArray578[anInt7142];
                        Cursor.interaction = anIntArray578[anInt7142 + 1];
                        return;
                    }
                    if (arg0 == 5427) {
                        anInt7142 -= 2;
                        return;
                    }
                    if (arg0 == 5428) {
                        anInt7142 -= 2;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1];
                        anIntArray578[anInt7142++] = Static251.method3549(local192, local834) ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5429) {
                        debugconsole.executeComand(false, false, aStringArray37[--anInt7139]);
                        return;
                    }
                    if (arg0 == 5430) {
                        try {
                            JavaScript.call("accountcreated", GameShell.loaderApplet);
                            return;
                        } catch (@Pc(4148) Throwable local4148) {
                            return;
                        }
                    }
                    if (arg0 == 5431) {
                        try {
                            JavaScript.call("accountcreatestarted", GameShell.loaderApplet);
                            return;
                        } catch (@Pc(4161) Throwable local4161) {
                            return;
                        }
                    }
                    if (arg0 == 5432) {
                        local95 = "";
                        if (Static175.aClipboard1 != null) {
                            @Pc(4173) Transferable local4173 = Static175.aClipboard1.getContents(null);
                            if (local4173 != null) {
                                try {
                                    local95 = (String) local4173.getTransferData(DataFlavor.stringFlavor);
                                    if (local95 == null) {
                                        local95 = "";
                                    }
                                } catch (@Pc(4186) Exception local4186) {
                                }
                            }
                        }
                        aStringArray37[anInt7139++] = local95;
                        return;
                    }
                    if (arg0 == 5433) {
                        Static143.anInt4059 = anIntArray578[--anInt7142];
                        return;
                    }
                    if (arg0 == 5435) {
                        anIntArray578[anInt7142++] = client.js ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5436) {
                        if (SystemInfo.instance.javaRelease < 6) {
                            anIntArray578[anInt7142++] = 0;
                            return;
                        }
                        if (SystemInfo.instance.javaRelease == 6 && SystemInfo.instance.javaUpdate < 10) {
                            anIntArray578[anInt7142++] = 0;
                            return;
                        }
                        anIntArray578[anInt7142++] = 1;
                        return;
                    }
                } else if (arg0 < 5600) {
                    if (arg0 == 5500) {
                        anInt7142 -= 4;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1];
                        local109 = anIntArray578[anInt7142 + 2];
                        local115 = anIntArray578[anInt7142 + 3];
                        Camera.moveTo((local192 >> 14 & 0x3FFF) - WorldMap.areaBaseX, false, local109, local834 << 2, (local192 & 0x3FFF) - WorldMap.areaBaseZ, local115);
                        return;
                    }
                    if (arg0 == 5501) {
                        anInt7142 -= 4;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1];
                        local109 = anIntArray578[anInt7142 + 2];
                        local115 = anIntArray578[anInt7142 + 3];
                        Static638.method8397(local109, (local192 & 0x3FFF) - WorldMap.areaBaseZ, (local192 >> 14 & 0x3FFF) - WorldMap.areaBaseX, local834 << 2, local115);
                        return;
                    }
                    if (arg0 == 5502) {
                        anInt7142 -= 6;
                        local192 = anIntArray578[anInt7142];
                        if (local192 >= 2) {
                            throw new RuntimeException();
                        }
                        Camera.posSpline = local192;
                        local834 = anIntArray578[anInt7142 + 1];
                        if (local834 + 1 >= Camera.spline[Camera.posSpline].length >> 1) {
                            throw new RuntimeException();
                        }
                        Camera.splinePosOffset = local834;
                        Camera.splineRate = 0;
                        Camera.splineStart = anIntArray578[anInt7142 + 2];
                        Camera.splineEnd = anIntArray578[anInt7142 + 3];
                        local109 = anIntArray578[anInt7142 + 4];
                        if (local109 >= 2) {
                            throw new RuntimeException();
                        }
                        Camera.lookSpline = local109;
                        local115 = anIntArray578[anInt7142 + 5];
                        if (local115 + 1 >= Camera.spline[Camera.lookSpline].length >> 1) {
                            throw new RuntimeException();
                        }
                        Camera.splineLookOffset = local115;
                        Camera.mode = CameraMode.MODE_SPLINE;
                        Camera.anInt10383 = -1;
                        Camera.anInt10376 = -1;
                        return;
                    }
                    if (arg0 == 5503) {
                        Camera.reset();
                        return;
                    }
                    if (arg0 == 5504) {
                        anInt7142 -= 2;
                        Camera.method6408(anIntArray578[anInt7142 + 1], anIntArray578[anInt7142]);
                        return;
                    }
                    if (arg0 == 5505) {
                        anIntArray578[anInt7142++] = (int) Static479.aFloat123 >> 3;
                        return;
                    }
                    if (arg0 == 5506) {
                        anIntArray578[anInt7142++] = (int) Camera.playerCameraYaw >> 3;
                        return;
                    }
                    if (arg0 == 5507) {
                        Static599.method7835();
                        return;
                    }
                    if (arg0 == 5508) {
                        Static494.method6596();
                        return;
                    }
                    if (arg0 == 5509) {
                        Static254.method3606();
                        return;
                    }
                    if (arg0 == 5510) {
                        Static470.method6386();
                        return;
                    }
                    if (arg0 == 5511) {
                        local192 = anIntArray578[--anInt7142];
                        local834 = local192 >> 14 & 0x3FFF;
                        local109 = local192 & 0x3FFF;
                        local834 -= WorldMap.areaBaseX;
                        if (local834 < 0) {
                            local834 = 0;
                        } else if (local834 >= Static720.mapWidth) {
                            local834 = Static720.mapWidth;
                        }
                        local109 -= WorldMap.areaBaseZ;
                        if (local109 < 0) {
                            local109 = 0;
                        } else if (local109 >= Static501.mapLength) {
                            local109 = Static501.mapLength;
                        }
                        Camera.anInt6262 = (local834 << 9) + 256;
                        Camera.anInt4018 = (local109 << 9) + 256;
                        Camera.mode = CameraMode.MODE_FOUR;
                        Camera.anInt10383 = -1;
                        Camera.anInt10376 = -1;
                        return;
                    }
                    if (arg0 == 5512) {
                        Camera.smoothReset();
                        return;
                    }
                    if (arg0 == 5514) {
                        Static582.orthoZoom = anIntArray578[--anInt7142];
                        return;
                    }
                    if (arg0 == 5516) {
                        anIntArray578[anInt7142++] = Static582.orthoZoom;
                        return;
                    }
                    if (arg0 == 5517) {
                        local192 = anIntArray578[--anInt7142];
                        if (local192 == -1) {
                            local834 = local192 >> 14 & 0x3FFF;
                            local109 = local192 & 0x3FFF;
                            local834 -= WorldMap.areaBaseX;
                            if (local834 < 0) {
                                local834 = 0;
                            } else if (local834 >= Static720.mapWidth) {
                                local834 = Static720.mapWidth;
                            }
                            local109 -= WorldMap.areaBaseZ;
                            if (local109 < 0) {
                                local109 = 0;
                            } else if (local109 >= Static501.mapLength) {
                                local109 = Static501.mapLength;
                            }
                            Camera.anInt10376 = (local834 << 9) + 256;
                            Camera.anInt10383 = (local109 << 9) + 256;
                            return;
                        }
                        Camera.anInt10376 = -1;
                        Camera.anInt10383 = -1;
                        return;
                    }
                    if (arg0 == 5547) {
                        anIntArray578[anInt7142++] = Camera.mode == CameraMode.MODE_DEFAULT ? 1 : 0;
                        return;
                    }
                } else if (arg0 < 5700) {
                    if (arg0 == 5600) {
                        anInt7139 -= 2;
                        local95 = aStringArray37[anInt7139];
                        local101 = aStringArray37[anInt7139 + 1];
                        local109 = anIntArray578[--anInt7142];
                        Login.requestLoginWithUsername(local109, local101, local95);
                        return;
                    }
                    if (arg0 == 5601) {
                        Static66.method1488();
                        return;
                    }
                    if (arg0 == 5602) {
                        if (!Static242.method3500()) {
                            Static707.method9227();
                        }
                        return;
                    }
                    if (arg0 == 5604) {
                        anInt7139--;
                        if (MainLogicManager.step != 3) {
                            return;
                        }
                        if (!Static242.method3500() && Static6.anInt95 == 0) {
                            Static104.method2029(aStringArray37[anInt7139]);
                            return;
                        }
                        return;
                    }
                    if (arg0 == 5605) {
                        anInt7139 -= 2;
                        anInt7142 -= 2;
                        if (MainLogicManager.step != 3) {
                            return;
                        }
                        if (!Static242.method3500() && Static6.anInt95 == 0) {
                            Static81.method1591(aStringArray37[anInt7139], anIntArray578[anInt7142], aStringArray37[anInt7139 + 1], anIntArray578[anInt7142 + 1] == 1);
                            return;
                        }
                        return;
                    }
                    if (arg0 == 5606) {
                        if (Static6.anInt95 == 0) {
                            Static580.anInt8621 = -2;
                        }
                        return;
                    }
                    if (arg0 == 5607) {
                        anIntArray578[anInt7142++] = Static169.anInt2855;
                        return;
                    }
                    if (arg0 == 5608) {
                        anIntArray578[anInt7142++] = Static118.anInt2292;
                        return;
                    }
                    if (arg0 == 5609) {
                        anIntArray578[anInt7142++] = Static580.anInt8621;
                        return;
                    }
                    if (arg0 == 5611) {
                        anIntArray578[anInt7142++] = Static329.anInt1749;
                        return;
                    }
                    if (arg0 == 5612) {
                        local192 = anIntArray578[--anInt7142];
                        Static674.method8789(local192);
                        return;
                    }
                    if (arg0 == 5613) {
                        anIntArray578[anInt7142++] = Static169.anInt2855;
                        return;
                    }
                    if (arg0 == 5615) {
                        anInt7139 -= 2;
                        local95 = aStringArray37[anInt7139];
                        local101 = aStringArray37[anInt7139 + 1];
                        Static218.method3188(local101, local95);
                        return;
                    }
                    if (arg0 == 5616) {
                        Login.logout(false);
                        return;
                    }
                    if (arg0 == 5617) {
                        anIntArray578[anInt7142++] = Static284.anInt4583;
                        return;
                    }
                    if (arg0 == 5618) {
                        anInt7142--;
                        return;
                    }
                    if (arg0 == 5619) {
                        anInt7142--;
                        return;
                    }
                    if (arg0 == 5620) {
                        anIntArray578[anInt7142++] = 0;
                        return;
                    }
                    if (arg0 == 5621) {
                        anInt7139 -= 2;
                        anInt7142 -= 2;
                        return;
                    }
                    if (arg0 == 5622) {
                        return;
                    }
                    if (arg0 == 5623) {
                        if (client.ssKey != null) {
                            anIntArray578[anInt7142++] = 1;
                            return;
                        }
                        anIntArray578[anInt7142++] = 0;
                        return;
                    }
                    if (arg0 == 5624) {
                        anIntArray578[anInt7142++] = (int) (client.userFlow >> 32);
                        anIntArray578[anInt7142++] = (int) (client.userFlow & 0xFFFFFFFFFFFFFFFFL);
                        return;
                    }
                    if (arg0 == 5625) {
                        anIntArray578[anInt7142++] = client.under13 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5626) {
                        client.under13 = true;
                        Static358.method9190();
                        return;
                    }
                    if (arg0 == 5627) {
                        anIntArray578[anInt7142++] = Static78.anInt1626;
                        anIntArray578[anInt7142++] = Static383.anInt6001;
                        anIntArray578[anInt7142++] = Static673.anInt10079;
                        Static78.anInt1626 = -2;
                        Static383.anInt6001 = -1;
                        Static673.anInt10079 = -1;
                        return;
                    }
                    if (arg0 == 5628) {
                        anIntArray578[anInt7142++] = Static242.method3500() ? 1 : 0;
                        return;
                    }
                    if (arg0 == 5629) {
                        anIntArray578[anInt7142++] = Static660.anInt9837;
                        return;
                    }
                    if (arg0 == 5630) {
                        Static56.method1220();
                        return;
                    }
                    if (arg0 == 5631) {
                        anInt7142 -= 2;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1];
                        Login.requestLoginFromSocialNetwork(local192, local834);
                        return;
                    }
                    if (arg0 == 5632) {
                        local192 = anIntArray578[--anInt7142];
                        Static303.method4428(local192);
                        return;
                    }
                    if (arg0 == 5633) {
                        anIntArray578[anInt7142++] = Static356.anInt5780;
                        return;
                    }
                } else if (arg0 < 6100) {
                    if (arg0 == 6001) {
                        local192 = anIntArray578[--anInt7142];
                        ClientOptions.instance.update(local192, ClientOptions.instance.brightness);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    @Pc(5337) boolean local5337;
                    if (arg0 == 6002) {
                        local5337 = anIntArray578[--anInt7142] == 1;
                        ClientOptions.instance.update(local5337 ? 1 : 0, ClientOptions.instance.animateBackgroundDefault);
                        ClientOptions.instance.update(local5337 ? 1 : 0, ClientOptions.instance.animateBackground);
                        MainLogicManager.mapBuild();
                        Static77.method1561();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6003) {
                        local5337 = anIntArray578[--anInt7142] == 1;
                        ClientOptions.instance.update(local5337 ? 2 : 1, ClientOptions.instance.removeRoofs);
                        ClientOptions.instance.update(local5337 ? 2 : 1, ClientOptions.instance.removeRoofsOverride);
                        Static77.method1561();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6005) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.groundDecor);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6007) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.idleAnimations);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6008) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.flickeringEffects);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6010) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.spotShadows);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6011) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.hardShadows);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6012) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.lightDetail);
                        Static296.updateFeatureMask();
                        InterfaceManager.loginOpened();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6014) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 2 : 0, ClientOptions.instance.waterDetail);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6015) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.fog);
                        MainLogicManager.mapBuild();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6016) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.antialiasingQuality);
                        Static32.setToolkit(ClientOptions.instance.toolkit.getValue(), false);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6017) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.stereoSound);
                        Static150.method2455();
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6018) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.soundVolume);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6019) {
                        local192 = anIntArray578[--anInt7142];
                        local834 = ClientOptions.instance.musicVolume.getValue();
                        if (local192 != local834) {
                            if (MainLogicManager.isAtGameScreen(MainLogicManager.step)) {
                                if (local834 == 0 && Static588.anInt8692 != -1) {
                                    Static611.method8229(Static588.anInt8692, local192, js5.MIDI_SONGS);
                                    Static550.method7266();
                                    Static501.aBoolean575 = false;
                                } else if (local192 == 0) {
                                    Static100.method1988();
                                    Static501.aBoolean575 = false;
                                } else {
                                    Static126.method2226(local192);
                                }
                            }
                            ClientOptions.instance.update(local192, ClientOptions.instance.musicVolume);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                    if (arg0 == 6020) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.backgroundSoundVolume);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6021) {
                        local192 = ClientOptions.instance.removeRoofs.getValue();
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 0 : local192, ClientOptions.instance.removeRoofsOverride);
                        Static77.method1561();
                        return;
                    }
                    if (arg0 == 6023) {
                        local192 = anIntArray578[--anInt7142];
                        ClientOptions.instance.update(local192, ClientOptions.instance.particles);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6024) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.antialiasingMode);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6025) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.buildArea);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6027) {
                        local192 = anIntArray578[--anInt7142];
                        if (local192 < 0 || local192 > 1) {
                            local192 = 0;
                        }
                        Static249.method3537(local192 == 1);
                        return;
                    }
                    if (arg0 == 6028) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 0 ? 0 : 1, ClientOptions.instance.customCursors);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6029) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.idleAnimations);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6030) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 0 ? 0 : 1, ClientOptions.instance.groundBlending);
                        ClientOptions.save();
                        MainLogicManager.mapBuild();
                        return;
                    }
                    if (arg0 == 6031) {
                        local192 = anIntArray578[--anInt7142];
                        if (local192 < 0 || local192 > 5) {
                            local192 = 2;
                        }
                        Static32.setToolkit(local192, false);
                        return;
                    }
                    if (arg0 == 6032) {
                        anInt7142 -= 2;
                        local192 = anIntArray578[anInt7142];
                        local1578 = anIntArray578[anInt7142 + 1] == 1;
                        ClientOptions.instance.update(local192, ClientOptions.instance.toolkitDefault);
                        if (!local1578) {
                            ClientOptions.instance.update(0, ClientOptions.instance.graphicsQuality);
                        }
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6033) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.cpuUsage);
                        ClientOptions.save();
                        return;
                    }
                    if (arg0 == 6034) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : 0, ClientOptions.instance.textures);
                        ClientOptions.save();
                        Static296.updateFeatureMask();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6035) {
                        local192 = ClientOptions.instance.animateBackgroundDefault.getValue();
                        ClientOptions.instance.update(anIntArray578[--anInt7142] == 1 ? 1 : local192, ClientOptions.instance.animateBackground);
                        MainLogicManager.mapBuild();
                        Static77.method1561();
                        return;
                    }
                    if (arg0 == 6036) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.maxScreenSize);
                        ClientOptions.save();
                        Static284.aBoolean355 = true;
                        return;
                    }
                    if (arg0 == 6037) {
                        ClientOptions.instance.update(anIntArray578[--anInt7142], ClientOptions.instance.speechVolume);
                        ClientOptions.save();
                        Static503.sentPreferences = false;
                        return;
                    }
                    if (arg0 == 6038) {
                        local192 = anIntArray578[--anInt7142];
                        local834 = ClientOptions.instance.loginVolume.getValue();
                        if (local192 != local834 && Static588.anInt8692 == Static597.anInt8821) {
                            if (!MainLogicManager.isAtGameScreen(MainLogicManager.step)) {
                                if (local834 == 0) {
                                    Static611.method8229(Static588.anInt8692, local192, js5.MIDI_SONGS);
                                    Static550.method7266();
                                    Static501.aBoolean575 = false;
                                } else if (local192 == 0) {
                                    Static100.method1988();
                                    Static501.aBoolean575 = false;
                                } else {
                                    Static126.method2226(local192);
                                }
                            }
                            ClientOptions.instance.update(local192, ClientOptions.instance.loginVolume);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                    if (arg0 == 6039) {
                        local192 = anIntArray578[--anInt7142];
                        if (local192 > 255 || local192 < 0) {
                            local192 = 0;
                        }
                        if (local192 != ClientOptions.instance.loadingSequence.getValue()) {
                            ClientOptions.instance.update(local192, ClientOptions.instance.loadingSequence);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                    if (arg0 == 6040) {
                        local192 = anIntArray578[--anInt7142];
                        if (local192 != ClientOptions.instance.orthographic.getValue()) {
                            ClientOptions.instance.update(local192, ClientOptions.instance.orthographic);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            Static498.method6646();
                        }
                        return;
                    }
                    if (arg0 == 6041) {
                        local192 = anIntArray578[--anInt7142];
                        if (local192 != ClientOptions.instance.skydetail.getValue()) {
                            ClientOptions.instance.update(local192, ClientOptions.instance.skydetail);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                        }
                        return;
                    }
                } else if (arg0 < 6200) {
                    if (arg0 == 6101) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.brightness.getValue();
                        return;
                    }
                    if (arg0 == 6102) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.animateBackgroundDefault.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6103) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.removeRoofs.getValue() == 2 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6105) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.groundDecor.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6107) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.idleAnimations.getValue();
                        return;
                    }
                    if (arg0 == 6108) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.flickeringEffects.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6110) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.spotShadows.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6111) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.hardShadows.getValue();
                        return;
                    }
                    if (arg0 == 6112) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.lightDetail.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6114) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.waterDetail.getValue() == 2 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6115) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.fog.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6116) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.antialiasingQuality.getValue();
                        return;
                    }
                    if (arg0 == 6117) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.stereoSound.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6118) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.soundVolume.getValue();
                        return;
                    }
                    if (arg0 == 6119) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.musicVolume.getValue();
                        return;
                    }
                    if (arg0 == 6120) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.backgroundSoundVolume.getValue();
                        return;
                    }
                    if (arg0 == 6123) {
                        anIntArray578[anInt7142++] = Static436.method3416();
                        return;
                    }
                    if (arg0 == 6124) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.antialiasingMode.getValue();
                        return;
                    }
                    if (arg0 == 6125) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.buildArea.getValue();
                        return;
                    }
                    if (arg0 == 6127) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.bloom.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6128) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.customCursors.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6129) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.idleAnimations.getValue();
                        return;
                    }
                    if (arg0 == 6130) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.groundBlending.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6131) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.toolkit.getValue();
                        return;
                    }
                    if (arg0 == 6132) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.toolkitDefault.getValue();
                        return;
                    }
                    if (arg0 == 6133) {
                        anIntArray578[anInt7142++] = SignLink.instance.signed && !SignLink.instance.microsoftjava ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6135) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.cpuUsage.value();
                        return;
                    }
                    if (arg0 == 6136) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.textures.getValue() == 1 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6138) {
                        anIntArray578[anInt7142++] = Static363.method6235(200, ClientOptions.instance.toolkit.getValue());
                        return;
                    }
                    if (arg0 == 6139) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.maxScreenSize.getValue();
                        return;
                    }
                    if (arg0 == 6142) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.speechVolume.getValue();
                        return;
                    }
                    if (arg0 == 6143) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.loginVolume.getValue();
                        return;
                    }
                    if (arg0 == 6144) {
                        anIntArray578[anInt7142++] = Static3.chooseSafeMode ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6145) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.loadingSequence.getValue();
                        return;
                    }
                    if (arg0 == 6146) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.orthographic.getValue();
                        return;
                    }
                    if (arg0 == 6147) {
                        anIntArray578[anInt7142++] = SystemInfo.instance.totalMemory < 512 || Static3.chooseSafeMode || Static171.graphicsError ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6148) {
                        anIntArray578[anInt7142++] = Static416.aBoolean472 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6149) {
                        anIntArray578[anInt7142++] = ClientOptions.instance.skydetail.getValue();
                        return;
                    }
                } else if (arg0 < 6300) {
                    if (arg0 == 6200) {
                        anInt7142 -= 2;
                        Static640.aShort122 = (short) anIntArray578[anInt7142];
                        if (Static640.aShort122 <= 0) {
                            Static640.aShort122 = 256;
                        }
                        Static640.aShort121 = (short) anIntArray578[anInt7142 + 1];
                        if (Static640.aShort121 <= 0) {
                            Static640.aShort121 = 205;
                        }
                        return;
                    }
                    if (arg0 == 6201) {
                        anInt7142 -= 2;
                        Static228.aShort45 = (short) anIntArray578[anInt7142];
                        if (Static228.aShort45 <= 0) {
                            Static228.aShort45 = 256;
                        }
                        Static502.aShort97 = (short) anIntArray578[anInt7142 + 1];
                        if (Static502.aShort97 <= 0) {
                            Static502.aShort97 = 320;
                        }
                        return;
                    }
                    if (arg0 == 6202) {
                        anInt7142 -= 4;
                        Static25.aShort1 = (short) anIntArray578[anInt7142];
                        if (Static25.aShort1 <= 0) {
                            Static25.aShort1 = 1;
                        }
                        Static598.aShort120 = (short) anIntArray578[anInt7142 + 1];
                        if (Static598.aShort120 <= 0) {
                            Static598.aShort120 = 32767;
                        } else if (Static598.aShort120 < Static25.aShort1) {
                            Static598.aShort120 = Static25.aShort1;
                        }
                        Static552.aShort123 = (short) anIntArray578[anInt7142 + 2];
                        if (Static552.aShort123 <= 0) {
                            Static552.aShort123 = 1;
                        }
                        Static306.aShort59 = (short) anIntArray578[anInt7142 + 3];
                        if (Static306.aShort59 <= 0) {
                            Static306.aShort59 = 32767;
                            return;
                        }
                        if (Static306.aShort59 < Static552.aShort123) {
                            Static306.aShort59 = Static552.aShort123;
                        }
                        return;
                    }
                    if (arg0 == 6203) {
                        Static498.method6643(0, false, 0, InterfaceManager.viewport.height, InterfaceManager.viewport.width);
                        anIntArray578[anInt7142++] = Static242.anInt3971;
                        anIntArray578[anInt7142++] = Static200.anInt3305;
                        return;
                    }
                    if (arg0 == 6204) {
                        anIntArray578[anInt7142++] = Static228.aShort45;
                        anIntArray578[anInt7142++] = Static502.aShort97;
                        return;
                    }
                    if (arg0 == 6205) {
                        anIntArray578[anInt7142++] = Static640.aShort122;
                        anIntArray578[anInt7142++] = Static640.aShort121;
                        return;
                    }
                } else if (arg0 < 6400) {
                    if (arg0 == 6300) {
                        anIntArray578[anInt7142++] = (int) (SystemTimer.safetime() / 60000L);
                        return;
                    }
                    if (arg0 == 6301) {
                        anIntArray578[anInt7142++] = (int) (SystemTimer.safetime() / 86400000L) - 11745;
                        return;
                    }
                    if (arg0 == 6302) {
                        anInt7142 -= 3;
                        local192 = anIntArray578[anInt7142];
                        local834 = anIntArray578[anInt7142 + 1];
                        local109 = anIntArray578[anInt7142 + 2];
                        @Pc(7384) long local7384 = Static40.method1026(local834, local109, local192);
                        local3561 = Static68.method3585(local7384);
                        if (local109 < 1970) {
                            local3561--;
                        }
                        anIntArray578[anInt7142++] = local3561;
                        return;
                    }
                    if (arg0 == 6303) {
                        anIntArray578[anInt7142++] = Static614.method8242(SystemTimer.safetime());
                        return;
                    }
                    if (arg0 == 6304) {
                        local192 = anIntArray578[--anInt7142];
                        local1578 = true;
                        if (local192 < 0) {
                            local1578 = (local192 + 1) % 4 == 0;
                        } else if (local192 < 1582) {
                            local1578 = local192 % 4 == 0;
                        } else if (local192 % 4 != 0) {
                            local1578 = false;
                        } else if (local192 % 100 != 0) {
                            local1578 = true;
                        } else if (local192 % 400 != 0) {
                            local1578 = false;
                        }
                        anIntArray578[anInt7142++] = local1578 ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6305) {
                        local192 = anIntArray578[--anInt7142];
                        @Pc(7512) int[] local7512 = Static212.method3135(local192);
                        Arrays.copy(local7512, 0, anIntArray578, anInt7142, 3);
                        anInt7142 += 3;
                        return;
                    }
                    if (arg0 == 6306) {
                        local192 = anIntArray578[--anInt7142];
                        anIntArray578[anInt7142++] = (int) (Static38.method1003(local192) / 60000L);
                        return;
                    }
                } else if (arg0 < 6500) {
                    if (arg0 == 6405) {
                        anIntArray578[anInt7142++] = Static21.method8119() ? 1 : 0;
                        return;
                    }
                    if (arg0 == 6406) {
                        anIntArray578[anInt7142++] = Static385.method5421() ? 1 : 0;
                        return;
                    }
                } else if (arg0 < 6600) {
                    if (arg0 == 6500) {
                        if (MainLogicManager.step == 7 && !Static242.method3500() && Static6.anInt95 == 0) {
                            if (WorldList.fetching) {
                                anIntArray578[anInt7142++] = 0;
                                return;
                            }
                            if (WorldList.lastReply > SystemTimer.safetime() - 1000L) {
                                anIntArray578[anInt7142++] = 1;
                                return;
                            }
                            WorldList.fetching = true;
                            @Pc(7662) ClientMessage local7662 = ClientMessage.create(Static231.A_CLIENT_PROT___41, ConnectionManager.LOBBY.cipher);
                            local7662.bitPacket.p4(WorldList.checksum);
                            ConnectionManager.LOBBY.send(local7662);
                            anIntArray578[anInt7142++] = 0;
                            return;
                        }
                        anIntArray578[anInt7142++] = 1;
                        return;
                    }
                    @Pc(7719) Country local7719;
                    @Pc(7686) GameWorld local7686;
                    if (arg0 == 6501) {
                        local7686 = WorldList.first();
                        if (local7686 != null) {
                            anIntArray578[anInt7142++] = local7686.id;
                            anIntArray578[anInt7142++] = local7686.flags;
                            aStringArray37[anInt7139++] = local7686.activity;
                            local7719 = local7686.method6717();
                            anIntArray578[anInt7142++] = local7719.flag;
                            aStringArray37[anInt7139++] = local7719.name;
                            anIntArray578[anInt7142++] = local7686.population;
                            anIntArray578[anInt7142++] = local7686.ping;
                            aStringArray37[anInt7139++] = local7686.address;
                            return;
                        }
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        anIntArray578[anInt7142++] = 0;
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        return;
                    }
                    if (arg0 == 6502) {
                        local7686 = WorldList.next();
                        if (local7686 != null) {
                            anIntArray578[anInt7142++] = local7686.id;
                            anIntArray578[anInt7142++] = local7686.flags;
                            aStringArray37[anInt7139++] = local7686.activity;
                            local7719 = local7686.method6717();
                            anIntArray578[anInt7142++] = local7719.flag;
                            aStringArray37[anInt7139++] = local7719.name;
                            anIntArray578[anInt7142++] = local7686.population;
                            anIntArray578[anInt7142++] = local7686.ping;
                            aStringArray37[anInt7139++] = local7686.address;
                            return;
                        }
                        anIntArray578[anInt7142++] = -1;
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        anIntArray578[anInt7142++] = 0;
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        return;
                    }
                    if (arg0 == 6503) {
                        local192 = anIntArray578[--anInt7142];
                        local101 = aStringArray37[--anInt7139];
                        if (MainLogicManager.step == 7 && !Static242.method3500() && Static6.anInt95 == 0) {
                            anIntArray578[anInt7142++] = Static430.method5817(local192, local101) ? 1 : 0;
                            return;
                        }
                        anIntArray578[anInt7142++] = 0;
                        return;
                    }
                    if (arg0 == 6506) {
                        local192 = anIntArray578[--anInt7142];
                        @Pc(8053) GameWorld local8053 = WorldList.list(local192);
                        if (local8053 != null) {
                            anIntArray578[anInt7142++] = local8053.flags;
                            aStringArray37[anInt7139++] = local8053.activity;
                            @Pc(8077) Country local8077 = local8053.method6717();
                            anIntArray578[anInt7142++] = local8077.flag;
                            aStringArray37[anInt7139++] = local8077.name;
                            anIntArray578[anInt7142++] = local8053.population;
                            anIntArray578[anInt7142++] = local8053.ping;
                            aStringArray37[anInt7139++] = local8053.address;
                            return;
                        }
                        anIntArray578[anInt7142++] = -1;
                        aStringArray37[anInt7139++] = "";
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        anIntArray578[anInt7142++] = 0;
                        anIntArray578[anInt7142++] = 0;
                        aStringArray37[anInt7139++] = "";
                        return;
                    }
                    if (arg0 == 6507) {
                        anInt7142 -= 4;
                        local192 = anIntArray578[anInt7142];
                        local1578 = anIntArray578[anInt7142 + 1] == 1;
                        local109 = anIntArray578[anInt7142 + 2];
                        local2331 = anIntArray578[anInt7142 + 3] == 1;
                        Static210.quicksortWorldList(local1578, local109, local192, local2331);
                        return;
                    }
                    if (arg0 == 6508) {
                        Static152.method9273();
                        return;
                    }
                    if (arg0 == 6509) {
                        if (MainLogicManager.step != 7) {
                            return;
                        }
                        Static60.aBoolean86 = anIntArray578[--anInt7142] == 1;
                        return;
                    }
                    if (arg0 == 6510) {
                        anIntArray578[anInt7142++] = client.worldFlags;
                        return;
                    }
                } else if (arg0 >= 6700) {
                    if (arg0 < 6800 && client.modeWhat == ModeWhat.WIP) {
                        if (arg0 == 6700) {
                            local192 = InterfaceManager.subInterfaces.size();
                            if (InterfaceManager.topLevelInterface != -1) {
                                local192++;
                            }
                            anIntArray578[anInt7142++] = local192;
                            return;
                        }
                        if (arg0 == 6701) {
                            local192 = anIntArray578[--anInt7142];
                            if (InterfaceManager.topLevelInterface != -1) {
                                if (local192 == 0) {
                                    anIntArray578[anInt7142++] = InterfaceManager.topLevelInterface;
                                    return;
                                }
                                local192--;
                            }
                            @Pc(8344) SubInterface local8344 = (SubInterface) InterfaceManager.subInterfaces.first();
                            while (local192-- > 0) {
                                local8344 = (SubInterface) InterfaceManager.subInterfaces.next();
                            }
                            anIntArray578[anInt7142++] = local8344.id;
                            return;
                        }
                        if (arg0 == 6702) {
                            local192 = anIntArray578[--anInt7142];
                            if (InterfaceList.interfaces[local192] == null) {
                                aStringArray37[anInt7139++] = "";
                                return;
                            }
                            local101 = InterfaceList.interfaces[local192][0].name;
                            if (local101 == null) {
                                aStringArray37[anInt7139++] = "";
                                return;
                            }
                            aStringArray37[anInt7139++] = local101.substring(0, local101.indexOf(58));
                            return;
                        }
                        if (arg0 == 6703) {
                            local192 = anIntArray578[--anInt7142];
                            if (InterfaceList.interfaces[local192] == null) {
                                anIntArray578[anInt7142++] = 0;
                                return;
                            }
                            anIntArray578[anInt7142++] = InterfaceList.interfaces[local192].length;
                            return;
                        }
                        if (arg0 == 6704) {
                            anInt7142 -= 2;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            if (InterfaceList.interfaces[local192] == null) {
                                aStringArray37[anInt7139++] = "";
                                return;
                            }
                            local198 = InterfaceList.interfaces[local192][local834].name;
                            if (local198 == null) {
                                aStringArray37[anInt7139++] = "";
                                return;
                            }
                            aStringArray37[anInt7139++] = local198;
                            return;
                        }
                        if (arg0 == 6705) {
                            anInt7142 -= 2;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            if (InterfaceList.interfaces[local192] == null) {
                                anIntArray578[anInt7142++] = 0;
                                return;
                            }
                            anIntArray578[anInt7142++] = InterfaceList.interfaces[local192][local834].anInt3774;
                            return;
                        }
                        if (arg0 == 6706) {
                            return;
                        }
                        if (arg0 == 6707) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 1);
                            return;
                        }
                        if (arg0 == 6708) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 2);
                            return;
                        }
                        if (arg0 == 6709) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 3);
                            return;
                        }
                        if (arg0 == 6710) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 4);
                            return;
                        }
                        if (arg0 == 6711) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 5);
                            return;
                        }
                        if (arg0 == 6712) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 6);
                            return;
                        }
                        if (arg0 == 6713) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 7);
                            return;
                        }
                        if (arg0 == 6714) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 8);
                            return;
                        }
                        if (arg0 == 6715) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 9);
                            return;
                        }
                        if (arg0 == 6716) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            InterfaceManager.ifButtonXSend(local192 << 16 | local834, local109, "", 10);
                            return;
                        }
                        if (arg0 == 6717) {
                            anInt7142 -= 3;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            local109 = anIntArray578[anInt7142 + 2];
                            @Pc(8940) Component local8940 = InterfaceList.getComponent(local109, local192 << 16 | local834);
                            InterfaceManager.endTargetMode();
                            @Pc(8945) ServerActiveProperties local8945 = InterfaceManager.serverActiveProperties(local8940);
                            InterfaceManager.enterTargetMode(local8945.getTargetMask(), local8940, local8945.targetParam);
                            return;
                        }
                    } else if (arg0 < 6900) {
                        @Pc(8975) MapElementType local8975;
                        if (arg0 == 6800) {
                            local192 = anIntArray578[--anInt7142];
                            local8975 = MapElementTypeList.instance.list(local192);
                            if (local8975.text == null) {
                                aStringArray37[anInt7139++] = "";
                                return;
                            }
                            aStringArray37[anInt7139++] = local8975.text;
                            return;
                        }
                        if (arg0 == 6801) {
                            local192 = anIntArray578[--anInt7142];
                            local8975 = MapElementTypeList.instance.list(local192);
                            anIntArray578[anInt7142++] = local8975.sprite;
                            return;
                        }
                        if (arg0 == 6802) {
                            local192 = anIntArray578[--anInt7142];
                            local8975 = MapElementTypeList.instance.list(local192);
                            anIntArray578[anInt7142++] = local8975.font;
                            return;
                        }
                        if (arg0 == 6803) {
                            local192 = anIntArray578[--anInt7142];
                            local8975 = MapElementTypeList.instance.list(local192);
                            anIntArray578[anInt7142++] = local8975.category;
                            return;
                        }
                        if (arg0 == 6804) {
                            anInt7142 -= 2;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            @Pc(9098) ParamType local9098 = ParamTypeList.instance.list(local834);
                            if (local9098.isString()) {
                                aStringArray37[anInt7139++] = MapElementTypeList.instance.list(local192).param(local834, local9098.defaultstr);
                                return;
                            }
                            anIntArray578[anInt7142++] = MapElementTypeList.instance.list(local192).param(local9098.defaultint, local834);
                            return;
                        }
                    } else if (arg0 < 7000) {
                        if (arg0 == 6900) {
                            anIntArray578[anInt7142++] = Static389.aBoolean459 && !Static34.aBoolean62 ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6901) {
                            anIntArray578[anInt7142++] = (int) (Static416.aLong207 / 60000L);
                            anIntArray578[anInt7142++] = (int) ((Static416.aLong207 - SystemTimer.safetime() - Static94.aLong70) / 60000L);
                            anIntArray578[anInt7142++] = Static425.aBoolean482 ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6902) {
                            anIntArray578[anInt7142++] = Static677.anInt10234;
                            return;
                        }
                        if (arg0 == 6903) {
                            anIntArray578[anInt7142++] = Static476.anInt7175;
                            return;
                        }
                        if (arg0 == 6904) {
                            anIntArray578[anInt7142++] = Static323.anInt5118;
                            return;
                        }
                        if (arg0 == 6905) {
                            local95 = "";
                            if (Static439.aSignedResource_4 != null) {
                                if (Static439.aSignedResource_4.result == null) {
                                    local95 = Static419.method5756(Static439.aSignedResource_4.intData1);
                                } else {
                                    local95 = (String) Static439.aSignedResource_4.result;
                                }
                            }
                            aStringArray37[anInt7139++] = local95;
                            return;
                        }
                        if (arg0 == 6906) {
                            anIntArray578[anInt7142++] = Static335.anInt5462;
                            return;
                        }
                        if (arg0 == 6907) {
                            anIntArray578[anInt7142++] = Static626.anInt9473;
                            return;
                        }
                        if (arg0 == 6908) {
                            anIntArray578[anInt7142++] = Static636.anInt9527;
                            return;
                        }
                        if (arg0 == 6909) {
                            anIntArray578[anInt7142++] = Static420.aBoolean479 ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6910) {
                            anIntArray578[anInt7142++] = Static106.anInt2153;
                            return;
                        }
                        if (arg0 == 6911) {
                            anIntArray578[anInt7142++] = Static639.anInt9571;
                            return;
                        }
                        if (arg0 == 6912) {
                            anIntArray578[anInt7142++] = Static438.anInt6640;
                            return;
                        }
                        if (arg0 == 6913) {
                            anIntArray578[anInt7142++] = Static435.anInt6594;
                            return;
                        }
                        if (arg0 == 6914) {
                            anIntArray578[anInt7142++] = Static684.aBoolean775 ? 1 : 0;
                            return;
                        }
                        if (arg0 == 6915) {
                            anIntArray578[anInt7142++] = Static134.anInt10326;
                            return;
                        }
                    } else if (arg0 < 7100) {
                        if (arg0 == 7000) {
                            local192 = Static519.method6831();
                            anIntArray578[anInt7142++] = Static165.anInt2810 = ClientOptions.instance.toolkit.getValue();
                            anIntArray578[anInt7142++] = local192;
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7001) {
                            Static395.method9162();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7002) {
                            Static133.method2316();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7003) {
                            Static75.method6239();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7004) {
                            Static468.method7643();
                            MainLogicManager.mapBuild();
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7005) {
                            ClientOptions.instance.update(0, ClientOptions.instance.graphicsQuality);
                            ClientOptions.save();
                            Static503.sentPreferences = false;
                            return;
                        }
                        if (arg0 == 7006) {
                            if (Static165.anInt2810 == 2) {
                                Static449.aBoolean511 = true;
                                return;
                            }
                            if (Static165.anInt2810 == 1) {
                                Static698.aBoolean792 = true;
                                return;
                            }
                            if (Static165.anInt2810 == 3) {
                                Static78.aBoolean139 = true;
                            }
                            return;
                        }
                        if (arg0 == 7007) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.graphicsQuality.getValue();
                            return;
                        }
                    } else if (arg0 < 7200) {
                        if (arg0 == 7100) {
                            anInt7142 -= 2;
                            local192 = anIntArray578[anInt7142];
                            local834 = anIntArray578[anInt7142 + 1];
                            if (local192 != -1) {
                                if (local834 > 255) {
                                    local834 = 255;
                                } else if (local834 < 0) {
                                    local834 = 0;
                                }
                                VideoTypeList.method6802(false, local192, local834);
                            }
                            return;
                        }
                        if (arg0 == 7101) {
                            local192 = anIntArray578[--anInt7142];
                            if (local192 != -1) {
                                VideoManager.stop(local192);
                            }
                            return;
                        }
                        if (arg0 == 7102) {
                            local192 = anIntArray578[--anInt7142];
                            if (local192 != -1) {
                                VideoTypeList.method9267(local192);
                            }
                            return;
                        }
                        if (arg0 == 7103) {
                            anIntArray578[anInt7142++] = Static183.method2796("jagtheora") ? 1 : 0;
                            return;
                        }
                    } else if (arg0 < 7300) {
                        if (arg0 == 7201) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.groundDecor.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7202) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.spotShadows.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7203) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.hardShadows.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7204) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.waterDetail.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7205) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.antialiasingMode.isCompatible() && Toolkit.active.method8015() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7206) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.particles.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7207) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.buildArea.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7208) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.bloom.isCompatible() && Toolkit.active.method7936() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7209) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.groundBlending.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7210) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.textures.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7211) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.maxScreenSize.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7212) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.fog.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7213) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.orthographic.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7214) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.toolkitDefault.isCompatible() ? 1 : 0;
                            return;
                        }
                        if (arg0 == 7215) {
                            anIntArray578[anInt7142++] = ClientOptions.instance.skydetail.isCompatible() ? 1 : 0;
                            return;
                        }
                    } else if (arg0 < 7400) {
                        if (arg0 == 7301) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.groundDecor.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7302) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.spotShadows.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7303) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.hardShadows.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7304) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.waterDetail.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7305) {
                            local192 = anIntArray578[--anInt7142];
                            if (!Toolkit.active.method8015()) {
                                anIntArray578[anInt7142++] = 3;
                                return;
                            }
                            anIntArray578[anInt7142++] = ClientOptions.instance.antialiasingMode.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7306) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.particles.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7307) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.buildArea.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7308) {
                            local192 = anIntArray578[--anInt7142];
                            if (!Toolkit.active.method7936()) {
                                anIntArray578[anInt7142++] = 3;
                                return;
                            }
                            anIntArray578[anInt7142++] = ClientOptions.instance.bloom.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7309) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.groundBlending.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7310) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.textures.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7311) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.maxScreenSize.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7312) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.fog.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7313) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.orthographic.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7314) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.toolkitDefault.getCompatibility(local192);
                            return;
                        }
                        if (arg0 == 7315) {
                            local192 = anIntArray578[--anInt7142];
                            anIntArray578[anInt7142++] = ClientOptions.instance.skydetail.getCompatibility(local192);
                            return;
                        }
                    }
                }
            }
        }
        throw new IllegalStateException(String.valueOf(arg0));
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!pd;I)V")
    public static void method6422(@OriginalArg(0) HookRequest arg0, @OriginalArg(1) int arg1) {
        @Pc(2) Object[] local2 = arg0.arguments;
        @Pc(8) int local8 = (Integer) local2[0];
        @Pc(12) ClientScript local12 = ClientScriptList.list(local8);
        if (local12 == null) {
            return;
        }
        anIntArray580 = new int[local12.anInt2948];
        @Pc(22) int local22 = 0;
        aStringArray36 = new String[local12.anInt2950];
        @Pc(28) int local28 = 0;
        aLongArray15 = new long[local12.anInt2949];
        @Pc(34) int local34 = 0;
        for (@Pc(36) int local36 = 1; local36 < local2.length; local36++) {
            if (local2[local36] instanceof Integer) {
                @Pc(48) int local48 = (Integer) local2[local36];
                if (local48 == -2147483647) {
                    local48 = arg0.mouseX;
                }
                if (local48 == -2147483646) {
                    local48 = arg0.mouseY;
                }
                if (local48 == -2147483645) {
                    local48 = arg0.source == null ? -1 : arg0.source.slot;
                }
                if (local48 == -2147483644) {
                    local48 = arg0.anInt7219;
                }
                if (local48 == -2147483643) {
                    local48 = arg0.source == null ? -1 : arg0.source.id;
                }
                if (local48 == -2147483642) {
                    local48 = arg0.target == null ? -1 : arg0.target.slot;
                }
                if (local48 == -2147483641) {
                    local48 = arg0.target == null ? -1 : arg0.target.id;
                }
                if (local48 == -2147483640) {
                    local48 = arg0.anInt7216;
                }
                if (local48 == -2147483639) {
                    local48 = arg0.anInt7221;
                }
                anIntArray580[local22++] = local48;
            } else if (local2[local36] instanceof String) {
                @Pc(154) String local154 = (String) local2[local36];
                if (local154.equals("event_opbase")) {
                    local154 = arg0.aString84;
                }
                aStringArray36[local28++] = local154;
            } else if (local2[local36] instanceof Long) {
                @Pc(180) long local180 = (Long) local2[local36];
                aLongArray15[local34++] = local180;
            }
        }
        anInt7153 = arg0.anInt7220;
        method6419(local12, arg1);
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(C)I")
    public static int charIsPrintable(@OriginalArg(0) char c) {
        return StringTools.isPrintable(c) ? 1 : 0;
    }

    @OriginalMember(owner = "client!ou", name = "e", descriptor = "(I)Ljava/lang/String;")
    public static String method6425(@OriginalArg(0) int arg0) {
        @Pc(9) String local9 = aClanSettings_7.getExtraSettingString(client.modeGame.id << 16 | arg0);
        return local9 == null ? "" : local9;
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Ljava/lang/String;I)V")
    public static void method6426(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
        if (Static608.staffModLevel == 0 && (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724)) {
            return;
        }
        @Pc(18) String local18 = arg0.toLowerCase();
        @Pc(20) byte local20 = 0;
        if (local18.startsWith(LocalisedText.CHATCOL0.localise(0))) {
            local20 = 0;
            arg0 = arg0.substring(LocalisedText.CHATCOL0.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL1.localise(0))) {
            local20 = 1;
            arg0 = arg0.substring(LocalisedText.CHATCOL1.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL2.localise(0))) {
            local20 = 2;
            arg0 = arg0.substring(LocalisedText.CHATCOL2.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL3.localise(0))) {
            local20 = 3;
            arg0 = arg0.substring(LocalisedText.CHATCOL3.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL4.localise(0))) {
            local20 = 4;
            arg0 = arg0.substring(LocalisedText.CHATCOL4.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL5.localise(0))) {
            local20 = 5;
            arg0 = arg0.substring(LocalisedText.CHATCOL5.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL6.localise(0))) {
            local20 = 6;
            arg0 = arg0.substring(LocalisedText.CHATCOL6.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL7.localise(0))) {
            local20 = 7;
            arg0 = arg0.substring(LocalisedText.CHATCOL7.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL8.localise(0))) {
            local20 = 8;
            arg0 = arg0.substring(LocalisedText.CHATCOL8.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL9.localise(0))) {
            local20 = 9;
            arg0 = arg0.substring(LocalisedText.CHATCOL9.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL10.localise(0))) {
            local20 = 10;
            arg0 = arg0.substring(LocalisedText.CHATCOL10.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATCOL11.localise(0))) {
            local20 = 11;
            arg0 = arg0.substring(LocalisedText.CHATCOL11.localise(0).length());
        } else if (client.language != 0) {
            if (local18.startsWith(LocalisedText.CHATCOL0.localise(client.language))) {
                local20 = 0;
                arg0 = arg0.substring(LocalisedText.CHATCOL0.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL1.localise(client.language))) {
                local20 = 1;
                arg0 = arg0.substring(LocalisedText.CHATCOL1.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL2.localise(client.language))) {
                local20 = 2;
                arg0 = arg0.substring(LocalisedText.CHATCOL2.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL3.localise(client.language))) {
                local20 = 3;
                arg0 = arg0.substring(LocalisedText.CHATCOL3.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL4.localise(client.language))) {
                local20 = 4;
                arg0 = arg0.substring(LocalisedText.CHATCOL4.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL5.localise(client.language))) {
                local20 = 5;
                arg0 = arg0.substring(LocalisedText.CHATCOL5.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL6.localise(client.language))) {
                local20 = 6;
                arg0 = arg0.substring(LocalisedText.CHATCOL6.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL7.localise(client.language))) {
                local20 = 7;
                arg0 = arg0.substring(LocalisedText.CHATCOL7.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL8.localise(client.language))) {
                local20 = 8;
                arg0 = arg0.substring(LocalisedText.CHATCOL8.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL9.localise(client.language))) {
                local20 = 9;
                arg0 = arg0.substring(LocalisedText.CHATCOL9.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL10.localise(client.language))) {
                local20 = 10;
                arg0 = arg0.substring(LocalisedText.CHATCOL10.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATCOL11.localise(client.language))) {
                local20 = 11;
                arg0 = arg0.substring(LocalisedText.CHATCOL11.localise(client.language).length());
            }
        }
        local18 = arg0.toLowerCase();
        @Pc(460) byte local460 = 0;
        if (local18.startsWith(LocalisedText.CHATEFFECT1.localise(0))) {
            local460 = 1;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT1.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT2.localise(0))) {
            local460 = 2;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT2.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT3.localise(0))) {
            local460 = 3;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT3.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT4.localise(0))) {
            local460 = 4;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT4.localise(0).length());
        } else if (local18.startsWith(LocalisedText.CHATEFFECT5.localise(0))) {
            local460 = 5;
            arg0 = arg0.substring(LocalisedText.CHATEFFECT5.localise(0).length());
        } else if (client.language != 0) {
            if (local18.startsWith(LocalisedText.CHATEFFECT1.localise(client.language))) {
                local460 = 1;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT1.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT2.localise(client.language))) {
                local460 = 2;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT2.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT3.localise(client.language))) {
                local460 = 3;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT3.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT4.localise(client.language))) {
                local460 = 4;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT4.localise(client.language).length());
            } else if (local18.startsWith(LocalisedText.CHATEFFECT5.localise(client.language))) {
                local460 = 5;
                arg0 = arg0.substring(LocalisedText.CHATEFFECT5.localise(client.language).length());
            }
        }
        @Pc(650) ServerConnection local650 = ConnectionManager.active();
        @Pc(656) ClientMessage local656 = ClientMessage.create(Static278.aClientProt_57, local650.cipher);
        local656.bitPacket.p1(0);
        @Pc(665) int local665 = local656.bitPacket.pos;
        local656.bitPacket.p1(local20);
        local656.bitPacket.p1(local460);
        WordPack.encode(local656.bitPacket, arg0);
        local656.bitPacket.psize1(local656.bitPacket.pos - local665);
        local650.send(local656);
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(ILjava/lang/String;I)V")
    public static void executeCutsceneSubtitleTrigger(@OriginalArg(0) int id, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
        @Pc(5) ClientScript script = ClientScriptList.trigger(Static42.CUTSCENE_SUBTITLE, id, -1);
        if (script == null) {
            return;
        }
        anIntArray580 = new int[script.anInt2948];
        aStringArray36 = new String[script.anInt2950];
        aStringArray36[0] = arg1;
        anIntArray580[0] = arg2;
        method6419(script, 200000);
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "()V")
    public static void profileClear() {
    }

    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!mia;II)V")
    public static void executeTrigger(@OriginalArg(0) ClientTriggerType triggerType, @OriginalArg(1) int v1, @OriginalArg(2) int v2) {
        @Pc(5) ClientScript local5 = ClientScriptList.trigger(triggerType, v1, v2);
        if (local5 == null) {
            return;
        }
        anIntArray580 = new int[local5.anInt2948];
        aStringArray36 = new String[local5.anInt2950];
        if (local5.triggerType == Static5.A_CLIENT_TRIGGER_TYPE___1 || local5.triggerType == Static639.A_CLIENT_TRIGGER_TYPE___13 || local5.triggerType == Static280.A_CLIENT_TRIGGER_TYPE___7) {
            @Pc(35) int local35 = 0;
            @Pc(37) int local37 = 0;
            if (WorldMap.component != null) {
                local35 = WorldMap.component.positionX;
                local37 = WorldMap.component.positionY;
            }
            anIntArray580[0] = MouseMonitor.instance.getRecordedX() - local35;
            anIntArray580[1] = MouseMonitor.instance.getRecordedY() - local37;
        }
        method6419(local5, 200000);
    }

    @OriginalMember(owner = "client!sda", name = "a", descriptor = "(BIII)V")
    public static void executeMapElementTrigger(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        if (arg2 == MiniMenuAction.OP_MAPELEMENT1) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT1, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT2) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT2, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT3) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT3, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT4) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT4, arg1, arg0);
        } else if (arg2 == MiniMenuAction.OP_MAPELEMENT5) {
            executeTrigger(ClientTriggerType.OP_MAPELEMENT5, arg1, arg0);
        }
    }
}
