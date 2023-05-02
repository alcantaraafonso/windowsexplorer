package br.com.beganinha.windowsexplorer;

import br.com.beganinha.windowsexplorer.dataprovider.ui.impl.JavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WindowsExplorerApplication {

    public static void main(String[] args) {
        // This is how normal Spring Boot app would be launched
        // JavaFxApplicationSupport is launched from the main method of WindowsExplorerApplication.class

        JavaFxApplicationSupport.main(args);
    }
}
