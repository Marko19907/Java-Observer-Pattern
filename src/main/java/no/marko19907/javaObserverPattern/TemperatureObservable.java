package no.marko19907.javaObserverPattern;

/**
 * Interface TemperatureObservable allows the classes that implement it
 * to receive updates from the TemperatureSensor.
 */
public interface TemperatureObservable {

  /**
   * Updates the temperature to the given value.
   * @param temp The new temperature value
   */
  void updateTemperature(int temp);
}