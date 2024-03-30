import com.jagex.graphics.MemoryPool;
import jaclib.memory.heap.NativeHeap;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cla")
public final class GlMemoryPool extends MemoryPool {

    @OriginalMember(owner = "client!cla", name = "n", descriptor = "Lclient!jaclib/memory/heap/NativeHeap;")
    public final NativeHeap heap;

    @OriginalMember(owner = "client!cla", name = "<init>", descriptor = "(I)V")
    public GlMemoryPool(@OriginalArg(0) int arg0) {
        this.heap = new NativeHeap(arg0);
    }

    @OriginalMember(owner = "client!cla", name = "a", descriptor = "(Z)V")
    public void deallocate() {
        this.heap.b();
    }
}
