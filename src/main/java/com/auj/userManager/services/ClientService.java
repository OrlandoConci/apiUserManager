package com.auj.userManager.services;

import com.auj.userManager.dtos.ClientDTO;
import com.auj.userManager.models.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    List<ClientDTO> getAllClientsDTO();

    Boolean containsSeveral(ClientDTO clientDTO, String caracter);

    Client getClientById(Long id);
}
