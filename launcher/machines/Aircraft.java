package launcher;

public class Aircraft
{
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private long idCounter;

  protected void Aircraft(String name, Coordinates coordinates)
  {

  }

  private long nextId()
  {

  }

  public long getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }
}