package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.domain.Driver;
import br.com.beganinha.windowsexplorer.core.usecase.ListDriversUseCase;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class WindowsExplorerController {
    @FXML
    private TextField teste;

//    @Autowired
    private ListDriversUseCase listDriversUseCase;

    public void entrar() {

        // Aqui iniciamos o contexto do SpringBoot chamando a class ApplicationContext atribuindo ela a variável context:
        ApplicationContext context = SpringContext.getAppContext();

        // Aqui chamamos o component do SpringBoot desejado,
        // fazendo com que ele receba a bean ListDriversUseCase vinda do ambiente do SpringBoot:
        listDriversUseCase = (ListDriversUseCase)context.getBean("listDriversUseCase");

        List<Driver> drivers = listDriversUseCase.listDrivers();
        drivers.stream().forEach(driver -> {
            System.out.println(driver.toString());
        });

        System.out.println("teste: " + teste.getText());
    }
}
