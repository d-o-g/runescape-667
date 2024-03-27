import com.jagex.LibraryList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.Loader;
import rs2.client.loading.LoadingRequirementType;

@OriginalClass("client!cha")
public final class LibraryLoader implements Loader {

    @OriginalMember(owner = "client!cha", name = "g", descriptor = "Z")
    public boolean done;

    @OriginalMember(owner = "client!cha", name = "b", descriptor = "Ljava/lang/String;")
    public final String name;

    @OriginalMember(owner = "client!cha", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public LibraryLoader(@OriginalArg(0) String name) {
        this.name = name;
    }

    @OriginalMember(owner = "client!cha", name = "a", descriptor = "(I)I")
    @Override
    public int completePercentage() {
        if (this.done) {
            return 100;
        }

        @Pc(14) int percentage = LibraryList.loadLibrary(this.name);
        if (percentage >= 0 && percentage <= 100) {
            return percentage;
        } else {
            this.done = true;
            return 100;
        }
    }

    @OriginalMember(owner = "client!cha", name = "c", descriptor = "(I)Z")
    public boolean isDone() {
        return this.done;
    }

    @OriginalMember(owner = "client!cha", name = "a", descriptor = "(B)Lclient!kf;")
    @Override
    public LoadingRequirementType type() {
        return LoadingRequirementType.NATIVE_LIBRARY;
    }
}
