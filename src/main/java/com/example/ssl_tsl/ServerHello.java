package com.example.ssl_tsl;

import java.security.SecureRandom;

public class ServerHello {
    private byte[] random;
    private String selectedCipherSuite;

    public ServerHello() {
        this.random = new byte[32];
        new SecureRandom().nextBytes(random);
        this.selectedCipherSuite = "TLS_RSA_WITH_AES_128_GCM_SHA256";
    }

    public byte[] toByteArray() {
        // Simplified conversion for demonstration
        return random;
    }
}
