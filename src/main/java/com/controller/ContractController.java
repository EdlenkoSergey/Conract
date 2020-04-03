package com.controller;

import com.contract.Contract;
import com.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/contract")
    public void save(@RequestBody Contract contract){
        contractService.save(contract);
    }
    @GetMapping("/contract/{id}")
    public Contract findById(@PathVariable Long id){
        return contractService.findById(id);
    }
}
