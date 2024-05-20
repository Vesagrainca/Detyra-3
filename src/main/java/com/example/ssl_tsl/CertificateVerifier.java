package com.example.ssl_tsl;

import java.security.cert.X509Certificate;
import java.util.List;

public class CertificateVerifier {
    private List<X509Certificate> trustedCAs;

    public CertificateVerifier(List<X509Certificate> trustedCAs) {
        this.trustedCAs = trustedCAs;
    }

    public boolean verify(X509Certificate serverCert) {
        try {
            for (X509Certificate caCert : trustedCAs) {
                try {
                    serverCert.verify(caCert.getPublicKey());
                    serverCert.checkValidity();
                    return true;
                } catch (Exception e) {
                    // Ignore and try next CA
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
