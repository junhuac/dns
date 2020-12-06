package com.evocalize.dns.bean;

import java.util.List;

import com.evocalize.dns.models.DNSQueryResult;

import io.swagger.annotations.ApiModelProperty;

public class DNSQueryResults {

    @ApiModelProperty(notes = "DNSQuery hits" , readOnly = true)
    private List<DNSQueryResult> hits;

    public DNSQueryResults() {
    }
    
    public DNSQueryResults(List<DNSQueryResult> hits) {
        this.hits = hits;
    }

    public List<DNSQueryResult> getHits() {
        return hits;
    }

    public void setHits(List<DNSQueryResult> hits) {
        this.hits = hits;
    }
}
