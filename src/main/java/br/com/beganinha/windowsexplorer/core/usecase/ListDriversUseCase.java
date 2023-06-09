package br.com.beganinha.windowsexplorer.core.usecase;

import br.com.beganinha.windowsexplorer.core.domain.Driver;

import java.io.File;
import java.util.List;

public interface ListDriversUseCase {

    public List<Driver> listDrivers();

    public boolean IsDrive(File f);
}
