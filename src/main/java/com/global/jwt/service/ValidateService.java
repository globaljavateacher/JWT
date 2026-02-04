package com.global.jwt.service;

import java.util.Properties;

import com.global.jwt.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class ValidateService {
	
	public static void validate(HttpServletRequest req) {
		try {
			String jwt = req.getParameter("jwt");
			String[] jwtArr = jwt.split("\\.");
			String encodedHeader = jwtArr[0];
			String encodedPayload = jwtArr[1];
			String requestSignature = jwtArr[2];
			String jwtPrivateKey = ((Properties)req.getServletContext().getAttribute("appConfig")).getProperty("jwt.private.key");
			String encodedSignature = JwtUtil.createSignature(encodedHeader, encodedPayload, jwtPrivateKey);
			boolean same = encodedSignature.equals(requestSignature) ? true : false ;
			req.setAttribute("signature", same);
			String payloadJson = JwtUtil.base64UrlDecode(encodedPayload);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode payloadNode = mapper.readTree(payloadJson);
			long exp = payloadNode.get("exp").asLong();
			long now = System.currentTimeMillis() / 1000;
			boolean use = exp > now ? true : false ;
			req.setAttribute("exp", use);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
