package br.com.beganinha.windowsexplorer.dataprovider.repository.mapper;

import br.com.beganinha.windowsexplorer.core.domain.Driver;
import br.com.beganinha.windowsexplorer.dataprovider.repository.entity.DriverEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverEntityMapper {
    Driver toDriver(DriverEntity driverEntity);
}
