package thb.fbi.leguan.service;

import javafx.scene.Scene;

public class ThemeService {
    
    private static String activeCSS = "light.css"; // default theme
    private static String cssFilePath = "/thb/fbi/leguan/css/";

    /**
     * load all css file into a specified scene
     * @param scene to load css files into
     */
    public static void applyCSS(Scene scene) {
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "base.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "buttons.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "editor.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "images.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "memoryPane.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "registerPane.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "scrolling.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "syntax.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "tab.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "table.css").toExternalForm());
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "visualizer.css").toExternalForm());

        // apply current theme css
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "themes/" + activeCSS).toExternalForm());
    }

    /**
     * Switch CSS Theme for a scene
     * @param scene to apply a theme to
     * @param theme a css file to use (e.g.: "light.css")
     */
    public static void switchTheme(Scene scene, String theme) {
        // remove previous loaded theme
        scene.getStylesheets().remove(ThemeService.class.getResource(cssFilePath + "themes/" + activeCSS).toExternalForm());
        
        activeCSS = theme;
        scene.getStylesheets().add(ThemeService.class.getResource(cssFilePath + "themes/" + activeCSS).toExternalForm());
    }
}
