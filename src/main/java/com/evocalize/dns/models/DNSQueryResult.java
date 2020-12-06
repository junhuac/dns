package com.evocalize.dns.models;

public class DNSQueryResult {

    private String type;
	
    private DNSRecord response;

    public DNSQueryResult() {
    }
    
    public DNSQueryResult(String type) {
        this.type = type;
    }
    
    public DNSQueryResult(String type, DNSRecord response) {
        this.type = type;
        this.response = response;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DNSRecord getResponse() {
        return response;
    }

    public void setResponse(DNSRecord response) {
        this.response = response;
    }
}
