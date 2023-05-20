package br.com.beganinha.windowsexplorer.dataprovider.repository;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static javafx.embed.swing.SwingFXUtils.toFXImage;

@Component
public class FileInfoRepository {

    //TODO trazer as implementações para cá

    public String calculateSize(java.io.File f) {
        String s;
        long sizeInByte = 0;
        Path path;
        if (isDrive(f)) {
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

    public boolean isDrive(java.io.File f) {
        java.io.File[] sysroots = java.io.File.listRoots();
        for (int i = 0; i < sysroots.length; i++) {
            if (f.equals(sysroots[i])) return true;
        }
        return false;
    }

    public int filesHiddensCount(java.io.File dir) {
        int count = 0;
        java.io.File[] fl = dir.listFiles();
        //System.out.println(fl.length);
        for (int i = 0; i < fl.length; i++) {
            try {
                if (fl[i].isHidden() || fl[i].isFile()) count++;
            } catch (Exception x) {
                System.out.println("Exception at prototype1, fileexplorer CountDir: " + x.getMessage());
            }

        }
        return count;
    }

    public String findAbsolutePath(TreeItem<String> item, String s) {
        if ((item.getParent() == null) || (item.getParent().getValue().equals("This PC"))) {
            return s;
        } else {
            String dir = item.getParent().getValue();
            dir = dir + "\\" + s;
            return findAbsolutePath(item.getParent(), dir);
        }
    }

    public int numOfDirectChilds(java.io.File f) {
        return 0;
    }

    public Image getIconImageFX(java.io.File f) {
        ImageIcon icon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(f);
        java.awt.Image img = icon.getImage();
        BufferedImage bimg = (BufferedImage) img;
        Image imgfx = toFXImage(bimg, null);

        return imgfx;
    }
}
