import com.jagex.Client;
import com.jagex.game.runetek6.config.meltype.MapElementType;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseMonitor;

public final class Static603 {

    @OriginalMember(owner = "client!taa", name = "E", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___109 = new ClientProt(29, -1);

    @OriginalMember(owner = "client!taa", name = "b", descriptor = "(Z)V")
    public static void method7899() {
        InterfaceManager.redraw(InterfaceManager.dragSource);
        InterfaceManager.dragTicks++;
        if (Static702.aBoolean797 && InterfaceManager.aBoolean428) {
            @Pc(30) int local30 = 0;
            @Pc(32) int local32 = 0;
            if (InterfaceManager.aBoolean210) {
                local30 = Static130.method2283();
                local32 = Static422.method5771();
            }
            @Pc(46) int local46 = local30 + MouseMonitor.instance.getRecordedX();
            @Pc(52) int local52 = MouseMonitor.instance.getRecordedY() + local32;
            local46 -= InterfaceManager.dragStartX;
            local52 -= InterfaceManager.dragStartY;
            if (InterfaceManager.dragParentX > local46) {
                local46 = InterfaceManager.dragParentX;
            }
            if (InterfaceManager.dragSource.width + local46 > InterfaceManager.dragParentX - -InterfaceManager.dragLayer.width) {
                local46 = InterfaceManager.dragLayer.width + InterfaceManager.dragParentX - InterfaceManager.dragSource.width;
            }
            if (local52 < InterfaceManager.dragParentY) {
                local52 = InterfaceManager.dragParentY;
            }
            if (InterfaceManager.dragParentY + InterfaceManager.dragLayer.height < local52 - -InterfaceManager.dragSource.height) {
                local52 = InterfaceManager.dragParentY + InterfaceManager.dragLayer.height - InterfaceManager.dragSource.height;
            }
            @Pc(119) int local119 = InterfaceManager.dragLayer.scrollX + local46 - InterfaceManager.dragParentX;
            @Pc(127) int local127 = InterfaceManager.dragLayer.scrollY + local52 - InterfaceManager.dragParentY;
            @Pc(197) HookRequest local197;
            if (MouseMonitor.instance.isDown()) {
                if (InterfaceManager.dragSource.dragDeadTime < InterfaceManager.dragTicks) {
                    @Pc(141) int local141 = local46 - InterfaceManager.dragLastX;
                    @Pc(146) int local146 = local52 - InterfaceManager.dragLastY;
                    if (InterfaceManager.dragSource.dragDeadZone < local141 || -InterfaceManager.dragSource.dragDeadZone > local141 || InterfaceManager.dragSource.dragDeadZone < local146 || local146 < -InterfaceManager.dragSource.dragDeadZone) {
                        InterfaceManager.dragging = true;
                    }
                }
                if (InterfaceManager.dragSource.onDrag != null && InterfaceManager.dragging) {
                    local197 = new HookRequest();
                    local197.source = InterfaceManager.dragSource;
                    local197.mouseX = local119;
                    local197.mouseY = local127;
                    local197.arguments = InterfaceManager.dragSource.onDrag;
                    ScriptRunner.executeHookInner(local197);
                    return;
                }
            } else {
                if (InterfaceManager.dragging) {
                    InterfaceManager.endTargetMode();
                    if (InterfaceManager.dragSource.onDragComplete != null) {
                        local197 = new HookRequest();
                        local197.target = InterfaceManager.dragTarget;
                        local197.mouseX = local119;
                        local197.source = InterfaceManager.dragSource;
                        local197.mouseY = local127;
                        local197.arguments = InterfaceManager.dragSource.onDragComplete;
                        ScriptRunner.executeHookInner(local197);
                    }
                    if (InterfaceManager.dragTarget != null && Static84.method1657(InterfaceManager.dragSource) != null) {
                        Static710.method6710(InterfaceManager.dragSource, InterfaceManager.dragTarget);
                    }
                } else if ((Client.mouseButtons == 1 || MiniMenu.topEntryIsIfButtonX1()) && MiniMenu.innerEntryCount > 2) {
                    MiniMenu.method6223(InterfaceManager.dragStartX + InterfaceManager.dragLastX, InterfaceManager.dragLastY + InterfaceManager.dragStartY);
                } else if (MiniMenu.isPopulated()) {
                    MiniMenu.method6223(InterfaceManager.dragLastX + InterfaceManager.dragStartX, InterfaceManager.dragLastY + InterfaceManager.dragStartY);
                }
                InterfaceManager.dragSource = null;
            }
        } else if (InterfaceManager.dragTicks > 1) {
            InterfaceManager.dragSource = null;
        }
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(BLclient!fu;Lclient!ha;Lclient!el;)V")
    public static void method7902(@OriginalArg(1) MapElementListEntry arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) MapElementType arg2) {
        @Pc(8) Sprite local8 = arg2.method2428(arg1);
        if (local8 == null) {
            return;
        }
        @Pc(15) int local15 = local8.getWidth();
        if (local8.getHeight() > local15) {
            local15 = local8.getHeight();
        }
        @Pc(31) int local31 = arg0.anInt3130;
        @Pc(34) int local34 = arg0.anInt3122;
        @Pc(36) int local36 = 0;
        @Pc(38) int local38 = 0;
        @Pc(40) int local40 = 0;
        @Pc(56) int local56;
        @Pc(78) int local78;
        if (arg2.text != null) {
            local36 = Fonts.p11Metrics.splitLines(Static37.aStringArray5, null, null, arg2.text);
            for (local56 = 0; local56 < local36; local56++) {
                @Pc(61) String local61 = Static37.aStringArray5[local56];
                if (local56 < local36 - 1) {
                    local61 = local61.substring(0, local61.length() - 4);
                }
                local78 = Static142.aClass327_1.method7539(local61);
                if (local78 > local38) {
                    local38 = local78;
                }
            }
            local40 = Static142.aClass327_1.method7536() * local36 + Static142.aClass327_1.method7538() / 2;
        }
        local56 = local15 / 2 + arg0.anInt3130;
        if (local31 < WorldMap.anInt5649 + local15) {
            local56 = local15 / 2 + WorldMap.anInt5649 + local38 / 2 + 15;
            local31 = WorldMap.anInt5649;
        } else if (WorldMap.anInt5651 - local15 < local31) {
            local31 = WorldMap.anInt5651 - local15;
            local56 = WorldMap.anInt5651 - local15 / 2 - local38 / 2 - 10 - 5;
        }
        @Pc(163) int local163 = arg0.anInt3122;
        if (local15 + WorldMap.anInt5653 > local34) {
            local163 = WorldMap.anInt5653 + local15 / 2 + 10;
            local34 = WorldMap.anInt5653;
        } else if (WorldMap.anInt5646 - local15 < local34) {
            local163 = WorldMap.anInt5646 - local15 / 2 - local40 - 10;
            local34 = WorldMap.anInt5646 - local15;
        }
        local78 = (int) (Math.atan2(local31 - arg0.anInt3130, local34 - arg0.anInt3122) / 3.141592653589793D * 32767.0D) & 0xFFFF;
        local8.method8186((float) local31 + (float) local15 / 2.0F, (float) local34 + (float) local15 / 2.0F, 4096, local78);
        @Pc(246) int local246 = -2;
        @Pc(248) int local248 = -2;
        @Pc(257) int local257 = -2;
        @Pc(259) int local259 = -2;
        if (arg2.text != null) {
            local246 = local56 - local38 / 2 - 5;
            local248 = local163;
            local257 = local38 + local246 + 10;
            local259 = Static142.aClass327_1.method7536() * local36 + local163 + 3;
            if (arg2.fillColour != 0) {
                arg1.fillRect(local246, local163, local257 - local246, local259 - local163, arg2.fillColour);
            }
            if (arg2.outlineColour != 0) {
                arg1.outlineRect(local246, local163, local257 - local246, local259 - local163, arg2.outlineColour);
            }
            for (@Pc(333) int local333 = 0; local333 < local36; local333++) {
                @Pc(338) String local338 = Static37.aStringArray5[local333];
                if (local36 - 1 > local333) {
                    local338 = local338.substring(0, local338.length() - 4);
                }
                Static142.aClass327_1.method7540(arg1, local338, local56, local163, arg2.textColour);
                local163 += Static142.aClass327_1.method7536();
            }
        }
        if (arg2.sprite == -1 && arg2.text == null) {
            return;
        }
        local15 >>= 0x1;
        @Pc(393) Node_Sub37 local393 = new Node_Sub37(arg0);
        local393.anInt6190 = local15 + local31;
        local393.anInt6187 = local259;
        local393.anInt6192 = local246;
        local393.anInt6195 = local31 - local15;
        local393.anInt6191 = local34 + local15;
        local393.anInt6186 = local34 - local15;
        local393.anInt6184 = local248;
        local393.anInt6185 = local257;
        WorldMap.aDeque_54.addLast(local393);
    }
}
