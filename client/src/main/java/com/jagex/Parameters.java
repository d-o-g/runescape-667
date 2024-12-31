package com.jagex;

import java.util.HashMap;
import java.util.Map;

public final class Parameters {

    public static Map<String, String> createDefault() {
        var parameters = new HashMap<String, String>();

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

        return parameters;
    }

    private Parameters() {
        /* empty */
    }
}
