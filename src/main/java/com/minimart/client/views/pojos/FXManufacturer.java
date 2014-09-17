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
import com.minimart.dto.ManufacturerDTO;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;

public class FXManufacturer extends FXModel {

	public FXManufacturer(ManufacturerDTO manufacturer) {
		this();

		this.setId(manufacturer.getId());
		this.setName(manufacturer.getName());
	}

	public FXManufacturer() {
		super();
		this.idProperty = new SimpleIntegerProperty();
		this.nameProperty = new SimpleStringProperty();
	}

	private SimpleIntegerProperty idProperty;

	private SimpleStringProperty nameProperty;

	public Integer getId() {
		return this.idProperty.get();
	}

	public String getName() {
		return this.nameProperty.get();
	}

	public void setId(Integer id) {
		this.idProperty.set(id);
	}

	public void setName(String name) {
		this.nameProperty.set(name);
	}

	@Override
	public String toString() {
		return "ManufacturerView [idProperty=" + idProperty + ", nameProperty="
				+ nameProperty + "]";
	}

	public List<TableColumn<FXModel, Object>> getColumnsList() {

		List<TableColumn<FXModel, Object>> columns = new ArrayList<TableColumn<FXModel, Object>>();

		// TableColumn<FXModel, Object> idColumn = new TableColumn<FXModel,
		// Object>("ID");
		// idColumn.setCellValueFactory(new PropertyValueFactory<FXModel,
		// Object>("id"));
		// idColumn.setCellFactory(FXCellFactory.getEditableCellFactory());
		//
		// columns.add(idColumn);

		final TableColumn<FXModel, Object> nameColumn = new TableColumn<FXModel, Object>(
				"Name");
		nameColumn
				.setCellValueFactory(new PropertyValueFactory<FXModel, Object>(
						"name"));
		nameColumn.setCellFactory(FXCellFactory.getEditableCell());

		EventHandler<TableColumn.CellEditEvent<FXModel, Object>> eventHandler = new EventHandler<TableColumn.CellEditEvent<FXModel, Object>>() {
			@Override
			public void handle(CellEditEvent<FXModel, Object> event) {

				System.out.println("In update ");
				FXManufacturer manufacturer = (FXManufacturer) event
						.getRowValue();
				if (event.getTableColumn().equals(nameColumn)) {
					manufacturer.setName((String) event.getNewValue());
				}
				System.out.println("Updated to " + manufacturer.toString());

				if (manufacturer.getId() != 0) {
					ServiceController serviceController = new ServiceController();
					serviceController.updateManufacturer((Manufacturer) manufacturer
									.toPOSModel());
				}
			}
		};

		nameColumn.setOnEditCommit(eventHandler);

		columns.add(nameColumn);

		return columns;
	}

	public POSModel toPOSModel() {
		Manufacturer manufacturer = new Manufacturer(this.getId(),
				this.getName());
		return manufacturer;
	}
}
