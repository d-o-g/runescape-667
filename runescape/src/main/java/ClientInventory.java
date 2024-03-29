import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.Animator;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.invtype.InvTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gfa")
public final class ClientInventory extends Node {

    @OriginalMember(owner = "client!fca", name = "g", descriptor = "Lclient!dla;")
    public static final ReferenceCache modelCache = new ReferenceCache(10);

    @OriginalMember(owner = "client!iw", name = "c", descriptor = "Lclient!av;")
    public static final IterableHashTable recentUse = new IterableHashTable(32);

    @OriginalMember(owner = "client!kd", name = "c", descriptor = "[I")
    public static final int[] updates = new int[32];

    @OriginalMember(owner = "client!sga", name = "k", descriptor = "I")
    public static int featureMask;

    @OriginalMember(owner = "client!oe", name = "N", descriptor = "I")
    public static int updateCount = 0;

    @OriginalMember(owner = "client!sba", name = "b", descriptor = "(B)V")
    public static void cacheClear() {
        recentUse.clear();
    }

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "(IIIZ)I")
    public static int get(@OriginalArg(0) int id, @OriginalArg(2) int slot, @OriginalArg(3) boolean otherPlayer) {
        @Pc(18) ClientInventory inventory = get(id, otherPlayer);

        if (inventory == null) {
            return -1;
        } else if (slot >= 0 && slot < inventory.objs.length) {
            return inventory.objs[slot];
        } else {
            return -1;
        }
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(IBZ)Lclient!gfa;")
    public static ClientInventory get(@OriginalArg(0) int id, @OriginalArg(2) boolean otherPlayer) {
        @Pc(19) long key = id | (otherPlayer ? Integer.MIN_VALUE : 0);
        return (ClientInventory) recentUse.get(key);
    }

    @OriginalMember(owner = "client!qt", name = "a", descriptor = "(IZBI)I")
    public static int count(@OriginalArg(3) int id, @OriginalArg(0) int slot, @OriginalArg(1) boolean otherPlayer) {
        @Pc(8) ClientInventory inventory = get(id, otherPlayer);

        if (inventory == null) {
            return 0;
        } else if (slot >= 0 && inventory.counts.length > slot) {
            return inventory.counts[slot];
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!cca", name = "a", descriptor = "(IIZB)I")
    public static int total(@OriginalArg(1) int id, @OriginalArg(0) int slot, @OriginalArg(2) boolean otherPlayer) {
        @Pc(8) ClientInventory inventory = get(id, otherPlayer);

        if (inventory == null) {
            return 0;
        } else if (slot == -1) {
            return 0;
        } else {
            @Pc(21) int total = 0;
            for (@Pc(29) int i = 0; i < inventory.counts.length; i++) {
                if (slot == inventory.objs[i]) {
                    total += inventory.counts[i];
                }
            }
            return total;
        }
    }

    @OriginalMember(owner = "client!gg", name = "a", descriptor = "(IZB)V")
    public static void empty(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
        @Pc(10) ClientInventory local10 = get(arg0, arg1);
        if (local10 != null) {
            for (@Pc(16) int local16 = 0; local16 < local10.objs.length; local16++) {
                local10.objs[local16] = -1;
                local10.counts[local16] = 0;
            }
        }
    }

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(ZII)V")
    public static void delete(@OriginalArg(1) int id, @OriginalArg(0) boolean otherPlayer) {
        @Pc(12) ClientInventory inventory = get(id, otherPlayer);

        if (inventory != null) {
            inventory.unlink();
        }
    }

    @OriginalMember(owner = "client!ko", name = "a", descriptor = "(ZIIIII)V")
    public static void setSlot(@OriginalArg(0) boolean arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        @Pc(20) long local20 = (arg0 ? Integer.MIN_VALUE : 0) | arg4;
        @Pc(26) ClientInventory local26 = (ClientInventory) recentUse.get(local20);
        if (local26 == null) {
            local26 = new ClientInventory();
            recentUse.put(local20, local26);
        }
        if (arg2 >= local26.objs.length) {
            @Pc(47) int[] local47 = new int[arg2 + 1];
            @Pc(52) int[] local52 = new int[arg2 + 1];
            for (@Pc(54) int local54 = 0; local54 < local26.objs.length; local54++) {
                local47[local54] = local26.objs[local54];
                local52[local54] = local26.counts[local54];
            }
            for (@Pc(86) int local86 = local26.objs.length; local86 < arg2; local86++) {
                local47[local86] = -1;
                local52[local86] = 0;
            }
            local26.counts = local52;
            local26.objs = local47;
        }
        local26.objs[arg2] = arg3;
        local26.counts[arg2] = arg1;
    }

    @OriginalMember(owner = "client!bja", name = "a", descriptor = "(BZI)I")
    public static int freeSpace(@OriginalArg(2) int id) {
        @Pc(13) ClientInventory inventory = get(id, false);
        if (inventory == null) {
            return InvTypeList.instance.list(id).size;
        }

        @Pc(24) int free = 0;
        for (@Pc(33) int i = 0; i < inventory.objs.length; i++) {
            if (inventory.objs[i] == -1) {
                free++;
            }
        }
        return free + InvTypeList.instance.list(id).size - inventory.objs.length;
    }

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(IZIZI)I")
    public static int totalParam(@OriginalArg(4) int id, @OriginalArg(2) int param, @OriginalArg(1) boolean stack) {
        @Pc(18) ClientInventory inventory = get(id, false);
        if (inventory == null) {
            return 0;
        }

        @Pc(25) int count = 0;
        for (@Pc(27) int i = 0; i < inventory.objs.length; i++) {
            if (inventory.objs[i] >= 0 && inventory.objs[i] < ObjTypeList.instance.num) {
                @Pc(54) ObjType objType = ObjTypeList.instance.list(inventory.objs[i]);
                @Pc(64) int local64 = objType.param(param, ParamTypeList.instance.list(param).defaultint);
                if (stack) {
                    count += local64 * inventory.counts[i];
                } else {
                    count += local64;
                }
            }
        }
        return count;
    }

    @OriginalMember(owner = "client!fea", name = "a", descriptor = "(IB)V")
    public static void setFeatureMask(@OriginalArg(0) int featureMask) {
        ClientInventory.featureMask = featureMask;
        modelCache.reset();
    }

    @OriginalMember(owner = "client!kg", name = "c", descriptor = "(B)V")
    public static void cacheReset() {
        modelCache.reset();
    }

    @OriginalMember(owner = "client!gfa", name = "t", descriptor = "[I")
    public int[] objs = {-1};

    @OriginalMember(owner = "client!gfa", name = "n", descriptor = "[I")
    public int[] counts = new int[1];

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
        @Pc(23) int[] local23 = this.objs;
        if (local11 != null && local11.invObjSlots != null) {
            local23 = new int[local11.invObjSlots.length];
            for (@Pc(45) int local45 = 0; local45 < local11.invObjSlots.length; local45++) {
                @Pc(52) int local52 = local11.invObjSlots[local45];
                if (local52 >= 0 && this.objs.length > local52) {
                    local23[local45] = this.objs[local52];
                } else {
                    local23[local45] = -1;
                }
            }
        }
        if (arg3 != null) {
            local9 = arg3.functionMask() | 0x800;
        }
        @Pc(116) long local116 = this.method3077(female, arg0, local23, arg4 == null ? null : arg4.clientpalette);
        if (modelCache != null) {
            local7 = (Model) modelCache.get(local116);
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
            local7 = arg1.createModel(local382, local151, featureMask, 64, 850);
            if (arg4 != null) {
                for (tx = 0; tx < 10; tx++) {
                    for (ty = 0; ty < PlayerModel.recol_s[tx].length; ty++) {
                        if (PlayerModel.recol_d[tx][ty].length > arg4.clientpalette[tx]) {
                            local7.ia(PlayerModel.recol_s[tx][ty], PlayerModel.recol_d[tx][ty][arg4.clientpalette[tx]]);
                        }
                    }
                }
            }
            if (modelCache != null) {
                local7.s(local9);
                modelCache.put(local7, local116);
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
