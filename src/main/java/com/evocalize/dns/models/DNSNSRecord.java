package com.evocalize.dns.models;

import java.util.List;

public class DNSNSRecord extends DNSRecord {

    private List<String> servers;

    public DNSNSRecord() {
    }
    
    public DNSNSRecord(String domain, long ttl, List<String> servers) {
    	super(domain, ttl);
        this.servers = servers;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
