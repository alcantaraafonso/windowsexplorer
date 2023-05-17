package br.com.beganinha.windowsexplorer.dataprovider.ui.impl;

import br.com.beganinha.windowsexplorer.SpringContext;
import br.com.beganinha.windowsexplorer.core.domain.File;
import br.com.beganinha.windowsexplorer.core.usecase.FileInfoUseCase;
import br.com.beganinha.windowsexplorer.dataprovider.ui.FileExplorerFx;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.context.ApplicationContext;

public class ClassTreeView  { //extends FileExplorerFx

    private FileInfoUseCase fileInfoUseCase;
    private ApplicationContext context;

    public ClassTreeView() {
        this.context = SpringContext.getAppContext();
        this.fileInfoUseCase = (FileInfoUseCase) context.getBean("fileInfoUseCase");
    }

//    @Override
//    public TreeItem<String>[] treeCreate(java.io.File dir) {
//
//
//        TreeItem<String>[] A = null;
//        java.io.File[] fl = dir.listFiles();
//
////        System.out.println("dir.listFiles(): " + dir.listFiles());
//
//        //Avaliar uma forma de useCase a partir do controller e não da View
//        int n = fl.length - fileInfoUseCase.filesHiddensCount(dir);
//        A = new TreeItem[n];
//        int pos = 0;
//        for (int i = 0; i < fl.length; i++) {
//
//            if (!fl[i].isFile() && !fl[i].isHidden() && fl[i].isDirectory() && n == 0) {
//                //TODO carregar a imagem
//                A[pos] = new TreeItem<>(fl[i].getName(), new ImageView(new Image(getClass().getClassLoader().getResource("folderOpen.png").toString()))); //new ImageView(new Image(ClassLoader.getSystemResourceAsStream("br/com/beganinha/windowsexplorer/dataprovider/ui/impl/img/folderOpen.png")))
//                pos++;
//            } else if (!fl[i].isFile() && !fl[i].isHidden() && fl[i].isDirectory() && n > 0) {
//                //TODO carregar a imagem
//                A[pos] = new TreeItem<>(fl[i].getName(), new ImageView(new Image(getClass().getClassLoader().getResource("folderOpen.png").toString())));
//                try {
//                    A[pos].getChildren().addAll(treeCreate(fl[i]));
//                    pos++;
//                } catch (Exception x) {
//                    System.out.println("Exception x in treecreate at " + fl[i].getAbsolutePath() + " " + x.getMessage());
//                }
//            }
//        }
//
//        return A;
//
//    }
//
//    @Override
//    public void createTreeView(TreeView<String> treeview) {
//        java.io.File[] sysroots = java.io.File.listRoots();
//        //TODO carregar a imagem
//        TreeItem<String> ThisPc = new TreeItem<>("This PC", new ImageView(new Image(getClass().getClassLoader().getResource("pc.png").toString()))); //new ImageView(new Image(ClassLoader.getSystemResourceAsStream("br/com/beganinha/windowsexplorer/dataprovider/ui/impl/img/pc.png")))
//        TreeItem<String>[] drives = new TreeItem[sysroots.length];
//        for (int i = 0; i < sysroots.length; i++) {
//            //TODO carregar a imagem
//            drives[i] = new TreeItem<>(sysroots[i].getAbsolutePath(), new ImageView(new Image(getClass().getClassLoader().getResource("thumb_Hard_Drive.png").toString()))); //new ImageView(new Image(ClassLoader.getSystemResourceAsStream("br/com/beganinha/windowsexplorer/dataprovider/ui/impl/img/thumb_Hard_Drive.png")))
//            try {
//                drives[i].getChildren().addAll(treeCreate(sysroots[i]));
//            } catch (NullPointerException x) {
//                System.out.println("Exeption x detected: " + x.fillInStackTrace() + drives[i].toString());
//            } finally {
//                ThisPc.getChildren().add(drives[i]);
//            }
//        }
//        treeview.setRoot(ThisPc);
//    }

//    @Override
//    public void createTableView(TableView<File> tableview, TableColumn<File, ImageView> image, TableColumn<File, String> date, TableColumn<File, String> name, TableColumn<File, String> size) {
//
//    }
//
//    @Override
//    public void createTableView() {
//
//    }
//
//    @Override
//    public void createTilesView() {
//
//    }
//
//    @Override
//    public void initiate() {
//
//    }
//
//    @Override
//    public void setValues(TableView<File> tableview, TableColumn<File, ImageView> image, TableColumn<File, String> date, TableColumn<File, String> name, TableColumn<File, String> size) {
//
//    }
//
//    @Override
//    public void createTiles() {
//
//    }

//    public String findAbsolutePath(TreeItem<String> item, String s) {
//        //acessar o useCase do controller
//        return null;
//        //return fileInfoUseCase.findAbsolutePath(item, s);
//    }
}
