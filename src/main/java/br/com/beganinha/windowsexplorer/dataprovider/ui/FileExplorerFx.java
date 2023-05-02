package br.com.beganinha.windowsexplorer.dataprovider.ui;

import br.com.beganinha.windowsexplorer.core.domain.FileInfo;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

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

    TableView<FileInfo> tableview;
    TableColumn<FileInfo, ImageView> image;
    TableColumn<FileInfo, String> date;
    TableColumn<FileInfo, String> name;
    TableColumn<FileInfo, String> size;

    FileExplorerFx() {
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
        String s;
        long sizeInByte = 0;
        Path path;
        if (IsDrive(f)) {
            return Long.toString(f.getTotalSpace() / (1024 * 1024 * 1024)) + "GB";
        }

        path = Paths.get(f.toURI());
        //sizeInByte = f.getTotalSpace(); // terrible idea cz sob subfolder e 199GB, 99GB esob dekhay >_<
        try {
            sizeInByte = Files.size(path);//at least works ^_^
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (sizeInByte < (1024)) {
            s = Long.toString(sizeInByte) + "B";
            return s;
        } else if (sizeInByte >= (1024) && sizeInByte < (1024 * 1024)) {
            long sizeInKb = sizeInByte / 1024;
            s = Long.toString(sizeInKb) + "KB";
            return s;
        } else if (sizeInByte >= (1024 * 1024) && sizeInByte < (1024 * 1024 * 1024)) {
            long sizeInMb = sizeInByte / (1024 * 1024);
            s = Long.toString(sizeInMb) + "MB";
            return s;
        } else if (sizeInByte >= (1024 * 1024 * 1024)) {
            long sizeInGb = sizeInByte / (1024 * 1024 * 1024);
            s = Long.toString(sizeInGb) + "GB";
            return s;
        }

        return null;
    }

    //TODO criar um caso de uso e colocar este método neste
    public boolean IsDrive(java.io.File f) {
        java.io.File[] sysroots = java.io.File.listRoots();
        for (int i = 0; i < sysroots.length; i++) {
            if (f.equals(sysroots[i])) return true;
        }
        return false;
    }
//    @Override
//    public String FindAbsolutePath(TreeItem<String> item, String s) {
//        return null;
//    }

    //TODO criar um caso de uso e colocar este método neste
    @Override
    public int filesHiddensCount(java.io.File dir) {
        int count = 0;
        java.io.File[] fl = dir.listFiles();
        //System.out.println(fl.length);
        for(int i=0; i<fl.length; i++){
            try{if(fl[i].isHidden() || fl[i].isFile()) count++; }
            catch(Exception x){
                System.out.println("Exception at prototype1, fileexplorer CountDir: "+x.getMessage());
            }

        }
        return count;
    }
}
