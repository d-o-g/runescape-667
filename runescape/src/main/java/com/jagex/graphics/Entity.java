package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ep")
public class Entity {

    @OriginalMember(owner = "client!ep", name = "c", descriptor = "Lclient!ep;")
    public Entity aEntity_67;

    @OriginalMember(owner = "client!ep", name = "e", descriptor = "Lclient!ep;")
    public Entity aEntity_68;

    @OriginalMember(owner = "client!ep", name = "a", descriptor = "(Z)V")
    public final void method9274() {
        if (this.aEntity_67 != null) {
            this.aEntity_67.aEntity_68 = this.aEntity_68;
            this.aEntity_68.aEntity_67 = this.aEntity_67;
            this.aEntity_68 = null;
            this.aEntity_67 = null;
        }
    }
}
