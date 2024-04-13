package com.jagex.crypto.rsa;

import java.math.BigInteger;

public final class RsaPublicKey {

    private final BigInteger modulus;

    private final BigInteger exponent;

    public RsaPublicKey(BigInteger modulus, BigInteger exponent) {
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
