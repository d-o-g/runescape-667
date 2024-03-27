import com.jagex.DisplayProperties;
import com.jagex.SignLink;
import com.jagex.core.constants.MaxScreenSize;
import com.jagex.core.util.Arrays;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static587 {

    @OriginalMember(owner = "client!sia", name = "h", descriptor = "I")
    public static int anInt8688;

    @OriginalMember(owner = "client!sia", name = "m", descriptor = "I")
    public static int anInt8673 = 0;

    @OriginalMember(owner = "client!sia", name = "n", descriptor = "Z")
    public static boolean aBoolean663 = false;

    @OriginalMember(owner = "client!sia", name = "b", descriptor = "[I")
    public static final int[] anIntArray689 = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};

    @OriginalMember(owner = "client!sia", name = "b", descriptor = "(I)V")
    public static void method7704() {
        if (!Static60.aBoolean86) {
            return;
        }
        while (true) {
            while (WorldList.activeWorlds.length > Static419.anInt6434) {
                @Pc(26) GameWorld local26 = WorldList.activeWorlds[Static419.anInt6434];
                if (local26 != null && local26.ping == -1) {
                    if (Static522.aClass2_Sub12_4 == null) {
                        Static522.aClass2_Sub12_4 = Static151.aClass226_20.method5245(local26.address);
                    }
                    @Pc(54) int local54 = Static522.aClass2_Sub12_4.anInt1631;
                    if (local54 == -1) {
                        return;
                    }
                    Static419.anInt6434++;
                    Static522.aClass2_Sub12_4 = null;
                    local26.ping = local54;
                } else {
                    Static419.anInt6434++;
                }
            }
            return;
        }
    }

    @OriginalMember(owner = "client!sia", name = "g", descriptor = "(I)[Lclient!oga;")
    public static DisplayProperties[] method7710() {
        if (Static679.aDisplayPropertiesArray1 == null) {
            @Pc(20) DisplayProperties[] local20 = SignLink.getDisplayProperties(GameShell.signLink, true);
            @Pc(24) DisplayProperties[] local24 = new DisplayProperties[local20.length];
            @Pc(26) int local26 = 0;
            @Pc(31) int maxScreenSize = ClientOptions.instance.maxScreenSize.getValue();
            @Pc(112) int local112;
            @Pc(117) DisplayProperties local117;
            label69:
            for (@Pc(33) int local33 = 0; local33 < local20.length; local33++) {
                @Pc(38) DisplayProperties local38 = local20[local33];
                if ((local38.oldWidth <= 0 || local38.oldWidth >= 24) && local38.width >= 800 && local38.height >= 600 && (maxScreenSize != MaxScreenSize._800x600 || local38.width <= 800 && local38.height <= 600) && (maxScreenSize != MaxScreenSize._1024x768 || local38.width <= 1024 && local38.height <= 768)) {
                    for (local112 = 0; local112 < local26; local112++) {
                        local117 = local24[local112];
                        if (local38.width == local117.width && local38.height == local117.height) {
                            if (local117.oldWidth < local38.oldWidth) {
                                local24[local112] = local38;
                            }
                            continue label69;
                        }
                    }
                    local24[local26] = local38;
                    local26++;
                }
            }
            Static679.aDisplayPropertiesArray1 = new DisplayProperties[local26];
            Arrays.copy(local24, 0, Static679.aDisplayPropertiesArray1, 0, local26);
            @Pc(175) int[] local175 = new int[Static679.aDisplayPropertiesArray1.length];
            for (local112 = 0; local112 < Static679.aDisplayPropertiesArray1.length; local112++) {
                local117 = Static679.aDisplayPropertiesArray1[local112];
                local175[local112] = local117.height * local117.width;
            }
            Static510.method6763(Static679.aDisplayPropertiesArray1, local175);
        }
        return Static679.aDisplayPropertiesArray1;
    }
}
