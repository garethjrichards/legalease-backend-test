package com.legalease.test.legaleasebackendtest.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Firm {
    public String id;
    public String name;
    public String slug;
    public String imageUrl;
    public String websiteUrl;
    public List<Badge> badges;
    public List<Object> awards;
    public List<FirmRegion> firmRegions;
}
