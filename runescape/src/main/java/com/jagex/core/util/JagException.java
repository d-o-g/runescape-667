package com.jagex.core.util;

import com.jagex.core.stringtools.general.StringTools;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

@OriginalClass("client!fl")
public final class JagException extends RuntimeException {

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "(Ljava/lang/Throwable;Ljava/lang/String;)Lclient!fl;")
    public static JagException wrap(@OriginalArg(0) Throwable cause, @OriginalArg(1) String message) {
        @Pc(12) JagException wrapped;
        if (cause instanceof JagException) {
            wrapped = (JagException) cause;
            wrapped.message = wrapped.message + ' ' + message;
        } else {
            wrapped = new JagException(cause, message);
        }
        return wrapped;
    }

    @OriginalMember(owner = "client!oaa", name = "a", descriptor = "(ILjava/lang/Throwable;)Ljava/lang/String;")
    public static String stackTrace(@OriginalArg(1) Throwable cause) throws IOException {
        @Pc(14) String message;

        if (cause instanceof JagException) {
            @Pc(18) JagException jagException = (JagException) cause;
            message = jagException.message + " | ";
            cause = jagException.cause;
        } else {
            message = "";
        }

        @Pc(37) StringWriter stringWriter = new StringWriter();
        @Pc(42) PrintWriter printWriter = new PrintWriter(stringWriter);

        cause.printStackTrace(printWriter);
        printWriter.close();

        @Pc(50) String stackTrace = stringWriter.toString();
        @Pc(58) BufferedReader reader = new BufferedReader(new StringReader(stackTrace));
        @Pc(61) String header = reader.readLine();

        while (true) {
            @Pc(64) String line = reader.readLine();
            if (line == null) {
                return message + "| " + header;
            }

            @Pc(70) int left = line.indexOf('(');
            @Pc(77) int right = line.indexOf(')', left + 1);

            @Pc(85) String trimmed;
            if (left == -1) {
                trimmed = line;
            } else {
                trimmed = line.substring(0, left);
            }

            trimmed = trimmed.trim();
            trimmed = trimmed.substring(trimmed.lastIndexOf(' ') + 1);
            trimmed = trimmed.substring(trimmed.lastIndexOf('\t') + 1);
            message = message + trimmed;

            if (left != -1 && right != -1) {
                @Pc(132) int file = line.indexOf(".java:", left);

                if (file >= 0) {
                    message = message + line.substring(file + 5, right);
                }
            }

            message = message + ' ';
        }
    }

    @OriginalMember(owner = "client!hea", name = "a", descriptor = "(BLjava/lang/String;)V")
    public static void print(@OriginalArg(1) String arg0) {
        System.out.println("Error: " + StringTools.replace(arg0, "%0a", "\n"));
    }

    @OriginalMember(owner = "client!fl", name = "f", descriptor = "Ljava/lang/Throwable;")
    public final Throwable cause;

    @OriginalMember(owner = "client!fl", name = "h", descriptor = "Ljava/lang/String;")
    public String message;

    @OriginalMember(owner = "client!fl", name = "<init>", descriptor = "(Ljava/lang/Throwable;Ljava/lang/String;)V")
    public JagException(@OriginalArg(0) Throwable cause, @OriginalArg(1) String message) {
        this.cause = cause;
        this.message = message;
    }
}
