package com.service;

import com.contract.Contract;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public void save(Contract contract){
        try {
            contract.setModel(objectMapper.writeValueAsString(contract.getContractModel()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        contractRepository.save(contract);

    }
    public Contract findById(Long id){
        Contract contract = contractRepository.findById(id).get();
        if(contract.getContractModel() == null) {
            try {
                contract.setContractModel(objectMapper.readValue(contract.getModel(), new TypeReference<Map<String, Object>>() {
                }));
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return contract;
    }
}
