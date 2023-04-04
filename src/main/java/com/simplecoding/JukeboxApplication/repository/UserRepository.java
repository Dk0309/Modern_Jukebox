package com.simplecoding.JukeboxApplication.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplecoding.JukeboxApplication.model.Playlist;
import com.simplecoding.JukeboxApplication.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

	User findByUserNameAndPassword(String userName,String password);
	
	@Query("{'playlist.playlistId':{$in:[?0]}}")
	Playlist findByPlaylistId(String id);
	
}
