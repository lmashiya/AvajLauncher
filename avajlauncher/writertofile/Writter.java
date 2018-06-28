package avajlauncher.writertofile;

import java.io.*;
import avajlauncher.weather.*;
import avajlauncher.aircraft.*;


public class Writter {

	public void	writetofile(String str) {
		try
		{
			File file = new File("Simulated.txt");


		 BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
    writer.append("\n");
    writer.append(str);
		writer.close();
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}

	}


}
