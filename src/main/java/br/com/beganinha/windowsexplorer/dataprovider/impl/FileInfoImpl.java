package br.com.beganinha.windowsexplorer.dataprovider.impl;

import br.com.beganinha.windowsexplorer.core.dataprovider.FileInfo;
import br.com.beganinha.windowsexplorer.dataprovider.repository.FileInfoRepository;
import javafx.scene.control.TreeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileInfoImpl implements FileInfo {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public String calculateSize(File f) {
        return null;
    }

    @Override
    public String findAbsolutePath(TreeItem<String> item, String s) {
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
