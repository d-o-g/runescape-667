import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.Loader;
import rs2.client.loading.LoadingRequirementType;

@OriginalClass("client!rr")
public final class LoadingRequirement {

    @OriginalMember(owner = "client!rr", name = "f", descriptor = "Lclient!jma;")
    public Loader anLoader_1;

    @OriginalMember(owner = "client!rr", name = "r", descriptor = "Lclient!kf;")
    public final LoadingRequirementType aLoadingRequirementType_5;

    @OriginalMember(owner = "client!rr", name = "B", descriptor = "I")
    public int anInt8468;

    @OriginalMember(owner = "client!rr", name = "<init>", descriptor = "(Lclient!kf;)V")
    public LoadingRequirement(@OriginalArg(0) LoadingRequirementType arg0) {
        this.aLoadingRequirementType_5 = arg0;
        this.anInt8468 = 1;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(BI)V")
    public void setSize(@OriginalArg(1) int arg0) {
        this.anInt8468 = arg0;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(B)Lclient!jma;")
    public Loader method7469() {
        return this.anLoader_1;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(Lclient!jma;I)V")
    public void method7470(@OriginalArg(0) Loader arg0) {
        if (arg0.type() != this.aLoadingRequirementType_5) {
            throw new IllegalArgumentException();
        }
        this.anLoader_1 = arg0;
    }

    @OriginalMember(owner = "client!rr", name = "a", descriptor = "(I)I")
    public int method7471() {
        return this.anInt8468;
    }

    @OriginalMember(owner = "client!rr", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
