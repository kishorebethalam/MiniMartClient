package com.minimart.client.views;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

import com.minimart.client.JavaFXDemo.EditingCell;
import com.minimart.client.JavaFXDemo.Person;
import com.minimart.client.views.pojos.FXModel;
import com.minimart.model.POSModel;

public class MMTableView extends TableView<FXModel>{
	
	private Class<? extends FXModel> fxModalClass;
	private Class<? extends POSModel> posModalClass;
	public MMTableView(Class<? extends FXModel> fxModalClass, Class<? extends POSModel> posModalClass) {
		
		super();
		
		this.fxModalClass = fxModalClass;
		this.posModalClass = posModalClass;
		
		List<String> fields = FXModel.getFieldNames(fxModalClass);
		for (String field : fields) { 
			
			TableColumn<FXModel, Object> column = new TableColumn<FXModel, Object>(field.toUpperCase());
			column.setCellValueFactory(new PropertyValueFactory<FXModel,Object>(field));

			//Set cell factory for cells that allow editing
	        Callback<TableColumn<FXModel, Object>, TableCell<FXModel, Object>> cellFactory =
	                new Callback<TableColumn<FXModel, Object>, TableCell<FXModel, Object>>() {

	                    public TableCell<FXModel, Object> call(TableColumn<FXModel, Object> p) {
	                        return new EditingCell();
	                    }
	                };
	        column.setCellFactory(cellFactory); 
			this.getColumns().add(column);
		}
		
		this.setEditable(true);
	}
	
	
	public void reloadTable(List<? extends POSModel> dataItems){

		ObservableList<FXModel>  views= FXModel.convertToFXModels(this.fxModalClass, this.posModalClass, dataItems);
		this.setItems(views);
	}

	// EditingCell - for editing capability in a TableCell
    public static class EditingCell extends TableCell<FXModel, Object> {
        private TextField textField;

        public EditingCell() {
        }
       
        @Override public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
       
        @Override public void cancelEdit() {
            super.cancelEdit();
            setText((String) getItem());
            setGraphic(null);
        }
       
        @Override public void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {                
                @Override public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    } 
}
