package com.finanzaspersonales.presenter.operations;

import com.finanzaspersonales.model.Budget;
import com.finanzaspersonales.model.Budgets;
import com.finanzaspersonales.presenter.input.DataInput;
import com.finanzaspersonales.presenter.ui.BudgetFormatter;
import com.finanzaspersonales.presenter.ui.UIFormatter;
import com.finanzaspersonales.view.MainView;

public class CreateBudget extends Operation {

  public CreateBudget(MainView view) {
    super(view, "Setting the budget", "Input the monthly total: ");
  }

  @Override
  protected void operation() {
    double amount = DataInput.inputAmount(view);
    Budget budget = Budgets.set(amount);

    showResult(budget);
  }

  /**
   * Shows the transaction after applying the operation.
   */
  protected void showResult(Budget budget) {
    view.appendWithNewline(
        UIFormatter.successStyle("Budget set."));
    view.appendWithNewline("\n" +
        UIFormatter.highlightStyle("Budget:"));
    view.appendWithoutNewline(BudgetFormatter.budgetDetailed(budget));
  }
}