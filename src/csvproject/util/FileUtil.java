package csvproject.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
	
	public static final String lineSeparator = System.lineSeparator();
	
	public static boolean write(String path, String data) {
		boolean append = false; // Default value without append parameter
		return write(path, data, append);
	}
	
	public static boolean write(String path, String data, boolean append) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		boolean success = true;
		try {
			fileWriter = new FileWriter(path, append);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(data);
			
		} catch (IOException e) {
			success = false;
			print("Error 1");
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
				fileWriter.close();
			} catch(IOException e) {
				print("Error 2");
				e.printStackTrace();
			}
		}
		
		return success;
	}
	
	public static String getStringInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
	
	public static void print(String display) {
		print(display, false);
	}
	
	public static void print(String display, boolean newLine) {
		if(newLine) {
			System.out.println(display);
		} else {
			System.out.print(display);
		}
	}
}
