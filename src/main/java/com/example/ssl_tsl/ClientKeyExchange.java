package com.example.ssl_tsl;

public class ClientKeyExchange {
    private byte[] preMasterSecret;

    public ClientKeyExchange(byte[] preMasterSecret) {
        this.preMasterSecret = preMasterSecret;
    }

    public byte[] toByteArray() {
        return this.preMasterSecret;
    }
}

