package avajlauncher.simulator;

import java.util.*;
import java.io.*;
import java.lang.*;
import avajlauncher.aircraft.*;
import avajlauncher.weather.*;
import avajlauncher.writertofile.*;

public class Runner
{

    private static List<Flyable> flyables = new ArrayList<Flyable>();
    private static WeatherTower weatherTower;
    private static Writter wrote = new Writter();
    public static void main(String[] args)
    {
      try
      {
        // wrote.writetofile("Hello there");
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line = br.readLine();

        if (line != null)
        {
          weatherTower = new WeatherTower();
          int simulations = Integer.parseInt(line.split(" ")[0]);
          while ((line = br.readLine()) != null)
          {
            Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]),
            Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
            flyables.add(flyable);
          }
          for(Flyable flyable: flyables)
          {
            flyable.registerTower(weatherTower);
          }

          for (int i = 0; i < simulations; i++)
          {
            weatherTower.changeWeather();
          }

        }
        else
        {
            System.out.println("The number of simulations runs must be positive or more then zero");
            System.exit(1);
        }
        br.close();
      }
      catch(FileNotFoundException no_file)
      {
        System.out.println(no_file.toString());
      }
      catch(IOException ex)
      {
        System.out.println(ex.toString());
      }
    }

}
