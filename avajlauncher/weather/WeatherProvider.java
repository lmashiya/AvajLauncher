package avajlauncher.weather;

import java.util.*;
import avajlauncher.aircraft.*;
import avajlauncher.writertofile.*;

public class WeatherProvider
{
  private static  WeatherProvider weatherProvider = null;
  private static String[] weather = {"RAIN","SUN","FOG","SNOW"};

  private WeatherProvider()
  {}

  public static WeatherProvider getProvider()
  {
    if(weatherProvider == null)
      weatherProvider = new WeatherProvider();
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates)
  {
    int randNum = (int)(Math.random() * weather.length);
    return weather[randNum];
  }
}
