import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.datastruct.Node;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterType;
import com.jagex.graphics.particles.ModelParticleEmitter;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterTypeList;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.particles.ParticleLimits;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rf")
public final class ParticleEmitter extends Node {

    @OriginalMember(owner = "client!rf", name = "u", descriptor = "I")
    public int anInt8268;

    @OriginalMember(owner = "client!rf", name = "x", descriptor = "I")
    public int anInt8272;

    @OriginalMember(owner = "client!rf", name = "i", descriptor = "I")
    public int anInt8273;

    @OriginalMember(owner = "client!rf", name = "m", descriptor = "I")
    public int anInt8274;

    @OriginalMember(owner = "client!rf", name = "y", descriptor = "I")
    public int anInt8275;

    @OriginalMember(owner = "client!rf", name = "l", descriptor = "I")
    public int anInt8276;

    @OriginalMember(owner = "client!rf", name = "A", descriptor = "I")
    public int anInt8277;

    @OriginalMember(owner = "client!rf", name = "B", descriptor = "I")
    public int anInt8278;

    @OriginalMember(owner = "client!rf", name = "C", descriptor = "I")
    public int anInt8264 = 0;

    @OriginalMember(owner = "client!rf", name = "o", descriptor = "Z")
    public boolean inactive = false;

    @OriginalMember(owner = "client!rf", name = "s", descriptor = "Lclient!iea;")
    public ParticleEmitterRelated related1 = new ParticleEmitterRelated();

    @OriginalMember(owner = "client!rf", name = "h", descriptor = "Lclient!iea;")
    public ParticleEmitterRelated related2 = new ParticleEmitterRelated();

    @OriginalMember(owner = "client!rf", name = "E", descriptor = "Z")
    public boolean finished = false;

    @OriginalMember(owner = "client!rf", name = "r", descriptor = "Lclient!rv;")
    public final ModelParticleEmitter model;

    @OriginalMember(owner = "client!rf", name = "g", descriptor = "J")
    public final long startTime;

    @OriginalMember(owner = "client!rf", name = "k", descriptor = "Lclient!hv;")
    public final ParticleSystem system;

    @OriginalMember(owner = "client!rf", name = "q", descriptor = "Lclient!vaa;")
    public ParticleEmitterType type;

    @OriginalMember(owner = "client!rf", name = "j", descriptor = "Lclient!fla;")
    public final LinkedList movingParticles;

    @OriginalMember(owner = "client!rf", name = "<init>", descriptor = "(Lclient!ha;Lclient!rv;Lclient!hv;J)V")
    public ParticleEmitter(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) ModelParticleEmitter model, @OriginalArg(2) ParticleSystem system, @OriginalArg(3) long startTime) {
        this.model = model;
        this.startTime = startTime;
        this.system = system;
        this.type = this.model.getType();
        if (!toolkit.method7937() && this.type.untextured != -1) {
            this.type = ParticleEmitterTypeList.get(this.type.untextured);
        }
        this.movingParticles = new LinkedList();
        this.anInt8264 = (int) ((double) this.anInt8264 + Math.random() * 64.0D);
        this.method7264();
        this.related2.anInt4281 = this.related1.anInt4281;
        this.related2.anInt4280 = this.related1.anInt4280;
        this.related2.anInt4277 = this.related1.anInt4277;
        this.related2.anInt4269 = this.related1.anInt4269;
        this.related2.anInt4283 = this.related1.anInt4283;
        this.related2.anInt4275 = this.related1.anInt4275;
        this.related2.anInt4270 = this.related1.anInt4270;
        this.related2.anInt4276 = this.related1.anInt4276;
        this.related2.anInt4279 = this.related1.anInt4279;
    }

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(IBZJLclient!ha;)V")
    public void tick(@OriginalArg(0) int elapsedTime, @OriginalArg(2) boolean running, @OriginalArg(3) long time, @OriginalArg(4) Toolkit toolkit) {
        if (this.inactive) {
            running = false;
        } else if (ParticleManager.option < this.type.minSetting) {
            running = false;
        } else if (ParticleManager.previousParticleCount > ParticleLimits.PARTICLES[ParticleManager.option]) {
            running = false;
        } else if (this.finished) {
            running = false;
        } else if (this.type.lifetime != -1) {
            @Pc(46) int timeSinceStart = (int) (time - this.startTime);
            if (this.type.periodic || this.type.lifetime >= timeSinceStart) {
                timeSinceStart %= this.type.lifetime;
            } else {
                running = false;
            }
            if (!this.type.activeFirst && timeSinceStart < this.type.activationAge) {
                running = false;
            }
            if (this.type.activeFirst && this.type.activationAge <= timeSinceStart) {
                running = false;
            }
        }

        if (running) {
            ParticleManager.emitterCount++;
            @Pc(46) int local46 = (this.related1.anInt4276 + this.related1.anInt4279 + this.related1.anInt4281) / 3;
            @Pc(147) int local147 = (this.related1.anInt4269 + this.related1.anInt4280 + this.related1.anInt4283) / 3;
            @Pc(162) int local162 = (this.related1.anInt4277 + this.related1.anInt4270 + this.related1.anInt4275) / 3;
            @Pc(210) int local210;
            @Pc(218) int local218;
            @Pc(226) int local226;
            @Pc(235) int local235;
            @Pc(244) int local244;
            @Pc(252) int local252;
            @Pc(362) int local362;
            @Pc(414) int local414;
            @Pc(435) int local435;
            if (local46 != this.related1.anInt4271 || local147 != this.related1.anInt4278 || this.related1.anInt4273 != local162) {
                this.related1.anInt4278 = local147;
                this.related1.anInt4273 = local162;
                this.related1.anInt4271 = local46;
                local210 = this.related1.anInt4281 - this.related1.anInt4279;
                local218 = this.related1.anInt4283 - this.related1.anInt4280;
                local226 = this.related1.anInt4277 - this.related1.anInt4270;
                local235 = this.related1.anInt4276 - this.related1.anInt4279;
                local244 = this.related1.anInt4269 - this.related1.anInt4280;
                local252 = this.related1.anInt4275 - this.related1.anInt4270;
                this.anInt8278 = local210 * local244 - local218 * local235;
                this.anInt8275 = local218 * local252 - local226 * local244;
                this.anInt8277 = local235 * local226 - local252 * local210;
                while (true) {
                    if (this.anInt8275 <= 32767 && this.anInt8277 <= 32767 && this.anInt8278 <= 32767 && this.anInt8275 >= -32767 && this.anInt8277 >= -32767 && this.anInt8278 >= -32767) {
                        local362 = (int) Math.sqrt(this.anInt8275 * this.anInt8275 + this.anInt8277 * this.anInt8277 + this.anInt8278 * this.anInt8278);
                        if (local362 <= 0) {
                            local362 = 1;
                        }
                        this.anInt8277 = this.anInt8277 * 32767 / local362;
                        this.anInt8275 = this.anInt8275 * 32767 / local362;
                        this.anInt8278 = this.anInt8278 * 32767 / local362;
                        if (this.type.maxAngleH > 0 || this.type.maxAngleV > 0) {
                            local414 = (int) (Math.atan2(this.anInt8278, this.anInt8275) * 2607.5945876176133D);
                            local435 = (int) (Math.atan2(this.anInt8277, Math.sqrt(this.anInt8275 * this.anInt8275 + this.anInt8278 * this.anInt8278)) * 2607.5945876176133D);
                            this.anInt8273 = this.type.maxAngleH - this.type.minAngleH;
                            this.anInt8272 = this.type.minAngleH + local414 - (this.anInt8273 >> 1);
                            this.anInt8274 = this.type.maxAngleV - this.type.minAngleV;
                            this.anInt8276 = this.type.minAngleV + local435 - (this.anInt8274 >> 1);
                        }
                        break;
                    }
                    this.anInt8278 >>= 0x1;
                    this.anInt8275 >>= 0x1;
                    this.anInt8277 >>= 0x1;
                }
            }
            this.anInt8264 += (int) (((double) this.type.minParticleRate + Math.random() * (double) (this.type.maxParticleRate - this.type.minParticleRate)) * (double) elapsedTime);
            if (this.anInt8264 > 63) {
                local210 = this.anInt8264 >> 6;
                this.anInt8264 &= 0x3F;
                for (local244 = 0; local244 < local210; local244++) {
                    @Pc(577) int local577;
                    @Pc(581) int local581;
                    if (this.type.maxAngleH <= 0 && this.type.maxAngleV <= 0) {
                        local218 = this.anInt8275;
                        local235 = this.anInt8278;
                        local226 = this.anInt8277;
                    } else {
                        local252 = (int) ((double) this.anInt8273 * Math.random()) + this.anInt8272;
                        local252 &= 0x3FFF;
                        local362 = Trig1.SIN[local252];
                        local414 = Trig1.COS[local252];
                        local435 = this.anInt8276 + (int) ((double) this.anInt8274 * Math.random());
                        local435 &= 0x1FFF;
                        local577 = Trig1.SIN[local435];
                        local581 = Trig1.COS[local435];
                        local218 = local414 * local577 >> 13;
                        local226 = (local581 << 1) * -1;
                        local235 = local577 * local362 >> 13;
                    }
                    @Pc(615) float local615 = (float) Math.random();
                    @Pc(618) float local618 = (float) Math.random();
                    if (local618 + local615 > 1.0F) {
                        local615 = 1.0F - local615;
                        local618 = 1.0F - local618;
                    }
                    @Pc(639) float local639 = 1.0F - local618 - local615;
                    local435 = (int) ((float) this.related1.anInt4276 * local639 + (float) this.related1.anInt4281 * local618 + local615 * (float) this.related1.anInt4279);
                    local577 = (int) ((float) this.related1.anInt4283 * local618 + local615 * (float) this.related1.anInt4280 + local639 * (float) this.related1.anInt4269);
                    local581 = (int) ((float) this.related1.anInt4270 * local615 + (float) this.related1.anInt4277 * local618 + local639 * (float) this.related1.anInt4275);
                    @Pc(727) int local727 = (int) (local639 * (float) this.related2.anInt4276 + (float) this.related2.anInt4281 * local618 + (float) this.related2.anInt4279 * local615);
                    @Pc(749) int local749 = (int) (local639 * (float) this.related2.anInt4269 + local618 * (float) this.related2.anInt4283 + local615 * (float) this.related2.anInt4280);
                    @Pc(771) int local771 = (int) (local618 * (float) this.related2.anInt4277 + (float) this.related2.anInt4270 * local615 + (float) this.related2.anInt4275 * local639);
                    @Pc(776) int local776 = local435 - local727;
                    @Pc(780) int local780 = local577 - local749;
                    @Pc(785) int local785 = local581 - local771;
                    @Pc(794) int local794 = (int) ((double) local776 * Math.random() + (double) local727);
                    @Pc(803) int local803 = (int) ((double) local749 + (double) local780 * Math.random());
                    @Pc(812) int local812 = (int) ((double) local771 + Math.random() * (double) local785);
                    @Pc(828) int local828 = (int) (Math.random() * (double) (this.type.maxSpeed - this.type.minSpeed)) + this.type.minSpeed;
                    @Pc(845) int local845 = (int) (Math.random() * (double) (this.type.maxLifetime - this.type.minLifetime)) + this.type.minLifetime;
                    @Pc(862) int local862 = (int) (Math.random() * (double) (this.type.maxSize - this.type.minSize)) + this.type.minSize;
                    @Pc(926) int local926;
                    if (this.type.uniformColourVariance) {
                        @Pc(868) double local868 = Math.random();
                        local926 = (int) ((double) this.type.anInt9903 + (double) this.type.anInt9913 * local868) | (int) ((double) this.type.anInt9914 + local868 * (double) this.type.anInt9911) << 8 | (int) ((double) this.type.anInt9899 + (double) this.type.anInt9929 * local868) << 16 | (int) (Math.random() * (double) this.type.anInt9878 + (double) this.type.anInt9906) << 24;
                    } else {
                        local926 = (int) ((double) this.type.anInt9903 + Math.random() * (double) this.type.anInt9913) | (int) ((double) this.type.anInt9914 + Math.random() * (double) this.type.anInt9911) << 8 | (int) (Math.random() * (double) this.type.anInt9929 + (double) this.type.anInt9899) << 16 | (int) ((double) this.type.anInt9906 + (double) this.type.anInt9878 * Math.random()) << 24;
                    }
                    @Pc(990) int local990 = this.type.texture;
                    if (!toolkit.method7937() && !this.type.aBoolean755) {
                        local990 = -1;
                    }
                    if (ParticleManager.particleNextPtr == ParticleManager.particleFreePtr) {
                        new MovingParticle(this, local794, local803, local812, local218, local226, local235, local828, local845, local926, local862, local990, this.type.disableHdLighting, this.type.preserveAmbient);
                    } else {
                        @Pc(1032) MovingParticle local1032 = ParticleManager.particles[ParticleManager.particleNextPtr];
                        ParticleManager.particleNextPtr = ParticleManager.particleNextPtr + 1 & 0x3FF;
                        local1032.method6696(this, local794, local803, local812, local218, local226, local235, local828, local845, local926, local862, local990, this.type.disableHdLighting, this.type.preserveAmbient);
                    }
                }
            }
        }
        if (!this.related1.method3860(this.related2)) {
            @Pc(1078) ParticleEmitterRelated local1078 = this.related2;
            this.related2 = this.related1;
            this.related1 = local1078;
            this.related1.anInt4275 = this.model.anInt8520;
            this.related1.anInt4276 = this.model.anInt8512;
            this.related1.anInt4283 = this.model.anInt8507;
            this.related1.anInt4281 = this.model.anInt8516;
            this.related1.anInt4270 = this.model.anInt8504;
            this.related1.anInt4280 = this.model.anInt8502;
            this.related1.anInt4277 = this.model.anInt8509;
            this.related1.anInt4278 = this.related2.anInt4278;
            this.related1.anInt4273 = this.related2.anInt4273;
            this.related1.anInt4279 = this.model.anInt8518;
            this.related1.anInt4271 = this.related2.anInt4271;
            this.related1.anInt4269 = this.model.anInt8503;
        }
        this.anInt8268 = 0;
        for (@Pc(1171) MovingParticle local1171 = (MovingParticle) this.movingParticles.first(); local1171 != null; local1171 = (MovingParticle) this.movingParticles.next()) {
            local1171.method6694(time, elapsedTime);
            this.anInt8268++;
        }
        ParticleManager.particleCount += this.anInt8268;
    }

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(JLclient!ha;I)V")
    public void method7263(@OriginalArg(0) long arg0, @OriginalArg(1) Toolkit arg1) {
        for (@Pc(11) MovingParticle local11 = (MovingParticle) this.movingParticles.first(); local11 != null; local11 = (MovingParticle) this.movingParticles.next()) {
            local11.method6695(arg1, arg0);
        }
    }

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(B)V")
    public void method7264() {
        this.related1.anInt4283 = this.model.anInt8507;
        this.related1.anInt4275 = this.model.anInt8520;
        this.related1.anInt4276 = this.model.anInt8512;
        this.related1.anInt4280 = this.model.anInt8502;
        this.related1.anInt4281 = this.model.anInt8516;
        this.related1.anInt4270 = this.model.anInt8504;
        this.related1.anInt4277 = this.model.anInt8509;
        this.related1.anInt4279 = this.model.anInt8518;
        this.related1.anInt4269 = this.model.anInt8503;

        if (this.related1.anInt4281 == this.related1.anInt4279 && this.related1.anInt4276 == this.related1.anInt4281 && this.related1.anInt4280 == this.related1.anInt4283 && this.related1.anInt4283 == this.related1.anInt4269 && this.related1.anInt4270 == this.related1.anInt4277 && this.related1.anInt4275 == this.related1.anInt4277) {
            this.finished = true;
        } else if (this.finished) {
            this.related2.anInt4280 = this.related1.anInt4280;
            this.related2.anInt4270 = this.related1.anInt4270;
            this.related2.anInt4279 = this.related1.anInt4279;
            this.related2.anInt4283 = this.related1.anInt4283;
            this.related2.anInt4277 = this.related1.anInt4277;
            this.related2.anInt4269 = this.related1.anInt4269;
            this.related2.anInt4275 = this.related1.anInt4275;
            this.finished = false;
            this.related2.anInt4276 = this.related1.anInt4276;
            this.related2.anInt4281 = this.related1.anInt4281;
        }
    }
}
