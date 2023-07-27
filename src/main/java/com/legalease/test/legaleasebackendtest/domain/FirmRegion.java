package com.legalease.test.legaleasebackendtest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FirmRegion{
    public String id;
    public Region region;
    public boolean booking;
    public String crossBorderCapability;
    public int clientSatisfactionRating;
    public int expertiseAndReputationRating;
}
