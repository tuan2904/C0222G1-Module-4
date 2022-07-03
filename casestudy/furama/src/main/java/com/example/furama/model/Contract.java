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
    private String getContractEndDate;
    @Column(columnDefinition = "VARCHAR(200)")
    private String contractDeposit;
    @Column(columnDefinition = "VARCHAR(200)")
    private String contractTotalMoney;

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
                    String getContractEndDate,
                    String contractDeposit,
                    String contractTotalMoney,
                    Customer customer,

                    Employee employee, Service service) {
        this.idContract = idContract;
        this.contractStartDate = contractStartDate;
        this.getContractEndDate = getContractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
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

    public String getGetContractEndDate() {
        return getContractEndDate;
    }

    public void setGetContractEndDate(String getContractEndDate) {
        this.getContractEndDate = getContractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
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
