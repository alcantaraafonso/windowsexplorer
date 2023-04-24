package br.com.beganinha.windowsexplorer.dataprovider.ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main-scene.fxml"));
        Scene scene = new Scene(root, 800, 500);
        //primaryStage.set(true);
        primaryStage.setTitle("Windows Explorer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
