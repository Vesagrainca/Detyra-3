package com.example.ssl_tsl;

import javax.crypto.KeyAgreement;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

public class DiffieHellmanKeyExchange {
    private KeyPair keyPair;
    private KeyAgreement keyAgreement;

    public DiffieHellmanKeyExchange() throws NoSuchAlgorithmException, InvalidKeyException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        kpg.initialize(2048);
        this.keyPair = kpg.generateKeyPair();
        this.keyAgreement = KeyAgreement.getInstance("DH");
        this.keyAgreement.init(this.keyPair.getPrivate());
    }

    public byte[] getPublicKey() {
        return this.keyPair.getPublic().getEncoded();
    }

    public void receivePublicKey(byte[] publicKeyBytes) throws Exception {
        KeyFactory kf = KeyFactory.getInstance("DH");
        PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        this.keyAgreement.doPhase(publicKey, true);
    }

    public byte[] generateSharedSecret() {
        return this.keyAgreement.generateSecret();
    }
}

