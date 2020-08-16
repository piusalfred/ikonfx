package com.github.piusalfred.ikonfx;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BrowserView extends AnchorPane {

    public final BrowserModel browserModel;
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

        init();


        //iconTypes.add("All Types");
        iconTypes.addAll(new ArrayList<>(IkonSet.allIkonsMap().keySet()));

        cmbChooseIconType.getItems().addAll(iconTypes);
        //select first value
        //  cmbChooseIconType.getCheckModel().check(0);


        cmbChooseIconType.getCheckModel().getCheckedItems()
                .addListener((ListChangeListener<String>) c -> {


                    ObservableList<String> checkedItems = (ObservableList<String>) c.getList();


                    //Update the Browser todo

                    boolean nonSelected = false;

                    if (c.getList().isEmpty()) {
                        nonSelected = true;
                    }

                    boolean finalNonSelected = nonSelected;
                    Platform.runLater(() -> updateGridView(checkedItems, finalNonSelected, txtSearchBox.getText()));

                });

        browserModel.selectedIkonProperty().addListener(
                (ObservableValue<? extends FontIcon>
                         observable, FontIcon oldValue, FontIcon newValue) -> {

                    fontIcon32.setIconLiteral(newValue.getIconLiteral());
                    fontIcon128.setIconLiteral(newValue.getIconLiteral());
                    fontIcon48.setIconLiteral(newValue.getIconLiteral());
                    fontIcon64.setIconLiteral(newValue.getIconLiteral());


                });


        txtSearchBox.textProperty()
                .addListener((observable, oldValue, newValue) ->
                        Platform.runLater(() -> updateGridView(cmbChooseIconType.getCheckModel().getCheckedItems(),
                                false,
                                newValue
                        )));


        browserModel.selectedIkonProperty().set(new FontIcon(Feather.FTH_CAMERA));

        //labels initial display
        lbIconType.setText(browserModel.selectedIkonProperty().get().getIconCode().getClass().getSimpleName());
        lbIconLiteral.setText(browserModel.selectedIkonProperty().get().getIconLiteral());


    }


    //fixme
    private void updateGridView(ObservableList<String> selectedIkons, boolean noneSelected, String searchValue) {

        List<FontIcon> allIkons = IkonSet.AllIkons();
        if (noneSelected) {

            if (searchValue == null || searchValue.isEmpty() || searchValue.isBlank()) {
                //Display All
                browserModel.getSelectedFontIcons().setAll(allIkons);
            }
            //filter a whole IkonSet and Just Come up with the search results


            Predicate<FontIcon> matchIkonLiteral = fontIcon -> {
                assert searchValue != null;
                return fontIcon.getIconLiteral().contains(searchValue);
            };

            Predicate<FontIcon> matchIkonCode = fontIcon ->
            {
                assert searchValue != null;
                return fontIcon.getIconCode().getDescription().contains(searchValue);
            };

            List<FontIcon> filteredList = allIkons.
                    stream()
                    .filter(matchIkonLiteral.or(matchIkonCode))
                    .collect(Collectors.toList());

            //Display Filtered List
            browserModel.getSelectedFontIcons().setAll(filteredList);


        } else {


            List<List<FontIcon>> listList = IkonSet.allIkonsMap().entrySet()
                    .stream()
                    .filter(map -> selectedIkons.contains(map.getKey()))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());

            List<FontIcon> selectedList = listList.stream().flatMap(List::stream).collect(Collectors.toList());

            Predicate<FontIcon> matchIkonLiteral = fontIcon -> {
                assert searchValue != null;
                return fontIcon.getIconLiteral().contains(searchValue);
            };

            Predicate<FontIcon> matchIkonCode = fontIcon ->
            {
                assert searchValue != null;
                return fontIcon.getIconCode().getDescription().contains(searchValue);
            };

            List<FontIcon> filteredList = selectedList.
                    stream()
                    .filter(matchIkonLiteral.or(matchIkonCode))
                    .collect(Collectors.toList());

            browserModel.getSelectedFontIcons().setAll(filteredList);

        }

    }


    public void init() {

        ikonsGridView = new GridView<>();
        ikonsGridView.setHorizontalCellSpacing(16.0);
        ikonsGridView.setVerticalCellSpacing(16.0);
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

        browserModel.getSelectedFontIcons().setAll(IkonSet.AllIkons());

        ikonsGridView.itemsProperty().bind(new ObservableValue<>() {
            @Override
            public void addListener(ChangeListener<? super ObservableList<FontIcon>> listener) {

            }

            @Override
            public void removeListener(ChangeListener<? super ObservableList<FontIcon>> listener) {

            }

            @Override
            public ObservableList<FontIcon> getValue() {
                return browserModel.getSelectedFontIcons();
            }

            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }
        });


    }
}
