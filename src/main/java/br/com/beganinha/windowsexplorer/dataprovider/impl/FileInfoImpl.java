package br.com.beganinha.windowsexplorer.dataprovider.impl;

import br.com.beganinha.windowsexplorer.core.dataprovider.FileInfo;
import br.com.beganinha.windowsexplorer.dataprovider.repository.FileInfoRepository;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileInfoImpl implements FileInfo {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public String calculateSize(File f) {
        return fileInfoRepository.calculateSize(f);
    }

    @Override
    public String findAbsolutePath(TreeItem<String> item, String s) {
        return fileInfoRepository.findAbsolutePath(item, s);
    }

    @Override
    public boolean isDrive(File f) {
        return fileInfoRepository.isDrive(f);
    }

    @Override
    public int filesHiddensCount(File dir) {
        return fileInfoRepository.filesHiddensCount(dir);
    }

    @Override
    public Image getIconImageFX(File f) {
        return fileInfoRepository.getIconImageFX(f);
    }


}
