package br.com.beganinha.windowsexplorer;

import br.com.beganinha.windowsexplorer.entrypoint.controller.MyController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
    public void start(Stage stage) throws Exception {
        VBox boxConteudo = new VBox();
        boxConteudo.setAlignment(Pos.CENTER);
        boxConteudo.setSpacing(10);
        boxConteudo.getStyleClass().add("conteudo");

        Scene scene = new Scene(boxConteudo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
