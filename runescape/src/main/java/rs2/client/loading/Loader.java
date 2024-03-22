package rs2.client.loading;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.LoadingRequirementType;

@OriginalClass("client!jma")
public interface Loader {

    @OriginalMember(owner = "client!jma", name = "a", descriptor = "(B)Lclient!kf;")
    LoadingRequirementType type();

    @OriginalMember(owner = "client!jma", name = "a", descriptor = "(I)I")
    int completePercentage();
}
