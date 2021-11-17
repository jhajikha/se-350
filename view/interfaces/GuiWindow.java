/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Jeffrey Sharpe
 */
package view.interfaces;

import view.EventName;

import javax.swing.*;

public interface GuiWindow {
    JButton getButton(EventName eventName);
}
