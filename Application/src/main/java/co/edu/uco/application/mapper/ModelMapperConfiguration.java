package co.edu.uco.application.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Juan Felipe Cardona;
 * Email: felipe7u7432@gmail.com
 * @version id: <b>CarpoolingUCO_SWIV/b> 17/4/2024, 01:28
 **/
@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
