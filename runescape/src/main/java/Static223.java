import jaggl.OpenGL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static223 {

    @OriginalMember(owner = "client!gu", name = "O", descriptor = "Lclient!uf;")
    public static final Class370 aClass370_9 = new Class370();

    @OriginalMember(owner = "client!gu", name = "a", descriptor = "(B[Lclient!ns;Lclient!tca;)Lclient!rda;")
    public static Class317 method9088(@OriginalArg(1) Class265[] arg0, @OriginalArg(2) Toolkit_Sub1_Sub2 arg1) {
        for (@Pc(7) int local7 = 0; local7 < arg0.length; local7++) {
            if (arg0[local7] == null || arg0[local7].aLong213 <= 0L) {
                return null;
            }
        }
        if (-86 <= -113) {
            return null;
        }
        @Pc(50) long local50 = OpenGL.glCreateProgramObjectARB();
        for (@Pc(52) int local52 = 0; local52 < arg0.length; local52++) {
            OpenGL.glAttachObjectARB(local50, arg0[local52].aLong213);
        }
        OpenGL.glLinkProgramARB(local50);
        OpenGL.glGetObjectParameterivARB(local50, OpenGL.GL_LINK_STATUS, Static440.anIntArray529, 0);
        if (Static440.anIntArray529[0] == 0) {
            if (Static440.anIntArray529[0] == 0) {
                System.out.println("Shader linking failed:");
            }
            OpenGL.glGetObjectParameterivARB(local50, OpenGL.GL_INFO_LOG_LENGTH, Static440.anIntArray529, 1);
            if (Static440.anIntArray529[1] > 1) {
                @Pc(110) byte[] local110 = new byte[Static440.anIntArray529[1]];
                OpenGL.glGetInfoLogARB(local50, Static440.anIntArray529[1], Static440.anIntArray529, 0, local110, 0);
                System.out.println(new String(local110));
            }
            if (Static440.anIntArray529[0] == 0) {
                for (@Pc(131) int local131 = 0; local131 < arg0.length; local131++) {
                    OpenGL.glDetachObjectARB(local50, arg0[local131].aLong213);
                }
                OpenGL.glDeleteObjectARB(local50);
                return null;
            }
        }
        return new Class317(arg1, local50, arg0);
    }

}
