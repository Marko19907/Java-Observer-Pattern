package no.marko19907.javaObserverPattern;

/**
 * Class Windows represents a simple class that simulates a virtual window.
 */
public class Window implements TemperatureObservable {

  @Override
  public void updateTemperature(int temp) {
    if (temp > 35) {
      System.out.println("The Window is now open!");
    }
    else {
      System.out.println("The Window is now closed!");
    }
  }
}
