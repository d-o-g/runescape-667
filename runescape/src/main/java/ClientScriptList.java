import com.jagex.core.datastruct.key.LruCache;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ClientScriptList {

    @OriginalMember(owner = "client!pca", name = "i", descriptor = "Lclient!ts;")
    public static final LruCache cache = new LruCache(128);

    @OriginalMember(owner = "client!pga", name = "a", descriptor = "(II)Lclient!fj;")
    public static ClientScript list(@OriginalArg(0) int id) {
        @Pc(10) ClientScript script = (ClientScript) cache.get(id);
        if (script != null) {
            return script;
        }

        @Pc(21) byte[] data = js5.CLIENTSCRIPTS.getfile(0, id);
        if (data == null || data.length <= 1) {
            return null;
        }

        try {
            script = ClientScript.decode(data);
        } catch (@Pc(38) Exception cause) {
            throw new RuntimeException(cause.getMessage() + " S: " + id);
        }

        cache.put(script, id);
        return script;
    }

    @OriginalMember(owner = "client!qu", name = "a", descriptor = "(Lclient!mia;III)Lclient!fj;")
    public static ClientScript trigger(@OriginalArg(0) ClientTriggerType type, @OriginalArg(1) int v1, @OriginalArg(2) int v2) {
        @Pc(10) int id = type.id | (v1 << 10);
        @Pc(19) ClientScript script = (ClientScript) cache.get((long) id << 16);
        if (script != null) {
            return script;
        }

        @Pc(32) byte[] data = js5.CLIENTSCRIPTS.getfile(js5.CLIENTSCRIPTS.getgroupid(id));
        if (data != null) {
            if (data.length > 1) {
                try {
                    script = ClientScript.decode(data);
                } catch (@Pc(51) Exception local51) {
                    throw new RuntimeException(local51.getMessage() + " S: " + id);
                }

                script.triggerType = type;
                cache.put(script, (long) id << 16);
                return script;
            }
        } else {
            id = v2 + 65536 << 10 | type.id;
            script = (ClientScript) cache.get((long) id << 16);
            if (script != null) {
                return script;
            }

            data = js5.CLIENTSCRIPTS.getfile(js5.CLIENTSCRIPTS.getgroupid(id));
            if (data != null) {
                if (data.length > 1) {
                    try {
                        script = ClientScript.decode(data);
                    } catch (@Pc(135) Exception local135) {
                        throw new RuntimeException(local135.getMessage() + " S: " + id);
                    }

                    script.triggerType = type;
                    cache.put(script, (long) id << 16);
                    return script;
                }
            } else {
                id = type.id | 0x3FFFC00;
                script = (ClientScript) cache.get((long) id << 16);
                if (script != null) {
                    return script;
                }

                data = js5.CLIENTSCRIPTS.getfile(js5.CLIENTSCRIPTS.getgroupid(id));
                if (data != null) {
                    if (data.length > 1) {
                        try {
                            script = ClientScript.decode(data);
                        } catch (@Pc(211) Exception cause) {
                            throw new RuntimeException(cause.getMessage() + " S: " + id);
                        }

                        script.triggerType = type;
                        cache.put(script, (long) id << 16);
                        return script;
                    }
                }
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!iha", name = "a", descriptor = "(Z)V")
    public static void cacheReset() {
        cache.clear();
    }
}
