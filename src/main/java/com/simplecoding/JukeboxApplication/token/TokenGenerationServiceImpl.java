package com.simplecoding.JukeboxApplication.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.simplecoding.JukeboxApplication.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenGenerationServiceImpl implements TokenGenerationService {

	@Override
	public Map<String, String> generateToken(User user) {
		
		String jwtToken=Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretkey").compact();
        Map<String,String> map=new HashMap<String, String>();
        map.put("token",jwtToken);
        map.put("message","User successfully logged in");
        return map;

	}

}
