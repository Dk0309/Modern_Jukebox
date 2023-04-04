package com.simplecoding.JukeboxApplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecoding.JukeboxApplication.exception.PlaylistNotFoundException;
import com.simplecoding.JukeboxApplication.exception.UserNotFoundException;
import com.simplecoding.JukeboxApplication.model.Playlist;
import com.simplecoding.JukeboxApplication.model.Song;
import com.simplecoding.JukeboxApplication.model.User;
import com.simplecoding.JukeboxApplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
			this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User login(String userName, String password) throws UserNotFoundException {
		
		User user = userRepository.findByUserNameAndPassword(userName, password);
		if(user == null){
	           throw new UserNotFoundException();
	         }
	         return user;
	}

	@Override
	public List<User> getAllUsers() {
		 
		return userRepository.findAll();
	}

	@Override
	public User createPlaylist(Playlist playlist, String userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).get();
		if(user == null)
		{
			throw new UserNotFoundException();
		}
		
		List<Playlist> playlists = new ArrayList<>();
		playlists.add(playlist);
		user.setPlaylists(playlists);
		return userRepository.save(user);
	}

	@Override
	public User addASongToPlaylist(Song song, Playlist playlist,String id, String userId) throws UserNotFoundException,PlaylistNotFoundException {
		User user = userRepository.findById(userId).get();
		if(user == null)
		{
			throw new UserNotFoundException();
		}
		if(user.getPlaylists() == null)
		{
			throw new PlaylistNotFoundException();			
		}
		
		 if(playlist.getPlaylistId() == userRepository.findByPlaylistId(id).getPlaylistId())
		 {
			    List<Playlist> playlists = user.getPlaylists();
				List<Song> songs = playlist.getSongs();
				songs.add(song);
				user.setPlaylists(playlists);
		 }
		    
		
		   return userRepository.save(user);
	}

	@Override
	public boolean deleteASongToPlaylist(String songId, String playlistId, String userId) throws PlaylistNotFoundException, UserNotFoundException {
		User user = userRepository.findById(userId).get();
		if(user == null)
		{
			throw new UserNotFoundException();
		}
		
		Playlist playlist = userRepository.findByPlaylistId(playlistId);
		if(playlist.getPlaylistId() == playlistId)
		{
			List<Playlist> playlists = user.getPlaylists();
			List<Song> songs = playlist.getSongs();
			songs.remove(songId);
			user.setPlaylists(playlists);
		}
		else
		{
			throw new PlaylistNotFoundException();
		}
		
		return true;
	}
	
	

}
