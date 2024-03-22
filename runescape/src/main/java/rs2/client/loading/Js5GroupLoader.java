package rs2.client.loading;

import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.Loader;
import rs2.client.loading.LoadingRequirementType;

@OriginalClass("client!ev")
public final class Js5GroupLoader implements Loader {

    @OriginalMember(owner = "client!ev", name = "h", descriptor = "Ljava/lang/String;")
    public final String group;

    @OriginalMember(owner = "client!ev", name = "c", descriptor = "Lclient!sb;")
    public final js5 config;

    @OriginalMember(owner = "client!ev", name = "<init>", descriptor = "(Lclient!sb;Ljava/lang/String;)V")
    public Js5GroupLoader(@OriginalArg(0) js5 config, @OriginalArg(1) String group) {
        this.group = group;
        this.config = config;
    }

    @OriginalMember(owner = "client!ev", name = "a", descriptor = "(I)I")
    @Override
    public int completePercentage() {
        if (this.config.requestgroupdownload(this.group)) {
            return 100;
        } else {
            return this.config.completePercentage(this.group);
        }
    }

    @OriginalMember(owner = "client!ev", name = "a", descriptor = "(B)Lclient!kf;")
    @Override
    public LoadingRequirementType type() {
        return LoadingRequirementType.JS5_GROUP;
    }
}
