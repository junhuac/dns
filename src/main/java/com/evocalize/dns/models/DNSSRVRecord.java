package com.evocalize.dns.models;

public class DNSSRVRecord extends DNSRecord {

    private String record;

    public DNSSRVRecord() {
    }
    
    public DNSSRVRecord(String domain, long ttl, String record) {
    	super(domain, ttl);
        this.record = record;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
