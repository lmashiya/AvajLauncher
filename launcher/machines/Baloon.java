package launcher.machines;

import launcher.machines.*;
import launcher.weather.*;
import launcher.machines.*;

public class Baloon extends Aircraft implements Flyable
{
  private WeatherTower weathertower;

  public Baloon(String name , Coordinates coordinates)
  {
    this.name = name;
    this.coordinates = coordinates;
  }

  public void updateConditions()
  {

  }

  public void registerTower(WeatherTower weathertower)
  {

  }

  public String getName()
  {
    return this.name;
  }
}
