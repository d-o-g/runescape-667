package rs2.client.event.mouse;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

@OriginalClass("client!vha")
public final class SimpleMouseMonitor extends MouseMonitor implements MouseListener, MouseMotionListener {

    @OriginalMember(owner = "client!vha", name = "M", descriptor = "I")
    public int recordedX;

    @OriginalMember(owner = "client!vha", name = "m", descriptor = "I")
    public int recordedY;

    @OriginalMember(owner = "client!vha", name = "j", descriptor = "I")
    public int recordedState;

    @OriginalMember(owner = "client!vha", name = "G", descriptor = "I")
    public int mouseY;

    @OriginalMember(owner = "client!vha", name = "s", descriptor = "I")
    public int mouseX;

    @OriginalMember(owner = "client!vha", name = "t", descriptor = "I")
    public int clickState;

    @OriginalMember(owner = "client!vha", name = "E", descriptor = "Ljava/awt/Component;")
    public Component component;

    @OriginalMember(owner = "client!vha", name = "J", descriptor = "Lclient!sia;")
    public Deque recorded = new Deque();

    @OriginalMember(owner = "client!vha", name = "K", descriptor = "Lclient!sia;")
    public Deque logged = new Deque();

    @OriginalMember(owner = "client!vha", name = "p", descriptor = "Z")
    public final boolean logging;

    @OriginalMember(owner = "client!vha", name = "<init>", descriptor = "(Ljava/awt/Component;Z)V")
    public SimpleMouseMonitor(@OriginalArg(0) Component component, @OriginalArg(1) boolean logging) {
        this.listen(component);
        this.logging = logging;
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(IIBII)V")
    public void log(@OriginalArg(0) int x, @OriginalArg(1) int extra, @OriginalArg(3) int type, @OriginalArg(4) int y) {
        @Pc(15) SimpleMouseLog log = new SimpleMouseLog();
        log.type = type;
        log.y = y;
        log.extra = extra;
        log.x = x;
        log.time = SystemTimer.safetime();
        this.logged.addLast(log);
    }

    @OriginalMember(owner = "client!vha", name = "c", descriptor = "(I)Z")
    @Override
    public boolean isLeftDown() {
        return (this.recordedState & CLICK_TYPE_LEFT) != 0;
    }

    @OriginalMember(owner = "client!vha", name = "b", descriptor = "(I)Z")
    @Override
    public boolean isRightDown() {
        return (this.recordedState & CLICK_TYPE_RIGHT) != 0;
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(ILjava/awt/event/MouseEvent;)I")
    public int getClickType(@OriginalArg(1) MouseEvent event) {
        @Pc(6) int modifiers = event.getModifiers();
        @Pc(15) boolean left = (modifiers & MouseEvent.BUTTON1_MASK) != 0;
        @Pc(27) boolean middle = (modifiers & MouseEvent.BUTTON2_MASK) != 0;
        @Pc(36) boolean right = (modifiers & MouseEvent.BUTTON3_MASK) != 0;

        if (middle && (left || right)) {
            middle = false;
        }

        if (left && right) {
            return CLICK_TYPE_RIGHT;
        } else if (left) {
            return CLICK_TYPE_LEFT;
        } else if (middle) {
            return CLICK_TYPE_MIDDLE;
        } else if (right) {
            return CLICK_TYPE_RIGHT;
        } else {
            return CLICK_TYPE_NONE;
        }
    }

    @OriginalMember(owner = "client!vha", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseEntered(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getX(), event.getY());
    }

    @OriginalMember(owner = "client!vha", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseExited(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getX(), event.getY());
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(Ljava/awt/Component;I)V")
    public void listen(@OriginalArg(0) Component component) {
        this.reset();
        this.component = component;
        this.component.addMouseListener(this);
        this.component.addMouseMotionListener(this);
    }

    @OriginalMember(owner = "client!vha", name = "f", descriptor = "(B)V")
    public void reset() {
        if (this.component == null) {
            return;
        }
        this.component.removeMouseMotionListener(this);
        this.component.removeMouseListener(this);
        this.component = null;
        this.logged = null;
        this.recorded = null;
        this.recordedX = this.recordedY = this.recordedState = 0;
        this.mouseX = this.mouseY = this.clickState = 0;
    }

    @OriginalMember(owner = "client!vha", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseMoved(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getX(), event.getY());
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(I)V")
    @Override
    public void remove() {
        this.reset();
    }

    @OriginalMember(owner = "client!vha", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mousePressed(@OriginalArg(0) MouseEvent event) {
        @Pc(10) int type = this.getClickType(event);

        if (type == CLICK_TYPE_LEFT) {
            this.log(event.getX(), event.getClickCount(), MouseLog.TYPE_PRESS_LEFT, event.getY());
        } else if (type == CLICK_TYPE_RIGHT) {
            this.log(event.getX(), event.getClickCount(), MouseLog.TYPE_PRESS_RIGHT, event.getY());
        } else if (type == CLICK_TYPE_MIDDLE) {
            this.log(event.getX(), event.getClickCount(), MouseLog.TYPE_PRESS_MIDDLE, event.getY());
        }

        this.clickState |= type;

        if (event.isPopupTrigger()) {
            event.consume();
        }
    }

    @OriginalMember(owner = "client!vha", name = "d", descriptor = "(B)I")
    @Override
    public int getRecordedX() {
        return this.recordedX;
    }

    @OriginalMember(owner = "client!vha", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseDragged(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getX(), event.getY());
    }

    @OriginalMember(owner = "client!vha", name = "d", descriptor = "(I)Z")
    @Override
    public boolean isMiddleDown() {
        return (this.recordedState & CLICK_TYPE_MIDDLE) != 0;
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(IBI)V")
    public void setPosition(@OriginalArg(0) int x, @OriginalArg(2) int y) {
        this.mouseY = y;
        this.mouseX = x;

        if (this.logging) {
            this.log(x, 0, MouseLog.TYPE_RESET, y);
        }
    }

    @OriginalMember(owner = "client!vha", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseClicked(@OriginalArg(0) MouseEvent event) {
        if (event.isPopupTrigger()) {
            event.consume();
        }
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(B)Lclient!bv;")
    @Override
    public MouseLog removeFirstLog() {
        return (MouseLog) this.recorded.removeFirst();
    }

    @OriginalMember(owner = "client!vha", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseReleased(@OriginalArg(0) MouseEvent event) {
        @Pc(8) int type = this.getClickType(event);
        if ((type & this.clickState) == 0) {
            type = this.clickState;
        }

        if ((type & CLICK_TYPE_LEFT) != 0) {
            this.log(event.getX(), event.getClickCount(), MouseLog.TYPE_RELEASE_LEFT, event.getY());
        }
        if ((type & CLICK_TYPE_RIGHT) != 0) {
            this.log(event.getX(), event.getClickCount(), MouseLog.TYPE_RELEASE_RIGHT, event.getY());
        }
        if ((type & CLICK_TYPE_MIDDLE) != 0) {
            this.log(event.getX(), event.getClickCount(), MouseLog.TYPE_RELEASE_MIDDLE, event.getY());
        }

        this.clickState &= ~type;

        if (event.isPopupTrigger()) {
            event.consume();
        }
    }

    @OriginalMember(owner = "client!vha", name = "a", descriptor = "(Z)I")
    @Override
    public int getRecordedY() {
        return this.recordedY;
    }

    @OriginalMember(owner = "client!vha", name = "e", descriptor = "(B)V")
    @Override
    public synchronized void record() {
        this.recordedState = this.clickState;
        this.recordedY = this.mouseY;
        this.recordedX = this.mouseX;
        @Pc(18) Deque temp = this.recorded;
        this.recorded = this.logged;
        this.logged = temp;
        this.logged.clear();
    }
}
