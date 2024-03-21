package rs2.client.event.mouse;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.event.mouse.MouseLog;

@OriginalClass("client!ct")
public final class CompleteMouseLog extends MouseLog {

    @OriginalMember(owner = "client!ct", name = "r", descriptor = "I")
    public int y;

    @OriginalMember(owner = "client!ct", name = "s", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!ct", name = "v", descriptor = "J")
    public long time;

    @OriginalMember(owner = "client!ct", name = "u", descriptor = "I")
    public int x;

    @OriginalMember(owner = "client!ct", name = "t", descriptor = "I")
    public int extra;

    @OriginalMember(owner = "client!ct", name = "c", descriptor = "(B)I")
    @Override
    public int getExtra() {
        return this.extra;
    }

    @OriginalMember(owner = "client!ct", name = "a", descriptor = "(I)I")
    @Override
    public int getY() {
        return this.y;
    }

    @OriginalMember(owner = "client!ct", name = "b", descriptor = "(B)J")
    @Override
    public long getTime() {
        return this.time;
    }

    @OriginalMember(owner = "client!ct", name = "a", descriptor = "(Z)I")
    @Override
    public int getType() {
        return this.type;
    }

    @OriginalMember(owner = "client!ct", name = "b", descriptor = "(I)I")
    @Override
    public int getX() {
        return this.x;
    }
}
