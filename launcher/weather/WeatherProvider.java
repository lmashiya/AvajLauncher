package launcher.weather;


import launcher.weather.*;
import launcher.machines.*;
public class WeatherProvider
{
  private WeatherProvider weatherprovider;
  private String[] weather = {"SNOW","RAIN","FOG","SUN"};

  private WeatherProvider()
  {

  }

  public WeatherProvider getProvider()
  {
    weatherprovider = new WeatherProvider();
    return weatherprovider;
  }

  public String getCurrentWeather(Coordinates coordinates)
  {
    int randNum = (int)(Math.random() * weather.length);
    return weather[randNum];
  }
}
