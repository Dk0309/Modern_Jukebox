package com.simplecoding.JukeboxApplication.model;

import org.springframework.data.annotation.Id;

public class Artist {

	@Id
	private String artistName;
	private String phoneNumber;
	private String address;
	
	
	public Artist() {

	}


	public Artist(String artistName, String phoneNumber, String address) {
		this.artistName = artistName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}


	public String getArtistName() {
		return artistName;
	}


	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Artist [artistName=" + artistName + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	
	
}
