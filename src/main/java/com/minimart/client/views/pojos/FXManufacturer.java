package com.minimart.client.views.pojos;

import com.minimart.model.Manufacturer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FXManufacturer extends FXModel{

	public FXManufacturer(Manufacturer manufacturer) {
		super();
		
		this.idProperty = new SimpleIntegerProperty();
		this.nameProperty = new SimpleStringProperty();
		
		this.setId(manufacturer.getId());
		this.setName(manufacturer.getName());
	}

	private SimpleIntegerProperty idProperty;
	
	private SimpleStringProperty nameProperty;
	
	public Integer getId(){
		return this.idProperty.get();
	}

	public String getName(){
		return this.nameProperty.get();
	}

	public void setId(Integer id){
		this.idProperty.set(id);
	}
	
	public void setName(String name){
		this.nameProperty.set(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManufacturerView [idProperty=" + idProperty + ", nameProperty="
				+ nameProperty + "]";
	}
}
