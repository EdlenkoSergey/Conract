package com.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private  String name;
    @Column(name = "model", length = 10000)
    @JsonIgnore
    private String model;
    @Transient
    private Map<String, Object> contractModel;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getContractModel() {
        return contractModel;
    }

    public void setContractModel(Map<String, Object> contractModel) {
        this.contractModel = contractModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
