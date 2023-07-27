package com.legalease.test.legaleasebackendtest.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.legalease.test.legaleasebackendtest.domain.Root;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    //TODO: I'd like to see this in a NoSQL DB like mongoDB in the future
    List<Root> dataSource;

    /**
     * This constructor initializes the JSON from the classpath and passes it into a List as if it was a data store
     *
     * and alternative (although not necessary in this case) can be to use the init() method
     * @param resourceFile the file on the classpath
     */
    public ApplicationServiceImpl(@Value("classpath:legalease-code-test-api.json") Resource resourceFile) {
        try (InputStream inputStream = resourceFile.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonParser parser = mapper.createParser(inputStream);
            dataSource = mapper.readValue(parser, new TypeReference<List<Root>>() {
            });
        } catch (IOException ex) {
            log.error("Could not initialise the JSON startup data", ex);
        }
    }

    /**
     * Get all the JSON data
     *
     * @return the JSON as a whole
     */
    @Override
    public List<Root> getAllRoot() {
        return dataSource;
    }

    /**
     * Get the root with id
     * @param id the id matching the root id
     * @return an optional root object
     */
    @Override
    public Optional<Root> getRootById(String id) {
        return dataSource.stream()
                         .filter(root -> id.equals(root.getId()))
                         .findFirst();
    }

    /**
     * Get the root by region id
     * @param regionId the region id
     * @return A list of roots matching the regionId
     */
    @Override
    public List<Root> getRootByRegionId(String regionId) {
        return dataSource.stream()
                         .filter(root -> regionIdFilter(root, regionId))
                         .collect(Collectors.toList());
    }

    /**
     * Validation for null values are not needed due to the file being perfect but I felt in a real world data source
     * the data might have missing values etc.
     *
     * @param root the root to match against
     * @param regionId the region id
     * @return whether the region matches
     */
    private boolean regionIdFilter(Root root, String regionId) {
        if (null == root || null == root.getFirm() || null == root.getFirm()
                                                                  .getFirmRegions()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
        }
        return root.getFirm()
                   .getFirmRegions()
                   .stream()
                   .anyMatch(firmRegion -> regionId.equals(firmRegion.getRegion().getId()));
    }
}
