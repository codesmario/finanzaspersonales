package com.finanzaspersonales.model.data.validators;

import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTestBase {
  protected void assertValidatorResult(@NotNull Validator validator,
                                       String expectedMessage,
                                       boolean result) {
    assertEquals(expectedMessage, validator.messages);
    assertEquals(result, validator.isValid());
  }
}
