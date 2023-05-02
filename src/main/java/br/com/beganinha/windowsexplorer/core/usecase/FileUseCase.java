package br.com.beganinha.windowsexplorer.core.usecase;

import javafx.scene.control.TreeItem;

import java.io.File;

public interface FileUseCase {

    String calculateSize(java.io.File f);

    String FindAbsolutePath(TreeItem<String> item, String s);

    boolean IsDrive(java.io.File f);

    int filesHiddensCount(java.io.File dir);


}
