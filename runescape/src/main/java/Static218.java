import com.jagex.core.io.FileOnDisk;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.sign.SignedResource;
import com.jagex.sign.SignedResourceStatus;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static218 {

    @OriginalMember(owner = "client!go", name = "b", descriptor = "(I)V")
    public static void readVarcs() {
        @Pc(7) FileOnDisk file = null;
        try {
            @Pc(13) SignedResource resource = GameShell.signLink.openPrefs("2", true);
            while (resource.status == SignedResourceStatus.IDLE) {
                TimeUtils.sleep(1L);
            }

            if (resource.status == SignedResourceStatus.SUCCESS) {
                file = (FileOnDisk) resource.result;
                @Pc(41) byte[] data = new byte[(int) file.length()];

                @Pc(57) int read;
                for (@Pc(43) int i = 0; i < data.length; i += read) {
                    read = file.read(data.length - i, data, i);

                    if (read == -1) {
                        throw new IOException("EOF");
                    }
                }

                Static618.decodeVarcs(new Packet(data));
            }
        } catch (@Pc(88) Exception ignored) {
            /* empty */
        }

        try {
            if (file != null) {
                file.close();
            }
        } catch (@Pc(100) Exception ignored) {
            /* empty */
        }
    }
}
