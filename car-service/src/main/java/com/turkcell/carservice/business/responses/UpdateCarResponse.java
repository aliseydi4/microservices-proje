package com.turkcell.carservice.business.responses;

public class UpdateCarResponse {
    private String id;
    private String code;

    public UpdateCarResponse() {
    }

    public UpdateCarResponse(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
