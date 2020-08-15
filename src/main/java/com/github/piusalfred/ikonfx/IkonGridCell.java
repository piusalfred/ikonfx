package com.github.piusalfred.ikonfx;

import javafx.geometry.Pos;
import org.controlsfx.control.GridCell;
import org.kordamp.ikonli.javafx.FontIcon;

public class IkonGridCell extends GridCell<FontIcon> {

    public IkonGridCell() {
        init();
    }

    private void init() {
        getStyleClass().add("ikon-grid-cell");
        setAlignment(Pos.CENTER);
    }


    @Override
    protected void updateItem(FontIcon item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(item);
        }
    }

}
