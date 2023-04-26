module winexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires lombok;
    requires org.mapstruct;
    // add other required JavaFX modules here

    opens br.com.beganinha.windowsexplorer.entrypoint.controller;
    opens br.com.beganinha.windowsexplorer.entrypoint;
    opens br.com.beganinha.windowsexplorer.dataprovider.ui;
}