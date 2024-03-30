import com.jagex.Client;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.io.Packet;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.flotype.FloorOverlayType;
import com.jagex.game.runetek6.config.flotype.FloorOverlayTypeList;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayType;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementType;
import com.jagex.game.runetek6.config.meltype.MapElementTypeList;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.graphics.Fonts;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.js5.js5;
import com.jagex.math.ColourUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!baa")
public final class WorldMap {

    @OriginalMember(owner = "client!baa", name = "D", descriptor = "Lclient!sia;")
    public static final Deque elements = new Deque();

    @OriginalMember(owner = "client!baa", name = "e", descriptor = "Lclient!av;")
    public static final IterableHashTable areas = new IterableHashTable(16);

    @OriginalMember(owner = "client!baa", name = "J", descriptor = "[B")
    public static final byte[] aByteArray55 = new byte[1];

    @OriginalMember(owner = "client!baa", name = "B", descriptor = "[S")
    public static final short[] aShortArray77 = new short[1];

    @OriginalMember(owner = "client!gia", name = "s", descriptor = "Lclient!hda;")
    public static Component component;

    @OriginalMember(owner = "client!cw", name = "C", descriptor = "Z")
    public static boolean hovered = false;

    @OriginalMember(owner = "client!lja", name = "l", descriptor = "I")
    public static int optionsX = -1;

    @OriginalMember(owner = "client!tba", name = "g", descriptor = "Lclient!hda;")
    public static Component optionsComponent = null;

    @OriginalMember(owner = "client!eu", name = "ic", descriptor = "I")
    public static int optionsY = -1;

    @OriginalMember(owner = "client!dm", name = "c", descriptor = "Z")
    public static boolean clicked = false;

    @OriginalMember(owner = "client!vp", name = "K", descriptor = "I")
    public static int clickedLevel;

    @OriginalMember(owner = "client!ps", name = "c", descriptor = "I")
    public static int clickedX;

    @OriginalMember(owner = "client!th", name = "p", descriptor = "I")
    public static int clickedY;

    @OriginalMember(owner = "client!ik", name = "t", descriptor = "I")
    public static int loadingPercent = 0;

    @OriginalMember(owner = "client!baa", name = "j", descriptor = "F")
    public static float currentZoom;

    @OriginalMember(owner = "client!kh", name = "ib", descriptor = "I")
    public static int width;

    @OriginalMember(owner = "client!sj", name = "b", descriptor = "I")
    public static int height;

    @OriginalMember(owner = "client!baa", name = "f", descriptor = "I")
    public static int areaHeight;

    @OriginalMember(owner = "client!baa", name = "G", descriptor = "I")
    public static int areaWidth;

    @OriginalMember(owner = "client!baa", name = "A", descriptor = "Lclient!ml;")
    public static MapElementTypeList mapElementTypeList;

    @OriginalMember(owner = "client!baa", name = "m", descriptor = "Lclient!ip;")
    public static WorldMapArea area;

    @OriginalMember(owner = "client!baa", name = "w", descriptor = "Lclient!sb;")
    public static js5 data;

    @OriginalMember(owner = "client!baa", name = "t", descriptor = "I")
    public static int areaX;

    @OriginalMember(owner = "client!baa", name = "F", descriptor = "I")
    public static int areaY;

    @OriginalMember(owner = "client!dl", name = "k", descriptor = "I")
    public static int areaBaseZ;

    @OriginalMember(owner = "client!vs", name = "o", descriptor = "I")
    public static int areaBaseX;

    @OriginalMember(owner = "client!baa", name = "x", descriptor = "F")
    public static float targetZoom;

    @OriginalMember(owner = "client!baa", name = "u", descriptor = "I")
    public static int tileSize;

    @OriginalMember(owner = "client!baa", name = "k", descriptor = "[[[B")
    public static byte[][][] tileShapes;

    @OriginalMember(owner = "client!rfa", name = "y", descriptor = "Lclient!sia;")
    public static Deque aDeque_54;

    @OriginalMember(owner = "client!baa", name = "g", descriptor = "I")
    public static int mapDl = (int) (Math.random() * 17.0D) - 8;

    @OriginalMember(owner = "client!baa", name = "q", descriptor = "I")
    public static int mapDh = (int) (Math.random() * 11.0D) - 5;

    @OriginalMember(owner = "client!baa", name = "y", descriptor = "Lclient!u;")
    public static MSITypeList msiTypeList;

    @OriginalMember(owner = "client!baa", name = "H", descriptor = "Lclient!gea;")
    public static LocTypeList locTypeList;

    @OriginalMember(owner = "client!baa", name = "M", descriptor = "Lclient!nc;")
    public static MapElementList staticElements;

    @OriginalMember(owner = "client!baa", name = "I", descriptor = "Lclient!uk;")
    public static VarDomain varDomain;

    @OriginalMember(owner = "client!baa", name = "b", descriptor = "Lclient!ef;")
    public static FloorOverlayTypeList floorOverlayTypeList;

    @OriginalMember(owner = "client!baa", name = "O", descriptor = "Lclient!dh;")
    public static FloorUnderlayTypeList floorUnderlayTypeList;

    @OriginalMember(owner = "client!baa", name = "d", descriptor = "[S")
    public static short[] aShortArray78;

    @OriginalMember(owner = "client!baa", name = "z", descriptor = "[B")
    public static byte[] aByteArray56;

    @OriginalMember(owner = "client!baa", name = "p", descriptor = "[B")
    public static byte[] aByteArray57;

    @OriginalMember(owner = "client!baa", name = "v", descriptor = "I")
    public static int anInt5645;

    @OriginalMember(owner = "client!baa", name = "h", descriptor = "[S")
    public static short[] aShortArray79;

    @OriginalMember(owner = "client!baa", name = "C", descriptor = "I")
    public static int anInt5646;

    @OriginalMember(owner = "client!baa", name = "E", descriptor = "[B")
    public static byte[] aByteArray58;

    @OriginalMember(owner = "client!baa", name = "s", descriptor = "I")
    public static int anInt5647;

    @OriginalMember(owner = "client!baa", name = "o", descriptor = "[I")
    public static int[] overlayColours;

    @OriginalMember(owner = "client!baa", name = "c", descriptor = "I")
    public static int anInt5649;

    @OriginalMember(owner = "client!baa", name = "i", descriptor = "[B")
    public static byte[] aByteArray59;

    @OriginalMember(owner = "client!baa", name = "l", descriptor = "Lclient!av;")
    public static IterableHashTable aIterableHashTable;

    @OriginalMember(owner = "client!baa", name = "r", descriptor = "I")
    public static int anInt5651;

    @OriginalMember(owner = "client!baa", name = "K", descriptor = "I")
    public static int anInt5652;

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "I")
    public static int anInt5653;

    @OriginalMember(owner = "client!baa", name = "N", descriptor = "[B")
    public static byte[] aByteArray60;

    @OriginalMember(owner = "client!baa", name = "n", descriptor = "I")
    public static int anInt5654;

    @OriginalMember(owner = "client!baa", name = "L", descriptor = "[[[Lclient!fla;")
    public static LinkedList[][][] tiles;

    @OriginalMember(owner = "client!rk", name = "w", descriptor = "I")
    public static int anInt3181 = -1;

    @OriginalMember(owner = "client!fba", name = "c", descriptor = "I")
    public static int anInt2809;

    @OriginalMember(owner = "client!tha", name = "e", descriptor = "I")
    public static int anInt9389;

    @OriginalMember(owner = "client!lea", name = "c", descriptor = "I")
    public static int lastAreaId;

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!sb;Lclient!ef;Lclient!dh;Lclient!gea;Lclient!ml;Lclient!u;Lclient!uk;)V")
    public static void init(@OriginalArg(0) js5 data, @OriginalArg(1) FloorOverlayTypeList floorOverlayTypeList, @OriginalArg(2) FloorUnderlayTypeList floorUnderlayTypeList, @OriginalArg(3) LocTypeList locTypeList, @OriginalArg(4) MapElementTypeList mapElementTypeList, @OriginalArg(5) MSITypeList msiTypeList, @OriginalArg(6) VarDomain varDomain) {
        WorldMap.data = data;
        WorldMap.floorOverlayTypeList = floorOverlayTypeList;
        WorldMap.floorUnderlayTypeList = floorUnderlayTypeList;
        WorldMap.locTypeList = locTypeList;
        WorldMap.mapElementTypeList = mapElementTypeList;
        WorldMap.msiTypeList = msiTypeList;
        WorldMap.varDomain = varDomain;

        areas.clear();

        @Pc(23) int detailsGroup = WorldMap.data.getgroupid("details");
        @Pc(28) int[] files = WorldMap.data.fileIds(detailsGroup);
        if (files != null) {
            for (@Pc(32) int i = 0; i < files.length; i++) {
                @Pc(41) WorldMapArea area = WorldMapArea.decode(WorldMap.data, detailsGroup, files[i]);
                areas.put(area.id, area);
            }
        }

        ColourUtils.init(false, true);
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IIIILclient!d;Lclient!ha;I)V")
    public static void draw(@OriginalArg(1) int childHeight, @OriginalArg(2) int childX, @OriginalArg(3) int childY, @OriginalArg(4) TextureSource source, @OriginalArg(5) Toolkit toolkit, @OriginalArg(6) int childWidth) {
        if (loadingPercent < 100) {
            load(source, toolkit);
        }

        toolkit.KA(childX, childY, childX + childWidth, childY + childHeight);

        if (loadingPercent < 100) {
            @Pc(38) int x = (childWidth / 2) + childX;
            toolkit.aa(childX, childY, childWidth, childHeight, 0xFF000000, 0);
            @Pc(57) int y = (childY + (childHeight / 2)) - 20 - 18;
            toolkit.outlineRect(x - 152, y, 304, 34, Client.OUTLINE_COLOURS[Client.colourId].getRGB(), 0);
            toolkit.aa(x - 150, y + 2, loadingPercent * 3, 30, Client.FILL_COLOURS[Client.colourId].getRGB(), 0);
            Fonts.b12.renderCentre(LocalisedText.LOADINGDOTDOTDOT.localise(Client.language), x, y + 20, Client.TEXT_COLOURS[Client.colourId].getRGB(), -1);
        } else {
            @Pc(114) int local114 = anInt2809 - (int) ((float) childWidth / currentZoom);
            @Pc(38) int z = anInt9389 + (int) ((float) childHeight / currentZoom);
            @Pc(57) int x = anInt2809 + (int) ((float) childWidth / currentZoom);

            width = (int) ((float) (childWidth * 2) / currentZoom);
            height = (int) ((float) (childHeight * 2) / currentZoom);

            @Pc(155) int local155 = anInt9389 - (int) ((float) childHeight / currentZoom);
            Static510.anInt7639 = anInt9389 - (int) ((float) childHeight / currentZoom);
            Static534.anInt8111 = anInt2809 - (int) ((float) childWidth / currentZoom);
            method5062(areaX + local114, z - -areaY, x + areaX, local155 + areaY, childX, childY, childWidth + childX, childHeight + childY + 1);
            method5060(toolkit);

            @Pc(203) Deque local203 = method5081(toolkit);
            Static368.method5272(local203, toolkit);

            if (Static320.anInt5084 > 0) {
                Static212.anInt3467--;
                if (Static212.anInt3467 == 0) {
                    Static320.anInt5084--;
                    Static212.anInt3467 = 20;
                }
            }

            if (Client.displayFps) {
                @Pc(250) int textX = childWidth + childX - 5;
                @Pc(256) int textY = childHeight + childY - 8;
                Fonts.p12.renderRight("Fps:" + GameShell.currentFps, textX, textY, 0xFFFF00, -1);
                @Pc(273) int memoryTextY = textY - 15;

                @Pc(275) Runtime runtime = Runtime.getRuntime();
                @Pc(285) int memKb = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                @Pc(287) int colour = 0xFFFF00;
                if (memKb > 65536) {
                    colour = 0xFF0000;
                }
                Fonts.p12.renderRight("Mem:" + memKb + "k", textX, memoryTextY, colour, -1);
                textY = memoryTextY - 15;
            }
        }
    }

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(BILclient!ha;III)V")
    public static void drawOverview(@OriginalArg(1) int width, @OriginalArg(2) Toolkit arg1, @OriginalArg(3) int height, @OriginalArg(4) int x, @OriginalArg(5) int z) {
        arg1.KA(x, z, x + width, height + z);
        arg1.fillRect(x, z, width, height, 0xFF000000);

        if (loadingPercent < 100) {
            return;
        }

        @Pc(44) float aspectRatio = (float) areaHeight / (float) areaWidth;

        @Pc(46) int newWidth = width;
        @Pc(48) int newHeight = height;
        if (aspectRatio < 1.0F) {
            newHeight = (int) (aspectRatio * (float) width);
        } else {
            newWidth = (int) ((float) height / aspectRatio);
        }

        @Pc(75) int newX = x + ((width - newWidth) / 2);
        @Pc(84) int newY = z + ((height - newHeight) / 2);

        if (Static13.aSprite_4 == null || Static13.aSprite_4.getWidth() != width || Static13.aSprite_4.getHeight() != height) {
            method5062(areaX, areaY + areaHeight, areaWidth + areaX, areaY, newX, newY, newX + newWidth, newY - -newHeight);
            method5060(arg1);
            Static13.aSprite_4 = arg1.createSprite(newX, newY, newWidth, newHeight, false);
        }

        Static13.aSprite_4.render(newX, newY);

        @Pc(138) int local138 = (newWidth * WorldMap.width) / areaWidth;
        @Pc(144) int local144 = (newHeight * WorldMap.height) / areaHeight;
        @Pc(152) int local152 = Static534.anInt8111 * newWidth / areaWidth + newX;
        @Pc(166) int local166 = newHeight + newY - local144 - Static510.anInt7639 * newHeight / areaHeight;

        @Pc(168) int colour = 0x88FF0000;
        if (Client.modeGame == ModeGame.STELLAR_DAWN) {
            colour = 0x88FFFFFF;
        }

        arg1.aa(local152, local166, local138, local144, colour, 1);
        arg1.outlineRect(local152, local166, local138, local144, colour, 0);

        if (Static320.anInt5084 <= 0) {
            return;
        }

        @Pc(202) int alpha;
        if (Static212.anInt3467 > 50) {
            alpha = (100 - Static212.anInt3467) * 5;
        } else {
            alpha = Static212.anInt3467 * 5;
        }

        for (@Pc(213) MapElementListEntry entry = (MapElementListEntry) elements.first(); entry != null; entry = (MapElementListEntry) elements.next()) {
            @Pc(221) MapElementType elementType = mapElementTypeList.list(entry.id);

            if (Static408.method5634(elementType)) {
                if (Static475.anInt7168 == entry.id) {
                    @Pc(256) int drawX = newX + ((newWidth * entry.x) / areaWidth);
                    @Pc(269) int drawY = newY + ((newHeight * (areaHeight - entry.y)) / areaHeight);
                    arg1.fillRect(drawX - 2, drawY - 2, 4, 4, (alpha << 24) | 0xFFFF00);
                } else if (Static409.anInt6318 != -1 && Static409.anInt6318 == elementType.category) {
                    @Pc(256) int drawX = newX + ((newWidth * entry.x) / areaWidth);
                    @Pc(269) int drawY = newY + (((areaHeight - entry.y) * newHeight) / areaHeight);
                    arg1.fillRect(drawX + -2, drawY - 2, 4, 4, (alpha << 24) | 0xFFFF00);
                }
            }
        }
    }

    @OriginalMember(owner = "client!fo", name = "d", descriptor = "(I)Lclient!ip;")
    public static WorldMapArea getArea() {
        return area;
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(I)V")
    public static void setArea(@OriginalArg(0) int id) {
        area = (WorldMapArea) areas.get(id);
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(IIIBI)V")
    public static void clickedOverview(@OriginalArg(0) int width, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(4) int height) {
        @Pc(16) float aspectRatio = (float) areaHeight / (float) areaWidth;

        @Pc(18) int newWidth = width;
        @Pc(20) int newHeight = height;
        if (aspectRatio < 1.0F) {
            newHeight = (int) ((float) width * aspectRatio);
        } else {
            newWidth = (int) ((float) height / aspectRatio);
        }

        @Pc(47) int newX = y - (height - newHeight) / 2;
        @Pc(56) int newY = x - (width - newWidth) / 2;
        anInt2809 = (newY * areaWidth) / newWidth;
        anInt9389 = areaHeight - ((areaHeight * newX) / newHeight);
        anInt3181 = -1;
        Static180.anInt3001 = -1;
        method5440();
    }

    @OriginalMember(owner = "client!cba", name = "a", descriptor = "(IZILclient!hda;)V")
    public static void setOptions(@OriginalArg(0) int optionsX, @OriginalArg(2) int optionsY, @OriginalArg(3) Component optionsComponent) {
        WorldMap.optionsX = optionsX;
        WorldMap.optionsComponent = optionsComponent;
        WorldMap.optionsY = optionsY;
    }

    @OriginalMember(owner = "client!wq", name = "a", descriptor = "(Lclient!d;Lclient!ha;Z)V")
    public static void load(@OriginalArg(0) TextureSource textureSource, @OriginalArg(1) Toolkit toolkit) {
        if (area == null) {
            return;
        }

        if (loadingPercent < 10) {
            if (!data.requestgroupdownload(area.file)) {
                loadingPercent = js5.WORLDMAPDATA.completePercentage(area.file) / 10;
                return;
            }

            Static700.method9152();
            loadingPercent = 10;
        }

        if (loadingPercent == 10) {
            areaX = area.minX >> 6 << 6;
            areaY = area.minY >> 6 << 6;

            areaWidth = (area.maxX >> 6 << 6) - (areaX - 64);
            areaHeight = (area.maxY >> 6 << 6) + 64 - areaY;

            @Pc(77) int[] coord = new int[3];
            @Pc(79) int relativeX = -1;
            @Pc(81) int relativeY = -1;
            if (area.method4088(coord, areaBaseZ + (PlayerEntity.self.z >> 9), PlayerEntity.self.level, (PlayerEntity.self.x >> 9) + areaBaseX)) {
                relativeX = coord[1] - areaX;
                relativeY = coord[2] - areaY;
            }

            if (!Static696.aBoolean784 && relativeX >= 0 && areaWidth > relativeX && relativeY >= 0 && relativeY < areaHeight) {
                relativeY += (int) (Math.random() * 10.0D) - 5;
                relativeX += (int) (Math.random() * 10.0D) - 5;
                anInt2809 = relativeX;
                anInt9389 = relativeY;
            } else if (Static227.anInt3694 == -1 || Static529.anInt8089 == -1) {
                area.method4085((area.origin >> 14) & 0x3FFF, area.origin & 0x3FFF, coord);
                anInt9389 = coord[2] - areaY;
                anInt2809 = coord[1] - areaX;
            } else {
                area.method4085(Static227.anInt3694, Static529.anInt8089, coord);

                if (coord != null) {
                    anInt2809 = coord[1] - areaX;
                    anInt9389 = coord[2] - areaY;
                }

                Static696.aBoolean784 = false;
                Static529.anInt8089 = -1;
                Static227.anInt3694 = -1;
            }

            if (area.zoom == 37) {
                currentZoom = 3.0F;
                targetZoom = 3.0F;
            } else if (area.zoom == 50) {
                currentZoom = 4.0F;
                targetZoom = 4.0F;
            } else if (area.zoom == 75) {
                currentZoom = 6.0F;
                targetZoom = 6.0F;
            } else if (area.zoom == 100) {
                currentZoom = 8.0F;
                targetZoom = 8.0F;
            } else if (area.zoom == 200) {
                currentZoom = 16.0F;
                targetZoom = 16.0F;
            } else {
                currentZoom = 8.0F;
                targetZoom = 8.0F;
            }

            tileSize = (int) currentZoom >> 1;
            tileShapes = Static640.method8437(tileSize);
            method5440();
            method5069();
            aDeque_54 = new Deque();

            mapDh += (int) (Math.random() * 5.0D) - 2;
            if (mapDh < -8) {
                mapDh = -8;
            }

            mapDl += (int) (Math.random() * 5.0D) - 2;
            if (mapDh > 8) {
                mapDh = 8;
            }

            if (mapDl < -16) {
                mapDl = -16;
            }
            if (mapDl > 16) {
                mapDl = 16;
            }

            method5067(textureSource, mapDh >> 2 << 10, mapDl >> 1);
            mapElementTypeList.setCaches(1024, 256);
            msiTypeList.setCache(256, 256);
            locTypeList.setRecentUse(4096);
            VarBitTypeListClient.instance.cacheReset(256);
            loadingPercent = 20;
        } else if (loadingPercent == 20) {
            Static314.noTimeout(true);
            method5080(toolkit, mapDh, mapDl);
            loadingPercent = 60;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 60) {
            if (data.groupExists(area.file + "_staticelements")) {
                if (!data.requestgroupdownload(area.file + "_staticelements")) {
                    return;
                }

                staticElements = MapElementList.load(Static174.mapMembers, data, area.file + "_staticelements");
            } else {
                staticElements = new MapElementList(0);
            }

            method5079();
            loadingPercent = 70;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 70) {
            Static559.aClass327_7 = new Class327(toolkit, 11, true, GameShell.canvas);
            loadingPercent = 73;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 73) {
            Static484.aClass327_6 = new Class327(toolkit, 12, true, GameShell.canvas);
            loadingPercent = 76;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 76) {
            Static142.aClass327_1 = new Class327(toolkit, 14, true, GameShell.canvas);
            loadingPercent = 79;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 79) {
            Static651.aClass327_8 = new Class327(toolkit, 17, true, GameShell.canvas);
            loadingPercent = 82;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 82) {
            Static275.aClass327_2 = new Class327(toolkit, 19, true, GameShell.canvas);
            loadingPercent = 85;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 85) {
            Static390.aClass327_5 = new Class327(toolkit, 22, true, GameShell.canvas);
            loadingPercent = 88;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else if (loadingPercent == 88) {
            Static364.aClass327_4 = new Class327(toolkit, 26, true, GameShell.canvas);
            loadingPercent = 91;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
        } else {
            Static359.aClass327_3 = new Class327(toolkit, 30, true, GameShell.canvas);
            loadingPercent = 100;
            Static314.noTimeout(true);
            Static199.doneslowupdate();
            System.gc();
        }
    }

    @OriginalMember(owner = "client!mc", name = "b", descriptor = "(I)V")
    public static void method5440() {
        if (anInt2809 < 0) {
            Static180.anInt3001 = -1;
            anInt3181 = -1;
            anInt2809 = 0;
        }

        if (areaWidth < anInt2809) {
            Static180.anInt3001 = -1;
            anInt2809 = areaWidth;
            anInt3181 = -1;
        }

        if (anInt9389 < 0) {
            anInt3181 = -1;
            Static180.anInt3001 = -1;
            anInt9389 = 0;
        }

        if (areaHeight < anInt9389) {
            anInt3181 = -1;
            Static180.anInt3001 = -1;
            anInt9389 = areaHeight;
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!d;II)V")
    public static void method5067(@OriginalArg(0) TextureSource textureSource, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        for (@Pc(1) int i = 0; i < floorOverlayTypeList.num; i++) {
            overlayColours[i + 1] = overlayColour(textureSource, i, arg1, arg2);
        }
    }

    @OriginalMember(owner = "client!baa", name = "b", descriptor = "(I)Lclient!ip;")
    public static WorldMapArea getArea(@OriginalArg(0) int arg0) {
        return (WorldMapArea) areas.get(arg0);
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;)V")
    public static void method5060(@OriginalArg(0) Toolkit arg0) {
        @Pc(3) int local3 = anInt5647 - anInt5652;
        @Pc(7) int local7 = anInt5645 - anInt5654;
        @Pc(15) int local15 = (anInt5651 - anInt5649 << 16) / local3;
        @Pc(23) int local23 = (anInt5646 - anInt5653 << 16) / local7;
        method5066(arg0, local15, local23);
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;IIIIIII[S[BZ)V")
    public static void method5061(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) short[] arg8, @OriginalArg(9) byte[] arg9, @OriginalArg(10) boolean arg10) {
        @Pc(20) int local20;
        @Pc(32) int local32;
        if (arg10 || arg5 != 0 || arg6 > 0) {
            if (arg6 == 0) {
                arg0.aa(arg1, arg2, arg3, arg4, arg5, 0);
            } else {
                local20 = arg7 & 0x3F;
                if (local20 == 0 || arg3 <= 1 || arg4 <= 1) {
                    local32 = overlayColours[arg6];
                    if (arg10 || local32 != 0) {
                        arg0.aa(arg1, arg2, arg3, arg4, local32, 0);
                    }
                } else {
                    local32 = arg10 ? 0 : 1;
                    Static339.method5007(arg4, tileShapes, overlayColours[arg6], arg3, tileSize, arg1, arg0, local32, arg7 >> 6 & 0x3, arg2, arg5, local20);
                }
            }
        }
        if (arg8 == null) {
            return;
        }
        if (arg3 == 1) {
            local20 = arg1;
        } else {
            local20 = arg1 + arg3 - 1;
        }
        if (arg4 == 1) {
            local32 = arg2;
        } else {
            local32 = arg2 + arg4 - 1;
        }
        for (@Pc(100) int local100 = 0; local100 < arg8.length; local100++) {
            @Pc(107) int local107 = arg9[local100] & 0x3F;
            if (local107 == 0 || local107 == 2 || local107 == 3 || local107 == 9) {
                @Pc(127) LocType local127 = locTypeList.list(arg8[local100] & 0xFFFF);
                if (local127.msi == -1) {
                    @Pc(133) int local133 = -3355444;
                    if (local127.active == LocInteractivity.INTERACTIVE) {
                        local133 = -3407872;
                    }
                    @Pc(147) int local147 = arg9[local100] >> 6 & 0x3;
                    if (local107 == 0) {
                        if (local147 == 0) {
                            arg0.P(arg1, arg2, arg4, local133, 0);
                        } else if (local147 == 1) {
                            arg0.U(arg1, arg2, arg3, local133, 0);
                        } else if (local147 == 2) {
                            arg0.P(local20, arg2, arg4, local133, 0);
                        } else {
                            arg0.U(arg1, local32, arg3, local133, 0);
                        }
                    } else if (local107 == 2) {
                        if (local147 == 0) {
                            arg0.P(arg1, arg2, arg4, -1, 0);
                            arg0.U(arg1, arg2, arg3, local133, 0);
                        } else if (local147 == 1) {
                            arg0.P(local20, arg2, arg4, -1, 0);
                            arg0.U(arg1, arg2, arg3, local133, 0);
                        } else if (local147 == 2) {
                            arg0.P(local20, arg2, arg4, -1, 0);
                            arg0.U(arg1, local32, arg3, local133, 0);
                        } else {
                            arg0.P(arg1, arg2, arg4, -1, 0);
                            arg0.U(arg1, local32, arg3, local133, 0);
                        }
                    } else if (local107 == 3) {
                        if (local147 == 0) {
                            arg0.U(arg1, arg2, 1, local133, 0);
                        } else if (local147 == 1) {
                            arg0.U(local20, arg2, 1, local133, 0);
                        } else if (local147 == 2) {
                            arg0.U(local20, local32, 1, local133, 0);
                        } else {
                            arg0.U(arg1, local32, 1, local133, 0);
                        }
                    } else if (local107 == 9) {
                        @Pc(313) int local313;
                        if (local147 == 0 || local147 == 2) {
                            for (local313 = 0; local313 < arg4; local313++) {
                                arg0.U(arg1 + local313, local32 - local313, 1, local133, 0);
                            }
                        } else {
                            for (local313 = 0; local313 < arg4; local313++) {
                                arg0.U(arg1 + local313, arg2 + local313, 1, local133, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(IIIIIIII)V")
    public static void method5062(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
        anInt5652 = arg0 - areaX;
        anInt5645 = arg1 - areaY;
        anInt5647 = arg2 - areaX;
        anInt5654 = arg3 - areaY;
        anInt5649 = arg4;
        anInt5653 = arg5;
        anInt5651 = arg6;
        anInt5646 = arg7;
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "([B[B[SII)V")
    public static void method5064(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) short[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        @Pc(2) int[] local2 = new int[areaHeight];
        @Pc(5) int[] local5 = new int[areaHeight];
        @Pc(8) int[] local8 = new int[areaHeight];
        @Pc(11) int[] local11 = new int[areaHeight];
        @Pc(14) int[] local14 = new int[areaHeight];
        for (@Pc(16) int local16 = -5; local16 < areaWidth; local16++) {
            @Pc(21) int local21 = local16 + 5;
            @Pc(25) int local25 = local16 - 5;
            @Pc(41) int local41;
            for (@Pc(27) int local27 = 0; local27 < areaHeight; local27++) {
                @Pc(86) int local86;

                if (local21 < areaWidth) {
                    local41 = arg0[local21 + local27 * areaWidth] & 0xFF;
                    if (local41 > 0) {
                        @Pc(50) FloorUnderlayType local50 = floorUnderlayTypeList.list(local41 - 1);
                        local2[local27] += local50.anInt6630;
                        local5[local27] += local50.anInt6637;
                        local8[local27] += local50.anInt6639;
                        local11[local27] += local50.anInt6632;
                        local86 = local14[local27]++;
                    }
                }

                if (local25 >= 0) {
                    local41 = arg0[local25 + local27 * areaWidth] & 0xFF;
                    if (local41 > 0) {
                        @Pc(50) FloorUnderlayType local50 = floorUnderlayTypeList.list(local41 - 1);
                        local2[local27] -= local50.anInt6630;
                        local5[local27] -= local50.anInt6637;
                        local8[local27] -= local50.anInt6639;
                        local11[local27] -= local50.anInt6632;
                        local86 = local14[local27]--;
                    }
                }
            }

            if (local16 >= 0) {
                local41 = 0;
                @Pc(159) int local159 = 0;
                @Pc(161) int local161 = 0;
                @Pc(163) int local163 = 0;
                @Pc(165) int local165 = 0;
                for (@Pc(167) int local167 = -5; local167 < areaHeight; local167++) {
                    @Pc(172) int local172 = local167 + 5;
                    if (local172 < areaHeight) {
                        local41 += local2[local172];
                        local159 += local5[local172];
                        local161 += local8[local172];
                        local163 += local11[local172];
                        local165 += local14[local172];
                    }
                    @Pc(209) int local209 = local167 - 5;
                    if (local209 >= 0) {
                        local41 -= local2[local209];
                        local159 -= local5[local209];
                        local161 -= local8[local209];
                        local163 -= local11[local209];
                        local165 -= local14[local209];
                    }
                    if (local167 >= 0 && local165 > 0) {
                        @Pc(261) int local261;
                        if ((arg0[local16 + local167 * areaWidth] & 0xFF) == 0) {
                            local261 = local16 + local167 * areaWidth;
                            arg1[local261] = 0;
                            arg2[local261] = 0;
                        } else {
                            local261 = local163 == 0 ? 0 : Static318.method8555(local161 / local165, local159 / local165, local41 * 256 / local163);
                            @Pc(294) int local294 = (local261 & 0x7F) + arg4;
                            if (local294 < 0) {
                                local294 = 0;
                            } else if (local294 > 127) {
                                local294 = 127;
                            }
                            @Pc(316) int local316 = (local261 + arg3 & 0xFC00) + (local261 & 0x380) + local294;
                            @Pc(322) int local322 = local16 + local167 * areaWidth;
                            @Pc(333) int local333 = ColourUtils.HSV_TO_RGB[ColourUtils.hslToHsv(Static75.method6238(local316)) & 0xFFFF];
                            arg1[local322] = (byte) (local333 >> 16 & 0xFF);
                            arg2[local322] = (short) (local333 & 0xFFFF);
                        }
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;IIII)V")
    public static void method5066(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(3) int local3 = anInt5647 - anInt5652;
        @Pc(7) int local7 = anInt5645 - anInt5654;
        if (anInt5647 < areaWidth) {
            local3++;
        }
        if (anInt5645 < areaHeight) {
            local7++;
        }
        @Pc(28) int local28;
        @Pc(40) int local40;
        @Pc(44) int local44;
        @Pc(50) int local50;
        @Pc(57) int local57;
        @Pc(70) int local70;
        @Pc(80) int local80;
        @Pc(84) int local84;
        @Pc(93) int local93;
        @Pc(173) int local173;
        @Pc(175) int local175;
        @Pc(177) int local177;
        @Pc(179) int local179;
        for (@Pc(17) int local17 = 0; local17 < local3; local17++) {
            local28 = (arg1 * local17 >> 16) + anInt5649;
            local40 = (arg1 * (local17 + 1) >> 16) + anInt5649;
            local44 = local40 - local28;
            if (local44 > 0) {
                local50 = anInt5652 + local17;
                if (local50 >= 0 && local50 < areaWidth) {
                    for (local57 = 0; local57 < local7; local57++) {
                        local70 = anInt5646 - (arg2 * (local57 + 1) >> 16);
                        local80 = anInt5646 - (arg2 * local57 >> 16);
                        local84 = local80 - local70;
                        if (local84 > 0) {
                            local93 = local57 + anInt5654;
                            local173 = local50 + local93 * areaWidth;
                            local175 = 0;
                            local177 = 0;
                            local179 = 0;
                            if (local93 >= 0 && local93 < areaHeight) {
                                local175 = (aByteArray56[local173] & 0xFF) << 16 | aShortArray79[local173] & 0xFFFF;
                                if (local175 != 0) {
                                    local175 |= 0xFF000000;
                                }
                                local177 = aByteArray60[local173] & 0xFF;
                                local179 = aShortArray78[local173] & 0xFFFF;
                            }
                            if (local175 == 0 && local177 == 0 && local179 == 0) {
                                if (area.anInt4561 != -1) {
                                    local175 = area.anInt4561 | 0xFF000000;
                                } else if ((local17 + anInt5652 & 0x4) == (local57 + anInt5645 & 0x4)) {
                                    local175 = overlayColours[floorOverlayTypeList.dflt + 1];
                                } else {
                                    local175 = 0xFF4B5368;
                                }
                                if (local175 == 0) {
                                    local175 = 0xFF000000;
                                }
                                arg0.aa(local28, local70, local44, local84, local175, 0);
                            } else if (local179 <= 0) {
                                method5061(arg0, local28, local70, local44, local84, local175, local177, aByteArray59[local173], null, null, true);
                            } else if (local179 == 65535) {
                                @Pc(282) Node_Sub23 local282 = (Node_Sub23) aIterableHashTable.get(local50 << 16 | local93);
                                if (local282 != null) {
                                    method5061(arg0, local28, local70, local44, local84, local175, local177, aByteArray59[local173], local282.aShortArray59, local282.aByteArray38, true);
                                }
                            } else {
                                aShortArray77[0] = (short) (local179 - 1);
                                aByteArray55[0] = aByteArray58[local173];
                                method5061(arg0, local28, local70, local44, local84, local175, local177, aByteArray59[local173], aShortArray77, aByteArray55, true);
                            }
                        }
                    }
                } else {
                    for (local57 = 0; local57 < local7; local57++) {
                        local70 = anInt5646 - (arg2 * (local57 + 1) >> 16);
                        local80 = anInt5646 - (arg2 * local57 >> 16);
                        local84 = local80 - local70;
                        if (area.anInt4561 != -1) {
                            local93 = area.anInt4561 | 0xFF000000;
                        } else if ((local17 + anInt5652 & 0x4) == (local57 + anInt5645 & 0x4)) {
                            local93 = overlayColours[floorOverlayTypeList.dflt + 1];
                        } else {
                            local93 = -11840664;
                        }
                        if (local93 == 0) {
                            local93 = -16777216;
                        }
                        arg0.aa(local28, local70, local44, local84, local93, 0);
                    }
                }
            }
        }
        for (local28 = -16; local28 < local3 + 16; local28++) {
            local40 = (arg1 * local28 >> 16) + anInt5649;
            local44 = (arg1 * (local28 + 1) >> 16) + anInt5649;
            local50 = local44 - local40;
            if (local50 > 0) {
                local57 = local28 + anInt5652;
                if (local57 >= 0 && local57 < areaWidth) {
                    for (local70 = -16; local70 < local7 + 16; local70++) {
                        local80 = anInt5646 - (arg2 * (local70 + 1) >> 16);
                        local84 = anInt5646 - (arg2 * local70 >> 16);
                        local93 = local84 - local80;
                        if (local93 > 0) {
                            local173 = local70 + anInt5654;
                            if (local173 >= 0 && local173 < areaHeight) {
                                local175 = aShortArray78[local57 + local173 * areaWidth] & 0xFFFF;
                                if (local175 <= 0) {
                                    Minimap.drawMsiMultiple(arg0, local40, local80, local50, local93, null, null);
                                } else if (local175 == 65535) {
                                    @Pc(459) Node_Sub23 local459 = (Node_Sub23) aIterableHashTable.get(local57 << 16 | local173);
                                    if (local459 != null) {
                                        Minimap.drawMsiMultiple(arg0, local40, local80, local50, local93, local459.aShortArray59, local459.aByteArray38);
                                    }
                                } else {
                                    aShortArray77[0] = (short) (local175 - 1);
                                    aByteArray55[0] = aByteArray58[local57 + local173 * areaWidth];
                                    Minimap.drawMsiMultiple(arg0, local40, local80, local50, local93, aShortArray77, aByteArray55);
                                }
                            }
                        }
                    }
                }
            }
        }
        local40 = anInt5652 >> 6;
        local44 = anInt5654 >> 6;
        if (local40 < 0) {
            local40 = 0;
        }
        if (local44 < 0) {
            local44 = 0;
        }
        local50 = anInt5647 >> 6;
        local57 = anInt5645 >> 6;
        if (local50 >= tiles[0].length) {
            local50 = tiles[0].length - 1;
        }
        if (local57 >= tiles[0][0].length) {
            local57 = tiles[0][0].length - 1;
        }
        for (local70 = 0; local70 < 3; local70++) {
            @Pc(641) int local641;
            @Pc(653) int local653;
            @Pc(665) int local665;
            @Pc(675) int local675;
            @Pc(631) int local631;
            for (local80 = local40; local80 <= local50; local80++) {
                for (local84 = local44; local84 <= local57; local84++) {
                    @Pc(589) LinkedList local589 = tiles[local70][local80][local84];
                    if (local589 != null) {
                        local173 = (local80 + (areaX >> 6)) * 64;
                        local175 = (local84 + (areaY >> 6)) * 64;
                        for (@Pc(612) WorldMapTile local612 = (WorldMapTile) local589.first(); local612 != null; local612 = (WorldMapTile) local589.next()) {
                            local179 = local173 + local612.aByte138 - areaX - anInt5652;
                            local631 = local175 + local612.aByte139 - areaY - anInt5654;
                            local641 = (arg1 * local179 >> 16) + anInt5649;
                            local653 = (arg1 * (local179 + 1) >> 16) + anInt5649;
                            local665 = anInt5646 - (arg2 * (local631 + 1) >> 16);
                            local675 = anInt5646 - (arg2 * local631 >> 16);
                            method5061(arg0, local641, local665, local653 - local641, local675 - local665, local612.anInt9770, local612.aByte137 & 0xFF, local612.aByte136, local612.aShortArray133, local612.aByteArray104, false);
                        }
                    }
                }
            }
            for (local84 = local40; local84 <= local50; local84++) {
                for (local93 = local44; local93 <= local57; local93++) {
                    @Pc(727) LinkedList local727 = tiles[local70][local84][local93];
                    if (local727 != null) {
                        local175 = (local84 + (areaX >> 6)) * 64;
                        local177 = (local93 + (areaY >> 6)) * 64;
                        for (@Pc(750) WorldMapTile local750 = (WorldMapTile) local727.first(); local750 != null; local750 = (WorldMapTile) local727.next()) {
                            local631 = local175 + local750.aByte138 - areaX - anInt5652;
                            local641 = local177 + local750.aByte139 - areaY - anInt5654;
                            local653 = (arg1 * local631 >> 16) + anInt5649;
                            local665 = (arg1 * (local631 + 1) >> 16) + anInt5649;
                            local675 = anInt5646 - (arg2 * (local641 + 1) >> 16);
                            @Pc(813) int local813 = anInt5646 - (arg2 * local641 >> 16);
                            Minimap.drawMsiMultiple(arg0, local653, local675, local665 - local653, local813 - local675, local750.aShortArray133, local750.aByteArray104);
                        }
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!d;III)I")
    public static int overlayColour(@OriginalArg(0) TextureSource textureSource, @OriginalArg(1) int id, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        @Pc(4) FloorOverlayType type = floorOverlayTypeList.list(id);
        if (type == null) {
            return 0;
        }

        @Pc(11) int texture = type.texture;
        if (texture >= 0 && textureSource.getMetrics(texture).disableable) {
            texture = -1;
        }

        @Pc(68) int colour;
        if (type.blendColour >= 0) {
            @Pc(27) int local27 = type.blendColour;

            @Pc(33) int local33 = (local27 & 0x7F) + arg3;
            if (local33 < 0) {
                local33 = 0;
            } else if (local33 > 127) {
                local33 = 127;
            }

            @Pc(55) int local55 = (local27 + arg2 & 0xFC00) + (local27 & 0x380) + local33;
            colour = ColourUtils.HSV_TO_RGB[ColourUtils.hslToHsv(ColourUtils.method3066(local55)) & 0xFFFF] | 0xFF000000;
        } else if (texture >= 0) {
            colour = ColourUtils.HSV_TO_RGB[ColourUtils.hslToHsv(ColourUtils.method3066(textureSource.getMetrics(texture).aShort37)) & 0xFFFF] | 0xFF000000;
        } else if (type.colour == -1) {
            colour = 0;
        } else {
            @Pc(27) int local27 = type.colour;
            @Pc(33) int local33 = (local27 & 0x7F) + arg3;
            if (local33 < 0) {
                local33 = 0;
            } else if (local33 > 127) {
                local33 = 127;
            }
            @Pc(55) int local55 = (local27 + arg2 & 0xFC00) + (local27 & 0x380) + local33;
            colour = ColourUtils.HSV_TO_RGB[ColourUtils.hslToHsv(ColourUtils.method3066(local55)) & 0xFFFF] | 0xFF000000;
        }

        return colour;
    }

    @OriginalMember(owner = "client!baa", name = "c", descriptor = "()V")
    public static void method5069() {
        aByteArray57 = new byte[areaWidth * areaHeight];
        aByteArray60 = new byte[areaWidth * areaHeight];
        aByteArray59 = new byte[areaWidth * areaHeight];
        aShortArray78 = new short[areaWidth * areaHeight];
        aByteArray58 = new byte[areaWidth * areaHeight];
        aIterableHashTable = new IterableHashTable(1024);
        tiles = new LinkedList[3][areaWidth >> 6][areaHeight >> 6];
        overlayColours = new int[floorOverlayTypeList.num + 1];
    }

    @OriginalMember(owner = "client!baa", name = "d", descriptor = "()V")
    public static void method5070() {
        aByteArray57 = null;
        aByteArray56 = null;
        aShortArray79 = null;
        aByteArray60 = null;
        aByteArray59 = null;
        aShortArray78 = null;
        aByteArray58 = null;
        aIterableHashTable = null;
        tiles = null;
        overlayColours = null;
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;Lclient!fu;Lclient!el;)V")
    public static void method5071(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) MapElementListEntry arg1, @OriginalArg(2) MapElementType arg2) {
        if (arg2.landmarkPolygons == null) {
            return;
        }
        @Pc(7) int[] local7 = new int[arg2.landmarkPolygons.length];
        @Pc(20) int local20;
        @Pc(32) int local32;
        for (@Pc(9) int local9 = 0; local9 < local7.length / 2; local9++) {
            local20 = arg2.landmarkPolygons[local9 * 2] + arg1.x;
            local32 = arg2.landmarkPolygons[local9 * 2 + 1] + arg1.y;
            local7[local9 * 2] = anInt5649 + (anInt5651 - anInt5649) * (local20 - anInt5652) / (anInt5647 - anInt5652);
            local7[local9 * 2 + 1] = anInt5646 - (anInt5646 - anInt5653) * (local32 - anInt5654) / (anInt5645 - anInt5654);
        }
        Static141.method2371(arg0, local7, arg2.landmarkBackground);
        if (arg2.anInt2603 > 0) {
            @Pc(102) int local102;
            @Pc(110) int local110;
            @Pc(120) int local120;
            @Pc(125) int local125;
            @Pc(127) int local127;
            for (local20 = 0; local20 < local7.length / 2 - 1; local20++) {
                local32 = local7[local20 * 2];
                local102 = local7[local20 * 2 + 1];
                local110 = local7[(local20 + 1) * 2];
                local120 = local7[(local20 + 1) * 2 + 1];
                if (local110 < local32) {
                    local125 = local32;
                    local127 = local102;
                    local32 = local110;
                    local102 = local120;
                    local110 = local125;
                    local120 = local127;
                } else if (local110 == local32 && local120 < local102) {
                    local125 = local102;
                    local102 = local120;
                    local120 = local125;
                }
                arg0.method7995(local32, local102, local110, local120, arg2.landmarkPalette[arg2.landmarkColorIndices[local20] & 0xFF], arg2.anInt2603, arg2.anInt2587, arg2.anInt2607);
            }
            local32 = local7[local7.length - 2];
            local102 = local7[local7.length - 1];
            local110 = local7[0];
            local120 = local7[1];
            if (local110 < local32) {
                local125 = local32;
                local127 = local102;
                local32 = local110;
                local102 = local120;
                local110 = local125;
                local120 = local127;
            } else if (local110 == local32 && local120 < local102) {
                local125 = local102;
                local102 = local120;
                local120 = local125;
            }
            arg0.method7995(local32, local102, local110, local120, arg2.landmarkPalette[arg2.landmarkColorIndices[arg2.landmarkColorIndices.length - 1] & 0xFF], arg2.anInt2603, arg2.anInt2587, arg2.anInt2607);
            return;
        }
        for (local20 = 0; local20 < local7.length / 2 - 1; local20++) {
            arg0.line(local7[(local20 + 1) * 2 + 1], local7[local20 * 2 + 1], local7[(local20 + 1) * 2], arg2.landmarkPalette[arg2.landmarkColorIndices[local20] & 0xFF], local7[local20 * 2]);
        }
        arg0.line(local7[1], local7[local7.length - 1], local7[0], arg2.landmarkPalette[arg2.landmarkColorIndices[arg2.landmarkColorIndices.length - 1] & 0xFF], local7[local7.length - 2]);
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;Lclient!fu;IIII)V")
    public static void method5073(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) MapElementListEntry arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        arg1.anInt3130 = anInt5649 + (arg2 * (arg1.x - anInt5652) >> 16);
        arg1.anInt3122 = anInt5646 - (arg3 * (arg1.y - anInt5654) >> 16);
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;Lclient!ge;IIII[I[I)V")
    public static void decodeTile(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) Packet packet, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int[] arg6, @OriginalArg(7) int[] arg7) {
        @Pc(3) int data = packet.g1();
        if ((data & 0x1) == 0) {
            @Pc(15) boolean local15 = (data & 0x2) == 0;
            @Pc(21) int local21 = data >> 2 & 0x3F;
            if (local21 != 62) {
                if (local21 == 63) {
                    local21 = packet.g1();
                } else if (local15) {
                    local21 = arg6[local21];
                } else {
                    local21 = arg7[local21];
                }
                if (local15) {
                    aByteArray57[arg4 + arg5 * areaWidth] = (byte) local21;
                    aByteArray60[arg4 + arg5 * areaWidth] = 0;
                } else {
                    aByteArray60[arg4 + arg5 * areaWidth] = (byte) local21;
                    aByteArray59[arg4 + arg5 * areaWidth] = 0;
                    aByteArray57[arg4 + arg5 * areaWidth] = packet.g1b();
                }
            }
            return;
        }

        @Pc(100) int local100 = (data >> 1 & 0x3) + 1;
        @Pc(108) boolean local108 = (data & 0x8) != 0;
        @Pc(116) boolean local116 = (data & 0x10) != 0;
        for (@Pc(118) int local118 = 0; local118 < local100; local118++) {
            @Pc(123) int local123 = packet.g1();
            @Pc(125) int local125 = 0;
            @Pc(127) int local127 = 0;
            if (local108) {
                local125 = packet.g1();
                local127 = packet.g1();
            }
            @Pc(139) int local139 = 0;
            if (local116) {
                local139 = packet.g1();
            }
            @Pc(215) short[] local215;
            @Pc(218) byte[] local218;
            @Pc(220) int local220;
            if (local118 == 0) {
                aByteArray57[arg4 + arg5 * areaWidth] = (byte) local123;
                aByteArray60[arg4 + arg5 * areaWidth] = (byte) local125;
                aByteArray59[arg4 + arg5 * areaWidth] = (byte) local127;
                if (local139 == 1) {
                    aShortArray78[arg4 + arg5 * areaWidth] = (short) (packet.g2() + 1);
                    aByteArray58[arg4 + arg5 * areaWidth] = packet.g1b();
                } else if (local139 > 1) {
                    aShortArray78[arg4 + arg5 * areaWidth] = -1;
                    local215 = new short[local139];
                    local218 = new byte[local139];
                    for (local220 = 0; local220 < local139; local220++) {
                        local215[local220] = (short) packet.g2();
                        local218[local220] = packet.g1b();
                    }
                    aIterableHashTable.put(arg4 << 16 | arg5, new Node_Sub23(local215, local218));
                }
            } else {
                local215 = null;
                local218 = null;
                if (local139 > 0) {
                    local215 = new short[local139];
                    local218 = new byte[local139];
                    for (local220 = 0; local220 < local139; local220++) {
                        local215[local220] = (short) packet.g2();
                        local218[local220] = packet.g1b();
                    }
                }
                if (tiles[local118 - 1][arg2 - (areaX >> 6)][arg3 - (areaY >> 6)] == null) {
                    tiles[local118 - 1][arg2 - (areaX >> 6)][arg3 - (areaY >> 6)] = new LinkedList();
                }
                @Pc(338) WorldMapTile tile = new WorldMapTile(arg4 & 0x3F, arg5 & 0x3F, local123, local125, local127, local215, local218);
                tiles[local118 - 1][arg2 - (areaX >> 6)][arg3 - (areaY >> 6)].add(tile);
            }
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "()V")
    public static void method5075() {
        @Pc(4) int local4;
        @Pc(15) int local15;
        @Pc(49) int local49;
        for (@Pc(1) int local1 = 0; local1 < areaWidth; local1++) {
            for (local4 = 0; local4 < areaHeight; local4++) {
                local15 = aShortArray78[local1 + local4 * areaWidth] & 0xFFFF;
                if (local15 != 0) {
                    @Pc(35) int local35;
                    if (local15 == 65535) {
                        @Pc(31) Node_Sub23 local31 = (Node_Sub23) aIterableHashTable.get(local1 << 16 | local4);
                        if (local31 != null) {
                            for (local35 = 0; local35 < local31.aShortArray59.length; local35++) {
                                @Pc(46) LocType local46 = locTypeList.list(local31.aShortArray59[local35] & 0xFFFF);
                                local49 = local46.mapelement;
                                if (local46.multiloc != null) {
                                    local46 = local46.getMultiLoc(varDomain);
                                    if (local46 != null) {
                                        local49 = local46.mapelement;
                                    }
                                }
                                if (local49 != -1) {
                                    @Pc(70) MapElementListEntry local70 = new MapElementListEntry(local49);
                                    local70.x = local1;
                                    local70.y = local4;
                                    elements.addLast(local70);
                                }
                            }
                        }
                    } else {
                        @Pc(94) LocType local94 = locTypeList.list(local15 - 1);
                        local35 = local94.mapelement;
                        if (local94.multiloc != null) {
                            local94 = local94.getMultiLoc(varDomain);
                            if (local94 != null) {
                                local35 = local94.mapelement;
                            }
                        }
                        if (local35 != -1) {
                            @Pc(118) MapElementListEntry local118 = new MapElementListEntry(local35);
                            local118.x = local1;
                            local118.y = local4;
                            elements.addLast(local118);
                        }
                    }
                }
            }
        }
        for (local4 = 0; local4 < 3; local4++) {
            for (local15 = 0; local15 < tiles[0].length; local15++) {
                for (@Pc(144) int local144 = 0; local144 < tiles[0][0].length; local144++) {
                    @Pc(153) LinkedList local153 = tiles[local4][local15][local144];
                    if (local153 != null) {
                        for (@Pc(160) WorldMapTile local160 = (WorldMapTile) local153.first(); local160 != null; local160 = (WorldMapTile) local153.next()) {
                            if (local160.aShortArray133 != null) {
                                for (local49 = 0; local49 < local160.aShortArray133.length; local49++) {
                                    @Pc(177) LocType local177 = locTypeList.list(local160.aShortArray133[local49] & 0xFFFF);
                                    @Pc(180) int local180 = local177.mapelement;
                                    if (local177.multiloc != null) {
                                        local177 = local177.getMultiLoc(varDomain);
                                        if (local177 != null) {
                                            local180 = local177.mapelement;
                                        }
                                    }
                                    if (local180 != -1) {
                                        @Pc(201) MapElementListEntry local201 = new MapElementListEntry(local180);
                                        local201.x = (local15 + (areaX >> 6)) * 64 + local160.aByte138 - areaX;
                                        local201.y = (local144 + (areaY >> 6)) * 64 + local160.aByte139 - areaY;
                                        elements.addLast(local201);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!baa", name = "b", descriptor = "(II)Lclient!jga;")
    public static Queue method5076(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(3) Queue local3 = new Queue();
        for (@Pc(8) WorldMapArea local8 = (WorldMapArea) areas.first(); local8 != null; local8 = (WorldMapArea) areas.next()) {
            if (local8.aBoolean354 && local8.contains(arg0, arg1)) {
                local3.add(local8);
            }
        }
        return local3;
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(II)Lclient!ip;")
    public static WorldMapArea method5078(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        for (@Pc(4) WorldMapArea area = (WorldMapArea) areas.first(); area != null; area = (WorldMapArea) areas.next()) {
            if (area.aBoolean354 && area.contains(arg0, arg1)) {
                return area;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!baa", name = "e", descriptor = "()V")
    public static void method5079() {
        @Pc(2) int[] local2 = new int[3];
        for (@Pc(4) int local4 = 0; local4 < staticElements.size; local4++) {
            @Pc(32) boolean local32 = area.method4088(local2, staticElements.coords[local4] & 0x3FFF, staticElements.coords[local4] >> 28 & 0x3, staticElements.coords[local4] >> 14 & 0x3FFF);
            if (local32) {
                @Pc(42) MapElementListEntry local42 = new MapElementListEntry(staticElements.elements[local4]);
                local42.x = local2[1] - areaX;
                local42.y = local2[2] - areaY;
                elements.addLast(local42);
            }
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;II)V")
    public static void method5080(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(11) Packet local11 = new Packet(data.getfile(area.file, "area"));
        @Pc(15) int local15 = local11.g1();
        @Pc(18) int[] local18 = new int[local15];
        for (@Pc(20) int local20 = 0; local20 < local15; local20++) {
            local18[local20] = local11.g1();
        }
        @Pc(35) int local35 = local11.g1();
        @Pc(38) int[] local38 = new int[local35];
        for (@Pc(40) int local40 = 0; local40 < local35; local40++) {
            local38[local40] = local11.g1();
        }
        while (true) {
            @Pc(60) int local60;
            @Pc(66) int local66;
            @Pc(69) int local69;
            @Pc(78) int local78;
            @Pc(150) int local150;
            while (local11.pos < local11.data.length) {
                @Pc(64) int local64;
                @Pc(86) int local86;
                if (local11.g1() == 0) {
                    local60 = local11.g1();
                    local64 = local11.g1();
                    for (local66 = 0; local66 < 64; local66++) {
                        for (local69 = 0; local69 < 64; local69++) {
                            local78 = local60 * 64 + local66 - areaX;
                            local86 = local64 * 64 + local69 - areaY;
                            decodeTile(arg0, local11, local60, local64, local78, local86, local18, local38);
                        }
                    }
                } else {
                    local60 = local11.g1();
                    local64 = local11.g1();
                    local66 = local11.g1();
                    local69 = local11.g1();
                    for (local78 = 0; local78 < 8; local78++) {
                        for (local86 = 0; local86 < 8; local86++) {
                            @Pc(138) int local138 = local60 * 64 + local66 * 8 + local78 - areaX;
                            local150 = local64 * 64 + local69 * 8 + local86 - areaY;
                            decodeTile(arg0, local11, local60, local64, local138, local150, local18, local38);
                        }
                    }
                }
            }
            aByteArray56 = new byte[areaWidth * areaHeight];
            aShortArray79 = new short[areaWidth * areaHeight];
            for (local60 = 0; local60 < 3; local60++) {
                @Pc(193) byte[] local193 = new byte[areaWidth * areaHeight];
                for (local66 = 0; local66 < tiles[local60].length; local66++) {
                    for (local69 = 0; local69 < tiles[local60][0].length; local69++) {
                        @Pc(207) LinkedList local207 = tiles[local60][local66][local69];
                        if (local207 != null) {
                            for (@Pc(214) WorldMapTile local214 = (WorldMapTile) local207.first(); local214 != null; local214 = (WorldMapTile) local207.next()) {
                                local193[local66 * 64 + local214.aByte138 + (local69 * 64 + local214.aByte139) * areaWidth] = (byte) local214.anInt9770;
                            }
                        }
                    }
                }
                method5064(local193, aByteArray56, aShortArray79, arg1, arg2);
                for (local69 = 0; local69 < tiles[local60].length; local69++) {
                    for (local78 = 0; local78 < tiles[local60][0].length; local78++) {
                        @Pc(278) LinkedList local278 = tiles[local60][local69][local78];
                        if (local278 != null) {
                            for (@Pc(285) WorldMapTile local285 = (WorldMapTile) local278.first(); local285 != null; local285 = (WorldMapTile) local278.next()) {
                                local150 = local69 * 64 + local285.aByte138 + (local78 * 64 + local285.aByte139) * areaWidth;
                                local285.anInt9770 = (aByteArray56[local150] & 0xFF) << 16 | aShortArray79[local150] & 0xFFFF;
                                if (local285.anInt9770 != 0) {
                                    local285.anInt9770 |= 0xFF000000;
                                }
                            }
                        }
                    }
                }
            }
            method5064(aByteArray57, aByteArray56, aShortArray79, arg1, arg2);
            aByteArray57 = null;
            method5075();
            return;
        }
    }

    @OriginalMember(owner = "client!baa", name = "b", descriptor = "(Lclient!ha;)Lclient!sia;")
    public static Deque method5081(@OriginalArg(0) Toolkit arg0) {
        @Pc(3) int local3 = anInt5647 - anInt5652;
        @Pc(7) int local7 = anInt5645 - anInt5654;
        @Pc(15) int local15 = (anInt5651 - anInt5649 << 16) / local3;
        @Pc(23) int local23 = (anInt5646 - anInt5653 << 16) / local7;
        return method5082(arg0, local15, local23);
    }

    @OriginalMember(owner = "client!baa", name = "b", descriptor = "(Lclient!ha;IIII)Lclient!sia;")
    public static Deque method5082(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        for (@Pc(4) MapElementListEntry entry = (MapElementListEntry) elements.first(); entry != null; entry = (MapElementListEntry) elements.next()) {
            method5073(arg0, entry, arg1, arg2);
        }
        return elements;
    }

    @OriginalMember(owner = "client!aaa", name = "b", descriptor = "(II)V")
    public static void setZoomPercentage(@OriginalArg(1) int percentage) {
        if (percentage == 37) {
            targetZoom = 3.0F;
        } else if (percentage == 50) {
            targetZoom = 4.0F;
        } else if (percentage == 75) {
            targetZoom = 6.0F;
        } else if (percentage == 100) {
            targetZoom = 8.0F;
        } else if (percentage == 200) {
            targetZoom = 16.0F;
        }

        anInt3181 = -1;
        anInt3181 = -1;
    }

    @OriginalMember(owner = "client!om", name = "a", descriptor = "(Z)I")
    public static int getZoom() {
        if ((double) targetZoom == 3.0D) {
            return 37;
        } else if ((double) targetZoom == 4.0D) {
            return 50;
        } else if ((double) targetZoom == 6.0D) {
            return 75;
        } else if ((double) targetZoom == 8.0D) {
            return 100;
        } else {
            return 200;
        }
    }

    @OriginalMember(owner = "client!bw", name = "a", descriptor = "(IZIII)V")
    public static void method1293(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        if (ClientOptions.instance.toolkit.getValue() == ToolkitType.JAVA) {
            reset(false);
        } else {
            Static114.toolkitType = ClientOptions.instance.toolkit.getValue();
            Static32.setToolkit(ToolkitType.JAVA, true);
        }
        Static696.aBoolean784 = arg1;
        Static529.anInt8089 = arg2;
        Static227.anInt3694 = arg3;
        setArea(arg0);
        if (arg4 != -11493) {
            Static60.aBoolean86 = false;
        }
    }

    private WorldMap() {
        /* empty */
    }

    @OriginalMember(owner = "client!vca", name = "a", descriptor = "(ZI)V")
    public static void reset(@OriginalArg(0) boolean saveArea) {
        if (saveArea && area != null) {
            lastAreaId = area.id;
        } else {
            lastAreaId = -1;
        }

        aDeque_54 = null;
        component = null;
        area = null;
        loadingPercent = 0;
        method5070();
        elements.clear();
        Static359.aClass327_3 = null;
        Static484.aClass327_6 = null;
        staticElements = null;
        Static651.aClass327_8 = null;
        Static180.anInt3001 = -1;
        Static13.aSprite_4 = null;
        Static142.aClass327_1 = null;
        Static390.aClass327_5 = null;
        Static559.aClass327_7 = null;
        Static364.aClass327_4 = null;
        Static275.aClass327_2 = null;
        anInt3181 = -1;
        if (mapElementTypeList != null) {
            mapElementTypeList.cacheReset();
            mapElementTypeList.setCaches(128, 64);
        }
        if (msiTypeList != null) {
            msiTypeList.setCache(64, 64);
        }
        if (locTypeList != null) {
            locTypeList.setRecentUse(64);
        }
        VarBitTypeListClient.instance.cacheReset(64);
    }

    @OriginalMember(owner = "client!tc", name = "e", descriptor = "(I)V")
    public static void method7934() {
        if (lastAreaId != -1) {
            method1293(lastAreaId, false, -1, -1, -11493);
            lastAreaId = -1;
        }
    }

    @OriginalMember(owner = "client!vd", name = "a", descriptor = "(II)V")
    public static void method8711(@OriginalArg(0) int arg0) {
        Static180.anInt3001 = -1;
        anInt3181 = -1;
        anInt2809 = arg0;
        method5440();
    }
}
