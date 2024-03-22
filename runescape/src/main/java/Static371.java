import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static371 {

    @OriginalMember(owner = "client!lma", name = "a", descriptor = "[I")
    public static final int[] anIntArray455 = new int[200];

    @OriginalMember(owner = "client!lma", name = "b", descriptor = "(I)V")
    public static void method5284() {
        @Pc(22) ClientMessage local22 = Static293.method4335(Static587.aClass345_105, ConnectionManager.GAME.cipher);
        local22.buffer.p1(InterfaceManager.getWindowMode());
        local22.buffer.p2(GameShell.canvasWid);
        local22.buffer.p2(GameShell.canvasHei);
        local22.buffer.p1(Static400.instance.aClass57_Sub13_1.method4373());
        ConnectionManager.GAME.send(local22);
    }
}
