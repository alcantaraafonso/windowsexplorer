package br.com.beganinha.windowsexplorer.entrypoint.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WindowsExplorerController {
    @FXML
    private TextField teste;

    public void entrar() {
        System.out.println("teste: " + teste.getText());
    }
}
