package com.evocalize.dns.models;

public class DNSRecord {

    private String domain;

    private long ttl;
    
    public DNSRecord() {
    }
    
    public DNSRecord(String domain) {
        this.domain = domain;
    }
    
    public DNSRecord(String domain, long ttl) {
        this.domain = domain;
        this.ttl = ttl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public long getTTL() {
        return ttl;
    }

    public void setTTL(long ttl) {
        this.ttl = ttl;
    }
}
