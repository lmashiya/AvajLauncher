package avajlauncher.aircraft;

import avajlauncher.weather.*;

public class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private long idCounter = 0L;

    protected Aircraft(String name , Coordinates coordinates)
    {
      this.id = nextId();
      this.name = name;
      this.coordinates = coordinates;
    }

    private long nextId()
    {
      return ++this.idCounter;
    }
}
