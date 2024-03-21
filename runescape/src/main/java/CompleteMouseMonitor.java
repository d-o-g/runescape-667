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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@OriginalClass("client!ht")
public final class CompleteMouseMonitor extends MouseMonitor implements MouseListener, MouseMotionListener, MouseWheelListener {

    @OriginalMember(owner = "client!ht", name = "j", descriptor = "I")
    public int recordedX;

    @OriginalMember(owner = "client!ht", name = "m", descriptor = "I")
    public int recordedState;

    @OriginalMember(owner = "client!ht", name = "r", descriptor = "I")
    public int recordedY;

    @OriginalMember(owner = "client!ht", name = "l", descriptor = "I")
    public int clickState;

    @OriginalMember(owner = "client!ht", name = "k", descriptor = "I")
    public int mouseY;

    @OriginalMember(owner = "client!ht", name = "s", descriptor = "I")
    public int mouseX;

    @OriginalMember(owner = "client!ht", name = "p", descriptor = "Ljava/awt/Component;")
    public Component component;

    @OriginalMember(owner = "client!ht", name = "n", descriptor = "Lclient!sia;")
    public Deque recorded = new Deque();

    @OriginalMember(owner = "client!ht", name = "q", descriptor = "Lclient!sia;")
    public Deque logged = new Deque();

    @OriginalMember(owner = "client!ht", name = "o", descriptor = "Z")
    public final boolean logging;

    @OriginalMember(owner = "client!ht", name = "<init>", descriptor = "(Ljava/awt/Component;Z)V")
    public CompleteMouseMonitor(@OriginalArg(0) Component component, @OriginalArg(1) boolean logging) {
        this.listen(component);
        this.logging = logging;
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(Z)I")
    @Override
    public int getRecordedY() {
        return this.recordedY;
    }

    @OriginalMember(owner = "client!ht", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseReleased(@OriginalArg(0) MouseEvent event) {
        @Pc(4) int type = this.getClickType(event);
        if ((this.clickState & type) == 0) {
            type = this.clickState;
        }

        if ((type & CLICK_TYPE_LEFT) != 0) {
            this.logEvent(event.getY(), event.getX(), MouseLog.TYPE_RELEASE_LEFT, event.getClickCount());
        }
        if ((type & CLICK_TYPE_RIGHT) != 0) {
            this.logEvent(event.getY(), event.getX(), MouseLog.TYPE_RELEASE_RIGHT, event.getClickCount());
        }
        if ((type & CLICK_TYPE_MIDDLE) != 0) {
            this.logEvent(event.getY(), event.getX(), MouseLog.TYPE_RELEASE_MIDDLE, event.getClickCount());
        }

        this.clickState &= ~type;

        if (event.isPopupTrigger()) {
            event.consume();
        }
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(IIIII)V")
    public void logEvent(@OriginalArg(0) int y, @OriginalArg(1) int x, @OriginalArg(2) int type, @OriginalArg(4) int extra) {
        @Pc(3) CompleteMouseLog log = new CompleteMouseLog();
        log.x = x;
        log.type = type;
        log.y = y;
        log.time = SystemTimer.safetime();
        log.extra = extra;
        this.logged.addLast(log);
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(ZII)V")
    public void setPosition(@OriginalArg(1) int y, @OriginalArg(2) int x) {
        this.mouseX = x;
        this.mouseY = y;

        if (this.logging) {
            this.logEvent(y, x, -1, 0);
        }
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(B)Lclient!bv;")
    @Override
    public MouseLog removeFirstLog() {
        return (MouseLog) this.recorded.removeFirst();
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(ILjava/awt/Component;)V")
    public void listen(@OriginalArg(1) Component component) {
        this.reset();
        this.component = component;
        this.component.addMouseListener(this);
        this.component.addMouseMotionListener(this);
        this.component.addMouseWheelListener(this);
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(Ljava/awt/event/MouseEvent;B)I")
    public int getClickType(@OriginalArg(0) MouseEvent event) {
        if (event.getButton() == MouseEvent.BUTTON1) {
            return event.isMetaDown() ? CLICK_TYPE_RIGHT : CLICK_TYPE_LEFT;
        } else if (event.getButton() == MouseEvent.BUTTON2) {
            return CLICK_TYPE_MIDDLE;
        } else if (event.getButton() == MouseEvent.BUTTON3) {
            return CLICK_TYPE_RIGHT;
        } else {
            return CLICK_TYPE_UNKNOWN;
        }
    }

    @OriginalMember(owner = "client!ht", name = "e", descriptor = "(I)V")
    public void reset() {
        if (this.component == null) {
            return;
        }
        this.component.removeMouseWheelListener(this);
        this.component.removeMouseMotionListener(this);
        this.component.removeMouseListener(this);
        this.logged = null;
        this.recordedX = this.recordedY = this.recordedState = 0;
        this.recorded = null;
        this.mouseX = this.mouseY = this.clickState = 0;
        this.component = null;
    }

    @OriginalMember(owner = "client!ht", name = "mouseWheelMoved", descriptor = "(Ljava/awt/event/MouseWheelEvent;)V")
    @Override
    public synchronized void mouseWheelMoved(@OriginalArg(0) MouseWheelEvent event) {
        @Pc(2) int x = event.getX();
        @Pc(5) int y = event.getY();
        @Pc(8) int rotation = event.getWheelRotation();
        this.logEvent(y, x, 6, rotation);
        event.consume();
    }

    @OriginalMember(owner = "client!ht", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseExited(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getY(), event.getX());
    }

    @OriginalMember(owner = "client!ht", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseDragged(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getY(), event.getX());
    }

    @OriginalMember(owner = "client!ht", name = "c", descriptor = "(I)Z")
    @Override
    public boolean isLeftDown() {
        return (this.recordedState & CLICK_TYPE_LEFT) != 0;
    }

    @OriginalMember(owner = "client!ht", name = "d", descriptor = "(B)I")
    @Override
    public int getRecordedX() {
        return this.recordedX;
    }

    @OriginalMember(owner = "client!ht", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mousePressed(@OriginalArg(0) MouseEvent event) {
        @Pc(4) int type = this.getClickType(event);

        if (type == CLICK_TYPE_LEFT) {
            this.logEvent(event.getY(), event.getX(), MouseLog.TYPE_PRESS_LEFT, event.getClickCount());
        } else if (type == CLICK_TYPE_RIGHT) {
            this.logEvent(event.getY(), event.getX(), MouseLog.TYPE_PRESS_RIGHT, event.getClickCount());
        } else if (type == CLICK_TYPE_MIDDLE) {
            this.logEvent(event.getY(), event.getX(), MouseLog.TYPE_PRESS_MIDDLE, event.getClickCount());
        }

        this.clickState |= type;

        if (event.isPopupTrigger()) {
            event.consume();
        }
    }

    @OriginalMember(owner = "client!ht", name = "e", descriptor = "(B)V")
    @Override
    public synchronized void method8841() {
        this.recordedState = this.clickState;
        this.recordedX = this.mouseX;
        this.recordedY = this.mouseY;
        @Pc(23) Deque temp = this.recorded;
        this.recorded = this.logged;
        this.logged = temp;
        this.logged.clear();
    }

    @OriginalMember(owner = "client!ht", name = "b", descriptor = "(I)Z")
    @Override
    public boolean isRightDown() {
        return (this.recordedState & CLICK_TYPE_RIGHT) != 0;
    }

    @OriginalMember(owner = "client!ht", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseMoved(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getY(), event.getX());
    }

    @OriginalMember(owner = "client!ht", name = "a", descriptor = "(I)V")
    @Override
    public void remove() {
        this.reset();
    }

    @OriginalMember(owner = "client!ht", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseEntered(@OriginalArg(0) MouseEvent event) {
        this.setPosition(event.getY(), event.getX());
    }

    @OriginalMember(owner = "client!ht", name = "d", descriptor = "(I)Z")
    @Override
    public boolean isMiddleDown() {
        return (this.recordedState & CLICK_TYPE_MIDDLE) != 0;
    }

    @OriginalMember(owner = "client!ht", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
    @Override
    public synchronized void mouseClicked(@OriginalArg(0) MouseEvent event) {
        if (event.isPopupTrigger()) {
            event.consume();
        }
    }
}
