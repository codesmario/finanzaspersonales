package com.finanzaspersonales.model.data.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransactionAmountValidatorTest {
  TransactionAmountValidator amountValidator;

  @BeforeEach
  void setup() {
    amountValidator = new TransactionAmountValidator();
  }

  @Test
  @DisplayName("Amount is less than zero.")
  void validateNegativeAmount() {
    amountValidator.validate(-1000);
    ValidatorTestHelper.assertValidator(
        amountValidator,
        "Amount value must be greater than zero.",
        false);
  }

  @Test
  @DisplayName("Amount is zero.")
  void validateZeroAmount() {
    amountValidator.validate(0);
    ValidatorTestHelper.assertValidator(
        amountValidator,
        "Amount value must be greater than zero.",
        false);
  }

  @Test
  @DisplayName("Amount is more than zero and correct.")
  void validateAmount() {
    amountValidator.validate(2000);
    ValidatorTestHelper.assertValidator(
        amountValidator,
        "",
        true);
  }
}
