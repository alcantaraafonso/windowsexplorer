package br.com.beganinha.windowsexplorer.dataprovider.impl;

import br.com.beganinha.windowsexplorer.core.dataprovider.ListDrivers;
import br.com.beganinha.windowsexplorer.core.domain.Driver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListDriversImpl implements ListDrivers {
    
    @Override
    public List<Driver> listDrivers() {
        return null;
    }
}
