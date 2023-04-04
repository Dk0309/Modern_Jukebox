package com.simplecoding.JukeboxApplication.service;

import java.util.List;

import com.simplecoding.JukeboxApplication.exception.PlaylistNotFoundException;
import com.simplecoding.JukeboxApplication.exception.UserNotFoundException;
import com.simplecoding.JukeboxApplication.model.Playlist;
import com.simplecoding.JukeboxApplication.model.Song;
import com.simplecoding.JukeboxApplication.model.User;

public interface UserService {

	User saveUser(User user);
	User login(String userName,String password) throws UserNotFoundException;
	List<User> getAllUsers();
	User createPlaylist(Playlist playlist,String userId) throws UserNotFoundException;
	User addASongToPlaylist(Song song,Playlist playlist,String id,String userId) throws UserNotFoundException,PlaylistNotFoundException;
	boolean deleteASongToPlaylist(String songId,String playlistId,String userId) throws PlaylistNotFoundException, UserNotFoundException;
}
