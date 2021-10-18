/*
 * Assignment: 1
 * Topic: JPaint
 * Author: Jeffrey Sharpe
 */
package view.interfaces;

public interface DialogChoice<T> {
    String getDialogTitle();

    String getDialogText();

    T[] getDialogOptions();

    T getCurrentSelection();
}
