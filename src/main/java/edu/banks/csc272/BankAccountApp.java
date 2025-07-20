/* ===============================================================
 *  BankAccountApp.java
 *  ---------------------------------------------------------------
 *  JavaFX entry‑point for the Module‑2 GUI (Lecture 4 reference)
 * =============================================================== */
package edu.banks.csc272;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Launches the Bank‑Account compound‑interest calculator. */
public class BankAccountApp extends Application {

    @Override                       /* JavaFX lifecycle hook — L4 */
    public void start(Stage stage) throws Exception {

        /* Load scene‑graph from FXML (MVC decoupling — L3) */
        Scene scene = new Scene(
                FXMLLoader.load(
                        getClass().getResource("/bank-account.fxml")
                )
        );

        stage.setTitle("Bank‑Account Calculator");
        stage.setScene(scene);
        stage.show();               /* paints the window — L4 */
    }

    /* Traditional Java entry‑point -> boots the JavaFX runtime. */
    public static void main(String[] args) { launch(args); }
}
