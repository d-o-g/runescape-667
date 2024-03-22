import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.Loader;
import rs2.client.loading.LoadingRequirementType;

@OriginalClass("client!pca")
public final class Js5FileLoader implements Loader {

    @OriginalMember(owner = "client!pca", name = "h", descriptor = "Lclient!sb;")
    public final js5 config;

    @OriginalMember(owner = "client!pca", name = "c", descriptor = "Ljava/lang/String;")
    public final String fileName;

    @OriginalMember(owner = "client!pca", name = "<init>", descriptor = "(Lclient!sb;Ljava/lang/String;)V")
    public Js5FileLoader(@OriginalArg(0) js5 config, @OriginalArg(1) String fileName) {
        this.config = config;
        this.fileName = fileName;
    }

    @OriginalMember(owner = "client!pca", name = "a", descriptor = "(I)I")
    @Override
    public int completePercentage() {
        return this.config.fileready(this.fileName) ? 100 : 0;
    }

    @OriginalMember(owner = "client!pca", name = "a", descriptor = "(B)Lclient!kf;")
    @Override
    public LoadingRequirementType type() {
        return LoadingRequirementType.JS5_FILE;
    }
}
