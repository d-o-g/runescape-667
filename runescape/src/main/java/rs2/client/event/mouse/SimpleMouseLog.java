package rs2.client.event.mouse;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.event.mouse.MouseLog;

@OriginalClass("client!lt")
public final class SimpleMouseLog extends MouseLog {

    @OriginalMember(owner = "client!lt", name = "t", descriptor = "I")
    public int y;

    @OriginalMember(owner = "client!lt", name = "v", descriptor = "I")
    public int x;

    @OriginalMember(owner = "client!lt", name = "r", descriptor = "I")
    public int extra;

    @OriginalMember(owner = "client!lt", name = "y", descriptor = "J")
    public long time;

    @OriginalMember(owner = "client!lt", name = "w", descriptor = "I")
    public int type;

    @OriginalMember(owner = "client!lt", name = "a", descriptor = "(I)I")
    @Override
    public int getY() {
        return this.y;
    }

    @OriginalMember(owner = "client!lt", name = "c", descriptor = "(B)I")
    @Override
    public int getExtra() {
        return this.extra;
    }

    @OriginalMember(owner = "client!lt", name = "b", descriptor = "(I)I")
    @Override
    public int getX() {
        return this.x;
    }

    @OriginalMember(owner = "client!lt", name = "b", descriptor = "(B)J")
    @Override
    public long getTime() {
        return this.time;
    }

    @OriginalMember(owner = "client!lt", name = "a", descriptor = "(Z)I")
    @Override
    public int getType() {
        return this.type;
    }
}
