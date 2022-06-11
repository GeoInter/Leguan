module thb.fbi {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires org.fxmisc.richtext;

    opens thb.fbi.controller to javafx.fxml;
    exports thb.fbi;
}
