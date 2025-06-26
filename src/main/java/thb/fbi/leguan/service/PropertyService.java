package thb.fbi.leguan.service;

import java.io.InputStream;
import java.util.Properties;

public class PropertyService {

    public static String getProperty(String key) {
        try (InputStream input = PropertyService.class.getResourceAsStream("/thb/fbi/.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
