package avajlauncher.aircraft;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class JetPlane extends Aircraft implements Flyable
{
  private WeatherTower Jweathertower;

  public JetPlane(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }

  public void updateConditions()
  {
    int heightJ = this.coordinates.getHeight();
    int longitudeJ = this.coordinates.getLongitude();
    int latitudeJ = this.coordinates.getLatitude();
    String weather = this.Jweathertower.getWeather(this.coordinates);

    if(weather == "RAIN")
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ, heightJ - 5);
      System.out.println("JetPlane in RAIN ");
    }
    else if (weather == "SUN")
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ, heightJ + 3);
      System.out.println("JetPlane in SUN ");
    }
    else if (weather == "SNOW")
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ, heightJ - 15);
      System.out.println("JetPlane in SNOW ");
    }
    else if (weather == "FOG")
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ, heightJ - 3);
      System.out.println("JetPlane in FOG ");
    }
    else
    {
      System.out.println("Type of weather doesnt exist.....Please check");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(Jweathertower);
  }

  public void registerTower(WeatherTower weathertower)
  {
    System.out.println("registered the JetPlane");
    this.Jweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    System.out.println("unregistered the JetPlane");
    this.Jweathertower = weathertower;
    weathertower.unregister(this);
  }

}
