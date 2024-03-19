import com.jagex.core.io.Packet;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dv")
public final class Mesh {

    @OriginalMember(owner = "client!dv", name = "k", descriptor = "[I")
    public int[] vertexZ;

    @OriginalMember(owner = "client!dv", name = "m", descriptor = "[S")
    public short[] aShortArray20;

    @OriginalMember(owner = "client!dv", name = "S", descriptor = "[I")
    public int[] vertexY;

    @OriginalMember(owner = "client!dv", name = "R", descriptor = "[S")
    public short[] texSpaceDefB;

    @OriginalMember(owner = "client!dv", name = "Y", descriptor = "[S")
    public short[] faceColour;

    @OriginalMember(owner = "client!dv", name = "O", descriptor = "[S")
    public short[] originModels;

    @OriginalMember(owner = "client!dv", name = "u", descriptor = "[S")
    public short[] faceB;

    @OriginalMember(owner = "client!dv", name = "t", descriptor = "[I")
    public int[] anIntArray206;

    @OriginalMember(owner = "client!dv", name = "N", descriptor = "[B")
    public byte[] aByteArray23;

    @OriginalMember(owner = "client!dv", name = "I", descriptor = "[B")
    public byte[] texMappingType;

    @OriginalMember(owner = "client!dv", name = "Q", descriptor = "[S")
    public short[] faceTexture;

    @OriginalMember(owner = "client!dv", name = "e", descriptor = "[I")
    public int[] texSpaceScaleY;

    @OriginalMember(owner = "client!dv", name = "f", descriptor = "[S")
    public short[] faceC;

    @OriginalMember(owner = "client!dv", name = "r", descriptor = "[Lclient!rv;")
    public MeshEmitter[] emitters;

    @OriginalMember(owner = "client!dv", name = "M", descriptor = "[I")
    public int[] texSpaceScaleZ;

    @OriginalMember(owner = "client!dv", name = "i", descriptor = "[B")
    public byte[] shadingTypes;

    @OriginalMember(owner = "client!dv", name = "W", descriptor = "[I")
    public int[] vertexGroup;

    @OriginalMember(owner = "client!dv", name = "Z", descriptor = "[S")
    public short[] faceA;

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "[I")
    public int[] faceGroup;

    @OriginalMember(owner = "client!dv", name = "l", descriptor = "[I")
    public int[] texSpaceScaleX;

    @OriginalMember(owner = "client!dv", name = "y", descriptor = "[S")
    public short[] texSpaceDefC;

    @OriginalMember(owner = "client!dv", name = "E", descriptor = "[B")
    public byte[] facePriorities;

    @OriginalMember(owner = "client!dv", name = "X", descriptor = "[B")
    public byte[] aByteArray27;

    @OriginalMember(owner = "client!dv", name = "J", descriptor = "[B")
    public byte[] faceAlpha;

    @OriginalMember(owner = "client!dv", name = "c", descriptor = "[S")
    public short[] texSpaceDefA;

    @OriginalMember(owner = "client!dv", name = "g", descriptor = "[I")
    public int[] anIntArray212;

    @OriginalMember(owner = "client!dv", name = "b", descriptor = "[I")
    public int[] vertexX;

    @OriginalMember(owner = "client!dv", name = "w", descriptor = "[I")
    public int[] anIntArray214;

    @OriginalMember(owner = "client!dv", name = "p", descriptor = "[Lclient!mn;")
    public MeshMagnet[] magnets;

    @OriginalMember(owner = "client!dv", name = "d", descriptor = "[Lclient!aq;")
    public MeshBillboard[] billboards;

    @OriginalMember(owner = "client!dv", name = "B", descriptor = "[B")
    public byte[] faceTexSpace;

    @OriginalMember(owner = "client!dv", name = "n", descriptor = "I")
    public int faceCount = 0;

    @OriginalMember(owner = "client!dv", name = "z", descriptor = "I")
    public int vertexCount = 0;

    @OriginalMember(owner = "client!dv", name = "D", descriptor = "I")
    public int maxVertex = 0;

    @OriginalMember(owner = "client!dv", name = "L", descriptor = "I")
    public int texSpaceCount = 0;

    @OriginalMember(owner = "client!dv", name = "j", descriptor = "B")
    public byte globalPriority = 0;

    @OriginalMember(owner = "client!dv", name = "h", descriptor = "I")
    public int version = 12;

    @OriginalMember(owner = "client!dv", name = "<init>", descriptor = "()V")
    public Mesh() {
    }

    @OriginalMember(owner = "client!dv", name = "<init>", descriptor = "([B)V")
    public Mesh(@OriginalArg(0) byte[] arg0) {
        if (arg0[arg0.length - 1] == -1 && arg0[arg0.length - 2] == -1) {
            this.method2235(arg0);
        } else {
            this.decodeOld(arg0);
        }
    }

    @OriginalMember(owner = "client!dv", name = "<init>", descriptor = "(III)V")
    public Mesh(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        this.faceGroup = new int[arg1];
        this.faceTexture = new short[arg1];
        this.faceColour = new short[arg1];
        this.faceB = new short[arg1];
        this.facePriorities = new byte[arg1];
        this.shadingTypes = new byte[arg1];
        this.vertexY = new int[arg0];
        this.faceA = new short[arg1];
        if (arg2 > 0) {
            this.texSpaceDefB = new short[arg2];
            this.texSpaceScaleX = new int[arg2];
            this.aByteArray23 = new byte[arg2];
            this.anIntArray214 = new int[arg2];
            this.texSpaceDefA = new short[arg2];
            this.texSpaceDefC = new short[arg2];
            this.texMappingType = new byte[arg2];
            this.texSpaceScaleZ = new int[arg2];
            this.aByteArray27 = new byte[arg2];
            this.anIntArray212 = new int[arg2];
            this.anIntArray206 = new int[arg2];
            this.texSpaceScaleY = new int[arg2];
        }
        this.vertexX = new int[arg0];
        this.vertexGroup = new int[arg0];
        this.vertexZ = new int[arg0];
        this.faceAlpha = new byte[arg1];
        this.faceTexSpace = new byte[arg1];
        this.faceC = new short[arg1];
    }

    @OriginalMember(owner = "client!dv", name = "<init>", descriptor = "([Lclient!dv;I)V")
    public Mesh(@OriginalArg(0) Mesh[] arg0, @OriginalArg(1) int arg1) {
        this.texSpaceCount = 0;
        this.vertexCount = 0;
        this.faceCount = 0;
        @Pc(30) int local30 = 0;
        @Pc(32) int local32 = 0;
        @Pc(34) int local34 = 0;
        @Pc(36) boolean local36 = false;
        @Pc(38) boolean local38 = false;
        @Pc(40) boolean local40 = false;
        @Pc(42) boolean local42 = false;
        @Pc(44) boolean local44 = false;
        @Pc(46) boolean local46 = false;
        this.globalPriority = -1;
        for (@Pc(51) int local51 = 0; local51 < arg1; local51++) {
            @Pc(56) Mesh local56 = arg0[local51];
            if (local56 != null) {
                this.faceCount += local56.faceCount;
                this.texSpaceCount += local56.texSpaceCount;
                this.vertexCount += local56.vertexCount;
                if (local56.magnets != null) {
                    local32 += local56.magnets.length;
                }
                if (local56.billboards != null) {
                    local34 += local56.billboards.length;
                }
                if (local56.emitters != null) {
                    local30 += local56.emitters.length;
                }
                local36 |= local56.shadingTypes != null;
                local40 |= local56.faceTexSpace != null;
                if (local56.facePriorities == null) {
                    if (this.globalPriority == -1) {
                        this.globalPriority = local56.globalPriority;
                    }
                    if (local56.globalPriority != this.globalPriority) {
                        local38 = true;
                    }
                } else {
                    local38 = true;
                }
                local42 |= local56.faceAlpha != null;
                local46 |= local56.faceGroup != null;
                local44 |= local56.faceTexture != null;
            }
        }
        this.vertexX = new int[this.vertexCount];
        this.faceA = new short[this.faceCount];
        if (local36) {
            this.shadingTypes = new byte[this.faceCount];
        }
        if (local32 > 0) {
            this.magnets = new MeshMagnet[local32];
        }
        this.originModels = new short[this.vertexCount];
        this.vertexY = new int[this.vertexCount];
        this.aShortArray20 = new short[this.faceCount];
        if (local46) {
            this.faceGroup = new int[this.faceCount];
        }
        this.faceColour = new short[this.faceCount];
        this.faceB = new short[this.faceCount];
        this.faceC = new short[this.faceCount];
        if (this.texSpaceCount > 0) {
            this.texSpaceScaleX = new int[this.texSpaceCount];
            this.aByteArray27 = new byte[this.texSpaceCount];
            this.aByteArray23 = new byte[this.texSpaceCount];
            this.texSpaceDefC = new short[this.texSpaceCount];
            this.texSpaceDefA = new short[this.texSpaceCount];
            this.texSpaceScaleZ = new int[this.texSpaceCount];
            this.texSpaceDefB = new short[this.texSpaceCount];
            this.anIntArray212 = new int[this.texSpaceCount];
            this.texMappingType = new byte[this.texSpaceCount];
            this.anIntArray214 = new int[this.texSpaceCount];
            this.texSpaceScaleY = new int[this.texSpaceCount];
            this.anIntArray206 = new int[this.texSpaceCount];
        }
        if (local34 > 0) {
            this.billboards = new MeshBillboard[local34];
        }
        if (local42) {
            this.faceAlpha = new byte[this.faceCount];
        }
        this.vertexGroup = new int[this.vertexCount];
        this.vertexZ = new int[this.vertexCount];
        if (local44) {
            this.faceTexture = new short[this.faceCount];
        }
        if (local40) {
            this.faceTexSpace = new byte[this.faceCount];
        }
        if (local30 > 0) {
            this.emitters = new MeshEmitter[local30];
        }
        if (local38) {
            this.facePriorities = new byte[this.faceCount];
        }
        local32 = 0;
        this.texSpaceCount = 0;
        local30 = 0;
        local34 = 0;
        this.faceCount = 0;
        this.vertexCount = 0;
        @Pc(648) int local648;
        @Pc(659) int local659;
        for (@Pc(401) int local401 = 0; local401 < arg1; local401++) {
            @Pc(407) short local407 = (short) (0x1 << local401);
            @Pc(411) Mesh local411 = arg0[local401];
            if (local411 != null) {
                @Pc(420) int local420;
                if (local411.billboards != null) {
                    for (local420 = 0; local420 < local411.billboards.length; local420++) {
                        @Pc(426) MeshBillboard local426 = local411.billboards[local420];
                        this.billboards[local34++] = local426.method682(local426.anInt588 + this.faceCount);
                    }
                }
                for (local420 = 0; local420 < local411.faceCount; local420++) {
                    if (local36 && local411.shadingTypes != null) {
                        this.shadingTypes[this.faceCount] = local411.shadingTypes[local420];
                    }
                    if (local38) {
                        if (local411.facePriorities == null) {
                            this.facePriorities[this.faceCount] = local411.globalPriority;
                        } else {
                            this.facePriorities[this.faceCount] = local411.facePriorities[local420];
                        }
                    }
                    if (local40 && local411.faceTexSpace != null) {
                        this.faceTexSpace[this.faceCount] = local411.faceTexSpace[local420];
                    }
                    if (local44) {
                        if (local411.faceTexture == null) {
                            this.faceTexture[this.faceCount] = -1;
                        } else {
                            this.faceTexture[this.faceCount] = local411.faceTexture[local420];
                        }
                    }
                    if (local46) {
                        if (local411.faceGroup == null) {
                            this.faceGroup[this.faceCount] = -1;
                        } else {
                            this.faceGroup[this.faceCount] = local411.faceGroup[local420];
                        }
                    }
                    this.faceA[this.faceCount] = (short) this.addVertex(local411, local411.faceA[local420], local407);
                    this.faceB[this.faceCount] = (short) this.addVertex(local411, local411.faceB[local420], local407);
                    this.faceC[this.faceCount] = (short) this.addVertex(local411, local411.faceC[local420], local407);
                    this.aShortArray20[this.faceCount] = local407;
                    this.faceColour[this.faceCount] = local411.faceColour[local420];
                    this.faceCount++;
                }
                @Pc(636) int local636;
                if (local411.emitters != null) {
                    for (local636 = 0; local636 < local411.emitters.length; local636++) {
                        local648 = this.addVertex(local411, local411.emitters[local636].anInt8514, local407);
                        local659 = this.addVertex(local411, local411.emitters[local636].anInt8508, local407);
                        @Pc(670) int local670 = this.addVertex(local411, local411.emitters[local636].anInt8505, local407);
                        this.emitters[local30] = local411.emitters[local636].method7554(local648, local659, local670);
                        local30++;
                    }
                }
                if (local411.magnets != null) {
                    for (local636 = 0; local636 < local411.magnets.length; local636++) {
                        local648 = this.addVertex(local411, local411.magnets[local636].anInt6247, local407);
                        this.magnets[local32] = local411.magnets[local636].method5593(local648);
                        local32++;
                    }
                }
            }
        }
        this.maxVertex = this.vertexCount;
        @Pc(747) int local747 = 0;
        for (@Pc(749) int local749 = 0; local749 < arg1; local749++) {
            @Pc(755) short local755 = (short) (0x1 << local749);
            @Pc(759) Mesh local759 = arg0[local749];
            if (local759 != null) {
                for (local648 = 0; local648 < local759.faceCount; local648++) {
                    if (local42) {
                        this.faceAlpha[local747++] = (byte) (local759.faceAlpha == null || local759.faceAlpha[local648] == -1 ? -1 : local759.faceAlpha[local648] + this.texSpaceCount);
                    }
                }
                for (local659 = 0; local659 < local759.texSpaceCount; local659++) {
                    @Pc(815) byte local815 = this.texMappingType[this.texSpaceCount] = local759.texMappingType[local659];
                    if (local815 == 0) {
                        this.texSpaceDefA[this.texSpaceCount] = (short) this.addVertex(local759, local759.texSpaceDefA[local659], local755);
                        this.texSpaceDefB[this.texSpaceCount] = (short) this.addVertex(local759, local759.texSpaceDefB[local659], local755);
                        this.texSpaceDefC[this.texSpaceCount] = (short) this.addVertex(local759, local759.texSpaceDefC[local659], local755);
                    }
                    if (local815 >= 1 && local815 <= 3) {
                        this.texSpaceDefA[this.texSpaceCount] = local759.texSpaceDefA[local659];
                        this.texSpaceDefB[this.texSpaceCount] = local759.texSpaceDefB[local659];
                        this.texSpaceDefC[this.texSpaceCount] = local759.texSpaceDefC[local659];
                        this.texSpaceScaleX[this.texSpaceCount] = local759.texSpaceScaleX[local659];
                        this.texSpaceScaleY[this.texSpaceCount] = local759.texSpaceScaleY[local659];
                        this.texSpaceScaleZ[this.texSpaceCount] = local759.texSpaceScaleZ[local659];
                        this.aByteArray27[this.texSpaceCount] = local759.aByteArray27[local659];
                        this.aByteArray23[this.texSpaceCount] = local759.aByteArray23[local659];
                        this.anIntArray214[this.texSpaceCount] = local759.anIntArray214[local659];
                    }
                    if (local815 == 2) {
                        this.anIntArray212[this.texSpaceCount] = local759.anIntArray212[local659];
                        this.anIntArray206[this.texSpaceCount] = local759.anIntArray206[local659];
                    }
                    this.texSpaceCount++;
                }
            }
        }
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(IIII)I")
    public int method2230(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        for (@Pc(15) int local15 = 0; local15 < this.vertexCount; local15++) {
            if (arg2 == this.vertexX[local15] && arg1 == this.vertexY[local15] && arg0 == this.vertexZ[local15]) {
                return local15;
            }
        }
        this.vertexX[this.vertexCount] = arg2;
        this.vertexY[this.vertexCount] = arg1;
        this.vertexZ[this.vertexCount] = arg0;
        this.maxVertex = this.vertexCount + 1;
        return this.vertexCount++;
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(ZIIISSBBB)I")
    public int method2231(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) short arg3, @OriginalArg(5) short arg4, @OriginalArg(6) byte arg5, @OriginalArg(7) byte arg6, @OriginalArg(8) byte arg7) {
        this.faceA[this.faceCount] = (short) arg0;
        this.faceB[this.faceCount] = (short) arg2;
        this.faceC[this.faceCount] = (short) arg1;
        this.shadingTypes[this.faceCount] = arg6;
        this.faceAlpha[this.faceCount] = arg7;
        this.faceColour[this.faceCount] = arg3;
        this.faceTexSpace[this.faceCount] = arg5;
        this.faceTexture[this.faceCount] = arg4;
        return this.faceCount++;
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(II)V")
    public void upscale() {
        for (@Pc(1) int local1 = 0; local1 < this.vertexCount; local1++) {
            this.vertexX[local1] <<= 0x2;
            this.vertexY[local1] <<= 0x2;
            this.vertexZ[local1] <<= 0x2;
        }
        if (this.texSpaceCount <= 0 || this.texSpaceScaleX == null) {
            return;
        }
        for (@Pc(51) int local51 = 0; local51 < this.texSpaceScaleX.length; local51++) {
            this.texSpaceScaleX[local51] <<= 0x2;
            this.texSpaceScaleY[local51] <<= 0x2;
            if (this.texMappingType[local51] != 1) {
                this.texSpaceScaleZ[local51] <<= 0x2;
            }
        }
    }

    @OriginalMember(owner = "client!dv", name = "b", descriptor = "(IIII)V")
    public void translate(@OriginalArg(0) int tx, @OriginalArg(1) int ty, @OriginalArg(3) int tz) {
        for (@Pc(13) int i = 0; i < this.vertexCount; i++) {
            this.vertexX[i] += tx;
            this.vertexY[i] += ty;
            this.vertexZ[i] += tz;
        }
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(IZ)[[I")
    public int[][] method2234(@OriginalArg(1) boolean arg0) {
        @Pc(8) int[] local8 = new int[256];
        @Pc(10) int local10 = 0;
        @Pc(19) int local19 = arg0 ? this.vertexCount : this.maxVertex;
        for (@Pc(21) int local21 = 0; local21 < local19; local21++) {
            @Pc(30) int local30 = this.vertexGroup[local21];
            if (local30 >= 0) {
                if (local10 < local30) {
                    local10 = local30;
                }
                @Pc(50) int local50 = local8[local30]++;
            }
        }
        @Pc(66) int[][] local66 = new int[local10 + 1][];
        for (@Pc(70) int local70 = 0; local70 <= local10; local70++) {
            local66[local70] = new int[local8[local70]];
            local8[local70] = 0;
        }
        for (@Pc(95) int local95 = 0; local95 < local19; local95++) {
            @Pc(104) int local104 = this.vertexGroup[local95];
            if (local104 >= 0) {
                local66[local104][local8[local104]++] = local95;
            }
        }
        return local66;
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "([BZ)V")
    public void method2235(@OriginalArg(0) byte[] data) {
        @Pc(8) Packet packet1 = new Packet(data);
        @Pc(13) Packet packet2 = new Packet(data);
        @Pc(18) Packet packet3 = new Packet(data);
        @Pc(23) Packet packet4 = new Packet(data);
        @Pc(28) Packet packet5 = new Packet(data);
        @Pc(33) Packet packet6 = new Packet(data);
        @Pc(38) Packet packet7 = new Packet(data);

        packet1.pos = data.length - 23;

        this.vertexCount = packet1.g2();
        this.faceCount = packet1.g2();
        this.texSpaceCount = packet1.g1();

        @Pc(63) int globalFlags = packet1.g1();
        @Pc(75) boolean hasSmoothingTypes = (globalFlags & 0x1) == 1;
        @Pc(85) boolean hasParticleEffects = (globalFlags & 0x2) == 2;
        @Pc(97) boolean hasBillboards = (globalFlags & 0x4) == 4;
        @Pc(109) boolean hasVersion = (globalFlags & 0x8) == 8;

        if (hasVersion) {
            packet1.pos -= 7;
            this.version = packet1.g1();
            packet1.pos += 6;
        }

        @Pc(134) int priorityFlag = packet1.g1();
        @Pc(138) int faceAlphaFlag = packet1.g1();
        @Pc(142) int faceGroupFlag = packet1.g1();
        @Pc(146) int faceTextureFlag = packet1.g1();
        @Pc(150) int vertexGroupFlag = packet1.g1();
        @Pc(154) int vertexLengthX = packet1.g2();
        @Pc(158) int vertexLengthY = packet1.g2();
        @Pc(162) int vertexLengthZ = packet1.g2();
        @Pc(166) int faceDataSize = packet1.g2();
        @Pc(170) int texSpaceSize = packet1.g2();
        @Pc(172) int planarMappingCount = 0;
        @Pc(174) int complexMappingCount = 0;
        @Pc(176) int cubeMappingCount = 0;

        if (this.texSpaceCount > 0) {
            this.texMappingType = new byte[this.texSpaceCount];

            packet1.pos = 0;

            for (@Pc(192) int i = 0; i < this.texSpaceCount; i++) {
                @Pc(202) byte type = this.texMappingType[i] = packet1.g1b();

                if (type == 0) {
                    planarMappingCount++;
                }

                if (type == 2) {
                    cubeMappingCount++;
                }

                if (type >= 1 && type <= 3) {
                    complexMappingCount++;
                }
            }
        }

        @Pc(192) int ptr = this.texSpaceCount;

        @Pc(242) int vertexFlagsPtr = ptr;
        ptr += this.vertexCount;

        @Pc(249) int smoothingPtr = ptr;
        if (hasSmoothingTypes) {
            ptr += this.faceCount;
        }

        @Pc(258) int faceTypePtr = ptr;
        ptr += this.faceCount;

        @Pc(265) int facePriPtr = ptr;
        if (priorityFlag == 255) {
            ptr += this.faceCount;
        }

        @Pc(277) int faceGroupPtr = ptr;
        if (faceGroupFlag == 1) {
            ptr += this.faceCount;
        }

        @Pc(287) int vertexGroupPtr = ptr;
        if (vertexGroupFlag == 1) {
            ptr += this.vertexCount;
        }

        @Pc(299) int faceAlphaPtr = ptr;
        if (faceAlphaFlag == 1) {
            ptr += this.faceCount;
        }

        @Pc(309) int faceDataSizePtr = ptr;
        ptr += faceDataSize;

        @Pc(315) int faceTextureFlagPtr = ptr;
        if (faceTextureFlag == 1) {
            ptr += this.faceCount * 2;
        }

        @Pc(329) int faceTextureSpacePtr = ptr;
        ptr += texSpaceSize;

        @Pc(335) int faceColourPtr = ptr;
        ptr += this.faceCount * 2;

        @Pc(344) int vertexXPtr = ptr;
        ptr += vertexLengthX;

        @Pc(350) int vertexYPtr = ptr;
        ptr += vertexLengthY;

        @Pc(356) int vertexZPtr = ptr;
        ptr += vertexLengthZ;

        @Pc(362) int planarMappingPtr = ptr;
        ptr += planarMappingCount * 6;

        @Pc(370) int complexMappingPtr = ptr;
        ptr += complexMappingCount * 6;

        @Pc(378) byte texSpaceScaleSize = 6;
        if (this.version == 14) {
            texSpaceScaleSize = 7;
        } else if (this.version >= 15) {
            texSpaceScaleSize = 9;
        }

        @Pc(395) int texSpaceScalePtr = ptr;
        ptr += complexMappingCount * texSpaceScaleSize;

        @Pc(403) int texSpaceRotationPtr = ptr;
        ptr += complexMappingCount;

        @Pc(409) int texSpaceOrientationPtr = ptr;
        ptr += complexMappingCount;

        @Pc(415) int texSpaceOffsetPtr = ptr;
        ptr += complexMappingCount + (cubeMappingCount * 2);

        this.faceColour = new short[this.faceCount];
        packet1.pos = vertexFlagsPtr;

        if (hasSmoothingTypes) {
            this.shadingTypes = new byte[this.faceCount];
        }

        if (this.texSpaceCount > 0) {
            this.texSpaceDefA = new short[this.texSpaceCount];

            if (complexMappingCount > 0) {
                this.texSpaceScaleZ = new int[complexMappingCount];
                this.aByteArray23 = new byte[complexMappingCount];
                this.texSpaceScaleX = new int[complexMappingCount];
                this.aByteArray27 = new byte[complexMappingCount];
                this.anIntArray214 = new int[complexMappingCount];
                this.texSpaceScaleY = new int[complexMappingCount];
            }

            if (cubeMappingCount > 0) {
                this.anIntArray212 = new int[cubeMappingCount];
                this.anIntArray206 = new int[cubeMappingCount];
            }

            this.texSpaceDefB = new short[this.texSpaceCount];
            this.texSpaceDefC = new short[this.texSpaceCount];
        }

        this.vertexZ = new int[this.vertexCount];
        this.faceC = new short[this.faceCount];
        this.vertexY = new int[this.vertexCount];
        this.faceA = new short[this.faceCount];

        if (faceTextureFlag == 1) {
            this.faceTexture = new short[this.faceCount];
        }

        if (priorityFlag == 255) {
            this.facePriorities = new byte[this.faceCount];
        } else {
            this.globalPriority = (byte) priorityFlag;
        }

        if (faceAlphaFlag == 1) {
            this.faceTexSpace = new byte[this.faceCount];
        }

        if (vertexGroupFlag == 1) {
            this.vertexGroup = new int[this.vertexCount];
        }

        this.vertexX = new int[this.vertexCount];

        if (faceTextureFlag == 1 && this.texSpaceCount > 0) {
            this.faceAlpha = new byte[this.faceCount];
        }

        if (faceGroupFlag == 1) {
            this.faceGroup = new int[this.faceCount];
        }

        this.faceB = new short[this.faceCount];

        packet2.pos = vertexXPtr;
        packet3.pos = vertexYPtr;
        packet4.pos = vertexZPtr;
        packet5.pos = vertexGroupPtr;

        @Pc(627) int pvx = 0;
        @Pc(629) int pvy = 0;
        @Pc(631) int pvz = 0;

        for (@Pc(633) int i = 0; i < this.vertexCount; i++) {
            @Pc(638) int vertexData = packet1.g1();

            @Pc(640) int x = 0;
            if ((vertexData & 0x1) != 0) {
                x = packet2.gsmarts();
            }

            @Pc(653) int y = 0;
            if ((vertexData & 0x2) != 0) {
                y = packet3.gsmarts();
            }

            @Pc(666) int z = 0;
            if ((vertexData & 0x4) != 0) {
                z = packet4.gsmarts();
            }

            this.vertexX[i] = x + pvx;
            this.vertexY[i] = pvy + y;
            this.vertexZ[i] = z + pvz;

            pvy = this.vertexY[i];
            pvz = this.vertexZ[i];
            pvx = this.vertexX[i];

            if (vertexGroupFlag == 1) {
                this.vertexGroup[i] = packet5.g1();
            }
        }

        packet1.pos = faceColourPtr;
        packet2.pos = smoothingPtr;
        packet3.pos = facePriPtr;
        packet4.pos = faceAlphaPtr;
        packet5.pos = faceGroupPtr;
        packet6.pos = faceTextureFlagPtr;
        packet7.pos = faceTextureSpacePtr;

        for (@Pc(638) int i = 0; i < this.faceCount; i++) {
            this.faceColour[i] = (short) packet1.g2();

            if (hasSmoothingTypes) {
                this.shadingTypes[i] = packet2.g1b();
            }

            if (priorityFlag == 255) {
                this.facePriorities[i] = packet3.g1b();
            }

            if (faceAlphaFlag == 1) {
                this.faceTexSpace[i] = packet4.g1b();
            }

            if (faceGroupFlag == 1) {
                this.faceGroup[i] = packet5.g1();
            }

            if (faceTextureFlag == 1) {
                this.faceTexture[i] = (short) (packet6.g2() - 1);
            }

            if (this.faceAlpha != null) {
                if (this.faceTexture[i] == -1) {
                    this.faceAlpha[i] = -1;
                } else {
                    this.faceAlpha[i] = (byte) (packet7.g1() - 1);
                }
            }
        }

        this.maxVertex = -1;
        packet1.pos = faceDataSizePtr;
        packet2.pos = faceTypePtr;

        @Pc(869) short faceA = 0;
        @Pc(871) short faceB = 0;
        @Pc(873) short faceC = 0;
        @Pc(875) short facePriority = 0;

        for (@Pc(877) int i = 0; i < this.faceCount; i++) {
            @Pc(882) int type = packet2.g1();

            if (type == 1) {
                faceA = (short) (packet1.gsmarts() + facePriority);
                facePriority = faceA;

                faceB = (short) (packet1.gsmarts() + facePriority);
                facePriority = faceB;

                faceC = (short) (packet1.gsmarts() + facePriority);
                facePriority = faceC;

                this.faceA[i] = faceA;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;

                if (this.maxVertex < faceA) {
                    this.maxVertex = faceA;
                }

                if (this.maxVertex < faceB) {
                    this.maxVertex = faceB;
                }

                if (this.maxVertex < faceC) {
                    this.maxVertex = faceC;
                }
            }

            if (type == 2) {
                faceB = faceC;
                faceC = (short) (packet1.gsmarts() + facePriority);

                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;

                if (this.maxVertex < faceC) {
                    this.maxVertex = faceC;
                }
            }

            if (type == 3) {
                faceA = faceC;
                faceC = (short) (packet1.gsmarts() + facePriority);

                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceB;
                this.faceC[i] = faceC;

                if (this.maxVertex < faceC) {
                    this.maxVertex = faceC;
                }
            }

            if (type == 4) {
                @Pc(1055) short faceABefore = faceA;
                faceA = faceB;
                faceC = (short) (facePriority + packet1.gsmarts());
                faceB = faceABefore;

                this.faceA[i] = faceA;
                facePriority = faceC;
                this.faceB[i] = faceABefore;
                this.faceC[i] = faceC;

                if (this.maxVertex < faceC) {
                    this.maxVertex = faceC;
                }
            }
        }

        packet1.pos = planarMappingPtr;

        this.maxVertex++;

        packet2.pos = complexMappingPtr;
        packet3.pos = texSpaceScalePtr;
        packet4.pos = texSpaceRotationPtr;
        packet5.pos = texSpaceOrientationPtr;
        packet6.pos = texSpaceOffsetPtr;

        for (@Pc(882) int i = 0; i < this.texSpaceCount; i++) {
            @Pc(1142) int type = this.texMappingType[i] & 0xFF;

            if (type == 0) {
                this.texSpaceDefA[i] = (short) packet1.g2();
                this.texSpaceDefB[i] = (short) packet1.g2();
                this.texSpaceDefC[i] = (short) packet1.g2();
            }

            if (type == 1) {
                this.texSpaceDefA[i] = (short) packet2.g2();
                this.texSpaceDefB[i] = (short) packet2.g2();
                this.texSpaceDefC[i] = (short) packet2.g2();

                if (this.version >= 15) {
                    this.texSpaceScaleX[i] = packet3.g3();
                    this.texSpaceScaleY[i] = packet3.g3();
                    this.texSpaceScaleZ[i] = packet3.g3();
                } else {
                    this.texSpaceScaleX[i] = packet3.g2();
                    if (this.version >= 14) {
                        this.texSpaceScaleY[i] = packet3.g3();
                    } else {
                        this.texSpaceScaleY[i] = packet3.g2();
                    }
                    this.texSpaceScaleZ[i] = packet3.g2();
                }

                this.aByteArray27[i] = packet4.g1b();
                this.aByteArray23[i] = packet5.g1b();
                this.anIntArray214[i] = packet6.g1b();
            }
            if (type == 2) {
                this.texSpaceDefA[i] = (short) packet2.g2();
                this.texSpaceDefB[i] = (short) packet2.g2();
                this.texSpaceDefC[i] = (short) packet2.g2();

                if (this.version >= 15) {
                    this.texSpaceScaleX[i] = packet3.g3();
                    this.texSpaceScaleY[i] = packet3.g3();
                    this.texSpaceScaleZ[i] = packet3.g3();
                } else {
                    this.texSpaceScaleX[i] = packet3.g2();
                    if (this.version >= 14) {
                        this.texSpaceScaleY[i] = packet3.g3();
                    } else {
                        this.texSpaceScaleY[i] = packet3.g2();
                    }
                    this.texSpaceScaleZ[i] = packet3.g2();
                }

                this.aByteArray27[i] = packet4.g1b();
                this.aByteArray23[i] = packet5.g1b();
                this.anIntArray214[i] = packet6.g1b();
                this.anIntArray212[i] = packet6.g1b();
                this.anIntArray206[i] = packet6.g1b();
            }

            if (type == 3) {
                this.texSpaceDefA[i] = (short) packet2.g2();
                this.texSpaceDefB[i] = (short) packet2.g2();
                this.texSpaceDefC[i] = (short) packet2.g2();

                if (this.version >= 15) {
                    this.texSpaceScaleX[i] = packet3.g3();
                    this.texSpaceScaleY[i] = packet3.g3();
                    this.texSpaceScaleZ[i] = packet3.g3();
                } else {
                    this.texSpaceScaleX[i] = packet3.g2();
                    if (this.version >= 14) {
                        this.texSpaceScaleY[i] = packet3.g3();
                    } else {
                        this.texSpaceScaleY[i] = packet3.g2();
                    }
                    this.texSpaceScaleZ[i] = packet3.g2();
                }

                this.aByteArray27[i] = packet4.g1b();
                this.aByteArray23[i] = packet5.g1b();
                this.anIntArray214[i] = packet6.g1b();
            }
        }

        packet1.pos = ptr;

        if (hasParticleEffects) {
            @Pc(1142) int emitterCount = packet1.g1();
            if (emitterCount > 0) {
                this.emitters = new MeshEmitter[emitterCount];

                for (@Pc(1556) int i = 0; i < emitterCount; i++) {
                    @Pc(1561) int type = packet1.g2();
                    @Pc(1565) int face = packet1.g2();
                    @Pc(1573) byte priority;

                    if (priorityFlag == 255) {
                        priority = this.facePriorities[face];
                    } else {
                        priority = (byte) priorityFlag;
                    }

                    this.emitters[i] = new MeshEmitter(type, this.faceA[face], this.faceB[face], this.faceC[face], priority);
                }
            }

            @Pc(1556) int magnetCount = packet1.g1();
            if (magnetCount > 0) {
                this.magnets = new MeshMagnet[magnetCount];

                for (@Pc(1561) int i = 0; i < magnetCount; i++) {
                    @Pc(1565) int type = packet1.g2();
                    @Pc(1627) int vertex = packet1.g2();
                    this.magnets[i] = new MeshMagnet(type, vertex);
                }
            }
        }

        if (hasBillboards) {
            @Pc(1142) int billboardCount = packet1.g1();
            if (billboardCount <= 0) {
                return;
            }

            this.billboards = new MeshBillboard[billboardCount];
            for (@Pc(1556) int i = 0; i < billboardCount; i++) {
                @Pc(1561) int type = packet1.g2();
                @Pc(1565) int face = packet1.g2();
                @Pc(1627) int group = packet1.g1();
                @Pc(1676) byte priority = packet1.g1b();
                this.billboards[i] = new MeshBillboard(type, face, group, priority);
            }
        }
    }

    @OriginalMember(owner = "client!dv", name = "c", descriptor = "(IIII)V")
    public void rotate(@OriginalArg(0) int z, @OriginalArg(1) int x, @OriginalArg(3) int y) {
        if (z != 0) {
            @Pc(5) int sinZ = Trig1.SIN[z];
            @Pc(9) int cosZ = Trig1.COS[z];

            for (@Pc(11) int i = 0; i < this.vertexCount; i++) {
                @Pc(28) int t = ((cosZ * this.vertexX[i]) + (sinZ * this.vertexY[i])) >> 14;
                this.vertexY[i] = ((cosZ * this.vertexY[i]) - (this.vertexX[i] * sinZ)) >> 14;
                this.vertexX[i] = t;
            }
        }

        if (x != 0) {
            @Pc(5) int sinX = Trig1.SIN[x];
            @Pc(9) int cosX = Trig1.COS[x];

            for (@Pc(11) int i = 0; i < this.vertexCount; i++) {
                @Pc(28) int t = ((cosX * this.vertexY[i]) - (sinX * this.vertexZ[i])) >> 14;
                this.vertexZ[i] = ((sinX * this.vertexY[i]) + (this.vertexZ[i] * cosX)) >> 14;
                this.vertexY[i] = t;
            }
        }

        if (y != 0) {
            @Pc(5) int sinY = Trig1.SIN[y];
            @Pc(9) int cosY = Trig1.COS[y];

            for (@Pc(11) int i = 0; i < this.vertexCount; i++) {
                @Pc(28) int t = ((sinY * this.vertexZ[i]) + (cosY * this.vertexX[i])) >> 14;
                this.vertexZ[i] = ((this.vertexZ[i] * cosY) - (sinY * this.vertexX[i])) >> 14;
                this.vertexX[i] = t;
            }
        }
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(BBBSSSSSSB)B")
    public byte addSphericalSpace() {
        if (this.texSpaceCount >= 255) {
            throw new IllegalStateException();
        }

        this.texMappingType[this.texSpaceCount] = 3;
        this.texSpaceDefA[this.texSpaceCount] = 0;
        this.texSpaceDefB[this.texSpaceCount] = 32767;
        this.texSpaceDefC[this.texSpaceCount] = 0;
        this.texSpaceScaleX[this.texSpaceCount] = 1024;
        this.texSpaceScaleY[this.texSpaceCount] = 1024;
        this.texSpaceScaleZ[this.texSpaceCount] = 1024;
        this.aByteArray27[this.texSpaceCount] = 0;
        this.aByteArray23[this.texSpaceCount] = 0;
        this.anIntArray214[this.texSpaceCount] = 0;
        return (byte) this.texSpaceCount++;
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(SSI)V")
    public void retexture(@OriginalArg(0) short arg0, @OriginalArg(1) short arg1) {
        if (this.faceTexture == null) {
            return;
        }

        for (@Pc(10) int i = 0; i < this.faceCount; i++) {
            if (this.faceTexture[i] == arg0) {
                this.faceTexture[i] = arg1;
            }
        }
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(B)[[I")
    public int[][] getBillboardGroups() {
        @Pc(8) int[] counts = new int[256];

        @Pc(10) int max = 0;
        for (@Pc(12) int i = 0; i < this.billboards.length; i++) {
            @Pc(22) int group = this.billboards[i].group;

            if (group >= 0) {
                if (group > max) {
                    max = group;
                }

                @Pc(39) int local39 = counts[group]++;
            }
        }

        @Pc(69) int[][] groups = new int[max + 1][];
        for (@Pc(71) int i = 0; i <= max; i++) {
            groups[i] = new int[counts[i]];
            counts[i] = 0;
        }

        for (@Pc(96) int i = 0; i < this.billboards.length; i++) {
            @Pc(106) int group = this.billboards[i].group;

            if (group >= 0) {
                groups[group][counts[group]++] = i;
            }
        }

        return groups;
    }

    @OriginalMember(owner = "client!dv", name = "b", descriptor = "(SSI)V")
    public void recolour(@OriginalArg(0) short src, @OriginalArg(1) short dest) {
        for (@Pc(5) int i = 0; i < this.faceCount; i++) {
            if (src == this.faceColour[i]) {
                this.faceColour[i] = dest;
            }
        }
    }

    @OriginalMember(owner = "client!dv", name = "b", descriptor = "(B)[[I")
    public int[][] getFaceGroups() {
        @Pc(16) int[] counts = new int[256];

        @Pc(18) int max = 0;
        for (@Pc(20) int i = 0; i < this.faceCount; i++) {
            @Pc(29) int group = this.faceGroup[i];

            if (group >= 0) {
                @Pc(38) int local38 = counts[group]++;

                if (group > max) {
                    max = group;
                }
            }
        }

        @Pc(62) int[][] groups = new int[max + 1][];
        for (@Pc(66) int i = 0; i <= max; i++) {
            groups[i] = new int[counts[i]];
            counts[i] = 0;
        }

        for (@Pc(87) int i = 0; i < this.faceCount; i++) {
            @Pc(96) int group = this.faceGroup[i];

            if (group >= 0) {
                groups[group][counts[group]++] = i;
            }
        }

        return groups;
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(I[B)V")
    public void decodeOld(@OriginalArg(1) byte[] data) {
        @Pc(5) boolean hasSmoothingTypes = false;
        @Pc(7) boolean hasTextures = false;
        @Pc(12) Packet packet1 = new Packet(data);
        @Pc(17) Packet packet2 = new Packet(data);
        @Pc(22) Packet packet3 = new Packet(data);
        @Pc(27) Packet packet4 = new Packet(data);
        @Pc(32) Packet packet5 = new Packet(data);

        packet1.pos = data.length - 18;

        this.vertexCount = packet1.g2();
        this.faceCount = packet1.g2();
        this.texSpaceCount = packet1.g1();

        @Pc(57) int texFlag = packet1.g1();
        @Pc(61) int priorityFlag = packet1.g1();
        @Pc(65) int alphaFlag = packet1.g1();
        @Pc(69) int faceGroupFlag = packet1.g1();
        @Pc(73) int vertexGroupFlag = packet1.g1();
        @Pc(77) int xLen = packet1.g2();
        @Pc(81) int yLen = packet1.g2();
        @Pc(85) int zLen = packet1.g2();
        @Pc(89) int faceLen = packet1.g2();
        @Pc(98) int ptr = 0;

        int vTypePtr = ptr;
        ptr += this.vertexCount;

        @Pc(100) int fTypePtr = ptr;
        ptr += this.faceCount;

        @Pc(107) int priPtr = ptr;
        if (priorityFlag == 255) {
            ptr += this.faceCount;
        }

        @Pc(117) int fGroupPtr = ptr;
        if (faceGroupFlag == 1) {
            ptr += this.faceCount;
        }

        @Pc(129) int texPtr = ptr;
        if (texFlag == 1) {
            ptr += this.faceCount;
        }

        @Pc(139) int vGroupPtr = ptr;
        if (vertexGroupFlag == 1) {
            ptr += this.vertexCount;
        }

        @Pc(151) int alphaPtr = ptr;
        if (alphaFlag == 1) {
            ptr += this.faceCount;
        }

        @Pc(163) int facePtr = ptr;
        ptr += faceLen;

        @Pc(169) int faceCountPtr = ptr;
        ptr += this.faceCount * 2;

        @Pc(178) int textFacePtr = ptr;
        ptr += this.texSpaceCount * 6;

        @Pc(187) int vxPtr = ptr;
        ptr += xLen;

        @Pc(198) int vyPtr = ptr;
        ptr += yLen;

        int vzPtr = ptr;
        ptr += zLen;

        if (priorityFlag == 255) {
            this.facePriorities = new byte[this.faceCount];
        } else {
            this.globalPriority = (byte) priorityFlag;
        }

        if (faceGroupFlag == 1) {
            this.faceGroup = new int[this.faceCount];
        }

        this.faceColour = new short[this.faceCount];
        this.vertexZ = new int[this.vertexCount];

        if (vertexGroupFlag == 1) {
            this.vertexGroup = new int[this.vertexCount];
        }

        this.faceB = new short[this.faceCount];
        this.vertexY = new int[this.vertexCount];
        this.vertexX = new int[this.vertexCount];

        packet1.pos = vTypePtr;

        if (this.texSpaceCount > 0) {
            this.texSpaceDefB = new short[this.texSpaceCount];
            this.texSpaceDefC = new short[this.texSpaceCount];
            this.texMappingType = new byte[this.texSpaceCount];
            this.texSpaceDefA = new short[this.texSpaceCount];
        }

        if (texFlag == 1) {
            this.shadingTypes = new byte[this.faceCount];
            this.faceTexture = new short[this.faceCount];
            this.faceAlpha = new byte[this.faceCount];
        }

        if (alphaFlag == 1) {
            this.faceTexSpace = new byte[this.faceCount];
        }

        this.faceA = new short[this.faceCount];
        this.faceC = new short[this.faceCount];

        packet2.pos = vxPtr;
        packet3.pos = vyPtr;
        packet4.pos = vzPtr;
        packet5.pos = vGroupPtr;

        @Pc(354) int pvx = 0;
        @Pc(356) int pvy = 0;
        @Pc(358) int pvz = 0;

        for (@Pc(360) int i = 0; i < this.vertexCount; i++) {
            @Pc(365) int vertexData = packet1.g1();

            @Pc(367) int x = 0;
            if ((vertexData & 0x1) != 0) {
                x = packet2.gsmarts();
            }

            @Pc(377) int y = 0;
            if ((vertexData & 0x2) != 0) {
                y = packet3.gsmarts();
            }

            @Pc(390) int z = 0;
            if ((vertexData & 0x4) != 0) {
                z = packet4.gsmarts();
            }

            this.vertexX[i] = pvx + x;
            this.vertexY[i] = pvy + y;
            this.vertexZ[i] = pvz + z;

            pvx = this.vertexX[i];
            pvy = this.vertexY[i];
            pvz = this.vertexZ[i];

            if (vertexGroupFlag == 1) {
                this.vertexGroup[i] = packet5.g1();
            }
        }

        packet1.pos = faceCountPtr;
        packet2.pos = texPtr;
        packet3.pos = priPtr;
        packet4.pos = alphaPtr;
        packet5.pos = fGroupPtr;

        for (@Pc(365) int i = 0; i < this.faceCount; i++) {
            this.faceColour[i] = (short) packet1.g2();

            if (texFlag == 1) {
                @Pc(367) int type = packet2.g1();

                if ((type & 0x1) == 1) {
                    this.shadingTypes[i] = 1;
                    hasSmoothingTypes = true;
                } else {
                    this.shadingTypes[i] = 0;
                }

                if ((type & 0x2) == 2) {
                    this.faceAlpha[i] = (byte) (type >> 2);
                    this.faceTexture[i] = this.faceColour[i];
                    this.faceColour[i] = 127;

                    if (this.faceTexture[i] != -1) {
                        hasTextures = true;
                    }
                } else {
                    this.faceAlpha[i] = -1;
                    this.faceTexture[i] = -1;
                }
            }

            if (priorityFlag == 255) {
                this.facePriorities[i] = packet3.g1b();
            }

            if (alphaFlag == 1) {
                this.faceTexSpace[i] = packet4.g1b();
            }

            if (faceGroupFlag == 1) {
                this.faceGroup[i] = packet5.g1();
            }
        }

        this.maxVertex = -1;
        packet1.pos = facePtr;
        packet2.pos = fTypePtr;

        @Pc(609) short fa = 0;
        @Pc(611) short fb = 0;
        @Pc(613) short fc = 0;
        @Pc(615) short pf = 0;

        for (@Pc(617) int i = 0; i < this.faceCount; i++) {
            @Pc(622) int type = packet2.g1();

            if (type == 1) {
                fa = (short) (pf + packet1.gsmarts());
                fb = (short) (packet1.gsmarts() + fa);
                fc = (short) (packet1.gsmarts() + fb);
                pf = fc;

                this.faceA[i] = fa;
                this.faceB[i] = fb;
                this.faceC[i] = fc;

                if (this.maxVertex < fa) {
                    this.maxVertex = fa;
                }

                if (this.maxVertex < fb) {
                    this.maxVertex = fb;
                }

                if (this.maxVertex < fc) {
                    this.maxVertex = fc;
                }
            }

            if (type == 2) {
                fb = fc;
                fc = (short) (packet1.gsmarts() + pf);
                pf = fc;

                this.faceA[i] = fa;
                this.faceB[i] = fb;
                this.faceC[i] = fc;

                if (this.maxVertex < fc) {
                    this.maxVertex = fc;
                }
            }

            if (type == 3) {
                fa = fc;
                fc = (short) (pf + packet1.gsmarts());
                this.faceA[i] = fa;
                pf = fc;
                this.faceB[i] = fb;
                this.faceC[i] = fc;

                if (this.maxVertex < fc) {
                    this.maxVertex = fc;
                }
            }

            if (type == 4) {
                @Pc(785) short faBefore = fa;
                fa = fb;
                fc = (short) (packet1.gsmarts() + pf);
                fb = faBefore;
                this.faceA[i] = fa;
                pf = fc;
                this.faceB[i] = faBefore;
                this.faceC[i] = fc;

                if (this.maxVertex < fc) {
                    this.maxVertex = fc;
                }
            }
        }

        packet1.pos = textFacePtr;
        this.maxVertex++;

        for (@Pc(622) int i = 0; i < this.texSpaceCount; i++) {
            this.texMappingType[i] = 0;
            this.texSpaceDefA[i] = (short) packet1.g2();
            this.texSpaceDefB[i] = (short) packet1.g2();
            this.texSpaceDefC[i] = (short) packet1.g2();
        }

        if (this.faceAlpha != null) {
            @Pc(884) boolean hasTexSpaces = false;

            for (@Pc(886) int i = 0; i < this.faceCount; i++) {
                @Pc(894) int space = this.faceAlpha[i] & 0xFF;
                if (space != 255) {
                    if ((this.faceA[i] == (this.texSpaceDefA[space] & 0xFFFF)) && (this.faceB[i] == (this.texSpaceDefB[space] & 0xFFFF)) && (this.faceC[i] == (this.texSpaceDefC[space] & 0xFFFF))) {
                        this.faceAlpha[i] = -1;
                    } else {
                        hasTexSpaces = true;
                    }
                }
            }

            if (!hasTexSpaces) {
                this.faceAlpha = null;
            }
        }

        if (!hasSmoothingTypes) {
            this.shadingTypes = null;
        }

        if (!hasTextures) {
            this.faceTexture = null;
        }
    }

    @OriginalMember(owner = "client!dv", name = "a", descriptor = "(Lclient!dv;IIS)I")
    public int addVertex(@OriginalArg(0) Mesh mesh, @OriginalArg(2) int v, @OriginalArg(3) short modelFlag) {
        @Pc(8) int x = mesh.vertexX[v];
        @Pc(13) int y = mesh.vertexY[v];
        @Pc(18) int z = mesh.vertexZ[v];

        for (@Pc(20) int i = 0; i < this.vertexCount; i++) {
            if (this.vertexX[i] == x && this.vertexY[i] == y && z == this.vertexZ[i]) {
                this.originModels[i] |= modelFlag;
                return i;
            }
        }

        this.vertexX[this.vertexCount] = x;
        this.vertexY[this.vertexCount] = y;
        this.vertexZ[this.vertexCount] = z;

        this.originModels[this.vertexCount] = modelFlag;
        this.vertexGroup[this.vertexCount] = mesh.vertexGroup == null ? -1 : mesh.vertexGroup[v];

        return this.vertexCount++;
    }
}
