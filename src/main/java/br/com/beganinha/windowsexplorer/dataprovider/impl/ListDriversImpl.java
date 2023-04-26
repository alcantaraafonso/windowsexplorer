package br.com.beganinha.windowsexplorer.dataprovider.impl;

import br.com.beganinha.windowsexplorer.core.dataprovider.ListDrivers;
import br.com.beganinha.windowsexplorer.core.domain.Driver;
import br.com.beganinha.windowsexplorer.dataprovider.repository.ListDrivesRepository;
import br.com.beganinha.windowsexplorer.dataprovider.repository.entity.DriverEntity;
import br.com.beganinha.windowsexplorer.dataprovider.repository.mapper.DriverEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListDriversImpl implements ListDrivers {

    @Autowired
    private ListDrivesRepository listDrivesRepository;

    @Autowired
    private DriverEntityMapper driverEntityMapper;

    @Override
    public List<Driver> listDrivers() {
        List<Driver> drivers = new ArrayList<>();

        List<DriverEntity> driverEntities = listDrivesRepository.listDrivers();
        drivers =  driverEntities.stream().map(entity -> driverEntityMapper.toDriver(entity)).toList();

        return drivers;
    }
}
