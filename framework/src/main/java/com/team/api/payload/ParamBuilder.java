package com.team.api.payload;

import java.util.ArrayList;
import java.util.List;

public class ParamBuilder {

    private final List<Param> paramList;

    public ParamBuilder() {
        this.paramList = new ArrayList<>();
    }


    public ParamBuilder addParam(String paramName, Object paramValue) {
        Param param = new Param(paramName, paramValue);
        paramList.add(param);
        return this;
    }

    public List<Param> getParamLists() {
        return paramList;
    }


}
