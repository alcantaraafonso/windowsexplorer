package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.domain.File;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static javafx.embed.swing.SwingFXUtils.toFXImage;

@Controller
public class ControllerTableView implements Initializable {
    @FXML
    private TableView<File> tableview;
    @FXML
    private TableColumn<File, ImageView> image;
    @FXML
    private TableColumn<File, String> date;
    @FXML
    private TableColumn<File, String> name;
    @FXML
    private TableColumn<File, String> size;
    private Desktop desktop;
    public ObservableList<File> list;

    private Label label;
    private int count;
    private String currDirStr;
    private java.io.File currDirFile;
    private String currDirName;

    private SimpleDateFormat sdf;

    private ApplicationContext context;
    private FileInfoUseCase fileInfoUseCase;

    private void setValues(TableView<File> tableview, TableColumn<File, ImageView> image, TableColumn<File, String> date,
                           TableColumn<File, String> name, TableColumn<File, String> size) {
        this.tableview = tableview;
        this.date = date;
        this.name = name;
        this.size = size;
        this.image = image;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");

        setValues(tableview, image, date, name, size);
        if (currDirFile == null) {
            currDirFile = new java.io.File("./");
            currDirStr = currDirFile.getAbsolutePath();
        }
        //Fx2.CreateTableView(); jehetu mara khay, tai alada kore code likhe dekhi hoy kina :'(
        /***/
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            java.io.File[] fl;
            ObservableList<File> list;
            if (currDirFile == null) {
                currDirFile = new java.io.File("./");
            }
            //if(Fx2.CurrDirName.equals("This PC")){  fl = File.listRoots();}
            {
                fl = currDirFile.listFiles();
            }
            // donot delete . original
            File st[] = new File[fl.length];
            for (int i = 0; i < fl.length; i++) {
                String s1 = null;
                String s2 = null;
                String s3 = null;
                ImageView img = null;
                try {
                    if (fileInfoUseCase.isDrive(fl[i])) {
                        img = new ImageView(fileInfoUseCase.getIconImageFX(fl[i]));
                        s1 = fl[i].getAbsolutePath();
                    } else {
                        img = new ImageView(fileInfoUseCase.getIconImageFX(fl[i]));
                        s1 = fl[i].getName();
                    }
                    s2 = fileInfoUseCase.calculateSize(fl[i]);
                    s3 = sdf.format(fl[i].lastModified());
                } catch (Exception x) {
                    System.out.println("Exception detected in tableview strings: " + x.getMessage());
                }
                st[i] = new File(img, s1, s2, s3);
            }

            list = FXCollections.observableArrayList(st);

            //id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
            image.setCellValueFactory(new PropertyValueFactory<>("image"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            size.setCellValueFactory(new PropertyValueFactory<>("size"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            tableview.setItems(list);
        }
    }

    @FXML
    public void handleTableMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            String str = tableview.getSelectionModel().getSelectedItem().getName();
            String s = currDirStr + "\\" + str;
            System.out.println(s);
            java.io.File file = new java.io.File(s);
            if (file.isDirectory()) {
                try {
                    currDirFile = file;
                    currDirStr = currDirFile.getAbsolutePath();
                    //Fx2.setLabelTxt();
                    tableview.getItems().clear();
                    createTableView();
                } catch (Exception x) {
                    System.out.println(x.getMessage());
                }
            } else if (file.isFile()) {
                desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException x) {
                    System.out.println(x.getMessage());
                }
            }
        }
    }

    public void createTableView() {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");

        sdf = new SimpleDateFormat("dd/MM/yy");
        java.io.File[] fl;
        ObservableList<File> list;
        if (currDirFile == null) {
            currDirFile = new java.io.File("./");
        }
        if (currDirName.equals("This PC")) {
            fl = java.io.File.listRoots();
        } else {
            fl = currDirFile.listFiles();
        }
        // donot delete . original
        File st[] = new File[fl.length];
        for (int i = 0; i < fl.length; i++) {
            String s1 = null;
            String s2 = null;
            String s3 = null;
            ImageView img = null;
            try {
                if (fileInfoUseCase.isDrive(fl[i])) {
                    img = new ImageView(fileInfoUseCase.getIconImageFX(fl[i]));
                    s1 = fl[i].getAbsolutePath();
                } else {
                    img = new ImageView(fileInfoUseCase.getIconImageFX(fl[i]));
                    s1 = fl[i].getName();
                }
                s2 = fileInfoUseCase.calculateSize(fl[i]);
                s3 = sdf.format(fl[i].lastModified());
            } catch (Exception x) {
                System.out.println("Exception detected in tableview strings: " + x.getMessage());
            }
            st[i] = new File(img, s1, s2, s3);
        }

        list = FXCollections.observableArrayList(st);

        //id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableview.setItems(list);
    }
}
