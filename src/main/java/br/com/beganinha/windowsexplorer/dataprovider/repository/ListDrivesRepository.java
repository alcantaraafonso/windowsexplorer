package br.com.beganinha.windowsexplorer.dataprovider.repository;

import br.com.beganinha.windowsexplorer.dataprovider.repository.entity.DriverEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListDrivesRepository {

    public List<DriverEntity> listDrivers() {
        File[] drives = File.listRoots();
        List<DriverEntity> drivers = new ArrayList<>();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                drivers.add(DriverEntity.builder()
                        .letter(aDrive.toString())
                        .totalCapicty(aDrive.getTotalSpace())
                        .freeCapicty(aDrive.getFreeSpace())
                        .build());
            }
        }
        return drivers;
    }
}
