package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.core.domain.Driver;
import br.com.beganinha.windowsexplorer.core.usecase.ListDriversUseCase;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class WindowsExplorerController {
    @FXML
    private TextField teste;

    @Autowired
    private ListDriversUseCase listDriversUseCase;

    public void entrar() {

        List<Driver> drivers = listDriversUseCase.listDrivers();
        drivers.stream().forEach(driver -> {
            System.out.println(driver);
        });

        System.out.println("teste: " + teste.getText());
    }
}
