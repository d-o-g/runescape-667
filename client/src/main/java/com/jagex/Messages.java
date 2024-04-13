package com.jagex;

public final class Messages {

    public static final String FIRST_PATH_MISSING = "Provide path to public RSA key as first program argument";

    public static final String PUBLIC_KEY_NOT_FOUND = "No public key file found at: file://%s";

    public static final String JS5_KEY_READING = "JS5 public key reading from: file://%s";

    public static final String LOGIN_KEY_READING = "Login public key reading from: file://%s";

    public static final String LOGIN_KEY_REUSING_JS5 = "Login public key reusing JS5 public key";

    public static final String JAWT_FAILED = "Failed to load jawt.dll - only safe mode will function. Try reinstalling Java.";

    private Messages() {
        /* empty */
    }
}
