package rs2.client.loading.screen.op.instance;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!gja")
public interface LoadingScreenOpInstance {

    @OriginalMember(owner = "client!gja", name = "a", descriptor = "(I)Lclient!kda;")
    LoadingScreenOpType type();
}
