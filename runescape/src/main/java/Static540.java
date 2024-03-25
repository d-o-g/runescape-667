import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static540 {

    @OriginalMember(owner = "client!r", name = "t", descriptor = "[I")
    public static final int[] anIntArray594 = new int[]{7, 8, 9, 10, 11, 12, 13, 15};

    @OriginalMember(owner = "client!r", name = "a", descriptor = "(Ljava/lang/String;BILjava/lang/String;)I")
    public static int compare(@OriginalArg(0) String b, @OriginalArg(2) int language, @OriginalArg(3) String a) {
        @Pc(6) int lengthA = a.length();
        @Pc(9) int lengthB = b.length();
        @Pc(11) int local11 = 0;
        @Pc(13) int local13 = 0;
        @Pc(22) char local22 = 0;
        @Pc(24) char local24 = 0;
        while (local11 - local22 < lengthA || lengthB > local13 - local24) {
            if (local11 - local22 >= lengthA) {
                return -1;
            }
            if (lengthB <= local13 - local24) {
                return 1;
            }
            @Pc(62) char local62;
            if (local22 == '\u0000') {
                local62 = a.charAt(local11++);
            } else {
                local62 = local22;
            }
            @Pc(77) char local77;
            if (local24 == '\u0000') {
                local77 = b.charAt(local13++);
            } else {
                local77 = local24;
            }
            local22 = StringTools.transliteral(local62);
            local24 = StringTools.transliteral(local77);
            local62 = Static322.method9436(language, local62);
            local77 = Static322.method9436(language, local77);
            if (local62 != local77 && Character.toUpperCase(local62) != Character.toUpperCase(local77)) {
                local62 = Character.toLowerCase(local62);
                local77 = Character.toLowerCase(local77);
                if (local77 != local62) {
                    return StringTools.intHash(language, local62) - StringTools.intHash(language, local77);
                }
            }
        }
        @Pc(149) int local149 = Math.min(lengthA, lengthB);
        for (@Pc(151) int local151 = 0; local151 < local149; local151++) {
            if (language == 2) {
                local11 = lengthA - local151 - 1;
                local13 = lengthB - local151 - 1;
            } else {
                local13 = local151;
                local11 = local151;
            }
            @Pc(180) char local180 = a.charAt(local11);
            @Pc(184) char local184 = b.charAt(local13);
            if (local180 != local184 && Character.toUpperCase(local180) != Character.toUpperCase(local184)) {
                local180 = Character.toLowerCase(local180);
                local184 = Character.toLowerCase(local184);
                if (local180 != local184) {
                    return StringTools.intHash(language, local180) - StringTools.intHash(language, local184);
                }
            }
        }
        @Pc(239) int local239 = lengthA - lengthB;
        if (local239 != 0) {
            return local239;
        }
        for (@Pc(246) int local246 = 0; local246 < local149; local246++) {
            @Pc(251) char local251 = a.charAt(local246);
            @Pc(255) char local255 = b.charAt(local246);
            if (local251 != local255) {
                return StringTools.intHash(language, local251) - StringTools.intHash(language, local255);
            }
        }
        return 0;
    }

    @OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILjava/lang/String;IIII)V")
    public static void method6539(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) String arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
        @Pc(7) Class8_Sub3 local7 = new Class8_Sub3();
        local7.anInt958 = arg0;
        local7.anInt954 = arg6;
        local7.anInt957 = arg3;
        local7.aString3 = arg2;
        local7.anInt959 = arg5;
        local7.anInt953 = TimeUtils.clock + arg1;
        local7.anInt956 = arg4;
        Static422.textCoords.add(local7);
    }
}
