package com.minimart.client.views.cellfactories;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import com.minimart.client.views.pojos.FXModel;

public class FXCellFactory {

	public FXCellFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Callback<TableColumn<FXModel, Object>, TableCell<FXModel, Object>> getEditableCell(){
		return new Callback<TableColumn<FXModel, Object>, TableCell<FXModel, Object>>() {

            public TableCell<FXModel, Object> call(TableColumn<FXModel, Object> p) {
                return new FXEditableCell();
            }
        };
	}

	public static Callback<TableColumn<FXModel, Boolean>, TableCell<FXModel, Boolean>> getButtonCell(final String title, final EventHandler<ActionEvent> actionEvent){
		
		return new Callback<TableColumn<FXModel, Boolean>, TableCell<FXModel, Boolean>>() {

            public TableCell<FXModel, Boolean> call(TableColumn<FXModel, Boolean> p) {
                return new FXButtonCell(title, actionEvent);
            }
        };
	}
}
