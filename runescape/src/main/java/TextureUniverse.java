import com.jagex.graphics.Mesh;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!uea")
public final class TextureUniverse {

    @OriginalMember(owner = "client!uea", name = "f", descriptor = "[I")
    public final int[] originX;

    @OriginalMember(owner = "client!uea", name = "a", descriptor = "[[F")
    public final float[][] matrices;

    @OriginalMember(owner = "client!uea", name = "d", descriptor = "[I")
    public final int[] originY;

    @OriginalMember(owner = "client!uea", name = "g", descriptor = "[I")
    public final int[] originZ;

    @OriginalMember(owner = "client!uea", name = "<init>", descriptor = "([I[I[I[[F)V")
    public TextureUniverse(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) float[][] arg3) {
        this.originX = arg0;
        this.matrices = arg3;
        this.originY = arg1;
        this.originZ = arg2;
    }

    @OriginalMember(owner = "client!bm", name = "a", descriptor = "(ILclient!dv;I[I)Lclient!uea;")
    public static TextureUniverse fromMesh(@OriginalArg(1) Mesh mesh, @OriginalArg(2) int arg1, @OriginalArg(3) int[] arg2) {
        @Pc(7) int[] local7 = null;
        @Pc(9) int[] local9 = null;
        @Pc(11) int[] local11 = null;
        @Pc(13) float[][] local13 = null;
        if (mesh.faceTexSpace != null) {
            @Pc(25) int local25 = mesh.texSpaceCount;
            @Pc(28) int[] local28 = new int[local25];
            @Pc(31) int[] local31 = new int[local25];
            @Pc(34) int[] local34 = new int[local25];
            @Pc(37) int[] local37 = new int[local25];
            @Pc(40) int[] local40 = new int[local25];
            @Pc(43) int[] local43 = new int[local25];
            for (@Pc(45) int local45 = 0; local45 < local25; local45++) {
                local28[local45] = Integer.MAX_VALUE;
                local31[local45] = -2147483647;
                local34[local45] = Integer.MAX_VALUE;
                local37[local45] = -2147483647;
                local40[local45] = Integer.MAX_VALUE;
                local43[local45] = -2147483647;
            }
            local11 = new int[local25];
            local13 = new float[local25][];
            @Pc(97) int local97;
            @Pc(158) int local158;
            for (@Pc(89) int local89 = 0; local89 < arg1; local89++) {
                local97 = arg2[local89];
                if (mesh.faceTexSpace[local97] != -1) {
                    @Pc(111) int local111 = mesh.faceTexSpace[local97] & 0xFF;
                    for (@Pc(113) int local113 = 0; local113 < 3; local113++) {
                        @Pc(134) short local134;
                        if (local113 == 0) {
                            local134 = mesh.faceA[local97];
                        } else if (local113 == 1) {
                            local134 = mesh.faceB[local97];
                        } else {
                            local134 = mesh.faceC[local97];
                        }
                        @Pc(153) int local153 = mesh.vertexX[local134];
                        local158 = mesh.vertexY[local134];
                        @Pc(163) int local163 = mesh.vertexZ[local134];
                        if (local153 < local28[local111]) {
                            local28[local111] = local153;
                        }
                        if (local153 > local31[local111]) {
                            local31[local111] = local153;
                        }
                        if (local34[local111] > local158) {
                            local34[local111] = local158;
                        }
                        if (local158 > local37[local111]) {
                            local37[local111] = local158;
                        }
                        if (local40[local111] > local163) {
                            local40[local111] = local163;
                        }
                        if (local163 > local43[local111]) {
                            local43[local111] = local163;
                        }
                    }
                }
            }
            local7 = new int[local25];
            local9 = new int[local25];
            for (local97 = 0; local97 < local25; local97++) {
                @Pc(268) byte local268 = mesh.texMappingType[local97];
                if (local268 > 0) {
                    local7[local97] = (local28[local97] + local31[local97]) / 2;
                    local9[local97] = (local34[local97] + local37[local97]) / 2;
                    local11[local97] = (local43[local97] + local40[local97]) / 2;
                    @Pc(340) float local340;
                    @Pc(326) float local326;
                    @Pc(334) float local334;
                    if (local268 == 1) {
                        local158 = mesh.texSpaceScaleX[local97];
                        local326 = 64.0F / (float) mesh.texSpaceScaleY[local97];
                        if (local158 == 0) {
                            local340 = 1.0F;
                            local334 = 1.0F;
                        } else if (local158 <= 0) {
                            local334 = 1.0F;
                            local340 = (float) -local158 / 1024.0F;
                        } else {
                            local340 = 1.0F;
                            local334 = (float) local158 / 1024.0F;
                        }
                    } else if (local268 == 2) {
                        local326 = 64.0F / (float) mesh.texSpaceScaleY[local97];
                        local334 = 64.0F / (float) mesh.texSpaceScaleZ[local97];
                        local340 = 64.0F / (float) mesh.texSpaceScaleX[local97];
                    } else {
                        local340 = (float) mesh.texSpaceScaleX[local97] / 1024.0F;
                        local326 = (float) mesh.texSpaceScaleY[local97] / 1024.0F;
                        local334 = (float) mesh.texSpaceScaleZ[local97] / 1024.0F;
                    }
                    local13[local97] = Static395.method9163(local340, local326, local334, mesh.texSpaceDefA[local97], mesh.texSpaceDefC[local97], mesh.texRotation[local97] & 0xFF, mesh.texSpaceDefB[local97]);
                }
            }
        }
        return new TextureUniverse(local7, local9, local11, local13);
    }
}
