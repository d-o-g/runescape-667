import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;

public final class RsaKeyPair {

    public static RsaKeyPair read(Path path) throws IOException {
        try (PemReader reader = new PemReader(Files.newBufferedReader(path))) {
            SubjectPublicKeyInfo spki = readSubjectPublicKeyInfo(reader);
            RSAKeyParameters publicKey = rsaFrom(spki);

            BigInteger modulus = publicKey.getModulus();
            BigInteger exponent = publicKey.getExponent();

            return new RsaKeyPair(modulus, exponent);
        }
    }

    private static SubjectPublicKeyInfo readSubjectPublicKeyInfo(PemReader reader) throws IOException {
        byte[] der = readSinglePemObject(reader, "PUBLIC KEY");
        SubjectPublicKeyInfo spki = SubjectPublicKeyInfo.getInstance(der);
        validateRsa(spki.getAlgorithm());
        return spki;
    }

    public static RSAKeyParameters rsaFrom(SubjectPublicKeyInfo spki) throws IOException {
        RSAPublicKey key = RSAPublicKey.getInstance(spki.parsePublicKey());

        return new RSAKeyParameters(
            /* isPrivate = */ false,
            /* modulus = */ key.getModulus(),
            /* exponent = */ key.getPublicExponent()
        );
    }

    private static byte[] readSinglePemObject(PemReader reader, String expectedType) throws IOException {
        PemObject obj = reader.readPemObject();
        if (obj == null) {
            throw new IOException("No PEM object in public key");
        }

        String type = obj.getType();
        if (!type.equals(expectedType)) {
            throw new IOException("PEM object type is not " + expectedType);
        }

        if (reader.readPemObject() != null) {
            throw new IOException("Trailing PEM object");
        }

        if (!obj.getHeaders().isEmpty()) {
            throw new IOException("PEM headers unsupported");
        }

        return obj.getContent();
    }

    private static void validateRsa(AlgorithmIdentifier id) throws IOException {
        if (!id.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption)) {
            throw new IOException("Invalid algorithm identifier, expecting rsaEncryption");
        }

        if (!id.getParameters().equals(DERNull.INSTANCE)) {
            throw new IOException("Invalid algorithm parameters, expecting NULL");
        }
    }

    private final BigInteger modulus;
    private final BigInteger exponent;

    private RsaKeyPair(BigInteger modulus, BigInteger exponent) {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getExponent() {
        return exponent;
    }
}
