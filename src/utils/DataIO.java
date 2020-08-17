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
	
	public static String[] readAndTreatConsoleLine() {
		return readConsoleLine().trim().split("[,|,\s]+");
	}
	
	public static void printAsStringLine(String[] text) {
		if (text == null) {
			return;
		}

		String str = "";
		for (int i = 0; i < text.length; i++) {
			str += text[i] + " ";
		}
		if (!str.equals("")) {
			System.out.println(str);
		}
	}

}
