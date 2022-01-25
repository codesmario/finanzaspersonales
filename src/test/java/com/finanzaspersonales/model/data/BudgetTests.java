package com.finanzaspersonales.model.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

class BudgetTests {
  Budget budget;
  double budgetMonthly;

  @BeforeEach
  void setBudget() {
    budgetMonthly = 10000;
    budget = new Budget(budgetMonthly);
  }

  @Test
  @DisplayName("Set monthly total")
  void testSetMonthlyTotal() {
    double total = 1000;
    budget.setMonthlyTotal(total);
    Assertions.assertEquals(
        total,
        budget.getMonthlyTotal(),
        "The monthly total can't be set.");
  }

  @Test
  @DisplayName("Yearly total")
  void testYearlyTotal() {
    Assertions.assertEquals(
        120000,
        budget.getYearlyTotal(),
        "The yearly total must be equal to 12 times the monthly total.");
  }

  @Test
  @DisplayName("Daily total")
  void testDailyTotal() {
    double dailyAmount = budgetMonthly / DateHelper.currentMonthLength();
    Assertions.assertEquals(
        dailyAmount,
        budget.getDailyTotal(),
        "The daily total must be the monthly amount divided by the current month days.");
  }

  @Test
  @DisplayName("Weekly total")
  void testWeeklyTotal() {
    double weeklyTotal = budgetMonthly / DateHelper.monthWeeks(YearMonth.now());
    Assertions.assertEquals(
        weeklyTotal,
        budget.getWeeklyTotal(),
        "The weekly amount must be the monthly total divided by the numbers of weeks.");
  }

  @Test
  @DisplayName("Budget enabled")
  void testEnabled() {
    Assertions.assertTrue(
        budget.isEnabled(),
        "The budget must be enabled when the amount is greater than zero.");
  }

  @Test
  @DisplayName("Budget disabled")
  void testDisabled() {
    budget.setMonthlyTotal(0);
    Assertions.assertFalse(
        budget.isEnabled(),
        "The budget must be disabled when the amount is less than zero.");
  }
}
