package chris;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Counter {
	
	public static int lines = 0;
	public static int whiles= 0;
	public static int fors = 0;
	public static int ifs = 0;
	public static int switches = 0;
	
	public static int countLines(File f) throws IOException{
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(f));
		String line = reader.readLine();
		while(line != null) {
			System.out.println(line);
			if (line.contains("//")) {
				lines--;
			}
			if(line.startsWith("/*")) {
				do {
					lines--;
				}while(!line.startsWith("*/"));
			}
			if(line.isBlank()) {
				lines--;
			}
			lines++;
			line = reader.readLine();
			System.out.println(lines);
		}
		return lines;
		
	}
	
	public static void countLoops(File f) throws IOException{
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(f));
		String line = reader.readLine();
		while(line != null) {
			if(line.contains("for")) {
				fors++;
			}else if(line.contains("while")) {
				whiles++;
			}else if(line.contains("if")) {
				ifs++;
			}else if(line.contains("switch")) {
				switches++;
			}
			line = reader.readLine();
		}
	}

	
	public static int getLines() {
		return lines;
	}

	public static int getWhiles() {
		return whiles;
	}

	public static int getFors() {
		return fors;
	}

	public static int getIfs() {
		return ifs;
	}

	public static int getSwitches() {
		return switches;
	}
}
