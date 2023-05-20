package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import static br.com.beganinha.windowsexplorer.dataprovider.ui.impl.ControllerTableView.Fx2;
//import static br.com.beganinha.windowsexplorer.dataprovider.ui.impl.ControllerTilesView.Fx3;

@Controller
public class ControllerTreeView implements Initializable {
    @FXML
    private Button btn;
    @FXML
    private Pane secPane;
    @FXML
    private TreeView<String> treeview;
    @FXML
    private Label label;
    private int count;
    private String currDirStr;
    private java.io.File currDirFile;
    private String currDirName;

    private ApplicationContext context;
    private FileInfoUseCase fileInfoUseCase;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        count = 0;

        currDirFile = new File("./");
        currDirStr = currDirFile.getAbsolutePath();

//        Fx2.lbl = label;

        label.setText(currDirStr);
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getClassLoader().getResource("Scene2.fxml"));
            secPane.getChildren().add(newLoadedPane);
        } catch (NullPointerException x) {
            x.printStackTrace();
        } catch (IOException x) {
            x.printStackTrace();
        }
        createTreeView(treeview);
//      Fx2.CreateTableView();// okhan theke dile error dey :/
    }

    @FXML
    public void handleMouseClicked(MouseEvent mouseEvent) {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");

        if (mouseEvent.getClickCount() == 1) {
            try {
                TreeItem<String> item = treeview.getSelectionModel().getSelectedItem();
                currDirName = item.getValue();
                System.out.println("Selected Text : " + item.getValue());
                currDirFile = new File(fileInfoUseCase.findAbsolutePath(item, item.getValue()));
                currDirStr = currDirFile.getAbsolutePath();
                label.setText(currDirStr);
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

    public TreeItem<String>[] treeCreate(java.io.File dir) {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");

        TreeItem<String>[] A = null;
        java.io.File[] fl = dir.listFiles();

//        System.out.println("dir.listFiles(): " + dir.listFiles());

        //Avaliar uma forma de useCase a partir do controller e não da View
        int n = fl.length - fileInfoUseCase.filesHiddensCount(dir);
        A = new TreeItem[n];
        int pos = 0;
        for (int i = 0; i < fl.length; i++) {

            if (!fl[i].isFile() && !fl[i].isHidden() && fl[i].isDirectory() && n == 0) {
                //TODO carregar a imagem
                A[pos] = new TreeItem<>(fl[i].getName(), new ImageView(new Image(getClass().getClassLoader().getResource("folderOpen.png").toString()))); //new ImageView(new Image(ClassLoader.getSystemResourceAsStream("br/com/beganinha/windowsexplorer/dataprovider/ui/impl/img/folderOpen.png")))
                pos++;
            } else if (!fl[i].isFile() && !fl[i].isHidden() && fl[i].isDirectory() && n > 0) {
                //TODO carregar a imagem
                A[pos] = new TreeItem<>(fl[i].getName(), new ImageView(new Image(getClass().getClassLoader().getResource("folderOpen.png").toString())));
                try {
                    A[pos].getChildren().addAll(treeCreate(fl[i]));
                    pos++;
                } catch (Exception x) {
                    System.out.println("Exception x in treecreate at " + fl[i].getAbsolutePath() + " " + x.getMessage());
                }
            }
        }

        return A;

    }

    public void createTreeView(TreeView<String> treeview) {
        java.io.File[] sysroots = java.io.File.listRoots();
        //TODO carregar a imagem
        TreeItem<String> ThisPc = new TreeItem<>("This PC", new ImageView(new Image(getClass().getClassLoader().getResource("pc.png").toString()))); //new ImageView(new Image(ClassLoader.getSystemResourceAsStream("br/com/beganinha/windowsexplorer/dataprovider/ui/impl/img/pc.png")))
        TreeItem<String>[] drives = new TreeItem[sysroots.length];
        for (int i = 0; i < sysroots.length; i++) {
            //TODO carregar a imagem
            drives[i] = new TreeItem<>(sysroots[i].getAbsolutePath(), new ImageView(new Image(getClass().getClassLoader().getResource("thumb_Hard_Drive.png").toString()))); //new ImageView(new Image(ClassLoader.getSystemResourceAsStream("br/com/beganinha/windowsexplorer/dataprovider/ui/impl/img/thumb_Hard_Drive.png")))
            try {
                drives[i].getChildren().addAll(treeCreate(sysroots[i]));
            } catch (NullPointerException x) {
                System.out.println("Exeption x detected: " + x.fillInStackTrace() + drives[i].toString());
            } finally {
                ThisPc.getChildren().add(drives[i]);
            }
        }
        treeview.setRoot(ThisPc);
    }

}
