module thb.fbi {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires org.fxmisc.richtext;
    requires org.antlr.antlr4.runtime;
    requires org.fxmisc.flowless;
    requires reactfx;

    opens thb.fbi.controller to javafx.fxml;
    exports thb.fbi;
}
