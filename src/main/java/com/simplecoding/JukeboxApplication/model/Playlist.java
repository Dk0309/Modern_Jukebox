package com.simplecoding.JukeboxApplication.model;

import java.util.List;

import org.springframework.data.annotation.Id;




public class Playlist {

	@Id
	private String playlistId;
	private String name;
	private List<Song> songs;
	
	public Playlist() {
		
	}

	public Playlist(String id, String name, List<Song> songs) {
		
		this.playlistId = id;
		this.name = name;
		this.songs = songs;
	}

	

	public String getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(String playlistId) {
		this.playlistId = playlistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + playlistId + ", name=" + name + ", songs=" + songs + "]";
	}
	
	
	
	
}
