package com.enoca.enocacase.response;

public class CompanyResponse {
    private String name;

    private String province;

    public CompanyResponse() {
        super();
    }

    public CompanyResponse(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
