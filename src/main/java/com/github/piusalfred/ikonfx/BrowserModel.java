package com.github.piusalfred.ikonfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.kordamp.ikonli.javafx.FontIcon;

public class BrowserModel {

    public static final double DEFAULT_WITH = 1000;
    public static final double DEFAULT_HEIGHT = 650;
    public static final String APP_STYLES = "/styles/main.css";
    public static final String APP_NAME = "IkonFX";
    public static final String APP_VERSION ="1.0.0" ;
    public static final String MAIN_VIEW_FXML = "/fxml/main.fxml";
    public static final int DEFAULT_IKON_SIZE = 24;


    private ObservableList<FontIcon> selectedFontIcons;
    private ObjectProperty<FontIcon> selectedIkonProperty;
    private ObjectProperty<Number> ikonSizeProperty;


    public BrowserModel() {


    }

    public ObservableList<FontIcon> getSelectedFontIcons() {
        if (selectedFontIcons == null) {
            selectedFontIcons = FXCollections.observableArrayList();
        }
        return selectedFontIcons;
    }



    public ObjectProperty<FontIcon> selectedIkonProperty() {
        if (selectedIkonProperty == null) {
            selectedIkonProperty = new SimpleObjectProperty<>();
        }
        return selectedIkonProperty;
    }


    public ObjectProperty<Number> ikonSizeProperty() {
        if (ikonSizeProperty == null) {
            ikonSizeProperty = new SimpleObjectProperty<>(DEFAULT_IKON_SIZE);
        }
        return ikonSizeProperty;
    }
}
