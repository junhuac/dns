package com.evocalize.dns.controllers;

import com.evocalize.dns.bean.DNSQuery;
import com.evocalize.dns.bean.DNSQueryResults;
import com.evocalize.dns.util.DNSLookupUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xbill.DNS.SimpleResolver;

@RestController
@RequestMapping("/admin")
@Api(value = "admin", description = "Rest API for administrative DNS operations", tags = "Admin DNS API")
public class AdminController {

	@CrossOrigin(origins = "http://localhost:8080")    
    @RequestMapping(value = "/dns",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "DNS query.", notes = "Returns the DNS query results.")
    public DNSQueryResults recordTypes(@RequestBody DNSQuery query,
                                 HttpServletRequest request, HttpServletResponse response) {
    	DNSQueryResults Results = new DNSQueryResults();
    	
    	try {
    		SimpleResolver resolver = new SimpleResolver("8.8.8.8");
			
			Results = DNSLookupUtil.forNameType(resolver, query.getlookup(), query.getRecordTypes());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Results = DNSLookupUtil.forNameType(query.getlookup(), query.getRecordTypes());
		}

    	return Results;
    }
}
