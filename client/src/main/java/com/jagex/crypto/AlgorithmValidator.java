package com.jagex.crypto;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

import java.io.IOException;

public final class AlgorithmValidator {

    public static void validate(
        AlgorithmIdentifier id,
        ASN1ObjectIdentifier expectedAlgorithm,
        ASN1Encodable expectedParameters
    ) throws IOException {
        validate(expectedAlgorithm, id.getAlgorithm());
        validate(expectedParameters, id.getParameters());
    }

    private static void validate(ASN1ObjectIdentifier expected, ASN1ObjectIdentifier actual) throws IOException {
        if (!actual.equals(expected)) {
            throw new IOException("Algorithm identifier must be " + expected + ", was " + actual);
        }
    }

    private static void validate(ASN1Encodable expected, ASN1Encodable actual) throws IOException {
        if (!actual.equals(expected)) {
            throw new IOException("Algorithm parameters must be " + expected + ", was " + actual);
        }
    }

    private AlgorithmValidator() {
        /* empty */
    }
}
