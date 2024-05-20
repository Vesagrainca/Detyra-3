package com.example.ssl_tsl;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

public class CertificateMessage {
    private X509Certificate certificate;

    public CertificateMessage(X509Certificate certificate) {
        this.certificate = certificate;
    }

    public byte[] toByteArray() throws CertificateEncodingException {
        return certificate.getEncoded();
    }
}
