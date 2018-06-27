package avajlauncher.aircraft;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class JetPlane extends Aircraft implements Flyable
{
  private WeatherTower Bweathertower;

  public JetPlane(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }

  public void updateConditions()
  {
    int heightJ = this.coordinates.getHeight();
    int longitudeJ = this.coordinates.getLongitude();
    int latitudeJ = this.coordinates.getLatitude();
    String weather = this.Bweathertower.getWeather(this.coordinates);

    if(weather.equals("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ + 5, heightJ);
      System.out.println("JetPlane in RAIN ");
    }
    else if (weather.equals("SUN"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ + 10, heightJ + 2);
      System.out.println("JetPlane in SUN ");
    }
    else if (weather.equals("SNOW"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ, heightJ - 7);
      System.out.println("JetPlane in SNOW ");
    }
    else if (weather.equals("FOG"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ + 1, heightJ);
      System.out.println("JetPlane in FOG ");
    }
    else
    {
      System.out.println("Type of weather doesnt exist.....Please check Jrtplane");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(Bweathertower);
}

  public void registerTower(WeatherTower weathertower)
  {
    this.Bweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    this.Bweathertower = weathertower;
    weathertower.unregister(this);
  }

}
