package avajlauncher.weather;

import avajlauncher.aircraft.*;
import java.util.*;

public class Tower
{
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> unregistered = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
      System.out.println("Registering");
      if(observers.contains(flyable))
        return;
      else
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
      System.out.println("Unregistring");
      if(unregistered.contains(flyable))
        return;
      else
        unregistered.add(flyable);
    }

    protected void conditionsChanged()
    {
      for(Flyable flyers: observers)
      {
        System.out.println("Doing the updating");
        flyers.updateConditions();
      }
      observers.removeAll(unregistered);
    }


}
