package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataIO {
	
	public static String readConsoleLine() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = reader.readLine();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

}
