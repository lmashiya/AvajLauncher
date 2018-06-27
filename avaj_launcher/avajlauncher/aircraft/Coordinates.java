package avajlauncher.aircraft;

import avajlauncher.weather.*;
import avajlauncher.aircraft.*;

public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
      this.latitude = latitude;
      this.longitude = longitude;
      this.height = height;
    }

    public int getHeight()
    {
      return this.height;
    }

    public int getLatitude()
    {
      return this.latitude;
    }

    public int getLongitude()
    {
      return this.longitude;
    }
}
