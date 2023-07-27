package com.legalease.test.legaleasebackendtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllRoot() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/")
                                              .accept(MediaType.APPLICATION_JSON)
                                              .with(httpBasic("user", "password")))
               .andExpect(MockMvcResultMatchers.status()
                                               .isOk())
               .andExpect(MockMvcResultMatchers.content()
                                               .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getRootById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/19859")
                                              .accept(MediaType.APPLICATION_JSON)
                                              .with(httpBasic("user", "password")))
               .andExpect(MockMvcResultMatchers.status()
                                               .isOk())
               .andExpect(MockMvcResultMatchers.content()
                                               .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFirmRegionById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/firm/firmRegion/region/170")
                                              .accept(MediaType.APPLICATION_JSON)
                                              .with(httpBasic("user", "password")))
               .andExpect(MockMvcResultMatchers.status()
                                               .isOk())
               .andExpect(MockMvcResultMatchers.content()
                                               .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getFirmRegionById_invalidRegion() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/firm/firmRegion/region/1")
                                              .accept(MediaType.APPLICATION_JSON)
                                              .with(httpBasic("user", "password")))
               .andExpect(MockMvcResultMatchers.status()
                                               .isBadRequest());
    }
}
