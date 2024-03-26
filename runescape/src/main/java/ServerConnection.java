import com.jagex.SignedResource;
import com.jagex.core.crypto.Isaac;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.BitPacket;
import com.jagex.core.io.connection.Connection;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

@OriginalClass("client!gw")
public final class ServerConnection {

    @OriginalMember(owner = "client!gw", name = "s", descriptor = "Lclient!vn;")
    public Connection connection;

    @OriginalMember(owner = "client!gw", name = "r", descriptor = "Lclient!oba;")
    public SignedResource gameSocketRequest;

    @OriginalMember(owner = "client!gw", name = "l", descriptor = "Lclient!iv;")
    public Isaac cipher;

    @OriginalMember(owner = "client!gw", name = "t", descriptor = "I")
    public int writeRate;

    @OriginalMember(owner = "client!gw", name = "z", descriptor = "Lclient!lga;")
    public ServerProt antepenultimateProt;

    @OriginalMember(owner = "client!gw", name = "o", descriptor = "Lclient!lga;")
    public ServerProt aServerProt_92;

    @OriginalMember(owner = "client!gw", name = "B", descriptor = "I")
    public int read;

    @OriginalMember(owner = "client!gw", name = "A", descriptor = "I")
    public int readRate;

    @OriginalMember(owner = "client!gw", name = "e", descriptor = "Lclient!lga;")
    public ServerProt penultimateProt;

    @OriginalMember(owner = "client!gw", name = "w", descriptor = "I")
    public int written;

    @OriginalMember(owner = "client!gw", name = "h", descriptor = "Lclient!sia;")
    public final Deque messages = new Deque();

    @OriginalMember(owner = "client!gw", name = "x", descriptor = "I")
    public int buffered = 0;

    @OriginalMember(owner = "client!gw", name = "d", descriptor = "Lclient!ge;")
    public final Packet writePacket = new Packet(1350);

    @OriginalMember(owner = "client!gw", name = "y", descriptor = "Lclient!rka;")
    public final BitPacket bitPacket = new BitPacket(15000);

    @OriginalMember(owner = "client!gw", name = "j", descriptor = "Lclient!lga;")
    public ServerProt currentProt = null;

    @OriginalMember(owner = "client!gw", name = "u", descriptor = "I")
    public int currentPacketSize = 0;

    @OriginalMember(owner = "client!gw", name = "g", descriptor = "I")
    public int idleWriteTicks = 0;

    @OriginalMember(owner = "client!gw", name = "a", descriptor = "Z")
    public boolean errored = false;

    @OriginalMember(owner = "client!gw", name = "q", descriptor = "Z")
    public boolean needsOpcode = true;

    @OriginalMember(owner = "client!gw", name = "n", descriptor = "I")
    public int anInt3646 = 0;

    @OriginalMember(owner = "client!gw", name = "b", descriptor = "(I)V")
    public void recordStats() {
        if (TimeUtils.clock % 50 == 0) {
            this.writeRate = this.written;
            this.readRate = this.read;
            this.written = 0;
            this.read = 0;
        }
    }

    @OriginalMember(owner = "client!gw", name = "a", descriptor = "(B)V")
    public void clear() {
        this.messages.clear();
        this.buffered = 0;
    }

    @OriginalMember(owner = "client!gw", name = "b", descriptor = "(B)V")
    public void flush() throws IOException {
        if (this.connection == null || this.buffered <= 0) {
            return;
        }

        this.writePacket.pos = 0;

        while (true) {
            @Pc(23) ClientMessage message = (ClientMessage) this.messages.first();
            if (message == null || message.totalSize > this.writePacket.data.length - this.writePacket.pos) {
                break;
            }

            this.writePacket.pdata(message.totalSize, message.bitPacket.data, 0);
            this.buffered -= message.totalSize;
            message.unlink();
            message.bitPacket.cache();
            message.method2768();
        }

        this.connection.write(this.writePacket.data, this.writePacket.pos, 0);
        this.idleWriteTicks = 0;
        this.written += this.writePacket.pos;
    }

    @OriginalMember(owner = "client!gw", name = "c", descriptor = "(I)V")
    public void close() {
        if (this.connection != null) {
            this.connection.close();
            this.connection = null;
        }
    }

    @OriginalMember(owner = "client!gw", name = "a", descriptor = "(ILclient!fk;)V")
    public void send(@OriginalArg(1) ClientMessage message) {
        this.messages.addLast(message);
        message.totalSize = message.bitPacket.pos;
        message.bitPacket.pos = 0;
        this.buffered += message.totalSize;
    }
}
