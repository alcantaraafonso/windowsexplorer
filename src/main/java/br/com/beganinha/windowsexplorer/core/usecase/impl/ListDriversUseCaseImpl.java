package br.com.beganinha.windowsexplorer.core.usecase.impl;

import br.com.beganinha.windowsexplorer.core.dataprovider.ListDrivers;
import br.com.beganinha.windowsexplorer.core.domain.Driver;
import br.com.beganinha.windowsexplorer.core.usecase.ListDriversUseCase;

import java.io.File;
import java.util.List;

public class ListDriversUseCaseImpl implements ListDriversUseCase {

    private final ListDrivers listDrivers;

    public ListDriversUseCaseImpl(ListDrivers listDrivers) {
        this.listDrivers = listDrivers;
    }

    @Override
    public List<Driver> listDrivers() {
        return listDrivers.listDrivers();
    }

    @Override
    public boolean IsDrive(File f) {
        return false;
    }
}
