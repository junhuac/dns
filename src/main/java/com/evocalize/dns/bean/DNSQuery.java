package com.evocalize.dns.bean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DNSQuery {

    @ApiModelProperty(notes = "Provided lookup name", required = true)
    private String lookup;

    @ApiModelProperty(notes = "DNSQuery recordTypes" , readOnly = true)
    private List<String> recordTypes;

    public DNSQuery() {
    }
    
    public DNSQuery(String lookup, List<String> recordTypes) {
        this.lookup = lookup;
        this.recordTypes = recordTypes;
    }

    public String getlookup() {
        return lookup;
    }

    public void setlookup(String lookup) {
        this.lookup = lookup;
    }

    public List<String> getRecordTypes() {
        return recordTypes;
    }

    public void setRecordTypes(List<String> recordTypes) {
        this.recordTypes = recordTypes;
    }
}
