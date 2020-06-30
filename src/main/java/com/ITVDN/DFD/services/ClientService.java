package com.ITVDN.DFD.services;

import com.ITVDN.DFD.entities.Client;
import com.ITVDN.DFD.repositories.ClientRepository;
import com.ITVDN.DFD.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        client.addRole(Role.CLIENT);
        clientRepository.save(client);
        return client;
    }

    public Client getClient(long id) {
        return clientRepository.findById(id).get();
    }
}
