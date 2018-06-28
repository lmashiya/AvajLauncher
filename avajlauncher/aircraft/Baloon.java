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

    if(weather.equals("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB - 5);
      System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " :The clouds are pissing all over my baloon");
    }
    else if (weather.equals("SUN"))
    {
      this.coordinates = new Coordinates(longitudeB + 2, latitudeB, heightB + 4);
      System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " :My choclates are melting");
    }
    else if (weather.equals("SNOW"))
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB - 15);
      System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " :The damn heater aint working im dying of this cold!!!");
    }
    else if (weather.equals("FOG"))
    {
      this.coordinates = new Coordinates(longitudeB, latitudeB, heightB - 3);
      System.out.println("Baloon#" + this.name + "(" + this.id + ")" + " :I cant see much but i can bet isaw a Lochness monster flying past");
    }
    else
    {
      System.out.println("Type of weather doesnt exist.....Please check in Baloon");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(Bweathertower);
  }

  public void registerTower(WeatherTower weathertower)
  {
    System.out.println("Tower 1234-543 : Baloon#" + this.name + "(" + this.id + ")" + " has registered to the Tower" );
    this.Bweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    System.out.println("Tower 1234-543 : Baloon#" + this.name + "(" + this.id + ")" + " has unregistered to the Tower" );
    this.Bweathertower = weathertower;
    weathertower.unregister(this);
  }

}
