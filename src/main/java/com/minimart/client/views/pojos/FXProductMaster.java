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
import com.minimart.dto.ProductMasterDTO;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;
import com.minimart.model.ProductMaster;

public class FXProductMaster extends FXModel {

	public FXProductMaster(ProductMasterDTO productMaster) {
		this();

		this.setId(productMaster.getId());
		this.setName(productMaster.getName());
		this.setBrandId(productMaster.getBrandId());
		this.setBrandName(productMaster.getBrandName());
		this.setCategoryId(productMaster.getCategoryId());
		this.setCategoryName(productMaster.getCategoryName());
	}

	public FXProductMaster() {
		super();
		this.idProperty = new SimpleIntegerProperty();
		this.brandIdProperty = new SimpleIntegerProperty();
		this.categoryIdProperty = new SimpleIntegerProperty();
		this.nameProperty = new SimpleStringProperty();
		this.brandNameProperty = new SimpleStringProperty();
		this.categoryNameProperty = new SimpleStringProperty();
	}

	private SimpleIntegerProperty idProperty;
	private SimpleStringProperty nameProperty;
	private SimpleIntegerProperty brandIdProperty;
	private SimpleIntegerProperty categoryIdProperty;
	private SimpleStringProperty brandNameProperty;
	private SimpleStringProperty categoryNameProperty;

	public Integer getId() {
		return this.idProperty.get();
	}

	public String getName() {
		return this.nameProperty.get();
	}
	public Integer getBrandId() {
		return this.brandIdProperty.get();
	}
	public Integer getCategoryId() {
		return this.categoryIdProperty.get();
	}
	public String getBrandName() {
		return this.brandNameProperty.get();
	}
	public String getCategoryName() {
		return this.categoryNameProperty.get();
	}

	public void setId(Integer id) {
		this.idProperty.set(id);
	}
	public void setBrandId(Integer brandId) {
		this.brandIdProperty.set(brandId);
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryIdProperty.set(categoryId);
	}
	public void setName(String name) {
		this.nameProperty.set(name);
	}
	public void setBrandName(String brandName) {
		this.brandNameProperty.set(brandName);
	}
	public void setCategoryName(String categoryName) {
		this.categoryNameProperty.set(categoryName);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FXProductMaster [idProperty=" + idProperty + ", nameProperty="
				+ nameProperty + ", brandIdProperty=" + brandIdProperty
				+ ", categoryIdProperty=" + categoryIdProperty
				+ ", brandNameProperty=" + brandNameProperty
				+ ", categoryNameProperty=" + categoryNameProperty + "]";
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

//		TableColumn<FXModel, Object> brandIdColumn = new TableColumn<FXModel, Object>("brandId");
//		brandIdColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("brandId"));
//		brandIdColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(brandIdColumn);
//
//		TableColumn<FXModel, Object> categoryIdColumn = new TableColumn<FXModel, Object>("CategoryId");
//		categoryIdColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("categoryId"));
//		categoryIdColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(categoryIdColumn);
		
		TableColumn<FXModel, Object> brandNameColumn = new TableColumn<FXModel, Object>("Brand");
		brandNameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("brandName"));
		brandNameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(brandNameColumn);

		TableColumn<FXModel, Object> categoryNameColumn = new TableColumn<FXModel, Object>("Category");
		categoryNameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("categoryName"));
		categoryNameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(categoryNameColumn);

		EventHandler<TableColumn.CellEditEvent<FXModel,Object>> eventHandler = new EventHandler<TableColumn.CellEditEvent<FXModel,Object>>(){
		      @Override
		      public void handle(CellEditEvent<FXModel, Object> event) {
		    	  
		    	  FXProductMaster productMaster = (FXProductMaster) event.getRowValue();
		    	  if (event.getTableColumn().equals(nameColumn)){
		    		  productMaster.setName((String)event.getNewValue());
		    	  };
		    	  
		    	  ServiceController serviceController = new ServiceController();
		    	  serviceController.updateProductMaster((ProductMaster) productMaster.toPOSModel());
		      }
		};

		nameColumn.setOnEditCommit(eventHandler); 
		return columns;
	}

	@Override
	public POSModel toPOSModel() {
		ProductMaster productMaster = new ProductMaster(this.getId(), this.getBrandId(), this.getCategoryId(), this.getName());
		return productMaster;
	}
}
