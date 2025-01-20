import com.jagex.Client;
import com.jagex.core.constants.LocLayer;
import com.jagex.core.constants.LocShapes;
import com.jagex.core.constants.TileFlag;
import com.jagex.core.io.Packet;
import com.jagex.game.Location;
import com.jagex.game.collision.CollisionMap;
import com.jagex.game.runetek6.config.flotype.FloorOverlayTypeList;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayTypeList;
import com.jagex.game.runetek6.config.lighttype.LightType;
import com.jagex.game.runetek6.config.lighttype.LightTypeList;
import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocOcclusionMode;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.graphics.EnvironmentLight;
import com.jagex.graphics.Ground;
import com.jagex.graphics.PointLight;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!taa")
public final class MapRegion extends Class306 {

    @OriginalMember(owner = "client!pf", name = "q", descriptor = "[I")
    public static final int[] WALLDECOR_STRAIGHT_XOFFSET = {1, 0, -1, 0};

    @OriginalMember(owner = "client!tea", name = "g", descriptor = "[I")
    public static final int[] WALLDECOR_STRAIGHT_ZOFFSET = {0, -1, 0, 1};

    @OriginalMember(owner = "client!mr", name = "e", descriptor = "[I")
    public static final int[] WALLDECOR_DIAGONAL_XOFFSET = {1, -1, -1, 1};

    @OriginalMember(owner = "client!uba", name = "e", descriptor = "[I")
    public static final int[] WALLDECOR_DIAGONAL_ZOFFSET = {-1, -1, 1, 1};

    @OriginalMember(owner = "client!th", name = "b", descriptor = "Z")
    public static final boolean occlude = false;

    @OriginalMember(owner = "client!ui", name = "m", descriptor = "Z")
    public static final boolean forceOcclusion = false;

    // $FF: synthetic field
    @OriginalMember(owner = "client!taa", name = "O", descriptor = "Ljava/lang/Class;")
    public static Class locClass;

    @OriginalMember(owner = "client!aaa", name = "L", descriptor = "Lclient!taa;")
    public static MapRegion active;

    @OriginalMember(owner = "client!taa", name = "K", descriptor = "I")
    public int maxLevel = 99;

    @OriginalMember(owner = "client!taa", name = "<init>", descriptor = "(IIIZ)V")
    public MapRegion(@OriginalArg(0) int levels, @OriginalArg(1) int mapWidth, @OriginalArg(2) int mapLength, @OriginalArg(3) boolean underwater) {
        super(levels, mapWidth, mapLength, underwater, FloorOverlayTypeList.instance, FloorUnderlayTypeList.instance);
    }

    @OriginalMember(owner = "client!aq", name = "a", descriptor = "(ZIII)I")
    public static int rotateLightX(@OriginalArg(1) int x, @OriginalArg(2) int z, @OriginalArg(3) int rotation) {
        @Pc(3) int maskedRotation = rotation & 0x3;
        if (maskedRotation == 0) {
            return x;
        } else if (maskedRotation == 1) {
            return z;
        } else if (maskedRotation == 2) {
            return 4095 - x;
        } else {
            return 4095 - z;
        }
    }

    @OriginalMember(owner = "client!pf", name = "a", descriptor = "(IIII)I")
    public static int rotateLightZ(@OriginalArg(2) int x, @OriginalArg(0) int z, @OriginalArg(1) int rotation) {
        @Pc(3) int maskedRotation = rotation & 0x3;
        if (maskedRotation == 0) {
            return z;
        } else if (maskedRotation == 1) {
            return 4095 - x;
        } else if (maskedRotation == 2) {
            return 4095 - z;
        } else {
            return x;
        }
    }

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(Lclient!th;)V")
    public static void method9122(@OriginalArg(0) EnvironmentLight arg0) {
        if (Static319.anInt5080 >= 65535) {
            return;
        }
        @Pc(7) PointLight local7 = arg0.light;
        EnvironmentLight.aEnvironmentLightArray1[Static319.anInt5080] = arg0;
        Static279.aBooleanArray11[Static319.anInt5080] = false;
        Static319.anInt5080++;
        @Pc(22) int local22 = arg0.level;
        if (arg0.aBoolean716) {
            local22 = 0;
        }
        @Pc(30) int local30 = arg0.level;
        if (arg0.aBoolean717) {
            local30 = Static299.tileMaxLevel - 1;
        }
        for (@Pc(39) int local39 = local22; local39 <= local30; local39++) {
            @Pc(42) int local42 = 0;
            @Pc(54) int local54 = local7.getZ() + EnvironmentLight.anInt3993 - local7.getRange() >> EnvironmentLight.anInt1066;
            if (local54 < 0) {
                local42 = -local54;
                local54 = 0;
            }
            @Pc(74) int local74 = local7.getZ() + local7.getRange() - EnvironmentLight.anInt3993 >> EnvironmentLight.anInt1066;
            if (local74 >= Static662.tileMaxZ) {
                local74 = Static662.tileMaxZ - 1;
            }
            for (@Pc(83) int local83 = local54; local83 <= local74; local83++) {
                @Pc(90) short local90 = arg0.aShortArray131[local42++];
                @Pc(106) int local106 = (local7.getX() + EnvironmentLight.anInt3993 - local7.getRange() >> EnvironmentLight.anInt1066) + (local90 >>> 8);
                @Pc(114) int local114 = local106 + (local90 & 0xFF) - 1;
                if (local106 < 0) {
                    local106 = 0;
                }
                if (local114 >= Static619.tileMaxX) {
                    local114 = Static619.tileMaxX - 1;
                }
                for (@Pc(127) int local127 = local106; local127 <= local114; local127++) {
                    @Pc(136) long local136 = Client.tileLightFlags[local39][local127][local83];
                    if ((local136 & 0xFFFFL) == 0L) {
                        Client.tileLightFlags[local39][local127][local83] = local136 | (long) Static319.anInt5080;
                    } else if ((local136 & 0xFFFF0000L) == 0L) {
                        Client.tileLightFlags[local39][local127][local83] = local136 | (long) Static319.anInt5080 << 16;
                    } else if ((local136 & 0xFFFF00000000L) == 0L) {
                        Client.tileLightFlags[local39][local127][local83] = local136 | (long) Static319.anInt5080 << 32;
                    } else if ((local136 & 0xFFFF000000000000L) == 0L) {
                        Client.tileLightFlags[local39][local127][local83] = local136 | (long) Static319.anInt5080 << 48;
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!ua", name = "a", descriptor = "(IIII)I")
    public static int rotateZoneX(@OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(3) int rotation) {
        @Pc(3) int maskedRotation = rotation & 0x3;
        if (maskedRotation == 0) {
            return x;
        } else if (maskedRotation == 1) {
            return z;
        } else if (maskedRotation == 2) {
            return 7 - x;
        } else {
            return 7 - z;
        }
    }

    @OriginalMember(owner = "client!qm", name = "a", descriptor = "(IIBI)I")
    public static int rotateZoneY(@OriginalArg(1) int x, @OriginalArg(0) int z, @OriginalArg(3) int rotation) {
        @Pc(7) int maskedRotation = rotation & 0x3;
        if (maskedRotation == 0) {
            return z;
        } else if (maskedRotation == 1) {
            return 7 - x;
        } else if (maskedRotation == 2) {
            return 7 - z;
        } else {
            return x;
        }
    }

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "(IIBIIII)I")
    public static int rotateLocX(@OriginalArg(5) int x, @OriginalArg(1) int z, @OriginalArg(0) int width, @OriginalArg(3) int length, @OriginalArg(6) int rotation, @OriginalArg(4) int locRotation) {
        @Pc(3) int maskedRotation = rotation & 0x3;
        if ((locRotation & 0x1) == 1) {
            @Pc(10) int temp = width;
            width = length;
            length = temp;
        }

        if (maskedRotation == 0) {
            return x;
        } else if (maskedRotation == 1) {
            return z;
        } else if (maskedRotation == 2) {
            return 7 + 1 - x - width;
        } else {
            return 7 + 1 - z - length;
        }
    }

    @OriginalMember(owner = "client!qga", name = "a", descriptor = "(IIIIIII)I")
    public static int rotateLocZ(@OriginalArg(5) int x, @OriginalArg(1) int z, @OriginalArg(4) int width, @OriginalArg(2) int length, @OriginalArg(0) int rotation, @OriginalArg(3) int locRotation) {
        if ((locRotation & 0x1) == 1) {
            @Pc(12) int temp = width;
            width = length;
            length = temp;
        }

        @Pc(20) int maskedRotation = rotation & 0x3;
        if (maskedRotation == 0) {
            return z;
        } else if (maskedRotation == 1) {
            return 1 + 7 - width - x;
        } else if (maskedRotation == 2) {
            return 1 + 7 - length - z;
        } else {
            return x;
        }
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(III[Lclient!eq;Lclient!ha;[B)V")
    public void loadLocations(@OriginalArg(0) int offsetX, @OriginalArg(1) int offsetZ, @OriginalArg(3) CollisionMap[] arg2, @OriginalArg(4) Toolkit toolkit, @OriginalArg(5) byte[] arg4) {
        @Pc(8) Packet packet = new Packet(arg4);
        @Pc(18) int id = -1;
        while (true) {
            @Pc(22) int idOffset = packet.gExtended1or2();
            if (idOffset == 0) {
                return;
            }
            id += idOffset;

            @Pc(30) int coord = 0;
            while (true) {
                @Pc(34) int coordOffset = packet.gsmart();
                if (coordOffset == 0) {
                    break;
                }
                coord += coordOffset - 1;

                @Pc(46) int locZ = coord & 0x3F;
                @Pc(52) int locX = coord >> 6 & 0x3F;
                @Pc(56) int locLevel = coord >> 12;
                @Pc(60) int shapeAndRotation = packet.g1();
                @Pc(64) int locShape = shapeAndRotation >> 2;
                @Pc(68) int locRotation = shapeAndRotation & 0x3;
                @Pc(73) int x = locX + offsetX;
                @Pc(77) int z = locZ + offsetZ;
                if (x > 0 && z > 0 && x < super.width - 1 && z < super.length - 1) {
                    @Pc(102) CollisionMap collisionMap = null;
                    if (!super.underwater) {
                        @Pc(107) int actualLevel = locLevel;
                        if ((Static280.tileFlags[1][x][z] & TileFlag.BRIDGE) == 2) {
                            actualLevel = locLevel - 1;
                        }
                        if (actualLevel >= 0) {
                            collisionMap = arg2[actualLevel];
                        }
                    }
                    this.loadLocation(x, z, locLevel, locLevel, id, locShape, locRotation, -1, collisionMap, toolkit);
                }
            }
        }
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(ILclient!ge;ILclient!ha;I)V")
    public void method7893(@OriginalArg(0) int arg0, @OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Toolkit arg3) {
        if (super.underwater) {
            return;
        }
        @Pc(10) boolean local10 = false;
        @Pc(12) Environment local12 = null;
        while (true) {
            while (true) {
                while (true) {
                    while (true) {
                        @Pc(28) int local28;
                        @Pc(86) int local86;
                        @Pc(504) int local504;
                        @Pc(143) int local143;
                        @Pc(147) int local147;
                        while (arg1.data.length > arg1.pos) {
                            local28 = arg1.g1();
                            if (local28 != 0) {
                                @Pc(149) int local149;
                                @Pc(153) int local153;
                                @Pc(290) int local290;
                                if (local28 == 1) {
                                    local86 = arg1.g1();
                                    if (local86 > 0) {
                                        for (local504 = 0; local504 < local86; local504++) {
                                            @Pc(512) EnvironmentLight local512 = new EnvironmentLight(arg3, arg1, 2);
                                            if (local512.preset == 31) {
                                                @Pc(523) LightType local523 = LightTypeList.instance.list(arg1.g2());
                                                local512.updateParameters(local523.ambient, local523.pattern, local523.amplitude, local523.frequency);
                                            }
                                            if (arg3.getMaxLights() > 0) {
                                                @Pc(543) PointLight local543 = local512.light;
                                                local149 = (arg2 << 9) + local543.getX();
                                                local153 = (arg0 << 9) + local543.getZ();
                                                local290 = local149 >> 9;
                                                @Pc(567) int local567 = local153 >> 9;
                                                if (local290 >= 0 && local567 >= 0 && super.width > local290 && super.length > local567) {
                                                    local543.setPosition(local149, local153, super.tileHeights[local512.level][local290][local567] - local543.getY());
                                                    method9122(local512);
                                                }
                                            }
                                        }
                                    }
                                } else if (local28 == 2) {
                                    if (local12 == null) {
                                        local12 = new Environment();
                                    }
                                    local12.decodeBloomParams(arg1);
                                } else if (local28 == 128) {
                                    if (local12 == null) {
                                        local12 = new Environment();
                                    }
                                    local12.method8384(arg1);
                                } else if (local28 == 129) {
                                    if (super.aByteArrayArrayArray12 == null) {
                                        super.aByteArrayArrayArray12 = new byte[4][][];
                                    }
                                    local10 = true;
                                    for (local86 = 0; local86 < 4; local86++) {
                                        @Pc(91) byte local91 = arg1.g1b();
                                        if (local91 == 0 && super.aByteArrayArrayArray12[local86] != null) {
                                            local143 = arg2;
                                            local147 = arg2 + 64;
                                            local149 = arg0;
                                            local153 = arg0 + 64;
                                            if (arg2 < 0) {
                                                local143 = 0;
                                            } else if (arg2 >= super.width) {
                                                local143 = super.width;
                                            }
                                            if (arg0 < 0) {
                                                local149 = 0;
                                            } else if (arg0 >= super.length) {
                                                local149 = super.length;
                                            }
                                            if (local147 < 0) {
                                                local147 = 0;
                                            } else if (super.width <= local147) {
                                                local147 = super.width;
                                            }
                                            if (local153 < 0) {
                                                local153 = 0;
                                            } else if (local153 >= super.length) {
                                                local153 = super.length;
                                            }
                                            while (local147 > local143) {
                                                while (local149 < local153) {
                                                    super.aByteArrayArrayArray12[local86][local143][local149] = 0;
                                                    local149++;
                                                }
                                                local143++;
                                            }
                                        } else if (local91 == 1) {
                                            if (super.aByteArrayArrayArray12[local86] == null) {
                                                super.aByteArrayArrayArray12[local86] = new byte[super.width + 1][super.length + 1];
                                            }
                                            for (local143 = 0; local143 < 64; local143 += 4) {
                                                for (local147 = 0; local147 < 64; local147 += 4) {
                                                    @Pc(280) byte local280 = arg1.g1b();
                                                    for (local153 = local143 + arg2; local153 < local143 + arg2 + 4; local153++) {
                                                        for (local290 = arg0 + local147; local290 < arg0 + local147 + 4; local290++) {
                                                            if (local153 >= 0 && super.width > local153 && local290 >= 0 && super.length > local290) {
                                                                super.aByteArrayArrayArray12[local86][local153][local290] = local280;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (local91 == 2) {
                                            if (super.aByteArrayArrayArray12[local86] == null) {
                                                super.aByteArrayArrayArray12[local86] = new byte[super.width + 1][super.length + 1];
                                            }
                                            if (local86 > 0) {
                                                local143 = arg2;
                                                local147 = arg2 + 64;
                                                local149 = arg0;
                                                local153 = arg0 + 64;
                                                if (local147 < 0) {
                                                    local147 = 0;
                                                } else if (super.width <= local147) {
                                                    local147 = super.width;
                                                }
                                                if (arg2 < 0) {
                                                    local143 = 0;
                                                } else if (arg2 >= super.width) {
                                                    local143 = super.width;
                                                }
                                                if (arg0 < 0) {
                                                    local149 = 0;
                                                } else if (arg0 >= super.length) {
                                                    local149 = super.length;
                                                }
                                                if (local153 < 0) {
                                                    local153 = 0;
                                                } else if (local153 >= super.length) {
                                                    local153 = super.length;
                                                }
                                                while (local143 < local147) {
                                                    while (local153 > local149) {
                                                        super.aByteArrayArrayArray12[local86][local143][local149] = super.aByteArrayArrayArray12[local86 - 1][local143][local149];
                                                        local149++;
                                                    }
                                                    local143++;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    throw new IllegalStateException("");
                                }
                            } else if (local12 == null) {
                                local12 = new Environment(arg1);
                            } else {
                                local12.method8386(arg1);
                            }
                        }
                        if (local12 != null) {
                            for (local28 = 0; local28 < 8; local28++) {
                                for (local86 = 0; local86 < 8; local86++) {
                                    local504 = local28 + (arg2 >> 3);
                                    local143 = local86 + (arg0 >> 3);
                                    if (local504 >= 0 && super.width >> 3 > local504 && local143 >= 0 && super.length >> 3 > local143) {
                                        Static108.method2064(local143, local504, local12);
                                    }
                                }
                            }
                        }
                        if (!local10 && super.aByteArrayArrayArray12 != null) {
                            for (local28 = 0; local28 < 4; local28++) {
                                if (super.aByteArrayArrayArray12[local28] != null) {
                                    for (local86 = 0; local86 < 16; local86++) {
                                        for (local504 = 0; local504 < 16; local504++) {
                                            local143 = (arg2 >> 2) + local86;
                                            local147 = (arg0 >> 2) + local504;
                                            if (local143 >= 0 && local143 < 26 && local147 >= 0 && local147 < 26) {
                                                super.aByteArrayArrayArray12[local28][local143][local147] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(IILclient!eq;ILclient!ha;IIIIII)V")
    public void loadLocation(@OriginalArg(5) int x, @OriginalArg(3) int z, @OriginalArg(9) int level, @OriginalArg(8) int virtualLevel, @OriginalArg(1) int id, @OriginalArg(0) int shape, @OriginalArg(6) int rotation, @OriginalArg(10) int animation, @OriginalArg(2) CollisionMap collisionMap, @OriginalArg(4) Toolkit toolkit) {
        boolean animatingBackground = ClientOptions.instance.animateBackground.getValue() != 0;
        boolean tileVisible = Static696.isTileVisibleFrom(z, Static164.areaLevel, x, virtualLevel);
        if (!animatingBackground && !tileVisible) {
            return;
        }

        if (level < this.maxLevel) {
            this.maxLevel = level;
        }

        @Pc(40) LocType locType = LocTypeList.instance.list(id);
        boolean texturesEnabled = ClientOptions.instance.textures.getValue() == 0;
        if (texturesEnabled && locType.istexture) {
            return;
        }

        @Pc(65) int locWidth;
        @Pc(68) int locLength;
        if (rotation == 1 || rotation == 3) {
            locLength = locType.width;
            locWidth = locType.length;
        } else {
            locWidth = locType.width;
            locLength = locType.length;
        }

        @Pc(100) int x0;
        @Pc(94) int x1;
        if (x + locWidth <= super.width) {
            x1 = (locWidth + 1 >> 1) + x;
            x0 = (locWidth >> 1) + x;
        } else {
            x1 = x + 1;
            x0 = x;
        }

        @Pc(123) int z0;
        @Pc(121) int z1;
        if (super.length < locLength + z) {
            z1 = z + 1;
            z0 = z;
        } else {
            z0 = z + (locLength >> 1);
            z1 = z + (locLength + 1 >> 1);
        }

        @Pc(143) Ground ground = Static246.ground[virtualLevel];
        int bottomLeftHeight = ground.getHeight(x0, z0);
        int bottomRightHeight = ground.getHeight(x1, z0);
        int topLeftHeight = ground.getHeight(x0, z1);
        int topRightHeight = ground.getHeight(x1, z1);
        @Pc(170) int averageHeight = (bottomLeftHeight + bottomRightHeight + topLeftHeight + topRightHeight) >> 2;

        @Pc(179) int absX = (x << 9) + (locWidth << 8);
        @Pc(187) int absZ = (locLength << 8) + (z << 9);

        @Pc(204) boolean copyNormals = Static404.renderShadows && !super.underwater && locType.sharelight;

        if (locType.hasSounds()) {
            SoundManager.addSounds(level, x, z, null, null, locType, rotation);
        }

        @Pc(248) boolean isStatic = animation == -1 && !locType.hasAnimations() && locType.multiloc == null && !locType.animated && !locType.aBoolean91;

        boolean occludeWall = LocShapes.isWall(shape) && locType.occlude != LocOcclusionMode.ALL;
        boolean occludeRoof = LocShapes.isRoof(shape) && locType.occlude == LocOcclusionMode.ROOFS;
        if (occlude && (occludeWall || occludeRoof)) {
            return;
        }

        if (shape == LocShapes.GROUNDDECOR) {
            if (ClientOptions.instance.groundDecor.getValue() == 0 && locType.active == LocInteractivity.NONINTERACTIVE && locType.blockwalk != 1 && !locType.forcedecor) {
                return;
            }

            @Pc(325) GroundDecor decor;
            if (isStatic) {
                @Pc(341) StaticGroundDecor staticDecor = new StaticGroundDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, rotation, copyNormals);

                decor = staticDecor;

                if (staticDecor.hardShadow()) {
                    staticDecor.addShadow(toolkit);
                }
            } else {
                decor = new DynamicGroundDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, rotation, animation);
            }

            Static61.method1299(level, x, z, decor);

            if (locType.blockwalk == 1 && collisionMap != null) {
                collisionMap.flagGroundDecor(x, z);
            }
        } else if (shape == LocShapes.CENTREPIECE_STRAIGHT || shape == LocShapes.CENTREPIECE_DIAGONAL) {
            @Pc(420) PositionEntity loc;
            @Pc(384) StaticLocation staticLoc = null;

            @Pc(424) int shadowValue;
            if (isStatic) {
                @Pc(416) StaticLocation staticLocation = new StaticLocation(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, x, x + locWidth - 1, z, z + locLength - 1, shape, rotation, copyNormals);
                staticLoc = staticLocation;
                loc = staticLocation;
                shadowValue = staticLocation.shadowValue();
            } else {
                shadowValue = 15;
                loc = new DynamicLocation(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, x, x + locWidth - 1, z, z + locLength - 1, shape, rotation, animation);
            }

            if (Static102.method2026(loc, false)) {
                if (staticLoc != null && staticLoc.hardShadow()) {
                    staticLoc.addShadow(toolkit);
                }

                if (locType.shadow && Static404.renderShadows) {
                    if (shadowValue > 30) {
                        shadowValue = 30;
                    }

                    for (@Pc(492) int locX = 0; locX <= locWidth; locX++) {
                        for (@Pc(495) int locZ = 0; locZ <= locLength; locZ++) {
                            ground.ka(locX + locX, locZ + locZ, shadowValue);
                        }
                    }
                }
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagLoc(x, z, locWidth, locLength, locType.blockrange, !locType.breakroutefinding);
            }
        } else if (shape >= LocShapes.ROOF_STRAIGHT && shape <= LocShapes.ROOF_FLAT || shape >= LocShapes.ROOFEDGE_STRAIGHT && shape <= LocShapes.ROOFEDGE_SQUARECORNER) {
            @Pc(420) PositionEntity loc;
            @Pc(384) StaticLocation staticLoc;

            if (isStatic) {
                staticLoc = new StaticLocation(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, x, x + locWidth - 1, z, z + locLength - 1, shape, rotation, copyNormals);

                if (staticLoc.hardShadow()) {
                    staticLoc.addShadow(toolkit);
                }

                loc = staticLoc;
            } else {
                loc = new DynamicLocation(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, x, locWidth + x - 1, z, z + locLength - 1, shape, rotation, animation);
            }

            Static102.method2026(loc, false);

            boolean occludeRoofs = locType.occlude == LocOcclusionMode.ROOFS;
            if (Static404.renderShadows && !super.underwater && shape >= LocShapes.ROOF_STRAIGHT && shape <= LocShapes.ROOF_FLAT && shape != LocShapes.ROOF_DIAGONAL_WITH_ROOFEDGE && level > 0 && !occludeRoofs) {
                super.occluderFlags[level][x][z] = (byte) (super.occluderFlags[level][x][z] | 0x4);
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagLoc(x, z, locWidth, locLength, locType.blockrange, !locType.breakroutefinding);
            }
        } else if (shape == LocShapes.WALL_STRAIGHT) {
            @Pc(774) Wall wall;

            @Pc(744) int occlusionMode = locType.occlude;
            if (forceOcclusion && locType.occlude == LocOcclusionMode.NONE) {
                occlusionMode = LocOcclusionMode.ALL;
            }

            if (isStatic) {
                @Pc(772) StaticWall staticWall = new StaticWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation, copyNormals);
                wall = staticWall;

                if (staticWall.hardShadow()) {
                    staticWall.addShadow(toolkit);
                }
            } else {
                wall = new DynamicWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation, animation);
            }

            Static584.method7665(level, x, z, wall, null);

            if (rotation == 0) {
                if (Static404.renderShadows && locType.shadow) {
                    ground.ka(x, z, 50);
                    ground.ka(x, z + 1, 50);
                }

                if (occlusionMode == LocOcclusionMode.ALL && !super.underwater) {
                    Static177.addLocationOccluder(1, locType.occlusionOffset, z, x, level, locType.occlusionHeight);
                }
            } else if (rotation == 1) {
                if (Static404.renderShadows && locType.shadow) {
                    ground.ka(x, z + 1, 50);
                    ground.ka(x + 1, z - -1, 50);
                }

                if (occlusionMode == LocOcclusionMode.ALL && !super.underwater) {
                    Static177.addLocationOccluder(2, -locType.occlusionOffset, z + 1, x, level, locType.occlusionHeight);
                }
            } else if (rotation == 2) {
                if (Static404.renderShadows && locType.shadow) {
                    ground.ka(x + 1, z, 50);
                    ground.ka(x + 1, z + 1, 50);
                }

                if (occlusionMode == LocOcclusionMode.ALL && !super.underwater) {
                    Static177.addLocationOccluder(1, -locType.occlusionOffset, z, x + 1, level, locType.occlusionHeight);
                }
            } else if (rotation == 3) {
                if (Static404.renderShadows && locType.shadow) {
                    ground.ka(x, z, 50);
                    ground.ka(x + 1, z, 50);
                }

                if (occlusionMode == LocOcclusionMode.ALL && !super.underwater) {
                    Static177.addLocationOccluder(2, locType.occlusionOffset, z, x, level, locType.occlusionHeight);
                }
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagWall(locType.blockrange, !locType.breakroutefinding, z, rotation, shape, x);
            }

            if (locType.walloff != 64) {
                Static411.method5666(level, x, z, locType.walloff);
            }
        } else if (shape == LocShapes.WALL_DIAGONALCORNER) {
            @Pc(1079) Wall wall;
            @Pc(1096) StaticWall staticWall;

            if (isStatic) {
                staticWall = new StaticWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation, copyNormals);
                wall = staticWall;

                if (staticWall.hardShadow()) {
                    staticWall.addShadow(toolkit);
                }
            } else {
                wall = new DynamicWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation, animation);
            }

            Static584.method7665(level, x, z, wall, null);

            if (locType.shadow && Static404.renderShadows) {
                if (rotation == 0) {
                    ground.ka(x, z + 1, 50);
                } else if (rotation == 1) {
                    ground.ka(x + 1, z - -1, 50);
                } else if (rotation == 2) {
                    ground.ka(x + 1, z, 50);
                } else if (rotation == 3) {
                    ground.ka(x, z, 50);
                }
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagWall(locType.blockrange, !locType.breakroutefinding, z, rotation, shape, x);
            }
        } else if (shape == LocShapes.WALL_L) {
            @Pc(1079) Wall wall;
            @Pc(774) Wall adjacentWall;

            @Pc(424) int rotation90 = (rotation + 1) & 0x3;

            if (isStatic) {
                @Pc(1267) StaticWall staticWall = new StaticWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation + 4, copyNormals);
                @Pc(1283) StaticWall adjacentStaticWall = new StaticWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation90, copyNormals);

                if (staticWall.hardShadow()) {
                    staticWall.addShadow(toolkit);
                }

                adjacentWall = adjacentStaticWall;

                if (adjacentStaticWall.hardShadow()) {
                    adjacentStaticWall.addShadow(toolkit);
                }

                wall = staticWall;
            } else {
                wall = new DynamicWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation + 4, animation);
                adjacentWall = new DynamicWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation90, animation);
            }

            Static584.method7665(level, x, z, wall, adjacentWall);

            boolean occlude = (locType.occlude == LocOcclusionMode.ALL) || (forceOcclusion && locType.occlude == -1);
            if (occlude && !super.underwater) {
                if (rotation == 0) {
                    Static177.addLocationOccluder(1, locType.occlusionOffset, z, x, level, locType.occlusionHeight);
                    Static177.addLocationOccluder(2, locType.occlusionOffset, z + 1, x, level, locType.occlusionHeight);
                } else if (rotation == 1) {
                    Static177.addLocationOccluder(1, locType.occlusionOffset, z, x + 1, level, locType.occlusionHeight);
                    Static177.addLocationOccluder(2, locType.occlusionOffset, z + 1, x, level, locType.occlusionHeight);
                } else if (rotation == 2) {
                    Static177.addLocationOccluder(1, locType.occlusionOffset, z, x + 1, level, locType.occlusionHeight);
                    Static177.addLocationOccluder(2, locType.occlusionOffset, z, x, level, locType.occlusionHeight);
                } else if (rotation == 3) {
                    Static177.addLocationOccluder(1, locType.occlusionOffset, z, x, level, locType.occlusionHeight);
                    Static177.addLocationOccluder(2, locType.occlusionOffset, z, x, level, locType.occlusionHeight);
                }
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagWall(locType.blockrange, !locType.breakroutefinding, z, rotation, shape, x);
            }

            if (locType.walloff != 64) {
                Static411.method5666(level, x, z, locType.walloff);
            }
        } else if (shape == LocShapes.WALL_SQUARECORNER) {
            @Pc(1079) Wall wall;

            if (isStatic) {
                @Pc(1096) StaticWall staticWall = new StaticWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation, copyNormals);

                if (staticWall.hardShadow()) {
                    staticWall.addShadow(toolkit);
                }

                wall = staticWall;
            } else {
                wall = new DynamicWall(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, shape, rotation, animation);
            }

            Static584.method7665(level, x, z, wall, null);

            if (locType.shadow && Static404.renderShadows) {
                if (rotation == 0) {
                    ground.ka(x, z + 1, 50);
                } else if (rotation == 1) {
                    ground.ka(x + 1, z - -1, 50);
                } else if (rotation == 2) {
                    ground.ka(x + 1, z, 50);
                } else if (rotation == 3) {
                    ground.ka(x, z, 50);
                }
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagWall(locType.blockrange, !locType.breakroutefinding, z, rotation, shape, x);
            }
        } else if (shape == LocShapes.WALL_DIAGONAL) {
            @Pc(420) PositionEntity loc;

            if (isStatic) {
                @Pc(384) StaticLocation staticLoc = new StaticLocation(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, x, x, z, z, shape, rotation, copyNormals);

                if (staticLoc.hardShadow()) {
                    staticLoc.addShadow(toolkit);
                }

                loc = staticLoc;
            } else {
                loc = new DynamicLocation(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, x, locWidth + x - 1, z, locLength + z - 1, shape, rotation, animation);
            }

            Static102.method2026(loc, false);

            if (locType.occlude == 1 && !super.underwater) {
                @Pc(1723) byte occlusionType;
                if ((rotation & 0x1) == 0) {
                    occlusionType = 8;
                } else {
                    occlusionType = 16;
                }

                Static177.addLocationOccluder(occlusionType, 0, z, x, level, locType.occlusionHeight);
            }

            if (locType.blockwalk != 0 && collisionMap != null) {
                collisionMap.flagLoc(x, z, locWidth, locLength, locType.blockrange, !locType.breakroutefinding);
            }

            if (locType.walloff != 64) {
                Static411.method5666(level, x, z, locType.walloff);
            }
        } else if (shape == LocShapes.WALLDECOR_STRAIGHT_NOOFFSET) {
            @Pc(1813) WallDecor decor;

            if (isStatic) {
                @Pc(1801) StaticWallDecor staticDecor = new StaticWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, 0, 0, shape, rotation);

                if (staticDecor.hardShadow()) {
                    staticDecor.addShadow(toolkit);
                }

                decor = staticDecor;
            } else {
                decor = new DynamicWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, 0, 0, shape, rotation, animation);
            }

            Static177.setWallDecor(level, x, z, decor, null);
        } else if (shape == LocShapes.WALLDECOR_STRAIGHT_OFFSET) {
            @Pc(1813) WallDecor decor;

            @Pc(1844) int local1844 = 65;
            @Pc(1850) Location wall = (Location) Static302.getWall(level, x, z);
            if (wall != null) {
                local1844 = LocTypeList.instance.list(wall.getId()).walloff + 1;
            }

            if (isStatic) {
                @Pc(1916) StaticWallDecor staticDecor = new StaticWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, WALLDECOR_STRAIGHT_XOFFSET[rotation] * local1844, WALLDECOR_STRAIGHT_ZOFFSET[rotation] * local1844, shape, rotation);

                if (staticDecor.hardShadow()) {
                    staticDecor.addShadow(toolkit);
                }

                decor = staticDecor;
            } else {
                decor = new DynamicWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, WALLDECOR_STRAIGHT_XOFFSET[rotation] * local1844, local1844 * WALLDECOR_STRAIGHT_ZOFFSET[rotation], shape, rotation, animation);
            }

            Static177.setWallDecor(level, x, z, decor, null);
        } else if (shape == LocShapes.WALLDECOR_DIAGONAL_OFFSET) {
            @Pc(1813) WallDecor decor;

            @Pc(1844) int local1844 = 33;
            @Pc(1850) Location wall = (Location) Static302.getWall(level, x, z);
            if (wall != null) {
                local1844 = (LocTypeList.instance.list(wall.getId()).walloff / 2) + 1;
            }

            if (isStatic) {
                @Pc(1916) StaticWallDecor staticDecor = new StaticWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, WALLDECOR_STRAIGHT_XOFFSET[rotation] * local1844, local1844 * WALLDECOR_STRAIGHT_ZOFFSET[rotation], shape, rotation + 4);
                decor = staticDecor;

                if (staticDecor.hardShadow()) {
                    staticDecor.addShadow(toolkit);
                }
            } else {
                decor = new DynamicWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, WALLDECOR_DIAGONAL_XOFFSET[rotation] * local1844, WALLDECOR_DIAGONAL_ZOFFSET[rotation] * local1844, shape, rotation + 4, animation);
            }

            Static177.setWallDecor(level, x, z, decor, null);
        } else if (shape == LocShapes.WALLDECOR_DIAGONAL_NOOFFSET) {
            @Pc(1813) WallDecor decor;
            @Pc(1844) int oppositeRotation = (rotation + 2) & 0x3;

            if (isStatic) {
                @Pc(2068) StaticWallDecor staticDecor = new StaticWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, 0, 0, shape, oppositeRotation + 4);
                decor = staticDecor;

                if (staticDecor.hardShadow()) {
                    staticDecor.addShadow(toolkit);
                }
            } else {
                decor = new DynamicWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, 0, 0, shape, oppositeRotation + 4, animation);
            }

            Static177.setWallDecor(level, x, z, decor, null);
        } else if (shape == LocShapes.WALLDECOR_DIAGONAL_BOTH) {
            @Pc(492) int oppositeRotation = rotation + 2 & 0x3;

            @Pc(495) int local495 = 33;
            @Pc(2134) Location wall = (Location) Static302.getWall(level, x, z);
            if (wall != null) {
                local495 = (LocTypeList.instance.list(wall.getId()).walloff / 2) + 1;
            }

            @Pc(2178) WallDecor primaryDecor;
            @Pc(2200) WallDecor secondaryDecor;
            if (isStatic) {
                primaryDecor = new StaticWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, WALLDECOR_DIAGONAL_XOFFSET[rotation] * local495, WALLDECOR_DIAGONAL_ZOFFSET[rotation] * local495, shape, rotation + 4);
                secondaryDecor = new StaticWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, 0, 0, shape, oppositeRotation + 4);

                if (primaryDecor.hardShadow()) {
                    primaryDecor.addShadow(toolkit);
                }

                if (secondaryDecor.hardShadow()) {
                    secondaryDecor.addShadow(toolkit);
                }
            } else {
                primaryDecor = new DynamicWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, WALLDECOR_DIAGONAL_XOFFSET[rotation] * local495, WALLDECOR_DIAGONAL_ZOFFSET[rotation] * local495, shape, rotation + 4, animation);
                secondaryDecor = new DynamicWallDecor(toolkit, locType, level, virtualLevel, absX, averageHeight, absZ, super.underwater, 0, 0, shape, oppositeRotation + 4, animation);
            }

            Static177.setWallDecor(level, x, z, primaryDecor, secondaryDecor);
        }
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(IILclient!ha;ILclient!ge;IIIII)V")
    public void decodeEnvironment(@OriginalArg(0) int x, @OriginalArg(2) Toolkit toolkit, @OriginalArg(3) int pointerZ, @OriginalArg(4) Packet packet, @OriginalArg(5) int level, @OriginalArg(6) int pointerX, @OriginalArg(7) int pointerRotation, @OriginalArg(8) int pointerLevel, @OriginalArg(9) int z) {
        if (super.underwater) {
            return;
        }
        @Pc(10) boolean local10 = false;
        @Pc(12) Environment environment = null;
        @Pc(18) int absX = (pointerX & 0x7) * 8;
        @Pc(24) int absZ = (pointerZ & 0x7) * 8;
        while (true) {
            while (packet.pos < packet.data.length) {
                @Pc(35) int code = packet.g1();

                if (code == 0) {
                    if (environment == null) {
                        environment = new Environment(packet);
                    } else {
                        environment.method8386(packet);
                    }
                } else if (code == 1) {
                    @Pc(63) int count = packet.g1();
                    if (count <= 0) {
                        continue;
                    }

                    for (@Pc(70) int i = 0; i < count; i++) {
                        @Pc(78) EnvironmentLight envLight = new EnvironmentLight(toolkit, packet, 2);
                        if (envLight.preset == 31) {
                            @Pc(91) LightType type = LightTypeList.instance.list(packet.g2());
                            envLight.updateParameters(type.ambient, type.pattern, type.amplitude, type.frequency);
                        }

                        if (toolkit.getMaxLights() > 0) {
                            @Pc(108) PointLight light = envLight.light;
                            @Pc(116) int lightX = light.getX() >> 9;
                            @Pc(122) int lightZ = light.getZ() >> 9;

                            if ((pointerLevel == envLight.level) && (lightX >= absX) && (lightX < (absX + 8)) && (lightZ >= absZ) && (lightZ < (absZ + 8))) {
                                @Pc(176) int rx = (x << 9) + rotateLightX(light.getX() & 0xFFF, light.getZ() & 0xFFF, pointerRotation);
                                lightX = rx >> 9;

                                @Pc(200) int rz = (z << 9) + rotateLightZ(light.getX() & 0xFFF, light.getZ() & 0xFFF, pointerRotation);
                                lightZ = rz >> 9;

                                if (lightX >= 0 && lightZ >= 0 && lightX < super.width && lightZ < super.length) {
                                    light.setPosition(rx, rz, super.tileHeights[pointerLevel][lightX][lightZ] - light.getY());
                                    method9122(envLight);
                                }
                            }
                        }
                    }
                } else if (code == 2) {
                    if (environment == null) {
                        environment = new Environment();
                    }
                    environment.decodeBloomParams(packet);
                } else if (code == 128) {
                    if (environment == null) {
                        environment = new Environment();
                    }
                    environment.method8384(packet);
                } else if (code == 129) {
                    if (super.aByteArrayArrayArray12 == null) {
                        super.aByteArrayArrayArray12 = new byte[4][][];
                    }
                    for (@Pc(63) int local63 = 0; local63 < 4; local63++) {
                        @Pc(311) byte local311 = packet.g1b();
                        if (local311 == 0 && super.aByteArrayArrayArray12[level] != null) {
                            if (pointerLevel >= local63) {
                                @Pc(327) int local327 = x;
                                @Pc(331) int local331 = x + 7;
                                @Pc(116) int local116 = z;
                                if (x < 0) {
                                    local327 = 0;
                                } else if (x >= super.width) {
                                    local327 = super.width;
                                }
                                if (local331 < 0) {
                                    local331 = 0;
                                } else if (local331 >= super.width) {
                                    local331 = super.width;
                                }

                                @Pc(122) int local122 = z + 7;
                                if (z < 0) {
                                    local116 = 0;
                                } else if (z >= super.length) {
                                    local116 = super.length;
                                }

                                if (local122 < 0) {
                                    local122 = 0;
                                } else if (super.length <= local122) {
                                    local122 = super.length;
                                }
                                while (local331 > local327) {
                                    while (local122 > local116) {
                                        super.aByteArrayArrayArray12[level][local327][local116] = 0;
                                        local116++;
                                    }
                                    local327++;
                                }
                            }
                        } else if (local311 == 1) {
                            if (super.aByteArrayArrayArray12[level] == null) {
                                super.aByteArrayArrayArray12[level] = new byte[super.width + 1][super.length + 1];
                            }

                            for (@Pc(327) int local327 = 0; local327 < 64; local327 += 4) {
                                for (@Pc(331) int local331 = 0; local331 < 64; local331 += 4) {
                                    @Pc(466) byte local466 = packet.g1b();
                                    if (local63 <= pointerLevel) {
                                        for (@Pc(122) int local122 = local327; local122 < local327 + 4; local122++) {
                                            for (@Pc(176) int local176 = local331; local176 < local331 + 4; local176++) {
                                                if (local122 >= absX && absX + 8 > local122 && local176 >= absZ && absZ + 8 > local176) {
                                                    @Pc(200) int rx = x + rotateZoneX(local122 & 0x7, local176 & 0x7, pointerRotation);
                                                    @Pc(534) int ry = z + rotateZoneY(local122 & 0x7, local176 & 0x7, pointerRotation);
                                                    if (rx >= 0 && rx < super.width && ry >= 0 && ry < super.length) {
                                                        super.aByteArrayArrayArray12[level][rx][ry] = local466;
                                                        local10 = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("");
                }
            }

            if (environment != null) {
                Static108.method2064(z >> 3, x >> 3, environment);
            }

            if (!local10 && super.aByteArrayArrayArray12 != null && super.aByteArrayArrayArray12[level] != null) {
                @Pc(35) int local35 = x + 7;
                @Pc(63) int local63 = z + 7;
                for (@Pc(70) int local70 = x; local70 < local35; local70++) {
                    for (@Pc(327) int local327 = z; local327 < local63; local327++) {
                        super.aByteArrayArrayArray12[level][local70][local327] = 0;
                    }
                }
                return;
            }
            return;
        }
    }

    @OriginalMember(owner = "client!taa", name = "b", descriptor = "(IIIII)Lclient!uv;")
    public Location getLoc(@OriginalArg(2) int level, @OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(3) int layer) {
        @Pc(5) Location location = null;
        if (layer == LocLayer.WALL) {
            location = (Location) Static302.getWall(level, x, z);
        }
        if (layer == LocLayer.WALLDECOR) {
            location = Static114.getWallDecor(level, x, z);
        }
        if (layer == LocLayer.GROUND) {
            location = (Location) Static578.getEntity(level, x, z, locClass == null ? (locClass = getClass("com.jagex.game.Location")) : locClass);
        }
        if (layer == LocLayer.GROUNDDECOR) {
            location = (Location) Static687.getGroundDecor(level, x, z);
        }
        return location;
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(I[Lclient!eq;ILclient!ha;BII[BIII)V")
    public void loadChunkLocations(@OriginalArg(0) int regionX, @OriginalArg(1) CollisionMap[] collisionMaps, @OriginalArg(2) int level, @OriginalArg(3) Toolkit toolkit, @OriginalArg(5) int x, @OriginalArg(6) int z, @OriginalArg(7) byte[] data, @OriginalArg(8) int regionRotation, @OriginalArg(9) int regionLevel, @OriginalArg(10) int regionZ) {
        @Pc(26) Packet packet = new Packet(data);
        @Pc(28) int id = -1;
        while (true) {
            @Pc(32) int idOffset = packet.gExtended1or2();
            if (idOffset == 0) {
                return;
            }
            id += idOffset;

            @Pc(40) int coord = 0;
            while (true) {
                @Pc(44) int coordOffset = packet.gsmart();
                if (coordOffset == 0) {
                    break;
                }
                coord += coordOffset - 1;

                @Pc(59) int locZ = coord & 0x3F;
                @Pc(65) int locX = coord >> 6 & 0x3F;
                @Pc(69) int locLevel = coord >> 12;
                @Pc(73) int shapeAndRotation = packet.g1();
                @Pc(77) int locShape = shapeAndRotation >> 2;
                @Pc(81) int locRotation = shapeAndRotation & 0x3;
                if ((locLevel == regionLevel) && (locX >= regionX) && (locX < (regionX + 8)) && (locZ >= regionZ) && (locZ < (regionZ + 8))) {
                    @Pc(113) LocType locType = LocTypeList.instance.list(id);
                    @Pc(130) int rx = rotateLocX(locX & 0x7, locZ & 0x7, locType.width, locType.length, regionRotation, locRotation) + x;
                    @Pc(147) int rz = rotateLocZ(locX & 0x7, locZ & 0x7, locType.width, locType.length, regionRotation, locRotation) + z;
                    if (rx > 0 && rz > 0 && rx < super.width - 1 && rz < super.length - 1) {
                        @Pc(173) CollisionMap collisionMap = null;
                        if (!super.underwater) {
                            @Pc(178) int actualLevel = level;
                            if ((Static280.tileFlags[1][rx][rz] & TileFlag.BRIDGE) != 0) {
                                actualLevel = level - 1;
                            }
                            if (actualLevel >= 0) {
                                collisionMap = collisionMaps[actualLevel];
                            }
                        }
                        this.loadLocation(rx, rz, level, level, id, locShape, (regionRotation + locRotation) & 0x3, -1, collisionMap, toolkit);
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(ZLclient!ha;B)V")
    public void method7898(@OriginalArg(0) boolean arg0, @OriginalArg(1) Toolkit arg1) {
        Static323.method4624();

        if (!arg0) {
            if (super.levels > 1) {
                for (@Pc(23) int x = 0; x < super.width; x++) {
                    for (@Pc(26) int z = 0; super.length > z; z++) {
                        if ((Static280.tileFlags[1][x][z] & TileFlag.BRIDGE) == 2) {
                            Static646.method8453(x, z);
                        }
                    }
                }
            }

            for (@Pc(23) int level = 0; super.levels > level; level++) {
                for (@Pc(26) int z = 0; super.length >= z; z++) {
                    for (@Pc(71) int x = 0; x <= super.width; x++) {
                        if ((super.occluderFlags[level][x][z] & TileFlag.REMOVE_ROOF) != 0) {
                            @Pc(88) int x1 = x;
                            @Pc(90) int x2 = x;

                            @Pc(92) int z1 = z;
                            @Pc(94) int z2 = z;
                            while (z1 > 0 && (super.occluderFlags[level][x][z1 - 1] & 0x4) != 0 && z - z1 < 10) {
                                z1--;
                            }
                            while (z2 < super.length && (super.occluderFlags[level][x][z2 + 1] & 0x4) != 0 && z2 - z1 < 10) {
                                z2++;
                            }

                            label111:
                            while (x1 > 0 && x - x1 < 10) {
                                for (@Pc(163) int local163 = z1; local163 <= z2; local163++) {
                                    if ((super.occluderFlags[level][x1 - 1][local163] & 0x4) == 0) {
                                        break label111;
                                    }
                                }
                                x1--;
                            }

                            label98:
                            while (super.width > x2 && x2 - x1 < 10) {
                                for (@Pc(163) int local163 = z1; local163 <= z2; local163++) {
                                    if ((super.occluderFlags[level][x2 + 1][local163] & 0x4) == 0) {
                                        break label98;
                                    }
                                }
                                x2++;
                            }

                            if ((x2 + 1 - x1) * (z2 + 1 - z1) >= 4) {
                                @Pc(163) int tileHeight = super.tileHeights[level][x1][z1];

                                Static269.method3911((z2 << 9) + 512, x1 << 9, tileHeight, z1 << 9, tileHeight, level, (x2 << 9) + 512);

                                for (@Pc(297) int localX = x1; localX <= x2; localX++) {
                                    for (@Pc(300) int localZ = z1; localZ <= z2; localZ++) {
                                        super.occluderFlags[level][localX][localZ] &= 0xFFFFFFFB;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Static348.method5107();
        }

        super.occluderFlags = null;
    }

    @OriginalMember(owner = "client!taa", name = "a", descriptor = "(IBILclient!eq;IILclient!ha;)V")
    public void removeLoc(@OriginalArg(4) int level, @OriginalArg(5) int x, @OriginalArg(2) int z, @OriginalArg(0) int layer, @OriginalArg(3) CollisionMap collisionMap, @OriginalArg(6) Toolkit toolkit) {
        @Pc(13) Location local13 = this.getLoc(level, x, z, layer);
        if (local13 == null) {
            return;
        }
        @Pc(22) LocType local22 = LocTypeList.instance.list(local13.getId());
        @Pc(26) int local26 = local13.getShape();
        @Pc(30) int local30 = local13.getRotation();
        if (local22.hasSounds()) {
            SoundManager.method8312(x, z, level, local22);
        }
        if (local13.hardShadow()) {
            local13.removeShadow(toolkit);
        }
        if (layer == 0) {
            Static26.method717(level, x, z);
            if (local22.blockwalk != 0) {
                collisionMap.unflagWall(z, local30, local26, !local22.breakroutefinding, x, local22.blockrange);
            }
            if (local22.occlude == 1) {
                if (local30 == 0) {
                    Static687.method8958(x, level, 1, z);
                } else if (local30 == 1) {
                    Static687.method8958(x, level, 2, z + 1);
                } else if (local30 == 2) {
                    Static687.method8958(x + 1, level, 1, z);
                } else if (local30 == 3) {
                    Static687.method8958(x, level, 2, z);
                }
            }
        } else if (layer == 1) {
            Static173.method2692(level, x, z);
        } else if (layer == 2) {
            Static10.method130(level, x, z, locClass == null ? (locClass = getClass("com.jagex.game.Location")) : locClass);
            if (local22.blockwalk != 0 && super.width > local22.width + x && super.length > local22.width + z && x + local22.length < super.width && local22.length + z < super.length) {
                collisionMap.unflagLoc(x, z, local22.width, local22.length, local30, local22.blockrange, !local22.breakroutefinding);
            }
            if (local26 == 9) {
                if ((local30 & 0x1) == 0) {
                    Static687.method8958(x, level, 8, z);
                } else {
                    Static687.method8958(x, level, 16, z);
                }
            }
        } else if (layer == 3) {
            Static609.method8212(level, x, z);
            if (local22.blockwalk == 1) {
                collisionMap.unflagGroundDecor(x, z);
            }
        }
    }

    static Class getClass(String name) {
        Class instance;
        try {
            instance = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw (NoClassDefFoundError) new NoClassDefFoundError().initCause(ex);
        }
        return instance;
    }
}
