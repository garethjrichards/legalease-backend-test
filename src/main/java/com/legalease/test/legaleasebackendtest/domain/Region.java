package com.legalease.test.legaleasebackendtest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Region{
    public String id;
    public String name;
    public String slug;
    public RegionGroup regionGroup;
}
