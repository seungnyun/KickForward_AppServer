package com.jang.biz.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.jang.biz.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	private static final String secretKey = "secretkey";
	private long expire = 1000L * 60 * 60 * 24; // 토큰 유효기간: 24시간
	//private long expire = 30000L; // 10 seconds
	// 토큰 생성 메소드
	public String createToken(User user, String AutoLogin) {
		// 토큰 서명 알고리즘 
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		// 로그인 유지 체크 안 된 경우 - 7일 유효
		if(AutoLogin.equals("true")) {
			return Jwts.builder()
					.setHeaderParam("typ", "JWT")
					.claim("id", user.getId())
					.setExpiration(new Date(System.currentTimeMillis() + 7*expire))
					.signWith(signatureAlgorithm, secretKey.getBytes())
					.compact();
		}else{ // 로그인 유지 체크된 경우 - expire 있긴 함
			return Jwts.builder()
					.setHeaderParam("typ", "JWT") // 토큰 타입
					.claim("id", user.getId()) // payload 넣기
					.setExpiration(new Date(System.currentTimeMillis() + expire))
					.signWith(signatureAlgorithm, secretKey.getBytes()) // 토큰 서명
					.compact(); // 직렬화
		}		
	}
	// 토큰 속 claim 정보 가져오는 메소드
	public Claims getClaim(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(secretKey.getBytes())
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}

	// JWT token 유효성 검증 메소드
	public boolean checkTokenExp(String token) {
		try{
			Claims claims = Jwts.parser()
					.setSigningKey(secretKey.getBytes())
					.parseClaimsJws(token)
					.getBody();
			System.out.println("[+] expire: " + claims.getExpiration());
			return true;
		}catch(ExpiredJwtException e) { // 토큰 만료된 경우
			System.out.println("[-] Token Expired");
			return false;
		}catch(JwtException e) { // 토큰 변조된 경우
			System.out.println("[-] Token Modified");
			return false;
		}
	}
}
