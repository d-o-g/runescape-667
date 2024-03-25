import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ffa")
public final class Orientation {

    @OriginalMember(owner = "client!ffa", name = "n", descriptor = "I")
    public int value;

    @OriginalMember(owner = "client!ffa", name = "f", descriptor = "I")
    public int speed;

    @OriginalMember(owner = "client!ffa", name = "a", descriptor = "(Z)V")
    public void normalize() {
        this.value &= 0x3FFF;
    }

    @OriginalMember(owner = "client!ffa", name = "b", descriptor = "(I)I")
    public int getValue(@OriginalArg(0) int arg0) {
        if (arg0 != 16383) {
            this.tick(27, -51, 39, -81);
        }
        return this.value & 0x3FFF;
    }

    @OriginalMember(owner = "client!ffa", name = "a", descriptor = "(BI)V")
    public void setValue(@OriginalArg(1) int value) {
        this.value = value;
        this.speed = 0;
    }

    @OriginalMember(owner = "client!ffa", name = "a", descriptor = "(IIII)Z")
    public boolean tick(@OriginalArg(0) int target, @OriginalArg(1) int maxSpeed, @OriginalArg(2) int arg2, @OriginalArg(3) int acceleration) {
        @Pc(6) int speedBefore = this.speed;
        if (target == this.value && this.speed == 0) {
            return false;
        }

        @Pc(73) boolean accelerate;
        if (this.speed == 0) {
            if (target > this.value && target <= acceleration + this.value || this.value > target && this.value - acceleration <= target) {
                this.value = target;
                return false;
            }

            accelerate = true;
        } else if (this.speed > 0 && this.value < target) {
            @Pc(97) int delta = this.speed * this.speed / (acceleration * 2);
            @Pc(102) int end = delta + this.value;

            if (target > end && end >= this.value) {
                accelerate = true;
            } else {
                accelerate = false;
            }
        } else if (this.speed < 0 && target < this.value) {
            @Pc(97) int delta = this.speed * this.speed / (acceleration * 2);
            @Pc(102) int end = this.value - delta;
            if (target < end && end <= this.value) {
                accelerate = true;
            } else {
                accelerate = false;
            }
        } else {
            accelerate = false;
        }

        if (arg2 != -21712) {
            this.setValue(-89);
        }

        if (accelerate) {
            if (target > this.value) {
                this.speed += acceleration;

                if (maxSpeed != 0 && this.speed > maxSpeed) {
                    this.speed = maxSpeed;
                }
            } else {
                this.speed -= acceleration;

                if (maxSpeed != 0 && this.speed < -maxSpeed) {
                    this.speed = -maxSpeed;
                }
            }

            if (this.speed != speedBefore) {
                @Pc(97) int local97 = (this.speed * this.speed) / (acceleration * 2);
                if (this.value >= target) {
                    if (this.value > target && this.value - local97 < target) {
                        this.speed = speedBefore;
                    }
                } else if (target < local97 + this.value) {
                    this.speed = speedBefore;
                }
            }
        } else if (this.speed > 0) {
            this.speed -= acceleration;

            if (this.speed < 0) {
                this.speed = 0;
            }
        } else {
            this.speed += acceleration;

            if (this.speed > 0) {
                this.speed = 0;
            }
        }

        this.value += this.speed + speedBefore >> 1;
        return accelerate;
    }
}
