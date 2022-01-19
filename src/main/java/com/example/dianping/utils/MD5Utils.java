package com.example.dianping.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author zh
 * @date 2021/7/9 20:50
 */
public class MD5Utils {

	public static String getMd5Str(String strValue) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(md5.digest(strValue.getBytes()));
	}
}
