/* ===============================================================
 *  BankAccountController.java
 *  ---------------------------------------------------------------
 *  Handles UI events for bank‑account.fxml  (Lectures 2–4)
 * =============================================================== */
package edu.banks.csc272;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;

/** Calculates balance = P·(1+r)<sup>n</sup> when the user presses the button. */
public class BankAccountController {

    /* ---------- FXML‑injected widgets (Lecture 3) ---------- */
    @FXML private TextField depositField;  /* principal P          */
    @FXML private TextField rateField;     /* rate r % per yr      */
    @FXML private TextField yearsField;    /* years n              */
    @FXML private Label     resultLabel;   /* output banner        */

    /* ---------- Format helpers (Lecture 2 utility classes) ---------- */
    private static final NumberFormat MONEY   = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT = NumberFormat.getPercentInstance();
    static { PERCENT.setMinimumFractionDigits(0); }

    /* onAction handler wired in FXML (#handleCalculate) */
    @FXML
    private void handleCalculate() {

        try {                                /* L1 defensive parse */
            double principal = Double.parseDouble(depositField.getText().trim());
            double ratePct   = Double.parseDouble(rateField.getText().trim());
            int    years     = Integer.parseInt(yearsField.getText().trim());

            if (principal < 0 || ratePct < 0 || years < 0)
                throw new NumberFormatException("negative");

            /* compound‑interest math — P·(1+r)^n                (Lecture 2) */
            double r = ratePct / 100.0;
            double bal = principal * Math.pow(1 + r, years);

            /* show nicely‑formatted result (Lecture 4 UI update) */
            resultLabel.setText(String.format(
                    "Balance after %d yr @ %s : %s",
                    years,
                    PERCENT.format(r),
                    MONEY.format(bal)));

        } catch (NumberFormatException ex) { /* invalid input path */
            resultLabel.setText("❌  Enter non‑negative numeric values.");
        }
    }
}
