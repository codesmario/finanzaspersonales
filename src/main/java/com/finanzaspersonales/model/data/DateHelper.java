package com.finanzaspersonales.model.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.WeekFields;

public class DateHelper {
  private DateHelper() { }

  public static int currentMonthLength() {
    return YearMonth.now().lengthOfMonth();
  }

  public static int monthWeeks(@NotNull YearMonth yearMonth) {
    return yearMonth.atEndOfMonth().get(WeekFields.ISO.weekOfMonth());
  }
}
