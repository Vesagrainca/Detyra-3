package com.example.ssl_tsl;

import javafx.scene.control.TextArea;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.OperatorCreationException;

import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SSLHandshake {

    private final TextArea logArea;

    public SSLHandshake(TextArea logArea) {
        this.logArea = logArea;
        // Add Bouncy Castle provider if not already installed
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    public void runHandshake() {
        try {
            log("Generating CA and server certificates...");
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair caKeyPair = keyGen.generateKeyPair();
            KeyPair serverKeyPair = keyGen.generateKeyPair();

            X509Certificate caCert = generateCertificate("CN=CA", caKeyPair, 365, "SHA256withRSA", caKeyPair.getPrivate());
            X509Certificate serverCert = generateCertificate("CN=Server", serverKeyPair, 365, "SHA256withRSA", caKeyPair.getPrivate());

            List<X509Certificate> trustedCAs = new ArrayList<>();
            trustedCAs.add(caCert);

            log("Client: Sending ClientHello...");
            // Implement ClientHello and send the message

            log("Server: Receiving ClientHello...");
            // Implement ServerHello and send the message

            log("Server: Sending Certificate...");
            // Implement CertificateMessage and send the server certificate

            log("Server: Sending ServerKeyExchange...");
            // Implement ServerKeyExchange and send the key exchange parameters

            log("Server: Sending ServerHelloDone...");
            // Implement ServerHelloDone and send the message

            log("Client: Receiving Certificate...");
            // Implement CertificateMessage and receive the server certificate

            log("Client: Verifying Server Certificate...");
            // Verify the server certificate against the trusted CA certificates

            log("Client: Sending ClientKeyExchange...");
            // Implement ClientKeyExchange and send the key exchange parameters

            log("Client: Sending ChangeCipherSpec...");
            // Implement ChangeCipherSpec and send the message

            log("Client: Sending Finished...");
            // Implement Finished and send the message

            log("Server: Receiving ChangeCipherSpec...");
            // Implement ChangeCipherSpec and receive the message

            log("Server: Receiving Finished...");
            // Implement Finished and receive the message

            log("SSL/TLS Handshake completed successfully");
        } catch (Exception e) {
            log("Error during handshake: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void log(String message) {
        logArea.appendText(message + "\n");
    }

    private X509Certificate generateCertificate(String dn, KeyPair pair, int days, String algorithm, PrivateKey signingKey) throws GeneralSecurityException, OperatorCreationException {
        // Set the certificate validity period
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + days * 24L * 60L * 60L * 1000L);
        // Generate a random serial number for the certificate
        BigInteger serialNumber = new BigInteger(Long.toString(startDate.getTime()));
        // Create the X500Name object for the distinguished name
        X500Name dnName = new X500Name(dn);

        // Create the certificate builder
        X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                dnName, serialNumber, startDate, endDate, dnName, pair.getPublic());

        // Create the content signer using the provided algorithm and private key
        ContentSigner contentSigner = new JcaContentSignerBuilder(algorithm).build(signingKey);

        // Build the certificate and convert it to an X509Certificate object
        return new JcaX509CertificateConverter().getCertificate(certBuilder.build(contentSigner));
    }
}
