package no.marko19907.javaObserverPattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureSensorTest {

  @Test
  @DisplayName("Tests the default no-arg constructor")
  public void testNoArgConstructor() {
    TemperatureSensor sensor = new TemperatureSensor();
    assertEquals(0, sensor.getTemperature());
  }

  @Test
  @DisplayName("Tests the constructor")
  public void testConstructor() {
    TemperatureSensor sensor = new TemperatureSensor(50);
    assertEquals(50, sensor.getTemperature());
  }

  @Test
  @DisplayName("Test setting the temperature")
  public void testSettingTemperature() {
    // Arrange
    TemperatureSensor sensor = new TemperatureSensor();

    // Act
    sensor.setTemperature(15);

    // Assert
    assertEquals(15, sensor.getTemperature());
  }

  @Test
  @DisplayName("Test adding an observer")
  public void testAddingObserver() {
    // Arrange
    TemperatureSensor sensor = new TemperatureSensor();
    Window observer = new Window();

    // Act
    sensor.addObserver(observer);

    // Assert
    assertEquals(1, sensor.getObserverNumber());
    assertTrue(sensor.getObservers().stream()
        .anyMatch(temperatureObserver -> temperatureObserver.equals(observer)));
  }

  @Test
  @DisplayName("Test removing an observer")
  public void testRemovingObserver() {
    // Arrange
    TemperatureSensor sensor = new TemperatureSensor();
    Window observer = new Window();
    sensor.addObserver(observer);

    // Act
    sensor.removeObserver(observer);

    // Assert
    assertEquals(0, sensor.getObserverNumber());
    assertFalse(sensor.getObservers().stream()
        .anyMatch(temperatureObserver -> temperatureObserver.equals(observer)));
  }
}