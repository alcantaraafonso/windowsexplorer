package br.com.beganinha.windowsexplorer.core.usecase.impl;

import br.com.beganinha.windowsexplorer.core.usecase.FileUseCase;
import javafx.scene.control.TreeItem;

import java.io.File;

public class FileUseCaseImpl implements FileUseCase {
    @Override
    public String calculateSize(File f) {
        return null;
    }

    @Override
    public String FindAbsolutePath(TreeItem<String> item, String s) {
        return null;
    }

    @Override
    public boolean IsDrive(File f) {
        return false;
    }

    @Override
    public int filesHiddensCount(File dir) {
        return 0;
    }
}
