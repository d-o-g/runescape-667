import com.jagex.sign.SignedResourceStatus;
import com.jagex.core.io.BitPacket;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Static437 {

    @OriginalMember(owner = "client!np", name = "c", descriptor = "Lclient!fma;")
    public static final Class131 aClass131_4 = new Class131();

    @OriginalMember(owner = "client!np", name = "a", descriptor = "(ILclient!rka;)V")
    public static void sendReflectionCheckReply(@OriginalArg(1) BitPacket bitPacket) {
        @Pc(10) ReflectionCheck check = Static631.reflectionChecks.first();
        if (check == null) {
            return;
        }

        @Pc(16) boolean unfinished = false;
        for (@Pc(18) int i = 0; i < check.memberCount; i++) {
            if (check.field[i] != null) {
                if (check.field[i].status == SignedResourceStatus.ERROR) {
                    check.status[i] = -5;
                }

                if (check.field[i].status == SignedResourceStatus.IDLE) {
                    unfinished = true;
                }
            }

            if (check.methods[i] != null) {
                if (check.methods[i].status == SignedResourceStatus.ERROR) {
                    check.status[i] = -6;
                }

                if (check.methods[i].status == SignedResourceStatus.IDLE) {
                    unfinished = true;
                }
            }
        }

        if (unfinished) {
            return;
        }

        @Pc(98) int pos = bitPacket.pos;
        bitPacket.p4(check.magic);

        for (@Pc(105) int i = 0; i < check.memberCount; i++) {
            if (check.status[i] != 0) {
                bitPacket.p1(check.status[i]);
                continue;
            }

            try {
                @Pc(130) int type = check.memberTypes[i];

                if (type == 0) {
                    @Pc(149) Field field = (Field) check.field[i].result;
                    @Pc(177) int v = field.getInt(null);
                    bitPacket.p1(0);
                    bitPacket.p4(v);
                } else if (type == 1) {
                    @Pc(149) Field field = (Field) check.field[i].result;
                    field.setInt(null, check.fieldValues[i]);
                    bitPacket.p1(0);
                } else if (type == 2) {
                    @Pc(149) Field field = (Field) check.field[i].result;
                    @Pc(177) int modifiers = field.getModifiers();
                    bitPacket.p1(0);
                    bitPacket.p4(modifiers);
                } else if (type == 3) {
                    @Pc(225) Method method = (Method) check.methods[i].result;
                    @Pc(250) byte[][] argData = check.arguments[i];
                    @Pc(254) Object[] args = new Object[argData.length];

                    for (@Pc(256) int j = 0; j < argData.length; j++) {
                        @Pc(268) ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(argData[j]));
                        args[j] = input.readObject();
                    }

                    @Pc(283) Object object = method.invoke(null, args);
                    if (object == null) {
                        bitPacket.p1(0);
                    } else if (object instanceof Number) {
                        bitPacket.p1(1);
                        bitPacket.p8(((Number) object).longValue());
                    } else if (object instanceof String) {
                        bitPacket.p1(2);
                        bitPacket.pjstr((String) object);
                    } else {
                        bitPacket.p1(4);
                    }
                } else if (type == 4) {
                    @Pc(225) Method method = (Method) check.methods[i].result;
                    @Pc(177) int modifiers = method.getModifiers();
                    bitPacket.p1(0);
                    bitPacket.p4(modifiers);
                }
            } catch (@Pc(338) ClassNotFoundException ignored) {
                bitPacket.p1(-10);
            } catch (@Pc(344) InvalidClassException ignored) {
                bitPacket.p1(-11);
            } catch (@Pc(350) StreamCorruptedException ignored) {
                bitPacket.p1(-12);
            } catch (@Pc(356) OptionalDataException ignored) {
                bitPacket.p1(-13);
            } catch (@Pc(362) IllegalAccessException ignored) {
                bitPacket.p1(-14);
            } catch (@Pc(368) IllegalArgumentException ignored) {
                bitPacket.p1(-15);
            } catch (@Pc(374) InvocationTargetException ignored) {
                bitPacket.p1(-16);
            } catch (@Pc(380) SecurityException ignored) {
                bitPacket.p1(-17);
            } catch (@Pc(386) IOException ignored) {
                bitPacket.p1(-18);
            } catch (@Pc(392) NullPointerException ignored) {
                bitPacket.p1(-19);
            } catch (@Pc(398) Exception ignored) {
                bitPacket.p1(-20);
            } catch (@Pc(404) Throwable ignored) {
                bitPacket.p1(-21);
            }
        }

        bitPacket.addcrc(pos);
        check.unlink();
    }

    @OriginalMember(owner = "client!np", name = "b", descriptor = "(III)Z")
    public static boolean method5917(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        return (arg2 & 0x70000) != 0 | Static646.method8457(arg1, arg2) || Static598.method7828(arg2, arg1);
    }
}
