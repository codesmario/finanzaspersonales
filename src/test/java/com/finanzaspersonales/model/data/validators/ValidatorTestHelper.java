package com.finanzaspersonales.model.data.validators;

import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTestHelper {
  public static void assertValidator(@NotNull CategoryNameValidator nameValidator,
                                     String expectedMessage,
                                     boolean result) {
    assertValidation(nameValidator, expectedMessage, result);
  }

  public static void assertValidator(@NotNull DateValidator dateValidator,
                                     String expectedMessage, boolean result) {
    assertValidation(dateValidator, expectedMessage, result);
  }

  public static void assertValidator(@NotNull TransactionAmountValidator amountValidator,
                                     String expectedMessage, boolean result) {
    assertValidation(amountValidator, expectedMessage, result);
  }

  private static void assertValidation(@NotNull Validator validator, String expectedMessage,
                                       boolean isValid) {
    assertEquals(expectedMessage, validator.messages);
    assertEquals(isValid, validator.isValid());
  }
}
