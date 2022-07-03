package com.example.furama.service.contract;

import com.example.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    void create(Contract contract);

    Page<Contract> listContract(Pageable pageable);

}
