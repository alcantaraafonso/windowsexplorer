package br.com.beganinha.windowsexplorer.entrypoint.controller;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerTileView implements Initializable {

    @FXML
    private TilePane tilePane;

//    private Label label;

    //    private int count;
    private String currDirStr;
    private java.io.File currDirFile;
    private String currDirName;

    private ApplicationContext context;
    private FileInfoUseCase fileInfoUseCase;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");

        createTiles();
    }

    public void createTiles() {

        File[] fl;
        if (currDirFile == null) {
            currDirFile = new File("./");
        }
        fl = currDirFile.listFiles();
        if (currDirName.equals("This PC")) {
            fl = File.listRoots();
        }
        int len = fl.length;
        //Pane newLoadedPane[]=new Pane[len];
        tilePane.getChildren().clear();
        for (int i = 0; i < len; i++) {
            //Label temp = new Label();
            Label title = new Label(fl[i].getName());
            title.setId(fl[i].getName());
            ImageView imageview = new ImageView(fileInfoUseCase.getIconImageFX(fl[i]));
            VBox vbox = new VBox();
            vbox.setId(fl[i].getName());
            vbox.getChildren().addAll(imageview, title);

            vbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getClickCount() == 2) {
                        System.out.println("Tile pressed " + vbox.getId());
                        String str = vbox.getId();
                        String str1 = currDirStr + "\\" + str;
                        File f = new File(str1);
                        if (f.isFile()) {
                            Desktop d = Desktop.getDesktop();
                            try {
                                d.open(f);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            currDirStr = str1;
                            currDirFile = new File(currDirStr);
//                            setLabelTxt();
                            tilePane.getChildren().clear();
                            createTiles();
                        }

                    }
                }
            });

            TilePane.setAlignment(vbox, Pos.BOTTOM_LEFT);

            tilePane.getChildren().add(vbox);
        }

    }

}
