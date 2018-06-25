package launcher.simulator;

import launcher.weather.*;
import launcher.machines.*;
import java.io.*;

public class Runner
{
  public static void main(String[] args) throws InterruptedException
  {
    try
    {
    //Reader to read file into the variable line
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    String line = br.readLine();
    //Check if line is empty or not
    if(line != null)
    {
      //changing from string to integer
      int simulations = Integer.parseInt(line.split(" ")[0]);
      //checking if simulations is more then 0
      if (simulations <= 0)
      {
        System.out.println("Number of simulations not specified");
        System.exit(1);
      }
    }

    }
    catch(FileNotFoundException ex)
    {
      System.out.println("File not found " + ex.toString());
    }
    catch(IOException e)
    {
      System.out.println("IO exception incurred ... " + e.toString());
    }

  }
}
