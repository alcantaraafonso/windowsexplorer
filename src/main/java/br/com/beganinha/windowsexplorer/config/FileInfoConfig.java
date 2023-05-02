package br.com.beganinha.windowsexplorer.config;

import br.com.beganinha.windowsexplorer.core.dataprovider.FileInfo;
import br.com.beganinha.windowsexplorer.core.usecase.impl.FileInfoUseCaseImpl;
import br.com.beganinha.windowsexplorer.dataprovider.impl.FileInfoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileInfoConfig {

    @Bean
    public FileInfoUseCaseImpl fileInfoUseCase(FileInfoImpl fileInfoImpl) {
        return new FileInfoUseCaseImpl(fileInfoImpl);
    }
}
