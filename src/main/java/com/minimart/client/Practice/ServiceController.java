package com.minimart.client.Practice;

import java.util.List;

import com.minimart.client.views.pojos.FXBrand;
import com.minimart.client.views.pojos.FXCategory;
import com.minimart.client.views.pojos.FXModel;
import com.minimart.dto.BrandDTO;
import com.minimart.dto.CategoryDTO;
import com.minimart.dto.InventoryItemDTO;
import com.minimart.dto.ManufacturerDTO;
import com.minimart.dto.ProductDTO;
import com.minimart.dto.ProductMasterDTO;
import com.minimart.model.Brand;
import com.minimart.model.Category;
import com.minimart.model.InventoryItem;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;
import com.minimart.model.Product;
import com.minimart.model.ProductMaster;
import com.minimart.restclient.BrandRESTClient;
import com.minimart.restclient.CategoryRESTClient;
import com.minimart.restclient.InventoryItemRESTClient;
import com.minimart.restclient.ManufacturerRESTClient;
import com.minimart.restclient.ProductMasterRESTClient;
import com.minimart.restclient.ProductRESTClient;

public class ServiceController {

	private static String baseUrl = "http://localhost:8080";
	public ServiceController() {
		
	}

	public List<BrandDTO> getAllBrandDTOs(){
		
		BrandRESTClient restClient = new BrandRESTClient(baseUrl);
		List<BrandDTO> dataItems = restClient.getAllBrandDTOs();
		
		return dataItems;
	}

	public List<CategoryDTO> getAllCategoryDTOs(){

		CategoryRESTClient restClient = new CategoryRESTClient(baseUrl);
		List<CategoryDTO> dataItems = restClient.getAllCategoryDTOs();
		
		return dataItems;
	}
	
	public List<InventoryItemDTO> getAllInventoryItemDTOs(){

		InventoryItemRESTClient restClient = new InventoryItemRESTClient(baseUrl);
		List<InventoryItemDTO> dataItems = restClient.getAllInventoryItemDTOs();
		
		return dataItems;
	}
	public List<ManufacturerDTO> getAllManufacturerDTOs(){

		ManufacturerRESTClient restClient = new ManufacturerRESTClient(baseUrl);
		List<ManufacturerDTO> dataItems = restClient.getAllManufacturerDTOs();
		
		return dataItems;
	}

	public List<ProductDTO> getAllProductDTOs(){

		ProductRESTClient restClient = new ProductRESTClient(baseUrl);
		List<ProductDTO> dataItems = restClient.getAllProductDTOs();
		
		return dataItems;
	}
	
	public List<ProductMasterDTO> getAllProductMasterDTOs(){

		ProductMasterRESTClient restClient = new ProductMasterRESTClient(baseUrl);
		List<ProductMasterDTO> dataItems = restClient.getAllProductMasterDTOs();
		
		return dataItems;
	}
	
	public void updateBrand(Brand brand){
		BrandRESTClient restClient = new BrandRESTClient(baseUrl);
		restClient.updateBrand(brand);
	}
	public void updateCategory(Category category){
		CategoryRESTClient restClient = new CategoryRESTClient(baseUrl);
		restClient.updateCategory(category);
	}
	public void updateInventoryItem(InventoryItem data){
		InventoryItemRESTClient restClient = new InventoryItemRESTClient(baseUrl);
		restClient.updateInventoryItem(data);
	}
	public void updateManufacturer(Manufacturer manufacturer){
		ManufacturerRESTClient restClient = new ManufacturerRESTClient(baseUrl);
		restClient.updateManufacturer(manufacturer);
	}
	public void updateProduct(Product product){
		ProductRESTClient restClient = new ProductRESTClient(baseUrl);
		restClient.updateProduct(product);
	}
	public void updateProductMaster(ProductMaster productMaster){
		ProductMasterRESTClient restClient = new ProductMasterRESTClient(baseUrl);
		restClient.updateProductMaster(productMaster);
	}
	public void addBrand(Brand brand){
		BrandRESTClient restClient = new BrandRESTClient(baseUrl);
		restClient.addBrand(brand);
	}
	public void addCategory(Category category){
		CategoryRESTClient restClient = new CategoryRESTClient(baseUrl);
		restClient.addCategory(category);
	}
	public void addInventoryItem(InventoryItem data){
		InventoryItemRESTClient restClient = new InventoryItemRESTClient(baseUrl);
		restClient.addInventoryItem(data);
	}
	public void addManufacturer(Manufacturer manufacturer){
		ManufacturerRESTClient restClient = new ManufacturerRESTClient(baseUrl);
		restClient.addManufacturer(manufacturer);
	}
	public void addProduct(Product product){
		ProductRESTClient restClient = new ProductRESTClient(baseUrl);
		restClient.addProduct(product);
	}
	public void addProductMaster(ProductMaster productMaster){
		ProductMasterRESTClient restClient = new ProductMasterRESTClient(baseUrl);
		restClient.addProductMaster(productMaster);
	}

	public void deleteBrand(Brand brand){
		BrandRESTClient restClient = new BrandRESTClient(baseUrl);
		restClient.deleteBrand(brand);
	}
	public void deleteCategory(Category category){
		CategoryRESTClient restClient = new CategoryRESTClient(baseUrl);
		restClient.deleteCategory(category);
	}
	public void deleteInventoryItem(InventoryItem data){
		InventoryItemRESTClient restClient = new InventoryItemRESTClient(baseUrl);
		restClient.deleteInventoryItem(data);
	}
	public void deleteManufacturer(Manufacturer manufacturer){
		ManufacturerRESTClient restClient = new ManufacturerRESTClient(baseUrl);
		restClient.deleteManufacturer(manufacturer);
	}
	public void deleteProduct(Product product){
		ProductRESTClient restClient = new ProductRESTClient(baseUrl);
		restClient.deleteProduct(product);
	}
	public void deleteProductMaster(ProductMaster productMaster){
		ProductMasterRESTClient restClient = new ProductMasterRESTClient(baseUrl);
		restClient.deleteProductMaster(productMaster);
	}
	public void delete(POSModel record) {
		
		if (record instanceof Brand){
			deleteBrand((Brand)record);
		}
		else if (record instanceof Category){
			deleteCategory((Category)record);
		}
		else if (record instanceof InventoryItem){
			deleteInventoryItem((InventoryItem)record);
		}
		else if (record instanceof Manufacturer){
			deleteManufacturer((Manufacturer)record);
		}
		else if (record instanceof Product){
			deleteProduct((Product)record);
		}
		else if (record instanceof ProductMaster){
			deleteProductMaster((ProductMaster)record);
		}
		
	}

	public void add(POSModel record) {
		if (record instanceof Brand){
			addBrand((Brand)record);
		}
		else if (record instanceof Category){
			addCategory((Category)record);
		}
		else if (record instanceof InventoryItem){
			addInventoryItem((InventoryItem)record);
		}
		else if (record instanceof Manufacturer){
			addManufacturer((Manufacturer)record);
		}
		else if (record instanceof Product){
			addProduct((Product)record);
		}
		else if (record instanceof ProductMaster){
			addProductMaster((ProductMaster)record);
		}
	}
	
}

