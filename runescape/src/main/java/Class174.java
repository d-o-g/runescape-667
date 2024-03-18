import com.jagex.collect.Queue;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!iba")
public final class Class174 implements Runnable {

    @OriginalMember(owner = "client!iba", name = "j", descriptor = "[I")
    public static final int[] anIntArray325 = new int[32];

    @OriginalMember(owner = "client!iba", name = "d", descriptor = "Lclient!jga;")
    public final Queue aQueue_7 = new Queue();

    @OriginalMember(owner = "client!iba", name = "n", descriptor = "I")
    public int anInt4243 = 0;

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "Z")
    public boolean aBoolean333 = false;

    @OriginalMember(owner = "client!iba", name = "g", descriptor = "Ljava/lang/Thread;")
    public Thread aThread2;

    static {
        @Pc(73) int local73 = 2;
        for (@Pc(75) int local75 = 0; local75 < 32; local75++) {
            anIntArray325[local75] = local73 - 1;
            local73 += local73;
        }
    }

    @OriginalMember(owner = "client!iba", name = "<init>", descriptor = "(Lclient!vq;)V")
    public Class174(@OriginalArg(0) SignLink arg0) {
        @Pc(20) SignedResource local20 = arg0.startThread(this, 5);
        while (local20.status == 0) {
            Static638.sleep(10L);
        }
        if (local20.status == 2) {
            throw new RuntimeException();
        }
        this.aThread2 = (Thread) local20.result;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(Lclient!af;IZ)Lclient!vp;")
    public DoublyLinkedNode_Sub2_Sub17_ method3825(@OriginalArg(0) Class9 arg0, @OriginalArg(1) int arg1) {
        @Pc(7) DoublyLinkedNode_Sub2_Sub17_ local7 = new DoublyLinkedNode_Sub2_Sub17_();
        local7.anInt10352 = 1;
        @Pc(13) Queue local13 = this.aQueue_7;
        synchronized (this.aQueue_7) {
            @Pc(21) DoublyLinkedNode_Sub2_Sub17_ local21 = (DoublyLinkedNode_Sub2_Sub17_) this.aQueue_7.first();
            while (true) {
                if (local21 == null) {
                    break;
                }
                if (local21.key2 == (long) arg1 && local21.aClass9_4 == arg0 && local21.anInt10352 == 2) {
                    local7.aBoolean778 = false;
                    local7.aByteArray109 = local21.aByteArray109;
                    return local7;
                }
                local21 = (DoublyLinkedNode_Sub2_Sub17_) this.aQueue_7.next();
            }
        }
        local7.aByteArray109 = arg0.method126(arg1);
        local7.aBoolean777 = true;
        local7.aBoolean778 = false;
        return local7;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(I)V")
    public void method3826() {
        this.aBoolean333 = true;
        @Pc(9) Queue local9 = this.aQueue_7;
        synchronized (this.aQueue_7) {
            this.aQueue_7.notifyAll();
        }
        try {
            this.aThread2.join();
        } catch (@Pc(25) InterruptedException local25) {
        }
        this.aThread2 = null;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(ILclient!vp;)V")
    public void method3827(@OriginalArg(1) DoublyLinkedNode_Sub2_Sub17_ arg0) {
        @Pc(6) Queue local6 = this.aQueue_7;
        synchronized (this.aQueue_7) {
            this.aQueue_7.add(arg0);
            this.anInt4243++;
            this.aQueue_7.notifyAll();
        }
    }

    @OriginalMember(owner = "client!iba", name = "run", descriptor = "()V")
    @Override
    public void run() {
        while (!this.aBoolean333) {
            @Pc(10) Queue local10 = this.aQueue_7;
            @Pc(18) DoublyLinkedNode_Sub2_Sub17_ local18;
            synchronized (this.aQueue_7) {
                local18 = (DoublyLinkedNode_Sub2_Sub17_) this.aQueue_7.removeFirst();
                if (local18 == null) {
                    try {
                        this.aQueue_7.wait();
                    } catch (@Pc(26) InterruptedException local26) {
                    }
                    continue;
                }
                this.anInt4243--;
            }
            try {
                if (local18.anInt10352 == 2) {
                    local18.aClass9_4.method125(local18.aByteArray109.length, local18.aByteArray109, (int) local18.key2);
                } else if (local18.anInt10352 == 3) {
                    local18.aByteArray109 = local18.aClass9_4.method126((int) local18.key2);
                }
            } catch (@Pc(83) Exception local83) {
                Static240.sendTrace(local83, (String) null);
            }
            local18.aBoolean778 = false;
        }
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(B[BILclient!af;)Lclient!vp;")
    public DoublyLinkedNode_Sub2_Sub17_ method3829(@OriginalArg(1) byte[] arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Class9 arg2) {
        @Pc(7) DoublyLinkedNode_Sub2_Sub17_ local7 = new DoublyLinkedNode_Sub2_Sub17_();
        local7.key2 = (long) arg1;
        local7.anInt10352 = 2;
        local7.aByteArray109 = arg0;
        local7.aClass9_4 = arg2;
        local7.aBoolean777 = false;
        this.method3827(local7);
        return local7;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(Lclient!af;II)Lclient!vp;")
    public DoublyLinkedNode_Sub2_Sub17_ method3830(@OriginalArg(0) Class9 arg0, @OriginalArg(2) int arg1) {
        @Pc(7) DoublyLinkedNode_Sub2_Sub17_ local7 = new DoublyLinkedNode_Sub2_Sub17_();
        local7.aClass9_4 = arg0;
        local7.aBoolean777 = false;
        local7.anInt10352 = 3;
        local7.key2 = (long) arg1;
        this.method3827(local7);
        return local7;
    }
}
