import com.jagex.core.constants.ComponentClientCode;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.LocalisedText;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.iftype.DragRender;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Model;
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

    @OriginalMember(owner = "client!lt", name = "D", descriptor = "I")
    public static int dragStartX = 0;

    @OriginalMember(owner = "client!en", name = "m", descriptor = "I")
    public static int dragStartY = 0;

    @OriginalMember(owner = "client!ld", name = "e", descriptor = "Lclient!hda;")
    public static Component dragParent = null;

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
                if (parent != 0xabcdabcd && (child.dragRenderBehaviour == DragRender.OFFSET || child.dragRenderBehaviour == DragRender.OFFSET_TRANSPARENT)) {
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

                    if (dragParentX + dragParent.width < mouseX - -child.width) {
                        mouseX = dragParentX + dragParent.width - child.width;
                    }
                    posX = mouseX;

                    if (dragParentY + dragParent.height < mouseY + child.height) {
                        mouseY = dragParentY + dragParent.height - child.height;
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
                            Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                        }

                        dirtyRectangles[rectangle] = true;
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.MINIMAP && CutsceneManager.state == 0) {
                        if (child.graphic(Static163.activeToolkit) != null) {
                            Static557.method7331();
                            Minimap.draw(posY, Static163.activeToolkit, child, posX);
                            flipDirtyRect[rectangle] = true;
                            Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);

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
                        ColourChooser.drawHue(child, posX, posY, Static163.activeToolkit);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.COLOUR_CHOOSER_SATURATION_VALUE) {
                        ColourChooser.drawSaturationValue(Static163.activeToolkit, child.colour % 64, child, posX, posY);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.COMPASS) {
                        if (child.graphic(Static163.activeToolkit) != null) {
                            Minimap.drawCompass(child, posX, posY);
                            flipDirtyRect[rectangle] = true;

                            Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);

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
                        WorldMap.draw(child.height, posX, posY, Static56.anTextureSource_3, Static163.activeToolkit, child.width);
                        dirtyRectangles[rectangle] = true;
                        Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                        continue;
                    }

                    if (child.clientcode == ComponentClientCode.WORLD_MAP_OVERVIEW) {
                        WorldMap.drawOverview(child.width, Static163.activeToolkit, child.height, posX, posY);
                        dirtyRectangles[rectangle] = true;
                        Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
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

                            @Pc(792) int offheap = Static163.activeToolkit.E() / 1024;
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

                        if (Static530.particleCount > 0) {
                            Fonts.p11.render(drawX, "Particles: " + Static111.activeParticleCount + " / " + Static530.particleCount, 0xFFFFFF00, 0xFFFFFFFF, drawY);
                        }
                        drawY += 12;

                        if (Static354.showProfiling) {
                            Fonts.p11.render(drawX, "Polys: " + Static163.activeToolkit.I() + " Models: " + Static163.activeToolkit.M(), 0xFFFFFF00, 0xFFFFFFFF, drawY);
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
                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER && Static163.activeToolkit.method8014()) {
                        Static163.activeToolkit.method7959(posX, posY, child.width, child.height);
                    }

                    draw(child.slot, posX - child.scrollX, children, x1, y1, y2, rectangle, arg7, x2, posY - child.scrollY);

                    if (child.dynamicComponents != null) {
                        draw(child.slot, posX - child.scrollX, child.dynamicComponents, x1, y1, y2, rectangle, arg7, x2, posY - child.scrollY);
                    }

                    @Pc(1214) SubInterface sub = (SubInterface) subInterfaces.get(child.slot);
                    if (sub != null) {
                        drawSubInterface(sub.anInt147, x1, x2, y1, posY, rectangle, posX, y2);
                    }

                    if (child.clientcode == ComponentClientCode.DEBUG_OVERLAY_LAYER) {
                        if (Static163.activeToolkit.method8014()) {
                            Static163.activeToolkit.method7974();
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
                                Static163.activeToolkit.method7971(x2 - x1, -y1 + y2, y1, x1, blue << 16 | alpha << 24 | red << 8 | green);
                            }
                        }
                    }

                    Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                }

                if (currentlyDirtyRect[rectangle] || rectDebug > 1) {
                    if (child.type == Component.TYPE_RECTANGLE) {
                        if (transparency == 0) {
                            if (child.filled) {
                                Static163.activeToolkit.aa(posX, posY, child.width, child.height, child.colour, 0);
                            } else {
                                Static163.activeToolkit.method7976(posX, posY, child.width, child.height, child.colour, 0);
                            }
                        } else {
                            if (child.filled) {
                                Static163.activeToolkit.aa(posX, posY, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
                            } else {
                                Static163.activeToolkit.method7976(posX, posY, child.width, child.height, 255 - (transparency & 0xFF) << 24 | child.colour & 0xFFFFFF, 1);
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
                        @Pc(1514) Font font = child.font(Static163.activeToolkit);

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
                                Static163.activeToolkit.T(posX, posY, posX + child.width, child.height + posY);
                            }

                            font.renderLines(child.verticalAlignment, colour | ((255 - (transparency & 0xFF)) << 24), child.textShadow ? 255 - (transparency & 0xFF) << 24 : -1, Static679.aSpriteArray14, child.maxLines, 0, posY, child.height, 0, null, child.lineHeight, child.width, posX, child.horizontalAlignment, null, text);

                            if (clipComponents) {
                                Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                            }

                            if (text.trim().length() > 0) {
                                if (!clipComponents) {
                                    @Pc(1730) FontMetrics metrics = Fonts.metrics(child.fontGraphic, Static163.activeToolkit);
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
                            child.skyBox(Static99.skyBoxSphereTypeList, Static324.skyBoxTypeList).method3162(Static163.activeToolkit, posY, posX, child.width, child.anInt3815 << 3, child.anInt3786 << 3, child.height);
                        } else {
                            @Pc(1816) Sprite sprite;
                            if (child.invObject != -1) {
                                @Pc(1836) PlayerModel model = child.objWearCol ? Static556.self.playerModel : null;
                                sprite = Static419.objTypeList.getCachedSprite(model, Static163.activeToolkit, child.objNumMode, child.invObject, child.outline, child.invCount, child.shadow | 0xFF000000);
                            } else if (child.video != -1) {
                                sprite = VideoTypeList.sprite(child.video, Static163.activeToolkit);
                            } else {
                                sprite = child.sprite(Static163.activeToolkit);
                            }

                            if (sprite != null) {
                                @Pc(323) int scaleWidth = sprite.scaleWidth();
                                @Pc(744) int scaleHeight = sprite.scaleHeight();
                                @Pc(1255) int backgroundColour = ((255 - (transparency & 0xFF)) << 24) | ((child.colour != 0) ? (child.colour & 0xFFFFFF) : 0xFFFFFF);

                                if (child.tiled) {
                                    Static163.activeToolkit.T(posX, posY, posX + child.width, posY - -child.height);

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

                                    Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
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
                                model = objType.model(child.animator, 2048, child.objWearCol ? Static556.self.playerModel : null, 1, Static163.activeToolkit);

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
                                    model = player.playerModel.bodyModel(Static419.objTypeList, child.animator, Static574.basTypeList, Static25.seqTypeList, 2048, null, Static523.wearposDefaults, Static68.idkTypeList, Static163.activeToolkit, Static690.aNPCTypeList_2, null, 0, null, Static34.aClass304_1);
                                }
                            }
                        } else if (child.objType == Component.OBJ_TYPE_INVENTORY_MALE || child.objType == Component.OBJ_TYPE_INVENTORY_FEMALE) {
                            @Pc(2468) ClientInventory inventory = Static556.method7303(child.obj, false);

                            if (inventory != null) {
                                model = inventory.method3078(child.objData, Static163.activeToolkit, child.objType == Component.OBJ_TYPE_INVENTORY_FEMALE, child.animator, child.objWearCol ? Static556.self.playerModel : null);
                            }
                        } else if (child.animator != null && child.animator.isAnimating()) {
                            model = child.model(Static163.activeToolkit, child.animator, Static574.basTypeList, Static68.idkTypeList, Static25.seqTypeList, Static556.self.playerModel, Static34.aClass304_1, Static690.aNPCTypeList_2, Static419.objTypeList, 2048, customisation);

                            if (model == null && Component.redrawAll) {
                                redraw(child);
                            }
                        } else {
                            model = child.model(Static163.activeToolkit, null, Static574.basTypeList, Static68.idkTypeList, Static25.seqTypeList, Static556.self.playerModel, Static34.aClass304_1, Static690.aNPCTypeList_2, Static419.objTypeList, 2048, customisation);

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
                            Static163.activeToolkit.setCamera(Static460.aMatrix_10);
                            Static163.activeToolkit.DA(local779, local792, local1255, local777);
                            Static163.activeToolkit.ya();

                            if (child.disableZBuffer) {
                                Static163.activeToolkit.C(false);
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

                            child.method3384(Static163.activeToolkit, model, Static59.aMatrix_5, TimeUtils.clock);

                            if (clipComponents) {
                                Static163.activeToolkit.T(posX, posY, posX + child.width, child.height + posY);
                            }

                            if (child.orthoView) {
                                if (child.modelOrtho) {
                                    model.renderOrtho(Static59.aMatrix_5, null, child.modelZoom, 1);
                                } else {
                                    model.render(Static59.aMatrix_5, null, 1);

                                    if (child.particleSystem != null) {
                                        Static163.activeToolkit.method8021(child.particleSystem.method3650());
                                    }
                                }
                            } else {
                                if (child.modelOrtho) {
                                    model.renderOrtho(Static59.aMatrix_5, null, child.modelZoom << 2, 1);
                                } else {
                                    model.render(Static59.aMatrix_5, null, 1);

                                    if (child.particleSystem != null) {
                                        Static163.activeToolkit.method8021(child.particleSystem.method3650());
                                    }
                                }
                            }

                            if (clipComponents) {
                                Static163.activeToolkit.KA(arg3, arg4, arg8, arg5);
                            }

                            if (child.disableZBuffer) {
                                Static163.activeToolkit.C(true);
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
                            Static163.activeToolkit.method7947(posX, local323, local744, local1255, child.colour, child.lineWidth);
                        } else {
                            Static163.activeToolkit.method7951(posX, local323, local744, local1255, child.colour, 0);
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

        if (Static556.self.accountName == null) {
            component.obj = 0;
            component.objData = 0;
            return;
        }

        component.modelAngleX = 150;
        component.modelAngleY = (int) (Math.sin((double) TimeUtils.clock / 40.0D) * 256.0D) & 0x7FF;

        component.objType = 5;
        component.obj = PlayerList.activePlayerSlot;
        component.objData = StringTools.intHash(Static556.self.accountName);

        @Pc(55) Animator animator = Static556.self.animator;
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

    @OriginalMember(owner = "client!qq", name = "a", descriptor = "(IIIIIIIZI)V")
    public static void drawSubInterface(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7) {
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
            if (Static148.aComponentArrayArray1[arg0] == null) {
                draw(-1, arg6, InterfaceList.interfaces[arg0], arg1, arg3, arg7, arg5, arg5 < 0, arg2, arg4);
            } else {
                draw(-1, arg6, Static148.aComponentArrayArray1[arg0], arg1, arg3, arg7, arg5, arg5 < 0, arg2, arg4);
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

    private InterfaceManager() {
        /* empty */
    }
}
