package com.jbt.mapstruct.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateMapper {

  public String asString(LocalDate date) {
    return date == null ? null : date.format(DateTimeFormatter.ofPattern("dd mm yyyy"));
  }

  public Date asDate(String date) {
    try {
      return date != null ? new SimpleDateFormat("yyyy-MM-dd").parse(date) : null;
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
