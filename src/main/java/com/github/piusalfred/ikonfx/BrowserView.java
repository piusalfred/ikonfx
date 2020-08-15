package com.github.piusalfred.ikonfx;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.GridView;
import org.kordamp.ikonli.feather.Feather;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.util.ArrayList;

public class BrowserView extends AnchorPane {

    final ObservableList<String> iconTypes = FXCollections.observableArrayList();

    public GridView<FontIcon> ikonsGridView;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private CheckComboBox<String> cmbChooseIconType;

    @FXML
    private TextField txtSearchBox;

    @FXML
    private FontIcon fontIcon128;

    @FXML
    private Label lbIconLiteral;

    @FXML
    private Label lbIconType;

    @FXML
    private FontIcon fontIcon64;

    @FXML
    private FontIcon fontIcon48;

    @FXML
    private FontIcon fontIcon32;

    public final BrowserModel browserModel;

    public BrowserView(BrowserModel browserModel) {

        this.browserModel = browserModel;



        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(BrowserModel.MAIN_VIEW_FXML));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.getStylesheets().add(getClass().getResource(BrowserModel.APP_STYLES).toExternalForm());


        iconTypes.add("All Types");
        iconTypes.addAll(new ArrayList<>(IkonSet.allIkonsMap().keySet()));

        cmbChooseIconType.getItems().addAll(iconTypes);
        //select first value
        cmbChooseIconType.getCheckModel().check(0);


        cmbChooseIconType.getCheckModel().getCheckedItems()
                .addListener((ListChangeListener<String>) c -> {

                    //Reset the search box
                    txtSearchBox.setText("");

                    //Update the Browser todo


                });

        browserModel.selectedIkonProperty().addListener(
                (ObservableValue<? extends FontIcon>
                         observable, FontIcon oldValue, FontIcon newValue) -> {

                    fontIcon32.setIconLiteral(newValue.getIconLiteral());
                    fontIcon128.setIconLiteral(newValue.getIconLiteral());
                    fontIcon48.setIconLiteral(newValue.getIconLiteral());
                    fontIcon64.setIconLiteral(newValue.getIconLiteral());


                });

        browserModel.selectedIkonProperty().set(new FontIcon(Feather.FTH_CAMERA));

        //labels initial display
        lbIconType.setText(browserModel.selectedIkonProperty().get().getIconCode().getClass().getSimpleName());
        lbIconLiteral.setText(browserModel.selectedIkonProperty().get().getIconLiteral());

       // init
        init();
    }



    public void init(){

        GridView<FontIcon> ikonsGridView = new GridView<>();
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.setContent(ikonsGridView);
        ikonsGridView.setCellFactory((GridView<FontIcon> gridView) -> new IkonGridCell());
        ikonsGridView.cellHeightProperty().bind(browserModel.ikonSizeProperty());
        ikonsGridView.cellWidthProperty().bind(browserModel.ikonSizeProperty());

        ikonsGridView.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            if (event.getTarget() instanceof FontIcon) {

                FontIcon target = (FontIcon) event.getTarget();
                browserModel.selectedIkonProperty().set(target);
                lbIconType.setText(target.getIconCode().getClass().getSimpleName());
                lbIconLiteral.setText(target.getIconLiteral());
            }
        });



        //todo> Display all icons

        browserModel.getelectedFontIcons().setAll(IkonSet.AllIkons());

      /*  browserModel.getelectedFontIcons()
                .forEach(fontIcon -> fontIcon.setOnMousePressed(event -> {
                    browserModel.selectedIkonProperty().set((FontIcon)event.getTarget());
        }));*/

        ikonsGridView.setItems(FXCollections.observableArrayList(browserModel.getelectedFontIcons()));





    }
}
