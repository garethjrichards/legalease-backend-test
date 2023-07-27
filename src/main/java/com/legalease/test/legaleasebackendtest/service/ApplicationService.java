package com.legalease.test.legaleasebackendtest.service;

import com.legalease.test.legaleasebackendtest.domain.Root;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<Root> getAllRoot();

    Optional<Root> getRootById(String id);

    List<Root> getRootByRegionId(String regionId);
}
