import com.jagex.core.constants.ComponentClientCode;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.constants.WindowMode;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.LocalisedText;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.iftype.DragRender;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.objtype.ObjType;
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
import rs2.client.event.mouse.MouseLog;
import rs2.client.event.mouse.MouseMonitor;

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
    public static boolean targeting = false;

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

    @OriginalMember(owner = "client!el", name = "R", descriptor = "[[Lclient!hda;")
    public static Component[][] cache;

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

            @Pc(125) int posX = offsetX + child.positionX;
            @Pc(130) int posY = offsetY + child.positionY;

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
                    posX = mouseX;

                    if (dragParentY + dragLayer.height < mouseY + child.height) {
                        mouseY = dragParentY + dragLayer.height - child.height;
                    }
                    posY = mouseY;
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
                @Pc(317) int local317 = posX + child.width;
                @Pc(323) int local323 = posY + child.height;

                if (child.type == Component.TYPE_LINE) {
                    local323++;
                    local317++;
                }

                y1 = arg4 >= posY ? arg4 : posY;
                x1 = posX > arg3 ? posX : arg3;
                x2 = arg8 <= local317 ? arg8 : local317;
                y2 = local323 < arg5 ? local323 : arg5;
            }

            if (x2 > x1 && y2 > y1) {
                if (child.clientcode != 0) {
                    if (child.clientcode == ComponentClientCode.SCENE || child.clientcode == ComponentClientCode.LOGIN_SCENE) {
                        setOptions(posY, posX, child);

                        if (!aBoolean210) {
                            Static294.method4339(posY, child.clientcode == ComponentClientCode.LOGIN_SCENE, child.width, child.height, posX);
                            Toolkit.active.KA(arg3, arg4, arg8, arg5);
                        }

                        dirtyRectangles[rectangle] = true;
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.MINIMAP && CutsceneManager.state == 0) {
                        if (child.graphic(Toolkit.active) != null) {
                            Static557.method7331();
                            Minimap.draw(posY, Toolkit.active, child, posX);
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
                        ColourChooser.drawHue(child, posX, posY, Toolkit.active);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.COLOUR_CHOOSER_SATURATION_VALUE) {
                        ColourChooser.drawSaturationValue(Toolkit.active, child.colour % 64, child, posX, posY);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.COMPASS) {
                        if (child.graphic(Toolkit.active) != null) {
                            Minimap.drawCompass(child, posX, posY);
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
                        WorldMap.draw(child.height, posX, posY, Static56.anTextureSource_3, Toolkit.active, child.width);
                        dirtyRectangles[rectangle] = true;
                        Toolkit.active.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.WORLD_MAP_OVERVIEW) {
                        WorldMap.drawOverview(child.width, Toolkit.active, child.height, posX, posY);
                        dirtyRectangles[rectangle] = true;
                        Toolkit.active.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY) {
                        if (!Static105.displayFps && !Static354.showProfiling) {
                            continue;
                        }

                        @Pc(317) int drawX = posX + child.width;
                        @Pc(323) int drawY = posY + 15;

                        if (aBoolean210) {
                            if (arg7) {
                                Static682.method8927(boundsBottom, boundsTop, boundsLeft, boundsRight);
                            } else {
                                Static595.method7810(boundsBottom, boundsRight, boundsTop, boundsLeft);
                            }
                        }

                        if (Static105.displayFps) {
                            @Pc(744) int fpsColour = 0xFFFFFF00;
                            if (Static652.currentFps < 20) {
                                fpsColour = 0xFFFF0000;
                            }

                            Fonts.p12.render(drawX, "Fps:" + Static652.currentFps, fpsColour, -1, drawY);
                            drawY += 15;

                            @Pc(768) Runtime runtime = Runtime.getRuntime();
                            @Pc(777) int memoryUsage = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                            @Pc(779) int memoryColour = 0xFFFFFF00;
                            if (memoryUsage > 0x18000) {
                                if (Static473.force64mb) {
                                    Static664.cacheRemoveSoftReferences();

                                    for (@Pc(792) int j = 0; j < 10; j++) {
                                        System.gc();
                                    }

                                    memoryUsage = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);

                                    if (memoryUsage > 65536) {
                                        Static67.method6098("WARNING: Memory usage over 64MB! Please inform whoever is responsible for the content/area you are using/in.");
                                    }
                                }

                                memoryColour = 0xFFFF0000;
                            }

                            Fonts.p12.render(drawX, "Mem:" + memoryUsage + "k", memoryColour, 0xFFFFFFFF, drawY);
                            drawY += 15;

                            Fonts.p12.render(drawX, "Game: In:" + ConnectionManager.GAME.readRate + "B/s Out:" + ConnectionManager.GAME.writeRate + "B/s", 0xFFFFFF00, 0xFFFFFFFF, drawY);
                            drawY += 15;

                            Fonts.p12.render(drawX, "Lobby: In:" + ConnectionManager.LOBBY.readRate + "B/s Out:" + ConnectionManager.LOBBY.writeRate + "B/s", 0xFFFFFF00, 0xFFFFFFFF, drawY);
                            drawY += 15;

                            @Pc(792) int offheap = Toolkit.active.E() / 1024;
                            Fonts.p12.render(drawX, "Offheap:" + offheap + "k", offheap > 65536 ? 0xFFFF0000 : 0xFFFFFF00, -1, drawY);
                            drawY += 15;

                            @Pc(936) int entryTotal = 0;
                            @Pc(938) int loadedTotal = 0;
                            @Pc(940) int extrasTotal = 0;
                            for (@Pc(942) int archive = 0; archive < 37; archive++) {
                                if (client.js5ResourceProviders[archive] != null) {
                                    entryTotal += client.js5ResourceProviders[archive].entryCount();
                                    loadedTotal += client.js5ResourceProviders[archive].loadedCount();
                                    extrasTotal += client.js5ResourceProviders[archive].extrasCount();
                                }
                            }

                            @Pc(986) int extrasPercentage = (extrasTotal * 100) / entryTotal;
                            @Pc(992) int totalPercentage = (loadedTotal * 10000) / entryTotal;

                            @Pc(1018) String cache = "Cache:" + StringTools.formatNumber(0, true, totalPercentage, 2) + "% (" + extrasPercentage + "%)";
                            Fonts.p11.render(drawX, cache, 0xFFFFFF00, 0xFFFFFFFF, drawY);
                            drawY += 12;
                        }

                        if (ParticleManager.particleCount > 0) {
                            Fonts.p11.render(drawX, "Particles: " + ParticleManager.runningParticleCount + " / " + ParticleManager.particleCount, 0xFFFFFF00, 0xFFFFFFFF, drawY);
                        }
                        drawY += 12;

                        if (Static354.showProfiling) {
                            Fonts.p11.render(drawX, "Polys: " + Toolkit.active.I() + " Models: " + Toolkit.active.M(), 0xFFFFFF00, 0xFFFFFFFF, drawY);
                            drawY += 12;

                            Fonts.p11.render(drawX, "Ls: " + Static606.anInt8954 + " La: " + Static577.anInt8587 + " NPC: " + Static480.npcCount + " Pl: " + Static179.playerCount, 0xFFFFFF00, 0xFFFFFFFF, drawY);
                            Static126.method2228();
                            drawY += 12;
                        }

                        dirtyRectangles[rectangle] = true;
                        continue;
                    }
                }

                if (child.type == Component.TYPE_LAYER) {
                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER && Toolkit.active.method8014()) {
                        Toolkit.active.method7959(posX, posY, child.width, child.height);
                    }

                    draw(child.slot, posX - child.scrollX, children, x1, y1, y2, rectangle, arg7, x2, posY - child.scrollY);

                    if (child.dynamicComponents != null) {
                        draw(child.slot, posX - child.scrollX, child.dynamicComponents, x1, y1, y2, rectangle, arg7, x2, posY - child.scrollY);
                    }

                    @Pc(1214) SubInterface sub = (SubInterface) subInterfaces.get(child.slot);
                    if (sub != null) {
                        draw(sub.id, x1, x2, y1, posY, rectangle, posX, y2);
                    }

                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER) {
                        if (Toolkit.active.method8014()) {
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
                                Toolkit.active.fillRect(x2 - x1, -y1 + y2, y1, x1, blue << 16 | alpha << 24 | red << 8 | green);
                            }
                        }
                    }

                    Toolkit.active.KA(arg3, arg4, arg8, arg5);
                }

                if (currentlyDirtyRect[rectangle] || rectDebug > 1) {
                    if (child.type == Component.TYPE_RECTANGLE) {
                        if (transparency == 0) {
                            if (child.filled) {
                                Toolkit.active.aa(posX, posY, child.width, child.height, child.colour, 0);
                            } else {
                                Toolkit.active.method7976(posX, posY, child.width, child.height, child.colour, 0);
                            }
                        } else {
                            if (child.filled) {
                                Toolkit.active.aa(posX, posY, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
                            } else {
                                Toolkit.active.method7976(posX, posY, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
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
                                @Pc(1543) ObjType objType = Static419.objTypeList.list(child.invObject);
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
                                text = LocalisedText.PLEASEWAIT.localise(Static51.language);
                                colour = child.colour;
                            }

                            if (clipComponents) {
                                Toolkit.active.T(posX, posY, posX + child.width, child.height + posY);
                            }

                            font.renderLines(child.verticalAlignment, colour | ((255 - (transparency & 0xFF)) << 24), child.textShadow ? 255 - (transparency & 0xFF) << 24 : -1, Static679.aSpriteArray14, child.maxLines, 0, posY, child.height, 0, null, child.lineHeight, child.width, posX, child.horizontalAlignment, null, text);

                            if (clipComponents) {
                                Toolkit.active.KA(arg3, arg4, arg8, arg5);
                            }

                            if (text.trim().length() > 0) {
                                if (!clipComponents) {
                                    @Pc(1730) FontMetrics metrics = Fonts.metrics(child.fontGraphic, Toolkit.active);
                                    @Pc(777) int textWidth = metrics.paraWidth(Static679.aSpriteArray14, text, child.width);
                                    @Pc(779) int textHeight = metrics.stringHeight(child.width, child.lineHeight, text, Static679.aSpriteArray14);

                                    if (aBoolean210) {
                                        if (arg7) {
                                            Static682.method8927(posY, posY + textHeight, posX, posX + textWidth);
                                        } else {
                                            Static595.method7810(posY, posX + textWidth, textHeight + posY, posX);
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
                            child.skyBox(Static99.skyBoxSphereTypeList, Static324.skyBoxTypeList).method3162(Toolkit.active, posY, posX, child.width, child.anInt3815 << 3, child.anInt3786 << 3, child.height);
                        } else {
                            @Pc(1816) Sprite sprite;
                            if (child.invObject != -1) {
                                @Pc(1836) PlayerModel model = child.objWearCol ? PlayerEntity.self.playerModel : null;
                                sprite = Static419.objTypeList.getCachedSprite(model, Toolkit.active, child.objNumMode, child.invObject, child.outline, child.invCount, child.shadow | 0xFF000000);
                            } else if (child.video != -1) {
                                sprite = VideoTypeList.sprite(child.video, Toolkit.active);
                            } else {
                                sprite = child.sprite(Toolkit.active);
                            }

                            if (sprite != null) {
                                @Pc(323) int scaleWidth = sprite.scaleWidth();
                                @Pc(744) int scaleHeight = sprite.scaleHeight();
                                @Pc(1255) int backgroundColour = ((255 - (transparency & 0xFF)) << 24) | ((child.colour != 0) ? (child.colour & 0xFFFFFF) : 0xFFFFFF);

                                if (child.tiled) {
                                    Toolkit.active.T(posX, posY, posX + child.width, posY - -child.height);

                                    if (child.angle2d != 0) {
                                        @Pc(777) int newWidth = (child.width + scaleWidth - 1) / scaleWidth;
                                        @Pc(779) int newHeight = (child.height + scaleHeight - 1) / scaleHeight;

                                        for (@Pc(792) int x = 0; x < newWidth; x++) {
                                            for (@Pc(936) int y = 0; y < newHeight; y++) {
                                                if (child.colour != 0) {
                                                    sprite.method8187((float) (x * scaleWidth + posX) + ((float) scaleWidth / 2.0F), (float) scaleHeight / 2.0F + (float) (y * scaleHeight + posY), 4096, child.angle2d, backgroundColour);
                                                } else {
                                                    sprite.method8186((float) (x * scaleWidth + posX) + ((float) scaleWidth / 2.0F), (float) (posY + scaleHeight * y) + (float) scaleHeight / 2.0F, 4096, child.angle2d);
                                                }
                                            }
                                        }
                                    } else {
                                        if (child.colour != 0 || transparency != 0) {
                                            sprite.method8189(posX, posY, child.width, child.height, 0, backgroundColour, 1);
                                        } else {
                                            sprite.method8198(posX, posY, child.width, child.height);
                                        }
                                    }

                                    Toolkit.active.KA(arg3, arg4, arg8, arg5);
                                } else {
                                    if (child.colour != 0 || transparency != 0) {
                                        if (child.angle2d != 0) {
                                            sprite.method8187(((float) child.width / 2.0F) + (float) posX, (float) child.height / 2.0F + (float) posY, child.width * 4096 / scaleWidth, child.angle2d, backgroundColour);
                                        } else if (scaleWidth == child.width && scaleHeight == child.height) {
                                            sprite.render(posX, posY, 0, backgroundColour, 1);
                                        } else {
                                            sprite.render(posX, posY, child.width, child.height, 0, backgroundColour, 1);
                                        }
                                    } else {
                                        if (child.angle2d != 0) {
                                            sprite.method8186(((float) child.width / 2.0F) + (float) posX, (float) posY + (float) child.height / 2.0F, child.width * 4096 / scaleWidth, child.angle2d);
                                        } else if (scaleWidth == child.width && scaleHeight == child.height) {
                                            sprite.render(posX, posY);
                                        } else {
                                            sprite.render(posX, posY, child.width, child.height);
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
                            @Pc(1543) ObjType objType = Static419.objTypeList.list(child.invObject);
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
                                    model = player.playerModel.bodyModel(Static419.objTypeList, child.animator, Static574.basTypeList, Static25.seqTypeList, 2048, null, Static523.wearposDefaults, Static68.idkTypeList, Toolkit.active, Static690.aNPCTypeList_2, null, 0, null, TimedVarDomain.instance);
                                }
                            }
                        } else if (child.objType == Component.OBJ_TYPE_INVENTORY_MALE || child.objType == Component.OBJ_TYPE_INVENTORY_FEMALE) {
                            @Pc(2468) ClientInventory inventory = Static556.method7303(child.obj, false);

                            if (inventory != null) {
                                model = inventory.method3078(child.objData, Toolkit.active, child.objType == Component.OBJ_TYPE_INVENTORY_FEMALE, child.animator, child.objWearCol ? PlayerEntity.self.playerModel : null);
                            }
                        } else if (child.animator != null && child.animator.isAnimating()) {
                            model = child.model(Toolkit.active, child.animator, Static574.basTypeList, Static68.idkTypeList, Static25.seqTypeList, PlayerEntity.self.playerModel, TimedVarDomain.instance, Static690.aNPCTypeList_2, Static419.objTypeList, 2048, customisation);

                            if (model == null && Component.redrawAll) {
                                redraw(child);
                            }
                        } else {
                            model = child.model(Toolkit.active, null, Static574.basTypeList, Static68.idkTypeList, Static25.seqTypeList, PlayerEntity.self.playerModel, TimedVarDomain.instance, Static690.aNPCTypeList_2, Static419.objTypeList, 2048, customisation);

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

                            @Pc(779) int local779 = child.width / 2 + posX;
                            @Pc(792) int local792 = child.height / 2 + posY;
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
                                Toolkit.active.T(posX, posY, posX + child.width, child.height + posY);
                            }

                            if (child.orthoView) {
                                if (child.modelOrtho) {
                                    model.renderOrtho(Static59.aMatrix_5, null, child.modelZoom, 1);
                                } else {
                                    model.render(Static59.aMatrix_5, null, 1);

                                    if (child.particleSystem != null) {
                                        Toolkit.active.method8021(child.particleSystem.method3650());
                                    }
                                }
                            } else {
                                if (child.modelOrtho) {
                                    model.renderOrtho(Static59.aMatrix_5, null, child.modelZoom << 2, 1);
                                } else {
                                    model.render(Static59.aMatrix_5, null, 1);

                                    if (child.particleSystem != null) {
                                        Toolkit.active.method8021(child.particleSystem.method3650());
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
                            local323 = child.height + posY;
                            local1255 = posY;
                            local744 = posX + child.width;
                        } else {
                            local1255 = child.height + posY;
                            local323 = posY;
                            local744 = posX + child.width;
                        }

                        if (child.lineWidth != 1) {
                            Toolkit.active.method7947(posX, local323, local744, local1255, child.colour, child.lineWidth);
                        } else {
                            Toolkit.active.method7951(posX, local323, local744, local1255, child.colour, 0);
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
        @Pc(17) int local17;
        if (InterfaceList.load(arg0)) {
            local17 = 0;
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
            if (cache[arg0] == null) {
                draw(-1, arg6, InterfaceList.interfaces[arg0], arg1, arg3, arg7, arg5, arg5 < 0, arg2, arg4);
            } else {
                draw(-1, arg6, cache[arg0], arg1, arg3, arg7, arg5, arg5 < 0, arg2, arg4);
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
            for (local17 = 0; local17 < 100; local17++) {
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

    @OriginalMember(owner = "client!lg", name = "b", descriptor = "(II)Ljava/lang/String;")
    public static String invText(@OriginalArg(1) int count) {
        @Pc(8) String text = Integer.toString(count);
        for (@Pc(13) int i = text.length() - 3; i > 0; i -= 3) {
            text = text.substring(0, i) + "," + text.substring(i);
        }

        if (text.length() > 9) {
            return " <col=00ff80>" + text.substring(0, text.length() - 8) + LocalisedText.MILLION.localise(Static51.language) + " (" + text + ")</col>";
        } else if (text.length() > 6) {
            return " <col=ffffff>" + text.substring(0, text.length() - 4) + LocalisedText.THOUSAND.localise(Static51.language) + " (" + text + ")</col>";
        } else {
            return " <col=ffff00>" + text + "</col>";
        }
    }

    @OriginalMember(owner = "client!vn", name = "a", descriptor = "(JI)V")
    public static void method7930(@OriginalArg(0) long arg0) {
        if (Static334.activeTiles != null) {
            if (Static511.anInt7645 == 1 || Static511.anInt7645 == 5) {
                Static604.method7903(arg0);
            } else if (Static511.anInt7645 == 4) {
                Static349.method5121(arg0);
            }
        }

        ParticleManager.method2421(TimeUtils.clock, Toolkit.active);

        if (topLevelInterface != -1) {
            animate(topLevelInterface);
        }

        for (@Pc(54) int i = 0; i < boundaryCount; i++) {
            if (dirtyRectangles[i]) {
                flipDirtyRect[i] = true;
            }

            currentlyDirtyRect[i] = dirtyRectangles[i];
            dirtyRectangles[i] = false;
        }

        lastDrawCycle = TimeUtils.clock;
        setOptions(-1, -1, null);

        if (topLevelInterface != -1) {
            boundaryCount = 0;
            method3833();
        }

        Toolkit.active.la();
        Static676.method8859(Toolkit.active);

        @Pc(116) int cursor = Static679.method8909();
        if (cursor == -1) {
            cursor = targetEndCursor;
        }
        if (cursor == -1) {
            cursor = Cursor.dflt;
        }

        Static115.method2136(cursor);
        @Pc(136) int size = PlayerEntity.self.boundSize((byte) 70) << 8;
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
        ParticleManager.method2421(TimeUtils.clock, Toolkit.active);
        if (topLevelInterface != -1) {
            animate(topLevelInterface);
        }
        for (@Pc(23) int local23 = 0; local23 < boundaryCount; local23++) {
            if (dirtyRectangles[local23]) {
                flipDirtyRect[local23] = true;
            }
            currentlyDirtyRect[local23] = dirtyRectangles[local23];
            dirtyRectangles[local23] = false;
        }
        lastDrawCycle = TimeUtils.clock;
        if (topLevelInterface != -1) {
            boundaryCount = 0;
            method3833();
        }
        Toolkit.active.la();
        Static676.method8859(Toolkit.active);
        @Pc(77) int local77 = Static679.method8909();
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
    public static void logicComponentList(@OriginalArg(0) Component[] components, @OriginalArg(1) int layer, @OriginalArg(2) int parentX1, @OriginalArg(3) int parentY1, @OriginalArg(4) int parentX2, @OriginalArg(5) int parentY2, @OriginalArg(6) int scrollDeltaX, @OriginalArg(7) int scrollDeltaY, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int mouseX2, @OriginalArg(11) int arg11) {
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
                    if (component.noClickThrough && mouseX2 >= x1 && arg11 >= y1 && mouseX2 < x2 && arg11 < y2) {
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

                        Static460.anInt6964 = 0;
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

                    if (!targeting && hovered) {
                        if (component.mouseOverCursor >= 0) {
                            targetEndCursor = component.mouseOverCursor;
                        } else if (component.noClickThrough) {
                            targetEndCursor = -1;
                        }
                    }

                    if (!MiniMenu.open && hovered) {
                        MiniMenu.addMiniMenuOptions(component, mouseX2 - startX, mouseX2 - startY);
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
                            if (KeyMonitor.instance.isPressed(component.opKeys[key])) {
                                if (component.opKeysIgnoreHeld == null || TimeUtils.clock >= component.opKeysIgnoreHeld[key]) {
                                    @Pc(634) byte mask = component.opChars[key];

                                    if ((mask == 0) || ((((mask & 0x8) == 0) || (!KeyMonitor.instance.isPressed(86) && !KeyMonitor.instance.isPressed(82) && !KeyMonitor.instance.isPressed(81))) && (((mask & 0x2) == 0) || KeyMonitor.instance.isPressed(86)) && (((mask & 0x1) == 0) || KeyMonitor.instance.isPressed(82)) && (((mask & 0x4) == 0) || KeyMonitor.instance.isPressed(81)))) {
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
                        } else if (MiniMenu.open || component.clientcode != ComponentClientCode.WORLD_MAP && Static460.anInt6964 > 0) {
                            clicked = false;
                            pressedOver = false;
                            hovered = false;
                        }

                        if (component.clientcode != 0) {
                            if (component.clientcode == ComponentClientCode.SCENE || component.clientcode == ComponentClientCode.LOGIN_SCENE) {
                                viewport = component;
                                if (Static456.aSkyBox_3 != null) {
                                    Static456.aSkyBox_3.method3168(Static400.instance.skydetail.value(), component.height, Toolkit.active);
                                }

                                if (component.clientcode == ComponentClientCode.SCENE) {
                                    if (MiniMenu.open || mouseX2 < x1 || arg11 < y1 || mouseX2 >= x2 || arg11 >= y2) {
                                        continue;
                                    }

                                    MiniMenu.addEntries3DView(arg9, arg8, Toolkit.active);

                                    for (@Pc(991) Class8_Sub1 local991 = (Class8_Sub1) Static149.A_ENTITY_LIST___4.first(); local991 != null; local991 = (Class8_Sub1) Static149.A_ENTITY_LIST___4.next()) {
                                        if (mouseX2 >= local991.anInt108 && mouseX2 < local991.anInt109 && arg11 >= local991.anInt112 && arg11 < local991.anInt111) {
                                            MiniMenu.reset();
                                            MiniMenu.addEntityEntries(local991.aClass8_Sub2_Sub1_Sub2_1);
                                        }
                                    }
                                }
                            }

                            if (component.clientcode == ComponentClientCode.MINIMAP) {
                                @Pc(524) Graphic graphic = component.graphic(Toolkit.active);
                                if (graphic == null || Minimap.toggle != 0 && Minimap.toggle != 3 || MiniMenu.open || mouseX2 < x1 || arg11 < y1 || mouseX2 >= x2 || arg11 >= y2) {
                                    continue;
                                }

                                @Pc(549) int local549 = mouseX2 - startX;
                                @Pc(555) int local555 = arg11 - startY;
                                @Pc(569) int local569 = graphic.lineOffsets[local555];
                                if (local549 < local569 || local549 > local569 + graphic.lineWidths[local555]) {
                                    continue;
                                }

                                local549 -= component.width / 2;
                                local555 -= component.height / 2;

                                @Pc(1125) int local1125;
                                if (Static511.anInt7645 == 4) {
                                    local1125 = (int) Static171.aFloat64 & 0x3FFF;
                                } else {
                                    local1125 = (int) Static171.aFloat64 + Static29.anInt723 & 0x3FFF;
                                }

                                @Pc(1137) int local1137 = Trig1.SIN[local1125];
                                @Pc(1141) int local1141 = Trig1.COS[local1125];
                                if (Static511.anInt7645 != 4) {
                                    local1137 = local1137 * (Static660.anInt9835 + 256) >> 8;
                                    local1141 = local1141 * (Static660.anInt9835 + 256) >> 8;
                                }

                                @Pc(1170) int local1170 = local555 * local1137 + local549 * local1141 >> 14;
                                @Pc(1180) int local1180 = local555 * local1141 - local549 * local1137 >> 14;

                                @Pc(1191) int local1191;
                                @Pc(1199) int local1199;
                                if (Static511.anInt7645 == 4) {
                                    local1191 = (Static433.anInt6262 >> 9) + (local1170 >> 2);
                                    local1199 = (Static249.anInt4018 >> 9) - (local1180 >> 2);
                                } else {
                                    @Pc(1208) int local1208 = (PlayerEntity.self.boundSize((byte) 83) - 1) * 256;
                                    local1191 = (PlayerEntity.self.x - local1208 >> 9) + (local1170 >> 2);
                                    local1199 = (PlayerEntity.self.z - local1208 >> 9) - (local1180 >> 2);
                                }

                                if (targeting && (targetMask & 0x40) != 0) {
                                    @Pc(1243) Component local1243 = InterfaceList.getComponent(targetComponent, targetSlot);

                                    if (local1243 == null) {
                                        endTargetMode();
                                    } else {
                                        MiniMenu.addEntry(false, component.invObject, 1L, local1191, local1199, targetVerb, 21, true, targetEnterCursor, " ->", (component.id << 0) | component.slot, true);
                                    }
                                } else {
                                    if (client.modeGame == ModeGame.STELLAR_DAWN) {
                                        MiniMenu.addEntry(false, -1, 1L, local1191, local1199, LocalisedText.FACEHERE.localise(Static51.language), 11, true, -1, "", 0L, true);
                                    }

                                    MiniMenu.addEntry(false, -1, 1L, local1191, local1199, Static331.walkText, 58, true, Static331.walkCursor, "", 0L, true);
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
                                    @Pc(555) int local555 = Static164.anInt2809 + local402 + WorldMap.areaX;
                                    @Pc(569) int local569 = Static615.anInt9389 + local549 + WorldMap.areaY;

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

                                        if (KeyMonitor.instance.isPressed(82) && Static608.staffModLevel > 0) {
                                            Static624.teleport(level, y, x);
                                            continue;
                                        }

                                        WorldMap.clicked = true;
                                        WorldMap.clickedLevel = level;
                                        WorldMap.clickedX = x;
                                        WorldMap.clickedY = y;
                                    }

                                    Static460.anInt6964 = 1;
                                    Static1.aBoolean821 = false;
                                    dragStartX = MouseMonitor.instance.getRecordedX();
                                    dragStartY = MouseMonitor.instance.getRecordedY();
                                    continue;
                                }

                                if (pressedOver && Static460.anInt6964 > 0) {
                                    if (Static460.anInt6964 == 1 && (dragStartX != MouseMonitor.instance.getRecordedX() || dragStartY != MouseMonitor.instance.getRecordedY())) {
                                        Static661.anInt6055 = Static164.anInt2809;
                                        Static417.anInt6399 = Static615.anInt9389;
                                        Static460.anInt6964 = 2;
                                    }
                                    if (Static460.anInt6964 == 2) {
                                        Static1.aBoolean821 = true;
                                        Static669.method8711(Static661.anInt6055 + (int) ((double) (dragStartX - MouseMonitor.instance.getRecordedX()) * 2.0D / (double) WorldMap.targetZoom));
                                        Static182.method2786(Static417.anInt6399 - (int) ((double) (dragStartY - MouseMonitor.instance.getRecordedY()) * 2.0D / (double) WorldMap.targetZoom));
                                    }
                                    continue;
                                }

                                if (Static460.anInt6964 > 0 && !Static1.aBoolean821) {
                                    if ((Static219.mouseButtons == 1 || MiniMenu.topEntryIsIfButtonX1()) && MiniMenu.optionCount > 2) {
                                        Static455.method6223(dragStartX, dragStartY);
                                    } else if (MiniMenu.isPopulated()) {
                                        Static455.method6223(dragStartX, dragStartY);
                                    }
                                }

                                Static460.anInt6964 = 0;
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

                        if (component.onInvTransmit != null && Static451.invUpdateCount > component.lastInvUpdate) {
                            if (component.inventoryTriggers == null || Static451.invUpdateCount - component.lastInvUpdate > 32) {
                                @Pc(877) HookRequest hook = new HookRequest();
                                hook.source = component;
                                hook.arguments = component.onInvTransmit;
                                Static521.A_DEQUE___44.addLast(hook);
                            } else {
                                label696:
                                for (@Pc(402) int j = component.lastInvUpdate; j < Static451.invUpdateCount; j++) {
                                    @Pc(549) int local549 = Static322.anIntArray889[j & 0x1F];

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

                            component.lastInvUpdate = Static451.invUpdateCount;
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
                                    @Pc(549) int local549 = Static395.anIntArray833[j & 0x1F];

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
                                    @Pc(549) int local549 = Static265.anIntArray328[j & 0x1F];

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

                        if (Static344.lastFriendTransmit > component.lastScriptTransmit && component.onFriendTransmit != null) {
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

                        if (Static526.lastStockTransmit > component.lastScriptTransmit && component.onStockTransmit != null) {
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
                                hook.anInt7216 = Static194.anInterface27Array1[j].method2664();
                                hook.anInt7221 = Static194.anInterface27Array1[j].method2666();
                                hook.arguments = component.onKey;
                                Static521.A_DEQUE___44.addLast(hook);
                            }
                        }

                        if (Static272.camFinished && component.onCamFinished != null) {
                            @Pc(877) HookRequest hook = new HookRequest();
                            hook.source = component;
                            hook.arguments = component.onCamFinished;
                            Static521.A_DEQUE___44.addLast(hook);
                        }
                    }

                    if (component.type == Component.TYPE_GRAPHIC && component.skyBox != -1) {
                        component.skyBox(Static99.skyBoxSphereTypeList, Static324.skyBoxTypeList).method3168(Static400.instance.skydetail.value(), component.height, Toolkit.active);
                    }

                    Static542.prefetchSprite(component);

                    if (component.type == 0) {
                        logicComponentList(components, component.slot, x1, y1, x2, y2, startX - component.scrollX, startY - component.scrollY, arg8, arg9, mouseX2, arg11);

                        if (component.dynamicComponents != null) {
                            logicComponentList(component.dynamicComponents, component.slot, x1, y1, x2, y2, startX - component.scrollX, startY - component.scrollY, arg8, arg9, mouseX2, arg11);
                        }

                        @Pc(2824) SubInterface sub = (SubInterface) subInterfaces.get(component.slot);
                        if (sub != null) {
                            if (client.modeGame == ModeGame.RUNESCAPE && sub.type == Component.TYPE_LAYER && !MiniMenu.open && hovered && !testOpacity) {
                                MiniMenu.reset();
                            }

                            mainLogic(y2, startY, y1, arg9, arg11, x2, startX, sub.id, arg8, mouseX2, x1);
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
            @Pc(64) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON1, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 2) {
            @Pc(64) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON2, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 3) {
            @Pc(64) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON3, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 4) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON4, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 5) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON5, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 6) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON6, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 7) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON7, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 8) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON8, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 9) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON9, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
        } else if (op == 10) {
            @Pc(148) ClientMessage message = ClientMessage.create(ClientProt.IF_BUTTON10, ConnectionManager.GAME.cipher);
            ClientMessage.addComponentData(component, button.invObject, message, idAndSlot);
            ConnectionManager.GAME.send(message);
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
        InterfaceManager.targeting = true;
        InterfaceManager.targetParam = targetParam;
        InterfaceManager.targetEnterCursor = target.targetEnterCursor;
        InterfaceManager.targetComponent = target.id;
        InterfaceManager.targetEndCursor = target.targetEndCursor;
        InterfaceManager.targetMask = targetMask;
        redraw(target);
    }

    @OriginalMember(owner = "client!or", name = "h", descriptor = "(I)V")
    public static void endTargetMode() {
        if (!targeting) {
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
        InterfaceManager.targeting = false;
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
    public static void mainLogic(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) int arg10) {
        if (!InterfaceList.load(arg7)) {
            return;
        }

        if (cache[arg7] == null) {
            logicComponentList(InterfaceList.interfaces[arg7], -1, arg10, arg2, arg5, arg0, arg6, arg1, arg8, arg3, arg9, arg4);
        } else {
            logicComponentList(cache[arg7], -1, arg10, arg2, arg5, arg0, arg6, arg1, arg8, arg3, arg9, arg4);
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

        MiniMenu.method1840();

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

    private InterfaceManager() {
        /* empty */
    }
}
