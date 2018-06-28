package avajlauncher.aircraft;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;
import avajlauncher.writertofile.*;

public class JetPlane extends Aircraft implements Flyable
{
  private WeatherTower Bweathertower;
  Writter obj = new Writter();
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
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " :Rain rain rain on me rain on me");
    }
    else if (weather.equals("SUN"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ + 10, heightJ + 2);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " :The gods have granted me safe passage...sunny day ...sunny skies!!!");
    }
    else if (weather.equals("SNOW"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ, heightJ - 7);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " : Bring my six pack and cooler box so i can put mt beers in...Snow");
    }
    else if (weather.equals("FOG"))
    {
      this.coordinates = new Coordinates(longitudeJ, latitudeJ + 1, heightJ);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " : Mxm cant see past my nose .......what the Hell");
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
    obj.writetofile("Tower 1234-543 : JetPlane#" + this.name + "(" + this.id + ")" + " has registered to the Tower" );
    this.Bweathertower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    obj.writetofile("Tower 1234-543 : JetPlane#" + this.name + "(" + this.id + ")" + " has unregistered to the Tower" );
    this.Bweathertower = weathertower;
    weathertower.unregister(this);
  }

}
