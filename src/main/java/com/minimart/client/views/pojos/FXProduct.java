package com.minimart.client.views.pojos;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import com.minimart.client.Practice.ServiceController;
import com.minimart.client.views.cellfactories.FXCellFactory;
import com.minimart.dto.ManufacturerDTO;
import com.minimart.dto.ProductDTO;
import com.minimart.model.Category;
import com.minimart.model.POSModel;
import com.minimart.model.Product;

public class FXProduct extends FXModel {

	public FXProduct(ProductDTO product) {
		this();

		this.setId(product.getId());
		this.setProductMasterId(product.getProductMasterId());
		this.setMeasurementCategory(product.getMeasurementCategory());
		this.setMeasurementQuantity(product.getMeasurementQuantity());
		this.setReorderFrequency(product.getReorderFrequency());
		this.setReorderVolume(product.getReorderVolume());
		this.setMrp(product.getMrp());
		this.setBuyPrice(product.getBuyPrice());
		this.setSellPrice(product.getSellPrice());
		this.setProductMasterName(product.getProductMasterName());
	}

	public FXProduct() {
		super();
		this.idProperty = new SimpleIntegerProperty();
		this.productMasterIdProperty= new SimpleIntegerProperty() ;
		this.measurementCategoryProperty = new SimpleStringProperty();
		this.measurementQuantityProperty = new SimpleIntegerProperty();
		this.mrpProperty = new SimpleFloatProperty();
		this.buyPriceProperty = new SimpleFloatProperty();
		this.sellPriceProperty = new SimpleFloatProperty();
		this.reorderVolumeProperty = new SimpleIntegerProperty();
		this.reorderFrequencyProperty = new SimpleStringProperty();
		this.productMasterNameProperty = new SimpleStringProperty();
	}

	private SimpleIntegerProperty idProperty;

	private SimpleIntegerProperty productMasterIdProperty;

	private SimpleStringProperty measurementCategoryProperty;
	
	private SimpleIntegerProperty measurementQuantityProperty;
	
	private SimpleFloatProperty mrpProperty;
	
	private SimpleFloatProperty buyPriceProperty;
	
	private SimpleFloatProperty sellPriceProperty;
	
	private SimpleIntegerProperty reorderVolumeProperty;
	
	private SimpleStringProperty reorderFrequencyProperty;
	
	private SimpleStringProperty productMasterNameProperty;
	
	

	public Integer getId() {
		return this.idProperty.get();
	}
	public Integer getProductMasterId() {
		return this.productMasterIdProperty.get();
	}
	public String getMeasurementCategory() {
		return this.measurementCategoryProperty.get();
	}
	public Integer getMeasurementQuantity() {
		return this.measurementQuantityProperty.get();
	}
	public Float getMrp(){
		return this.mrpProperty.get();
	}
	public Float getBuyPrice(){
		return this.buyPriceProperty.get();
	}
	public Float getSellPrice(){
		return this.sellPriceProperty.get();
	}
	public Integer getReorderVolume(){
		return this.reorderVolumeProperty.get();
	}
	public String getReorderFrequency(){
		return this.reorderFrequencyProperty.get();
	}
	public String getProductMasterName(){
		return this.productMasterNameProperty.get();
	}
	
	public void setId(Integer id) {
		this.idProperty.set(id);
	}

	public void setProductMasterId(Integer productMasterid) {
		this.productMasterIdProperty.set(productMasterid);
	}
	public void setMeasurementCategory(String measurementCategory) {
		this.measurementCategoryProperty.set(measurementCategory);
	}
	public void setMeasurementQuantity(int measurementQuantity) {
		this.measurementQuantityProperty.set(measurementQuantity);
	}
	public void setMrp(Float mrp){
		this.mrpProperty.set(mrp);
	}
	public void setBuyPrice(Float buyPrice){
		this.buyPriceProperty.set(buyPrice);
	}
	public void  setSellPrice(Float sellPrice){
		this.sellPriceProperty.set(sellPrice);
	}
	public void setReorderVolume(Integer reorderVolume){
		this.reorderVolumeProperty.set(reorderVolume);
	}
	public void setReorderFrequency(String reorderFrequency){
		this.reorderFrequencyProperty.set(reorderFrequency);
	}
	public void setProductMasterName(String productMasterName){
		this.productMasterNameProperty.set(productMasterName);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FXProduct [idProperty=" + idProperty
				+ ", productMasterIdProperty=" + productMasterIdProperty
				+ ", measurementCategoryProperty="
				+ measurementCategoryProperty
				+ ", measurementQuantityProperty="
				+ measurementQuantityProperty + ", mrpProperty=" + mrpProperty
				+ ", buyPriceProperty=" + buyPriceProperty
				+ ", sellPriceProperty=" + sellPriceProperty
				+ ", reorderVolumeProperty=" + reorderVolumeProperty
				+ ", reorderFrequencyProperty=" + reorderFrequencyProperty
				+ ", productMasterNameProperty=" + productMasterNameProperty
				+ "]";
	}

	public List<TableColumn<FXModel, Object>> getColumnsList() {

		List<TableColumn<FXModel, Object>> columns = new ArrayList<TableColumn<FXModel, Object>>();

//		TableColumn<FXModel, Object> idColumn = new TableColumn<FXModel, Object>("ID");
//		idColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("id"));
//		idColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(idColumn);

//		TableColumn<FXModel, Object> productMasterIdColumn = new TableColumn<FXModel, Object>("productMasterId");
//		productMasterIdColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("productMasterId"));
//		productMasterIdColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(productMasterIdColumn);

		TableColumn<FXModel, Object> productMasterNameColumn = new TableColumn<FXModel, Object>("Product");
		productMasterNameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("productMasterName"));
		productMasterNameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(productMasterNameColumn);

		final TableColumn<FXModel, Object> measurementCategoryColumn = new TableColumn<FXModel, Object>("Measurement Category");
		measurementCategoryColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("measurementCategory"));
		measurementCategoryColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(measurementCategoryColumn);
		
		final TableColumn<FXModel, Object> measurementQuantityColumn = new TableColumn<FXModel, Object>("Measurement Quantity");
		measurementQuantityColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("measurementQuantity"));
		measurementQuantityColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(measurementQuantityColumn);

		final TableColumn<FXModel, Object> mrpColumn = new TableColumn<FXModel, Object>("MRP");
		mrpColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("mrp"));
		mrpColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(mrpColumn);
		
		
		final TableColumn<FXModel, Object> buyPriceColumn = new TableColumn<FXModel, Object>("Buy Price");
		buyPriceColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("buyPrice"));
		buyPriceColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(buyPriceColumn);

		final TableColumn<FXModel, Object> sellPriceColumn = new TableColumn<FXModel, Object>("Sell Price");
		sellPriceColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("sellPrice"));
		sellPriceColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(sellPriceColumn);
		
		final TableColumn<FXModel, Object> reorderFrequencyColumn = new TableColumn<FXModel, Object>("Reorder Frequency");
		reorderFrequencyColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("reorderFrequency"));
		reorderFrequencyColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(reorderFrequencyColumn);

		final TableColumn<FXModel, Object> reorderVolumeColumn = new TableColumn<FXModel, Object>("Reorder Volume");
		reorderVolumeColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("reorderVolume"));
		reorderVolumeColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(reorderVolumeColumn);

		EventHandler<TableColumn.CellEditEvent<FXModel,Object>> eventHandler = new EventHandler<TableColumn.CellEditEvent<FXModel,Object>>(){
		      @Override
		      public void handle(CellEditEvent<FXModel, Object> event) {
		    	  
		    	  FXProduct product = (FXProduct) event.getRowValue();
		    	  if (event.getTableColumn().equals(measurementCategoryColumn)){
		    		  product.setMeasurementCategory((String)event.getNewValue());
		    	  }
		    	  else if (event.getTableColumn().equals(measurementQuantityColumn)){
		    		  product.setMeasurementQuantity(new Integer(event.getNewValue().toString()));
		    	  }
		    	  else if (event.getTableColumn().equals(mrpColumn)){
		    		  product.setMrp(new Float(event.getNewValue().toString()));
		    	  }
		    	  else if (event.getTableColumn().equals(buyPriceColumn)){
		    		  product.setBuyPrice(new Float(event.getNewValue().toString()));
		    	  }
		    	  else if (event.getTableColumn().equals(sellPriceColumn)){
		    		  product.setSellPrice(new Float(event.getNewValue().toString()));
		    	  }
		    	  else if (event.getTableColumn().equals(reorderFrequencyColumn)){
		    		  product.setReorderFrequency(event.getNewValue().toString());
		    	  }
		    	  else if (event.getTableColumn().equals(reorderVolumeColumn)){
		    		  product.setReorderVolume(new Integer(event.getNewValue().toString()));
		    	  }
		    	  
		    	  ServiceController serviceController = new ServiceController();
		    	  serviceController.updateProduct((Product) product.toPOSModel());
		      }
		};
		measurementCategoryColumn.setOnEditCommit(eventHandler);
		measurementQuantityColumn.setOnEditCommit(eventHandler);
		mrpColumn.setOnEditCommit(eventHandler); 
		buyPriceColumn.setOnEditCommit(eventHandler); 
		sellPriceColumn.setOnEditCommit(eventHandler); 
		reorderFrequencyColumn.setOnEditCommit(eventHandler);
		reorderVolumeColumn.setOnEditCommit(eventHandler);
		
		return columns;
	}

	@Override
	public POSModel toPOSModel() {
		Product product = new Product(this.getId(), this.getProductMasterId(), this.getMeasurementCategory(), this.getMeasurementQuantity(), this.getMrp(), this.getSellPrice(), this.getBuyPrice(), this.getReorderVolume(), this.getReorderFrequency());
		return product;
	}
}
