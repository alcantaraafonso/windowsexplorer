package br.com.beganinha.windowsexplorer.dataprovider.ui.impl;

import br.com.beganinha.windowsexplorer.core.domain.FileInfo;
import br.com.beganinha.windowsexplorer.dataprovider.ui.FileExplorerFx;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;

public class ClassTreeView extends FileExplorerFx {
    @Override
    public TreeItem<String>[] TreeCreate(java.io.File dir) {
        return new TreeItem[0];
    }

    @Override
    public String FindAbsolutePath(TreeItem<String> item, String s) {
        return null;
    }

    @Override
    public void CreateTreeView(TreeView<String> treeview) {

    }

    @Override
    public void CreateTableView(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size) {

    }

    @Override
    public void CreateTableView() {

    }

    @Override
    public void CreateTilesView() {

    }

    @Override
    public void Initiate() {

    }

    @Override
    public void setValues(TableView<FileInfo> tableview, TableColumn<FileInfo, ImageView> image, TableColumn<FileInfo, String> date, TableColumn<FileInfo, String> name, TableColumn<FileInfo, String> size) {

    }

    @Override
    public void CreateTiles() {

    }

    @Override
    public int NumOfDirectChilds(java.io.File f) {
        return 0;
    }
}
