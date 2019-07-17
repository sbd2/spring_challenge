package com.intercorp.backendchallenge.domain;

public class AgeMeanKPI implements KPI {

    private static final String NAME = "Promedio edad";
    private Double value;

    @Override
    public String getName() {
        return NAME;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
