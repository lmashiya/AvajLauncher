package launcher.machines;

import launcher.simulator.*;
import launcher.weather.*;
import launcher.machines.*;
//This the factory for all your machines or in this case Flyables
public class AircraftFactory
{
  public  static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
  {
    //checking if the values are valid
    if (longitude >= 0 && latitude >= 0 && height > 1)
    {
      //make new instance of coordinates if valid
      Coordinates coord = new Coordinates(longitude, latitude, height);
      //checking the name and making objects for machines
      String newName = type.toUpperCase();
      if (newName.equals("BALOON"))
      {
        return new Baloon(name,coord);
      }

      else if (newName.equals("JETPLANE"))
      {
        return new JetPlane(name, coord);
      }

      else if (newName.equals("HELICOPTER"))
      {
        return new Helicopter(name, coord);
      }

      else
      {
          System.out.println("Please make sure the Flyable is a [BALOON,JETPLANE,AIRCRAFT]");
          System.exit(1);
          return null;
      }
    }
    else
      {
        System.out.println("The input values must be positve and larger then 0");
        System.exit(1);
        return null;
      }
  }
}
