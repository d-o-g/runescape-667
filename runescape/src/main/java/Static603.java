import com.jagex.Client;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseMonitor;

public final class Static603 {

    @OriginalMember(owner = "client!taa", name = "b", descriptor = "(Z)V")
    public static void method7899() {
        InterfaceManager.redraw(InterfaceManager.dragSource);
        InterfaceManager.dragTicks++;
        if (Static702.aBoolean797 && InterfaceManager.aBoolean428) {
            @Pc(30) int local30 = 0;
            @Pc(32) int local32 = 0;
            if (OrthoMode.toolkitActive) {
                local30 = OrthoMode.method2283();
                local32 = Static422.method5771();
            }
            @Pc(46) int local46 = local30 + MouseMonitor.instance.getRecordedX();
            @Pc(52) int local52 = MouseMonitor.instance.getRecordedY() + local32;
            local46 -= InterfaceManager.dragStartX;
            local52 -= InterfaceManager.dragStartY;
            if (InterfaceManager.dragParentX > local46) {
                local46 = InterfaceManager.dragParentX;
            }
            if (InterfaceManager.dragSource.width + local46 > InterfaceManager.dragParentX - -InterfaceManager.dragLayer.width) {
                local46 = InterfaceManager.dragLayer.width + InterfaceManager.dragParentX - InterfaceManager.dragSource.width;
            }
            if (local52 < InterfaceManager.dragParentY) {
                local52 = InterfaceManager.dragParentY;
            }
            if (InterfaceManager.dragParentY + InterfaceManager.dragLayer.height < local52 - -InterfaceManager.dragSource.height) {
                local52 = InterfaceManager.dragParentY + InterfaceManager.dragLayer.height - InterfaceManager.dragSource.height;
            }
            @Pc(119) int local119 = InterfaceManager.dragLayer.scrollX + local46 - InterfaceManager.dragParentX;
            @Pc(127) int local127 = InterfaceManager.dragLayer.scrollY + local52 - InterfaceManager.dragParentY;
            @Pc(197) HookRequest local197;
            if (MouseMonitor.instance.isDown()) {
                if (InterfaceManager.dragSource.dragDeadTime < InterfaceManager.dragTicks) {
                    @Pc(141) int local141 = local46 - InterfaceManager.dragLastX;
                    @Pc(146) int local146 = local52 - InterfaceManager.dragLastY;
                    if (InterfaceManager.dragSource.dragDeadZone < local141 || -InterfaceManager.dragSource.dragDeadZone > local141 || InterfaceManager.dragSource.dragDeadZone < local146 || local146 < -InterfaceManager.dragSource.dragDeadZone) {
                        InterfaceManager.dragging = true;
                    }
                }
                if (InterfaceManager.dragSource.onDrag != null && InterfaceManager.dragging) {
                    local197 = new HookRequest();
                    local197.source = InterfaceManager.dragSource;
                    local197.mouseX = local119;
                    local197.mouseY = local127;
                    local197.arguments = InterfaceManager.dragSource.onDrag;
                    ScriptRunner.executeHookInner(local197);
                    return;
                }
            } else {
                if (InterfaceManager.dragging) {
                    InterfaceManager.endTargetMode();
                    if (InterfaceManager.dragSource.onDragComplete != null) {
                        local197 = new HookRequest();
                        local197.target = InterfaceManager.dragTarget;
                        local197.mouseX = local119;
                        local197.source = InterfaceManager.dragSource;
                        local197.mouseY = local127;
                        local197.arguments = InterfaceManager.dragSource.onDragComplete;
                        ScriptRunner.executeHookInner(local197);
                    }
                    if (InterfaceManager.dragTarget != null && Static84.method1657(InterfaceManager.dragSource) != null) {
                        Static710.method6710(InterfaceManager.dragSource, InterfaceManager.dragTarget);
                    }
                } else if ((Client.mouseButtons == 1 || MiniMenu.topEntryIsIfButtonX1()) && MiniMenu.innerEntryCount > 2) {
                    MiniMenu.method6223(InterfaceManager.dragStartX + InterfaceManager.dragLastX, InterfaceManager.dragLastY + InterfaceManager.dragStartY);
                } else if (MiniMenu.isPopulated()) {
                    MiniMenu.method6223(InterfaceManager.dragLastX + InterfaceManager.dragStartX, InterfaceManager.dragLastY + InterfaceManager.dragStartY);
                }
                InterfaceManager.dragSource = null;
            }
        } else if (InterfaceManager.dragTicks > 1) {
            InterfaceManager.dragSource = null;
        }
    }

}
