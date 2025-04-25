package thb.fbi.leguan.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import thb.fbi.leguan.service.PropertyService;

public class AboutPageController {

    @FXML
    private Label versionText;
    @FXML
    private Label licenseText;
    @FXML
    private ImageView logo;

    @FXML
    public void initialize() {
        // Load License file (also works in packaged jar) 
        InputStream licenseStream = getClass().getResourceAsStream("/LICENSE");
        String licenseString = "MIT License";
        if (licenseStream != null) {
            try {
                licenseString = new String(licenseStream.readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        versionText.setText(PropertyService.getProperty("version"));
        licenseText.setText(licenseString);

        logo.setImage(new Image(this.getClass().getResourceAsStream("/thb/fbi/leguan/images/leguan@3x.png")));
    }

    @FXML
    private void openBugReport() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/GeoInter/Leguan/issues"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException u) {
                u.printStackTrace();
            }
        }
    }
}
