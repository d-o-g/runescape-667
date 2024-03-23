import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.util.Date;

public final class Static79 {

    @OriginalMember(owner = "client!cja", name = "a", descriptor = "(BLjava/lang/String;)V")
    public static void method1579(@OriginalArg(1) String arg0) {
        if (Static393.aStringArray32 == null) {
            Static279.method4072();
        }
        Static459.aCalendar3.setTime(new Date(SystemTimer.safetime()));
        @Pc(20) int local20 = Static459.aCalendar3.get(11);
        @Pc(31) int local31 = Static459.aCalendar3.get(12);
        @Pc(35) int local35 = Static459.aCalendar3.get(13);
        @Pc(69) String local69 = Integer.toString(local20 / 10) + local20 % 10 + ":" + local31 / 10 + local31 % 10 + ":" + local35 / 10 + local35 % 10;
        @Pc(74) String[] local74 = Static189.method2861(arg0, '\n');
        for (@Pc(76) int local76 = 0; local76 < local74.length; local76++) {
            for (@Pc(79) int local79 = Static512.anInt7664; local79 > 0; local79--) {
                Static393.aStringArray32[local79] = Static393.aStringArray32[local79 - 1];
            }
            Static393.aStringArray32[0] = local69 + ": " + local74[local76];
            if (Static134.aFileOutputStream2 != null) {
                try {
                    Static134.aFileOutputStream2.write(Cp1252.encode(Static393.aStringArray32[0] + "\n"));
                } catch (@Pc(129) IOException local129) {
                }
            }
            if (Static512.anInt7664 < Static393.aStringArray32.length - 1) {
                Static512.anInt7664++;
                if (Static213.anInt3471 > 0) {
                    Static213.anInt3471++;
                }
            }
        }
    }
}
