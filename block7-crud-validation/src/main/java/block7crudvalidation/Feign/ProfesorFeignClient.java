package block7crudvalidation.Feign;


import block7crudvalidation.controller.dto.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "profesor-service", url = "http://localhost:8081")
@Component
public interface ProfesorFeignClient {

    @GetMapping("/profesor/{idProfesor}")
    ProfesorOutputDto getProfesor(@PathVariable("idProfesor") Long idProfesor);

}
