package com.practiceService.model;

import java.io.Serializable;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class StudentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Field
	private String objectId;
	
	@Field
	private String assetID;
	
	@Field
	private String name;
	
	@Field
	private String address;

	@Field
	private Meta meta;
	
	
	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentDetail [objectId=" + objectId + ", assetID=" + assetID + ", name=" + name + ", address="
				+ address + "]";
	}

	
}
