package br.com.beganinha.windowsexplorer.core.dataprovider;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;

public interface FileInfo {
    String calculateSize(java.io.File f);

    String findAbsolutePath(TreeItem<String> item, String s);

    boolean isDrive(java.io.File f);

    int filesHiddensCount(java.io.File dir);

    Image getIconImageFX(java.io.File f);
}
