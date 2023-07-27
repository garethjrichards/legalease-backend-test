package com.legalease.test.legaleasebackendtest.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Root {
    public String id;
    public Firm firm;
    public String trend;
    public boolean diversity;
    public String tier;
    public int position;
}
