import com.jagex.core.constants.ComponentClientCode;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.LocalisedText;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.iftype.DragRender;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Model;
import com.jagex.graphics.PickingCylinder;
import com.jagex.graphics.Sprite;
import com.jagex.js5.js5;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseMonitor;

import java.awt.Rectangle;

public final class InterfaceManager {

    @OriginalMember(owner = "client!lia", name = "b", descriptor = "[Z")
    public static final boolean[] dirtyRectangles = new boolean[100];

    @OriginalMember(owner = "client!ff", name = "k", descriptor = "I")
    public static int lastDrawCycle = -2;

    @OriginalMember(owner = "client!cea", name = "u", descriptor = "Lclient!hda;")
    public static Component optionsComponent = null;

    @OriginalMember(owner = "client!fu", name = "p", descriptor = "I")
    public static int anInt3123 = -1;

    @OriginalMember(owner = "client!ww", name = "b", descriptor = "I")
    public static int anInt10936 = -1;

    @OriginalMember(owner = "client!dh", name = "f", descriptor = "Lclient!hda;")
    public static Component dragSource = null;

    @OriginalMember(owner = "client!dq", name = "k", descriptor = "I")
    public static int boundaryCount = 0;

    @OriginalMember(owner = "client!tia", name = "S", descriptor = "[Ljava/awt/Rectangle;")
    public static Rectangle[] boundaries = new Rectangle[100];

    @OriginalMember(owner = "client!dda", name = "o", descriptor = "Z")
    public static boolean testOpacity = false;

    @OriginalMember(owner = "client!dca", name = "v", descriptor = "I")
    public static int dragOffsetY;

    @OriginalMember(owner = "client!nq", name = "e", descriptor = "[Lclient!hda;")
    public static Component[] dragChildren;

    @OriginalMember(owner = "client!gl", name = "c", descriptor = "I")
    public static int dragOffsetX;

    @OriginalMember(owner = "client!ffa", name = "b", descriptor = "Z")
    public static boolean dragging = false;

    @OriginalMember(owner = "client!kq", name = "k", descriptor = "Z")
    public static boolean aBoolean428 = false;

    static {
        for (@Pc(87) int i = 0; i < 100; i++) {
            boundaries[i] = new Rectangle();
        }
    }

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(Lclient!sb;Lclient!sb;Lclient!sb;BLclient!sb;)V")
    public static void init(@OriginalArg(0) js5 interfacesJs5, @OriginalArg(1) js5 fontMetricsJs5, @OriginalArg(2) js5 spritesJs5, @OriginalArg(4) js5 modelsJs5) {
        Component.spritesJs5 = spritesJs5;
        Component.interfacesJs5 = interfacesJs5;
        Component.modelsJs5 = modelsJs5;
        InterfaceList.interfaces = new Component[Component.interfacesJs5.groupSize()][];
        InterfaceList.loaded = new boolean[Component.interfacesJs5.groupSize()];
    }

    @OriginalMember(owner = "client!fj", name = "a", descriptor = "(ILclient!hda;)V")
    public static void redraw(@OriginalArg(1) Component component) {
        if (component.lastUpdate == lastDrawCycle) {
            dirtyRectangles[component.rectangle] = true;
        }
    }

    @OriginalMember(owner = "client!oq", name = "b", descriptor = "(I)V")
    public static void redrawAll() {
        for (@Pc(1) int i = 0; i < 100; i++) {
            dirtyRectangles[i] = true;
        }
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(IBILclient!hda;)V")
    public static void setOptions(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Component optionsComponent) {
        anInt3123 = arg0;
        InterfaceManager.optionsComponent = optionsComponent;
        anInt10936 = arg1;
    }

    @OriginalMember(owner = "client!cea", name = "a", descriptor = "(II[Lclient!hda;IIIIZIII)V")
    public static void draw(@OriginalArg(0) int parent, @OriginalArg(1) int offsetX, @OriginalArg(2) Component[] children, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int boundRectangle, @OriginalArg(7) boolean arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int offsetY) {
        Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);

        for (@Pc(13) int i = 0; i < children.length; i++) {
            @Pc(19) Component child = children[i];
            if ((child == null) || ((parent != child.layer) && ((parent != 0xabcdabcd) || (dragSource != child)))) {
                continue;
            }

            @Pc(49) int boundsLeft = child.positionX + offsetX;
            @Pc(54) int boundsBottom = offsetY + child.positionY;
            @Pc(61) int boundsRight = child.width + boundsLeft + 1;
            @Pc(69) int boundsTop = boundsBottom + child.height + 1;

            @Pc(74) int rectangle;
            if (boundRectangle == -1) {
                boundaries[boundaryCount].setBounds(child.positionX + offsetX, offsetY + child.positionY, child.width, child.height);
                rectangle = boundaryCount++;
            } else {
                rectangle = boundRectangle;
            }

            child.rectangle = rectangle;
            child.lastUpdate = TimeUtils.clock;

            if (isHidden(child)) {
                continue;
            }

            if (child.clientcode != 0) {
                drawSpinningPlayer(child);
            }

            @Pc(125) int local125 = offsetX + child.positionX;
            @Pc(130) int local130 = offsetY + child.positionY;
            @Pc(132) int local132 = 0;
            @Pc(134) int local134 = 0;
            if (Static137.aBoolean210) {
                local132 = Static130.method2283();
                local134 = Static422.method5771();
            }

            @Pc(145) int transparency = child.transparency;
            if (testOpacity && (serverActiveProperties(child).events != 0 || child.type == Component.TYPE_LAYER) && transparency > 127) {
                transparency = 127;
            }

            @Pc(216) int local216;
            @Pc(222) int local222;
            if (dragSource == child) {
                if (parent != 0xabcdabcd && (child.dragRenderBehaviour == DragRender.OFFSET || child.dragRenderBehaviour == DragRender.OFFSET_TRANSPARENT)) {
                    dragOffsetY = offsetY;
                    dragChildren = children;
                    dragOffsetX = offsetX;
                    continue;
                }

                if (dragging && aBoolean428) {
                    local216 = local132 + MouseMonitor.instance.getRecordedX();
                    local222 = local134 + MouseMonitor.instance.getRecordedY();
                    local222 -= Static150.anInt2631;
                    local216 -= Static378.anInt5941;
                    if (Static123.anInt2341 > local216) {
                        local216 = Static123.anInt2341;
                    }
                    if (local222 < Static169.anInt2853) {
                        local222 = Static169.anInt2853;
                    }
                    if (Static123.anInt2341 + Static354.aComponent_8.width < local216 - -child.width) {
                        local216 = Static123.anInt2341 + Static354.aComponent_8.width - child.width;
                    }
                    local125 = local216;
                    if (Static169.anInt2853 + Static354.aComponent_8.height < local222 + child.height) {
                        local222 = Static169.anInt2853 + Static354.aComponent_8.height - child.height;
                    }
                    local130 = local222;
                }
                if (child.dragRenderBehaviour == DragRender.OFFSET_TRANSPARENT) {
                    transparency = 128;
                }
            }
            @Pc(359) int local359;
            @Pc(371) int local371;
            @Pc(317) int local317;
            @Pc(323) int local323;
            if (child.type == 2) {
                local216 = arg3;
                local371 = arg5;
                local222 = arg4;
                local359 = arg8;
            } else {
                local317 = local125 + child.width;
                local323 = local130 + child.height;
                if (child.type == 9) {
                    local323++;
                    local317++;
                }
                local222 = arg4 >= local130 ? arg4 : local130;
                local216 = local125 > arg3 ? local125 : arg3;
                local359 = arg8 <= local317 ? arg8 : local317;
                local371 = local323 < arg5 ? local323 : arg5;
            }
            if (local359 > local216 && local222 < local371) {
                @Pc(744) int local744;
                @Pc(777) int local777;
                @Pc(792) int local792;
                @Pc(936) int local936;
                @Pc(938) int local938;
                @Pc(779) int local779;
                if (child.clientcode != 0) {
                    if (child.clientcode == ComponentClientCode.SCENE || child.clientcode == ComponentClientCode.LOGIN_SCENE) {
                        setOptions(local130, local125, child);
                        if (!Static137.aBoolean210) {
                            Static294.method4339(local130, child.clientcode == ComponentClientCode.LOGIN_SCENE, child.width, child.height, local125);
                            Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                        }
                        dirtyRectangles[rectangle] = true;
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.MINIMAP && Static1.anInt10798 == 0) {
                        if (child.graphic(Static163.activeToolkit) != null) {
                            Static557.method7331();
                            Static28.method746(local130, Static163.activeToolkit, child, local125);
                            Static469.aBooleanArray23[rectangle] = true;
                            Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                            if (Static137.aBoolean210) {
                                if (arg7) {
                                    Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                                } else {
                                    Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                                }
                            }
                        }
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.COLOUR_CHOOSER_HUE) {
                        Static212.method3136(child, local125, local130, Static163.activeToolkit);
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.COLOUR_CHOOSER_SATURATION_VALUE) {
                        Static393.method5509(Static163.activeToolkit, child.colour % 64, child, local125, local130);
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.COMPASS) {
                        if (child.graphic(Static163.activeToolkit) != null) {
                            Static646.method8454(child, local125, local130);
                            Static469.aBooleanArray23[rectangle] = true;
                            Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                            if (Static137.aBoolean210) {
                                if (arg7) {
                                    Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                                } else {
                                    Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                                }
                            }
                        }
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.WORLD_MAP) {
                        Static93.method1832(child.height, local125, local130, Static56.anTextureSource_3, Static163.activeToolkit, child.width);
                        dirtyRectangles[rectangle] = true;
                        Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.WORLD_MAP_OVERVIEW) {
                        Static515.method6801(child.width, Static163.activeToolkit, child.height, local125, local130);
                        dirtyRectangles[rectangle] = true;
                        Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }
                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY) {
                        if (!Static105.aBoolean196 && !Static354.aBoolean440) {
                            continue;
                        }
                        local317 = local125 + child.width;
                        local323 = local130 + 15;
                        if (Static137.aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }
                        if (Static105.aBoolean196) {
                            local744 = -256;
                            if (Static652.anInt9712 < 20) {
                                local744 = -65536;
                            }
                            Fonts.p12.render(local317, "Fps:" + Static652.anInt9712, local744, -1, local323);
                            local323 += 15;
                            @Pc(768) Runtime local768 = Runtime.getRuntime();
                            local777 = (int) ((local768.totalMemory() - local768.freeMemory()) / 1024L);
                            local779 = -256;
                            if (local777 > 98304) {
                                if (Static473.aBoolean539) {
                                    Static664.method8659();
                                    for (local792 = 0; local792 < 10; local792++) {
                                        System.gc();
                                    }
                                    local777 = (int) ((local768.totalMemory() - local768.freeMemory()) / 1024L);
                                    if (local777 > 65536) {
                                        Static67.method6098("WARNING: Memory usage over 64MB! Please inform whoever is responsible for the content/area you are using/in.");
                                    }
                                }
                                local779 = -65536;
                            }
                            Fonts.p12.render(local317, "Mem:" + local777 + "k", local779, -1, local323);
                            local323 += 15;
                            Fonts.p12.render(local317, "Game: In:" + Static405.A_SERVER_CONNECTION___2.readRate + "B/s Out:" + Static405.A_SERVER_CONNECTION___2.writeRate + "B/s", -256, -1, local323);
                            local323 += 15;
                            Fonts.p12.render(local317, "Lobby: In:" + Static405.A_SERVER_CONNECTION___1.readRate + "B/s Out:" + Static405.A_SERVER_CONNECTION___1.writeRate + "B/s", -256, -1, local323);
                            local323 += 15;
                            local792 = Static163.activeToolkit.E() / 1024;
                            Fonts.p12.render(local317, "Offheap:" + local792 + "k", local792 > 65536 ? -65536 : -256, -1, local323);
                            local323 += 15;
                            local936 = 0;
                            local938 = 0;
                            @Pc(940) int local940 = 0;
                            for (@Pc(942) int local942 = 0; local942 < 37; local942++) {
                                if (client.js5ResourceProviders[local942] != null) {
                                    local936 += client.js5ResourceProviders[local942].entryCount();
                                    local938 += client.js5ResourceProviders[local942].method6649();
                                    local940 += client.js5ResourceProviders[local942].extrasCount();
                                }
                            }
                            @Pc(986) int local986 = local940 * 100 / local936;
                            @Pc(992) int local992 = local938 * 10000 / local936;
                            @Pc(1018) String local1018 = "Cache:" + Static573.method7571(0, true, (long) local992, 2) + "% (" + local986 + "%)";
                            Fonts.p11.render(local317, local1018, -256, -1, local323);
                            local323 += 12;
                        }
                        if (Static530.anInt8093 > 0) {
                            Fonts.p11.render(local317, "Particles: " + Static111.anInt2220 + " / " + Static530.anInt8093, -256, -1, local323);
                        }
                        local323 += 12;
                        if (Static354.aBoolean440) {
                            Fonts.p11.render(local317, "Polys: " + Static163.activeToolkit.I() + " Models: " + Static163.activeToolkit.M(), -256, -1, local323);
                            local323 += 12;
                            Fonts.p11.render(local317, "Ls: " + Static606.anInt8954 + " La: " + Static577.anInt8587 + " NPC: " + Static480.anInt7206 + " Pl: " + Static179.anInt2984, -256, -1, local323);
                            Static126.method2228();
                            local323 += 12;
                        }
                        dirtyRectangles[rectangle] = true;
                        continue;
                    }
                }
                @Pc(1255) int local1255;
                @Pc(1214) Node_Sub4 local1214;
                if (child.type == 0) {
                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER && Static163.activeToolkit.method8014()) {
                        Static163.activeToolkit.method7959(local125, local130, child.width, child.height);
                    }
                    draw(child.slot, local125 - child.anInt3809, children, local216, local222, local371, rectangle, arg7, local359, local130 - child.anInt3768);
                    if (child.aComponentArray1 != null) {
                        draw(child.slot, local125 - child.anInt3809, child.aComponentArray1, local216, local222, local371, rectangle, arg7, local359, local130 - child.anInt3768);
                    }
                    local1214 = (Node_Sub4) Static548.aIterableHashTable_40.get((long) child.slot);
                    if (local1214 != null) {
                        Static534.method7120(local1214.anInt147, local216, local359, local222, local130, rectangle, local125, local371);
                    }
                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER) {
                        if (Static163.activeToolkit.method8014()) {
                            Static163.activeToolkit.method7974();
                        }
                        if (Static1.anInt10798 == 3) {
                            local323 = Static399.anInt6215;
                            local744 = Static337.anInt5556;
                            local1255 = Static186.anInt3059;
                            local777 = Static622.anInt7737;
                            if (TimeUtils.clock < Static4.anInt84) {
                                @Pc(1276) float local1276 = (float) (TimeUtils.clock - Static115.anInt2259) / (float) (Static4.anInt84 - Static115.anInt2259);
                                local744 = (int) ((float) Static582.anInt8628 * (1.0F - local1276) + local1276 * (float) Static337.anInt5556);
                                local1255 = (int) (local1276 * (float) Static186.anInt3059 + (float) Static493.anInt7370 * (1.0F - local1276));
                                local323 = (int) (local1276 * (float) Static399.anInt6215 + (1.0F - local1276) * (float) Static323.anInt5120);
                                local777 = (int) (local1276 * (float) Static622.anInt7737 + (1.0F - local1276) * (float) Static201.anInt8407);
                            }
                            if (local323 > 0) {
                                Static163.activeToolkit.method7971(local359 - local216, -local222 + local371, local222, local216, local744 << 16 | local323 << 24 | local1255 << 8 | local777);
                            }
                        }
                    }
                    Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                }
                if (Static359.aBooleanArray17[rectangle] || Static18.anInt251 > 1) {
                    if (child.type == 3) {
                        if (transparency == 0) {
                            if (child.filled) {
                                Static163.activeToolkit.aa(local125, local130, child.width, child.height, child.colour, 0);
                            } else {
                                Static163.activeToolkit.method7976(local125, local130, child.width, child.height, child.colour, 0);
                            }
                        } else if (child.filled) {
                            Static163.activeToolkit.aa(local125, local130, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
                        } else {
                            Static163.activeToolkit.method7976(local125, local130, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
                        }
                        if (Static137.aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }
                    } else {
                        @Pc(1543) ObjType local1543;
                        if (child.type == 4) {
                            @Pc(1514) Font local1514 = child.font(Static163.activeToolkit);
                            if (local1514 != null) {
                                local323 = child.colour;
                                @Pc(1533) String local1533 = child.text;
                                if (child.anInt3760 != -1) {
                                    local1543 = Static419.aObjTypeList_1.list(child.anInt3760);
                                    local1533 = local1543.name;
                                    if (local1533 == null) {
                                        local1533 = "null";
                                    }
                                    if ((local1543.stackable == 1 || child.anInt3817 != 1) && child.anInt3817 != -1) {
                                        local1533 = "<col=ff9040>" + local1533 + "</col> x" + Static360.method5233(child.anInt3817);
                                    }
                                }
                                if (child.anInt3745 != -1) {
                                    local1533 = Static146.method2414(child.anInt3745);
                                    if (local1533 == null) {
                                        local1533 = "";
                                    }
                                }
                                if (child == Static390.aComponent_9) {
                                    local1533 = LocalisedText.PLEASEWAIT.localise(Static51.anInt1052);
                                    local323 = child.colour;
                                }
                                if (Static376.aBoolean452) {
                                    Static163.activeToolkit.T(local125, local130, local125 + child.width, child.height + local130);
                                }
                                local1514.renderLines(child.verticalAlignment, local323 | 255 - (transparency & 0xFF) << 24, child.textShadow ? 255 - (transparency & 0xFF) << 24 : -1, Static679.aSpriteArray14, child.maxLines, 0, local130, child.height, 0, (ClippingMask) null, child.lineHeight, child.width, local125, child.horizontalAlignment, (int[]) null, local1533);
                                if (Static376.aBoolean452) {
                                    Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                                }
                                if (local1533.trim().length() > 0) {
                                    if (!Static376.aBoolean452) {
                                        @Pc(1730) FontMetrics local1730 = Fonts.metrics(child.fontGraphic, Static163.activeToolkit);
                                        local777 = local1730.paraWidth(Static679.aSpriteArray14, local1533, child.width);
                                        local779 = local1730.stringHeight(child.width, child.lineHeight, local1533, Static679.aSpriteArray14);
                                        if (Static137.aBoolean210) {
                                            if (arg7) {
                                                Static682.method8927(local130, local130 + local779, local125, local125 + local777);
                                            } else {
                                                Static595.method7810(local130, local125 + local777, local779 + local130, local125);
                                            }
                                        }
                                    } else if (Static137.aBoolean210) {
                                        if (arg7) {
                                            Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                                        } else {
                                            Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                                        }
                                    }
                                }
                            } else if (Component.redrawAll) {
                                redraw(child);
                            }
                        } else if (child.type == 5) {
                            if (child.skyBox < 0) {
                                @Pc(1816) Sprite local1816;
                                if (child.anInt3760 != -1) {
                                    @Pc(1836) PlayerModel local1836 = child.objWearCol ? Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aPlayerModel_1 : null;
                                    local1816 = Static419.aObjTypeList_1.getCachedSprite(local1836, Static163.activeToolkit, child.anInt3757, child.anInt3760, child.outline, child.anInt3817, child.shadow | 0xFF000000);
                                } else if (child.anInt3745 == -1) {
                                    local1816 = child.sprite(Static163.activeToolkit);
                                } else {
                                    local1816 = Static651.method8512(child.anInt3745, Static163.activeToolkit);
                                }
                                if (local1816 != null) {
                                    local323 = local1816.scaleWidth();
                                    local744 = local1816.scaleHeight();
                                    local1255 = 255 - (transparency & 0xFF) << 24 | (child.colour == 0 ? 16777215 : child.colour & 0xFFFFFF);
                                    if (child.tiled) {
                                        Static163.activeToolkit.T(local125, local130, local125 + child.width, local130 - -child.height);
                                        if (child.angle2d != 0) {
                                            local777 = (child.width + local323 - 1) / local323;
                                            local779 = (local744 + child.height - 1) / local744;
                                            for (local792 = 0; local792 < local777; local792++) {
                                                for (local936 = 0; local936 < local779; local936++) {
                                                    if (child.colour == 0) {
                                                        local1816.method8186((float) (local792 * local323 + local125) + (float) local323 / 2.0F, (float) (local130 + local744 * local936) + (float) local744 / 2.0F, 4096, child.angle2d);
                                                    } else {
                                                        local1816.method8187((float) (local792 * local323 + local125) + (float) local323 / 2.0F, (float) local744 / 2.0F + (float) (local936 * local744 + local130), 4096, child.angle2d, local1255);
                                                    }
                                                }
                                            }
                                        } else if (child.colour == 0 && transparency == 0) {
                                            local1816.method8198(local125, local130, child.width, child.height);
                                        } else {
                                            local1816.method8189(local125, local130, child.width, child.height, 0, local1255, 1);
                                        }
                                        Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                                    } else if (child.colour == 0 && transparency == 0) {
                                        if (child.angle2d != 0) {
                                            local1816.method8186((float) child.width / 2.0F + (float) local125, (float) local130 + (float) child.height / 2.0F, child.width * 4096 / local323, child.angle2d);
                                        } else if (local323 == child.width && child.height == local744) {
                                            local1816.render(local125, local130);
                                        } else {
                                            local1816.render(local125, local130, child.width, child.height);
                                        }
                                    } else if (child.angle2d != 0) {
                                        local1816.method8187((float) child.width / 2.0F + (float) local125, (float) child.height / 2.0F + (float) local130, child.width * 4096 / local323, child.angle2d, local1255);
                                    } else if (local323 == child.width && child.height == local744) {
                                        local1816.render(local125, local130, 0, local1255, 1);
                                    } else {
                                        local1816.render(local125, local130, child.width, child.height, 0, local1255, 1);
                                    }
                                } else if (Component.redrawAll) {
                                    redraw(child);
                                }
                            } else {
                                child.skyBox(Static99.aSkyBoxSphereTypeList_1, Static324.aSkyBoxTypeList_1).method3162(Static163.activeToolkit, local130, local125, child.width, child.anInt3815 << 3, child.anInt3786 << 3, child.height);
                            }
                            if (Static137.aBoolean210) {
                                if (arg7) {
                                    Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                                } else {
                                    Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                                }
                            }
                        } else if (child.type == 6) {
                            Static104.method2033();
                            NPCTypeCustomisation local1215 = null;
                            @Pc(2313) Model local2313 = null;
                            local744 = 0;
                            if (child.anInt3760 != -1) {
                                local1543 = Static419.aObjTypeList_1.list(child.anInt3760);
                                if (local1543 != null) {
                                    local1543 = local1543.getStacked(child.anInt3817);
                                    local2313 = local1543.model(child.aAnimator_6, 2048, child.objWearCol ? Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aPlayerModel_1 : null, 1, Static163.activeToolkit);
                                    if (local2313 == null) {
                                        redraw(child);
                                    } else {
                                        local744 = -local2313.fa() >> 1;
                                    }
                                }
                            } else if (child.objType == 5) {
                                local1255 = child.obj;
                                if (local1255 >= 0 && local1255 < 2048) {
                                    @Pc(2341) Class8_Sub2_Sub1_Sub2_Sub1 local2341 = Static621.aClass8_Sub2_Sub1_Sub2_Sub1Array3[local1255];
                                    if (local2341 != null && (local1255 == Static312.anInt5000 || Static214.method3157(local2341.aString9) == child.objData)) {
                                        local2313 = local2341.aPlayerModel_1.bodyModel(Static419.aObjTypeList_1, child.aAnimator_6, Static574.aBASTypeList_2, Static25.aSeqTypeList_1, 2048, (int[]) null, Static523.wearposDefaults, Static68.aIDKTypeList_3, Static163.activeToolkit, Static690.aNPCTypeList_2, (Animator[]) null, 0, (Animator) null, Static34.aClass304_1);
                                    }
                                }
                            } else if (child.objType == 8 || child.objType == 9) {
                                @Pc(2468) Node_Sub22 local2468 = Static556.method7303(child.obj, false);
                                if (local2468 != null) {
                                    local2313 = local2468.method3078(child.objData, Static163.activeToolkit, child.objType == 9, child.aAnimator_6, child.objWearCol ? Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aPlayerModel_1 : null);
                                }
                            } else if (child.aAnimator_6 != null && child.aAnimator_6.isAnimating()) {
                                local2313 = child.model(Static163.activeToolkit, child.aAnimator_6, Static574.aBASTypeList_2, Static68.aIDKTypeList_3, Static25.aSeqTypeList_1, Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aPlayerModel_1, Static34.aClass304_1, Static690.aNPCTypeList_2, Static419.aObjTypeList_1, 2048, local1215);
                                if (local2313 == null && Component.redrawAll) {
                                    redraw(child);
                                }
                            } else {
                                local2313 = child.model(Static163.activeToolkit, (Animator) null, Static574.aBASTypeList_2, Static68.aIDKTypeList_3, Static25.aSeqTypeList_1, Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aPlayerModel_1, Static34.aClass304_1, Static690.aNPCTypeList_2, Static419.aObjTypeList_1, 2048, local1215);
                                if (local2313 == null && Component.redrawAll) {
                                    redraw(child);
                                }
                            }
                            if (local2313 != null) {
                                if (child.anInt3800 <= 0) {
                                    local1255 = 512;
                                } else {
                                    local1255 = (child.width << 9) / child.anInt3800;
                                }
                                if (child.anInt3825 <= 0) {
                                    local777 = 512;
                                } else {
                                    local777 = (child.height << 9) / child.anInt3825;
                                }
                                local779 = child.width / 2 + local125;
                                local792 = child.height / 2 + local130;
                                if (!child.orthoView) {
                                    local779 += child.modelOriginX * local1255 >> 9;
                                    local792 += child.modelOriginY * local777 >> 9;
                                }
                                Static460.aMatrix_10.makeIdentity();
                                Static163.activeToolkit.setCamera(Static460.aMatrix_10);
                                Static163.activeToolkit.DA(local779, local792, local1255, local777);
                                Static163.activeToolkit.ya();
                                if (child.disableZBuffer) {
                                    Static163.activeToolkit.C(false);
                                }
                                if (child.orthoView) {
                                    Static59.aMatrix_5.method7136(child.modelAngleX);
                                    Static59.aMatrix_5.rotateAxisY(child.modelAngleY);
                                    Static59.aMatrix_5.rotateAxisZ(child.modelAngleZ);
                                    Static59.aMatrix_5.translate(child.modelOriginX, child.modelOriginY, child.modelOriginZ);
                                } else {
                                    local936 = Trig1.SIN[child.modelAngleX << 3] * (child.modelZoom << 2) >> 14;
                                    local938 = Trig1.COS[child.modelAngleX << 3] * (child.modelZoom << 2) >> 14;
                                    Static59.aMatrix_5.makeRotationZ(-child.modelAngleZ << 3);
                                    Static59.aMatrix_5.rotateAxisY(child.modelAngleY << 3);
                                    Static59.aMatrix_5.translate(child.anInt3736 << 2, local744 + (child.anInt3804 << 2) + local936, (child.anInt3804 << 2) + local938);
                                    Static59.aMatrix_5.rotateAxisX(child.modelAngleX << 3);
                                }
                                child.method3384(Static163.activeToolkit, local2313, Static59.aMatrix_5, TimeUtils.clock);
                                if (Static376.aBoolean452) {
                                    Static163.activeToolkit.T(local125, local130, local125 + child.width, child.height + local130);
                                }
                                if (child.orthoView) {
                                    if (child.modelOrtho) {
                                        local2313.renderOrtho(Static59.aMatrix_5, (PickingCylinder) null, child.modelZoom, 1);
                                    } else {
                                        local2313.render(Static59.aMatrix_5, (PickingCylinder) null, 1);
                                        if (child.particleSystem != null) {
                                            Static163.activeToolkit.method8021(child.particleSystem.method3650());
                                        }
                                    }
                                } else if (child.modelOrtho) {
                                    local2313.renderOrtho(Static59.aMatrix_5, (PickingCylinder) null, child.modelZoom << 2, 1);
                                } else {
                                    local2313.render(Static59.aMatrix_5, (PickingCylinder) null, 1);
                                    if (child.particleSystem != null) {
                                        Static163.activeToolkit.method8021(child.particleSystem.method3650());
                                    }
                                }
                                if (Static376.aBoolean452) {
                                    Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                                }
                                if (child.disableZBuffer) {
                                    Static163.activeToolkit.C(true);
                                }
                            }
                            if (Static137.aBoolean210) {
                                if (arg7) {
                                    Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                                } else {
                                    Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                                }
                            }
                        } else if (child.type == 9) {
                            if (child.lineDirection) {
                                local323 = child.height + local130;
                                local1255 = local130;
                                local744 = local125 + child.width;
                            } else {
                                local1255 = child.height + local130;
                                local323 = local130;
                                local744 = local125 + child.width;
                            }
                            if (child.lineWidth == 1) {
                                Static163.activeToolkit.method7951(local125, local323, local744, local1255, child.colour, 0);
                            } else {
                                Static163.activeToolkit.method7947(local125, local323, local744, local1255, child.colour, child.lineWidth);
                            }
                            if (Static137.aBoolean210) {
                                if (arg7) {
                                    Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                                } else {
                                    Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private InterfaceManager() {
        /* empty */
    }

    @OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!hda;)Z")
    public static boolean isHidden(@OriginalArg(0) Component arg0) {
        if (testOpacity) {
            if (serverActiveProperties(arg0).events != 0) {
                return false;
            }
            if (arg0.type == 0) {
                return false;
            }
        }
        return arg0.hidden;
    }

    @OriginalMember(owner = "client!qi", name = "a", descriptor = "(ZLclient!hda;)V")
    public static void drawSpinningPlayer(@OriginalArg(1) Component arg0) {
        if (ComponentClientCode.SPINNING_PLAYER != arg0.clientcode) {
            return;
        }
        if (Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aString9 == null) {
            arg0.obj = 0;
            arg0.objData = 0;
            return;
        }
        arg0.modelAngleX = 150;
        arg0.modelAngleY = (int) (Math.sin((double) TimeUtils.clock / 40.0D) * 256.0D) & 0x7FF;
        arg0.objType = 5;
        arg0.obj = Static312.anInt5000;
        arg0.objData = Static214.method3157(Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aString9);
        @Pc(55) Animator local55 = Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.aAnimator_10;
        if (local55 == null) {
            arg0.aAnimator_6 = null;
            return;
        }
        if (arg0.aAnimator_6 == null) {
            arg0.aAnimator_6 = new Animator_Sub1();
        }
        arg0.modelAnimation = local55.getAnimationId();
        arg0.aAnimator_6.method9096(local55);
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "(Lclient!hda;)Lclient!ofa;")
    public static ServerActiveProperties serverActiveProperties(@OriginalArg(0) Component arg0) {
        @Pc(13) ServerActiveProperties local13 = (ServerActiveProperties) Static291.A_HASH_TABLE___24.get(((long) arg0.slot << 32) + (long) arg0.id);
        return local13 == null ? arg0.serverActiveProperties : local13;
    }
}
