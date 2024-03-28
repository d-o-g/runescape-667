package rs2.client.loading.screen;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!uha")
public interface LoadingScreen {

    @OriginalMember(owner = "client!uha", name = "d", descriptor = "(I)I")
    int percentage();

    @OriginalMember(owner = "client!uha", name = "a", descriptor = "(I)V")
    void method8461();

    @OriginalMember(owner = "client!uha", name = "c", descriptor = "(I)I")
    int getFadeDuration();

    @OriginalMember(owner = "client!uha", name = "a", descriptor = "(ZJ)Z")
    boolean method8463(@OriginalArg(1) long arg0);

    @OriginalMember(owner = "client!uha", name = "b", descriptor = "(I)V")
    void method8464();

    @OriginalMember(owner = "client!uha", name = "a", descriptor = "(ZB)V")
    void render(@OriginalArg(0) boolean arg0);
}
