module winexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    // add other required JavaFX modules here

    exports br.com.beganinha.windowsexplorer.entrypoint.controller;
}