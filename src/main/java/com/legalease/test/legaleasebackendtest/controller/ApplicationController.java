package com.legalease.test.legaleasebackendtest.controller;

import com.legalease.test.legaleasebackendtest.domain.Root;
import com.legalease.test.legaleasebackendtest.service.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO: Would be nice to switch to reactive streams using Spring WebFlux
@RestController
@RequestMapping("/api")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    /**
     * Get all the root data from the JSON
     */
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Root>> getAllRoot() {
        return ResponseEntity.ok(applicationService.getAllRoot());
    }

    /**
     * Supply a root id as the path variable and it will pass that root back
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Root> getRootById(@PathVariable("id") String id) {
        return ResponseEntity.of(applicationService.getRootById(id));
    }

    /**
     * Supply the region id and it will pass back all the roots matching that id
     * In this example any region that is not 170 is returned as a Bad request by the
     * RestExceptionHandler
     * Very convoluted structure ideally I'd like to see regions as a seperate schema and service
     */
    //
    @GetMapping("/firm/firmRegion/region/{id}")
    @ResponseBody
    public ResponseEntity<List<Root>> getFirmRegionById(@PathVariable("id") String id) {
        if (!"170".equals(id)) {
            throw new IllegalArgumentException();
        }

        return ResponseEntity.ok(applicationService.getRootByRegionId(id));
    }
}
