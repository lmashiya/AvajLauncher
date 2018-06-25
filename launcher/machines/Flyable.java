package launcher.machines;

import launcher.weather.*;
import launcher.machines.*;
import launcher.simulator.*;

public interface Flyable
{
  public void updateConditions();
  public void registerTower(WeatherTower weathertower);
}
