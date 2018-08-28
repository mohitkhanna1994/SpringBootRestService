package com.practiceService.model;

public class Student {

	private String assetID;

	public String getAssetID() {
		return assetID;
	}

	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}

	@Override
	public String toString() {
		return "Student [assetID=" + assetID + "]";
	}
	
}
