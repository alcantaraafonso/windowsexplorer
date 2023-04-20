package br.com.beganinha.windowsexplorer.entrypoint.controller;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplicationSupport extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        SpringApplicationBuilder builder = new
                SpringApplicationBuilder(JavaFxApplicationSupport.class);
        builder.application()
                .setWebApplicationType(WebApplicationType.NONE);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        VBox boxConteudo = new VBox();
//        boxConteudo.setAlignment(Pos.CENTER);
//        boxConteudo.setSpacing(10);
//        boxConteudo.getStyleClass().add("conteudo");
//
////        String cssPath = getClass().getResource("/br/com/beganinha/windowsexplorer/dataprovider/ui/winexplorer.css").toExternalForm();
//        Scene scene = new Scene(boxConteudo, 400, 400);
////        scene.getStylesheets().add(cssPath);
//        stage.setScene(scene);
//        stage.show();
///br/com/beganinha/windowexplorer/dataprovider/ui/

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-scene.fxml"));
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
