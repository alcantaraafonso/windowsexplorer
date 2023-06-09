module winexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.base;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires lombok;
    requires org.mapstruct;
    requires java.desktop;
    // add other required JavaFX modules here

    opens br.com.beganinha.windowsexplorer.entrypoint.controller;
    opens br.com.beganinha.windowsexplorer.dataprovider.ui;
    opens br.com.beganinha.windowsexplorer.config;
    opens br.com.beganinha.windowsexplorer.dataprovider.impl;
    opens br.com.beganinha.windowsexplorer.dataprovider.repository;
    opens br.com.beganinha.windowsexplorer.dataprovider.repository.mapper;
    opens br.com.beganinha.windowsexplorer;
    opens br.com.beganinha.windowsexplorer.dataprovider.ui.impl;
    opens br.com.beganinha.windowsexplorer.core.usecase;
    opens br.com.beganinha.windowsexplorer.core.domain;
}