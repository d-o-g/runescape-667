import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vca")
public final class CutsceneAction_Sub23 extends CutsceneAction {

    @OriginalMember(owner = "client!vca", name = "j", descriptor = "I")
    public final int z1;

    @OriginalMember(owner = "client!vca", name = "s", descriptor = "I")
    public final int origin;

    @OriginalMember(owner = "client!vca", name = "w", descriptor = "I")
    public final int x1;

    @OriginalMember(owner = "client!vca", name = "u", descriptor = "I")
    public final int x2;

    @OriginalMember(owner = "client!vca", name = "A", descriptor = "I")
    public final int z2;

    @OriginalMember(owner = "client!vca", name = "v", descriptor = "I")
    public final int target;

    @OriginalMember(owner = "client!vca", name = "q", descriptor = "I")
    public final int level;

    @OriginalMember(owner = "client!vca", name = "l", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!vca", name = "h", descriptor = "I")
    public final int y1;

    @OriginalMember(owner = "client!vca", name = "n", descriptor = "I")
    public final int y2;

    @OriginalMember(owner = "client!vca", name = "t", descriptor = "I")
    public final int duration;

    @OriginalMember(owner = "client!vca", name = "p", descriptor = "I")
    public final int verticalAngle;

    @OriginalMember(owner = "client!vca", name = "y", descriptor = "I")
    public final int displacement;

    @OriginalMember(owner = "client!vca", name = "<init>", descriptor = "(Lclient!ge;II)V")
    public CutsceneAction_Sub23(@OriginalArg(0) Packet packet, @OriginalArg(1) int from, @OriginalArg(2) int to) {
        super(packet);

        if (from == 0) {
            @Pc(10) int coord = packet.g4();
            this.z1 = coord & 0xFFFF;
            this.origin = -1;
            this.x1 = coord >>> 16;
        } else {
            this.x1 = -1;
            this.z1 = -1;
            this.origin = packet.g2();
        }

        if (to == 0) {
            @Pc(10) int coord = packet.g4();
            this.z2 = coord >>> 16;
            this.target = -1;
            this.x2 = coord & 0xFFFF;
        } else {
            this.x2 = -1;
            this.z2 = -1;
            this.target = packet.g2();
        }

        if (from == 0 && to == 0) {
            this.level = packet.g1();
        } else {
            this.level = -1;
        }

        this.id = packet.g2();
        this.y1 = packet.g1();
        this.y2 = packet.g1();
        this.duration = packet.g3();
        this.verticalAngle = packet.g2();
        this.displacement = packet.g1();
    }

    @OriginalMember(owner = "client!vca", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        @Pc(18) int level;

        @Pc(21) int z1;
        @Pc(24) int x1;
        if (this.x1 >= 0) {
            z1 = (this.z1 * 512) + 256;
            x1 = (this.x1 * 512) + 256;
            level = this.level;
        } else {
            @Pc(15) PathingEntity entity = CutsceneManager.actors[this.origin].entity();
            level = entity.level;
            z1 = entity.z;
            x1 = entity.x;
        }

        @Pc(63) int x2;
        @Pc(56) int z2;
        if (this.z1 >= 0) {
            z2 = (this.x2 * 512) + 256;
            x2 = (this.z2 * 512) + 256;
        } else {
            @Pc(15) PathingEntity entity = CutsceneManager.actors[this.target].entity();
            x2 = entity.x;
            z2 = entity.z;

            if (level < 0) {
                level = entity.level;
            }
        }

        @Pc(91) int local91 = this.displacement << 2;
        @Pc(128) ProjectileAnimation projectile = new ProjectileAnimation(this.id, level, level, x1, z1, this.y1 << 2, TimeUtils.clock, TimeUtils.clock + this.duration, this.verticalAngle, local91, this.origin + 1, this.target + 1, this.y2 << 2, false, 0);
        projectile.target(this.y2 << 2, this.duration + TimeUtils.clock, z2, x2);
        Static505.projectiles.addLast(new ProjectileAnimationNode(projectile));
    }
}
