package com.jagex.core.io;

import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.io.InputStream;

@OriginalClass("client!saa")
public final class DummyInputStream extends InputStream {

    @OriginalMember(owner = "client!saa", name = "read", descriptor = "()I")
    @Override
    public int read() {
        TimeUtils.sleep(30000L);
        return -1;
    }
}
