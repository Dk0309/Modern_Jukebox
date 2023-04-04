package com.simplecoding.JukeboxApplication.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecoding.JukeboxApplication.exception.PlaylistNotFoundException;
import com.simplecoding.JukeboxApplication.exception.UserNotFoundException;
import com.simplecoding.JukeboxApplication.model.Playlist;
import com.simplecoding.JukeboxApplication.model.Song;
import com.simplecoding.JukeboxApplication.model.User;
import com.simplecoding.JukeboxApplication.service.UserService;
import com.simplecoding.JukeboxApplication.token.TokenGenerationService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private UserService userService;
	private ResponseEntity<?> responseEntity;
	private TokenGenerationService tokenGenerationService;
	
	@Autowired
	public UserController(UserService userService,TokenGenerationService tokenGenerationService) {
		this.userService = userService;
		this.tokenGenerationService = tokenGenerationService;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> saveUser(@RequestBody User user)
	{
		 userService.saveUser(user);
	     return responseEntity = new ResponseEntity<>("User Created" , HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
		   Map<String, String> map = null;
		    try {
		      User userObj = userService.login(user.getUserName(), user.getPassword());
		      if (userObj.getUserName().equals(user.getUserName())) {
		        map=tokenGenerationService.generateToken(user);
		      }
		      responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
		    }
		  catch(UserNotFoundException e){
		      throw new UserNotFoundException();
		  }
		    catch (Exception e){
		      responseEntity = new ResponseEntity<>("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		    return responseEntity;
		  }
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers(HttpServletRequest request){

	    List<User> list =  userService.getAllUsers();
	    responseEntity = new ResponseEntity<>(list,HttpStatus.OK);
	    return responseEntity;
	
      }
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<?> createPlaylist(@RequestBody Playlist playlist,@PathVariable String userId) throws UserNotFoundException
	{
		User user = userService.createPlaylist(playlist, userId);
		return responseEntity = new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@PostMapping("/user/addSong/{userId}/{id}")
	public ResponseEntity<?> addSongs(@RequestBody Song song,Playlist playlist,@PathVariable String id,@PathVariable String userId) throws UserNotFoundException, PlaylistNotFoundException
	{
		
		userService.addASongToPlaylist(song,playlist, id, userId);
		return responseEntity = new ResponseEntity<>("song added",HttpStatus.CREATED);
		
	}
	
	@PostMapping("/user/deleteSong/{userId}/{id}/{songId}")
	public ResponseEntity<?> deleteSongs(@PathVariable String songId,@PathVariable String id,@PathVariable String userId) throws UserNotFoundException, PlaylistNotFoundException
	{
		userService.deleteASongToPlaylist(songId, id, userId);
		return responseEntity = new ResponseEntity<>("song added",HttpStatus.OK);
		
	}
}