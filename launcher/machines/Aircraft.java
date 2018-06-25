package launcher.machines;

import java.io.*;
import launcher.weather.*;
import launcher.machines.*;

public class Aircraft
{
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private long idCounter;

 protected void Aircraft(String name, Coordinates coordinates)
  {
    this.name = name;
    this.coordinates = coordinates;
  }

  public Aircraft()
  {}

  private long nextId()
  {
    return this.id;
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

  public static void doReader(String path)
  {
    String line;

    try
    {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line != null)
        System.out.println(line);
    }
      catch(FileNotFoundException e)
    {
      System.out.println("File not found ...... " + path);
      System.exit(0);
    }

    catch(IOException ex)
    {
      System.out.println("They is no text to read");
      System.exit(0);
    }
  }

}
