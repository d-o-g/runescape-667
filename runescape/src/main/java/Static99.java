import com.jagex.core.io.connection.AsyncDuplexConnection;
import com.jagex.core.io.connection.Connection;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.IOException;
import java.net.Socket;

public final class Static99 {

    @OriginalMember(owner = "client!dba", name = "x", descriptor = "Lclient!dg;")
    public static SkyBoxSphereTypeList skyBoxSphereTypeList;

    @OriginalMember(owner = "client!dba", name = "z", descriptor = "I")
    public static int anInt2077;

    @OriginalMember(owner = "client!dba", name = "a", descriptor = "(Ljava/net/Socket;IB)Lclient!vn;")
    public static Connection method1975(@OriginalArg(0) Socket arg0) throws IOException {
        return new AsyncDuplexConnection(arg0, 15000);
    }

}
