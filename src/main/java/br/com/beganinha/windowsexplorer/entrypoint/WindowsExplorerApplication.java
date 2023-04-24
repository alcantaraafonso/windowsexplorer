package br.com.beganinha.windowsexplorer.entrypoint;

import br.com.beganinha.windowsexplorer.dataprovider.ui.JavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WindowsExplorerApplication {

    public static void main(String[] args) {
        // This is how normal Spring Boot app would be launched
        // JavaFxApplicationSupport is launched from the main method of WindowsExplorerApplication.class

        JavaFxApplicationSupport.main(args);
    }
}
