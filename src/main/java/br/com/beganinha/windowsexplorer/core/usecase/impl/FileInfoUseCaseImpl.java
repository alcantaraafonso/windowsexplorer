package br.com.beganinha.windowsexplorer.core.usecase.impl;

import br.com.beganinha.windowsexplorer.core.dataprovider.FileInfo;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;

import java.io.File;

public class FileInfoUseCaseImpl implements FileInfoUseCase {

    private final FileInfo fileInfo;

    public FileInfoUseCaseImpl(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    @Override
    public String calculateSize(File f) {
        return fileInfo.calculateSize(f);
    }

    @Override
    public String findAbsolutePath(TreeItem<String> item, String s) {
        return null;
    }

    @Override
    public boolean isDrive(File f) {
        return false;
    }

    @Override
    public int filesHiddensCount(File dir) {
        return 0;
    }

    @Override
    public Image getIconImageFX(File f) {
        return fileInfo.getIconImageFX(f);
    }


}
