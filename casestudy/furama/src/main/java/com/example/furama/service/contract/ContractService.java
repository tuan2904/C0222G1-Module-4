package com.example.furama.service.contract;

import com.example.furama.model.Contract;
import com.example.furama.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public void create(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> listContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
