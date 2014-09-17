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
import com.minimart.dto.BrandDTO;
import com.minimart.model.Brand;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;

public class FXBrand extends FXModel {

	public FXBrand(BrandDTO brandDTO) {
		this();

		this.setId(brandDTO.getId());
		this.setName(brandDTO.getName());
		this.setManufacturerName(brandDTO.getManufacturerName());
		this.setManufacturerId(brandDTO.getManufacturerId());
	}

	public FXBrand() {
		super();
		this.idProperty = new SimpleIntegerProperty();
		this.nameProperty = new SimpleStringProperty();
		this.manufacturerNameProperty = new SimpleStringProperty();
		this.manufacturerIdProperty = new SimpleIntegerProperty();
	}

	private SimpleIntegerProperty idProperty;
	
	private SimpleStringProperty nameProperty;

	private SimpleIntegerProperty manufacturerIdProperty;

	private SimpleStringProperty manufacturerNameProperty;

	public Integer getId() {
		return this.idProperty.get();
	}

	public String getName() {
		return this.nameProperty.get();
	}
	public Integer getManufacturerId() {
		return this.manufacturerIdProperty.get();
	}
	public void setId(Integer id) {
		this.idProperty.set(id);
	}

	public void setName(String name) {
		this.nameProperty.set(name);
	}
	public void setManufacturerId(Integer id) {
		this.manufacturerIdProperty.set(id);
	}
	
	public String getManufacturerName() {
		return this.manufacturerNameProperty.get();
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerNameProperty.set(manufacturerName);
	}

	

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FXBrand [idProperty=" + idProperty + ", nameProperty="
				+ nameProperty + ", manufacturerIdProperty="
				+ manufacturerIdProperty + ", manufacturerNameProperty="
				+ manufacturerNameProperty + "]";
	}

	public List<TableColumn<FXModel, Object>> getColumnsList() {
		
		List<TableColumn<FXModel, Object>> columns = new ArrayList<TableColumn<FXModel, Object>>();

		final TableColumn<FXModel, Object> nameColumn = new TableColumn<FXModel, Object>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("name"));
		nameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(nameColumn);
		
		TableColumn<FXModel, Object> manufacturerNameColumn = new TableColumn<FXModel, Object>("Manufacturer");
		manufacturerNameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("manufacturerName"));
		manufacturerNameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(manufacturerNameColumn);

		EventHandler<TableColumn.CellEditEvent<FXModel,Object>> eventHandler = new EventHandler<TableColumn.CellEditEvent<FXModel,Object>>(){
		      @Override
		      public void handle(CellEditEvent<FXModel, Object> event) {
		    	  
		    	  FXBrand brand = (FXBrand) event.getRowValue();
		    	  if (event.getTableColumn().equals(nameColumn)){
		    		  brand.setName((String)event.getNewValue());
		    	  };
		    	  
		    	  ServiceController serviceController = new ServiceController();
		    	  serviceController.updateBrand((Brand) brand.toPOSModel());
		      }
		};
		nameColumn.setOnEditCommit(eventHandler); 

		return columns;
	}

	@Override
	public POSModel toPOSModel() {
		Brand brand = new Brand(this.getId(), this.getManufacturerId(), this.getName());
		System.out.println(brand.toString());
		return brand;
	}
}
