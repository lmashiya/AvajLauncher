package avajlauncher.aircraft;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class Helicopter extends Aircraft implements Flyable
{
  private WeatherTower Hweathertower;

  public Helicopter(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }

  public void updateConditions()
  {
    int heightH = this.coordinates.getHeight();
    int longitudeH = this.coordinates.getLongitude();
    int latitudeH = this.coordinates.getLatitude();
    String weather = this.Hweathertower.getWeather(this.coordinates);

    if(weather == "RAIN")
    {
      this.coordinates = new Coordinates(longitudeH, latitudeH, heightH - 5);
      System.out.println("Helicopter in RAIN ");
    }
    else if (weather == "SUN")
    {
      this.coordinates = new Coordinates(longitudeH, latitudeH, heightH + 3);
      System.out.println("Helicopter in SUN ");
    }
    else if (weather == "SNOW")
    {
      this.coordinates = new Coordinates(longitudeH, latitudeH, heightH - 15);
      System.out.println("Helicopter in SNOW ");
    }
    else if (weather == "FOG")
    {
      this.coordinates = new Coordinates(longitudeH, latitudeH, heightH - 3);
      System.out.println("Helicopter in FOG ");
    }
    else
    {
      System.out.println("Type of weather doesnt exist.....Please check");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(Hweathertower);
  }

  public void registerTower(WeatherTower weathertower)
  {
    System.out.println("registered the JetPlane");
    this.Hweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    System.out.println("unregistered the JetPlane");
    this.Hweathertower = weathertower;
    weathertower.unregister(this);
  }

}
