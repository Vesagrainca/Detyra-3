package com.example.ssl_tsl;

public class ChangeCipherSpec {
    public byte[] toByteArray() {
        return new byte[] { 1 }; // Single byte message
    }
}

