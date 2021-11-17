/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Jeffrey Sharpe
 */
package view.interfaces;

import view.EventName;

public interface UiModule {
    void addEvent(EventName eventName, EventCallback command);
    <T> T getDialogResponse(DialogChoice dialogChoice);
}
