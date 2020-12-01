package br.unit.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/home")
    public ResponseEntity<String> home(){
        HttpStatus httpStatus = HttpStatus.ACCEPTED;
        return ResponseEntity.status(httpStatus).body("Página Inicial da API Bank. " +
                "<br><br><a href='swagger-ui.html'>Documentação</a>");
    }
}
