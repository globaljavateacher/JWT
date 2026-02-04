package com.global.jwt.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class JwtUtil {
	
	public static String base64UrlEncode(String data) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(data.getBytes(StandardCharsets.UTF_8));
	}
	
	public static String base64UrlDecode(String data) {
		byte[] decoded = Base64.getUrlDecoder().decode(data);
		return new String(decoded, StandardCharsets.UTF_8);
	}
	
	public static String createSignature(String header, String payload, String jwtPrivateKey) throws Exception {
		String data = header + "." + payload;
		Mac sha256Hmac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKey = new SecretKeySpec(jwtPrivateKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
		sha256Hmac.init(secretKey);
		byte[] signatureBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));
		return Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);
	}
}
