package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	String path;
	
	public Writer(String path) {
		this.path=path;
	}
	
	public void writeLine(String line) {
		String[] elements = line.split(";");
		String clean_line = elements[0].trim();
		for(int i = 1; i<elements.length;i++) {
			clean_line = clean_line.concat(";").concat(elements[i].trim());
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
			writer.write("\n" + clean_line);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

