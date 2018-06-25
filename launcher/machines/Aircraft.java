package launcher.machines;

import java.io.*;
import launcher.weather.*;
import launcher.machines.*;

public class Aircraft
{
  protected static long id;
  protected String name;
  protected Coordinates coordinates;
  private long idCounter = 0L;

 protected void Aircraft(String name, Coordinates coordinates)
  {
    this.id = nextId();
    this.name = name;
    this.coordinates = coordinates;
  }

  public Aircraft()
  {}

  private long nextId()
  {
    return ++this.idCounter;
  }

  public long getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public long createId()
  {
    return this.id = (long)(Math.random() * 1234567);

  }


}
