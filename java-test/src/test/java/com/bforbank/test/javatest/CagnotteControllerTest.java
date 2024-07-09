package com.bforbank.test.javatest.controller;

import com.bforbank.test.javatest.entity.Cagnotte;
import com.bforbank.test.javatest.service.CagnotteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CagnotteController.class)
public class CagnotteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CagnotteService cagnotteService;

    @Test
    public void testAddAmount() throws Exception {
        Cagnotte cagnotte = new Cagnotte();
        cagnotte.setId(1L);
        cagnotte.setClientId(1L);
        cagnotte.setPassageCount(1);
        cagnotte.setAmount(5.0);

        Mockito.when(cagnotteService.addAmount(Mockito.eq(1L), Mockito.anyDouble())).thenReturn(cagnotte);

        Map<String, Double> request = new HashMap<>();
        request.put("amount", 5.0);

        mockMvc.perform(post("/api/cagnottes/1/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\": 5.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.clientId", is(1)))
                .andExpect(jsonPath("$.passageCount", is(1)))
                .andExpect(jsonPath("$.amount", is(5.0)));
    }

    @Test
    public void testIsCagnotteAvailable() throws Exception {
        Mockito.when(cagnotteService.isCagnotteAvailable(1L)).thenReturn(true);

        mockMvc.perform(get("/api/cagnottes/1/available")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
