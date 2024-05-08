module com.mycompany.caca {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.caca to javafx.fxml;
    exports com.mycompany.caca;
}
