package br.com.beganinha.windowsexplorer.dataprovider.ui;

import br.com.beganinha.windowsexplorer.core.domain.File;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface FileExplorer {
    /**this class will contain all the method's name. as other derived classes
     * will be created, they will implement necessary methods accordingly...*/
    Image getIconImageFX(java.io.File f);
    TreeItem<String>[] treeCreate(java.io.File dir);

    void createTreeView(TreeView<String> treeview);
    void createTableView(TableView<File> tableview, TableColumn<File, ImageView> image, TableColumn<File, String> date,
                         TableColumn<File, String> name, TableColumn<File, String> size);
    void createTableView();
    void createTilesView();
    void setLabelTxt();
    void initiate();
    void setValues(TableView<File> tableview, TableColumn<File, ImageView> image, TableColumn<File, String> date,
                   TableColumn<File, String> name, TableColumn<File, String> size);
    void createTiles();

    /**all these methods are implemented at FileInfoRepository **/
//    String calculateSize(java.io.File f);
//    String findAbsolutePath(TreeItem<String> item, String s);
//    boolean IsDrive(java.io.File f);
//    int filesHiddensCount(java.io.File dir);

//    public int numOfDirectChilds(java.io.File f);
}
