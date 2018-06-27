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

    if(weather.equals("RAIN"))
    {
      this.coordinates = new Coordinates(longitudeH + 5, latitudeH, heightH);
      System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " :Why so much rain......i hate water!!!");
    }
    else if (weather.equals("SUN"))
    {
      this.coordinates = new Coordinates(longitudeH + 10, latitudeH, heightH + 2);
      System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " :My ass is on fire .......damnm is getting tooo hot!!!");
    }
    else if (weather.equals("SNOW"))
    {
      this.coordinates = new Coordinates(longitudeH, latitudeH, heightH - 12);
      System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " :Frozen the movie is playing on Etv!!!");
    }
    else if (weather.equals("FOG"))
    {
      this.coordinates = new Coordinates(longitudeH + 1, latitudeH, heightH);
      System.out.println("Helicopter#" + this.name + "(" + this.id + ")" + " Wish i had headlights tom see through this FOG!!!");
    }
    else
    {
      System.out.println("Type of weather doesnt exist.....Please check in Helicopter");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(Bweathertower);
  }

  public void registerTower(WeatherTower weathertower)
  {
    System.out.println("Tower 1234-543 : Helicopter#" + this.name + "(" + this.id + ")" + " has registered to the Tower" );
    this.Bweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    System.out.println("Tower 1234-543 : Helicopter#" + this.name + "(" + this.id + ")" + " has unregistered to the Tower" );
    this.Bweathertower = weathertower;
    weathertower.unregister(this);
  }

}
