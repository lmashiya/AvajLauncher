package avajlauncher.aircraft;

import java.util.*;
import java.io.*;
import avajlauncher.weather.*;


public class WriteToFile {
	private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter output = null;

	public WriteToFile()
	{
		try{
			file = new File("Simulated.txt");
			fileWriter = new FileWriter(file);
			output = new BufferedWriter(fileWriter);
		} catch (IOException e)
		{ }
	}

	public void	writetofile(String str) {
		try {
			output.write(str);
			output.newLine();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void closeFile() {
		try {
			if (output != null)
				output.close();
		} catch (Exception ex) {
			System.out.println("File not closing");
		}
	}
}
