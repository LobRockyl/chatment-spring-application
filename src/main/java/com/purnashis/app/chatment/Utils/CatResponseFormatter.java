package com.purnashis.app.chatment.Utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CatResponseFormatter {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String fact;
    private String length;

    public String getFact() {
        return this.fact;
    }

}
