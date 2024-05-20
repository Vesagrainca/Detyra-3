package com.example.ssl_tsl;

public class Finished {
    private byte[] verifyData;

    public Finished(byte[] verifyData) {
        this.verifyData = verifyData;
    }

    public byte[] toByteArray() {
        return this.verifyData;
    }
}

