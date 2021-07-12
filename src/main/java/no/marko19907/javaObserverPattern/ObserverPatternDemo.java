package no.marko19907.javaObserverPattern;

/**
 * A simple main class for testing.
 */
public class ObserverPatternDemo {

  /**
   * The main method.
   * @param args The command-line arguments
   */
  public static void main(String[] args) {
    TemperatureSensor sensor = new TemperatureSensor();
    sensor.setTemperature(40);

    Window window = new Window();
    sensor.addObserver(window);
    sensor.setTemperature(45);
    sensor.setTemperature(10);
  }
}
