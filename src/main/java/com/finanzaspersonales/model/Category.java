package com.finanzaspersonales.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Represents a transaction category.
 * It must have a unique name and a transaction type.
 * @author joseph
 * @version 1.0
 * @since 1.0
 */
@Getter
@ToString
@NoArgsConstructor
public class Category {
  @Setter
  @NotNull
  private TransactionType transactionType;
  private final String uniqueID = UUID.randomUUID().toString();
  private String name;

  /**
   * Sets the name of the category, validating that it is not empty.
   * @param name Must be unique.
   */
  public void setName(@NotNull String name) throws IllegalArgumentException {
    if(!name.isEmpty()) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Name cannot be empty");
    }
  }
}