package br.com.beganinha.windowsexplorer;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class JavaFxApplicationSupport extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
//        SpringApplicationBuilder builder = new
//                SpringApplicationBuilder(JavaFxApplicationSupport.class);
//        builder.application()
//                .setWebApplicationType(WebApplicationType.NONE);
        ApplicationContextInitializer<GenericApplicationContext> initializer = ac -> {

            ac.registerBean(Application.class, () -> JavaFxApplicationSupport.this);
            ac.registerBean(Parameters.class, this::getParameters);
            ac.registerBean(HostServices.class, this::getHostServices);

        };
        this.applicationContext = new SpringApplicationBuilder().sources(WindowsExplorerApplication.class)
                .initializers(initializer).run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("TreeView.fxml"));
        Scene scene = new Scene(root);
        //primaryStage.set(true);
        primaryStage.setTitle("Windows Explorer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
