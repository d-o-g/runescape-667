import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

@OriginalClass("client!wea")
public final class Js5Video extends Video {

    @OriginalMember(owner = "client!wea", name = "I", descriptor = "[I")
    public int[] pages;

    @OriginalMember(owner = "client!wea", name = "J", descriptor = "I")
    public int pageIndex;

    @OriginalMember(owner = "client!wea", name = "N", descriptor = "[[B")
    public byte[][] pageData = new byte[10][];

    @OriginalMember(owner = "client!wea", name = "S", descriptor = "Lclient!ge;")
    public final Packet pagePacket = new Packet(null);

    @OriginalMember(owner = "client!wea", name = "O", descriptor = "Lclient!ge;")
    public final Packet filePacket = new Packet(null);

    @OriginalMember(owner = "client!wea", name = "L", descriptor = "Lclient!sb;")
    public final js5 js5;

    @OriginalMember(owner = "client!wea", name = "K", descriptor = "I")
    public final int file;

    @OriginalMember(owner = "client!wea", name = "<init>", descriptor = "(ILclient!sb;I)V")
    public Js5Video(@OriginalArg(0) int arg0, @OriginalArg(1) js5 js5, @OriginalArg(2) int arg2) {
        super(arg0);
        this.js5 = js5;
        this.file = arg2;
    }

    @OriginalMember(owner = "client!wea", name = "i", descriptor = "(I)V")
    public void readNextPages() {
        if (this.pages == null) {
            return;
        }

        for (@Pc(12) int i = 0; (i < 10) && ((i + this.pageIndex) < this.pages.length); i++) {
            if (this.pageData[i] == null && this.js5.requestdownload(0, this.pages[this.pageIndex + i])) {
                this.pageData[i] = this.js5.getfile(0, this.pages[this.pageIndex + i]);
            }
        }
    }

    @OriginalMember(owner = "client!wea", name = "a", descriptor = "([BI)I")
    @Override
    protected int readPage(@OriginalArg(0) byte[] buffer) throws IOException {
        if (this.pages == null) {
            if (!this.js5.requestdownload(0, this.file)) {
                return 0;
            }

            @Pc(29) byte[] data = this.js5.getfile(0, this.file);
            if (data == null) {
                throw new IllegalStateException("");
            }

            this.filePacket.data = data;
            this.filePacket.pos = 0;

            @Pc(50) int count = data.length >> 1;
            this.pages = new int[count];
            for (@Pc(56) int page = 0; page < count; page++) {
                this.pages[page] = this.filePacket.g2();
            }
        }

        if (this.pageIndex >= this.pages.length) {
            return -1;
        }

        this.readNextPages();

        this.filePacket.data = buffer;
        this.filePacket.pos = 0;

        do {
            if (this.filePacket.pos >= this.filePacket.data.length) {
                this.filePacket.data = null;
                return buffer.length;
            }

            if (this.pagePacket.data == null) {
                if (this.pageData[0] == null) {
                    this.filePacket.data = null;
                    return this.filePacket.pos;
                }

                this.pagePacket.data = this.pageData[0];
            }

            @Pc(143) int freeSpace = this.filePacket.data.length - this.filePacket.pos;
            @Pc(50) int pageSize = this.pagePacket.data.length - this.pagePacket.pos;
            if (freeSpace < pageSize) {
                this.pagePacket.gdata(this.filePacket.pos, freeSpace, this.filePacket.data);
                this.filePacket.data = null;
                return buffer.length;
            }

            this.filePacket.pdata(pageSize, this.pagePacket.data, this.pagePacket.pos);
            this.pagePacket.pos = 0;
            this.pageIndex++;
            this.pagePacket.data = null;
            for (@Pc(56) int i = 0; i < 9; i++) {
                this.pageData[i] = this.pageData[i + 1];
            }
            this.pageData[9] = null;
        } while (this.pageIndex < this.pages.length);

        this.filePacket.data = null;
        return this.filePacket.pos;
    }
}
