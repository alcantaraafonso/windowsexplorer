package br.com.beganinha.windowsexplorer.core.usecase;

import javafx.scene.control.TreeItem;

public interface FileInfoUseCase {

    String calculateSize(java.io.File f);

    String findAbsolutePath(TreeItem<String> item, String s);

    boolean IsDrive(java.io.File f);

    int filesHiddensCount(java.io.File dir);


}
