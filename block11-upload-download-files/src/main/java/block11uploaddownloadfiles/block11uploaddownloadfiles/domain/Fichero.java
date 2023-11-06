package block11uploaddownloadfiles.block11uploaddownloadfiles.domain;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.Builder;
import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fichero {
    @Id
    @GeneratedValue
    Long idFichero;
    String name;
    String tipo;
    String ruta;
    Date fechaSubida;
    String categoria;



}
