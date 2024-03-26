package com.jagex.core.io;

import com.jagex.SignLink;
import com.jagex.SignedResource;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lja")
public final class ConnectionInfo {

    @OriginalMember(owner = "client!lja", name = "e", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!lja", name = "i", descriptor = "Ljava/lang/String;")
    public String address;

    @OriginalMember(owner = "client!lja", name = "m", descriptor = "I")
    public int defaultPort = 43594;

    @OriginalMember(owner = "client!lja", name = "k", descriptor = "I")
    public int alternatePort = 443;

    @OriginalMember(owner = "client!lja", name = "d", descriptor = "Z")
    public boolean proxy = false;

    @OriginalMember(owner = "client!lja", name = "f", descriptor = "Z")
    public boolean alternate = true;

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(I)V")
    public void rotateMethods() {
        if (!this.alternate) {
            this.proxy = true;
            this.alternate = true;
        } else if (this.proxy) {
            this.proxy = false;
        } else {
            this.alternate = false;
        }
    }

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(BLclient!vq;)Lclient!oba;")
    public SignedResource openSocket(@OriginalArg(1) SignLink signLink) {
        return signLink.openSocket(this.address, this.alternate ? this.alternatePort : this.defaultPort, this.proxy);
    }

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(ILclient!lja;)Z")
    public boolean equalTo(@OriginalArg(1) ConnectionInfo other) {
        if (other == null) {
            return false;
        } else {
            return other.id == this.id && this.address.equals(other.address);
        }
    }
}
