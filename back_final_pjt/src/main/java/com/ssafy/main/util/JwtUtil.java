package com.ssafy.main.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private static final String SALT = "coex";
	
	//토큰 생성
	//인자로 키와 밸류가 넘어왔다고만 처리 (한가지의 정보만 넣는다고 가정)
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return 	Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")//헤더완료
				.claim(claimId, data)
				// 페이로드 완료
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명 완료
				.compact();
	}
	
	//유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey("".getBytes("UTF-8")).parseClaimsJws(token);
	}
	
}
