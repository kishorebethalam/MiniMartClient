package com.minimart.client.Practice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import com.minimart.client.restclient.BrandRESTClient;
import com.minimart.client.restclient.ManufacturerRESTClient;
import com.minimart.client.views.MMTableView;
import com.minimart.client.views.pojos.FXManufacturer;
import com.minimart.model.Brand;
import com.minimart.model.Manufacturer;


public class Table extends Application {

	public Table() {
		// TODO Auto-generated constructor stub
	}

	public void testTable(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
		grid.setPrefWidth(450);

		Scene root = new Scene(grid, 620, 320);

		primaryStage.setScene(root);
		primaryStage.show();

		MMTableView tableView = new MMTableView(FXManufacturer.class, Manufacturer.class);
		tableView.setPrefSize(root.getWidth(), root.getHeight());

//		List<POSModel> manufacturers = new ArrayList<POSModel>();
		ManufacturerRESTClient restClient = new ManufacturerRESTClient("http://localhost:8080");
		//List<Manufacturer> manufacturers = restClient.getAllManufacturers();
		
		BrandRESTClient brandClient = new BrandRESTClient("http://localhost:8080");
		Brand brand = brandClient.getBrand(1);
		System.out.println(brand.toString());
		
        tableView.setEditable(true);
//		tableView.reloadTable(manufacturers);
		
		grid.add(tableView, 0, 0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		testTable(primaryStage);

	}

	public static void main(String args[]) {
		launch(args);
	}

}
