import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static702 {

    @OriginalMember(owner = "client!wda", name = "n", descriptor = "I")
    public static int anInt10569;

    @OriginalMember(owner = "client!wda", name = "a", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_20 = new Class397(4);

    @OriginalMember(owner = "client!wda", name = "l", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_16 = new Class397(1);

    @OriginalMember(owner = "client!wda", name = "d", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_13 = new Class397(1);

    @OriginalMember(owner = "client!wda", name = "b", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_14 = new Class397(2);

    @OriginalMember(owner = "client!wda", name = "f", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_15 = new Class397(4);

    @OriginalMember(owner = "client!wda", name = "c", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_17 = new Class397(2);

    @OriginalMember(owner = "client!wda", name = "i", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_18 = new Class397(4);

    @OriginalMember(owner = "client!wda", name = "e", descriptor = "Lclient!wda;")
    public static final Class397 aClass397_19 = new Class397(2);

    @OriginalMember(owner = "client!wda", name = "h", descriptor = "Z")
    public static boolean aBoolean797 = false;

    @OriginalMember(owner = "client!wda", name = "a", descriptor = "(ILclient!cg;I)V")
    public static void updateActionAnimator(@OriginalArg(1) PathingEntity entity, @OriginalArg(2) int speed) {
        if (entity.actionAnimations == null) {
            return;
        }

        @Pc(13) int animation = entity.actionAnimations[speed + 1];
        if (entity.actionAnimator.getAnimationId() != animation) {
            entity.actionAnimator.update(entity.actionAnimator.getDelay(), animation);
            entity.animationPathPointer = entity.pathPointer;
        }
    }
}
