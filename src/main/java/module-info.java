/* ===============================================================
 *  module-info.java   (Java 17+ explicit modules)
 * =============================================================== */
module edu.banks.csc272 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.banks.csc272 to javafx.fxml;   /* allow FXML reflection */
    exports edu.banks.csc272;
}
