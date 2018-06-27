package avajlauncher.simulator;

import java.util.*;
import java.io.*;
import java.lang.*;
import avajlauncher.weather.*;
import avajlauncher.aircraft.*;

public class Runner
{

    private static List<Flyable> flyables = new ArrayList<Flyable>();
    private static WeatherTower weathertower;
    public static void main(String[] args)
    {
      try
      {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line = br.readLine();

        if (line != null)
        {
          weathertower = new WeatherTower();
          int simulations = Integer.parseInt(line.split(" ")[0]);
          System.out.println("simulations----> " + simulations);
          while ((line = br.readLine()) != null)
          {
            System.out.println("In the while loop");
            System.out.println(line);
            System.out.println("Hey You im here");
            Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]),
            Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
            Coordinates coord = new Coordinates(Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),Integer.parseInt(line.split(" ")[4]));
            String weather = WeatherProvider.getProvider().getCurrentWeather(coord);
            System.out.println("getWeather -----> " + weather);
            if (flyable == null)
              flyables.add(flyable);
            System.out.println("Added all the flyables to the list");
          }
          System.out.println("Going to the for each loop");
          for(Flyable flyable: flyables)
          {
            System.out.println("inside for loop");
            System.out.println(flyable);
            flyable.registerTower(weathertower);
          }

          for (int i = 0; i < simulations; i++)
          {
            System.out.println("Changed weather-----> " + i);
            weathertower.changeWeather();
          }

        }
        else
        {
            System.out.println("The number of simulations runs must be positive or more then zero");
            System.exit(1);
        }
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
