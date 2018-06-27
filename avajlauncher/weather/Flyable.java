package avajlauncher.weather;

import avajlauncher.aircraft.*;
import avajlauncher.weather.*;

public interface Flyable
{
  public void updateConditions();
  public void registerTower(WeatherTower weathertower);
  public void unregisterTower(WeatherTower weathertower);
}
