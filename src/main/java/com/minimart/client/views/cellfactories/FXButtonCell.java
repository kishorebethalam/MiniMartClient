package com.minimart.client.views.cellfactories;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import com.minimart.client.views.pojos.FXModel;

public class FXButtonCell extends TableCell<FXModel, Boolean> {

	final Button cellButton ;
	
	public FXButtonCell(String title, EventHandler<ActionEvent> actionEvent) {
		cellButton = new Button(title);
		cellButton.setOnAction(actionEvent);
	}

	//Display button if the row is not empty
	@Override
	protected void updateItem(Boolean t, boolean empty) {
		super.updateItem(t, empty);
		if(!empty){
			setGraphic(cellButton);
		}
		else{
			setGraphic(null);
		}
	}
}
