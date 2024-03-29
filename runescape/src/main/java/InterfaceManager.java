import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.DisplayProperties;
import com.jagex.graphics.Fonts;
import com.jagex.sign.SignLink;
import com.jagex.sign.SignedResource;
import com.jagex.sign.SignedResourceStatus;
import com.jagex.core.constants.MainLogicStep;
import com.jagex.core.constants.MaxScreenSize;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.core.constants.ComponentClientCode;
import com.jagex.core.constants.MiniMenuAction;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.constants.WindowMode;
import com.jagex.core.datastruct.key.HashTableIterator;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.LocalisedText;
import com.jagex.game.PlayerModel;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.game.runetek6.config.defaults.WearposDefaults;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.iftype.DragRender;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.iftype.SubInterfaceType;
import com.jagex.game.runetek6.config.iftype.TargetMask;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import com.jagex.game.runetek6.config.skyboxtype.SkyBoxTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Model;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.keyboard.KeyboardMonitor;
import rs2.client.event.mouse.MouseLog;
import rs2.client.event.mouse.MouseMonitor;

import java.awt.Container;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;

public final class InterfaceManager {

    private static final int ROOT = 0xABCDABCD;
    public static final int IMMEDIATE_HOOK_TYPE_DIALOGABORT = 0;
    public static final int IMMEDIATE_HOOK_TYPE_SUBCHANGE = 1;

    @OriginalMember(owner = "client!lia", name = "b", descriptor = "[Z")
    public static final boolean[] dirtyRectangles = new boolean[100];

    @OriginalMember(owner = "client!oq", name = "i", descriptor = "[Z")
    public static final boolean[] flipDirtyRect = new boolean[100];

    @OriginalMember(owner = "client!lfa", name = "a", descriptor = "[Z")
    public static final boolean[] currentlyDirtyRect = new boolean[100];

    @OriginalMember(owner = "client!je", name = "h", descriptor = "Lclient!av;")
    public static final IterableHashTable serverActiveProperties = new IterableHashTable(512);

    @OriginalMember(owner = "client!ff", name = "k", descriptor = "I")
    public static int lastDrawCycle = -2;

    @OriginalMember(owner = "client!cea", name = "u", descriptor = "Lclient!hda;")
    public static Component optionsComponent = null;

    @OriginalMember(owner = "client!fu", name = "p", descriptor = "I")
    public static int optionsY = -1;

    @OriginalMember(owner = "client!ww", name = "b", descriptor = "I")
    public static int optionsX = -1;

    @OriginalMember(owner = "client!dh", name = "f", descriptor = "Lclient!hda;")
    public static Component dragSource = null;

    @OriginalMember(owner = "client!dq", name = "k", descriptor = "I")
    public static int rectangleCount = 0;

    @OriginalMember(owner = "client!tia", name = "S", descriptor = "[Ljava/awt/Rectangle;")
    public static Rectangle[] rectangles = new Rectangle[100];

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

    @OriginalMember(owner = "client!lt", name = "D", descriptor = "I")
    public static int dragStartX = 0;

    @OriginalMember(owner = "client!en", name = "m", descriptor = "I")
    public static int dragStartY = 0;

    @OriginalMember(owner = "client!ld", name = "e", descriptor = "Lclient!hda;")
    public static Component dragLayer = null;

    @OriginalMember(owner = "client!fe", name = "e", descriptor = "I")
    public static int dragParentY = -1;

    @OriginalMember(owner = "client!dr", name = "b", descriptor = "I")
    public static int dragParentX = -1;

    @OriginalMember(owner = "client!ef", name = "d", descriptor = "Z")
    public static boolean aBoolean210 = false;

    @OriginalMember(owner = "client!re", name = "n", descriptor = "Lclient!av;")
    public static IterableHashTable subInterfaces = new IterableHashTable(8);

    @OriginalMember(owner = "client!aka", name = "l", descriptor = "I")
    public static int rectDebug = 0;

    @OriginalMember(owner = "client!mda", name = "B", descriptor = "Lclient!hda;")
    public static Component dialog = null;

    @OriginalMember(owner = "client!lr", name = "e", descriptor = "Z")
    public static boolean clipComponents = false;

    @OriginalMember(owner = "client!ls", name = "j", descriptor = "I")
    public static volatile int topLevelInterface = -1;

    @OriginalMember(owner = "client!ep", name = "b", descriptor = "Z")
    public static boolean resizableScreen = true;

    @OriginalMember(owner = "client!un", name = "t", descriptor = "I")
    public static int dragLastX = -1;

    @OriginalMember(owner = "client!dka", name = "b", descriptor = "I")
    public static int dragLastY = -1;

    @OriginalMember(owner = "client!fl", name = "a", descriptor = "I")
    public static int dragTicks;

    @OriginalMember(owner = "client!et", name = "c", descriptor = "Z")
    public static boolean targetMode = false;

    @OriginalMember(owner = "client!eq", name = "a", descriptor = "Ljava/lang/String;")
    public static String targetVerb = null;

    @OriginalMember(owner = "client!ea", name = "d", descriptor = "Ljava/lang/String;")
    public static String targetedVerb = null;

    @OriginalMember(owner = "client!kg", name = "M", descriptor = "Lclient!hda;")
    public static Component dragTarget = null;

    @OriginalMember(owner = "client!tf", name = "b", descriptor = "Lclient!hda;")
    public static Component viewport = null;

    @OriginalMember(owner = "client!wn", name = "c", descriptor = "I")
    public static int targetMask;

    @OriginalMember(owner = "client!tf", name = "c", descriptor = "I")
    public static int targetParam;

    @OriginalMember(owner = "client!oda", name = "u", descriptor = "I")
    public static int targetSlot;

    @OriginalMember(owner = "client!faa", name = "i", descriptor = "I")
    public static int targetInvObj = -1;

    @OriginalMember(owner = "client!ci", name = "h", descriptor = "I")
    public static int targetComponent = -1;

    @OriginalMember(owner = "client!lla", name = "f", descriptor = "I")
    public static int targetEnterCursor;

    @OriginalMember(owner = "client!nv", name = "o", descriptor = "I")
    public static int targetEndCursor = -1;

    @OriginalMember(owner = "client!oja", name = "c", descriptor = "Z")
    public static boolean lobbyOpened = false;

    @OriginalMember(owner = "client!sga", name = "g", descriptor = "Z")
    public static boolean loginOpened = false;

    static {
        for (@Pc(87) int i = 0; i < 100; i++) {
            rectangles[i] = new Rectangle();
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

    @OriginalMember(owner = "client!sh", name = "a", descriptor = "(IIBII)V")
    public static void redrawWithin(@OriginalArg(1) int x, @OriginalArg(4) int y, @OriginalArg(0) int width, @OriginalArg(3) int height) {
        for (@Pc(1) int i = 0; i < rectangleCount; i++) {
            @Pc(6) Rectangle rectangle = rectangles[i];

            if (x < rectangle.x + rectangle.width && x + width > rectangle.x && y < rectangle.height + rectangle.y && height + y > rectangle.y) {
                dirtyRectangles[i] = true;
            }
        }

        Static682.method8927(y, y + height, x, x + width);
    }

    @OriginalMember(owner = "client!cea", name = "a", descriptor = "(II[Lclient!hda;IIIIZIII)V")
    public static void draw(@OriginalArg(0) int parent, @OriginalArg(1) int offsetX, @OriginalArg(2) Component[] children, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int boundRectangle, @OriginalArg(7) boolean arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int offsetY) {
        Toolkit.active.KA(arg3, arg4, arg8, arg5);

        for (@Pc(13) int i = 0; i < children.length; i++) {
            @Pc(19) Component child = children[i];
            if ((child == null) || ((parent != child.layer) && ((parent != ROOT) || (dragSource != child)))) {
                continue;
            }

            @Pc(49) int boundsLeft = child.positionX + offsetX;
            @Pc(54) int boundsBottom = offsetY + child.positionY;
            @Pc(61) int boundsRight = child.width + boundsLeft + 1;
            @Pc(69) int boundsTop = boundsBottom + child.height + 1;

            @Pc(74) int rectangle;
            if (boundRectangle == -1) {
                rectangles[rectangleCount].setBounds(child.positionX + offsetX, offsetY + child.positionY, child.width, child.height);
                rectangle = rectangleCount++;
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

            @Pc(125) int screenX = offsetX + child.positionX;
            @Pc(130) int screenY = offsetY + child.positionY;

            @Pc(132) int local132 = 0;
            @Pc(134) int local134 = 0;
            if (aBoolean210) {
                local132 = Static130.method2283();
                local134 = Static422.method5771();
            }

            @Pc(145) int transparency = child.transparency;
            if (testOpacity && (serverActiveProperties(child).events != 0 || child.type == Component.TYPE_LAYER) && transparency > 127) {
                transparency = 127;
            }

            if (dragSource == child) {
                if (parent != ROOT && (child.dragRenderBehaviour == DragRender.OFFSET || child.dragRenderBehaviour == DragRender.OFFSET_TRANSPARENT)) {
                    dragOffsetY = offsetY;
                    dragChildren = children;
                    dragOffsetX = offsetX;
                    continue;
                }

                if (dragging && aBoolean428) {
                    @Pc(216) int mouseX;
                    @Pc(222) int mouseY;
                    mouseX = local132 + MouseMonitor.instance.getRecordedX();
                    mouseY = local134 + MouseMonitor.instance.getRecordedY();
                    mouseY -= dragStartY;
                    mouseX -= dragStartX;

                    if (mouseX < dragParentX) {
                        mouseX = dragParentX;
                    }
                    if (mouseY < dragParentY) {
                        mouseY = dragParentY;
                    }

                    if (dragParentX + dragLayer.width < mouseX - -child.width) {
                        mouseX = dragParentX + dragLayer.width - child.width;
                    }
                    screenX = mouseX;

                    if (dragParentY + dragLayer.height < mouseY + child.height) {
                        mouseY = dragParentY + dragLayer.height - child.height;
                    }
                    screenY = mouseY;
                }

                if (child.dragRenderBehaviour == DragRender.OFFSET_TRANSPARENT) {
                    transparency = 128;
                }
            }

            @Pc(216) int x1;
            @Pc(222) int y1;
            @Pc(359) int x2;
            @Pc(371) int y2;
            if (child.type == Component.TYPE_INVENTORY) {
                x1 = arg3;
                y2 = arg5;
                y1 = arg4;
                x2 = arg8;
            } else {
                @Pc(317) int local317 = screenX + child.width;
                @Pc(323) int local323 = screenY + child.height;

                if (child.type == Component.TYPE_LINE) {
                    local323++;
                    local317++;
                }

                y1 = arg4 >= screenY ? arg4 : screenY;
                x1 = screenX > arg3 ? screenX : arg3;
                x2 = arg8 <= local317 ? arg8 : local317;
                y2 = local323 < arg5 ? local323 : arg5;
            }

            if (x2 > x1 && y2 > y1) {
                if (child.clientcode != 0) {
                    if (child.clientcode == ComponentClientCode.SCENE || child.clientcode == ComponentClientCode.LOGIN_SCENE) {
                        setOptions(screenY, screenX, child);

                        if (!aBoolean210) {
                            Static294.method4339(screenY, child.clientcode == ComponentClientCode.LOGIN_SCENE, child.width, child.height, screenX);
                            Toolkit.active.KA(arg3, arg4, arg8, arg5);
                        }

                        dirtyRectangles[rectangle] = true;
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.MINIMAP && CutsceneManager.state == 0) {
                        if (child.graphic(Toolkit.active) != null) {
                            Static557.method7331();
                            Minimap.draw(child, Toolkit.active, screenX, screenY);
                            flipDirtyRect[rectangle] = true;
                            Toolkit.active.KA(arg3, arg4, arg8, arg5);

                            if (aBoolean210) {
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
                        ColourChooser.drawHue(child, screenX, screenY, Toolkit.active);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.COLOUR_CHOOSER_SATURATION_VALUE) {
                        ColourChooser.drawSaturationValue(Toolkit.active, child.colour % 64, child, screenX, screenY);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.COMPASS) {
                        if (child.graphic(Toolkit.active) != null) {
                            Minimap.drawCompass(child, screenX, screenY);
                            flipDirtyRect[rectangle] = true;

                            Toolkit.active.KA(arg3, arg4, arg8, arg5);

                            if (aBoolean210) {
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
                        WorldMap.draw(child.height, screenX, screenY, Js5TextureSource.instance, Toolkit.active, child.width);
                        dirtyRectangles[rectangle] = true;
                        Toolkit.active.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.WORLD_MAP_OVERVIEW) {
                        WorldMap.drawOverview(child.width, Toolkit.active, child.height, screenX, screenY);
                        dirtyRectangles[rectangle] = true;
                        Toolkit.active.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY) {
                        if (!Client.displayFps && !Static354.showProfiling) {
                            continue;
                        }

                        @Pc(317) int drawX = screenX + child.width;
                        @Pc(323) int drawY = screenY + 15;

                        if (aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }

                        if (Client.displayFps) {
                            @Pc(744) int fpsColour = 0xFFFFFF00;
                            if (GameShell.currentFps < 20) {
                                fpsColour = 0xFFFF0000;
                            }

                            Fonts.p12.renderRight("Fps:" + GameShell.currentFps, drawX, drawY, fpsColour, -1);
                            drawY += 15;

                            @Pc(768) Runtime runtime = Runtime.getRuntime();
                            @Pc(777) int memoryUsage = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                            @Pc(779) int memoryColour = 0xFFFFFF00;
                            if (memoryUsage > 0x18000) {
                                if (Client.force64mb) {
                                    Static664.cacheRemoveSoftReferences();

                                    for (@Pc(792) int j = 0; j < 10; j++) {
                                        System.gc();
                                    }

                                    memoryUsage = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);

                                    if (memoryUsage > 65536) {
                                        ChatHistory.addPrivateError("WARNING: Memory usage over 64MB! Please inform whoever is responsible for the content/area you are using/in.");
                                    }
                                }

                                memoryColour = 0xFFFF0000;
                            }

                            Fonts.p12.renderRight("Mem:" + memoryUsage + "k", drawX, drawY, memoryColour, 0xFFFFFFFF);
                            drawY += 15;

                            Fonts.p12.renderRight("Game: In:" + ServerConnection.GAME.readRate + "B/s Out:" + ServerConnection.GAME.writeRate + "B/s", drawX, drawY, 0xFFFFFF00, 0xFFFFFFFF);
                            drawY += 15;

                            Fonts.p12.renderRight("Lobby: In:" + ServerConnection.LOBBY.readRate + "B/s Out:" + ServerConnection.LOBBY.writeRate + "B/s", drawX, drawY, 0xFFFFFF00, 0xFFFFFFFF);
                            drawY += 15;

                            @Pc(792) int offheap = Toolkit.active.E() / 1024;
                            Fonts.p12.renderRight("Offheap:" + offheap + "k", drawX, drawY, offheap > 65536 ? 0xFFFF0000 : 0xFFFFFF00, -1);
                            drawY += 15;

                            @Pc(936) int entryTotal = 0;
                            @Pc(938) int loadedTotal = 0;
                            @Pc(940) int extrasTotal = 0;
                            for (@Pc(942) int archive = 0; archive < 37; archive++) {
                                if (Client.js5ResourceProviders[archive] != null) {
                                    entryTotal += Client.js5ResourceProviders[archive].entryCount();
                                    loadedTotal += Client.js5ResourceProviders[archive].loadedCount();
                                    extrasTotal += Client.js5ResourceProviders[archive].extrasCount();
                                }
                            }

                            @Pc(986) int extrasPercentage = (extrasTotal * 100) / entryTotal;
                            @Pc(992) int totalPercentage = (loadedTotal * 10000) / entryTotal;

                            @Pc(1018) String cache = "Cache:" + StringTools.formatNumber(0, true, totalPercentage, 2) + "% (" + extrasPercentage + "%)";
                            Fonts.p11.renderRight(cache, drawX, drawY, 0xFFFFFF00, 0xFFFFFFFF);
                            drawY += 12;
                        }

                        if (ParticleManager.particleCount > 0) {
                            Fonts.p11.renderRight("Particles: " + ParticleManager.runningParticleCount + " / " + ParticleManager.particleCount, drawX, drawY, 0xFFFFFF00, 0xFFFFFFFF);
                        }
                        drawY += 12;

                        if (Static354.showProfiling) {
                            Fonts.p11.renderRight("Polys: " + Toolkit.active.I() + " Models: " + Toolkit.active.M(), drawX, drawY, 0xFFFFFF00, 0xFFFFFFFF);
                            drawY += 12;

                            Fonts.p11.renderRight("Ls: " + Static606.anInt8954 + " La: " + Static577.anInt8587 + " NPC: " + Static480.npcCount + " Pl: " + Static179.playerCount, drawX, drawY, 0xFFFFFF00, 0xFFFFFFFF);
                            Static126.method2228();
                            drawY += 12;
                        }

                        dirtyRectangles[rectangle] = true;
                        continue;
                    }
                }

                if (child.type == Component.TYPE_LAYER) {
                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER && Toolkit.active.bloom()) {
                        Toolkit.active.method7959(screenX, screenY, child.width, child.height);
                    }

                    draw(child.slot, screenX - child.scrollX, children, x1, y1, y2, rectangle, arg7, x2, screenY - child.scrollY);

                    if (child.dynamicComponents != null) {
                        draw(child.slot, screenX - child.scrollX, child.dynamicComponents, x1, y1, y2, rectangle, arg7, x2, screenY - child.scrollY);
                    }

                    @Pc(1214) SubInterface sub = (SubInterface) subInterfaces.get(child.slot);
                    if (sub != null) {
                        draw(sub.id, x1, x2, y1, screenY, rectangle, screenX, y2);
                    }

                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER) {
                        if (Toolkit.active.bloom()) {
                            Toolkit.active.method7974();
                        }

                        if (CutsceneManager.state == 3) {
                            @Pc(323) int alpha = CutsceneManager.cutsceneFadeAlpha;
                            @Pc(744) int blue = CutsceneManager.cutsceneFadeBlue;
                            @Pc(1255) int red = CutsceneManager.cutsceneFadeRed;
                            @Pc(777) int green = CutsceneManager.cutsceneFadeGreen;

                            if (TimeUtils.clock < CutsceneManager.cutsceneFadeEnd) {
                                @Pc(1276) float f = (float) (TimeUtils.clock - CutsceneManager.cutsceneFadeStart) / (float) (CutsceneManager.cutsceneFadeEnd - CutsceneManager.cutsceneFadeStart);
                                blue = (int) ((f * (float) CutsceneManager.cutsceneFadeBlue) + ((float) Static582.anInt8628 * (1.0F - f)));
                                red = (int) ((f * (float) CutsceneManager.cutsceneFadeRed) + ((float) Static493.anInt7370 * (1.0F - f)));
                                alpha = (int) ((f * (float) CutsceneManager.cutsceneFadeAlpha) + ((float) Static323.anInt5120 * (1.0F - f)));
                                green = (int) ((f * (float) CutsceneManager.cutsceneFadeGreen) + ((float) Static201.anInt8407 * (1.0F - f)));
                            }

                            if (alpha > 0) {
                                Toolkit.active.fillRect(x1, y1, x2 - x1, -y1 + y2, blue << 16 | alpha << 24 | red << 8 | green);
                            }
                        }
                    }

                    Toolkit.active.KA(arg3, arg4, arg8, arg5);
                }

                if (currentlyDirtyRect[rectangle] || rectDebug > 1) {
                    if (child.type == Component.TYPE_RECTANGLE) {
                        if (transparency == 0) {
                            if (child.filled) {
                                Toolkit.active.aa(screenX, screenY, child.width, child.height, child.colour, 0);
                            } else {
                                Toolkit.active.outlineRect(screenX, screenY, child.width, child.height, child.colour, 0);
                            }
                        } else {
                            if (child.filled) {
                                Toolkit.active.aa(screenX, screenY, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
                            } else {
                                Toolkit.active.outlineRect(screenX, screenY, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
                            }
                        }

                        if (aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }
                    } else if (child.type == Component.TYPE_TEXT) {
                        @Pc(1514) Font font = child.font(Toolkit.active);

                        if (font != null) {
                            @Pc(323) int colour = child.colour;
                            @Pc(1533) String text = child.text;

                            if (child.invObject != -1) {
                                @Pc(1543) ObjType objType = ObjTypeList.instance.list(child.invObject);
                                text = objType.name;

                                if (text == null) {
                                    text = "null";
                                }

                                if ((objType.stackable == ObjStackability.ALWAYS || child.invCount != 1) && child.invCount != -1) {
                                    text = "<col=ff9040>" + text + "</col> x" + invText(child.invCount);
                                }
                            }

                            if (child.video != -1) {
                                text = VideoTypeList.subtitles(child.video);

                                if (text == null) {
                                    text = "";
                                }
                            }

                            if (child == dialog) {
                                text = LocalisedText.PLEASEWAIT.localise(Client.language);
                                colour = child.colour;
                            }

                            if (clipComponents) {
                                Toolkit.active.T(screenX, screenY, screenX + child.width, child.height + screenY);
                            }

                            font.renderLines(text, screenX, screenY, 0, 0, child.width, child.height, child.horizontalAlignment, child.verticalAlignment, child.maxLines, child.lineHeight, colour | ((255 - (transparency & 0xFF)) << 24), child.textShadow ? 255 - (transparency & 0xFF) << 24 : -1, null, Sprites.nameIcons, null);

                            if (clipComponents) {
                                Toolkit.active.KA(arg3, arg4, arg8, arg5);
                            }

                            if (text.trim().length() > 0) {
                                if (!clipComponents) {
                                    @Pc(1730) FontMetrics metrics = Fonts.metrics(child.fontGraphic, Toolkit.active);
                                    @Pc(777) int textWidth = metrics.paraWidth(Sprites.nameIcons, text, child.width);
                                    @Pc(779) int textHeight = metrics.stringHeight(child.width, child.lineHeight, text, Sprites.nameIcons);

                                    if (aBoolean210) {
                                        if (arg7) {
                                            Static682.method8927(screenY, screenY + textHeight, screenX, screenX + textWidth);
                                        } else {
                                            Static595.method7810(screenY, screenX + textWidth, textHeight + screenY, screenX);
                                        }
                                    }
                                } else if (aBoolean210) {
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
                    } else if (child.type == Component.TYPE_GRAPHIC) {
                        if (child.skyBox >= 0) {
                            child.skyBox(SkyBoxSphereTypeList.instance, SkyBoxTypeList.instance).method3162(Toolkit.active, screenY, screenX, child.width, child.anInt3815 << 3, child.anInt3786 << 3, child.height);
                        } else {
                            @Pc(1816) Sprite sprite;
                            if (child.invObject != -1) {
                                @Pc(1836) PlayerModel model = child.objWearCol ? PlayerEntity.self.playerModel : null;
                                sprite = ObjTypeList.instance.getCachedSprite(model, Toolkit.active, child.objNumMode, child.invObject, child.outline, child.invCount, child.shadow | 0xFF000000);
                            } else if (child.video != -1) {
                                sprite = VideoTypeList.frame(child.video, Toolkit.active);
                            } else {
                                sprite = child.sprite(Toolkit.active);
                            }

                            if (sprite != null) {
                                @Pc(323) int scaleWidth = sprite.scaleWidth();
                                @Pc(744) int scaleHeight = sprite.scaleHeight();
                                @Pc(1255) int backgroundColour = ((255 - (transparency & 0xFF)) << 24) | ((child.colour != 0) ? (child.colour & 0xFFFFFF) : 0xFFFFFF);

                                if (child.tiled) {
                                    Toolkit.active.T(screenX, screenY, screenX + child.width, screenY - -child.height);

                                    if (child.angle2d != 0) {
                                        @Pc(777) int newWidth = (child.width + scaleWidth - 1) / scaleWidth;
                                        @Pc(779) int newHeight = (child.height + scaleHeight - 1) / scaleHeight;

                                        for (@Pc(792) int x = 0; x < newWidth; x++) {
                                            for (@Pc(936) int y = 0; y < newHeight; y++) {
                                                if (child.colour != 0) {
                                                    sprite.renderRotated((float) (x * scaleWidth + screenX) + ((float) scaleWidth / 2.0F), (float) scaleHeight / 2.0F + (float) (y * scaleHeight + screenY), 4096, child.angle2d, backgroundColour);
                                                } else {
                                                    sprite.renderRotated((float) (x * scaleWidth + screenX) + ((float) scaleWidth / 2.0F), (float) (screenY + scaleHeight * y) + (float) scaleHeight / 2.0F, 4096, child.angle2d);
                                                }
                                            }
                                        }
                                    } else {
                                        if (child.colour != 0 || transparency != 0) {
                                            sprite.renderTiled(screenX, screenY, child.width, child.height, 0, backgroundColour, 1);
                                        } else {
                                            sprite.renderTiled(screenX, screenY, child.width, child.height);
                                        }
                                    }

                                    Toolkit.active.KA(arg3, arg4, arg8, arg5);
                                } else {
                                    if (child.colour != 0 || transparency != 0) {
                                        if (child.angle2d != 0) {
                                            sprite.renderRotated(((float) child.width / 2.0F) + (float) screenX, (float) child.height / 2.0F + (float) screenY, child.width * 4096 / scaleWidth, child.angle2d, backgroundColour);
                                        } else if (scaleWidth == child.width && scaleHeight == child.height) {
                                            sprite.render(screenX, screenY, 0, backgroundColour, 1);
                                        } else {
                                            sprite.render(screenX, screenY, child.width, child.height, 0, backgroundColour, 1);
                                        }
                                    } else {
                                        if (child.angle2d != 0) {
                                            sprite.renderRotated(((float) child.width / 2.0F) + (float) screenX, (float) screenY + (float) child.height / 2.0F, child.width * 4096 / scaleWidth, child.angle2d);
                                        } else if (scaleWidth == child.width && scaleHeight == child.height) {
                                            sprite.render(screenX, screenY);
                                        } else {
                                            sprite.render(screenX, screenY, child.width, child.height);
                                        }
                                    }
                                }
                            } else if (Component.redrawAll) {
                                redraw(child);
                            }
                        }

                        if (aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }
                    } else if (child.type == Component.TYPE_MODEL) {
                        Static104.method2033();
                        NPCTypeCustomisation customisation = null;
                        @Pc(2313) Model model = null;
                        @Pc(744) int minY = 0;

                        if (child.invObject != -1) {
                            @Pc(1543) ObjType objType = ObjTypeList.instance.list(child.invObject);
                            if (objType != null) {
                                objType = objType.getStacked(child.invCount);
                                model = objType.model(child.animator, 2048, child.objWearCol ? PlayerEntity.self.playerModel : null, 1, Toolkit.active);

                                if (model != null) {
                                    minY = -model.fa() >> 1;
                                } else {
                                    redraw(child);
                                }
                            }
                        } else if (child.objType == Component.OBJ_TYPE_PLAYERMODEL) {
                            @Pc(1255) int slot = child.obj;
                            if (slot >= 0 && slot < 2048) {
                                @Pc(2341) PlayerEntity player = PlayerList.highResolutionPlayers[slot];

                                if (player != null && (slot == PlayerList.activePlayerSlot || StringTools.intHash(player.accountName) == child.objData)) {
                                    model = player.playerModel.bodyModel(ObjTypeList.instance, child.animator, BASTypeList.instance, SeqTypeList.instance, 2048, null, WearposDefaults.instance, IDKTypeList.instance, Toolkit.active, NPCTypeList.instance, null, 0, null, TimedVarDomain.instance);
                                }
                            }
                        } else if (child.objType == Component.OBJ_TYPE_INVENTORY_MALE || child.objType == Component.OBJ_TYPE_INVENTORY_FEMALE) {
                            @Pc(2468) ClientInventory inventory = Static556.method7303(child.obj, false);

                            if (inventory != null) {
                                model = inventory.method3078(child.objData, Toolkit.active, child.objType == Component.OBJ_TYPE_INVENTORY_FEMALE, child.animator, child.objWearCol ? PlayerEntity.self.playerModel : null);
                            }
                        } else if (child.animator != null && child.animator.isAnimating()) {
                            model = child.model(Toolkit.active, child.animator, BASTypeList.instance, IDKTypeList.instance, SeqTypeList.instance, PlayerEntity.self.playerModel, TimedVarDomain.instance, NPCTypeList.instance, ObjTypeList.instance, 2048, customisation);

                            if (model == null && Component.redrawAll) {
                                redraw(child);
                            }
                        } else {
                            model = child.model(Toolkit.active, null, BASTypeList.instance, IDKTypeList.instance, SeqTypeList.instance, PlayerEntity.self.playerModel, TimedVarDomain.instance, NPCTypeList.instance, ObjTypeList.instance, 2048, customisation);

                            if (model == null && Component.redrawAll) {
                                redraw(child);
                            }
                        }

                        if (model != null) {
                            @Pc(1255) int local1255;
                            if (child.anInt3800 <= 0) {
                                local1255 = 512;
                            } else {
                                local1255 = (child.width << 9) / child.anInt3800;
                            }

                            @Pc(777) int local777;
                            if (child.anInt3825 <= 0) {
                                local777 = 512;
                            } else {
                                local777 = (child.height << 9) / child.anInt3825;
                            }

                            @Pc(779) int local779 = child.width / 2 + screenX;
                            @Pc(792) int local792 = child.height / 2 + screenY;
                            if (!child.orthoView) {
                                local779 += child.modelOriginX * local1255 >> 9;
                                local792 += child.modelOriginY * local777 >> 9;
                            }

                            Static460.aMatrix_10.makeIdentity();
                            Toolkit.active.setCamera(Static460.aMatrix_10);
                            Toolkit.active.DA(local779, local792, local1255, local777);
                            Toolkit.active.ya();

                            if (child.disableZBuffer) {
                                Toolkit.active.C(false);
                            }

                            if (child.orthoView) {
                                Static59.aMatrix_5.makeRotationX(child.modelAngleX);
                                Static59.aMatrix_5.rotateAxisY(child.modelAngleY);
                                Static59.aMatrix_5.rotateAxisZ(child.modelAngleZ);
                                Static59.aMatrix_5.translate(child.modelOriginX, child.modelOriginY, child.modelOriginZ);
                            } else {
                                @Pc(936) int local936 = Trig1.SIN[child.modelAngleX << 3] * (child.modelZoom << 2) >> 14;
                                @Pc(938) int local938 = Trig1.COS[child.modelAngleX << 3] * (child.modelZoom << 2) >> 14;
                                Static59.aMatrix_5.makeRotationZ(-child.modelAngleZ << 3);
                                Static59.aMatrix_5.rotateAxisY(child.modelAngleY << 3);
                                Static59.aMatrix_5.translate(child.anInt3736 << 2, minY + (child.anInt3804 << 2) + local936, (child.anInt3804 << 2) + local938);
                                Static59.aMatrix_5.rotateAxisX(child.modelAngleX << 3);
                            }

                            child.method3384(Toolkit.active, model, Static59.aMatrix_5, TimeUtils.clock);

                            if (clipComponents) {
                                Toolkit.active.T(screenX, screenY, screenX + child.width, child.height + screenY);
                            }

                            if (child.orthoView) {
                                if (child.modelOrtho) {
                                    model.renderOrtho(Static59.aMatrix_5, null, child.modelZoom, 1);
                                } else {
                                    model.render(Static59.aMatrix_5, null, 1);

                                    if (child.particleSystem != null) {
                                        Toolkit.active.render(child.particleSystem.method3650());
                                    }
                                }
                            } else {
                                if (child.modelOrtho) {
                                    model.renderOrtho(Static59.aMatrix_5, null, child.modelZoom << 2, 1);
                                } else {
                                    model.render(Static59.aMatrix_5, null, 1);

                                    if (child.particleSystem != null) {
                                        Toolkit.active.render(child.particleSystem.method3650());
                                    }
                                }
                            }

                            if (clipComponents) {
                                Toolkit.active.KA(arg3, arg4, arg8, arg5);
                            }

                            if (child.disableZBuffer) {
                                Toolkit.active.C(true);
                            }
                        }

                        if (aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }
                    } else if (child.type == Component.TYPE_LINE) {
                        @Pc(323) int local323;
                        @Pc(744) int local744;
                        @Pc(1255) int local1255;

                        if (child.lineDirection) {
                            local323 = child.height + screenY;
                            local1255 = screenY;
                            local744 = screenX + child.width;
                        } else {
                            local1255 = child.height + screenY;
                            local323 = screenY;
                            local744 = screenX + child.width;
                        }

                        if (child.lineWidth != 1) {
                            Toolkit.active.method7947(screenX, local323, local744, local1255, child.colour, child.lineWidth);
                        } else {
                            Toolkit.active.line(screenX, local323, local744, local1255, child.colour, 0);
                        }

                        if (aBoolean210) {
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

    @OriginalMember(owner = "client!qq", name = "a", descriptor = "(IIIIIIIZI)V")
    public static void draw(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7) {
        if (InterfaceList.load(arg0)) {
            @Pc(17) int local17 = 0;
            @Pc(58) int local58 = 0;
            @Pc(60) int local60 = 0;
            @Pc(62) int local62 = 0;
            @Pc(64) int local64 = 0;

            if (aBoolean210) {
                local62 = Static582.anInt8629;
                local64 = Static691.anInt10368;
                local17 = Static435.anInt6597;
                local58 = Static320.anInt5085;
                local60 = Static599.anInt8837;
                Static691.anInt10368 = 1;
            }

            if (InterfaceList.cache[arg0] != null) {
                draw(-1, arg6, InterfaceList.cache[arg0], arg1, arg3, arg7, arg5, arg5 < 0, arg2, arg4);
            } else {
                draw(-1, arg6, InterfaceList.interfaces[arg0], arg1, arg3, arg7, arg5, arg5 < 0, arg2, arg4);
            }

            if (aBoolean210) {
                if (arg5 >= 0 && Static691.anInt10368 == 2) {
                    Static682.method8927(Static320.anInt5085, Static582.anInt8629, Static435.anInt6597, Static599.anInt8837);
                }
                Static320.anInt5085 = local58;
                Static582.anInt8629 = local62;
                Static435.anInt6597 = local17;
                Static691.anInt10368 = local64;
                Static599.anInt8837 = local60;
            }
        } else if (arg5 == -1) {
            for (@Pc(17) int local17 = 0; local17 < 100; local17++) {
                dirtyRectangles[local17] = true;
            }
        } else {
            dirtyRectangles[arg5] = true;
        }
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(IBILclient!hda;)V")
    public static void setOptions(@OriginalArg(0) int optionsY, @OriginalArg(2) int optionsX, @OriginalArg(3) Component optionsComponent) {
        InterfaceManager.optionsY = optionsY;
        InterfaceManager.optionsComponent = optionsComponent;
        InterfaceManager.optionsX = optionsX;
    }

    @OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!hda;)Z")
    public static boolean isHidden(@OriginalArg(0) Component component) {
        if (testOpacity) {
            if (serverActiveProperties(component).events != 0) {
                return false;
            }

            if (component.type == Component.TYPE_LAYER) {
                return false;
            }
        }

        return component.hidden;
    }

    @OriginalMember(owner = "client!qi", name = "a", descriptor = "(ZLclient!hda;)V")
    public static void drawSpinningPlayer(@OriginalArg(1) Component component) {
        if (ComponentClientCode.SPINNING_PLAYER != component.clientcode) {
            return;
        }

        if (PlayerEntity.self.accountName == null) {
            component.obj = 0;
            component.objData = 0;
            return;
        }

        component.modelAngleX = 150;
        component.modelAngleY = (int) (Math.sin((double) TimeUtils.clock / 40.0D) * 256.0D) & 0x7FF;

        component.objType = 5;
        component.obj = PlayerList.activePlayerSlot;
        component.objData = StringTools.intHash(PlayerEntity.self.accountName);

        @Pc(55) Animator animator = PlayerEntity.self.animator;
        if (animator == null) {
            component.animator = null;
            return;
        }

        if (component.animator == null) {
            component.animator = new ComponentAnimator();
        }

        component.modelAnimation = animator.getAnimationId();
        component.animator.copyFrom(animator);
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "(Lclient!hda;)Lclient!ofa;")
    public static ServerActiveProperties serverActiveProperties(@OriginalArg(0) Component component) {
        @Pc(13) ServerActiveProperties properties = (ServerActiveProperties) serverActiveProperties.get(((long) component.slot << 32) + (long) component.id);
        return properties != null ? properties : component.serverActiveProperties;
    }

    @OriginalMember(owner = "client!fw", name = "a", descriptor = "(BI)V")
    public static void resetServerActiveProperties(@OriginalArg(1) int id) {
        for (@Pc(11) Node node = serverActiveProperties.first(); node != null; node = serverActiveProperties.next()) {
            if ((long) id == (node.key >> 48 & 0xFFFFL)) {
                node.unlink();
            }
        }
    }

    @OriginalMember(owner = "client!lg", name = "b", descriptor = "(II)Ljava/lang/String;")
    public static String invText(@OriginalArg(1) int count) {
        @Pc(8) String text = Integer.toString(count);
        for (@Pc(13) int i = text.length() - 3; i > 0; i -= 3) {
            text = text.substring(0, i) + "," + text.substring(i);
        }

        if (text.length() > 9) {
            return " <col=00ff80>" + text.substring(0, text.length() - 8) + LocalisedText.MILLION.localise(Client.language) + " (" + text + ")</col>";
        } else if (text.length() > 6) {
            return " <col=ffffff>" + text.substring(0, text.length() - 4) + LocalisedText.THOUSAND.localise(Client.language) + " (" + text + ")</col>";
        } else {
            return " <col=ffff00>" + text + "</col>";
        }
    }

    @OriginalMember(owner = "client!vn", name = "a", descriptor = "(JI)V")
    public static void method7930(@OriginalArg(0) long arg0) {
        if (Static334.activeTiles != null) {
            if (Camera.mode == CameraMode.MODE_DEFAULT || Camera.mode == CameraMode.MODE_SMOOTH_RESET) {
                Static604.method7903(arg0);
            } else if (Camera.mode == CameraMode.MODE_FOUR) {
                Static349.method5121(arg0);
            }
        }

        ParticleManager.tick(TimeUtils.clock, Toolkit.active);

        if (topLevelInterface != -1) {
            animate(topLevelInterface);
        }

        for (@Pc(54) int i = 0; i < rectangleCount; i++) {
            if (dirtyRectangles[i]) {
                flipDirtyRect[i] = true;
            }

            currentlyDirtyRect[i] = dirtyRectangles[i];
            dirtyRectangles[i] = false;
        }

        lastDrawCycle = TimeUtils.clock;
        setOptions(-1, -1, null);

        if (topLevelInterface != -1) {
            rectangleCount = 0;
            method3833();
        }

        Toolkit.active.la();
        MiniMenu.draw(Toolkit.active);

        @Pc(116) int cursor = MiniMenu.cursor();
        if (cursor == -1) {
            cursor = targetEndCursor;
        }
        if (cursor == -1) {
            cursor = Cursor.dflt;
        }

        Static115.method2136(cursor);
        @Pc(136) int size = PlayerEntity.self.getSize() << 8;
        Static220.method3198(Static35.currentTick, size + PlayerEntity.self.z, PlayerEntity.self.x + size, PlayerEntity.self.level);
        Static35.currentTick = 0;
    }

    @OriginalMember(owner = "client!at", name = "a", descriptor = "(II)V")
    public static void animate(@OriginalArg(1) int id) {
        if (InterfaceList.load(id)) {
            animate(-1, InterfaceList.interfaces[id]);
        }
    }

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(II[Lclient!hda;)V")
    public static void animate(@OriginalArg(1) int layer, @OriginalArg(2) Component[] components) {
        for (@Pc(3) int i = 0; i < components.length; i++) {
            @Pc(9) Component component = components[i];

            if (component != null && component.layer == layer && !isHidden(component)) {
                if (component.type == Component.TYPE_LAYER) {
                    animate(component.slot, components);

                    if (component.dynamicComponents != null) {
                        animate(component.slot, component.dynamicComponents);
                    }

                    @Pc(56) SubInterface sub = (SubInterface) subInterfaces.get(component.slot);
                    if (sub != null) {
                        animate(sub.id);
                    }
                }

                if (component.type == Component.TYPE_MODEL && component.modelAnimation != -1) {
                    if (component.animator == null) {
                        component.animator = new ComponentAnimator();
                        component.animator.update(true, component.modelAnimation);
                    }

                    if (component.animator.tick(Static35.currentTick) && component.animator.isFinished()) {
                        component.animator.resetImmediately();
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!aq", name = "a", descriptor = "(I)V")
    public static void method680() {
        ParticleManager.tick(TimeUtils.clock, Toolkit.active);
        if (topLevelInterface != -1) {
            animate(topLevelInterface);
        }
        for (@Pc(23) int local23 = 0; local23 < rectangleCount; local23++) {
            if (dirtyRectangles[local23]) {
                flipDirtyRect[local23] = true;
            }
            currentlyDirtyRect[local23] = dirtyRectangles[local23];
            dirtyRectangles[local23] = false;
        }
        lastDrawCycle = TimeUtils.clock;
        if (topLevelInterface != -1) {
            rectangleCount = 0;
            method3833();
        }
        Toolkit.active.la();
        MiniMenu.draw(Toolkit.active);
        @Pc(77) int local77 = MiniMenu.cursor();
        if (local77 == -1) {
            local77 = targetEndCursor;
        }
        if (local77 == -1) {
            local77 = Cursor.dflt;
        }
        Static115.method2136(local77);
        Static35.currentTick = 0;
    }

    @OriginalMember(owner = "client!ic", name = "a", descriptor = "(I)V")
    public static void method3833() {
        dragChildren = null;
        if (aBoolean210 && getWindowMode() != 1) {
            Static294.method4339(0, MainLogicManager.step == 3 || MainLogicManager.step == 7, Static593.method7779(), Static58.method1260(), 0);
        }

        @Pc(46) int local46 = 0;
        @Pc(48) int local48 = 0;
        if (aBoolean210) {
            local46 = Static130.method2283();
            local48 = Static422.method5771();
        }

        draw(topLevelInterface, local46, GameShell.canvasWid + local46, local48, local48, -1, local46, GameShell.canvasHei + local48);

        if (dragChildren != null) {
            draw(ROOT, dragOffsetX, dragChildren, local46, local48, local48 + GameShell.canvasHei, dragLayer.rectangle, true, local46 + GameShell.canvasWid, dragOffsetY);
            dragChildren = null;
        }
    }

    @OriginalMember(owner = "client!bda", name = "c", descriptor = "(I)I")
    public static int getWindowMode() {
        if (GameShell.fsframe != null) {
            return WindowMode.FULLSCREEN;
        } else if (resizableScreen) {
            return WindowMode.RESIZABLE;
        } else {
            return WindowMode.FIXED;
        }
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "([Lclient!hda;IIIIIIIIIII)V")
    public static void logicComponentList(@OriginalArg(0) Component[] components, @OriginalArg(1) int layer, @OriginalArg(2) int parentX1, @OriginalArg(3) int parentY1, @OriginalArg(4) int parentX2, @OriginalArg(5) int parentY2, @OriginalArg(6) int scrollDeltaX, @OriginalArg(7) int scrollDeltaY, @OriginalArg(8) int mouseX1, @OriginalArg(9) int mouseY1, @OriginalArg(10) int mouseX2, @OriginalArg(11) int mouseY2) {
        for (@Pc(1) int i = 0; i < components.length; i++) {
            @Pc(6) Component component = components[i];
            if (component == null || component.layer != layer) {
                continue;
            }

            @Pc(19) int startX = component.positionX + scrollDeltaX;
            @Pc(24) int startY = component.positionY + scrollDeltaY;
            @Pc(30) int x1;
            @Pc(32) int y1;
            @Pc(34) int x2;
            @Pc(36) int y2;

            if (component.type == Component.TYPE_INVENTORY) {
                x1 = parentX1;
                y1 = parentY1;
                x2 = parentX2;
                y2 = parentY2;
            } else {
                @Pc(42) int endX = startX + component.width;
                @Pc(47) int endY = startY + component.height;

                if (component.type == Component.TYPE_LINE) {
                    endX++;
                    endY++;
                }

                x1 = startX > parentX1 ? startX : parentX1;
                y1 = startY > parentY1 ? startY : parentY1;
                x2 = endX < parentX2 ? endX : parentX2;
                y2 = endY < parentY2 ? endY : parentY2;
            }

            if ((component.type == Component.TYPE_LAYER) || component.hasHook || (serverActiveProperties(component).events != 0) || (component == dragLayer) || (component.clientcode == ComponentClientCode.MINIMAP) || (component.clientcode == ComponentClientCode.WORLD_MAP_OPTIONS) || (component.clientcode == ComponentClientCode.SCENE) || (component.clientcode == ComponentClientCode.LOGIN_SCENE)) {
                if (isHidden(component)) {
                    continue;
                }

                @Pc(42) int orthoDeltaX = 0;
                @Pc(47) int orthoDeltaY = 0;
                if (aBoolean210) {
                    orthoDeltaX = Static130.method2283();
                    orthoDeltaY = Static422.method5771();
                }

                if (component == dragSource && getServerDragLayer(dragSource) != null) {
                    Static702.aBoolean797 = true;
                    dragLastX = startX;
                    dragLastY = startY;
                }

                if (component.hasOpKey || x1 < x2 && y1 < y2) {
                    if (component.noClickThrough && mouseX2 >= x1 && mouseY2 >= y1 && mouseX2 < x2 && mouseY2 < y2) {
                        for (@Pc(220) HookRequest hook = (HookRequest) Static521.A_DEQUE___44.first(); hook != null; hook = (HookRequest) Static521.A_DEQUE___44.next()) {
                            if (hook.mouseEvent) {
                                hook.unlink();
                                hook.source.hovered = false;
                            }
                        }

                        if (dragTicks == 0) {
                            dragSource = null;
                            dragLayer = null;
                        }

                        MiniMenu.anInt6964 = 0;
                        WorldMap.hovered = false;
                        WorldMap.clicked = false;

                        if (!MiniMenu.open) {
                            MiniMenu.reset();
                        }
                    }

                    @Pc(308) boolean clickMask = component.clickMask && component.type == Component.TYPE_GRAPHIC && component.transparency == 0 && component.skyBox < 0 && component.invObject == -1 && component.video == -1 && !component.tiled && component.angle2d == 0;

                    @Pc(310) boolean hovered = false;
                    if (MouseMonitor.instance.getRecordedX() + orthoDeltaX >= x1 && MouseMonitor.instance.getRecordedY() + orthoDeltaY >= y1 && MouseMonitor.instance.getRecordedX() + orthoDeltaX < x2 && MouseMonitor.instance.getRecordedY() + orthoDeltaY < y2) {
                        if (clickMask) {
                            @Pc(353) Graphic graphic = component.graphic(Toolkit.active);

                            if (graphic != null && graphic.scaleWidth == component.width && graphic.scaleHeight == component.height) {
                                @Pc(380) int x = MouseMonitor.instance.getRecordedX() + orthoDeltaX - startX;
                                @Pc(388) int y = MouseMonitor.instance.getRecordedY() + orthoDeltaY - startY;

                                if (y >= 0 && y < graphic.lineOffsets.length) {
                                    @Pc(402) int lineOffset = graphic.lineOffsets[y];

                                    if (x >= lineOffset && x <= lineOffset + graphic.lineWidths[y]) {
                                        hovered = true;
                                    }
                                }
                            } else {
                                hovered = true;
                            }
                        } else {
                            hovered = true;
                        }
                    }

                    if (!targetMode && hovered) {
                        if (component.mouseOverCursor >= 0) {
                            targetEndCursor = component.mouseOverCursor;
                        } else if (component.noClickThrough) {
                            targetEndCursor = -1;
                        }
                    }

                    if (!MiniMenu.open && hovered) {
                        addMiniMenuOptions(component, mouseX2 - startX, mouseX2 - startY);
                    }

                    @Pc(462) boolean pressedOver = false;
                    if (MouseMonitor.instance.isLeftDown() && hovered) {
                        pressedOver = true;
                    }

                    @Pc(474) boolean clicked = false;
                    @Pc(479) MouseLog log = (MouseLog) Static226.mouseLogs.first();
                    if (log != null && log.getType() == MouseLog.TYPE_PRESS_LEFT && log.getX() >= x1 && log.getY() >= y1 && log.getX() < x2 && log.getY() < y2) {
                        if (clickMask) {
                            @Pc(524) Graphic graphic = component.graphic(Toolkit.active);

                            if (graphic != null && graphic.scaleWidth == component.width && graphic.scaleHeight == component.height) {
                                @Pc(549) int x = log.getX() - startX;
                                @Pc(555) int y = log.getY() - startY;

                                if (y >= 0 && y < graphic.lineOffsets.length) {
                                    @Pc(569) int lineOffset = graphic.lineOffsets[y];

                                    if (x >= lineOffset && x <= lineOffset + graphic.lineWidths[y]) {
                                        clicked = true;
                                    }
                                }
                            } else {
                                clicked = true;
                            }
                        } else {
                            clicked = true;
                        }
                    }

                    if (component.opKeys != null && !debugconsole.isOpen()) {
                        for (@Pc(402) int key = 0; key < component.opKeys.length; key++) {
                            if (KeyboardMonitor.instance.isPressed(component.opKeys[key])) {
                                if (component.opKeysIgnoreHeld == null || TimeUtils.clock >= component.opKeysIgnoreHeld[key]) {
                                    @Pc(634) byte mask = component.opChars[key];

                                    if ((mask == 0) || ((((mask & 0x8) == 0) || (!KeyboardMonitor.instance.isPressed(86) && !KeyboardMonitor.instance.isPressed(82) && !KeyboardMonitor.instance.isPressed(81))) && (((mask & 0x2) == 0) || KeyboardMonitor.instance.isPressed(86)) && (((mask & 0x1) == 0) || KeyboardMonitor.instance.isPressed(82)) && (((mask & 0x4) == 0) || KeyboardMonitor.instance.isPressed(81)))) {
                                        if (key < 10) {
                                            ifButtonXSend(component.slot, -1, "", key + 1);
                                        } else if (key == 10) {
                                            endTargetMode();

                                            @Pc(726) ServerActiveProperties properties = serverActiveProperties(component);
                                            enterTargetMode(properties.getTargetMask(), component, properties.targetParam);

                                            targetVerb = getComponentTargetVerb(component);
                                            if (targetVerb == null) {
                                                targetVerb = "Null";
                                            }

                                            targetedVerb = component.opBase + "<col=ffffff>";
                                        }

                                        @Pc(555) int delay = component.opKeyRates[key];
                                        if (component.opKeysIgnoreHeld == null) {
                                            component.opKeysIgnoreHeld = new int[component.opKeys.length];
                                        }

                                        if (delay != 0) {
                                            component.opKeysIgnoreHeld[key] = TimeUtils.clock + delay;
                                        } else {
                                            component.opKeysIgnoreHeld[key] = Integer.MAX_VALUE;
                                        }
                                    }
                                }
                            } else if (component.opKeysIgnoreHeld != null) {
                                component.opKeysIgnoreHeld[key] = 0;
                            }
                        }
                    }

                    if (clicked) {
                        dragTryPickup(orthoDeltaY + log.getY() - startY, component, orthoDeltaX + log.getX() - startX);
                    }

                    if (dragSource != null && dragSource != component && hovered && serverActiveProperties(component).isDragTarget()) {
                        dragTarget = component;
                    }

                    if (component == dragLayer) {
                        aBoolean428 = true;
                        dragParentX = startX;
                        dragParentY = startY;
                    }

                    if (component.hasHook || component.clientcode != 0) {
                        if (hovered && Static611.mouseWheelRotation != 0 && component.onScrollWheel != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.mouseEvent = true;
                            hook.source = component;
                            hook.mouseY = Static611.mouseWheelRotation;
                            hook.arguments = component.onScrollWheel;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (dragSource != null) {
                            clicked = false;
                            pressedOver = false;
                        } else if (MiniMenu.open || (component.clientcode != ComponentClientCode.WORLD_MAP && MiniMenu.anInt6964 > 0)) {
                            clicked = false;
                            pressedOver = false;
                            hovered = false;
                        }

                        if (component.clientcode != 0) {
                            if (component.clientcode == ComponentClientCode.SCENE || component.clientcode == ComponentClientCode.LOGIN_SCENE) {
                                viewport = component;
                                if (Static456.aSkyBox_3 != null) {
                                    Static456.aSkyBox_3.method3168(ClientOptions.instance.skydetail.getValue(), component.height, Toolkit.active);
                                }

                                if (component.clientcode == ComponentClientCode.SCENE) {
                                    if (MiniMenu.open || mouseX2 < x1 || mouseY2 < y1 || mouseX2 >= x2 || mouseY2 >= y2) {
                                        continue;
                                    }

                                    MiniMenu.addEntries3DView(Toolkit.active, mouseX1, mouseY1);

                                    for (@Pc(991) Class8_Sub1 local991 = (Class8_Sub1) Static149.A_ENTITY_LIST___4.first(); local991 != null; local991 = (Class8_Sub1) Static149.A_ENTITY_LIST___4.next()) {
                                        if (mouseX2 >= local991.anInt108 && mouseX2 < local991.anInt109 && mouseY2 >= local991.anInt112 && mouseY2 < local991.anInt111) {
                                            MiniMenu.reset();
                                            MiniMenu.addEntityEntries(local991.aClass8_Sub2_Sub1_Sub2_1);
                                        }
                                    }
                                }
                            }

                            if (component.clientcode == ComponentClientCode.MINIMAP) {
                                @Pc(524) Graphic graphic = component.graphic(Toolkit.active);
                                if (graphic == null || Minimap.toggle != 0 && Minimap.toggle != 3 || MiniMenu.open || mouseX2 < x1 || mouseY2 < y1 || mouseX2 >= x2 || mouseY2 >= y2) {
                                    continue;
                                }

                                @Pc(549) int x = mouseX2 - startX;
                                @Pc(555) int y = mouseY2 - startY;
                                @Pc(569) int lineOffset = graphic.lineOffsets[y];
                                if (x < lineOffset || x > lineOffset + graphic.lineWidths[y]) {
                                    continue;
                                }

                                x -= component.width / 2;
                                y -= component.height / 2;

                                @Pc(1125) int yaw;
                                if (Camera.mode == CameraMode.MODE_FOUR) {
                                    yaw = (int) Camera.playerCameraYaw & 0x3FFF;
                                } else {
                                    yaw = (int) Camera.playerCameraYaw + Camera.yawOffset & 0x3FFF;
                                }

                                @Pc(1137) int sinYaw = Trig1.SIN[yaw];
                                @Pc(1141) int cosYaw = Trig1.COS[yaw];
                                if (Camera.mode != CameraMode.MODE_FOUR) {
                                    sinYaw = sinYaw * (Camera.scaleOffset + 256) >> 8;
                                    cosYaw = cosYaw * (Camera.scaleOffset + 256) >> 8;
                                }

                                @Pc(1170) int local1170 = ((y * sinYaw) + (x * cosYaw)) >> 14;
                                @Pc(1180) int local1180 = ((y * cosYaw) - (x * sinYaw)) >> 14;

                                @Pc(1191) int local1191;
                                @Pc(1199) int local1199;
                                if (Camera.mode == CameraMode.MODE_FOUR) {
                                    local1191 = (Camera.anInt6262 >> 9) + (local1170 >> 2);
                                    local1199 = (Camera.anInt4018 >> 9) - (local1180 >> 2);
                                } else {
                                    @Pc(1208) int local1208 = (PlayerEntity.self.getSize() - 1) * 256;
                                    local1191 = (PlayerEntity.self.x - local1208 >> 9) + (local1170 >> 2);
                                    local1199 = (PlayerEntity.self.z - local1208 >> 9) - (local1180 >> 2);
                                }

                                if (targetMode && (targetMask & TargetMask.TGT_GROUND) != 0) {
                                    @Pc(1243) Component target = InterfaceList.getComponent(targetComponent, targetSlot);

                                    if (target != null) {
                                        MiniMenu.addEntryInner(false, component.invObject, 1L, local1191, local1199, targetVerb, MiniMenuAction.TGT_GROUND, true, targetEnterCursor, " ->", (component.id << 0) | component.slot, true);
                                    } else {
                                        endTargetMode();
                                    }
                                } else {
                                    if (Client.modeGame == ModeGame.STELLAR_DAWN) {
                                        MiniMenu.addEntryInner(false, -1, 1L, local1191, local1199, LocalisedText.FACEHERE.localise(Client.language), MiniMenuAction.FACE_SQUARE, true, -1, "", 0L, true);
                                    }

                                    MiniMenu.addEntryInner(false, -1, 1L, local1191, local1199, Static331.moveText, MiniMenuAction.WALK, true, Static331.moveCursor, "", 0L, true);
                                }

                                continue;
                            }

                            if (component.clientcode == ComponentClientCode.WORLD_MAP) {
                                WorldMap.component = component;

                                if (hovered) {
                                    WorldMap.hovered = true;
                                }

                                if (clicked) {
                                    @Pc(402) int local402 = (int) ((double) (orthoDeltaX + log.getX() - startX - component.width / 2) * 2.0D / (double) WorldMap.currentZoom);
                                    @Pc(549) int local549 = (int) -((double) (orthoDeltaY + log.getY() - startY - component.height / 2) * 2.0D / (double) WorldMap.currentZoom);
                                    @Pc(555) int local555 = WorldMap.anInt2809 + local402 + WorldMap.areaX;
                                    @Pc(569) int local569 = WorldMap.anInt9389 + local549 + WorldMap.areaY;

                                    @Pc(1383) WorldMapArea area = WorldMap.getArea();
                                    if (area == null) {
                                        continue;
                                    }

                                    @Pc(1388) int[] local1388 = new int[3];
                                    area.method4091(local569, local555, local1388);

                                    if (local1388 != null) {
                                        int level = local1388[0];
                                        int y = local1388[2];
                                        int x = local1388[1];

                                        if (KeyboardMonitor.instance.isPressed(82) && Client.staffModLevel > 0) {
                                            Static624.teleport(level, y, x);
                                            continue;
                                        }

                                        WorldMap.clicked = true;
                                        WorldMap.clickedLevel = level;
                                        WorldMap.clickedX = x;
                                        WorldMap.clickedY = y;
                                    }

                                    MiniMenu.anInt6964 = 1;
                                    Static1.aBoolean821 = false;
                                    dragStartX = MouseMonitor.instance.getRecordedX();
                                    dragStartY = MouseMonitor.instance.getRecordedY();
                                    continue;
                                }

                                if (pressedOver && MiniMenu.anInt6964 > 0) {
                                    if (MiniMenu.anInt6964 == 1 && (dragStartX != MouseMonitor.instance.getRecordedX() || dragStartY != MouseMonitor.instance.getRecordedY())) {
                                        Static661.anInt6055 = WorldMap.anInt2809;
                                        Static417.anInt6399 = WorldMap.anInt9389;
                                        MiniMenu.anInt6964 = 2;
                                    }
                                    if (MiniMenu.anInt6964 == 2) {
                                        Static1.aBoolean821 = true;
                                        WorldMap.method8711(Static661.anInt6055 + (int) ((double) (dragStartX - MouseMonitor.instance.getRecordedX()) * 2.0D / (double) WorldMap.targetZoom));
                                        Static182.method2786(Static417.anInt6399 - (int) ((double) (dragStartY - MouseMonitor.instance.getRecordedY()) * 2.0D / (double) WorldMap.targetZoom));
                                    }
                                    continue;
                                }

                                if (MiniMenu.anInt6964 > 0 && !Static1.aBoolean821) {
                                    if ((Client.mouseButtons == 1 || MiniMenu.topEntryIsIfButtonX1()) && MiniMenu.innerEntryCount > 2) {
                                        MiniMenu.method6223(dragStartX, dragStartY);
                                    } else if (MiniMenu.isPopulated()) {
                                        MiniMenu.method6223(dragStartX, dragStartY);
                                    }
                                }

                                MiniMenu.anInt6964 = 0;
                                continue;
                            }

                            if (component.clientcode == ComponentClientCode.WORLD_MAP_OVERVIEW) {
                                if (pressedOver) {
                                    WorldMap.clickedOverview(component.width, orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX, orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY, component.height);
                                }
                                continue;
                            }

                            if (component.clientcode == ComponentClientCode.WORLD_MAP_OPTIONS) {
                                WorldMap.setOptions(startX, startY, component);
                                continue;
                            }
                        }

                        if (!component.clicked && clicked) {
                            component.clicked = true;

                            if (component.onClick != null) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.mouseEvent = true;
                                hook.source = component;
                                hook.mouseX = orthoDeltaX + log.getX() - startX;
                                hook.mouseY = orthoDeltaY + log.getY() - startY;
                                hook.arguments = component.onClick;
                                Static521.A_DEQUE___44.addLast(hook);
                            }
                        }

                        if (component.clicked && pressedOver && component.onClickRepeat != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.mouseEvent = true;
                            hook.source = component;
                            hook.mouseX = orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX;
                            hook.mouseY = orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY;
                            hook.arguments = component.onClickRepeat;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (component.clicked && !pressedOver) {
                            component.clicked = false;

                            if (component.onRelease != null) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.mouseEvent = true;
                                hook.source = component;
                                hook.mouseX = orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX;
                                hook.mouseY = orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY;
                                hook.arguments = component.onRelease;
                                Static59.A_DEQUE___33.addLast(hook);
                            }
                        }

                        if (pressedOver && component.onHold != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.mouseEvent = true;
                            hook.source = component;
                            hook.mouseX = orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX;
                            hook.mouseY = orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY;
                            hook.arguments = component.onHold;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (!component.hovered && hovered) {
                            component.hovered = true;

                            if (component.onMouseOver != null) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.mouseEvent = true;
                                hook.source = component;
                                hook.mouseX = orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX;
                                hook.mouseY = orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY;
                                hook.arguments = component.onMouseOver;
                                Static521.A_DEQUE___44.addLast(hook);
                            }
                        }

                        if (component.hovered && hovered && component.onMouseRepeat != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.mouseEvent = true;
                            hook.source = component;
                            hook.mouseX = orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX;
                            hook.mouseY = orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY;
                            hook.arguments = component.onMouseRepeat;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (component.hovered && !hovered) {
                            component.hovered = false;

                            if (component.onMouseLeave != null) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.mouseEvent = true;
                                hook.source = component;
                                hook.mouseX = orthoDeltaX + MouseMonitor.instance.getRecordedX() - startX;
                                hook.mouseY = orthoDeltaY + MouseMonitor.instance.getRecordedY() - startY;
                                hook.arguments = component.onMouseLeave;
                                Static59.A_DEQUE___33.addLast(hook);
                            }
                        }

                        if (component.onTimer != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onTimer;
                            Static618.A_DEQUE___68.addLast(hook);
                        }

                        if (component.onVarcTransmit != null && Static52.varcUpdateCount > component.lastVarcUpdate) {
                            if (component.varcTriggers == null || Static52.varcUpdateCount - component.lastVarcUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onVarcTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label768:
                                for (@Pc(402) int j = component.lastVarcUpdate; j < Static52.varcUpdateCount; j++) {
                                    @Pc(549) int local549 = Static278.anIntArray350[j & 0x1F];

                                    for (@Pc(555) int k = 0; k < component.varcTriggers.length; k++) {
                                        if (component.varcTriggers[k] == local549) {
                                            @Pc(2022) HookRequest hook = new HookRequest();
                                            hook.source = component;
                                            hook.arguments = component.onVarcTransmit;
                                            Static521.A_DEQUE___44.addLast(hook);
                                            break label768;
                                        }
                                    }
                                }
                            }

                            component.lastVarcUpdate = Static52.varcUpdateCount;
                        }

                        if (component.onVarcstrTransmit != null && Static455.varcstrUpdateCount > component.lastVarcstrUpdate) {
                            if (component.varcstrTriggers == null || Static455.varcstrUpdateCount - component.lastVarcstrUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onVarcstrTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label744:
                                for (@Pc(402) int j = component.lastVarcstrUpdate; j < Static455.varcstrUpdateCount; j++) {
                                    @Pc(549) int local549 = Static268.anIntArray332[j & 0x1F];

                                    for (@Pc(555) int k = 0; k < component.varcstrTriggers.length; k++) {
                                        if (component.varcstrTriggers[k] == local549) {
                                            @Pc(2022) HookRequest hook = new HookRequest();
                                            hook.source = component;
                                            hook.arguments = component.onVarcstrTransmit;
                                            Static521.A_DEQUE___44.addLast(hook);
                                            break label744;
                                        }
                                    }
                                }
                            }

                            component.lastVarcstrUpdate = Static455.varcstrUpdateCount;
                        }

                        if (component.onVarTransmit != null && Static635.varpUpdateCount > component.lastVarpUpdate) {
                            if (component.varpTriggers == null || Static635.varpUpdateCount - component.lastVarpUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onVarTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label720:
                                for (@Pc(402) int j = component.lastVarpUpdate; j < Static635.varpUpdateCount; j++) {
                                    @Pc(549) int local549 = Static142.anIntArray225[j & 0x1F];

                                    for (@Pc(555) int k = 0; k < component.varpTriggers.length; k++) {
                                        if (component.varpTriggers[k] == local549) {
                                            @Pc(2022) HookRequest hook = new HookRequest();
                                            hook.source = component;
                                            hook.arguments = component.onVarTransmit;
                                            Static521.A_DEQUE___44.addLast(hook);
                                            break label720;
                                        }
                                    }
                                }
                            }

                            component.lastVarpUpdate = Static635.varpUpdateCount;
                        }

                        if (component.onInvTransmit != null && ClientInventory.updateCount > component.lastInvUpdate) {
                            if (component.inventoryTriggers == null || ClientInventory.updateCount - component.lastInvUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onInvTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label696:
                                for (@Pc(402) int j = component.lastInvUpdate; j < ClientInventory.updateCount; j++) {
                                    @Pc(549) int local549 = ClientInventory.updates[j & 0x1F];

                                    for (@Pc(555) int k = 0; k < component.inventoryTriggers.length; k++) {
                                        if (component.inventoryTriggers[k] == local549) {
                                            @Pc(2022) HookRequest hook = new HookRequest();
                                            hook.source = component;
                                            hook.arguments = component.onInvTransmit;
                                            Static521.A_DEQUE___44.addLast(hook);
                                            break label696;
                                        }
                                    }
                                }
                            }

                            component.lastInvUpdate = ClientInventory.updateCount;
                        }

                        if (component.onStatTransmit != null && Static366.statUpdateCount > component.lastStatUpdate) {
                            if (component.statTriggers == null || Static366.statUpdateCount - component.lastStatUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onStatTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label672:
                                for (@Pc(402) int j = component.lastStatUpdate; j < Static366.statUpdateCount; j++) {
                                    @Pc(549) int local549 = Static395.statUpdates[j & 0x1F];

                                    for (@Pc(555) int k = 0; k < component.statTriggers.length; k++) {
                                        if (component.statTriggers[k] == local549) {
                                            @Pc(2022) HookRequest hook = new HookRequest();
                                            hook.source = component;
                                            hook.arguments = component.onStatTransmit;
                                            Static521.A_DEQUE___44.addLast(hook);
                                            break label672;
                                        }
                                    }
                                }
                            }

                            component.lastStatUpdate = Static366.statUpdateCount;
                        }

                        if (component.onVarclanTransmit != null && Static710.varclanUpdateCount > component.lastVarclanUpdate) {
                            if (component.varclanTriggers == null || Static710.varclanUpdateCount - component.lastVarclanUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onVarclanTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label648:
                                for (@Pc(402) int j = component.lastVarclanUpdate; j < Static710.varclanUpdateCount; j++) {
                                    @Pc(549) int local549 = Static265.varclanUpdates[j & 0x1F];

                                    for (@Pc(555) int k = 0; k < component.varclanTriggers.length; k++) {
                                        if (component.varclanTriggers[k] == local549) {
                                            @Pc(2022) HookRequest local2022 = new HookRequest();
                                            local2022.source = component;
                                            local2022.arguments = component.onVarclanTransmit;
                                            Static521.A_DEQUE___44.addLast(local2022);
                                            break label648;
                                        }
                                    }
                                }
                            }

                            component.lastVarclanUpdate = Static710.varclanUpdateCount;
                        }

                        if (ChatHistory.lastTransmit > component.lastScriptTransmit && component.onChatTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onChatTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (FriendsList.lastTransmit > component.lastScriptTransmit && component.onFriendTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onFriendTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (Static352.lastClanTransmit > component.lastScriptTransmit && component.onClanTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onClanTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (Static400.lastClanSettingsTransmit > component.lastScriptTransmit && component.onClanSettingsTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onClanSettingsTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (Static39.lastClanChannelTransmit > component.lastScriptTransmit && component.onClanChannelTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onClanChannelTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (StockmarketManager.lastTransmit > component.lastScriptTransmit && component.onStockTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onStockTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        if (Static321.lastMiscTransmit > component.lastScriptTransmit && component.onMiscTransmit != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onMiscTransmit;
                            Static521.A_DEQUE___44.addLast(hook);
                        }

                        component.lastScriptTransmit = World.tick;

                        if (component.onKey != null) {
                            for (@Pc(402) int j = 0; j < Static671.anInt10026; j++) {
                                @Pc(2682) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.anInt7216 = Static194.AN_KEYBOARD_EVENT_ARRAY_1[j].getKeyCode();
                                hook.anInt7221 = Static194.AN_KEYBOARD_EVENT_ARRAY_1[j].getKeyChar();
                                hook.arguments = component.onKey;
                                Static521.A_DEQUE___44.addLast(hook);
                            }
                        }

                        if (Camera.splineFinished && component.onCamFinished != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onCamFinished;
                            Static521.A_DEQUE___44.addLast(hook);
                        }
                    }

                    if (component.type == Component.TYPE_GRAPHIC && component.skyBox != -1) {
                        component.skyBox(SkyBoxSphereTypeList.instance, SkyBoxTypeList.instance).method3168(ClientOptions.instance.skydetail.getValue(), component.height, Toolkit.active);
                    }

                    Static542.prefetchSprite(component);

                    if (component.type == 0) {
                        logicComponentList(components, component.slot, x1, y1, x2, y2, startX - component.scrollX, startY - component.scrollY, mouseX1, mouseY1, mouseX2, mouseY2);

                        if (component.dynamicComponents != null) {
                            logicComponentList(component.dynamicComponents, component.slot, x1, y1, x2, y2, startX - component.scrollX, startY - component.scrollY, mouseX1, mouseY1, mouseX2, mouseY2);
                        }

                        @Pc(2824) SubInterface sub = (SubInterface) subInterfaces.get(component.slot);
                        if (sub != null) {
                            if (Client.modeGame == ModeGame.RUNESCAPE && sub.type == Component.TYPE_LAYER && !MiniMenu.open && hovered && !testOpacity) {
                                MiniMenu.reset();
                            }

                            mainLogic(sub.id, x1, y1, mouseX2, y2, startX, startY, mouseX1, mouseY1, mouseY2, x2);
                        }
                    }
                }
            } else if (x1 < x2 && y1 < y2) {
                Static542.prefetchSprite(component);
            }
        }
    }

    @OriginalMember(owner = "client!sfa", name = "a", descriptor = "(Lclient!hda;Z)Lclient!hda;")
    public static Component getServerDragLayer(@OriginalArg(0) Component arg0) {
        @Pc(15) Component local15 = Static84.method1657(arg0);
        if (local15 == null) {
            local15 = arg0.aComponent_6;
        }
        return local15;
    }

    @OriginalMember(owner = "client!dn", name = "a", descriptor = "(IIILjava/lang/String;I)V")
    public static void ifButtonXSend(@OriginalArg(1) int component, @OriginalArg(2) int idAndSlot, @OriginalArg(3) String arg2, @OriginalArg(4) int op) {
        @Pc(8) Component button = InterfaceList.getComponent(idAndSlot, component);
        if (button == null) {
            return;
        }

        if (button.onOp != null) {
            @Pc(19) HookRequest hook = new HookRequest();
            hook.arguments = button.onOp;
            hook.anInt7219 = op;
            hook.aString84 = arg2;
            hook.source = button;
            ScriptRunner.executeHookInner(hook);
        }

        if (MainLogicManager.step != 11 || !serverActiveProperties(button).isOpEnabled(op - 1)) {
            return;
        }

        if (op == 1) {
            @Pc(64) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON1, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 2) {
            @Pc(64) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON2, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 3) {
            @Pc(64) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON3, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 4) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON4, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 5) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON5, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 6) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON6, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 7) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON7, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 8) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON8, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 9) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON9, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        } else if (op == 10) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON10, ServerConnection.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ServerConnection.GAME.send(message);
        }
    }

    @OriginalMember(owner = "client!md", name = "a", descriptor = "(IBLclient!hda;I)V")
    public static void enterTargetMode(@OriginalArg(0) int targetMask, @OriginalArg(2) Component target, @OriginalArg(3) int targetParam) {
        if (target == null) {
            return;
        }

        if (target.onTargetEnter != null) {
            @Pc(14) HookRequest hook = new HookRequest();
            hook.source = target;
            hook.arguments = target.onTargetEnter;
            ScriptRunner.executeHookInner(hook);
        }

        InterfaceManager.targetInvObj = target.invObject;
        InterfaceManager.targetSlot = target.slot;
        InterfaceManager.targetMode = true;
        InterfaceManager.targetParam = targetParam;
        InterfaceManager.targetEnterCursor = target.targetEnterCursor;
        InterfaceManager.targetComponent = target.id;
        InterfaceManager.targetEndCursor = target.targetEndCursor;
        InterfaceManager.targetMask = targetMask;
        redraw(target);
    }

    @OriginalMember(owner = "client!or", name = "h", descriptor = "(I)V")
    public static void endTargetMode() {
        if (!targetMode) {
            return;
        }

        @Pc(14) Component target = InterfaceList.getComponent(InterfaceManager.targetComponent, InterfaceManager.targetSlot);
        if (target != null && target.onTargetLeave != null) {
            @Pc(25) HookRequest hook = new HookRequest();
            hook.arguments = target.onTargetLeave;
            hook.source = target;
            ScriptRunner.executeHookInner(hook);
        }

        InterfaceManager.targetEndCursor = -1;
        InterfaceManager.targetMode = false;
        InterfaceManager.targetInvObj = -1;

        if (target != null) {
            redraw(target);
        }
    }

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "(ILclient!hda;ZI)V")
    public static void dragTryPickup(@OriginalArg(0) int dragStartY, @OriginalArg(1) Component dragSource, @OriginalArg(3) int dragStartX) {
        if (InterfaceManager.dragSource != null || MiniMenu.open || (dragSource == null || getServerDragLayer(dragSource) == null)) {
            return;
        }

        InterfaceManager.dragSource = dragSource;
        InterfaceManager.dragLayer = getServerDragLayer(dragSource);
        InterfaceManager.dragStartY = dragStartY;
        InterfaceManager.dragStartX = dragStartX;
        InterfaceManager.dragging = false;
        InterfaceManager.dragTicks = 0;
    }

    @OriginalMember(owner = "client!nk", name = "a", descriptor = "(IIIIIIIIIIII)V")
    public static void mainLogic(@OriginalArg(8) int id, @OriginalArg(11) int parentX1, @OriginalArg(3) int parentY1, @OriginalArg(10) int mouseX2, @OriginalArg(0) int parentY2, @OriginalArg(7) int scrollDeltaX, @OriginalArg(1) int scrollDeltaY, @OriginalArg(9) int mouseX1, @OriginalArg(4) int mouseY1, @OriginalArg(5) int mouseY2, @OriginalArg(6) int parentX2) {
        if (!InterfaceList.load(id)) {
            return;
        }

        if (InterfaceList.cache[id] == null) {
            logicComponentList(InterfaceList.interfaces[id], -1, parentX1, parentY1, parentX2, parentY2, scrollDeltaX, scrollDeltaY, mouseX1, mouseY1, mouseX2, mouseY2);
        } else {
            logicComponentList(InterfaceList.cache[id], -1, parentX1, parentY1, parentX2, parentY2, scrollDeltaX, scrollDeltaY, mouseX1, mouseY1, mouseX2, mouseY2);
        }
    }

    @OriginalMember(owner = "client!nw", name = "a", descriptor = "(Lclient!hda;II)Ljava/lang/String;")
    public static String getOp(@OriginalArg(0) Component component, @OriginalArg(1) int op) {
        if (serverActiveProperties(component).isOpEnabled(op) || component.onOp != null) {
            if (component.ops != null && op < component.ops.length && component.ops[op] != null && component.ops[op].trim().length() != 0) {
                return component.ops[op];
            } else {
                return testOpacity ? "Hidden-" + op : null;
            }
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!lv", name = "a", descriptor = "(Lclient!hda;B)Ljava/lang/String;")
    public static String getComponentTargetVerb(@OriginalArg(0) Component component) {
        if (serverActiveProperties(component).getTargetMask() != 0) {
            if (component.targetVerb != null && component.targetVerb.trim().length() != 0) {
                return component.targetVerb;
            } else {
                return testOpacity ? "Hidden-use" : null;
            }
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIIZ)Lclient!aha;")
    public static SubInterface openSubInterface(@OriginalArg(0) int type, @OriginalArg(1) int id, @OriginalArg(2) int idAndSlot, @OriginalArg(4) boolean scripted) {
        @Pc(7) SubInterface sub = new SubInterface();
        sub.id = id;
        sub.type = type;
        subInterfaces.put(idAndSlot, sub);

        restartInterfaceAnims(id);

        @Pc(26) Component parent = InterfaceList.list(idAndSlot);
        if (parent != null) {
            redraw(parent);
        }

        if (dialog != null) {
            redraw(dialog);
            dialog = null;
        }

        MiniMenu.openButtons();

        if (parent != null) {
            calculateLayerDimensions(parent, !scripted);
        }

        if (!scripted) {
            ScriptRunner.executeOnLoad(id);
        }

        if (!scripted && topLevelInterface != -1) {
            runHookImmediate(IMMEDIATE_HOOK_TYPE_SUBCHANGE, topLevelInterface);
        }

        return sub;
    }

    @OriginalMember(owner = "client!dq", name = "a", descriptor = "(II)V")
    public static void restartInterfaceAnims(@OriginalArg(0) int id) {
        if (!InterfaceList.load(id)) {
            return;
        }

        @Pc(13) Component[] children = InterfaceList.interfaces[id];
        for (@Pc(15) int i = 0; i < children.length; i++) {
            @Pc(20) Component child = children[i];

            if (child != null && child.animator != null) {
                child.animator.resetImmediately();
            }
        }
    }

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(III)V")
    public static void runHookImmediate(@OriginalArg(1) int type, @OriginalArg(2) int id) {
        if (InterfaceList.load(id)) {
            runHookImmediate(InterfaceList.interfaces[id], type);
        }
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "([Lclient!hda;II)V")
    public static void runHookImmediate(@OriginalArg(0) Component[] children, @OriginalArg(2) int type) {
        for (@Pc(1) int i = 0; i < children.length; i++) {
            @Pc(11) Component child = children[i];
            if (child == null) {
                continue;
            }

            if (child.type == Component.TYPE_LAYER) {
                if (child.dynamicComponents != null) {
                    runHookImmediate(child.dynamicComponents, type);
                }

                @Pc(38) SubInterface sub = (SubInterface) subInterfaces.get(child.slot);
                if (sub != null) {
                    runHookImmediate(type, sub.id);
                }
            }

            @Pc(58) HookRequest hook;
            if (type == IMMEDIATE_HOOK_TYPE_DIALOGABORT && child.onDialogAbort != null) {
                hook = new HookRequest();
                hook.source = child;
                hook.arguments = child.onDialogAbort;
                ScriptRunner.executeHookInner(hook);
            }

            if (type == IMMEDIATE_HOOK_TYPE_SUBCHANGE && child.onSubChange != null) {
                if (child.id >= 0) {
                    @Pc(88) Component sub = InterfaceList.list(child.slot);

                    if (sub == null || sub.staticComponents == null || sub.staticComponents.length <= child.id || sub.staticComponents[child.id] != child) {
                        continue;
                    }
                }

                hook = new HookRequest();
                hook.source = child;
                hook.arguments = child.onSubChange;
                ScriptRunner.executeHookInner(hook);
            }
        }
    }

    @OriginalMember(owner = "client!eda", name = "a", descriptor = "(Lclient!hda;BZ)V")
    public static void calculateLayerDimensions(@OriginalArg(0) Component layer, @OriginalArg(2) boolean execScript) {
        @Pc(16) int width = layer.scrollWidth == 0 ? layer.width : layer.scrollWidth;
        @Pc(37) int height = layer.scrollHeight == 0 ? layer.height : layer.scrollHeight;

        calculateComponentListDimensions(width, execScript, height, InterfaceList.interfaces[layer.slot >> 16], layer.slot);

        if (layer.dynamicComponents != null) {
            calculateComponentListDimensions(width, execScript, height, layer.dynamicComponents, layer.slot);
        }

        @Pc(72) SubInterface sub = (SubInterface) subInterfaces.get(layer.slot);
        if (sub != null) {
            calculateComponentListDimensions(execScript, sub.id, height, width);
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(ZIIII)V")
    public static void calculateComponentListDimensions(@OriginalArg(0) boolean execScript, @OriginalArg(1) int arg1, @OriginalArg(3) int height, @OriginalArg(4) int width) {
        if (InterfaceList.load(arg1)) {
            calculateComponentListDimensions(width, execScript, height, InterfaceList.interfaces[arg1], -1);
        }
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(ZIZI[Lclient!hda;I)V")
    public static void calculateComponentListDimensions(@OriginalArg(1) int width, @OriginalArg(2) boolean execScript, @OriginalArg(3) int height, @OriginalArg(4) Component[] children, @OriginalArg(5) int parent) {
        for (@Pc(5) int i = 0; i < children.length; i++) {
            @Pc(14) Component child = children[i];

            if (child != null && child.layer == parent) {
                resize(execScript, height, width, child);
                calculateDimensions(child, width, height, -8525);

                if (child.scrollX > child.scrollWidth - child.width) {
                    child.scrollX = child.scrollWidth - child.width;
                }
                if (child.scrollX < 0) {
                    child.scrollX = 0;
                }
                if (child.scrollY > child.scrollHeight - child.height) {
                    child.scrollY = child.scrollHeight - child.height;
                }
                if (child.scrollY < 0) {
                    child.scrollY = 0;
                }

                if (child.type == Component.TYPE_LAYER) {
                    calculateLayerDimensions(child, execScript);
                }
            }
        }
    }

    @OriginalMember(owner = "client!pw", name = "a", descriptor = "(ZIIILclient!hda;)V")
    public static void resize(@OriginalArg(0) boolean execScript, @OriginalArg(1) int parentHeight, @OriginalArg(3) int parentWidth, @OriginalArg(4) Component component) {
        @Pc(6) int width = component.width;
        @Pc(16) int height = component.height;

        if (component.sizeTypeHorizontal == 0) {
            component.width = component.baseWidth;
        } else if (component.sizeTypeHorizontal == 1) {
            component.width = parentWidth - component.baseWidth;
        } else if (component.sizeTypeHorizontal == 2) {
            component.width = (component.baseWidth * parentWidth) >> 14;
        }

        if (component.sizeTypeVertical == 0) {
            component.height = component.baseHeight;
        } else if (component.sizeTypeVertical == 1) {
            component.height = parentHeight - component.baseHeight;
        } else if (component.sizeTypeVertical == 2) {
            component.height = (parentHeight * component.baseHeight) >> 14;
        }

        if (component.sizeTypeHorizontal == 4) {
            component.width = component.aspectRatioHeight * component.height / component.aspectRatioWidth;
        }

        if (component.sizeTypeVertical == 4) {
            component.height = component.width * component.aspectRatioWidth / component.aspectRatioHeight;
        }

        if (testOpacity && (serverActiveProperties(component).events != 0 || component.type == Component.TYPE_LAYER)) {
            if (component.height < 5 && component.width < 5) {
                component.height = 5;
                component.width = 5;
            } else {
                if (component.width <= 0) {
                    component.width = 5;
                }
                if (component.height <= 0) {
                    component.height = 5;
                }
            }
        }

        if (component.clientcode == ComponentClientCode.SCENE) {
            viewport = component;
        }

        if (execScript && component.onResize != null && (width != component.width || height != component.height)) {
            @Pc(225) HookRequest hook = new HookRequest();
            hook.arguments = component.onResize;
            hook.source = component;
            Static521.A_DEQUE___44.addLast(hook);
        }
    }

    @OriginalMember(owner = "client!or", name = "a", descriptor = "(Lclient!hda;III)V")
    public static void calculateDimensions(@OriginalArg(0) Component component, @OriginalArg(1) int width, @OriginalArg(2) int height, @OriginalArg(3) int arg3) {
        if (component.postTypeVertical == 0) {
            component.positionY = component.basePosY;
        } else if (component.postTypeVertical == 1) {
            component.positionY = component.basePosY + ((height - component.height) / 2);
        } else if (component.postTypeVertical == 2) {
            component.positionY = height - component.height - component.basePosY;
        } else if (component.postTypeVertical == 3) {
            component.positionY = (component.basePosY * height) >> 14;
        } else if (component.postTypeVertical == 4) {
            component.positionY = ((height - component.height) / 2) + ((height * component.basePosY) >> 14);
        } else {
            component.positionY = height - ((component.basePosY * height) >> 14) - component.height;
        }

        if (component.posTypeHorizontal == 0) {
            component.positionX = component.basePosX;
        } else if (component.posTypeHorizontal == 1) {
            component.positionX = component.basePosX + ((width - component.width) / 2);
        } else if (component.posTypeHorizontal == 2) {
            component.positionX = width - component.width - component.basePosX;
        } else if (component.posTypeHorizontal == 3) {
            component.positionX = (component.basePosX * width) >> 14;
        } else if (component.posTypeHorizontal == 4) {
            component.positionX = ((width - component.width) / 2) + ((width * component.basePosX) >> 14);
        } else {
            component.positionX = width - ((width * component.basePosX) >> 14) - component.width;
        }

        if (testOpacity && (serverActiveProperties(component).events != 0 || component.type == Component.TYPE_LAYER)) {
            if (component.positionX < 0) {
                component.positionX = 0;
            } else if (width < component.width + component.positionX) {
                component.positionX = width - component.width;
            }

            if (component.positionY < 0) {
                component.positionY = 0;
            } else if (component.positionY + component.height > height) {
                component.positionY = height - component.height;
            }
        }
    }

    @OriginalMember(owner = "client!mt", name = "a", descriptor = "(IIIZI)V")
    public static void changeWindowMode(@OriginalArg(1) int mode, @OriginalArg(2) int width, @OriginalArg(3) boolean modeDifferent, @OriginalArg(4) int height) {
        Static498.method6646();
        Static297.aLong153 = 0L;

        @Pc(10) int current = getWindowMode();
        if (mode == WindowMode.FULLSCREEN || current == WindowMode.FULLSCREEN) {
            modeDifferent = true;
        }
        if (!Toolkit.active.method7983()) {
            modeDifferent = true;
        }

        windowModeChanged(current, height, mode, width, modeDifferent);
    }

    @OriginalMember(owner = "client!li", name = "a", descriptor = "(IIIIIZ)V")
    public static void windowModeChanged(@OriginalArg(0) int oldMode, @OriginalArg(1) int height, @OriginalArg(2) int newMode, @OriginalArg(4) int width, @OriginalArg(5) boolean modeChanged) {
        if (GameShell.fsframe != null && (newMode != WindowMode.FULLSCREEN || width != GameShell.fullscreenWidth || height != GameShell.fullscreenHeight)) {
            exitFullscreen(GameShell.signLink, GameShell.fsframe);
            GameShell.fsframe = null;
        }

        if (newMode == WindowMode.FULLSCREEN && GameShell.fsframe == null) {
            GameShell.fsframe = createFullscreenFrame(GameShell.signLink, width, height, 0, 0);

            if (GameShell.fsframe != null) {
                GameShell.fullscreenWidth = width;
                GameShell.fullscreenHeight = height;
                ClientOptions.save();
            }
        }

        if (newMode == WindowMode.FULLSCREEN && GameShell.fsframe == null) {
            windowModeChanged(oldMode, -1, ClientOptions.instance.screenSizeDefault.getValue(), -1, true);
            return;
        }

        @Pc(95) Container topContainer;
        if (GameShell.fsframe != null) {
            GameShell.frameHei = height;
            GameShell.frameWid = width;
            topContainer = GameShell.fsframe;
        } else if (GameShell.frame != null) {
            @Pc(110) Insets insets = GameShell.frame.getInsets();
            GameShell.frameWid = GameShell.frame.getSize().width - insets.right - insets.left;

            @Pc(126) int negativeTop = -insets.top;
            GameShell.frameHei = GameShell.frame.getSize().height + negativeTop - insets.bottom;

            topContainer = GameShell.frame;
        } else {
            if (GameShell.loaderApplet == null) {
                topContainer = GameShell.instance;
            } else {
                topContainer = GameShell.loaderApplet;
            }

            GameShell.frameWid = topContainer.getSize().width;
            GameShell.frameHei = topContainer.getSize().height;
        }

        if (newMode == WindowMode.FIXED) {
            GameShell.topMargin = 0;
            GameShell.leftMargin = (GameShell.frameWid - Client.loadingScreenWidth) / 2;
            GameShell.canvasHei = Client.loadingScreenHeight;
            GameShell.canvasWid = Client.loadingScreenWidth;
        } else {
            method4625();
        }

        if (Client.modeWhere != ModeWhere.LIVE) {
            @Pc(178) boolean tooSmall;
            if (GameShell.canvasWid < 1024 && GameShell.canvasHei < 768) {
                tooSmall = true;
            } else {
                tooSmall = false;
            }
        }

        if (modeChanged) {
            Static574.method7572();
        } else {
            GameShell.canvas.setSize(GameShell.canvasWid, GameShell.canvasHei);

            if (aBoolean210) {
                Static575.method7606(GameShell.canvas);
            } else {
                Toolkit.active.method7935(GameShell.canvas, GameShell.canvasWid, GameShell.canvasHei);
            }

            if (topContainer == GameShell.frame) {
                @Pc(110) Insets local110 = GameShell.frame.getInsets();
                GameShell.canvas.setLocation(GameShell.leftMargin + local110.left, GameShell.topMargin + local110.top);
            } else {
                GameShell.canvas.setLocation(GameShell.leftMargin, GameShell.topMargin);
            }
        }

        if (newMode >= WindowMode.RESIZABLE) {
            resizableScreen = true;
        } else {
            resizableScreen = false;
        }

        if (topLevelInterface != -1) {
            refreshTopLevelInterface(true);
        }

        if (ServerConnection.GAME.connection != null && MainLogicStep.isAtGameScreen(MainLogicManager.step)) {
            Protocol.sendWindowStatus();
        }

        for (@Pc(258) int i = 0; i < 100; i++) {
            dirtyRectangles[i] = true;
        }

        GameShell.fullredraw = true;
    }

    @OriginalMember(owner = "client!uda", name = "a", descriptor = "(IZ)V")
    public static void refreshTopLevelInterface(@OriginalArg(1) boolean id) {
        calculateComponentListDimensions(id, topLevelInterface, GameShell.canvasHei, GameShell.canvasWid);
    }

    @OriginalMember(owner = "client!nea", name = "a", descriptor = "(ILclient!hda;II)V")
    public static void addMiniMenuOptions(@OriginalArg(1) Component component, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        if (targetMode) {
            @Pc(16) ParamType param = targetParam == -1 ? null : ParamTypeList.instance.list(targetParam);

            if (serverActiveProperties(component).isUseTarget() && (targetMask & TargetMask.TGT_BUTTON) != 0 && (param == null || component.param(param.defaultint, targetParam) != param.defaultint)) {
                MiniMenu.addEntryInner(false, component.invObject, 0L, component.id, component.slot, targetVerb, MiniMenuAction.IF_BUTTONT, true, targetEnterCursor, targetedVerb + " -> " + component.opBase, (component.id << 0) | component.slot, false);
            }
        }

        for (@Pc(97) int i = 9; i >= 5; i--) {
            @Pc(106) String op = getOp(component, i);

            if (op != null) {
                MiniMenu.addEntryInner(false, component.invObject, i + 1, component.id, component.slot, op, MiniMenuAction.IF_BUTTONX2, true, opCursor(i, component), component.opBase, (component.id << 0) | component.slot, false);
            }
        }

        @Pc(106) String targetVerb = getComponentTargetVerb(component);
        if (targetVerb != null) {
            MiniMenu.addEntryInner(false, component.invObject, 0L, component.id, component.slot, targetVerb, MiniMenuAction.TGT_BUTTON, true, component.targetOpCursor, component.opBase, (component.id << 0) | component.slot, false);
        }

        for (@Pc(193) int i = 4; i >= 0; i--) {
            @Pc(204) String op = getOp(component, i);

            if (op != null) {
                MiniMenu.addEntryInner(false, component.invObject, i + 1, component.id, component.slot, op, MiniMenuAction.IF_BUTTONX1, true, opCursor(i, component), component.opBase, (component.id << 0) | component.slot, false);
            }
        }

        if (serverActiveProperties(component).isPauseButton()) {
            if (component.pauseText == null) {
                MiniMenu.addEntryInner(false, component.invObject, 0L, component.id, component.slot, LocalisedText.CONTINUE.localise(Client.language), MiniMenuAction.PAUSE_BUTTON, true, -1, "", (component.id << 0) | component.slot, false);
            } else {
                MiniMenu.addEntryInner(false, component.invObject, 0L, component.id, component.slot, component.pauseText, MiniMenuAction.PAUSE_BUTTON, true, -1, "", (component.id << 0) | component.slot, false);
            }
        }
    }

    @OriginalMember(owner = "client!ln", name = "a", descriptor = "(ILclient!hda;I)I")
    public static int opCursor(@OriginalArg(0) int op, @OriginalArg(1) Component component) {
        if (!serverActiveProperties(component).isOpEnabled(op) && component.onOp == null) {
            return -1;
        } else if (component.opCursors == null || op >= component.opCursors.length) {
            return -1;
        } else {
            return component.opCursors[op];
        }
    }

    @OriginalMember(owner = "client!oh", name = "a", descriptor = "(IZ)V")
    public static void openLogin(@OriginalArg(1) boolean unloaded) {
        if (unloaded) {
            if (topLevelInterface != -1) {
                discard(topLevelInterface);
            }

            for (@Pc(21) SubInterface sub = (SubInterface) subInterfaces.first(); sub != null; sub = (SubInterface) subInterfaces.next()) {
                if (!sub.isLinked()) {
                    sub = (SubInterface) subInterfaces.first();

                    if (sub == null) {
                        break;
                    }
                }

                closeSubInterface(sub, true, false);
            }

            topLevelInterface = -1;
            subInterfaces = new IterableHashTable(8);
            InterfaceList.reset();
            topLevelInterface = GraphicsDefaults.instance.login_interface;
            refreshTopLevelInterface(false);
            redrawAll();
            ScriptRunner.executeOnLoad(topLevelInterface);
        }

        Static300.method4389();
        lobbyOpened = false;
        MiniMenu.setCancelEntry();
        targetEndCursor = -1;
        Static115.method2136(Cursor.dflt);
        PlayerEntity.self = new PlayerEntity();
        PlayerEntity.self.z = Static501.mapLength * 512 / 2;
        PlayerEntity.self.x = Static720.mapWidth * 512 / 2;
        PlayerEntity.self.pathX[0] = Static720.mapWidth / 2;
        Camera.z = 0;
        Camera.x = 0;
        PlayerEntity.self.pathZ[0] = Static501.mapLength / 2;

        if (Camera.mode == CameraMode.MODE_FIXED) {
            Camera.z = Camera.moveToZ << 9;
            Camera.x = Camera.moveToX << 9;
        } else {
            Camera.splineTick();
        }

        loginOpened();
    }

    @OriginalMember(owner = "client!go", name = "a", descriptor = "(I)V")
    public static void loginOpened() {
        loginOpened = true;
    }

    @OriginalMember(owner = "client!as", name = "a", descriptor = "(ZZ)V")
    public static void openLobby(@OriginalArg(0) boolean unloaded) {
        if (unloaded) {
            if (topLevelInterface != -1) {
                discard(topLevelInterface);
            }

            for (@Pc(16) SubInterface sub = (SubInterface) subInterfaces.first(); sub != null; sub = (SubInterface) subInterfaces.next()) {
                if (!sub.isLinked()) {
                    sub = (SubInterface) subInterfaces.first();

                    if (sub == null) {
                        break;
                    }
                }

                closeSubInterface(sub, true, false);
            }

            topLevelInterface = -1;
            subInterfaces = new IterableHashTable(8);
            InterfaceList.reset();
            topLevelInterface = GraphicsDefaults.instance.lobby_interface;
            refreshTopLevelInterface(false);
            redrawAll();
            ScriptRunner.executeOnLoad(topLevelInterface);
        }

        lobbyOpened = true;
    }

    @OriginalMember(owner = "client!ku", name = "a", descriptor = "(IZ)V")
    public static void discard(@OriginalArg(0) int id) {
        if (id != -1 && InterfaceList.loaded[id]) {
            Component.interfacesJs5.discardUnpacked(id);
            InterfaceList.interfaces[id] = null;
            InterfaceList.cache[id] = null;
            InterfaceList.loaded[id] = false;
        }
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(BZZLclient!aha;)V")
    public static void closeSubInterface(@OriginalArg(3) SubInterface sub, @OriginalArg(2) boolean discard, @OriginalArg(1) boolean fromClient) {
        @Pc(6) int subId = sub.id;
        @Pc(10) int idAndSlot = (int) sub.key;
        sub.unlink();

        if (discard) {
            discard(subId);
        }

        resetServerActiveProperties(subId);

        @Pc(27) Component inter = InterfaceList.list(idAndSlot);
        if (inter != null) {
            redraw(inter);
        }

        MiniMenu.openButtons();

        if (!fromClient && topLevelInterface != -1) {
            runHookImmediate(IMMEDIATE_HOOK_TYPE_SUBCHANGE, topLevelInterface);
        }

        @Pc(55) HashTableIterator iterator = new HashTableIterator(subInterfaces);
        for (@Pc(60) SubInterface child = (SubInterface) iterator.first(); child != null; child = (SubInterface) iterator.next()) {
            if (!child.isLinked()) {
                child = (SubInterface) iterator.first();

                if (child == null) {
                    break;
                }
            }

            if (child.type == SubInterfaceType.OVERLAY_CLIENT) {
                @Pc(84) int key = (int) child.key;

                if (subId == key >>> 16) {
                    closeSubInterface(child, true, fromClient);
                }
            }
        }
    }

    private InterfaceManager() {
        /* empty */
    }

    @OriginalMember(owner = "client!ci", name = "a", descriptor = "(IZ)V")
    public static void method1557() {
        @Pc(13) ClientMessage local13 = ClientMessage.create(ClientProt.CLOSE_MODAL, ServerConnection.GAME.cipher);
        ServerConnection.GAME.send(local13);
        for (@Pc(22) SubInterface local22 = (SubInterface) subInterfaces.first(); local22 != null; local22 = (SubInterface) subInterfaces.next()) {
            if (!local22.isLinked()) {
                local22 = (SubInterface) subInterfaces.first();
                if (local22 == null) {
                    break;
                }
            }
            if (local22.type == 0) {
                closeSubInterface(local22, true, true);
            }
        }
        if (dialog != null) {
            redraw(dialog);
            dialog = null;
        }
    }

    @OriginalMember(owner = "client!un", name = "a", descriptor = "(Lclient!vq;ILjava/awt/Frame;)V")
    public static void exitFullscreen(@OriginalArg(0) SignLink signLink, @OriginalArg(2) Frame frame) {
        while (true) {
            @Pc(10) SignedResource resource = signLink.exitFullscreen(frame);
            while (resource.status == SignedResourceStatus.IDLE) {
                TimeUtils.sleep(10L);
            }

            if (resource.status == SignedResourceStatus.SUCCESS) {
                frame.setVisible(false);
                frame.dispose();
                return;
            }

            TimeUtils.sleep(100L);
        }
    }

    @OriginalMember(owner = "client!ph", name = "a", descriptor = "(ILclient!vq;IIII)Ljava/awt/Frame;")
    public static Frame createFullscreenFrame(@OriginalArg(1) SignLink signlink, @OriginalArg(4) int width, @OriginalArg(3) int height, @OriginalArg(0) int oldWidth, @OriginalArg(2) int oldHeight) {
        if (!signlink.supportsFullscreen()) {
            return null;
        }

        @Pc(18) DisplayProperties[] properties = SignLink.getDisplayProperties(signlink, true);
        if (properties == null) {
            return null;
        }

        @Pc(25) boolean found = false;
        for (@Pc(27) int i = 0; i < properties.length; i++) {
            if (properties[i].width == width && properties[i].height == height && (oldHeight == 0 || oldHeight == properties[i].oldHeight) && (!found || properties[i].oldWidth > oldWidth)) {
                found = true;
                oldWidth = properties[i].oldWidth;
            }
        }

        if (!found) {
            return null;
        }

        @Pc(101) SignedResource resource = signlink.enterFullscreen(width, height, oldWidth, oldHeight);
        while (resource.status == SignedResourceStatus.IDLE) {
            TimeUtils.sleep(10L);
        }

        @Pc(112) Frame frame = (Frame) resource.result;
        if (frame == null) {
            return null;
        } else if (resource.status == SignedResourceStatus.ERROR) {
            exitFullscreen(signlink, frame);
            return null;
        } else {
            return frame;
        }
    }

    @OriginalMember(owner = "client!kda", name = "a", descriptor = "(I)V")
    public static void method4625() {
        @Pc(5) int maxScreenSize = 0;
        if (ClientOptions.instance != null) {
            maxScreenSize = ClientOptions.instance.maxScreenSize.getValue();
        }

        if (maxScreenSize == MaxScreenSize._800x600) {
            @Pc(34) int local34 = GameShell.frameWid <= 800 ? GameShell.frameWid : 800;
            GameShell.leftMargin = (GameShell.frameWid - local34) / 2;
            GameShell.canvasWid = local34;
            @Pc(51) int local51 = GameShell.frameHei <= 600 ? GameShell.frameHei : 600;
            GameShell.topMargin = 0;
            GameShell.canvasHei = local51;
        } else if (maxScreenSize == MaxScreenSize._1024x768) {
            @Pc(34) int local34 = GameShell.frameWid <= 1024 ? GameShell.frameWid : 1024;
            GameShell.canvasWid = local34;
            @Pc(51) int local51 = GameShell.frameHei <= 768 ? GameShell.frameHei : 768;
            GameShell.leftMargin = (GameShell.frameWid - local34) / 2;
            GameShell.canvasHei = local51;
            GameShell.topMargin = 0;
        } else {
            GameShell.topMargin = 0;
            GameShell.canvasHei = GameShell.frameHei;
            GameShell.canvasWid = GameShell.frameWid;
            GameShell.leftMargin = 0;
        }
    }

    @OriginalMember(owner = "client!nfa", name = "a", descriptor = "(IIIII)V")
    public static void method5773(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        for (@Pc(5) int i = 0; i < rectangleCount; i++) {
            @Pc(10) Rectangle rectangle = rectangles[i];
            if (arg0 < rectangle.x + rectangle.width && rectangle.x < arg2 + arg0 && rectangle.height + rectangle.y > arg1 && rectangle.y < arg1 + arg3) {
                flipDirtyRect[i] = true;
            }
        }
        Static682.method8927(arg1, arg3 + arg1, arg0, arg0 + arg2);
    }
}
