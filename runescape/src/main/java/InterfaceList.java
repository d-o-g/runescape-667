import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class InterfaceList {

    @OriginalMember(owner = "client!of", name = "z", descriptor = "[[Lclient!hda;")
    public static Component[][] interfaces;

    @OriginalMember(owner = "client!ec", name = "G", descriptor = "[Z")
    public static boolean[] loaded;

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(BI)Lclient!hda;")
    public static Component list(@OriginalArg(1) int idAndSlot) {
        @Pc(16) int id = idAndSlot >> 16;
        @Pc(20) int slot = idAndSlot & 0xFFFF;

        if (interfaces[id] == null || interfaces[id][slot] == null) {
            @Pc(38) boolean loaded = load(id);

            if (!loaded) {
                return null;
            }
        }

        return interfaces[id][slot];
    }

    @OriginalMember(owner = "client!rw", name = "d", descriptor = "(II)Z")
    public static boolean load(@OriginalArg(1) int id) {
        if (loaded[id]) {
            return true;
        } else if (Component.interfacesJs5.requestgroupdownload(id)) {
            @Pc(25) int slots = Component.interfacesJs5.fileLimit(id);
            if (slots == 0) {
                loaded[id] = true;
                return true;
            }

            if (interfaces[id] == null) {
                interfaces[id] = new Component[slots];
            }

            for (@Pc(53) int slot = 0; slot < slots; slot++) {
                if (interfaces[id][slot] == null) {
                    @Pc(66) byte[] data = Component.interfacesJs5.getfile(slot, id);

                    if (data != null) {
                        @Pc(78) Component component = interfaces[id][slot] = new Component();
                        component.slot = slot + (id << 16);

                        if (data[0] != -1) {
                            throw new IllegalStateException("if1");
                        }

                        component.decode(new Packet(data));
                    }
                }
            }

            loaded[id] = true;
            return true;
        } else {
            return false;
        }
    }

    private InterfaceList() {
        /* empty */
    }

    @OriginalMember(owner = "client!aia", name = "a", descriptor = "(III)Lclient!hda;")
    public static Component getComponent(@OriginalArg(1) int component, @OriginalArg(2) int id) {
        @Pc(21) Component inter = list(id);

        if (component == -1) {
            return inter;
        } else if (inter != null && inter.staticComponents != null && component < inter.staticComponents.length) {
            return inter.staticComponents[component];
        } else {
            return null;
        }
    }
}
