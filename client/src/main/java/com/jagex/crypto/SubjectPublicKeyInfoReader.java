package com.jagex.crypto;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.IOException;

public final class SubjectPublicKeyInfoReader {

    public static SubjectPublicKeyInfo read(PemReader reader) throws IOException {
        var der = readPublicKey(reader);
        return SubjectPublicKeyInfo.getInstance(der);
    }

    private static byte[] readPublicKey(PemReader reader) throws IOException {
        return readSinglePemObject(reader, "PUBLIC KEY");
    }

    private static byte[] readSinglePemObject(PemReader reader, String type) throws IOException {
        var obj = reader.readPemObject();
        if (obj == null) {
            throw new IOException("No PEM object in public key");
        }

        var actualType = obj.getType();
        if (!actualType.equals(type)) {
            throw new IOException("PEM object type must be " + type + ", was " + actualType);
        }

        if (reader.readPemObject() != null) {
            throw new IOException("Trailing PEM object");
        }

        if (!obj.getHeaders().isEmpty()) {
            throw new IOException("PEM headers unsupported");
        }

        return obj.getContent();
    }

    private SubjectPublicKeyInfoReader() {
        /* empty */
    }
}
