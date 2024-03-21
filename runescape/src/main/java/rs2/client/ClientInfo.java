package rs2.client;

import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.File;

public final class ClientInfo {

    @OriginalMember(owner = "client!nba", name = "l", descriptor = "Ljava/lang/String;")
    public static final String osName;

    @OriginalMember(owner = "client!nba", name = "d", descriptor = "Ljava/lang/String;")
    public static final String osArch;

    private static final String javaVendor;

    private static final String javaVersion;

    private static final String osVersion;

    private static final File userHome;

    static {
        @Pc(63) String property = "Unknown";
        try {
            property = System.getProperty("java.vendor").toLowerCase();
        } catch (@Pc(71) Exception ignored) {
            /* empty */
        }

        javaVendor = property.toLowerCase();
        property = "Unknown";

        try {
            property = System.getProperty("java.version").toLowerCase();
        } catch (@Pc(86) Exception ignored) {
            /* empty */
        }
        javaVersion = property.toLowerCase();
        property = "Unknown";

        try {
            property = System.getProperty("os.name").toLowerCase();
        } catch (@Pc(101) Exception ignored) {
            /* empty */
        }
        osName = property.toLowerCase();
        property = "Unknown";

        try {
            property = System.getProperty("os.arch").toLowerCase();
        } catch (@Pc(116) Exception ignored) {
            /* empty */
        }
        osArch = property.toLowerCase();
        property = "Unknown";

        try {
            property = System.getProperty("os.version").toLowerCase();
        } catch (@Pc(131) Exception ignored) {
            /* empty */
        }
        osVersion = property.toLowerCase();
        property = "~/";

        try {
            property = System.getProperty("user.home").toLowerCase();
        } catch (@Pc(146) Exception ignored) {
            /* empty */
        }

        userHome = new File(property);
    }

    private ClientInfo() {
        /* empty */
    }
}
