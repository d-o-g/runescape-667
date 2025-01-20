import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lw")
public final class Actor {

    @OriginalMember(owner = "client!lw", name = "f", descriptor = "Z")
    public boolean initialised = false;

    @OriginalMember(owner = "client!lw", name = "c", descriptor = "Lclient!wj;")
    public NPCEntity npc = null;

    @OriginalMember(owner = "client!lw", name = "e", descriptor = "Lclient!ca;")
    public PlayerEntity player = null;

    @OriginalMember(owner = "client!lw", name = "b", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!lw", name = "d", descriptor = "I")
    public final int npcId;

    @OriginalMember(owner = "client!lw", name = "<init>", descriptor = "(Lclient!ge;I)V")
    public Actor(@OriginalArg(0) Packet packet, @OriginalArg(1) int id) {
        this.id = id;

        @Pc(19) int type = packet.g1();
        if (type == 0) {
            this.npcId = packet.gSmart2or4null();
        } else if (type == 1) {
            this.npcId = -1;
        } else {
            this.npcId = -1;
        }

        packet.gjstr();
    }

    @OriginalMember(owner = "client!lw", name = "a", descriptor = "(IBII)V")
    public void teleport(@OriginalArg(0) int x, @OriginalArg(2) int level, @OriginalArg(3) int z) {
        if (this.npc == null) {
            this.player.level = this.player.virtualLevel = (byte) level;
            this.player.teleport(x, z);
        } else {
            this.npc.clearPath(true, z, x, level, this.npc.getSize());
        }
    }

    @OriginalMember(owner = "client!lw", name = "a", descriptor = "(B)V")
    public void reset() {
        this.npc = null;
        this.initialised = false;
        this.player = null;
    }

    @OriginalMember(owner = "client!lw", name = "a", descriptor = "(I)Lclient!cg;")
    public PathingEntity entity() {
        return this.npc == null ? this.player : this.npc;
    }

    @OriginalMember(owner = "client!lw", name = "a", descriptor = "(BIIII)V")
    public void init(@OriginalArg(1) int angle, @OriginalArg(2) int level, @OriginalArg(3) int x, @OriginalArg(4) int z) {
        if (!this.initialised) {
            this.initialised = true;

            if (this.npcId >= 0) {
                this.npc = new NPCEntity(25);
                this.npc.cutsceneClock = TimeUtils.clock;
                this.npc.slot = this.id;
                this.npc.setupNewNPCType(NPCTypeList.instance.list(this.npcId));
                this.npc.setSize(this.npc.type.size);
                this.npc.yawSpeed = this.npc.type.yawSpeed << 3;
                this.npc.drawPriority = Static457.anInt6933++;
            } else {
                this.player = new PlayerEntity(25);
                this.player.decodeAppearance(CutsceneManager.packet);
                this.player.cutsceneClock = TimeUtils.clock;
                this.player.drawPriority = Static457.anInt6933++;
                this.player.slot = this.id;
            }
        }

        if (this.npcId < 0) {
            this.player.level = this.player.virtualLevel = (byte) level;
            this.player.teleport(x, z);
            this.player.turn(angle, true);
        } else {
            this.npc.clearPath(true, z, x, level, this.npc.getSize());
            this.npc.turn(angle, true);
        }
    }
}
