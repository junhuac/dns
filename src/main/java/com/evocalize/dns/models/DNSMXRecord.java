package com.evocalize.dns.models;

import java.util.List;

public class DNSMXRecord extends DNSRecord {

    private List<String> servers;

    public DNSMXRecord() {
    }
    
    public DNSMXRecord(String domain, long ttl, List<String> servers) {
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
