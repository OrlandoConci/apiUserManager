package com.auj.userManager.services.implementsServices;

import com.auj.userManager.dtos.ClientDTO;
import com.auj.userManager.models.Client;
import com.auj.userManager.repositories.ClientRepository;
import com.auj.userManager.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImplements implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {  /// Trae todos lo clientes
        return clientRepository.findAll();
    }

    @Override
    public List<ClientDTO> getAllClientsDTO() { /// Crea una lista con todos clientes en formato DTOs
        return getAllClients().stream().map(ClientDTO::new).toList();
    }

    @Override
    public Boolean containsSeveral(ClientDTO clientDTO, String caracter) { /// Recorre un String para buscar más de un car
        var cant = 0;
        for (int i = 0; i < clientDTO.getEmail().length(); i++) {
            char c = clientDTO.getEmail().charAt(i);
            if (String.valueOf(c).equals(caracter)) {
                cant++;
            }
        }
        return cant >= 2;
    };

    @Override
    public Client getClientById(Long id){ /// Busca un client por su ID
        return clientRepository.findById(id).orElse(null);
    }
}
