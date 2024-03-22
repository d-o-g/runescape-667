import com.jagex.core.io.Packet;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.DelayedStateChange;
import rs2.client.event.mouse.MouseLog;
import rs2.client.loading.LoadState;
import com.jagex.game.LocalisedText;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static709 {

    @OriginalMember(owner = "client!wh", name = "N", descriptor = "I")
    public static int anInt10667;

    @OriginalMember(owner = "client!wh", name = "F", descriptor = "I")
    public static int anInt10669 = 1;

    @OriginalMember(owner = "client!wh", name = "a", descriptor = "(IZIILclient!qha;)Lclient!gb;")
    public static Class93_Sub2_Sub1 method9251(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Toolkit_Sub3 arg3) {
        if (arg3.aBoolean597 || Static700.method9150(arg1) && Static700.method9150(arg0)) {
            return new Class93_Sub2_Sub1(arg3, 3553, arg2, arg1, arg0);
        } else if (arg3.aBoolean595) {
            return new Class93_Sub2_Sub1(arg3, 34037, arg2, arg1, arg0);
        } else {
            return new Class93_Sub2_Sub1(arg3, arg2, arg1, arg0, IntMath.nextPow2(arg1), IntMath.nextPow2(arg0));
        }
    }

    @OriginalMember(owner = "client!wh", name = "g", descriptor = "(I)V")
    public static void method9252() {
        if (Static655.aLoadStateArray1 == null) {
            Static655.aLoadStateArray1 = LoadState.method2955();
            Static473.aLoadState_22 = Static655.aLoadStateArray1[0];
            Static72.aLong52 = SystemTimer.safetime();
        }
        if (Static449.aClass364_1 == null) {
            Static229.method3368();
        }
        @Pc(27) LoadState local27 = Static473.aLoadState_22;
        @Pc(35) int local35 = Static523.method3448();
        if (Static473.aLoadState_22 == local27) {
            Static579.aString106 = Static473.aLoadState_22.stalledText.localise(client.language);
            if (Static473.aLoadState_22.updatePercentage) {
                Static376.anInt5919 = Static473.aLoadState_22.startPercentage + local35 * (Static473.aLoadState_22.endPercentage - Static473.aLoadState_22.startPercentage) / 100;
            }
            if (Static473.aLoadState_22.displayPercentage) {
                Static579.aString106 = Static579.aString106 + Static376.anInt5919 + "%";
            }
        } else if (LoadState.COMPLETE == Static473.aLoadState_22) {
            Static449.aClass364_1 = null;
            MainLogicManager.setStep(3);
        } else {
            Static579.aString106 = local27.changedText.localise(client.language);
            if (Static473.aLoadState_22.displayPercentage) {
                Static579.aString106 = Static579.aString106 + local27.endPercentage + "%";
            }
            Static376.anInt5919 = local27.endPercentage;
            if (Static473.aLoadState_22.updatePercentage || local27.updatePercentage) {
                Static72.aLong52 = SystemTimer.safetime();
            }
        }
        if (Static449.aClass364_1 == null) {
            return;
        }
        Static449.aClass364_1.method8374(Static376.anInt5919, Static579.aString106, Static473.aLoadState_22, Static72.aLong52);
        if (Static234.anInterface22Array1 == null) {
            return;
        }
        for (@Pc(157) int local157 = Static214.anInt3500 + 1; local157 < Static234.anInterface22Array1.length; local157++) {
            if (Static234.anInterface22Array1[local157].method8460() >= 100 && Static214.anInt3500 == local157 - 1 && MainLogicManager.step >= 1 && Static449.aClass364_1.method8376()) {
                try {
                    Static234.anInterface22Array1[local157].method8464();
                } catch (@Pc(197) Exception local197) {
                    Static234.anInterface22Array1 = null;
                    return;
                }
                Static449.aClass364_1.method8373(Static234.anInterface22Array1[local157]);
                Static214.anInt3500++;
                if (Static214.anInt3500 >= Static234.anInterface22Array1.length - 1 && Static234.anInterface22Array1.length > 1) {
                    Static214.anInt3500 = Static333.aClass279_1.method6276() ? 0 : -1;
                }
            }
        }
        return;
    }

    @OriginalMember(owner = "client!wh", name = "i", descriptor = "(I)V")
    public static void method9254() {
        if (Static249.anInt4008 > 1) {
            Static249.anInt4008--;
            Static321.lastMiscTransmit = World.tick;
        }
        if (ConnectionManager.GAME.errored) {
            ConnectionManager.GAME.errored = false;
            ConnectionManager.disconnect();
            return;
        }
        if (!MiniMenu.open) {
            MiniMenu.reset();
        }
        for (@Pc(34) int local34 = 0; local34 < 100 && Static236.readPacket(ConnectionManager.GAME); local34++) {
        }
        if (MainLogicManager.step != 11) {
            return;
        }
        @Pc(71) ClientMessage local71;
        @Pc(80) int local80;
        while (Static232.method3400()) {
            local71 = ClientMessage.create(Static632.A_CLIENT_PROT___110, ConnectionManager.GAME.cipher);
            local71.buffer.p1(0);
            local80 = local71.buffer.pos;
            Static437.method5915(local71.buffer);
            local71.buffer.psize1(local71.buffer.pos - local80);
            ConnectionManager.GAME.send(local71);
        }
        if (Static211.aClass2_Sub12_3 == null) {
            if (Static675.aLong307 <= SystemTimer.safetime()) {
                Static211.aClass2_Sub12_3 = Static151.aClass226_20.method5245(client.gameConnection.address);
            }
        } else if (Static211.aClass2_Sub12_3.anInt1631 != -1) {
            local71 = ClientMessage.create(Static50.A_CLIENT_PROT___90, ConnectionManager.GAME.cipher);
            local71.buffer.p2(Static211.aClass2_Sub12_3.anInt1631);
            ConnectionManager.GAME.send(local71);
            Static211.aClass2_Sub12_3 = null;
            Static675.aLong307 = SystemTimer.safetime() + 30000L;
        }
        @Pc(166) MouseLog local166 = (MouseLog) Static226.mouseLogs.first();
        @Pc(181) int local181;
        @Pc(208) int local208;
        @Pc(226) int local226;
        @Pc(282) int local282;
        @Pc(288) int local288;
        @Pc(300) int local300;
        @Pc(179) ClientMessage local179;
        if (local166 != null || Static56.aLong38 < SystemTimer.safetime() - 2000L) {
            local179 = null;
            local181 = 0;
            for (@Pc(186) MouseLog local186 = (MouseLog) Static677.A_DEQUE___76.first(); local186 != null && (local179 == null || local179.buffer.pos - local181 < 240); local186 = (MouseLog) Static677.A_DEQUE___76.next()) {
                local186.unlink();
                local208 = local186.getY();
                if (local208 < -1) {
                    local208 = -1;
                } else if (local208 > 65534) {
                    local208 = 65534;
                }
                local226 = local186.getX();
                if (local226 < -1) {
                    local226 = -1;
                } else if (local226 > 65534) {
                    local226 = 65534;
                }
                if (Static172.anInt2890 != local226 || local208 != Static634.anInt9516) {
                    if (local179 == null) {
                        local179 = ClientMessage.create(Static603.A_CLIENT_PROT___109, ConnectionManager.GAME.cipher);
                        local179.buffer.p1(0);
                        local181 = local179.buffer.pos;
                    }
                    local282 = local226 - Static172.anInt2890;
                    Static172.anInt2890 = local226;
                    local288 = local208 - Static634.anInt9516;
                    Static634.anInt9516 = local208;
                    local300 = (int) ((local186.getTime() - Static56.aLong38) / 20L);
                    if (local300 < 8 && local282 >= -32 && local282 <= 31 && local288 >= -32 && local288 <= 31) {
                        local282 += 32;
                        local288 += 32;
                        local179.buffer.p2((local300 << 12) + (local282 << 6) + local288);
                    } else if (local300 < 32 && local282 >= -128 && local282 <= 127 && local288 >= -128 && local288 <= 127) {
                        local179.buffer.p1(local300 + 128);
                        local282 += 128;
                        local288 += 128;
                        local179.buffer.p2(local288 + (local282 << 8));
                    } else if (local300 >= 32) {
                        local179.buffer.p2(local300 + 57344);
                        if (local226 == 1 || local208 == -1) {
                            local179.buffer.p4(Integer.MIN_VALUE);
                        } else {
                            local179.buffer.p4(local226 | local208 << 16);
                        }
                    } else {
                        local179.buffer.p1(local300 + 192);
                        if (local226 == 1 || local208 == -1) {
                            local179.buffer.p4(Integer.MIN_VALUE);
                        } else {
                            local179.buffer.p4(local208 << 16 | local226);
                        }
                    }
                    Static56.aLong38 = local186.getTime();
                }
            }
            if (local179 != null) {
                local179.buffer.psize1(local179.buffer.pos - local181);
                ConnectionManager.GAME.send(local179);
            }
        }
        @Pc(541) int local541;
        if (local166 != null) {
            @Pc(527) long local527 = (local166.getTime() - Static180.aLong108) / 50L;
            if (local527 > 32767L) {
                local527 = 32767L;
            }
            Static180.aLong108 = local166.getTime();
            local541 = local166.getY();
            if (local541 < 0) {
                local541 = 0;
            } else if (local541 > 65535) {
                local541 = 65535;
            }
            local208 = local166.getX();
            if (local208 < 0) {
                local208 = 0;
            } else if (local208 > 65535) {
                local208 = 65535;
            }
            @Pc(581) byte local581 = 0;
            if (local166.getType() == 2) {
                local581 = 1;
            }
            local282 = (int) local527;
            @Pc(603) ClientMessage local603 = ClientMessage.create(Static111.A_CLIENT_PROT___21, ConnectionManager.GAME.cipher);
            local603.buffer.p2_alt3(local581 << 15 | local282);
            local603.buffer.p4_alt2(local208 | local541 << 16);
            ConnectionManager.GAME.send(local603);
        }
        @Pc(660) long local660;
        if (Static216.anInt3530 > 0) {
            local179 = ClientMessage.create(Static187.A_CLIENT_PROT___36, ConnectionManager.GAME.cipher);
            local179.buffer.p1(Static216.anInt3530 * 3);
            for (local181 = 0; local181 < Static216.anInt3530; local181++) {
                @Pc(652) Interface27 local652 = Static591.anInterface27Array2[local181];
                local660 = (local652.method2665() - Static351.aLong173) / 50L;
                if (local660 > 65535L) {
                    local660 = 65535L;
                }
                Static351.aLong173 = local652.method2665();
                local179.buffer.p1(local652.method2664());
                local179.buffer.p2((int) local660);
            }
            ConnectionManager.GAME.send(local179);
        }
        if (Static232.anInt3764 > 0) {
            Static232.anInt3764--;
        }
        if (Static273.aBoolean339 && Static232.anInt3764 <= 0) {
            Static273.aBoolean339 = false;
            Static232.anInt3764 = 20;
            local179 = ClientMessage.create(Static235.A_CLIENT_PROT___47, ConnectionManager.GAME.cipher);
            local179.buffer.p2((int) Static479.aFloat123 >> 3);
            local179.buffer.p2((int) Static171.aFloat64 >> 3);
            ConnectionManager.GAME.send(local179);
        }
        if (Static91.aBoolean750 != Static50.aBoolean565) {
            Static50.aBoolean565 = Static91.aBoolean750;
            local179 = ClientMessage.create(Static621.A_CLIENT_PROT___113, ConnectionManager.GAME.cipher);
            local179.buffer.p1(Static91.aBoolean750 ? 1 : 0);
            ConnectionManager.GAME.send(local179);
        }
        if (!Static503.aBoolean578) {
            local179 = ClientMessage.create(Static600.A_CLIENT_PROT___108, ConnectionManager.GAME.cipher);
            local179.buffer.p1(0);
            local181 = local179.buffer.pos;
            @Pc(810) Packet local810 = ClientOptions.instance.method5110();
            local179.buffer.pdata(local810.pos, local810.data, 0);
            local179.buffer.psize1(local179.buffer.pos - local181);
            ConnectionManager.GAME.send(local179);
            Static503.aBoolean578 = true;
        }
        if (Static334.activeTiles != null) {
            if (Static511.anInt7645 == 2) {
                Static592.method7761();
            } else if (Static511.anInt7645 == 3) {
                Static583.method7659();
            }
        }
        if (Static494.aBoolean563) {
            Static494.aBoolean563 = false;
        } else {
            Static288.aFloat83 /= 2.0F;
        }
        if (Static15.aBoolean17) {
            Static15.aBoolean17 = false;
        } else {
            Static552.aFloat207 /= 2.0F;
        }
        Static630.method8358();
        if (MainLogicManager.step != 11) {
            return;
        }
        Static159.method2575();
        Static271.method3930();
        Static35.method918();
        ConnectionManager.GAME.anInt3646++;
        if (ConnectionManager.GAME.anInt3646 > 750) {
            ConnectionManager.disconnect();
            return;
        }
        if (CutsceneManager.state == 0) {
            Static82.method1593();
            Static13.method158();
        } else {
            if (CutsceneManager.state == 1 && Static360.method5230(Static717.anInt10817)) {
                Static266.method6774();
                CutsceneManager.state = 2;
            }
            if (CutsceneManager.state == 2 && MainLogicManager.step != 12) {
                Static25.A_HASH_TABLE___4.clear();
                Static440.anInt6680 = 0;
                Static607.anInt9251 = TimeUtils.clock;
                CutsceneManager.state = 3;
                Static457.method6231();
            }
            if (CutsceneManager.state == 3) {
                local80 = TimeUtils.clock - Static607.anInt9251;
                if (Static401.aClass39Array1.length > Static440.anInt6680) {
                    do {
                        @Pc(982) Class39 local982 = Static401.aClass39Array1[Static440.anInt6680];
                        if (local982.anInt10553 > local80) {
                            break;
                        }
                        local982.method9161();
                    } while (CutsceneManager.state == 3 && ++Static440.anInt6680 < Static401.aClass39Array1.length);
                }
                if (CutsceneManager.state == 3) {
                    for (local181 = 0; local181 < Static219.aClass236Array1.length; local181++) {
                        @Pc(1027) Class236 local1027 = Static219.aClass236Array1[local181];
                        if (local1027.aBoolean455) {
                            @Pc(1034) Class8_Sub2_Sub1_Sub2 local1034 = local1027.method5363();
                            Static489.method6547(true, local1034);
                        }
                    }
                }
            }
        }
        Static90.method1733();
        if (!Static288.aBoolean356) {
            Static598.method7827();
            Static288.aBoolean356 = true;
        }
        for (local80 = TimedVarDomain.instance.method6872(true); local80 != -1; local80 = TimedVarDomain.instance.method6872(false)) {
            Static36.method977(local80, (byte) 108);
            Static142.anIntArray225[Static635.varpUpdateCount++ & 0x1F] = local80;
        }
        for (@Pc(1099) DelayedStateChange change = DelayedStateChange.removeFirst(); change != null; change = DelayedStateChange.removeFirst()) {
            local541 = change.getType();
            local660 = change.getValue();
            if (local541 == 1) {
                Static511.anIntArray614[(int) local660] = change.primaryData;
                Static624.aBoolean727 |= Static118.aBooleanArray4[(int) local660];
                Static278.anIntArray350[Static52.varcUpdateCount++ & 0x1F] = (int) local660;
            } else if (local541 == 2) {
                Static37.aStringArray4[(int) local660] = change.stringData;
                Static268.anIntArray332[Static455.varcstrUpdateCount++ & 0x1F] = (int) local660;
            } else {
                @Pc(1143) Component local1143;
                if (local541 == 3) {
                    local1143 = InterfaceList.list((int) local660);
                    if (!change.stringData.equals(local1143.text)) {
                        local1143.text = change.stringData;
                        InterfaceManager.redraw(local1143);
                    }
                } else {
                    @Pc(1739) int local1739;
                    if (local541 == 4) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = change.primaryData;
                        local300 = change.secondaryData;
                        local1739 = change.tertiaryData;
                        if (local288 != local1143.objType || local300 != local1143.obj || local1739 != local1143.objData) {
                            local1143.objData = local1739;
                            local1143.objType = local288;
                            local1143.obj = local300;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 5) {
                        local1143 = InterfaceList.list((int) local660);
                        if (local1143.modelAnimation != change.primaryData) {
                            if (change.primaryData == -1) {
                                local1143.animator = null;
                            } else {
                                if (local1143.animator == null) {
                                    local1143.animator = new ComponentAnimator();
                                }
                                local1143.animator.update(true, change.primaryData);
                            }
                            local1143.modelAnimation = change.primaryData;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 6) {
                        local282 = change.primaryData;
                        local288 = local282 >> 10 & 0x1F;
                        local300 = local282 >> 5 & 0x1F;
                        local1739 = local282 & 0x1F;
                        @Pc(1751) int local1751 = (local300 << 11) + (local288 << 19) + (local1739 << 3);
                        @Pc(1756) Component local1756 = InterfaceList.list((int) local660);
                        if (local1756.colour != local1751) {
                            local1756.colour = local1751;
                            InterfaceManager.redraw(local1756);
                        }
                    } else if (local541 == 7) {
                        local1143 = InterfaceList.list((int) local660);
                        @Pc(1701) boolean local1701 = change.primaryData == 1;
                        if (local1701 != local1143.hidden) {
                            local1143.hidden = local1701;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 8) {
                        local1143 = InterfaceList.list((int) local660);
                        if (change.primaryData != local1143.modelAngleX || change.secondaryData != local1143.modelAngleY || local1143.modelZoom != change.tertiaryData) {
                            local1143.modelAngleX = change.primaryData;
                            local1143.modelAngleY = change.secondaryData;
                            local1143.modelZoom = change.tertiaryData;
                            if (local1143.invObject != -1) {
                                if (local1143.anInt3800 > 0) {
                                    local1143.modelZoom = local1143.modelZoom * 32 / local1143.anInt3800;
                                } else if (local1143.baseWidth > 0) {
                                    local1143.modelZoom = local1143.modelZoom * 32 / local1143.baseWidth;
                                }
                            }
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 9) {
                        local1143 = InterfaceList.list((int) local660);
                        if (change.primaryData != local1143.invObject || change.secondaryData != local1143.invCount) {
                            local1143.invCount = change.secondaryData;
                            local1143.invObject = change.primaryData;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 10) {
                        local1143 = InterfaceList.list((int) local660);
                        if (change.primaryData != local1143.anInt3736 || local1143.anInt3804 != change.secondaryData || change.tertiaryData != local1143.modelAngleZ) {
                            local1143.anInt3736 = change.primaryData;
                            local1143.anInt3804 = change.secondaryData;
                            local1143.modelAngleZ = change.tertiaryData;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 11) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.postTypeVertical = 0;
                        local1143.positionY = local1143.basePosY = change.secondaryData;
                        local1143.positionX = local1143.basePosX = change.primaryData;
                        local1143.posTypeHorizontal = 0;
                        InterfaceManager.redraw(local1143);
                    } else if (local541 == 12) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = change.primaryData;
                        if (local1143 != null && local1143.type == 0) {
                            if (local288 > local1143.scrollHeight - local1143.height) {
                                local288 = local1143.scrollHeight - local1143.height;
                            }
                            if (local288 < 0) {
                                local288 = 0;
                            }
                            if (local1143.scrollY != local288) {
                                local1143.scrollY = local288;
                                InterfaceManager.redraw(local1143);
                            }
                        }
                    } else if (local541 == 14) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.graphic = change.primaryData;
                    } else if (local541 == 15) {
                        Minimap.flagY = change.secondaryData;
                        Static266.aBoolean583 = true;
                        Minimap.flagX = change.primaryData;
                    } else if (local541 == 16) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.fontGraphic = change.primaryData;
                    } else if (local541 == 20) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.fontMonospaced = change.primaryData == 1;
                    } else if (local541 == 21) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.clickMask = change.primaryData == 1;
                    } else if (local541 == 17) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.video = change.primaryData;
                    } else if (local541 == 18) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = (int) (local660 >> 32);
                        local1143.setRecol((short) change.secondaryData, local288, (short) change.primaryData);
                    } else if (local541 == 19) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = (int) (local660 >> 32);
                        local1143.setRetex((short) change.primaryData, local288, (short) change.secondaryData);
                    }
                }
            }
        }
        Static35.currentTick++;
        if (Static616.anInt9417 != 0) {
            Static481.anInt7215 += 20;
            if (Static481.anInt7215 >= 400) {
                Static616.anInt9417 = 0;
            }
        }
        if (Static67.aComponent_10 != null) {
            Static499.anInt7501++;
            if (Static499.anInt7501 >= 15) {
                InterfaceManager.redraw(Static67.aComponent_10);
                Static67.aComponent_10 = null;
            }
        }
        WorldMap.component = null;
        InterfaceManager.aBoolean428 = false;
        Static702.aBoolean797 = false;
        InterfaceManager.dragTarget = null;
        WorldMap.setOptions(-1, -1, (Component) null);
        if (!InterfaceManager.targeting) {
            InterfaceManager.targetEndCursor = -1;
        }
        Static443.method5981();
        World.tick++;
        if (WorldMap.clicked) {
            @Pc(1980) ClientMessage local1980 = ClientMessage.create(Static133.A_CLIENT_PROT___26, ConnectionManager.GAME.cipher);
            local1980.buffer.p4_alt3(WorldMap.clickedY | WorldMap.clickedLevel << 28 | WorldMap.clickedX << 14);
            ConnectionManager.GAME.send(local1980);
            WorldMap.clicked = false;
        }
        while (true) {
            @Pc(2006) HookRequest local2006;
            @Pc(2026) Component local2026;
            @Pc(2011) Component local2011;
            do {
                local2006 = (HookRequest) Static618.A_DEQUE___68.removeFirst();
                if (local2006 == null) {
                    while (true) {
                        do {
                            local2006 = (HookRequest) Static59.A_DEQUE___33.removeFirst();
                            if (local2006 == null) {
                                while (true) {
                                    do {
                                        local2006 = (HookRequest) Static521.A_DEQUE___44.removeFirst();
                                        if (local2006 == null) {
                                            if (WorldMap.component == null) {
                                                Static460.anInt6964 = 0;
                                            }
                                            if (InterfaceManager.dragSource != null) {
                                                Static603.method7899();
                                            }
                                            if (Static608.staffModLevel > 0 && KeyMonitor.instance.isPressed(82) && KeyMonitor.instance.isPressed(81) && Static611.mouseWheelRotation != 0) {
                                                local541 = PlayerEntity.self.level - Static611.mouseWheelRotation;
                                                if (local541 < 0) {
                                                    local541 = 0;
                                                } else if (local541 > 3) {
                                                    local541 = 3;
                                                }
                                                Static624.teleport(local541, PlayerEntity.self.pathY[0] + WorldMap.areaBaseY, WorldMap.areaBaseX - -PlayerEntity.self.pathX[0]);
                                            }
                                            Static320.method4598();
                                            for (local541 = 0; local541 < 5; local541++) {
                                                @Pc(2246) int local2246 = Static194.anIntArray268[local541]++;
                                            }
                                            if (Static624.aBoolean727 && Static98.aLong71 < SystemTimer.safetime() - 60000L) {
                                                Static266.method6777();
                                            }
                                            for (@Pc(2281) Class8_Sub4_Sub1 local2281 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.first(); local2281 != null; local2281 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.next()) {
                                                if (SystemTimer.safetime() / 1000L - 5L > (long) local2281.anInt6433) {
                                                    if (local2281.aShort74 > 0) {
                                                        Static44.method1072(local2281.aString72 + LocalisedText.FRIENDLOGIN.localise(client.language), "", 0, "", "", 5);
                                                    }
                                                    if (local2281.aShort74 == 0) {
                                                        Static44.method1072(local2281.aString72 + LocalisedText.FRIENDLOGOUT.localise(client.language), "", 0, "", "", 5);
                                                    }
                                                    local2281.unlink();
                                                }
                                            }
                                            if (14590 != 14590) {
                                                anInt10667 = -107;
                                            }
                                            Static392.anInt6143++;
                                            if (Static392.anInt6143 > 500) {
                                                Static392.anInt6143 = 0;
                                                local226 = (int) (Math.random() * 8.0D);
                                                if ((local226 & 0x2) == 2) {
                                                    Static145.anInt2561 += Static374.anInt5906;
                                                }
                                                if ((local226 & 0x1) == 1) {
                                                    Static508.anInt7627 += Static555.anInt8305;
                                                }
                                                if ((local226 & 0x4) == 4) {
                                                    Static288.anInt4621 += anInt10669;
                                                }
                                            }
                                            if (Static508.anInt7627 < -50) {
                                                Static555.anInt8305 = 2;
                                            }
                                            if (Static508.anInt7627 > 50) {
                                                Static555.anInt8305 = -2;
                                            }
                                            if (Static145.anInt2561 < -55) {
                                                Static374.anInt5906 = 2;
                                            }
                                            if (Static288.anInt4621 < -40) {
                                                anInt10669 = 1;
                                            }
                                            if (Static145.anInt2561 > 55) {
                                                Static374.anInt5906 = -2;
                                            }
                                            Static439.anInt6675++;
                                            if (Static288.anInt4621 > 40) {
                                                anInt10669 = -1;
                                            }
                                            if (Static439.anInt6675 > 500) {
                                                Static439.anInt6675 = 0;
                                                local226 = (int) (Math.random() * 8.0D);
                                                if ((local226 & 0x1) == 1) {
                                                    Static29.anInt723 += Static653.anInt9718;
                                                }
                                                if ((local226 & 0x2) == 2) {
                                                    Static660.anInt9835 += Static171.anInt2887;
                                                }
                                            }
                                            if (Static29.anInt723 < -60) {
                                                Static653.anInt9718 = 2;
                                            }
                                            if (Static29.anInt723 > 60) {
                                                Static653.anInt9718 = -2;
                                            }
                                            if (Static660.anInt9835 < -20) {
                                                Static171.anInt2887 = 1;
                                            }
                                            ConnectionManager.GAME.idleWriteTicks++;
                                            if (Static660.anInt9835 > 10) {
                                                Static171.anInt2887 = -1;
                                            }
                                            if (ConnectionManager.GAME.idleWriteTicks > 50) {
                                                @Pc(2571) ClientMessage local2571 = ClientMessage.create(ClientProt.NO_TIMEOUT, ConnectionManager.GAME.cipher);
                                                ConnectionManager.GAME.send(local2571);
                                            }
                                            if (Static252.aBoolean316) {
                                                Static143.method3571();
                                                Static252.aBoolean316 = false;
                                            }
                                            try {
                                                ConnectionManager.GAME.flush();
                                                return;
                                            } catch (@Pc(2588) IOException local2588) {
                                                ConnectionManager.disconnect();
                                                return;
                                            }
                                        }
                                        local2011 = local2006.source;
                                        if (local2011.id < 0) {
                                            break;
                                        }
                                        local2026 = InterfaceList.list(local2011.layer);
                                    } while (local2026 == null || local2026.staticComponents == null || local2026.staticComponents.length <= local2011.id || local2011 != local2026.staticComponents[local2011.id]);
                                    ScriptRunner.executeHookInner(local2006);
                                }
                            }
                            local2011 = local2006.source;
                            if (local2011.id < 0) {
                                break;
                            }
                            local2026 = InterfaceList.list(local2011.layer);
                        } while (local2026 == null || local2026.staticComponents == null || local2011.id >= local2026.staticComponents.length || local2026.staticComponents[local2011.id] != local2011);
                        ScriptRunner.executeHookInner(local2006);
                    }
                }
                local2011 = local2006.source;
                if (local2011.id < 0) {
                    break;
                }
                local2026 = InterfaceList.list(local2011.layer);
            } while (local2026 == null || local2026.staticComponents == null || local2026.staticComponents.length <= local2011.id || local2026.staticComponents[local2011.id] != local2011);
            ScriptRunner.executeHookInner(local2006);
        }
    }
}
