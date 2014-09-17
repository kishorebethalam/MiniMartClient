package com.minimart.client.Practice;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import com.minimart.client.views.FXTableView;
import com.minimart.client.views.pojos.FXBrand;
import com.minimart.client.views.pojos.FXCategory;
import com.minimart.client.views.pojos.FXInventoryItem;
import com.minimart.client.views.pojos.FXManufacturer;
import com.minimart.client.views.pojos.FXModel;
import com.minimart.client.views.pojos.FXProduct;
import com.minimart.client.views.pojos.FXProductMaster;
import com.minimart.dto.BrandDTO;
import com.minimart.dto.CategoryDTO;
import com.minimart.dto.InventoryItemDTO;
import com.minimart.dto.ManufacturerDTO;
import com.minimart.dto.ProductDTO;
import com.minimart.dto.ProductMasterDTO;
import com.minimart.model.POSModel;


public class Table extends Application {

	private ServiceController serviceController;
	private GridPane menuPane;
	private Pane contentPane;
	Button addButton;
	public Table() {
		serviceController = new ServiceController();
	}

	public void testTable(Stage primaryStage) {

		displayMainStage(primaryStage);
		

	}
	
	public void displayMainStage(Stage primaryStage){
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setWidth(bounds.getWidth() );
		primaryStage.setHeight(bounds.getHeight() );


		GridPane grid = new GridPane();
		grid.setHgap(25);
		grid.setVgap(25);
		grid.setAlignment(Pos.CENTER);

		Scene root = new Scene(grid, primaryStage.getWidth(), primaryStage.getHeight());
		primaryStage.setScene(root);
		primaryStage.show();

		menuPane = createMenuPane(root.getWidth() / 4 - 2 * grid.getHgap(), root.getHeight() - 2 * grid.getVgap() );
		grid.add(menuPane, 0, 0);
		

		GridPane mainContentPane = new GridPane();
		mainContentPane.setVgap(25);
		
		mainContentPane.setPrefSize(root.getWidth() * 3 / 4 - 2 * grid.getHgap(), root.getHeight() -  2 * grid.getVgap() );
		grid.add(mainContentPane, 1, 0);
		
		GridPane topMenuPane = new GridPane();
		topMenuPane.setHgap(25);
		topMenuPane.setAlignment(Pos.CENTER);
		
		addButton = new Button("Add");
		topMenuPane.add(addButton, 0, 0);
		
		
		addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	
            	if (addButton.getText().equalsIgnoreCase("Add")){
            		addNewRow();
            		
            	}
            	else {
            		saveNewRow();
            	}
            	
            }

			private void addNewRow() {
				FXTableView tableView = (FXTableView) contentPane.getChildren().get(0);
				Class<? extends FXModel> modelClass = tableView.getFxModalClass();
				FXModel object = null;
				try {
					object = modelClass.newInstance();
				} catch (InstantiationException | IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tableView.getItems().add(object);
				addButton.setText("Save");
			}
			private void saveNewRow() {
				FXTableView tableView = (FXTableView) contentPane.getChildren().get(0);
				FXModel lastItem = tableView.getItems().get(tableView.getItems().size() - 1);
				if (lastItem.toPOSModel().verifyRequiredFields()){
					ServiceController serviceController = new ServiceController();
					serviceController.add(lastItem.toPOSModel());
            		addButton.setText("Add");
				}
				else {
					System.out.println("Don't add as validation failed");
				}
			}
        });

		mainContentPane.add(addButton, 0, 0);
		
		contentPane = new Pane();
		contentPane.setPrefSize(root.getWidth() * 3 / 4 - 2 * grid.getHgap(), root.getHeight() -  2 * grid.getVgap() - 100 );
		mainContentPane.add(contentPane, 0, 1);

//		
		

		List<BrandDTO> brands = serviceController.getAllBrandDTOs();
		displayTableView(contentPane, FXBrand.class, BrandDTO.class, brands);
		
	}
	
	public GridPane createMenuPane(double width, double height){
		
		GridPane menuPane = new GridPane();
		menuPane.setHgap(25);
		menuPane.setVgap(25);
		menuPane.setPrefSize(width, height);
		
		Button brandButton = new Button();
		brandButton.setText("Brand");
		brandButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	List<BrandDTO> brands = serviceController.getAllBrandDTOs();
        		displayTableView(contentPane, FXBrand.class, BrandDTO.class, brands);
            }
        });
		
		menuPane.add(brandButton, 0, 0);
		
		Button manufacturerButton = new Button();
		manufacturerButton.setText("Manufacturer");
		manufacturerButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
        		List<ManufacturerDTO> manufacturers = serviceController.getAllManufacturerDTOs();
        		displayTableView(contentPane, FXManufacturer.class, ManufacturerDTO.class, manufacturers);
            }
        });
        
		menuPane.add(manufacturerButton, 0, 1);
		
		Button categoryButton = new Button();
		categoryButton.setText("Category");
		categoryButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
        		List<CategoryDTO> dataItems = serviceController.getAllCategoryDTOs();
        		displayTableView(contentPane, FXCategory.class, CategoryDTO.class, dataItems);
            }
        });
        
		menuPane.add(categoryButton, 0, 2);
		
		Button inventoryItemButton = new Button();
		inventoryItemButton.setText("Inventory Item");
		inventoryItemButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
        		List<InventoryItemDTO> dataItems = serviceController.getAllInventoryItemDTOs();
        		displayTableView(contentPane, FXInventoryItem.class, InventoryItemDTO.class, dataItems);
            }
        });
        
		menuPane.add(inventoryItemButton, 0, 3);
		
		Button productButton = new Button();
		productButton.setText("Product");
		productButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
        		List<ProductDTO> dataItems = serviceController.getAllProductDTOs();
        		displayTableView(contentPane, FXProduct.class, ProductDTO.class, dataItems);
            }
        });
        
		menuPane.add(productButton, 0, 4);
		
		Button productMasterButton = new Button();
		productMasterButton.setText("Product Master");
		productMasterButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
        		List<ProductMasterDTO> dataItems = serviceController.getAllProductMasterDTOs();
        		displayTableView(contentPane, FXProductMaster.class, ProductMasterDTO.class, dataItems);
            }
        });
        
		menuPane.add(productMasterButton, 0, 5);
		
		
		return menuPane;
	}
	public void displayTableView(Pane containerPane, Class<? extends FXModel> fxModalClass, Class<? extends POSModel> posModalClass, List<? extends POSModel> dataItems){
		
		FXTableView tableView = new FXTableView(fxModalClass, posModalClass);
		tableView.setPrefSize(containerPane.getPrefWidth(), containerPane.getPrefHeight());
        tableView.setEditable(true);
		
		containerPane.getChildren().clear();
		containerPane.getChildren().add(tableView);
		
		tableView.reloadTable(dataItems);		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		testTable(primaryStage);

	}

	public static void main(String args[]) {
		launch(args);
	}

}
