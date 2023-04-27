package br.com.beganinha.windowsexplorer.config;

import br.com.beganinha.windowsexplorer.core.usecase.impl.ListDriversUseCaseImpl;
import br.com.beganinha.windowsexplorer.dataprovider.impl.ListDriversImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListDriversConfig {

    @Bean
    public ListDriversUseCaseImpl listDriversUseCase(ListDriversImpl listDriverImpl) {
        return new ListDriversUseCaseImpl(listDriverImpl);
    }

}
