package com.example.ssl_tsl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML
    private Button handshakeButton;

    @FXML
    private TextArea logArea;

    @FXML
    public void initialize() {
        handshakeButton.setOnAction(event -> {
            logArea.clear();
            logArea.appendText("Starting SSL/TLS Handshake...\n");

            try {
                SSLHandshake simulation = new SSLHandshake(logArea);
                simulation.runHandshake();
            } catch (Exception e) {
                logArea.appendText("Error during handshake: " + e.getMessage());
            }
        });
    }
}
