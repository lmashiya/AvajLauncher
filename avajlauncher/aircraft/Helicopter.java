package avajlauncher.aircraft;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class Helicopter extends Aircraft implements Flyable
{
  private WeatherTower Bweathertower;

  public Helicopter(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }

  public void updateConditions()
  {
    int heightH = this.coordinates.getHeight();
    int longitudeH = this.coordinates.getLongitude();
    int latitudeH = this.coordinates.getLatitude();
    String weather = this.Bweathertower.getWeather(this.coordinates);

    if(weather.equalsIgnoreCase("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeH + 5, latitudeH, heightH);
      System.out.println("Helicopter in RAIN ");
    }
    else if (weather.equalsIgnoreCase("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeH + 10, latitudeH, heightH + 2);
      System.out.println("Helicopter in SUN ");
    }
    else if (weather.equalsIgnoreCase("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeH, latitudeH, heightH - 12);
      System.out.println("Helicopter in SNOW ");
    }
    else if (weather.equalsIgnoreCase("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeH + 1, latitudeH, heightH);
      System.out.println("Helicopter in FOG ");
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
    System.out.println("registered the JetPlane");
    this.Bweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    System.out.println("unregistered the JetPlane");
    this.Bweathertower = weathertower;
    weathertower.unregister(this);
  }

}