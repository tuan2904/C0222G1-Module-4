package com.example.furama.model;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceName;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceArea;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceCost;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceMaxPeople;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceRoom;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceDescription;
    @Column(columnDefinition = "VARCHAR(200)")
    private String servicePoolArea;
    @Column(columnDefinition = "VARCHAR(200)")
    private String serviceNumberFloors;
    @ManyToOne
    @JoinColumn(name = "id_service_type")
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(name = "id_rant_type")
    private RentType rentType;
    @OneToMany(mappedBy = "service")
    private Set<Contract> contracts;

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Service() {
    }

    public Service(int serviceId,
                   String serviceName,
                   String serviceArea,
                   String serviceCost,
                   String serviceMaxPeople,
                   String serviceRoom,
                   String serviceDescription,
                   String servicePoolArea,
                   String serviceNumberFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.serviceRoom = serviceRoom;
        this.serviceDescription = serviceDescription;
        this.servicePoolArea = servicePoolArea;
        this.serviceNumberFloors = serviceNumberFloors;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

//    public String getRentTypeId() {
//        return rentTypeId;
//    }
//
//    public void setRentTypeId(String rentTypeId) {
//        this.rentTypeId = rentTypeId;
//    }
//
//    public String getServiceTypeId() {
//        return serviceTypeId;
//    }
//
//    public void setServiceTypeId(String serviceTypeId) {
//        this.serviceTypeId = serviceTypeId;
//    }

    public String getServiceRoom() {
        return serviceRoom;
    }

    public void setServiceRoom(String serviceRoom) {
        this.serviceRoom = serviceRoom;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(String servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public String getServiceNumberFloors() {
        return serviceNumberFloors;
    }

    public void setServiceNumberFloors(String serviceNumberFloors) {
        this.serviceNumberFloors = serviceNumberFloors;
    }
}
