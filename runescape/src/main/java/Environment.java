import com.jagex.Class67;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import com.jagex.game.runetek6.config.skyboxtype.SkyBoxTypeList;
import com.jagex.graphics.skybox.SkyBox;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!uc")
public final class Environment {

    @OriginalMember(owner = "client!dr", name = "c", descriptor = "Lclient!dla;")
    public static final ReferenceCache skyBoxCache = new ReferenceCache(8);

    @OriginalMember(owner = "client!ie", name = "j", descriptor = "Lclient!dla;")
    public static final ReferenceCache A_WEIGHTED_CACHE___235 = new ReferenceCache(8);

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(ZIIII)Lclient!gm;")
    public static SkyBox method5047(@OriginalArg(1) int sphereOffsetY, @OriginalArg(2) int id, @OriginalArg(3) int sphereOffsetX, @OriginalArg(4) int sphereOffsetZ) {
        @Pc(31) long key = ((long) id & 0xFFFFL) | (((long) sphereOffsetZ & 0xFFFFL) << 16) | (((long) sphereOffsetX << 48) & (0xFFFFL << 48)) | (((long) sphereOffsetY & 0xFFFFL) << 32);
        @Pc(43) SkyBox skyBox = (SkyBox) skyBoxCache.get(key);
        if (skyBox == null) {
            skyBox = SkyBoxTypeList.instance.skyBox(SkyBoxSphereTypeList.instance, sphereOffsetZ, id, sphereOffsetY, sphereOffsetX);
            skyBoxCache.put(skyBox, key);
        }
        return skyBox;
    }

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(IIIIIII)Lclient!pu;")
    public static Class67 method5301(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        @Pc(33) long key = (long) arg5 * 67481L ^ (long) arg1 * 97549L ^ (long) arg2 * 475427L ^ (long) arg3 * 986053L ^ (long) arg0 * 32147369L ^ (long) arg4 * 76724863L;
        @Pc(39) Class67 local39 = (Class67) A_WEIGHTED_CACHE___235.get(key);
        if (local39 == null) {
            local39 = Static425.toolkit.method8008(arg5, arg1, arg2, arg3, arg0, arg4);
            A_WEIGHTED_CACHE___235.put(local39, key);
            return local39;
        } else {
            return local39;
        }
    }

    @OriginalMember(owner = "client!eu", name = "f", descriptor = "(I)V")
    public static void cacheReset() {
        A_WEIGHTED_CACHE___235.reset();
        skyBoxCache.reset();
    }

    @OriginalMember(owner = "client!uc", name = "k", descriptor = "F")
    public float aFloat201 = 1.0F;

    @OriginalMember(owner = "client!uc", name = "m", descriptor = "F")
    public float aFloat203 = 1.0F;

    @OriginalMember(owner = "client!uc", name = "o", descriptor = "F")
    public float aFloat200 = 0.25F;

    @OriginalMember(owner = "client!uc", name = "e", descriptor = "I")
    public int anInt9533;

    @OriginalMember(owner = "client!uc", name = "t", descriptor = "Lclient!pu;")
    public Class67 aClass67_10;

    @OriginalMember(owner = "client!uc", name = "i", descriptor = "I")
    public int anInt9535;

    @OriginalMember(owner = "client!uc", name = "d", descriptor = "F")
    public float aFloat202;

    @OriginalMember(owner = "client!uc", name = "s", descriptor = "Lclient!gm;")
    public SkyBox aSkyBox_5;

    @OriginalMember(owner = "client!uc", name = "p", descriptor = "I")
    public int anInt9537;

    @OriginalMember(owner = "client!uc", name = "g", descriptor = "F")
    public float aFloat205;

    @OriginalMember(owner = "client!uc", name = "v", descriptor = "F")
    public float aFloat204;

    @OriginalMember(owner = "client!uc", name = "a", descriptor = "I")
    public int anInt9534;

    @OriginalMember(owner = "client!uc", name = "f", descriptor = "I")
    public int anInt9538;

    @OriginalMember(owner = "client!uc", name = "c", descriptor = "I")
    public int anInt9539;

    @OriginalMember(owner = "client!uc", name = "<init>", descriptor = "()V")
    public Environment() {
        this.anInt9533 = -60;
        this.aClass67_10 = Static226.aClass67_9;
        this.anInt9535 = -50;
        this.aFloat202 = 1.2F;
        this.aSkyBox_5 = Static495.aSkyBox_4;
        this.anInt9537 = Static68.anInt4096;
        this.aFloat205 = 0.69921875F;
        this.aFloat204 = 1.1523438F;
        this.anInt9534 = -50;
        this.anInt9538 = Static563.anInt8460;
        this.anInt9539 = 0;
    }

    @OriginalMember(owner = "client!uc", name = "<init>", descriptor = "(Lclient!ge;)V")
    public Environment(@OriginalArg(0) Packet arg0) {
        this.method8386(arg0);
    }

    @OriginalMember(owner = "client!uc", name = "a", descriptor = "(Lclient!ge;I)V")
    public void method8384(@OriginalArg(0) Packet arg0) {
        @Pc(17) int local17 = arg0.g2();
        @Pc(21) int local21 = arg0.g2s();
        @Pc(25) int local25 = arg0.g2s();
        @Pc(29) int local29 = arg0.g2s();
        @Pc(33) int local33 = arg0.g2();
        Static436.anInt3852 = local33;
        this.aSkyBox_5 = method5047(local25, local17, local21, local29);
    }

    @OriginalMember(owner = "client!uc", name = "a", descriptor = "(Lclient!ge;Z)V")
    public void decodeBloomParams(@OriginalArg(0) Packet arg0) {
        this.aFloat201 = (float) (arg0.g1() * 8) / 255.0F;
        this.aFloat200 = (float) (arg0.g1() * 8) / 255.0F;
        this.aFloat203 = (float) (arg0.g1() * 8) / 255.0F;
    }

    @OriginalMember(owner = "client!uc", name = "b", descriptor = "(Lclient!ge;I)V")
    public void method8386(@OriginalArg(0) Packet arg0) {
        @Pc(7) int local7 = arg0.g1();
        if (ClientOptions.instance.lightDetail.getValue() == 1 && Static425.toolkit.getMaxLights() > 0) {
            if ((local7 & 0x1) == 0) {
                this.anInt9537 = Static68.anInt4096;
            } else {
                this.anInt9537 = arg0.g4();
            }
            if ((local7 & 0x2) == 0) {
                this.aFloat204 = 1.1523438F;
            } else {
                this.aFloat204 = (float) arg0.g2() / 256.0F;
            }
            if ((local7 & 0x4) == 0) {
                this.aFloat205 = 0.69921875F;
            } else {
                this.aFloat205 = (float) arg0.g2() / 256.0F;
            }
            if ((local7 & 0x8) == 0) {
                this.aFloat202 = 1.2F;
            } else {
                this.aFloat202 = (float) arg0.g2() / 256.0F;
            }
        } else {
            if ((local7 & 0x1) != 0) {
                arg0.g4();
            }
            if ((local7 & 0x2) != 0) {
                arg0.g2();
            }
            if ((local7 & 0x4) != 0) {
                arg0.g2();
            }
            if ((local7 & 0x8) != 0) {
                arg0.g2();
            }
            this.aFloat202 = 1.2F;
            this.aFloat204 = 1.1523438F;
            this.aFloat205 = 0.69921875F;
            this.anInt9537 = Static68.anInt4096;
        }
        if ((local7 & 0x10) == 0) {
            this.anInt9535 = -50;
            this.anInt9534 = -50;
            this.anInt9533 = -60;
        } else {
            this.anInt9535 = arg0.g2s();
            this.anInt9533 = arg0.g2s();
            this.anInt9534 = arg0.g2s();
        }
        if ((local7 & 0x20) == 0) {
            this.anInt9538 = Static563.anInt8460;
        } else {
            this.anInt9538 = arg0.g4();
        }
        if ((local7 & 0x40) == 0) {
            this.anInt9539 = 0;
        } else {
            this.anInt9539 = arg0.g2();
        }
        if ((local7 & 0x80) == 0) {
            this.aClass67_10 = Static226.aClass67_9;
            return;
        }
        @Pc(251) int local251 = arg0.g2();
        @Pc(255) int local255 = arg0.g2();
        @Pc(261) int local261 = arg0.g2();
        @Pc(265) int local265 = arg0.g2();
        @Pc(271) int local271 = arg0.g2();
        @Pc(275) int local275 = arg0.g2();
        this.aClass67_10 = method5301(local271, local255, local261, local265, local275, local251);
    }

    @OriginalMember(owner = "client!uc", name = "a", descriptor = "(BLclient!uc;)Z")
    public boolean method8388(@OriginalArg(1) Environment arg0) {
        return this.anInt9537 == arg0.anInt9537 && arg0.aFloat204 == this.aFloat204 && this.aFloat205 == arg0.aFloat205 && this.aFloat202 == arg0.aFloat202 && arg0.aFloat200 == this.aFloat200 && this.aFloat201 == arg0.aFloat201 && this.aFloat203 == arg0.aFloat203 && this.anInt9538 == arg0.anInt9538 && arg0.anInt9539 == this.anInt9539 && arg0.aClass67_10 == this.aClass67_10 && arg0.aSkyBox_5 == this.aSkyBox_5;
    }
}
