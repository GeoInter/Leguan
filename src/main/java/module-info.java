module thb.fbi.leguan {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires org.fxmisc.richtext;
    requires org.antlr.antlr4.runtime;
    requires org.fxmisc.flowless;
    requires reactfx;
    requires java.desktop;

    opens thb.fbi.leguan.controller to javafx.fxml;
    exports thb.fbi.leguan;
}
