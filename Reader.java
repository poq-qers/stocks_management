package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	static int totalLines = 0;
	String path;
	
	public Reader(String path) {
		this.path=path;
	}
	
	public String readLine() {
		totalLines++;
		int currentLine = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine()) != null) {
				currentLine++;
				if(currentLine == totalLines) {
					reader.close();
					return line;
				}
			}
			reader.close();
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		return "error";
	}
	
}
