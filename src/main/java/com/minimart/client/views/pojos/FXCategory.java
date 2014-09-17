package com.minimart.client.views.pojos;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import com.minimart.client.Practice.ServiceController;
import com.minimart.client.views.cellfactories.FXCellFactory;
import com.minimart.dto.CategoryDTO;
import com.minimart.model.Brand;
import com.minimart.model.Category;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;

public class FXCategory extends FXModel {

	public FXCategory(CategoryDTO categoryDTO) {
		this();

		this.setId(categoryDTO.getId());
		this.setName(categoryDTO.getName());
		this.setParentCategoryId(categoryDTO.getParentCategoryId());
		this.setParentCategoryName(categoryDTO.getParentCategoryName());
	}

	public FXCategory() {
		super();
		this.idProperty = new SimpleIntegerProperty();
		this.nameProperty = new SimpleStringProperty();
		this.parentCategoryIdProperty = new SimpleIntegerProperty();
		this.parentCategoryNameProperty = new SimpleStringProperty();
	}

	private SimpleIntegerProperty idProperty;

	private SimpleStringProperty nameProperty;
	
	private SimpleIntegerProperty parentCategoryIdProperty;
	
	private SimpleStringProperty parentCategoryNameProperty;

	public Integer getId() {
		return this.idProperty.get();
	}

	public String getName() {
		return this.nameProperty.get();
	}

	public Integer getParentCategoryId() {
		return this.parentCategoryIdProperty.get();
	}

	public String getParentCategoryName() {
		return this.parentCategoryNameProperty.get();
	}
	
	public void setId(Integer id) {
		this.idProperty.set(id);
	}

	public void setName(String name) {
		this.nameProperty.set(name);
	}
	
	
	public void setParentCategoryId(Integer id) {
		this.parentCategoryIdProperty.set(id);
	}

	public void setParentCategoryName(String name) {
		this.parentCategoryNameProperty.set(name);
	}

	

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FXCategory [idProperty=" + idProperty + ", nameProperty="
				+ nameProperty + ", parentCategoryIdProperty="
				+ parentCategoryIdProperty + ", parentCategoryNameProperty="
				+ parentCategoryNameProperty + "]";
	}

	public List<TableColumn<FXModel, Object>> getColumnsList() {
		
		List<TableColumn<FXModel, Object>> columns = new ArrayList<TableColumn<FXModel, Object>>();

//		TableColumn<FXModel, Object> idColumn = new TableColumn<FXModel, Object>("ID");
//		idColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("id"));
//		idColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(idColumn);

		final TableColumn<FXModel, Object> nameColumn = new TableColumn<FXModel, Object>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("name"));
		nameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(nameColumn);

//		TableColumn<FXModel, Object> parentCategoryIdColumn = new TableColumn<FXModel, Object>("ParentCategoryId");
//		parentCategoryIdColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("parentCategoryId"));
//		parentCategoryIdColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(parentCategoryIdColumn);
		
		TableColumn<FXModel, Object> parentCategoryNameColumn = new TableColumn<FXModel, Object>("Parent Category");
		parentCategoryNameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("parentCategoryName"));
		parentCategoryNameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(parentCategoryNameColumn);
		
		EventHandler<TableColumn.CellEditEvent<FXModel,Object>> eventHandler = new EventHandler<TableColumn.CellEditEvent<FXModel,Object>>(){
		      @Override
		      public void handle(CellEditEvent<FXModel, Object> event) {
		    	  
		    	  FXCategory category = (FXCategory) event.getRowValue();
		    	  if (event.getTableColumn().equals(nameColumn)){
		    		  category.setName((String)event.getNewValue());
		    	  };
		    	  
		    	  ServiceController serviceController = new ServiceController();
		    	  serviceController.updateCategory((Category) category.toPOSModel());
		      }
		};
		nameColumn.setOnEditCommit(eventHandler); 

		return columns;
	}

	@Override
	public POSModel toPOSModel() {
		Category category = new Category(this.getId(), this.getParentCategoryId(), this.getName());
		return category;
	}
}
