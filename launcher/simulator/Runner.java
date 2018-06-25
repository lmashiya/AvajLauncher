package launcher.simulator;

import launcher.weather.*;
import launcher.machines.*;
import java.io.*;
import java.util.*;

public class Runner
{
  private static List<Flyable> flyables = new ArrayList<Flyable>();
  private static WeatherTower weathertower;

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
      while ((line = br.readLine()) != null)
      {
        Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0],line.split(" ")[1],Integer.parseInt(line.split(" ")[2]),
        Integer.parseInt(line.split(" ")[3]),Integer.parseInt(line.split(" ")[4]));

        flyables.add(flyable);
      }
      for(Flyable flyable: flyables) {
        flyable.registerTower(weathertower);
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
