package com.minimart.client.views.pojos;

import java.lang.reflect.Constructor;

import com.minimart.model.POSModel;

public class MMBaseViewFactory {

	public MMBaseViewFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static FXModel creaetFromDataItem(Class<? extends FXModel> viewClass, Class<? extends POSModel> modelClass, POSModel model){
		
		try {
			
			FXModel baseView = null;
			
			if (viewClass != null) {
				Constructor<?> ctor = null;
				try {
					ctor = viewClass.getDeclaredConstructor(modelClass);
					ctor.setAccessible(true);
					baseView = viewClass.cast(ctor.newInstance(model));
					
				}catch (Exception exp){
					System.out.println("Caught an exception" + exp.getMessage());
					exp.printStackTrace();
				}
			}
			
			return baseView;

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
