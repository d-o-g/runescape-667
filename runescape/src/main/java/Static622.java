import jaggl.OpenGL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static622 {

    @OriginalMember(owner = "client!tla", name = "a", descriptor = "(Ljava/lang/String;ILclient!qha;B)Lclient!cn;")
    public static Class71 method6854(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) GlToolkit arg2, @OriginalArg(3) byte arg3) {
        if (arg3 <= 97) {
            return null;
        }
        @Pc(11) int local11 = OpenGL.glGenProgramARB();
        OpenGL.glBindProgramARB(arg1, local11);
        OpenGL.glProgramStringARB(arg1, OpenGL.GL_PROGRAM_FORMAT_ASCII_ARB, arg0);
        OpenGL.glGetIntegerv(OpenGL.GL_PROGRAM_ERROR_POSITION_ARB, Static166.anIntArray247, 0);
        if (Static166.anIntArray247[0] == -1) {
            OpenGL.glBindProgramARB(arg1, 0);
            return new Class71(arg2, arg1, local11);
        } else {
            OpenGL.glBindProgramARB(arg1, 0);
            return null;
        }
    }
}
