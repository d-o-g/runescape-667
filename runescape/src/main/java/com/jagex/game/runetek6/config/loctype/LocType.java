package com.jagex.game.runetek6.config.loctype;

import com.jagex.collect.HashTable;
import com.jagex.collect.IntNode;
import com.jagex.collect.Node;
import com.jagex.collect.StringNode;
import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.LocShapes;
import com.jagex.core.io.Packet;
import com.jagex.game.Animator;
import com.jagex.game.VarDomain;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.ModelAndShadow;
import com.jagex.graphics.Shadow;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!c")
public final class LocType {

    public static final int INVISIBLE_ID = -1;

    @OriginalMember(owner = "client!iia", name = "o", descriptor = "Lclient!od;")
    public static final ModelAndShadow modelAndShadow = new ModelAndShadow();

    @OriginalMember(owner = "client!sv", name = "N", descriptor = "[Lclient!dv;")
    public static final Mesh[] A_MESH_ARRAY_1 = new Mesh[4];

    @OriginalMember(owner = "client!ne", name = "o", descriptor = "[S")
    public static short[] clientpalette = new short[256];

    @OriginalMember(owner = "client!c", name = "sb", descriptor = "[B")
    public byte[] modelShapes;

    @OriginalMember(owner = "client!c", name = "Wb", descriptor = "B")
    public byte targetHue;

    @OriginalMember(owner = "client!c", name = "Bb", descriptor = "[Ljava/lang/String;")
    public String[] ops;

    @OriginalMember(owner = "client!c", name = "u", descriptor = "[I")
    public int[] quests;

    @OriginalMember(owner = "client!c", name = "H", descriptor = "[I")
    public int[] multiLocs;

    @OriginalMember(owner = "client!c", name = "ub", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!c", name = "d", descriptor = "[B")
    public byte[] recol_d_palette;

    @OriginalMember(owner = "client!c", name = "kb", descriptor = "Lclient!av;")
    public HashTable params;

    @OriginalMember(owner = "client!c", name = "mb", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!c", name = "S", descriptor = "Lclient!gea;")
    public LocTypeList typeList;

    @OriginalMember(owner = "client!c", name = "j", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!c", name = "I", descriptor = "[[I")
    public int[][] models;

    @OriginalMember(owner = "client!c", name = "Tb", descriptor = "[I")
    public int[] anIntArray116;

    @OriginalMember(owner = "client!c", name = "ob", descriptor = "[S")
    public short[] retex_s;

    @OriginalMember(owner = "client!c", name = "Vb", descriptor = "B")
    public byte targetSaturation;

    @OriginalMember(owner = "client!c", name = "Db", descriptor = "[S")
    public short[] recol_s;

    @OriginalMember(owner = "client!c", name = "D", descriptor = "B")
    public byte targetLightness;

    @OriginalMember(owner = "client!c", name = "Rb", descriptor = "Z")
    public boolean aBoolean88 = false;

    @OriginalMember(owner = "client!c", name = "B", descriptor = "Z")
    public boolean hardShadow = true;

    @OriginalMember(owner = "client!c", name = "db", descriptor = "I")
    public int scaleY = 128;

    @OriginalMember(owner = "client!c", name = "x", descriptor = "I")
    public int anInt1213 = 0;

    @OriginalMember(owner = "client!c", name = "g", descriptor = "B")
    public byte colourShiftPercentage = 0;

    @OriginalMember(owner = "client!c", name = "O", descriptor = "I")
    public int anInt1227 = 0;

    @OriginalMember(owner = "client!c", name = "Gb", descriptor = "I")
    public int anInt1219 = 0;

    @OriginalMember(owner = "client!c", name = "w", descriptor = "I")
    public int length = 1;

    @OriginalMember(owner = "client!c", name = "q", descriptor = "I")
    public int cursor1Op = -1;

    @OriginalMember(owner = "client!c", name = "h", descriptor = "I")
    public int anInt1221 = 0;

    @OriginalMember(owner = "client!c", name = "k", descriptor = "I")
    public int anInt1214 = 0;

    @OriginalMember(owner = "client!c", name = "K", descriptor = "I")
    public int scaleX = 128;

    @OriginalMember(owner = "client!c", name = "qb", descriptor = "Ljava/lang/String;")
    public String name = "null";

    @OriginalMember(owner = "client!c", name = "G", descriptor = "I")
    public int translateZ = 0;

    @OriginalMember(owner = "client!c", name = "ib", descriptor = "Z")
    public boolean members = false;

    @OriginalMember(owner = "client!c", name = "lb", descriptor = "I")
    public int lb = -1;

    @OriginalMember(owner = "client!c", name = "s", descriptor = "I")
    public int mapElement = -1;

    @OriginalMember(owner = "client!c", name = "v", descriptor = "I")
    public int locOcclusionMode = -1;

    @OriginalMember(owner = "client!c", name = "p", descriptor = "I")
    public int soundDistance = 0;

    @OriginalMember(owner = "client!c", name = "z", descriptor = "I")
    public int sound = -1;

    @OriginalMember(owner = "client!c", name = "c", descriptor = "I")
    public int multiLocVarbit = -1;

    @OriginalMember(owner = "client!c", name = "Nb", descriptor = "Z")
    public boolean routingHint = false;

    @OriginalMember(owner = "client!c", name = "m", descriptor = "Z")
    public boolean msiFlip = false;

    @OriginalMember(owner = "client!c", name = "a", descriptor = "I")
    public int scaleZ = 128;

    @OriginalMember(owner = "client!c", name = "y", descriptor = "I")
    public int anInt1248 = 0;

    @OriginalMember(owner = "client!c", name = "f", descriptor = "I")
    public int ambientSoundVolume = 255;

    @OriginalMember(owner = "client!c", name = "n", descriptor = "I")
    public int msiRotateOffset = 0;

    @OriginalMember(owner = "client!c", name = "Cb", descriptor = "[I")
    public int[] animations = null;

    @OriginalMember(owner = "client!c", name = "nb", descriptor = "I")
    public int hillValue = -1;

    @OriginalMember(owner = "client!c", name = "Sb", descriptor = "I")
    public int anInt1231 = 0;

    @OriginalMember(owner = "client!c", name = "L", descriptor = "I")
    public int cursor1 = -1;

    @OriginalMember(owner = "client!c", name = "yb", descriptor = "I")
    public int occlusionHeight = 960;

    @OriginalMember(owner = "client!c", name = "W", descriptor = "Z")
    public boolean aBoolean94 = true;

    @OriginalMember(owner = "client!c", name = "U", descriptor = "I")
    public int anInt1243 = 64;

    @OriginalMember(owner = "client!c", name = "vb", descriptor = "[I")
    public int[] animationChances = null;

    @OriginalMember(owner = "client!c", name = "X", descriptor = "B")
    public byte hillType = 0;

    @OriginalMember(owner = "client!c", name = "jb", descriptor = "I")
    public int anInt1249 = 256;

    @OriginalMember(owner = "client!c", name = "tb", descriptor = "I")
    public int cursor2Op = -1;

    @OriginalMember(owner = "client!c", name = "b", descriptor = "I")
    public int translateX = 0;

    @OriginalMember(owner = "client!c", name = "Y", descriptor = "I")
    public int ambient = 0;

    @OriginalMember(owner = "client!c", name = "M", descriptor = "I")
    public int movementPolicy = 2;

    @OriginalMember(owner = "client!c", name = "bb", descriptor = "Z")
    public boolean aBoolean92 = false;

    @OriginalMember(owner = "client!c", name = "N", descriptor = "Z")
    public boolean animated = false;

    @OriginalMember(owner = "client!c", name = "Eb", descriptor = "I")
    public int translateY = 0;

    @OriginalMember(owner = "client!c", name = "E", descriptor = "I")
    public int blockedDirections = 0;

    @OriginalMember(owner = "client!c", name = "fb", descriptor = "I")
    public int anInt1268 = 256;

    @OriginalMember(owner = "client!c", name = "o", descriptor = "I")
    public int contrast = 0;

    @OriginalMember(owner = "client!c", name = "gb", descriptor = "Z")
    public boolean obstructiveGround = false;

    @OriginalMember(owner = "client!c", name = "t", descriptor = "Z")
    public boolean requiresTextures = false;

    @OriginalMember(owner = "client!c", name = "P", descriptor = "Z")
    public boolean blockRanged = true;

    @OriginalMember(owner = "client!c", name = "Mb", descriptor = "Z")
    public boolean aBoolean91 = false;

    @OriginalMember(owner = "client!c", name = "e", descriptor = "Z")
    public boolean copyNormals = false;

    @OriginalMember(owner = "client!c", name = "Ub", descriptor = "I")
    public int width = 1;

    @OriginalMember(owner = "client!c", name = "Q", descriptor = "I")
    public int occlusionOffset = 0;

    @OriginalMember(owner = "client!c", name = "xb", descriptor = "I")
    public int msi = -1;

    @OriginalMember(owner = "client!c", name = "pb", descriptor = "I")
    public int multiLocVarp = -1;

    @OriginalMember(owner = "client!c", name = "Ab", descriptor = "I")
    public int cursor2 = -1;

    @OriginalMember(owner = "client!c", name = "Z", descriptor = "Z")
    public boolean castsShadow = true;

    @OriginalMember(owner = "client!c", name = "zb", descriptor = "Z")
    public boolean msiRotate = false;

    @OriginalMember(owner = "client!c", name = "Jb", descriptor = "Z")
    public boolean mirrorModel = false;

    @OriginalMember(owner = "client!c", name = "Ib", descriptor = "I")
    public int interactivity = LocInteractivity.UNSET;

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(B)Z")
    public boolean hasMultipleAnimations() {
        return this.animations != null && this.animations.length > 1;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!ge;II)V")
    public void decode(@OriginalArg(0) Packet packet, @OriginalArg(1) int code) {
        if (code == 1 || code == 5) {
            if (code == 5 && this.typeList.animateBackground) {
                this.skip(packet);
            }

            @Pc(37) int shapeCount = packet.g1();
            this.modelShapes = new byte[shapeCount];
            this.models = new int[shapeCount][];

            for (@Pc(47) int i = 0; i < shapeCount; i++) {
                this.modelShapes[i] = packet.g1b();

                @Pc(59) int modelCount = packet.g1();
                this.models[i] = new int[modelCount];
                for (@Pc(67) int j = 0; j < modelCount; j++) {
                    this.models[i][j] = packet.g2();
                }
            }

            if (code == 5 && !this.typeList.animateBackground) {
                this.skip(packet);
            }
        } else if (code == 2) {
            this.name = packet.gjstr();
        } else if (code == 14) {
            this.width = packet.g1();
        } else if (code == 15) {
            this.length = packet.g1();
        } else if (code == 17) {
            this.blockRanged = false;
            this.movementPolicy = 0;
        } else if (code == 18) {
            this.blockRanged = false;
        } else if (code == 19) {
            this.interactivity = packet.g1();
        } else if (code == 21) {
            this.hillType = 1;
        } else if (code == 22) {
            this.copyNormals = true;
        } else if (code == 23) {
            this.locOcclusionMode = LocOcclusionMode.ALL;
        } else if (code == 24) {
            @Pc(37) int animation = packet.g2();
            if (animation != 65535) {
                this.animations = new int[]{animation};
            }
        } else if (code == 27) {
            this.movementPolicy = 1;
        } else if (code == 28) {
            this.anInt1243 = packet.g1() << 2;
        } else if (code == 29) {
            this.ambient = packet.g1b();
        } else if (code == 39) {
            this.contrast = packet.g1b() * 5;
        } else if (code >= 30 && code < 35) {
            this.ops[code - 30] = packet.gjstr();
        } else if (code == 40) {
            @Pc(37) int count = packet.g1();
            this.recol_d = new short[count];
            this.recol_s = new short[count];

            for (@Pc(47) int i = 0; i < count; i++) {
                this.recol_s[i] = (short) packet.g2();
                this.recol_d[i] = (short) packet.g2();
            }
        } else if (code == 41) {
            @Pc(37) int count = packet.g1();
            this.retex_d = new short[count];
            this.retex_s = new short[count];

            for (@Pc(47) int i = 0; i < count; i++) {
                this.retex_s[i] = (short) packet.g2();
                this.retex_d[i] = (short) packet.g2();
            }
        } else if (code == 42) {
            @Pc(37) int count = packet.g1();
            this.recol_d_palette = new byte[count];

            for (@Pc(47) int local47 = 0; local47 < count; local47++) {
                this.recol_d_palette[local47] = packet.g1b();
            }
        } else if (code == 62) {
            this.mirrorModel = true;
        } else if (code == 64) {
            this.castsShadow = false;
        } else if (code == 65) {
            this.scaleX = packet.g2();
        } else if (code == 66) {
            this.scaleY = packet.g2();
        } else if (code == 67) {
            this.scaleZ = packet.g2();
        } else if (code == 69) {
            this.blockedDirections = packet.g1();
        } else if (code == 70) {
            this.translateX = packet.g2s() << 2;
        } else if (code == 71) {
            this.translateY = packet.g2s() << 2;
        } else if (code == 72) {
            this.translateZ = packet.g2s() << 2;
        } else if (code == 73) {
            this.obstructiveGround = true;
        } else if (code == 74) {
            this.routingHint = true;
        } else if (code == 75) {
            this.lb = packet.g1();
        } else if (code == 77 || code == 92) {
            this.multiLocVarbit = packet.g2();
            if (this.multiLocVarbit == 65535) {
                this.multiLocVarbit = -1;
            }

            this.multiLocVarp = packet.g2();
            if (this.multiLocVarp == 65535) {
                this.multiLocVarp = -1;
            }

            @Pc(37) int defaultId = INVISIBLE_ID;
            if (code == 92) {
                defaultId = packet.g2();

                if (defaultId == 65535) {
                    defaultId = INVISIBLE_ID;
                }
            }

            @Pc(47) int count = packet.g1();
            this.multiLocs = new int[count + 2];
            for (@Pc(59) int i = 0; i <= count; i++) {
                this.multiLocs[i] = packet.g2();

                if (this.multiLocs[i] == 65535) {
                    this.multiLocs[i] = INVISIBLE_ID;
                }
            }

            this.multiLocs[count + 1] = defaultId;
        } else if (code == 78) {
            this.sound = packet.g2();
            this.soundDistance = packet.g1();
        } else if (code == 79) {
            this.anInt1231 = packet.g2();
            this.anInt1219 = packet.g2();
            this.soundDistance = packet.g1();
            @Pc(37) int local37 = packet.g1();
            this.anIntArray116 = new int[local37];
            for (@Pc(47) int local47 = 0; local47 < local37; local47++) {
                this.anIntArray116[local47] = packet.g2();
            }
        } else if (code == 81) {
            this.hillType = 2;
            this.hillValue = packet.g1() * 256;
        } else if (code == 82) {
            this.requiresTextures = true;
        } else if (code == 88) {
            this.hardShadow = false;
        } else if (code == 89) {
            this.aBoolean94 = false;
        } else if (code == 91) {
            this.members = true;
        } else if (code == 93) {
            this.hillType = 3;
            this.hillValue = packet.g2();
        } else if (code == 94) {
            this.hillType = 4;
        } else if (code == 95) {
            this.hillType = 5;
            this.hillValue = packet.g2s();
        } else if (code == 97) {
            this.msiRotate = true;
        } else if (code == 98) {
            this.animated = true;
        } else if (code == 99) {
            this.cursor1Op = packet.g1();
            this.cursor1 = packet.g2();
        } else if (code == 100) {
            this.cursor2Op = packet.g1();
            this.cursor2 = packet.g2();
        } else if (code == 101) {
            this.msiRotateOffset = packet.g1();
        } else if (code == 102) {
            this.msi = packet.g2();
        } else if (code == 103) {
            this.locOcclusionMode = LocOcclusionMode.ROOFS;
        } else if (code == 104) {
            this.ambientSoundVolume = packet.g1();
        } else if (code == 105) {
            this.msiFlip = true;
        } else if (code == 106) {
            @Pc(37) int count = packet.g1();
            @Pc(47) int totalChance = 0;
            this.animations = new int[count];
            this.animationChances = new int[count];

            for (@Pc(59) int i = 0; i < count; i++) {
                this.animations[i] = packet.g2();

                if (this.animations[i] == 65535) {
                    this.animations[i] = -1;
                }

                totalChance += this.animationChances[i] = packet.g1();
            }

            for (@Pc(67) int i = 0; i < count; i++) {
                this.animationChances[i] = (this.animationChances[i] * 65535) / totalChance;
            }
        } else if (code == 107) {
            this.mapElement = packet.g2();
        } else if (code >= 150 && code < 155) {
            this.ops[code - 150] = packet.gjstr();

            if (!this.typeList.allowMembers) {
                this.ops[code - 150] = null;
            }
        } else if (code == 160) {
            @Pc(37) int count = packet.g1();
            this.quests = new int[count];

            for (@Pc(47) int local47 = 0; local47 < count; local47++) {
                this.quests[local47] = packet.g2();
            }
        } else if (code == 162) {
            this.hillType = 3;
            this.hillValue = packet.g4();
        } else if (code == 163) {
            this.targetHue = packet.g1b();
            this.targetSaturation = packet.g1b();
            this.targetLightness = packet.g1b();
            this.colourShiftPercentage = packet.g1b();
        } else if (code == 164) {
            this.anInt1214 = packet.g2s();
        } else if (code == 165) {
            this.anInt1213 = packet.g2s();
        } else if (code == 166) {
            this.anInt1248 = packet.g2s();
        } else if (code == 167) {
            this.anInt1227 = packet.g2();
        } else if (code == 168) {
            this.aBoolean88 = true;
        } else if (code == 169) {
            this.aBoolean92 = true;
        } else if (code == 170) {
            this.occlusionHeight = packet.gsmart();
        } else if (code == 171) {
            this.occlusionOffset = packet.gsmart();
        } else if (code == 173) {
            this.anInt1268 = packet.g2();
            this.anInt1249 = packet.g2();
        } else if (code == 177) {
            this.aBoolean91 = true;
        } else if (code == 178) {
            this.anInt1221 = packet.g1();
        } else if (code == 249) {
            @Pc(37) int count = packet.g1();
            if (this.params == null) {
                @Pc(47) int size = IntMath.nextPow2(count);
                this.params = new HashTable(size);
            }

            for (@Pc(47) int i = 0; i < count; i++) {
                @Pc(872) boolean string = packet.g1() == 1;
                @Pc(67) int id = packet.g3();

                @Pc(885) Node param;
                if (string) {
                    param = new StringNode(packet.gjstr());
                } else {
                    param = new IntNode(packet.g4());
                }

                this.params.put(id, param);
            }
        }
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(Ljava/lang/String;IZ)Ljava/lang/String;")
    public String param(@OriginalArg(0) String dflt, @OriginalArg(1) int id) {
        if (this.params == null) {
            return dflt;
        } else {
            @Pc(25) StringNode param = (StringNode) this.params.get(id);
            return param == null ? dflt : param.value;
        }
    }

    @OriginalMember(owner = "client!c", name = "b", descriptor = "(II)Z")
    public boolean hasAnimation(@OriginalArg(0) int id) {
        if (this.animations != null && id != -1) {
            for (@Pc(21) int i = 0; i < this.animations.length; i++) {
                if (id == this.animations[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!c", name = "c", descriptor = "(I)Z")
    public boolean hasAnimations() {
        return this.animations != null;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(ILclient!uk;)Lclient!c;")
    public LocType getMultiLoc(@OriginalArg(1) VarDomain varDomain) {
        @Pc(5) int index = -1;
        if (this.multiLocVarbit != -1) {
            index = varDomain.getVarbitValue(this.multiLocVarbit);
        } else if (this.multiLocVarp != -1) {
            index = varDomain.getVarValueInt(this.multiLocVarp);
        }

        if (index < 0 || this.multiLocs.length - 1 <= index || this.multiLocs[index] == -1) {
            @Pc(74) int id = this.multiLocs[this.multiLocs.length - 1];
            return id == -1 ? null : this.typeList.list(id);
        } else {
            return this.typeList.list(this.multiLocs[index]);
        }
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(I)Z")
    public boolean isLoaded() {
        if (this.models == null) {
            return true;
        }

        @Pc(11) boolean loaded = true;
        @Pc(15) js5 local15 = this.typeList.meshes;
        synchronized (this.typeList.meshes) {
            for (@Pc(19) int i = 0; i < this.models.length; i++) {
                for (@Pc(22) int j = 0; j < this.models[i].length; j++) {
                    loaded &= this.typeList.meshes.requestdownload(0, this.models[i][j]);
                }
            }
            return loaded;
        }
    }

    @OriginalMember(owner = "client!c", name = "d", descriptor = "(I)Z")
    public boolean hasSounds() {
        if (this.multiLocs == null) {
            return this.sound != -1 || this.anIntArray116 != null;
        }

        for (@Pc(35) int i = 0; i < this.multiLocs.length; i++) {
            if (this.multiLocs[i] != INVISIBLE_ID) {
                @Pc(52) LocType locType = this.typeList.list(this.multiLocs[i]);
                if (locType.sound != -1 || locType.anIntArray116 != null) {
                    return true;
                }
            }
        }

        return false;
    }

    @OriginalMember(owner = "client!c", name = "c", descriptor = "(II)Z")
    public boolean loadedModels(@OriginalArg(0) int shape) {
        if (this.models == null) {
            return true;
        }

        @Pc(13) js5 local13 = this.typeList.meshes;
        synchronized (this.typeList.meshes) {
            for (@Pc(26) int i = 0; i < this.modelShapes.length; i++) {
                if (shape == this.modelShapes[i]) {
                    for (@Pc(35) int j = 0; j < this.models[i].length; j++) {
                        if (!this.typeList.meshes.requestdownload(0, this.models[i][j])) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            return true;
        }
    }

    @OriginalMember(owner = "client!c", name = "b", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(3) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(packet, code);
        }
    }

    @OriginalMember(owner = "client!c", name = "b", descriptor = "(I)V")
    public void postDecode() {
        if (this.interactivity == LocInteractivity.UNSET) {
            this.interactivity = LocInteractivity.NONINTERACTIVE;

            if (this.modelShapes != null && this.modelShapes.length == 1 && this.modelShapes[0] == 10) {
                this.interactivity = LocInteractivity.INTERACTIVE;
            }

            for (@Pc(43) int i = 0; i < 5; i++) {
                if (this.ops[i] != null) {
                    this.interactivity = LocInteractivity.INTERACTIVE;
                    break;
                }
            }
        }

        if (this.lb == -1) {
            this.lb = this.movementPolicy == 0 ? 0 : 1;
        }

        if (this.hasAnimations() || this.animated || this.multiLocs != null) {
            this.aBoolean91 = true;
        }
    }

    @OriginalMember(owner = "client!c", name = "e", descriptor = "(I)I")
    public int randomAnimation() {
        if (this.animations != null) {
            if (this.animations.length <= 1) {
                return this.animations[0];
            }

            @Pc(34) int random = (int) (Math.random() * 65535.0D);
            for (@Pc(36) int i = 0; i < this.animations.length; i++) {
                if (random <= this.animationChances[i]) {
                    return this.animations[i];
                }

                random -= this.animationChances[i];
            }
        }

        return -1;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(IIILclient!s;ZBIILclient!ha;Lclient!gp;ILclient!s;)Lclient!od;")
    public ModelAndShadow modelAndShadow(@OriginalArg(0) int rotation, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Ground arg3, @OriginalArg(4) boolean addShadow, @OriginalArg(6) int arg5, @OriginalArg(7) int shape, @OriginalArg(8) Toolkit toolkit, @OriginalArg(9) LocTypeCustomisation customisation, @OriginalArg(10) int functionMask, @OriginalArg(11) Ground ground) {
        if (LocShapes.isWallDecor(shape)) {
            shape = LocShapes.WALLDECOR_STRAIGHT_NOOFFSET;
        }

        @Pc(21) long key = (long) (rotation + (this.id << 10) + (shape << 3));
        key |= (long) (toolkit.index << 29);
        if (customisation != null) {
            key |= customisation.id << 32;
        }

        @Pc(40) int newFunctionMask = functionMask;
        if (this.hillType == 3) {
            newFunctionMask = functionMask | 0x7;
        } else {
            if (this.hillType != 0 || this.anInt1213 != 0) {
                newFunctionMask = functionMask | 0x2;
            }
            if (this.anInt1214 != 0) {
                newFunctionMask |= 0x1;
            }
            if (this.anInt1248 != 0) {
                newFunctionMask |= 0x4;
            }
        }

        if (addShadow) {
            newFunctionMask |= 0x40000;
        }

        @Pc(96) ReferenceCache local96 = this.typeList.modelAndShadows;
        @Pc(106) ModelAndShadow modelAndShadow;
        synchronized (this.typeList.modelAndShadows) {
            modelAndShadow = (ModelAndShadow) this.typeList.modelAndShadows.get(key);
        }

        @Pc(120) Model model = modelAndShadow == null ? null : modelAndShadow.model;
        @Pc(122) Shadow shadow = null;
        if (model != null && toolkit.compareFunctionMasks(model.ua(), newFunctionMask) == 0) {
            model = modelAndShadow.model;
            shadow = modelAndShadow.shadow;

            if (addShadow && shadow == null) {
                shadow = modelAndShadow.shadow = model.ba((Shadow) null);
            }
        } else {
            if (model != null) {
                newFunctionMask = toolkit.combineFunctionMasks(newFunctionMask, model.ua());
            }

            @Pc(144) int innerMask = newFunctionMask;
            if (shape == LocShapes.CENTREPIECE_STRAIGHT && rotation > 3) {
                innerMask = newFunctionMask | 0x5;
            }

            model = this.model(toolkit, innerMask, customisation, rotation, shape);
            if (model == null) {
                return null;
            }

            if (shape == LocShapes.CENTREPIECE_STRAIGHT && rotation > 3) {
                model.a(2048);
            }

            if (addShadow) {
                shadow = model.ba((Shadow) null);
            }

            model.s(newFunctionMask);
            modelAndShadow = new ModelAndShadow();
            modelAndShadow.shadow = shadow;
            modelAndShadow.model = model;

            @Pc(210) ReferenceCache local210 = this.typeList.modelAndShadows;
            synchronized (this.typeList.modelAndShadows) {
                this.typeList.modelAndShadows.put(modelAndShadow, key);
            }
        }

        @Pc(271) boolean local271 = this.hillType != 0 && (arg3 != null || ground != null);
        @Pc(292) boolean local292 = this.anInt1214 != 0 || this.anInt1213 != 0 || this.anInt1248 != 0;
        if (local271 || local292) {
            model = model.copy((byte) 0, newFunctionMask, true);

            if (local271) {
                model.p(this.hillType, this.hillValue, arg3, ground, arg2, arg5, arg1);
            }

            if (local292) {
                model.H(this.anInt1214, this.anInt1213, this.anInt1248);
            }

            model.s(functionMask);
        } else {
            model = model.copy((byte) 0, functionMask, true);
        }

        LocType.modelAndShadow.model = model;
        LocType.modelAndShadow.shadow = shadow;

        return LocType.modelAndShadow;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(IIIILclient!s;Lclient!gu;ILclient!ha;Lclient!s;Lclient!gp;II)Lclient!ka;")
    public Model wallModel(@OriginalArg(0) int rotation, @OriginalArg(1) int arg1, @OriginalArg(2) int shape, @OriginalArg(3) int arg3, @OriginalArg(4) Ground arg4, @OriginalArg(5) Animator animator, @OriginalArg(7) Toolkit toolkit, @OriginalArg(8) Ground arg7, @OriginalArg(9) LocTypeCustomisation customisation, @OriginalArg(10) int functionMask, @OriginalArg(11) int arg10) {
        if (LocShapes.isWallDecor(shape)) {
            shape = LocShapes.WALLDECOR_STRAIGHT_NOOFFSET;
        }

        @Pc(22) long key = (long) ((this.id << 10) + ((shape << 3) + rotation));
        @Pc(24) int functionMaskBefore = functionMask;
        key |= (long) (toolkit.index << 29);
        if (customisation != null) {
            key |= customisation.id << 32;
        }

        if (animator != null) {
            functionMask |= animator.functionMask();
        }

        if (this.hillType == 3) {
            functionMask |= 0x7;
        } else {
            if (this.hillType != 0 || this.anInt1213 != 0) {
                functionMask |= 0x2;
            }

            if (this.anInt1214 != 0) {
                functionMask |= 0x1;
            }

            if (this.anInt1248 != 0) {
                functionMask |= 0x4;
            }
        }

        if (shape == LocShapes.CENTREPIECE_STRAIGHT && rotation > 3) {
            functionMask |= 0x5;
        }

        @Pc(116) ReferenceCache local116 = this.typeList.wallModels;
        @Pc(126) Model model;
        synchronized (this.typeList.wallModels) {
            model = (Model) this.typeList.wallModels.get(key);
        }

        if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
            if (model != null) {
                functionMask = toolkit.combineFunctionMasks(functionMask, model.ua());
            }

            model = this.model(toolkit, functionMask, customisation, rotation, shape);

            if (model == null) {
                return null;
            }

            local116 = this.typeList.wallModels;
            synchronized (this.typeList.wallModels) {
                this.typeList.wallModels.put(model, key);
            }
        }

        @Pc(190) boolean copied = false;
        if (animator != null) {
            model = model.copy((byte) 1, functionMask, true);
            copied = true;
            animator.animate(model, rotation & 0x3);
        }

        if (shape == LocShapes.CENTREPIECE_STRAIGHT && rotation > 3) {
            if (!copied) {
                model = model.copy((byte) 3, functionMask, true);
                copied = true;
            }
            model.a(2048);
        }

        if (this.hillType != 0) {
            if (!copied) {
                copied = true;
                model = model.copy((byte) 3, functionMask, true);
            }
            model.p(this.hillType, this.hillValue, arg7, arg4, arg3, arg10, arg1);
        }

        if (this.anInt1214 != 0 || this.anInt1213 != 0 || this.anInt1248 != 0) {
            if (!copied) {
                model = model.copy((byte) 3, functionMask, true);
                copied = true;
            }
            model.H(this.anInt1214, this.anInt1213, this.anInt1248);
        }

        if (copied) {
            model.s(functionMaskBefore);
        }

        return model;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!ha;ILclient!gp;BII)Lclient!ka;")
    public Model model(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int functionMask, @OriginalArg(2) LocTypeCustomisation customisation, @OriginalArg(4) int rotation, @OriginalArg(5) int shape) {
        @Pc(8) int ambient = this.ambient + 64;
        @Pc(13) int contrast = this.contrast + 850;
        @Pc(15) int functionMaskBefore = functionMask;

        @Pc(35) boolean mirror = this.mirrorModel || shape == LocShapes.WALL_L && rotation > 3;
        if (mirror) {
            functionMask |= 0x10;
        }

        if (rotation == 0) {
            if (this.scaleX != 128 || this.translateX != 0) {
                functionMask |= 0x1;
            }
            if (this.scaleZ != 128 || this.translateZ != 0) {
                functionMask |= 0x4;
            }
        } else {
            functionMask |= 0xD;
        }

        if (this.scaleY != 128 || this.translateY != 0) {
            functionMask |= 0x2;
        }

        if (this.recol_s != null) {
            functionMask |= 0x4000;
        }

        if (this.retex_s != null) {
            functionMask |= 0x8000;
        }

        if (this.colourShiftPercentage != 0) {
            functionMask |= 0x80000;
        }

        @Pc(123) Model model = null;
        if (this.modelShapes == null) {
            return null;
        }

        @Pc(131) int shapeIndex = -1;
        for (@Pc(139) int i = 0; i < this.modelShapes.length; i++) {
            if (this.modelShapes[i] == shape) {
                shapeIndex = i;
                break;
            }
        }

        if (shapeIndex == -1) {
            return null;
        }

        @Pc(179) int[] models = (customisation != null && customisation.models != null) ? customisation.models : this.models[shapeIndex];
        @Pc(182) int modelCount = models.length;
        if (modelCount > 0) {
            @Pc(191) long key = (long) toolkit.index;
            for (@Pc(193) int i = 0; i < modelCount; i++) {
                key = (key * 67783L) + (long) models[i];
            }

            @Pc(211) ReferenceCache local211 = this.typeList.models;
            synchronized (this.typeList.models) {
                model = (Model) this.typeList.models.get(key);
            }

            if (model != null) {
                if (model.WA() != ambient) {
                    functionMask |= 0x1000;
                }

                if (contrast != model.da()) {
                    functionMask |= 0x2000;
                }
            }

            if (model == null || toolkit.compareFunctionMasks(model.ua(), functionMask) != 0) {
                @Pc(265) int innerFunctionMask = functionMask | 0x1F01F;
                if (model != null) {
                    innerFunctionMask = toolkit.combineFunctionMasks(innerFunctionMask, model.ua());
                }

                @Pc(275) Mesh mesh = null;
                @Pc(277) Mesh[] local277 = A_MESH_ARRAY_1;
                synchronized (A_MESH_ARRAY_1) {
                    for (@Pc(281) int i = 0; i < modelCount; i++) {
                        @Pc(286) js5 local286 = this.typeList.meshes;
                        synchronized (this.typeList.meshes) {
                            mesh = Mesh.load(models[i] & 0xFFFF, this.typeList.meshes);
                        }

                        if (mesh == null) {
                            return null;
                        }

                        if (mesh.version < 13) {
                            mesh.upscale();
                        }

                        if (modelCount > 1) {
                            A_MESH_ARRAY_1[i] = mesh;
                        }
                    }

                    if (modelCount > 1) {
                        mesh = new Mesh(A_MESH_ARRAY_1, modelCount);
                    }
                }

                model = toolkit.createModel(mesh, innerFunctionMask, this.typeList.featureMask, ambient, contrast);

                @Pc(372) ReferenceCache local372 = this.typeList.models;
                synchronized (this.typeList.models) {
                    this.typeList.models.put(model, key);
                }
            }
        }

        if (model == null) {
            return null;
        }

        @Pc(398) Model result = model.copy((byte) 0, functionMask, true);

        if (ambient != model.WA()) {
            result.C(ambient);
        }

        if (model.da() != contrast) {
            result.LA(contrast);
        }

        if (mirror) {
            result.v();
        }

        if (shape == 4 && rotation > 3) {
            result.k(2048);
            result.H(180, 0, -180);
        }

        @Pc(448) int rotationMask = rotation & 0x3;
        if (rotationMask == 1) {
            result.k(4096);
        } else if (rotationMask == 2) {
            result.k(8192);
        } else if (rotationMask == 3) {
            result.k(12288);
        }

        if (this.recol_s != null) {
            @Pc(490) short[] recol_d;
            if (customisation == null || customisation.recol_d == null) {
                recol_d = this.recol_d;
            } else {
                recol_d = customisation.recol_d;
            }

            for (@Pc(193) int i = 0; i < this.recol_s.length; i++) {
                if (this.recol_d_palette == null || this.recol_d_palette.length <= i) {
                    result.ia(this.recol_s[i], recol_d[i]);
                } else {
                    result.ia(this.recol_s[i], clientpalette[this.recol_d_palette[i] & 0xFF]);
                }
            }
        }

        if (this.retex_s != null) {
            @Pc(490) short[] retex_d;
            if (customisation == null || customisation.retex_d == null) {
                retex_d = this.retex_d;
            } else {
                retex_d = customisation.retex_d;
            }

            for (@Pc(193) int i = 0; i < this.retex_s.length; i++) {
                result.aa(this.retex_s[i], retex_d[i]);
            }
        }

        if (this.colourShiftPercentage != 0) {
            result.adjustColours(this.targetHue, this.targetSaturation, this.targetLightness, this.colourShiftPercentage & 0xFF);
        }

        if (this.scaleX != 128 || this.scaleY != 128 || this.scaleZ != 128) {
            result.O(this.scaleX, this.scaleY, this.scaleZ);
        }

        if (this.translateX != 0 || this.translateY != 0 || this.translateZ != 0) {
            result.H(this.translateX, this.translateY, this.translateZ);
        }

        result.s(functionMaskBefore);
        return result;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(BLclient!ge;)V")
    public void skip(@OriginalArg(1) Packet packet) {
        @Pc(12) int count = packet.g1();

        for (@Pc(14) int i = 0; i < count; i++) {
            packet.pos++;

            @Pc(25) int skip = packet.g1();
            packet.pos += skip * 2;
        }
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(III)I")
    public int param(@OriginalArg(0) int dflt, @OriginalArg(2) int id) {
        if (this.params == null) {
            return dflt;
        } else {
            @Pc(17) IntNode param = (IntNode) this.params.get(id);
            return param == null ? dflt : param.value;
        }
    }
}
