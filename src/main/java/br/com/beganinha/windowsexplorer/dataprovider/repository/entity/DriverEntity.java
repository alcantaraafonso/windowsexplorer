package br.com.beganinha.windowsexplorer.dataprovider.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverEntity {

    private String letter;
    private long totalCapicty;
    private long freeCapicty;

}
