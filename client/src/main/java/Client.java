import com.jagex.awt.CloseWindowListener;
import com.jagex.crypto.rsa.RsaPublicKeyReader;
import com.jagex.game.runetek6.client.GameShell;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.jagex.Messages.FIRST_PATH_MISSING;
import static com.jagex.Messages.JAWT_FAILED;
import static com.jagex.Messages.JS5_KEY_READING;
import static com.jagex.Messages.LOGIN_KEY_READING;
import static com.jagex.Messages.LOGIN_KEY_REUSING_JS5;
import static com.jagex.Messages.PUBLIC_KEY_NOT_FOUND;
import static com.jagex.awt.Dimensions.MINIMUM_SIZE;
import static com.jagex.awt.Dimensions.PREFERRED_SIZE;

public final class Client implements AppletStub {

    public static void main(String[] args) {
        try {
            setPublicKeys(args);
            loadJawtCatching();

            URL url = new URL("http://127.0.0.1/");
            Client client = new Client(url);
            client.start();
        } catch (Throwable t) {
            System.out.println("Failed to start client:");
            t.printStackTrace();
        }
    }

    private static void setPublicKeys(String[] args) throws IOException {
        var firstPath = optionalPathFrom(args, 0).orElseThrow(() -> new IOException(FIRST_PATH_MISSING));
        var js5Msg = String.format(JS5_KEY_READING, firstPath);
        System.out.println(js5Msg);

        var secondPath = optionalPathFrom(args, 1);
        var loginMsg = secondPath.map(path -> String.format(LOGIN_KEY_READING, path)).orElse(LOGIN_KEY_REUSING_JS5);
        System.out.println(loginMsg);

        var js5 = RsaPublicKeyReader.read(firstPath);
        Static442.JS5_RSA_EXPONENT = js5.getExponent();
        Static670.JS5_RSA_MODULUS = js5.getModulus();

        var login = secondPath.map(RsaPublicKeyReader::readUnchecked).orElse(js5);
        LoginManager.RSA_EXPONENT = login.getExponent();
        LoginManager.RSA_MODULUS = login.getModulus();
    }

    private static Optional<Path> optionalPathFrom(String[] args, int index) throws IOException {
        if (args.length > index) {
            var arg = args[index];
            var path = Paths.get(arg);
            checkPublicKeyExists(path);
            return Optional.of(path);
        } else {
            return Optional.empty();
        }
    }

    private static void checkPublicKeyExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new IOException(String.format(PUBLIC_KEY_NOT_FOUND, path));
        }
    }

    private static void loadJawtCatching() {
        try {
            System.loadLibrary("jawt");
        } catch (Throwable t) {
            String os = System.getProperty("os.name");

            if (os.toLowerCase().contains("windows")) {
                System.err.println(JAWT_FAILED);
                t.printStackTrace();
            }
        }
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
