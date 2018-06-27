package avajlauncher.weather;

import java.util.*;
import avajlauncher.aircraft.*;

public class WeatherProvider
{
  private static  WeatherProvider weatherProvider = null;
  private static String[] weather = {"RAIN","SUN","FOG","SNOW"};

  private WeatherProvider()
  {}

  public static WeatherProvider getProvider()
  {
    System.out.println("WeatherProvider inside ");
    if(weatherProvider == null)
      weatherProvider = new WeatherProvider();
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates)
  {
    int randNum = (int)(Math.random() * weather.length);
    System.out.println("Weather chosen " + randNum);
    System.out.println(weather);
    return weather[randNum];
  }
}
