package com.auj.userManager.constrollers;


import com.auj.userManager.dtos.ClientDTO;
import com.auj.userManager.models.Client;
import com.auj.userManager.repositories.ClientRepository;
import com.auj.userManager.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/// Controlador para escuchar y responder a las peticiones.
@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    /// Devuelve todas las entidades Clientes existentes.
    @GetMapping("/users")
    public ResponseEntity<?> getAllClients () {
        return new ResponseEntity<>(clientService.getAllClientsDTO(), HttpStatus.OK);
    };

    /// Recibe una petición de registro de usuario y verifica su correcto contenido.
    @PostMapping("/users")
    public ResponseEntity<?> register(@RequestBody ClientDTO clientDTO) {

        if(clientDTO.getName().isBlank()) {
            return new ResponseEntity<>("El campo de nombre no debe estar vacío." , HttpStatus.FORBIDDEN);
        }
        if(clientDTO.getLastName().isBlank()) {
            return new ResponseEntity<>("El campo de apellido no debe estar vacío." , HttpStatus.FORBIDDEN);
        }
        if(clientDTO.getEmail().isBlank()) {
            return new ResponseEntity<>("El campo de correo electrónico no debe estar vacío." , HttpStatus.FORBIDDEN);
        }
        if(!clientDTO.getEmail().contains("@")) {
            return new ResponseEntity<>("El correo electrónico no tiene '@'" , HttpStatus.FORBIDDEN);
        }
        if (clientService.containsSeveral(clientDTO, "@")){
            return new ResponseEntity<>("El correo electrónico no puede contener más de un '@'", HttpStatus.FORBIDDEN);
        }
        if(clientRepository.existsByEmail(clientDTO.getEmail())) {
            return new ResponseEntity<>("El correo electrónico ya está registrado.", HttpStatus.FORBIDDEN);
        }

        Client newClient = new Client(
                clientDTO.getName(),
                clientDTO.getLastName(),
                clientDTO.getEmail()
        );

        clientRepository.save(newClient);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
    }

    /// Recibe una petición para eliminar un usuario con un ID como variable en la ruta.
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        Client client = clientService.getClientById(id);
        if(client == null) {
            return new ResponseEntity<>("No existe en la Base de Datos un usuario con el id: " + id + ".",
                    HttpStatus.NOT_FOUND);
        }
        clientRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente.");
    }
}
