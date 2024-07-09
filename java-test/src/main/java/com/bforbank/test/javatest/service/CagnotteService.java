package com.bforbank.test.javatest.service;

import com.bforbank.test.javatest.entity.Cagnotte;
import com.bforbank.test.javatest.entity.Client;
import com.bforbank.test.javatest.exception.ResourceNotFoundException;
import com.bforbank.test.javatest.repository.CagnotteRepository;
import com.bforbank.test.javatest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CagnotteService {
    @Autowired
    private CagnotteRepository cagnotteRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Cagnotte addAmount(Long clientId, double amount) {
        Optional<Client> clientOpt = clientRepository.findById(clientId);
        if (!clientOpt.isPresent()) {
            throw new ResourceNotFoundException("Client not found");
        }

        Cagnotte cagnotte = cagnotteRepository.findByClientId(clientId)
                .orElse(new Cagnotte(clientId, 0, 0.0));
        cagnotte.setAmount(cagnotte.getAmount() + amount);
        cagnotte.setPassageCount(cagnotte.getPassageCount() + 1);

        return cagnotteRepository.save(cagnotte);
    }

    public boolean isCagnotteAvailable(Long clientId) {
        Cagnotte cagnotte = cagnotteRepository.findByClientId(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Cagnotte not found"));

        return cagnotte.getPassageCount() >= 3 && cagnotte.getAmount() >= 10.0;
    }
}
