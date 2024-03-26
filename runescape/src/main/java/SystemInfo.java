import com.jagex.game.runetek6.client.GameShell;
import com.jagex.SignLink;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import jaclib.hardware_info.HardwareInfo;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pw")
public final class SystemInfo extends Node {

    public static final int OS_TYPE_WINDOWS = 1;

    public static final int OS_TYPE_MAC = 2;

    public static final int OS_TYPE_LINUX = 3;

    public static final int OS_TYPE_UNKNOWN = 4;

    public static final int OS_VERSION_WINDOWS_4_0 = 1;

    public static final int OS_VERSION_WINDOWS_4_1 = 2;

    public static final int OS_VERSION_WINDOWS_4_9 = 3;

    public static final int OS_VERSION_WINDOWS_5_0 = 4;

    public static final int OS_VERSION_WINDOWS_5_1 = 5;

    public static final int OS_VERSION_WINDOWS_6_0 = 6;

    public static final int OS_VERSION_WINDOWS_6_1 = 7;

    public static final int OS_VERSION_MAC_10_4 = 20;

    public static final int OS_VERSION_MAC_10_5 = 21;

    public static final int OS_VERSION_MAC_10_6 = 22;

    public static final int OS_VERSION_MAC_10_7 = 23;

    public static final int JAVA_VENDOR_SUN = 1;

    public static final int JAVA_VENDOR_MICROSOFT = 2;

    public static final int JAVA_VENDOR_APPLE = 4;

    public static final int JAVA_VENDOR_UNKNOWN = 3;

    @OriginalMember(owner = "client!jea", name = "m", descriptor = "Lclient!pw;")
    public static SystemInfo instance;

    @OriginalMember(owner = "client!pw", name = "M", descriptor = "I")
    public int anInt7598;

    @OriginalMember(owner = "client!pw", name = "E", descriptor = "Ljava/lang/String;")
    public String aString92;

    @OriginalMember(owner = "client!pw", name = "y", descriptor = "I")
    public int javaVersion;

    @OriginalMember(owner = "client!pw", name = "N", descriptor = "I")
    public int javaRelease;

    @OriginalMember(owner = "client!pw", name = "J", descriptor = "Z")
    public boolean is64bit;

    @OriginalMember(owner = "client!pw", name = "D", descriptor = "Ljava/lang/String;")
    public String aString93;

    @OriginalMember(owner = "client!pw", name = "z", descriptor = "I")
    public int anInt7604;

    @OriginalMember(owner = "client!pw", name = "A", descriptor = "I")
    public int anInt7605;

    @OriginalMember(owner = "client!pw", name = "w", descriptor = "I")
    public int javaUpdate;

    @OriginalMember(owner = "client!pw", name = "F", descriptor = "I")
    public int processorCount;

    @OriginalMember(owner = "client!pw", name = "u", descriptor = "Ljava/lang/String;")
    public String aString94;

    @OriginalMember(owner = "client!pw", name = "L", descriptor = "I")
    public int totalMemory;

    @OriginalMember(owner = "client!pw", name = "r", descriptor = "I")
    public int osType;

    @OriginalMember(owner = "client!pw", name = "O", descriptor = "Ljava/lang/String;")
    public String aString95;

    @OriginalMember(owner = "client!pw", name = "s", descriptor = "I")
    public int osVersion;

    @OriginalMember(owner = "client!pw", name = "x", descriptor = "Z")
    public boolean unsigned;

    @OriginalMember(owner = "client!pw", name = "o", descriptor = "I")
    public int heapSize;

    @OriginalMember(owner = "client!pw", name = "n", descriptor = "I")
    public int anInt7614;

    @OriginalMember(owner = "client!pw", name = "K", descriptor = "I")
    public int anInt7615;

    @OriginalMember(owner = "client!pw", name = "k", descriptor = "I")
    public int anInt7616;

    @OriginalMember(owner = "client!pw", name = "H", descriptor = "I")
    public int javaVendor;

    @OriginalMember(owner = "client!pw", name = "<init>", descriptor = "()V")
    public SystemInfo() {
    }

    @OriginalMember(owner = "client!pw", name = "<init>", descriptor = "(ZLclient!vq;)V")
    public SystemInfo(@OriginalArg(0) boolean arg0, @OriginalArg(1) SignLink signLink) {
        if (SignLink.osNameLower.startsWith("win")) {
            this.osType = OS_TYPE_WINDOWS;
        } else if (SignLink.osNameLower.startsWith("mac")) {
            this.osType = OS_TYPE_MAC;
        } else if (SignLink.osNameLower.startsWith("linux")) {
            this.osType = OS_TYPE_LINUX;
        } else {
            this.osType = OS_TYPE_UNKNOWN;
        }

        if (SignLink.osArchRaw.startsWith("amd64") || SignLink.osArchRaw.startsWith("x86_64")) {
            this.is64bit = true;
        } else {
            this.is64bit = false;
        }

        if (this.osType == OS_TYPE_WINDOWS) {
            if (SignLink.osVersionRaw.indexOf("4.0") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_4_0;
            } else if (SignLink.osVersionRaw.indexOf("4.1") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_4_1;
            } else if (SignLink.osVersionRaw.indexOf("4.9") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_4_9;
            } else if (SignLink.osVersionRaw.indexOf("5.0") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_5_0;
            } else if (SignLink.osVersionRaw.indexOf("5.1") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_5_1;
            } else if (SignLink.osVersionRaw.indexOf("6.0") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_6_0;
            } else if (SignLink.osVersionRaw.indexOf("6.1") != -1) {
                this.osVersion = OS_VERSION_WINDOWS_6_1;
            }
        } else if (this.osType == OS_TYPE_MAC) {
            if (SignLink.osVersionRaw.indexOf("10.4") != -1) {
                this.osVersion = OS_VERSION_MAC_10_4;
            } else if (SignLink.osVersionRaw.indexOf("10.5") != -1) {
                this.osVersion = OS_VERSION_MAC_10_5;
            } else if (SignLink.osVersionRaw.indexOf("10.6") != -1) {
                this.osVersion = OS_VERSION_MAC_10_6;
            } else if (SignLink.osVersionRaw.indexOf("10.7") != -1) {
                this.osVersion = OS_VERSION_MAC_10_7;
            }
        }

        if (SignLink.javaVendor.toLowerCase().indexOf("sun") != -1) {
            this.javaVendor = JAVA_VENDOR_SUN;
        } else if (SignLink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
            this.javaVendor = JAVA_VENDOR_MICROSOFT;
        } else if (SignLink.javaVendor.toLowerCase().indexOf("apple") == -1) {
            this.javaVendor = JAVA_VENDOR_APPLE;
        } else {
            this.javaVendor = JAVA_VENDOR_UNKNOWN;
        }

        @Pc(334) int javaRelease = 0;
        try {
            for (@Pc(332) int i = SignLink.javaVersion.startsWith("1.") ? 2 : 0; i < SignLink.javaVersion.length(); i++) {
                @Pc(340) char c = SignLink.javaVersion.charAt(i);
                if (c < '0' || c > '9') {
                    break;
                }

                javaRelease = ((javaRelease * 10) + c) - '0';
            }
        } catch (@Pc(372) Exception ignored) {
            /* empty */
        }
        this.javaRelease = javaRelease;

        @Pc(334) int javaVersion = 0;
        try {
            for (@Pc(332) int i = SignLink.javaVersion.indexOf(46, 2) + 1; i < SignLink.javaVersion.length(); i++) {
                @Pc(340) char c = SignLink.javaVersion.charAt(i);
                if (c < '0' || c > '9') {
                    break;
                }

                javaVersion = (c + (javaVersion * 10)) - '0';
            }
        } catch (@Pc(422) Exception ignored) {
            /* empty */
        }
        this.javaVersion = javaVersion;

        @Pc(334) int javaUpdate = 0;
        try {
            for (@Pc(332) int i = SignLink.javaVersion.indexOf(95, 4) + 1; i < SignLink.javaVersion.length(); i++) {
                @Pc(340) char c = SignLink.javaVersion.charAt(i);
                if (c < '0' || c > '9') {
                    break;
                }

                javaUpdate = ((javaUpdate * 10) + c) - '0';
            }
        } catch (@Pc(470) Exception ignored) {
            /* empty */
        }
        this.javaUpdate = javaUpdate;

        if (this.javaRelease > 3) {
            this.processorCount = GameShell.cpucount;
        } else {
            this.processorCount = 0;
        }

        this.heapSize = GameShell.maxmemory;

        if (signLink.signed) {
            this.unsigned = false;
        } else {
            this.unsigned = true;
        }

        try {
            @Pc(511) int[] cpuInfo = HardwareInfo.getCPUInfo();
            if (cpuInfo != null && cpuInfo.length == 7) {
                this.anInt7604 = cpuInfo[2];
                this.anInt7598 = cpuInfo[5];
                this.totalMemory = cpuInfo[6];
                this.anInt7614 = cpuInfo[4];
                this.anInt7605 = cpuInfo[3];
            }
        } catch (@Pc(548) Throwable local548) {
            this.totalMemory = 0;
        }

        if (this.aString92 == null) {
            this.aString92 = "";
        }
        if (this.aString95 == null) {
            this.aString95 = "";
        }
        if (this.aString93 == null) {
            this.aString93 = "";
        }
        if (this.aString94 == null) {
            this.aString94 = "";
        }

        this.trim();
    }

    @OriginalMember(owner = "client!pw", name = "a", descriptor = "(Z)V")
    public void trim() {
        if (this.aString95.length() > 40) {
            this.aString95 = this.aString95.substring(0, 40);
        }
        if (this.aString93.length() > 40) {
            this.aString93 = this.aString93.substring(0, 40);
        }
        if (this.aString94.length() > 10) {
            this.aString94 = this.aString94.substring(0, 10);
        }
        if (this.aString92.length() > 10) {
            this.aString92 = this.aString92.substring(0, 10);
        }
    }

    @OriginalMember(owner = "client!pw", name = "a", descriptor = "(Lclient!ge;I)V")
    public void encode(@OriginalArg(0) Packet packet) {
        packet.p1(5);
        packet.p1(this.osType);
        packet.p1(this.is64bit ? 1 : 0);
        packet.p1(this.osVersion);
        packet.p1(this.javaVendor);
        packet.p1(this.javaRelease);
        packet.p1(this.javaVersion);
        packet.p1(this.javaUpdate);
        packet.p1(this.unsigned ? 1 : 0);
        packet.p2(this.heapSize);
        packet.p1(this.processorCount);
        packet.p3(this.totalMemory);
        packet.p2(this.anInt7604);
        packet.p1(this.anInt7605);
        packet.p1(this.anInt7614);
        packet.p1(this.anInt7598);
        packet.pjstr2(this.aString95);
        packet.pjstr2(this.aString93);
        packet.pjstr2(this.aString94);
        packet.pjstr2(this.aString92);
        packet.p1(this.anInt7615);
        packet.p2(this.anInt7616);
    }

    @OriginalMember(owner = "client!pw", name = "b", descriptor = "(B)I")
    public int size() {
        int size = 23;
        /* @formatter:off */
        @Pc(18) int size1 = size+ Packet.pjstr2len(this.aString95);
        @Pc(25) int size2 = size1 + Packet.pjstr2len(this.aString93);
        @Pc(32) int size3 = size2 + Packet.pjstr2len(this.aString94);
                int size4 = size3 + Packet.pjstr2len(this.aString92);
        /* @formatter:on */
        return size4;
    }
}
