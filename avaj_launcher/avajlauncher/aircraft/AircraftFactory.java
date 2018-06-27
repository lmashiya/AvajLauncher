package avajlauncher.aircraft;

import avajlauncher.weather.*;
import avajlauncher.aircraft.*;

public class AircraftFactory
{
  public static Flyable newAircraft(String type,String name, int longitude, int latitude, int height )
  {
    System.out.println("Making Aircraft in Factory");
    if (longitude > 0 && latitude > 0 && height >= 1)
    {
      Coordinates coordinates = new Coordinates(longitude,latitude,height);
      if(type.equalsIgnoreCase("Baloon"))
        return new Baloon(name, coordinates);
      else if (type.equalsIgnoreCase("Helicopter"))
        return new Helicopter(name, coordinates);
      else if (type.equalsIgnoreCase("Jetplane"))
        return new JetPlane(name, coordinates);
      else
      {
        System.out.println("Flyable does not exist please check input file");
        System.exit(1);
        return null;
      }
    }
    else
    {
      System.out.println("Please input positive values that are bigger than zero in the coordinates");
      System.exit(1);
      return null;
    }
  }
}
