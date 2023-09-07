package com.team.api.payload;

public class Param {

    private final String paramName;
    private final Object paramValue;

    public Param(String paramName, Object paramValue) {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }


    public String getParamName() {
        return paramName;
    }

    public Object getParamValue() {
        return paramValue;
    }
}
