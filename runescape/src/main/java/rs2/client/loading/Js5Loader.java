package rs2.client.loading;

import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ft")
public final class Js5Loader implements Loader {

    @OriginalMember(owner = "client!ft", name = "c", descriptor = "Lclient!sb;")
    public final js5 config;

    @OriginalMember(owner = "client!ft", name = "<init>", descriptor = "(Lclient!sb;)V")
    public Js5Loader(@OriginalArg(0) js5 config) {
        this.config = config;
    }

    @OriginalMember(owner = "client!ft", name = "a", descriptor = "(I)I")
    @Override
    public int completePercentage() {
        return this.config.isComplete() ? 100 : this.config.completePercentage();
    }

    @OriginalMember(owner = "client!ft", name = "a", descriptor = "(B)Lclient!kf;")
    @Override
    public LoadingRequirementType type() {
        return LoadingRequirementType.JS5;
    }
}
