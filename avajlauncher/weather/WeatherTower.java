package avajlauncher.weather;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public class WeatherTower extends Tower
{
  public String getWeather(Coordinates coordinates)
  {
      String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
      return weather;
  }

  public void changeWeather()
  {
    this.conditionsChanged();
  }
}
