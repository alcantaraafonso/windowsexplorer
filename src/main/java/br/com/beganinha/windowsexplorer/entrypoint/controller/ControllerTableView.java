package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.core.domain.File;
import br.com.beganinha.windowsexplorer.dataprovider.ui.FileExplorerFx;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ControllerTableView implements Initializable {
    @FXML private TableView<File> tableview;
    @FXML private TableColumn<File, ImageView> image;
    @FXML private TableColumn<File, String> date;
    @FXML private TableColumn<File, String> name;
    @FXML private TableColumn<File, String> size;
    private Desktop desktop;
    public ObservableList<File> list;
    public static FileExplorerFx fileExplorerFx;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void handleTableMouseClicked(MouseEvent mouseEvent){

    }
}
