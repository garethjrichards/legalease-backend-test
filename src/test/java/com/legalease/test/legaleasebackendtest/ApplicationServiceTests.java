package com.legalease.test.legaleasebackendtest;

import com.legalease.test.legaleasebackendtest.domain.Root;
import com.legalease.test.legaleasebackendtest.service.ApplicationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ApplicationServiceTests {
    @Autowired
    private ApplicationService applicationService;

    @Test
    void getAllRoot() {
        List<Root> roots = applicationService.getAllRoot();
        assertNotNull(roots);
        assertTrue(roots.size() > 0);
    }

    @Test
    void getRootById() {
        Optional<Root> root = applicationService.getRootById("19859");
        assertTrue(root.isPresent());
        assertEquals("19859", root.get()
                                  .getId());
    }

    @Test
    void getRootByRegionId() {
        List<Root> roots = applicationService.getRootByRegionId("170");
        assertNotNull(roots);
        assertTrue(roots.size() > 0);
    }
}
