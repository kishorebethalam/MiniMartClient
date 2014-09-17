package com.minimart.client.views.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;

import com.minimart.client.Practice.ServiceController;
import com.minimart.client.views.cellfactories.FXCellFactory;
import com.minimart.dto.CategoryDTO;
import com.minimart.dto.InventoryItemDTO;
import com.minimart.model.InventoryItem;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;

public class FXInventoryItem extends FXModel {

	public FXInventoryItem(InventoryItemDTO inventoryItemDTO) {
		this();

		this.setId(inventoryItemDTO.getId());
		this.setProductId(inventoryItemDTO.getProductId());
		this.setTrackingCode(inventoryItemDTO.getTrackingCode());
		this.setQuantity(inventoryItemDTO.getQuantity());
		this.setReceivedDate(inventoryItemDTO.getReceivedDate());
		this.setExpiryDate(inventoryItemDTO.getExpiryDate());
		this.setPromotionalOffer(inventoryItemDTO.getPromotionalOffer());
		this.setProductName(inventoryItemDTO.getProductName());
		this.setMeasurementCategory(inventoryItemDTO.getMeasurementCategory());
		this.setMeasurementQuantity(inventoryItemDTO.getMeasurementQuantity());
	}

	public FXInventoryItem() {
		super();
		this.idProperty = new SimpleIntegerProperty();
		this.productIdProperty = new SimpleIntegerProperty();
		this.trackingCodeProperty = new SimpleStringProperty();
		this.quantityProperty = new SimpleIntegerProperty();
		this.receivedDateProperty = new SimpleObjectProperty<Date>();
		this.expiryDateProperty = new SimpleObjectProperty<Date>();
		this.promotionalOfferProperty = new SimpleStringProperty();
		this.productNameProperty = new SimpleStringProperty();
		this.measurementCategoryProperty = new SimpleStringProperty();
		this.measurementQuantityProperty = new SimpleIntegerProperty();
		;
	}

	
	
	private SimpleIntegerProperty idProperty;
	private SimpleIntegerProperty productIdProperty;
	private SimpleStringProperty trackingCodeProperty;
	private SimpleIntegerProperty quantityProperty;
	private SimpleObjectProperty<Date> receivedDateProperty;
	private SimpleObjectProperty<Date> expiryDateProperty;
	private SimpleStringProperty promotionalOfferProperty;
	private SimpleStringProperty productNameProperty;
	private SimpleStringProperty measurementCategoryProperty;
	private SimpleIntegerProperty measurementQuantityProperty;

	public Integer getId() {
		return this.idProperty.get();
	}

	public Integer getProductId() {
		return this.productIdProperty.get();
	}

	public String getTrackingCode() {
		return this.trackingCodeProperty.get();
	}
	
	public Integer getQuantity() {
		return this.quantityProperty.get();
	}
	public Date getReceivedDate() {
		return this.receivedDateProperty.get();
	}
	public Date getExpiryDate() {
		return this.expiryDateProperty.get();
	}
	public String getPromotionalOffer() {
		return this.promotionalOfferProperty.get();
	}
	public String getProductName() {
		return this.productNameProperty.get();
	}
	public String getMeasurementCategory() {
		return this.measurementCategoryProperty.get();
	}
	public Integer getMeasurementQuantity() {
		return this.measurementQuantityProperty.get();
	}
	public void setId(Integer id) {
		this.idProperty.set(id);
	}
	public void setProductId(Integer productId) {
		this.productIdProperty.set(productId);
	}
	
	public void setTrackingCode(String trackingCode) {
		this.trackingCodeProperty.set(trackingCode);
	}
	
	public void setQuantity(Integer quantity) {
		this.quantityProperty.set(quantity);
	}
	public void setReceivedDate(Date receivedDate) {
		this.receivedDateProperty.set(receivedDate);
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDateProperty.set(expiryDate);
	}
	public void setPromotionalOffer(String promotionalOffer) {
		this.promotionalOfferProperty.set(promotionalOffer);
	}
	public void setProductName(String productName) {
		this.productNameProperty.set(productName);
	}
	public void setMeasurementCategory(String measurementCategory) {
		this.measurementCategoryProperty.set(measurementCategory);
	}
	public void setMeasurementQuantity(Integer measurementQuantity) {
		this.measurementQuantityProperty.set(measurementQuantity);
	}

	

	

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FXInventoryItem [idProperty=" + idProperty
				+ ", productIdProperty=" + productIdProperty
				+ ", trackingCodeProperty=" + trackingCodeProperty
				+ ", quantityProperty=" + quantityProperty
				+ ", receivedDateProperty=" + receivedDateProperty
				+ ", expiryDateProperty=" + expiryDateProperty
				+ ", promotionalOfferProperty=" + promotionalOfferProperty
				+ ", productNameProperty=" + productNameProperty
				+ ", measurementCategoryProperty="
				+ measurementCategoryProperty
				+ ", measurementQuantityProperty="
				+ measurementQuantityProperty + "]";
	}

	public List<TableColumn<FXModel, Object>> getColumnsList() {
		
		List<TableColumn<FXModel, Object>> columns = new ArrayList<TableColumn<FXModel, Object>>();

//		TableColumn<FXModel, Object> idColumn = new TableColumn<FXModel, Object>("ID");
//		idColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("id"));
//		idColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(idColumn);
//
//		TableColumn<FXModel, Object> productIdColumn = new TableColumn<FXModel, Object>("ProductId");
//		productIdColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("productId"));
//		productIdColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
//
//		columns.add(productIdColumn);

		TableColumn<FXModel, Object> productNameColumn = new TableColumn<FXModel, Object>("Product");
		productNameColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("productName"));
		productNameColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(productNameColumn);

		TableColumn<FXModel, Object> measurementQuantityColumn = new TableColumn<FXModel, Object>("Measurement Quantity");
		measurementQuantityColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("measurementQuantity"));
		measurementQuantityColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(measurementQuantityColumn);
		
		TableColumn<FXModel, Object> measurementCategoryColumn = new TableColumn<FXModel, Object>("Measurement Type");
		measurementCategoryColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("measurementCategory"));
		measurementCategoryColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(measurementCategoryColumn);

		final TableColumn<FXModel, Object> quantityColumn = new TableColumn<FXModel, Object>("Quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("quantity"));
		quantityColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(quantityColumn);

		final TableColumn<FXModel, Object> trackingCodeColumn = new TableColumn<FXModel, Object>("Bar Code");
		trackingCodeColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("trackingCode"));
		trackingCodeColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(trackingCodeColumn);
		

		
		TableColumn<FXModel, Object> receivedDateColumn = new TableColumn<FXModel, Object>("Received Date");
		receivedDateColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("receivedDate"));
		receivedDateColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(receivedDateColumn);
		
		TableColumn<FXModel, Object> expiryDateColumn = new TableColumn<FXModel, Object>("Expiry Date");
		expiryDateColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("expiryDate"));
		expiryDateColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(expiryDateColumn);
		
		final TableColumn<FXModel, Object> promotionalOfferColumn = new TableColumn<FXModel, Object>("Offer");
		promotionalOfferColumn.setCellValueFactory(new PropertyValueFactory<FXModel, Object>("promotionalOffer"));
		promotionalOfferColumn.setCellFactory(FXCellFactory.getEditableCell());

		columns.add(promotionalOfferColumn);


		EventHandler<TableColumn.CellEditEvent<FXModel,Object>> eventHandler = new EventHandler<TableColumn.CellEditEvent<FXModel,Object>>(){
		      @Override
		      public void handle(CellEditEvent<FXModel, Object> event) {
		    	  
		    	  FXInventoryItem inventoryItem = (FXInventoryItem) event.getRowValue();
		    	  
		    	  if (event.getTableColumn().equals(quantityColumn)){
		    		  inventoryItem.setQuantity(new Integer(event.getNewValue().toString()));
		    	  }
		    	  else if (event.getTableColumn().equals(trackingCodeColumn)){
		    		  inventoryItem.setTrackingCode((String)event.getNewValue());
		    	  }
		    	  else if (event.getTableColumn().equals(promotionalOfferColumn)){
		    		  inventoryItem.setPromotionalOffer((String)event.getNewValue());
		    	  }
		    	  
		    	  
		    	  ServiceController serviceController = new ServiceController();
		    	  serviceController.updateInventoryItem((InventoryItem) inventoryItem.toPOSModel());
		      }
		};

		quantityColumn.setOnEditCommit(eventHandler);
		trackingCodeColumn.setOnEditCommit(eventHandler);
		promotionalOfferColumn.setOnEditCommit(eventHandler);
		
		return columns;
	}

	@Override
	public POSModel toPOSModel() {
		InventoryItem inventoryItem = new InventoryItem(this.getId(), this.getProductId(), this.getTrackingCode(), this.getQuantity(), this.getReceivedDate(), this.getExpiryDate(), this.getPromotionalOffer());
		return inventoryItem;
	}
}
