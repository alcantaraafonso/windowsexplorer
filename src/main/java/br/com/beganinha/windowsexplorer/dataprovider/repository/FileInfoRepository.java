package br.com.beganinha.windowsexplorer.dataprovider.repository;

import javafx.scene.control.TreeItem;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileInfoRepository {

    //TODO trazer as implementações para cá

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

    public boolean IsDrive(java.io.File f) {
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
        for(int i=0; i<fl.length; i++){
            try{if(fl[i].isHidden() || fl[i].isFile()) count++; }
            catch(Exception x){
                System.out.println("Exception at prototype1, fileexplorer CountDir: "+x.getMessage());
            }

        }
        return count;
    }

    public String FindAbsolutePath(TreeItem<String> item, String s) {
        return null;
    }
}
