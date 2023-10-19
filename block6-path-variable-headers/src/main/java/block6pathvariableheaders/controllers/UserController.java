package block6pathvariableheaders.controllers;

import block6pathvariableheaders.model.DatosEntrada;
import block6pathvariableheaders.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    private List<User> users = new ArrayList<>();

    //- Petición GET: mandando parámetros en el path (http://localhost:8080/user/{id}) y devolver el mismo id mandado
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        return user;
    }
        //Vertodo
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return  users;
    }
    //añade y guarda en memoria
    @PostMapping("/user")
    public User manejarSolicitud(@RequestBody User user) {
        if ( user.getName() == null  ) {
            // Realizar alguna acción si el objeto no es válido, como lanzar una excepción o devolver un error
        } else {
            // Realizar alguna operación con el objeto usuario, como almacenarlo en una lista
            users.add(user);
        }
        // En este caso, simplemente lo devolvemos tal como lo recibimos
        return user;
    }


    //Petición PUT: mandando  Request Params (http://localhost:8080/post?var1=1&var2=2) devolver un HashMap con los datos mandados . Por ejemplo: [ {var1: 1}, {var2: 2} ]
            @PutMapping("/post")
    public Map<String, Object> manejarSolicitudPut(@RequestParam("var1") String var1, @RequestParam("var2") String var2) {
        Map<String, Object> response = new HashMap<>();
        response.put("var1", var1);
        response.put("var2", var2);
        return response;
    }

    //Petición GET: Mandar Header “h1” y “H2” a la URL http://localhost:8080/header. Cualquier otro Header deberá ser ignorado (o no mostrado al menos)
//Se añade al header de postman el h1 y h2 en la claves key y luego se pone el valor
    @GetMapping("/header")
    public String manejarSolicitud(HttpServletRequest request) {
        String h1 = request.getHeader("h1");
        String h2 = request.getHeader("h2");

        if (h1 != null && h2 != null) {
            return "Encabezado h1: " + h1 + ", Encabezado h2: " + h2;
        } else {
            return "Los encabezados h1 y h2 son obligatorios.";
        }

    }

    //Petición POST: Devolver todo los datos mandados: En la URL http://localhost:8080/all devolver el body si es mandado, todos los  Request Param y los headers en una objeto tipo:String body;
    //List<String> headers;
    //List<String> requestParams;



    @PostMapping("/all")
    public DatosEntrada manejarSolicitud(@RequestBody(required = false) String body,
                                         @RequestParam Map<String, String> queryParams,
                                         @RequestHeader Map<String, String> headers,
                                         HttpServletRequest request) {

        // Obtener los encabezados de la solicitud como una lista de strings
        List<String> headerList = new ArrayList<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headerList.add(headerName + ": " + request.getHeader(headerName));
        }

        // Obtener los parámetros de la URL como una lista de strings
        List<String> queryParamsList = new ArrayList<>();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            queryParamsList.add(entry.getKey() + ": " + entry.getValue());
        }

        // Crear y devolver el objeto DatosEntrada
        DatosEntrada datosEntrada = new DatosEntrada();
        datosEntrada.setBody(body);
        datosEntrada.setHeaders(headerList);
        datosEntrada.setRequestParams(queryParamsList);
        return datosEntrada;
    }

    }

