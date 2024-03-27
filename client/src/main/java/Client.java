import com.jagex.game.runetek6.client.GameShell;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class Client implements AppletStub {
    private static final Dimension MINIMUM_SIZE = new Dimension(765, 503);
    private static final Dimension PREFERRED_SIZE = new Dimension(1024, 768);

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Provide path to public key as first program argument");
            System.exit(1);
        }

        Path publicKeyPath = Paths.get(args[0]);
        if (!Files.exists(publicKeyPath)) {
            System.err.println("No public key file found at: " + publicKeyPath);
            System.exit(1);
        }

        System.out.println("Reading public key from: " + publicKeyPath);

        RsaKeyPair keyPair = RsaKeyPair.read(publicKeyPath);
        LoginManager.RSA_EXPONENT = keyPair.getExponent();
        LoginManager.RSA_MODULUS = keyPair.getModulus();
        Static442.JS5_RSA_EXPONENT = keyPair.getExponent();
        Static670.JS5_RSA_MODULUS = keyPair.getModulus();

        try {
            System.loadLibrary("jawt");
        } catch (Throwable t) {
            String os = System.getProperty("os.name");

            if (os.toLowerCase().contains("windows")) {
                System.err.println("Failed to load jawt.dll - only safe mode will function. Try reinstalling Java.");
                t.printStackTrace();
            }
        }

        Client client = new Client(new URL("http://127.0.0.1/"));
        client.start();
    }

    private final Frame frame = new Frame("Jagex");
    private final Applet applet = new Applet();
    private final Map<String, String> parameters = new HashMap<>();
    private final URL url;

    private Client(URL url) {
        this.url = url;

        parameters.put("cabbase", "g.cab");
        parameters.put("java_arguments", "-Xmx256m -Dsun.java2d.noddraw=true");
        parameters.put("colourid", "0");
        parameters.put("worldid", "1");
        parameters.put("lobbyid", "1000");
        parameters.put("lobbyaddress", "127.0.0.1");
        parameters.put("demoid", "0");
        parameters.put("demoaddress", "");
        parameters.put("modewhere", "1");
        parameters.put("modewhat", "0");
        parameters.put("lang", "0");
        parameters.put("objecttag", "0");
        parameters.put("js", "1");
        parameters.put("game", "0");
        parameters.put("affid", "0");
        parameters.put("advert", "1");
        parameters.put("settings", "wwGlrZHF5gJcZl7tf7KSRh0MZLhiU0gI0xDX6DwZ-Qk");
        parameters.put("country", "0");
        parameters.put("haveie6", "0");
        parameters.put("havefirefox", "1");
        parameters.put("cookieprefix", "");
        parameters.put("cookiehost", "127.0.0.1");
        parameters.put("cachesubdirid", "0");
        parameters.put("crashurl", "");
        parameters.put("unsignedurl", "");
        parameters.put("sitesettings_member", "1");
        parameters.put("frombilling", "false");
        parameters.put("sskey", "");
        parameters.put("force64mb", "false");
        parameters.put("worldflags", "8");
    }

    private void start() {
        applet.setStub(this);
        applet.setBackground(Color.BLACK);

        applet.setMinimumSize(MINIMUM_SIZE);
        applet.setPreferredSize(MINIMUM_SIZE);
        applet.setSize(MINIMUM_SIZE);

        GameShell.provideLoaderApplet(applet);

        client c = new client();
        c.init();
        c.start();

        frame.add(applet);
        frame.addWindowListener(new CloseWindowListener());
        frame.pack();

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.toFront();

        frame.setMinimumSize(frame.getSize());
        frame.setPreferredSize(PREFERRED_SIZE);
        frame.setSize(PREFERRED_SIZE);
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public URL getDocumentBase() {
        return url;
    }

    @Override
    public URL getCodeBase() {
        return url;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {
        /* empty */
    }
}
