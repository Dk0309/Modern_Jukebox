package com.simplecoding.JukeboxApplication.token;

import java.util.Map;

import com.simplecoding.JukeboxApplication.model.User;

public interface TokenGenerationService {

	Map<String,String> generateToken(User user);
}
