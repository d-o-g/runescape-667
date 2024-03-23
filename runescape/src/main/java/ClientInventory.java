import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import com.jagex.game.Animator;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gfa")
public final class ClientInventory extends Node {

    @OriginalMember(owner = "client!gfa", name = "t", descriptor = "[I")
    public int[] anIntArray278 = new int[]{-1};

    @OriginalMember(owner = "client!gfa", name = "n", descriptor = "[I")
    public int[] anIntArray279 = new int[1];

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(ZI[I[IZ)J")
    public long method3077(@OriginalArg(0) boolean female, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int[] arg3) {
        @Pc(7) long[] local7 = Packet.crc64table;
        @Pc(9) long local9 = -1L;
        @Pc(25) long local25 = local7[(int) ((local9 ^ (long) (arg1 >> 8)) & 0xFFL)] ^ local9 >>> 8;
        local9 = local7[(int) ((local25 ^ (long) arg1) & 0xFFL)] ^ local25 >>> 8;
        for (@Pc(41) int local41 = 0; local41 < arg2.length; local41++) {
            local9 = local9 >>> 8 ^ local7[(int) ((local9 ^ (long) (arg2[local41] >> 24)) & 0xFFL)];
            local9 = local7[(int) ((local9 ^ (long) (arg2[local41] >> 16)) & 0xFFL)] ^ local9 >>> 8;
            local9 = local9 >>> 8 ^ local7[(int) (((long) (arg2[local41] >> 8) ^ local9) & 0xFFL)];
            local9 = local9 >>> 8 ^ local7[(int) (((long) arg2[local41] ^ local9) & 0xFFL)];
        }
        if (arg3 != null) {
            for (@Pc(126) int local126 = 0; local126 < 5; local126++) {
                local9 = local9 >>> 8 ^ local7[(int) ((local9 ^ (long) arg3[local126]) & 0xFFL)];
            }
        }
        return local7[(int) ((local9 ^ (long) (female ? 1 : 0)) & 0xFFL)] ^ local9 >>> 8;
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(IILclient!ha;IZLclient!gu;Lclient!ju;)Lclient!ka;")
    public Model method3078(@OriginalArg(0) int arg0, @OriginalArg(2) Toolkit arg1, @OriginalArg(4) boolean female, @OriginalArg(5) Animator arg3, @OriginalArg(6) PlayerModel arg4) {
        @Pc(7) Model local7 = null;
        @Pc(9) int local9 = 2048;
        @Pc(11) BASType local11 = null;
        if (arg0 != -1) {
            local11 = BASTypeList.instance.list(arg0);
        }
        @Pc(23) int[] local23 = this.anIntArray278;
        if (local11 != null && local11.invObjSlots != null) {
            local23 = new int[local11.invObjSlots.length];
            for (@Pc(45) int local45 = 0; local45 < local11.invObjSlots.length; local45++) {
                @Pc(52) int local52 = local11.invObjSlots[local45];
                if (local52 >= 0 && this.anIntArray278.length > local52) {
                    local23[local45] = this.anIntArray278[local52];
                } else {
                    local23[local45] = -1;
                }
            }
        }
        if (arg3 != null) {
            local9 = arg3.functionMask() | 0x800;
        }
        @Pc(116) long local116 = this.method3077(female, arg0, local23, arg4 == null ? null : arg4.clientpalette);
        if (Static166.A_WEIGHTED_CACHE___59 != null) {
            local7 = (Model) Static166.A_WEIGHTED_CACHE___59.get(local116);
        }
        if (local7 == null || arg1.compareFunctionMasks(local7.ua(), local9) != 0) {
            if (local7 != null) {
                local9 = arg1.combineFunctionMasks(local9, local7.ua());
            }
            @Pc(151) int local151 = local9;
            @Pc(153) boolean local153 = false;
            for (@Pc(155) int local155 = 0; local155 < local23.length; local155++) {
                if (local23[local155] != -1 && !ObjTypeList.instance.list(local23[local155]).loadedModels(female, null)) {
                    local153 = true;
                }
            }
            if (local153) {
                return null;
            }
            @Pc(203) Mesh[] meshes = new Mesh[local23.length];
            for (@Pc(205) int local205 = 0; local205 < local23.length; local205++) {
                if (local23[local205] != -1) {
                    meshes[local205] = ObjTypeList.instance.list(local23[local205]).playerModel(null, female);
                }
            }
            @Pc(278) int tx;
            @Pc(285) int ty;
            if (local11 != null && local11.wornTransformations != null) {
                for (@Pc(252) int local252 = 0; local252 < local11.wornTransformations.length; local252++) {
                    if (local11.wornTransformations[local252] != null && meshes[local252] != null) {
                        tx = local11.wornTransformations[local252][0];
                        ty = local11.wornTransformations[local252][1];
                        @Pc(292) int tz = local11.wornTransformations[local252][2];
                        @Pc(299) int rx = local11.wornTransformations[local252][3];
                        @Pc(306) int ry = local11.wornTransformations[local252][4];
                        @Pc(313) int rz = local11.wornTransformations[local252][5];
                        if (rx != 0 || ry != 0 || rz != 0) {
                            meshes[local252].rotate(rz, rx, ry);
                        }
                        if (tx != 0 || ty != 0 || tz != 0) {
                            meshes[local252].translate(tx, ty, tz);
                        }
                    }
                }
            }
            @Pc(382) Mesh local382 = new Mesh(meshes, meshes.length);
            if (arg4 != null) {
                local151 = local9 | 0x4000;
            }
            local7 = arg1.createModel(local382, local151, Static584.anInt8635, 64, 850);
            if (arg4 != null) {
                for (tx = 0; tx < 10; tx++) {
                    for (ty = 0; ty < PlayerModel.recol_s[tx].length; ty++) {
                        if (PlayerModel.recol_d[tx][ty].length > arg4.clientpalette[tx]) {
                            local7.ia(PlayerModel.recol_s[tx][ty], PlayerModel.recol_d[tx][ty][arg4.clientpalette[tx]]);
                        }
                    }
                }
            }
            if (Static166.A_WEIGHTED_CACHE___59 != null) {
                local7.s(local9);
                Static166.A_WEIGHTED_CACHE___59.put(local7, local116);
            }
        }
        if (arg3 == null) {
            return local7;
        } else {
            @Pc(478) Model local478 = local7.copy((byte) 1, local9, true);
            arg3.animate(local478, 0);
            return local478;
        }
    }
}
