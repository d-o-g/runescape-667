package rs2.client.loading.loader;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!kf")
public final class LoadingRequirementType {

    @OriginalMember(owner = "client!kf", name = "b", descriptor = "Lclient!kf;")
    public static final LoadingRequirementType JS5 = new LoadingRequirementType();

    @OriginalMember(owner = "client!kf", name = "d", descriptor = "Lclient!kf;")
    public static final LoadingRequirementType JS5_FILE = new LoadingRequirementType();

    @OriginalMember(owner = "client!kf", name = "c", descriptor = "Lclient!kf;")
    public static final LoadingRequirementType JS5_GROUP = new LoadingRequirementType();

    @OriginalMember(owner = "client!kf", name = "a", descriptor = "Lclient!kf;")
    public static final LoadingRequirementType NATIVE_LIBRARY = new LoadingRequirementType();

    @OriginalMember(owner = "client!kf", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        throw new IllegalStateException();
    }
}
