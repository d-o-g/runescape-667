package rs2.client.loading.screen.op;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jd")
public interface LoadingScreenOp {

    @OriginalMember(owner = "client!jd", name = "b", descriptor = "(I)Z")
    boolean ready();

    @OriginalMember(owner = "client!jd", name = "a", descriptor = "(I)V")
    void init();

    @OriginalMember(owner = "client!jd", name = "a", descriptor = "(ZI)V")
    void execute();
}
