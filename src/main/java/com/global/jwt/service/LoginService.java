package com.global.jwt.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.global.jwt.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import tools.jackson.databind.ObjectMapper;

public class LoginService {
	
	public static void login(HttpServletRequest req) {
		try {
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			if ( "hong".equals(userId) && "1234".equals(userPw) ) {
				Map<String, Object> header = new HashMap<>();
				header.put("alg", "HS256");
				header.put("typ", "JWT");
				ObjectMapper mapper = new ObjectMapper();
				String headerJson = mapper.writeValueAsString(header);
				String encodedHeader = JwtUtil.base64UrlEncode(headerJson);
				Map<String, Object> payload = new HashMap<>();
				payload.put("sub", "hong");
				payload.put("role", "ROLE_USER");
				payload.put("iat", System.currentTimeMillis() / 1000);
				payload.put("exp", (System.currentTimeMillis() / 1000) + 3600);
				String payloadJson = mapper.writeValueAsString(payload);
				String encodedPayload = JwtUtil.base64UrlEncode(payloadJson);
				String jwtPrivateKey = ((Properties)req.getServletContext().getAttribute("appConfig")).getProperty("jwt.private.key");
				String encodedSignature = JwtUtil.createSignature(encodedHeader, encodedPayload, jwtPrivateKey);
				req.setAttribute("headerJson", headerJson);
				req.setAttribute("payloadJson", payloadJson);
				req.setAttribute("JWT", encodedHeader + "." + encodedPayload + "." + encodedSignature);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
