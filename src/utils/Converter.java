package utils;

import java.nio.charset.StandardCharsets;

public class Converter {
	
	public static String bytesToString(byte[] bytes) {
		return new String(bytes, StandardCharsets.UTF_8);
	}
	
	public static byte [] stringToBytes(String string) {
		return string.getBytes();
	}
	
	public static String bytesToHexString(byte[] bytes) {
		String s = "";
		for (byte b : bytes) {
			s += Integer.toHexString(b);
		}
		return s;
	}

}
