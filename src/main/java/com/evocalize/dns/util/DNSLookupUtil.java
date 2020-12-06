package com.evocalize.dns.util;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

import com.evocalize.dns.bean.DNSQueryResults;
import com.evocalize.dns.models.DNSARecord;
import com.evocalize.dns.models.DNSCNAMERecord;
import com.evocalize.dns.models.DNSMXRecord;
import com.evocalize.dns.models.DNSNSRecord;
import com.evocalize.dns.models.DNSQueryResult;
import com.evocalize.dns.models.DNSSRVRecord;
import com.evocalize.dns.models.DNSTXTRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DNSLookupUtil {
    
	private static HashMap<String, Integer> map = new HashMap<String, Integer>() {
	    {
	        put("A", Type.A);
	        put("CNAME", Type.CNAME);
	        put("TXT", Type.TXT);
	        put("SRV", Type.SRV);
	        put("NS", Type.NS);
	        put("MX", Type.MX);
	    }
	};

	public static DNSQueryResults forNameType(String nameStr, List<String> recordTypes) {
    	return forNameType(null, nameStr, recordTypes);
    }

    public static List<String> NameString(Resolver resolver, String nameStr, int type) {
        Name name;

        try {
            name = Name.fromString(nameStr);
        } catch (TextParseException e) {
            throw new IllegalArgumentException();
        }
        Lookup lookup = new Lookup(name, type);
        if(null != resolver) {
        	lookup.setResolver(resolver);
        }
        lookup.setCache(null);
        lookup.run();

        if (lookup.getResult() != Lookup.SUCCESSFUL) {
            throw new RuntimeException(lookup.getErrorString());
        }
        return Arrays.stream(lookup.getAnswers())
                .map(Record::rdataToString)
                .collect(Collectors.toList());
    }

    public static DNSQueryResult forNameType(Resolver resolver, String nameStr, String recordType) {
        Name name;
    	int type = map.get(recordType);
    	DNSQueryResult result = new DNSQueryResult(recordType);

        try {
            name = Name.fromString(nameStr);
        } catch (TextParseException e) {
            throw new IllegalArgumentException();
        }
        Lookup lookup = new Lookup(name, type);
        if(null != resolver) {
        	lookup.setResolver(resolver);
        }
        lookup.setCache(null);
        Record[] records = lookup.run();

        if (lookup.getResult() != Lookup.SUCCESSFUL) {
            return result;
        }
        
        switch(type)
        {
	        case Type.A:
	        	result.setResponse(new DNSARecord(nameStr, records[0].getTTL(), records[0].rdataToString()));
	        break;
	         
	        case Type.CNAME:
	        	result.setResponse(new DNSCNAMERecord(nameStr, records[0].getTTL(), records[0].rdataToString()));
	        break;
	         
	        case Type.TXT:
	        	List<String> record = Arrays.stream(lookup.getAnswers())
	                .map(Record::rdataToString)
	                .collect(Collectors.toList());
	        	result.setResponse(new DNSTXTRecord(nameStr, records[0].getTTL(), record.toString()));
	        break;
	         
	        case Type.SRV:
	        	result.setResponse(new DNSSRVRecord(nameStr, records[0].getTTL(), records[0].rdataToString()));
	        break;
	         
	        case Type.NS:
	        	List<String> nameservers = Arrays.stream(lookup.getAnswers())
                .map(Record::rdataToString)
                .collect(Collectors.toList());
	        	result.setResponse(new DNSMXRecord(nameStr, records[0].getTTL(), nameservers));
        	break;
	         
	        case Type.MX:
	        	List<String> servers = Arrays.stream(lookup.getAnswers())
	                .map(Record::rdataToString)
	                .collect(Collectors.toList());
	        	result.setResponse(new DNSMXRecord(nameStr, records[0].getTTL(), servers));
	        break;
	         
	        default:
	        break;
        }
        
        return result;
    }
    
    public static DNSQueryResults forNameType(Resolver resolver, String nameStr, List<String> recordTypes) {
        Name name;

        DNSQueryResults results = new DNSQueryResults();
        List<DNSQueryResult> hits = new ArrayList<DNSQueryResult>();
        
        for(String recordType : recordTypes) {
        
        	DNSQueryResult result = forNameType(resolver, nameStr, recordType);
        	hits.add(result);
        }
        
    	results.setHits(hits);

    	return results;
    }
    }