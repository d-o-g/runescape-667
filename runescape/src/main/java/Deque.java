import com.jagex.collect.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sia")
public final class Deque {

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "Lclient!ie;")
    public Node pointer;

    @OriginalMember(owner = "client!sia", name = "x", descriptor = "Lclient!ie;")
    public final Node tail = new Node();

    @OriginalMember(owner = "client!sia", name = "<init>", descriptor = "()V")
    public Deque() {
        this.tail.next = this.tail;
        this.tail.prev = this.tail;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;I)V")
    public void addFirst(@OriginalArg(0) Node node) {
        if (node.prev != null) {
            node.remove();
        }
        node.next = this.tail.next;
        node.prev = this.tail;
        node.prev.next = node;
        node.next.prev = node;
    }

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "(I)Lclient!ie;")
    public Node first(@OriginalArg(0) int arg0) {
        @Pc(7) Node first = this.tail.next;
        if (arg0 != 65280) {
            this.pointer = null;
        }
        if (first == this.tail) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = first.next;
            return first;
        }
    }

    @OriginalMember(owner = "client!sia", name = "f", descriptor = "(I)V")
    public void clear() {
        while (true) {
            @Pc(7) Node current = this.tail.next;
            if (this.tail == current) {
                this.pointer = null;
                return;
            }
            current.remove();
        }
    }

    @OriginalMember(owner = "client!sia", name = "c", descriptor = "(I)I")
    public int size() {
        @Pc(13) int size = 0;
        @Pc(17) Node current = this.tail.next;
        while (current != this.tail) {
            current = current.next;
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!sia", name = "d", descriptor = "(I)Z")
    public boolean isEmpty() {
        return this.tail == this.tail.next;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;Lclient!sia;B)V")
    public void append(@OriginalArg(0) Node before, @OriginalArg(1) Deque deque) {
        @Pc(7) Node node = this.tail.prev;
        this.tail.prev = before.prev;
        before.prev.next = this.tail;
        if (before != this.tail) {
            before.prev = deque.tail.prev;
            before.prev.next = before;
            node.next = deque.tail;
            deque.tail.prev = node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(I)Lclient!ie;")
    public Node removeFirst() {
        @Pc(7) Node node = this.tail.next;
        if (node == this.tail) {
            return null;
        } else {
            node.remove();
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "h", descriptor = "(I)Lclient!ie;")
    public Node next() {
        @Pc(13) Node node = this.pointer;
        if (node == this.tail) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next;
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(ILclient!sia;)V")
    public void appendTo(@OriginalArg(1) Deque arg0) {
        this.append(this.tail.next, arg0);
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(B)Lclient!ie;")
    public Node last() {
        @Pc(14) Node node = this.tail.prev;
        if (node == this.tail) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.prev;
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "b", descriptor = "(B)Lclient!ie;")
    public Node previous() {
        @Pc(6) Node node = this.pointer;
        if (node == this.tail) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.prev;
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(BLclient!ie;)V")
    public void addLast(@OriginalArg(1) Node node) {
        if (node.prev != null) {
            node.remove();
        }
        node.next = this.tail;
        node.prev = this.tail.prev;
        node.prev.next = node;
        node.next.prev = node;
    }
}
