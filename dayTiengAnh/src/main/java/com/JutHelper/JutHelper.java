package com.JutHelper;

import java.security.Key;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JutHelper {
	@Value("${jut.privatekey}") private String privatekey; // lay gia tri private key tu file aplication
	public String generateToken(String data) {
		System.out.println(privatekey);
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privatekey));
		String jws = Jwts.builder().subject(data).signWith(key).compact();
		return jws;
	}
	
	public boolean verifyToken(String token) {
		try {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privatekey));
		Jwts.parser()     // (1)
	//	    .keyLocator((Locator<Key>)) // (2) dynamically locate signing or encryption keys
		    .verifyWith(key)      //     or a constant key used to verify all signed JWTs
		    //.decryptWith(key)     //     or a constant key used to decrypt all encrypted JWTs
	
		    .build()                // (3)
	
		    .parse(token); 
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
