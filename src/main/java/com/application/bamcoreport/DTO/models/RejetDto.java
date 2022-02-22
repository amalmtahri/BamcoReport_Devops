package com.application.bamcoreport.DTO.models;

import java.util.Date;

public class RejetDto {


    private Long id;
    private String flowType;
    private String rejectNature;
    private String entity;
    private Date declarationDate;
    private Long agencyCode;
    private Long userRegistrationNumber;
    private String bu;
    private String su;
    private String regionalDelegation;
    private String subDelegationType;
    private String subDelegationName;
    private Long cliFileCode;
    private Long clientCode ;
    private String gravity;
    private Long zoneCode;
    private Boolean isWrongField;
    private Long errorCode;
    private String errorLabel;
    private Boolean isRequestTaken;
    private String actionDetail;
    private String file;
    private UserDto takenBy;

    public RejetDto(Long id, String flowType, String rejectNature, String entity, Date declarationDate, Long agencyCode, Long userRegistrationNumber, String bu, String su, String regionalDelegation, String subDelegationType, String subDelegationName, Long cliFileCode, Long clientCode, String gravity, Long zoneCode, Boolean isWrongField, Long errorCode, String errorLabel, Boolean isRequestTaken, String actionDetail, String file, UserDto takenBy) {
        this.id = id;
        this.flowType = flowType;
        this.rejectNature = rejectNature;
        this.entity = entity;
        this.declarationDate = declarationDate;
        this.agencyCode = agencyCode;
        this.userRegistrationNumber = userRegistrationNumber;
        this.bu = bu;
        this.su = su;
        this.regionalDelegation = regionalDelegation;
        this.subDelegationType = subDelegationType;
        this.subDelegationName = subDelegationName;
        this.cliFileCode = cliFileCode;
        this.clientCode = clientCode;
        this.gravity = gravity;
        this.zoneCode = zoneCode;
        this.isWrongField = isWrongField;
        this.errorCode = errorCode;
        this.errorLabel = errorLabel;
        this.isRequestTaken = isRequestTaken;
        this.actionDetail = actionDetail;
        this.file = file;
        this.takenBy = takenBy;
    }

    public RejetDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getRejectNature() {
        return rejectNature;
    }

    public void setRejectNature(String rejectNature) {
        this.rejectNature = rejectNature;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Date getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(Date declarationDate) {
        this.declarationDate = declarationDate;
    }

    public Long getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(Long agencyCode) {
        this.agencyCode = agencyCode;
    }

    public Long getUserRegistrationNumber() {
        return userRegistrationNumber;
    }

    public void setUserRegistrationNumber(Long userRegistrationNumber) {
        this.userRegistrationNumber = userRegistrationNumber;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getSu() {
        return su;
    }

    public void setSu(String su) {
        this.su = su;
    }

    public String getRegionalDelegation() {
        return regionalDelegation;
    }

    public void setRegionalDelegation(String regionalDelegation) {
        this.regionalDelegation = regionalDelegation;
    }

    public String getSubDelegationType() {
        return subDelegationType;
    }

    public void setSubDelegationType(String subDelegationType) {
        this.subDelegationType = subDelegationType;
    }

    public String getSubDelegationName() {
        return subDelegationName;
    }

    public void setSubDelegationName(String subDelegationName) {
        this.subDelegationName = subDelegationName;
    }

    public Long getCliFileCode() {
        return cliFileCode;
    }

    public void setCliFileCode(Long cliFileCode) {
        this.cliFileCode = cliFileCode;
    }

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public Long getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(Long zoneCode) {
        this.zoneCode = zoneCode;
    }

    public Boolean getWrongField() {
        return isWrongField;
    }

    public void setWrongField(Boolean wrongField) {
        isWrongField = wrongField;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(String errorLabel) {
        this.errorLabel = errorLabel;
    }

    public Boolean getRequestTaken() {
        return isRequestTaken;
    }

    public void setRequestTaken(Boolean requestTaken) {
        isRequestTaken = requestTaken;
    }

    public String getActionDetail() {
        return actionDetail;
    }

    public void setActionDetail(String actionDetail) {
        this.actionDetail = actionDetail;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public UserDto getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(UserDto takenBy) {
        this.takenBy = takenBy;
    }

    @Override
    public String toString() {
        return "RejetDto{" +
                "id=" + id +
                ", flowType='" + flowType + '\'' +
                ", rejectNature='" + rejectNature + '\'' +
                ", entity='" + entity + '\'' +
                ", declarationDate=" + declarationDate +
                ", agencyCode=" + agencyCode +
                ", userRegistrationNumber=" + userRegistrationNumber +
                ", bu='" + bu + '\'' +
                ", su='" + su + '\'' +
                ", regionalDelegation='" + regionalDelegation + '\'' +
                ", subDelegationType='" + subDelegationType + '\'' +
                ", subDelegationName='" + subDelegationName + '\'' +
                ", cliFileCode=" + cliFileCode +
                ", clientCode=" + clientCode +
                ", gravity='" + gravity + '\'' +
                ", zoneCode=" + zoneCode +
                ", isWrongField=" + isWrongField +
                ", errorCode=" + errorCode +
                ", errorLabel='" + errorLabel + '\'' +
                ", isRequestTaken=" + isRequestTaken +
                ", actionDetail='" + actionDetail + '\'' +
                ", file='" + file + '\'' +
                ", takenBy=" + takenBy +
                '}';
    }
}
