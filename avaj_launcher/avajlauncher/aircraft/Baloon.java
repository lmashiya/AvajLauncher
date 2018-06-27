package avajlauncher.aircraft;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class Baloon extends Aircraft implements Flyable
{
  private WeatherTower Bweathertower;

  Baloon(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }

  public void updateConditions()
  {
    int heightB = this.coordinates.getHeight();
    int longitudeB = this.coordinates.getLongitude();
    int latitudeB = this.coordinates.getLatitude();
    String weather = this.Bweathertower.getWeather(this.coordinates);

    if(weather == "RAIN")
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB - 5);
      System.out.println("Ballon in RAIN ");
    }
    else if (weather == "SUN")
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB + 3);
      System.out.println("Ballon in SUN ");
    }
    else if (weather == "SNOW")
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB - 15);
      System.out.println("Ballon in SNOW ");
    }
    else if (weather == "FOG")
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB - 3);
      System.out.println("Ballon in FOG ");
    }
    else
    {
      System.out.println("Type of weather doesnt exist.....Please check");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(Bweathertower);
  }

  public void registerTower(WeatherTower weathertower)
  {
    System.out.println("registered the Ballon");
    this.Bweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    System.out.println("unregistered the Ballon");
    this.Bweathertower = weathertower;
    weathertower.unregister(this);
  }

}
