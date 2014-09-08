package com.minimart.client.views.pojos;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.minimart.client.utils.ReflectionUtil;
import com.minimart.model.POSModel;

public class FXModel {

	public FXModel() {
		// TODO Auto-generated constructor stub
	}

	public static List<String> getFieldNames(Class<? extends FXModel> viewClass){
		
		List<String> fieldNames = new ArrayList<String>();
		
		List<Method> methods = ReflectionUtil.getDeclaredGetters(viewClass);
		for (Method method : methods) {
			String field = method.getName().replaceAll("get", "");
			field = field.substring(0, 1).toLowerCase() + field.substring(1);
			fieldNames.add(field);
		}
		return fieldNames;
	}
	
	public static ObservableList<FXModel> convertToFXModels(Class<? extends FXModel> viewClass, Class<? extends POSModel> modelClass, List<POSModel> dataItems){
		List<FXModel> views = new ArrayList<FXModel>();
		for (POSModel model : dataItems) {
			FXModel view = MMBaseViewFactory.creaetFromDataItem(viewClass, modelClass, model);
			views.add(view);
			System.out.println("view:" + view.toString());
		}
		return FXCollections.observableList(views);
	}
}
