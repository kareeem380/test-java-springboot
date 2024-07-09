package com.bforbank.test.javatest.service;

import com.bforbank.test.javatest.entity.Client;
import com.bforbank.test.javatest.exception.ResourceNotFoundException;
import com.bforbank.test.javatest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    public Client updateClient(Long clientId, Client clientDetails) {
        Client client = getClientById(clientId);
        client.setName(clientDetails.getName());
        return clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        Client client = getClientById(clientId);
        clientRepository.delete(client);
    }
}
