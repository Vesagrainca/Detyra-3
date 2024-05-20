package com.example.ssl_tsl;

public class ServerKeyExchange {
    private byte[] publicKey;

    public ServerKeyExchange(byte[] publicKey) {
        this.publicKey = publicKey;
    }

    public byte[] toByteArray() {
        return publicKey;
    }
}
