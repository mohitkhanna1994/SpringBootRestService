package com.practice.practiceService.couchBase.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
	
@Configuration
@PropertySource(ignoreResourceNotFound = true, value ="classpath:/${spring.profiles.active}/app.properties")
public abstract class CouchBaseConnService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CouchBaseConnService.class);

	@Value("${spring.couchbase.bootstrap-hosts}")
	public String hosts;

	@Value("${spring.couchbase.bucket.name}")
	public String bucket;

	@Value("${spring.couchbase.bucket.password}")
	public String bucketPwd;
	
	public CouchbaseTemplate template;

	@Autowired
    public void setCouchbaseTemplate(CouchbaseTemplate template) {
        this.template = template;
    }
	
	public Bucket getCurrentBucket(){
		Cluster cluster = CouchbaseCluster.create(hosts);
		LOGGER.debug("couchbase cluster info::"+cluster);
		System.out.println("couchbase cluster info::"+cluster);
		return cluster.openBucket(bucket, bucketPwd);
	}
}
