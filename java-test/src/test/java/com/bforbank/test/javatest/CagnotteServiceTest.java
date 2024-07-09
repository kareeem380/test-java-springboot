package com.bforbank.test.javatest;

import com.bforbank.test.javatest.entity.Cagnotte;
import com.bforbank.test.javatest.entity.Client;
import com.bforbank.test.javatest.repository.ClientRepository;
import com.bforbank.test.javatest.service.CagnotteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CagnotteServiceTest {
    @Autowired
    private CagnotteService cagnotteService;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testAddAmount() {
        Client client = clientRepository.save(new Client());
        client.setName("Test Client");
        Cagnotte cagnotte = cagnotteService.addAmount(client.getId(), 5.0);
        assertEquals(5.0, cagnotte.getAmount());
        assertEquals(1, cagnotte.getPassageCount());
    }

    @Test
    public void testIsCagnotteAvailable() {
        Client client = clientRepository.save(new Client());
        client.setName("Test Client");
        cagnotteService.addAmount(client.getId(), 5.0);
        cagnotteService.addAmount(client.getId(), 3.0);
        cagnotteService.addAmount(client.getId(), 2.0);
        assertTrue(cagnotteService.isCagnotteAvailable(client.getId()));
    }
}
