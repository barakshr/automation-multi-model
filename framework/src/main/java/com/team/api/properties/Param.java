package com.team.api.properties;

import java.util.ArrayList;
import java.util.List;

public class Param {
    String type;

  private   String paramName;
    private  Object paramValue;

    private List<Param> paramList = new ArrayList();

    public Param() {

    }


     public Param(String paramName, String type, Object paramValue) {
        this.type = type;
        this.paramValue = paramValue;
        this.paramName = paramName;
    }

    public String getType() {
        return type;
    }


    public Object getParamValue() {
        return paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public List<Param> getParamList() {
        return paramList;
    }

    public Param addParam(String paramName, String type, Object paramValue) {
        new Param(paramName, type, paramValue);
        paramList.add(this);
        return this;
    }

}
