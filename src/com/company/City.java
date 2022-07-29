package com.company;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Data
@ToString
public class City {

    @ToString.Exclude
    private int id;
    private String name, region, district, foundation;
    private int population;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && population == city.population && Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district) && Objects.equals(foundation, city.foundation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region, district, foundation, population);
    }
}
