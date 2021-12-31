package com.finanzaspersonales.presenter;

import com.finanzaspersonales.presenter.input.MenuInput;
import com.finanzaspersonales.presenter.ui.MenuItem;
import com.finanzaspersonales.view.View;

/**
 * Acts upon the model and the view.
 * Formats the data for display and handles the user input.
 * Controls one view and determines what it displays.
 * @author denisse
 * @version 1.0
 * @since 1.0
 */
public abstract class Presenter {
  protected final View view;
  protected MenuItem[] menuItems;

  protected Presenter(View view) {
    this.view = view;
  }

  /**
   * Asks for the user input, validates it, and returns an appropriate action.
   * @return Tells the app what to do next.
   */
  public Action present() {
    loadView();
    Action action = Action.NONE;
    while (action == Action.NONE) {
      String menuOption = MenuInput.handleMenu(menuItems, view);
      action = chooseOperation(menuOption);
    }
    return action;
  }

  protected Action chooseOperation(String operation) {
    return Action.RELOAD;
  }

  /**
   * Creates all the ui elements, formats it and displays it in the view.
   * Calls the View.initialize method to print the presenter's main menu.
   */
  protected void loadView() {}
}
