package com.evocalize.dns.models;

public class DNSCNAMERecord extends DNSRecord {

    private String ip;

    public DNSCNAMERecord() {
    }
    
    public DNSCNAMERecord(String domain, long ttl, String ip) {
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
