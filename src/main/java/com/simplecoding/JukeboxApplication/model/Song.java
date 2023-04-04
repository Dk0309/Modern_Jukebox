package com.simplecoding.JukeboxApplication.model;

import org.springframework.data.annotation.Id;

public class Song {
	
	@Id
	private String songId;
	private String songName;
	private Artist artist;
	
	
	public Song() {
		
	}


	public Song(String songId, String songName, Artist artist) {
		
		this.songId = songId;
		this.songName = songName;
		this.artist = artist;
	}


	public String getSongId() {
		return songId;
	}


	public void setSongId(String songId) {
		this.songId = songId;
	}


	public String getSongName() {
		return songName;
	}


	public void setSongName(String songName) {
		this.songName = songName;
	}


	public Artist getArtist() {
		return artist;
	}


	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", artist=" + artist + "]";
	}
	
	
	

}
