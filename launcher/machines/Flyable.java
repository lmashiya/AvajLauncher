package launcher.machines;

import launcher.weather.*;
import launcher.machines.*;

public interface Flyable
{
  public void updateConditions();
  public void registerTower(WeatherTower weathertower);
}
