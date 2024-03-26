package rs2.client.web;

import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.SignedResourceStatus;
import com.jagex.core.util.JavaScript;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.net.URL;

public final class ClientURLTools {

    @OriginalMember(owner = "client!ija", name = "j", descriptor = "Lclient!vq;")
    private static SignLink windowsSignLink;

    @OriginalMember(owner = "client!kn", name = "h", descriptor = "Ljava/lang/String;")
    private static String windowsPage;

    @OriginalMember(owner = "client!hfa", name = "w", descriptor = "Lclient!oba;")
    private static SignedResource windowsSignedResource;

    @OriginalMember(owner = "client!uc", name = "a", descriptor = "(Ljava/lang/String;IILclient!vq;)Lclient!oba;")
    public static SignedResource openURL(@OriginalArg(0) String page, @OriginalArg(2) int type, @OriginalArg(3) SignLink signLink) {
        return openURL(signLink, page, "openjs", type);
    }

    @OriginalMember(owner = "client!bda", name = "a", descriptor = "(BLclient!vq;Ljava/lang/String;Ljava/lang/String;I)Lclient!oba;")
    public static SignedResource openURL(@OriginalArg(1) SignLink signLink, @OriginalArg(2) String page, @OriginalArg(3) String function, @OriginalArg(4) int type) {
        if (type == OpenUrlType.OPEN_PAGE) {
            return signLink.openurl(page);
        }

        if (type == OpenUrlType.CALL) {
            try {
                @Pc(36) Object object = JavaScript.call(GameShell.loaderApplet, function, new Object[]{(new URL(GameShell.loaderApplet.getCodeBase(), page)).toString()});
                if (object == null) {
                    throw new RuntimeException();
                }

                @Pc(47) SignedResource resource = new SignedResource();
                resource.status = SignedResourceStatus.SUCCESS;
                return resource;
            } catch (@Pc(53) Throwable ignored) {
                @Pc(57) SignedResource resource = new SignedResource();
                resource.status = SignedResourceStatus.ERROR;
                return resource;
            }
        } else if (type == OpenUrlType.OPEN_IN_NEW_TAB) {
            try {
                GameShell.loaderApplet.getAppletContext().showDocument(new URL(GameShell.loaderApplet.getCodeBase(), page), "_blank");

                @Pc(57) SignedResource resource = new SignedResource();
                resource.status = SignedResourceStatus.SUCCESS;
                return resource;
            } catch (@Pc(94) Exception ignored) {
                @Pc(57) SignedResource resource = new SignedResource();
                resource.status = SignedResourceStatus.ERROR;
                return resource;
            }
        } else if (type == OpenUrlType.REPLACE) {
            try {
                JavaScript.call("loggedout", GameShell.loaderApplet);
            } catch (@Pc(115) Throwable ignored) {
                /* empty */
            }

            try {
                GameShell.loaderApplet.getAppletContext().showDocument(new URL(GameShell.loaderApplet.getCodeBase(), page), "_top");

                @Pc(57) SignedResource resource = new SignedResource();
                resource.status = SignedResourceStatus.SUCCESS;
                return resource;
            } catch (@Pc(137) Exception ignored) {
                @Pc(57) SignedResource resource = new SignedResource();
                resource.status = SignedResourceStatus.ERROR;
                return resource;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!ia", name = "a", descriptor = "(ILjava/lang/String;Ljava/lang/String;Lclient!vq;ZZ)V")
    public static void openURL(@OriginalArg(1) String page, @OriginalArg(2) String function, @OriginalArg(3) SignLink signLink, @OriginalArg(4) boolean glToolkit, @OriginalArg(5) boolean loggedIn) {
        if (loggedIn) {
            if (SignLink.osNameLower.startsWith("win") && signLink.signed) {
                @Pc(31) String haveie6 = null;
                if (GameShell.loaderApplet != null) {
                    haveie6 = GameShell.loaderApplet.getParameter("haveie6");
                }

                if (haveie6 == null || !haveie6.equals("1")) {
                    @Pc(53) SignedResource resource = openURL(page, OpenUrlType.OPEN_PAGE, signLink);
                    windowsSignLink = signLink;
                    windowsPage = page;
                    windowsSignedResource = resource;
                    return;
                }
            }

            if (SignLink.osNameLower.startsWith("mac")) {
                @Pc(31) String havefirefox = null;
                if (GameShell.loaderApplet != null) {
                    havefirefox = GameShell.loaderApplet.getParameter("havefirefox");
                }

                if (havefirefox != null && havefirefox.equals("1") && glToolkit) {
                    openURL(signLink, page, function, OpenUrlType.CALL);
                    return;
                }
            }

            openURL(page, OpenUrlType.OPEN_IN_NEW_TAB, signLink);
        } else {
            openURL(page, OpenUrlType.REPLACE, signLink);
        }
    }

    @OriginalMember(owner = "client!wia", name = "a", descriptor = "(B)V")
    public static void tick() {
        if (windowsSignedResource == null) {
            return;
        }
        if (windowsSignedResource.status == SignedResourceStatus.SUCCESS) {
            windowsSignedResource = null;
            return;
        }
        if (windowsSignedResource.status == SignedResourceStatus.ERROR) {
            openURL(windowsPage, OpenUrlType.OPEN_IN_NEW_TAB, windowsSignLink);
            windowsSignedResource = null;
        }
    }

    private ClientURLTools() {
        /* empty */
    }
}
