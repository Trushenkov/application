package ru.tds.excel;


import рф.пф.всво.роив.снз._2017_10_06.ЭДПФР;

import java.util.Date;

public class XlsRow extends ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись {

    private int rowNumber;
    private String municipalEducation;
    private String nomination;
    private String inn;
    private String kpp;
    private String registrationNumber;
    private String LastName;
    private String Name;
    private String MiddleName;
    private Date dateBirthday;
    private String snils;
    private Date dateOfContract;
    private String termOfContract;
    private Boolean agreeExperience;
    private Boolean insuranceСontributions;

    public XlsRow(int rowNumber, String municipalEducation, String nomination,
                  String inn, String kpp, String registrationNumber,
                  String lastName, String name, String middleName,
                  Date dateBirthday, String snils, Date dateOfContract,
                  String termOfContract, Boolean agreeExperience, Boolean insuranceСontributions) {
        this.rowNumber = rowNumber;
        this.municipalEducation = municipalEducation;
        this.nomination = nomination;
        this.inn = inn;
        this.kpp = kpp;
        this.registrationNumber = registrationNumber;
        this.LastName = lastName;
        this.Name = name;
        this.MiddleName = middleName;
        this.dateBirthday = dateBirthday;
        this.snils = snils;
        this.dateOfContract = dateOfContract;
        this.termOfContract = termOfContract;
        this.agreeExperience = agreeExperience;
        this.insuranceСontributions = insuranceСontributions;
    }

    public XlsRow() {
    }

    public int getRowNumber() {
        return rowNumber;
    }

    void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getMunicipalEducation() {
        return municipalEducation;
    }

    void setMunicipalEducation(String municipalEducation) {
        this.municipalEducation = municipalEducation;
    }

    public String getNomination() {
        return nomination;
    }

    void setNomination(String nomination) {
        this.nomination = nomination;
    }

    public String getInn() {
        return inn;
    }

    void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getLastName() {
        return LastName;
    }

    void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getName() {
        return Name;
    }

    void setName(String name) {
        Name = name;
    }

    public String getMiddleName() {
        return MiddleName;
    }


    void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getSnils() {
        return snils;
    }

    void setSnils(String snils) {
        this.snils = snils;
    }

    public Date getDateOfContract() {
        return dateOfContract;
    }

    void setDateOfContract(Date dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getTermOfContract() {
        return termOfContract;
    }

    void setTermOfContract(String termOfContract) {
        this.termOfContract = termOfContract;
    }

    public Boolean getAgreeExperience() {
        return agreeExperience;
    }

    void setAgreeExperience(Boolean agreeExperience) {
        this.agreeExperience = agreeExperience;
    }

    public Boolean getInsuranceСontributions() {
        return insuranceСontributions;
    }

    @Override
    public String toString() {
        return "XlsRow{" +
                "rowNumber=" + rowNumber +
                ", municipalEducation='" + municipalEducation + '\'' +
                ", nomination='" + nomination + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Name='" + Name + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", dateBirthday=" + dateBirthday +
                ", snils='" + snils + '\'' +
                ", dateOfContract=" + dateOfContract +
                ", termOfContract='" + termOfContract + '\'' +
                ", agreeExperience=" + agreeExperience +
                ", insuranceСontributions=" + insuranceСontributions +
                '}';
    }

    void setInsuranceСontributions(Boolean insuranceСontributions) {
        this.insuranceСontributions = insuranceСontributions;
    }

}
