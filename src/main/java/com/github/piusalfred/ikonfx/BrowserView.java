package com.github.piusalfred.ikonfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.GridView;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.feather.Feather;

import java.io.IOException;
import java.util.function.Consumer;

public class BrowserView extends AnchorPane {

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

        browserModel.selectedIkonProperty().set(new FontIcon(Feather.FTH_CAMERA));



        fontIcon32.iconCodeProperty().bind(browserModel.selectedIkonProperty().get().iconCodeProperty());
        fontIcon128.iconCodeProperty().bind(browserModel.selectedIkonProperty().get().iconCodeProperty());
        fontIcon48.iconCodeProperty().bind(browserModel.selectedIkonProperty().get().iconCodeProperty());
        fontIcon64.iconCodeProperty().bind(browserModel.selectedIkonProperty().get().iconCodeProperty());

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

                Platform.runLater(() -> browserModel.selectedIkonProperty().set(new FontIcon(Feather.FTH_CODEPEN)));



            }
        });



        //todo> Display all icons

        browserModel.getelectedFontIcons().setAll(IkonSet.AllIkons());

        browserModel.getelectedFontIcons().forEach(new Consumer<FontIcon>() {
            @Override
            public void accept(FontIcon fontIcon) {
              //  fontIcon.addE
            }
        });

        ikonsGridView.setItems(FXCollections.observableArrayList(browserModel.getelectedFontIcons()));





    }
}
