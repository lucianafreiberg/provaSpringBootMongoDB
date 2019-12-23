package com.bankaccount.clientaccount;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "accounts")
public class Account implements Serializable {
    private static final long serialVersionUID = 4731805173886990886L;

    @MongoId
    private String id;

    @Size(min = 6, max = 6)
    private String accountNumber;

    @Size(min = 4, max = 4)
    private String agency;

    private Boolean status;

    @Size(min = 11, max = 11)
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCreation;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataUpdate;

    private Account() {

    }

    public Account(String id, String accountNumber, String agency, String cpf) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.status = true;
        this.cpf = cpf;
    }

    public Account(String id, String accountNumber, String agency, String cpf, LocalDateTime dataCreation, LocalDateTime dataUpdate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.status = true;
        this.cpf = cpf;
        this.dataCreation = dataCreation;
        this.dataUpdate = dataUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataCreation() {
        return dataCreation;
    }

    public void setDataCreation(LocalDateTime dataCreation) {
        this.dataCreation = dataCreation;
    }

    public LocalDateTime getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(LocalDateTime dataUpdate) {
        this.dataUpdate = dataUpdate;
    }

}
