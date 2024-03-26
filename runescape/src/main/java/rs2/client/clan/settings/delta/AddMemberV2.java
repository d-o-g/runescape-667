package rs2.client.clan.settings.delta;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

@OriginalClass("client!lda")
public final class AddMemberV2 extends DeltaEntry {

    @OriginalMember(owner = "client!lda", name = "s", descriptor = "Ljava/lang/String;")
    public String name = null;

    @OriginalMember(owner = "client!lda", name = "n", descriptor = "I")
    public int joinRuneday = 0;

    @OriginalMember(owner = "client!lda", name = "p", descriptor = "J")
    public long hash = -1L;

    @OriginalMember(owner = "client!lda", name = "a", descriptor = "(Lclient!hi;I)V")
    @Override
    public void applyTo(@OriginalArg(0) ClanSettings settings) {
        settings.doAddMember(this.name, this.hash, this.joinRuneday);
    }

    @OriginalMember(owner = "client!lda", name = "a", descriptor = "(ILclient!ge;)V")
    @Override
    public void decode(@OriginalArg(1) Packet packet) {
        if (packet.g1() != 255) {
            packet.pos--;
            this.hash = packet.g8();
        }

        this.name = packet.fastgstr();
        this.joinRuneday = packet.g2();

        if (ClanSettings.debug) {
            System.out.println("memberhash:" + this.hash + " membername:" + this.name);
        }
    }
}
