package avajlauncher.weather;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class WeatherTower extends Tower
{
  public String getWeather(Coordinates coordinates)
  {
      String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
      System.out.println("gteWeather -----> " + weather);
      return weather;
  }

  public void changeWeather()
  {
    System.out.println("Inside changeWeather ");
    this.conditionsChanged();
  }
}
