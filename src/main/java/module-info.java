module ma.ensi.ensidesktopapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens ma.ensi.ensidesktopapp to javafx.fxml;
    opens ma.ensi.ensidesktopapp.controller to javafx.fxml;
    opens ma.ensi.ensidesktopapp.model to javafx.base;
    exports ma.ensi.ensidesktopapp;
}
