module com.example.ssl_tsl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.bouncycastle.provider;
    requires org.bouncycastle.pkix;
    requires org.bouncycastle.util;
    opens com.example.ssl_tsl to javafx.fxml;
    exports com.example.ssl_tsl;
}