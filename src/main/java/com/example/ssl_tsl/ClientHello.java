package com.example.ssl_tsl;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class ClientHello {
    private byte[] random;
    private List<String> cipherSuites;

    public ClientHello() {
        this.random = new byte[32];
        new SecureRandom().nextBytes(random);
        this.cipherSuites = Arrays.asList("TLS_RSA_WITH_AES_128_GCM_SHA256");
    }

    public byte[] toByteArray() {
        // Simplified conversion for demonstration
        return random;
    }
}
