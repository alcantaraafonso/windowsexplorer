package br.com.beganinha.windowsexplorer.dataprovider.ui;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.domain.File;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import br.com.beganinha.windowsexplorer.core.usecase.ListDriversUseCase;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import static javafx.embed.swing.SwingFXUtils.toFXImage;

public abstract class FileExplorerFx implements FileExplorer {

    static java.io.File CurrDirFile;
    static String CurrDirStr;
    static Label lbl;
    static String CurrDirName;
    static TilePane tilePane;
    SimpleDateFormat sdf;

    TableView<File> tableview;
    TableColumn<File, ImageView> image;
    TableColumn<File, String> date;
    TableColumn<File, String> name;
    TableColumn<File, String> size;

    private FileInfoUseCase fileInfoUseCase;
    private ApplicationContext context;

    public FileExplorerFx() {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase)context.getBean("fileInfoUseCase");
    }

    @Override
    public Image getIconImageFX(java.io.File f) {
        ImageIcon icon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(f);
        java.awt.Image img = icon.getImage();
        BufferedImage bimg = (BufferedImage) img;
        Image imgfx = toFXImage(bimg, null); //Java Swing Image to Java FX Image
        return imgfx;
    }

    @Override
    public void setLabelTxt() {
        lbl.setText(CurrDirStr);
    }

    //TODO criar um caso de uso e colocar este método neste
    public String calculateSize(java.io.File f) {
        return fileInfoUseCase.calculateSize(f);

    }

    //TODO criar um caso de uso e colocar este método neste
    public boolean IsDrive(java.io.File f) {
        return fileInfoUseCase.IsDrive(f);
    }

    //TODO criar um caso de uso e colocar este método neste
    @Override
    public int filesHiddensCount(java.io.File dir) {
        return fileInfoUseCase.filesHiddensCount(dir);
    }
}
