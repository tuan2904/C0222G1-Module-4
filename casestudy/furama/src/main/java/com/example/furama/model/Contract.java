package com.example.furama.model;

import javax.persistence.*;

@Entity(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContract;
    @Column(columnDefinition = "VARCHAR(200)")
    private String contractStartDate;
    @Column(columnDefinition = "VARCHAR(200)")
    private String contractEndDate;
    @Column(columnDefinition = "VARCHAR(200)")
    private String contractDeposit;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public Contract() {
    }

    public Contract(int idContract,
                    String contractStartDate,
                    String contractEndDate,
                    String contractDeposit,
                    Customer customer,

                    Employee employee, Service service) {
        this.idContract = idContract;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String getContractEndDate) {
        this.contractEndDate = getContractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
