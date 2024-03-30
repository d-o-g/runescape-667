import com.jagex.graphics.MemoryPool;
import jaclib.memory.heap.NativeHeap;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dia")
public final class NativeMemoryPool extends MemoryPool {

    @OriginalMember(owner = "client!dia", name = "p", descriptor = "Lclient!jaclib/memory/heap/NativeHeap;")
    public final NativeHeap heap;

    @OriginalMember(owner = "client!dia", name = "<init>", descriptor = "(I)V")
    public NativeMemoryPool(@OriginalArg(0) int arg0) {
        this.heap = new NativeHeap(arg0);
    }

    @OriginalMember(owner = "client!dia", name = "b", descriptor = "(B)V")
    public void deallocate() {
        this.heap.b();
    }
}
