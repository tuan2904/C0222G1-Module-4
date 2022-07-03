package com.example.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRentType;
    @Column(columnDefinition = "VARCHAR(200)")
    private String name;
    @Column(columnDefinition = "VARCHAR(200)")
    private String rentTypeCost;
    @OneToMany(mappedBy = "rentType")
    private Set<Service> services;

    public RentType() {
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int id) {
        this.idRentType = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(String rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
