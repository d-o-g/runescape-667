import com.jagex.SignedResource;
import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vs")
public final class ReflectionCheck extends Node {

    @OriginalMember(owner = "client!vs", name = "r", descriptor = "[Lclient!oba;")
    public SignedResource[] field;

    @OriginalMember(owner = "client!vs", name = "v", descriptor = "I")
    public int memberCount;

    @OriginalMember(owner = "client!vs", name = "n", descriptor = "[[[B")
    public byte[][][] arguments;

    @OriginalMember(owner = "client!vs", name = "u", descriptor = "[I")
    public int[] fieldValues;

    @OriginalMember(owner = "client!vs", name = "k", descriptor = "[I")
    public int[] memberTypes;

    @OriginalMember(owner = "client!vs", name = "w", descriptor = "[I")
    public int[] status;

    @OriginalMember(owner = "client!vs", name = "q", descriptor = "[Lclient!oba;")
    public SignedResource[] methods;

    @OriginalMember(owner = "client!vs", name = "l", descriptor = "I")
    public int magic;
}
