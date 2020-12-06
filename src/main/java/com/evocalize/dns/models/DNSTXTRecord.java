package com.evocalize.dns.models;

public class DNSTXTRecord extends DNSRecord {

    private String record;

    public DNSTXTRecord() {
    }
    
    public DNSTXTRecord(String domain, long ttl, String record) {
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
