package com.jbt.springbootactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Customer health indicator can be written to provide some extra information to be added in
 * health actuator.
 */
@Component
public class CustomHealthActuator implements HealthIndicator {

  @Override
  public Health health() {
    return Health.up().withDetail("JBT", "UP").build();
  }
}
