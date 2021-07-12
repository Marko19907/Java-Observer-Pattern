package no.marko19907.javaObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TemperatureSensor represents a virtual sensor that can notify
 * subscribed observers of changes according to the "observer" design pattern.
 */
public class TemperatureSensor {
  /**
   * The List of temperature observers that receive temperature updates.
   */
  private final List<TemperatureObservable> observers;

  /**
   * The current temperature
   */
  private int temperature;

  /**
   * Default no-arg constructor with a start temperature of 0 degrees.
   */
  public TemperatureSensor() {
    this.observers = new ArrayList<>();
    this.temperature = 0;
  }

  /**
   * Constructor for TemperatureSensor objects with a given start temperature.
   * @param startTemp The start temperature of the sensor
   */
  public TemperatureSensor(int startTemp) {
    this.observers = new ArrayList<>();
    this.temperature = startTemp;
  }

  /**
   * Adds the given observer to the List of observers that receive updates.
   * @param observer The observer to add, not null
   */
  public void addObserver(TemperatureObservable observer) {
    if (observer != null) {
      this.observers.add(observer);
    }
  }

  /**
   * Removes the given observer from the List of observers that receive updates.
   * @param observer The observer to remove, not null
   */
  public void removeObserver(TemperatureObservable observer) {
    if (observer != null) {
      this.observers.removeIf(observer::equals);
    }
  }

  /**
   * Sets the given temperature as the sensor's current temperature,
   * all observers are notified of the temperature change.
   * @param temperature The new sensor temperature
   */
  public void setTemperature(int temperature) {
    this.temperature = temperature;
    this.updateObservers();
  }

  /**
   * Notifies all observers of a temperature change.
   */
  private void updateObservers() {
    this.observers.forEach(observable -> {
      if (observable != null) {
        observable.updateTemperature(this.temperature);
      }
    });
  }

  /**
   * Returns the current temperature of the sensor.
   * @return The current temperature of the sensor
   */
  public int getTemperature() {
    return this.temperature;
  }

  /**
   * Returns the number of observers currently subscribed to the temperature updates.
   * @return The number of observers currently subscribed to the temperature updates
   */
  public int getObserverNumber() {
    return this.observers.size();
  }

  /**
   * Returns a List of the currently subscribed observers.
   * @return A List of the currently subscribed observers
   */
  public List<TemperatureObservable> getObservers() {
    return this.observers;
  }
}
