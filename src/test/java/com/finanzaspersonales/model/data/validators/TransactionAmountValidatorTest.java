package com.finanzaspersonales.model.data.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransactionAmountValidatorTest extends ValidatorTestBase {
  TransactionAmountValidator amountValidator;

  @BeforeEach
  void setup() {
    amountValidator = new TransactionAmountValidator();
  }

  @Test
  @DisplayName("Amount is less than zero.")
  void validateNegativeAmount() {
    amountValidator.validate(-1000);
    assertValidatorResult(
        amountValidator,
        "Amount value must be greater than zero.",
        false);
  }

  @Test
  @DisplayName("Amount is zero.")
  void validateZeroAmount() {
    amountValidator.validate(0);
    assertValidatorResult(
        amountValidator,
        "Amount value must be greater than zero.",
        false);
  }

  @Test
  @DisplayName("Amount is more than zero and correct.")
  void validateAmount() {
    amountValidator.validate(2000);
    assertValidatorResult(
        amountValidator,
        "",
        true);
  }
}
