package com.minimart.client.views;

import java.util.List;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import com.minimart.client.Practice.ServiceController;
import com.minimart.client.views.pojos.FXModel;
import com.minimart.model.POSModel;

public class FXTableView extends TableView<FXModel> {

	private Class<? extends FXModel> fxModalClass;
	private Class<? extends POSModel> posModalClass;

	public FXTableView(Class<? extends FXModel> fxModalClass,
			Class<? extends POSModel> posModalClass) {

		super();

		this.fxModalClass = fxModalClass;
		this.posModalClass = posModalClass;

		this.addColumns(fxModalClass);

		this.setEditable(true);
	}

	
	/**
	 * @return the fxModalClass
	 */
	public Class<? extends FXModel> getFxModalClass() {
		return fxModalClass;
	}


	/**
	 * @return the posModalClass
	 */
	public Class<? extends POSModel> getPosModalClass() {
		return posModalClass;
	}


	public void reloadTable(List<? extends POSModel> dataItems) {

		ObservableList<FXModel> views = FXModel.convertToFXModels(
				this.fxModalClass, this.posModalClass, dataItems);
		this.setItems(views);
	}

	public void addColumns(Class<? extends FXModel> fxModelClass) {

		try {
			FXModel model = fxModelClass.newInstance();

			List<TableColumn<FXModel, Object>> columns = model.getColumnsList();
			for (TableColumn<FXModel, Object> column : columns) {
				this.getColumns().add(column);
			}
			addDeleteButton();

		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void addDeleteButton() {
		// Insert Button
		final TableColumn deleteColumn = new TableColumn<>("Action");
		this.getColumns().add(deleteColumn);

		deleteColumn
				.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FXModel, Boolean>, ObservableValue<Boolean>>() {

					@Override
					public ObservableValue<Boolean> call(
							TableColumn.CellDataFeatures<FXModel, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		// Adding the Button to the cell
		deleteColumn.setCellFactory(new Callback<TableColumn<FXModel, Boolean>, TableCell<FXModel, Boolean>>() {

            public TableCell<FXModel, Boolean> call(TableColumn<FXModel, Boolean> p) {
                return new DeleteButtonCell();
            }
        });		

	}
	
	//Define the button cell
	private class DeleteButtonCell extends TableCell<FXModel, Boolean> {
	    
		final Button cellButton = new Button("Delete");
	    
	    DeleteButtonCell(){
	        
	    	//Action when the button is pressed
	        cellButton.setOnAction(new EventHandler<ActionEvent>(){

	            @Override
	            public void handle(ActionEvent t) {
	                // get Selected Item
	            	FXModel record = (FXModel) DeleteButtonCell.this.getTableView().getItems().get(DeleteButtonCell.this.getIndex());
	            	//remove selected item from the table list
	            	getItems().remove(record);
	            	
	            	ServiceController serviceController = new ServiceController();
	            	serviceController.delete(record.toPOSModel());
	            }
	        });
	    }

	    //Display button if the row is not empty
	    @Override
	    protected void updateItem(Boolean t, boolean empty) {
	        super.updateItem(t, empty);
	        if(!empty){
	            setGraphic(cellButton);
	        }
	        else {
	        	setGraphic(null);
	        }
	    }
	}
}


