package com.jagex;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public final class Messages {

    public static final String JS5_KEY_READING = "Reading JS5 public key from: %s";

    public static final String LOGIN_KEY_READING = "Reading login public key from: %s";

    public static final String JAWT_FAILED = "Failed to load jawt.dll - only safe mode will function. Try reinstalling Java.";

    public static String formatAbsolute(String format, Path path) {
        return String.format(format, asClickableFileUrl(path.toAbsolutePath().normalize()));
    }

    private static String asClickableFileUrl(Path path) {
        try {
            return new URI(
                /* scheme = */ "file",
                /* authority = */ "",
                /* path = */ path.toUri().getPath(),
                /* query = */ null,
                /* fragment = */ null
            ).toASCIIString();
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Messages() {
        /* empty */
    }
}
