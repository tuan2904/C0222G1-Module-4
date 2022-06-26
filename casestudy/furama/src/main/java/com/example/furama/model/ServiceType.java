package com.example.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiceType;
    @Column(columnDefinition = "VARCHAR(200)")
    private String name;
    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public ServiceType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }
}
