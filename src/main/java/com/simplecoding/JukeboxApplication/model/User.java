package com.simplecoding.JukeboxApplication.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String userId;
	private String userName;
	private String password;
	private List<Playlist> playlists;
	public User() {
		
	}
	public User(String userId, String userName, String password, List<Playlist> playlists) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.playlists = playlists;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", playlists="
				+ playlists + "]";
	}
	
	
	
	
	

}
