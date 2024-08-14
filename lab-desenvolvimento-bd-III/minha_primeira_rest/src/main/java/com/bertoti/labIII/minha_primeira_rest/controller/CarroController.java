package com.bertoti.labIII.minha_primeira_rest.controller;

import com.bertoti.labIII.minha_primeira_rest.model.Carro;
import com.bertoti.labIII.minha_primeira_rest.model.ResponseCarro;
import com.bertoti.labIII.minha_primeira_rest.model.ResponseMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CarroController {
    private Map<String, Carro> carros = new HashMap<>();

    public CarroController() {
        for (Carro carro : List.of(
                new Carro(1, "Ford", "Mustang"),
                new Carro(2, "Porsche", "911"),
                new Carro(3, "Audi", "R8"),
                new Carro(4, "Ferrari", "488 GTB"),
                new Carro(5, "Lamborghini", "Huracán"),
                new Carro(6, "McLaren", "720S"),
                new Carro(7, "Nissan", "GT-R"),
                new Carro(8, "Subaru", "WRX STI"),
                new Carro(9, "Dodge", "Challenger"),
                new Carro(10, "Toyota", "Supra")
        )) {
            carros.put(carro.getId().toString(), carro);
        }
    }

    // http://localhost:8080/carros
    @GetMapping
    public ResponseEntity<List<Carro>> getCarros() {
        return ResponseEntity.ok(new ArrayList<>(carros.values()));
    }

    // http://localhost:8080/carros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCarro> getCarroById(@PathVariable Integer id) {
        Carro carro = carros.get(id.toString());
        if (carro != null) {
            ResponseCarro responseCarro = new ResponseCarro(carro, HttpStatus.OK, "Carro encontrado com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(responseCarro);
        } else {
            ResponseCarro responseCarro = new ResponseCarro(null, HttpStatus.NOT_FOUND, "Carro não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseCarro);
        }
    }

    // http://localhost:8080/carros
    // Body (raw JSON):
    // {
    //    "id": integer,
    //    "marca": "string",
    //    "modelo": "string"
    // }
    @PostMapping
    public ResponseEntity<ResponseCarro> postCarro(@RequestBody Carro carro) {
        if (carro.getId() == null || carro.getId() <= 0) {
            ResponseCarro responseCarro = new ResponseCarro(null, HttpStatus.BAD_REQUEST, "O ID do carro deve ser um número positivo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCarro);
        }
        if (carro.getMarca() == null || carro.getMarca().isEmpty()) {
            ResponseCarro responseCarro = new ResponseCarro(null, HttpStatus.BAD_REQUEST, "A marca do carro é obrigatória");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCarro);
        }
        if (carro.getModelo() == null || carro.getModelo().isEmpty()) {
            ResponseCarro responseCarro = new ResponseCarro(null, HttpStatus.BAD_REQUEST, "O modelo do carro é obrigatório");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCarro);
        }
        if (carros.containsKey(carro.getId().toString())) {
            ResponseCarro responseCarro = new ResponseCarro(null, HttpStatus.BAD_REQUEST, "O ID do carro já existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCarro);
        }

        carros.put(carro.getId().toString(), carro);
        ResponseCarro responseCarro = new ResponseCarro(carro, HttpStatus.OK, "Carro adicionado com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(responseCarro);
    }


    // http://localhost:8080/carros/{id}
    // Body (raw JSON):
    // {
    //    "id": integer,
    //    "marca": "string",
    //    "modelo": "string"
    // }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseCarro> putCarro(@PathVariable Integer id, @RequestBody Carro updateCarro) {
        String stringId = id.toString();
        if (carros.containsKey(stringId)) {
            updateCarro.setId(Integer.parseInt(stringId)); // Garantir que o ID permaneça o mesmo
            carros.put(stringId, updateCarro);
            ResponseCarro responseCarro = new ResponseCarro(updateCarro, HttpStatus.OK, "Carro atualizado com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(responseCarro);
        } else {
            ResponseCarro responseCarro = new ResponseCarro(null, HttpStatus.NOT_FOUND, "Carro não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseCarro);
        }
    }

    //http://localhost:8080/carros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteCarro(@PathVariable String id) {
        if (carros.containsKey(id)) {
            carros.remove(id);
            ResponseMessage responseMessage = new ResponseMessage(HttpStatus.OK, "Carro excluído com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        } else {
            ResponseMessage responseMessage = new ResponseMessage(HttpStatus.NOT_FOUND, "Carro não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }
    }
}
