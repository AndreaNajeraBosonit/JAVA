package block7crudvalidation.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;


@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public class RestTemplateConfig {

        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            return builder.build();
        }
    }


}
