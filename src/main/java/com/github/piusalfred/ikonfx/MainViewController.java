package com.github.piusalfred.ikonfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.CheckComboBox;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    final ObservableList<String> iconTypes = FXCollections.observableArrayList();
    @FXML
    public GridPane gridPane;
    @FXML
    public AnchorPane mainView;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public CheckComboBox<String> cmbChooseIconType;
    @FXML
    public TextField txtSearchBox;
    @FXML
    public FontIcon fontIcon128;
    @FXML
    public Label lbIconLiteral;
    @FXML
    public Label lbIconType;
    @FXML
    public FontIcon fontIcon64;
    @FXML
    public FontIcon fontIcon48;
    @FXML
    public FontIcon fontIcon32;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        iconTypes.add("All Icons");

        IkonSet.allIkonsMap().forEach((s, fontIcons) -> System.out.println(iconTypes.add(s)));

        cmbChooseIconType.getItems().addAll(iconTypes);

        List<FontIcon> fontIconList = IkonSet.AllIkons();
        int column = 0;
        int row = 0;
        int index = 0;

        for (FontIcon icon : fontIconList) {

            gridPane.add(icon, column++, row);

            icon.setOnMouseEntered(event -> System.out.println("Mouse Entered"));
            icon.setOnMouseClicked(event -> System.out.println("Mouse Clicked"));
            icon.setOnMousePressed(event -> System.out.println("Mouse Pressed"));

            GridPane.setMargin(icon, new Insets(8, 8, 8, 8));
            if (++index % 10 == 0) {
                column = 0;
                row++;
            }
        }


    }
}
