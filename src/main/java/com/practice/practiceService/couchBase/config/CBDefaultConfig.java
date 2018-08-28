package com.practice.practiceService.couchBase.config;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.query.Consistency;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

@EnableCouchbaseRepositories
@Configuration
@PropertySource(ignoreResourceNotFound = true, value ="classpath:/${spring.profiles.active}/couchbase.properties")
public class CBDefaultConfig extends AbstractCouchbaseConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(CBDefaultConfig.class);

    @Value("${couchbase.cluster.bucket.current}")
    public String bucketCurrent; 
   
    @Value("${couchbase.cluster.password}")
    public String password;

    @Value("${couchbase.cluster.ip}")
    public String hosts;

    @Override
    public String getBucketName() {
        return bucketCurrent;
    }

    @Override
    protected CouchbaseEnvironment getEnvironment(){
    	return DefaultCouchbaseEnvironment.builder()
                .connectTimeout(100000) //100000ms = 100s, default is 5s
                .build();
    }


	@Override
    protected String getBucketPassword() {
    	System.out.println("getBucketPassword::password::"+password);
    	LOGGER.debug("getBucketPassword::password::"+password);
        return password;
    }

    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList(hosts);
    }
    
    @Override
    protected Consistency getDefaultConsistency() {
        return Consistency.READ_YOUR_OWN_WRITES;
    }
    
    @Bean
    public Bucket currentBucket() throws Exception {
    	LOGGER.debug("::password::"+password);
        return couchbaseCluster().openBucket(bucketCurrent, password);
    }
}