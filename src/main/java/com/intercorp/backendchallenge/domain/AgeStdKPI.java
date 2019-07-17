package com.intercorp.backendchallenge.domain;

public class AgeStdKPI implements KPI {
    private static final String NAME = "Desviación estándar edad";
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
