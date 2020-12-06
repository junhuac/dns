package com.evocalize.dns;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DNSApplication {

	public static void main(String[] args) {
		initialize();
		SpringApplication.run(DNSApplication.class, args);
	}

	public static void initialize() {
		  String tsDbFile = System.getProperty("user.dir") + File.separator + "spf4j-performance-monitoring.tsdb2";
		  String tsTextFile = System.getProperty("user.dir") + File.separator + "spf4j-performance-monitoring.txt";
		  System.setProperty("spf4j.perf.ms.config", "TSDB@" + tsDbFile + "," + "TSDB_TXT@" + tsTextFile);
	}	
}
