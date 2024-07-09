package com.bforbank.test.javatest.controller;

import com.bforbank.test.javatest.entity.Cagnotte;
import com.bforbank.test.javatest.service.CagnotteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cagnottes")
public class CagnotteController {

    @Autowired
    private CagnotteService cagnotteService;

    @PostMapping("/{clientId}/add")
    public ResponseEntity<Cagnotte> addAmount(@PathVariable Long clientId, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Cagnotte cagnotte = cagnotteService.addAmount(clientId, amount);
        return ResponseEntity.ok(cagnotte);
    }

    @GetMapping("/{clientId}/available")
    public ResponseEntity<Boolean> isCagnotteAvailable(@PathVariable Long clientId) {
        boolean available = cagnotteService.isCagnotteAvailable(clientId);
        return ResponseEntity.ok(available);
    }
}
