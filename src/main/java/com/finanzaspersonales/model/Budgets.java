package com.finanzaspersonales.model;

import org.jetbrains.annotations.NotNull;

import javax.xml.crypto.Data;

public class Budgets {

  private Budgets() { }

  @NotNull
  public static Budget set(double monthlyAmount) {
    Budget budget;
    if (isBudgetSet()) {
      budget = get();
      budget.setMonthlyTotal(monthlyAmount);
    } else {
      budget = new Budget(monthlyAmount);
      Database.db().saveBudget(budget);
    }
    return budget;
  }

  public static Budget get() {
    return Database.db().getBudget();
  }

  public static boolean isBudgetSet() {
    return Database.db().getBudget().getMonthlyTotal() > 0;
  }

  public static void remove() {
    Database.db().saveBudget(new Budget(0));
  }
}