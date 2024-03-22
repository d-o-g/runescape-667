import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.constants.ModeWhere;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@OriginalClass("client!tu")
public final class Class362 implements Runnable {

    @OriginalMember(owner = "client!tu", name = "a", descriptor = "[Lclient!rj;")
    public Class323[] aClass323Array1;

    @OriginalMember(owner = "client!tu", name = "f", descriptor = "Z")
    public volatile boolean aBoolean730;

    @OriginalMember(owner = "client!tu", name = "c", descriptor = "Lclient!oba;")
    public SignedResource aSignedResource_7;

    @OriginalMember(owner = "client!tu", name = "g", descriptor = "Ljava/lang/Thread;")
    public Thread aThread5;

    @OriginalMember(owner = "client!tu", name = "a", descriptor = "(II)Lclient!rj;")
    public Class323 method8346(@OriginalArg(1) int arg0) {
        return this.aClass323Array1 == null || arg0 < 0 || this.aClass323Array1.length <= arg0 ? null : this.aClass323Array1[arg0];
    }

    @OriginalMember(owner = "client!tu", name = "run", descriptor = "()V")
    @Override
    public void run() {
        try {
            @Pc(16) BufferedReader local16 = new BufferedReader(new InputStreamReader((DataInputStream) this.aSignedResource_7.result));
            @Pc(19) String local19 = local16.readLine();
            @Pc(22) Class396 local22 = Static640.method8436();
            while (local19 != null) {
                local22.method9149(local19);
                local19 = local16.readLine();
            }
            @Pc(39) String[] local39 = local22.method9151();
            if (local39.length % 3 != 0) {
                return;
            }
            this.aClass323Array1 = new Class323[local39.length / 3];
            for (@Pc(57) int local57 = 0; local57 < local39.length; local57 += 3) {
                this.aClass323Array1[local57 / 3] = new Class323(local39[local57], local39[local57 + 1], local39[local57 + 2]);
            }
        } catch (@Pc(92) IOException local92) {
        }
        this.aBoolean730 = true;
    }

    @OriginalMember(owner = "client!tu", name = "b", descriptor = "(I)Z")
    public boolean method8349() {
        if (this.aBoolean730) {
            return true;
        }
        if (this.aSignedResource_7 == null) {
            try {
                @Pc(23) int local23 = ModeWhere.LIVE == client.modeWhere ? 80 : Login.worldInfo.id + 7000;
                this.aSignedResource_7 = SignLink.instance.openStream(new URL("http://" + Login.worldInfo.address + ":" + local23 + "/news.ws?game=" + client.modeGame.id));
            } catch (@Pc(54) MalformedURLException local54) {
                return true;
            }
        }
        if (this.aSignedResource_7 == null || this.aSignedResource_7.status == 2) {
            return true;
        } else if (this.aSignedResource_7.status == 1) {
            if (this.aThread5 == null) {
                this.aThread5 = new Thread(this);
                this.aThread5.start();
            }
            return this.aBoolean730;
        } else {
            return false;
        }
    }
}
