package com.example.ssl_tsl;

import java.security.Provider;

public class BouncyCastleProvider extends Provider {
    protected BouncyCastleProvider(String name, double version, String info) {
        super(name, version, info);
    }
}
