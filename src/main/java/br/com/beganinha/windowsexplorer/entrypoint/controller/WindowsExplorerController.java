package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import br.com.beganinha.windowsexplorer.dataprovider.ui.impl.ClassTreeView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import static br.com.beganinha.windowsexplorer.dataprovider.ui.impl.ControllerTableView.Fx2;
//import static br.com.beganinha.windowsexplorer.dataprovider.ui.impl.ControllerTilesView.Fx3;

@Controller
public class WindowsExplorerController implements Initializable {
    @FXML
    private Button btn;
    @FXML
    private Pane secPane;
    @FXML
    private TreeView<String> treeview;
    @FXML
    private Label label;
    private int count;

    @Autowired
    static ClassTreeView classTreeViewMain;

    private FileInfoUseCase fileInfoUseCase;
    private ApplicationContext context = SpringContext.getAppContext();


    //public static FileExplorerFx Fx2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = 0;
        classTreeViewMain = new ClassTreeView();

        classTreeViewMain.setCurrDirFile(new File("./"));
        classTreeViewMain.setCurrDirStr(classTreeViewMain.getCurrDirFile().getAbsolutePath());
        classTreeViewMain.setLbl(label);

//        Fx2.lbl = label;

        label.setText(classTreeViewMain.getCurrDirStr());
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getClassLoader().getResource("Scene2.fxml"));
            secPane.getChildren().add(newLoadedPane);
        } catch (NullPointerException x) {
            x.printStackTrace();
        } catch (IOException x) {
            x.printStackTrace();
        }
        classTreeViewMain.createTreeView(treeview);
//        Fx2.CreateTableView();// okhan theke dile error dey :/
    }

    @FXML
    public void handleMouseClicked(MouseEvent mouseEvent) {
        fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");

        if (mouseEvent.getClickCount() == 1) {
            try {
                TreeItem<String> item = treeview.getSelectionModel().getSelectedItem();
                classTreeViewMain.setCurrDirName(item.getValue());
                System.out.println("Selected Text : " + item.getValue());
                classTreeViewMain.setCurrDirFile(new File(fileInfoUseCase.findAbsolutePath(item, item.getValue())));
                classTreeViewMain.setCurrDirStr(classTreeViewMain.getCurrDirFile().getAbsolutePath());
                label.setText(classTreeViewMain.getCurrDirStr());
//                Fx2.tableview.getItems().clear();
//                Fx2.createTableView();
//                Fx3.createTiles();
                /**tableview.getItems().clear();
                 CreateTableView();
                 /**call some other function to activate createtableview() in corres controller */
            } catch (Exception x) {
                System.out.println(x.getMessage());
            }
        }
        //Fx2.tableview.getItems().clear();
        //Fx2.CreateTableView();
    }

    @FXML
    public void loadFxml(ActionEvent event) throws IOException {
        count = (count + 1) % 2;
        Pane newLoadedPane;
        secPane.getChildren().clear();
        if (count == 0) {
            newLoadedPane = FXMLLoader.load(getClass().getClassLoader().getResource("/Scene2.fxml"));
        } else {
            newLoadedPane = FXMLLoader.load(getClass().getClassLoader().getResource("/Scene3.fxml"));
        }
        secPane.getChildren().add(newLoadedPane);
    }

}
