package com.evocalize.dns.models;

public class DNSARecord extends DNSRecord {

    private String ip;

    public DNSARecord() {
    }
    
    public DNSARecord(String domain) {
    	super(domain);
    }
    
    public DNSARecord(String domain, long ttl) {
    	super(domain, ttl);
    }
    
    public DNSARecord(String domain, long ttl, String ip) {
    	super(domain, ttl);
        this.ip = ip;
    }

    public String getIP() {
        return ip;
    }

    public void setIP(String ip) {
        this.ip = ip;
    }
}
