package com.enoca.enocacase.response;

public class EmployeeResponse {
    private String name;

    private String company;

    public EmployeeResponse() {
        super();
    }

    public EmployeeResponse(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
