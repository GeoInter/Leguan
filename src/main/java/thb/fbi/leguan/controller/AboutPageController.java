package thb.fbi.leguan.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import thb.fbi.leguan.service.PropertyService;

public class AboutPageController {

    @FXML private Label versionText;
    @FXML private Label licenseText;

    @FXML
    public void initialize() {
        String license = "";
        try {
            license = Files.readString(Path.of("LICENSE"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        versionText.setText(PropertyService.getProperty("version"));
        licenseText.setText(license);
    }
}
