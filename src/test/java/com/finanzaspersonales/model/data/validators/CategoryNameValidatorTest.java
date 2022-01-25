package com.finanzaspersonales.model.data.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryNameValidatorTest {
  private CategoryNameValidator nameValidator;

  @BeforeEach
  public void setup() {
    nameValidator = new CategoryNameValidator();
  }

  @Test
  @DisplayName("Null name")
  void validateNullName() {
    nameValidator.validate(null);
    ValidatorTestHelper.assertValidator(
        nameValidator,
        "Name can not be null.",
        false);
  }

  @Test
  @DisplayName("Empty name")
  void validateEmptyName() {
    nameValidator.validate("");
    ValidatorTestHelper.assertValidator(
        nameValidator,
        "Name can not be empty.",
        false);
  }

  @Test
  @DisplayName("Existing name")
  void validateNameExists() {
    nameValidator.validate("Comida");
    ValidatorTestHelper.assertValidator(
        nameValidator,
        "Category name already exists. Input a unique name.",
        false);
  }

  @Test
  @DisplayName("Correct name")
  void validateCorrectName() {
    nameValidator.validate("Entertainment");
    ValidatorTestHelper.assertValidator(
        nameValidator,
        "",
        true);
  }

}