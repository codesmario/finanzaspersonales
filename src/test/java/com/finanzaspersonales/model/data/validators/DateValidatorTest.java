package com.finanzaspersonales.model.data.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateValidatorTest extends ValidatorTestBase {
  DateValidator dateValidator;

  @BeforeEach
  void setUp() {
    dateValidator = new DateValidator();
  }

  @Test
  @DisplayName("Day is zero")
  void validateDayZero() {
    dateValidator.validate("2021-01-0");
    assertValidatorResult(
        dateValidator,
        "The day must be greater than zero.",
        false);
  }

  @Test
  @DisplayName("Invalid day")
  void validateInvalidDay() {
    dateValidator.validate("2021-02-30");
    assertValidatorResult(
        dateValidator,
        "Invalid day for the month and year provided.",
        false);
  }

  @Test
  @DisplayName("Month is zero")
  void validateMonthZero() {
    dateValidator.validate("2021-00-20");
    assertValidatorResult(
        dateValidator,
        "The month must be greater than zero.",
        false);
  }

  @Test
  @DisplayName("Month not in range [1,12]")
  void validateMonthIncorrectRange() {
    dateValidator.validate("2021-23-01");
    assertValidatorResult(
        dateValidator,
        "The month must be between 1 and 12.",
        false);
  }

  @Test
  @DisplayName("Correct date")
  void validateCorrectDate() {
    dateValidator.validate("2021-1-01");
    dateValidator.validate("2022-01-20");
    assertValidatorResult(
        dateValidator,
        "",
        true);
  }
}