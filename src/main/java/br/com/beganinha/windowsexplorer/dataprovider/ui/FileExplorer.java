package br.com.beganinha.windowsexplorer.dataprovider.ui;

import br.com.beganinha.windowsexplorer.core.domain.FileInfo;
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
    TreeItem<String>[] TreeCreate(java.io.File dir);
    String calculateSize(java.io.File f);
    String FindAbsolutePath(TreeItem<String> item, String s);
    boolean IsDrive(java.io.File f);
    int filesHiddensCount(java.io.File dir);
    void CreateTreeView(TreeView<String> treeview);
    void CreateTableView(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date,
                         TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size);
    void CreateTableView();
    void CreateTilesView();
    void setLabelTxt();
    void Initiate();
    void setValues(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date,
                   TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size);
    void CreateTiles();
    /**********************/
    public int NumOfDirectChilds(java.io.File f);
}
